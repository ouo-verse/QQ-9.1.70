package junit.framework;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface TestListener {
    void addError(Test test, Throwable th5);

    void addFailure(Test test, AssertionFailedError assertionFailedError);

    void endTest(Test test);

    void startTest(Test test);
}
