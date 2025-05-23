package org.junit.internal.runners.statements;

import org.junit.runners.model.Statement;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Fail extends Statement {
    private final Throwable error;

    public Fail(Throwable th5) {
        this.error = th5;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Throwable {
        throw this.error;
    }
}
