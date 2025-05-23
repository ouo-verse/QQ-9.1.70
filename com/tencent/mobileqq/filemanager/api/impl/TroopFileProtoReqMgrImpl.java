package com.tencent.mobileqq.filemanager.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReqMgr;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import mqq.observer.CheckConErroObserver;
import qb1.g;

/* loaded from: classes12.dex */
public class TroopFileProtoReqMgrImpl implements ITroopFileProtoReqMgr {
    static final String KEY_RUNNABLE_INDEX = "key_runnable_index";
    public static final String TAG = "TroopFileProtoReqMgr";
    private AppInterface mApp;
    private ConcurrentHashMap<Intent, c> requests = new ConcurrentHashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class ProtoRequestRunnable implements Runnable {
        long C;

        /* renamed from: d, reason: collision with root package name */
        c f206793d;

        /* renamed from: e, reason: collision with root package name */
        NewIntent f206794e;

        /* renamed from: f, reason: collision with root package name */
        long f206795f;

        /* renamed from: m, reason: collision with root package name */
        long f206798m;

        /* renamed from: h, reason: collision with root package name */
        boolean f206796h = false;

        /* renamed from: i, reason: collision with root package name */
        boolean f206797i = false;
        boolean D = false;

        ProtoRequestRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QLog.i(TroopFileProtoReqMgrImpl.TAG, 1, "cookie<" + this.f206793d.f206818b.f206816n + "> sendToMsf. scheduleIndex:" + this.f206794e.getIntExtra("key_runnable_index", 0) + " timeOut:" + this.f206795f);
            this.f206796h = true;
            this.f206798m = System.currentTimeMillis();
            this.f206794e.putExtra("timeout", this.f206795f);
            StatictisInfo statictisInfo = this.f206793d.f206822f;
            statictisInfo.retryCount = statictisInfo.retryCount + 1;
            TroopFileProtoReqMgrImpl.this.requests.put(this.f206794e, this.f206793d);
            TroopFileProtoReqMgrImpl.this.sendToMsf(this.f206794e);
        }
    }

    /* loaded from: classes12.dex */
    public class a extends CheckConErroObserver {

        /* renamed from: d, reason: collision with root package name */
        c f206799d;

        /* renamed from: e, reason: collision with root package name */
        b f206800e;

        public a(c cVar, b bVar) {
            this.f206799d = cVar;
            this.f206800e = bVar;
        }

        @Override // mqq.observer.CheckConErroObserver, mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            String str;
            b bVar;
            FromServiceMsg fromServiceMsg;
            FromServiceMsg fromServiceMsg2;
            Object obj = "";
            if (bundle == null) {
                str = "";
            } else {
                str = bundle.getString("msf_con_erro");
                if (str == null) {
                    str = "";
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TroopFileProtoReqMgrImpl.TAG, 2, "CheckConErroObserverImp.onReceive -> msfConErro: " + str);
                }
                c cVar = this.f206799d;
                if (cVar != null && (fromServiceMsg2 = cVar.f206817a) != null) {
                    fromServiceMsg2.addAttribute(BaseConstants.Attribute_TAG_SOCKET_CONNERROR, str);
                }
            }
            b bVar2 = this.f206800e;
            if (bVar2 != null && bVar2.f206813k != null) {
                Bundle bundle2 = new Bundle();
                Bundle bundle3 = this.f206800e.f206814l;
                if (bundle3 != null) {
                    bundle2.putAll(bundle3);
                }
                c cVar2 = this.f206799d;
                if (cVar2 != null && (fromServiceMsg = cVar2.f206817a) != null) {
                    bundle2.putString("data_error_msg", fromServiceMsg.getBusinessFailMsg());
                    bundle2.putInt("data_error_code", this.f206799d.f206817a.getBusinessFailCode());
                    QLog.e(TroopFileProtoReqMgrImpl.TAG, 1, "cookie<" + this.f206799d.f206818b.f206816n + "> onProtoResponse fail end. failCode:" + this.f206799d.f206817a.getBusinessFailCode() + " retryCount:" + this.f206799d.f206822f.retryCount + " msfConErro:" + str);
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("cookie<");
                    c cVar3 = this.f206799d;
                    if (cVar3 != null && (bVar = cVar3.f206818b) != null) {
                        obj = Long.valueOf(bVar.f206816n);
                    }
                    sb5.append(obj);
                    sb5.append("> onProtoResponse fail end. msfConErro:");
                    sb5.append(str);
                    QLog.e(TroopFileProtoReqMgrImpl.TAG, 1, sb5.toString());
                }
                b bVar3 = this.f206800e;
                bVar3.f206813k.onResult(-1, null, bVar3.f206814l);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class b implements g {

        /* renamed from: o, reason: collision with root package name */
        static long f206802o;

        /* renamed from: a, reason: collision with root package name */
        public String f206803a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f206804b;

        /* renamed from: c, reason: collision with root package name */
        public int f206805c = 480000;

        /* renamed from: d, reason: collision with root package name */
        public int f206806d = 9;

        /* renamed from: e, reason: collision with root package name */
        public int f206807e = 3;

        /* renamed from: f, reason: collision with root package name */
        public int f206808f = 25;

        /* renamed from: g, reason: collision with root package name */
        public int f206809g = RichMediaStrategy.NO_MSF_SUGGEST_RETRY;

        /* renamed from: h, reason: collision with root package name */
        public boolean f206810h = true;

        /* renamed from: i, reason: collision with root package name */
        public boolean f206811i = true;

        /* renamed from: j, reason: collision with root package name */
        public int f206812j = 1;

        /* renamed from: k, reason: collision with root package name */
        public ProtoUtils.TroopProtocolObserver f206813k;

        /* renamed from: l, reason: collision with root package name */
        public Bundle f206814l;

        /* renamed from: m, reason: collision with root package name */
        c f206815m;

        /* renamed from: n, reason: collision with root package name */
        long f206816n;

        public b() {
            long j3 = f206802o + 1;
            f206802o = j3;
            this.f206816n = j3;
        }

        @Override // qb1.g
        public void a(String str) {
            this.f206803a = str;
        }

        @Override // qb1.g
        public void b(Bundle bundle) {
            this.f206814l = bundle;
        }

        @Override // qb1.g
        public void c(ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
            this.f206813k = troopProtocolObserver;
        }

        @Override // qb1.g
        public void d(byte[] bArr) {
            this.f206804b = bArr;
        }
    }

    /* loaded from: classes12.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public FromServiceMsg f206817a;

        /* renamed from: b, reason: collision with root package name */
        public b f206818b;

        /* renamed from: c, reason: collision with root package name */
        public long f206819c;

        /* renamed from: d, reason: collision with root package name */
        public ProtoRequestRunnable[] f206820d;

        /* renamed from: e, reason: collision with root package name */
        public int f206821e;

        /* renamed from: f, reason: collision with root package name */
        public StatictisInfo f206822f = new StatictisInfo();

        /* renamed from: g, reason: collision with root package name */
        boolean f206823g = false;
    }

    private synchronized void interCancelRequest(b bVar) {
        if (bVar != null) {
            if (bVar.f206815m != null) {
                QLog.i(TAG, 1, "cookie<" + bVar.f206816n + "> cancelRequest.");
                stopAllRunnables(bVar.f206815m);
            }
        }
    }

    private synchronized void interSendProtoRequest(b bVar) {
        QLog.i(TAG, 1, "cookie<" + bVar.f206816n + "> sendProtoRequest. ssocmd:" + bVar.f206803a + " tryCount:" + bVar.f206806d + " fixtryCount:" + bVar.f206807e + " fastResend:" + bVar.f206810h + " RemindSlowNet:" + bVar.f206811i);
        c cVar = new c();
        bVar.f206815m = cVar;
        cVar.f206818b = bVar;
        cVar.f206819c = System.currentTimeMillis();
        cVar.f206820d = new ProtoRequestRunnable[bVar.f206806d];
        int i3 = 0;
        for (int i16 = 0; i16 < bVar.f206806d; i16++) {
            ProtoRequestRunnable protoRequestRunnable = new ProtoRequestRunnable();
            cVar.f206820d[i16] = protoRequestRunnable;
            protoRequestRunnable.f206793d = cVar;
            AppInterface appInterface = this.mApp;
            if (appInterface == null) {
                QLog.e(TAG, 1, "mApp is null");
                return;
            }
            NewIntent newIntent = new NewIntent(appInterface.getApp(), com.tencent.mobileqq.troop.filemanager.d.class);
            protoRequestRunnable.f206794e = newIntent;
            Bundle bundle = bVar.f206814l;
            if (bundle != null) {
                newIntent.putExtras(bundle);
            }
            newIntent.putExtra("data", bVar.f206804b);
            newIntent.putExtra("cmd", bVar.f206803a);
            newIntent.putExtra("key_runnable_index", i16);
            newIntent.putExtra("fastresendenable", bVar.f206810h);
            newIntent.putExtra(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, bVar.f206811i);
        }
        while (true) {
            int i17 = bVar.f206807e;
            if (i3 < i17) {
                int i18 = bVar.f206805c;
                long j3 = (i3 * i18) / i17;
                ProtoRequestRunnable protoRequestRunnable2 = cVar.f206820d[i3];
                protoRequestRunnable2.f206795f = (i18 - j3) - (bVar.f206808f * i3);
                scheduleRunnable(protoRequestRunnable2, j3);
                i3++;
            } else {
                cVar.f206821e = i17;
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.ITroopFileProtoReqMgr
    public void cancelRequest(g gVar) {
        if (gVar != null && (gVar instanceof b)) {
            interCancelRequest((b) gVar);
        } else {
            QLog.e(TAG, 1, "cancelRequest err. req=null");
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.ITroopFileProtoReqMgr
    public g createProtoReq() {
        return new b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0016, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean isAllTryFinished(c cVar) {
        int i3 = 0;
        while (true) {
            ProtoRequestRunnable[] protoRequestRunnableArr = cVar.f206820d;
            if (i3 >= protoRequestRunnableArr.length) {
                return true;
            }
            ProtoRequestRunnable protoRequestRunnable = protoRequestRunnableArr[i3];
            if (protoRequestRunnable.f206797i || (!protoRequestRunnable.f206796h && !protoRequestRunnable.D)) {
                i3++;
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = (AppInterface) appRuntime;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onDestroy ");
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mApp = null;
    }

    @Override // com.tencent.mobileqq.filemanager.api.ITroopFileProtoReqMgr
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        int i16;
        ProtoUtils.TroopProtocolObserver troopProtocolObserver;
        boolean z16;
        c cVar;
        Bundle bundle;
        int i17;
        synchronized (this) {
            if (intent != null && fromServiceMsg != null) {
                cVar = this.requests.get(intent);
                if (cVar != null && !cVar.f206823g) {
                    i3 = intent.getIntExtra("key_runnable_index", 0);
                    recordRunnableBack(intent, cVar);
                    bundle = intent.getExtras();
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    b bVar = cVar.f206818b;
                    i16 = bVar.f206812j;
                    cVar.f206817a = fromServiceMsg;
                    cVar.f206822f.errCode = fromServiceMsg.getResultCode();
                    int resultCode = fromServiceMsg.getResultCode();
                    QLog.i(TAG, 1, "cookie<" + cVar.f206818b.f206816n + "> onProtoResponse. scheduleIndex:" + i3 + " retCode:" + resultCode);
                    if (resultCode == 1000) {
                        stopAllRunnables(cVar);
                        this.requests.remove(intent);
                        if (bVar.f206813k != null) {
                            bundle.putByteArray("data", fh.a(fromServiceMsg.getWupBuffer()));
                            troopProtocolObserver = bVar.f206813k;
                            z16 = true;
                        } else {
                            z16 = true;
                            troopProtocolObserver = null;
                        }
                    } else {
                        if (resultCode == 2901) {
                            long currentTimeMillis = System.currentTimeMillis() - cVar.f206819c;
                            if (currentTimeMillis < bVar.f206809g && (i17 = cVar.f206821e) < bVar.f206806d) {
                                ProtoRequestRunnable protoRequestRunnable = cVar.f206820d[i17];
                                cVar.f206821e = i17 + 1;
                                protoRequestRunnable.f206795f = (bVar.f206805c - currentTimeMillis) - 5000;
                                scheduleRunnable(protoRequestRunnable, 0L);
                                troopProtocolObserver = null;
                                z16 = false;
                            } else {
                                QLog.d(TAG, 2, "onReceive found 2901 but do not retry : elapse:" + currentTimeMillis + " index:" + cVar.f206821e);
                            }
                        }
                        if (isAllTryFinished(cVar)) {
                            stopAllRunnables(cVar);
                            this.requests.remove(intent);
                            if (resultCode == 1013) {
                                NewIntent newIntent = new NewIntent(this.mApp.getApplication(), BuiltInServlet.class);
                                newIntent.setObserver(new a(cVar, bVar));
                                newIntent.putExtra("action", 2201);
                                this.mApp.startServlet(newIntent);
                            } else {
                                troopProtocolObserver = bVar.f206813k;
                                if (troopProtocolObserver != null) {
                                    z16 = false;
                                }
                            }
                        }
                        troopProtocolObserver = null;
                        z16 = false;
                    }
                }
                i3 = -1;
                i16 = 1;
                troopProtocolObserver = null;
                z16 = false;
            } else {
                i3 = -1;
                i16 = 1;
                troopProtocolObserver = null;
                z16 = false;
                cVar = null;
            }
            bundle = null;
        }
        if (troopProtocolObserver != null) {
            if (z16) {
                QLog.i(TAG, 1, "cookie<" + cVar.f206818b.f206816n + "> onProtoResponse suc end. scheduleIndex:" + i3 + " retryCount:" + cVar.f206822f.retryCount);
                troopProtocolObserver.onReceive(i16, true, bundle);
                return;
            }
            bundle.putString("data_error_msg", fromServiceMsg.getBusinessFailMsg());
            bundle.putInt("data_error_code", fromServiceMsg.getBusinessFailCode());
            QLog.e(TAG, 1, "cookie<" + cVar.f206818b.f206816n + "> onProtoResponse fail end. failCode:" + fromServiceMsg.getBusinessFailCode() + " retryCount:" + cVar.f206822f.retryCount);
            troopProtocolObserver.onResult(-1, null, bundle);
        }
    }

    void recordRunnableBack(Intent intent, c cVar) {
        ProtoRequestRunnable protoRequestRunnable = cVar.f206820d[intent.getIntExtra("key_runnable_index", 0)];
        protoRequestRunnable.f206797i = true;
        protoRequestRunnable.C = System.currentTimeMillis();
    }

    void scheduleRunnable(ProtoRequestRunnable protoRequestRunnable, long j3) {
        protoRequestRunnable.D = true;
        this.mHandler.postDelayed(protoRequestRunnable, j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.ITroopFileProtoReqMgr
    public void sendProtoRequest(g gVar) {
        if (gVar != null && (gVar instanceof b)) {
            interSendProtoRequest((b) gVar);
        } else {
            QLog.e(TAG, 1, "sendProtoRequest err. req=null");
        }
    }

    void sendToMsf(NewIntent newIntent) {
        this.mApp.startServlet(newIntent);
    }

    void stopAllRunnables(c cVar) {
        cVar.f206823g = true;
        int i3 = 0;
        while (true) {
            ProtoRequestRunnable[] protoRequestRunnableArr = cVar.f206820d;
            if (i3 < protoRequestRunnableArr.length) {
                this.requests.remove(protoRequestRunnableArr[i3].f206794e);
                this.mHandler.removeCallbacks(cVar.f206820d[i3]);
                i3++;
            } else {
                return;
            }
        }
    }
}
