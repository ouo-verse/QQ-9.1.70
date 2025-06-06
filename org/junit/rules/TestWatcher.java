package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class TestWatcher implements TestRule {
    /* JADX INFO: Access modifiers changed from: private */
    public void failedQuietly(Throwable th5, Description description, List<Throwable> list) {
        try {
            failed(th5, description);
        } catch (Throwable th6) {
            list.add(th6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishedQuietly(Description description, List<Throwable> list) {
        try {
            finished(description);
        } catch (Throwable th5) {
            list.add(th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void skippedQuietly(AssumptionViolatedException assumptionViolatedException, Description description, List<Throwable> list) {
        try {
            if (assumptionViolatedException instanceof org.junit.AssumptionViolatedException) {
                skipped((org.junit.AssumptionViolatedException) assumptionViolatedException, description);
            } else {
                skipped(assumptionViolatedException, description);
            }
        } catch (Throwable th5) {
            list.add(th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startingQuietly(Description description, List<Throwable> list) {
        try {
            starting(description);
        } catch (Throwable th5) {
            list.add(th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void succeededQuietly(Description description, List<Throwable> list) {
        try {
            succeeded(description);
        } catch (Throwable th5) {
            list.add(th5);
        }
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(final Statement statement, final Description description) {
        return new Statement() { // from class: org.junit.rules.TestWatcher.1
            @Override // org.junit.runners.model.Statement
            public void evaluate() throws Throwable {
                ArrayList arrayList = new ArrayList();
                TestWatcher.this.startingQuietly(description, arrayList);
                try {
                    try {
                        statement.evaluate();
                        TestWatcher.this.succeededQuietly(description, arrayList);
                    } catch (AssumptionViolatedException e16) {
                        arrayList.add(e16);
                        TestWatcher.this.skippedQuietly(e16, description, arrayList);
                        MultipleFailureException.assertEmpty(arrayList);
                    } catch (Throwable th5) {
                        arrayList.add(th5);
                        TestWatcher.this.failedQuietly(th5, description, arrayList);
                        MultipleFailureException.assertEmpty(arrayList);
                    }
                    MultipleFailureException.assertEmpty(arrayList);
                } finally {
                    TestWatcher.this.finishedQuietly(description, arrayList);
                }
            }
        };
    }

    @Deprecated
    protected void skipped(AssumptionViolatedException assumptionViolatedException, Description description) {
    }

    protected void skipped(org.junit.AssumptionViolatedException assumptionViolatedException, Description description) {
        skipped((AssumptionViolatedException) assumptionViolatedException, description);
    }

    protected void finished(Description description) {
    }

    protected void starting(Description description) {
    }

    protected void succeeded(Description description) {
    }

    protected void failed(Throwable th5, Description description) {
    }
}
