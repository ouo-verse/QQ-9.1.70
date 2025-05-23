package org.junit.internal.runners.statements;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.Statement;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ExpectException extends Statement {
    private final Class<? extends Throwable> expected;
    private final Statement next;

    public ExpectException(Statement statement, Class<? extends Throwable> cls) {
        this.next = statement;
        this.expected = cls;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Exception {
        boolean z16;
        try {
            this.next.evaluate();
            z16 = true;
        } catch (AssumptionViolatedException e16) {
            throw e16;
        } catch (Throwable th5) {
            if (this.expected.isAssignableFrom(th5.getClass())) {
                z16 = false;
            } else {
                throw new Exception("Unexpected exception, expected<" + this.expected.getName() + "> but was<" + th5.getClass().getName() + ">", th5);
            }
        }
        if (!z16) {
            return;
        }
        throw new AssertionError("Expected exception: " + this.expected.getName());
    }
}
