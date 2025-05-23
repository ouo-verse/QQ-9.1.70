package com.tencent.qqlive.tvkplayer.vinfo.common;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKIllegalCGIResponseException extends Exception {
    public static final int ERROR_TYPE_PLAYBACK_NOT_FOUNT = 5;
    private int mErrorType;

    public TVKIllegalCGIResponseException(int i3) {
        this(i3, "");
    }

    public int getErrorType() {
        return this.mErrorType;
    }

    public TVKIllegalCGIResponseException(int i3, String str) {
        super(str);
        this.mErrorType = i3;
    }
}
