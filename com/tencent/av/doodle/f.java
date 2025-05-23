package com.tencent.av.doodle;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class f extends b {

    /* renamed from: j, reason: collision with root package name */
    protected Path f73630j = new Path();

    /* renamed from: k, reason: collision with root package name */
    protected PathMeasure f73631k;

    public f() {
        this.f73631k = null;
        this.f73631k = new PathMeasure(this.f73630j, false);
    }

    @Override // com.tencent.av.doodle.b
    public void c(float f16, float f17) {
        Path path = this.f73630j;
        PointF pointF = this.f73615h;
        float f18 = pointF.x;
        float f19 = pointF.y;
        path.quadTo(f18, f19, (f16 + f18) / 2.0f, (f17 + f19) / 2.0f);
        this.f73631k.setPath(this.f73630j, false);
        h();
    }

    @Override // com.tencent.av.doodle.b
    public void f(float f16, float f17) {
        super.f(f16, f17);
        this.f73630j.reset();
        this.f73630j.moveTo(f16, f17);
        this.f73631k.setPath(this.f73630j, false);
        h();
    }

    @Override // com.tencent.av.doodle.b
    public void g(float f16, float f17) {
        PointF pointF = this.f73615h;
        pointF.x = f16;
        pointF.y = f17;
        this.f73630j.lineTo(f16, f17);
        this.f73631k.setPath(this.f73630j, false);
        h();
    }

    public abstract void h();
}
