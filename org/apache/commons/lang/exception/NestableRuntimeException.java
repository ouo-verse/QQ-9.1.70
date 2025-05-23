package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NestableRuntimeException extends RuntimeException implements Nestable {
    private static final long serialVersionUID = 1;
    private Throwable cause;
    protected NestableDelegate delegate;

    public NestableRuntimeException() {
        this.delegate = new NestableDelegate(this);
        this.cause = null;
    }

    @Override // java.lang.Throwable, org.apache.commons.lang.exception.Nestable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable, org.apache.commons.lang.exception.Nestable
    public String getMessage() {
        if (super.getMessage() != null) {
            return super.getMessage();
        }
        Throwable th5 = this.cause;
        if (th5 != null) {
            return th5.toString();
        }
        return null;
    }

    @Override // org.apache.commons.lang.exception.Nestable
    public String[] getMessages() {
        return this.delegate.getMessages();
    }

    @Override // org.apache.commons.lang.exception.Nestable
    public Throwable getThrowable(int i3) {
        return this.delegate.getThrowable(i3);
    }

    @Override // org.apache.commons.lang.exception.Nestable
    public int getThrowableCount() {
        return this.delegate.getThrowableCount();
    }

    @Override // org.apache.commons.lang.exception.Nestable
    public Throwable[] getThrowables() {
        return this.delegate.getThrowables();
    }

    @Override // org.apache.commons.lang.exception.Nestable
    public int indexOfThrowable(Class cls) {
        return this.delegate.indexOfThrowable(cls, 0);
    }

    @Override // org.apache.commons.lang.exception.Nestable
    public final void printPartialStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        this.delegate.printStackTrace();
    }

    @Override // org.apache.commons.lang.exception.Nestable
    public int indexOfThrowable(Class cls, int i3) {
        return this.delegate.indexOfThrowable(cls, i3);
    }

    @Override // java.lang.Throwable, org.apache.commons.lang.exception.Nestable
    public void printStackTrace(PrintStream printStream) {
        this.delegate.printStackTrace(printStream);
    }

    @Override // java.lang.Throwable, org.apache.commons.lang.exception.Nestable
    public void printStackTrace(PrintWriter printWriter) {
        this.delegate.printStackTrace(printWriter);
    }

    public NestableRuntimeException(String str) {
        super(str);
        this.delegate = new NestableDelegate(this);
        this.cause = null;
    }

    @Override // org.apache.commons.lang.exception.Nestable
    public String getMessage(int i3) {
        if (i3 == 0) {
            return super.getMessage();
        }
        return this.delegate.getMessage(i3);
    }

    public NestableRuntimeException(Throwable th5) {
        this.delegate = new NestableDelegate(this);
        this.cause = th5;
    }

    public NestableRuntimeException(String str, Throwable th5) {
        super(str);
        this.delegate = new NestableDelegate(this);
        this.cause = th5;
    }
}
