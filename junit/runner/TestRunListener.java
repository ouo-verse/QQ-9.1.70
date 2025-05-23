package junit.runner;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface TestRunListener {
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_FAILURE = 2;

    void testEnded(String str);

    void testFailed(int i3, String str, String str2);

    void testRunEnded(long j3);

    void testRunStarted(String str, int i3);

    void testRunStopped(long j3);

    void testStarted(String str);
}
