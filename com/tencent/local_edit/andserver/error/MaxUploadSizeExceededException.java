package com.tencent.local_edit.andserver.error;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MaxUploadSizeExceededException extends HttpException {
    private final long mMaxSize;

    public MaxUploadSizeExceededException(long j3) {
        this(j3, null);
    }

    public long getMaxSize() {
        return this.mMaxSize;
    }

    public MaxUploadSizeExceededException(long j3, Throwable th5) {
        super(413, "Maximum upload size of " + j3 + " bytes exceeded", th5);
        this.mMaxSize = j3;
    }
}
