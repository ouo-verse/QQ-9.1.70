package org.junit.runners.model;

import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TestTimedOutException extends Exception {
    private static final long serialVersionUID = 31935685163547539L;
    private final TimeUnit timeUnit;
    private final long timeout;

    public TestTimedOutException(long j3, TimeUnit timeUnit) {
        super(String.format("test timed out after %d %s", Long.valueOf(j3), timeUnit.name().toLowerCase()));
        this.timeUnit = timeUnit;
        this.timeout = j3;
    }

    public TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    public long getTimeout() {
        return this.timeout;
    }
}
