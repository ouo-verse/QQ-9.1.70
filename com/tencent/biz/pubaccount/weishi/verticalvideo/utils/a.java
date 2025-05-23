package com.tencent.biz.pubaccount.weishi.verticalvideo.utils;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public float f82300a;

    /* renamed from: b, reason: collision with root package name */
    public float f82301b;

    /* renamed from: c, reason: collision with root package name */
    public float f82302c;

    /* renamed from: d, reason: collision with root package name */
    public float f82303d;

    public a(float f16, float f17, float f18, float f19) {
        this.f82300a = f16;
        this.f82302c = f18;
        this.f82301b = f17;
        this.f82303d = f19;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        double d16 = f16;
        return (float) ((Math.pow(1.0f - f16, 2.0d) * 3.0d * d16 * this.f82301b) + (r0 * 3.0f * Math.pow(d16, 2.0d) * this.f82303d) + Math.pow(d16, 3.0d));
    }
}
