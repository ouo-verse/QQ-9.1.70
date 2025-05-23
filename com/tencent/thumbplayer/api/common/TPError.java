package com.tencent.thumbplayer.api.common;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPError {
    public static final long INVALID_POSITION_MS = Long.MIN_VALUE;
    public static final String TP_ERROR_EXTRA_PARAM_INT_TRACK_INDEX = "tp_error_extra_param_int_track_index";
    public static final String TP_ERRPR_EXTRA_PARAM_STRING_ASSET_OPAQUE = "tp_error_extra_param_string_asset_opaque";
    private long mCurrentPosMs;
    private final int mErrorCode;
    private int mErrorType;
    private final HashMap<String, Object> mExtraParams;

    public TPError(int i3) {
        this(-1, i3);
    }

    public void addExtraParam(String str, Object obj) {
        this.mExtraParams.put(str, obj);
    }

    public Map<String, Object> getAllExtraParams() {
        return new HashMap(this.mExtraParams);
    }

    public long getCurrentPosMs() {
        return this.mCurrentPosMs;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public int getErrorType() {
        return this.mErrorType;
    }

    public Object getExtraParam(String str) {
        return this.mExtraParams.get(str);
    }

    @NonNull
    public String toString() {
        return "errorType=" + this.mErrorType + ", errorCode=" + this.mErrorCode + ", positionMs=" + this.mCurrentPosMs + ", extraParams=" + this.mExtraParams;
    }

    public TPError(int i3, int i16) {
        this(i3, i16, Long.MIN_VALUE);
    }

    public TPError(int i3, int i16, long j3) {
        this.mExtraParams = new HashMap<>();
        this.mErrorType = i3;
        this.mErrorCode = i16;
        this.mCurrentPosMs = j3;
    }
}
