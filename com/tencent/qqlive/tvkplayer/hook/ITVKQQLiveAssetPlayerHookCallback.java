package com.tencent.qqlive.tvkplayer.hook;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;

/* loaded from: classes23.dex */
public interface ITVKQQLiveAssetPlayerHookCallback {
    void openMediaPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo);

    void openMediaPlayerByAfd(Context context, AssetFileDescriptor assetFileDescriptor, long j3, long j16);

    void openMediaPlayerByPfd(Context context, ParcelFileDescriptor parcelFileDescriptor, long j3, long j16);

    void openMediaPlayerByUrl(Context context, String str, String str2, long j3, long j16, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo);

    void pause();

    void prepare();

    void setFlowId(String str);

    void start();

    void startAd();

    void stop();

    void updateReportParam(TVKProperties tVKProperties);
}
