package com.tencent.qqmusic.mediaplayer.perf;

import android.net.Uri;

/* loaded from: classes23.dex */
public interface PlayerInfoCollector {
    void putBoolean(String str, boolean z16);

    void putInt(String str, int i3);

    void putLong(String str, long j3);

    void putString(String str, String str2);

    void putUri(String str, Uri uri);
}
