package org.slf4j.helpers;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FormattingTuple {
    public static FormattingTuple NULL = new FormattingTuple(null);
    private Object[] argArray;
    private String message;
    private Throwable throwable;

    public FormattingTuple(String str) {
        this(str, null, null);
    }

    public Object[] getArgArray() {
        return this.argArray;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public FormattingTuple(String str, Object[] objArr, Throwable th5) {
        this.message = str;
        this.throwable = th5;
        this.argArray = objArr;
    }
}
