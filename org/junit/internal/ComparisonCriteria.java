package org.junit.internal;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.junit.Assert;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class ComparisonCriteria {
    private int assertArraysAreSameLength(Object obj, Object obj2, String str) {
        if (obj == null) {
            Assert.fail(str + "expected array was null");
        }
        if (obj2 == null) {
            Assert.fail(str + "actual array was null");
        }
        int length = Array.getLength(obj2);
        int length2 = Array.getLength(obj);
        if (length != length2) {
            Assert.fail(str + "array lengths differed, expected.length=" + length2 + " actual.length=" + length);
        }
        return length2;
    }

    private boolean isArray(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            return true;
        }
        return false;
    }

    public void arrayEquals(String str, Object obj, Object obj2) throws ArrayComparisonFailure {
        String str2;
        if (obj != obj2) {
            if (!Arrays.deepEquals(new Object[]{obj}, new Object[]{obj2})) {
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str + MsgSummary.STR_COLON;
                }
                int assertArraysAreSameLength = assertArraysAreSameLength(obj, obj2, str2);
                for (int i3 = 0; i3 < assertArraysAreSameLength; i3++) {
                    Object obj3 = Array.get(obj, i3);
                    Object obj4 = Array.get(obj2, i3);
                    if (isArray(obj3) && isArray(obj4)) {
                        try {
                            arrayEquals(str, obj3, obj4);
                        } catch (ArrayComparisonFailure e16) {
                            e16.addDimension(i3);
                            throw e16;
                        }
                    } else {
                        try {
                            assertElementsEqual(obj3, obj4);
                        } catch (AssertionError e17) {
                            throw new ArrayComparisonFailure(str2, e17, i3);
                        }
                    }
                }
            }
        }
    }

    protected abstract void assertElementsEqual(Object obj, Object obj2);
}
