package org.jbox2d.common;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Color3f {

    /* renamed from: x, reason: collision with root package name */
    public float f423633x;

    /* renamed from: y, reason: collision with root package name */
    public float f423634y;

    /* renamed from: z, reason: collision with root package name */
    public float f423635z;
    public static final Color3f WHITE = new Color3f(1.0f, 1.0f, 1.0f);
    public static final Color3f BLACK = new Color3f(0.0f, 0.0f, 0.0f);
    public static final Color3f BLUE = new Color3f(0.0f, 0.0f, 1.0f);
    public static final Color3f GREEN = new Color3f(0.0f, 1.0f, 0.0f);
    public static final Color3f RED = new Color3f(1.0f, 0.0f, 0.0f);

    public Color3f() {
        this.f423635z = 0.0f;
        this.f423634y = 0.0f;
        this.f423633x = 0.0f;
    }

    public void set(float f16, float f17, float f18) {
        this.f423633x = f16;
        this.f423634y = f17;
        this.f423635z = f18;
    }

    public Color3f(float f16, float f17, float f18) {
        this.f423633x = f16;
        this.f423634y = f17;
        this.f423635z = f18;
    }

    public void set(Color3f color3f) {
        this.f423633x = color3f.f423633x;
        this.f423634y = color3f.f423634y;
        this.f423635z = color3f.f423635z;
    }
}
