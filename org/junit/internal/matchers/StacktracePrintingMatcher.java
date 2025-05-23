package org.junit.internal.matchers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Throwable;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/* loaded from: classes29.dex */
public class StacktracePrintingMatcher<T extends Throwable> extends org.hamcrest.TypeSafeMatcher<T> {
    private final Matcher<T> throwableMatcher;

    public StacktracePrintingMatcher(Matcher<T> matcher) {
        this.throwableMatcher = matcher;
    }

    @Factory
    public static <T extends Exception> Matcher<T> isException(Matcher<T> matcher) {
        return new StacktracePrintingMatcher(matcher);
    }

    @Factory
    public static <T extends Throwable> Matcher<T> isThrowable(Matcher<T> matcher) {
        return new StacktracePrintingMatcher(matcher);
    }

    private String readStacktrace(Throwable th5) {
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void describeTo(Description description) {
        this.throwableMatcher.describeTo(description);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void describeMismatchSafely(T t16, Description description) {
        this.throwableMatcher.describeMismatch(t16, description);
        description.appendText("\nStacktrace was: ");
        description.appendText(readStacktrace(t16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean matchesSafely(T t16) {
        return this.throwableMatcher.matches(t16);
    }
}
