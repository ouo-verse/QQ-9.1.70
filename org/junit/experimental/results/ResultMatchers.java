package org.junit.experimental.results;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ResultMatchers {
    public static Matcher<PrintableResult> failureCountIs(final int i3) {
        return new TypeSafeMatcher<PrintableResult>() { // from class: org.junit.experimental.results.ResultMatchers.1
            public void describeTo(Description description) {
                description.appendText("has " + i3 + " failures");
            }

            public boolean matchesSafely(PrintableResult printableResult) {
                return printableResult.failureCount() == i3;
            }
        };
    }

    public static Matcher<PrintableResult> hasFailureContaining(final String str) {
        return new BaseMatcher<PrintableResult>() { // from class: org.junit.experimental.results.ResultMatchers.3
            public void describeTo(Description description) {
                description.appendText("has failure containing " + str);
            }

            public boolean matches(Object obj) {
                return obj.toString().contains(str);
            }
        };
    }

    public static Matcher<Object> hasSingleFailureContaining(final String str) {
        return new BaseMatcher<Object>() { // from class: org.junit.experimental.results.ResultMatchers.2
            public void describeTo(Description description) {
                description.appendText("has single failure containing " + str);
            }

            public boolean matches(Object obj) {
                if (obj.toString().contains(str) && ResultMatchers.failureCountIs(1).matches(obj)) {
                    return true;
                }
                return false;
            }
        };
    }

    public static Matcher<PrintableResult> isSuccessful() {
        return failureCountIs(0);
    }
}
