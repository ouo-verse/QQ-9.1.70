package com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer;

import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DefaultTVKDataBinder implements ITVKDataBinder {
    private static final String TAG = "video.DefaultTVKDataBinder";

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onAdPrepared(ITVKPlayerEventListener.AdType adType, long j3) {
        Log.d(TAG, "[VideoPlayReport] onAdPrepare");
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onAdStop() {
        Log.d(TAG, "[VideoPlayReport] onAdStop");
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onNetVideoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
        Log.d(TAG, "[VideoPlayReport] onNetVideoInfo");
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onOpenMedia(TVKPlayerVideoInfo tVKPlayerVideoInfo, String str) {
        Log.d(TAG, "[VideoPlayReport] onOpenMedia");
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onUpdateReportParam(TVKProperties tVKProperties) {
        Log.d(TAG, "[VideoPlayReport] onUpdateReportParam");
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onVideoPlay(@Nullable View view) {
        Log.d(TAG, "[VideoPlayReport] onVideoPlay");
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onVideoPrepared(long j3) {
        Log.d(TAG, "[VideoPlayReport] onVideoPrepare");
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onVideoStop() {
        Log.d(TAG, "[VideoPlayReport] onVideoStop");
    }
}
