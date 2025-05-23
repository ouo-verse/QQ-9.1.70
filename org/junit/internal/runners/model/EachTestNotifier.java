package org.junit.internal.runners.model;

import java.util.Iterator;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

/* compiled from: P */
/* loaded from: classes29.dex */
public class EachTestNotifier {
    private final Description description;
    private final RunNotifier notifier;

    public EachTestNotifier(RunNotifier runNotifier, Description description) {
        this.notifier = runNotifier;
        this.description = description;
    }

    private void addMultipleFailureException(org.junit.runners.model.MultipleFailureException multipleFailureException) {
        Iterator<Throwable> it = multipleFailureException.getFailures().iterator();
        while (it.hasNext()) {
            addFailure(it.next());
        }
    }

    public void addFailedAssumption(AssumptionViolatedException assumptionViolatedException) {
        this.notifier.fireTestAssumptionFailed(new Failure(this.description, assumptionViolatedException));
    }

    public void addFailure(Throwable th5) {
        if (th5 instanceof org.junit.runners.model.MultipleFailureException) {
            addMultipleFailureException((org.junit.runners.model.MultipleFailureException) th5);
        } else {
            this.notifier.fireTestFailure(new Failure(this.description, th5));
        }
    }

    public void fireTestFinished() {
        this.notifier.fireTestFinished(this.description);
    }

    public void fireTestIgnored() {
        this.notifier.fireTestIgnored(this.description);
    }

    public void fireTestStarted() {
        this.notifier.fireTestStarted(this.description);
    }
}
