package com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOfflineVodVidAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKFormatIDChooser;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes23.dex */
abstract class TVKMediaSourceController implements ITVKMediaSourceController {
    protected static final int INVALID_DRM_TYPE = -1;
    protected static final int INVALID_REQUEST_ID = -1;
    private static final String TAG = "TVKMediaSourceController";

    @NonNull
    protected final TVKPlayerInputParam mInputParam;
    protected final ITVKLogger mLogger;

    @NonNull
    protected final ITVKMediaSourceListener mMediaSourceListener;

    @NonNull
    private final ITVKPlayerFeatureGroup mPlayerFeatureGroup;
    private final Set<Integer> mRequestIdSet = new HashSet();

    @NonNull
    protected final TVKPlayerRuntimeParam mRuntimeParam;

    @NonNull
    private final ITVKPlayerState mState;

    public TVKMediaSourceController(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull ITVKMediaSourceListener iTVKMediaSourceListener) {
        this.mLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, TAG);
        this.mInputParam = tVKQQLiveAssetPlayerContext.getInputParam();
        this.mRuntimeParam = tVKQQLiveAssetPlayerContext.getRuntimeParam();
        this.mState = tVKQQLiveAssetPlayerContext.getState();
        this.mPlayerFeatureGroup = tVKQQLiveAssetPlayerContext.getFeatureGroup();
        this.mMediaSourceListener = iTVKMediaSourceListener;
    }

    private void convertOfflineRequestToOnlineRequest() {
        this.mLogger.info("convert offline request to online request!", new Object[0]);
        ITVKAsset tVKAsset = this.mRuntimeParam.getTVKAsset();
        if (tVKAsset.getAssetType() == 262144) {
            TVKOfflineVodVidAsset tVKOfflineVodVidAsset = (TVKOfflineVodVidAsset) tVKAsset;
            this.mRuntimeParam.setTVKAsset(TVKAssetFactory.createOnlineVodVidAsset(tVKOfflineVodVidAsset.getVid(), tVKOfflineVodVidAsset.getCid()));
        }
        this.mInputParam.getPlayerVideoInfo().removeConfigMap(TVKPlayerVideoInfo.PLAYER_CFG_KEY_COMPATIBLE_MODE);
        requestNetVideoInfo(new TVKCGIRequestParam.Builder(this.mInputParam.getPlayerVideoInfo(), this.mRuntimeParam.getTVKAsset(), this.mInputParam.getUserInfo()).definition(this.mInputParam.getDefinition()).streamFormatId(TVKFormatIDChooser.chooseFormatID(this.mInputParam.getPlayerVideoInfo())).flowId(this.mInputParam.getFlowId()).build(), this.mPlayerFeatureGroup, TVKFeatureFactory.createFeatureParamGroup(this.mInputParam, this.mRuntimeParam));
    }

    private void printCGIResponse(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        String str;
        int i3;
        this.mLogger.info("****************************************************************", new Object[0]);
        this.mLogger.info("CGI : ** videoInfo Response **", new Object[0]);
        if (tVKNetVideoInfo instanceof TVKVodVideoInfo) {
            i3 = ((TVKVodVideoInfo) tVKNetVideoInfo).getDownloadType();
            str = "vod";
        } else if (tVKNetVideoInfo instanceof TVKLiveVideoInfo) {
            i3 = ((TVKLiveVideoInfo) tVKNetVideoInfo).getStream();
            str = "live";
        } else {
            str = "unknown";
            i3 = -1;
        }
        StringBuilder sb5 = new StringBuilder();
        for (TVKNetVideoInfo.DefnInfo defnInfo : tVKNetVideoInfo.getDefinitionList()) {
            sb5.append("(");
            sb5.append(defnInfo.getDefn());
            sb5.append(":");
            sb5.append(defnInfo.getDefnName());
            sb5.append(") ");
        }
        TVKNetVideoInfo.DefnInfo curDefinition = tVKNetVideoInfo.getCurDefinition();
        String vid = tVKNetVideoInfo.getVid();
        this.mLogger.info("CGI : response values : vid:" + vid, new Object[0]);
        this.mLogger.info("CGI : response values : playType:" + str, new Object[0]);
        this.mLogger.info("CGI : response values : format:" + i3, new Object[0]);
        this.mLogger.info("CGI : response values : cur definition:" + curDefinition.getDefn(), new Object[0]);
        this.mLogger.info("CGI : response values : definitions:" + ((Object) sb5), new Object[0]);
        this.mLogger.info("CGI : response values : duration:" + tVKNetVideoInfo.getDurationSec(), new Object[0]);
        this.mLogger.info("CGI : response values : cur videoCodec:" + curDefinition.getVideoCodec(), new Object[0]);
        this.mLogger.info("CGI : response values : cur audioCodec:" + curDefinition.getAudioCodec(), new Object[0]);
        if (tVKNetVideoInfo.isPreview()) {
            this.mLogger.info("CGI : response values : preview startPositionSec:" + tVKNetVideoInfo.getPreviewStartPositionSec(), new Object[0]);
            this.mLogger.info("CGI : response values : preview durationSec:" + tVKNetVideoInfo.getPreviewDurationSec(), new Object[0]);
        }
        if (curDefinition.getDrm() != -1) {
            this.mLogger.info("CGI : response values : cur definition drm:" + curDefinition.getDrm(), new Object[0]);
        }
        this.mLogger.info("CGI : response values : fps:" + tVKNetVideoInfo.getFps(), new Object[0]);
        this.mLogger.info("****************************************************************", new Object[0]);
    }

    private void updateLiveInfoToRuntimeParam(@NonNull TVKLiveVideoInfo tVKLiveVideoInfo) {
        this.mRuntimeParam.setMediaFormat(tVKLiveVideoInfo.getStream());
    }

    private void updateVodInfoToRuntimeParam(@NonNull TVKVodVideoInfo tVKVodVideoInfo) {
        this.mRuntimeParam.setVideoDurationMs(tVKVodVideoInfo.getDurationSec() * 1000);
        this.mRuntimeParam.setMediaFormat(tVKVodVideoInfo.getDownloadType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addRequestId(int i3) {
        this.mRequestIdSet.add(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRequestProcessedOrCanceled(int i3) {
        return !this.mRequestIdSet.contains(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean preprocessOnCGIFailure(int i3, @NonNull TVKError tVKError) {
        this.mLogger.error("preprocessOnCGIFailure(): requestId=[" + i3 + "], errorInfo = [" + tVKError + "]", new Object[0]);
        if (!this.mState.is(ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.warn("preprocessOnCGIFailure in invalid state=" + this.mState.state(), new Object[0]);
            return false;
        }
        if (tVKError.getMainErrorCode() != 1401025) {
            return true;
        }
        convertOfflineRequestToOnlineRequest();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean preprocessOnCGISuccess(int i3, @NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        List<ITVKPlayerFeature> livePlayerFeatureList;
        this.mLogger.info("preprocessOnCGISuccess() called with: requestId = [" + i3 + "], netVideoInfo = [" + tVKNetVideoInfo + "]", new Object[0]);
        if (!this.mState.is(ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.warn("preprocessOnCGISuccess in invalid state=" + this.mState.state(), new Object[0]);
            return false;
        }
        if (tVKNetVideoInfo.getCurDefinition() != null && !tVKNetVideoInfo.getDefinitionList().isEmpty()) {
            printCGIResponse(tVKNetVideoInfo);
            this.mRuntimeParam.setNetVideoInfo(tVKNetVideoInfo);
            Collections.emptyList();
            if (tVKNetVideoInfo instanceof TVKVodVideoInfo) {
                updateVodInfoToRuntimeParam((TVKVodVideoInfo) tVKNetVideoInfo);
                livePlayerFeatureList = this.mPlayerFeatureGroup.getVodPlayerFeatureList();
            } else if (tVKNetVideoInfo instanceof TVKLiveVideoInfo) {
                updateLiveInfoToRuntimeParam((TVKLiveVideoInfo) tVKNetVideoInfo);
                livePlayerFeatureList = this.mPlayerFeatureGroup.getLivePlayerFeatureList();
            } else {
                this.mLogger.error("unhandled netVideoInfo=" + tVKNetVideoInfo.getClass(), new Object[0]);
                return false;
            }
            Iterator<ITVKPlayerFeature> it = livePlayerFeatureList.iterator();
            while (it.hasNext()) {
                it.next().processOnCGISuccess(this.mInputParam, this.mRuntimeParam);
            }
            return true;
        }
        TVKError tVKError = new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETVINFO_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.EMPTY_DEFINITION_LIST_ERR);
        tVKError.addExtraInfo(TVKError.ExtraInfoKey.NET_VIDEO_INFO, tVKNetVideoInfo);
        this.mMediaSourceListener.onFailure(i3, this.mRuntimeParam.getTVKAsset(), tVKError);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeRequestId(int i3) {
        this.mRequestIdSet.remove(Integer.valueOf(i3));
    }
}
