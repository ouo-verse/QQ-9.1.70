package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class NativeLog {
    private static final String TAG = "NativeLog";

    static {
        if (NativeLibs.audioCommon.load()) {
            Logger.i(TAG, "[static initializer] NativeLog load succeed.");
        }
    }

    public static native int init(String str);
}
