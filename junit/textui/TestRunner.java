package junit.textui;

import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import java.io.PrintStream;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;
import junit.runner.Version;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TestRunner extends BaseTestRunner {
    public static final int EXCEPTION_EXIT = 2;
    public static final int FAILURE_EXIT = 1;
    public static final int SUCCESS_EXIT = 0;
    private ResultPrinter fPrinter;

    public TestRunner() {
        this(System.out);
    }

    public static void main(String[] strArr) {
        try {
            if (!new TestRunner().start(strArr).wasSuccessful()) {
                System.exit(1);
            }
            System.exit(0);
        } catch (Exception e16) {
            System.err.println(e16.getMessage());
            System.exit(2);
        }
    }

    public static void run(Class<? extends TestCase> cls) {
        run(new TestSuite(cls));
    }

    public static void runAndWait(Test test) {
        new TestRunner().doRun(test, true);
    }

    protected TestResult createTestResult() {
        return new TestResult();
    }

    public TestResult doRun(Test test) {
        return doRun(test, false);
    }

    protected void pause(boolean z16) {
        if (!z16) {
            return;
        }
        this.fPrinter.printWaitPrompt();
        try {
            System.in.read();
        } catch (Exception unused) {
        }
    }

    @Override // junit.runner.BaseTestRunner
    protected void runFailed(String str) {
        System.err.println(str);
        System.exit(1);
    }

    protected TestResult runSingleMethod(String str, String str2, boolean z16) throws Exception {
        return doRun(TestSuite.createTest(loadSuiteClass(str).asSubclass(TestCase.class), str2), z16);
    }

    public void setPrinter(ResultPrinter resultPrinter) {
        this.fPrinter = resultPrinter;
    }

    public TestResult start(String[] strArr) throws Exception {
        String str = "";
        String str2 = str;
        int i3 = 0;
        boolean z16 = false;
        while (i3 < strArr.length) {
            if (strArr[i3].equals("-wait")) {
                z16 = true;
            } else if (strArr[i3].equals(LogCmdOptions.CLEAR)) {
                i3++;
                str = extractClassName(strArr[i3]);
            } else if (strArr[i3].equals("-m")) {
                i3++;
                String str3 = strArr[i3];
                int lastIndexOf = str3.lastIndexOf(46);
                String substring = str3.substring(0, lastIndexOf);
                str2 = str3.substring(lastIndexOf + 1);
                str = substring;
            } else if (strArr[i3].equals("-v")) {
                System.err.println("JUnit " + Version.id() + " by Kent Beck and Erich Gamma");
            } else {
                str = strArr[i3];
            }
            i3++;
        }
        if (!str.equals("")) {
            try {
                if (!str2.equals("")) {
                    return runSingleMethod(str, str2, z16);
                }
                return doRun(getTest(str), z16);
            } catch (Exception e16) {
                throw new Exception("Could not create and run test suite: " + e16);
            }
        }
        throw new Exception("Usage: TestRunner [-wait] testCaseName, where name is the name of the TestCase class");
    }

    public TestRunner(PrintStream printStream) {
        this(new ResultPrinter(printStream));
    }

    public static TestResult run(Test test) {
        return new TestRunner().doRun(test);
    }

    public TestResult doRun(Test test, boolean z16) {
        TestResult createTestResult = createTestResult();
        createTestResult.addListener(this.fPrinter);
        long currentTimeMillis = System.currentTimeMillis();
        test.run(createTestResult);
        this.fPrinter.print(createTestResult, System.currentTimeMillis() - currentTimeMillis);
        pause(z16);
        return createTestResult;
    }

    public TestRunner(ResultPrinter resultPrinter) {
        this.fPrinter = resultPrinter;
    }

    @Override // junit.runner.BaseTestRunner
    public void testEnded(String str) {
    }

    @Override // junit.runner.BaseTestRunner
    public void testStarted(String str) {
    }

    @Override // junit.runner.BaseTestRunner
    public void testFailed(int i3, Test test, Throwable th5) {
    }
}
