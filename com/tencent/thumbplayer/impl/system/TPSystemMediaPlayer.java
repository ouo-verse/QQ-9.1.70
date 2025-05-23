package com.tencent.thumbplayer.impl.system;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPSubtitleRenderParams;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.ITPPlayerListener;
import com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.v2.ITPReportExtendedController;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.api.snapshot.ITPSnapshotor;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotParams;
import com.tencent.thumbplayer.asset.TPAfdMediaAsset;
import com.tencent.thumbplayer.asset.TPPfdMediaAsset;
import com.tencent.thumbplayer.asset.TPSimulatedLiveMediaAsset;
import com.tencent.thumbplayer.asset.TPUrlMediaAsset;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.TPCryptoUtil;
import com.tencent.thumbplayer.common.TPDynamicStatisticParams;
import com.tencent.thumbplayer.common.TPErrorCode;
import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.common.TPPlayerStateToString;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.common.thread.TPThreadPool;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import com.tencent.thumbplayer.datatransport.play.ITPPlayRemuxer;
import com.tencent.thumbplayer.impl.ITPInnerPlayer;
import com.tencent.thumbplayer.impl.ITPInnerPlayerListener;
import com.tencent.thumbplayer.snapshot.TPSystemSnapshotor;
import com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener;
import com.tencent.thumbplayer.subtitle.TPSubtitleParser;
import com.tencent.thumbplayer.tpplayer.TPPlayerStateMgr;
import com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase;
import com.tencent.thumbplayer.utils.timer.ITPVideoTimerListener;
import com.tencent.thumbplayer.utils.timer.TPVideoTimerManager;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes26.dex */
public class TPSystemMediaPlayer implements ITPInnerPlayer, ITPVideoTimerListener {
    private static final int RESET_TYPE_SEL_AUDIO_TRACK = 2;
    private static final int RESET_TYPE_SWITCH_URL = 1;
    private static final String TAG = "TPSystemMediaPlayer";
    private static final int TP_SYSTEM_PLAYER_INNER_RESTORE_STATE_ERR = -10004;
    private static final int TP_SYSTEM_PLAYER_INNER_SEL_TRACK_EXCEPTION = -10000;
    private static final int TP_SYSTEM_PLAYER_INNER_SEL_TRACK_NOT_SUPPORT = -10001;
    private static final int TP_SYSTEM_PLAYER_INNER_TRACK_INDEX_ERR = -10002;
    private static final int TP_SYSTEM_PLAYER_INNER_TRACK_TYPE_NOT_SUPPORT = -10003;
    private static final int TP_SYSTEM_PLAYER_TOKEN_FLAG = 1;
    private static final int mIntervalCheckBufferingMs = 400;
    private final List<ExternalTrackInfo> mAudioTrackInfo;
    private BufferCheck mBufferCheck;
    private final InnerPlayerListener mInnerPlayerListener;
    private ResetActionInfo mLastAction;
    private volatile MediaPlayer mMediaPlayer;
    private final TPPlayerStateMgr mMediaPlayerState;
    private ITPPlayerListener.IOnCompletionListener mOnCompletionListener;
    private ITPPlayerListener.IOnErrorListener mOnErrorListener;
    private ITPPlayerListener.IOnInfoListener mOnInfoListener;
    private ITPPlayerListener.IOnSnapshotListener mOnPlayerSnapshotListener;
    private ITPPlayerListener.IOnPreparedListener mOnPreparedListener;
    private ITPPlayerListener.IOnSeekCompleteListener mOnSeekCompleteListener;
    private ITPPlayerListener.IOnSubtitleDataOutListener mOnSubtitleDataOutListener;
    private ITPPlayerListener.IOnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private final ITPSnapshotor.ITPSnapshotorListener mSnapshotorListener;
    private final TPPlayerStateMgr mState;
    private int mSubtitleDataType;
    private TPSubtitleParser mSubtitleParser;
    private final ITPSubtitleParserListener mSubtitleParserListener;
    private Object mSurfaceObj;
    TPSystemSnapshotor mSystemSnapshotor;
    private final TPContext mTPContext;
    private boolean mIsLoopback = false;
    private long mLoopStartPositionMs = 0;
    private long mLoopEndPositionMs = -1;
    private ITPMediaAsset mMediaAsset = null;
    private ITPMediaAsset mRemuxingMediaAsset = null;
    private boolean mIsAudioMute = false;
    private float mAudioVolume = 1.0f;
    private float mPlaySpeed = 1.0f;
    private long mSeekOpaque = 0;
    private long mStartPositionMs = 0;
    private long mSkipEndPositionMs = -1;
    private boolean mIsLive = false;
    private long mConfiguredDurationMs = -1;
    private int mConfiguredVideoHeight = 0;
    private int mConfiguredVideoWidth = 0;
    private boolean mForceUseConfiguredVideoWidthHeight = false;
    private AudioAttributes mAudioAttributes = null;
    private boolean mEnablePreferredAudioDeviceInfo = false;
    private AudioDeviceInfo mPreferredAudioDeviceInfo = null;
    private String mPreferredStartAudioTrackName = "";
    private boolean mIsAllowCheckBuffingByPosition = true;
    private final Map<Integer, Long> mSnapshotTaskIdToOpaque = new ConcurrentHashMap();
    private Future<?> mCheckPrepareTimeoutTask = null;
    private final Object mCheckPrepareTimeoutLock = new Object();
    private long mIntervalCheckPreparingTimeOutMs = s.G;
    private final Object mCheckBuffingTimerLock = new Object();
    private int mCheckBufferFrequent = 3;
    private int mCheckBufferTimerOutFrequent = 30;
    private final Object mCheckBufferTimerOutByInfoLock = new Object();
    private Future<?> mCheckBufferTimeOutBySystemInfoTimer = null;
    private boolean mIsSeekable = true;
    private boolean mIsSuspend = false;
    private long mBaseDurationMs = 0;
    private long mLastCheckPositionMs = -1;
    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    private volatile boolean mIsBuffering = false;
    private volatile long mLastValidPositionMs = -1;
    private int mCheckBufferPosNoChangeCount = 0;
    private int mSelectSubtitleIndex = -1;
    private int mCurAudioTrackIndex = 0;
    private int mCurInnerAudioTrackIndex = -1;
    private ITPPlayRemuxer mRemuxer = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class BufferCheck {
        boolean mCheckAbort;
        Future<?> mCheckBuffingTimer;

        BufferCheck() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class ExternalTrackInfo {
        public ITPMediaAsset asset;
        public TPTrackInfo trackInfo;

        ExternalTrackInfo() {
        }
    }

    /* loaded from: classes26.dex */
    private static class HookCallback implements Handler.Callback {
        private final Handler impl;

        HookCallback(Handler handler) {
            this.impl = handler;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                this.impl.handleMessage(message);
                return true;
            } catch (Exception e16) {
                TPLogUtil.e(TPSystemMediaPlayer.TAG, "mediaPlayerExceptionHook, HookCallback, " + Log.getStackTraceString(e16));
                return true;
            }
        }
    }

