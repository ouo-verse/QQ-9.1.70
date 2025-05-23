package com.tencent.thumbplayer.tpplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoID;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPPropertyID;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPTimeoutException;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.manager.TPMgrConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.ITPMediaAssetRequest;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import com.tencent.thumbplayer.api.player.ITPPlayerListener;
import com.tencent.thumbplayer.api.player.TPPlayerConstructParams;
import com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.v2.ITPReportExtendedController;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotParams;
import com.tencent.thumbplayer.asset.TPAfdMediaAsset;
import com.tencent.thumbplayer.asset.TPMediaAsset;
import com.tencent.thumbplayer.asset.TPPfdMediaAsset;
import com.tencent.thumbplayer.common.TPBasicTypeParseUtil;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.TPInnerOptionalID;
import com.tencent.thumbplayer.common.TPPlayerInfoGetterImpl;
import com.tencent.thumbplayer.common.TPPlayerStateToString;
import com.tencent.thumbplayer.common.config.TPConfig;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.common.thread.TPThreadPool;
import com.tencent.thumbplayer.common.thread.TPThreadSwitchProxy;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport;
import com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener;
import com.tencent.thumbplayer.datatransport.play.TPPlayDataTransport;
import com.tencent.thumbplayer.report.reportv1.TPReportManager;
import com.tencent.thumbplayer.report.reportv1.TPReportNonImplPlugin;
import com.tencent.thumbplayer.report.reportv2.TPReportController;
import com.tencent.thumbplayer.retry.ITPPlayerRetryAdapter;
import com.tencent.thumbplayer.retry.TPPlayerRetryAdapterFactory;
import com.tencent.thumbplayer.richmedia.ITPInnerRichMediaSynchronizer;
import com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase;
import com.tencent.thumbplayer.tpplayer.plugin.ITPPluginManager;
import com.tencent.thumbplayer.tpplayer.plugin.TPPluginManager;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPPlayer implements ITPPlayer, TPThreadSwitchProxy.IPreprocessing, ITPMediaAssetRequest {
    public static final long API_CALL_TIMEOUT_MS = 500;
    private static final String LOG_API_CALL_PREFIX = "api call:";
    private static final String THREAD_SWITCH_PREPROCESSING_API_NAME_SET_DATA_SOURCE = "setDataSource";
    private EventHandler mCallbackHandler;
    private Surface mCurSurface;
    private SurfaceHolder mCurSurfaceHolder;
    private ITPMediaAsset mCurrentMediaAsset;
    private ITPPlayDataTransport mDataTransport;
    private boolean mEnableSuggestedBitrateCallback;
    private final TPPlayerEventForwarder mEventForwarder;
    InnerDataTransportListener mInnerDataTransportLisenter;
    private InnerPlayerListener mInnerPlayerListener;
    private TPPlayerListeners mPlayerListeners;
    private ITPPluginManager mPluginManager;
    private TPReportController mReportController;
    private TPReportManager mReportManager;
    private TPReportNonImplPlugin mReportNonImplPlugin;
    private Object mReportParam;
    private ITPPlayerRetryAdapter mRetryAdapter;
    private ITPInnerRichMediaSynchronizer mRichMediaSynchronizer;
    private final TPPlayerStateMgr mStateMgr;
    private Map<Integer, Long> mSwitchTaskIDToOpaqueMap;
    private TPContext mTPContext;
    private long mUniqueIdCounter;
    private Map<Long, Long> mUniqueIdToOpaqueMap;
    private HandlerThread mWorkThread;

    /* loaded from: classes26.dex */
    private class InnerDataTransportListener implements ITPPlayDataTransportListener {
        InnerDataTransportListener() {
        }

        @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener
        public void onDownloadFinished() {
            TPLogUtil.i(TPPlayer.this.mTPContext.getLogTag(), "data transport, onDownloadFinished");
            TPPlayer.this.postOnInfoCallback(80000, null);
        }

        @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener
        public void onError(@NonNull TPError tPError) {
            TPPlayer.this.postOnInfoCallback(80003, new TPOnInfoParam.Builder().setObjParam(tPError).build());
        }

        @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener
        public long onGetCurrentPlayOffsetByte() {
            return TPPlayer.this.mRetryAdapter.getDemuxerOffsetInFileByte();
        }

        @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener
        public long onGetCurrentPositionMs() {
            return TPPlayer.this.mRetryAdapter.getCurrentPositionMs();
        }

        @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener
        public long onGetPlayerBufferLengthMs() {
            return Math.max(TPPlayer.this.mRetryAdapter.getAvailablePositionMs() - TPPlayer.this.mRetryAdapter.getCurrentPositionMs(), 0L);
        }

        @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener
        public long onGetRemainTimeBeforePlayMs() {
            return TPPlayer.this.mPlayerListeners.onGetRemainTimeBeforePlayMs(TPPlayer.this);
        }

        @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener
        public void onInfo(int i3, TPDataTransportMessageInfo tPDataTransportMessageInfo) {
            if (i3 != 14) {
                if (i3 == 16) {
                    TPPlayer.this.mEventForwarder.forwardProtocolUpdateEvent((String) tPDataTransportMessageInfo.obj1, (String) tPDataTransportMessageInfo.obj2);
                }
            } else {
                TPPlayer.this.mEventForwarder.forwardCdnUrlUpdateEvent((String) tPDataTransportMessageInfo.obj1, (String) tPDataTransportMessageInfo.obj2, (String) tPDataTransportMessageInfo.obj3);
            }
            TPPlayer.this.postOnInfoCallback(TPOnInfoID.TP_ONINFO_ID_LONG1_OBJ_DATA_TRANSPORT_INFO, new TPOnInfoParam.Builder().setLongParam(i3).setObjParam(tPDataTransportMessageInfo).build());
        }

        @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener
        public void onMediaAssetExpire() {
            TPLogUtil.i(TPPlayer.this.mTPContext.getLogTag(), "data transport, onMediaAssetExpire");
            TPPlayer.this.postOnMediaAssetExpireCallback();
        }

        @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener
        public void onNeedReconnectDueToM3u8DataUpdate() {
            TPPlayer.this.mRetryAdapter.reopenPlayer(false);
        }

        @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener
        public void onNeedReconnectDueToMediaDataInvalid() {
            TPPlayer.this.mRetryAdapter.reopenPlayer(true);
        }

        @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener
        public void onProgressUpdate(@NonNull TPDownloadProgressInfo tPDownloadProgressInfo) {
            TPPlayer.this.postOnInfoCallback(80001, new TPOnInfoParam.Builder().setObjParam(tPDownloadProgressInfo).build());
            TPPlayer.this.mEventForwarder.forwardDownloadProgressEvent(tPDownloadProgressInfo.getDownloadSpeedbps(), tPDownloadProgressInfo.getExtraInfo());
        }

        @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener
        public void onSuggestedBitrateChanged(int i3) {
            long j3 = i3;
            TPPlayer.this.mRetryAdapter.addOptionalParam(TPOptionalParam.buildLong(TPInnerOptionalID.OPTIONAL_ID_GLOBAL_LONG_ADAPTIVE_SUGGEST_BITRATE_BPS, j3));
            if (TPPlayer.this.mEnableSuggestedBitrateCallback) {
                TPPlayer.this.postOnInfoCallback(80002, new TPOnInfoParam.Builder().setLongParam(j3).build());
            }
        }

        @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransportListener
        public void onSwitchDataSourceComplete(long j3) {
            TPPlayer.this.postOnInfoCallback(3, new TPOnInfoParam.Builder().setLongParam(j3).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class InnerPlayerListener implements ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnVideoSizeChangedListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnAudioFrameOutListener, ITPPlayerListener.IOnAudioProcessFrameOutListener, ITPPlayerListener.IOnSubtitleDataOutListener, ITPPlayerListener.IOnStateChangedListener, ITPPlayerListener.IOnDebugTrackingInfoListener, ITPPlayerListener.IOnSnapshotListener {
        InnerPlayerListener() {
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnAudioFrameOutListener
        public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
            if (!TPPlayer.this.mStateMgr.isInStates(2, 3, 4, 5)) {
                TPLogUtil.w(TPPlayer.this.mTPContext.getLogTag(), "onAudioFrameOut, invalid state:" + TPPlayerStateToString.getStateName(TPPlayer.this.mStateMgr.getCurrentState()));
                return;
            }
            TPPlayer.this.mPlayerListeners.onAudioFrameOut(iTPPlayer, tPAudioFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnAudioProcessFrameOutListener
        public TPAudioFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
            if (!TPPlayer.this.mStateMgr.isInStates(2, 3, 4, 5)) {
                TPLogUtil.w(TPPlayer.this.mTPContext.getLogTag(), "onAudioProcessFrameOut, invalid state:" + TPPlayerStateToString.getStateName(TPPlayer.this.mStateMgr.getCurrentState()));
                return null;
            }
            return TPPlayer.this.mPlayerListeners.onAudioProcessFrameOut(iTPPlayer, tPAudioFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnCompletionListener
        public void onCompletion(ITPPlayer iTPPlayer) {
            ReportThumbPlayer.getInstance().onCompletion(iTPPlayer);
            if (!TPPlayer.this.mStateMgr.isInStates(3, 4, 5)) {
                TPLogUtil.w(TPPlayer.this.mTPContext.getLogTag(), "onCompletion, invalid state:" + TPPlayerStateToString.getStateName(TPPlayer.this.mStateMgr.getCurrentState()));
                return;
            }
            TPLogUtil.i(TPPlayer.this.mTPContext.getLogTag(), "onCompletion");
            TPPlayer.this.mStateMgr.changeToState(6);
            TPPlayer.this.postOnCompletionCallback();
            TPPlayer.this.mEventForwarder.forwardCompletionEvent();
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnDebugTrackingInfoListener
        public void onDebugTrackingInfo(ITPPlayer iTPPlayer, TPDebugTrackingInfo tPDebugTrackingInfo) {
            TPPlayer.this.postOnDebugTrackingCallback(tPDebugTrackingInfo);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnErrorListener
        public void onError(ITPPlayer iTPPlayer, @NonNull TPError tPError) {
            String obj;
            ReportThumbPlayer.getInstance().onError(iTPPlayer, tPError);
            if (!TPPlayer.this.mStateMgr.isInStates(1, 2, 3, 4, 5)) {
                TPLogUtil.w(TPPlayer.this.mTPContext.getLogTag(), "onError, invalid state:" + TPPlayerStateToString.getStateName(TPPlayer.this.mStateMgr.getCurrentState()));
                return;
            }
            TPLogUtil.e(TPPlayer.this.mTPContext.getLogTag(), "error:" + tPError);
            TPPlayer.this.mStateMgr.changeToState(9);
            Object extraParam = tPError.getExtraParam(TPError.TP_ERRPR_EXTRA_PARAM_STRING_ASSET_OPAQUE);
            ITPPlayDataTransport iTPPlayDataTransport = TPPlayer.this.mDataTransport;
            if (extraParam == null) {
                obj = "";
            } else {
                obj = extraParam.toString();
            }
            TPError error = iTPPlayDataTransport.getError(obj);
            if (error != null) {
                TPError tPError2 = new TPError(error.getErrorType(), error.getErrorCode(), tPError.getCurrentPosMs());
                for (String str : error.getAllExtraParams().keySet()) {
                    tPError2.addExtraParam(str, error.getExtraParam(str));
                }
                for (String str2 : tPError.getAllExtraParams().keySet()) {
                    tPError2.addExtraParam(str2, tPError.getExtraParam(str2));
                }
                tPError2.addExtraParam(TPError.TP_ERRPR_EXTRA_PARAM_STRING_ASSET_OPAQUE, error.getExtraParam(TPError.TP_ERRPR_EXTRA_PARAM_STRING_ASSET_OPAQUE));
                tPError2.addExtraParam(TPError.TP_ERROR_EXTRA_PARAM_INT_TRACK_INDEX, tPError.getExtraParam(TPError.TP_ERROR_EXTRA_PARAM_INT_TRACK_INDEX));
                TPLogUtil.e(TPPlayer.this.mTPContext.getLogTag(), "error replaced by: " + tPError2);
                tPError = tPError2;
            }
            TPPlayer.this.postOnErrorCallback(tPError);
            TPPlayer.this.mEventForwarder.forwardErrorEvent(tPError);
            TPPlayer.this.mDataTransport.pause();
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnInfoListener
        public void onInfo(ITPPlayer iTPPlayer, int i3, TPOnInfoParam tPOnInfoParam) {
            ReportThumbPlayer.getInstance().onInfo(iTPPlayer, i3, tPOnInfoParam);
            if (i3 == 3) {
                TPPlayer.this.handleOnSwitchDataSourceComplete(i3, tPOnInfoParam);
                return;
            }
            if (i3 == 101) {
                TPPlayer.this.handleOnFirstClipOpened(i3, tPOnInfoParam);
                return;
            }
            if (i3 == 501) {
                TPPlayer.this.handleOnHlsPrivateTag(i3, tPOnInfoParam);
                return;
            }
            if (i3 == 200) {
                TPPlayer.this.handleOnBufferingStart(i3, tPOnInfoParam);
                return;
            }
            if (i3 != 201) {
                switch (i3) {
                    case 10:
                        TPPlayer.this.handleOnSelectTrackSuccess(i3, tPOnInfoParam);
                        return;
                    case 11:
                        TPPlayer.this.handleOnSelectTrackError(i3, tPOnInfoParam);
                        return;
                    case 12:
                        TPPlayer.this.handleOnDeselectTrackSuccess(i3, tPOnInfoParam);
                        return;
                    case 13:
                        TPPlayer.this.handleOnDeselectTrackError(i3, tPOnInfoParam);
                        return;
                    default:
                        switch (i3) {
                            case 105:
                                TPPlayer.this.handleOnFirstAudioFrameRendered(i3, tPOnInfoParam);
                                return;
                            case 106:
                                TPPlayer.this.handleOnFirstVideoFrameRendered(i3, tPOnInfoParam);
                                return;
                            case 107:
                                TPPlayer.this.handleOnFirstPacketRead(i3, tPOnInfoParam);
                                return;
                            default:
                                TPPlayer.this.postOnInfoCallback(i3, tPOnInfoParam);
                                return;
                        }
                }
            }
            TPPlayer.this.handleOnBufferingEnd(i3, tPOnInfoParam);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnPreparedListener
        public void onPrepared(ITPPlayer iTPPlayer) {
            boolean z16;
            ReportThumbPlayer.getInstance().onPrepared(iTPPlayer);
            if (!TPPlayer.this.mStateMgr.isInStates(2)) {
                TPLogUtil.w(TPPlayer.this.mTPContext.getLogTag(), "onPrepared, invalid state:" + TPPlayerStateToString.getStateName(TPPlayer.this.mStateMgr.getCurrentState()));
                return;
            }
            TPLogUtil.i(TPPlayer.this.mTPContext.getLogTag(), "onPrepared");
            TPPlayer.this.mStateMgr.changeToState(3);
            TPPlayer.this.postOnDebugTrackingCallback(new TPDebugTrackingInfo(1004));
            TPPlayer.this.postOnPreparedCallback();
            String str = TPPlayer.this.mRetryAdapter.getWidth() + "*" + TPPlayer.this.mRetryAdapter.getHeight();
            int trackCount = TPPlayer.this.getTrackCount(1);
            TPPlayerEventForwarder tPPlayerEventForwarder = TPPlayer.this.mEventForwarder;
            int playerCoreType = TPPlayer.this.mRetryAdapter.getPlayerCoreType();
            long optLong = TPBasicTypeParseUtil.optLong(TPPlayer.this.mRetryAdapter.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_VIDEO_BITRATE), 0L);
            long durationMs = TPPlayer.this.mRetryAdapter.getDurationMs();
            String property = TPPlayer.this.mRetryAdapter.getProperty(TPPropertyID.TP_PROPERTY_ID_STRING_CONTAINER_FORMAT);
            if (trackCount > 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            tPPlayerEventForwarder.forwardPrepareCompleteEvent(playerCoreType, str, optLong, durationMs, property, z16);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSeekCompleteListener
        public void onSeekComplete(ITPPlayer iTPPlayer, long j3) {
            if (!TPPlayer.this.mStateMgr.isInStates(3, 4, 5)) {
                TPLogUtil.w(TPPlayer.this.mTPContext.getLogTag(), "onSeekComplete, invalid state:" + TPPlayerStateToString.getStateName(TPPlayer.this.mStateMgr.getCurrentState()));
                return;
            }
            TPPlayer.this.mDataTransport.onSeekComplete();
            TPPlayer.this.postOnSeekCompleteCallback(j3);
            TPPlayer.this.mEventForwarder.forwardSeekCompleteEvent(TPPlayer.this.getCurrentPositionMs());
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSnapshotListener
        public void onSnapshotFailed(ITPPlayer iTPPlayer, long j3, @NonNull TPError tPError) {
            TPPlayer.this.postOnSnapshotFailedCallback(j3, tPError);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSnapshotListener
        public void onSnapshotSuccess(ITPPlayer iTPPlayer, long j3, long j16, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer) {
            TPPlayer.this.postOnSnapshotSuccessCallback(j3, j16, tPVideoFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnStateChangedListener
        public void onStateChanged(ITPPlayer iTPPlayer, int i3, int i16) {
            TPPlayer.this.mDataTransport.onPlayerStateChanged(i16);
            TPPlayer.this.postOnStateChangedCallback(i3, i16);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSubtitleDataOutListener
        public void onSubtitleDataOut(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
            if (!TPPlayer.this.mStateMgr.isInStates(2, 3, 4, 5)) {
                TPLogUtil.w(TPPlayer.this.mTPContext.getLogTag(), "onSubtitleDataOut, invalid state:" + TPPlayerStateToString.getStateName(TPPlayer.this.mStateMgr.getCurrentState()));
                return;
            }
            TPPlayer.this.mPlayerListeners.onSubtitleDataOut(iTPPlayer, tPSubtitleData);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnVideoFrameOutListener
        public void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
            if (!TPPlayer.this.mStateMgr.isInStates(2, 3, 4, 5)) {
                TPLogUtil.w(TPPlayer.this.mTPContext.getLogTag(), "onVideoFrameOut, invalid state:" + TPPlayerStateToString.getStateName(TPPlayer.this.mStateMgr.getCurrentState()));
                return;
            }
            TPPlayer.this.mPlayerListeners.onVideoFrameOut(iTPPlayer, tPVideoFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnVideoSizeChangedListener
        public void onVideoSizeChanged(ITPPlayer iTPPlayer, int i3, int i16) {
            if (TPPlayer.this.mStateMgr.isInStates(2, 3, 4, 5)) {
                TPPlayer.this.postOnVideoSizeChangedCallback(i3, i16);
                return;
            }
            TPLogUtil.w(TPPlayer.this.mTPContext.getLogTag(), "onVideoSizeChanged, invalid state:" + TPPlayerStateToString.getStateName(TPPlayer.this.mStateMgr.getCurrentState()));
        }
    }

    public TPPlayer(Context context) throws TPLoadLibraryException {
        this(context, null);
    }

    private void addOptionalParamInternal(@NonNull TPOptionalParam<?> tPOptionalParam) {
        if (TPOptionalID.OPTIONAL_ID_GLOBAL_BOOL_ENABLE_SUGGESTED_BITRATE_CALLBACK.equals(tPOptionalParam.getKey())) {
            this.mEnableSuggestedBitrateCallback = ((Boolean) tPOptionalParam.getValue()).booleanValue();
        }
    }

    private long assignUniqueIDForOpaque(long j3) {
        this.mUniqueIdToOpaqueMap.put(Long.valueOf(this.mUniqueIdCounter), Long.valueOf(j3));
        TPLogUtil.i(this.mTPContext.getLogTag(), "convert opaque(" + j3 + ") => uniqueID(" + this.mUniqueIdCounter + ")");
        long j16 = this.mUniqueIdCounter;
        this.mUniqueIdCounter = 1 + j16;
        return j16;
    }

    private long getOpaqueFromUniqueID(long j3) {
        if (!this.mUniqueIdToOpaqueMap.containsKey(Long.valueOf(j3))) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "invalid uniqueID: " + j3);
            return -1L;
        }
        long longValue = this.mUniqueIdToOpaqueMap.get(Long.valueOf(j3)).longValue();
        TPLogUtil.i(this.mTPContext.getLogTag(), "convert uniqueID(" + j3 + ") => opaque(" + longValue + ")");
        return longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTrackCount(int i3) {
        TPTrackInfo[] trackInfo = this.mRetryAdapter.getTrackInfo();
        if (trackInfo == null || trackInfo.length == 0) {
            return 0;
        }
        int i16 = 0;
        for (TPTrackInfo tPTrackInfo : trackInfo) {
            if (tPTrackInfo != null && tPTrackInfo.getMediaType() == i3) {
                i16++;
            }
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnBufferingEnd(int i3, TPOnInfoParam tPOnInfoParam) {
        this.mDataTransport.onBufferingEnd();
        postOnInfoCallback(i3, tPOnInfoParam);
        this.mEventForwarder.forwardBufferingEndEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnBufferingStart(int i3, TPOnInfoParam tPOnInfoParam) {
        this.mDataTransport.onBufferingStart();
        postOnInfoCallback(i3, tPOnInfoParam);
        this.mEventForwarder.forwardBufferingStartEvent(getCurrentPositionMs(), this.mCurrentMediaAsset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnDeselectTrackError(int i3, TPOnInfoParam tPOnInfoParam) {
        if (tPOnInfoParam == null) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "deselect track error, but onInfoParam is null!");
        } else {
            postOnInfoCallback(i3, new TPOnInfoParam.Builder(tPOnInfoParam).setLongParam(getOpaqueFromUniqueID(tPOnInfoParam.getLongParam1())).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnDeselectTrackSuccess(int i3, TPOnInfoParam tPOnInfoParam) {
        if (tPOnInfoParam == null) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "deselect track success, but onInfoParam is null!");
        } else {
            postOnInfoCallback(i3, new TPOnInfoParam.Builder(tPOnInfoParam).setLongParam(getOpaqueFromUniqueID(tPOnInfoParam.getLongParam1())).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnFirstAudioFrameRendered(int i3, TPOnInfoParam tPOnInfoParam) {
        postOnInfoCallback(i3, tPOnInfoParam);
        postOnDebugTrackingCallback(new TPDebugTrackingInfo(1006));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnFirstClipOpened(int i3, TPOnInfoParam tPOnInfoParam) {
        postOnInfoCallback(i3, tPOnInfoParam);
        this.mEventForwarder.forwardFirstClipOpenedEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnFirstPacketRead(int i3, TPOnInfoParam tPOnInfoParam) {
        postOnInfoCallback(i3, tPOnInfoParam);
        this.mEventForwarder.forwardFirstPacketReadEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnFirstVideoFrameRendered(int i3, TPOnInfoParam tPOnInfoParam) {
        postOnInfoCallback(i3, tPOnInfoParam);
        postOnDebugTrackingCallback(new TPDebugTrackingInfo(1005));
        this.mEventForwarder.forwardFirstVideoFrameRenderedEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnHlsPrivateTag(int i3, TPOnInfoParam tPOnInfoParam) {
        if (tPOnInfoParam == null) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "on hls private tag, but onInfoParam is null!");
        } else {
            postOnInfoCallback(i3, tPOnInfoParam);
            this.mEventForwarder.forwardHlsPrivateTagEvent(tPOnInfoParam.getStrParam1());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnSelectTrackError(int i3, TPOnInfoParam tPOnInfoParam) {
        if (tPOnInfoParam == null) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "select track error, but onInfoParam is null!");
            return;
        }
        postOnInfoCallback(i3, new TPOnInfoParam.Builder(tPOnInfoParam).setLongParam(getOpaqueFromUniqueID(tPOnInfoParam.getLongParam1())).build());
        this.mEventForwarder.forwardSelectTrackCompleteEvent((TPError) tPOnInfoParam.getObjParam(), tPOnInfoParam.getLongParam1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnSelectTrackSuccess(int i3, TPOnInfoParam tPOnInfoParam) {
        if (tPOnInfoParam == null) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "select track success, but onInfoParam is null!");
            return;
        }
        postOnInfoCallback(i3, new TPOnInfoParam.Builder(tPOnInfoParam).setLongParam(getOpaqueFromUniqueID(tPOnInfoParam.getLongParam1())).build());
        this.mEventForwarder.forwardSelectTrackCompleteEvent(null, tPOnInfoParam.getLongParam1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnSwitchDataSourceComplete(int i3, TPOnInfoParam tPOnInfoParam) {
        if (tPOnInfoParam == null) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "switch data source complete, but onInfoParam is null!");
            return;
        }
        int longParam1 = (int) tPOnInfoParam.getLongParam1();
        if (!this.mSwitchTaskIDToOpaqueMap.containsKey(Integer.valueOf(longParam1))) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "switch data source complete, but task id not found!");
            return;
        }
        long longValue = this.mSwitchTaskIDToOpaqueMap.get(Integer.valueOf(longParam1)).longValue();
        this.mDataTransport.onSwitchDataSourceComplete(longParam1);
        postOnInfoCallback(i3, new TPOnInfoParam.Builder(tPOnInfoParam).setLongParam(longValue).build());
        this.mEventForwarder.forwardSwitchDataSourceCompleteEvent();
    }

    private void initCallbackHandler(@NonNull Looper looper, Looper looper2) {
        if (looper2 == null) {
            if (Looper.myLooper() == null) {
                this.mCallbackHandler = new EventHandler(looper);
                return;
            } else {
                this.mCallbackHandler = new EventHandler();
                return;
            }
        }
        this.mCallbackHandler = new EventHandler(looper2);
    }

    private void initPlayerRetryAdapter(@Nullable TPPlayerConstructParams tPPlayerConstructParams) throws TPLoadLibraryException {
        ITPPlayerRetryAdapter createTPPlayerRetryAdapter = TPPlayerRetryAdapterFactory.createTPPlayerRetryAdapter(this.mTPContext, tPPlayerConstructParams);
        this.mRetryAdapter = createTPPlayerRetryAdapter;
        createTPPlayerRetryAdapter.setOnPreparedListener(this.mInnerPlayerListener);
        this.mRetryAdapter.setOnCompletionListener(this.mInnerPlayerListener);
        this.mRetryAdapter.setOnInfoListener(this.mInnerPlayerListener);
        this.mRetryAdapter.setOnErrorListener(this.mInnerPlayerListener);
        this.mRetryAdapter.setOnSeekCompleteListener(this.mInnerPlayerListener);
        this.mRetryAdapter.setOnVideoSizeChangedListener(this.mInnerPlayerListener);
        this.mRetryAdapter.setOnVideoFrameOutListener(this.mInnerPlayerListener);
        this.mRetryAdapter.setOnAudioFrameOutListener(this.mInnerPlayerListener);
        this.mRetryAdapter.setOnAudioProcessFrameOutListener(this.mInnerPlayerListener);
        this.mRetryAdapter.setOnSubtitleDataOutListener(this.mInnerPlayerListener);
        this.mRetryAdapter.setOnStateChangedListener(this.mInnerPlayerListener);
        this.mRetryAdapter.setOnDebugTrackingInfoListener(this.mInnerPlayerListener);
        this.mRetryAdapter.setOnSnapshotListener(this.mInnerPlayerListener);
    }

    private void initPluginAndDataReport() {
        this.mPluginManager = new TPPluginManager();
        if (((Boolean) TPConfig.getConfigValue(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_PLAYING_QUALITY_REPORT, Boolean.TRUE)).booleanValue()) {
            TPReportManager tPReportManager = new TPReportManager(this.mTPContext.getAppContext());
            this.mReportManager = tPReportManager;
            this.mPluginManager.addPlugin(tPReportManager);
        } else {
            TPReportNonImplPlugin tPReportNonImplPlugin = new TPReportNonImplPlugin();
            this.mReportNonImplPlugin = tPReportNonImplPlugin;
            this.mPluginManager.addPlugin(tPReportNonImplPlugin);
        }
        if (((Boolean) TPConfig.getConfigValue(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_NEW_PLAYING_QUALITY_REPORT, Boolean.FALSE)).booleanValue()) {
            TPReportController tPReportController = new TPReportController(this.mTPContext.getAppContext());
            this.mReportController = tPReportController;
            tPReportController.setPlayerInfoGetter(new TPPlayerInfoGetterImpl(this.mRetryAdapter));
            this.mReportController.init();
            this.mTPContext.getPlayerEventPublisher().addEventReceiver(this.mReportController);
        }
    }

    private Looper initWorkerLooper(Looper looper) {
        if (looper == null || looper == Looper.getMainLooper()) {
            HandlerThread obtainHandleThread = TPThreadPool.getInstance().obtainHandleThread("TPWorkThread");
            this.mWorkThread = obtainHandleThread;
            return obtainHandleThread.getLooper();
        }
        return looper;
    }

    private void internalStop() {
        this.mStateMgr.changeToState(7);
        this.mRetryAdapter.stop();
        this.mStateMgr.changeToState(8);
        this.mEventForwarder.forwardStopEvent();
        this.mDataTransport.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postOnCompletionCallback$6() {
        TPLogUtil.i(this.mTPContext.getLogTag(), "post callback: onCompletion");
        this.mPlayerListeners.onCompletion(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postOnDebugTrackingCallback$2(TPDebugTrackingInfo tPDebugTrackingInfo) {
        this.mPlayerListeners.onDebugTrackingInfo(this, tPDebugTrackingInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postOnErrorCallback$7(TPError tPError) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "post callback: onError");
        this.mPlayerListeners.onError(this, tPError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postOnInfoCallback$1(int i3, TPOnInfoParam tPOnInfoParam) {
        this.mPlayerListeners.onInfo(this, i3, tPOnInfoParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postOnMediaAssetExpireCallback$11() {
        this.mPlayerListeners.onMediaAssetExpire(this, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postOnPreparedCallback$5() {
        TPLogUtil.i(this.mTPContext.getLogTag(), "post callback: onPrepared");
        this.mPlayerListeners.onPrepared(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postOnSeekCompleteCallback$8(long j3) {
        this.mPlayerListeners.onSeekComplete(this, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postOnSnapshotFailedCallback$4(long j3, TPError tPError) {
        this.mPlayerListeners.onSnapshotFailed(this, j3, tPError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postOnSnapshotSuccessCallback$3(long j3, long j16, TPVideoFrameBuffer tPVideoFrameBuffer) {
        this.mPlayerListeners.onSnapshotSuccess(this, j3, j16, tPVideoFrameBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postOnStateChangedCallback$10(int i3, int i16) {
        this.mPlayerListeners.onStateChanged(this, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postOnStopAsyncCompleteCallback$12() {
        this.mPlayerListeners.onStopAsyncComplete(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postOnVideoSizeChangedCallback$9(int i3, int i16) {
        this.mPlayerListeners.onVideoSizeChanged(this, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$setRichMediaSynchronizer$0(ITPInnerRichMediaSynchronizer iTPInnerRichMediaSynchronizer) {
        return getCurrentPositionMs();
    }

    private void postCallback(Runnable runnable) {
        EventHandler eventHandler = this.mCallbackHandler;
        if (eventHandler != null) {
            if (eventHandler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                this.mCallbackHandler.post(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnCompletionCallback() {
        postCallback(new Runnable() { // from class: com.tencent.thumbplayer.tpplayer.k
            @Override // java.lang.Runnable
            public final void run() {
                TPPlayer.this.lambda$postOnCompletionCallback$6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnDebugTrackingCallback(final TPDebugTrackingInfo tPDebugTrackingInfo) {
        postCallback(new Runnable() { // from class: com.tencent.thumbplayer.tpplayer.g
            @Override // java.lang.Runnable
            public final void run() {
                TPPlayer.this.lambda$postOnDebugTrackingCallback$2(tPDebugTrackingInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnErrorCallback(final TPError tPError) {
        postCallback(new Runnable() { // from class: com.tencent.thumbplayer.tpplayer.i
            @Override // java.lang.Runnable
            public final void run() {
                TPPlayer.this.lambda$postOnErrorCallback$7(tPError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnInfoCallback(final int i3, final TPOnInfoParam tPOnInfoParam) {
        postCallback(new Runnable() { // from class: com.tencent.thumbplayer.tpplayer.c
            @Override // java.lang.Runnable
            public final void run() {
                TPPlayer.this.lambda$postOnInfoCallback$1(i3, tPOnInfoParam);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnMediaAssetExpireCallback() {
        postCallback(new Runnable() { // from class: com.tencent.thumbplayer.tpplayer.d
            @Override // java.lang.Runnable
            public final void run() {
                TPPlayer.this.lambda$postOnMediaAssetExpireCallback$11();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnPreparedCallback() {
        postCallback(new Runnable() { // from class: com.tencent.thumbplayer.tpplayer.h
            @Override // java.lang.Runnable
            public final void run() {
                TPPlayer.this.lambda$postOnPreparedCallback$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnSeekCompleteCallback(final long j3) {
        postCallback(new Runnable() { // from class: com.tencent.thumbplayer.tpplayer.b
            @Override // java.lang.Runnable
            public final void run() {
                TPPlayer.this.lambda$postOnSeekCompleteCallback$8(j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnSnapshotFailedCallback(final long j3, final TPError tPError) {
        postCallback(new Runnable() { // from class: com.tencent.thumbplayer.tpplayer.j
            @Override // java.lang.Runnable
            public final void run() {
                TPPlayer.this.lambda$postOnSnapshotFailedCallback$4(j3, tPError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnSnapshotSuccessCallback(final long j3, final long j16, final TPVideoFrameBuffer tPVideoFrameBuffer) {
        postCallback(new Runnable() { // from class: com.tencent.thumbplayer.tpplayer.f
            @Override // java.lang.Runnable
            public final void run() {
                TPPlayer.this.lambda$postOnSnapshotSuccessCallback$3(j3, j16, tPVideoFrameBuffer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnStateChangedCallback(final int i3, final int i16) {
        postCallback(new Runnable() { // from class: com.tencent.thumbplayer.tpplayer.a
            @Override // java.lang.Runnable
            public final void run() {
                TPPlayer.this.lambda$postOnStateChangedCallback$10(i3, i16);
            }
        });
    }

    private void postOnStopAsyncCompleteCallback() {
        postCallback(new Runnable() { // from class: com.tencent.thumbplayer.tpplayer.e
            @Override // java.lang.Runnable
            public final void run() {
                TPPlayer.this.lambda$postOnStopAsyncCompleteCallback$12();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnVideoSizeChangedCallback(final int i3, final int i16) {
        postCallback(new Runnable() { // from class: com.tencent.thumbplayer.tpplayer.l
            @Override // java.lang.Runnable
            public final void run() {
                TPPlayer.this.lambda$postOnVideoSizeChangedCallback$9(i3, i16);
            }
        });
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true)
    public void addAudioTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException, UnsupportedOperationException {
        if (!TextUtils.isEmpty(str)) {
            if (iTPMediaAsset.isValid() && iTPMediaAsset.getAssetType() == 3) {
                TPLogUtil.i(this.mTPContext.getLogTag(), "api call:addAudioTrackSource, name:" + str + ", audioAsset:" + iTPMediaAsset);
                ITPMediaAsset startAudioTrack = this.mDataTransport.startAudioTrack(iTPMediaAsset);
                if (startAudioTrack != null) {
                    this.mRetryAdapter.addAudioTrackSource(startAudioTrack, str);
                    return;
                } else {
                    TPLogUtil.e(this.mTPContext.getLogTag(), "api call:addAudioTrackSource, start data transport task failed.");
                    throw new UnsupportedOperationException("failed to call addAudioTrackSource");
                }
            }
            throw new IllegalArgumentException("addAudioTrackSource, asset is invalid, name:" + str + ", audioAsset:" + iTPMediaAsset);
        }
        throw new IllegalArgumentException("addAudioTrackSource, name is empty");
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true)
    public void addOptionalParam(TPOptionalParam<?> tPOptionalParam) throws IllegalStateException {
        ReportThumbPlayer.getInstance().setPlayerOptionalParam(this, tPOptionalParam);
        addOptionalParamInternal(tPOptionalParam);
        this.mDataTransport.addOptionalParam(tPOptionalParam);
        this.mRetryAdapter.addOptionalParam(tPOptionalParam);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void addPlugin(ITPPluginBase iTPPluginBase) {
        ITPPluginManager iTPPluginManager = this.mPluginManager;
        if (iTPPluginManager != null) {
            iTPPluginManager.addPlugin(iTPPluginBase);
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true)
    public void addSubtitleTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException, UnsupportedOperationException {
        if (!TextUtils.isEmpty(str)) {
            if (iTPMediaAsset.isValid() && iTPMediaAsset.getAssetType() == 3) {
                TPLogUtil.i(this.mTPContext.getLogTag(), "api call:addSubtitleTrackSource, name:" + str + ", subtitleAsset:" + iTPMediaAsset);
                long currentTimeMillis = System.currentTimeMillis();
                ITPMediaAsset startSubtitleTrack = this.mDataTransport.startSubtitleTrack(iTPMediaAsset);
                if (startSubtitleTrack != null) {
                    this.mRetryAdapter.addSubtitleTrackSource(startSubtitleTrack, str);
                    this.mEventForwarder.forwardAddSubtitleEvent(str, iTPMediaAsset, currentTimeMillis, System.currentTimeMillis());
                    return;
                } else {
                    TPLogUtil.e(this.mTPContext.getLogTag(), "api call:addSubtitleTrackSource, start data transport task failed.");
                    throw new UnsupportedOperationException("failed to call addSubtitleTrackSource");
                }
            }
            throw new IllegalArgumentException("addSubtitleTrackSource, asset is invalid, name:" + str + ", subtitleAsset:" + iTPMediaAsset);
        }
        throw new IllegalArgumentException("addSubtitleTrackSource, name is empty");
    }

    @Override // com.tencent.thumbplayer.common.thread.TPThreadSwitchProxy.IPreprocessing
    public void beforeThreadSwitch(Method method, Object[] objArr) {
        if (THREAD_SWITCH_PREPROCESSING_API_NAME_SET_DATA_SOURCE.equals(method.getName()) && objArr != null && objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof TPPfdMediaAsset) {
                try {
                    TPPfdMediaAsset tPPfdMediaAsset = (TPPfdMediaAsset) obj;
                    ParcelFileDescriptor parcelFileDescriptor = tPPfdMediaAsset.getParcelFileDescriptor();
                    if (parcelFileDescriptor != null) {
                        tPPfdMediaAsset.setParcelFileDescriptor(ParcelFileDescriptor.fromFd(parcelFileDescriptor.detachFd()));
                        parcelFileDescriptor.close();
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    TPLogUtil.e(this.mTPContext.getLogTag(), e16, "[beforeThreadSwitch] Exception encountered: ");
                    return;
                }
            }
            if (obj instanceof TPAfdMediaAsset) {
                try {
                    TPAfdMediaAsset tPAfdMediaAsset = (TPAfdMediaAsset) obj;
                    AssetFileDescriptor assetFileDescriptor = tPAfdMediaAsset.getAssetFileDescriptor();
                    if (assetFileDescriptor != null) {
                        tPAfdMediaAsset.setAssetFileDescriptor(new AssetFileDescriptor(ParcelFileDescriptor.fromFd(assetFileDescriptor.getParcelFileDescriptor().detachFd()), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength()));
                        assetFileDescriptor.close();
                    }
                } catch (Exception e17) {
                    TPLogUtil.e(this.mTPContext.getLogTag(), e17, "[beforeThreadSwitch] Exception encountered: ");
                }
            }
        }
    }

    @Override // com.tencent.thumbplayer.api.dtreport.IDtReport
    public void bindVideoPlayerInfo(Object obj) {
        TPLogUtil.e(getTPConext().getLogTag(), "bindVideoPlayerInfo:" + obj);
        this.mReportParam = obj;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch
    public void deselectTrackAsync(int i3) {
        deselectTrackAsync(i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public long getAvailablePositionMs() {
        if (this.mDataTransport.getDownloadPercentage() > 0.0f) {
            return (this.mDataTransport.getDownloadPercentage() / 100.0f) * ((float) this.mRetryAdapter.getDurationMs());
        }
        if (this.mDataTransport.getAvailablePositionMs() > 0) {
            return this.mDataTransport.getAvailablePositionMs();
        }
        return this.mRetryAdapter.getAvailablePositionMs();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public long getCurrentPositionMs() {
        return this.mRetryAdapter.getCurrentPositionMs();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true)
    public int getCurrentState() throws TPTimeoutException {
        return this.mStateMgr.getCurrentState();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public long getDurationMs() {
        return this.mRetryAdapter.getDurationMs();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true)
    public int getHeight() {
        return this.mRetryAdapter.getHeight();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public int getPlayerCoreType() {
        return this.mRetryAdapter.getPlayerCoreType();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @Nullable
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true)
    public TPProgramInfo[] getProgramInfo() {
        return this.mRetryAdapter.getProgramInfo();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true)
    public String getProperty(String str) {
        return this.mRetryAdapter.getProperty(str);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @Nullable
    public ITPReportExtendedController getReportExtendedController() {
        return this.mReportController;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @Nullable
    public ITPBusinessReportManager getReportManager() {
        TPReportManager tPReportManager = this.mReportManager;
        if (tPReportManager == null) {
            return this.mReportNonImplPlugin;
        }
        return tPReportManager;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @NonNull
    public TPContext getTPConext() {
        return this.mTPContext;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @Nullable
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true)
    public TPTrackInfo[] getTrackInfo() {
        return this.mRetryAdapter.getTrackInfo();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true)
    public int getWidth() {
        return this.mRetryAdapter.getWidth();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, printBeforeSwitching = true)
    public void pause() throws IllegalStateException {
        ReportThumbPlayer.getInstance().pause(this);
        if (this.mStateMgr.isInStates(4, 5)) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "api call:pause");
            this.mRetryAdapter.pause();
            this.mStateMgr.changeToState(5);
            this.mEventForwarder.forwardPauseEvent();
            return;
        }
        TPLogUtil.e(this.mTPContext.getLogTag(), "api call:pause, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
        throw new IllegalStateException("error : pause, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch
    public void pauseDownload() throws IllegalStateException {
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:pauseDownload");
        if (!this.mStateMgr.isInStates(0, 1, 2)) {
            this.mRetryAdapter.pauseDownload();
            this.mDataTransport.pause();
            return;
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "api call:pauseDownload, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
        throw new IllegalStateException("error : pauseDownload, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, printBeforeSwitching = true)
    public void prepareAsync() throws IllegalStateException {
        boolean z16;
        long j3;
        if (this.mStateMgr.isInStates(1, 7, 8)) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "api call:prepareAsync");
            postOnDebugTrackingCallback(new TPDebugTrackingInfo(1003));
            TPReportManager tPReportManager = this.mReportManager;
            if (tPReportManager != null) {
                z16 = tPReportManager.doReportSampling();
            } else {
                z16 = true;
            }
            TPReportController tPReportController = this.mReportController;
            if (tPReportController != null) {
                tPReportController.setReportToBeaconNeeded(z16);
            }
            this.mDataTransport.resume();
            this.mRetryAdapter.prepareAsync();
            this.mStateMgr.changeToState(2);
            String str = UUID.randomUUID().toString() + System.nanoTime();
            boolean isUseDataTransportForCurrentPlayTask = this.mDataTransport.isUseDataTransportForCurrentPlayTask();
            this.mEventForwarder.forwardPrepareEvent(this.mCurrentMediaAsset, isUseDataTransportForCurrentPlayTask, str);
            TPOnInfoParam.Builder builder = new TPOnInfoParam.Builder();
            if (isUseDataTransportForCurrentPlayTask) {
                j3 = 1;
            } else {
                j3 = 0;
            }
            postOnInfoCallback(50003, builder.setLongParam(j3).build());
            return;
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "api call:prepareAsync, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
        throw new IllegalStateException("error : prepareAsync, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(printBeforeSwitching = true)
    public void release() {
        if (this.mStateMgr.isInStates(10)) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "api call:release, already in state RELEASED, do nothing");
        } else {
            TPLogUtil.i(this.mTPContext.getLogTag(), "api call:release");
            this.mRetryAdapter.release();
            this.mEventForwarder.forwardReleaseEvent();
            this.mPlayerListeners.clear();
            this.mDataTransport.release();
            this.mPluginManager.release();
            TPReportController tPReportController = this.mReportController;
            if (tPReportController != null) {
                tPReportController.release();
            }
            TPThreadPool.getInstance().recycle(this.mWorkThread, this.mCallbackHandler);
            this.mWorkThread = null;
            this.mCallbackHandler = null;
            this.mStateMgr.changeToState(10);
        }
        ReportThumbPlayer.getInstance().release(this);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true)
    public void removeTrack(int i3) throws IllegalArgumentException {
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:removeTrack, trackIndex:" + i3);
        this.mRetryAdapter.removeTrack(i3);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void reopenPlayer(int i3, boolean z16) {
        ITPPlayerRetryAdapter iTPPlayerRetryAdapter = this.mRetryAdapter;
        if (iTPPlayerRetryAdapter != null) {
            iTPPlayerRetryAdapter.reopenPlayer(i3, z16);
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, printBeforeSwitching = true)
    public void reset() {
        ReportThumbPlayer.getInstance().reset(this);
        if (this.mStateMgr.isInStates(0, 10)) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "api call:reset, already in state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()) + ", do nothing");
            return;
        }
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:reset");
        this.mRetryAdapter.reset();
        this.mEventForwarder.forwardResetEvent();
        this.mDataTransport.stop();
        this.mDataTransport.reset();
        this.mCallbackHandler.removeCallbacksAndMessages(null);
        this.mCurrentMediaAsset = null;
        this.mSwitchTaskIDToOpaqueMap.clear();
        this.mUniqueIdToOpaqueMap.clear();
        this.mUniqueIdCounter = 0L;
        this.mCurSurface = null;
        this.mCurSurfaceHolder = null;
        this.mTPContext.increasePlayID();
        this.mStateMgr.changeToState(0);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch
    public void resumeDownload() {
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:resumeDownload");
        this.mRetryAdapter.resumeDownload();
        this.mDataTransport.resume();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, printBeforeSwitching = true)
    public void seekToAsync(long j3) throws IllegalStateException {
        seekToAsync(j3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch
    public void selectProgramAsync(int i3) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:selectProgramAsync, programIndex:" + i3);
        this.mRetryAdapter.selectProgramAsync(i3);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch
    public void selectTrackAsync(int i3) {
        selectTrackAsync(i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(removeRepeated = true)
    public void setAudioMute(boolean z16) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:setAudioMute, isMute:" + z16);
        this.mRetryAdapter.setAudioMute(z16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(removeRepeated = true)
    public void setAudioNormalizeVolumeParams(String str) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:setAudioNormalizeVolumeParams, params:" + str);
        this.mRetryAdapter.setAudioNormalizeVolumeParams(str);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(removeRepeated = true)
    public void setAudioVolume(float f16) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:setAudioVolume, volume:" + f16);
        this.mRetryAdapter.setAudioVolume(f16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19) {
        ITPMediaAsset iTPMediaAsset;
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            TPLogUtil.i(getTPConext().getLogTag(), "setBusinessDownloadStrategy TPDownloadProxyNative not init");
            return;
        }
        TPDownloadProxyNative.getInstance().setBusinessDownloadStrategy(i3, i16, i17, i18, i19);
        TPLogUtil.i(getTPConext().getLogTag(), "setBusinessDownloadStrategy:" + i3 + "|" + i16 + "|" + i17 + "|" + i18 + "|" + i19);
        if (this.mDataTransport == null || (iTPMediaAsset = this.mCurrentMediaAsset) == null || !Boolean.parseBoolean(((TPMediaAsset) iTPMediaAsset).getParam(TPDownloadProxyEnum.DLPARAM_PLAYER_EMERGENCY_SAFE_TIME_EFFECT_SELF, String.valueOf(false)))) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TPDownloadProxyEnum.DLPARAM_PLAYER_SELF_EMERGENCY_TIME, i16);
            jSONObject.put(TPDownloadProxyEnum.DLPARAM_PLAYER_SELF_SAFE_TIME, i17);
            jSONObject.put(TPDownloadProxyEnum.DLPPARAM_PLAYER_SELF_EMERGENCY_TIME_FOR_PRE_PLAYER, i18);
            jSONObject.put(TPDownloadProxyEnum.DLPPARAM_PLAYER_SELF_SAFE_TIME_FOR_PRE_PLAYER, i19);
            String jSONObject2 = jSONObject.toString();
            this.mDataTransport.addOptionalParam(TPOptionalParam.buildString(TPDataTransportEnum.TASK_OPTIONAL_SlEF_EMERGENCY_SAFE_TIME, jSONObject2));
            TPLogUtil.e(getTPConext().getLogTag(), "updateSelfEmergencySafeTimes:" + jSONObject2);
        } catch (Exception e16) {
            TPLogUtil.i(getTPConext().getLogTag(), e16.toString());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, printBeforeSwitching = true)
    public void setDataSource(@NonNull ITPMediaAsset iTPMediaAsset) throws IllegalArgumentException, IllegalStateException, UnsupportedOperationException {
        if (this.mStateMgr.isInStates(0)) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "api call:setDataSource, mediaAsset=" + iTPMediaAsset);
            postOnDebugTrackingCallback(new TPDebugTrackingInfo(1000));
            this.mCurrentMediaAsset = iTPMediaAsset;
            ITPMediaAsset start = this.mDataTransport.start(iTPMediaAsset);
            if (start != null) {
                this.mEventForwarder.forwardSetDataSourceEvent(this.mCurrentMediaAsset, this.mDataTransport.isUseDataTransportForCurrentPlayTask());
                this.mRetryAdapter.setDataSource(start);
                this.mStateMgr.changeToState(1);
                postOnDebugTrackingCallback(new TPDebugTrackingInfo(1001));
                ReportThumbPlayer.getInstance().setDataSource(this, iTPMediaAsset);
                return;
            }
            TPLogUtil.e(this.mTPContext.getLogTag(), "api call:setDataSource, start transport task failed");
            postOnDebugTrackingCallback(new TPDebugTrackingInfo(1001));
            throw new UnsupportedOperationException("failed to call setDataSource");
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "api call:setDataSource, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
        throw new IllegalStateException("error : setDataSource, invalid state" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = false, printBeforeSwitching = true)
    public void setIsActive(boolean z16) {
        String valueOf;
        if (this.mDataTransport != null) {
            if (z16) {
                valueOf = String.valueOf(1);
            } else {
                valueOf = String.valueOf(0);
            }
            this.mDataTransport.addOptionalParam(TPOptionalParam.buildString(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_RUNNING_STATE, valueOf));
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(removeRepeated = true)
    public void setLogTagPrefix(String str) {
        this.mTPContext.setLogTagPrefix(str);
        this.mRetryAdapter.setLogTagPrefix(this.mTPContext.getLogTag());
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(removeRepeated = true)
    public void setLoopback(boolean z16) {
        setLoopback(z16, 0L, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnAudioFrameOutListener(ITPPlayerListener.IOnAudioFrameOutListener iOnAudioFrameOutListener) {
        this.mPlayerListeners.setOnAudioFrameOutListener(iOnAudioFrameOutListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnAudioProcessFrameOutListener(ITPPlayerListener.IOnAudioProcessFrameOutListener iOnAudioProcessFrameOutListener) {
        this.mPlayerListeners.setOnAudioProcessFrameOutListener(iOnAudioProcessFrameOutListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener iOnCompletionListener) {
        this.mPlayerListeners.setOnCompletionListener(iOnCompletionListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnDebugTrackingInfoListener(ITPPlayerListener.IOnDebugTrackingInfoListener iOnDebugTrackingInfoListener) {
        this.mPlayerListeners.setOnDebugTrackingInfoListener(iOnDebugTrackingInfoListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnErrorListener(ITPPlayerListener.IOnErrorListener iOnErrorListener) {
        this.mPlayerListeners.setOnErrorListener(iOnErrorListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnGetRemainTimeBeforePlayListener(ITPPlayerListener.IOnGetRemainTimeBeforePlayListener iOnGetRemainTimeBeforePlayListener) {
        this.mPlayerListeners.setOnGetRemainTimeBeforePlayListener(iOnGetRemainTimeBeforePlayListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnInfoListener(ITPPlayerListener.IOnInfoListener iOnInfoListener) {
        this.mPlayerListeners.setOnInfoListener(iOnInfoListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnMediaAssetExpireListener(ITPPlayerListener.IOnMediaAssetExpireListener iOnMediaAssetExpireListener) {
        this.mPlayerListeners.setOnMediaAssetExpireListener(iOnMediaAssetExpireListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener iOnPreparedListener) {
        this.mPlayerListeners.setOnPreparedListener(iOnPreparedListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener) {
        this.mPlayerListeners.setOnSeekCompleteListener(iOnSeekCompleteListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnSnapshotListener(ITPPlayerListener.IOnSnapshotListener iOnSnapshotListener) {
        this.mPlayerListeners.setOnSnapshotListener(iOnSnapshotListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnStateChangedListener(ITPPlayerListener.IOnStateChangedListener iOnStateChangedListener) {
        this.mPlayerListeners.setOnStateChangedListener(iOnStateChangedListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener) {
        this.mPlayerListeners.setOnStopAsyncCompleteListener(iOnStopAsyncCompleteListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnSubtitleDataOutListener(ITPPlayerListener.IOnSubtitleDataOutListener iOnSubtitleDataOutListener) {
        this.mPlayerListeners.setOnSubtitleDataOutListener(iOnSubtitleDataOutListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener) {
        this.mPlayerListeners.setOnVideoFrameOutListener(iOnVideoFrameOutListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener) {
        this.mPlayerListeners.setOnVideoSizeChangedListener(iOnVideoSizeChangedListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(removeRepeated = true)
    public void setPlaySpeedRatio(float f16) {
        ReportThumbPlayer.getInstance().setPlaySpeedRatio(this, f16);
        if (f16 <= 0.0f) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "api call:failed to setPlaySpeedRatio, speedRatio:" + f16);
            return;
        }
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:setPlaySpeedRatio, speedRatio:" + f16);
        this.mRetryAdapter.setPlaySpeedRatio(f16);
        this.mDataTransport.setPlaySpeedRatio(f16);
        try {
            ITPInnerRichMediaSynchronizer iTPInnerRichMediaSynchronizer = this.mRichMediaSynchronizer;
            if (iTPInnerRichMediaSynchronizer != null) {
                iTPInnerRichMediaSynchronizer.setPlaybackRate(f16);
            }
        } catch (IllegalArgumentException | IllegalStateException e16) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "api call:rich media processor setPlaybackRate:" + e16);
        }
        this.mEventForwarder.forwardSetPlaySpeedEvent(f16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch
    public void setRichMediaSynchronizer(@Nullable ITPRichMediaSynchronizer iTPRichMediaSynchronizer) {
        if (iTPRichMediaSynchronizer == null) {
            ITPInnerRichMediaSynchronizer iTPInnerRichMediaSynchronizer = this.mRichMediaSynchronizer;
            if (iTPInnerRichMediaSynchronizer != null) {
                iTPInnerRichMediaSynchronizer.setInnerListener(null);
            }
            this.mRichMediaSynchronizer = null;
            return;
        }
        if (iTPRichMediaSynchronizer instanceof ITPInnerRichMediaSynchronizer) {
            ITPInnerRichMediaSynchronizer iTPInnerRichMediaSynchronizer2 = (ITPInnerRichMediaSynchronizer) iTPRichMediaSynchronizer;
            this.mRichMediaSynchronizer = iTPInnerRichMediaSynchronizer2;
            iTPInnerRichMediaSynchronizer2.setInnerListener(new ITPInnerRichMediaSynchronizer.ITPInnerRichMediaSynchronizerListener() { // from class: com.tencent.thumbplayer.tpplayer.m
                @Override // com.tencent.thumbplayer.richmedia.ITPInnerRichMediaSynchronizer.ITPInnerRichMediaSynchronizerListener
                public final long onGetCurrentPositionMs(ITPInnerRichMediaSynchronizer iTPInnerRichMediaSynchronizer3) {
                    long lambda$setRichMediaSynchronizer$0;
                    lambda$setRichMediaSynchronizer$0 = TPPlayer.this.lambda$setRichMediaSynchronizer$0(iTPInnerRichMediaSynchronizer3);
                    return lambda$setRichMediaSynchronizer$0;
                }
            });
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = false)
    public void setSurface(Surface surface) {
        if (surface == this.mCurSurface) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "api call:setSurface, new surface is same as current one");
            return;
        }
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:setSurface, surface:" + surface);
        this.mRetryAdapter.setSurface(surface);
        this.mCurSurface = surface;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = false)
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == this.mCurSurfaceHolder) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "api call:setSurfaceHolder, new surfaceHolder is same as current one");
            return;
        }
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:setSurfaceHolder, SurfaceHolder:" + surfaceHolder);
        this.mRetryAdapter.setSurfaceHolder(surfaceHolder);
        this.mCurSurfaceHolder = surfaceHolder;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void snapshotAsync(TPSnapshotParams tPSnapshotParams) throws IllegalStateException {
        snapshotAsync(tPSnapshotParams, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, printBeforeSwitching = true)
    public void start() throws IllegalStateException {
        ReportThumbPlayer.getInstance().start(this);
        if (this.mStateMgr.isInStates(3, 4, 5, 6)) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "api call:start");
            this.mRetryAdapter.start();
            this.mStateMgr.changeToState(4);
            this.mEventForwarder.forwardStartEvent();
            return;
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "api call:start, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
        throw new IllegalStateException("error : start, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, printBeforeSwitching = true)
    public void stop() throws IllegalStateException {
        ReportThumbPlayer.getInstance().stop(this);
        if (this.mStateMgr.isInStates(2, 3, 4, 5, 7, 8, 6)) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "api call:stop");
            internalStop();
            return;
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "api call:stop, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
        throw new IllegalStateException("error : stop, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, printBeforeSwitching = true)
    public void stopAsync() throws IllegalStateException {
        ReportThumbPlayer.getInstance().stop(this);
        if (this.mStateMgr.isInStates(2, 3, 4, 5, 7, 8, 6)) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "api call:stopAsync");
            internalStop();
            postOnStopAsyncCompleteCallback();
            return;
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "api call:stopAsync, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
        throw new IllegalStateException("error : stopAsync, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAndSelectTrackAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, int[] iArr, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        if (this.mStateMgr.isInStates(3, 4, 5, 6)) {
            if (iArr != null && iArr.length > 0) {
                int length = this.mRetryAdapter.getTrackInfo().length;
                for (int i16 : iArr) {
                    if (i16 >= length || i16 < 0) {
                        throw new IllegalArgumentException("invalid select track idx:" + i16);
                    }
                }
                TPLogUtil.i(this.mTPContext.getLogTag(), "api call:switchDataSourceAndSelectTrackAsync, mode:" + i3 + ", opaque:" + j3 + ", asset:" + iTPMediaAsset + ", trackidx:" + iArr.toString());
                this.mCurrentMediaAsset = iTPMediaAsset;
                iTPMediaAsset.setParam("dl_param_play_start_time", String.valueOf(getCurrentPositionMs()));
                ITPPlayDataTransport.SwitchTaskInfo switchDataSource = this.mDataTransport.switchDataSource(iTPMediaAsset, i3, j3);
                if (switchDataSource != null) {
                    if (switchDataSource.isNeedSwitchPlayerDataSource()) {
                        this.mSwitchTaskIDToOpaqueMap.put(Integer.valueOf(switchDataSource.getTaskID()), Long.valueOf(j3));
                        this.mRetryAdapter.switchDataSourceAndSelectTrackAsync(switchDataSource.getProxyMediaAsset(), switchDataSource.getMode(), iArr, switchDataSource.getTaskID());
                        this.mEventForwarder.forwardSwitchDataSourceEvent();
                        return;
                    } else {
                        for (int i17 : iArr) {
                            selectTrackAsync(i17);
                        }
                        return;
                    }
                }
                TPLogUtil.e(this.mTPContext.getLogTag(), "api call:switchDataSourceAndSelectTrackAsync, data transport switchDataSourceAndSelectTrackAsync failed.");
                throw new UnsupportedOperationException("failed to call switchDataSourceAndSelectTrackAsync");
            }
            throw new IllegalArgumentException("select tracks idx null");
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "api call:switchDataSourceAndSelectTrackAsync, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
        throw new IllegalStateException("error : switchDataSourceAndSelectTrackAsync, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, removeRepeated = true)
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:switchDataSourceAsync");
        switchDataSourceAsync(iTPMediaAsset, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPMediaAssetRequest
    @TPThreadSwitchProxy.ThreadSwitch(removeRepeated = true)
    public void updateMediaAsset(ITPMediaAsset iTPMediaAsset) {
        if (!this.mStateMgr.isInStates(2, 3, 4, 5)) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "updateMediaAsset, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()) + ", do nothing");
            return;
        }
        this.mDataTransport.updateDataSource(iTPMediaAsset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes26.dex */
    public class EventHandler extends Handler {
        EventHandler() {
        }

        EventHandler(Looper looper) {
            super(looper);
        }
    }

    public TPPlayer(Context context, Looper looper) throws TPLoadLibraryException {
        this(context, looper, null);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch
    public void deselectTrackAsync(int i3, long j3) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:deselectTrackAsync, trackIndex:" + i3 + ", opaque:" + j3);
        this.mRetryAdapter.deselectTrackAsync(i3, assignUniqueIDForOpaque(j3));
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, printBeforeSwitching = true)
    public void seekToAsync(long j3, long j16) throws IllegalStateException {
        seekToAsync(j3, 0, j16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch
    public void selectTrackAsync(int i3, long j3) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:selectTrackAsync, trackIndex:" + i3 + ", opaque:" + j3);
        long assignUniqueIDForOpaque = assignUniqueIDForOpaque(j3);
        this.mRetryAdapter.selectTrackAsync(i3, assignUniqueIDForOpaque);
        TPTrackInfo[] trackInfo = this.mRetryAdapter.getTrackInfo();
        if (trackInfo == null || trackInfo.length <= i3 || i3 < 0) {
            return;
        }
        this.mEventForwarder.forwardSelectTrackEvent(trackInfo[i3].getName(), trackInfo[i3].getMediaType(), assignUniqueIDForOpaque);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(removeRepeated = true)
    public void setLoopback(boolean z16, long j3, long j16) {
        ReportThumbPlayer.getInstance().setLoopback(this, z16, j3, j16);
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:setLoopback, isLoopBack:" + z16 + ", loopStartPositionMs:" + j3 + ", loopEndPositionMs:" + j16);
        this.mRetryAdapter.setLoopback(z16, j3, j16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true)
    public void snapshotAsync(TPSnapshotParams tPSnapshotParams, long j3) throws IllegalStateException {
        if (this.mStateMgr.isInStates(3, 4, 5, 6)) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "api call:snapshotAsync, snapshot params:" + tPSnapshotParams);
            this.mRetryAdapter.snapshotAsync(tPSnapshotParams, j3);
            return;
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "api call:snapshotAsync, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
        throw new IllegalStateException("error : snapshotAsync, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
    }

    public TPPlayer(Context context, Looper looper, Looper looper2) throws TPLoadLibraryException {
        this(context, looper, looper2, null);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, printBeforeSwitching = true)
    public void seekToAsync(long j3, int i3) throws IllegalStateException {
        seekToAsync(j3, i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch
    public void selectProgramAsync(int i3, long j3) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:selectProgramAsync, programIndex:" + i3 + ", opaque:" + j3);
        this.mRetryAdapter.selectProgramAsync(i3, j3);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, removeRepeated = true)
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:switchDataSourceAsync, opaque:" + j3);
        switchDataSourceAsync(iTPMediaAsset, 0, j3);
    }

    public TPPlayer(Context context, Looper looper, Looper looper2, @Nullable TPPlayerConstructParams tPPlayerConstructParams) throws TPLoadLibraryException {
        this.mSwitchTaskIDToOpaqueMap = new HashMap();
        this.mUniqueIdToOpaqueMap = new HashMap();
        this.mUniqueIdCounter = 0L;
        Looper initWorkerLooper = initWorkerLooper(looper);
        this.mTPContext = new TPContext(context, initWorkerLooper);
        initCallbackHandler(initWorkerLooper, looper2);
        initPluginAndDataReport();
        this.mPlayerListeners = new TPPlayerListeners("");
        this.mInnerPlayerListener = new InnerPlayerListener();
        this.mInnerDataTransportLisenter = new InnerDataTransportListener();
        TPPlayerEventForwarder tPPlayerEventForwarder = new TPPlayerEventForwarder(this.mTPContext, this.mPluginManager);
        this.mEventForwarder = tPPlayerEventForwarder;
        tPPlayerEventForwarder.forwardCreateStartEvent();
        initPlayerRetryAdapter(tPPlayerConstructParams);
        tPPlayerEventForwarder.forwardCreateEndEvent();
        TPPlayerStateMgr tPPlayerStateMgr = (TPPlayerStateMgr) this.mTPContext.getStateQuerier();
        this.mStateMgr = tPPlayerStateMgr;
        tPPlayerStateMgr.setOnStateChangedListener(this.mInnerPlayerListener);
        TPPlayDataTransport tPPlayDataTransport = new TPPlayDataTransport(this.mTPContext);
        this.mDataTransport = tPPlayDataTransport;
        tPPlayDataTransport.setPlayDataTransportListener(this.mInnerDataTransportLisenter);
        this.mRetryAdapter.setPlayRemuxer(this.mDataTransport);
        TPLogUtil.i(this.mTPContext.getLogTag(), "create TPPlayer");
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, printBeforeSwitching = true)
    public void seekToAsync(long j3, int i3, long j16) throws IllegalStateException {
        ReportThumbPlayer.getInstance().seekToAsync(this, j3);
        if (this.mStateMgr.isInStates(3, 4, 5, 6)) {
            this.mRetryAdapter.seekToAsync(j3, i3, j16);
            this.mDataTransport.onSeek();
            if (this.mStateMgr.getCurrentState() == 6) {
                this.mStateMgr.changeToState(4);
            }
            try {
                ITPInnerRichMediaSynchronizer iTPInnerRichMediaSynchronizer = this.mRichMediaSynchronizer;
                if (iTPInnerRichMediaSynchronizer != null) {
                    iTPInnerRichMediaSynchronizer.seek(j3);
                }
            } catch (IllegalArgumentException | IllegalStateException e16) {
                TPLogUtil.w(this.mTPContext.getLogTag(), "api call:rich media processor seek:" + e16);
            }
            this.mEventForwarder.forwardSeekEvent(getCurrentPositionMs());
            return;
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "api call:seekToAsync, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
        throw new IllegalStateException("error : seekToAsync, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, removeRepeated = true)
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        TPLogUtil.i(this.mTPContext.getLogTag(), "api call:switchDataSourceAsync, mode:" + i3);
        switchDataSourceAsync(iTPMediaAsset, i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TPThreadSwitchProxy.ThreadSwitch(needWaiting = true, removeRepeated = true)
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        if (this.mStateMgr.isInStates(3, 4, 5, 6)) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "api call:switchDataSource, mode:" + i3 + ", opaque:" + j3 + ", asset:" + iTPMediaAsset);
            this.mCurrentMediaAsset = iTPMediaAsset;
            iTPMediaAsset.setParam("dl_param_play_start_time", String.valueOf(getCurrentPositionMs()));
            ITPPlayDataTransport.SwitchTaskInfo switchDataSource = this.mDataTransport.switchDataSource(iTPMediaAsset, i3, j3);
            if (switchDataSource != null) {
                if (switchDataSource.isNeedSwitchPlayerDataSource()) {
                    this.mSwitchTaskIDToOpaqueMap.put(Integer.valueOf(switchDataSource.getTaskID()), Long.valueOf(j3));
                    this.mRetryAdapter.switchDataSourceAsync(switchDataSource.getProxyMediaAsset(), switchDataSource.getMode(), switchDataSource.getTaskID());
                    this.mEventForwarder.forwardSwitchDataSourceEvent();
                    return;
                }
                return;
            }
            TPLogUtil.e(this.mTPContext.getLogTag(), "api call:switchDataSourceAsync, data transport switchDataSource failed.");
            throw new UnsupportedOperationException("failed to call switchDataSourceAsync");
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "api call:switchDataSourceAsync, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
        throw new IllegalStateException("error : switchDataSourceAsync, invalid state:" + TPPlayerStateToString.getStateName(this.mStateMgr.getCurrentState()));
    }
}
