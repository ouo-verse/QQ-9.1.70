package com.tencent.superplayer.api;

import android.app.Activity;

/* loaded from: classes26.dex */
public interface ISPlayerPreLoader {
    void release();

    int startPreloadTask(Activity activity, SuperPlayerVideoInfo superPlayerVideoInfo);

    void stopPreloadTask(int i3);
}
