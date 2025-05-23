package com.tencent.qui.video.floatingview.operate;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qui.video.floatingview.b;
import com.tencent.qui.video.floatingview.c;
import com.tencent.qui.video.floatingview.d;
import com.tencent.qui.video.floatingview.e;
import com.tencent.qui.video.floatingview.view.QUIVideoFloatViewContainer;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f363914a;

    /* renamed from: b, reason: collision with root package name */
    private final e f363915b;

    /* renamed from: c, reason: collision with root package name */
    private final c f363916c;

    /* renamed from: d, reason: collision with root package name */
    private QUIVideoFloatViewContainer f363917d;

    /* renamed from: e, reason: collision with root package name */
    private Object f363918e;

    /* renamed from: f, reason: collision with root package name */
    private b f363919f;

    /* renamed from: g, reason: collision with root package name */
    private bz3.b f363920g;

    public a(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            return;
        }
        this.f363914a = cVar.a();
        this.f363915b = new e().h(true).k(cVar.b()).l(cVar.c());
        this.f363916c = cVar;
    }

    private void k() {
        if (this.f363915b.c()) {
            this.f363917d.s();
        }
    }

    private void s() {
        a d16 = d.i().d();
        if (d16 != null && this.f363914a.equals(d16.e())) {
            d.i().h();
        }
    }

    private void t() {
        this.f363915b.h(false);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            if (this.f363917d == null) {
                return;
            }
            k();
            t();
            s();
        }
    }

    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (View) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.f363917d;
    }

    public e c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (e) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f363915b;
    }

    public void d() {
        QUIVideoFloatViewContainer qUIVideoFloatViewContainer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            if (this.f363915b.a() || (qUIVideoFloatViewContainer = this.f363917d) == null) {
                return;
            }
            qUIVideoFloatViewContainer.z();
        }
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f363914a;
    }

    public c f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (c) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f363916c;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.f363919f != null) {
            return true;
        }
        return false;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        QUIVideoFloatViewContainer qUIVideoFloatViewContainer = this.f363917d;
        if (qUIVideoFloatViewContainer == null) {
            return;
        }
        qUIVideoFloatViewContainer.T();
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        QUIVideoFloatViewContainer qUIVideoFloatViewContainer = this.f363917d;
        if (qUIVideoFloatViewContainer == null) {
            return;
        }
        qUIVideoFloatViewContainer.e0();
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        QUIVideoFloatViewContainer qUIVideoFloatViewContainer = this.f363917d;
        if (qUIVideoFloatViewContainer == null) {
            return;
        }
        qUIVideoFloatViewContainer.f0();
    }

    public void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        if (this.f363915b.a()) {
            ud0.d.a("QUIVideoFloatWindowOperator", ud0.d.f438811e, "fold status can not chang orient");
            return;
        }
        if (this.f363915b.e() == z16) {
            ud0.d.a("QUIVideoFloatWindowOperator", ud0.d.f438811e, "is same status not need to rotation");
            return;
        }
        QUIVideoFloatViewContainer qUIVideoFloatViewContainer = this.f363917d;
        if (qUIVideoFloatViewContainer == null) {
            ud0.d.a("QUIVideoFloatWindowOperator", ud0.d.f438811e, "not container view ");
        } else {
            qUIVideoFloatViewContainer.i0(z16);
        }
    }

    public a m(bz3.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        }
        this.f363920g = bVar;
        return this;
    }

    public a n(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        }
        this.f363919f = bVar;
        return this;
    }

    public void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        QUIVideoFloatViewContainer qUIVideoFloatViewContainer = this.f363917d;
        if (qUIVideoFloatViewContainer == null) {
            return;
        }
        qUIVideoFloatViewContainer.setProgress(i3);
    }

    public a p(QUIVideoFloatViewContainer qUIVideoFloatViewContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) qUIVideoFloatViewContainer);
        }
        this.f363917d = qUIVideoFloatViewContainer;
        return this;
    }

    public void q() {
        QUIVideoFloatViewContainer qUIVideoFloatViewContainer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            if (!this.f363915b.a() || (qUIVideoFloatViewContainer = this.f363917d) == null) {
                return;
            }
            qUIVideoFloatViewContainer.n0();
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        QUIVideoFloatViewContainer qUIVideoFloatViewContainer = this.f363917d;
        if (qUIVideoFloatViewContainer == null) {
            return;
        }
        qUIVideoFloatViewContainer.o0();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return "QUIVideoFloatWindowOperator{mBusinessKey='" + this.f363914a + "', mStatus=" + this.f363915b + ", mConfig=" + this.f363916c + ", mView=" + this.f363917d + ", mTransInfo=" + this.f363918e + ", mError=" + this.f363919f + ", mDelegate=" + this.f363920g + '}';
    }
}
