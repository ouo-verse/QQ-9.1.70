package com.microrapid.opencv;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ImageMainColorData implements Serializable {
    private static final float COLOR_MAX = 255.0f;
    private static final float COLOR_MIN = 0.0f;
    private static final float HUE_MAX = 360.0f;
    private static final float HUE_MIN = 0.0f;
    private static final float LUM_MAX = 1.0f;
    private static final float LUM_MIN = 0.0f;
    private static final float PERCENT_MAX = 100.0f;
    private static final float PERCENT_MIN = 0.0f;
    public final float area;

    /* renamed from: b, reason: collision with root package name */
    public final float f38083b;

    /* renamed from: g, reason: collision with root package name */
    public final float f38084g;

    /* renamed from: h, reason: collision with root package name */
    public final float f38085h;

    /* renamed from: l, reason: collision with root package name */
    public final float f38086l;

    /* renamed from: r, reason: collision with root package name */
    public final float f38087r;

    public ImageMainColorData(float f16, float f17, float f18, float f19, float f26, float f27) {
        this.f38087r = correctValue(f16, 0.0f, COLOR_MAX);
        this.f38084g = correctValue(f17, 0.0f, COLOR_MAX);
        this.f38083b = correctValue(f18, 0.0f, COLOR_MAX);
        this.f38086l = correctValue(f19, 0.0f, 1.0f);
        this.f38085h = correctValue(f26, 0.0f, 360.0f);
        this.area = correctValue(f27, 0.0f, 100.0f);
    }

    private static float correctValue(float f16, float f17, float f18) {
        if (f16 < f17) {
            return f17;
        }
        if (f16 > f18) {
            return f18;
        }
        return f16;
    }

    public String toString() {
        return "ImageMainColorData{r=" + this.f38087r + ", g=" + this.f38084g + ", b=" + this.f38083b + ", l=" + this.f38086l + ", h=" + this.f38085h + ", area=" + this.area + '}';
    }
}
