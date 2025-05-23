package com.tencent.liteav.videobase.egl;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d extends IOException {
    private static final long serialVersionUID = 2723743254380545567L;
    public final int mErrorCode;
    private final String mErrorMessage;

    public d(int i3) {
        this(i3, "");
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        if (this.mErrorMessage != null) {
            return "EGL error code: " + this.mErrorCode + ", " + this.mErrorMessage;
        }
        return "EGL error code: " + this.mErrorCode + ", " + super.getMessage();
    }

    public d(int i3, String str) {
        super(str);
        this.mErrorCode = i3;
        this.mErrorMessage = str;
    }

    public d(int i3, String str, Throwable th5) {
        super(str, th5);
        this.mErrorCode = i3;
        this.mErrorMessage = str;
    }
}
