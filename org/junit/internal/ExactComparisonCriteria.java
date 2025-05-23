package org.junit.internal;

import org.junit.Assert;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ExactComparisonCriteria extends ComparisonCriteria {
    @Override // org.junit.internal.ComparisonCriteria
    protected void assertElementsEqual(Object obj, Object obj2) {
        Assert.assertEquals(obj, obj2);
    }
}
