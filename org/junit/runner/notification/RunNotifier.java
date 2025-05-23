package org.junit.runner.notification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RunNotifier {
    private final List<RunListener> listeners = new CopyOnWriteArrayList();
    private volatile boolean pleaseStop = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public abstract class SafeNotifier {
        private final List<RunListener> currentListeners;

        SafeNotifier(RunNotifier runNotifier) {
            this(runNotifier.listeners);
        }

        protected abstract void notifyListener(RunListener runListener) throws Exception;

        void run() {
            int size = this.currentListeners.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (RunListener runListener : this.currentListeners) {
                try {
                    notifyListener(runListener);
                    arrayList.add(runListener);
                } catch (Exception e16) {
                    arrayList2.add(new Failure(Description.TEST_MECHANISM, e16));
                }
            }
            RunNotifier.this.fireTestFailures(arrayList, arrayList2);
        }

        SafeNotifier(List<RunListener> list) {
            this.currentListeners = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireTestFailures(List<RunListener> list, final List<Failure> list2) {
        if (!list2.isEmpty()) {
            new SafeNotifier(list) { // from class: org.junit.runner.notification.RunNotifier.4
                @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
                protected void notifyListener(RunListener runListener) throws Exception {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        runListener.testFailure((Failure) it.next());
                    }
                }
            }.run();
        }
    }

    public void addFirstListener(RunListener runListener) {
        if (runListener != null) {
            this.listeners.add(0, wrapIfNotThreadSafe(runListener));
            return;
        }
        throw new NullPointerException("Cannot add a null listener");
    }

    public void addListener(RunListener runListener) {
        if (runListener != null) {
            this.listeners.add(wrapIfNotThreadSafe(runListener));
            return;
        }
        throw new NullPointerException("Cannot add a null listener");
    }

    public void fireTestAssumptionFailed(final Failure failure) {
        new SafeNotifier() { // from class: org.junit.runner.notification.RunNotifier.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(RunNotifier.this);
            }

            @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
            protected void notifyListener(RunListener runListener) throws Exception {
                runListener.testAssumptionFailure(failure);
            }
        }.run();
    }

    public void fireTestFailure(Failure failure) {
        fireTestFailures(this.listeners, Arrays.asList(failure));
    }

    public void fireTestFinished(final Description description) {
        new SafeNotifier() { // from class: org.junit.runner.notification.RunNotifier.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(RunNotifier.this);
            }

            @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
            protected void notifyListener(RunListener runListener) throws Exception {
                runListener.testFinished(description);
            }
        }.run();
    }

    public void fireTestIgnored(final Description description) {
        new SafeNotifier() { // from class: org.junit.runner.notification.RunNotifier.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(RunNotifier.this);
            }

            @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
            protected void notifyListener(RunListener runListener) throws Exception {
                runListener.testIgnored(description);
            }
        }.run();
    }

    public void fireTestRunFinished(final Result result) {
        new SafeNotifier() { // from class: org.junit.runner.notification.RunNotifier.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(RunNotifier.this);
            }

            @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
            protected void notifyListener(RunListener runListener) throws Exception {
                runListener.testRunFinished(result);
            }
        }.run();
    }

    public void fireTestRunStarted(final Description description) {
        new SafeNotifier() { // from class: org.junit.runner.notification.RunNotifier.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(RunNotifier.this);
            }

            @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
            protected void notifyListener(RunListener runListener) throws Exception {
                runListener.testRunStarted(description);
            }
        }.run();
    }

    public void fireTestStarted(final Description description) throws StoppedByUserException {
        if (!this.pleaseStop) {
            new SafeNotifier() { // from class: org.junit.runner.notification.RunNotifier.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(RunNotifier.this);
                }

                @Override // org.junit.runner.notification.RunNotifier.SafeNotifier
                protected void notifyListener(RunListener runListener) throws Exception {
                    runListener.testStarted(description);
                }
            }.run();
            return;
        }
        throw new StoppedByUserException();
    }

    public void pleaseStop() {
        this.pleaseStop = true;
    }

    public void removeListener(RunListener runListener) {
        if (runListener != null) {
            this.listeners.remove(wrapIfNotThreadSafe(runListener));
            return;
        }
        throw new NullPointerException("Cannot remove a null listener");
    }

    RunListener wrapIfNotThreadSafe(RunListener runListener) {
        if (!runListener.getClass().isAnnotationPresent(RunListener.ThreadSafe.class)) {
            return new SynchronizedRunListener(runListener, this);
        }
        return runListener;
    }
}
