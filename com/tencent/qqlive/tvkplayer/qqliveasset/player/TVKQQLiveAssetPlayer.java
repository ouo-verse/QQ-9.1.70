package com.tencent.qqlive.tvkplayer.qqliveasset.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.JsonObject;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKAudioFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.TVKDefinitionType;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAfdAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineSimulatedLiveAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKPfdAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKUrlAsset;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKPostProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKVideoFxProcessor;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer;
import com.tencent.qqlive.tvkplayer.api.subtitle.ITVKSubtitleRendererController;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.capability.TVKCapabilityMgr;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.context.TVKDebugTrackingEventReporter;
import com.tencent.qqlive.tvkplayer.context.TVKReportEventParamsInner;
import com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate;
import com.tencent.qqlive.tvkplayer.postprocess.api.ITVKVideoFxErrorListener;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKPositionTransformUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKQQLiveAssetPlayerListenerEmpty;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureExtraParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKPlayerMsgHandler;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.params.TVKOptionalParamsGenerator;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.params.TVKTPPlayerConstructParamGenerator;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceController;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceListener;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.TVKMediaSourceControllerFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.audio.TVKAudioPostProcessor;
import com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.video.TVKVideoPostProcessor;
import com.tencent.qqlive.tvkplayer.qqliveasset.richmedia.ITVKRichMediaSynchronizerInternal;
import com.tencent.qqlive.tvkplayer.qqliveasset.richmedia.TVKRichMediaSynchronizerInternal;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.TVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKFormatIDChooser;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKPostProcessorStrategy;
import com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.ITVKSubtitleRenderer;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.external.TVKAudioTrackExternal;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.external.TVKSubtitleTrackExternal;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKDefinitionUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKElapsedTimeStatistics;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKImageUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLongTextPrinter;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener;
import com.tencent.qqlive.tvkplayer.tpplayer.api.TVKTPPlayerFactory;
import com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface;
import com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPSimulatedLiveMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;
import com.tencent.thumbplayer.api.asset.TPMediaAssetFactory;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPPropertyID;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.ITPMediaAssetRequest;
import com.tencent.thumbplayer.api.player.TPPlayerConstructParams;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotParams;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes23.dex */
public class TVKQQLiveAssetPlayer implements ITVKQQLiveAssetPlayer, ITVKQQLiveAssetPlayerSharedOperator, ITVKTPPlayerListener, ITVKMediaPlayerPrivate, ITVKVideoFxErrorListener {
    private static final String API_CALL_PREFIX = "api call: ";
    private static final String MODULE_NAME = "TVKQQLiveAssetPlayer";
    private static final int MSG_CHECK_PERMISSION_TIMEOUT_FOR_LIVE = 65535;
    private static final AtomicInteger sVideoSnapshotTaskId = new AtomicInteger(1);

    @NonNull
    private final TVKQQLiveAssetPlayerContext mAssetPlayerContext;
    private ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener mAssetPlayerListener = new TVKQQLiveAssetPlayerListenerEmpty();
    private int mAssetRequestId = -1;
    private ITVKMediaSourceController mAssetRequester;
    private final TVKAudioPostProcessor mAudioPostProcessor;

    @NonNull
    private final TVKPlayerInputParam mInputParam;
    private final boolean mIsLooperFromThreadPool;
    private final ITVKLogger mLogger;

    @NonNull
    private final TVKMediaTrackSelector mMediaTrackSelector;

    @NonNull
    private ITVKTPPlayer mPlayer;

    @NonNull
    private final TVKPlayerMsgHandler mPlayerMsgHandler;

    @NonNull
    private final TVKPlayerRealTimeInfoProcessor mRealTimeInfoProcessor;

    @NonNull
    private final ITVKRichMediaSynchronizerInternal mRichMediaSynchronizerInternal;

    @NonNull
    private final TVKPlayerRuntimeParam mRunTimeParam;

    @NonNull
    private final TVKPlayerState mState;
    private final ITVKSubtitleRenderer mSubtitleRenderer;
    private ITVKTPPlayerListener mTVKTPPlayerListener;

    @NonNull
    private final TVKTPReporter mTVKTPReporter;
    private final TVKVideoPostProcessor mVideoPostProcessor;

    @NonNull
    private final Handler mWorkThreadHandler;

    @NonNull
    private final Looper mWorkThreadLooper;

    /* loaded from: classes23.dex */
    private class QQLiveAssetRenderSurfaceCallback implements ITVKRenderSurface.IVideoSurfaceCallback {
        private Surface mCurSurface;
        private final TVKElapsedTimeStatistics mTimeStatistics;

        QQLiveAssetRenderSurfaceCallback() {
            this.mCurSurface = null;
            this.mTimeStatistics = new TVKElapsedTimeStatistics();
        }

        @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface.IVideoSurfaceCallback
        public void onSurfaceChanged(ITVKRenderSurface iTVKRenderSurface, Surface surface) {
            TVKQQLiveAssetPlayer.this.mLogger.info("renderSurface onSurfaceChanged", new Object[0]);
            if (TVKQQLiveAssetPlayer.this.mState.is(ITVKPlayerState.STATE.ERROR, ITVKPlayerState.STATE.RELEASED)) {
                TVKQQLiveAssetPlayer.this.mLogger.warn("renderSurface onSurfaceChanged, invalid state:" + TVKQQLiveAssetPlayer.this.mState.state(), new Object[0]);
                return;
            }
            if (this.mCurSurface == surface) {
                return;
            }
            this.mTimeStatistics.point();
            TVKQQLiveAssetPlayer.this.setSurface(surface);
            TVKQQLiveAssetPlayer.this.mLogger.info("onSurfaceChanged, setSurface cost=" + this.mTimeStatistics.costTimeMsFromLastPoint(), new Object[0]);
            this.mCurSurface = surface;
        }

        @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface.IVideoSurfaceCallback
        public void onSurfaceCreated(ITVKRenderSurface iTVKRenderSurface, Surface surface) {
            TVKQQLiveAssetPlayer.this.mLogger.info("renderSurface onSurfaceCreated", new Object[0]);
            if (TVKQQLiveAssetPlayer.this.mState.is(ITVKPlayerState.STATE.ERROR, ITVKPlayerState.STATE.RELEASED)) {
                TVKQQLiveAssetPlayer.this.mLogger.warn("renderSurface onSurfaceCreated, invalid state:" + TVKQQLiveAssetPlayer.this.mState.state(), new Object[0]);
                return;
            }
            TVKQQLiveAssetPlayer.this.mRunTimeParam.setBackground(false);
            TVKQQLiveAssetPlayer.this.setSurface(surface);
            this.mCurSurface = surface;
        }

        @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface.IVideoSurfaceCallback
        public void onSurfaceDestroyed(ITVKRenderSurface iTVKRenderSurface, Surface surface) {
            TVKQQLiveAssetPlayer.this.mLogger.info("renderSurface onSurfaceDestroyed", new Object[0]);
            if (TVKQQLiveAssetPlayer.this.mState.is(ITVKPlayerState.STATE.ERROR, ITVKPlayerState.STATE.RELEASED)) {
                TVKQQLiveAssetPlayer.this.mLogger.warn("renderSurface onSurfaceDestroyed, invalid state:" + TVKQQLiveAssetPlayer.this.mState.state(), new Object[0]);
                return;
            }
            TVKQQLiveAssetPlayer.this.mRunTimeParam.setBackground(true);
            this.mTimeStatistics.point();
            TVKQQLiveAssetPlayer.this.setSurface(null);
            TVKQQLiveAssetPlayer.this.mLogger.info("onSurfaceDestroyed, setSurface cost=" + this.mTimeStatistics.costTimeMsFromLastPoint(), new Object[0]);
            this.mCurSurface = null;
        }
    }

    /* loaded from: classes23.dex */
    private class QQLiveAssetRequesterListener implements ITVKMediaSourceListener {
        QQLiveAssetRequesterListener() {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceListener
        public void onFailure(int i3, ITVKAsset iTVKAsset, @NonNull TVKError tVKError) {
            TVKQQLiveAssetPlayer.this.processError(tVKError);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceListener
        public void onSuccess(int i3, ITVKAsset iTVKAsset, @NonNull ITPMediaAsset iTPMediaAsset, @NonNull TVKNetVideoInfo tVKNetVideoInfo) {
            if (TVKQQLiveAssetPlayer.this.isPreviewInvalid(tVKNetVideoInfo)) {
                TVKQQLiveAssetPlayer.this.processPlayerPermissionTimeout("CGI.onSuccess, preview invalid: previewStartPositionSec=" + tVKNetVideoInfo.getPreviewStartPositionSec() + " previewDurationSec=" + tVKNetVideoInfo.getPreviewDurationSec() + " startPositionMs=" + TVKQQLiveAssetPlayer.this.mRunTimeParam.getStartPositionMs());
                return;
            }
            if (TVKQQLiveAssetPlayer.this.mRunTimeParam.isQuickPlayWithOfflineResource()) {
                TVKQQLiveAssetPlayer.this.mAssetPlayerListener.onInfo(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_QUICK_PLAY_WITH_OFFLINE_RESOURCE, 0L, 0L, null);
            }
            TVKQQLiveAssetPlayer.this.processCGIRequestSuccess(tVKNetVideoInfo);
            TVKQQLiveAssetPlayer.this.mRunTimeParam.setLastPositionMs(TVKQQLiveAssetPlayer.this.mRunTimeParam.getStartPositionMs());
            TVKQQLiveAssetPlayer.this.mRunTimeParam.setTPMediaAsset(iTPMediaAsset);
            TVKQQLiveAssetPlayer.this.mState.changeState(ITVKPlayerState.STATE.CGIED);
            TVKQQLiveAssetPlayer.this.mAssetPlayerListener.onVideoCGIed(tVKNetVideoInfo);
        }
    }

    /* loaded from: classes23.dex */
    private class WorkerThreadHandler extends Handler {
        public WorkerThreadHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 65535) {
                TVKQQLiveAssetPlayer.this.processPlayerPermissionTimeout("timer check live permission timeout");
            }
        }
    }

