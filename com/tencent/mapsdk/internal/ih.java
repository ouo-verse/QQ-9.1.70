package com.tencent.mapsdk.internal;

import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ih extends ie {

    /* renamed from: g, reason: collision with root package name */
    protected float f148786g;

    /* renamed from: h, reason: collision with root package name */
    protected float f148787h;

    /* renamed from: i, reason: collision with root package name */
    protected float f148788i;

    /* renamed from: j, reason: collision with root package name */
    protected float f148789j;

    public ih(float f16, float f17, float f18, float f19, long j3) {
        super(j3);
        this.f148786g = f16;
        this.f148787h = f17;
        this.f148788i = f18;
        this.f148789j = f19;
    }

    @Override // com.tencent.mapsdk.internal.ie
    protected void a(GL10 gl10, long j3) {
        float f16 = this.f148787h;
        float f17 = this.f148786g;
        float f18 = this.f148789j;
        float f19 = this.f148788i;
        float f26 = (float) j3;
        long j16 = this.f148778e;
        gl10.glScalef(f17 + (((f16 - f17) * f26) / ((float) j16)), f19 + (((f18 - f19) * f26) / ((float) j16)), 1.0f);
    }
}
