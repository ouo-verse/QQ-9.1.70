package org.jf.util;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ExceptionWithContext extends RuntimeException {
    private StringBuffer context;

    public ExceptionWithContext(String str, Object... objArr) {
        this(null, str, objArr);
    }

    private static String formatMessage(String str, Object... objArr) {
        if (str == null) {
            return null;
        }
        return String.format(str, objArr);
    }

    public static ExceptionWithContext withContext(Throwable th5, String str, Object... objArr) {
        ExceptionWithContext exceptionWithContext;
        if (th5 instanceof ExceptionWithContext) {
            exceptionWithContext = (ExceptionWithContext) th5;
        } else {
            exceptionWithContext = new ExceptionWithContext(th5);
        }
        exceptionWithContext.addContext(String.format(str, objArr));
        return exceptionWithContext;
    }

    public void addContext(String str) {
        if (str != null) {
            this.context.append(str);
            if (!str.endsWith("\n")) {
                this.context.append('\n');
                return;
            }
            return;
        }
        throw new NullPointerException("str == null");
    }

    public String getContext() {
        return this.context.toString();
    }

    public void printContext(PrintStream printStream) {
        printStream.println(getMessage());
        printStream.print(this.context);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        printStream.println(this.context);
    }

    public ExceptionWithContext(Throwable th5) {
        this(th5, null, new Object[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExceptionWithContext(Throwable th5, String str, Object... objArr) {
        super(r3, th5);
        String message;
        if (str != null) {
            message = formatMessage(str, objArr);
        } else {
            message = th5 != null ? th5.getMessage() : null;
        }
        if (th5 instanceof ExceptionWithContext) {
            String stringBuffer = ((ExceptionWithContext) th5).context.toString();
            StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.length() + 200);
            this.context = stringBuffer2;
            stringBuffer2.append(stringBuffer);
            return;
        }
        this.context = new StringBuffer(200);
    }

    public void printContext(PrintWriter printWriter) {
        printWriter.println(getMessage());
        printWriter.print(this.context);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        printWriter.println(this.context);
    }
}
