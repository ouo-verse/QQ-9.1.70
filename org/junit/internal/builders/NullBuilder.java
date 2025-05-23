package org.junit.internal.builders;

import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NullBuilder extends RunnerBuilder {
    @Override // org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) throws Throwable {
        return null;
    }
}
