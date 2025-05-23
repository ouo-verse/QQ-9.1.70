package com.tencent.mapsdk.internal;

import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* renamed from: com.tencent.mapsdk.internal.if, reason: invalid class name */
/* loaded from: classes9.dex */
public final class Cif extends ie {

    /* renamed from: g, reason: collision with root package name */
    private float f148783g;

    /* renamed from: h, reason: collision with root package name */
    private float f148784h;

    Cif(float f16, float f17, long j3) {
        super(j3);
        this.f148783g = f16;
        this.f148784h = f17;
    }

    @Override // com.tencent.mapsdk.internal.ie
    protected final void a(GL10 gl10, long j3) {
        float f16 = this.f148784h;
        float f17 = this.f148783g;
        float f18 = f17 + (((f16 - f17) * ((float) j3)) / ((float) this.f148778e));
        gl10.glColor4f(f18, f18, f18, f18);
    }
}
