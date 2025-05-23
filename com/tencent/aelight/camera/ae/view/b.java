package com.tencent.aelight.camera.ae.view;

import android.graphics.Color;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {
    public static final b A;
    public static final b B;
    public static final b C;
    public static final b[] D;

    /* renamed from: x, reason: collision with root package name */
    public static final b f65901x;

    /* renamed from: y, reason: collision with root package name */
    public static final b f65902y;

    /* renamed from: z, reason: collision with root package name */
    public static final b f65903z;

    /* renamed from: a, reason: collision with root package name */
    public final String f65904a;

    /* renamed from: b, reason: collision with root package name */
    public final int f65905b;

    /* renamed from: c, reason: collision with root package name */
    public final int f65906c;

    /* renamed from: d, reason: collision with root package name */
    public final int f65907d;

    /* renamed from: e, reason: collision with root package name */
    public final int f65908e;

    /* renamed from: f, reason: collision with root package name */
    public final int f65909f;

    /* renamed from: g, reason: collision with root package name */
    public final int f65910g;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f65911h;

    /* renamed from: i, reason: collision with root package name */
    public final int f65912i;

    /* renamed from: j, reason: collision with root package name */
    public final int f65913j;

    /* renamed from: k, reason: collision with root package name */
    public final int f65914k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f65915l;

    /* renamed from: m, reason: collision with root package name */
    public final int f65916m;

    /* renamed from: n, reason: collision with root package name */
    public final int f65917n;

    /* renamed from: o, reason: collision with root package name */
    public final int f65918o;

    /* renamed from: p, reason: collision with root package name */
    public final int f65919p;

    /* renamed from: q, reason: collision with root package name */
    public final int f65920q;

    /* renamed from: r, reason: collision with root package name */
    public final int f65921r;

    /* renamed from: s, reason: collision with root package name */
    public final int f65922s;

    /* renamed from: t, reason: collision with root package name */
    public final int f65923t;

    /* renamed from: u, reason: collision with root package name */
    public final int f65924u;

    /* renamed from: v, reason: collision with root package name */
    public final int f65925v;

    /* renamed from: w, reason: collision with root package name */
    public final int f65926w;

    static {
        b bVar = new b("1to1_light", R.drawable.mij, R.drawable.mii, R.drawable.mik, R.drawable.mih, R.drawable.mjo, R.drawable.miv, new float[]{0.0f, 1.0f}, Color.parseColor("#9095A8"), R.drawable.mio, -16777216, false, R.drawable.j4v, R.drawable.miq, R.drawable.j4t, R.drawable.j4u, R.drawable.mic, R.drawable.f160068mj1, R.drawable.f160070mj3, R.drawable.j4r, R.drawable.f160069mj2, -16777216, Color.parseColor("#7A7A8D"));
        f65901x = bVar;
        b bVar2 = new b("full_light", R.drawable.mim, R.drawable.min, R.drawable.mik, R.drawable.mil, R.drawable.mjp, R.drawable.miw, new float[]{0.0f, 1.0f}, -1, R.drawable.mip, -1, true, R.drawable.j4w, R.drawable.miq, R.drawable.j4t, R.drawable.j4u, R.drawable.mic, R.drawable.f160068mj1, R.drawable.f160070mj3, R.drawable.j4s, R.drawable.f160069mj2, -1, Color.parseColor("#E6FFFFFF"));
        f65902y = bVar2;
        f65903z = new b("4to3_no_top_margin_light", R.drawable.mij, R.drawable.mii, R.drawable.mik, R.drawable.mih, R.drawable.mjo, R.drawable.miv, new float[]{0.0f, 1.0f}, Color.parseColor("#9095A8"), R.drawable.mio, -16777216, false, R.drawable.j4w, R.drawable.miq, R.drawable.j4t, R.drawable.j4u, R.drawable.mic, R.drawable.f160068mj1, R.drawable.f160070mj3, R.drawable.j4s, R.drawable.f160069mj2, -16777216, Color.parseColor("#7A7A8D"));
        A = new b("4to3_with_top_margin_light", R.drawable.mij, R.drawable.mii, R.drawable.mik, R.drawable.mih, R.drawable.mjo, R.drawable.miv, new float[]{0.0f, 1.0f}, Color.parseColor("#9095A8"), R.drawable.mio, -16777216, false, R.drawable.j4v, R.drawable.miq, R.drawable.j4t, R.drawable.j4u, R.drawable.mic, R.drawable.f160068mj1, R.drawable.f160070mj3, R.drawable.j4s, R.drawable.f160069mj2, -16777216, Color.parseColor("#7A7A8D"));
        B = bVar;
        C = bVar2;
        D = new b[]{bVar, bVar2, bVar, bVar2};
    }

    b(String str, int i3, int i16, int i17, int i18, int i19, int i26, float[] fArr, int i27, int i28, int i29, boolean z16, int i36, int i37, int i38, int i39, int i46, int i47, int i48, int i49, int i56, int i57, int i58) {
        this.f65904a = str;
        this.f65905b = i3;
        this.f65906c = i16;
        this.f65908e = i17;
        this.f65907d = i18;
        this.f65909f = i19;
        this.f65910g = i26;
        this.f65911h = fArr;
        this.f65912i = i27;
        this.f65913j = i28;
        this.f65914k = i29;
        this.f65915l = z16;
        this.f65916m = i36;
        this.f65917n = i37;
        this.f65918o = i38;
        this.f65919p = i39;
        this.f65920q = i46;
        this.f65921r = i47;
        this.f65922s = i48;
        this.f65923t = i49;
        this.f65924u = i56;
        this.f65925v = i57;
        this.f65926w = i58;
    }

    public static float a(float f16) {
        float f17 = (f16 - 1.0f) / 0.17349994f;
        if (f17 < 0.0f) {
            return 0.0f;
        }
        if (f17 > 1.0f) {
            return 1.0f;
        }
        return f17;
    }

    public static float b(float f16) {
        float f17 = (f16 - 0.6f) / 0.39999998f;
        if (f17 < 0.0f) {
            return 0.0f;
        }
        if (f17 > 1.0f) {
            return 1.0f;
        }
        return f17;
    }
}
