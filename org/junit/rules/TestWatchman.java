package org.junit.rules;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class TestWatchman implements MethodRule {
    @Override // org.junit.rules.MethodRule
    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, Object obj) {
        return new Statement() { // from class: org.junit.rules.TestWatchman.1
            @Override // org.junit.runners.model.Statement
            public void evaluate() throws Throwable {
                TestWatchman.this.starting(frameworkMethod);
                try {
                    try {
                        statement.evaluate();
                        TestWatchman.this.succeeded(frameworkMethod);
                    } catch (AssumptionViolatedException e16) {
                        throw e16;
                    } catch (Throwable th5) {
                        TestWatchman.this.failed(th5, frameworkMethod);
                        throw th5;
                    }
                } finally {
                    TestWatchman.this.finished(frameworkMethod);
                }
            }
        };
    }

    public void finished(FrameworkMethod frameworkMethod) {
    }

    public void starting(FrameworkMethod frameworkMethod) {
    }

    public void succeeded(FrameworkMethod frameworkMethod) {
    }

    public void failed(Throwable th5, FrameworkMethod frameworkMethod) {
    }
}
