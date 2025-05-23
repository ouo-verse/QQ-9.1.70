package org.junit;

import java.util.Arrays;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Assume {
    public static void assumeFalse(boolean z16) {
        assumeTrue(!z16);
    }

    public static void assumeNoException(Throwable th5) {
        assumeThat(th5, CoreMatchers.nullValue());
    }

    public static void assumeNotNull(Object... objArr) {
        assumeThat(Arrays.asList(objArr), CoreMatchers.everyItem(CoreMatchers.notNullValue()));
    }

    public static <T> void assumeThat(T t16, Matcher<T> matcher) {
        if (!matcher.matches(t16)) {
            throw new AssumptionViolatedException(t16, matcher);
        }
    }

    public static void assumeTrue(boolean z16) {
        assumeThat(Boolean.valueOf(z16), CoreMatchers.is(Boolean.TRUE));
    }

    public static void assumeFalse(String str, boolean z16) {
        assumeTrue(str, !z16);
    }

    public static void assumeNoException(String str, Throwable th5) {
        assumeThat(str, th5, CoreMatchers.nullValue());
    }

    public static void assumeTrue(String str, boolean z16) {
        if (!z16) {
            throw new AssumptionViolatedException(str);
        }
    }

    public static <T> void assumeThat(String str, T t16, Matcher<T> matcher) {
        if (!matcher.matches(t16)) {
            throw new AssumptionViolatedException(str, t16, matcher);
        }
    }
}
