package org.junit.internal.runners.model;

import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class ReflectiveCallable {
    public Object run() throws Throwable {
        try {
            return runReflectiveCall();
        } catch (InvocationTargetException e16) {
            throw e16.getTargetException();
        }
    }

    protected abstract Object runReflectiveCall() throws Throwable;
}
