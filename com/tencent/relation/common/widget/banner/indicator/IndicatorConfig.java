package com.tencent.relation.common.widget.banner.indicator;

import androidx.annotation.ColorInt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes25.dex */
public class IndicatorConfig {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f364835a;

    /* renamed from: b, reason: collision with root package name */
    private int f364836b;

    /* renamed from: c, reason: collision with root package name */
    private int f364837c;

    /* renamed from: d, reason: collision with root package name */
    private int f364838d;

    /* renamed from: e, reason: collision with root package name */
    private int f364839e;

    /* renamed from: f, reason: collision with root package name */
    private int f364840f;

    /* renamed from: g, reason: collision with root package name */
    @ColorInt
    private int f364841g;

    /* renamed from: h, reason: collision with root package name */
    @ColorInt
    private int f364842h;

    /* renamed from: i, reason: collision with root package name */
    private int f364843i;

    /* renamed from: j, reason: collision with root package name */
    private int f364844j;

    /* renamed from: k, reason: collision with root package name */
    private a f364845k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f364846l;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes25.dex */
    public @interface Direction {
        public static final int CENTER = 1;
        public static final int LEFT = 0;
        public static final int RIGHT = 2;
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f364847a;

        /* renamed from: b, reason: collision with root package name */
        public int f364848b;

        /* renamed from: c, reason: collision with root package name */
        public int f364849c;

        /* renamed from: d, reason: collision with root package name */
        public int f364850d;

        public a() {
            this(com.tencent.relation.common.widget.banner.config.a.f364826d);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public a(int i3) {
            this(i3, i3, i3, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }

        public a(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.f364847a = i3;
            this.f364848b = i16;
            this.f364849c = i17;
            this.f364850d = i18;
        }
    }

    public IndicatorConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f364837c = 1;
        this.f364838d = com.tencent.relation.common.widget.banner.config.a.f364825c;
        this.f364839e = com.tencent.relation.common.widget.banner.config.a.f364823a;
        this.f364840f = com.tencent.relation.common.widget.banner.config.a.f364824b;
        this.f364841g = -1996488705;
        this.f364842h = -2013265920;
        this.f364843i = com.tencent.relation.common.widget.banner.config.a.f364828f;
        this.f364844j = com.tencent.relation.common.widget.banner.config.a.f364827e;
        this.f364846l = true;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f364836b;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.f364837c;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f364835a;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f364838d;
    }

    public a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f364845k == null) {
            q(new a());
        }
        return this.f364845k;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f364841g;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.f364839e;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f364842h;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.f364840f;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.f364846l;
    }

    public IndicatorConfig k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 21, (Object) this, z16);
        }
        this.f364846l = z16;
        return this;
    }

    public IndicatorConfig l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        this.f364836b = i3;
        return this;
    }

    public IndicatorConfig m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 19, (Object) this, i3);
        }
        this.f364837c = i3;
        return this;
    }

    public IndicatorConfig n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 25, (Object) this, i3);
        }
        this.f364844j = i3;
        return this;
    }

    public IndicatorConfig o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        this.f364835a = i3;
        return this;
    }

    public IndicatorConfig p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        this.f364838d = i3;
        return this;
    }

    public IndicatorConfig q(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        this.f364845k = aVar;
        return this;
    }

    public IndicatorConfig r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        this.f364841g = i3;
        return this;
    }

    public IndicatorConfig s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        this.f364839e = i3;
        return this;
    }

    public IndicatorConfig t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 23, (Object) this, i3);
        }
        this.f364843i = i3;
        return this;
    }

    public IndicatorConfig u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        this.f364842h = i3;
        return this;
    }

    public IndicatorConfig v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 17, (Object) this, i3);
        }
        this.f364840f = i3;
        return this;
    }
}
