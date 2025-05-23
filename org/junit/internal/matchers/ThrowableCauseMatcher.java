package org.junit.internal.matchers;

import java.lang.Throwable;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ThrowableCauseMatcher<T extends Throwable> extends org.hamcrest.TypeSafeMatcher<T> {
    private final Matcher<? extends Throwable> causeMatcher;

    public ThrowableCauseMatcher(Matcher<? extends Throwable> matcher) {
        this.causeMatcher = matcher;
    }

    @Factory
    public static <T extends Throwable> Matcher<T> hasCause(Matcher<? extends Throwable> matcher) {
        return new ThrowableCauseMatcher(matcher);
    }

    public void describeTo(Description description) {
        description.appendText("exception with cause ");
        description.appendDescriptionOf(this.causeMatcher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void describeMismatchSafely(T t16, Description description) {
        description.appendText("cause ");
        this.causeMatcher.describeMismatch(t16.getCause(), description);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean matchesSafely(T t16) {
        return this.causeMatcher.matches(t16.getCause());
    }
}
