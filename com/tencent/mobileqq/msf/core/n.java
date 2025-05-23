package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class n {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    static final String f248682b = "MSF.C.NetConnTag.";

    /* renamed from: a, reason: collision with root package name */
    private volatile Handler f248683a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f248684a;

        /* renamed from: b, reason: collision with root package name */
        private final t f248685b;

        public a(int i3, t tVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) tVar);
            } else {
                this.f248684a = i3;
                this.f248685b = tVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ArrayList<Integer> remove = this.f248685b.f250078c.remove(Integer.valueOf(this.f248684a));
            if (remove != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag.", 2, "remove merged ssoseq list: " + remove.toString() + " from SSO LoginMerge " + this.f248684a);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag.", 2, "SSO LoginMerge's ssoseq " + this.f248684a + "list has been removed by error code.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final ToServiceMsg f248686a;

        /* renamed from: b, reason: collision with root package name */
        private final t f248687b;

        public b(ToServiceMsg toServiceMsg, t tVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) toServiceMsg, (Object) tVar);
            } else {
                this.f248686a = toServiceMsg;
                this.f248687b = tVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ToServiceMsg toServiceMsg = this.f248686a;
            if (toServiceMsg == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag.", 2, "req null, add preDetTimeout failed! return.");
                    return;
                }
                return;
            }
            try {
                ToServiceMsg toServiceMsg2 = this.f248687b.f250077b.get(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
                if (toServiceMsg2 == null || !toServiceMsg2.isNeedCallback()) {
                    return;
                }
                ToServiceMsg toServiceMsg3 = this.f248687b.f250077b.get(Integer.valueOf(this.f248686a.getRequestSsoSeq()));
                if (toServiceMsg3 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag.", 2, "timeout msg " + toServiceMsg3 + " also received resp, return.");
                        return;
                    }
                    return;
                }
                this.f248687b.h(toServiceMsg3);
                toServiceMsg3.getAttributes().remove(MsfConstants.ATTRIBUTE_PREDETECT_TIMEOUT_CALLBACKER);
            } catch (Exception e16) {
                QLog.d("MSF.C.NetConnTag.", 1, "got fail msg. " + e16, e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final int f248688a;

        /* renamed from: b, reason: collision with root package name */
        private final t f248689b;

        public c(int i3, t tVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) tVar);
            } else {
                this.f248688a = i3;
                this.f248689b = tVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f248689b.c(this.f248688a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
        void a(ToServiceMsg toServiceMsg);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    static class f implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final com.tencent.mobileqq.msf.core.net.o f248694a;

        public f(com.tencent.mobileqq.msf.core.net.o oVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) oVar);
            } else {
                this.f248694a = oVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.msf.core.net.o oVar = this.f248694a;
            if (oVar != null) {
                try {
                    oVar.p();
                } catch (Exception e16) {
                    QLog.d("MSF.C.NetConnTag.", 1, "call loginConnectTimeOut error " + e16);
                }
            }
        }
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public Runnable a(ToServiceMsg toServiceMsg, long j3, d dVar, t tVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Runnable) iPatchRedirector.redirect((short) 4, this, toServiceMsg, Long.valueOf(j3), dVar, tVar);
        }
        e eVar = new e(toServiceMsg, dVar, tVar);
        if (toServiceMsg != null) {
            this.f248683a.postDelayed(eVar, j3);
        }
        return eVar;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MsfCoreTimeoutChecker", 5);
        baseHandlerThread.start();
        this.f248683a = new Handler(baseHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private d f248690a;

        /* renamed from: b, reason: collision with root package name */
        private ToServiceMsg f248691b;

        /* renamed from: c, reason: collision with root package name */
        private final t f248692c;

        public e(ToServiceMsg toServiceMsg, t tVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, n.this, toServiceMsg, tVar);
            } else {
                this.f248691b = toServiceMsg;
                this.f248692c = tVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int i16;
            int i17;
            String str;
            com.tencent.mobileqq.msf.core.net.n i18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            ToServiceMsg toServiceMsg = this.f248691b;
            String str2 = "MSF.C.NetConnTag.";
            if (toServiceMsg == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag.", 2, "req null, return.");
                    return;
                }
                return;
            }
            if (this.f248692c == null) {
                QLog.e("MSF.C.NetConnTag.", 1, "sender null, return");
                return;
            }
            d dVar = this.f248690a;
            if (dVar != null) {
                dVar.a(toServiceMsg);
            }
            try {
                if (this.f248692c.f250077b.get(Integer.valueOf(this.f248691b.getRequestSsoSeq())) != null) {
                    ToServiceMsg remove = this.f248692c.f250077b.remove(Integer.valueOf(this.f248691b.getRequestSsoSeq()));
                    if (!remove.isNeedCallback()) {
                        return;
                    }
                    String serviceCmd = remove.getServiceCmd();
                    com.tencent.mobileqq.msf.core.net.o oVar = this.f248692c.f250076a;
                    if (oVar != null && (i18 = oVar.i()) != null) {
                        i3 = i18.u();
                        i17 = i18.p();
                        i16 = i18.o();
                    } else {
                        i3 = -1;
                        i16 = -1;
                        i17 = -1;
                    }
                    try {
                        try {
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("netRecv ssoSeq:");
                                sb5.append(remove.getRequestSsoSeq());
                                sb5.append(" uin:");
                                sb5.append(remove.getUin());
                                sb5.append(" cmd:");
                                sb5.append(serviceCmd);
                                sb5.append(" costTime:");
                                str = "MSF.C.NetConnTag.";
                                sb5.append(remove.getTimeout());
                                sb5.append(NetConnInfoCenter.getSignalStrengthsLog());
                                sb5.append(" code:");
                                sb5.append(1002);
                                sb5.append(" failMsg:");
                                sb5.append("wait serverResp timeout");
                                sb5.append(" socketFd:");
                                sb5.append(i3);
                                sb5.append(" remainRecvBuffSize:");
                                sb5.append(i17);
                                sb5.append(" receiveBufferSize:");
                                sb5.append(i16);
                                str2 = str;
                                QLog.d(str2, 2, sb5.toString());
                            } else {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("netRecv ssoSeq:");
                                sb6.append(remove.getRequestSsoSeq());
                                sb6.append(" uin:");
                                sb6.append(MsfSdkUtils.getShortUin(remove.getUin()));
                                sb6.append(" cmd=");
                                sb6.append(com.tencent.mobileqq.msf.core.z.a.a(serviceCmd));
                                sb6.append(" costTime:");
                                str = "MSF.C.NetConnTag.";
                                sb6.append(remove.getTimeout());
                                sb6.append(NetConnInfoCenter.getSignalStrengthsLog());
                                sb6.append(" code:");
                                sb6.append(1002);
                                sb6.append(" failMsg:");
                                sb6.append("wait serverResp timeout");
                                sb6.append(" socketFd:");
                                sb6.append(i3);
                                sb6.append(" remainRecvBuffSize:");
                                sb6.append(i17);
                                sb6.append(" receiveBufferSize:");
                                sb6.append(i16);
                                str2 = str;
                                QLog.d(str2, 1, sb6.toString());
                            }
                            FromServiceMsg a16 = o.a(remove);
                            a16.setBusinessFail(1002, "wait serverResp timeout");
                            if (this.f248692c.a(remove, a16)) {
                                try {
                                    MsfService.getCore().getSsoRespHandler().a(remove, a16);
                                    this.f248692c.E.a(remove, a16);
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                }
                            }
                            if (MsfService.getCore().getStatReporter() != null && remove.isSupportRetry()) {
                                MsfService.getCore().getStatReporter().d(false);
                            }
                        } catch (Exception e17) {
                            e = e17;
                            QLog.d(str2, 1, "got fail msg. " + e, e);
                        }
                    } catch (Exception e18) {
                        e = e18;
                        str2 = str;
                        QLog.d(str2, 1, "got fail msg. " + e, e);
                    }
                }
            } catch (Exception e19) {
                e = e19;
                QLog.d(str2, 1, "got fail msg. " + e, e);
            }
        }

        public e(ToServiceMsg toServiceMsg, d dVar, t tVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, n.this, toServiceMsg, dVar, tVar);
                return;
            }
            this.f248691b = toServiceMsg;
            this.f248690a = dVar;
            this.f248692c = tVar;
        }
    }

    public Runnable a(int i3, long j3, t tVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Runnable) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3), tVar);
        }
        a aVar = new a(i3, tVar);
        this.f248683a.postDelayed(aVar, j3);
        return aVar;
    }

    public Runnable b(ToServiceMsg toServiceMsg, long j3, t tVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Runnable) iPatchRedirector.redirect((short) 3, this, toServiceMsg, Long.valueOf(j3), tVar);
        }
        e eVar = new e(toServiceMsg, tVar);
        if (toServiceMsg != null) {
            this.f248683a.postDelayed(eVar, j3);
        }
        return eVar;
    }

    public Runnable a(com.tencent.mobileqq.msf.core.net.o oVar, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Runnable) iPatchRedirector.redirect((short) 6, this, oVar, Long.valueOf(j3));
        }
        if (oVar == null) {
            return null;
        }
        f fVar = new f(oVar);
        this.f248683a.postDelayed(fVar, j3);
        return fVar;
    }

    public void b(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.f248683a.removeCallbacks(runnable);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) runnable);
        }
    }

    public Handler a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? this.f248683a : (Handler) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public Runnable b(int i3, long j3, t tVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Runnable) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Long.valueOf(j3), tVar);
        }
        c cVar = new c(i3, tVar);
        this.f248683a.postDelayed(cVar, j3);
        return cVar;
    }

    public void a(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            this.f248683a.removeCallbacks(runnable);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) runnable);
        }
    }

    public Runnable a(ToServiceMsg toServiceMsg, long j3, t tVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Runnable) iPatchRedirector.redirect((short) 11, this, toServiceMsg, Long.valueOf(j3), tVar);
        }
        b bVar = new b(toServiceMsg, tVar);
        if (toServiceMsg != null) {
            this.f248683a.postDelayed(bVar, j3);
        }
        return bVar;
    }
}
