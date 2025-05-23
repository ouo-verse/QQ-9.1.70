package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.StringBuilderPrinter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.f;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.MsfServiceBindInfo;
import com.tencent.qphone.base.remote.ServiceMsgWrapper;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i extends p implements IMsfProxy {
    static IPatchRedirector $redirector_ = null;
    private static final String E = "MSF.D.ProxyNew";
    private static final int F = 20000;
    private static final int G = 10000;
    private static final int H = 2000;
    private ConcurrentHashMap<Integer, ServiceMsgWrapper> A;
    protected boolean B;
    private final c C;
    private IMsfServiceCallbacker D;

    /* renamed from: z, reason: collision with root package name */
    private ConcurrentHashMap<Integer, ServiceMsgWrapper> f250556z;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends IMsfServiceCallbacker.Stub {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // android.os.Binder, android.os.IBinder
        public boolean isBinderAlive() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d(i.E, 2, "isBinderAlive");
            }
            return super.isBinderAlive();
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onFirstPkgResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3, int i16, int i17) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            int requestSsoSeq = fromServiceMsg.getRequestSsoSeq();
            if (QLog.isColorLevel()) {
                QLog.d(i.E, 2, "receive first res package, , thread id = " + Thread.currentThread().getId() + ", ssoSeq = " + requestSsoSeq + ", index = " + i3 + ", length = " + fromServiceMsg.getWupBuffer().length + ", packageLength = " + i16 + ", totalLength = " + i17);
            }
            ServiceMsgWrapper serviceMsgWrapper = new ServiceMsgWrapper(toServiceMsg, fromServiceMsg, i17);
            serviceMsgWrapper.buildFromMsgWupBuffer(i3, fromServiceMsg.getWupBuffer());
            i.this.f250556z.put(Integer.valueOf(requestSsoSeq), serviceMsgWrapper);
            i.this.f250636c.postDelayed(new f(i.this.f250556z, requestSsoSeq), 20000L);
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onNextPkgResp(int i3, int i16, byte[] bArr) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i17 = 2;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), bArr);
                return;
            }
            Integer valueOf = Integer.valueOf(i3);
            ServiceMsgWrapper serviceMsgWrapper = (ServiceMsgWrapper) i.this.f250556z.get(valueOf);
            if (QLog.isColorLevel() || serviceMsgWrapper == null) {
                if (serviceMsgWrapper == null) {
                    i17 = 1;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("receive next res package, , thread id = ");
                sb5.append(Thread.currentThread().getId());
                sb5.append(", ssoSeq = ");
                sb5.append(valueOf);
                sb5.append(", index = ");
                sb5.append(i16);
                sb5.append(", length = ");
                sb5.append(bArr.length);
                sb5.append(", resServiceMsgWrapper = null ");
                if (serviceMsgWrapper == null) {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.d(i.E, i17, sb5.toString());
            }
            if (serviceMsgWrapper != null) {
                serviceMsgWrapper.buildFromMsgWupBuffer(i16, bArr);
                if (serviceMsgWrapper.isFinishTransported()) {
                    i.this.d(serviceMsgWrapper.getToServiceMsg(), serviceMsgWrapper.getFromServiceMsg());
                    com.tencent.mobileqq.msf.sdk.report.c.a().onReceiveResp(serviceMsgWrapper.getToServiceMsg(), serviceMsgWrapper.getFromServiceMsg());
                    i.this.f250556z.remove(valueOf);
                }
            }
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onReceiveFirstPkgPushResp(FromServiceMsg fromServiceMsg, int i3, int i16, int i17) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, fromServiceMsg, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            int requestSsoSeq = fromServiceMsg.getRequestSsoSeq();
            if (QLog.isColorLevel()) {
                QLog.d(i.E, 2, "receive first push package, , thread id = " + Thread.currentThread().getId() + ", ssoSeq = " + requestSsoSeq + ", index = " + i3 + ", length = " + fromServiceMsg.getWupBuffer().length + ", packageLength = " + i16 + ", totalLength = " + i17);
            }
            ServiceMsgWrapper serviceMsgWrapper = new ServiceMsgWrapper(null, fromServiceMsg, i17);
            serviceMsgWrapper.buildFromMsgWupBuffer(i3, fromServiceMsg.getWupBuffer());
            i.this.A.put(Integer.valueOf(requestSsoSeq), serviceMsgWrapper);
            i.this.f250636c.postDelayed(new f(i.this.A, requestSsoSeq), 20000L);
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onReceiveNextPkgPushResp(int i3, int i16, byte[] bArr) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i17 = 2;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), bArr);
                return;
            }
            Integer valueOf = Integer.valueOf(i3);
            ServiceMsgWrapper serviceMsgWrapper = (ServiceMsgWrapper) i.this.A.get(valueOf);
            if (QLog.isColorLevel() || serviceMsgWrapper == null) {
                if (serviceMsgWrapper == null) {
                    i17 = 1;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("receive next push package, , thread id = ");
                sb5.append(Thread.currentThread().getId());
                sb5.append(", ssoSeq = ");
                sb5.append(valueOf);
                sb5.append(", index = ");
                sb5.append(i16);
                sb5.append(", length = ");
                sb5.append(bArr.length);
                sb5.append(", resServiceMsgWrapper = null ");
                if (serviceMsgWrapper == null) {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.d(i.E, i17, sb5.toString());
            }
            if (serviceMsgWrapper != null) {
                serviceMsgWrapper.buildFromMsgWupBuffer(i16, bArr);
                if (serviceMsgWrapper.isFinishTransported()) {
                    i.this.a(serviceMsgWrapper.getFromServiceMsg());
                    com.tencent.mobileqq.msf.sdk.report.c.a().onRecvServicePushResp(serviceMsgWrapper.getFromServiceMsg());
                    i.this.A.remove(valueOf);
                }
            }
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onReceivePushResp(FromServiceMsg fromServiceMsg) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                i.this.a(fromServiceMsg);
                com.tencent.mobileqq.msf.sdk.report.c.a().onRecvServicePushResp(fromServiceMsg);
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) fromServiceMsg);
            }
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onResponse(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                i.this.d(toServiceMsg, fromServiceMsg);
                com.tencent.mobileqq.msf.sdk.report.c.a().onReceiveResp(toServiceMsg, fromServiceMsg);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            }
        }

        @Override // android.os.Binder, android.os.IBinder
        public boolean pingBinder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d(i.E, 2, "pingBinder");
            }
            return super.pingBinder();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements Runnable {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.msf.sdk.report.c.a().onServiceConnected();
            int registerMsfService = i.this.registerMsfService(false, true);
            if (com.tencent.mobileqq.msf.service.n.a(BaseApplication.processName)) {
                i.this.f250647n.registerServiceListener();
            }
            if (QLog.isColorLevel()) {
                QLog.d(i.E, 2, "registerMsfService result:" + registerMsfService);
            }
            i.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements Runnable {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: s, reason: collision with root package name */
        static final String f250559s = "BindService";

        /* renamed from: t, reason: collision with root package name */
        static final int f250560t = 1;

        /* renamed from: u, reason: collision with root package name */
        static final int f250561u = 2;

        /* renamed from: v, reason: collision with root package name */
        static final int f250562v = 4;

        /* renamed from: w, reason: collision with root package name */
        static final int f250563w = 8;

        /* renamed from: x, reason: collision with root package name */
        static final int f250564x = 16;

        /* renamed from: a, reason: collision with root package name */
        int f250565a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicBoolean f250566b;

        /* renamed from: c, reason: collision with root package name */
        boolean f250567c;

        /* renamed from: d, reason: collision with root package name */
        long f250568d;

        /* renamed from: e, reason: collision with root package name */
        long f250569e;

        /* renamed from: f, reason: collision with root package name */
        long f250570f;

        /* renamed from: g, reason: collision with root package name */
        long f250571g;

        /* renamed from: h, reason: collision with root package name */
        long f250572h;

        /* renamed from: i, reason: collision with root package name */
        short f250573i;

        /* renamed from: j, reason: collision with root package name */
        short f250574j;

        /* renamed from: k, reason: collision with root package name */
        short f250575k;

        /* renamed from: l, reason: collision with root package name */
        short f250576l;

        /* renamed from: m, reason: collision with root package name */
        short f250577m;

        /* renamed from: n, reason: collision with root package name */
        boolean f250578n;

        /* renamed from: o, reason: collision with root package name */
        boolean f250579o;

        /* renamed from: p, reason: collision with root package name */
        boolean f250580p;

        /* renamed from: q, reason: collision with root package name */
        boolean f250581q;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
                return;
            }
            this.f250565a = 0;
            this.f250566b = new AtomicBoolean(false);
            this.f250567c = false;
            this.f250568d = 0L;
            this.f250569e = 0L;
            this.f250570f = 0L;
            this.f250571g = 0L;
            this.f250572h = 0L;
            this.f250573i = (short) 0;
            this.f250574j = (short) 0;
            this.f250575k = (short) 0;
            this.f250576l = (short) 0;
            this.f250577m = (short) 0;
            this.f250581q = false;
            this.f250580p = false;
            this.f250579o = false;
            this.f250578n = false;
        }

        String a() {
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append("control=");
            sb5.append(Integer.toBinaryString(this.f250565a));
            sb5.append(" conned=");
            sb5.append(i.this.b());
            sb5.append(" start=[");
            sb5.append((int) this.f250573i);
            sb5.append(",");
            sb5.append(this.f250568d);
            sb5.append("]");
            sb5.append(" bindSucc=[");
            sb5.append((int) this.f250574j);
            sb5.append(",");
            sb5.append(this.f250569e);
            sb5.append("]");
            sb5.append(" bindFail=[");
            sb5.append((int) this.f250575k);
            sb5.append(",");
            sb5.append(this.f250570f);
            sb5.append("]");
            sb5.append(" unbind=[");
            sb5.append((int) this.f250576l);
            sb5.append(",");
            sb5.append(this.f250571g);
            sb5.append("]");
            sb5.append(" stop=[");
            sb5.append((int) this.f250577m);
            sb5.append(",");
            sb5.append(this.f250572h);
            sb5.append("]");
            if (QLog.isColorLevel()) {
                QLog.i(f250559s, 2, sb5.toString());
            }
            return sb5.toString();
        }

        /* JADX WARN: Removed duplicated region for block: B:69:0x01b0  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i3;
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int i16 = this.f250565a;
            if (QLog.isColorLevel()) {
                QLog.d(f250559s, 2, "execute cmd: " + Integer.toBinaryString(i16));
            }
            if ((i16 & 8) == 8) {
                long currentTimeMillis = System.currentTimeMillis();
                if (i.this.b()) {
                    i.this.j();
                }
                this.f250579o = i.this.f();
                this.f250577m = (short) (this.f250577m + 1);
                this.f250572h = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d(f250559s, 2, "stop service cost=" + (this.f250572h - currentTimeMillis));
                }
            }
            if ((i16 & 4) == 4) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (i.this.b()) {
                    i.this.j();
                }
                i.this.g();
                boolean z16 = !i.this.b();
                this.f250581q = z16;
                if (!z16) {
                    QLog.i(f250559s, 1, "unbind service failed");
                }
                this.f250576l = (short) (this.f250576l + 1);
                this.f250571g = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d(f250559s, 2, "unbind service cost=" + (this.f250571g - currentTimeMillis2));
                }
            }
            if ((i16 & 1) == 1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                i.this.e();
                this.f250573i = (short) (this.f250573i + 1);
                this.f250568d = System.currentTimeMillis();
                this.f250578n = true;
                if (QLog.isColorLevel()) {
                    QLog.d(f250559s, 2, "start service cost=" + (System.currentTimeMillis() - currentTimeMillis3));
                }
            }
            if ((i16 & 16) == 16) {
                Intent intent = new Intent("com.tencent.mobileqq.msf.startmsf");
                intent.setPackage(BaseApplication.getContext().getPackageName());
                BaseApplication.getContext().sendBroadcast(intent);
            }
            if ((i16 & 2) == 2) {
                long currentTimeMillis4 = System.currentTimeMillis();
                if (!i.this.b()) {
                    this.f250580p = i.this.a();
                    int i17 = 50;
                    int i18 = 1;
                    while (!i.this.b() && !Thread.interrupted() && i17 <= 2000) {
                        try {
                            LockMethodProxy.sleep(i17);
                            i17 += i18 * 50;
                            i18++;
                        } catch (Exception unused) {
                        }
                    }
                    if (!i.this.b()) {
                        this.f250575k = (short) (this.f250575k + 1);
                        this.f250570f = System.currentTimeMillis();
                        if (System.currentTimeMillis() - this.f250568d > 10000) {
                            i3 = 23;
                        } else {
                            i3 = 6;
                        }
                        if (System.currentTimeMillis() - this.f250572h > 30000) {
                            i3 |= 29;
                        }
                        if (QLog.isColorLevel()) {
                            if (i.this.b()) {
                                j3 = this.f250569e;
                            } else {
                                j3 = this.f250570f;
                            }
                            QLog.d(f250559s, 2, "bind service bindSucc=" + this.f250580p + " conned=" + i.this.b() + " cost=" + (j3 - currentTimeMillis4));
                        }
                    } else {
                        this.f250574j = (short) (this.f250574j + 1);
                        this.f250575k = (short) 0;
                        this.f250569e = System.currentTimeMillis();
                    }
                }
                i3 = 0;
                if (QLog.isColorLevel()) {
                }
            } else {
                i3 = 0;
            }
            if (i.this.b()) {
                this.f250566b.set(false);
            } else if (i3 > 0) {
                i.this.C.f250565a = i3;
                i.this.f250636c.post(i.this.C);
            } else {
                this.f250566b.set(false);
            }
            if (QLog.isColorLevel()) {
                a();
                QLog.d(f250559s, 2, "execute cmd finished");
            }
        }
    }

    public i(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.B = false;
        this.C = new c();
        this.D = new a();
        this.f250556z = new ConcurrentHashMap<>();
        this.A = new ConcurrentHashMap<>();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Transport-Timeout-Checker", 5);
        baseHandlerThread.start();
        this.f250636c = new Handler(baseHandlerThread.getLooper());
    }

    private int f(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return -1;
        }
        try {
        } catch (DeadObjectException e16) {
            b(toServiceMsg);
            QLog.w(E, 1, e16.getMessage(), e16);
        } catch (Exception e17) {
            if (this.f250634a == null) {
                b(toServiceMsg);
            } else {
                e17.printStackTrace();
            }
        }
        if (b()) {
            return e(toServiceMsg);
        }
        b(toServiceMsg);
        return -1;
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    protected void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (com.tencent.mobileqq.msf.service.n.a(BaseApplication.processName)) {
            this.f250647n.unregisterServiceListener();
        }
        com.tencent.mobileqq.msf.sdk.report.c.a().onServiceDisconnected();
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    void e() {
        if (!com.tencent.mobileqq.msf.core.p.a()) {
            QLog.d(E, 1, "startBaseService no allow");
            return;
        }
        try {
            ComponentName componentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.f250647n.msfServiceName);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, this.f250647n.processName);
            BaseApplication.getContext().startService(intent);
        } catch (Exception e16) {
            QLog.d(E, 1, " " + e16, e16);
        }
        QLog.d(E, 1, "start service finish");
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            super.g();
        }
    }

    String h() {
        StringBuilder sb5 = new StringBuilder();
        this.f250636c.dump(new StringBuilderPrinter(sb5), "");
        if (QLog.isColorLevel()) {
            QLog.i(E, 2, sb5.toString());
        }
        return sb5.toString();
    }

    void i() {
        if (!b() && this.C.f250566b.compareAndSet(false, true)) {
            c cVar = this.C;
            cVar.f250565a = 3;
            long currentTimeMillis = System.currentTimeMillis();
            cVar.f250572h = currentTimeMillis;
            cVar.f250568d = currentTimeMillis;
            this.f250636c.postAtFrontOfQueue(this.C);
            com.tencent.mobileqq.msf.sdk.report.c.a().onReqServiceConn();
            if (QLog.isColorLevel()) {
                QLog.i(E, 2, "MSF_Alive_Log requestServiceConn");
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public void init(MsfServiceSdk msfServiceSdk) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msfServiceSdk);
            return;
        }
        this.f250647n = msfServiceSdk;
        msfServiceSdk.msfServiceName = this.f250641h;
        if (this.f250644k != null) {
            if (this.f250642i) {
                this.f250636c.postDelayed(this.f250644k, 10000L);
            } else {
                this.f250636c.postDelayed(this.f250644k, 2000L);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public void initMsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            i();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        while (!p.f250628t.isEmpty()) {
            ToServiceMsg poll = p.f250628t.poll();
            if (poll != null) {
                try {
                    e(poll);
                } catch (Exception e16) {
                    b(poll, a(poll, poll.getServiceName() + "sendMsgToServiceFailed\uff0c" + e16.toString()));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public int registerMsfService(boolean z16, boolean z17) {
        IMsfServiceCallbacker iMsfServiceCallbacker;
        IBinder iBinder;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Boolean.valueOf(z17))).intValue();
        }
        if (QLog.isColorLevel() && (iMsfServiceCallbacker = this.D) != null) {
            String hexString = Integer.toHexString(iMsfServiceCallbacker.hashCode());
            IMsfServiceCallbacker iMsfServiceCallbacker2 = this.D;
            if (iMsfServiceCallbacker2 != null) {
                iBinder = iMsfServiceCallbacker2.asBinder();
            } else {
                iBinder = null;
            }
            if (iBinder != null) {
                z18 = iBinder.isBinderAlive();
            } else {
                z18 = false;
            }
            QLog.d(E, 2, "registerMsfService processName=" + this.f250647n.processName + " callback=" + hexString + " isBindAlive=" + z18);
        } else {
            QLog.d(E, 1, "registerMsfService processName=" + this.f250647n.processName + " callback=" + this.D);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(this.f250647n.msfServiceName, "0", BaseConstants.CMD_REGISTERMSFSERVICE);
        toServiceMsg.setMsfCommand(MsfCommand.registerMsfService);
        MsfServiceSdk msfServiceSdk = this.f250647n;
        MsfServiceBindInfo msfServiceBindInfo = new MsfServiceBindInfo(msfServiceSdk.appid, msfServiceSdk.processName, msfServiceSdk.getBootBroadcastName(), this.D);
        a(this.D);
        toServiceMsg.getAttributes().put(MsfConstants.INTENT_BINDSERVICEINFO, msfServiceBindInfo);
        toServiceMsg.setNeedCallback(false);
        this.B = true;
        return sendMsg(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public void registerProxyDone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (this.f250642i && this.f250643j && this.f250644k != null) {
            this.f250636c.removeCallbacks(this.f250644k);
            this.f250636c.post(this.f250644k);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.p, com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public int sendMsg(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (toServiceMsg == null) {
            return -1;
        }
        if (d(toServiceMsg)) {
            a(toServiceMsg);
            return -1;
        }
        com.tencent.mobileqq.msf.sdk.report.c.a().onSendMsg(toServiceMsg, b());
        if (toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_NEW_REGPRXYSVC_PBSYNCMSG)) {
            toServiceMsg.setMsfCommand(MsfCommand.msf_pbSyncMsg);
        }
        if (toServiceMsg.getAppSeq() < 0) {
            toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
        }
        if (toServiceMsg.getTimeout() == -1) {
            toServiceMsg.setTimeout(30000L);
        }
        if (toServiceMsg.isNeedCallback()) {
            c(toServiceMsg);
        }
        if (b()) {
            return f(toServiceMsg);
        }
        b(toServiceMsg);
        if (b()) {
            return f(toServiceMsg);
        }
        QLog.i(E, 1, "MSF_Alive_Log requestServiceConn in MsfServiceProxyNew sendMsg");
        i();
        return -1;
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public boolean serviceConnected() {
        IBinder iBinder;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        try {
            IMsfServiceCallbacker iMsfServiceCallbacker = this.D;
            if (iMsfServiceCallbacker != null) {
                iBinder = iMsfServiceCallbacker.asBinder();
            } else {
                iBinder = null;
            }
            if (iBinder != null) {
                z16 = iBinder.isBinderAlive();
            } else {
                z16 = false;
            }
            if (iBinder != null) {
                z17 = iBinder.pingBinder();
            } else {
                z17 = false;
            }
            if (!b() || !z16 || !z17) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public void startMsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            e();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public void stopMsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            f();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public int unRegisterMsfService(Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) bool)).intValue();
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(this.f250647n.msfServiceName, "0", BaseConstants.CMD_UNREGISTERMSFSERVICE);
        toServiceMsg.setMsfCommand(MsfCommand.unRegisterMsfService);
        toServiceMsg.extraData.putBoolean(MsfConstants.ATTRIBUTE_STOP_WAKE_PROCESS, bool.booleanValue());
        this.B = false;
        b(this.D);
        return sendMsg(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public void unbindMsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            j();
            g();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    protected void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(E, 2, "add fail queue req:" + toServiceMsg + " from:" + fromServiceMsg);
        }
        this.f250647n.addServiceRespMsg(new MsfMessagePair(toServiceMsg, fromServiceMsg));
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    protected void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            this.f250647n.postServiceTask(new b());
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public boolean c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg)).booleanValue();
        }
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        boolean booleanValue = fromServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUTE_SAMEDEVICE) ? ((Boolean) fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_SAMEDEVICE)).booleanValue() : false;
        if (businessFailCode != -2) {
            if (businessFailCode != 2001) {
                if (businessFailCode == 3003) {
                    QLog.d(E, 1, "AppClone: old guid = " + util.buf_to_string(NetConnInfoCenter.GUID));
                    com.tencent.qmethod.pandoraex.api.r.b();
                    NetConnInfoCenter.GUID = WtloginHelper.updateGuid(BaseApplication.getContext());
                    QLog.d(E, 1, "AppClone: new guid = " + util.buf_to_string(NetConnInfoCenter.GUID));
                    fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_APP_CLONE, Boolean.TRUE);
                    this.f250647n.errorHandler.onKicked(toServiceMsg, fromServiceMsg, true);
                    return true;
                }
                if (businessFailCode == 2008) {
                    this.f250647n.errorHandler.onGrayError(toServiceMsg, fromServiceMsg, booleanValue);
                    return true;
                }
                if (businessFailCode != 2009) {
                    switch (businessFailCode) {
                        case 2011:
                            this.f250647n.errorHandler.onRecvServerTip(toServiceMsg, fromServiceMsg, booleanValue);
                            return true;
                        case 2012:
                            this.f250647n.errorHandler.onKickedAndClearToken(toServiceMsg, fromServiceMsg, booleanValue);
                            return true;
                        case 2013:
                            this.f250647n.errorHandler.onKicked(toServiceMsg, fromServiceMsg, booleanValue);
                            return true;
                        case 2014:
                            this.f250647n.errorHandler.onInvalidSign(booleanValue);
                            return true;
                        default:
                            return false;
                    }
                }
                this.f250647n.errorHandler.onServerSuspended(toServiceMsg, fromServiceMsg, booleanValue);
                return true;
            }
            QLog.d(E, 1, "BaseConstants.CODE_NO_LOGIN " + fromServiceMsg.hashCode());
            this.f250647n.errorHandler.onUserTokenExpired(toServiceMsg, fromServiceMsg, booleanValue);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        QLog.d(E, 1, "onReceiveResp fromServiceMsg = " + fromServiceMsg.getServiceCmd() + ", ssoSeq = " + fromServiceMsg.getRequestSsoSeq() + ", length = " + fromServiceMsg.getWupBuffer().length);
        ToServiceMsg remove = p.f250629u.remove(Integer.valueOf(toServiceMsg.getAppSeq()));
        Runnable remove2 = p.f250630v.remove(Integer.valueOf(toServiceMsg.getAppSeq()));
        if (remove2 != null) {
            this.f250636c.removeCallbacks(remove2);
        }
        if (remove != null) {
            if (!"LongConn.OffPicUp".equalsIgnoreCase(remove.getServiceCmd()) && !"ImgStore.GroupPicUp".equalsIgnoreCase(remove.getServiceCmd())) {
                if (QLog.isColorLevel()) {
                    QLog.d(E, 2, " onResponse " + toServiceMsg.getRequestSsoSeq() + " " + fromServiceMsg);
                }
            } else {
                QLog.d(E, 1, "onReceiveResp." + remove.getStringForLog() + " isConnectedMsf:" + this.B);
            }
            if (c(toServiceMsg, fromServiceMsg)) {
                return;
            }
            if (this.B) {
                if (QLog.isColorLevel()) {
                    QLog.d(E, 2, "add queue req:" + toServiceMsg + " from:" + fromServiceMsg);
                }
                this.f250647n.addServiceRespMsg(new MsfMessagePair(toServiceMsg, fromServiceMsg));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(E, 2, " close msfServiceConn. msg is droped." + toServiceMsg.getRequestSsoSeq() + " " + fromServiceMsg);
                return;
            }
            return;
        }
        if (!"LongConn.OffPicUp".equalsIgnoreCase(fromServiceMsg.getServiceCmd()) && !"ImgStore.GroupPicUp".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d(E, 2, " found timeout resp to:" + toServiceMsg + " from:" + fromServiceMsg);
                return;
            }
            return;
        }
        QLog.d(E, 1, "onReceiveResp." + fromServiceMsg.getStringForLog() + " waiteTemp is null.");
        if (fromServiceMsg.isSuccess()) {
            HashMap hashMap = new HashMap();
            hashMap.put("appSeq", String.valueOf(fromServiceMsg.getAppSeq()));
            hashMap.put("ssoSeq", String.valueOf(fromServiceMsg.getRequestSsoSeq()));
            RdmReq rdmReq = new RdmReq();
            rdmReq.eventName = "PicUpMsgErroCase1";
            rdmReq.isRealTime = true;
            rdmReq.params = hashMap;
            try {
                ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq);
                rdmReportMsg.setTimeout(30000L);
                MsfServiceSdk.get().sendMsg(rdmReportMsg);
            } catch (Exception e16) {
                QLog.d(E, 1, "onReceiveResp, send rdmReportMsg error", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    protected void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            b(toServiceMsg, fromServiceMsg);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    boolean a() {
        boolean bindService;
        boolean z16 = false;
        if (!com.tencent.mobileqq.msf.core.p.a()) {
            QLog.d(E, 1, "bindBaseService no allow");
            return false;
        }
        com.tencent.mobileqq.msf.sdk.report.c.a().onBindStart();
        try {
            ComponentName componentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.f250647n.msfServiceName);
            Intent intent = new Intent();
            intent.putExtra(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, this.f250647n.processName);
            intent.setComponent(componentName);
            if (QLog.isColorLevel()) {
                bindService = BaseApplication.getContext().bindService(intent, this.f250649p, 3);
            } else {
                bindService = BaseApplication.getContext().bindService(intent, this.f250649p, 1);
            }
            z16 = bindService;
        } catch (Exception e16) {
            QLog.w(E, 1, " " + e16, e16);
        }
        com.tencent.mobileqq.msf.sdk.report.c.a().onBindEnd(z16);
        QLog.d(E, 1, "bind service finished " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    public boolean f() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        try {
            ComponentName componentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.f250647n.msfServiceName);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, this.f250647n.processName);
            z16 = BaseApplication.getContext().stopService(intent);
        } catch (Exception e16) {
            QLog.w(E, 1, " " + e16, e16);
            e16.printStackTrace();
            z16 = false;
        }
        QLog.d(E, 1, "stopService service finished " + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msf.sdk.p
    public int e(ToServiceMsg toServiceMsg) throws RemoteException, NullPointerException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (toServiceMsg == null) {
            return -1;
        }
        toServiceMsg.setAppId(this.f250647n.appid);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_SENDTIME, Long.valueOf(System.currentTimeMillis()));
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, this.f250647n.processName);
        if (QLog.isColorLevel() && com.tencent.mobileqq.msf.core.z.a.a(toServiceMsg)) {
            QLog.d(E, 2, " send req to msfService:" + toServiceMsg);
        }
        return super.e(toServiceMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FromServiceMsg fromServiceMsg) {
        QLog.d(E, 1, "onRecvServicePushResp fromServiceMsg = " + fromServiceMsg.getServiceCmd() + ", ssoSeq = " + fromServiceMsg.getRequestSsoSeq() + ", length = " + fromServiceMsg.getWupBuffer().length);
        if (!c(null, fromServiceMsg)) {
            if (fromServiceMsg.getMsfCommand() == MsfCommand.pushSetConfig) {
                QLog.setUIN_REPORTLOG_LEVEL(((Integer) fromServiceMsg.getAttribute(fromServiceMsg.getServiceCmd())).intValue());
                NetConnInfoCenter.socketConnState = ((Integer) fromServiceMsg.getAttribute(BaseConstants.Attribute_SOCKET_CONNSTATE)).intValue();
                NetConnInfoCenter.servetTimeSecondInterv = ((Long) fromServiceMsg.getAttribute(BaseConstants.Attribute_SERVERTIME)).longValue();
                NetConnInfoCenter.GUID = (byte[]) fromServiceMsg.getAttribute(BaseConstants.Attribute_DEVICEGUID);
                NetConnInfoCenter.sAppTimeoutConfig = ((Integer) fromServiceMsg.getAttribute(BaseConstants.Attribute_RESP_APP_TIMEOUT)).intValue();
                NetConnInfoCenter.setGateWayIp((String) fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_GATEWAY_IP, ""));
                long longValue = ((Long) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_SERVICE_INIT_TIME, 0L)).longValue();
                long longValue2 = ((Long) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_SERVICE_READY_TIME, 0L)).longValue();
                NetConnInfoCenter.setMSFServiceInitTime(longValue);
                NetConnInfoCenter.setMSFServiceReadyTime(longValue2);
                if (fromServiceMsg.getServiceCmd() == null || !fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
                    return;
                }
                com.tencent.mobileqq.msf.core.c0.f.a().a(f.a.f247651c, fromServiceMsg.getWupBuffer(), 17);
                return;
            }
            if (this.B) {
                this.f250647n.addServicePushMsg(fromServiceMsg);
                return;
            }
            if (fromServiceMsg.getServiceCmd() != null && fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
                com.tencent.mobileqq.msf.core.c0.f.a().a(f.a.f247651c, fromServiceMsg.getWupBuffer(), 16);
            }
            if (QLog.isColorLevel()) {
                QLog.d(E, 2, " close msfServiceConn. push msg is droped." + fromServiceMsg);
                return;
            }
            return;
        }
        if (fromServiceMsg.getBusinessFailCode() == -2) {
            if (QLog.isColorLevel()) {
                QLog.d(E, 2, "receive service ipc test push, length = " + fromServiceMsg.getWupBuffer().length);
                return;
            }
            return;
        }
        if (fromServiceMsg.getServiceCmd() == null || !fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
            return;
        }
        com.tencent.mobileqq.msf.core.c0.f.a().a(f.a.f247651c, fromServiceMsg.getWupBuffer(), 15);
    }
}