    /* loaded from: classes26.dex */
    private class InnerSubtitleParserListener implements ITPSubtitleParserListener {
        InnerSubtitleParserListener() {
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onDeselectError(TPError tPError, long j3) {
            ITPPlayerListener.IOnInfoListener iOnInfoListener = TPSystemMediaPlayer.this.mOnInfoListener;
            if (iOnInfoListener != null) {
                iOnInfoListener.onInfo(TPSystemMediaPlayer.this, 13, new TPOnInfoParam.Builder().setLongParam(j3).setObjParam(tPError).build());
            }
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onDeselectSuccess(long j3) {
            ITPPlayerListener.IOnInfoListener iOnInfoListener = TPSystemMediaPlayer.this.mOnInfoListener;
            if (iOnInfoListener != null) {
                iOnInfoListener.onInfo(TPSystemMediaPlayer.this, 12, new TPOnInfoParam.Builder().setLongParam(j3).build());
            }
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public long onGetCurrentPlayPositionMs() {
            if (!TPSystemMediaPlayer.this.mState.isInStates(5, 4)) {
                return -1L;
            }
            return TPSystemMediaPlayer.this.getCurrentPositionMs();
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onSelectError(TPError tPError, long j3) {
            ITPPlayerListener.IOnInfoListener iOnInfoListener = TPSystemMediaPlayer.this.mOnInfoListener;
            if (iOnInfoListener != null) {
                iOnInfoListener.onInfo(TPSystemMediaPlayer.this, 11, new TPOnInfoParam.Builder().setLongParam(j3).setObjParam(tPError).build());
            }
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onSelectSuccess(long j3) {
            ITPPlayerListener.IOnInfoListener iOnInfoListener = TPSystemMediaPlayer.this.mOnInfoListener;
            if (iOnInfoListener != null) {
                iOnInfoListener.onInfo(TPSystemMediaPlayer.this, 10, new TPOnInfoParam.Builder().setLongParam(j3).build());
            }
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onSubtitleData(TPSubtitleData tPSubtitleData) {
            ITPPlayerListener.IOnSubtitleDataOutListener iOnSubtitleDataOutListener = TPSystemMediaPlayer.this.mOnSubtitleDataOutListener;
            if (iOnSubtitleDataOutListener != null) {
                iOnSubtitleDataOutListener.onSubtitleDataOut(TPSystemMediaPlayer.this, tPSubtitleData);
            }
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onSubtitleError(int i3, TPError tPError) {
            ITPPlayerListener.IOnInfoListener iOnInfoListener = TPSystemMediaPlayer.this.mOnInfoListener;
            if (iOnInfoListener != null) {
                iOnInfoListener.onInfo(TPSystemMediaPlayer.this, 254, new TPOnInfoParam.Builder().setLongParam(TPSystemMediaPlayer.this.mAudioTrackInfo.size() + i3).setObjParam(tPError).build());
            }
        }

        @Override // com.tencent.thumbplayer.subtitle.ITPSubtitleParserListener
        public void onSubtitleNote(int i3, String str) {
            TPLogUtil.d(TPSystemMediaPlayer.this.mTPContext.getLogTag(), "onSubtitleNote, " + str);
            ITPPlayerListener.IOnInfoListener iOnInfoListener = TPSystemMediaPlayer.this.mOnInfoListener;
            if (iOnInfoListener != null) {
                iOnInfoListener.onInfo(TPSystemMediaPlayer.this, 506, new TPOnInfoParam.Builder().setLongParam(TPSystemMediaPlayer.this.mAudioTrackInfo.size() + i3).setStrParam(str).build());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class ResetActionInfo {
        int externalAudioTrackIndex;
        int innerAudioTrackIndex;
        int innerSubtitleTrackIndex;
        long opaque;
        long positionMs;
        int resetType;
        int state;

        ResetActionInfo() {
        }
    }

    public TPSystemMediaPlayer(TPContext tPContext) {
        ArrayList arrayList = new ArrayList();
        this.mAudioTrackInfo = arrayList;
        this.mSubtitleDataType = 0;
        this.mLastAction = null;
        this.mTPContext = tPContext;
        this.mState = new TPPlayerStateMgr(tPContext);
        this.mMediaPlayerState = new TPPlayerStateMgr(tPContext);
        this.mInnerPlayerListener = new InnerPlayerListener();
        this.mSubtitleParserListener = new InnerSubtitleParserListener();
        ExternalTrackInfo externalTrackInfo = new ExternalTrackInfo();
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        externalTrackInfo.trackInfo = tPTrackInfo;
        tPTrackInfo.setSelected(true);
        externalTrackInfo.trackInfo.setName("audio_1");
        arrayList.add(externalTrackInfo);
        initMediaPlayer();
        createSubtitleParser();
        this.mSnapshotorListener = new ITPSnapshotor.ITPSnapshotorListener() { // from class: com.tencent.thumbplayer.impl.system.TPSystemMediaPlayer.1
            @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor.ITPSnapshotorListener
            public void onError(int i3, long j3, @NonNull TPError tPError) {
                Long l3;
                ITPPlayerListener.IOnSnapshotListener iOnSnapshotListener = TPSystemMediaPlayer.this.mOnPlayerSnapshotListener;
                if (iOnSnapshotListener == null || (l3 = (Long) TPSystemMediaPlayer.this.mSnapshotTaskIdToOpaque.remove(Integer.valueOf(i3))) == null) {
                    return;
                }
                iOnSnapshotListener.onSnapshotFailed(TPSystemMediaPlayer.this, l3.longValue(), tPError);
            }

            @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor.ITPSnapshotorListener
            public void onSuccess(int i3, long j3, long j16, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer) {
                Long l3;
                ITPPlayerListener.IOnSnapshotListener iOnSnapshotListener = TPSystemMediaPlayer.this.mOnPlayerSnapshotListener;
                if (iOnSnapshotListener == null || (l3 = (Long) TPSystemMediaPlayer.this.mSnapshotTaskIdToOpaque.remove(Integer.valueOf(i3))) == null) {
                    return;
                }
                iOnSnapshotListener.onSnapshotSuccess(TPSystemMediaPlayer.this, l3.longValue(), j16, tPVideoFrameBuffer);
            }
        };
        TPLogUtil.i(tPContext.getLogTag(), "TPSystemMediaPlayer construct");
    }

    private void addOptionalParamToSubtitleParser(@NonNull TPOptionalParam<?> tPOptionalParam) {
        TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
        if (tPSubtitleParser == null) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "AddOptionalParamToSubtitleParser failed, mSubtitleParser is null");
            return;
        }
        try {
            tPSubtitleParser.addOptionalParam(tPOptionalParam);
        } catch (TPLoadLibraryException e16) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "subtitle parser addOptionalParam failed, exception:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeVideoWidthHeight(int i3, int i16) {
        if (i3 <= 0 || i16 <= 0 || this.mForceUseConfiguredVideoWidthHeight) {
            i3 = this.mConfiguredVideoWidth;
            i16 = this.mConfiguredVideoHeight;
            TPLogUtil.i(this.mTPContext.getLogTag(), "width:" + i3 + " height:" + i16 + " forceUse:" + this.mForceUseConfiguredVideoWidthHeight + ", force use configured width and height!");
        }
        if (i3 > 0 && i16 > 0) {
            if (this.mVideoWidth != i3 || this.mVideoHeight != i16) {
                TPLogUtil.i(this.mTPContext.getLogTag(), "video size changed: (" + this.mVideoWidth + HippyTKDListViewAdapter.X + this.mVideoHeight + ")=>(" + i3 + HippyTKDListViewAdapter.X + i16 + ")");
                this.mVideoWidth = i3;
                this.mVideoHeight = i16;
                ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
                if (iOnVideoSizeChangedListener != null) {
                    iOnVideoSizeChangedListener.onVideoSizeChanged(this, i3, i16);
                    return;
                }
                return;
            }
            return;
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "width or height <= 0");
    }

    private void checkBuffingEvent() {
        long currentPositionMs = getCurrentPositionMs();
        long j3 = this.mLastCheckPositionMs;
        this.mLastCheckPositionMs = currentPositionMs;
        if (!this.mState.isInStates(4)) {
            if (this.mState.isInStates(5) && this.mIsBuffering) {
                TPLogUtil.i(this.mTPContext.getLogTag(), "checkBuffingEvent, pause state and send end buffering");
                this.mIsBuffering = false;
                this.mCheckBufferPosNoChangeCount = 0;
                ITPPlayerListener.IOnInfoListener iOnInfoListener = this.mOnInfoListener;
                if (iOnInfoListener != null) {
                    iOnInfoListener.onInfo(this, 201, null);
                    return;
                }
                return;
            }
            return;
        }
        if (this.mIsLoopback) {
            long j16 = this.mLoopEndPositionMs;
            if (j16 > 0 && currentPositionMs >= j16 && this.mIsSeekable) {
                TPLogUtil.i(this.mTPContext.getLogTag(), "checkBuffingEvent, loopback skip end, curPositionMs:" + currentPositionMs + ", loopStartPositionMs:" + this.mLoopStartPositionMs);
                this.mMediaPlayer.seekTo((int) this.mLoopStartPositionMs);
            }
        } else if (this.mSkipEndPositionMs > 0 && currentPositionMs >= getDurationMs() - this.mSkipEndPositionMs) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "checkBuffingEvent, skip end, baseDurationMs: " + this.mBaseDurationMs + ", curPositionMs:" + currentPositionMs + ", skipEndPositionMs:" + this.mSkipEndPositionMs);
            this.mState.changeToState(6);
            mediaPlayerStopAndReset();
            destroyCheckBuffingTimer();
            ITPPlayerListener.IOnCompletionListener iOnCompletionListener = this.mOnCompletionListener;
            if (iOnCompletionListener != null) {
                iOnCompletionListener.onCompletion(this);
                return;
            }
            return;
        }
        if (currentPositionMs == j3 && currentPositionMs > 0) {
            int i3 = this.mCheckBufferPosNoChangeCount + 1;
            this.mCheckBufferPosNoChangeCount = i3;
            if (i3 >= this.mCheckBufferFrequent && !this.mIsBuffering) {
                this.mIsBuffering = true;
                TPLogUtil.i(this.mTPContext.getLogTag(), "checkBuffingEvent, position no change, send start buffering");
                ITPPlayerListener.IOnInfoListener iOnInfoListener2 = this.mOnInfoListener;
                if (iOnInfoListener2 != null) {
                    iOnInfoListener2.onInfo(this, 200, null);
                }
            }
            if (this.mCheckBufferPosNoChangeCount >= this.mCheckBufferTimerOutFrequent) {
                TPLogUtil.e(this.mTPContext.getLogTag(), "checkBuffingEvent post error");
                this.mState.changeToState(9);
                mediaPlayerStopAndReset();
                this.mIsBuffering = false;
                destroyCheckBuffingTimer();
                ITPPlayerListener.IOnErrorListener iOnErrorListener = this.mOnErrorListener;
                if (iOnErrorListener != null) {
                    iOnErrorListener.onError(this, new TPError(2001, formatErrorCode(-110), getCurrentPositionMs()));
                    return;
                }
                return;
            }
            return;
        }
        if (this.mIsBuffering) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "checkBuffingEvent, position change, send end buffering");
            ITPPlayerListener.IOnInfoListener iOnInfoListener3 = this.mOnInfoListener;
            if (iOnInfoListener3 != null) {
                iOnInfoListener3.onInfo(this, 201, null);
            }
        }
        this.mIsBuffering = false;
        this.mCheckBufferPosNoChangeCount = 0;
    }

    private TPSystemSnapshotor createAndInitSystemSnapshotor() {
        String str;
        ITPMediaAsset iTPMediaAsset = this.mMediaAsset;
        if (iTPMediaAsset != null && iTPMediaAsset.isValid()) {
            TPSystemSnapshotor tPSystemSnapshotor = new TPSystemSnapshotor();
            try {
                tPSystemSnapshotor.init(this.mMediaAsset, this.mSnapshotorListener);
                return tPSystemSnapshotor;
            } catch (Exception e16) {
                TPLogUtil.e(this.mTPContext.getLogTag(), "init image generator failed, exception:" + e16);
                return null;
            }
        }
        String logTag = this.mTPContext.getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("init image generator failed, mediaAsset is ");
        if (this.mMediaAsset == null) {
            str = "null";
        } else {
            str = HippyReporter.RemoveEngineReason.INVALID;
        }
        sb5.append(str);
        TPLogUtil.e(logTag, sb5.toString());
        return null;
    }

    private void createSubtitleParser() {
        try {
            this.mSubtitleParser = new TPSubtitleParser();
            TPLogUtil.i(this.mTPContext.getLogTag(), "create subtitle parser success, subtitle data type:" + this.mSubtitleDataType);
        } catch (TPLoadLibraryException e16) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "create subtitle parser failed:" + e16);
        } catch (UnsupportedOperationException e17) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "create subtitle parser failed:" + e17);
        }
    }

