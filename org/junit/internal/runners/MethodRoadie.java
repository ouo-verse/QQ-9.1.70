package org.junit.internal.runners;

import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.TestTimedOutException;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class MethodRoadie {
    private final Description description;
    private final RunNotifier notifier;
    private final Object test;
    private TestMethod testMethod;

    public MethodRoadie(Object obj, TestMethod testMethod, RunNotifier runNotifier, Description description) {
        this.test = obj;
        this.notifier = runNotifier;
        this.description = description;
        this.testMethod = testMethod;
    }

    private void runAfters() {
        Iterator<Method> it = this.testMethod.getAfters().iterator();
        while (it.hasNext()) {
            try {
                it.next().invoke(this.test, new Object[0]);
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
                Iterator<Method> it = this.testMethod.getBefores().iterator();
                while (it.hasNext()) {
                    it.next().invoke(this.test, new Object[0]);
                }
            } catch (InvocationTargetException e16) {
                throw e16.getTargetException();
            }
        } catch (AssumptionViolatedException unused) {
            throw new FailedBefore();
        } catch (Throwable th5) {
            addFailure(th5);
            throw new FailedBefore();
        }
    }

    private void runWithTimeout(final long j3) {
        runBeforesThenTestThenAfters(new Runnable() { // from class: org.junit.internal.runners.MethodRoadie.1
            @Override // java.lang.Runnable
            public void run() {
                ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
                Future submit = newSingleThreadExecutor.submit(new Callable<Object>() { // from class: org.junit.internal.runners.MethodRoadie.1.1
                    @Override // java.util.concurrent.Callable
                    public Object call() throws Exception {
                        MethodRoadie.this.runTestMethod();
                        return null;
                    }
                });
                newSingleThreadExecutor.shutdown();
                try {
                    long j16 = j3;
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    if (!newSingleThreadExecutor.awaitTermination(j16, timeUnit)) {
                        newSingleThreadExecutor.shutdownNow();
                    }
                    submit.get(0L, timeUnit);
                } catch (TimeoutException unused) {
                    MethodRoadie.this.addFailure(new TestTimedOutException(j3, TimeUnit.MILLISECONDS));
                } catch (Exception e16) {
                    MethodRoadie.this.addFailure(e16);
                }
            }
        });
    }

    protected void addFailure(Throwable th5) {
        this.notifier.fireTestFailure(new Failure(this.description, th5));
    }

    public void run() {
        if (this.testMethod.isIgnored()) {
            this.notifier.fireTestIgnored(this.description);
            return;
        }
        this.notifier.fireTestStarted(this.description);
        try {
            long timeout = this.testMethod.getTimeout();
            if (timeout > 0) {
                runWithTimeout(timeout);
            } else {
                runTest();
            }
        } finally {
            this.notifier.fireTestFinished(this.description);
        }
    }

    public void runBeforesThenTestThenAfters(Runnable runnable) {
        try {
            try {
                runBefores();
                runnable.run();
            } catch (FailedBefore unused) {
            } catch (Exception unused2) {
                throw new RuntimeException("test should never throw an exception to this level");
            }
        } finally {
            runAfters();
        }
    }

    public void runTest() {
        runBeforesThenTestThenAfters(new Runnable() { // from class: org.junit.internal.runners.MethodRoadie.2
            @Override // java.lang.Runnable
            public void run() {
                MethodRoadie.this.runTestMethod();
            }
        });
    }

    protected void runTestMethod() {
        try {
            this.testMethod.invoke(this.test);
            if (this.testMethod.expectsException()) {
                addFailure(new AssertionError("Expected exception: " + this.testMethod.getExpectedException().getName()));
            }
        } catch (InvocationTargetException e16) {
            Throwable targetException = e16.getTargetException();
            if (targetException instanceof AssumptionViolatedException) {
                return;
            }
            if (!this.testMethod.expectsException()) {
                addFailure(targetException);
                return;
            }
            if (this.testMethod.isUnexpected(targetException)) {
                addFailure(new Exception("Unexpected exception, expected<" + this.testMethod.getExpectedException().getName() + "> but was<" + targetException.getClass().getName() + ">", targetException));
            }
        } catch (Throwable th5) {
            addFailure(th5);
        }
    }
}
