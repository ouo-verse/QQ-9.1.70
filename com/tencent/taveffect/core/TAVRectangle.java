package com.tencent.taveffect.core;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVRectangle {
    public float height;
    public float width;

    /* renamed from: x, reason: collision with root package name */
    public float f374471x;

    /* renamed from: y, reason: collision with root package name */
    public float f374472y;

    public TAVRectangle() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public String toString() {
        return "TAVRectangle{x=" + this.f374471x + ", y=" + this.f374472y + ", width=" + this.width + ", height=" + this.height + '}';
    }

    public TAVRectangle(float f16, float f17, float f18, float f19) {
        this.f374471x = f16;
        this.f374472y = f17;
        this.width = f18;
        this.height = f19;
    }
}
