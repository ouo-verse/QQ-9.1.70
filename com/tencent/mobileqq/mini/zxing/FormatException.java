package com.tencent.mobileqq.mini.zxing;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class FormatException extends ReaderException {
    private static final FormatException INSTANCE;

    static {
        FormatException formatException = new FormatException();
        INSTANCE = formatException;
        formatException.setStackTrace(ReaderException.NO_TRACE);
    }

    FormatException() {
    }

    public static FormatException getFormatInstance() {
        return ReaderException.isStackTrace ? new FormatException() : INSTANCE;
    }

    FormatException(Throwable th5) {
        super(th5);
    }

    public static FormatException getFormatInstance(Throwable th5) {
        return ReaderException.isStackTrace ? new FormatException(th5) : INSTANCE;
    }
}