    public TVKQQLiveAssetPlayer(@NonNull TVKContext tVKContext, @Nullable ITVKDrawableContainer iTVKDrawableContainer, @Nullable Looper looper, @Nullable Looper looper2) {
        if (looper == null) {
            this.mWorkThreadLooper = TVKThreadPool.getInstance().obtainHandleThread(MODULE_NAME, TVKMediaPlayerConfig.PlayerConfig.default_tvk_work_thread_priority).getLooper();
            this.mIsLooperFromThreadPool = true;
        } else {
            this.mWorkThreadLooper = looper;
            this.mIsLooperFromThreadPool = false;
        }
        this.mWorkThreadHandler = new WorkerThreadHandler(this.mWorkThreadLooper);
        ITVKTPPlayer createTVKTPPlayer = TVKTPPlayerFactory.createTVKTPPlayer(tVKContext, this.mWorkThreadLooper);
        this.mPlayer = createTVKTPPlayer;
        this.mTVKTPPlayerListener = this;
        createTVKTPPlayer.setTVKTPPlayerListener(this);
        TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext = new TVKQQLiveAssetPlayerContext(tVKContext, this.mPlayer, this, this.mWorkThreadLooper, looper2);
        this.mAssetPlayerContext = tVKQQLiveAssetPlayerContext;
        tVKQQLiveAssetPlayerContext.setAssetPlayerListener(this.mAssetPlayerListener);
        TVKPlayerInputParam inputParam = tVKQQLiveAssetPlayerContext.getInputParam();
        this.mInputParam = inputParam;
        TVKPlayerRuntimeParam runtimeParam = tVKQQLiveAssetPlayerContext.getRuntimeParam();
        this.mRunTimeParam = runtimeParam;
        this.mState = tVKQQLiveAssetPlayerContext.getState();
        inputParam.setWorkThreadLooper(this.mWorkThreadLooper);
        inputParam.setCallbackLooper(looper2);
        inputParam.setDrawableContainer(iTVKDrawableContainer);
        if (iTVKDrawableContainer instanceof ITVKVideoViewPrivate) {
            ITVKVideoViewPrivate iTVKVideoViewPrivate = (ITVKVideoViewPrivate) iTVKDrawableContainer;
            updatePlayerViewDisplayParams(iTVKVideoViewPrivate);
            inputParam.setPlayerView(iTVKVideoViewPrivate);
        }
        TVKLogger tVKLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, MODULE_NAME);
        this.mLogger = tVKLogger;
        this.mRichMediaSynchronizerInternal = new TVKRichMediaSynchronizerInternal(tVKQQLiveAssetPlayerContext, inputParam, runtimeParam);
        TVKVideoPostProcessor videoPostProcessor = tVKQQLiveAssetPlayerContext.getVideoPostProcessor();
        this.mVideoPostProcessor = videoPostProcessor;
        videoPostProcessor.setErrorListener(this);
        videoPostProcessor.addVideoSurfaceCallBack(new QQLiveAssetRenderSurfaceCallback());
        this.mAudioPostProcessor = tVKQQLiveAssetPlayerContext.getAudioPostProcessor();
        this.mSubtitleRenderer = tVKQQLiveAssetPlayerContext.getSubtitleRenderer();
        if (iTVKDrawableContainer instanceof ITVKRenderSurface) {
            videoPostProcessor.setOutputRenderSurface((ITVKRenderSurface) iTVKDrawableContainer);
        }
        this.mPlayerMsgHandler = new TVKPlayerMsgHandler(tVKQQLiveAssetPlayerContext);
        this.mRealTimeInfoProcessor = new TVKPlayerRealTimeInfoProcessor(tVKQQLiveAssetPlayerContext);
        this.mMediaTrackSelector = tVKQQLiveAssetPlayerContext.getMediaTrackSelector();
        this.mTVKTPReporter = new TVKTPReporter(this.mPlayer.getReportManager());
        tVKLogger.info("TVKQQLiveAssetPlayer created, drawableContainer: " + iTVKDrawableContainer, new Object[0]);
    }

    private void cancelAssetRequestIfExist() {
        if (this.mAssetRequester != null && this.mAssetRequestId != -1) {
            this.mLogger.info("cancel CGI request, requestId=" + this.mAssetRequestId, new Object[0]);
            this.mAssetRequester.cancelRequest(this.mAssetRequestId);
        }
    }

    private void connectVideoPostProcessor(TVKVideoPostProcessor tVKVideoPostProcessor) {
        boolean z16;
        if (this.mRunTimeParam.isDolbyVision() && TVKCapabilityMgr.getInstance().isSupportDolbyVisionSoftRender()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mLogger.info("connectVideoPostProcessor, needDVMA =" + z16 + ", needSDREnhance = " + this.mRunTimeParam.isNeedSDREnhance() + ", needSuperResolution =" + this.mRunTimeParam.isNeedSuperResolution(), new Object[0]);
        if (z16) {
            this.mVideoPostProcessor.addDolbyVisionSoftRenderEffect();
            this.mAssetPlayerListener.onInfo(601, 0L, 0L, null);
        }
        if (this.mRunTimeParam.isNeedSDREnhance()) {
            this.mVideoPostProcessor.addSDREnhanceEffect();
        }
        if (this.mRunTimeParam.isNeedSuperResolution()) {
            this.mVideoPostProcessor.addSuperResolutionEffect();
        }
        boolean connectPostProcessor = tVKVideoPostProcessor.connectPostProcessor(this.mRunTimeParam.getVideoWidth(), this.mRunTimeParam.getVideoHeight());
        this.mLogger.info("connectVideoPostProcessor success: " + connectPostProcessor, new Object[0]);
    }

    private long correctLoopEndPosition(long j3) {
        TVKNetVideoInfo netVideoInfo = this.mRunTimeParam.getNetVideoInfo();
        if (!(netVideoInfo instanceof TVKVodVideoInfo)) {
            return j3;
        }
        long adjustSkipStartPositionForEmbeddedAd = TVKPositionTransformUtils.adjustSkipStartPositionForEmbeddedAd(TVKPositionTransformUtils.adjustSkipStartPositionForPluginAd(j3, netVideoInfo), netVideoInfo);
        if (this.mRunTimeParam.isPreview()) {
            if (adjustSkipStartPositionForEmbeddedAd <= 0) {
                adjustSkipStartPositionForEmbeddedAd = this.mRunTimeParam.getVideoDurationMs();
            }
            long previewStartPositionSec = netVideoInfo.getPreviewStartPositionSec() * 1000;
            return Math.min(Math.max(adjustSkipStartPositionForEmbeddedAd, previewStartPositionSec), (netVideoInfo.getPreviewDurationSec() * 1000) + previewStartPositionSec);
        }
        return adjustSkipStartPositionForEmbeddedAd;
    }

    private long correctLoopStartPosition(long j3) {
        TVKNetVideoInfo netVideoInfo = this.mRunTimeParam.getNetVideoInfo();
        if (!(netVideoInfo instanceof TVKVodVideoInfo)) {
            return j3;
        }
        long adjustSkipStartPositionForEmbeddedAd = TVKPositionTransformUtils.adjustSkipStartPositionForEmbeddedAd(TVKPositionTransformUtils.adjustSkipStartPositionForPluginAd(j3, netVideoInfo), netVideoInfo);
        if (this.mRunTimeParam.isPreview()) {
            long previewStartPositionSec = netVideoInfo.getPreviewStartPositionSec() * 1000;
            return Math.min(Math.max(adjustSkipStartPositionForEmbeddedAd, previewStartPositionSec), (netVideoInfo.getPreviewDurationSec() * 1000) + previewStartPositionSec);
        }
        return adjustSkipStartPositionForEmbeddedAd;
    }

    private void disconnectVideoPostProcessor(TVKVideoPostProcessor tVKVideoPostProcessor) {
        boolean disconnectPostProcessor = tVKVideoPostProcessor.disconnectPostProcessor();
        this.mLogger.info("disconnectVideoPostProcessor success: " + disconnectPostProcessor, new Object[0]);
    }

    private void dumpMap(String str, Map<String, String> map) {
        StringBuilder sb5 = new StringBuilder(str);
        sb5.append("(");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb5.append("[");
                sb5.append(entry.getKey());
                sb5.append("]");
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append("[");
                sb5.append(entry.getValue());
                sb5.append("]&");
            }
        } else {
            sb5.append("null");
        }
        sb5.append(")");
        String sb6 = sb5.toString();
        final ITVKLogger iTVKLogger = this.mLogger;
        Objects.requireNonNull(iTVKLogger);
        TVKLongTextPrinter.print(sb6, new TVKLongTextPrinter.Printer() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.player.a
            @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKLongTextPrinter.Printer
            public final void print(String str2) {
                TVKQQLiveAssetPlayer.lambda$dumpMap$2(ITVKLogger.this, str2);
            }
        });
    }

    private void dumpOpenMediaPlayerParams() {
        TVKPlayerVideoInfo playerVideoInfo = this.mInputParam.getPlayerVideoInfo();
        if (playerVideoInfo == null) {
            this.mLogger.info("### TVKPlayerVideoInfo is null", new Object[0]);
            return;
        }
        this.mLogger.info("### TVKPlayerVideoInfo", new Object[0]);
        String str = "### Asset: " + playerVideoInfo.getAsset();
        final ITVKLogger iTVKLogger = this.mLogger;
        Objects.requireNonNull(iTVKLogger);
        TVKLongTextPrinter.print(str, new TVKLongTextPrinter.Printer() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.player.b
            @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKLongTextPrinter.Printer
            public final void print(String str2) {
                TVKQQLiveAssetPlayer.lambda$dumpOpenMediaPlayerParams$0(ITVKLogger.this, str2);
            }
        });
        dumpMap("### ConfigMap: ", playerVideoInfo.getConfigMap());
        dumpMap("### ExtraRequestParamsMap: ", playerVideoInfo.getExtraRequestParamsMap());
        dumpMap("### AdReportInfo: ", playerVideoInfo.getAdReportInfoMap());
        dumpMap("### ProxyExtra: ", playerVideoInfo.getProxyExtraMap());
        dumpMap("### AdRequestParamMap: ", playerVideoInfo.getAdRequestParamMap());
        String str2 = "### ReportInfoProperties: " + playerVideoInfo.getReportInfoProperties();
        final ITVKLogger iTVKLogger2 = this.mLogger;
        Objects.requireNonNull(iTVKLogger2);
        TVKLongTextPrinter.print(str2, new TVKLongTextPrinter.Printer() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.player.c
            @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKLongTextPrinter.Printer
            public final void print(String str3) {
                TVKQQLiveAssetPlayer.lambda$dumpOpenMediaPlayerParams$1(ITVKLogger.this, str3);
            }
        });
        TVKUserInfo userInfo = this.mInputParam.getUserInfo();
        if (userInfo == null) {
            this.mLogger.info("### TVKUserInfo is null", new Object[0]);
            return;
        }
        this.mLogger.info("### TVKUserInfo", new Object[0]);
        this.mLogger.info("### isVip: " + userInfo.isVip(), new Object[0]);
    }

    private void generateOptionalParamAndSet(boolean z16) {
        Iterator<TPOptionalParam<?>> it = TVKOptionalParamsGenerator.generateOptionalParamList(this.mAssetPlayerContext, z16).iterator();
        while (it.hasNext()) {
            this.mPlayer.addOptionalParam(it.next());
        }
        Iterator<TPOptionalParam<?>> it5 = this.mInputParam.getInitOptionalParamList().iterator();
        while (it5.hasNext()) {
            this.mPlayer.addOptionalParam(it5.next());
        }
    }

    private void handleAudioPostProcessor() {
        if (this.mInputParam.isAudioProcessorConnected()) {
            this.mLogger.info("audio post processor is need to reactivate", new Object[0]);
            this.mAudioPostProcessor.connectPostProcessor();
        }
    }

    private void handleVideoPostProcessor() {
        if (this.mInputParam.isVideoProcessorConnected() || TVKPostProcessorStrategy.isNeedConnectVideoProcessor(this.mRunTimeParam, this.mAssetPlayerContext.getCurrentPlayerFeatureList())) {
            this.mLogger.info("video post processor is need to reactivate", new Object[0]);
            connectVideoPostProcessor(this.mVideoPostProcessor);
        }
    }

    private boolean isGetPlayerParamInvalidState() {
        return this.mState.is(ITVKPlayerState.STATE.RELEASED);
    }

    private boolean isLivePreviewInvalid(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        if (tVKNetVideoInfo.getLiveCurrentPreviewDurationSec() <= 0) {
            return true;
        }
        return false;
    }

    private boolean isNeedChangePlayerCore(int i3, TPPlayerConstructParams tPPlayerConstructParams) {
        int[] iArr;
        if (tPPlayerConstructParams != null) {
            for (TPOptionalParam<?> tPOptionalParam : tPPlayerConstructParams.getOptionalParams()) {
                if (TPPlayerConstructParams.CONSTRUCT_ID_QUEUE_INT_CORE_TYPE.equals(tPOptionalParam.getKey())) {
                    iArr = (int[]) tPOptionalParam.getValue();
                    break;
                }
            }
        }
        iArr = null;
        if (iArr != null && iArr.length != 0) {
            if (iArr[0] != i3) {
                return true;
            }
            return false;
        }
        if (i3 != 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPreviewInvalid(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        if (!tVKNetVideoInfo.isPreview()) {
            return false;
        }
        if (tVKNetVideoInfo instanceof TVKVodVideoInfo) {
            return isVodPreviewInvalid(tVKNetVideoInfo);
        }
        if (!(tVKNetVideoInfo instanceof TVKLiveVideoInfo)) {
            return false;
        }
        return isLivePreviewInvalid(tVKNetVideoInfo);
    }

    private boolean isSetPlayerParamInvalidState() {
        return this.mState.is(ITVKPlayerState.STATE.RELEASED);
    }

    private boolean isVodPreviewInvalid(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        if (this.mInputParam.getPlayerVideoInfo().getAsset() instanceof TVKOnlineSimulatedLiveAsset) {
            if (tVKNetVideoInfo.getPreviewDurationSec() > 0) {
                return false;
            }
            return true;
        }
        long startPositionMs = this.mRunTimeParam.getStartPositionMs();
        long previewStartPositionSec = tVKNetVideoInfo.getPreviewStartPositionSec() * 1000;
        long previewStartPositionSec2 = (tVKNetVideoInfo.getPreviewStartPositionSec() + tVKNetVideoInfo.getPreviewDurationSec()) * 1000;
        if (startPositionMs >= previewStartPositionSec && startPositionMs < previewStartPositionSec2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$dumpMap$2(ITVKLogger iTVKLogger, String str) {
        iTVKLogger.info(str, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$dumpOpenMediaPlayerParams$0(ITVKLogger iTVKLogger, String str) {
        iTVKLogger.info(str, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$dumpOpenMediaPlayerParams$1(ITVKLogger iTVKLogger, String str) {
        iTVKLogger.info(str, new Object[0]);
    }

    private void notifyAudioPostProcessorCgiSuccess() {
        if (this.mState.is(ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mAudioPostProcessor.onCGIRequestSuccess();
        }
    }

    private void openMediaPlayerByUrlImpl(Context context, String str, String str2, long j3, long j16, @Nullable TVKUserInfo tVKUserInfo, @Nullable TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        Map<String, String> map;
        if (context == null) {
            this.mLogger.error("api call: openMediaPlayerByUrl, context is null", new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.mLogger.error("api call: openMediaPlayerByUrl, url is empty", new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAY_URL_EMPTY_ERR));
            return;
        }
        if (!this.mState.is(ITVKPlayerState.STATE.IDLE)) {
            this.mLogger.error("api call: openMediaPlayerByUrl, invalidState: " + this.mState.state(), new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_STATE_ERR));
            return;
        }
        this.mLogger.info("api call: openMediaPlayerByUrl, url=" + str + "fileID=" + str2 + ", startPositionMs=" + j3 + ", skipEndPositionMs=" + j16, new Object[0]);
        setUpParamsWhenOpenMediaPlayer(context, tVKUserInfo, tVKPlayerVideoInfo, "", j3, j16);
        dumpOpenMediaPlayerParams();
        if (tVKPlayerVideoInfo != null && tVKPlayerVideoInfo.getAsset() != null && tVKPlayerVideoInfo.getAsset().getAssetType() == 2) {
            map = ((TVKUrlAsset) tVKPlayerVideoInfo.getAsset()).getCdnHttpHeaderMap();
        } else {
            map = null;
        }
        ITPUrlMediaAsset createUrlMediaAsset = TPMediaAssetFactory.createUrlMediaAsset(str);
        createUrlMediaAsset.setHttpHeader(map);
        createUrlMediaAsset.setParam("dl_param_play_keyid", str2);
        this.mRunTimeParam.setTPMediaAsset(createUrlMediaAsset);
        this.mTVKTPReporter.setPlayerVideoInfo(tVKPlayerVideoInfo);
        this.mTVKTPReporter.onOpenMediaPlayer();
        this.mState.changeState(ITVKPlayerState.STATE.CGIED);
        this.mAssetPlayerListener.onVideoCGIed(this.mRunTimeParam.getNetVideoInfo());
    }

    private boolean permissionTimeOutLive(TVKLiveVideoInfo tVKLiveVideoInfo) {
        if (!tVKLiveVideoInfo.isPreview() || (SystemClock.elapsedRealtime() - this.mRunTimeParam.getLiveStartPlayTimeMs()) / 1000 < tVKLiveVideoInfo.getLiveCurrentPreviewDurationSec()) {
            return false;
        }
        return true;
    }

    private boolean permissionTimeOutVod(long j3, TVKVodVideoInfo tVKVodVideoInfo) {
        boolean z16;
        if (!tVKVodVideoInfo.isPreview()) {
            return false;
        }
        long previewStartPositionSec = tVKVodVideoInfo.getPreviewStartPositionSec() * 1000;
        long previewStartPositionSec2 = (tVKVodVideoInfo.getPreviewStartPositionSec() + tVKVodVideoInfo.getPreviewDurationSec()) * 1000;
        if (j3 >= previewStartPositionSec && j3 <= previewStartPositionSec2) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.mLogger.warn("permissionTimeoutByPos, previewStartTimeMs=" + previewStartPositionSec + ", previewEndTimeMs=" + previewStartPositionSec2 + ", positionMs=" + j3, new Object[0]);
        }
        return z16;
    }

    private boolean permissionTimeoutByPos(long j3) {
        TVKNetVideoInfo netVideoInfo = this.mRunTimeParam.getNetVideoInfo();
        if (netVideoInfo == null) {
            return false;
        }
        if (TVKAssetUtils.isLiveAsset(this.mRunTimeParam.getTVKAsset())) {
            return permissionTimeOutLive((TVKLiveVideoInfo) netVideoInfo);
        }
        if (!TVKAssetUtils.isVodAsset(this.mRunTimeParam.getTVKAsset())) {
            return false;
        }
        return permissionTimeOutVod(j3, (TVKVodVideoInfo) netVideoInfo);
    }

    private void processAntiScreenShot(int i3) {
        if (TVKMediaPlayerConfig.PlayerConfig.enable_dok_check && this.mRunTimeParam.getNetVideoInfo() != null && this.mRunTimeParam.getNetVideoInfo().isAntiScreenShot()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("1", this.mInputParam.getUserInfo().getVUserId());
            jsonObject.addProperty("2", TVKCommParams.getStaGuid());
            jsonObject.addProperty("3", this.mRunTimeParam.getNetVideoInfo().getVid());
            CKeyFacade.doK(jsonObject.toString(), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPlayerPermissionTimeout(@NonNull String str) {
        this.mLogger.error("processPlayerPermissionTimeout, msg=" + str, new Object[0]);
        stopAndResetPlayer();
        this.mState.changeState(ITVKPlayerState.STATE.COMPLETE);
        this.mAssetPlayerListener.onPermissionTimeout();
    }

    private void processSkipEndPositionForTimeOutLogicWhenVideoPrepared() {
        if (TVKAssetUtils.isVodAsset(this.mRunTimeParam.getTVKAsset()) && this.mRunTimeParam.isPreview()) {
            long durationMs = this.mPlayer.getDurationMs();
            long previewStartPositionSec = (this.mRunTimeParam.getNetVideoInfo().getPreviewStartPositionSec() + this.mRunTimeParam.getNetVideoInfo().getPreviewDurationSec()) * 1000;
            long j3 = durationMs - previewStartPositionSec;
            this.mLogger.info("isPreview, videoDurationMs=" + durationMs + ", cgiPreviewEndPositionMs=" + previewStartPositionSec + ", skipEndPositionEndMs=" + j3, new Object[0]);
            this.mRunTimeParam.setSkipEndPositionMs(j3);
            this.mPlayer.addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_GLOBAL_LONG_SKIP_END_TIME_MS, j3));
        }
    }

    private void removeVideoSurfaceCallBack(ITVKRenderSurface.IVideoSurfaceCallback iVideoSurfaceCallback) {
        if (this.mInputParam.getDrawableContainer() instanceof ITVKRenderSurface) {
            ((ITVKRenderSurface) this.mInputParam.getDrawableContainer()).removeVideoSurfaceCallBack(iVideoSurfaceCallback);
        }
    }

    private void reportEvent(ITVKReportEventListener.ReportEvent reportEvent, TVKReportEventParamsInner tVKReportEventParamsInner) {
        TVKDebugTrackingEventReporter debugTrackingEventReporter = this.mAssetPlayerContext.getDebugTrackingEventReporter();
        if (debugTrackingEventReporter == null) {
            this.mLogger.warn("tvkContext.debugTrackingEventReporter == null, can not report event=" + reportEvent.name(), new Object[0]);
            return;
        }
        this.mLogger.debug("event happens: " + reportEvent.name() + " in " + tVKReportEventParamsInner.getTimeSince1970Ms(), new Object[0]);
        debugTrackingEventReporter.sendEvent(reportEvent, tVKReportEventParamsInner);
    }

    private void resetAndChangePlayerIfNeededBeforePrepare() {
        TPPlayerConstructParams generatePlayerConstructParam = TVKTPPlayerConstructParamGenerator.generatePlayerConstructParam(this.mAssetPlayerContext);
        if (!isNeedChangePlayerCore(this.mPlayer.getPlayerCoreType(), generatePlayerConstructParam)) {
            this.mPlayer.reset();
            return;
        }
        this.mPlayer.reset();
        this.mPlayer.release();
        ITVKTPPlayer createTVKTPPlayer = TVKTPPlayerFactory.createTVKTPPlayer(this.mAssetPlayerContext, this.mInputParam.getWorkThreadLooper(), generatePlayerConstructParam);
        this.mPlayer = createTVKTPPlayer;
        createTVKTPPlayer.setSurface(this.mVideoPostProcessor.getRenderSurface());
        this.mPlayer.setTVKTPPlayerListener(this.mTVKTPPlayerListener);
        this.mAssetPlayerContext.setPlayer(this.mPlayer);
    }

    private void seekToImpl(int i3, int i16, String str) {
        TVKPlayerState tVKPlayerState = this.mState;
        ITVKPlayerState.STATE state = ITVKPlayerState.STATE.PREPARED;
        if (!tVKPlayerState.is(ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, state, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED, ITVKPlayerState.STATE.COMPLETE)) {
            this.mLogger.warn(str + ", invalid state=" + this.mState.state(), new Object[0]);
            return;
        }
        if (this.mState.less(state)) {
            this.mLogger.info(str + ", state less than prepared, setSeekPosition to runtime param, positionMs=" + i3, new Object[0]);
            this.mRunTimeParam.setSeekPositionMs((long) i3);
            this.mRunTimeParam.setSeekMode(i16);
            return;
        }
        this.mLogger.info(str + ", positionMs=" + i3, new Object[0]);
        if (permissionTimeoutByPos(i3)) {
            processPlayerPermissionTimeout(str + ": permission timeout");
            return;
        }
        try {
            this.mPlayer.seekToAsync(i3, i16, -1L);
        } catch (IllegalStateException unused) {
            this.mLogger.warn("seekTo has a IllegalStateException, mState=" + this.mState.state(), new Object[0]);
        }
    }

    private boolean setDataSource(@NonNull ITPMediaAsset iTPMediaAsset) {
        try {
            this.mPlayer.setDataSource(iTPMediaAsset);
            return true;
        } catch (IllegalArgumentException e16) {
            this.mLogger.printException(e16);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_SET_DATASOURCE_ILLEGAL_ARG_EXCEPTION_ERR));
            return false;
        } catch (IllegalStateException e17) {
            this.mLogger.printException(e17);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_STATE_ERR));
            return false;
        } catch (UnsupportedOperationException e18) {
            this.mLogger.printException(e18);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_NOT_SUPPORT_ERR));
            return false;
        }
    }

    private void setUpParamsWhenOpenMediaPlayer(@NonNull Context context, @Nullable TVKUserInfo tVKUserInfo, @Nullable TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, long j3, long j16) {
        this.mRunTimeParam.clear(1);
        this.mAssetPlayerContext.updateContext(context);
        this.mInputParam.setUserInfo(tVKUserInfo);
        this.mInputParam.setPlayerVideoInfo(tVKPlayerVideoInfo);
        this.mInputParam.setDefinition(TVKDefinitionUtils.getSuggestDefinition(str));
        this.mInputParam.setAdaptiveDefinition(TVKDefinitionType.DEFINITION_TYPE_ADAPTIVE.equals(str));
        if (tVKPlayerVideoInfo != null) {
            this.mInputParam.setCurAudioTrack(tVKPlayerVideoInfo.getConfigMapValue("track", ""));
            this.mInputParam.setCurSubtitleTrack(tVKPlayerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_SUBTITLE_LANGUAGE_ID, ""));
            this.mRunTimeParam.setTVKAsset(tVKPlayerVideoInfo.getAsset());
        }
        this.mRunTimeParam.setStartPositionMs(j3);
        this.mRunTimeParam.setSkipEndPositionMs(j16);
        this.mRunTimeParam.setLastPositionMs(j3);
    }

    private void setViewSecure(boolean z16) {
        ITVKVideoViewPrivate playerView = this.mInputParam.getPlayerView();
        if (playerView == null) {
            this.mLogger.warn("mInputParam.getPlayerView() == null", new Object[0]);
            return;
        }
        boolean viewSecure = playerView.setViewSecure(z16);
        if (z16 && !viewSecure) {
            this.mLogger.error("isSetSecureSuccess == false, we forced black screen to notify app developer", new Object[0]);
            this.mLogger.error("textureview don't support setSecure, encryption videos cannot be played, please use ITVKProxyFactory.createVideoView to get surfaceView. if you have problem, please ask rtx [asimayuan] why", new Object[0]);
            updatePostProcessorOutputSurface(null);
            updatePlayerRenderSurface();
            this.mAssetPlayerListener.onInfo(533, 0L, 0L, null);
            return;
        }
        ITVKDrawableContainer drawableContainer = this.mInputParam.getDrawableContainer();
        if (drawableContainer instanceof ITVKRenderSurface) {
            this.mVideoPostProcessor.setOutputRenderSurface((ITVKRenderSurface) drawableContainer);
        }
    }

    private void startPermissionTimeOutCheckerForLive() {
        long liveCurrentPreviewDurationSec;
        this.mWorkThreadHandler.removeMessages(65535);
        boolean z16 = this.mInputParam.getPlayerVideoInfo().getAsset() instanceof TVKOnlineSimulatedLiveAsset;
        if ((!TVKAssetUtils.isLiveAsset(this.mRunTimeParam.getTVKAsset()) && !z16) || !this.mAssetPlayerContext.getRuntimeParam().isPreview()) {
            return;
        }
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo == null) {
            this.mLogger.warn("sendDelayMsgToCheckPermissionTimeOutForLive, netVideoInfo == null, return", new Object[0]);
            return;
        }
        this.mRunTimeParam.setLiveStartPlayTimeMs(SystemClock.elapsedRealtime());
        if (z16) {
            liveCurrentPreviewDurationSec = netVideoInfo.getPreviewDurationSec();
        } else {
            liveCurrentPreviewDurationSec = netVideoInfo.getLiveCurrentPreviewDurationSec();
        }
        this.mLogger.info("startPermissionTimeOutCheckerForLive, previewDurationSec=" + liveCurrentPreviewDurationSec, new Object[0]);
        this.mWorkThreadHandler.sendEmptyMessageDelayed(65535, liveCurrentPreviewDurationSec * 1000);
    }

    private void updatePlayerListener() {
        this.mAssetPlayerContext.setAssetPlayerListener(this.mAssetPlayerListener);
        this.mRichMediaSynchronizerInternal.setQQLiveAssetPlayerListener(this.mAssetPlayerListener);
    }

    private void updatePlayerRenderSurface() {
        if (!this.mVideoPostProcessor.isSurfaceReady()) {
            this.mLogger.info("surface is not ready, set player surface null now", new Object[0]);
            setSurface(null);
        } else {
            setSurface(this.mVideoPostProcessor.getRenderSurface());
        }
    }

    private void updatePlayerViewDisplayParams(ITVKVideoViewPrivate iTVKVideoViewPrivate) {
        iTVKVideoViewPrivate.setXYaxis(this.mInputParam.getViewXYaxis());
        float displayViewScale = this.mInputParam.getDisplayViewScale();
        Pair<Float, Float> displayViewScaleAnchor = this.mInputParam.getDisplayViewScaleAnchor();
        if (displayViewScaleAnchor != null) {
            iTVKVideoViewPrivate.setDisplayScale(displayViewScale, ((Float) displayViewScaleAnchor.first).floatValue(), ((Float) displayViewScaleAnchor.second).floatValue());
        } else {
            iTVKVideoViewPrivate.setDisplayScale(displayViewScale);
        }
        iTVKVideoViewPrivate.setDisplayOffset(this.mInputParam.getDisplayViewOffsetX(), this.mInputParam.getDisplayViewOffsetY());
        iTVKVideoViewPrivate.setAlignment(this.mInputParam.getViewAlignment());
    }

    private void updatePostProcessorOutputSurface(ITVKDrawableContainer iTVKDrawableContainer) {
        this.mLogger.info("updatePostProcessorOutputSurface: " + iTVKDrawableContainer, new Object[0]);
        if (iTVKDrawableContainer instanceof ITVKRenderSurface) {
            ITVKRenderSurface iTVKRenderSurface = (ITVKRenderSurface) iTVKDrawableContainer;
            iTVKRenderSurface.setFixedSize(this.mRunTimeParam.getVideoWidth(), this.mRunTimeParam.getVideoHeight());
            this.mVideoPostProcessor.setOutputRenderSurface(iTVKRenderSurface);
        } else {
            this.mLogger.warn("drawableContainer not instanceof ITVKRenderSurface, setOutputRenderSurface(null)\uff0cdrawableContainer=" + iTVKDrawableContainer, new Object[0]);
            this.mVideoPostProcessor.setOutputRenderSurface(null);
        }
    }

    private void updateRunTimeParamWhenPlayerPrepared() {
        this.mRunTimeParam.setVideoWidthAndHeight(this.mPlayer.getWidth(), this.mPlayer.getHeight());
        try {
            this.mRunTimeParam.setVideoRotation(TVKUtils.optInt(this.mPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_VIDEO_ROTATION), 0));
        } catch (IllegalStateException e16) {
            this.mLogger.printException(e16);
        }
        this.mRunTimeParam.setStreamDumpInfo("");
        updateVideoDuration();
    }

    private void updateVideoDuration() {
        if (TVKAssetUtils.isLiveAsset(this.mRunTimeParam.getTVKAsset())) {
            return;
        }
        long durationMs = this.mPlayer.getDurationMs();
        TVKNetVideoInfo netVideoInfo = this.mRunTimeParam.getNetVideoInfo();
        if (netVideoInfo == null) {
            this.mRunTimeParam.setVideoDurationMs(durationMs);
            return;
        }
        netVideoInfo.isPreview();
        if (netVideoInfo.isPreview()) {
            this.mRunTimeParam.setVideoDurationMs(netVideoInfo.getDurationSec() * 1000);
        } else if (durationMs <= 0) {
            this.mRunTimeParam.setVideoDurationMs(netVideoInfo.getDurationSec() * 1000);
        } else {
            this.mRunTimeParam.setVideoDurationMs(durationMs);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    public void addOptionalParam(TPOptionalParam<?> tPOptionalParam) {
        this.mInputParam.addInitParamToList(tPOptionalParam);
        this.mPlayer.addOptionalParam(tPOptionalParam);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void addTrackInfo(int i3, String str, String str2) {
        TVKSubtitleTrackExternal tVKSubtitleTrackExternal;
        if (!this.mState.is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED, ITVKPlayerState.STATE.COMPLETE)) {
            this.mLogger.warn("api call: addTrackInfo, invalid state=" + this.mState.state(), new Object[0]);
            return;
        }
        try {
            if (i3 == 2) {
                TVKAudioTrackExternal tVKAudioTrackExternal = new TVKAudioTrackExternal();
                tVKAudioTrackExternal.setTrackName(str);
                tVKAudioTrackExternal.setAudioTrackUrl(str2);
                this.mAssetPlayerContext.getPlayer().addAudioTrackSource(TPMediaAssetFactory.createUrlMediaAsset(str2), tVKAudioTrackExternal.getTrackUniqueId());
                tVKSubtitleTrackExternal = tVKAudioTrackExternal;
            } else if (i3 == 3) {
                TVKSubtitleTrackExternal tVKSubtitleTrackExternal2 = new TVKSubtitleTrackExternal();
                tVKSubtitleTrackExternal2.setSubTitleUrl(str2);
                tVKSubtitleTrackExternal2.setTrackName(str);
                this.mAssetPlayerContext.getPlayer().addSubtitleTrackSource(TPMediaAssetFactory.createUrlMediaAsset(str2), tVKSubtitleTrackExternal2.getTrackUniqueId());
                tVKSubtitleTrackExternal = tVKSubtitleTrackExternal2;
            } else {
                this.mLogger.info("the track type not supported.", new Object[0]);
                return;
            }
            tVKSubtitleTrackExternal.setSelected(false);
            this.mLogger.info("api call: addTrackInfo, trackInfo=" + tVKSubtitleTrackExternal, new Object[0]);
            this.mRunTimeParam.addTrackInfo(tVKSubtitleTrackExternal);
        } catch (IllegalArgumentException e16) {
            e = e16;
            this.mLogger.error("addTrackInfo has exception: " + e, new Object[0]);
        } catch (UnsupportedOperationException e17) {
            e = e17;
            this.mLogger.error("addTrackInfo has exception: " + e, new Object[0]);
        }
    }

    @Override // com.tencent.thumbplayer.api.dtreport.IDtReport
    public void bindVideoPlayerInfo(Object obj) {
        ITVKTPPlayer iTVKTPPlayer = this.mPlayer;
        if (iTVKTPPlayer != null) {
            iTVKTPPlayer.bindVideoPlayerInfo(obj);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public int captureImageInTime(int i3, int i16) throws IllegalStateException, IllegalArgumentException {
        if (this.mState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            if (i3 >= 0 && i16 >= 0) {
                this.mLogger.info("api call: captureImageInTime, width=" + i3 + " height=" + i16, new Object[0]);
                TPSnapshotParams tPSnapshotParams = new TPSnapshotParams();
                tPSnapshotParams.setWidth(i3);
                tPSnapshotParams.setHeight(i16);
                tPSnapshotParams.setPixelFormat(37);
                long j3 = (long) TVKMediaPlayerConfig.PlayerConfig.pos_ms_seek_tolerance_before;
                long j16 = TVKMediaPlayerConfig.PlayerConfig.pos_ms_seek_tolerance_after;
                tPSnapshotParams.setRequestedPositionMsToleranceBefore(j3);
                tPSnapshotParams.setRequestedPositionMsToleranceAfter(j16);
                ITVKTPPlayer iTVKTPPlayer = this.mPlayer;
                AtomicInteger atomicInteger = sVideoSnapshotTaskId;
                iTVKTPPlayer.snapshotAsync(tPSnapshotParams, atomicInteger.get());
                return atomicInteger.getAndIncrement();
            }
            this.mLogger.error("captureImageInTime, invalid argument: width=" + i3 + " height=" + i16, new Object[0]);
            throw new IllegalArgumentException("illegal argument, width&height must great than 0, width=" + i3 + " height=" + i16);
        }
        this.mLogger.error("captureImageInTime, invalid state, state=" + this.mState.state(), new Object[0]);
        throw new IllegalStateException("captureImageInTime, state is " + this.mState.state());
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void connectPostProcessor(ITVKPostProcessor iTVKPostProcessor) throws IllegalStateException {
        this.mLogger.info("api call: connectPostProcessor, processor=" + iTVKPostProcessor, new Object[0]);
        if (iTVKPostProcessor instanceof TVKAudioPostProcessor) {
            TVKAudioPostProcessor tVKAudioPostProcessor = (TVKAudioPostProcessor) iTVKPostProcessor;
            if (!tVKAudioPostProcessor.isPostProcessorConnected()) {
                tVKAudioPostProcessor.connectPostProcessor();
                this.mInputParam.setAudioProcessorConnected(true);
            }
        }
        if (iTVKPostProcessor instanceof TVKVideoPostProcessor) {
            TVKVideoPostProcessor tVKVideoPostProcessor = (TVKVideoPostProcessor) iTVKPostProcessor;
            if (!tVKVideoPostProcessor.isPostProcessorConnected() && TVKPostProcessorStrategy.isSupportVideoProcessor(this.mRunTimeParam.getNetVideoInfo(), this.mAssetPlayerContext.getCurrentPlayerFeatureList())) {
                connectVideoPostProcessor(tVKVideoPostProcessor);
                this.mInputParam.setVideoProcessorConnected(true);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void deselectTrack(int i3) throws IllegalArgumentException, IllegalStateException {
        if (this.mState.is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.error("api call: deselectTrack, should execute TVKRegularSelectSubtitleTrackFunction, TVKRegularSelectAudioTrackFunction or TVKNestM3u8SelectAudioTrackFunction, state=" + this.mState.state(), new Object[0]);
            return;
        }
        this.mLogger.error("deselectTrack, error state", new Object[0]);
        throw new IllegalStateException("deselectTrack, error state");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void disconnectPostProcessor(ITVKPostProcessor iTVKPostProcessor) throws IllegalStateException {
        this.mLogger.info("api call: disconnectPostProcessor, processor=" + iTVKPostProcessor, new Object[0]);
        if (iTVKPostProcessor instanceof TVKAudioPostProcessor) {
            TVKAudioPostProcessor tVKAudioPostProcessor = (TVKAudioPostProcessor) iTVKPostProcessor;
            if (tVKAudioPostProcessor.isPostProcessorConnected()) {
                tVKAudioPostProcessor.disconnectPostProcessor();
                this.mInputParam.setAudioProcessorConnected(false);
            }
        }
        if (iTVKPostProcessor instanceof TVKVideoPostProcessor) {
            TVKVideoPostProcessor tVKVideoPostProcessor = (TVKVideoPostProcessor) iTVKPostProcessor;
            if (tVKVideoPostProcessor.isPostProcessorConnected()) {
                disconnectVideoPostProcessor(tVKVideoPostProcessor);
                this.mInputParam.setVideoProcessorConnected(false);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    public int getAdState() {
        return 1;
    }

    @NonNull
    public TVKQQLiveAssetPlayerContext getAssetPlayerContext() {
        return this.mAssetPlayerContext;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public ITVKAudioFxProcessor getAudioFxProcessor() {
        this.mLogger.info("api call: getAudioFxProcessor", new Object[0]);
        return this.mAudioPostProcessor;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public long getAvailablePositionMs() {
        TVKPlayerState tVKPlayerState = this.mState;
        ITVKPlayerState.STATE state = ITVKPlayerState.STATE.PREPARED;
        if (!tVKPlayerState.is(ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, state, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.warn("api call: getAvailablePositionMs, invalid state=" + this.mState.state(), new Object[0]);
            return 0L;
        }
        if (this.mState.less(state)) {
            return this.mRunTimeParam.getLastPositionMs();
        }
        return this.mPlayer.getAvailablePositionMs();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public int getBufferPercent() {
        if (!this.mState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED, ITVKPlayerState.STATE.STOPPED, ITVKPlayerState.STATE.COMPLETE)) {
            this.mLogger.warn("api call: getBufferPercent, invalid state=" + this.mState.state(), new Object[0]);
            return 0;
        }
        long videoDurationMs = this.mRunTimeParam.getVideoDurationMs();
        if (videoDurationMs <= 0) {
            return 0;
        }
        return (int) ((this.mPlayer.getAvailablePositionMs() * 100) / videoDurationMs);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public TVKNetVideoInfo getCurNetVideoInfo() {
        if (!this.mState.is(ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED, ITVKPlayerState.STATE.COMPLETE)) {
            this.mLogger.warn("api call: getCurNetVideoInfo, invalid state=" + this.mState.state(), new Object[0]);
            return null;
        }
        return this.mRunTimeParam.getNetVideoInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public long getCurrentPosition() {
        if (!this.mState.is(ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            return this.mRunTimeParam.getLastPositionMs();
        }
        long currentPositionMs = this.mPlayer.getCurrentPositionMs();
        this.mRunTimeParam.setLastPositionMs(currentPositionMs);
        return currentPositionMs;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public int getDownloadSpeed(int i3) {
        if (!this.mState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED, ITVKPlayerState.STATE.STOPPED, ITVKPlayerState.STATE.COMPLETE)) {
            this.mLogger.warn("api call: getDownloadSpeed, invalid state=" + this.mState.state(), new Object[0]);
            return 0;
        }
        return (int) this.mRunTimeParam.getDownloadSpeedKBps();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public long getDuration() {
        if (!this.mState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED, ITVKPlayerState.STATE.STOPPED, ITVKPlayerState.STATE.COMPLETE)) {
            this.mLogger.warn("api call: getDuration, invalid state=" + this.mState.state(), new Object[0]);
            return 0L;
        }
        return this.mRunTimeParam.getVideoDurationMs();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public boolean getOutputMute() {
        if (isGetPlayerParamInvalidState()) {
            this.mLogger.warn("api call: getOutputMute, invalid state=" + this.mState.state(), new Object[0]);
            return false;
        }
        return this.mInputParam.isOutputMute();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public TPProgramInfo[] getProgramInfo() {
        return this.mPlayer.getTPPlayer().getProgramInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    public String getProperty(String str) throws IllegalStateException {
        return this.mPlayer.getProperty(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public ITVKRichMediaSynchronizer getRichMediaSynchronizer() throws IllegalStateException {
        if (!this.mRichMediaSynchronizerInternal.isPrepared()) {
            return null;
        }
        return this.mRichMediaSynchronizerInternal;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public int getSelectedTrack(int i3) {
        List<TVKTrackInfo> trackInfoList = this.mRunTimeParam.getTrackInfoList();
        for (int i16 = 0; i16 < trackInfoList.size(); i16++) {
            if (trackInfoList.get(i16).getTrackType() == i3 && trackInfoList.get(i16).isSelected()) {
                return i16;
            }
        }
        return -1;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public String getStreamDumpInfo() {
        if (isGetPlayerParamInvalidState()) {
            this.mLogger.warn("api call: getStreamDumpInfo, invalid state=" + this.mState.state(), new Object[0]);
            return "";
        }
        return this.mRunTimeParam.getStreamDumpInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public ITVKSubtitleRendererController getSubtitleRendererController() {
        ITVKSubtitleRenderer iTVKSubtitleRenderer = this.mSubtitleRenderer;
        if (iTVKSubtitleRenderer instanceof ITVKSubtitleRendererController) {
            return (ITVKSubtitleRendererController) iTVKSubtitleRenderer;
        }
        return null;
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    public ITVKTPPlayer getTVKTPPlayer() {
        return this.mPlayer;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public TVKTrackInfo[] getTrackInfo() {
        if (this.mState.is(ITVKPlayerState.STATE.ERROR, ITVKPlayerState.STATE.RELEASED)) {
            this.mLogger.warn("api call: addTrackInfo, invalid state=" + this.mState.state(), new Object[0]);
            return new TVKTrackInfo[0];
        }
        TVKTrackInfo[] tVKTrackInfoArr = (TVKTrackInfo[]) this.mRunTimeParam.getTrackInfoList().toArray(new TVKTrackInfo[0]);
        if (tVKTrackInfoArr == null) {
            return new TVKTrackInfo[0];
        }
        return tVKTrackInfoArr;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public ITVKVideoFxProcessor getVideoFxProcessor() {
        if (!TVKPostProcessorStrategy.isSupportVideoProcessor(this.mRunTimeParam.getNetVideoInfo(), this.mAssetPlayerContext.getCurrentPlayerFeatureList())) {
            this.mLogger.warn("api call: getVideoFxProcessor, processor is unavailable", new Object[0]);
            return null;
        }
        return this.mVideoPostProcessor;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public int getVideoHeight() {
        if (isGetPlayerParamInvalidState()) {
            this.mLogger.warn("api call: getVideoHeight, invalid state=" + this.mState.state(), new Object[0]);
            return 0;
        }
        return this.mRunTimeParam.getVideoHeight();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public int getVideoRotation() throws IllegalStateException {
        if (!isGetPlayerParamInvalidState()) {
            return this.mRunTimeParam.getVideoRotation();
        }
        this.mLogger.warn("api call: getVideoRotation, invalid state=" + this.mState.state(), new Object[0]);
        throw new IllegalStateException("api call: getVideoRotation, invalid state=" + this.mState.state());
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public int getVideoWidth() {
        if (isGetPlayerParamInvalidState()) {
            this.mLogger.warn("api call: getVideoWidth, invalid state=" + this.mState.state(), new Object[0]);
            return 0;
        }
        return this.mRunTimeParam.getVideoWidth();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public boolean isLoopBack() {
        if (isGetPlayerParamInvalidState()) {
            this.mLogger.warn("api call: isLoopBack, invalid state=" + this.mState.state(), new Object[0]);
            return false;
        }
        return this.mInputParam.isLoopback();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public boolean isPaused() {
        return this.mState.is(ITVKPlayerState.STATE.PAUSED);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public boolean isPlaying() {
        return this.mState.is(ITVKPlayerState.STATE.STARTED);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onAudioFrameOut(TPAudioFrameBuffer tPAudioFrameBuffer) {
        if (!this.mState.is(ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.error("onAudioFrameOut, invalidState=" + this.mState.state(), new Object[0]);
            return;
        }
        TVKAudioFrameBuffer tVKAudioFrameBuffer = new TVKAudioFrameBuffer();
        tVKAudioFrameBuffer.setData(tPAudioFrameBuffer.getData());
        tVKAudioFrameBuffer.setDataSize(tPAudioFrameBuffer.getDataSize());
        tVKAudioFrameBuffer.setFormat(tPAudioFrameBuffer.getFormat());
        tVKAudioFrameBuffer.setSampleRate(tPAudioFrameBuffer.getSampleRate());
        tVKAudioFrameBuffer.setChannelLayout(tPAudioFrameBuffer.getChannelLayout());
        tVKAudioFrameBuffer.setPtsMs(tPAudioFrameBuffer.getPtsMs());
        tVKAudioFrameBuffer.setNbSamples(tPAudioFrameBuffer.getNbSamples());
        tVKAudioFrameBuffer.setChannels(tPAudioFrameBuffer.getChannels());
        tVKAudioFrameBuffer.setEventFlag(tPAudioFrameBuffer.getEventFlag());
        this.mAssetPlayerListener.onAudioFrameOut(tVKAudioFrameBuffer);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onCompletion() {
        this.mLogger.info("onCompletion", new Object[0]);
        this.mState.changeState(ITVKPlayerState.STATE.COMPLETE);
        if (this.mRunTimeParam.isPreview()) {
            processPlayerPermissionTimeout("onComplete: isPreview=true, permission timeout");
        } else {
            stopAndResetPlayer();
            this.mAssetPlayerListener.onCompletion();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onDebugTrackingInfo(TPDebugTrackingInfo tPDebugTrackingInfo) {
        ITVKReportEventListener.ReportEvent reportEvent = TVKTPDebugTrackingInfoMapper.getReportEvent(tPDebugTrackingInfo.getTrackingInfoID());
        if (reportEvent != null) {
            this.mLogger.info("onDebugTrackingInfo, report event=" + reportEvent + " timeSince1970Ms=" + tPDebugTrackingInfo.getTimeSince1970Ms(), new Object[0]);
            reportEvent(reportEvent, new TVKReportEventParamsInner.Builder().setTimeSince1970Ms(tPDebugTrackingInfo.getTimeSince1970Ms()).build());
        }
        this.mAssetPlayerListener.onDebugTrackingInfo(tPDebugTrackingInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onError(TPError tPError) {
        int i3;
        if (!this.mState.is(ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.error("onError, invalid state=" + this.mState.state(), new Object[0]);
            return;
        }
        if (TVKAssetUtils.isQQLiveAsset(this.mRunTimeParam.getTVKAsset())) {
            i3 = TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR;
        } else {
            i3 = TVKCommonErrorCodeUtil.MODULE.PLAY_OTHER_ASSET_ERR;
        }
        this.mLogger.error("onError, error:" + tPError, new Object[0]);
        processError(new TVKError(i3, tPError.getErrorCode()));
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public long onGetRemainTimeBeforePlayMs() {
        return this.mAssetPlayerListener.getAdvRemainTimeMs();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onInfo(int i3, TPOnInfoParam tPOnInfoParam) {
        if (!this.mState.is(ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.error("onInfo, invalid state=" + this.mState.state(), new Object[0]);
            return;
        }
        this.mPlayerMsgHandler.handleMsg(i3, tPOnInfoParam);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onMediaAssetExpire(ITPMediaAssetRequest iTPMediaAssetRequest) {
        this.mLogger.error("onMediaAssetExpire should be handled by TVKUniversalUpdateResourceFunction, state=" + this.mState.state(), new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onNextAssetRequired(ITPSimulatedLiveMediaAsset.ITPSimulatedLiveAssetRequest iTPSimulatedLiveAssetRequest) {
        this.mLogger.error("onNextAssetRequired, I literally can do nothing", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onPrepared() {
        if (!this.mState.is(ITVKPlayerState.STATE.PREPARING)) {
            this.mLogger.error("onPrepared, invalidState=" + this.mState.state(), new Object[0]);
            return;
        }
        this.mLogger.info("onPrepared", new Object[0]);
        preprocessWhenPlayerPrepared();
        this.mState.changeState(ITVKPlayerState.STATE.PREPARED);
        this.mAssetPlayerListener.onVideoPrepared();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException {
        this.mRealTimeInfoProcessor.onRealTimeInfoChange(i3, obj);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onSeekComplete(long j3) {
        if (!this.mState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.error("onSeekComplete, invalidState=" + this.mState.state(), new Object[0]);
            return;
        }
        this.mRunTimeParam.setLastPositionMs(this.mPlayer.getCurrentPositionMs());
        this.mAssetPlayerListener.onSeekComplete();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onSnapshotFailed(long j3, @NonNull TPError tPError) {
        this.mLogger.info("onCaptureVideoFailed, error=" + tPError, new Object[0]);
        this.mAssetPlayerListener.onCaptureImageFailed((int) j3, tPError.getErrorCode());
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onSnapshotSuccess(long j3, long j16, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer) {
        this.mLogger.info("onCaptureVideoSuccess", new Object[0]);
        try {
            Bitmap bitmap = tPVideoFrameBuffer.toBitmap();
            try {
                TPSubtitleFrameBuffer tPSubtitleFrameBuffer = (TPSubtitleFrameBuffer) this.mSubtitleRenderer.getCurrentSubtitleData();
                if (tPSubtitleFrameBuffer != null) {
                    bitmap = TVKImageUtils.blendBitmapByOverlay(bitmap, tPSubtitleFrameBuffer.toBitmap());
                }
            } catch (UnsupportedOperationException e16) {
                this.mLogger.error("cannot convert subtitle frame buffer to Bitmap", e16);
            }
            this.mAssetPlayerListener.onCaptureImageSucceed((int) j3, tPVideoFrameBuffer.getWidth(), tPVideoFrameBuffer.getHeight(), bitmap);
        } catch (UnsupportedOperationException unused) {
            this.mLogger.error("cannot convert frame buffer to Bitmap", new Object[0]);
            this.mAssetPlayerListener.onCaptureImageFailed((int) j3, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_NOT_SUPPORT_ERR);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onSubtitleDataOut(TPSubtitleData tPSubtitleData) {
        if (!this.mState.is(ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.error("onSubtitleDataOut, invalidState=" + this.mState.state(), new Object[0]);
            return;
        }
        if (tPSubtitleData instanceof TPSubtitleFrameBuffer) {
            this.mSubtitleRenderer.render(tPSubtitleData);
        }
        this.mAssetPlayerListener.onSubtitleDataOut(tPSubtitleData);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onVideoFrameOut(TPVideoFrameBuffer tPVideoFrameBuffer) {
        if (!this.mState.is(ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.error("onVideoFrameOut, invalidState=" + this.mState.state(), new Object[0]);
            return;
        }
        TVKVideoFrameBuffer tVKVideoFrameBuffer = new TVKVideoFrameBuffer();
        tVKVideoFrameBuffer.setData(tPVideoFrameBuffer.getData());
        tVKVideoFrameBuffer.setLineSize(tPVideoFrameBuffer.getLineSize());
        tVKVideoFrameBuffer.setFormat(tPVideoFrameBuffer.getFormat());
        tVKVideoFrameBuffer.setWidth(tPVideoFrameBuffer.getWidth());
        tVKVideoFrameBuffer.setHeight(tPVideoFrameBuffer.getHeight());
        tVKVideoFrameBuffer.setRotation(tPVideoFrameBuffer.getRotation());
        tVKVideoFrameBuffer.setPtsMs(tPVideoFrameBuffer.getPtsMs());
        tVKVideoFrameBuffer.setDisplayWidth(tPVideoFrameBuffer.getDisplayWidth());
        tVKVideoFrameBuffer.setDisplayHeight(tPVideoFrameBuffer.getDisplayHeight());
        tVKVideoFrameBuffer.setTrackID(tPVideoFrameBuffer.getTrackID());
        tVKVideoFrameBuffer.setEventFlag(tPVideoFrameBuffer.getEventFlag());
        this.mAssetPlayerListener.onVideoFrameOut(tVKVideoFrameBuffer);
    }

    @Override // com.tencent.qqlive.tvkplayer.postprocess.api.ITVKVideoFxErrorListener
    public void onVideoFxFatal(int i3, String str, Object obj) {
        this.mLogger.error("onVideoFxFatal", new Object[0]);
        processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.VIDEO_FX_ERR, i3));
    }

    @Override // com.tencent.qqlive.tvkplayer.postprocess.api.ITVKVideoFxErrorListener
    public void onVideoFxWarning(int i3, String str, Object obj) {
        this.mAssetPlayerListener.onInfo(600, 0L, 0L, Integer.valueOf(i3));
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener
    public void onVideoSizeChanged(int i3, int i16) {
        if (!this.mState.is(ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.error("onVideoSizeChanged, invalidState=" + this.mState.state(), new Object[0]);
            return;
        }
        this.mRunTimeParam.setVideoWidthAndHeight(i3, i16);
        if (this.mInputParam.getDrawableContainer() instanceof ITVKRenderSurface) {
            ((ITVKRenderSurface) this.mInputParam.getDrawableContainer()).setFixedSize(i3, i16);
        }
        if (this.mVideoPostProcessor.isPostProcessorConnected()) {
            this.mVideoPostProcessor.setFixedSize(i3, i16);
        }
        this.mAssetPlayerListener.onVideoSizeChanged(i3, i16);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void openMediaPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (context == null) {
            this.mLogger.error("api call: openMediaPlayer, context is null", new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        if (tVKPlayerVideoInfo == null) {
            this.mLogger.error("api call: openMediaPlayer, videoInfo is null", new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        if (!tVKPlayerVideoInfo.isAssetValid()) {
            this.mLogger.error("api call: openMediaPlayer, invalid asset: " + tVKPlayerVideoInfo.getAsset(), new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        long skipStartPositionMs = tVKPlayerVideoInfo.getSkipStartPositionMs();
        long skipEndPositionMs = tVKPlayerVideoInfo.getSkipEndPositionMs();
        if (tVKPlayerVideoInfo.getAsset().getAssetType() == 2) {
            this.mLogger.info("api call: openMediaPlayer input TVKUrlAsset, should use openMediaPlayerByUrl", new Object[0]);
            TVKUrlAsset tVKUrlAsset = (TVKUrlAsset) tVKPlayerVideoInfo.getAsset();
            openMediaPlayerByUrl(context, tVKUrlAsset.getUrl(), tVKUrlAsset.getFileId(), skipStartPositionMs, skipEndPositionMs, tVKUserInfo, tVKPlayerVideoInfo);
            return;
        }
        if (tVKPlayerVideoInfo.getAsset().getAssetType() == 4) {
            this.mLogger.info("api call: openMediaPlayer input TVKPfdAsset, should use openMediaPlayerByPfd", new Object[0]);
            openMediaPlayerByPfd(context, ((TVKPfdAsset) tVKPlayerVideoInfo.getAsset()).getPfd(), skipStartPositionMs, skipEndPositionMs);
            return;
        }
        if (tVKPlayerVideoInfo.getAsset().getAssetType() == 8) {
            openMediaPlayerByAfd(context, ((TVKAfdAsset) tVKPlayerVideoInfo.getAsset()).getAfd(), skipStartPositionMs, skipEndPositionMs);
            return;
        }
        if (!this.mState.is(ITVKPlayerState.STATE.IDLE)) {
            this.mLogger.error("api call: openMediaPlayer, invalidState: " + this.mState.state(), new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_STATE_ERR));
            return;
        }
        reportEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_VIDEO_OPEN_MEDIA_PLAYER, new TVKReportEventParamsInner.Builder().build());
        String definition = tVKPlayerVideoInfo.getDefinition();
        this.mLogger.info("api call: openMediaPlayer, args: definition=" + definition + ", startPositionMs=" + skipStartPositionMs + ", skipEndPositionMs=" + skipEndPositionMs, new Object[0]);
        setUpParamsWhenOpenMediaPlayer(context, tVKUserInfo, tVKPlayerVideoInfo, definition, skipStartPositionMs, skipEndPositionMs);
        dumpOpenMediaPlayerParams();
        QQLiveAssetRequesterListener qQLiveAssetRequesterListener = new QQLiveAssetRequesterListener();
        this.mLogger.info("createQQLiveRequester, start", new Object[0]);
        this.mAssetRequester = TVKMediaSourceControllerFactory.createMediaSourceController(this.mAssetPlayerContext, this.mWorkThreadLooper, qQLiveAssetRequesterListener);
        this.mLogger.info("createQQLiveRequester end", new Object[0]);
        if (this.mAssetRequester == null) {
            this.mLogger.error("api call: openMediaPlayer, invalid assetType, assetType=" + tVKPlayerVideoInfo.getAsset(), new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        this.mState.changeState(ITVKPlayerState.STATE.CGING);
        this.mAssetRequestId = this.mAssetRequester.requestNetVideoInfo(new TVKCGIRequestParam.Builder(tVKPlayerVideoInfo, this.mRunTimeParam.getTVKAsset(), tVKUserInfo).definition(this.mInputParam.getDefinition()).streamFormatId(TVKFormatIDChooser.chooseFormatID(tVKPlayerVideoInfo)).flowId(this.mInputParam.getFlowId()).build(), this.mAssetPlayerContext.getFeatureGroup(), TVKFeatureFactory.createFeatureParamGroup(this.mInputParam, this.mRunTimeParam, new TVKPlayerFeatureExtraParam.Builder().isFirstRequestForThisPlay(true).build()));
        this.mAssetPlayerListener.onInfo(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST, 0L, 0L, null);
        this.mTVKTPReporter.setPlayerVideoInfo(tVKPlayerVideoInfo);
        this.mTVKTPReporter.onOpenMediaPlayer();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void openMediaPlayerByAfd(Context context, AssetFileDescriptor assetFileDescriptor, long j3, long j16) {
        if (context == null) {
            this.mLogger.error("api call: openMediaPlayerByAfd, context is null", new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        if (assetFileDescriptor == null) {
            this.mLogger.error("api call: openMediaPlayerByAfd, afd is null", new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        if (!this.mState.is(ITVKPlayerState.STATE.IDLE)) {
            this.mLogger.error("api call: openMediaPlayerByAfd, state invalid: " + this.mState.state(), new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_STATE_ERR));
            return;
        }
        this.mLogger.info("api call: openMediaPlayerByAfd, startPositionMs=" + j3 + ", skipEndPositionMs=" + j16, new Object[0]);
        setUpParamsWhenOpenMediaPlayer(context, null, null, "", j3, j16);
        dumpOpenMediaPlayerParams();
        this.mRunTimeParam.setTPMediaAsset(TPMediaAssetFactory.createAfdMediaAsset(assetFileDescriptor));
        this.mTVKTPReporter.onOpenMediaPlayer();
        this.mState.changeState(ITVKPlayerState.STATE.CGIED);
        this.mAssetPlayerListener.onVideoCGIed(null);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void openMediaPlayerByPfd(Context context, ParcelFileDescriptor parcelFileDescriptor, long j3, long j16) {
        if (context == null) {
            this.mLogger.error("api call: openMediaPlayerByPfd, context is null", new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        if (parcelFileDescriptor == null) {
            this.mLogger.error("api call: openMediaPlayerByPfd, pfd is null", new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        if (!this.mState.is(ITVKPlayerState.STATE.IDLE)) {
            this.mLogger.error("api call: openMediaPlayerByPfd, state invalid: " + this.mState.state(), new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_STATE_ERR));
            return;
        }
        this.mLogger.info("api call: openMediaPlayerByPfd, startPositionMs=" + j3 + ", skipEndPositionMs=" + j16, new Object[0]);
        setUpParamsWhenOpenMediaPlayer(context, null, null, "", j3, j16);
        dumpOpenMediaPlayerParams();
        this.mRunTimeParam.setTPMediaAsset(TPMediaAssetFactory.createPfdMediaAsset(parcelFileDescriptor));
        this.mTVKTPReporter.setFileDescriptor(parcelFileDescriptor);
        this.mTVKTPReporter.onOpenMediaPlayer();
        this.mState.changeState(ITVKPlayerState.STATE.CGIED);
        this.mAssetPlayerListener.onVideoCGIed(null);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void openMediaPlayerByUrl(Context context, String str, String str2, long j3, long j16, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        openMediaPlayerByUrlImpl(context, str, str2, j3, j16, tVKUserInfo, tVKPlayerVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void pause() {
        TVKPlayerState tVKPlayerState = this.mState;
        ITVKPlayerState.STATE state = ITVKPlayerState.STATE.PAUSED;
        if (!tVKPlayerState.is(ITVKPlayerState.STATE.STARTED, state, ITVKPlayerState.STATE.COMPLETE)) {
            this.mLogger.warn("api call: pause, invalid state=" + this.mState.state(), new Object[0]);
            return;
        }
        this.mLogger.info("api call: pause", new Object[0]);
        try {
            this.mPlayer.pause();
            this.mState.changeState(state);
        } catch (IllegalStateException unused) {
            this.mLogger.error("api call: pause, IllegalStateException", new Object[0]);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void pauseDownload() {
        this.mLogger.info("api call: pauseDownload", new Object[0]);
        this.mPlayer.pauseDownload();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void prepare() {
        if (!this.mState.is(ITVKPlayerState.STATE.CGIED)) {
            this.mLogger.warn("api call:  prepare, invalidState=" + this.mState.state(), new Object[0]);
            return;
        }
        ITPMediaAsset tPMediaAsset = this.mRunTimeParam.getTPMediaAsset();
        if (tPMediaAsset == null) {
            this.mLogger.error("api call: prepare, runtime media asset is null", new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
        } else {
            this.mLogger.info("api call: prepare", new Object[0]);
            setupPlayerAndPrepareAsync(tPMediaAsset, false);
            this.mState.changeState(ITVKPlayerState.STATE.PREPARING);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.ITVKQQLiveAssetPlayerSharedOperator
    public void preprocessWhenPlayerPrepared() {
        if (this.mRunTimeParam.getSeekPositionMs() != -1) {
            seekToImpl((int) this.mRunTimeParam.getSeekPositionMs(), this.mRunTimeParam.getSeekMode(), "doTransactionWhenPlayerPrepared");
            this.mRunTimeParam.setSeekPositionMs(-1L);
            this.mRunTimeParam.setSeekMode(1);
        }
        updateRunTimeParamWhenPlayerPrepared();
        if (this.mInputParam.isLoopback()) {
            long correctLoopStartPosition = correctLoopStartPosition(this.mInputParam.getLoopStartPositionMs());
            long correctLoopEndPosition = correctLoopEndPosition(this.mInputParam.getLoopEndPositionMs());
            this.mLogger.info("loopback range corrected: start=" + correctLoopStartPosition + ", end=" + correctLoopEndPosition, new Object[0]);
            this.mPlayer.setLoopback(this.mInputParam.isLoopback(), correctLoopStartPosition, correctLoopEndPosition);
        }
        processSkipEndPositionForTimeOutLogicWhenVideoPrepared();
        this.mMediaTrackSelector.processSelectStateOfMediaTrack();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.ITVKQQLiveAssetPlayerSharedOperator
    public void processCGIRequestSuccess(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        startPermissionTimeOutCheckerForLive();
        this.mRichMediaSynchronizerInternal.activateRichMedia(tVKNetVideoInfo);
        setViewSecure(tVKNetVideoInfo.isAntiScreenShot());
        notifyAudioPostProcessorCgiSuccess();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.ITVKQQLiveAssetPlayerSharedOperator
    public void processError(TVKError tVKError) {
        this.mLogger.error("processError: " + tVKError, new Object[0]);
        if (permissionTimeoutByPos(this.mRunTimeParam.getLastPositionMs())) {
            processPlayerPermissionTimeout("processError, position out of preview range");
            return;
        }
        stopAndResetPlayer();
        this.mState.changeState(ITVKPlayerState.STATE.IDLE);
        tVKError.setPositionMs((int) this.mRunTimeParam.getLastPositionMs());
        if (tVKError.getExtraInfo(TVKError.ExtraInfoKey.NET_VIDEO_INFO) == null) {
            tVKError.addExtraInfo(TVKError.ExtraInfoKey.NET_VIDEO_INFO, this.mRunTimeParam.getNetVideoInfo());
        }
        this.mInputParam.clear(1);
        this.mRunTimeParam.clear(1);
        this.mAssetPlayerListener.onError(tVKError);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void refreshPlayer() {
        this.mLogger.error("api call: refreshPlayer, should execute TVKUniversalRefreshPlayerFunction, state=" + this.mState.state(), new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void refreshPlayerWithReopen() {
        this.mLogger.error("api call: refreshPlayerWithReopen, should execute TVKUniversalRefreshPlayerWithReopenFunction, state=" + this.mState.state(), new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void release() {
        TVKPlayerState tVKPlayerState = this.mState;
        ITVKPlayerState.STATE state = ITVKPlayerState.STATE.RELEASED;
        if (tVKPlayerState.is(state)) {
            this.mLogger.error("api call: release, invalid state=" + this.mState.state(), new Object[0]);
            return;
        }
        this.mLogger.info("api call: release", new Object[0]);
        removeVideoSurfaceCallBack(this.mVideoPostProcessor);
        cancelAssetRequestIfExist();
        this.mAssetPlayerListener = new TVKQQLiveAssetPlayerListenerEmpty();
        updatePlayerListener();
        stopAndResetPlayer();
        this.mAudioPostProcessor.releaseProcessor();
        this.mVideoPostProcessor.releaseProcessor();
        this.mInputParam.clear(1);
        this.mRunTimeParam.clear(1);
        this.mInputParam.clear(0);
        this.mRunTimeParam.clear(0);
        this.mState.changeState(state);
        this.mPlayer.release();
        this.mRichMediaSynchronizerInternal.release();
        if (this.mIsLooperFromThreadPool) {
            this.mWorkThreadLooper.quit();
        }
        this.mLogger.info("api call: release end", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void resumeDownload() {
        this.mLogger.info("api call: resumeDownload", new Object[0]);
        this.mPlayer.resumeDownload();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void seekForLive(long j3) {
        this.mLogger.error("api call: seekForLive, should execute TVKUniversalSeekLiveFunction, state=" + this.mState.state(), new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void seekTo(int i3) {
        seekToImpl(i3, 1, "api call: seekTo");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void seekToAccuratePos(int i3) {
        seekToImpl(i3, 3, "api call: seekToAccuratePos");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void seekToAccuratePosFast(int i3) {
        seekToImpl(i3, 3, "api call: seekToAccuratePosFast");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void selectProgram(int i3, long j3) {
        this.mPlayer.getTPPlayer().selectProgramAsync(i3, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void selectTrack(int i3) throws IllegalArgumentException, IllegalStateException {
        if (this.mState.is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.error("api call: deselectTrack, should execute TVKRegularSelectSubtitleTrackFunction, TVKRegularSelectAudioTrackFunction or TVKNestM3u8SelectAudioTrackFunction, state=" + this.mState.state(), new Object[0]);
            return;
        }
        this.mLogger.error("selectTrack, error state", new Object[0]);
        throw new IllegalStateException("selectTrack, error state");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void setAlignment(int i3) {
        if (this.mState.is(ITVKPlayerState.STATE.RELEASED)) {
            this.mLogger.warn("api call: setAlignment, in release state", new Object[0]);
            return;
        }
        this.mLogger.info("api call: setAlignment, type=" + i3, new Object[0]);
        this.mInputParam.setViewAlignment(i3);
        if (this.mInputParam.getPlayerView() != null) {
            this.mInputParam.getPlayerView().setAlignment(i3);
        } else {
            this.mLogger.warn("setAlignment, player view is null", new Object[0]);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void setAssetPlayerListener(ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener iTVKQQLiveAssetPlayerListener) {
        if (iTVKQQLiveAssetPlayerListener == null) {
            this.mAssetPlayerListener = new TVKQQLiveAssetPlayerListenerEmpty();
        } else {
            this.mAssetPlayerListener = iTVKQQLiveAssetPlayerListener;
        }
        updatePlayerListener();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void setAudioGainRatio(float f16) {
        if (isSetPlayerParamInvalidState()) {
            this.mLogger.warn("api call: setAudioGainRatio, invalid state=" + this.mState.state(), new Object[0]);
            return;
        }
        this.mLogger.info("api call: setAudioGainRatio, gainRatio=" + f16, new Object[0]);
        this.mInputParam.setAudioGainRatio(f16);
        this.mPlayer.setAudioVolume(f16);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void setDisplayOffset(float f16, float f17) {
        if (this.mState.is(ITVKPlayerState.STATE.RELEASED)) {
            this.mLogger.warn("api call: setDisplayOffset, in release state", new Object[0]);
            return;
        }
        this.mLogger.info("api call: setDisplayOffset, offsetX=" + f16 + ", offsetY=" + f17, new Object[0]);
        this.mInputParam.setDisplayViewOffsetX(f16);
        this.mInputParam.setDisplayViewOffsetY(f17);
        if (this.mInputParam.getPlayerView() != null) {
            this.mInputParam.getPlayerView().setDisplayOffset(f16, f17);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void setDisplayScale(float f16) {
        if (this.mState.is(ITVKPlayerState.STATE.RELEASED)) {
            this.mLogger.warn("api call: setDisplayScale, in release state", new Object[0]);
            return;
        }
        this.mLogger.info("api call: setDisplayScale, scale=" + f16, new Object[0]);
        this.mInputParam.setDisplayViewScale(f16);
        this.mInputParam.setDisplayViewScaleAnchor(null);
        if (this.mInputParam.getPlayerView() != null) {
            this.mInputParam.getPlayerView().setDisplayScale(f16);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void setFlowId(String str) {
        this.mLogger.info("api call: setFlowId, flowid=" + str, new Object[0]);
        this.mInputParam.setFlowId(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void setLoopback(boolean z16) {
        if (isSetPlayerParamInvalidState()) {
            this.mLogger.warn("api call: setLoopback, invalid state=" + this.mState.state(), new Object[0]);
            return;
        }
        this.mLogger.info("api call: setLoopback, isLoopback=" + z16, new Object[0]);
        setLoopback(z16, 0L, -1L);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public boolean setOutputMute(boolean z16) {
        if (isSetPlayerParamInvalidState()) {
            this.mLogger.warn("api call: setOutputMute, invalid state=" + this.mState.state(), new Object[0]);
            return false;
        }
        this.mLogger.info("api call: setOutputMute, isMute=" + z16, new Object[0]);
        this.mInputParam.setOutputMute(z16);
        this.mPlayer.setAudioMute(z16);
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void setPlaySpeedRatio(float f16) {
        if (this.mState.is(ITVKPlayerState.STATE.ERROR, ITVKPlayerState.STATE.RELEASED)) {
            this.mLogger.warn("api call: setPlaySpeedRatio, in release state", new Object[0]);
            return;
        }
        this.mLogger.info("api call: setPlaySpeedRatio, speedRatio=" + f16, new Object[0]);
        this.mInputParam.setSpeedRatio(f16);
        this.mPlayer.setPlaySpeedRatio(f16);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void setSurface(Surface surface) {
        if (TVKMediaPlayerConfig.PlayerConfig.enable_first_frame_render_when_paused && surface != null && this.mState.is(ITVKPlayerState.STATE.PAUSED)) {
            this.mPlayer.addOptionalParam(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_GLOBAL_INT_CURRENT_PAUSE_FOR_SWITCHING_SURFACE, 1));
        }
        this.mPlayer.setSurface(surface);
    }

    public void setTVKTPPlayerListener(@NonNull ITVKTPPlayerListener iTVKTPPlayerListener) {
        this.mTVKTPPlayerListener = iTVKTPPlayerListener;
        this.mPlayer.setTVKTPPlayerListener(iTVKTPPlayerListener);
    }

    public void setVideoFxErrorListener(@NonNull ITVKVideoFxErrorListener iTVKVideoFxErrorListener) {
        this.mVideoPostProcessor.setErrorListener(iTVKVideoFxErrorListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void setXYaxis(int i3) {
        if (this.mState.is(ITVKPlayerState.STATE.RELEASED)) {
            this.mLogger.warn("api call: setXYaxis, in release state", new Object[0]);
            return;
        }
        this.mLogger.info("api call: setXYaxis, type=" + i3, new Object[0]);
        this.mInputParam.setViewXYaxis(i3);
        if (this.mInputParam.getPlayerView() != null) {
            this.mInputParam.getPlayerView().setXYaxis(i3);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.ITVKQQLiveAssetPlayerSharedOperator
    public void setupPlayerAndPrepareAsync(@NonNull ITPMediaAsset iTPMediaAsset, boolean z16) {
        if (!iTPMediaAsset.isValid()) {
            this.mLogger.error("setupAndPreparePlayer, invalid media asset: " + iTPMediaAsset, new Object[0]);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAY_URL_EMPTY_ERR));
            return;
        }
        reportEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PLAYER_BEFORE_SET_DATA_SOURCE_AND_PARAM, new TVKReportEventParamsInner.Builder().build());
        resetAndChangePlayerIfNeededBeforePrepare();
        generateOptionalParamAndSet(z16);
        this.mMediaTrackSelector.setupAllMediaTracks();
        if (!setDataSource(iTPMediaAsset)) {
            return;
        }
        this.mPlayer.setAudioMute(this.mInputParam.isOutputMute());
        this.mPlayer.setPlaySpeedRatio(this.mInputParam.getSpeedRatio());
        this.mPlayer.setAudioVolume(this.mInputParam.getAudioVolume());
        this.mRichMediaSynchronizerInternal.connectToPlayer(this.mPlayer);
        updatePlayerRenderSurface();
        handleVideoPostProcessor();
        handleAudioPostProcessor();
        this.mSubtitleRenderer.updateVideoView(this.mInputParam.getPlayerView());
        reportEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PLAYER_AFTER_SET_DATA_SOURCE_AND_PARAM, new TVKReportEventParamsInner.Builder().build());
        try {
            this.mPlayer.prepareAsync();
        } catch (IllegalStateException e16) {
            this.mLogger.printException(e16);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_STATE_ERR));
        } catch (UnsupportedOperationException e17) {
            this.mLogger.printException(e17);
            processError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_CREATE_FAILED_ERR));
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void start() {
        TVKPlayerState tVKPlayerState = this.mState;
        ITVKPlayerState.STATE state = ITVKPlayerState.STATE.STARTED;
        ITVKPlayerState.STATE state2 = ITVKPlayerState.STATE.PAUSED;
        if (!tVKPlayerState.is(ITVKPlayerState.STATE.PREPARED, state, state2, ITVKPlayerState.STATE.COMPLETE)) {
            this.mLogger.warn("api call: start, invalid state=" + this.mState.state(), new Object[0]);
            return;
        }
        this.mLogger.info("api call: start", new Object[0]);
        this.mLogger.info("start with video view: " + this.mInputParam.getPlayerView(), new Object[0]);
        if (this.mInputParam.getPlayerView() != null) {
            this.mInputParam.getPlayerView().printView();
        }
        if (this.mRunTimeParam.isBackground() && this.mState.is(state2) && !this.mInputParam.isEnableBackgroundPlay()) {
            this.mLogger.info("start player from pause state in the background, but not background play, set CURRENT_PAUSE_FOR_SWITCHING_SURFACE", new Object[0]);
            this.mPlayer.addOptionalParam(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_GLOBAL_INT_CURRENT_PAUSE_FOR_SWITCHING_SURFACE, 1));
        }
        try {
            this.mPlayer.start();
            this.mState.changeState(state);
        } catch (IllegalStateException unused) {
            this.mLogger.error("api call: start, IllegalStateException", new Object[0]);
        }
        processAntiScreenShot(100);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void stop() {
        if (!this.mState.is(ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED, ITVKPlayerState.STATE.COMPLETE)) {
            this.mLogger.warn("api call: stop, call in wrong state, state=" + this.mState.state() + ", do nothing, return", new Object[0]);
            return;
        }
        this.mLogger.info("api call: stop", new Object[0]);
        this.mState.changeState(ITVKPlayerState.STATE.STOPPED);
        this.mRichMediaSynchronizerInternal.reset();
        this.mPlayerMsgHandler.reset();
        this.mTVKTPReporter.reset();
        stopAndResetPlayer();
        processAntiScreenShot(101);
        this.mVideoPostProcessor.reset();
        this.mAudioPostProcessor.reset();
        this.mSubtitleRenderer.reset();
        ITVKVideoViewPrivate playerView = this.mInputParam.getPlayerView();
        this.mInputParam.clear(1);
        this.mRunTimeParam.clear(1);
        if (playerView != null) {
            updatePlayerViewDisplayParams(playerView);
        }
        this.mAssetPlayerContext.getFeatureGroup().reset();
        this.mState.changeState(ITVKPlayerState.STATE.IDLE);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.ITVKQQLiveAssetPlayerSharedOperator
    public void stopAndResetPlayer() {
        this.mLogger.info("call stopAndResetPlayer, mRequestId=" + this.mAssetRequestId, new Object[0]);
        this.mWorkThreadHandler.removeMessages(65535);
        cancelAssetRequestIfExist();
        long currentPositionMs = this.mPlayer.getCurrentPositionMs();
        if (currentPositionMs > 0) {
            this.mRunTimeParam.setLastPositionMs(currentPositionMs);
        }
        try {
            try {
                this.mPlayer.stop();
            } catch (IllegalStateException unused) {
                this.mLogger.error("stopAndResetPlayer, invalid state=" + this.mState.state(), new Object[0]);
            }
        } finally {
            this.mPlayer.reset();
            this.mPlayerMsgHandler.reset();
            setViewSecure(false);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void switchDefinition(String str) throws IllegalStateException, IllegalArgumentException {
        this.mLogger.error("api call: switchDefinition, should execute TVKRegularSwitchDefinitionFunction, state=" + this.mState.state(), new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void switchDefinitionWithReopen(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException {
        this.mLogger.error("api call: switchDefinitionWithReopen, should execute TVKUniversalReopenSwitchDefinitionFunction, state=" + this.mState.state(), new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void updatePlayerVideoView(ITVKDrawableContainer iTVKDrawableContainer) {
        boolean z16 = false;
        if (this.mState.is(ITVKPlayerState.STATE.RELEASED)) {
            this.mLogger.error("api call: updatePlayerVideoView, invalid state", new Object[0]);
            return;
        }
        if (this.mInputParam.getDrawableContainer() == iTVKDrawableContainer) {
            this.mLogger.warn("api call: updatePlayerVideoView, same video view, return", new Object[0]);
            return;
        }
        this.mLogger.info("api call: updatePlayerVideoView: " + iTVKDrawableContainer, new Object[0]);
        this.mInputParam.setDrawableContainer(iTVKDrawableContainer);
        if (iTVKDrawableContainer instanceof ITVKVideoViewPrivate) {
            ITVKVideoViewPrivate iTVKVideoViewPrivate = (ITVKVideoViewPrivate) iTVKDrawableContainer;
            updatePlayerViewDisplayParams(iTVKVideoViewPrivate);
            this.mInputParam.setPlayerView(iTVKVideoViewPrivate);
        } else {
            this.mInputParam.setPlayerView(null);
        }
        this.mSubtitleRenderer.updateVideoView(this.mInputParam.getPlayerView());
        updatePostProcessorOutputSurface(iTVKDrawableContainer);
        updatePlayerRenderSurface();
        if (this.mRunTimeParam.getNetVideoInfo() != null) {
            z16 = this.mRunTimeParam.getNetVideoInfo().isAntiScreenShot();
        }
        setViewSecure(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void updateUserInfo(TVKUserInfo tVKUserInfo) {
        if (this.mState.is(ITVKPlayerState.STATE.RELEASED)) {
            this.mLogger.warn("api call: updateUserInfo, in release state", new Object[0]);
        } else {
            this.mInputParam.setUserInfo(tVKUserInfo);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void switchDefinition(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException {
        this.mLogger.error("api call: switchDefinition with videoInfo&userInfo, should execute TVKRegularSwitchDefinitionFunction, state=" + this.mState.state(), new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void setLoopback(boolean z16, long j3, long j16) {
        if (isSetPlayerParamInvalidState()) {
            this.mLogger.warn("api call: setLoopback, invalid state=" + this.mState.state(), new Object[0]);
            return;
        }
        this.mLogger.info("api call: setLoopback, isLoopback=" + z16 + ", loopStartPositionMs=" + j3 + ", loopEndPositionMs=" + j16, new Object[0]);
        this.mInputParam.setLoopback(z16, j3, j16);
        if (this.mState.less(ITVKPlayerState.STATE.PREPARED)) {
            this.mLogger.info("setLoopback, video unprepared", new Object[0]);
            return;
        }
        long correctLoopStartPosition = correctLoopStartPosition(j3);
        long correctLoopEndPosition = correctLoopEndPosition(j16);
        this.mLogger.info("loopback range corrected: start=" + correctLoopStartPosition + ", end=" + correctLoopEndPosition, new Object[0]);
        this.mPlayer.setLoopback(z16, correctLoopStartPosition, correctLoopEndPosition);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void setDisplayScale(float f16, float f17, float f18) {
        if (this.mState.is(ITVKPlayerState.STATE.RELEASED)) {
            this.mLogger.warn("api call: setDisplayScale, in release state", new Object[0]);
            return;
        }
        this.mLogger.info("api call: setDisplayScale, scale=" + f16 + ", anchorX:" + f17 + ", anchorY:" + f18, new Object[0]);
        this.mInputParam.setDisplayViewScale(f16);
        this.mInputParam.setDisplayViewScaleAnchor(new Pair<>(Float.valueOf(f17), Float.valueOf(f18)));
        if (this.mInputParam.getPlayerView() != null) {
            this.mInputParam.getPlayerView().setDisplayScale(f16, f17, f18);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    public void removePendingPlayerCallback() {
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void startAd() {
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    public void enablePlayerCallbackInterception(boolean z16) {
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    public void setStateKeeperListener(ITVKMediaPlayerPrivate.ITVKStateKeeperListener iTVKStateKeeperListener) {
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer
    public void updateReportParam(TVKProperties tVKProperties) {
    }
}
