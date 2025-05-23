package com.tencent.mobileqq.portal;

import android.opengl.GLES20;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static int f259380e;

    /* renamed from: f, reason: collision with root package name */
    public static int f259381f;

    /* renamed from: g, reason: collision with root package name */
    public static int f259382g;

    /* renamed from: h, reason: collision with root package name */
    public static int f259383h;

    /* renamed from: a, reason: collision with root package name */
    public int f259384a;

    /* renamed from: b, reason: collision with root package name */
    public int f259385b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f259386c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, Integer> f259387d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73621);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f259380e = 0;
        f259381f = 1;
        f259382g = 2;
        f259383h = 3;
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f259384a = 0;
        this.f259385b = 0;
        this.f259386c = new int[1];
        this.f259387d = new HashMap<>();
    }

    private void a(float f16, String str) {
        int intValue = this.f259387d.get(str).intValue();
        if (intValue >= 0) {
            GLES20.glUniform1f(intValue, f16);
        }
    }

    private void b(int i3) {
        float f16 = new float[]{1.0f, 1.0f, 0.95f, 0.9f}[i3];
        if (i3 == f259383h) {
            f16 = 1.1f;
        } else if (i3 == f259382g) {
            f16 = 1.0f;
        }
        a(f16, CustomImageProps.QUALITY);
        a(0.0f, "add_red");
        a(0.0f, "red_m");
        a(0.0f, "green_m");
        a(0.0f, "blue_m");
    }

    private void c(float f16, float f17, float f18, float f19, float f26, float f27, float f28) {
        a(f16, "percent1");
        a(f17, "percent2");
        a(f18, "percent3");
        a(f19, "percent4");
        a(f26, "percent5");
        a(f27, "percent6");
        a(f28, "percent7");
    }

    public void d(int i3) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        float f28;
        float f29;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (i3 == f259381f) {
            f27 = 0.455f;
            f28 = 0.17f;
            f29 = 0.177f;
        } else {
            if (i3 == f259382g) {
                f27 = 0.62f;
                f17 = 0.375f;
                f18 = 0.07f;
                f19 = 0.125f;
                f26 = 0.26f;
                f16 = f27;
                c(0.0f, f16, f17, f18, 0.0f, f19, f26);
                b(i3);
            }
            if (i3 == f259383h) {
                f27 = 0.824f;
                f28 = 0.461f;
                f29 = 0.152f;
            } else {
                f16 = 0.0f;
                f17 = 0.0f;
                f18 = 0.0f;
                f19 = 0.0f;
                f26 = 0.0f;
                c(0.0f, f16, f17, f18, 0.0f, f19, f26);
                b(i3);
            }
        }
        f19 = 0.2f;
        f26 = 0.0f;
        f17 = f28;
        f18 = f29;
        f16 = f27;
        c(0.0f, f16, f17, f18, 0.0f, f19, f26);
        b(i3);
    }
}
