package org.junit.experimental.results;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/* loaded from: classes29.dex */
public class PrintableResult {
    private Result result;

    public PrintableResult(List<Failure> list) {
        this(new FailureList(list).result());
    }

    public static PrintableResult testResult(Class<?> cls) {
        return testResult(Request.aClass(cls));
    }

    public int failureCount() {
        return this.result.getFailures().size();
    }

    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new TextListener(new PrintStream(byteArrayOutputStream)).testRunFinished(this.result);
        return byteArrayOutputStream.toString();
    }

    PrintableResult(Result result) {
        this.result = result;
    }

    public static PrintableResult testResult(Request request) {
        return new PrintableResult(new JUnitCore().run(request));
    }
}
