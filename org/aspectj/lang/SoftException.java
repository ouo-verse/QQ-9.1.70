package org.aspectj.lang;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SoftException extends RuntimeException {
    private static final boolean HAVE_JAVA_14;
    Throwable inner;

    static {
        boolean z16;
        try {
            Class.forName("java.nio.Buffer");
            z16 = true;
        } catch (Throwable unused) {
            z16 = false;
        }
        HAVE_JAVA_14 = z16;
    }

    public SoftException(Throwable th5) {
        this.inner = th5;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.inner;
    }

    public Throwable getWrappedThrowable() {
        return this.inner;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Throwable th5 = this.inner;
        if (HAVE_JAVA_14 || th5 == null) {
            return;
        }
        printStream.print("Caused by: ");
        th5.printStackTrace(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Throwable th5 = this.inner;
        if (HAVE_JAVA_14 || th5 == null) {
            return;
        }
        printWriter.print("Caused by: ");
        th5.printStackTrace(printWriter);
    }
}
