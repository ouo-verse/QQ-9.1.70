package com.qq.wx.voice.embedqqegg.util;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LogTool {
    public static boolean isShow = false;

    public static void d(int i3) {
        if (isShow) {
            Log.d("WXVoiceDebug", String.valueOf(i3));
        }
    }

    public static void d(String str) {
        if (isShow) {
            Log.d("WXVoiceDebug", str);
        }
    }
}
