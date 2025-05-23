package org.junit.internal;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TextListener extends RunListener {
    private final PrintStream writer;

    public TextListener(JUnitSystem jUnitSystem) {
        this(jUnitSystem.out());
    }

    private PrintStream getWriter() {
        return this.writer;
    }

    protected String elapsedTimeAsString(long j3) {
        return NumberFormat.getInstance().format(j3 / 1000.0d);
    }

    protected void printFailure(Failure failure, String str) {
        getWriter().println(str + ") " + failure.getTestHeader());
        getWriter().print(failure.getTrace());
    }

    protected void printFailures(Result result) {
        List<Failure> failures = result.getFailures();
        if (failures.size() == 0) {
            return;
        }
        int i3 = 1;
        if (failures.size() == 1) {
            getWriter().println("There was " + failures.size() + " failure:");
        } else {
            getWriter().println("There were " + failures.size() + " failures:");
        }
        Iterator<Failure> it = failures.iterator();
        while (it.hasNext()) {
            printFailure(it.next(), "" + i3);
            i3++;
        }
    }

    protected void printFooter(Result result) {
        String str;
        if (result.wasSuccessful()) {
            getWriter().println();
            getWriter().print("OK");
            PrintStream writer = getWriter();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" (");
            sb5.append(result.getRunCount());
            sb5.append(" test");
            if (result.getRunCount() == 1) {
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
            getWriter().println("Tests run: " + result.getRunCount() + ",  Failures: " + result.getFailureCount());
        }
        getWriter().println();
    }

    protected void printHeader(long j3) {
        getWriter().println();
        getWriter().println("Time: " + elapsedTimeAsString(j3));
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFailure(Failure failure) {
        this.writer.append('E');
    }

    @Override // org.junit.runner.notification.RunListener
    public void testIgnored(Description description) {
        this.writer.append('I');
    }

    @Override // org.junit.runner.notification.RunListener
    public void testRunFinished(Result result) {
        printHeader(result.getRunTime());
        printFailures(result);
        printFooter(result);
    }

    @Override // org.junit.runner.notification.RunListener
    public void testStarted(Description description) {
        this.writer.append('.');
    }

    public TextListener(PrintStream printStream) {
        this.writer = printStream;
    }
}
