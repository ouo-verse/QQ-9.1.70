package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface TestRule {
    Statement apply(Statement statement, Description description);
}
