package junit.framework;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TestFailure {
    protected Test fFailedTest;
    protected Throwable fThrownException;

    public TestFailure(Test test, Throwable th5) {
        this.fFailedTest = test;
        this.fThrownException = th5;
    }

    public String exceptionMessage() {
        return thrownException().getMessage();
    }

    public Test failedTest() {
        return this.fFailedTest;
    }

    public boolean isFailure() {
        return thrownException() instanceof AssertionFailedError;
    }

    public Throwable thrownException() {
        return this.fThrownException;
    }

    public String toString() {
        return this.fFailedTest + MsgSummary.STR_COLON + this.fThrownException.getMessage();
    }

    public String trace() {
        StringWriter stringWriter = new StringWriter();
        thrownException().printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
