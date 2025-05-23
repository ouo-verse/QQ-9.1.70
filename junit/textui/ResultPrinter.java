package junit.textui;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Enumeration;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestFailure;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.runner.BaseTestRunner;

/* loaded from: classes28.dex */
public class ResultPrinter implements TestListener {
    int fColumn = 0;
    PrintStream fWriter;

    public ResultPrinter(PrintStream printStream) {
        this.fWriter = printStream;
    }

    @Override // junit.framework.TestListener
    public void addError(Test test, Throwable th5) {
        getWriter().print("E");
    }

    @Override // junit.framework.TestListener
    public void addFailure(Test test, AssertionFailedError assertionFailedError) {
        getWriter().print(UserInfo.SEX_FEMALE);
    }

    protected String elapsedTimeAsString(long j3) {
        return NumberFormat.getInstance().format(j3 / 1000.0d);
    }

    public PrintStream getWriter() {
        return this.fWriter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void print(TestResult testResult, long j3) {
        printHeader(j3);
        printErrors(testResult);
        printFailures(testResult);
        printFooter(testResult);
    }

    public void printDefect(TestFailure testFailure, int i3) {
        printDefectHeader(testFailure, i3);
        printDefectTrace(testFailure);
    }

    protected void printDefectHeader(TestFailure testFailure, int i3) {
        getWriter().print(i3 + ") " + testFailure.failedTest());
    }

    protected void printDefectTrace(TestFailure testFailure) {
        getWriter().print(BaseTestRunner.getFilteredTrace(testFailure.trace()));
    }

    protected void printDefects(Enumeration<TestFailure> enumeration, int i3, String str) {
        if (i3 == 0) {
            return;
        }
        if (i3 == 1) {
            getWriter().println("There was " + i3 + " " + str + ":");
        } else {
            getWriter().println("There were " + i3 + " " + str + "s:");
        }
        int i16 = 1;
        while (enumeration.hasMoreElements()) {
            printDefect(enumeration.nextElement(), i16);
            i16++;
        }
    }

    protected void printErrors(TestResult testResult) {
        printDefects(testResult.errors(), testResult.errorCount(), "error");
    }

    protected void printFailures(TestResult testResult) {
        printDefects(testResult.failures(), testResult.failureCount(), "failure");
    }

    protected void printFooter(TestResult testResult) {
        String str;
        if (testResult.wasSuccessful()) {
            getWriter().println();
            getWriter().print("OK");
            PrintStream writer = getWriter();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" (");
            sb5.append(testResult.runCount());
            sb5.append(" test");
            if (testResult.runCount() == 1) {
                str = "";
            } else {
                str = ReportConstant.COSTREPORT_PREFIX;
            }
            sb5.append(str);
            sb5.append(")");
            writer.println(sb5.toString());
        } else {
            getWriter().println();
            getWriter().println("FAILURES!!!");
            getWriter().println("Tests run: " + testResult.runCount() + ",  Failures: " + testResult.failureCount() + ",  Errors: " + testResult.errorCount());
        }
        getWriter().println();
    }

    protected void printHeader(long j3) {
        getWriter().println();
        getWriter().println("Time: " + elapsedTimeAsString(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void printWaitPrompt() {
        getWriter().println();
        getWriter().println("<RETURN> to continue");
    }

    @Override // junit.framework.TestListener
    public void startTest(Test test) {
        getWriter().print(".");
        int i3 = this.fColumn;
        this.fColumn = i3 + 1;
        if (i3 >= 40) {
            getWriter().println();
            this.fColumn = 0;
        }
    }

    @Override // junit.framework.TestListener
    public void endTest(Test test) {
    }
}
