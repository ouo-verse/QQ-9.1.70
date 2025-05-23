package junit.extensions;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ActiveTestSuite extends TestSuite {
    private volatile int fActiveTestDeathCount;

    public ActiveTestSuite() {
    }

    @Override // junit.framework.TestSuite, junit.framework.Test
    public void run(TestResult testResult) {
        this.fActiveTestDeathCount = 0;
        super.run(testResult);
        waitUntilFinished();
    }

    public synchronized void runFinished() {
        this.fActiveTestDeathCount++;
        notifyAll();
    }

    @Override // junit.framework.TestSuite
    public void runTest(final Test test, final TestResult testResult) {
        new BaseThread() { // from class: junit.extensions.ActiveTestSuite.1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    test.run(testResult);
                } finally {
                    ActiveTestSuite.this.runFinished();
                }
            }
        }.start();
    }

    synchronized void waitUntilFinished() {
        while (this.fActiveTestDeathCount < testCount()) {
            try {
                LockMethodProxy.wait(this);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public ActiveTestSuite(Class<? extends TestCase> cls) {
        super(cls);
    }

    public ActiveTestSuite(String str) {
        super(str);
    }

    public ActiveTestSuite(Class<? extends TestCase> cls, String str) {
        super(cls, str);
    }
}
