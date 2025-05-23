package com.tencent.mobileqq.mini.zxing;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class NotFoundException extends ReaderException {
    private static final NotFoundException INSTANCE;

    static {
        NotFoundException notFoundException = new NotFoundException();
        INSTANCE = notFoundException;
        notFoundException.setStackTrace(ReaderException.NO_TRACE);
    }

    NotFoundException() {
    }

    public static NotFoundException getNotFoundInstance() {
        return INSTANCE;
    }
}
