package com.tencent.superplayer.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioTrack;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.MethodNotSupportedException;
import com.tencent.superplayer.api.SPDeinitManager;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.framecheck.EmptyVideoFrameCheckHelper;
import com.tencent.superplayer.framecheck.FrameComparePipeLine;
import com.tencent.superplayer.framecheck.IVideoFrameCheckHelper;
import com.tencent.superplayer.framecheck.VideoFrameCheckHelper;
import com.tencent.superplayer.player.ListenerCombine;
import com.tencent.superplayer.player.SuperPlayerMgrInternal;
import com.tencent.superplayer.preload.PreloadPlayerInfo;
import com.tencent.superplayer.preload.PreloadPlayerMgr;
import com.tencent.superplayer.report.ISPReportProvider;
import com.tencent.superplayer.report.ISPReporter;
import com.tencent.superplayer.report.SPReportEvent;
import com.tencent.superplayer.report.SPReportHelper;
import com.tencent.superplayer.tvkplayer.listener.ITVKOnNetVideoInfoListener;
import com.tencent.superplayer.tvkplayer.listener.ITVKOnPermissionTimeoutListener;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.SPlayerVideoView;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPMediaCodecExceptionInfo;
import com.tencent.thumbplayer.api.common.TPMediaCodecReadyInfo;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes26.dex */
public class SuperPlayerMgr implements ISuperPlayer, SuperPlayerMgrInternal.SPlayerManagerInternalListener, ISPlayerVideoView.IVideoViewCallBack, FrameComparePipeLine.OnVideoFrameCheckListener {
    private static final String API_CALL_LOG_PREFIX = "api call : ";
    private static final String API_HANDLE_LOG_PREFIX = "api handle : ";
    private static final String FILENAME = "SuperPlayerMgr.java";
    private SuperPlayerListenerCallBack listenerCallBack;
    private Context mContext;
    private HandlerThread mHandlerThread;
    private SuperPlayerListenerMgr mListenerMgr;
    private Looper mLooper;
    private SuperPlayerOption mOpenOption;
    private SuperPlayerState mPlayState;
    private SuperPlayerMgrInternal mPlayerMgrInternal;
    private String mPlayerTag;
    private SuperPlayerWrapper mPlayerWrapper;
    private int mSceneId;
    private SPlayerVideoView.SurfaceObject mSurfaceObjectForChange;
    private String mTAG;
    private List<TPOptionalParam> mTPOptionalParamList;
    private String mToken;
    private SuperPlayerVideoInfo mVideoInfo;
    private ISPlayerVideoView mVideoView;
    private int mXYaxis = 0;
    private float mSpeedRatio = 1.0f;
    private boolean mIsSeeking = false;
    private boolean mIsLoopback = false;
    private boolean mIsOutputMute = false;
    private int mEmergencyTime = 0;
    private int mSafePlayTime = 0;
    private int mEmergencyTimeForPrePlay = 0;
    private int mSafePlayTimeForPrePlay = 0;
    private boolean mNeedAutoStart = false;
    private boolean mNeedAutoPause = false;
    private Surface mExtSurface = null;
    private ISPReporter mReporter = new SPReportHelper();
    private IVideoFrameCheckHelper mFrameCheckHelper = EmptyVideoFrameCheckHelper.getInstance();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class WrapperListenerAdapter implements ListenerCombine.ISuperPlayerCombine {
        private SuperPlayerListenerCallBack mMgrCallBack;

        public WrapperListenerAdapter(SuperPlayerListenerCallBack superPlayerListenerCallBack) {
            this.mMgrCallBack = superPlayerListenerCallBack;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnAudioFrameOutputListener
        public void onAudioFrameOutput(TPAudioFrameBuffer tPAudioFrameBuffer) {
            this.mMgrCallBack.onAudioFrameOutput(tPAudioFrameBuffer);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
        public void onCaptureImageFailed(ISuperPlayer iSuperPlayer, int i3, int i16) {
            this.mMgrCallBack.onCaptureImageFailed(iSuperPlayer, i3, i16);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
        public void onCaptureImageSucceed(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, Bitmap bitmap) {
            this.mMgrCallBack.onCaptureImageSucceed(iSuperPlayer, i3, i16, i17, bitmap);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            if (this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr) {
                ((SuperPlayerMgr) this.mMgrCallBack.getPlayer()).handleOnCompletion();
            }
            this.mMgrCallBack.onCompletion(iSuperPlayer);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener
        public void onDefinitionInfoUpdate(ISuperPlayer iSuperPlayer, String str, ArrayList<String> arrayList) {
            this.mMgrCallBack.onDefinitionInfoUpdate(iSuperPlayer, str, arrayList);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
        public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
            if (this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr) {
                ((SuperPlayerMgr) this.mMgrCallBack.getPlayer()).handleOnError(iSuperPlayer, i3, i16, i17, str);
            }
            return this.mMgrCallBack.onError(iSuperPlayer, i3, i16, i17, str);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
        public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
            if (this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr) {
                ((SuperPlayerMgr) this.mMgrCallBack.getPlayer()).handleOnInfo(iSuperPlayer, i3, j3, j16, obj);
            }
            return this.mMgrCallBack.onInfo(iSuperPlayer, i3, j3, j16, obj);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
        public void onSeekComplete(ISuperPlayer iSuperPlayer) {
            if (this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr) {
                ((SuperPlayerMgr) this.mMgrCallBack.getPlayer()).handleOnSeekComplete();
            }
            this.mMgrCallBack.onSeekComplete(iSuperPlayer);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnSubtitleDataListener
        public void onSubtitleData(ISuperPlayer iSuperPlayer, TPSubtitleData tPSubtitleData) {
            this.mMgrCallBack.onSubtitleData(iSuperPlayer, tPSubtitleData);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener
        public void onTVideoNetInfoUpdate(ISuperPlayer iSuperPlayer, TVideoNetInfo tVideoNetInfo) {
            this.mMgrCallBack.onTVideoNetInfoUpdate(iSuperPlayer, tVideoNetInfo);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoFrameOutputListener
        public void onVideoFrameOutput(TPVideoFrameBuffer tPVideoFrameBuffer) {
            this.mMgrCallBack.onVideoFrameOutput(tPVideoFrameBuffer);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
            boolean z16;
            ISuperPlayer player = this.mMgrCallBack.getPlayer();
            if (player instanceof SuperPlayerMgr) {
                z16 = ((SuperPlayerMgr) player).handleOnVideoPrepared();
            } else {
                z16 = true;
            }
            if (z16) {
                this.mMgrCallBack.onVideoPrepared(iSuperPlayer);
            }
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(ISuperPlayer iSuperPlayer, int i3, int i16) {
            this.mMgrCallBack.onVideoSizeChanged(iSuperPlayer, i3, i16);
        }
    }

    public SuperPlayerMgr(Context context, int i3, ISPlayerVideoView iSPlayerVideoView) {
        this.mSceneId = i3;
        this.mContext = context.getApplicationContext();
        this.mVideoView = iSPlayerVideoView;
        init();
    }

    private String getThreadName() {
        return LogUtil.TAG + this.mPlayerTag + "-" + this.mSceneId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnCompletion() {
        this.mPlayState.changeStateAndNotify(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        this.mPlayState.changeStateAndNotify(9);
        this.mReporter.onError(i3 + ":" + i17, i3 + ":" + i17 + ":" + i16 + ":" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        if (i3 != 104) {
            if (i3 != 105) {
                if (i3 != 108) {
                    if (i3 != 115) {
                        if (i3 != 124) {
                            if (i3 != 127) {
                                if (i3 != 204) {
                                    if (i3 != 112) {
                                        if (i3 != 113) {
                                            switch (i3) {
                                                case 207:
                                                    if (obj instanceof TPDownloadProgressInfo) {
                                                        this.mReporter.onDownloadProgressUpdate((TPDownloadProgressInfo) obj);
                                                        ISPlayerVideoView iSPlayerVideoView = this.mVideoView;
                                                        if (iSPlayerVideoView instanceof SPlayerVideoView) {
                                                            ((SPlayerVideoView) iSPlayerVideoView).updateDebugInfo(this, ((SPReportHelper) this.mReporter).getEvent(), this.mPlayerTag);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                case 208:
                                                    if (obj instanceof TPMediaCodecReadyInfo) {
                                                        this.mReporter.onCodecReuseInfo((TPMediaCodecReadyInfo) obj);
                                                        return;
                                                    }
                                                    return;
                                                case 209:
                                                    break;
                                                case 210:
                                                    if (obj instanceof TPMediaCodecExceptionInfo) {
                                                        this.mReporter.onCodecReuseInfoException((TPMediaCodecExceptionInfo) obj);
                                                        break;
                                                    }
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case 250:
                                                            if (obj instanceof String) {
                                                                String str = (String) obj;
                                                                if (!TextUtils.isEmpty(str)) {
                                                                    this.mReporter.onQuicInfoUpdate(str);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        case 251:
                                                            if (obj instanceof String) {
                                                                this.mReporter.onPcdnDownloadFailed((String) obj);
                                                                return;
                                                            }
                                                            return;
                                                        case 252:
                                                            this.mReporter.onDropFrame(((float) j3) / ((float) j16), this.mOpenOption);
                                                            this.listenerCallBack.onInfo(iSuperPlayer, 255, r10 * 100.0f, 0L, obj);
                                                            return;
                                                        default:
                                                            return;
                                                    }
                                            }
                                            this.mReporter.onVideoFrameCheckResult((int) j3);
                                            return;
                                        }
                                        if (!this.mIsSeeking) {
                                            this.mReporter.onVideoBufferEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    if (!this.mIsSeeking) {
                                        this.mReporter.onVideoBufferStart();
                                        return;
                                    }
                                    return;
                                }
                                if (obj instanceof TPPlayerMsg.TPCDNURLInfo) {
                                    this.mReporter.onCDNInfoUpdate((TPPlayerMsg.TPCDNURLInfo) obj);
                                    return;
                                }
                                return;
                            }
                            if (obj instanceof MediaInfo) {
                                this.mReporter.onMediaInfoReady((MediaInfo) obj);
                                return;
                            }
                            return;
                        }
                        this.mReporter.onPlayerTypeChanged(j3);
                        return;
                    }
                    this.mReporter.onVideoDecoderTypeChanged(j3);
                    return;
                }
                this.mReporter.onCurrentLoopEnd();
                return;
            }
            this.mReporter.onFirstVideoFrameRendered();
            this.mFrameCheckHelper.onFirstFrameRendered();
            ISPlayerVideoView iSPlayerVideoView2 = this.mVideoView;
            if (iSPlayerVideoView2 instanceof SPlayerVideoView) {
                ((SPlayerVideoView) iSPlayerVideoView2).updateDebugInfo(this, ((SPReportHelper) this.mReporter).getEvent(), this.mPlayerTag);
                return;
            }
            return;
        }
        this.mReporter.onFirstAudioFrameRendered();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnSeekComplete() {
        this.mIsSeeking = false;
        this.mReporter.onSeekComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleOnVideoPrepared() {
        LogUtil.i(this.mTAG, "handleOnVideoPrepared():");
        this.mPlayState.changeStateAndNotify(4);
        ISPlayerVideoView iSPlayerVideoView = this.mVideoView;
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.setFixedSize(getVideoWidth(), getVideoHeight());
        }
        this.mReporter.onPrepared();
        if (this.mNeedAutoStart) {
            this.mNeedAutoStart = false;
            start();
            return false;
        }
        if (this.mNeedAutoPause) {
            this.mNeedAutoPause = false;
            pause();
            return false;
        }
        return true;
    }

    private void init() {
        initTagAndToken();
        this.mPlayState = new SuperPlayerState(this.mPlayerTag);
        this.mReporter.init(this, this.mSceneId);
        try {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread(getThreadName());
            this.mHandlerThread = baseHandlerThread;
            baseHandlerThread.start();
            Looper looper = this.mHandlerThread.getLooper();
            this.mLooper = looper;
            SuperPlayerMgrInternal superPlayerMgrInternal = new SuperPlayerMgrInternal(this.mTAG, looper, this);
            this.mPlayerMgrInternal = superPlayerMgrInternal;
            superPlayerMgrInternal.setIsNeedBlockMessage(true);
            this.mListenerMgr = new SuperPlayerListenerMgr(this.mPlayerTag);
            if (this.mVideoView != null) {
                LogUtil.i(this.mTAG, "updatePlayerVideoView when init, mVideoView = " + this.mVideoView);
                LogUtil.d(this.mTAG, "\u65e5\u5fd7\u8fc7\u6ee4(View): \u3010" + this.mVideoView.getLogTag() + "\u3011, updatePlayerVideoView when init");
                this.mVideoView.addViewCallBack(this);
            }
            SuperPlayerSDKMgr.getPlayerPool().put(this);
            b.a();
        } catch (OutOfMemoryError e16) {
            System.gc();
            LogUtil.i(this.mTAG, "init out of memory" + e16);
        }
    }

    private void initListenerForWrapper() {
        SuperPlayerListenerCallBack superPlayerListenerCallBack = new SuperPlayerListenerCallBack(this, this.mListenerMgr, this.mLooper);
        this.listenerCallBack = superPlayerListenerCallBack;
        superPlayerListenerCallBack.setNotifyPreparedPlayMsgAhead(this.mOpenOption.notifyPreparedPlayMsgAhead);
        WrapperListenerAdapter wrapperListenerAdapter = new WrapperListenerAdapter(this.listenerCallBack);
        this.mPlayerWrapper.setOnVideoPreparedListener(wrapperListenerAdapter);
        this.mPlayerWrapper.setOnCompletionListener(wrapperListenerAdapter);
        this.mPlayerWrapper.setOnInfoListener(wrapperListenerAdapter);
        this.mPlayerWrapper.setOnErrorListener(wrapperListenerAdapter);
        this.mPlayerWrapper.setOnSeekCompleteListener(wrapperListenerAdapter);
        this.mPlayerWrapper.setOnVideoSizeChangedListener(wrapperListenerAdapter);
        this.mPlayerWrapper.setOnCaptureImageListener(wrapperListenerAdapter);
        this.mPlayerWrapper.setOnDefinitionInfoListener(wrapperListenerAdapter);
        this.mPlayerWrapper.setOnTVideoNetInfoUpdateListener(wrapperListenerAdapter);
        this.mPlayerWrapper.setOnAudioFrameOutputListener(wrapperListenerAdapter);
        this.mPlayerWrapper.setOnVideoFrameOutputListener(wrapperListenerAdapter);
        this.mPlayerWrapper.setOnSubtitleDataListener(wrapperListenerAdapter);
    }

    private void initTagAndToken() {
        this.mPlayerTag = CommonUtil.f();
        this.mTAG = this.mPlayerTag + "-" + FILENAME;
        String str = SystemClock.uptimeMillis() + "-" + hashCode();
        this.mToken = str;
        if (str != null && str.length() > 24) {
            this.mToken = this.mToken.substring(8, 24);
        }
        LogUtil.d(this.mTAG, "createPlayer sceneid:" + getSceneId() + ", initToken:" + this.mToken + ", runningInstanceCnt:" + SuperPlayerSDKMgr.getPlayerPool().size());
    }

    private void onPlayerOpen(SuperPlayerOption superPlayerOption) {
        if (superPlayerOption.enableVideoFrameCheck) {
            IVideoFrameCheckHelper iVideoFrameCheckHelper = this.mFrameCheckHelper;
            if (iVideoFrameCheckHelper instanceof VideoFrameCheckHelper) {
                iVideoFrameCheckHelper.onPlayerReset();
            } else {
                this.mFrameCheckHelper = new VideoFrameCheckHelper();
            }
        } else {
            this.mFrameCheckHelper = EmptyVideoFrameCheckHelper.getInstance();
        }
        this.mFrameCheckHelper.setOnVideoFrameCheckListener(this);
        ISPlayerVideoView iSPlayerVideoView = this.mVideoView;
        if (iSPlayerVideoView != null && iSPlayerVideoView.isSurfaceReady()) {
            this.mPlayerWrapper.setSurface(iSPlayerVideoView.getSurface());
            this.mFrameCheckHelper.updatePlayerVideoView(iSPlayerVideoView);
        }
        int[] iArr = SPReportHelper.dropFrameReportSceneId;
        if (iArr != null) {
            for (int i3 : iArr) {
                if (this.mSceneId == i3) {
                    superPlayerOption.enableDropFrameDetect = true;
                    return;
                }
            }
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void addExtReportData(String str, String str2) {
        this.mReporter.addExtReportData(str, str2);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void addSubtitleSource(String str, String str2) {
        handleAddSubtitleSource(str, "", str2);
    }

    @Override // com.tencent.thumbplayer.api.dtreport.IDtReport
    public void bindVideoPlayerInfo(Object obj) {
        if (this.mPlayerWrapper != null) {
            LogUtil.i(this.mTAG, "bindVideoPlayerInfo  " + obj);
            this.mPlayerWrapper.bindVideoPlayerInfo(obj);
            return;
        }
        LogUtil.i(this.mTAG, "bindVideoPlayerInfo  wrapper is null");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int captureImageInTime(long j3, int i3, int i16) throws IllegalStateException, IllegalArgumentException, IllegalAccessException {
        if (this.mPlayerMgrInternal == null) {
            return 0;
        }
        LogUtil.i(this.mTAG, "api call : captureImageInTime, positionMs:" + j3 + ", width:" + i3 + ", height:" + i16);
        return this.mPlayerMgrInternal.captureImageInTime(j3, i3, i16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void deselectTrack(int i3, long j3) {
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return;
        }
        superPlayerMgrInternal.deselectTrack(i3, j3);
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public TVKNetVideoInfo getCurTVKNetVideoInfo() {
        throw new MethodNotSupportedException("can't getCurTVKNetVideoInfo in SuperPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getCurrentPlayerState() {
        SPDeinitManager.DeinitPlayerInfo state = SuperPlayerSDKMgr.getDeinitManager().getState(this.mToken);
        if (state != null && state.needRecover) {
            return state.state;
        }
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getCurrentPlayerState();
        }
        return 0;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getCurrentPositionMs() {
        if (this.mPlayerMgrInternal == null) {
            return 0L;
        }
        SPDeinitManager.DeinitPlayerInfo state = SuperPlayerSDKMgr.getDeinitManager().getState(this.mToken);
        if (state != null && state.needRecover) {
            return state.position;
        }
        return this.mPlayerMgrInternal.getCurrentPositionMs();
    }

    public SPDeinitManager.DeinitPlayerInfo getDeinitPlayerInfo() {
        Surface surface;
        SPDeinitManager.DeinitPlayerInfo deinitPlayerInfo = new SPDeinitManager.DeinitPlayerInfo();
        deinitPlayerInfo.token = getToken();
        deinitPlayerInfo.playerTag = getPlayerTag();
        deinitPlayerInfo.state = getCurrentPlayerState();
        deinitPlayerInfo.position = getCurrentPositionMs();
        deinitPlayerInfo.duration = getDurationMs();
        deinitPlayerInfo.mediaInfo = getMediaInfo();
        deinitPlayerInfo.outputMuted = isOutputMute();
        deinitPlayerInfo.loopback = isLoopBack();
        deinitPlayerInfo.videoView = new WeakReference<>(getVideoView());
        deinitPlayerInfo.serviceType = CommonUtil.i(getSceneId());
        deinitPlayerInfo.xyAxis = this.mXYaxis;
        deinitPlayerInfo.speedRatio = this.mSpeedRatio;
        SuperPlayerOption superPlayerOption = this.mOpenOption;
        if (superPlayerOption != null) {
            deinitPlayerInfo.isPreplay = superPlayerOption.isPrePlay;
            deinitPlayerInfo.stopPlayerInBackground = superPlayerOption.stopPlayerInBackground;
            deinitPlayerInfo.quickStopPlayerInBackground = superPlayerOption.quickStopPlayerInBackground;
        }
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            surface = superPlayerWrapper.getSurface();
        } else {
            surface = null;
        }
        if (this.mPlayerWrapper != null) {
            deinitPlayerInfo.surface = new WeakReference<>(surface);
        }
        return deinitPlayerInfo;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getDurationMs() {
        if (this.mPlayerMgrInternal == null) {
            return 0L;
        }
        SPDeinitManager.DeinitPlayerInfo state = SuperPlayerSDKMgr.getDeinitManager().getState(this.mToken);
        if (state != null && state.needRecover) {
            return state.duration;
        }
        return this.mPlayerMgrInternal.getDurationMs();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getFileSizeBytes() {
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return 0L;
        }
        return superPlayerMgrInternal.getFileSizeBytes();
    }

    public String getFlowId() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getFlowId();
        }
        return null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public float getMaxVolumeGain() {
        return AudioTrack.getMaxVolume();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public MediaInfo getMediaInfo() {
        SPDeinitManager.DeinitPlayerInfo state = SuperPlayerSDKMgr.getDeinitManager().getState(this.mToken);
        if (state != null && state.needRecover) {
            return state.mediaInfo;
        }
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return new MediaInfo("null");
        }
        return superPlayerMgrInternal.getMediaInfo();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getPlayableDurationMs() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getPlayableDurationMs();
        }
        return 0L;
    }

    public String getPlayerTag() {
        return this.mPlayerTag;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public TPProgramInfo[] getProgramInfo() {
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return null;
        }
        return superPlayerMgrInternal.getProgramInfo();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public String getProperty(String str) {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getProperty(String.valueOf(str));
        }
        return "";
    }

    public SPReportEvent getReportEvent() {
        return ((SPReportHelper) this.mReporter).getEvent();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public ISPReportProvider getReportProvider() {
        return this.mReporter;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getSceneId() {
        return this.mSceneId;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public String getStreamDumpInfo() {
        if (this.mPlayerMgrInternal == null) {
            return "";
        }
        LogUtil.i(this.mTAG, "api call : getStreamDumpInfo");
        return this.mPlayerMgrInternal.getStreamDumpInfo();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public SuperPlayerVideoInfo getSuperVideoInfo() {
        return this.mVideoInfo;
    }

    public Surface getSurface() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getSurface();
        }
        return null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public String getToken() {
        return this.mToken;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public TPTrackInfo[] getTrackInfo() {
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return null;
        }
        return superPlayerMgrInternal.getTrackInfo();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getVideoHeight() {
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return 0;
        }
        return superPlayerMgrInternal.getVideoHeight();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getVideoRotation() {
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return 0;
        }
        return superPlayerMgrInternal.getVideoRotation();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public ISPlayerVideoView getVideoView() {
        return this.mVideoView;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getVideoWidth() {
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return 0;
        }
        return superPlayerMgrInternal.getVideoWidth();
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleAddSubtitleSource(String str, String str2, String str3) {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            try {
                superPlayerWrapper.addSubtitleSource(str, str3);
            } catch (Exception e16) {
                LogUtil.e(this.mTAG, e16);
            }
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public int handleCaptureImageInTime(long j3, int i3, int i16) {
        LogUtil.i(this.mTAG, "api handle : handleCaptureImageInTime, positionMs:" + j3 + ", width:" + i3 + ", height:" + i16);
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.captureImageInTime(j3, i3, i16);
        }
        return -1;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleDeselectTrack(int i3, long j3) {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            try {
                superPlayerWrapper.deselectTrack(i3, j3);
            } catch (Exception e16) {
                LogUtil.e(this.mTAG, e16);
            }
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public long handleGetCurrentPosition() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getCurrentPositionMs();
        }
        return 0L;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public long handleGetDuration() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getDurationMs();
        }
        return 0L;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public long handleGetFileSizeBytes() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getFileSizeBytes();
        }
        return 0L;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public MediaInfo handleGetMediaInfo() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getMediaInfo();
        }
        return null;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public TPProgramInfo[] handleGetProgramInfo() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getProgramInfo();
        }
        return null;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public String handleGetStreamDumpInfo() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getStreamDumpInfo();
        }
        return null;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public TPTrackInfo[] handleGetTrackInfo() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getTrackInfo();
        }
        return null;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public int handleGetVideoHeight() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getVideoHeight();
        }
        return 0;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public int handleGetVideoRotation() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getVideoRotation();
        }
        return 0;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public int handleGetVideoWidth() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.getVideoWidth();
        }
        return 0;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public boolean handleIsBuffering() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null && superPlayerWrapper.isBuffering()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleOpenMediaPlayer(Context context, SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerOption superPlayerOption) throws TPLoadLibraryException {
        SuperPlayerOption superPlayerOption2;
        boolean z16;
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        LogUtil.i(this.mTAG, "api handle : handleOpenMediaPlayer, playerVideoInfo:" + superPlayerVideoInfo + ", startPostionMilsec:" + j3);
        if (superPlayerOption == null) {
            superPlayerOption2 = SuperPlayerOption.obtain();
        } else {
            superPlayerOption2 = superPlayerOption;
        }
        PreloadPlayerInfo playerFromPool = PreloadPlayerMgr.getInstance().getPlayerFromPool(this.mSceneId, superPlayerVideoInfo);
        ISPlayerVideoView iSPlayerVideoView = this.mVideoView;
        if (playerFromPool != null) {
            LogUtil.i(this.mTAG, "\u590d\u7528\u9884\u52a0\u8f7d\u64ad\u653e\u5668, PlayerTag = \u3010" + playerFromPool.player.getPlayerTag() + "\u3011");
            SuperPlayerWrapper superPlayerWrapper = playerFromPool.player;
            this.mPlayerWrapper = superPlayerWrapper;
            superPlayerWrapper.updatePlayerTag(this.mPlayerTag);
            if (iSPlayerVideoView != null) {
                iSPlayerVideoView.changeSurfaceObject(playerFromPool.videoView.getStoredSurfaceObject());
            } else {
                this.mSurfaceObjectForChange = playerFromPool.videoView.getStoredSurfaceObject();
            }
            z16 = true;
        } else {
            LogUtil.i(this.mTAG, "\u4e0d\u590d\u7528\u9884\u52a0\u8f7d\u64ad\u653e\u5668");
            if (this.mPlayerWrapper == null) {
                this.mPlayerWrapper = new SuperPlayerWrapper(this.mContext, this.mSceneId, this.mPlayerTag, this.mLooper, this.mTPOptionalParamList);
            }
            if (iSPlayerVideoView != null && iSPlayerVideoView.isSurfaceReady()) {
                this.mPlayerWrapper.setSurface(iSPlayerVideoView.getSurface());
                this.mFrameCheckHelper.updatePlayerVideoView(iSPlayerVideoView);
            } else {
                Surface surface = this.mExtSurface;
                if (surface != null) {
                    this.mPlayerWrapper.setSurface(surface);
                }
            }
            z16 = false;
        }
        this.mVideoInfo = superPlayerVideoInfo;
        this.mOpenOption = superPlayerOption2;
        initListenerForWrapper();
        this.mPlayerMgrInternal.setIsNeedBlockMessage(false);
        this.mPlayerWrapper.updateIsPreloadingStatus(false);
        this.mPlayerWrapper.setPlayerOptionalParamList(this.mTPOptionalParamList);
        this.mPlayerWrapper.setBusinessDownloadStrategy(this.mEmergencyTime, this.mSafePlayTime, this.mEmergencyTimeForPrePlay, this.mSafePlayTimeForPrePlay);
        if (!z16) {
            onPlayerOpen(superPlayerOption2);
            this.mPlayerWrapper.openMediaPlayer(context, superPlayerVideoInfo, j3, superPlayerOption2);
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handlePause() {
        LogUtil.i(this.mTAG, "api handle : handlePause:");
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            try {
                superPlayerWrapper.pause();
            } catch (IllegalStateException e16) {
                LogUtil.e(this.mTAG, "api handle : handlePause:", e16);
            }
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handlePauseDownload() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            try {
                superPlayerWrapper.pauseDownload();
            } catch (Exception e16) {
                LogUtil.e(this.mTAG, e16);
            }
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleRelease() {
        LogUtil.i(this.mTAG, "api handle : handleRelease:");
        this.mContext = null;
        IVideoFrameCheckHelper iVideoFrameCheckHelper = this.mFrameCheckHelper;
        if (iVideoFrameCheckHelper != null) {
            iVideoFrameCheckHelper.onPlayerRelease();
        }
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr != null) {
            superPlayerListenerMgr.release();
        }
        ISPlayerVideoView iSPlayerVideoView = this.mVideoView;
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.removeViewCallBack(this);
        }
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.release();
            this.mPlayerWrapper = null;
        }
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.mHandlerThread = null;
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleReset() {
        LogUtil.i(this.mTAG, "api handle : handleReset:");
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.reset();
        }
        IVideoFrameCheckHelper iVideoFrameCheckHelper = this.mFrameCheckHelper;
        if (iVideoFrameCheckHelper != null) {
            iVideoFrameCheckHelper.onPlayerReset();
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleResumeDownload() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.resumeDownload();
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleSeekTo(int i3) {
        LogUtil.i(this.mTAG, "api handle : handleSeekTo, positionMilsec:" + i3);
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.seekTo(i3);
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleSelectProgram(int i3, long j3) {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.selectProgram(i3, j3);
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleSelectTrack(int i3, long j3) {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            try {
                superPlayerWrapper.selectTrack(i3, j3);
            } catch (Exception e16) {
                LogUtil.e(this.mTAG, e16);
            }
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleSetBusinessDownloadStrategy(int i3, int i16, int i17, int i18) {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            try {
                superPlayerWrapper.setBusinessDownloadStrategy(i3, i16, i17, i18);
            } catch (Throwable th5) {
                LogUtil.e(this.mTAG, th5);
            }
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleSetLoopback(boolean z16) {
        LogUtil.i(this.mTAG, "api handle : handleSetLoopback, isLoopback:" + z16);
        this.mIsLoopback = z16;
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.setLoopback(z16);
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public boolean handleSetOutputMute(boolean z16) {
        LogUtil.i(this.mTAG, "api handle : handleSetOutputMute, isMute:" + z16);
        this.mIsOutputMute = z16;
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.setOutputMute(z16);
            return true;
        }
        return true;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleSetPlaySpeedRatio(float f16) {
        LogUtil.i(this.mTAG, "api handle : handleSetPlaySpeedRatio, speedRatio:" + f16);
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.setPlaySpeedRatio(f16);
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleSetPlayerActive() {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.setPlayerActive();
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleSetSurface(Surface surface) {
        LogUtil.i(this.mTAG, "api handle : handleSetSurface");
        this.mExtSurface = surface;
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.setSurface(surface);
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleSetVolumeGain(float f16) {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.setVolumeGain(f16);
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleStart() {
        LogUtil.i(this.mTAG, "api handle : handleStart:");
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            try {
                superPlayerWrapper.start();
            } catch (IllegalStateException e16) {
                LogUtil.e(this.mTAG, "api handle : handleStart:", e16);
            }
        }
        IVideoFrameCheckHelper iVideoFrameCheckHelper = this.mFrameCheckHelper;
        if (iVideoFrameCheckHelper != null) {
            iVideoFrameCheckHelper.onPlayerStart();
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleStop() {
        LogUtil.i(this.mTAG, "api handle : handleStop:");
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            try {
                superPlayerWrapper.stop();
            } catch (IllegalStateException e16) {
                LogUtil.e(this.mTAG, "api handle : handleStop:", e16);
            }
        }
        IVideoFrameCheckHelper iVideoFrameCheckHelper = this.mFrameCheckHelper;
        if (iVideoFrameCheckHelper != null) {
            iVideoFrameCheckHelper.onPlayerStop();
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleSwitchDefinition(String str, int i3) {
        LogUtil.i(this.mTAG, "api handle : handleSwitchDefinition, definition:" + str + ", mode:" + i3);
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.switchDefinition(str, i3);
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleSwitchDefinitionForUrl(String str, int i3) {
        LogUtil.i(this.mTAG, "api handle : handleSwitchDefinition, url:" + str + ", mode:" + i3);
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.switchDefinitionForUrl(str, i3);
        }
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleUpdatePlayerVideoView(ISPlayerVideoView iSPlayerVideoView) {
        LogUtil.i(this.mTAG, "api handle : handleUpdatePlayerVideoView");
        if (this.mPlayerWrapper != null) {
            if (iSPlayerVideoView != null && iSPlayerVideoView.isSurfaceReady()) {
                this.mPlayerWrapper.setSurface(iSPlayerVideoView.getSurface());
                this.mFrameCheckHelper.updatePlayerVideoView(iSPlayerVideoView);
            } else {
                this.mPlayerWrapper.setSurface(null);
                this.mFrameCheckHelper.updatePlayerVideoView(null);
            }
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isBuffering() {
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return false;
        }
        return superPlayerMgrInternal.isBuffering();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isLoopBack() {
        return this.mIsLoopback;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isOutputMute() {
        return this.mIsOutputMute;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isPausing() {
        SPDeinitManager.DeinitPlayerInfo state = SuperPlayerSDKMgr.getDeinitManager().getState(this.mToken);
        if (state != null && state.needRecover) {
            if (state.state == 6) {
                return true;
            }
            return false;
        }
        if (this.mPlayState.getCurState() == 6) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isPlaying() {
        SPDeinitManager.DeinitPlayerInfo state = SuperPlayerSDKMgr.getDeinitManager().getState(this.mToken);
        if (state != null && state.needRecover) {
            if (state.state == 5) {
                return true;
            }
            return false;
        }
        if (this.mPlayState.getCurState() == 5) {
            return true;
        }
        return false;
    }

    public void notifyCustomInfoEvent(int i3, long j3, long j16, Object obj) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.onInfo(this, i3, j3, j16, obj);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void onPrePlayViewShow() {
        this.mReporter.onPrePlayViewShow();
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException {
        throw new MethodNotSupportedException("can't onRealTimeInfoChange in SuperPlayer");
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceCreated(Object obj) {
        Surface surface;
        SuperPlayerWrapper superPlayerWrapper;
        ISPlayerVideoView iSPlayerVideoView = this.mVideoView;
        String str = this.mTAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("api handle : onSurfaceCreated, mPlayerWrapper=");
        sb5.append(this.mPlayerWrapper);
        sb5.append(", videoView=");
        sb5.append(iSPlayerVideoView);
        sb5.append(", surface=");
        if (iSPlayerVideoView != null) {
            surface = iSPlayerVideoView.getSurface();
        } else {
            surface = null;
        }
        sb5.append(surface);
        LogUtil.i(str, sb5.toString());
        if (iSPlayerVideoView != null && iSPlayerVideoView.getSurface() != null && (superPlayerWrapper = this.mPlayerWrapper) != null) {
            superPlayerWrapper.setSurface(iSPlayerVideoView.getSurface());
            this.mFrameCheckHelper.updatePlayerVideoView(iSPlayerVideoView);
            LogUtil.i(this.mTAG, "onSurfaceCreated view created. mediaPlayer.setSurface:");
            return;
        }
        LogUtil.e(this.mTAG, "onSurfaceCreated view created. mVideoView.getViewSurface() = null");
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceDestroy(Object obj) {
        LogUtil.i(this.mTAG, "api handle : onSurfaceDestroy");
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.setSurface(null);
        }
    }

    @Override // com.tencent.superplayer.framecheck.FrameComparePipeLine.OnVideoFrameCheckListener
    public void onVideoFrameCheckResult(int i3) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.onInfo(this, 209, i3, 0L, null);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void openMediaPlayer(Context context, SuperPlayerVideoInfo superPlayerVideoInfo, long j3) {
        openMediaPlayer(context, superPlayerVideoInfo, j3, SuperPlayerOption.obtain());
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void openTVKPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, long j3, long j16) {
        throw new MethodNotSupportedException("can't openTVKPlayer in SuperPlayer");
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void openTVKPlayerByUrl(Context context, String str, String str2, long j3, long j16) {
        throw new MethodNotSupportedException("can't openTVKPlayerByUrl in SuperPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void pause() {
        LogUtil.i(this.mTAG, "api call : pause");
        int curState = this.mPlayState.getCurState();
        if (curState != 0 && curState != 8 && curState != 7 && curState != 9 && curState != 10) {
            if (this.mPlayerMgrInternal == null) {
                return;
            }
            this.mPlayState.changeStateAndNotify(6);
            this.mPlayerMgrInternal.pause();
            if (this.mNeedAutoStart) {
                this.mNeedAutoStart = false;
                this.mNeedAutoPause = true;
                return;
            }
            return;
        }
        LogUtil.e(this.mTAG, "api call : pause, failed, mPlayState.getCurState() =" + this.mPlayState.getCurState());
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void pauseDownload() {
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        LogUtil.i(this.mTAG, "api call : pauseDownload");
        this.mPlayerMgrInternal.pauseDownload();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void release() {
        LogUtil.i(this.mTAG, "api call : release");
        if (this.mPlayState.getCurState() == 10) {
            LogUtil.e(this.mTAG, "api call : release, failed, mPlayState.getCurState() == " + this.mPlayState.getCurState());
            return;
        }
        this.mPlayState.changeStateAndNotify(10);
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        this.mReporter.onRelease();
        SuperPlayerSDKMgr.getPlayerPool().remove(this);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            this.mPlayerMgrInternal.release();
            return;
        }
        if (Build.VERSION.SDK_INT < 28 && SuperPlayerSDKMgr.getSdkOption().enableReleaseByJoin) {
            this.mPlayerMgrInternal.release();
            try {
                HandlerThread handlerThread = this.mHandlerThread;
                if (handlerThread != null) {
                    handlerThread.join();
                }
                LogUtil.i(this.mTAG, "release by join");
                return;
            } catch (Exception e16) {
                LogUtil.e(this.mTAG, e16);
                return;
            }
        }
        this.mPlayerMgrInternal.release();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void reset() {
        LogUtil.i(this.mTAG, "api call : reset");
        if (this.mPlayState.getCurState() != 0 && this.mPlayState.getCurState() != 10) {
            if (this.mPlayerMgrInternal == null) {
                return;
            }
            this.mPlayState.changeStateAndNotify(0);
            this.mVideoView = null;
            this.mExtSurface = null;
            this.mReporter.reset();
            this.mSurfaceObjectForChange = null;
            this.mTPOptionalParamList = null;
            this.mPlayerMgrInternal.reset();
            this.mPlayerMgrInternal.setIsNeedBlockMessage(true);
            this.mSpeedRatio = 1.0f;
            this.mNeedAutoStart = false;
            this.mNeedAutoPause = false;
            return;
        }
        LogUtil.e(this.mTAG, "api call : reset, failed, mPlayState.getCurState() =" + this.mPlayState.getCurState());
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void resumeDownload() {
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        LogUtil.i(this.mTAG, "api call : resumeDownload");
        this.mPlayerMgrInternal.resumeDownload();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void seekTo(int i3) {
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        LogUtil.i(this.mTAG, "api call : seekTo, positionMilsec:" + i3);
        this.mIsSeeking = true;
        this.mReporter.onSeek(getCurrentPositionMs(), (long) i3);
        this.mPlayerMgrInternal.seekTo(i3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void selectProgram(int i3, long j3) {
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return;
        }
        superPlayerMgrInternal.selectProgram(i3, j3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void selectTrack(int i3, long j3) {
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return;
        }
        superPlayerMgrInternal.selectTrack(i3, j3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18) {
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return;
        }
        this.mEmergencyTime = i3;
        this.mSafePlayTime = i16;
        this.mEmergencyTimeForPrePlay = i17;
        this.mSafePlayTimeForPrePlay = i18;
        superPlayerMgrInternal.setBusinessDownloadStrategy(i3, i16, i17, i18);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setLoopback(boolean z16) {
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        LogUtil.i(this.mTAG, "api call : setLoopback, isLoopback:" + z16);
        this.mPlayerMgrInternal.setLoopback(z16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnAudioFrameOutputListener(ISuperPlayer.OnAudioFrameOutputListener onAudioFrameOutputListener) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.setOnAudioFrameOutputListener(onAudioFrameOutputListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener onCaptureImageListener) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.setOnCaptureImageListener(onCaptureImageListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnCompletionListener(ISuperPlayer.OnCompletionListener onCompletionListener) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.setOnCompletionListener(onCompletionListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener onDefinitionInfoListener) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.setOnDefinitionInfoListener(onDefinitionInfoListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnErrorListener(ISuperPlayer.OnErrorListener onErrorListener) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.setOnErrorListener(onErrorListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnInfoListener(ISuperPlayer.OnInfoListener onInfoListener) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.setOnInfoListener(onInfoListener);
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void setOnPermissionTimeoutListener(ITVKOnPermissionTimeoutListener iTVKOnPermissionTimeoutListener) {
        throw new MethodNotSupportedException("can't setOnPermissionTimeoutListener in SuperPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnSubtitleDataListener(ISuperPlayer.OnSubtitleDataListener onSubtitleDataListener) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.setOnSubtitleDataListener(onSubtitleDataListener);
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void setOnTVKNetVideoInfoListener(ITVKOnNetVideoInfoListener iTVKOnNetVideoInfoListener) {
        throw new MethodNotSupportedException("can't setOnTVKNetVideoInfoListener in SuperPlayer");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnTVideoNetInfoUpdateListener(ISuperPlayer.OnTVideoNetInfoListener onTVideoNetInfoListener) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.setOnTVideoNetVideoInfoListener(onTVideoNetInfoListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnVideoFrameOutputListener(ISuperPlayer.OnVideoFrameOutputListener onVideoFrameOutputListener) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.setOnVideoOutputFrameListener(onVideoFrameOutputListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener onVideoPreparedListener) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.setOnVideoPreparedListener(onVideoPreparedListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
        if (superPlayerListenerMgr == null) {
            return;
        }
        superPlayerListenerMgr.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOutputMute(boolean z16) {
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        LogUtil.i(this.mTAG, "api call : setOutputMute:" + z16);
        this.mPlayerMgrInternal.setOutputMute(z16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setPlaySpeedRatio(float f16) {
        LogUtil.i(this.mTAG, "api call : setPlaySpeedRatio");
        this.mSpeedRatio = f16;
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return;
        }
        superPlayerMgrInternal.setPlaySpeedRatio(f16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setPlayerActive() {
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return;
        }
        SuperPlayerOption superPlayerOption = this.mOpenOption;
        if (superPlayerOption != null) {
            superPlayerOption.quickStopPlayerInBackground = false;
        }
        superPlayerMgrInternal.setPlayerActive();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setPlayerOptionalParamList(List<TPOptionalParam> list) {
        this.mTPOptionalParamList = list;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setReportContentId(String str) {
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.setReportContentId(str);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setSurface(Surface surface) {
        LogUtil.i(this.mTAG, "api call : setSurface");
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return;
        }
        superPlayerMgrInternal.setSurface(surface);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setVolumeGain(float f16) {
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        LogUtil.i(this.mTAG, "api handle : setVolumeGain");
        this.mPlayerMgrInternal.setVolumeGain(f16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setXYaxis(int i3) {
        LogUtil.i(this.mTAG, "api call : setXYaxis, type=" + i3);
        this.mXYaxis = i3;
        ISPlayerVideoView iSPlayerVideoView = this.mVideoView;
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.setXYaxis(i3);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void start() {
        LogUtil.i(this.mTAG, "api call : start");
        int curState = this.mPlayState.getCurState();
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        if (curState != 4 && curState != 5 && curState != 6 && curState != 7) {
            SPDeinitManager.DeinitPlayerInfo state = SuperPlayerSDKMgr.getDeinitManager().getState(this.mToken);
            if (curState == 0 && state != null && state.needRecover) {
                LogUtil.i(this.mTAG, "api call : start fail, had been stop by deinit, so go to open first");
                this.mNeedAutoStart = true;
                this.mNeedAutoPause = false;
                openMediaPlayer(this.mContext, this.mVideoInfo, state.position, this.mOpenOption);
                return;
            }
            LogUtil.e(this.mTAG, "api call : start, state error, currentState=" + curState);
            return;
        }
        this.mPlayState.changeStateAndNotify(5);
        this.mReporter.onStart();
        this.mPlayerMgrInternal.start();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void stop() {
        LogUtil.i(this.mTAG, "api call : stop");
        int curState = this.mPlayState.getCurState();
        if (curState != 8 && curState != 0 && curState != 10) {
            if (this.mPlayerMgrInternal == null) {
                return;
            }
            this.mPlayState.changeStateAndNotify(8);
            this.mReporter.onStop();
            this.mPlayerMgrInternal.stop();
            return;
        }
        LogUtil.e(this.mTAG, "api call : stop, failed, mPlayState.getCurState() == " + this.mPlayState.getCurState());
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void switchDefinition(String str, int i3) {
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        LogUtil.i(this.mTAG, "api call : switchDefinition, definition:" + str + ", mode:" + i3);
        this.mPlayerMgrInternal.switchDefinition(str, i3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void switchDefinitionForUrl(String str, int i3) {
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        LogUtil.i(this.mTAG, "api call : switchDefinitionForUrl, url:" + str + ", mode:" + i3);
        this.mPlayerMgrInternal.switchDefinitionForUrl(str, i3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void updatePlayerSceneId(int i3) {
        this.mSceneId = i3;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void updatePlayerVideoView(ISPlayerVideoView iSPlayerVideoView) {
        boolean z16;
        String str = this.mTAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("api call : updatePlayerVideoView, mVideoView == videoView is ");
        if (this.mVideoView == iSPlayerVideoView) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(", videoView=");
        sb5.append(iSPlayerVideoView);
        LogUtil.i(str, sb5.toString());
        if (iSPlayerVideoView != null) {
            LogUtil.d(this.mTAG, "\u65e5\u5fd7\u8fc7\u6ee4(View): \u3010" + iSPlayerVideoView.getLogTag() + "\u3011, updatePlayerVideoView");
        }
        ISPlayerVideoView iSPlayerVideoView2 = this.mVideoView;
        if (iSPlayerVideoView2 == iSPlayerVideoView) {
            return;
        }
        if (iSPlayerVideoView2 != null) {
            iSPlayerVideoView2.removeViewCallBack(null);
        }
        this.mVideoView = iSPlayerVideoView;
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.addViewCallBack(this);
            this.mVideoView.setXYaxis(this.mXYaxis);
        }
        SPlayerVideoView.SurfaceObject surfaceObject = this.mSurfaceObjectForChange;
        if (surfaceObject != null) {
            ISPlayerVideoView iSPlayerVideoView3 = this.mVideoView;
            if (iSPlayerVideoView3 != null) {
                iSPlayerVideoView3.changeSurfaceObject(surfaceObject);
            }
            this.mSurfaceObjectForChange = null;
            return;
        }
        SuperPlayerMgrInternal superPlayerMgrInternal = this.mPlayerMgrInternal;
        if (superPlayerMgrInternal == null) {
            return;
        }
        superPlayerMgrInternal.updatePlayerVideoView(iSPlayerVideoView);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void addExtReportData(Map<String, String> map) {
        this.mReporter.addExtReportData(map);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void openMediaPlayer(Context context, SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerOption superPlayerOption) {
        LogUtil.i(this.mTAG, "api call : openMediaPlayer, sceneid:" + getSceneId() + ", videoInfo:" + superPlayerVideoInfo + ", startPositionMilsec:" + j3 + ", playerOption:" + superPlayerOption);
        if (this.mPlayState.getCurState() != 0) {
            LogUtil.e(this.mTAG, "api call : openMediaPlayer, failed, mPlayState.getCurState() =" + this.mPlayState.getCurState());
            return;
        }
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        SuperPlayerSDKMgr.getDeinitManager().setPlayerActive(this);
        this.mPlayState.changeStateAndNotify(3);
        this.mReporter.onOpenMediaPlayer(superPlayerVideoInfo, j3, superPlayerOption);
        this.mPlayerMgrInternal.openMediaPlayer(context, superPlayerVideoInfo, j3, superPlayerOption);
        com.tencent.superplayer.bandwidth.a.b(this.mSceneId);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int captureImageInTime(long j3, int i3, int i16, int i17, int i18, int i19) throws IllegalStateException, IllegalArgumentException, IllegalAccessException {
        if (this.mPlayerMgrInternal == null) {
            return 0;
        }
        LogUtil.i(this.mTAG, "api call : captureImageInTime, positionMs:" + j3 + ", width:" + i3 + ", height:" + i16 + ", requestedTimeMsToleranceBefore:" + i17 + ", requestedTimeMsToleranceAfter:" + i18 + ", requestedTimeLimit:" + i19);
        return this.mPlayerMgrInternal.captureImageInTime(j3, i3, i16, i17, i18, i19);
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public int handleCaptureImageInTime(long j3, int i3, int i16, int i17, int i18, int i19) {
        LogUtil.i(this.mTAG, "api handle : handleCaptureImageInTime, positionMs:" + j3 + ", width:" + i3 + ", height:" + i16 + ", requestedTimeMsToleranceBefore:" + i17 + ", requestedTimeMsToleranceAfter:" + i18 + ", requestedTimeLimit:" + i19);
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            return superPlayerWrapper.captureImageInTime(j3, i3, i16, i17, i18, i19);
        }
        return -1;
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleSeekTo(int i3, int i16) {
        LogUtil.i(this.mTAG, "api handle : handleSeekToAccuratePos, positionMilsec:" + i3 + ", mode:" + i16);
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.seekTo(i3, i16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setLoopback(boolean z16, long j3, long j16) {
        setLoopback(z16, j3, j16, 1);
    }

    @Override // com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
    public void handleSetLoopback(boolean z16, long j3, long j16, int i3) {
        LogUtil.i(this.mTAG, "api handle : handleSetLoopback, isLoopback:" + z16 + ", loopStartPositionMs:" + j3 + ", loopEndPositionMs:" + j16);
        SuperPlayerWrapper superPlayerWrapper = this.mPlayerWrapper;
        if (superPlayerWrapper != null) {
            superPlayerWrapper.setLoopback(z16, j3, j16);
        }
    }

    public void setLoopback(boolean z16, long j3, long j16, int i3) {
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        LogUtil.i(this.mTAG, "api call : setLoopback, isLoopback:" + z16 + ", loopStartPositionMs:" + j3 + ", loopEndPositionMs:" + j16 + ", seekMode=" + i3);
        this.mPlayerMgrInternal.setLoopback(z16, j3, j16, i3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void seekTo(int i3, int i16) {
        if (this.mPlayerMgrInternal == null) {
            return;
        }
        LogUtil.i(this.mTAG, "api call : seekTo, positionMs:" + i3 + ", mode:" + i16);
        this.mIsSeeking = true;
        this.mReporter.onSeek(getCurrentPositionMs(), (long) i3);
        this.mPlayerMgrInternal.seekTo(i3, i16);
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceChanged(Object obj) {
    }
}
