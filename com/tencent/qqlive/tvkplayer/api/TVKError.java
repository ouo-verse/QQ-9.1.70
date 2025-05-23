package com.tencent.qqlive.tvkplayer.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKError {
    private final int mErrorModule;
    private final HashMap<String, Object> mExtraInfo;
    private final String mFullErrorCode;
    private final int mMainErrorCode;
    private int mPositionMs;
    private final int mSubErrorCode;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ExtraInfoKey {
        public static String DETAIL_INFO = "DETAIL_INFO";
        public static String ERROR_AUDIO_TRACK_NAME = "AUDIO_TRACK_NAME";
        public static String ERROR_INSTRUCTION = "ERROR_INSTRUCTION";
        public static String IP_LIMITATION_INFO = "IP_LIMITATION_INFO";
        public static String NET_VIDEO_INFO = "NET_VIDEO_INFO";
    }

    public TVKError(int i3, int i16) {
        this(i3, i16, Integer.MAX_VALUE);
    }

    public void addExtraInfo(String str, Object obj) {
        this.mExtraInfo.put(str, obj);
    }

    public int getErrorModule() {
        return this.mErrorModule;
    }

    @Nullable
    public Object getExtraInfo(String str) {
        return this.mExtraInfo.get(str);
    }

    @NonNull
    public String getFullErrorCode() {
        return this.mFullErrorCode;
    }

    public int getMainErrorCode() {
        return this.mMainErrorCode;
    }

    public int getPositionMs() {
        return this.mPositionMs;
    }

    public int getSubErrorCode() {
        return this.mSubErrorCode;
    }

    public void setPositionMs(int i3) {
        this.mPositionMs = i3;
    }

    @NonNull
    public String toString() {
        return "TVKError: mErrorModule=" + this.mErrorModule + ", mMainErrorCode=" + this.mMainErrorCode + ", mFullErrorCode=" + this.mFullErrorCode + ", mPositionMs=" + this.mPositionMs + ", mExtraInfo=" + this.mExtraInfo;
    }

    public TVKError(int i3, int i16, int i17) {
        this.mExtraInfo = new HashMap<>();
        this.mPositionMs = -1;
        this.mErrorModule = i3;
        this.mMainErrorCode = i16;
        this.mSubErrorCode = i17;
        if (i17 != Integer.MAX_VALUE) {
            this.mFullErrorCode = String.format(Locale.getDefault(), "%d.%d.%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.mFullErrorCode = String.format(Locale.getDefault(), "%d.%d", Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void addExtraInfo(HashMap<String, Object> hashMap) {
        this.mExtraInfo.putAll(hashMap);
    }
}
