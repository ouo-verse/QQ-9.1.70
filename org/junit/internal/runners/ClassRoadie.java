package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class ClassRoadie {
    private Description description;
    private RunNotifier notifier;
    private final Runnable runnable;
    private TestClass testClass;

    public ClassRoadie(RunNotifier runNotifier, TestClass testClass, Description description, Runnable runnable) {
        this.notifier = runNotifier;
        this.testClass = testClass;
        this.description = description;
        this.runnable = runnable;
    }

    private void runAfters() {
        Iterator<Method> it = this.testClass.getAfters().iterator();
        while (it.hasNext()) {
            try {
                it.next().invoke(null, new Object[0]);
            } catch (InvocationTargetException e16) {
                addFailure(e16.getTargetException());
            } catch (Throwable th5) {
                addFailure(th5);
            }
        }
    }

    private void runBefores() throws FailedBefore {
        try {
            try {
                Iterator<Method> it = this.testClass.getBefores().iterator();
                while (it.hasNext()) {
                    it.next().invoke(null, new Object[0]);
                }
            } catch (AssumptionViolatedException unused) {
                throw new FailedBefore();
            } catch (Throwable th5) {
                addFailure(th5);
                throw new FailedBefore();
            }
        } catch (InvocationTargetException e16) {
            throw e16.getTargetException();
        }
    }

    protected void addFailure(Throwable th5) {
        this.notifier.fireTestFailure(new Failure(this.description, th5));
    }

    public void runProtected() {
        try {
            runBefores();
            runUnprotected();
        } catch (FailedBefore unused) {
        } catch (Throwable th5) {
            runAfters();
            throw th5;
        }
        runAfters();
    }

    protected void runUnprotected() {
        this.runnable.run();
    }
}
