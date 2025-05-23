package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface Nestable {
    Throwable getCause();

    String getMessage();

    String getMessage(int i3);

    String[] getMessages();

    Throwable getThrowable(int i3);

    int getThrowableCount();

    Throwable[] getThrowables();

    int indexOfThrowable(Class cls);

    int indexOfThrowable(Class cls, int i3);

    void printPartialStackTrace(PrintWriter printWriter);

    void printStackTrace(PrintStream printStream);

    void printStackTrace(PrintWriter printWriter);
}
