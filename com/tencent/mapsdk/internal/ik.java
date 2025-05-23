package com.tencent.mapsdk.internal;

import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ik extends ie {

    /* renamed from: g, reason: collision with root package name */
    private float f148793g;

    /* renamed from: h, reason: collision with root package name */
    private float f148794h;

    /* renamed from: i, reason: collision with root package name */
    private float f148795i;

    /* renamed from: j, reason: collision with root package name */
    private float f148796j;

    ik(float f16, float f17, float f18, float f19, long j3) {
        super(j3);
        this.f148793g = f16;
        this.f148794h = f17;
        this.f148795i = f18;
        this.f148796j = f19;
    }

    @Override // com.tencent.mapsdk.internal.ie
    protected final void a(GL10 gl10, long j3) {
        float f16 = this.f148794h;
        float f17 = this.f148793g;
        float f18 = this.f148796j;
        float f19 = this.f148795i;
        float f26 = (float) j3;
        long j16 = this.f148778e;
        gl10.glTranslatef(f17 + (((f16 - f17) * f26) / ((float) j16)), f19 + (((f18 - f19) * f26) / ((float) j16)), 0.0f);
    }
}
