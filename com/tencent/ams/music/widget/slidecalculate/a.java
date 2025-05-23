package com.tencent.ams.music.widget.slidecalculate;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f71652a;

    /* renamed from: b, reason: collision with root package name */
    private int f71653b;

    /* renamed from: c, reason: collision with root package name */
    private Integer f71654c;

    /* renamed from: d, reason: collision with root package name */
    private Integer f71655d;

    /* renamed from: e, reason: collision with root package name */
    private int f71656e;

    /* renamed from: f, reason: collision with root package name */
    private int f71657f;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f71658a;

        /* renamed from: b, reason: collision with root package name */
        private int f71659b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f71660c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f71661d;

        /* renamed from: e, reason: collision with root package name */
        private int f71662e;

        /* renamed from: f, reason: collision with root package name */
        private int f71663f;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f71658a = 90;
            this.f71659b = 0;
            this.f71660c = null;
            this.f71661d = null;
            this.f71662e = 45;
            this.f71663f = 200;
        }

        private boolean n(int i3) {
            if (i3 >= 0 && i3 <= 360) {
                return false;
            }
            return true;
        }

        private void o() {
            if (this.f71658a == 360) {
                this.f71658a = 0;
            }
            if (this.f71659b == 360) {
                this.f71659b = 0;
            }
            Integer num = this.f71660c;
            if (num != null && num.intValue() == 360) {
                this.f71660c = 0;
            }
            Integer num2 = this.f71661d;
            if (num2 != null && num2.intValue() == 360) {
                this.f71661d = 0;
            }
        }

        public a g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            if (n(this.f71658a) || n(this.f71659b)) {
                this.f71658a = 90;
                this.f71659b = 0;
            }
            Integer num = this.f71661d;
            C0701a c0701a = null;
            if ((num == null && this.f71660c != null) || (num != null && this.f71660c == null)) {
                this.f71660c = null;
                this.f71661d = null;
            } else {
                Integer num2 = this.f71660c;
                if (num2 != null && (n(num2.intValue()) || n(this.f71661d.intValue()))) {
                    this.f71660c = null;
                    this.f71661d = null;
                }
            }
            if (n(this.f71662e)) {
                this.f71662e = 45;
            }
            if (this.f71663f < 0) {
                this.f71663f = 200;
            }
            o();
            return new a(this, c0701a);
        }

        public b h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.f71658a = i3;
            return this;
        }

        public b i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (b) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            this.f71659b = i3;
            return this;
        }

        public b j(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) num);
            }
            this.f71660c = num;
            return this;
        }

        public b k(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) num);
            }
            this.f71661d = num;
            return this;
        }

        public b l(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (b) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.f71662e = i3;
            return this;
        }

        public b m(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (b) iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            this.f71663f = i3;
            return this;
        }
    }

    /* synthetic */ a(b bVar, C0701a c0701a) {
        this(bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar, (Object) c0701a);
    }

    private void g(int i3) {
        this.f71652a = i3;
    }

    private void h(int i3) {
        this.f71653b = i3;
    }

    private void i(Integer num) {
        this.f71654c = num;
    }

    private void j(Integer num) {
        this.f71655d = num;
    }

    private void k(int i3) {
        this.f71656e = i3;
    }

    private void l(int i3) {
        this.f71657f = i3;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f71652a;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f71653b;
    }

    public Integer c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Integer) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f71654c;
    }

    public Integer d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Integer) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f71655d;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f71656e;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f71657f;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "SlideConfig{degreeA=" + this.f71652a + ", degreeB=" + this.f71653b + ", degreeC=" + this.f71654c + ", degreeD=" + this.f71655d + ", degreeN=" + this.f71656e + ", distance=" + this.f71657f + '}';
    }

    a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        g(bVar.f71658a);
        h(bVar.f71659b);
        i(bVar.f71660c);
        j(bVar.f71661d);
        k(bVar.f71662e);
        l(bVar.f71663f);
    }
}
