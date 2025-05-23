package com.tencent.mapsdk.internal;

import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ii extends ih {

    /* renamed from: k, reason: collision with root package name */
    private long f148790k;

    /* renamed from: l, reason: collision with root package name */
    private long f148791l;

    ii(float f16, float f17, float f18, float f19, long j3, long j16) {
        super(f16, f17, f18, f19, j3 + j16);
        this.f148790k = j3;
        this.f148791l = j16;
    }

    @Override // com.tencent.mapsdk.internal.ih, com.tencent.mapsdk.internal.ie
    protected final void a(GL10 gl10, long j3) {
        float f16;
        float f17;
        float f18 = ((ih) this).f148787h;
        float f19 = ((ih) this).f148786g;
        float f26 = f18 - f19;
        float f27 = this.f148789j;
        float f28 = ((ih) this).f148788i;
        float f29 = f27 - f28;
        long j16 = this.f148790k;
        if (j3 < j16) {
            float f36 = (float) j3;
            f16 = f19 + ((f26 * f36) / ((float) j16));
            f17 = f28 + ((f29 * f36) / ((float) j16));
        } else {
            float f37 = (float) (j3 - j16);
            long j17 = this.f148791l;
            f16 = f18 - ((f26 * f37) / ((float) j17));
            f17 = f27 - ((f29 * f37) / ((float) j17));
        }
        gl10.glScalef(f16, f17, 1.0f);
    }
}
