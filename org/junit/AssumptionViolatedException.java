package org.junit;

import org.hamcrest.Matcher;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AssumptionViolatedException extends org.junit.internal.AssumptionViolatedException {
    private static final long serialVersionUID = 1;

    public <T> AssumptionViolatedException(T t16, Matcher<T> matcher) {
        super((Object) t16, (Matcher<?>) matcher);
    }

    public <T> AssumptionViolatedException(String str, T t16, Matcher<T> matcher) {
        super(str, t16, matcher);
    }

    public AssumptionViolatedException(String str) {
        super(str);
    }

    public AssumptionViolatedException(String str, Throwable th5) {
        super(str, th5);
    }
}
