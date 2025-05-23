package com.tencent.tavkit.tavffmpeg;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FFmpegInfo {
    private static final String TAG = "FFmpegInfo";

    public static String getVersion() {
        Log.d(TAG, "maxjyhu---getVersion: ");
        return nativeGetFFmpegVersion();
    }

    public static native String nativeGetFFmpegVersion();
}
