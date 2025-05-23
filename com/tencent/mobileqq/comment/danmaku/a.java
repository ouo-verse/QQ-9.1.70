package com.tencent.mobileqq.comment.danmaku;

import android.content.Context;
import android.view.View;
import com.tencent.common.danmaku.core.DanmakuManager;
import com.tencent.common.danmaku.inject.b;
import com.tencent.common.danmaku.inject.g;
import com.tencent.common.danmaku.inject.l;
import com.tencent.common.danmaku.inject.m;
import com.tencent.common.danmaku.tool.h;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements DanmakuManager.e {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final String f201770e;

    /* renamed from: f, reason: collision with root package name */
    private static final l.a f201771f;

    /* renamed from: a, reason: collision with root package name */
    private DanmakuManager f201772a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.comment.danmaku.b f201773b;

    /* renamed from: c, reason: collision with root package name */
    private c f201774c;

    /* renamed from: d, reason: collision with root package name */
    private m f201775d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.comment.danmaku.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C7463a implements l.a {
        static IPatchRedirector $redirector_;

        C7463a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.common.danmaku.inject.l.a
        public void d(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.d(a.f201770e, 2, str2);
            }
        }

        @Override // com.tencent.common.danmaku.inject.l.a
        public void e(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.e(a.f201770e, 2, str2);
            }
        }

        @Override // com.tencent.common.danmaku.inject.l.a
        public void i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.i(a.f201770e, 2, str2);
            }
        }

        @Override // com.tencent.common.danmaku.inject.l.a
        public void v(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.d(a.f201770e, 2, str2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements g {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.common.danmaku.inject.g
        public long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            if (a.this.f201774c != null) {
                return a.this.f201774c.e();
            }
            return 0L;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22455);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            f201770e = a.class.getSimpleName();
            f201771f = new C7463a();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.common.danmaku.core.DanmakuManager.e
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        com.tencent.mobileqq.comment.danmaku.b bVar = this.f201773b;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.tencent.common.danmaku.core.DanmakuManager.e
    public void b(List<com.tencent.common.danmaku.data.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) list);
        } else if (this.f201773b != null && !l()) {
            this.f201773b.b();
        }
    }

    @Override // com.tencent.common.danmaku.core.DanmakuManager.e
    public void c(com.tencent.common.danmaku.data.a aVar, h hVar, com.tencent.common.danmaku.tool.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, aVar, hVar, bVar);
        }
    }

    @Override // com.tencent.common.danmaku.core.DanmakuManager.e
    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        }
    }

    public void g(List<com.tencent.common.danmaku.data.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        if (list != null && !list.isEmpty()) {
            DanmakuManager danmakuManager = this.f201772a;
            if (danmakuManager != null) {
                danmakuManager.u(list);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f201770e, 4, "addDanmakuList danmakuList is null");
        }
    }

    public void h(DanmuItemBean danmuItemBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) danmuItemBean);
            return;
        }
        if (danmuItemBean != null && this.f201772a != null) {
            com.tencent.common.danmaku.data.a C = this.f201772a.C(-2147483647, new com.tencent.mobileqq.comment.danmaku.data.a(danmuItemBean));
            C.r0(true);
            this.f201772a.v(C);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        DanmakuManager danmakuManager = this.f201772a;
        if (danmakuManager != null) {
            danmakuManager.B();
            this.f201772a.y();
        }
    }

    public com.tencent.common.danmaku.data.a j(com.tencent.mobileqq.comment.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.common.danmaku.data.a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        }
        DanmakuManager danmakuManager = this.f201772a;
        if (danmakuManager != null && aVar != null) {
            return danmakuManager.C(-2147483647, aVar);
        }
        return null;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        DanmakuManager danmakuManager = this.f201772a;
        if (danmakuManager != null) {
            danmakuManager.q0();
            this.f201772a.G();
            this.f201772a = null;
        }
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        DanmakuManager danmakuManager = this.f201772a;
        if (danmakuManager != null && danmakuManager.Z()) {
            return true;
        }
        return false;
    }

    public void m(Context context, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) view);
            return;
        }
        m p16 = com.tencent.common.danmaku.inject.b.p();
        this.f201775d = p16;
        p16.B(3);
        this.f201775d.v(7000);
        this.f201775d.A(8.0f);
        this.f201775d.s(12.0f);
        this.f201775d.t(12.0f);
        this.f201775d.r(false);
        this.f201775d.E(true);
        b.a s16 = com.tencent.common.danmaku.inject.b.s();
        s16.s(new b());
        s16.r(-4);
        s16.l(new com.tencent.mobileqq.comment.danmaku.view.a(context));
        com.tencent.common.danmaku.inject.b m3 = s16.m();
        l.d(f201771f);
        this.f201772a = new DanmakuManager(view, m3);
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        DanmakuManager danmakuManager = this.f201772a;
        if (danmakuManager != null && danmakuManager.d0()) {
            return true;
        }
        return false;
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        DanmakuManager danmakuManager = this.f201772a;
        if (danmakuManager != null) {
            danmakuManager.m0();
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        DanmakuManager danmakuManager = this.f201772a;
        if (danmakuManager != null) {
            danmakuManager.u0();
        }
    }

    public void q(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, j3);
            return;
        }
        DanmakuManager danmakuManager = this.f201772a;
        if (danmakuManager != null) {
            danmakuManager.w0(j3);
        }
    }

    public void r(com.tencent.mobileqq.comment.danmaku.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
            return;
        }
        this.f201773b = bVar;
        DanmakuManager danmakuManager = this.f201772a;
        if (danmakuManager != null) {
            danmakuManager.A0(this);
        }
    }

    public void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        m mVar = this.f201775d;
        if (mVar != null) {
            mVar.F(i3);
            DanmakuManager danmakuManager = this.f201772a;
            if (danmakuManager != null) {
                danmakuManager.k0();
            }
        }
    }

    public void t(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
        } else {
            this.f201774c = cVar;
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        DanmakuManager danmakuManager = this.f201772a;
        if (danmakuManager != null) {
            danmakuManager.C0();
        }
    }
}
