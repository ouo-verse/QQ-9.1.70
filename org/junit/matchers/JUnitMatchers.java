package org.junit.matchers;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.core.CombinableMatcher;
import org.junit.internal.matchers.StacktracePrintingMatcher;

/* compiled from: P */
/* loaded from: classes29.dex */
public class JUnitMatchers {
    @Deprecated
    public static <T> CombinableMatcher.CombinableBothMatcher<T> both(Matcher<? super T> matcher) {
        return CoreMatchers.both(matcher);
    }

    @Deprecated
    public static Matcher<String> containsString(String str) {
        return CoreMatchers.containsString(str);
    }

    @Deprecated
    public static <T> CombinableMatcher.CombinableEitherMatcher<T> either(Matcher<? super T> matcher) {
        return CoreMatchers.either(matcher);
    }

    @Deprecated
    public static <T> Matcher<Iterable<T>> everyItem(Matcher<T> matcher) {
        return CoreMatchers.everyItem(matcher);
    }

    @Deprecated
    public static <T> Matcher<Iterable<? super T>> hasItem(T t16) {
        return CoreMatchers.hasItem(t16);
    }

    @Deprecated
    public static <T> Matcher<Iterable<T>> hasItems(T... tArr) {
        return CoreMatchers.hasItems(tArr);
    }

    public static <T extends Exception> Matcher<T> isException(Matcher<T> matcher) {
        return StacktracePrintingMatcher.isException(matcher);
    }

    public static <T extends Throwable> Matcher<T> isThrowable(Matcher<T> matcher) {
        return StacktracePrintingMatcher.isThrowable(matcher);
    }

    @Deprecated
    public static <T> Matcher<Iterable<? super T>> hasItem(Matcher<? super T> matcher) {
        return CoreMatchers.hasItem(matcher);
    }

    @Deprecated
    public static <T> Matcher<Iterable<T>> hasItems(Matcher<? super T>... matcherArr) {
        return CoreMatchers.hasItems(matcherArr);
    }
}
