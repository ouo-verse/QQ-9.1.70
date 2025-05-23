package org.junit.internal.matchers;

import java.lang.Throwable;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ThrowableMessageMatcher<T extends Throwable> extends org.hamcrest.TypeSafeMatcher<T> {
    private final Matcher<String> matcher;

    public ThrowableMessageMatcher(Matcher<String> matcher) {
        this.matcher = matcher;
    }

    @Factory
    public static <T extends Throwable> Matcher<T> hasMessage(Matcher<String> matcher) {
        return new ThrowableMessageMatcher(matcher);
    }

    public void describeTo(Description description) {
        description.appendText("exception with message ");
        description.appendDescriptionOf(this.matcher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void describeMismatchSafely(T t16, Description description) {
        description.appendText("message ");
        this.matcher.describeMismatch(t16.getMessage(), description);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean matchesSafely(T t16) {
        return this.matcher.matches(t16.getMessage());
    }
}
