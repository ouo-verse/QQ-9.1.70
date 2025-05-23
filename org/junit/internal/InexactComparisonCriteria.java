package org.junit.internal;

import org.junit.Assert;

/* compiled from: P */
/* loaded from: classes29.dex */
public class InexactComparisonCriteria extends ComparisonCriteria {
    public Object fDelta;

    public InexactComparisonCriteria(double d16) {
        this.fDelta = Double.valueOf(d16);
    }

    @Override // org.junit.internal.ComparisonCriteria
    protected void assertElementsEqual(Object obj, Object obj2) {
        if (obj instanceof Double) {
            Assert.assertEquals(((Double) obj).doubleValue(), ((Double) obj2).doubleValue(), ((Double) this.fDelta).doubleValue());
        } else {
            Assert.assertEquals(((Float) obj).floatValue(), ((Float) obj2).floatValue(), ((Float) this.fDelta).floatValue());
        }
    }

    public InexactComparisonCriteria(float f16) {
        this.fDelta = Float.valueOf(f16);
    }
}
