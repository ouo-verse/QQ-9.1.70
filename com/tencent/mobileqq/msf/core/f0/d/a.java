package com.tencent.mobileqq.msf.core.f0.d;

import android.content.Context;
import com.tencent.mobileqq.msf.core.e0.i;
import com.tencent.mobileqq.msf.core.e0.j;
import com.tencent.mobileqq.msf.core.f0.a;
import com.tencent.mobileqq.msf.core.h;
import com.tencent.mobileqq.msf.core.n;
import com.tencent.mobileqq.msf.core.net.r.f;
import com.tencent.mobileqq.msf.core.net.s.k;
import com.tencent.mobileqq.msf.core.r;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.core.u;
import com.tencent.mobileqq.msf.core.v;
import com.tencent.mobileqq.msf.core.x.q;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements com.tencent.mobileqq.msf.core.f0.a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: l, reason: collision with root package name */
    public static final String f248311l = "LegacyNetworkServiceManager";

    /* renamed from: a, reason: collision with root package name */
    private final i f248312a;

    /* renamed from: b, reason: collision with root package name */
    private final q f248313b;

    /* renamed from: c, reason: collision with root package name */
    private h f248314c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.msf.core.i f248315d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.msf.core.quicksend.b f248316e;

    /* renamed from: f, reason: collision with root package name */
    private final d.a f248317f;

    /* renamed from: g, reason: collision with root package name */
    private final k f248318g;

    /* renamed from: h, reason: collision with root package name */
    private final n f248319h;

    /* renamed from: i, reason: collision with root package name */
    private final r.h f248320i;

    /* renamed from: j, reason: collision with root package name */
    private final u.b f248321j;

    /* renamed from: k, reason: collision with root package name */
    private final o.a f248322k;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements u.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.u.b
        public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
            f fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
                return;
            }
            if (toServiceMsg != null) {
                toServiceMsg.getAttributes().remove(MsfConstants.ATTRIBUTE_TIMEOUT_CALLBACKER);
                if (com.tencent.mobileqq.msf.core.x.e.o().a()) {
                    toServiceMsg.getAttributes().remove(MsfConstants.ATTRIBUTE_PREDETECT_TIMEOUT_CALLBACKER);
                }
                if (fromServiceMsg.getBusinessFailCode() != 1000) {
                    a.this.a(toServiceMsg, fromServiceMsg);
                }
            }
            if (i.f248005l && f.f()) {
                try {
                    QLog.d("MSF.C.NetConnTag.", 1, "recv data in socket adaptor way");
                    if (a.this.r() != null && (fVar = a.this.r().j().f250097v) != null) {
                        fVar.b().b(fromServiceMsg.getRequestSsoSeq(), false);
                    }
                } catch (Exception e16) {
                    QLog.d(a.f248311l, 1, "adaptor recv failed", e16);
                }
            }
            if (toServiceMsg != null && a.this.q() != null) {
                a.this.q().b(toServiceMsg, fromServiceMsg);
                if (a.this.q().d(toServiceMsg) && fromServiceMsg.isSuccess()) {
                    a.this.q().f249878j.a(toServiceMsg, fromServiceMsg);
                }
            }
            try {
                if (BaseConstants.CMD_MSG_PBSENDMSG.equals(fromServiceMsg.getServiceCmd())) {
                    v.a(toServiceMsg, fromServiceMsg, false);
                    a.this.f().k(toServiceMsg, fromServiceMsg, false, 0);
                    if (com.tencent.mobileqq.msf.core.x.e.o().b()) {
                        d.c.c(toServiceMsg, fromServiceMsg);
                    }
                }
            } catch (Exception e17) {
                QLog.d(a.f248311l, 1, "handler weakNet with PBSendMsg error", e17);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements o.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.service.o.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (com.tencent.mobileqq.msf.core.x.b.c()) {
                try {
                    a.this.r().j().f250097v.c().k();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(a.f248311l, 2, "failed to call adaptorcontroller foreground ", e16);
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.msf.service.o.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (com.tencent.mobileqq.msf.core.x.b.c()) {
                try {
                    a.this.r().j().f250097v.c().j();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(a.f248311l, 2, "failed to call adaptorcontroller background ", e16);
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.msf.service.o.a
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (com.tencent.mobileqq.msf.core.x.b.c()) {
                try {
                    a.this.r().j().f250097v.c().k();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(a.f248311l, 2, "failed to call adaptorcontroller foreground ", e16);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements q.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.x.q.b
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                QLog.d(a.f248311l, 1, "[onNewSsoConnChanged] switch: ", Boolean.valueOf(z16));
                a.this.a(z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC8075a f248327a;

        e(a.InterfaceC8075a interfaceC8075a) {
            this.f248327a = interfaceC8075a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) interfaceC8075a);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f248327a.a();
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248320i = new C8078a();
        this.f248321j = new b();
        this.f248322k = new c();
        this.f248312a = new i(MsfService.getCore(), this);
        this.f248313b = new q(this);
        this.f248317f = d.a.c(this);
        this.f248318g = new com.tencent.mobileqq.msf.core.net.s.i(MsfService.getCore(), this);
        this.f248319h = new n();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? this.f248312a.p() : ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.f248312a.l();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.f248312a.c();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return s().e();
    }

    public d.a f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (d.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f248317f;
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f248312a.e();
    }

    public com.tencent.mobileqq.msf.core.d h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (com.tencent.mobileqq.msf.core.d) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.f248312a.d();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.f248312a.q();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return r().j().f250076a.m();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.f248317f.o();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.f248312a.a();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return this.f248312a.r();
    }

    public h n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (h) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f248314c;
    }

    public com.tencent.mobileqq.msf.core.i o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.msf.core.i) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f248315d;
    }

    public n p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (n) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f248319h;
    }

    public com.tencent.mobileqq.msf.core.quicksend.b q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.msf.core.quicksend.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f248316e;
    }

    public i r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f248312a;
    }

    public q s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (q) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f248313b;
    }

    public k t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (k) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f248318g;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.f0.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C8078a implements r.h {
        static IPatchRedirector $redirector_;

        C8078a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.r.h
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            k t16 = a.this.t();
            if (t16 != null) {
                t16.c();
            }
        }

        @Override // com.tencent.mobileqq.msf.core.r.h
        public void b(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            } else {
                a.this.s().p();
            }
        }

        @Override // com.tencent.mobileqq.msf.core.r.h
        public void a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
                return;
            }
            k t16 = a.this.t();
            if (t16 != null) {
                t16.a(str, i3);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.r.h
        public void a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                a.this.s().q();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.r.h
        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                a.this.f().a(i3, i16);
            } else {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public boolean a(Context context, a.InterfaceC8075a interfaceC8075a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) interfaceC8075a)).booleanValue();
        }
        try {
            r.l().a(this.f248320i);
            MsfService.getCore().getSsoRespHandler().a(this.f248321j);
            o.a(this.f248322k);
            this.f248313b.k();
            this.f248319h.b();
            if (!this.f248312a.a(context)) {
                QLog.e(f248311l, 1, "Sender init fail");
                return false;
            }
            this.f248312a.a((com.tencent.mobileqq.msf.core.e0.e) com.tencent.mobileqq.msf.core.e0.h.a());
            this.f248312a.a((com.tencent.mobileqq.msf.core.e0.d) com.tencent.mobileqq.msf.core.e0.h.a());
            com.tencent.mobileqq.msf.core.e0.a aVar = new com.tencent.mobileqq.msf.core.e0.a();
            this.f248312a.a((com.tencent.mobileqq.msf.core.e0.e) aVar);
            this.f248312a.a((com.tencent.mobileqq.msf.core.e0.d) aVar);
            this.f248312a.a(com.tencent.mobileqq.msf.core.i0.d.a.b());
            com.tencent.mobileqq.msf.core.e0.b bVar = new com.tencent.mobileqq.msf.core.e0.b();
            this.f248312a.a((com.tencent.mobileqq.msf.core.e0.e) bVar);
            this.f248312a.a((com.tencent.mobileqq.msf.core.e0.d) bVar);
            this.f248312a.a(new j(this));
            this.f248313b.a(new d());
            this.f248314c = new h(MsfService.getCore(), this);
            if (com.tencent.mobileqq.msf.core.quicksend.b.e()) {
                this.f248315d = new com.tencent.mobileqq.msf.core.i(MsfService.getCore(), context, this);
            }
            this.f248316e = new com.tencent.mobileqq.msf.core.quicksend.b(MsfService.getCore(), this);
            com.tencent.mobileqq.msf.core.q.s().post(new e(interfaceC8075a));
            return true;
        } catch (Exception e16) {
            QLog.e(f248311l, 1, "LegacyNetworkServiceManager error", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            i.b(str);
        } else {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            i.a(i3);
        } else {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public int a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (toServiceMsg == null) {
            return -1;
        }
        this.f248312a.a(toServiceMsg);
        try {
            if (BaseConstants.CMD_MSG_PBSENDMSG.equals(toServiceMsg.getServiceCmd())) {
                v.a(MsfService.getCore(), toServiceMsg);
                this.f248317f.p(toServiceMsg);
            } else if (BaseConstants.CMD_NEW_REGPRXYSVC_INFOSYNC.equals(toServiceMsg.getServiceCmd())) {
                v.b(MsfService.getCore(), toServiceMsg);
            }
        } catch (Throwable th5) {
            QLog.e(f248311l, 1, "[sendSsoMsg] ", th5);
        }
        return toServiceMsg.getRequestSsoSeq();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public void a(String str, int i3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, str2);
        } else {
            CodecWarpper.nativeSetAccountKey(str, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, str2);
            t.a(str, false);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            CodecWarpper.nativeRemoveAccountKey(str);
            t.a(str, false);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public void a(com.tencent.qphone.base.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            this.f248312a.a(aVar);
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? this.f248312a.b() : ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
    }

    @Override // com.tencent.mobileqq.msf.core.f0.a
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            r().j().A();
        } else {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
        }
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
            this.f248312a.a(z16);
        } else {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063 A[Catch: Exception -> 0x0089, TRY_LEAVE, TryCatch #0 {Exception -> 0x0089, blocks: (B:2:0x0000, B:4:0x0008, B:6:0x0019, B:8:0x002a, B:10:0x003b, B:16:0x0059, B:18:0x0063), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3;
        try {
            int businessFailCode = fromServiceMsg.getBusinessFailCode();
            int intValue = ((Integer) toServiceMsg.getAttribute("reqPkgSize", 0)).intValue();
            boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("_tag_senddata_error", Boolean.FALSE)).booleanValue();
            long longValue = ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF, 0L)).longValue() - ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET, 0L)).longValue();
            if (longValue >= 0 && longValue <= TTL.MAX_VALUE) {
                j3 = longValue;
                if (MsfService.getCore().getStatReporter() == null) {
                    MsfService.getCore().getStatReporter().a(toServiceMsg.getServiceCmd(), toServiceMsg.getRequestSsoSeq(), j3, businessFailCode, toServiceMsg.getWupBuffer().length, fromServiceMsg.getWupBuffer().length, intValue, booleanValue);
                    return;
                }
                return;
            }
            j3 = 0;
            if (MsfService.getCore().getStatReporter() == null) {
            }
        } catch (Exception e16) {
            QLog.e(f248311l, 1, "reportSendError exception:", e16);
        }
    }
}
