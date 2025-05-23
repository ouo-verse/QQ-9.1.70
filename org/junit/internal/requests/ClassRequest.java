package org.junit.internal.requests;

import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.Request;
import org.junit.runner.Runner;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ClassRequest extends Request {
    private final boolean canUseSuiteMethod;
    private final Class<?> fTestClass;
    private volatile Runner runner;
    private final Object runnerLock;

    public ClassRequest(Class<?> cls, boolean z16) {
        this.runnerLock = new Object();
        this.fTestClass = cls;
        this.canUseSuiteMethod = z16;
    }

    @Override // org.junit.runner.Request
    public Runner getRunner() {
        if (this.runner == null) {
            synchronized (this.runnerLock) {
                if (this.runner == null) {
                    this.runner = new AllDefaultPossibilitiesBuilder(this.canUseSuiteMethod).safeRunnerForClass(this.fTestClass);
                }
            }
        }
        return this.runner;
    }

    public ClassRequest(Class<?> cls) {
        this(cls, true);
    }
}
