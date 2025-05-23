package com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTTVKDataProvider;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.utils.b;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TVKDataBinder implements ITVKDataBinder {
    public static final String KEY_REPORT_TYPE = "report_type";
    private static final String TAG = "video.VideoDataBinder";
    public static final String VALUE_REPORT_TYPE_AD = "11";
    public static final String VALUE_REPORT_TYPE_VIDEO = "12";
    private VideoEntity mAdEntity;
    private boolean mAdNeedReportType;
    private final String mFlowId;
    private TVKNetVideoInfo mNetVideoInfo;
    private final IDTTVKDataProvider mProvider;
    private TVKProperties mReportProperties;
    private long mVideoDuration;
    private VideoEntity mVideoEntity;
    private TVKPlayerVideoInfo mVideoInfo;
    private boolean mVideoNeedReportType;
    private final Map<String, Object> mOpenParams = new HashMap();
    private final Map<String, Object> mBizParams = new HashMap();
    private final Object mVideoPlayer = new Object();
    private final Object mAdPlayer = new Object();

    public TVKDataBinder(String str, IDTTVKDataProvider iDTTVKDataProvider) {
        this.mFlowId = str;
        this.mProvider = iDTTVKDataProvider;
    }

    private String calculateReportType(boolean z16) {
        if (z16 && this.mAdNeedReportType) {
            this.mAdNeedReportType = false;
            return "11";
        }
        if (!z16 && this.mVideoNeedReportType) {
            this.mVideoNeedReportType = false;
            return "12";
        }
        return "";
    }

    private Map<String, Object> getInnerParams(boolean z16) {
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_REPORT_TYPE, calculateReportType(z16));
        return hashMap;
    }

    private String getVid() {
        String c16 = b.c(this.mVideoInfo);
        if (!TextUtils.isEmpty(c16)) {
            return c16;
        }
        TVKNetVideoInfo tVKNetVideoInfo = this.mNetVideoInfo;
        if (tVKNetVideoInfo != null && !TextUtils.isEmpty(tVKNetVideoInfo.getVid())) {
            return this.mNetVideoInfo.getVid();
        }
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onAdPrepared(ITVKPlayerEventListener.AdType adType, long j3) {
        Log.d(TAG, "[VideoPlayReport] onAdPrepare vid=" + getVid() + ", flowId=" + this.mFlowId + ", isBizReady=" + this.mProvider.isBizReady(this.mReportProperties) + ", adDuration=" + j3);
        if (!this.mProvider.active(this.mVideoInfo)) {
            return;
        }
        Map<String, ?> formatStartParams = this.mProvider.formatStartParams(this.mNetVideoInfo, false);
        String contentId = this.mProvider.getContentId(this.mVideoInfo);
        VideoEntity.Builder bizReady = new VideoEntity.Builder().bizReady(true);
        if (TextUtils.isEmpty(contentId)) {
            contentId = this.mFlowId;
        }
        VideoEntity build = bizReady.setContentId(contentId).setContentType(this.mProvider.getContentType(this.mVideoInfo, 1)).setIdentifier(getVid()).setVideoDuration((int) j3).addCustomParams(this.mOpenParams).addCustomParams(this.mBizParams).addCustomParams(formatStartParams).addCustomParams(getInnerParams(true)).build();
        this.mAdEntity = build;
        VideoReport.bindVideoPlayerInfo(this.mAdPlayer, build);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onAdStop() {
        Log.d(TAG, "[VideoPlayReport] onAdStop vid=" + getVid() + ", flowId=" + this.mFlowId + ", isBizReady=" + this.mProvider.isBizReady(this.mReportProperties));
        if (!this.mProvider.active(this.mVideoInfo)) {
            return;
        }
        VideoReport.unbindVideoPlayerInfo(this.mAdPlayer);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onNetVideoInfo(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        Log.d(TAG, "[VideoPlayReport] onNetVideoInfo vid=" + tVKNetVideoInfo.getVid() + ", flowId=" + this.mFlowId + ", isBizReady=" + this.mProvider.isBizReady(this.mReportProperties));
        this.mNetVideoInfo = tVKNetVideoInfo;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onOpenMedia(@NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo, String str) {
        Log.d(TAG, "[VideoPlayReport] onOpenMedia vid=" + b.c(tVKPlayerVideoInfo) + ", flowId=" + this.mFlowId + ", isBizReady=" + this.mProvider.isBizReady(tVKPlayerVideoInfo.getReportInfoProperties()));
        this.mVideoInfo = tVKPlayerVideoInfo;
        this.mReportProperties = tVKPlayerVideoInfo.getReportInfoProperties();
        this.mOpenParams.clear();
        this.mBizParams.clear();
        this.mOpenParams.putAll(this.mProvider.formatOpenParams(tVKPlayerVideoInfo, str));
        this.mBizParams.putAll(this.mProvider.formatBizParams(this.mReportProperties));
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onUpdateReportParam(@NonNull TVKProperties tVKProperties) {
        Log.d(TAG, "[VideoPlayReport] onUpdateReportParam vid=" + getVid() + ", flowId=" + this.mFlowId + ", isBizReady=" + this.mProvider.isBizReady(tVKProperties));
        this.mReportProperties = tVKProperties;
        this.mBizParams.putAll(this.mProvider.formatBizParams(tVKProperties));
        VideoEntity videoEntity = this.mVideoEntity;
        if (videoEntity != null) {
            VideoReport.updateVideoPlayerInfo(this.mVideoPlayer, new VideoBaseEntity.Builder(videoEntity).bizReady(this.mProvider.isBizReady(tVKProperties)).addCustomParams(this.mBizParams).build());
        }
        VideoEntity videoEntity2 = this.mAdEntity;
        if (videoEntity2 != null) {
            VideoReport.updateVideoPlayerInfo(this.mAdPlayer, new VideoBaseEntity.Builder(videoEntity2).bizReady(true).addCustomParams(this.mBizParams).build());
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onVideoPlay(@Nullable View view) {
        Log.d(TAG, "[VideoPlayReport] onVideoPlay vid=" + getVid() + ", flowId=" + this.mFlowId + ", isBizReady=" + this.mProvider.isBizReady(this.mReportProperties));
        if (!this.mProvider.active(this.mVideoInfo)) {
            return;
        }
        Map<String, ?> formatStartParams = this.mProvider.formatStartParams(this.mNetVideoInfo, false);
        String contentId = this.mProvider.getContentId(this.mVideoInfo);
        VideoEntity.Builder bizReady = new VideoEntity.Builder().bizReady(this.mProvider.isBizReady(this.mReportProperties));
        if (TextUtils.isEmpty(contentId)) {
            contentId = this.mFlowId;
        }
        VideoEntity build = bizReady.setContentId(contentId).setContentType(this.mProvider.getContentType(this.mVideoInfo, 2)).setVideoView(view).setIdentifier(getVid()).setVideoDuration((int) this.mVideoDuration).addCustomParams(this.mOpenParams).addCustomParams(this.mBizParams).addCustomParams(formatStartParams).addCustomParams(getInnerParams(false)).build();
        this.mVideoEntity = build;
        VideoReport.bindVideoPlayerInfo(this.mVideoPlayer, build);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onVideoPrepared(long j3) {
        Log.d(TAG, "[VideoPlayReport] onVideoPrepare vid=" + getVid() + ", flowId=" + this.mFlowId + ", isBizReady=" + this.mProvider.isBizReady(this.mReportProperties) + ", videoDuration=" + j3);
        this.mVideoDuration = j3;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder
    public void onVideoStop() {
        Log.d(TAG, "[VideoPlayReport] onVideoStop vid=" + getVid() + ", flowId=" + this.mFlowId + ", isBizReady=" + this.mProvider.isBizReady(this.mReportProperties));
        if (!this.mProvider.active(this.mVideoInfo)) {
            return;
        }
        VideoReport.unbindVideoPlayerInfo(this.mVideoPlayer);
    }
}
