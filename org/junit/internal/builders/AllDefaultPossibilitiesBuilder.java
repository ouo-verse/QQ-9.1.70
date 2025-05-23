package org.junit.internal.builders;

import java.util.Arrays;
import java.util.Iterator;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

/* loaded from: classes29.dex */
public class AllDefaultPossibilitiesBuilder extends RunnerBuilder {
    private final boolean canUseSuiteMethod;

    public AllDefaultPossibilitiesBuilder(boolean z16) {
        this.canUseSuiteMethod = z16;
    }

    protected AnnotatedBuilder annotatedBuilder() {
        return new AnnotatedBuilder(this);
    }

    protected IgnoredBuilder ignoredBuilder() {
        return new IgnoredBuilder();
    }

    protected JUnit3Builder junit3Builder() {
        return new JUnit3Builder();
    }

    protected JUnit4Builder junit4Builder() {
        return new JUnit4Builder();
    }

    @Override // org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) throws Throwable {
        Iterator it = Arrays.asList(ignoredBuilder(), annotatedBuilder(), suiteMethodBuilder(), junit3Builder(), junit4Builder()).iterator();
        while (it.hasNext()) {
            Runner safeRunnerForClass = ((RunnerBuilder) it.next()).safeRunnerForClass(cls);
            if (safeRunnerForClass != null) {
                return safeRunnerForClass;
            }
        }
        return null;
    }

    protected RunnerBuilder suiteMethodBuilder() {
        if (this.canUseSuiteMethod) {
            return new SuiteMethodBuilder();
        }
        return new NullBuilder();
    }
}
