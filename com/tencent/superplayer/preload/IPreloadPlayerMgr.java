package com.tencent.superplayer.preload;

import android.app.Activity;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

/* loaded from: classes26.dex */
public interface IPreloadPlayerMgr {
    PreloadPlayerInfo getPlayerFromPool(int i3, SuperPlayerVideoInfo superPlayerVideoInfo);

    int startPreloadTask(Activity activity, int i3, SuperPlayerVideoInfo superPlayerVideoInfo);

    void stopPreloadTask(int i3);
}
