package com.tencent.luggage.wxa.n6;

import android.graphics.PointF;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final float f135462a;

    /* renamed from: b, reason: collision with root package name */
    public final float f135463b;

    /* renamed from: c, reason: collision with root package name */
    public final float f135464c;

    /* renamed from: d, reason: collision with root package name */
    public final int f135465d;

    public b(float f16, PointF pointF, int i3) {
        this.f135462a = f16;
        this.f135463b = pointF.x;
        this.f135464c = pointF.y;
        this.f135465d = i3;
    }

    public PointF a() {
        return new PointF(this.f135463b, this.f135464c);
    }

    public int b() {
        return this.f135465d;
    }

    public float c() {
        return this.f135462a;
    }
}
