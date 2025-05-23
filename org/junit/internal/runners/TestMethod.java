package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class TestMethod {
    private final Method method;
    private TestClass testClass;

    public TestMethod(Method method, TestClass testClass) {
        this.method = method;
        this.testClass = testClass;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean expectsException() {
        if (getExpectedException() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Method> getAfters() {
        return this.testClass.getAnnotatedMethods(After.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Method> getBefores() {
        return this.testClass.getAnnotatedMethods(Before.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Class<? extends Throwable> getExpectedException() {
        Test test = (Test) this.method.getAnnotation(Test.class);
        if (test != null && test.expected() != Test.None.class) {
            return test.expected();
        }
        return null;
    }

    public long getTimeout() {
        Test test = (Test) this.method.getAnnotation(Test.class);
        if (test == null) {
            return 0L;
        }
        return test.timeout();
    }

    public void invoke(Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        this.method.invoke(obj, new Object[0]);
    }

    public boolean isIgnored() {
        if (this.method.getAnnotation(Ignore.class) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isUnexpected(Throwable th5) {
        return !getExpectedException().isAssignableFrom(th5.getClass());
    }
}
