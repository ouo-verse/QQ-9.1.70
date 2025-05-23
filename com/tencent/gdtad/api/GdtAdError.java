package com.tencent.gdtad.api;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtAdError {
    public static final int ERROR_DISPLAY_FORMAT_MISMATCH = 7;
    public static final int ERROR_INTERNAL = 1;
    public static final int ERROR_INVALID_REQUEST = 4;
    public static final int ERROR_LOAD_TOO_FREQUENTLY = 2;
    public static final int ERROR_NETWORK = 3;
    public static final int ERROR_NO_FILL = 5;
    public static final int ERROR_SERVER = 6;
    public static final int ERROR_SUCCESS = 0;
    private int errorCode;

    public GdtAdError(int i3) {
        this.errorCode = i3;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public String getErrorMessage() {
        switch (getErrorCode()) {
            case 0:
                return "Success";
            case 1:
                return "Internal Error";
            case 2:
                return "Ad was re-loaded too frequently";
            case 3:
                return "Network Error";
            case 4:
                return "Invalid Request";
            case 5:
                return "No Fill";
            case 6:
                return "Server Error";
            case 7:
                return "Display Format Mismatch";
            default:
                return null;
        }
    }
}
