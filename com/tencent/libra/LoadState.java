package com.tencent.libra;

/* compiled from: P */
/* loaded from: classes7.dex */
public enum LoadState {
    STATE_PREPARE(false, false),
    STATE_DOWNLOADING(false, false),
    STATE_DECODING(false, false),
    STATE_CANCEL(true, false),
    STATE_DOWNLOAD_FAILED(true, false),
    STATE_DECODE_FAILED(true, false),
    STATE_URL_ILLEGAL(true, false),
    STATE_DOWNLOAD_SUCCESS(false, false),
    STATE_SUCCESS(true, true);

    private final boolean mIsFinish;
    private final boolean mIsSuccess;

    LoadState(boolean z16, boolean z17) {
        this.mIsFinish = z16;
        this.mIsSuccess = z17;
    }

    public boolean isDownloadSuccess() {
        if (this == STATE_DOWNLOAD_SUCCESS) {
            return true;
        }
        return false;
    }

    public boolean isFinish() {
        return this.mIsFinish;
    }

    public boolean isFinishError() {
        if (this.mIsFinish && !this.mIsSuccess) {
            return true;
        }
        return false;
    }

    public boolean isFinishSuccess() {
        if (this.mIsFinish && this.mIsSuccess) {
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        return !this.mIsFinish;
    }
}
