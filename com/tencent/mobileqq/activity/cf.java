package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class cf {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public String f180634d;

    /* renamed from: e, reason: collision with root package name */
    protected a f180635e;

    /* renamed from: f, reason: collision with root package name */
    protected int f180636f;

    /* renamed from: h, reason: collision with root package name */
    protected b f180637h;

    /* renamed from: i, reason: collision with root package name */
    public QQAppInterface f180638i;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void G0(b bVar);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f180639a;

        /* renamed from: b, reason: collision with root package name */
        public String f180640b;

        /* renamed from: c, reason: collision with root package name */
        public String f180641c;

        /* renamed from: d, reason: collision with root package name */
        public int f180642d;

        /* renamed from: e, reason: collision with root package name */
        public int f180643e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f180644f;

        /* renamed from: g, reason: collision with root package name */
        public String f180645g;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public cf(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f180636f = -1;
            this.f180638i = qQAppInterface;
        }
    }

    public abstract void d(BaseActivity baseActivity);

    public abstract int e();

    public b f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f180637h;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f180636f;
    }

    public abstract b h(int i3);

    public abstract Drawable i();

    public abstract void j(b bVar);

    public abstract void k(BaseActivity baseActivity, b bVar);

    public abstract void l(BaseActivity baseActivity);

    public abstract void m(int i3);

    public void n(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f180635e = aVar;
        }
    }

    public void o(b bVar) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else if (bVar == this.f180637h && (aVar = this.f180635e) != null) {
            aVar.G0(bVar);
        }
    }
}
