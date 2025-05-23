package org.junit.rules;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface MethodRule {
    Statement apply(Statement statement, FrameworkMethod frameworkMethod, Object obj);
}
