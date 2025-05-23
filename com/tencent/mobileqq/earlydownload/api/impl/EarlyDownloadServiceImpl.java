package com.tencent.mobileqq.earlydownload.api.impl;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.util.QQFaceFileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.GetResourceRespInfo;
import protocol.KQQConfig.GetResourceRespInfoV2;
import protocol.KQQConfig.GetResourceRespV2;
import protocol.KQQConfig.ReqUserInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EarlyDownloadServiceImpl implements IEarlyDownloadService, Handler.Callback, INetEngineListener, HttpEngineTask.IHttpEngineTask {
    static IPatchRedirector $redirector_ = null;
    static final int ACTION_DOWNLOAD_ON_CANCEL = 131329;
    static final int ACTION_DOWNLOAD_ON_RESP = 131328;
    static final int ACTION_NET_CHANGED = 131330;
    static final int ACTION_ON_BROADCAST_REQ = 131333;
    static final int ACTION_ON_GET_CONFIG_RESP = 131331;
    static final int ACTION_ON_SERVER_RESP = 131332;
    public static int DELAY_TIME = 0;
    static final int MAX_REQ_DOWNLOAD_COUNT = 3;
    private static final String TAG = "EarlyDown.EarlyDownloadServiceImpl";
    private static String currentUin;
    public static final Lock lock;
    private static final ArrayList<Integer> sForbiddenBusinesses;
    private boolean afterAppStart;
    private ArrayList<com.tencent.mobileqq.earlydownload.inject.a> mBaseEarlyHandlerProcessorArrayList;
    private HashMap<String, b> mDownloadRecords;
    private Handler mEarlyHandler;
    private com.tencent.mobileqq.earlydownload.inject.b mEarlyHandlerProcessorFactory;
    private HashMap<String, HttpEngineTask> mPendingDownloadRecords;
    private IPreDownloadController mPreDownloadCtrl;
    public final HashSet<String> mRequestSet;
    private ServerConfigObserver mServerConfigObserver;
    private HashMap<String, com.tencent.mobileqq.earlydownload.handler.b> mapHandler;
    public Boolean pluginConfigGetSucc;
    private long timeUpdateSuccess;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends ServerConfigObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EarlyDownloadServiceImpl.this);
            }
        }

        @Override // mqq.observer.ServerConfigObserver
        public void onGetPluginConfig(boolean z16, int i3, GetResourceRespV2 getResourceRespV2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), getResourceRespV2);
            } else {
                super.onGetPluginConfig(z16, i3, getResourceRespV2);
                EarlyDownloadServiceImpl.this.handleOnGetPluginConfig(z16, i3, getResourceRespV2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        HttpNetReq f203910a;

        /* renamed from: b, reason: collision with root package name */
        AbsPreDownloadTask f203911b;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19676);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        DELAY_TIME = 60000;
        lock = new ReentrantLock();
        sForbiddenBusinesses = new ArrayList<Integer>() { // from class: com.tencent.mobileqq.earlydownload.api.impl.EarlyDownloadServiceImpl.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                add(10092);
                add(10093);
                add(10024);
                add(10040);
                add(10083);
                add(10084);
                add(10085);
                add(10090);
                add(10061);
            }
        };
    }

    public EarlyDownloadServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mEarlyHandlerProcessorFactory = new com.tencent.mobileqq.earlydownload.inject.b();
        this.mServerConfigObserver = new a();
        this.afterAppStart = false;
        this.mapHandler = new HashMap<>();
        this.mDownloadRecords = new HashMap<>();
        this.mPendingDownloadRecords = new HashMap<>();
        this.mRequestSet = new HashSet<>();
    }

    private com.tencent.mobileqq.earlydownload.handler.b createHandler(String str, AppRuntime appRuntime) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "createHandler pkgName=" + str);
        }
        com.tencent.mobileqq.earlydownload.handler.b bVar = null;
        if (str != null && str.length() != 0) {
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                return null;
            }
            ArrayList<com.tencent.mobileqq.earlydownload.inject.a> arrayList = this.mBaseEarlyHandlerProcessorArrayList;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<com.tencent.mobileqq.earlydownload.inject.a> it = this.mBaseEarlyHandlerProcessorArrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.mobileqq.earlydownload.inject.a next = it.next();
                    if (next != null && TextUtils.equals(next.b(), str)) {
                        bVar = next.a(MobileQQ.sMobileQQ.peekAppRuntime());
                        break;
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "createHandler(), mBaseEarlyHandlerProcessorArrayList is null !!!" + str);
            }
            if (bVar == null) {
                QLog.e(TAG, 1, "createHandler() can't find Handler for:" + str);
            }
        }
        return bVar;
    }

    private void doBroadcastReq(Intent intent) {
        String stringExtra = intent.getStringExtra("strResName");
        String action = intent.getAction();
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "handleBroadcastReq() resName=" + stringExtra + " action=" + action);
        }
        com.tencent.mobileqq.earlydownload.handler.b earlyHandler = getEarlyHandler(stringExtra);
        if (earlyHandler == null) {
            if (TextUtils.isEmpty(intent.getAction())) {
                QLog.e("EarlyDown", 2, "handleBroadcastReq() action is null");
                return;
            }
            Intent intent2 = new Intent(intent.getAction().replace("req.", "resp."));
            intent2.putExtra("strResName", intent.getStringExtra("strResName"));
            intent2.putExtra("strPkgName", intent.getStringExtra("strPkgName"));
            intent2.putExtra("reqResult", false);
            intent2.putExtra("resultReason", "resName:" + stringExtra + " is not valid.");
            MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(intent2, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
            return;
        }
        XmlData o16 = earlyHandler.o();
        if ("req.com.tencent.mobileqq.EARLY_DOWNLOAD".equals(action)) {
            if (o16.loadState == 1) {
                Intent intent3 = new Intent("resp.com.tencent.mobileqq.EARLY_DOWNLOAD");
                intent3.putExtra("reqResult", false);
                intent3.putExtra("strResName", stringExtra);
                intent3.putExtra("strPkgName", o16.strPkgName);
                intent3.putExtra("loadState", 1);
                intent3.putExtra("resultReason", "resource has been success.");
                MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(intent3, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
                return;
            }
            earlyHandler.K(true);
            earlyHandler.I(intent.getBooleanExtra(IAELaunchRecorder.MILESTONE_CLICK, false));
            return;
        }
        if ("req.com.tencent.mobileqq.EARLY_QUERY".equals(action)) {
            Intent intent4 = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
            intent4.putExtra("strResName", stringExtra);
            intent4.putExtra("strPkgName", o16.strPkgName);
            intent4.putExtra("reqResult", true);
            intent4.putExtra("loadState", o16.loadState);
            intent4.putExtra("totalSize", o16.totalSize);
            intent4.putExtra("downSize", o16.downSize);
            MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(intent4, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
            return;
        }
        if ("req.com.tencent.mobileqq.EARLY_CANCEL".equals(action)) {
            earlyHandler.K(true);
            cancelDownload(earlyHandler.o());
            return;
        }
        if ("req.com.tencent.mobileqq.EARLY_SET_FAIL".equals(action)) {
            earlyHandler.J(false);
            Intent intent5 = new Intent("resp.com.tencent.mobileqq.EARLY_SET_FAIL");
            intent5.putExtra("strResName", stringExtra);
            intent5.putExtra("strPkgName", o16.strPkgName);
            intent5.putExtra("reqResult", true);
            intent5.putExtra("loadState", o16.loadState);
            MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(intent5, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
            if (intent.getBooleanExtra("restartDownload", false)) {
                earlyHandler.K(true);
                earlyHandler.I(intent.getBooleanExtra(IAELaunchRecorder.MILESTONE_CLICK, false));
            }
        }
    }

    private void doOnCancelDownload(XmlData xmlData) {
        Object obj;
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "doOnCancelDownload() name=" + xmlData.strResName + ",strResURL_big=" + xmlData.strResURL_big + ",strResURL_small=" + xmlData.strResURL_small + ",localVer=" + xmlData.Version);
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return;
        }
        Lock lock2 = lock;
        lock2.lock();
        try {
            b remove = this.mDownloadRecords.remove(xmlData.strResName);
            HttpEngineTask remove2 = this.mPendingDownloadRecords.remove(xmlData.strResName);
            lock2.unlock();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("doOnCancelDownload(), netReq = ");
                if (remove != null) {
                    obj = remove.f203910a;
                } else {
                    obj = "";
                }
                sb5.append(obj);
                sb5.append(", pendingNetReq = ");
                sb5.append(remove2);
                QLog.d(TAG, 2, sb5.toString());
            }
            com.tencent.mobileqq.earlydownload.handler.b earlyHandler = getEarlyHandler(xmlData.strResName);
            if (remove == null && remove2 == null) {
                if (earlyHandler != null && earlyHandler.x()) {
                    Intent intent = new Intent("resp.com.tencent.mobileqq.EARLY_CANCEL");
                    intent.putExtra("reqResult", false);
                    intent.putExtra("resultReason", "resName=" + xmlData.strResName + " is not loading..");
                    intent.putExtra("strResName", xmlData.strResName);
                    intent.putExtra("strPkgName", xmlData.strPkgName);
                    MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(intent, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
                    earlyHandler.K(false);
                    return;
                }
                return;
            }
            if (remove != null) {
                if (remove.f203911b != null) {
                    this.mPreDownloadCtrl.cancelPreDownload(xmlData.strResURL_big);
                } else {
                    ((IHttpEngineService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IHttpEngineService.class, "all")).cancelReq(remove.f203910a);
                }
            }
            if (remove2 != null) {
                this.mPreDownloadCtrl.cancelPreDownload(xmlData.strResURL_big);
            }
            xmlData.tStart = 0L;
            xmlData.hasResDownloaded = false;
            xmlData.loadState = 0;
            com.tencent.mobileqq.earlydownload.a.f(xmlData, "loadState", "hasResDownloaded", "tStart");
            if (earlyHandler != null) {
                earlyHandler.F(xmlData);
            }
        } catch (Throwable th5) {
            lock.unlock();
            throw th5;
        }
    }

    private void doOnGetConfig(GetResourceRespV2 getResourceRespV2) {
        Iterator<GetResourceRespInfoV2> it;
        int i3;
        Iterator<GetResourceRespInfoV2> it5;
        if (getResourceRespV2 == null) {
            return;
        }
        ArrayList<GetResourceRespInfoV2> arrayList = getResourceRespV2.vecDeletedResInfo;
        if (arrayList != null) {
            Iterator<GetResourceRespInfoV2> it6 = arrayList.iterator();
            while (it6.hasNext()) {
                GetResourceRespInfoV2 next = it6.next();
                if (next != null) {
                    String str = next.strResName;
                    com.tencent.mobileqq.earlydownload.handler.b bVar = this.mapHandler.get(str);
                    if (bVar != null) {
                        bVar.l();
                    }
                    removeHandler(str);
                    if (QLog.isColorLevel()) {
                        QLog.d("EarlyDown", 2, "doOnGetConfig() removeRes, strPkgName=" + next.strPkgName);
                    }
                }
            }
        }
        ArrayList<GetResourceRespInfoV2> arrayList2 = getResourceRespV2.vecAddedResInfo;
        int i16 = 512;
        if (arrayList2 != null) {
            Iterator<GetResourceRespInfoV2> it7 = arrayList2.iterator();
            while (it7.hasNext()) {
                GetResourceRespInfoV2 next2 = it7.next();
                if (next2 != null && next2.iPluginType == i16) {
                    String str2 = next2.strResName;
                    com.tencent.mobileqq.earlydownload.handler.b earlyHandler = getEarlyHandler(str2);
                    if (earlyHandler != null) {
                        it5 = it7;
                        XmlData d16 = com.tencent.mobileqq.earlydownload.a.d(earlyHandler.p(), next2.strResName, next2.strPkgName, next2.strResConf, next2.uiNewVer, next2.strResURL_big, next2.strResURL_small);
                        if (!TextUtils.equals(next2.strPkgName, earlyHandler.o().strPkgName)) {
                            QLog.e(TAG, 1, "doOnGetConfig() pkgName mismatch! resp:" + next2.strPkgName + " vs local:" + earlyHandler.o().strPkgName);
                        }
                        earlyHandler.o().updateServerInfo(d16);
                        com.tencent.mobileqq.earlydownload.a.f(earlyHandler.o(), new String[0]);
                        Message obtain = Message.obtain();
                        if (obtain == null) {
                            obtain = new Message();
                        }
                        obtain.what = ACTION_ON_SERVER_RESP;
                        obtain.obj = new Object[]{str2, d16};
                        if (str2.equals(this.mEarlyHandlerProcessorFactory.a())) {
                            DELAY_TIME = 0;
                        } else {
                            DELAY_TIME = 60000;
                        }
                        Handler handler = this.mEarlyHandler;
                        if (handler != null) {
                            handler.sendMessageDelayed(obtain, DELAY_TIME);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("EarlyDown", 2, "doOnGetConfig() Added resName=" + str2 + " data=" + d16 + " updateServerInfo done, doOnServerResp after " + DELAY_TIME + "ms");
                        }
                    } else {
                        it5 = it7;
                    }
                    it7 = it5;
                    i16 = 512;
                }
            }
        }
        ArrayList<GetResourceRespInfoV2> arrayList3 = getResourceRespV2.vecUpdatedResInfo;
        if (arrayList3 != null) {
            Iterator<GetResourceRespInfoV2> it8 = arrayList3.iterator();
            while (it8.hasNext()) {
                GetResourceRespInfoV2 next3 = it8.next();
                if (next3 != null && next3.iPluginType == 512) {
                    String str3 = next3.strResName;
                    com.tencent.mobileqq.earlydownload.handler.b earlyHandler2 = getEarlyHandler(str3);
                    if (earlyHandler2 != null) {
                        int i17 = earlyHandler2.o().Version;
                        it = it8;
                        XmlData d17 = com.tencent.mobileqq.earlydownload.a.d(earlyHandler2.p(), next3.strResName, next3.strPkgName, next3.strResConf, next3.uiNewVer, next3.strResURL_big, next3.strResURL_small);
                        earlyHandler2.o().updateServerInfo(d17);
                        if (i17 < next3.uiNewVer) {
                            i3 = 0;
                            earlyHandler2.o().loadState = 0;
                        } else {
                            i3 = 0;
                        }
                        com.tencent.mobileqq.earlydownload.a.f(earlyHandler2.o(), new String[i3]);
                        Message obtain2 = Message.obtain();
                        if (obtain2 == null) {
                            obtain2 = new Message();
                        }
                        obtain2.what = ACTION_ON_SERVER_RESP;
                        Object[] objArr = new Object[2];
                        objArr[i3] = str3;
                        objArr[1] = d17;
                        obtain2.obj = objArr;
                        if (str3.equals(this.mEarlyHandlerProcessorFactory.a())) {
                            DELAY_TIME = i3;
                        } else {
                            DELAY_TIME = 60000;
                        }
                        Handler handler2 = this.mEarlyHandler;
                        if (handler2 != null) {
                            handler2.sendMessageDelayed(obtain2, DELAY_TIME);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("EarlyDown", 2, "doOnGetConfig() Updated resName=" + str3 + " data=" + d17 + " updateServerInfo done, doOnServerResp after " + DELAY_TIME + "ms");
                        }
                    } else {
                        it = it8;
                    }
                    it8 = it;
                }
            }
        }
    }

    private void doOnResp(NetResp netResp) {
        boolean z16;
        long j3;
        HttpNetReq httpNetReq;
        HttpNetReq httpNetReq2;
        String t16;
        String str;
        StringBuffer stringBuffer;
        XmlData xmlData = (XmlData) netResp.mReq.getUserData();
        if (xmlData == null) {
            return;
        }
        if (netResp.mResult == 3) {
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "doOnResp() resName=" + xmlData.strResName + " is downloading...");
                return;
            }
            return;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return;
        }
        if (netResp.mResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - xmlData.tStart;
        try {
            j3 = new File(netResp.mReq.mOutPath).length();
        } catch (Exception unused) {
            j3 = 0;
        }
        Lock lock2 = lock;
        lock2.lock();
        try {
            b remove = this.mDownloadRecords.remove(xmlData.strResName);
            if (remove != null) {
                httpNetReq = remove.f203910a;
            } else {
                httpNetReq = null;
            }
            lock2.unlock();
            if (z16) {
                z16 = verifyResource(xmlData, netResp.mReq.mOutPath);
                if (!z16) {
                    netResp.mErrCode = AppConstants.RichMediaErrorCode.ERR_MD5_NOT_SAME_1;
                    netResp.mErrDesc = "md5_not_same.netSize:" + j3 + xmlData.strLog;
                    xmlData.strLog = "";
                    xmlData.hasResDownloaded = false;
                    try {
                        FileUtils.deleteFile(netResp.mReq.mOutPath);
                    } catch (Exception unused2) {
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 2, "doOnResp() verifyResource=" + z16 + " resName=" + xmlData.strResName);
                }
            }
            int i3 = xmlData.reqLoadCount;
            int i16 = netResp.mErrCode;
            if ((i16 == -6103066 || i16 == -9527) && i3 < 3) {
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 2, "retry load.resName:" + xmlData.strResName + ".reqCount=" + xmlData.reqLoadCount + ".errCode=" + netResp.mErrCode);
                }
                downloadResource(xmlData, netResp.mReq.mOutPath);
                return;
            }
            xmlData.reqLoadCount = 0;
            com.tencent.mobileqq.earlydownload.handler.b earlyHandler = getEarlyHandler(xmlData.strResName);
            if (z16) {
                httpNetReq2 = httpNetReq;
                xmlData.tLoadFail = 0L;
                xmlData.loadState = 1;
                xmlData.hasResDownloaded = true;
                if (QLog.isColorLevel()) {
                    stringBuffer = new StringBuffer("onDownloadFinish() resName=" + xmlData.strResName + " storeBackup=" + xmlData.StoreBackup);
                } else {
                    stringBuffer = null;
                }
                if (xmlData.StoreBackup && earlyHandler != null) {
                    try {
                        String m3 = earlyHandler.m();
                        boolean copyFile = FileUtils.copyFile(netResp.mReq.mOutPath, m3);
                        if (QLog.isColorLevel() && stringBuffer != null) {
                            stringBuffer.append(" copyResult=" + copyFile + " src=" + netResp.mReq.mOutPath + " dest=" + m3);
                        }
                    } catch (Exception unused3) {
                    }
                }
                if (QLog.isColorLevel() && stringBuffer != null) {
                    QLog.d("EarlyDown", 2, stringBuffer.toString());
                }
            } else {
                httpNetReq2 = httpNetReq;
                int i17 = netResp.mErrCode;
                if (i17 != 9366 && i17 != 9369 && i17 != 9367 && i17 != 9037 && i17 != 9004) {
                    xmlData.tLoadFail = System.currentTimeMillis();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("EarlyDown", 2, "set tLoadFail=" + xmlData.tLoadFail + " strPkgName=" + xmlData.strResName);
                }
                if (earlyHandler != null) {
                    earlyHandler.J(true);
                }
                FileUtils.deleteFile(netResp.mReq.mOutPath);
            }
            com.tencent.mobileqq.earlydownload.a.f(xmlData, "Version", "loadState", "tLoadFail", "hasResDownloaded");
            removeRequesting(xmlData.getStrResName());
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "doOnResp() result=" + z16 + " errCode=" + netResp.mErrCode + " name=" + xmlData.strResName + ",strResURL_big=" + xmlData.strResURL_big);
            }
            if (httpNetReq2 != null) {
                if (earlyHandler != null) {
                    earlyHandler.G(xmlData, z16, netResp.mErrCode, netResp.mReq.mOutPath);
                    earlyHandler.h();
                }
                int i18 = netResp.mErrCode;
                if (i18 != 9366 && i18 != 9037 && i18 != 9004 && i18 != 9040) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("param_FailCode", Integer.toString(netResp.mErrCode));
                    hashMap.put("param_strPkgName", xmlData.strPkgName);
                    hashMap.put("param_reqCount", Integer.toString(i3));
                    if (!z16) {
                        HashMap<String, String> hashMap2 = netResp.mRespProperties;
                        if (hashMap2 != null && (str = hashMap2.get("serverip")) != null && str.length() > 0) {
                            hashMap.put("param_serverIP", str);
                        }
                        String str2 = netResp.mErrDesc;
                        if (str2 != null && str2.length() > 0) {
                            hashMap.put("param_desc", netResp.mErrDesc + xmlData.strLog);
                            xmlData.strLog = "";
                        }
                    }
                    if (earlyHandler != null && (t16 = earlyHandler.t()) != null && t16.length() > 0) {
                        StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), earlyHandler.t(), z16, elapsedRealtime, j3, hashMap, "");
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "doOnResp() resName=" + xmlData.strResName + " netReq is null. may has been cancelled.");
            }
        } catch (Throwable th5) {
            lock.unlock();
            throw th5;
        }
    }

    private void initStrResNames(AppRuntime appRuntime) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return;
        }
        ArrayList<com.tencent.mobileqq.earlydownload.inject.a> b16 = this.mEarlyHandlerProcessorFactory.b(MobileQQ.sMobileQQ.peekAppRuntime());
        if (b16 != null && b16.size() > 0) {
            this.mBaseEarlyHandlerProcessorArrayList = b16;
        }
        ArrayList<com.tencent.mobileqq.earlydownload.inject.a> arrayList = this.mBaseEarlyHandlerProcessorArrayList;
        if (arrayList != null && arrayList.size() > 0) {
            if (QLog.isColorLevel()) {
                Iterator<com.tencent.mobileqq.earlydownload.inject.a> it = this.mBaseEarlyHandlerProcessorArrayList.iterator();
                while (it.hasNext()) {
                    QLog.i(TAG, 2, "early download res name : " + it.next().b());
                }
                return;
            }
            return;
        }
        QLog.i(TAG, 1, "early download res name list is null !!!");
    }

    private boolean isBusinessForbidPreDownload(com.tencent.mobileqq.earlydownload.handler.b bVar) {
        if (bVar != null && sForbiddenBusinesses.contains(Integer.valueOf(bVar.n()))) {
            return true;
        }
        return false;
    }

    private void onDownloadBegin(XmlData xmlData, HttpNetReq httpNetReq, AbsPreDownloadTask absPreDownloadTask) {
        xmlData.tStart = SystemClock.elapsedRealtime();
        xmlData.loadState = 2;
        xmlData.hasResDownloaded = false;
        com.tencent.mobileqq.earlydownload.a.f(xmlData, "loadState", "hasResDownloaded");
        com.tencent.mobileqq.earlydownload.handler.b earlyHandler = getEarlyHandler(xmlData.getStrResName());
        if (earlyHandler != null && xmlData.reqLoadCount == 0) {
            earlyHandler.E(xmlData);
        }
        xmlData.reqLoadCount++;
        Lock lock2 = lock;
        lock2.lock();
        try {
            b bVar = new b(null);
            bVar.f203910a = httpNetReq;
            bVar.f203911b = absPreDownloadTask;
            this.mDownloadRecords.put(xmlData.strResName, bVar);
            this.mPendingDownloadRecords.remove(xmlData.strResName);
            lock2.unlock();
        } catch (Throwable th5) {
            lock.unlock();
            throw th5;
        }
    }

    private boolean verifyResource(XmlData xmlData, String str) {
        String str2;
        String str3;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("verifyResource() data=");
            if (xmlData != null) {
                str3 = xmlData.strResName;
            } else {
                str3 = "";
            }
            sb5.append(str3);
            sb5.append(", filepath=");
            sb5.append(str);
            QLog.d("EarlyDown", 2, sb5.toString());
        }
        if (xmlData == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(xmlData.MD5)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.e("EarlyDown", 2, "verifyResource() file[" + str + "] not exist..");
            }
            return false;
        }
        try {
            try {
                str2 = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
            } catch (UnsatisfiedLinkError unused) {
                str2 = com.tencent.qqprotect.singleupdate.a.d(file);
            }
        } catch (Exception unused2) {
            str2 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "verifyResource " + xmlData.strResName + ",data.md5=" + xmlData.MD5 + ",file.md5=" + str2);
        }
        if (xmlData.MD5.equalsIgnoreCase(str2)) {
            return true;
        }
        xmlData.strLog = ".md5.S:" + xmlData.MD5 + ".L:" + str2 + ".";
        return false;
    }

    @Override // com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
    public void addRequesting(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "addRequesting " + str);
        }
        synchronized (this.mRequestSet) {
            if (!this.mRequestSet.contains(str)) {
                this.mRequestSet.add(str);
            }
        }
    }

    void cancelDownload(XmlData xmlData) {
        if (xmlData == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "cancelDownload.name=" + xmlData.strResName + ",strResURL_big=" + xmlData.strResURL_big + ",localVer=" + xmlData.Version);
        }
        Handler handler = this.mEarlyHandler;
        if (handler != null) {
            handler.obtainMessage(ACTION_DOWNLOAD_ON_CANCEL, xmlData).sendToTarget();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0185 A[Catch: all -> 0x01ac, TRY_LEAVE, TryCatch #2 {all -> 0x01ac, blocks: (B:65:0x015f, B:68:0x017d, B:70:0x0185, B:75:0x0175), top: B:64:0x015f, outer: #0 }] */
    @Override // com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void downloadResource(XmlData xmlData, String str) {
        String str2;
        int i3;
        com.tencent.mobileqq.earlydownload.handler.b earlyHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) xmlData, (Object) str);
            return;
        }
        int i16 = 2;
        if (xmlData != null && str != null && str.length() != 0) {
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "downloadResource() name=" + xmlData.strResName + " strResURL_big=" + xmlData.strResURL_big + " storagePath=" + str);
            }
            if (TextUtils.isEmpty(xmlData.strResURL_big)) {
                return;
            }
            Lock lock2 = lock;
            lock2.lock();
            try {
                if (this.mDownloadRecords.containsKey(xmlData.strResName)) {
                    if (xmlData.loadState == 0) {
                        xmlData.loadState = 2;
                        com.tencent.mobileqq.earlydownload.a.f(xmlData, "loadState");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "downloadResource() return, already exist=" + xmlData.strResName);
                    }
                    lock2.unlock();
                    return;
                }
                if (this.mPendingDownloadRecords.containsKey(xmlData.strResName)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "hasPendingDownloadRecord, isUserClick " + xmlData.isUserClick);
                    }
                    if (!xmlData.isUserClick) {
                        lock2.unlock();
                        return;
                    } else {
                        HttpEngineTask remove = this.mPendingDownloadRecords.remove(xmlData.strResName);
                        if (remove != null) {
                            this.mPreDownloadCtrl.cancelPreDownload(remove.httpReq.mReqUrl);
                        }
                    }
                }
                lock2.unlock();
                xmlData.tStart = SystemClock.elapsedRealtime();
                xmlData.loadState = 2;
                xmlData.hasResDownloaded = false;
                com.tencent.mobileqq.earlydownload.a.f(xmlData, "loadState", "hasResDownloaded");
                IHttpEngineService iHttpEngineService = (IHttpEngineService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IHttpEngineService.class, "all");
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "netEngine == null ? ");
                }
                HttpNetReq httpNetReq = new HttpNetReq();
                httpNetReq.mCallback = this;
                httpNetReq.mSupportBreakResume = true;
                httpNetReq.mReqUrl = xmlData.strResURL_big;
                httpNetReq.mNeedIpConnect = true;
                httpNetReq.mHttpMethod = 0;
                httpNetReq.setUserData(xmlData);
                httpNetReq.mOutPath = str;
                httpNetReq.bAcceptNegativeContentLength = true;
                if (!xmlData.isUserClick && this.mPreDownloadCtrl.isEnable()) {
                    httpNetReq.mPrioty = 2;
                    lock2.lock();
                    try {
                        HttpEngineTask httpEngineTask = new HttpEngineTask((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), xmlData.strResName, this, httpNetReq);
                        if (!xmlData.load2G) {
                            if (xmlData.load3G) {
                                i16 = 3;
                            } else {
                                i3 = 1;
                                earlyHandler = getEarlyHandler(xmlData.strResName);
                                if (earlyHandler != null) {
                                    this.mPreDownloadCtrl.requestPreDownload(earlyHandler.n(), earlyHandler.q(), xmlData.strResName, 0, xmlData.strResURL_big, earlyHandler.u(), i3, 0, false, httpEngineTask);
                                    this.mPendingDownloadRecords.put(xmlData.strResName, httpEngineTask);
                                }
                                lock2.unlock();
                                return;
                            }
                        }
                        i3 = i16;
                        earlyHandler = getEarlyHandler(xmlData.strResName);
                        if (earlyHandler != null) {
                        }
                        lock2.unlock();
                        return;
                    } finally {
                    }
                }
                if (xmlData.isUserClick) {
                    i16 = 1;
                }
                httpNetReq.mPrioty = i16;
                onDownloadBegin(xmlData, httpNetReq, null);
                iHttpEngineService.sendReq(httpNetReq);
                return;
            } finally {
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("downloadResource() return, ");
            if (xmlData == null) {
                str2 = "data==null";
            } else {
                str2 = "storagePath=" + str;
            }
            sb5.append(str2);
            QLog.d("EarlyDown", 2, sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
    public String getCurrentUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        String str = currentUin;
        if (str == null || str.length() == 0) {
            currentUin = MobileQQ.sMobileQQ.getLastLoginUin();
        }
        String str2 = currentUin;
        if (str2 != null && str2.length() > 0) {
            return currentUin;
        }
        return MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
    }

    @Override // com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
    public com.tencent.mobileqq.earlydownload.handler.b getEarlyHandler(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.earlydownload.handler.b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        com.tencent.mobileqq.earlydownload.handler.b bVar = null;
        if (str != null && str.length() != 0) {
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                return null;
            }
            bVar = this.mapHandler.get(str);
            if (bVar == null && (bVar = createHandler(str, MobileQQ.sMobileQQ.peekAppRuntime())) != null) {
                Lock lock2 = lock;
                lock2.lock();
                try {
                    if (!this.mapHandler.containsKey(str)) {
                        this.mapHandler.put(str, bVar);
                    }
                    lock2.unlock();
                } catch (Throwable th5) {
                    lock.unlock();
                    throw th5;
                }
            }
        }
        return bVar;
    }

    @Override // com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
    public void handleBroadcastReq(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) intent);
            return;
        }
        if (this.mEarlyHandler != null) {
            Message obtain = Message.obtain();
            if (obtain == null) {
                obtain = new Message();
            }
            obtain.obj = intent;
            obtain.what = ACTION_ON_BROADCAST_REQ;
            this.mEarlyHandler.sendMessage(obtain);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        GetResourceRespV2 getResourceRespV2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 4, "EarlyDownloadManager handleMessage,msg.what = " + message.what);
        }
        switch (message.what) {
            case ACTION_DOWNLOAD_ON_RESP /* 131328 */:
                doOnResp((NetResp) message.obj);
                break;
            case ACTION_DOWNLOAD_ON_CANCEL /* 131329 */:
                doOnCancelDownload((XmlData) message.obj);
                break;
            case ACTION_NET_CHANGED /* 131330 */:
                updateConfigs(false);
                break;
            case ACTION_ON_GET_CONFIG_RESP /* 131331 */:
                Object obj = message.obj;
                if (obj != null) {
                    getResourceRespV2 = (GetResourceRespV2) obj;
                } else {
                    getResourceRespV2 = null;
                }
                doOnGetConfig(getResourceRespV2);
                break;
            case ACTION_ON_SERVER_RESP /* 131332 */:
                Object obj2 = message.obj;
                if (obj2 instanceof GetResourceRespInfo) {
                    GetResourceRespInfo getResourceRespInfo = (GetResourceRespInfo) obj2;
                    if (QLog.isColorLevel()) {
                        QLog.d("EarlyDown", 2, "ACTION_ON_SERVER_RESP doOnServerResp() GetResourceRespInfo,resp.strPkgName = " + getResourceRespInfo.strPkgName + ",resp.iResult = " + getResourceRespInfo.iResult + ",resp.strResName = " + getResourceRespInfo.strResName);
                    }
                    if (getResourceRespInfo.iResult == 0) {
                        com.tencent.mobileqq.earlydownload.handler.b earlyHandler = getEarlyHandler(getResourceRespInfo.strResName);
                        if (earlyHandler != null) {
                            earlyHandler.j(com.tencent.mobileqq.earlydownload.a.d(earlyHandler.p(), getResourceRespInfo.strResName, getResourceRespInfo.strPkgName, getResourceRespInfo.strResConf, getResourceRespInfo.uiNewVer, getResourceRespInfo.strResURL_big, getResourceRespInfo.strResURL_small));
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("EarlyDown", 2, "ACTION_ON_SERVER_RESP doOnServerResp() GetResourceRespInfo = " + getResourceRespInfo.strPkgName + ",handler = " + earlyHandler);
                            break;
                        }
                    } else {
                        com.tencent.mobileqq.earlydownload.handler.b earlyHandler2 = getEarlyHandler(getResourceRespInfo.strResName);
                        if (earlyHandler2 != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("EarlyDown", 2, "!ACTION_ON_SERVER_RESP! doOnServerResp() GetResourceRespInfo = " + getResourceRespInfo.strPkgName + ",handler = " + earlyHandler2);
                            }
                            earlyHandler2.G(earlyHandler2.o(), false, getResourceRespInfo.iResult, "");
                        }
                        removeRequesting(getResourceRespInfo.strResName);
                        break;
                    }
                } else if (obj2 instanceof Object[]) {
                    Object[] objArr = (Object[]) obj2;
                    if (objArr.length == 2) {
                        Object obj3 = objArr[0];
                        if (obj3 instanceof String) {
                            Object obj4 = objArr[1];
                            if (obj4 instanceof XmlData) {
                                XmlData xmlData = (XmlData) obj4;
                                com.tencent.mobileqq.earlydownload.handler.b earlyHandler3 = getEarlyHandler((String) obj3);
                                if (QLog.isColorLevel()) {
                                    QLog.d("EarlyDown", 4, "ACTION_ON_SERVER_RESP object[], handler = " + earlyHandler3);
                                }
                                if (earlyHandler3 != null && !isBusinessForbidPreDownload(earlyHandler3)) {
                                    earlyHandler3.j(xmlData);
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            case ACTION_ON_BROADCAST_REQ /* 131333 */:
                Object obj5 = message.obj;
                if (obj5 instanceof Intent) {
                    doBroadcastReq((Intent) obj5);
                    break;
                }
                break;
        }
        return false;
    }

    public void handleOnGetPluginConfig(boolean z16, int i3, GetResourceRespV2 getResourceRespV2) {
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), Integer.valueOf(i3), getResourceRespV2);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("onGetPluginConfig() isSucc=" + z16 + " iPluginType=" + i3);
            if (getResourceRespV2 != null) {
                stringBuffer.append(" result=" + ((int) getResourceRespV2.result));
                stringBuffer.append(" uin=" + getResourceRespV2.uin);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(" add=");
                ArrayList<GetResourceRespInfoV2> arrayList = getResourceRespV2.vecAddedResInfo;
                if (arrayList != null) {
                    i16 = arrayList.size();
                } else {
                    i16 = 0;
                }
                sb5.append(i16);
                stringBuffer.append(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append(" update=");
                ArrayList<GetResourceRespInfoV2> arrayList2 = getResourceRespV2.vecUpdatedResInfo;
                if (arrayList2 != null) {
                    i17 = arrayList2.size();
                } else {
                    i17 = 0;
                }
                sb6.append(i17);
                stringBuffer.append(sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append(" delete=");
                ArrayList<GetResourceRespInfoV2> arrayList3 = getResourceRespV2.vecDeletedResInfo;
                if (arrayList3 != null) {
                    i18 = arrayList3.size();
                } else {
                    i18 = 0;
                }
                sb7.append(i18);
                stringBuffer.append(sb7.toString());
            }
            QLog.d("EarlyDown", 2, stringBuffer.toString());
            stringBuffer.setLength(0);
            if (!this.afterAppStart && i3 == 512) {
                stringBuffer.append("set afterAppStart=true");
            }
            QLog.d("EarlyDown", 2, stringBuffer.toString());
        }
        if (i3 != 512) {
            return;
        }
        this.pluginConfigGetSucc = Boolean.valueOf(z16);
        this.afterAppStart = true;
        if (!z16 || getResourceRespV2 == null) {
            return;
        }
        this.timeUpdateSuccess = SystemClock.elapsedRealtime();
        if (this.mEarlyHandler != null) {
            Message obtain = Message.obtain();
            if (obtain == null) {
                obtain = new Message();
            }
            obtain.what = ACTION_ON_GET_CONFIG_RESP;
            obtain.obj = getResourceRespV2;
            this.mEarlyHandler.sendMessage(obtain);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
    public boolean isLowEndPhone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        if (!ah.k0() && FileUtils.getAvailableInnernalMemorySize() > 1.048576E8f) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
    public boolean isRequesting(String str) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        synchronized (this.mRequestSet) {
            contains = this.mRequestSet.contains(str);
        }
        return contains;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) appRuntime);
            return;
        }
        initStrResNames(appRuntime);
        this.mEarlyHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.mPreDownloadCtrl = (IPreDownloadController) appRuntime.getRuntimeService(IPreDownloadController.class, "");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        com.tencent.mobileqq.earlydownload.handler.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        currentUin = null;
        ArrayList<com.tencent.mobileqq.earlydownload.inject.a> arrayList = this.mBaseEarlyHandlerProcessorArrayList;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<com.tencent.mobileqq.earlydownload.inject.a> it = this.mBaseEarlyHandlerProcessorArrayList.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.earlydownload.inject.a next = it.next();
                if (next != null && (bVar = this.mapHandler.get(next.b())) != null) {
                    bVar.g();
                }
            }
        }
        Handler handler = this.mEarlyHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mEarlyHandler = null;
        Lock lock2 = lock;
        lock2.lock();
        try {
            this.mapHandler.clear();
            lock2.unlock();
        } catch (Throwable th5) {
            lock.unlock();
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
    public void onNetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Handler handler = this.mEarlyHandler;
        if (handler == null) {
            return;
        }
        boolean hasMessages = handler.hasMessages(ACTION_ON_GET_CONFIG_RESP);
        if (this.afterAppStart && !hasMessages) {
            Message obtain = Message.obtain();
            if (obtain == null) {
                obtain = new Message();
            }
            obtain.what = ACTION_NET_CHANGED;
            if (this.mEarlyHandler.hasMessages(ACTION_NET_CHANGED)) {
                this.mEarlyHandler.removeMessages(ACTION_NET_CHANGED);
            }
            this.mEarlyHandler.sendMessageDelayed(obtain, DELAY_TIME);
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "onNetChange() sendMsg:ACTION_NET_CHANGE, delay(ms):" + DELAY_TIME);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "onNetChanged() return, afterAppStart=" + this.afterAppStart + " hasMsg:" + hasMessages);
        }
    }

    @Override // com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask
    public void onPreDownloadStart(HttpEngineTask httpEngineTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) httpEngineTask);
        } else {
            onDownloadBegin((XmlData) httpEngineTask.httpReq.getUserData(), httpEngineTask.httpReq, httpEngineTask);
        }
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) netResp);
            return;
        }
        Handler handler = this.mEarlyHandler;
        if (handler != null) {
            handler.obtainMessage(ACTION_DOWNLOAD_ON_RESP, netResp).sendToTarget();
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
    public void onServerResp(GetResourceRespInfo getResourceRespInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) getResourceRespInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onServerResp() PkgName = ");
            if (getResourceRespInfo != null) {
                str = getResourceRespInfo.strPkgName;
            } else {
                str = "[respInfo is null]";
            }
            sb5.append(str);
            QLog.d("EarlyDown", 2, sb5.toString());
        }
        if (!this.afterAppStart) {
            this.afterAppStart = true;
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "onServerResp() afterAppStart=true");
            }
        }
        if (this.mEarlyHandler != null) {
            Message obtain = Message.obtain();
            if (obtain == null) {
                obtain = new Message();
            }
            obtain.what = ACTION_ON_SERVER_RESP;
            obtain.obj = getResourceRespInfo;
            this.mEarlyHandler.sendMessage(obtain);
        }
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        XmlData xmlData = (XmlData) netReq.getUserData();
        if (xmlData != null) {
            xmlData.totalSize = j16;
            xmlData.downSize = j3;
            com.tencent.mobileqq.earlydownload.handler.b earlyHandler = getEarlyHandler(xmlData.strResName);
            if (earlyHandler != null) {
                earlyHandler.H(j3, j16);
            }
        }
    }

    public void removeHandler(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "removeHandler() strResName=" + str);
        }
        if (str != null && str.length() != 0) {
            Lock lock2 = lock;
            lock2.lock();
            try {
                com.tencent.mobileqq.earlydownload.handler.b remove = this.mapHandler.remove(str);
                lock2.unlock();
                if (remove != null) {
                    remove.g();
                }
            } catch (Throwable th5) {
                lock.unlock();
                throw th5;
            }
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
    public void removeRequesting(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "removeRequesting " + str);
        }
        synchronized (this.mRequestSet) {
            if (this.mRequestSet.contains(str)) {
                this.mRequestSet.remove(str);
            }
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
    public void setEarlyDownloadLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            lock.lock();
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
    public void setEarlyDownloadUnLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
    public void updateConfigs(boolean z16) {
        GetResourceReqInfoV2 getResourceReqInfoV2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return;
        }
        long j3 = this.timeUpdateSuccess;
        if (j3 > 0 && j3 + 7200000 > SystemClock.elapsedRealtime()) {
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "updateConfigs() timeUpdateSuccess + delay(120min) > now. return.");
                return;
            }
            return;
        }
        ReqUserInfo reqUserInfo = new ReqUserInfo();
        reqUserInfo.cType = (byte) 1;
        reqUserInfo.stGps = new GPS();
        reqUserInfo.strAuthName = QQAppInterface.AUTHORIZATION_NAME;
        reqUserInfo.strAuthPassword = QQAppInterface.AUTHORIZATION_PASSWORD;
        reqUserInfo.vCells = new ArrayList<>();
        reqUserInfo.vMacs = new ArrayList<>();
        ArrayList<GetResourceReqInfoV2> arrayList = new ArrayList<>();
        ArrayList<com.tencent.mobileqq.earlydownload.inject.a> arrayList2 = this.mBaseEarlyHandlerProcessorArrayList;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<com.tencent.mobileqq.earlydownload.inject.a> it = this.mBaseEarlyHandlerProcessorArrayList.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.earlydownload.inject.a next = it.next();
                if (next != null) {
                    com.tencent.mobileqq.earlydownload.handler.b earlyHandler = getEarlyHandler(next.b());
                    if (earlyHandler != null) {
                        earlyHandler.D(z16);
                        getResourceReqInfoV2 = earlyHandler.s(next.b());
                    } else {
                        getResourceReqInfoV2 = null;
                    }
                    if (getResourceReqInfoV2 != null) {
                        arrayList.add(getResourceReqInfoV2);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "getPluginList: 128 reqInfoV2s.len=" + arrayList.size());
        }
        ((ServerConfigManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(3)).getPluginConfig(512, reqUserInfo, arrayList, this.mServerConfigObserver, AppSetting.f());
    }
}
