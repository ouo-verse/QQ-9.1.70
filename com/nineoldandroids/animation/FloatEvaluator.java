package com.nineoldandroids.animation;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FloatEvaluator implements TypeEvaluator<Number> {
    @Override // com.nineoldandroids.animation.TypeEvaluator
    public Float evaluate(float f16, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f16 * (number2.floatValue() - floatValue)));
    }
}
