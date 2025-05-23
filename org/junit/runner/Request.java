package org.junit.runner;

import java.util.Comparator;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.internal.requests.ClassRequest;
import org.junit.internal.requests.FilterRequest;
import org.junit.internal.requests.SortingRequest;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.manipulation.Filter;
import org.junit.runners.model.InitializationError;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class Request {
    public static Request aClass(Class<?> cls) {
        return new ClassRequest(cls);
    }

    public static Request classWithoutSuiteMethod(Class<?> cls) {
        return new ClassRequest(cls, false);
    }

    public static Request classes(Computer computer, Class<?>... clsArr) {
        try {
            return runner(computer.getSuite(new AllDefaultPossibilitiesBuilder(true), clsArr));
        } catch (InitializationError unused) {
            throw new RuntimeException("Bug in saff's brain: Suite constructor, called as above, should always complete");
        }
    }

    public static Request errorReport(Class<?> cls, Throwable th5) {
        return runner(new ErrorReportingRunner(cls, th5));
    }

    public static Request method(Class<?> cls, String str) {
        return aClass(cls).filterWith(Description.createTestDescription(cls, str));
    }

    public static Request runner(final Runner runner) {
        return new Request() { // from class: org.junit.runner.Request.1
            @Override // org.junit.runner.Request
            public Runner getRunner() {
                return Runner.this;
            }
        };
    }

    public Request filterWith(Filter filter) {
        return new FilterRequest(this, filter);
    }

    public abstract Runner getRunner();

    public Request sortWith(Comparator<Description> comparator) {
        return new SortingRequest(this, comparator);
    }

    public Request filterWith(Description description) {
        return filterWith(Filter.matchMethodDescription(description));
    }

    public static Request classes(Class<?>... clsArr) {
        return classes(JUnitCore.defaultComputer(), clsArr);
    }
}
