package com.tencent.superplayer.tvkplayer;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.superplayer.tvkplayer.listener.ITVKOnNetVideoInfoListener;
import com.tencent.superplayer.tvkplayer.listener.ITVKOnPermissionTimeoutListener;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ITVKAbility {
    TVKNetVideoInfo getCurTVKNetVideoInfo();

    void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException;

    void openTVKPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, long j3, long j16);

    void openTVKPlayerByUrl(Context context, String str, String str2, long j3, long j16);

    void setOnPermissionTimeoutListener(ITVKOnPermissionTimeoutListener iTVKOnPermissionTimeoutListener);

    void setOnTVKNetVideoInfoListener(ITVKOnNetVideoInfoListener iTVKOnNetVideoInfoListener);
}
