package org.apache.commons.lang;

import java.io.PrintStream;
import java.io.PrintWriter;
import org.apache.commons.lang.exception.Nestable;
import org.apache.commons.lang.exception.NestableDelegate;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NotImplementedException extends UnsupportedOperationException implements Nestable {
    private static final String DEFAULT_MESSAGE = "Code is not implemented";
    private static final long serialVersionUID = -6894122266938754088L;
    private Throwable cause;
    private NestableDelegate delegate;

    public NotImplementedException() {
        super(DEFAULT_MESSAGE);
        this.delegate = new NestableDelegate(this);
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

    public NotImplementedException(String str) {
        super(str == null ? DEFAULT_MESSAGE : str);
        this.delegate = new NestableDelegate(this);
    }

    @Override // java.lang.Throwable, org.apache.commons.lang.exception.Nestable
    public void printStackTrace(PrintWriter printWriter) {
        this.delegate.printStackTrace(printWriter);
    }

    public NotImplementedException(Throwable th5) {
        super(DEFAULT_MESSAGE);
        this.delegate = new NestableDelegate(this);
        this.cause = th5;
    }

    @Override // org.apache.commons.lang.exception.Nestable
    public String getMessage(int i3) {
        if (i3 == 0) {
            return super.getMessage();
        }
        return this.delegate.getMessage(i3);
    }

    public NotImplementedException(String str, Throwable th5) {
        super(str == null ? DEFAULT_MESSAGE : str);
        this.delegate = new NestableDelegate(this);
        this.cause = th5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NotImplementedException(Class cls) {
        super(r3);
        String stringBuffer;
        if (cls == null) {
            stringBuffer = DEFAULT_MESSAGE;
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Code is not implemented in ");
            stringBuffer2.append(cls);
            stringBuffer = stringBuffer2.toString();
        }
        this.delegate = new NestableDelegate(this);
    }
}
