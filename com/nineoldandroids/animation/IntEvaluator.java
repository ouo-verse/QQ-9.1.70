package com.nineoldandroids.animation;

/* compiled from: P */
/* loaded from: classes2.dex */
public class IntEvaluator implements TypeEvaluator<Integer> {
    @Override // com.nineoldandroids.animation.TypeEvaluator
    public Integer evaluate(float f16, Integer num, Integer num2) {
        return Integer.valueOf((int) (num.intValue() + (f16 * (num2.intValue() - r3))));
    }
}
