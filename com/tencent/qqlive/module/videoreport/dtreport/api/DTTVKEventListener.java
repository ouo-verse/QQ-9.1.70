package com.tencent.qqlive.module.videoreport.dtreport.api;

import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.ITVKDataBinder;
import com.tencent.qqlive.module.videoreport.utils.b;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTTVKEventListener extends BaseTVKEventListener {
    private static final String TAG = "video.DTTVKEventListener";
    private final IDTTVKDataProvider mProvider;

    DTTVKEventListener(IDTTVKDataProvider iDTTVKDataProvider) {
        this.mProvider = iDTTVKDataProvider;
    }

    public static DTTVKEventListener create(IDTTVKDataProvider iDTTVKDataProvider) {
        return new DTTVKEventListener(iDTTVKDataProvider);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener
    protected void handleADPlay(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
        Log.d(TAG, "[VideoPlayReport] handleADPlay, flowId=" + eventParams.getFlowId());
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener
    protected void handleADPrepared(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
        Log.d(TAG, "[VideoPlayReport] handleADPrepared, flowId=" + eventParams.getFlowId());
        ITVKDataBinder.Factory.with(eventParams.getFlowId()).onAdPrepared((ITVKPlayerEventListener.AdType) eventParams.getParamByKey("adtype"), ((Long) eventParams.getParamByKey(ITVKPlayerEventListener.KEY_AD_DURATION)).longValue());
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener
    protected void handleADStop(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
        Log.d(TAG, "[VideoPlayReport] handleADStop, flowId=" + eventParams.getFlowId());
        ITVKDataBinder.Factory.with(eventParams.getFlowId()).onAdStop();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener
    protected void handleNetVideoInfo(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
        Log.d(TAG, "[VideoPlayReport] handleNetVideoInfo, flowId=" + eventParams.getFlowId());
        String flowId = eventParams.getFlowId();
        TVKNetVideoInfo tVKNetVideoInfo = (TVKNetVideoInfo) eventParams.getParamByKey(ITVKPlayerEventListener.KEY_NET_VIDEO_INFO);
        if (tVKNetVideoInfo == null) {
            return;
        }
        ITVKDataBinder.Factory.with(flowId).onNetVideoInfo(tVKNetVideoInfo);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener
    protected void handleOpenMedia(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
        Log.d(TAG, "[VideoPlayReport] handleOpenMedia, flowId=" + eventParams.getFlowId());
        TVKPlayerVideoInfo tVKPlayerVideoInfo = (TVKPlayerVideoInfo) eventParams.getParamByKey(ITVKPlayerEventListener.KEY_TVKPLAYERVIDEOINFO);
        if (tVKPlayerVideoInfo == null) {
            return;
        }
        String flowId = eventParams.getFlowId();
        String str = (String) eventParams.getParamByKey("url");
        if (TextUtils.isEmpty(b.b(tVKPlayerVideoInfo))) {
            b.d(tVKPlayerVideoInfo, flowId);
        }
        ITVKDataBinder.Factory.init(flowId, this.mProvider);
        ITVKDataBinder.Factory.with(flowId).onOpenMedia(tVKPlayerVideoInfo, str);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener
    protected void handleUpdateReportParam(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
        Log.d(TAG, "[VideoPlayReport] handleUpdateReportParam, flowId=" + eventParams.getFlowId());
        String flowId = eventParams.getFlowId();
        TVKProperties tVKProperties = (TVKProperties) eventParams.getParamByKey(ITVKPlayerEventListener.KEY_TVKPROPERTIES);
        if (tVKProperties == null) {
            return;
        }
        ITVKDataBinder.Factory.with(flowId).onUpdateReportParam(tVKProperties);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener
    protected void handleVideoPlay(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
        View view;
        Log.d(TAG, "[VideoPlayReport] handleVideoPlay, flowId=" + eventParams.getFlowId());
        String flowId = eventParams.getFlowId();
        if (iTVKMediaPlayer.getVideoView() instanceof View) {
            view = (View) iTVKMediaPlayer.getVideoView();
        } else {
            view = null;
        }
        ITVKDataBinder.Factory.with(flowId).onVideoPlay(view);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener
    protected void handleVideoPrepared(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
        Log.d(TAG, "[VideoPlayReport] handleVideoPrepared, flowId=" + eventParams.getFlowId());
        ITVKDataBinder.Factory.with(eventParams.getFlowId()).onVideoPrepared(((Long) eventParams.getParamByKey("videoDuration")).longValue());
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.BaseTVKEventListener
    protected void handleVideoStop(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.EventParams eventParams) {
        Log.d(TAG, "[VideoPlayReport] handleVideoStop, flowId=" + eventParams.getFlowId());
        String flowId = eventParams.getFlowId();
        ITVKDataBinder.Factory.with(flowId).onVideoStop();
        ITVKDataBinder.Factory.release(flowId);
    }
}
