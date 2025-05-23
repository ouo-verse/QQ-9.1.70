package junit.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TestResult {
    protected List<TestFailure> fFailures = new ArrayList();
    protected List<TestFailure> fErrors = new ArrayList();
    protected List<TestListener> fListeners = new ArrayList();
    protected int fRunTests = 0;
    private boolean fStop = false;

    private synchronized List<TestListener> cloneListeners() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.fListeners);
        return arrayList;
    }

    public synchronized void addError(Test test, Throwable th5) {
        this.fErrors.add(new TestFailure(test, th5));
        Iterator<TestListener> it = cloneListeners().iterator();
        while (it.hasNext()) {
            it.next().addError(test, th5);
        }
    }

    public synchronized void addFailure(Test test, AssertionFailedError assertionFailedError) {
        this.fFailures.add(new TestFailure(test, assertionFailedError));
        Iterator<TestListener> it = cloneListeners().iterator();
        while (it.hasNext()) {
            it.next().addFailure(test, assertionFailedError);
        }
    }

    public synchronized void addListener(TestListener testListener) {
        this.fListeners.add(testListener);
    }

    public void endTest(Test test) {
        Iterator<TestListener> it = cloneListeners().iterator();
        while (it.hasNext()) {
            it.next().endTest(test);
        }
    }

    public synchronized int errorCount() {
        return this.fErrors.size();
    }

    public synchronized Enumeration<TestFailure> errors() {
        return Collections.enumeration(this.fErrors);
    }

    public synchronized int failureCount() {
        return this.fFailures.size();
    }

    public synchronized Enumeration<TestFailure> failures() {
        return Collections.enumeration(this.fFailures);
    }

    public synchronized void removeListener(TestListener testListener) {
        this.fListeners.remove(testListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void run(final TestCase testCase) {
        startTest(testCase);
        runProtected(testCase, new Protectable() { // from class: junit.framework.TestResult.1
            @Override // junit.framework.Protectable
            public void protect() throws Throwable {
                testCase.runBare();
            }
        });
        endTest(testCase);
    }

    public synchronized int runCount() {
        return this.fRunTests;
    }

    public void runProtected(Test test, Protectable protectable) {
        try {
            protectable.protect();
        } catch (ThreadDeath e16) {
            throw e16;
        } catch (AssertionFailedError e17) {
            addFailure(test, e17);
        } catch (Throwable th5) {
            addError(test, th5);
        }
    }

    public synchronized boolean shouldStop() {
        return this.fStop;
    }

    public void startTest(Test test) {
        int countTestCases = test.countTestCases();
        synchronized (this) {
            this.fRunTests += countTestCases;
        }
        Iterator<TestListener> it = cloneListeners().iterator();
        while (it.hasNext()) {
            it.next().startTest(test);
        }
    }

    public synchronized void stop() {
        this.fStop = true;
    }

    public synchronized boolean wasSuccessful() {
        boolean z16;
        if (failureCount() == 0) {
            if (errorCount() == 0) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }
}
