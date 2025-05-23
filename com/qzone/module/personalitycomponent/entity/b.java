package com.qzone.module.personalitycomponent.entity;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b implements TypeEvaluator {
    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f16, Object obj, Object obj2) {
        PointF pointF = (PointF) obj;
        PointF pointF2 = (PointF) obj2;
        float f17 = pointF.x;
        float f18 = f17 + ((pointF2.x - f17) * f16);
        float f19 = pointF.y;
        float f26 = f19 + (f16 * (pointF2.y - f19));
        PointF pointF3 = new PointF();
        pointF3.set(f18, f26);
        return pointF3;
    }
}
