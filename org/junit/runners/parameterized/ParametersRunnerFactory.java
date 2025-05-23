package org.junit.runners.parameterized;

import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;

/* loaded from: classes29.dex */
public interface ParametersRunnerFactory {
    Runner createRunnerForTestWithParameters(TestWithParameters testWithParameters) throws InitializationError;
}
