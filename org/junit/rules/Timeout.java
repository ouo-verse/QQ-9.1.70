package org.junit.rules;

import java.util.concurrent.TimeUnit;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Timeout implements TestRule {
    private final boolean lookForStuckThread;
    private final TimeUnit timeUnit;
    private final long timeout;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Builder {
        private boolean lookForStuckThread = false;
        private long timeout = 0;
        private TimeUnit timeUnit = TimeUnit.SECONDS;

        protected Builder() {
        }

        public Timeout build() {
            return new Timeout(this);
        }

        protected boolean getLookingForStuckThread() {
            return this.lookForStuckThread;
        }

        protected TimeUnit getTimeUnit() {
            return this.timeUnit;
        }

        protected long getTimeout() {
            return this.timeout;
        }

        public Builder withLookingForStuckThread(boolean z16) {
            this.lookForStuckThread = z16;
            return this;
        }

        public Builder withTimeout(long j3, TimeUnit timeUnit) {
            this.timeout = j3;
            this.timeUnit = timeUnit;
            return this;
        }
    }

    @Deprecated
    public Timeout(int i3) {
        this(i3, TimeUnit.MILLISECONDS);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Timeout millis(long j3) {
        return new Timeout(j3, TimeUnit.MILLISECONDS);
    }

    public static Timeout seconds(long j3) {
        return new Timeout(j3, TimeUnit.SECONDS);
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        try {
            return createFailOnTimeoutStatement(statement);
        } catch (Exception e16) {
            return new Statement() { // from class: org.junit.rules.Timeout.1
                @Override // org.junit.runners.model.Statement
                public void evaluate() throws Throwable {
                    throw new RuntimeException("Invalid parameters for Timeout", e16);
                }
            };
        }
    }

    protected Statement createFailOnTimeoutStatement(Statement statement) throws Exception {
        return FailOnTimeout.builder().withTimeout(this.timeout, this.timeUnit).withLookingForStuckThread(this.lookForStuckThread).build(statement);
    }

    protected final boolean getLookingForStuckThread() {
        return this.lookForStuckThread;
    }

    protected final long getTimeout(TimeUnit timeUnit) {
        return timeUnit.convert(this.timeout, this.timeUnit);
    }

    public Timeout(long j3, TimeUnit timeUnit) {
        this.timeout = j3;
        this.timeUnit = timeUnit;
        this.lookForStuckThread = false;
    }

    protected Timeout(Builder builder) {
        this.timeout = builder.getTimeout();
        this.timeUnit = builder.getTimeUnit();
        this.lookForStuckThread = builder.getLookingForStuckThread();
    }
}
