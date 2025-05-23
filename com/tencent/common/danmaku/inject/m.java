package com.tencent.common.danmaku.inject;

import android.util.DisplayMetrics;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f99733r;

    /* renamed from: a, reason: collision with root package name */
    private int f99734a;

    /* renamed from: b, reason: collision with root package name */
    private int f99735b;

    /* renamed from: c, reason: collision with root package name */
    private int f99736c;

    /* renamed from: d, reason: collision with root package name */
    private int f99737d;

    /* renamed from: e, reason: collision with root package name */
    private int f99738e;

    /* renamed from: f, reason: collision with root package name */
    private float f99739f;

    /* renamed from: g, reason: collision with root package name */
    private float f99740g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f99741h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f99742i;

    /* renamed from: j, reason: collision with root package name */
    private int f99743j;

    /* renamed from: k, reason: collision with root package name */
    private int f99744k;

    /* renamed from: l, reason: collision with root package name */
    private float f99745l;

    /* renamed from: m, reason: collision with root package name */
    private float f99746m;

    /* renamed from: n, reason: collision with root package name */
    private float f99747n;

    /* renamed from: o, reason: collision with root package name */
    private float f99748o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f99749p;

    /* renamed from: q, reason: collision with root package name */
    private int f99750q;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9760);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            f99733r = true;
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f99741h = true;
        this.f99749p = false;
        this.f99750q = 60;
        DisplayMetrics displayMetrics = com.tencent.common.danmaku.a.b().a().e().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        if (this.f99749p) {
            this.f99744k = Math.max(i3, i16);
            this.f99743j = Math.min(i3, i16);
        } else {
            this.f99744k = Math.min(i3, i16);
            this.f99743j = Math.max(i3, i16);
        }
        v(8000);
        F(12);
        B(3);
        y(1.5f);
        x(1);
        s(5.0f);
        t(5.0f);
        r(true);
        u(true);
        D(16.0f);
        q(0.0f);
        A(5.0f);
        z(4.0f);
    }

    public static boolean p() {
        return f99733r;
    }

    public static void w(boolean z16) {
        f99733r = z16;
    }

    public void A(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Float.valueOf(f16));
        } else {
            this.f99747n = com.tencent.common.danmaku.util.c.b(f16);
        }
    }

    public void B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f99736c = i3;
        }
    }

    public void C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
        } else {
            this.f99743j = i3;
        }
    }

    public void D(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Float.valueOf(f16));
        } else {
            this.f99745l = com.tencent.common.danmaku.util.c.b(f16);
        }
    }

    public void E(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, z16);
            return;
        }
        if (this.f99749p != z16) {
            int i3 = this.f99743j;
            this.f99743j = this.f99744k;
            this.f99744k = i3;
        }
        this.f99749p = z16;
    }

    public void F(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f99735b = com.tencent.common.danmaku.util.c.b(i3);
        }
    }

    public float a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Float) iPatchRedirector.redirect((short) 25, (Object) this)).floatValue();
        }
        return this.f99746m;
    }

    public float b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Float) iPatchRedirector.redirect((short) 15, (Object) this)).floatValue();
        }
        return this.f99739f;
    }

    public float c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Float) iPatchRedirector.redirect((short) 13, (Object) this)).floatValue();
        }
        return this.f99740g;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f99734a;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.f99738e;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f99737d;
    }

    public float g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Float) iPatchRedirector.redirect((short) 29, (Object) this)).floatValue();
        }
        return this.f99748o;
    }

    public float h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Float) iPatchRedirector.redirect((short) 27, (Object) this)).floatValue();
        }
        return this.f99747n;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f99736c;
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.f99744k;
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.f99743j;
    }

    public float l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Float) iPatchRedirector.redirect((short) 23, (Object) this)).floatValue();
        }
        return this.f99745l;
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f99735b;
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.f99741h;
    }

    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.f99742i;
    }

    public void q(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Float.valueOf(f16));
        } else {
            this.f99746m = f16;
        }
    }

    public void r(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.f99741h = z16;
        }
    }

    public void s(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        } else {
            this.f99739f = com.tencent.common.danmaku.util.c.b(f16);
        }
    }

    public void t(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
        } else {
            this.f99740g = com.tencent.common.danmaku.util.c.b(f16);
        }
    }

    public void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.f99742i = z16;
        }
    }

    public void v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f99734a = i3;
        }
    }

    public void x(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.f99738e = com.tencent.common.danmaku.util.c.b(i3);
        }
    }

    public void y(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.f99737d = com.tencent.common.danmaku.util.c.b(f16);
        }
    }

    public void z(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Float.valueOf(f16));
        } else {
            this.f99748o = com.tencent.common.danmaku.util.c.b(f16);
        }
    }
}