    private void deselectSubtitleTrack(int i3, long j3) {
        TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
        if (tPSubtitleParser == null) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "deselectSubtitleTrack failed, mSubtitleParser is null");
            return;
        }
        try {
            tPSubtitleParser.deselectTrackAsync(i3, j3);
            TPLogUtil.i(this.mTPContext.getLogTag(), "deselectSubTrack, trackIndex:" + i3 + ", opaque:" + j3);
        } catch (TPLoadLibraryException | UnsupportedOperationException e16) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "deselectSubTrack failed, exception:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void destroyCheckBufferTimeOutByInfo() {
        synchronized (this.mCheckBufferTimerOutByInfoLock) {
            Future<?> future = this.mCheckBufferTimeOutBySystemInfoTimer;
            if (future != null) {
                future.cancel(true);
                this.mCheckBufferTimeOutBySystemInfoTimer = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void destroyCheckBuffingTimer() {
        synchronized (this.mCheckBuffingTimerLock) {
            BufferCheck bufferCheck = this.mBufferCheck;
            if (bufferCheck != null) {
                bufferCheck.mCheckAbort = true;
                Future<?> future = bufferCheck.mCheckBuffingTimer;
                if (future != null) {
                    future.cancel(true);
                }
                this.mBufferCheck.mCheckBuffingTimer = null;
                this.mBufferCheck = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void destroyCheckPrepareTimeoutTimer() {
        synchronized (this.mCheckPrepareTimeoutLock) {
            Future<?> future = this.mCheckPrepareTimeoutTask;
            if (future != null) {
                future.cancel(true);
                this.mCheckPrepareTimeoutTask = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int formatErrorCode(int i3) {
        long j3;
        if (i3 < 0) {
            j3 = 10000000 - i3;
        } else {
            j3 = 10000000 + i3;
        }
        if (j3 >= TTL.MAX_VALUE) {
            j3 = 2147483647L;
        }
        return (int) j3;
    }

    @NonNull
    private TPTrackInfo[] getSubtitleTrackInfo() {
        TPTrackInfo[] tPTrackInfoArr;
        TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
        if (tPSubtitleParser == null) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "getSubtitleTrackInfo failed, mSubtitleParser is null");
            return new TPTrackInfo[0];
        }
        try {
            tPTrackInfoArr = tPSubtitleParser.getTrackInfo();
        } catch (TPLoadLibraryException e16) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "get subtitle trackInfo failed, exception:" + e16);
            tPTrackInfoArr = null;
        }
        if (tPTrackInfoArr == null) {
            return new TPTrackInfo[0];
        }
        return tPTrackInfoArr;
    }

    private void handlePreferredStartTrack() {
        if (TextUtils.isEmpty(this.mPreferredStartAudioTrackName)) {
            return;
        }
        for (int i3 = 0; i3 < this.mAudioTrackInfo.size(); i3++) {
            ExternalTrackInfo externalTrackInfo = this.mAudioTrackInfo.get(i3);
            if (this.mPreferredStartAudioTrackName.equals(externalTrackInfo.trackInfo.getName())) {
                if (externalTrackInfo.trackInfo.isInternal()) {
                    return;
                }
                if (this.mRemuxer == null) {
                    ITPPlayerListener.IOnErrorListener iOnErrorListener = this.mOnErrorListener;
                    if (iOnErrorListener != null) {
                        iOnErrorListener.onError(this, new TPError(2000, TPErrorCode.TP_ERROR_CODE_GENERAL_FAILED));
                        return;
                    }
                    return;
                }
                TPLogUtil.i(this.mTPContext.getLogTag(), "start with track:" + externalTrackInfo.trackInfo.getName());
                this.mRemuxingMediaAsset = this.mRemuxer.startRemuxing(this.mMediaAsset, externalTrackInfo.asset);
                this.mAudioTrackInfo.get(this.mCurAudioTrackIndex).trackInfo.setSelected(false);
                this.mAudioTrackInfo.get(i3).trackInfo.setSelected(true);
                this.mCurAudioTrackIndex = i3;
            }
        }
    }

    private void initMediaPlayer() {
        this.mMediaPlayer = mediaPlayerCreate();
        this.mState.changeToState(0);
        this.mMediaPlayerState.changeToState(0);
    }

    private void initSubtitleParser() {
        TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
        if (tPSubtitleParser == null) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "init subtitle parser failed, subtitle parser is null");
            return;
        }
        try {
            tPSubtitleParser.init(this.mSubtitleDataType, this.mSubtitleParserListener);
            TPLogUtil.i(this.mTPContext.getLogTag(), "init subtitle parser success, subtitle data type:" + this.mSubtitleDataType);
        } catch (TPLoadLibraryException e16) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "init subtitle parser failed:" + e16);
        } catch (IllegalArgumentException e17) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "init subtitle parser failed:" + e17);
        } catch (UnsupportedOperationException e18) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "init subtitle parser failed:" + e18);
        }
    }

    private void innerPrepareAsync() throws IllegalStateException {
        setInitParamsBeforePrepare();
        registerPlayerListener(this.mMediaPlayer, this.mInnerPlayerListener);
        TPLogUtil.i(this.mTPContext.getLogTag(), "prepareAsync");
        this.mState.changeToState(2);
        this.mMediaPlayerState.changeToState(2);
        try {
            this.mMediaPlayer.prepareAsync();
        } catch (IllegalStateException e16) {
            throw e16;
        } catch (Exception e17) {
            TPLogUtil.e(this.mTPContext.getLogTag(), e17.getMessage());
            ITPPlayerListener.IOnErrorListener iOnErrorListener = this.mOnErrorListener;
            if (iOnErrorListener != null) {
                iOnErrorListener.onError(this, new TPError(2000, formatErrorCode(-1004), getCurrentPositionMs()));
            }
        }
        startCheckPrepareTimeoutTimer();
    }

    private void innerSetDataSource() throws IllegalArgumentException {
        ITPMediaAsset iTPMediaAsset = this.mRemuxingMediaAsset;
        if (iTPMediaAsset == null) {
            iTPMediaAsset = this.mMediaAsset;
        }
        int assetType = iTPMediaAsset.getAssetType();
        if (assetType == 1) {
            innerSetDataSource((TPAfdMediaAsset) iTPMediaAsset);
        } else if (assetType == 2) {
            innerSetDataSource((TPPfdMediaAsset) iTPMediaAsset);
        } else if (assetType == 3) {
            innerSetDataSource((TPUrlMediaAsset) iTPMediaAsset);
        } else if (assetType == 8) {
            innerSetDataSource((TPUrlMediaAsset) ((TPSimulatedLiveMediaAsset) iTPMediaAsset).getStartAsset());
        } else {
            TPLogUtil.i(this.mTPContext.getLogTag(), "Unsupported mediaAsset:" + iTPMediaAsset);
            throw new IllegalArgumentException("setDataSource, unsupported mediaAsset:" + iTPMediaAsset);
        }
        this.mMediaPlayerState.changeToState(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAllowCheckBufferByPosition() {
        if (this.mIsLive) {
            return false;
        }
        return this.mIsAllowCheckBuffingByPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCheckBufferTimeOutByInfo$2() {
        if (!this.mState.isInStates(5) && this.mIsBuffering) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "startCheckBufferTimeOutByInfo, buffer last too long");
            this.mState.changeToState(9);
            mediaPlayerStopAndReset();
            this.mIsBuffering = false;
            destroyCheckBufferTimeOutByInfo();
            ITPPlayerListener.IOnErrorListener iOnErrorListener = this.mOnErrorListener;
            if (iOnErrorListener != null) {
                iOnErrorListener.onError(this, new TPError(2001, formatErrorCode(-110), getCurrentPositionMs()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCheckBufferingTimer$1(BufferCheck bufferCheck) {
        while (!bufferCheck.mCheckAbort) {
            checkBuffingEvent();
            try {
                LockMethodProxy.sleep(400L);
            } catch (InterruptedException e16) {
                TPLogUtil.e(this.mTPContext.getLogTag(), e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCheckPrepareTimeoutTimer$0() {
        if (this.mState.isInStates(2)) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "startCheckPrepareTimeoutTimer, post error");
            this.mState.changeToState(9);
            mediaPlayerStopAndReset();
            destroyCheckPrepareTimeoutTimer();
            ITPPlayerListener.IOnErrorListener iOnErrorListener = this.mOnErrorListener;
            if (iOnErrorListener != null) {
                iOnErrorListener.onError(this, new TPError(2001, formatErrorCode(-110), getCurrentPositionMs()));
            }
        }
    }

    private MediaPlayer mediaPlayerCreate() {
        return TPAndroidMediaPlayerFactory.createPlayer(this.mTPContext);
    }

    private void mediaPlayerExceptionHook(MediaPlayer mediaPlayer) {
        try {
            Field declaredField = MediaPlayer.class.getDeclaredField("mEventHandler");
            declaredField.setAccessible(true);
            Handler handler = (Handler) declaredField.get(mediaPlayer);
            Field declaredField2 = Handler.class.getDeclaredField("mCallback");
            declaredField2.setAccessible(true);
            if (((Handler.Callback) declaredField2.get(handler)) == null) {
                declaredField2.set(handler, new HookCallback(handler));
            }
        } catch (Exception e16) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "mediaPlayerExceptionHook, " + Log.getStackTraceString(e16));
        }
    }

    private void mediaPlayerRelease() {
        if (!this.mMediaPlayerState.isInStates(10)) {
            this.mMediaPlayerState.changeToState(10);
            TPLogUtil.i(this.mTPContext.getLogTag(), "androidMediaPlayer release.");
            this.mMediaPlayer.release();
        }
    }

    private void mediaPlayerReset() {
        destroyCheckPrepareTimeoutTimer();
        destroyCheckBuffingTimer();
        destroyCheckBufferTimeOutByInfo();
        mediaPlayerStopAndRelease();
        this.mMediaPlayer = mediaPlayerCreate();
        if (this.mIsAudioMute) {
            this.mMediaPlayer.setVolume(0.0f, 0.0f);
        } else if (this.mAudioVolume != 1.0f) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            float f16 = this.mAudioVolume;
            mediaPlayer.setVolume(f16, f16);
        }
        float f17 = this.mPlaySpeed;
        if (f17 != 1.0d) {
            setPlaySpeedRatio(f17);
        }
        if (this.mIsLoopback) {
            this.mMediaPlayer.setLooping(this.mIsLoopback);
        }
    }

    private void mediaPlayerStop() {
        if (this.mMediaPlayerState.isInStates(3, 4, 5)) {
            this.mMediaPlayerState.changeToState(8);
            TPLogUtil.i(this.mTPContext.getLogTag(), "androidMediaPlayer stop.");
            this.mMediaPlayer.stop();
        }
    }

    private void mediaPlayerStopAndRelease() {
        unRegisterPlayerListener(this.mMediaPlayer);
        mediaPlayerStop();
        mediaPlayerRelease();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mediaPlayerStopAndReset() {
        unRegisterPlayerListener(this.mMediaPlayer);
        mediaPlayerStop();
        this.mMediaPlayerState.changeToState(0);
        this.mMediaPlayer.reset();
        TPLogUtil.i(this.mTPContext.getLogTag(), "androidMediaPlayer reset.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void playerResetEnd() {
        int i3;
        ResetActionInfo resetActionInfo = this.mLastAction;
        TPLogUtil.i(this.mTPContext.getLogTag(), "playerResetEnd, actionInfo:" + resetActionInfo + ", isSuspend:" + this.mIsSuspend);
        if (resetActionInfo != null && this.mIsSuspend) {
            ITPPlayerListener.IOnInfoListener iOnInfoListener = this.mOnInfoListener;
            if (resetActionInfo.resetType == 1) {
                i3 = 3;
            } else {
                i3 = 10;
            }
            if (iOnInfoListener != null) {
                iOnInfoListener.onInfo(this, i3, new TPOnInfoParam.Builder().setLongParam(resetActionInfo.opaque).build());
            }
            if (resetActionInfo.innerAudioTrackIndex > 0) {
                this.mMediaPlayer.selectTrack(resetActionInfo.innerAudioTrackIndex);
            }
            if (resetActionInfo.innerSubtitleTrackIndex > 0) {
                this.mMediaPlayer.selectTrack(resetActionInfo.innerSubtitleTrackIndex);
            }
            if (resetActionInfo.positionMs > 0 && this.mIsSeekable) {
                TPLogUtil.i(this.mTPContext.getLogTag(), "playerResetEnd, onPrepared and seek to:" + resetActionInfo.positionMs);
                try {
                    this.mMediaPlayer.seekTo((int) resetActionInfo.positionMs);
                } catch (Exception e16) {
                    TPLogUtil.e(this.mTPContext.getLogTag(), e16);
                }
            }
            TPLogUtil.i(this.mTPContext.getLogTag(), "playerResetEnd, restore state:" + resetActionInfo.state);
            int i16 = resetActionInfo.state;
            if (i16 != 0 && i16 != 1 && i16 != 2) {
                if (i16 != 3 && i16 != 5) {
                    if (i16 == 4) {
                        TPLogUtil.i(this.mTPContext.getLogTag(), "playerResetEnd, androidMediaPlayer start.");
                        this.mMediaPlayer.start();
                        this.mState.changeToState(resetActionInfo.state);
                        this.mMediaPlayerState.changeToState(4);
                        startCheckBufferingTimer();
                    } else {
                        TPLogUtil.e(this.mTPContext.getLogTag(), "illegal state, state:" + resetActionInfo.state);
                        this.mState.changeToState(9);
                        mediaPlayerStopAndReset();
                        ITPPlayerListener.IOnErrorListener iOnErrorListener = this.mOnErrorListener;
                        if (iOnErrorListener != null) {
                            iOnErrorListener.onError(this, new TPError(2000, formatErrorCode(-10004), getCurrentPositionMs()));
                        }
                    }
                    this.mIsSuspend = false;
                    this.mLastAction = null;
                    return;
                }
                this.mState.changeToState(i16);
                this.mIsSuspend = false;
                this.mLastAction = null;
                return;
            }
            this.mState.changeToState(3);
            changeVideoWidthHeight(this.mMediaPlayer.getVideoWidth(), this.mMediaPlayer.getVideoHeight());
            ITPPlayerListener.IOnPreparedListener iOnPreparedListener = this.mOnPreparedListener;
            if (iOnPreparedListener != null) {
                iOnPreparedListener.onPrepared(this);
            }
            this.mIsSuspend = false;
            this.mLastAction = null;
            return;
        }
        if (this.mStartPositionMs > 0 && this.mIsSeekable) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "onPrepared, and seek to:" + this.mStartPositionMs);
            try {
                this.mMediaPlayer.seekTo((int) this.mStartPositionMs);
            } catch (Exception e17) {
                TPLogUtil.e(this.mTPContext.getLogTag(), e17);
            }
        }
        this.mState.changeToState(3);
        changeVideoWidthHeight(this.mMediaPlayer.getVideoWidth(), this.mMediaPlayer.getVideoHeight());
        ITPPlayerListener.IOnPreparedListener iOnPreparedListener2 = this.mOnPreparedListener;
        if (iOnPreparedListener2 != null) {
            iOnPreparedListener2.onPrepared(this);
        }
        return;
    }

    private synchronized void playerResetStart(ResetActionInfo resetActionInfo) throws IOException, IllegalArgumentException, IllegalStateException {
        int i3;
        int i16;
        resetActionInfo.positionMs = getCurrentPositionMs();
        resetActionInfo.state = this.mState.getCurrentState();
        resetActionInfo.innerAudioTrackIndex = this.mCurInnerAudioTrackIndex;
        resetActionInfo.innerSubtitleTrackIndex = this.mSelectSubtitleIndex;
        TPLogUtil.i(this.mTPContext.getLogTag(), "playerResetStart, positionMs:" + resetActionInfo.positionMs + ", state:" + resetActionInfo.state);
        this.mIsSuspend = true;
        mediaPlayerReset();
        this.mMediaPlayerState.changeToState(0);
        innerSetDataSource();
        this.mMediaPlayerState.changeToState(1);
        Object obj = this.mSurfaceObj;
        if (obj == null) {
            this.mMediaPlayer.setDisplay(null);
        } else if (obj instanceof SurfaceHolder) {
            this.mMediaPlayer.setDisplay((SurfaceHolder) this.mSurfaceObj);
        } else if (obj instanceof Surface) {
            this.mMediaPlayer.setSurface((Surface) this.mSurfaceObj);
        }
        ResetActionInfo resetActionInfo2 = this.mLastAction;
        if (resetActionInfo2 != null && (i3 = resetActionInfo2.resetType) != resetActionInfo.resetType) {
            ITPPlayerListener.IOnInfoListener iOnInfoListener = this.mOnInfoListener;
            if (i3 == 1) {
                i16 = 3;
            } else {
                i16 = 10;
            }
            if (iOnInfoListener != null) {
                iOnInfoListener.onInfo(this, i16, new TPOnInfoParam.Builder().setLongParam(resetActionInfo2.opaque).build());
            }
            resetActionInfo.state = resetActionInfo2.state;
            resetActionInfo.positionMs = resetActionInfo2.positionMs;
        }
        this.mLastAction = resetActionInfo;
        int i17 = resetActionInfo.state;
        if (i17 == 2 || i17 == 3 || i17 == 4 || i17 == 5) {
            innerPrepareAsync();
        }
    }

    private void registerPlayerListener(MediaPlayer mediaPlayer, InnerPlayerListener innerPlayerListener) {
        mediaPlayer.setOnPreparedListener(innerPlayerListener);
        mediaPlayer.setOnCompletionListener(innerPlayerListener);
        mediaPlayer.setOnErrorListener(innerPlayerListener);
        mediaPlayer.setOnInfoListener(innerPlayerListener);
        mediaPlayer.setOnBufferingUpdateListener(innerPlayerListener);
        mediaPlayer.setOnSeekCompleteListener(innerPlayerListener);
        mediaPlayer.setOnVideoSizeChangedListener(innerPlayerListener);
    }

    private void releaseSnapShotorIfNeeded() {
        TPSystemSnapshotor tPSystemSnapshotor = this.mSystemSnapshotor;
        if (tPSystemSnapshotor == null) {
            return;
        }
        tPSystemSnapshotor.release();
        this.mSystemSnapshotor = null;
        ITPPlayerListener.IOnSnapshotListener iOnSnapshotListener = this.mOnPlayerSnapshotListener;
        if (iOnSnapshotListener != null) {
            Iterator<Long> it = this.mSnapshotTaskIdToOpaque.values().iterator();
            while (it.hasNext()) {
                iOnSnapshotListener.onSnapshotFailed(this, it.next().longValue(), new TPError(1001, TPErrorCode.TP_ERROR_CODE_GENERAL_FAILED));
            }
        }
        this.mSnapshotTaskIdToOpaque.clear();
    }

    private void releaseSubtitleParser() {
        TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
        if (tPSubtitleParser == null) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "release subtitle parser failed, subtitle parser is null");
            return;
        }
        try {
            tPSubtitleParser.release();
            TPLogUtil.i(this.mTPContext.getLogTag(), "release subtitle parser success");
        } catch (TPLoadLibraryException e16) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "release subtitle parser failed:" + e16);
        } catch (UnsupportedOperationException e17) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "release subtitle parser failed:" + e17);
        }
    }

    private void resetAllParams() {
        this.mStartPositionMs = 0L;
        this.mSkipEndPositionMs = -1L;
        this.mIsLive = false;
        this.mConfiguredDurationMs = -1L;
        this.mConfiguredVideoHeight = 0;
        this.mConfiguredVideoWidth = 0;
        this.mForceUseConfiguredVideoWidthHeight = false;
        this.mAudioAttributes = null;
        this.mPreferredAudioDeviceInfo = null;
        this.mEnablePreferredAudioDeviceInfo = false;
        this.mLastValidPositionMs = -1L;
        this.mIsAllowCheckBuffingByPosition = true;
        this.mIsSuspend = false;
        this.mIsLoopback = false;
        this.mLoopStartPositionMs = 0L;
        this.mLoopEndPositionMs = -1L;
        this.mIsAudioMute = false;
        this.mAudioVolume = 1.0f;
        this.mPlaySpeed = 1.0f;
        this.mIsSeekable = true;
        this.mBaseDurationMs = 0L;
        this.mLastCheckPositionMs = -1L;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mIsBuffering = false;
        this.mLastValidPositionMs = -1L;
        this.mCheckBufferPosNoChangeCount = 0;
        this.mSelectSubtitleIndex = -1;
        this.mCurAudioTrackIndex = 0;
        this.mCurInnerAudioTrackIndex = -1;
        this.mAudioTrackInfo.clear();
    }

    private void resetSubtitleParser() {
        TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
        if (tPSubtitleParser == null) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "reset subtitle parser failed, subtitle parser is null");
            return;
        }
        try {
            tPSubtitleParser.reset();
            TPLogUtil.i(this.mTPContext.getLogTag(), "reset subtitle parser success");
        } catch (TPLoadLibraryException e16) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "reset subtitle parser failed:" + e16);
        } catch (UnsupportedOperationException e17) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "reset subtitle parser failed:" + e17);
        }
    }

    private void restartRemuxingIfNeed() {
        if (this.mRemuxingMediaAsset != null && this.mRemuxer != null) {
            ExternalTrackInfo externalTrackInfo = this.mAudioTrackInfo.get(this.mCurAudioTrackIndex);
            if (externalTrackInfo.trackInfo.isInternal()) {
                return;
            }
            this.mRemuxer.stopRemuxing();
            this.mRemuxingMediaAsset = this.mRemuxer.startRemuxing(this.mMediaAsset, externalTrackInfo.asset);
        }
    }

    private void seekSubtitleParser(long j3, long j16) {
        TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
        if (tPSubtitleParser == null) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "seekSubtitleParser failed, mSubtitleParser is null");
            return;
        }
        try {
            tPSubtitleParser.seekToAsync(j3, j16);
        } catch (TPLoadLibraryException | UnsupportedOperationException e16) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "subtitle parser seekToAsync failed, exception:" + e16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0041, code lost:
    
        if (r8 == 3) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void seekToComm(MediaPlayer mediaPlayer, long j3, int i3) {
        int i16;
        int i17 = Build.VERSION.SDK_INT;
        if (i17 < 26) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "os ver is too low, current sdk int:" + i17 + ", is less than 26, use seekTo(int positionMs) instead");
            mediaPlayer.seekTo((int) j3);
            return;
        }
        try {
            if (i3 != 1) {
                if (i3 == 2) {
                    i16 = 1;
                } else {
                    i16 = 3;
                }
                mediaPlayer.seekTo(j3, i16);
                return;
            }
            mediaPlayer.seekTo(j3, i16);
            return;
        } catch (Exception e16) {
            TPLogUtil.e(this.mTPContext.getLogTag(), e16);
            try {
                if (this.mMediaPlayerState.isInStates(6)) {
                    this.mState.changeToState(4);
                }
                mediaPlayer.seekTo((int) j3);
                return;
            } catch (Exception e17) {
                TPLogUtil.e(this.mTPContext.getLogTag(), e17);
                return;
            }
        }
        i16 = 0;
    }

    private void selectAudioTrack(int i3, long j3) throws IOException, IllegalArgumentException, IllegalStateException, IndexOutOfBoundsException {
        if (i3 == this.mCurAudioTrackIndex) {
            ITPPlayerListener.IOnInfoListener iOnInfoListener = this.mOnInfoListener;
            if (iOnInfoListener != null) {
                iOnInfoListener.onInfo(this, 10, new TPOnInfoParam.Builder().setLongParam(j3).build());
                return;
            }
            return;
        }
        stopRemuxingIfNeed();
        ExternalTrackInfo externalTrackInfo = this.mAudioTrackInfo.get(i3);
        if (!externalTrackInfo.trackInfo.isInternal()) {
            this.mRemuxingMediaAsset = this.mRemuxer.startRemuxing(this.mMediaAsset, externalTrackInfo.asset);
        }
        ResetActionInfo resetActionInfo = new ResetActionInfo();
        resetActionInfo.opaque = j3;
        resetActionInfo.externalAudioTrackIndex = i3;
        resetActionInfo.resetType = 2;
        playerResetStart(resetActionInfo);
    }

    private void selectSubtitleTrack(int i3, long j3) {
        TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
        if (tPSubtitleParser == null) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "selectSubtitleTrack failed, mSubtitleParser is null");
            return;
        }
        try {
            tPSubtitleParser.selectTrackAsync(i3, j3);
            TPLogUtil.i(this.mTPContext.getLogTag(), "selectSubTrack, trackIndex:" + i3 + ", opaque:" + j3);
        } catch (TPLoadLibraryException | UnsupportedOperationException e16) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "selectSubTrack failed, exception:" + e16);
        }
    }

    private void setAudioAttributes(AudioAttributes audioAttributes) {
        if (audioAttributes == null) {
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        this.mMediaPlayer.setAudioAttributes(this.mAudioAttributes);
        TPLogUtil.i(this.mTPContext.getLogTag(), "set audio attributes into MediaPlayer, API:" + i3 + ">=21, " + this.mAudioAttributes.toString());
    }

    private void setInitParamsBeforePrepare() {
        setAudioAttributes(this.mAudioAttributes);
    }

    private void setPlaySpeedRatioForSubtitleParser(float f16) {
        TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
        if (tPSubtitleParser == null) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "setPlaySpeedRatioForSubtitleParser failed, mSubtitleParser is null");
            return;
        }
        try {
            tPSubtitleParser.setPlaySpeedRatio(f16);
        } catch (TPLoadLibraryException | UnsupportedOperationException e16) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "subtitle parser setPlaySpeedRatio failed, exception:" + e16);
        }
    }

    private void setPreferredAudioDevice(AudioDeviceInfo audioDeviceInfo) {
        boolean preferredDevice;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            preferredDevice = this.mMediaPlayer.setPreferredDevice(audioDeviceInfo);
            TPLogUtil.i(this.mTPContext.getLogTag(), "setPreferredDevice, ret:" + preferredDevice);
            return;
        }
        TPLogUtil.i(this.mTPContext.getLogTag(), "set audio deviceInfo into MediaPlayer, need API:" + i3 + ">=28");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCheckBufferTimeOutByInfo() {
        synchronized (this.mCheckBufferTimerOutByInfoLock) {
            if (this.mCheckBufferTimeOutBySystemInfoTimer == null) {
                this.mCheckBufferTimeOutBySystemInfoTimer = TPThreadPool.getInstance().obtainScheduledExecutorService().schedule(new Runnable() { // from class: com.tencent.thumbplayer.impl.system.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPSystemMediaPlayer.this.lambda$startCheckBufferTimeOutByInfo$2();
                    }
                }, this.mCheckBufferTimerOutFrequent * 400, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void startCheckBufferingTimer() {
        synchronized (this.mCheckBuffingTimerLock) {
            if (!isAllowCheckBufferByPosition()) {
                TPLogUtil.i(this.mTPContext.getLogTag(), "startCheckBufferingTimer, forbidden check buffer by position");
                return;
            }
            if (this.mBufferCheck == null) {
                final BufferCheck bufferCheck = new BufferCheck();
                this.mBufferCheck = bufferCheck;
                bufferCheck.mCheckAbort = false;
                bufferCheck.mCheckBuffingTimer = TPThreadPool.getInstance().obtainScheduledExecutorService().schedule(new Runnable() { // from class: com.tencent.thumbplayer.impl.system.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPSystemMediaPlayer.this.lambda$startCheckBufferingTimer$1(bufferCheck);
                    }
                }, 0L, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void startCheckPrepareTimeoutTimer() {
        TPLogUtil.i(this.mTPContext.getLogTag(), "startCheckPrepareTimeoutTimer");
        synchronized (this.mCheckPrepareTimeoutLock) {
            if (this.mCheckPrepareTimeoutTask == null) {
                this.mCheckPrepareTimeoutTask = TPThreadPool.getInstance().obtainScheduledExecutorService().schedule(new Runnable() { // from class: com.tencent.thumbplayer.impl.system.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPSystemMediaPlayer.this.lambda$startCheckPrepareTimeoutTimer$0();
                    }
                }, this.mIntervalCheckPreparingTimeOutMs, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void stopRemuxingIfNeed() {
        ITPPlayRemuxer iTPPlayRemuxer = this.mRemuxer;
        if (iTPPlayRemuxer != null && this.mRemuxingMediaAsset != null) {
            iTPPlayRemuxer.stopRemuxing();
            this.mRemuxingMediaAsset = null;
        }
    }

    private int systemTrackType2TPTrackType(int i3) {
        if (2 == i3) {
            return 1;
        }
        if (1 == i3) {
            return 0;
        }
        if (4 == i3) {
            return 3;
        }
        return -1;
    }

    private void unRegisterPlayerListener(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnPreparedListener(null);
        mediaPlayer.setOnCompletionListener(null);
        mediaPlayer.setOnErrorListener(null);
        mediaPlayer.setOnInfoListener(null);
        mediaPlayer.setOnBufferingUpdateListener(null);
        mediaPlayer.setOnSeekCompleteListener(null);
        mediaPlayer.setOnVideoSizeChangedListener(null);
    }

    private void upDateCurrentPositionMs() {
        try {
            if (this.mIsLive || this.mBaseDurationMs <= 0 || this.mIsSuspend || this.mState.isInStates(9) || this.mState.isInStates(0, 1, 2, 8, 3)) {
                return;
            }
            long currentPosition = this.mMediaPlayer.getCurrentPosition();
            if (currentPosition > 0) {
                this.mLastValidPositionMs = currentPosition;
            }
        } catch (Exception unused) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "upDateCurrentPositionMs exception");
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void addAudioTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException {
        if (iTPMediaAsset.getAssetType() == 3 && !TextUtils.isEmpty(((TPUrlMediaAsset) iTPMediaAsset).getSystemMediaPlayerUrl()) && !TextUtils.isEmpty(str)) {
            TPTrackInfo tPTrackInfo = new TPTrackInfo();
            tPTrackInfo.setName(str);
            tPTrackInfo.setExclusive(true);
            tPTrackInfo.setInternal(false);
            tPTrackInfo.setSelected(false);
            tPTrackInfo.setMediaType(1);
            ExternalTrackInfo externalTrackInfo = new ExternalTrackInfo();
            externalTrackInfo.trackInfo = tPTrackInfo;
            externalTrackInfo.asset = iTPMediaAsset;
            TPLogUtil.i(this.mTPContext.getLogTag(), "addAudioTrackSource, name:" + tPTrackInfo.getName() + ", url:" + str);
            this.mAudioTrackInfo.add(externalTrackInfo);
            return;
        }
        TPLogUtil.e(this.mTPContext.getLogTag(), "addAudioTrackSource, invalid asset:" + iTPMediaAsset + ", name:" + str);
        throw new IllegalArgumentException("addAudioTrackSource, name or asset is invalid");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x009b, code lost:
    
        if (r0.equals(com.tencent.thumbplayer.api.optionalparam.TPOptionalID.OPTIONAL_ID_BEFORE_LONG_ANDROID_MEDIAPLAYER_VIDEO_DURATION_MS) == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void addBeforeOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) throws IllegalStateException {
        char c16 = 2;
        if (this.mState.isInStates(0, 1)) {
            String key = tPOptionalParam.getKey();
            key.hashCode();
            switch (key.hashCode()) {
                case -1720380850:
                    if (key.equals(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_PREFERRED_AUDIO_DEVICE_INFO)) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1550593085:
                    if (key.equals(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ANDROID_MEDIAPLAYER_ALLOW_CHECK_BUFFERING_BY_POSITION)) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1054967493:
                    break;
                case -999567715:
                    if (key.equals(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ANDROID_MEDIAPLAYER_IS_LIVE)) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -625767507:
                    if (key.equals(TPOptionalID.OPTIONAL_ID_BEFORE_INT_ANDROID_MEDIAPLAYER_VIDEO_WIDTH)) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -620245911:
                    if (key.equals(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFERING_TIMEOUT_MS)) {
                        c16 = 5;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -333342683:
                    if (key.equals(TPOptionalID.OPTIONAL_ID_BEFORE_OBJECT_AUDIO_ATTRIBUTES)) {
                        c16 = 6;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -273207806:
                    if (key.equals(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_START_PLAYING_TIME_MS)) {
                        c16 = 7;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 249154116:
                    if (key.equals(TPOptionalID.OPTIONAL_ID_BEFORE_INT_OUT_SUBTITLE_DATA_TYPE)) {
                        c16 = '\b';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 329937892:
                    if (key.equals(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_PREPARE_TIMEOUT_MS)) {
                        c16 = '\t';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1643048992:
                    if (key.equals(TPOptionalID.OPTIONAL_ID_BEFORE_INT_ANDROID_MEDIAPLAYER_VIDEO_HEIGHT)) {
                        c16 = '\n';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1735247529:
                    if (key.equals(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ANDROID_MEDIAPLAYER_USE_CONFIGURED_VIDEO_WIDTH_HEIGHT)) {
                        c16 = 11;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                    this.mEnablePreferredAudioDeviceInfo = ((Boolean) tPOptionalParam.getValue()).booleanValue();
                    return;
                case 1:
                    this.mIsAllowCheckBuffingByPosition = ((Boolean) tPOptionalParam.getValue()).booleanValue();
                    return;
                case 2:
                    this.mConfiguredDurationMs = ((Long) tPOptionalParam.getValue()).longValue();
                    return;
                case 3:
                    boolean booleanValue = ((Boolean) tPOptionalParam.getValue()).booleanValue();
                    this.mIsLive = booleanValue;
                    if (booleanValue) {
                        this.mIsSeekable = false;
                    }
                    TPLogUtil.i(this.mTPContext.getLogTag(), "addBeforeOptionalParam, is live:" + this.mIsLive);
                    return;
                case 4:
                    this.mConfiguredVideoWidth = ((Integer) tPOptionalParam.getValue()).intValue();
                    TPLogUtil.i(this.mTPContext.getLogTag(), "addBeforeOptionalParam, video width:" + this.mConfiguredVideoWidth);
                    return;
                case 5:
                    this.mCheckBufferTimerOutFrequent = (int) ((((Long) tPOptionalParam.getValue()).longValue() + 400) / 400);
                    TPLogUtil.i(this.mTPContext.getLogTag(), "addBeforeOptionalParam, buffer timeout:" + tPOptionalParam.getValue() + "(ms)");
                    return;
                case 6:
                    this.mAudioAttributes = (AudioAttributes) tPOptionalParam.getValue();
                    TPLogUtil.i(this.mTPContext.getLogTag(), "addBeforeOptionalParam, audioAttribute:" + this.mAudioAttributes);
                    return;
                case 7:
                    this.mStartPositionMs = ((Long) tPOptionalParam.getValue()).longValue();
                    TPLogUtil.i(this.mTPContext.getLogTag(), "addBeforeOptionalParam, startPositionMs:" + this.mStartPositionMs);
                    return;
                case '\b':
                    int intValue = ((Integer) tPOptionalParam.getValue()).intValue();
                    TPLogUtil.i(this.mTPContext.getLogTag(), "addBeforeOptionalParam, subtitle data type:" + intValue);
                    this.mSubtitleDataType = intValue;
                    return;
                case '\t':
                    this.mIntervalCheckPreparingTimeOutMs = ((Long) tPOptionalParam.getValue()).longValue();
                    TPLogUtil.i(this.mTPContext.getLogTag(), "addBeforeOptionalParam, prepare timeout:" + this.mIntervalCheckPreparingTimeOutMs + "(ms)");
                    return;
                case '\n':
                    this.mConfiguredVideoHeight = ((Integer) tPOptionalParam.getValue()).intValue();
                    TPLogUtil.i(this.mTPContext.getLogTag(), "addBeforeOptionalParam, video height:" + this.mConfiguredVideoHeight);
                    return;
                case 11:
                    this.mForceUseConfiguredVideoWidthHeight = ((Boolean) tPOptionalParam.getValue()).booleanValue();
                    TPLogUtil.i(this.mTPContext.getLogTag(), "addBeforeOptionalParam, force use video width and height:" + this.mForceUseConfiguredVideoWidthHeight);
                    return;
                default:
                    return;
            }
        }
        throw new IllegalStateException("addBeforeOptionalParam invalid state: " + TPPlayerStateToString.getStateName(this.mState.getCurrentState()));
    }

    void addGlobalOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) {
        AudioDeviceInfo audioDeviceInfo;
        String key = tPOptionalParam.getKey();
        key.hashCode();
        char c16 = '\uffff';
        switch (key.hashCode()) {
            case -2018520943:
                if (key.equals(TPOptionalID.OPTIONAL_ID_GLOBAL_OBJECT_SUBTITLE_RENDER_PARAMS)) {
                    c16 = 0;
                    break;
                }
                break;
            case 1387723591:
                if (key.equals(TPOptionalID.OPTIONAL_ID_GLOBAL_OBJECT_PREFERRED_AUDIO_DEVICE_INFO)) {
                    c16 = 1;
                    break;
                }
                break;
            case 1539581376:
                if (key.equals(TPOptionalID.OPTIONAL_ID_GLOBAL_LONG_SKIP_END_TIME_MS)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                TPSubtitleRenderParams tPSubtitleRenderParams = (TPSubtitleRenderParams) tPOptionalParam.getValue();
                TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
                if (tPSubtitleParser != null) {
                    try {
                        tPSubtitleParser.setRenderParams(tPSubtitleRenderParams);
                        TPLogUtil.i(this.mTPContext.getLogTag(), "addGlobalOptionalParam, subtitle render params:" + tPSubtitleRenderParams);
                        return;
                    } catch (TPLoadLibraryException e16) {
                        TPLogUtil.e(this.mTPContext.getLogTag(), "addGlobalOptionalParam subtitle render params failed:" + e16);
                        return;
                    }
                }
                return;
            case 1:
                if (this.mEnablePreferredAudioDeviceInfo && this.mPreferredAudioDeviceInfo != (audioDeviceInfo = (AudioDeviceInfo) tPOptionalParam.getValue())) {
                    this.mPreferredAudioDeviceInfo = audioDeviceInfo;
                    setPreferredAudioDevice(audioDeviceInfo);
                    return;
                }
                return;
            case 2:
                this.mSkipEndPositionMs = ((Long) tPOptionalParam.getValue()).longValue();
                TPLogUtil.i(this.mTPContext.getLogTag(), "addGlobalOptionalParam, skipEndPositionMs:" + this.mSkipEndPositionMs);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void addOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) throws IllegalStateException {
        if (tPOptionalParam.isBeforeOptionalParam()) {
            addBeforeOptionalParam(tPOptionalParam);
        } else {
            addGlobalOptionalParam(tPOptionalParam);
        }
        addOptionalParamToSubtitleParser(tPOptionalParam);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void addPlugin(ITPPluginBase iTPPluginBase) {
        com.tencent.thumbplayer.api.player.a.a(this, iTPPluginBase);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void addSubtitleTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException {
        TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
        if (tPSubtitleParser == null) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "addSubtitleTrackSource failed, mSubtitleParser is null");
            return;
        }
        try {
            tPSubtitleParser.addDataSource(iTPMediaAsset, str);
        } catch (TPLoadLibraryException | IllegalArgumentException | UnsupportedOperationException e16) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "addSubtitleTrackSource failed, exception:" + e16);
            throw new IllegalArgumentException("addSubtitleTrackSource failed, exception:" + e16);
        }
    }

    void addTokenToHttpHeaderIfNeeded(@NonNull TPUrlMediaAsset tPUrlMediaAsset) {
        if (!TextUtils.isEmpty(tPUrlMediaAsset.getHttpVerificationCode())) {
            String generateHttpToken = TPCryptoUtil.generateHttpToken(1, tPUrlMediaAsset.getHttpVerificationCode());
            HashMap hashMap = new HashMap(tPUrlMediaAsset.getHttpHeader());
            hashMap.put("TP-MD5", generateHttpToken);
            tPUrlMediaAsset.setHttpHeader(hashMap);
        }
    }

    @Override // com.tencent.thumbplayer.api.dtreport.IDtReport
    public /* synthetic */ void bindVideoPlayerInfo(Object obj) {
        we4.a.a(this, obj);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void deselectTrackAsync(int i3) {
        deselectTrackAsync(i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public long getAvailablePositionMs() {
        return -1L;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public long getCurrentPositionMs() {
        return this.mLastValidPositionMs;
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ int getCurrentState() {
        return com.tencent.thumbplayer.impl.a.a(this);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public long getDemuxerCurrentOriginalPtsUs() {
        return -1L;
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public long getDemuxerOffsetInFileByte() {
        return -1L;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public long getDurationMs() {
        if (this.mIsLive) {
            return 0L;
        }
        if (this.mIsSuspend) {
            return this.mBaseDurationMs;
        }
        if (!this.mState.isInStates(3, 4, 5)) {
            return -1L;
        }
        if (this.mBaseDurationMs <= 0) {
            this.mBaseDurationMs = this.mMediaPlayer.getDuration();
        }
        long j3 = this.mConfiguredDurationMs;
        if (j3 > 0) {
            long j16 = this.mBaseDurationMs;
            if (j16 <= 0) {
                this.mBaseDurationMs = j3;
            } else {
                long abs = Math.abs(j3 - j16) * 100;
                long j17 = this.mConfiguredDurationMs;
                if (abs / j17 > 1) {
                    this.mBaseDurationMs = j17;
                }
            }
        }
        return this.mBaseDurationMs;
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public TPDynamicStatisticParams getDynamicStatisticParams(boolean z16) {
        return null;
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public TPGeneralPlayFlowParams getGeneralPlayFlowParams() {
        return null;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public int getHeight() {
        return this.mVideoHeight;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public int getPlayerCoreType() {
        return 1;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public TPProgramInfo[] getProgramInfo() {
        return null;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public String getProperty(String str) throws IllegalStateException {
        return "";
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ ITPReportExtendedController getReportExtendedController() {
        return com.tencent.thumbplayer.impl.a.b(this);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ ITPBusinessReportManager getReportManager() {
        return com.tencent.thumbplayer.impl.a.c(this);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ TPContext getTPConext() {
        return com.tencent.thumbplayer.api.player.a.b(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a A[LOOP:0: B:20:0x0054->B:22:0x005a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c A[LOOP:1: B:25:0x006a->B:26:0x006c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0049  */
    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TPTrackInfo[] getTrackInfo() {
        MediaPlayer.TrackInfo[] trackInfoArr;
        TPTrackInfo[] subtitleTrackInfo;
        int length;
        Iterator<ExternalTrackInfo> it;
        int length2;
        int i3;
        if (this.mState.isInStates(3, 4, 5) && TPSystemInfo.SDK_INT > 16) {
            try {
                trackInfoArr = this.mMediaPlayer.getTrackInfo();
            } catch (Exception unused) {
                TPLogUtil.e(this.mTPContext.getLogTag(), "getTrackInfo, android getTrackInfo crash");
            }
            subtitleTrackInfo = getSubtitleTrackInfo();
            if (trackInfoArr != null && this.mAudioTrackInfo.isEmpty() && subtitleTrackInfo.length == 0) {
                return new TPTrackInfo[0];
            }
            int size = this.mAudioTrackInfo.size() + subtitleTrackInfo.length;
            if (trackInfoArr != null) {
                length = 0;
            } else {
                length = trackInfoArr.length;
            }
            TPTrackInfo[] tPTrackInfoArr = new TPTrackInfo[size + length];
            it = this.mAudioTrackInfo.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                tPTrackInfoArr[i16] = it.next().trackInfo;
                i16++;
            }
            length2 = subtitleTrackInfo.length;
            i3 = 0;
            while (i3 < length2) {
                tPTrackInfoArr[i16] = subtitleTrackInfo[i3];
                i3++;
                i16++;
            }
            if (trackInfoArr != null && trackInfoArr.length > 0) {
                for (MediaPlayer.TrackInfo trackInfo : trackInfoArr) {
                    if (trackInfo != null) {
                        TPTrackInfo tPTrackInfo = new TPTrackInfo();
                        tPTrackInfo.setName(trackInfo.getLanguage());
                        tPTrackInfo.setMediaType(systemTrackType2TPTrackType(trackInfo.getTrackType()));
                        TPLogUtil.i(this.mTPContext.getLogTag(), "getTrackInfo index:" + i16 + ", type:" + tPTrackInfo.getMediaType() + ", isSelected:" + tPTrackInfo.isSelected() + ", name:" + tPTrackInfo.getName());
                        tPTrackInfoArr[i16] = tPTrackInfo;
                        i16++;
                    }
                }
            }
            return tPTrackInfoArr;
        }
        trackInfoArr = null;
        subtitleTrackInfo = getSubtitleTrackInfo();
        if (trackInfoArr != null) {
        }
        int size2 = this.mAudioTrackInfo.size() + subtitleTrackInfo.length;
        if (trackInfoArr != null) {
        }
        TPTrackInfo[] tPTrackInfoArr2 = new TPTrackInfo[size2 + length];
        it = this.mAudioTrackInfo.iterator();
        int i162 = 0;
        while (it.hasNext()) {
        }
        length2 = subtitleTrackInfo.length;
        i3 = 0;
        while (i3 < length2) {
        }
        if (trackInfoArr != null) {
            while (r2 < r1) {
            }
        }
        return tPTrackInfoArr2;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public int getWidth() {
        return this.mVideoWidth;
    }

    @Override // com.tencent.thumbplayer.utils.timer.ITPVideoTimerListener
    public void onTimerCallback() {
        upDateCurrentPositionMs();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public synchronized void pause() throws IllegalStateException {
        TPLogUtil.i(this.mTPContext.getLogTag(), "pause");
        if (this.mIsSuspend) {
            ResetActionInfo resetActionInfo = this.mLastAction;
            if (resetActionInfo != null) {
                resetActionInfo.state = 5;
            }
            TPLogUtil.w(this.mTPContext.getLogTag(), "system player is busy.");
            return;
        }
        TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
        if (tPSubtitleParser != null) {
            try {
                tPSubtitleParser.pause();
            } catch (TPLoadLibraryException | UnsupportedOperationException e16) {
                TPLogUtil.e(this.mTPContext.getLogTag(), "subtitle parser pause failed, exception:" + e16);
            }
        }
        this.mMediaPlayer.pause();
        this.mState.changeToState(5);
        this.mMediaPlayerState.changeToState(5);
        TPVideoTimerManager.g().unRegisterTimerListener(this);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void prepareAsync() throws IllegalStateException {
        initSubtitleParser();
        handlePreferredStartTrack();
        innerSetDataSource();
        innerPrepareAsync();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public synchronized void release() {
        TPLogUtil.i(this.mTPContext.getLogTag(), "release");
        releaseSubtitleParser();
        destroyCheckPrepareTimeoutTimer();
        destroyCheckBuffingTimer();
        destroyCheckBufferTimeOutByInfo();
        this.mState.changeToState(10);
        mediaPlayerStopAndRelease();
        this.mMediaAsset = null;
        releaseSnapShotorIfNeeded();
        this.mOnPreparedListener = null;
        this.mOnCompletionListener = null;
        this.mOnInfoListener = null;
        this.mOnErrorListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mSurfaceObj = null;
        TPVideoTimerManager.g().unRegisterTimerListener(this);
        TPLogUtil.i(this.mTPContext.getLogTag(), "release over.");
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void removeTrack(int i3) throws IllegalArgumentException {
        if (i3 >= 0) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "removeTrack, trackIndex:" + i3);
            int size = this.mAudioTrackInfo.size();
            int length = getSubtitleTrackInfo().length;
            if (i3 < size) {
                TPTrackInfo tPTrackInfo = this.mAudioTrackInfo.get(i3).trackInfo;
                if (!tPTrackInfo.isSelected() && !tPTrackInfo.isInternal()) {
                    this.mAudioTrackInfo.remove(i3);
                    return;
                }
                throw new IllegalArgumentException("To be removed audio track is selected: " + tPTrackInfo.isSelected() + " or internal: " + tPTrackInfo.isInternal() + ", cannot remove");
            }
            if (i3 < length + size) {
                try {
                    this.mSubtitleParser.removeTrack(i3 - size);
                    return;
                } catch (TPLoadLibraryException e16) {
                    throw new IllegalArgumentException(e16);
                }
            }
            throw new IllegalArgumentException("not support remove inner track!");
        }
        throw new IllegalArgumentException("removeTrack, trackIndex:" + i3 + " is invalid");
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public synchronized void reset() {
        TPLogUtil.i(this.mTPContext.getLogTag(), "reset");
        this.mState.changeToState(0);
        this.mMediaPlayerState.changeToState(0);
        resetSubtitleParser();
        this.mMediaPlayer.reset();
        this.mMediaAsset = null;
        this.mRemuxingMediaAsset = null;
        releaseSnapShotorIfNeeded();
        stopRemuxingIfNeed();
        resetAllParams();
        destroyCheckPrepareTimeoutTimer();
        destroyCheckBuffingTimer();
        destroyCheckBufferTimeOutByInfo();
        TPVideoTimerManager.g().unRegisterTimerListener(this);
        TPLogUtil.i(this.mTPContext.getLogTag(), "reset over.");
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void seekToAsync(long j3) throws IllegalStateException {
        seekToAsync(j3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void selectProgramAsync(int i3) {
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void selectTrackAsync(int i3) {
        selectTrackAsync(i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setAudioMute(boolean z16) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "setAudioMute: " + z16);
        this.mIsAudioMute = z16;
        try {
            if (z16) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                MediaPlayer mediaPlayer = this.mMediaPlayer;
                float f16 = this.mAudioVolume;
                mediaPlayer.setVolume(f16, f16);
                TPLogUtil.i(this.mTPContext.getLogTag(), "setAudioMute: false, audioVolume: " + this.mAudioVolume);
            }
        } catch (Exception e16) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "setAudioMute, Exception: " + e16);
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setAudioVolume(float f16) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "setAudioVolume: " + f16);
        this.mAudioVolume = f16;
        try {
            if (this.mMediaPlayer != null) {
                MediaPlayer mediaPlayer = this.mMediaPlayer;
                float f17 = this.mAudioVolume;
                mediaPlayer.setVolume(f17, f17);
            }
        } catch (IllegalStateException e16) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "setAudioVolume exception: " + e16);
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19) {
        com.tencent.thumbplayer.api.player.a.c(this, i3, i16, i17, i18, i19);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setDataSource(@NonNull ITPMediaAsset iTPMediaAsset) throws IllegalArgumentException, IllegalStateException {
        String str;
        if (iTPMediaAsset != null && iTPMediaAsset.isValid()) {
            this.mMediaAsset = iTPMediaAsset;
            this.mState.changeToState(1);
            ReportThumbPlayer.getInstance().setDataSource(this, iTPMediaAsset);
            return;
        }
        String logTag = this.mTPContext.getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setDataSource, mediaAsset is ");
        String str2 = "null";
        if (iTPMediaAsset == null) {
            str = "null";
        } else {
            str = HippyReporter.RemoveEngineReason.INVALID;
        }
        sb5.append(str);
        TPLogUtil.w(logTag, sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("setDataSource, mediaAsset is ");
        if (iTPMediaAsset != null) {
            str2 = HippyReporter.RemoveEngineReason.INVALID;
        }
        sb6.append(str2);
        throw new IllegalArgumentException(sb6.toString());
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setLogTagPrefix(String str) {
        com.tencent.thumbplayer.impl.a.d(this, str);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setLoopback(boolean z16) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "setLoopback: " + z16);
        this.mIsLoopback = z16;
        this.mMediaPlayer.setLooping(z16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener iOnCompletionListener) {
        this.mOnCompletionListener = iOnCompletionListener;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnErrorListener(ITPPlayerListener.IOnErrorListener iOnErrorListener) {
        this.mOnErrorListener = iOnErrorListener;
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setOnGetRemainTimeBeforePlayListener(ITPPlayerListener.IOnGetRemainTimeBeforePlayListener iOnGetRemainTimeBeforePlayListener) {
        com.tencent.thumbplayer.impl.a.e(this, iOnGetRemainTimeBeforePlayListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnInfoListener(ITPPlayerListener.IOnInfoListener iOnInfoListener) {
        this.mOnInfoListener = iOnInfoListener;
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setOnMediaAssetExpireListener(ITPPlayerListener.IOnMediaAssetExpireListener iOnMediaAssetExpireListener) {
        com.tencent.thumbplayer.impl.a.f(this, iOnMediaAssetExpireListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener iOnPreparedListener) {
        this.mOnPreparedListener = iOnPreparedListener;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener) {
        this.mOnSeekCompleteListener = iOnSeekCompleteListener;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnSnapshotListener(ITPPlayerListener.IOnSnapshotListener iOnSnapshotListener) {
        this.mOnPlayerSnapshotListener = iOnSnapshotListener;
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setOnStateChangedListener(ITPPlayerListener.IOnStateChangedListener iOnStateChangedListener) {
        com.tencent.thumbplayer.impl.a.g(this, iOnStateChangedListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener) {
        com.tencent.thumbplayer.impl.a.h(this, iOnStopAsyncCompleteListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnSubtitleDataOutListener(ITPPlayerListener.IOnSubtitleDataOutListener iOnSubtitleDataOutListener) {
        this.mOnSubtitleDataOutListener = iOnSubtitleDataOutListener;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = iOnVideoSizeChangedListener;
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public void setPlayRemuxer(ITPPlayRemuxer iTPPlayRemuxer) {
        this.mRemuxer = iTPPlayRemuxer;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TargetApi(23)
    public void setPlaySpeedRatio(float f16) {
        if (f16 <= 0.0f) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "failed to setPlaySpeedRatio, speedRatio:" + f16);
            return;
        }
        TPLogUtil.i(this.mTPContext.getLogTag(), "setPlaySpeedRatio: " + f16);
        this.mPlaySpeed = f16;
        if (this.mMediaPlayerState.isInStates(0)) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "failed to setPlaySpeedRatio, illegal state");
            return;
        }
        try {
            PlaybackParams playbackParams = this.mMediaPlayer.getPlaybackParams();
            if (playbackParams.getSpeed() != f16) {
                playbackParams.setSpeed(f16);
                this.mMediaPlayer.setPlaybackParams(playbackParams);
                setPlaySpeedRatioForSubtitleParser(f16);
            }
        } catch (Exception e16) {
            TPLogUtil.e(this.mTPContext.getLogTag(), e16);
        }
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setRichMediaSynchronizer(ITPRichMediaSynchronizer iTPRichMediaSynchronizer) {
        com.tencent.thumbplayer.impl.a.i(this, iTPRichMediaSynchronizer);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setSurface(Surface surface) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "setSurface, surface: " + surface);
        this.mSurfaceObj = surface;
        this.mMediaPlayer.setSurface(surface);
        TPLogUtil.i(this.mTPContext.getLogTag(), "setSurface over, surface: " + surface);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "setSurfaceHolder, surfaceHolder: " + surfaceHolder);
        this.mSurfaceObj = surfaceHolder;
        this.mMediaPlayer.setDisplay(surfaceHolder);
        TPLogUtil.i(this.mTPContext.getLogTag(), "setSurfaceHolder over, surfaceHolder: " + surfaceHolder);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void snapshotAsync(TPSnapshotParams tPSnapshotParams) throws IllegalStateException {
        snapshotAsync(tPSnapshotParams, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void start() throws IllegalStateException {
        TPLogUtil.i(this.mTPContext.getLogTag(), "start");
        if (this.mIsSuspend) {
            ResetActionInfo resetActionInfo = this.mLastAction;
            if (resetActionInfo != null) {
                resetActionInfo.state = 4;
            }
            TPLogUtil.w(this.mTPContext.getLogTag(), "system player is busy.");
            return;
        }
        if (!this.mState.isInStates(3, 5)) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "start, illegal state:" + this.mState);
            return;
        }
        this.mMediaPlayer.start();
        this.mState.changeToState(4);
        this.mMediaPlayerState.changeToState(4);
        TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
        if (tPSubtitleParser != null) {
            try {
                tPSubtitleParser.start();
            } catch (TPLoadLibraryException | UnsupportedOperationException e16) {
                TPLogUtil.e(this.mTPContext.getLogTag(), "subtitle parser start failed, exception:" + e16);
            }
        }
        float f16 = this.mPlaySpeed;
        if (f16 != 1.0d) {
            setPlaySpeedRatio(f16);
        }
        startCheckBufferingTimer();
        TPVideoTimerManager.g().registerTimerListener(this);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public synchronized void stop() throws IllegalStateException {
        TPLogUtil.i(this.mTPContext.getLogTag(), "stop");
        destroyCheckPrepareTimeoutTimer();
        destroyCheckBuffingTimer();
        destroyCheckBufferTimeOutByInfo();
        this.mState.changeToState(8);
        mediaPlayerStop();
        this.mCurAudioTrackIndex = 0;
        this.mLastAction = null;
        this.mSelectSubtitleIndex = -1;
        this.mCurInnerAudioTrackIndex = -1;
        TPSubtitleParser tPSubtitleParser = this.mSubtitleParser;
        if (tPSubtitleParser != null) {
            try {
                tPSubtitleParser.pause();
            } catch (TPLoadLibraryException | UnsupportedOperationException e16) {
                TPLogUtil.e(this.mTPContext.getLogTag(), "subtitle parser pause failed, exception:" + e16);
            }
        }
        TPVideoTimerManager.g().unRegisterTimerListener(this);
        TPLogUtil.i(this.mTPContext.getLogTag(), "stop over.");
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void stopAsync() {
        com.tencent.thumbplayer.impl.a.j(this);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        switchDataSourceAsync(iTPMediaAsset, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TargetApi(16)
    public void deselectTrackAsync(int i3, long j3) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "deselectTrackAsync, trackIndex:" + i3);
        int size = this.mAudioTrackInfo.size();
        int length = getSubtitleTrackInfo().length;
        if (i3 >= size && i3 < length + size) {
            try {
                deselectSubtitleTrack(i3 - size, j3);
                return;
            } catch (Exception e16) {
                TPLogUtil.e(this.mTPContext.getLogTag(), e16);
                return;
            }
        }
        this.mMediaPlayer.deselectTrack(i3);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void seekToAsync(long j3, long j16) throws IllegalStateException {
        seekToAsync(j3, 0, j16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void selectProgramAsync(int i3, long j3) {
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void selectTrackAsync(int i3, long j3) {
        MediaPlayer.TrackInfo[] trackInfoArr;
        TPLogUtil.i(this.mTPContext.getLogTag(), "selectTrackAsync, trackIndex:" + i3 + ", opaque:" + j3);
        int size = this.mAudioTrackInfo.size();
        int length = getSubtitleTrackInfo().length;
        ITPPlayerListener.IOnInfoListener iOnInfoListener = this.mOnInfoListener;
        if (i3 >= 0 && i3 < size) {
            if (this.mState.isInStates(0, 1, 8)) {
                this.mPreferredStartAudioTrackName = this.mAudioTrackInfo.get(i3).trackInfo.getName();
                iOnInfoListener.onInfo(this, 10, new TPOnInfoParam.Builder().setLongParam(j3).build());
                return;
            }
            try {
                selectAudioTrack(i3, j3);
                this.mAudioTrackInfo.get(this.mCurAudioTrackIndex).trackInfo.setSelected(false);
                this.mAudioTrackInfo.get(i3).trackInfo.setSelected(true);
                this.mCurAudioTrackIndex = i3;
                return;
            } catch (Exception e16) {
                TPLogUtil.e(this.mTPContext.getLogTag(), e16);
                if (iOnInfoListener != null) {
                    iOnInfoListener.onInfo(this, 11, new TPOnInfoParam.Builder().setLongParam(j3).setObjParam(new TPError(2000, formatErrorCode(-10000))).build());
                    return;
                }
                return;
            }
        }
        if (i3 >= size && i3 < size + length) {
            try {
                selectSubtitleTrack(i3 - size, j3);
                return;
            } catch (Exception e17) {
                TPLogUtil.e(this.mTPContext.getLogTag(), e17);
                if (iOnInfoListener != null) {
                    iOnInfoListener.onInfo(this, 11, new TPOnInfoParam.Builder().setLongParam(j3).setObjParam(new TPError(2000, formatErrorCode(-10000))).build());
                    return;
                }
                return;
            }
        }
        int i16 = i3 - (size + length);
        if (!this.mState.isInStates(3, 4, 5)) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "selectTrackAsync, illegal state:" + this.mState);
            return;
        }
        try {
            trackInfoArr = this.mMediaPlayer.getTrackInfo();
        } catch (Exception unused) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "getTrackInfo, android getTrackInfo crash");
            trackInfoArr = null;
        }
        if (trackInfoArr == null || trackInfoArr.length <= i16) {
            if (iOnInfoListener != null) {
                iOnInfoListener.onInfo(this, 11, new TPOnInfoParam.Builder().setLongParam(j3).setObjParam(new TPError(2000, formatErrorCode(-10002))).build());
                return;
            }
            return;
        }
        MediaPlayer.TrackInfo trackInfo = trackInfoArr[i16];
        if (trackInfo.getTrackType() == 2) {
            this.mCurInnerAudioTrackIndex = i16;
            if (this.mCurAudioTrackIndex < this.mAudioTrackInfo.size()) {
                ExternalTrackInfo externalTrackInfo = this.mAudioTrackInfo.get(this.mCurAudioTrackIndex);
                if (externalTrackInfo.trackInfo.isSelected()) {
                    externalTrackInfo.trackInfo.setSelected(false);
                }
            }
        } else {
            if (trackInfo.getTrackType() != 4) {
                if (iOnInfoListener != null) {
                    iOnInfoListener.onInfo(this, 11, new TPOnInfoParam.Builder().setLongParam(j3).setObjParam(new TPError(2000, formatErrorCode(-10003))).build());
                    return;
                }
                return;
            }
            this.mSelectSubtitleIndex = i16;
        }
        this.mMediaPlayer.selectTrack(i16);
        if (iOnInfoListener != null) {
            iOnInfoListener.onInfo(this, 10, new TPOnInfoParam.Builder().setLongParam(j3).build());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void snapshotAsync(TPSnapshotParams tPSnapshotParams, long j3) throws IllegalStateException {
        if (this.mSystemSnapshotor == null) {
            TPSystemSnapshotor createAndInitSystemSnapshotor = createAndInitSystemSnapshotor();
            this.mSystemSnapshotor = createAndInitSystemSnapshotor;
            if (createAndInitSystemSnapshotor == null) {
                throw new IllegalStateException("snapshotAsync, create system snapshotor failed");
            }
        }
        try {
            this.mSnapshotTaskIdToOpaque.put(Integer.valueOf(this.mSystemSnapshotor.snapshotAsyncAtPosition(getCurrentPositionMs(), tPSnapshotParams)), Long.valueOf(j3));
        } catch (IllegalArgumentException | IllegalStateException | UnsupportedOperationException e16) {
            TPLogUtil.e(this.mTPContext.getLogTag(), e16);
            throw new IllegalStateException(e16);
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, long j3) throws IllegalStateException, IllegalArgumentException {
        TPLogUtil.i(this.mTPContext.getLogTag(), "switchDataSourceAsync, asset: " + iTPMediaAsset);
        if (iTPMediaAsset != null && iTPMediaAsset.isValid() && iTPMediaAsset.getAssetType() == 3) {
            this.mMediaAsset = iTPMediaAsset;
            releaseSnapShotorIfNeeded();
            restartRemuxingIfNeed();
            ResetActionInfo resetActionInfo = new ResetActionInfo();
            resetActionInfo.opaque = j3;
            resetActionInfo.externalAudioTrackIndex = this.mCurAudioTrackIndex;
            resetActionInfo.resetType = 1;
            try {
                playerResetStart(resetActionInfo);
                return;
            } catch (Exception unused) {
                throw new IllegalStateException("playerResetStart");
            }
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "switchDataSourceAsync, unsupported mediaAsset: " + iTPMediaAsset);
        throw new IllegalArgumentException("switchDataSourceAsync, unsupported mediaAsset: " + iTPMediaAsset);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void seekToAsync(long j3, int i3) throws IllegalStateException {
        seekToAsync(j3, i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @TargetApi(26)
    public void seekToAsync(long j3, int i3, long j16) throws IllegalStateException {
        TPLogUtil.i(this.mTPContext.getLogTag(), "seekToAsync, position: " + j3 + ", mode: " + i3 + ", opaque:" + j16);
        if (!this.mIsSeekable) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "current media doesn't support seek, ignore");
            return;
        }
        if (this.mIsSuspend) {
            ResetActionInfo resetActionInfo = this.mLastAction;
            if (resetActionInfo != null) {
                resetActionInfo.positionMs = j3;
                return;
            }
            return;
        }
        if (this.mMediaPlayerState.isInStates(6)) {
            this.mState.changeToState(4);
        }
        this.mSeekOpaque = j16;
        seekToComm(this.mMediaPlayer, j3, i3);
        seekSubtitleParser(j3, j16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setLoopback(boolean z16, long j3, long j16) throws IllegalStateException, IllegalArgumentException {
        TPLogUtil.i(this.mTPContext.getLogTag(), "setLoopback: " + z16 + ", loopStartPositionMs: " + j3 + ", loopEndPositionMs: " + j16);
        if (j3 >= 0) {
            long j17 = this.mBaseDurationMs;
            if (j3 <= j17 || j17 == -1) {
                if (j3 > j16 && j16 != -1) {
                    throw new IllegalArgumentException("loopStartPosition error, must less than loopEndPositionMs");
                }
                this.mIsLoopback = z16;
                this.mLoopStartPositionMs = j3;
                this.mLoopEndPositionMs = j16;
                this.mMediaPlayer.setLooping(z16);
                return;
            }
        }
        throw new IllegalArgumentException("loopStartPosition error, must more than 0 and less than duration");
    }

    private void innerSetDataSource(@NonNull TPUrlMediaAsset tPUrlMediaAsset) throws IllegalArgumentException, IllegalStateException {
        if (!TextUtils.isEmpty(tPUrlMediaAsset.getSystemMediaPlayerUrl())) {
            addTokenToHttpHeaderIfNeeded(tPUrlMediaAsset);
            TPLogUtil.i(this.mTPContext.getLogTag(), "setDataSource, url:" + tPUrlMediaAsset.getSystemMediaPlayerUrl() + ", httpHeader:" + tPUrlMediaAsset.getHttpHeader());
            try {
                this.mMediaPlayer.setDataSource(this.mTPContext.getAppContext(), Uri.parse(tPUrlMediaAsset.getSystemMediaPlayerUrl()), tPUrlMediaAsset.getHttpHeader());
                return;
            } catch (IOException e16) {
                throw new IllegalArgumentException(e16);
            } catch (SecurityException e17) {
                throw new IllegalArgumentException(e17);
            }
        }
        TPLogUtil.i(this.mTPContext.getLogTag(), "setDataSource, androidMediaPlayerUrl is empty");
        throw new IllegalArgumentException("setDataSource, url is empty");
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        switchDataSourceAsync(iTPMediaAsset, i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, long j3) throws IllegalStateException, IllegalArgumentException {
        switchDataSourceAsync(iTPMediaAsset, j3);
    }

    private void innerSetDataSource(@NonNull TPPfdMediaAsset tPPfdMediaAsset) throws IllegalArgumentException, IllegalStateException {
        if (tPPfdMediaAsset.getParcelFileDescriptor() != null) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "setDataSource, pfd:" + tPPfdMediaAsset.getParcelFileDescriptor());
            try {
                this.mMediaPlayer.setDataSource(tPPfdMediaAsset.getParcelFileDescriptor().getFileDescriptor());
                return;
            } catch (IOException e16) {
                throw new IllegalArgumentException(e16);
            }
        }
        TPLogUtil.i(this.mTPContext.getLogTag(), "setDataSource, pfd is null");
        throw new IllegalArgumentException("setDataSource, pfd is null");
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void pauseDownload() throws IllegalStateException {
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void resumeDownload() {
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setAudioNormalizeVolumeParams(String str) {
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setIsActive(boolean z16) {
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnAudioFrameOutListener(ITPPlayerListener.IOnAudioFrameOutListener iOnAudioFrameOutListener) {
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnAudioProcessFrameOutListener(ITPPlayerListener.IOnAudioProcessFrameOutListener iOnAudioProcessFrameOutListener) {
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnDebugTrackingInfoListener(ITPPlayerListener.IOnDebugTrackingInfoListener iOnDebugTrackingInfoListener) {
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public void setOnEventRecordListener(ITPInnerPlayerListener.IOnEventRecordListener iOnEventRecordListener) {
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener) {
    }

    private void innerSetDataSource(@NonNull TPAfdMediaAsset tPAfdMediaAsset) throws IllegalArgumentException, IllegalStateException {
        if (tPAfdMediaAsset.getAssetFileDescriptor() != null) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "setDataSource, afd:" + tPAfdMediaAsset.getAssetFileDescriptor());
            try {
                AssetFileDescriptor assetFileDescriptor = tPAfdMediaAsset.getAssetFileDescriptor();
                if (Build.VERSION.SDK_INT >= 24) {
                    this.mMediaPlayer.setDataSource(assetFileDescriptor);
                    return;
                } else {
                    this.mMediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                    return;
                }
            } catch (IOException e16) {
                throw new IllegalArgumentException(e16);
            }
        }
        TPLogUtil.i(this.mTPContext.getLogTag(), "setDataSource afd is null");
        throw new IllegalArgumentException("afd is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class InnerPlayerListener implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnBufferingUpdateListener {
        InnerPlayerListener() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (TPSystemMediaPlayer.this.mIsLive) {
                TPLogUtil.w(TPSystemMediaPlayer.this.mTPContext.getLogTag(), "onCompletion unknown err, current is live playing.");
                return;
            }
            TPLogUtil.i(TPSystemMediaPlayer.this.mTPContext.getLogTag(), "onCompletion.");
            TPSystemMediaPlayer.this.mMediaPlayerState.changeToState(6);
            TPSystemMediaPlayer.this.destroyCheckBuffingTimer();
            ITPPlayerListener.IOnCompletionListener iOnCompletionListener = TPSystemMediaPlayer.this.mOnCompletionListener;
            if (iOnCompletionListener != null) {
                iOnCompletionListener.onCompletion(TPSystemMediaPlayer.this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x009f, code lost:
        
            if (r7 == 100) goto L17;
         */
        @Override // android.media.MediaPlayer.OnErrorListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            if (TPSystemMediaPlayer.this.mState.isInStates(6, 8, 10, 0, 9)) {
                TPLogUtil.i(TPSystemMediaPlayer.this.mTPContext.getLogTag(), "onError, illegal state:" + TPSystemMediaPlayer.this.mState + ", what:" + i3 + ", extra:" + i16);
                return true;
            }
            TPLogUtil.i(TPSystemMediaPlayer.this.mTPContext.getLogTag(), "onError, what: " + i3 + ", extra: " + i16);
            TPSystemMediaPlayer.this.destroyCheckPrepareTimeoutTimer();
            TPSystemMediaPlayer.this.destroyCheckBuffingTimer();
            TPSystemMediaPlayer.this.mState.changeToState(9);
            int i17 = 2000;
            if (i16 != -1010 && i16 != -1007) {
                if (i16 != -110) {
                    switch (i16) {
                        default:
                            if (i3 != 1) {
                                break;
                            }
                            break;
                        case -1005:
                        case -1004:
                        case -1003:
                            i17 = 2001;
                            break;
                    }
                }
                i17 = 2001;
            }
            TPSystemMediaPlayer.this.mediaPlayerStopAndReset();
            ITPPlayerListener.IOnErrorListener iOnErrorListener = TPSystemMediaPlayer.this.mOnErrorListener;
            if (iOnErrorListener != null) {
                iOnErrorListener.onError(TPSystemMediaPlayer.this, new TPError(i17, TPSystemMediaPlayer.formatErrorCode(i3), TPSystemMediaPlayer.this.getCurrentPositionMs()));
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i16) {
            int i17;
            TPLogUtil.i(TPSystemMediaPlayer.this.mTPContext.getLogTag(), "androidMediaPlayer onInfo, what:" + i3 + ", extra:" + i16);
            if (i3 != 3) {
                if (i3 == 801) {
                    TPSystemMediaPlayer.this.mIsSeekable = false;
                } else if (i3 != 701) {
                    if (i3 == 702) {
                        i17 = 201;
                    }
                } else {
                    i17 = 200;
                }
                i17 = -1;
            } else {
                i17 = 106;
            }
            ITPPlayerListener.IOnInfoListener iOnInfoListener = TPSystemMediaPlayer.this.mOnInfoListener;
            if (i17 != -1) {
                if (200 != i17 && 201 != i17) {
                    if (iOnInfoListener != null) {
                        iOnInfoListener.onInfo(TPSystemMediaPlayer.this, i17, null);
                    }
                } else if (!TPSystemMediaPlayer.this.isAllowCheckBufferByPosition()) {
                    if (200 == i17) {
                        TPSystemMediaPlayer.this.mIsBuffering = true;
                        TPSystemMediaPlayer.this.startCheckBufferTimeOutByInfo();
                    } else {
                        TPSystemMediaPlayer.this.mIsBuffering = false;
                        TPSystemMediaPlayer.this.destroyCheckBufferTimeOutByInfo();
                    }
                    if (iOnInfoListener != null) {
                        iOnInfoListener.onInfo(TPSystemMediaPlayer.this, i17, null);
                    }
                }
            }
            if (i17 == 106) {
                TPSystemMediaPlayer.this.changeVideoWidthHeight(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (!TPSystemMediaPlayer.this.mState.isInStates(2)) {
                TPLogUtil.i(TPSystemMediaPlayer.this.mTPContext.getLogTag(), "onPrepared is called in error situation, state:" + TPSystemMediaPlayer.this.mState);
                return;
            }
            TPSystemMediaPlayer.this.mMediaPlayerState.changeToState(3);
            long duration = TPSystemMediaPlayer.this.mMediaPlayer.getDuration();
            if (duration <= 0) {
                TPSystemMediaPlayer.this.mIsSeekable = false;
            } else {
                TPSystemMediaPlayer.this.mBaseDurationMs = duration;
            }
            TPLogUtil.i(TPSystemMediaPlayer.this.mTPContext.getLogTag(), "onPrepared, mStartPositionMs:" + TPSystemMediaPlayer.this.mStartPositionMs + ", durationMs:" + duration + ", isLive:" + TPSystemMediaPlayer.this.mIsLive);
            TPSystemMediaPlayer.this.destroyCheckPrepareTimeoutTimer();
            TPSystemMediaPlayer.this.playerResetEnd();
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (TPSystemMediaPlayer.this.mMediaPlayer == null) {
                return;
            }
            TPLogUtil.i(TPSystemMediaPlayer.this.mTPContext.getLogTag(), "onSeekComplete");
            if (TPSystemMediaPlayer.this.mState.isInStates(4) && TPSystemMediaPlayer.this.mMediaPlayerState.isInStates(6)) {
                TPSystemMediaPlayer.this.mState.changeToState(4);
                TPSystemMediaPlayer.this.mMediaPlayerState.changeToState(4);
                TPSystemMediaPlayer.this.mMediaPlayer.start();
            }
            ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener = TPSystemMediaPlayer.this.mOnSeekCompleteListener;
            if (!TPSystemMediaPlayer.this.mState.isInStates(3) && iOnSeekCompleteListener != null) {
                TPSystemMediaPlayer tPSystemMediaPlayer = TPSystemMediaPlayer.this;
                iOnSeekCompleteListener.onSeekComplete(tPSystemMediaPlayer, tPSystemMediaPlayer.mSeekOpaque);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i16) {
            TPSystemMediaPlayer.this.changeVideoWidthHeight(i3, i16);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void reopenPlayer(int i3, boolean z16) {
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAndSelectTrackAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, int[] iArr, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
    }
}
