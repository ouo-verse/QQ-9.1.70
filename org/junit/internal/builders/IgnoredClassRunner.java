package org.junit.internal.builders;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

/* compiled from: P */
/* loaded from: classes29.dex */
public class IgnoredClassRunner extends Runner {
    private final Class<?> clazz;

    public IgnoredClassRunner(Class<?> cls) {
        this.clazz = cls;
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        return Description.createSuiteDescription(this.clazz);
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        runNotifier.fireTestIgnored(getDescription());
    }
}
