package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public float f291156a;

    /* renamed from: b, reason: collision with root package name */
    public float f291157b;

    /* renamed from: c, reason: collision with root package name */
    public float f291158c;

    /* renamed from: d, reason: collision with root package name */
    public int f291159d;

    /* renamed from: e, reason: collision with root package name */
    public int f291160e;

    /* renamed from: f, reason: collision with root package name */
    public int f291161f;

    /* renamed from: g, reason: collision with root package name */
    public int f291162g;

    /* renamed from: h, reason: collision with root package name */
    public int f291163h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f291164i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f291165j;

    /* renamed from: k, reason: collision with root package name */
    protected long f291166k;

    /* renamed from: l, reason: collision with root package name */
    protected long f291167l;

    /* renamed from: m, reason: collision with root package name */
    private InterfaceC8631a f291168m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.surfaceviewaction.action.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC8631a {
        void a();
    }

    public a(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f291156a = 0.0f;
        this.f291157b = 0.0f;
        this.f291158c = 1.0f;
        this.f291159d = 255;
        this.f291160e = 0;
        this.f291164i = false;
        this.f291165j = false;
        this.f291161f = i3;
        this.f291162g = i16;
        this.f291163h = i17;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i3, float f16) {
        InterfaceC8631a interfaceC8631a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Float.valueOf(f16));
        } else if (i3 >= this.f291161f && (interfaceC8631a = this.f291168m) != null) {
            interfaceC8631a.a();
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f291167l = System.currentTimeMillis();
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f291166k += System.currentTimeMillis() - this.f291167l;
        }
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f291165j) {
            return false;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.f291166k);
        float f16 = currentTimeMillis;
        int i3 = this.f291161f;
        float f17 = f16 / i3;
        int i16 = this.f291163h;
        if (i16 == 1) {
            f17 = (currentTimeMillis * currentTimeMillis) / (i3 * i3);
        } else if (i16 == 2) {
            float f18 = f16 / i3;
            f17 = f18 * (2.0f - f18);
        }
        a(currentTimeMillis, f17);
        if (currentTimeMillis >= this.f291161f) {
            g();
        }
        return true;
    }

    public void e(InterfaceC8631a interfaceC8631a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) interfaceC8631a);
        } else {
            this.f291168m = interfaceC8631a;
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f291165j = false;
            this.f291166k = System.currentTimeMillis();
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f291165j = true;
        }
    }
}
