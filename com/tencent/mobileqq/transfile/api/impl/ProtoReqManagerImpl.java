package com.tencent.mobileqq.transfile.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.proto.IProtoReqStrategy;
import com.tencent.mobileqq.transfile.ptt.PttProtoReqStrategy;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.CheckConErroObserver;
import mqq.util.WeakReference;

/* loaded from: classes19.dex */
public class ProtoReqManagerImpl implements DPCObserver, IProtoReqManager {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_RUNNABLE_INDEX = "key_runnable_index";
    public static final String TAG = "Q.richmedia.ProtoReqManager";

    @ConfigInject(configPath = "Foundation/Transfile/src/main/resources/Inject_InitProtoReqStrategyConfig.yml", version = 1)
    public static HashMap<String, Class<? extends IProtoReqStrategy>> protoReqStrategy;
    private AppInterface mApp;
    private Handler mHandler;
    private boolean mHasGetDPC;
    ConcurrentHashMap<Intent, ProtoResp> requests;

    /* loaded from: classes19.dex */
    public class CheckConErroObserverImp extends CheckConErroObserver {
        static IPatchRedirector $redirector_;
        ProtoReq mReq;
        ProtoResp mResp;

        public CheckConErroObserverImp(ProtoResp protoResp, ProtoReq protoReq) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ProtoReqManagerImpl.this, protoResp, protoReq);
            } else {
                this.mResp = protoResp;
                this.mReq = protoReq;
            }
        }

        @Override // mqq.observer.CheckConErroObserver, mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (bundle != null) {
                String string = bundle.getString("msf_con_erro");
                if (string == null) {
                    string = "";
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ProtoReqManagerImpl.TAG, 2, "CheckConErroObserverImp.onReceive -> msfConErro: " + string);
                }
                FromServiceMsg fromServiceMsg = this.mResp.resp;
                if (fromServiceMsg != null) {
                    fromServiceMsg.addAttribute(BaseConstants.Attribute_TAG_SOCKET_CONNERROR, string);
                }
            }
            ProtoReq protoReq = this.mReq;
            IProtoRespBack iProtoRespBack = protoReq.callback;
            if (iProtoRespBack != null) {
                iProtoRespBack.onProtoResp(this.mResp, protoReq);
            }
        }
    }

    /* loaded from: classes19.dex */
    public interface IProtoRespBack {
        void onProtoResp(ProtoResp protoResp, ProtoReq protoReq);
    }

    /* loaded from: classes19.dex */
    public static class ProtoReq {
        static IPatchRedirector $redirector_;
        public Object busiData;
        public IProtoRespBack callback;
        public int fixScheduleCount;
        public boolean isFastResendEnable;
        public boolean isNeedRemindSlowNetwork;
        public int noMsfSuggestRetryTime;
        public byte[] reqBody;
        ProtoResp resp;
        public String ssoCmd;
        public int timeSpace;
        public int tryCount;
        public int tryTime;

        public ProtoReq() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.tryTime = 480000;
            this.tryCount = 9;
            this.fixScheduleCount = 3;
            this.timeSpace = 25;
            this.noMsfSuggestRetryTime = RichMediaStrategy.NO_MSF_SUGGEST_RETRY;
            this.isFastResendEnable = true;
            this.isNeedRemindSlowNetwork = true;
        }

        public void setEasyRetryMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.tryTime = 30000;
            this.tryCount = 1;
            this.fixScheduleCount = 1;
        }
    }

    /* loaded from: classes19.dex */
    public static class ProtoReqRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        boolean activated;
        long finishTime;
        boolean finished;
        NewIntent intent;
        WeakReference<ProtoReqManagerImpl> manager;
        ProtoResp resp;
        boolean scheduled;
        long startTime;
        long timeOut;

        public ProtoReqRunnable(ProtoReqManagerImpl protoReqManagerImpl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) protoReqManagerImpl);
                return;
            }
            this.activated = false;
            this.finished = false;
            this.scheduled = false;
            this.manager = new WeakReference<>(protoReqManagerImpl);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d(ProtoReqManagerImpl.TAG, 2, "ProtoReqRunnable.run() : resp.startTime" + this.resp.startTime);
            this.activated = true;
            this.startTime = System.currentTimeMillis();
            this.intent.putExtra(ProtoServlet.KEY_TIMEOUT, this.timeOut);
            this.resp.statisInfo.retryCount++;
            WeakReference<ProtoReqManagerImpl> weakReference = this.manager;
            if (weakReference != null && weakReference.get() != null) {
                ProtoReqManagerImpl protoReqManagerImpl = this.manager.get();
                protoReqManagerImpl.requests.put(this.intent, this.resp);
                protoReqManagerImpl.sendToMsf(this.intent);
            }
        }
    }

    /* loaded from: classes19.dex */
    public static class ProtoResp {
        static IPatchRedirector $redirector_;
        public int freeRunnalbleIndex;
        boolean processed;
        public ProtoReq req;
        public FromServiceMsg resp;
        public ProtoReqRunnable[] runs;
        public long startTime;
        public StatictisInfo statisInfo;

        public ProtoResp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.statisInfo = new StatictisInfo();
                this.processed = false;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38752);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        HashMap<String, Class<? extends IProtoReqStrategy>> hashMap = new HashMap<>();
        protoReqStrategy = hashMap;
        hashMap.put(RichMediaConstants.CMD_TEMP_PTT_DOWNLOAD, PttProtoReqStrategy.class);
        protoReqStrategy.put(RichMediaConstants.CMD_TEMP_PTT_UPLOAD, PttProtoReqStrategy.class);
        protoReqStrategy.put(RichMediaConstants.CMD_LONGCONN_GROUPPTT_DOWN, PttProtoReqStrategy.class);
        protoReqStrategy.put(RichMediaConstants.CMD_LONGCONN_GROUPPTT_UP, PttProtoReqStrategy.class);
    }

    public ProtoReqManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.requests = new ConcurrentHashMap<>();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mHasGetDPC = false;
    }

    private void getDPC() {
        if (((IDPCApi) QRoute.api(IDPCApi.class)).getServerDataCurrentState() == 4) {
            RichMediaStrategy.updataFromDpc(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.RichProReqCfg.name()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0016, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isAllTryFinished(ProtoResp protoResp) {
        int i3 = 0;
        while (true) {
            ProtoReqRunnable[] protoReqRunnableArr = protoResp.runs;
            if (i3 >= protoReqRunnableArr.length) {
                return true;
            }
            ProtoReqRunnable protoReqRunnable = protoReqRunnableArr[i3];
            if (protoReqRunnable.finished || (!protoReqRunnable.activated && !protoReqRunnable.scheduled)) {
                i3++;
            }
        }
    }

    private void recordRunnableBack(Intent intent, ProtoResp protoResp) {
        ProtoReqRunnable protoReqRunnable = protoResp.runs[intent.getIntExtra(KEY_RUNNABLE_INDEX, 0)];
        protoReqRunnable.finished = true;
        protoReqRunnable.finishTime = System.currentTimeMillis();
    }

    private void setConfigFromDpc(ProtoReq protoReq) {
        protoReq.tryTime = RichMediaStrategy.getTryTime_dpc();
        protoReq.tryCount = RichMediaStrategy.getTryCount_dpc();
        protoReq.fixScheduleCount = RichMediaStrategy.getFixSchedulTryCount_dpc();
    }

    private void stopAllRunnables(ProtoResp protoResp) {
        protoResp.processed = true;
        int i3 = 0;
        while (true) {
            ProtoReqRunnable[] protoReqRunnableArr = protoResp.runs;
            if (i3 < protoReqRunnableArr.length) {
                this.requests.remove(protoReqRunnableArr[i3].intent);
                this.mHandler.removeCallbacks(protoResp.runs[i3]);
                i3++;
            } else {
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.api.IProtoReqManager
    public synchronized void cancelReq(ProtoReq protoReq) {
        ProtoResp protoResp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) protoReq);
            return;
        }
        if (protoReq != null && (protoResp = protoReq.resp) != null) {
            stopAllRunnables(protoResp);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = (AppInterface) appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onDestroy ");
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mApp = null;
    }

    @Override // com.tencent.mobileqq.dpc.DPCObserver
    public void onDpcPullFinished(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (z16) {
            RichMediaStrategy.updataFromDpc(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.RichProReqCfg.name()));
        }
        ((IDPCApi) QRoute.api(IDPCApi.class)).removeObserver(this);
    }

    @Override // com.tencent.mobileqq.transfile.api.IProtoReqManager
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ProtoResp protoResp;
        ProtoReq protoReq;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        synchronized (this) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onReceive." + fromServiceMsg);
            }
            IProtoRespBack iProtoRespBack = null;
            if (intent != null && fromServiceMsg != null) {
                protoResp = this.requests.get(intent);
                if (protoResp != null && !protoResp.processed) {
                    recordRunnableBack(intent, protoResp);
                    protoReq = protoResp.req;
                    protoResp.resp = fromServiceMsg;
                    protoResp.statisInfo.errCode = fromServiceMsg.getResultCode();
                    int resultCode = fromServiceMsg.getResultCode();
                    if (resultCode == 1000) {
                        stopAllRunnables(protoResp);
                        this.requests.remove(intent);
                        if (protoReq.callback != null) {
                            int length = fromServiceMsg.getWupBuffer().length - 4;
                            byte[] bArr = new byte[length];
                            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
                            fromServiceMsg.putWupBuffer(bArr);
                            iProtoRespBack = protoReq.callback;
                        }
                    } else {
                        if (resultCode == 2901) {
                            long currentTimeMillis = System.currentTimeMillis() - protoResp.startTime;
                            if (currentTimeMillis < protoReq.noMsfSuggestRetryTime && (i3 = protoResp.freeRunnalbleIndex) < protoReq.tryCount) {
                                ProtoReqRunnable protoReqRunnable = protoResp.runs[i3];
                                protoResp.freeRunnalbleIndex = i3 + 1;
                                protoReqRunnable.timeOut = (protoReq.tryTime - currentTimeMillis) - 5000;
                                scheduleRunnable(protoReqRunnable, 0L);
                            } else if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "onReceive found 2901 but do not retry : elapse:" + currentTimeMillis + " index:" + protoResp.freeRunnalbleIndex);
                            }
                        }
                        if (isAllTryFinished(protoResp)) {
                            stopAllRunnables(protoResp);
                            this.requests.remove(intent);
                            if (resultCode == 1013) {
                                AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                                if (appInterface == null) {
                                    return;
                                }
                                NewIntent newIntent = new NewIntent(appInterface.getApplication(), BuiltInServlet.class);
                                newIntent.setObserver(new CheckConErroObserverImp(protoResp, protoReq));
                                newIntent.putExtra("action", 2201);
                                appInterface.startServlet(newIntent);
                            } else {
                                IProtoRespBack iProtoRespBack2 = protoReq.callback;
                                if (iProtoRespBack2 != null) {
                                    iProtoRespBack = iProtoRespBack2;
                                }
                            }
                        }
                    }
                }
                protoReq = null;
            } else {
                protoResp = null;
                protoReq = null;
            }
            if (iProtoRespBack != null) {
                iProtoRespBack.onProtoResp(protoResp, protoReq);
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.api.IProtoReqManager
    public void scheduleRunnable(ProtoReqRunnable protoReqRunnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, protoReqRunnable, Long.valueOf(j3));
        } else {
            protoReqRunnable.scheduled = true;
            this.mHandler.postDelayed(protoReqRunnable, j3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0090 A[Catch: all -> 0x012a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0006, B:7:0x000c, B:11:0x0011, B:13:0x0015, B:14:0x001b, B:19:0x0029, B:21:0x002f, B:22:0x0049, B:24:0x004d, B:26:0x0056, B:28:0x0061, B:30:0x006c, B:31:0x006f, B:33:0x0073, B:36:0x007d, B:38:0x0090, B:39:0x0093, B:40:0x00c1, B:42:0x00c5, B:44:0x0103, B:46:0x0106, B:49:0x0109, B:51:0x010d, B:53:0x0126, B:58:0x0085, B:56:0x008a), top: B:2:0x0001, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c5 A[Catch: all -> 0x012a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0006, B:7:0x000c, B:11:0x0011, B:13:0x0015, B:14:0x001b, B:19:0x0029, B:21:0x002f, B:22:0x0049, B:24:0x004d, B:26:0x0056, B:28:0x0061, B:30:0x006c, B:31:0x006f, B:33:0x0073, B:36:0x007d, B:38:0x0090, B:39:0x0093, B:40:0x00c1, B:42:0x00c5, B:44:0x0103, B:46:0x0106, B:49:0x0109, B:51:0x010d, B:53:0x0126, B:58:0x0085, B:56:0x008a), top: B:2:0x0001, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010d A[Catch: all -> 0x012a, LOOP:1: B:49:0x0109->B:51:0x010d, LOOP_END, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0006, B:7:0x000c, B:11:0x0011, B:13:0x0015, B:14:0x001b, B:19:0x0029, B:21:0x002f, B:22:0x0049, B:24:0x004d, B:26:0x0056, B:28:0x0061, B:30:0x006c, B:31:0x006f, B:33:0x0073, B:36:0x007d, B:38:0x0090, B:39:0x0093, B:40:0x00c1, B:42:0x00c5, B:44:0x0103, B:46:0x0106, B:49:0x0109, B:51:0x010d, B:53:0x0126, B:58:0x0085, B:56:0x008a), top: B:2:0x0001, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0126 A[EDGE_INSN: B:52:0x0126->B:53:0x0126 BREAK  A[LOOP:1: B:49:0x0109->B:51:0x010d], SYNTHETIC] */
    @Override // com.tencent.mobileqq.transfile.api.IProtoReqManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void sendProtoReq(ProtoReq protoReq) {
        IProtoReqStrategy iProtoReqStrategy;
        ProtoResp protoResp;
        int i3;
        int i16;
        int i17;
        Class<? extends IProtoReqStrategy> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) protoReq);
            return;
        }
        if (!this.mHasGetDPC) {
            getDPC();
            this.mHasGetDPC = true;
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface == null) {
            return;
        }
        if (protoReq != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "req:" + protoReq.ssoCmd);
            }
            String str = protoReq.ssoCmd;
            if (str != null && (str.equals("ImgStore.GroupPicUp") || protoReq.ssoCmd.equals("LongConn.OffPicUp") || protoReq.ssoCmd.equals(RichMediaConstants.CMD_LONGCONN_GUILDPIC_UP))) {
                setConfigFromDpc(protoReq);
            }
            String str2 = protoReq.ssoCmd;
            if (str2 != null && (cls = protoReqStrategy.get(str2)) != null) {
                try {
                    iProtoReqStrategy = cls.newInstance();
                } catch (IllegalAccessException e16) {
                    e16.printStackTrace();
                } catch (InstantiationException e17) {
                    e17.printStackTrace();
                }
                if (iProtoReqStrategy != null) {
                    iProtoReqStrategy.updateReq(protoReq);
                }
                protoResp = new ProtoResp();
                protoReq.resp = protoResp;
                protoResp.req = protoReq;
                protoResp.startTime = System.currentTimeMillis();
                protoResp.runs = new ProtoReqRunnable[protoReq.tryCount];
                byte[] bArr = protoReq.reqBody;
                ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 4);
                allocate.putInt(bArr.length + 4).put(bArr);
                byte[] array = allocate.array();
                i3 = 0;
                for (i16 = 0; i16 < protoReq.tryCount; i16++) {
                    ProtoReqRunnable protoReqRunnable = new ProtoReqRunnable(this);
                    protoResp.runs[i16] = protoReqRunnable;
                    protoReqRunnable.resp = protoResp;
                    NewIntent newIntent = new NewIntent(appInterface.getApp(), ProtoServlet.class);
                    protoReqRunnable.intent = newIntent;
                    newIntent.putExtra(ProtoServlet.KEY_BODY, array);
                    newIntent.putExtra("key_cmd", protoReq.ssoCmd);
                    newIntent.putExtra(KEY_RUNNABLE_INDEX, i16);
                    newIntent.putExtra(ProtoServlet.KEY_FAST_RESEND_ENABLE, protoReq.isFastResendEnable);
                    newIntent.putExtra(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, protoReq.isNeedRemindSlowNetwork);
                    if (iProtoReqStrategy != null) {
                        iProtoReqStrategy.updateIntent(newIntent);
                    }
                }
                while (true) {
                    i17 = protoReq.fixScheduleCount;
                    if (i3 < i17) {
                        break;
                    }
                    int i18 = protoReq.tryTime;
                    long j3 = (i3 * i18) / i17;
                    ProtoReqRunnable protoReqRunnable2 = protoResp.runs[i3];
                    protoReqRunnable2.timeOut = (i18 - j3) - (protoReq.timeSpace * i3);
                    scheduleRunnable(protoReqRunnable2, j3);
                    i3++;
                }
                protoResp.freeRunnalbleIndex = i17;
            }
            iProtoReqStrategy = null;
            if (iProtoReqStrategy != null) {
            }
            protoResp = new ProtoResp();
            protoReq.resp = protoResp;
            protoResp.req = protoReq;
            protoResp.startTime = System.currentTimeMillis();
            protoResp.runs = new ProtoReqRunnable[protoReq.tryCount];
            byte[] bArr2 = protoReq.reqBody;
            ByteBuffer allocate2 = ByteBuffer.allocate(bArr2.length + 4);
            allocate2.putInt(bArr2.length + 4).put(bArr2);
            byte[] array2 = allocate2.array();
            i3 = 0;
            while (i16 < protoReq.tryCount) {
            }
            while (true) {
                i17 = protoReq.fixScheduleCount;
                if (i3 < i17) {
                }
                int i182 = protoReq.tryTime;
                long j36 = (i3 * i182) / i17;
                ProtoReqRunnable protoReqRunnable22 = protoResp.runs[i3];
                protoReqRunnable22.timeOut = (i182 - j36) - (protoReq.timeSpace * i3);
                scheduleRunnable(protoReqRunnable22, j36);
                i3++;
            }
            protoResp.freeRunnalbleIndex = i17;
        }
    }

    void sendToMsf(NewIntent newIntent) {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface != null) {
            appInterface.startServlet(newIntent);
        }
    }
}
