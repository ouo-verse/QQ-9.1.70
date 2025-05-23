package com.tencent.ditto.reflect;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoConditionOperatorValue extends DittoValue {
    DittoValue conditionValue = null;
    DittoValue trueValue = null;
    DittoValue falseValue = null;

    private DittoValue getResultField(Object obj) {
        boolean z16;
        Object value = this.conditionValue.getValue(obj);
        if (value instanceof Boolean) {
            z16 = ((Boolean) value).booleanValue();
        } else if (!(value instanceof Number) ? value != null : ((Number) value).floatValue() != 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return this.trueValue;
        }
        return this.falseValue;
    }

    @Override // com.tencent.ditto.reflect.DittoValue
    public Object getValue(Object obj) {
        return getResultField(obj).getValue(obj);
    }

    @Override // com.tencent.ditto.reflect.DittoValue
    public void setValue(Object obj, boolean z16) {
        getResultField(obj).setValue(obj, z16);
    }

    @Override // com.tencent.ditto.reflect.DittoValue
    public void setValue(Object obj, String str) {
        getResultField(obj).setValue(obj, str);
    }
}
