package org.junit.internal.matchers;

import java.lang.reflect.Method;
import org.hamcrest.BaseMatcher;
import org.junit.internal.MethodSorter;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public abstract class TypeSafeMatcher<T> extends BaseMatcher<T> {
    private Class<?> expectedType;

    protected TypeSafeMatcher() {
        this.expectedType = findExpectedType(getClass());
    }

    private static Class<?> findExpectedType(Class<?> cls) {
        while (cls != Object.class) {
            for (Method method : MethodSorter.getDeclaredMethods(cls)) {
                if (isMatchesSafelyMethod(method)) {
                    return method.getParameterTypes()[0];
                }
            }
            cls = cls.getSuperclass();
        }
        throw new Error("Cannot determine correct type for matchesSafely() method.");
    }

    private static boolean isMatchesSafelyMethod(Method method) {
        if (method.getName().equals("matchesSafely") && method.getParameterTypes().length == 1 && !method.isSynthetic()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean matches(Object obj) {
        if (obj != 0 && this.expectedType.isInstance(obj) && matchesSafely(obj)) {
            return true;
        }
        return false;
    }

    public abstract boolean matchesSafely(T t16);

    /* JADX WARN: Multi-variable type inference failed */
    protected TypeSafeMatcher(Class<T> cls) {
        this.expectedType = cls;
    }
}
