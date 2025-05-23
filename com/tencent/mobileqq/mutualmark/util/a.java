package com.tencent.mobileqq.mutualmark.util;

import android.content.Context;
import android.util.Size;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private static int f252262m;

    /* renamed from: n, reason: collision with root package name */
    private static int f252263n;

    /* renamed from: o, reason: collision with root package name */
    private static int f252264o;

    /* renamed from: p, reason: collision with root package name */
    private static int f252265p;

    /* renamed from: q, reason: collision with root package name */
    private static int f252266q;

    /* renamed from: r, reason: collision with root package name */
    private static double f252267r;

    /* renamed from: s, reason: collision with root package name */
    private static int f252268s;

    /* renamed from: t, reason: collision with root package name */
    private static double f252269t;

    /* renamed from: u, reason: collision with root package name */
    private static double f252270u;

    /* renamed from: a, reason: collision with root package name */
    private int f252271a;

    /* renamed from: b, reason: collision with root package name */
    private int f252272b;

    /* renamed from: c, reason: collision with root package name */
    private int f252273c;

    /* renamed from: d, reason: collision with root package name */
    private int f252274d;

    /* renamed from: e, reason: collision with root package name */
    private int f252275e;

    /* renamed from: f, reason: collision with root package name */
    private int f252276f;

    /* renamed from: g, reason: collision with root package name */
    private int f252277g;

    /* renamed from: h, reason: collision with root package name */
    private int f252278h;

    /* renamed from: i, reason: collision with root package name */
    private double f252279i;

    /* renamed from: j, reason: collision with root package name */
    private int f252280j;

    /* renamed from: k, reason: collision with root package name */
    private double f252281k;

    /* renamed from: l, reason: collision with root package name */
    private double f252282l;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33278);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        f252262m = 9;
        f252263n = 1;
        f252264o = 2;
        f252265p = 2;
        f252266q = 2;
        f252267r = 1.0d;
        f252268s = 2;
        f252269t = 4.0d;
        f252270u = 0.2247191011235955d;
    }

    public a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f252271a = 0;
        this.f252272b = 0;
        this.f252273c = 0;
        this.f252274d = 0;
        this.f252275e = 0;
        this.f252276f = 0;
        this.f252277g = 0;
        this.f252278h = 0;
        this.f252279i = 0.0d;
        this.f252280j = 0;
        this.f252281k = 0.0d;
        this.f252282l = 0.0d;
        i(context);
        int i3 = this.f252277g;
        int i16 = f252262m;
        int i17 = ((i3 * i16) / (i16 + 1)) / 5;
        this.f252271a = i17;
        int i18 = (i3 / (i16 + 1)) / 4;
        this.f252272b = i18;
        int i19 = i18 * f252263n;
        this.f252273c = i19;
        this.f252274d = f252264o * i19;
        this.f252275e = f252265p * i19;
        this.f252276f = f252266q * i19;
        this.f252278h = (i17 * 3) + (i19 * 2);
        this.f252279i = i19 * f252267r;
        this.f252280j = i19 * f252268s;
        this.f252281k = i3 / f252269t;
        this.f252282l = i3 * f252270u;
    }

    private void i(Context context) {
        Size c16;
        this.f252277g = ViewUtils.getScreenWidth() - ViewUtils.dip2px(72.0f);
        if (PadUtil.a(context) != DeviceType.FOLD || !AppSetting.t(context) || !(context instanceof FragmentActivity) || (c16 = m.c((FragmentActivity) context)) == null) {
            return;
        }
        this.f252277g = c16.getWidth() - ViewUtils.dip2px(72.0f);
    }

    public double a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Double) iPatchRedirector.redirect((short) 13, (Object) this)).doubleValue();
        }
        return this.f252282l;
    }

    public double b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Double) iPatchRedirector.redirect((short) 12, (Object) this)).doubleValue();
        }
        return this.f252281k;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f252280j;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f252271a;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f252273c;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f252272b;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f252276f;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f252275e;
    }
}
