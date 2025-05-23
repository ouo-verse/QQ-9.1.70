package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ErrorReportingRunner extends Runner {
    private final List<Throwable> causes;
    private final Class<?> testClass;

    public ErrorReportingRunner(Class<?> cls, Throwable th5) {
        if (cls != null) {
            this.testClass = cls;
            this.causes = getCauses(th5);
            return;
        }
        throw new NullPointerException("Test class cannot be null");
    }

    private Description describeCause(Throwable th5) {
        return Description.createTestDescription(this.testClass, "initializationError");
    }

    private List<Throwable> getCauses(Throwable th5) {
        if (th5 instanceof InvocationTargetException) {
            return getCauses(th5.getCause());
        }
        if (th5 instanceof org.junit.runners.model.InitializationError) {
            return ((org.junit.runners.model.InitializationError) th5).getCauses();
        }
        if (th5 instanceof InitializationError) {
            return ((InitializationError) th5).getCauses();
        }
        return Arrays.asList(th5);
    }

    private void runCause(Throwable th5, RunNotifier runNotifier) {
        Description describeCause = describeCause(th5);
        runNotifier.fireTestStarted(describeCause);
        runNotifier.fireTestFailure(new Failure(describeCause, th5));
        runNotifier.fireTestFinished(describeCause);
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        Description createSuiteDescription = Description.createSuiteDescription(this.testClass);
        Iterator<Throwable> it = this.causes.iterator();
        while (it.hasNext()) {
            createSuiteDescription.addChild(describeCause(it.next()));
        }
        return createSuiteDescription;
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        Iterator<Throwable> it = this.causes.iterator();
        while (it.hasNext()) {
            runCause(it.next(), runNotifier);
        }
    }
}
