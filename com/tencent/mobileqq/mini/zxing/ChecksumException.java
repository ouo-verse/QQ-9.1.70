package com.tencent.mobileqq.mini.zxing;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ChecksumException extends ReaderException {
    private static final ChecksumException INSTANCE;

    static {
        ChecksumException checksumException = new ChecksumException();
        INSTANCE = checksumException;
        checksumException.setStackTrace(ReaderException.NO_TRACE);
    }

    ChecksumException() {
    }

    public static ChecksumException getChecksumInstance() {
        return ReaderException.isStackTrace ? new ChecksumException() : INSTANCE;
    }

    ChecksumException(Throwable th5) {
        super(th5);
    }

    public static ChecksumException getChecksumInstance(Throwable th5) {
        return ReaderException.isStackTrace ? new ChecksumException(th5) : INSTANCE;
    }
}
