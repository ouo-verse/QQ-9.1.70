package com.tencent.mobileqq.shortvideo.dancemachine;

import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class Color4f {
    public static final Color4f BLACK = new Color4f(0.0f, 0.0f, 0.0f, 1.0f);
    public static final Color4f WHITE = new Color4f(1.0f, 1.0f, 1.0f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    private float f287850a;

    /* renamed from: b, reason: collision with root package name */
    private float f287851b;

    /* renamed from: g, reason: collision with root package name */
    private float f287852g;

    /* renamed from: r, reason: collision with root package name */
    private float f287853r;

    public Color4f(float f16, float f17, float f18, float f19) {
        this.f287853r = f16;
        this.f287852g = f17;
        this.f287851b = f18;
        this.f287850a = f19;
    }

    public float getAlpha() {
        return this.f287850a;
    }

    public float getBlue() {
        return this.f287851b;
    }

    public float getGreen() {
        return this.f287852g;
    }

    public float[] getPremultipliedRGBComponents() {
        float f16 = this.f287853r;
        float f17 = this.f287850a;
        return new float[]{f16 * f17, this.f287852g * f17, this.f287851b * f17, f17};
    }

    public float getRed() {
        return this.f287853r;
    }

    public void putValue(FloatBuffer floatBuffer) {
        floatBuffer.put(this.f287853r);
        floatBuffer.put(this.f287852g);
        floatBuffer.put(this.f287851b);
        floatBuffer.put(this.f287850a);
    }

    public void setValue(float f16, float f17, float f18, float f19) {
        this.f287853r = f16;
        this.f287852g = f17;
        this.f287851b = f18;
        this.f287850a = f19;
    }
}
