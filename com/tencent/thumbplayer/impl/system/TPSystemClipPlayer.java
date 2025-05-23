package com.tencent.thumbplayer.impl.system;

import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import com.tencent.thumbplayer.api.player.ITPPlayerListener;
import com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.v2.ITPReportExtendedController;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotParams;
import com.tencent.thumbplayer.asset.TPMultiMediaAsset;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.TPDynamicStatisticParams;
import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.datatransport.play.ITPPlayRemuxer;
import com.tencent.thumbplayer.impl.ITPInnerPlayer;
import com.tencent.thumbplayer.impl.ITPInnerPlayerListener;
import com.tencent.thumbplayer.impl.TPInnerPlayerListeners;
import com.tencent.thumbplayer.tpplayer.TPPlayerStateMgr;
import com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPSystemClipPlayer implements ITPInnerPlayer {
    private static final String TAG = "TPSystemClipPlayer";
    private ITPMediaAsset mCurrentMediaAsset;
    private boolean mIsLoopback;
    private boolean mIsSwitchingDef;
    private ITPInnerPlayer mPlayerBase;
    private final TPInnerPlayerListeners mPlayerListeners;
    private final TPPlayerStateMgr mPlayerState;
    private final TPContext mTPContext;
    private final List<Long> mClipDurationMsList = new ArrayList();
    private final List<Long> mClipStartPositionMsList = new ArrayList();
    private final List<ITPMediaAsset> mClipList = new ArrayList();
    private int mCurrentClipIndex = 0;
    private LinkedList<Long> mSwitchingDefTagQueue = new LinkedList<>();
    private Object mSurfaceObj = null;
    private final Map<String, TPOptionalParam<?>> mOptionalParamMap = new HashMap();
    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    private boolean mIsAudioMute = false;
    private float mAudioVolume = 1.0f;
    private float mSpeedRatio = 1.0f;
    private long mLoopStartPositionMs = 0;
    private long mLoopEndPositionMs = -1;
    private final TPPlayerBaseListeners mPlayerBaseListeners = new TPPlayerBaseListeners();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class TPPlayerBaseListeners implements ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnVideoSizeChangedListener, ITPPlayerListener.IOnSubtitleDataOutListener, ITPPlayerListener.IOnSnapshotListener {
        TPPlayerBaseListeners() {
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnCompletionListener
        public void onCompletion(ITPPlayer iTPPlayer) {
            ReportThumbPlayer.getInstance().onCompletion(iTPPlayer);
            TPSystemClipPlayer.this.handleOnComplete();
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnErrorListener
        public void onError(ITPPlayer iTPPlayer, @NonNull TPError tPError) {
            ReportThumbPlayer.getInstance().onError(iTPPlayer, tPError);
            TPSystemClipPlayer.this.handleOnError(tPError);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnInfoListener
        public void onInfo(ITPPlayer iTPPlayer, int i3, TPOnInfoParam tPOnInfoParam) {
            ReportThumbPlayer.getInstance().onInfo(iTPPlayer, i3, tPOnInfoParam);
            TPSystemClipPlayer.this.handleOnInfo(i3, tPOnInfoParam);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnPreparedListener
        public void onPrepared(ITPPlayer iTPPlayer) {
            ReportThumbPlayer.getInstance().onPrepared(iTPPlayer);
            TPSystemClipPlayer.this.handleOnPrepared();
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSeekCompleteListener
        public void onSeekComplete(ITPPlayer iTPPlayer, long j3) {
            TPSystemClipPlayer.this.handleOnSeekComplete(j3);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSnapshotListener
        public void onSnapshotFailed(ITPPlayer iTPPlayer, long j3, @NonNull TPError tPError) {
            TPSystemClipPlayer.this.mPlayerListeners.onSnapshotFailed(TPSystemClipPlayer.this, j3, tPError);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSnapshotListener
        public void onSnapshotSuccess(ITPPlayer iTPPlayer, long j3, long j16, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer) {
            TPSystemClipPlayer.this.mPlayerListeners.onSnapshotSuccess(TPSystemClipPlayer.this, j3, j16, tPVideoFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSubtitleDataOutListener
        public void onSubtitleDataOut(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
            TPSystemClipPlayer.this.handleOnSubtitleData(tPSubtitleData);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnVideoSizeChangedListener
        public void onVideoSizeChanged(ITPPlayer iTPPlayer, int i3, int i16) {
            TPSystemClipPlayer.this.handleOnVideoSizeChange(i3, i16);
        }
    }

    public TPSystemClipPlayer(@NonNull TPContext tPContext) {
        this.mTPContext = tPContext;
        this.mPlayerBase = new TPSystemMediaPlayer(tPContext);
        this.mPlayerState = new TPPlayerStateMgr(tPContext);
        this.mPlayerListeners = new TPInnerPlayerListeners(tPContext.getLogTag());
        setListenersToPlayerBase();
    }

    private ITPMediaAsset getCurrentClipAsset() {
        return this.mClipList.get(this.mCurrentClipIndex);
    }

    private long getCurrentClipDurationMs() {
        return this.mClipDurationMsList.get(this.mCurrentClipIndex).longValue();
    }

    private long getCurrentClipStartPositionMs() {
        return this.mClipStartPositionMsList.get(this.mCurrentClipIndex).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnComplete() {
        TPInnerPlayerListeners tPInnerPlayerListeners;
        if (!this.mPlayerState.isInStates(3, 4, 5)) {
            return;
        }
        if (isMultiMediaAsset(this.mCurrentMediaAsset) && (tPInnerPlayerListeners = this.mPlayerListeners) != null) {
            tPInnerPlayerListeners.onInfo(this, 153, new TPOnInfoParam.Builder().setLongParam(this.mCurrentClipIndex).build());
        }
        if (this.mCurrentClipIndex >= this.mClipList.size() - 1) {
            this.mPlayerState.changeToState(6);
            this.mPlayerListeners.onCompletion(this);
            return;
        }
        try {
            switchPlayer(this.mCurrentClipIndex + 1, 0L);
        } catch (IOException e16) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "handleOnComplete:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnError(TPError tPError) {
        if (!this.mPlayerState.isInStates(1, 2, 3, 4, 5)) {
            return;
        }
        this.mPlayerListeners.onError(this, tPError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnInfo(int i3, TPOnInfoParam tPOnInfoParam) {
        if (!this.mPlayerState.isInStates(2, 3, 4, 5)) {
            return;
        }
        this.mPlayerListeners.onInfo(this, i3, tPOnInfoParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnPrepared() {
        TPInnerPlayerListeners tPInnerPlayerListeners = this.mPlayerListeners;
        if (tPInnerPlayerListeners != null) {
            tPInnerPlayerListeners.onInfo(this, 152, new TPOnInfoParam.Builder().setLongParam(this.mCurrentClipIndex).build());
        }
        if (isMultiMediaAsset(this.mCurrentMediaAsset) && this.mPlayerState.getCurrentState() != 2) {
            start();
            if (this.mIsSwitchingDef && this.mPlayerListeners != null && !this.mSwitchingDefTagQueue.isEmpty()) {
                Long poll = this.mSwitchingDefTagQueue.poll();
                if (poll != null) {
                    this.mPlayerListeners.onInfo(this, 3, new TPOnInfoParam.Builder().setLongParam(poll.longValue()).build());
                }
                this.mIsSwitchingDef = false;
                return;
            }
            return;
        }
        if (!this.mPlayerState.isInStates(2)) {
            return;
        }
        this.mPlayerState.changeToState(3);
        TPInnerPlayerListeners tPInnerPlayerListeners2 = this.mPlayerListeners;
        if (tPInnerPlayerListeners2 != null) {
            tPInnerPlayerListeners2.onPrepared(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnSeekComplete(long j3) {
        if (!this.mPlayerState.isInStates(3, 4, 5)) {
            return;
        }
        if (this.mPlayerState.isInStates(6)) {
            start();
        }
        this.mPlayerListeners.onSeekComplete(this, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnSubtitleData(TPSubtitleData tPSubtitleData) {
        if (this.mPlayerState.isInStates(0, 1, 10, 9)) {
            return;
        }
        this.mPlayerListeners.onSubtitleDataOut(this, tPSubtitleData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnVideoSizeChange(int i3, int i16) {
        if (!this.mPlayerState.isInStates(2, 3, 4, 5)) {
            return;
        }
        this.mVideoHeight = i16;
        this.mVideoWidth = i3;
        this.mPlayerListeners.onVideoSizeChanged(this, i3, i16);
    }

    private void initClipListByAsset(@NonNull ITPMediaAsset iTPMediaAsset) throws IllegalArgumentException {
        resetClipParams();
        long j3 = 0;
        if (isMultiMediaAsset(iTPMediaAsset)) {
            for (Pair<ITPMediaAsset, Long> pair : ((TPMultiMediaAsset) iTPMediaAsset).getAssetAndClipDurationMsPairList()) {
                this.mClipList.add(pair.first);
                this.mClipDurationMsList.add(pair.second);
            }
            if (!this.mClipList.isEmpty() && !this.mClipDurationMsList.isEmpty()) {
                for (int i3 = 0; i3 < this.mClipList.size(); i3++) {
                    this.mClipStartPositionMsList.add(Long.valueOf(j3));
                    j3 += this.mClipDurationMsList.get(i3).longValue();
                }
                return;
            }
            throw new IllegalArgumentException("system clipMediaPlayer : clipList or clipDurationList is empty");
        }
        this.mClipList.add(iTPMediaAsset);
        this.mClipDurationMsList.add(Long.MAX_VALUE);
        this.mClipStartPositionMsList.add(0L);
    }

    private boolean isMultiMediaAsset(ITPMediaAsset iTPMediaAsset) {
        if (iTPMediaAsset != null && iTPMediaAsset.getAssetType() == 6) {
            return true;
        }
        return false;
    }

    private boolean isSystemPlayableAsset(ITPMediaAsset iTPMediaAsset) {
        if (iTPMediaAsset == null || !iTPMediaAsset.isValid()) {
            return false;
        }
        if (iTPMediaAsset.getAssetType() != 6 && iTPMediaAsset.getAssetType() != 3 && iTPMediaAsset.getAssetType() != 2 && iTPMediaAsset.getAssetType() != 1 && iTPMediaAsset.getAssetType() != 8) {
            return false;
        }
        return true;
    }

    private void resetAllParams() {
        this.mSurfaceObj = null;
        this.mCurrentMediaAsset = null;
        this.mCurrentClipIndex = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mIsAudioMute = false;
        this.mAudioVolume = 1.0f;
        this.mSpeedRatio = 1.0f;
        this.mIsLoopback = false;
        this.mLoopStartPositionMs = 0L;
        this.mLoopEndPositionMs = -1L;
        this.mOptionalParamMap.clear();
        this.mClipDurationMsList.clear();
        this.mClipStartPositionMsList.clear();
        this.mClipList.clear();
        this.mIsSwitchingDef = false;
        this.mSwitchingDefTagQueue.clear();
    }

    private void resetClipParams() {
        this.mClipList.clear();
        this.mClipDurationMsList.clear();
        this.mClipStartPositionMsList.clear();
    }

    private void selectClipPlayer(long j3) {
        for (int i3 = 0; i3 < this.mClipList.size(); i3++) {
            if (this.mClipStartPositionMsList.get(i3).longValue() <= j3 && j3 <= this.mClipStartPositionMsList.get(i3).longValue() + this.mClipDurationMsList.get(i3).longValue()) {
                try {
                    switchPlayer(i3, j3 - this.mClipStartPositionMsList.get(i3).longValue());
                } catch (IOException e16) {
                    TPLogUtil.i(this.mTPContext.getLogTag(), "selectClipPlayer:" + e16);
                }
            }
        }
    }

    private void setListenersToPlayerBase() {
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer == null) {
            return;
        }
        iTPInnerPlayer.setOnInfoListener(this.mPlayerBaseListeners);
        this.mPlayerBase.setOnPreparedListener(this.mPlayerBaseListeners);
        this.mPlayerBase.setOnCompletionListener(this.mPlayerBaseListeners);
        this.mPlayerBase.setOnErrorListener(this.mPlayerBaseListeners);
        this.mPlayerBase.setOnSeekCompleteListener(this.mPlayerBaseListeners);
        this.mPlayerBase.setOnVideoSizeChangedListener(this.mPlayerBaseListeners);
        this.mPlayerBase.setOnSubtitleDataOutListener(this.mPlayerBaseListeners);
        this.mPlayerBase.setOnSnapshotListener(this.mPlayerBaseListeners);
    }

    private void setPlayerParamBeforePrepare(ITPInnerPlayer iTPInnerPlayer, long j3) {
        ITPMediaAsset currentClipAsset = getCurrentClipAsset();
        if (currentClipAsset.getAssetType() == 2 || currentClipAsset.getAssetType() == 1 || currentClipAsset.getAssetType() == 3 || currentClipAsset.getAssetType() == 8) {
            iTPInnerPlayer.setDataSource(currentClipAsset);
        }
        Iterator<Map.Entry<String, TPOptionalParam<?>>> it = this.mOptionalParamMap.entrySet().iterator();
        while (it.hasNext()) {
            iTPInnerPlayer.addOptionalParam(it.next().getValue());
        }
        iTPInnerPlayer.addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_START_PLAYING_TIME_MS, j3));
        iTPInnerPlayer.setLoopback(this.mIsLoopback, this.mLoopStartPositionMs, this.mLoopEndPositionMs);
        iTPInnerPlayer.setAudioMute(this.mIsAudioMute);
        iTPInnerPlayer.setAudioVolume(this.mAudioVolume);
        iTPInnerPlayer.setPlaySpeedRatio(this.mSpeedRatio);
        Object obj = this.mSurfaceObj;
        if (obj instanceof SurfaceHolder) {
            iTPInnerPlayer.setSurfaceHolder((SurfaceHolder) obj);
        } else if (obj instanceof Surface) {
            iTPInnerPlayer.setSurface((Surface) obj);
        }
    }

    private void switchPlayer(int i3, long j3) throws IOException {
        TPLogUtil.d(this.mTPContext.getLogTag(), "switchPlayer, clipNo:" + i3 + ", startPositionMs:" + j3);
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.release();
            this.mPlayerBase = null;
        }
        this.mCurrentClipIndex = i3;
        this.mPlayerBase = new TPSystemMediaPlayer(this.mTPContext);
        setListenersToPlayerBase();
        setPlayerParamBeforePrepare(this.mPlayerBase, j3);
        this.mPlayerBase.prepareAsync();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void addAudioTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException {
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.addAudioTrackSource(iTPMediaAsset, str);
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void addOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) throws IllegalStateException {
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.addOptionalParam(tPOptionalParam);
        }
        this.mOptionalParamMap.put(tPOptionalParam.getKey(), tPOptionalParam);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void addPlugin(ITPPluginBase iTPPluginBase) {
        com.tencent.thumbplayer.api.player.a.a(this, iTPPluginBase);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void addSubtitleTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException {
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.addSubtitleTrackSource(iTPMediaAsset, str);
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
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer == null) {
            return -1L;
        }
        return iTPInnerPlayer.getAvailablePositionMs();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public long getCurrentPositionMs() {
        long j3 = 0;
        for (int i3 = 0; i3 < this.mClipList.size() && i3 < this.mCurrentClipIndex; i3++) {
            j3 += this.mClipDurationMsList.get(i3).longValue();
        }
        if (this.mPlayerState.isInStates(9, 10)) {
            return j3;
        }
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            return j3 + iTPInnerPlayer.getCurrentPositionMs();
        }
        return -1L;
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
        if (!isMultiMediaAsset(this.mCurrentMediaAsset)) {
            ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
            if (iTPInnerPlayer != null) {
                return iTPInnerPlayer.getDurationMs();
            }
            return -1L;
        }
        Iterator<Long> it = this.mClipDurationMsList.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += it.next().longValue();
        }
        return j3;
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
        int i3 = this.mVideoHeight;
        if (i3 > 0) {
            return i3;
        }
        if (this.mPlayerState.isInStates(10, 9)) {
            return 0;
        }
        int height = this.mPlayerBase.getHeight();
        this.mVideoHeight = height;
        return height;
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
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            return iTPInnerPlayer.getProperty(str);
        }
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

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public TPTrackInfo[] getTrackInfo() {
        ITPInnerPlayer iTPInnerPlayer;
        if (isMultiMediaAsset(this.mCurrentMediaAsset) || (iTPInnerPlayer = this.mPlayerBase) == null) {
            return null;
        }
        return iTPInnerPlayer.getTrackInfo();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public int getWidth() {
        int i3 = this.mVideoWidth;
        if (i3 > 0) {
            return i3;
        }
        if (this.mPlayerState.isInStates(10, 9)) {
            return 0;
        }
        int width = this.mPlayerBase.getWidth();
        this.mVideoWidth = width;
        return width;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void pause() throws IllegalStateException {
        if (!this.mPlayerState.isInStates(4, 5)) {
            return;
        }
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            try {
                iTPInnerPlayer.pause();
                this.mPlayerState.changeToState(5);
                return;
            } catch (IllegalStateException unused) {
                throw new IllegalStateException("pause error, state invalid");
            }
        }
        throw new IllegalStateException("pause error, player is null");
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void prepareAsync() throws IllegalStateException {
        if (!this.mPlayerState.isInStates(1, 7, 8)) {
            return;
        }
        long j3 = 0;
        for (Map.Entry<String, TPOptionalParam<?>> entry : this.mOptionalParamMap.entrySet()) {
            if (entry.getKey().equals(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_START_PLAYING_TIME_MS)) {
                long longValue = ((Long) entry.getValue().getValue()).longValue();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.mClipList.size()) {
                        break;
                    }
                    if (this.mClipStartPositionMsList.get(i3).longValue() <= longValue && longValue <= this.mClipStartPositionMsList.get(i3).longValue() + this.mClipDurationMsList.get(i3).longValue()) {
                        this.mCurrentClipIndex = i3;
                        break;
                    }
                    i3++;
                }
                j3 = longValue - this.mClipStartPositionMsList.get(this.mCurrentClipIndex).longValue();
            }
        }
        setPlayerParamBeforePrepare(this.mPlayerBase, j3);
        this.mPlayerState.changeToState(2);
        this.mPlayerBase.prepareAsync();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void release() {
        TPLogUtil.i(this.mTPContext.getLogTag(), "release, current state:" + this.mPlayerState);
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.release();
            this.mPlayerBase = null;
        }
        resetAllParams();
        this.mPlayerListeners.clear();
        this.mPlayerState.changeToState(10);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void removeTrack(int i3) throws IllegalArgumentException {
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.removeTrack(i3);
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void reset() {
        TPLogUtil.i(this.mTPContext.getLogTag(), "reset, current state:" + this.mPlayerState);
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.reset();
        }
        resetAllParams();
        this.mPlayerState.changeToState(0);
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
        if (this.mPlayerState.isInStates(9, 10)) {
            return;
        }
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.setAudioMute(z16);
        }
        this.mIsAudioMute = z16;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setAudioVolume(float f16) {
        if (this.mPlayerState.isInStates(9, 10)) {
            return;
        }
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.setAudioVolume(f16);
        }
        this.mAudioVolume = f16;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19) {
        com.tencent.thumbplayer.api.player.a.c(this, i3, i16, i17, i18, i19);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setDataSource(@NonNull ITPMediaAsset iTPMediaAsset) throws IllegalArgumentException, IllegalStateException {
        if (isSystemPlayableAsset(iTPMediaAsset)) {
            initClipListByAsset(iTPMediaAsset);
            try {
                this.mCurrentMediaAsset = iTPMediaAsset;
                this.mPlayerState.changeToState(1);
                ReportThumbPlayer.getInstance().setDataSource(this, iTPMediaAsset);
                return;
            } catch (Exception e16) {
                TPLogUtil.e(this.mTPContext.getLogTag(), e16);
                throw new IllegalStateException("exception when system clip player set data source!");
            }
        }
        throw new IllegalArgumentException("system media player can not play mediaAsset: " + iTPMediaAsset);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public void setLogTagPrefix(String str) {
        this.mPlayerListeners.updateTag(this.mTPContext.getLogTag());
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setLoopback(boolean z16) {
        if (this.mPlayerState.isInStates(9, 10)) {
            return;
        }
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.setLoopback(z16);
        }
        this.mIsLoopback = z16;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener iOnCompletionListener) {
        this.mPlayerListeners.setOnCompletionListener(iOnCompletionListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnErrorListener(ITPPlayerListener.IOnErrorListener iOnErrorListener) {
        this.mPlayerListeners.setOnErrorListener(iOnErrorListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setOnGetRemainTimeBeforePlayListener(ITPPlayerListener.IOnGetRemainTimeBeforePlayListener iOnGetRemainTimeBeforePlayListener) {
        com.tencent.thumbplayer.impl.a.e(this, iOnGetRemainTimeBeforePlayListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnInfoListener(ITPPlayerListener.IOnInfoListener iOnInfoListener) {
        this.mPlayerListeners.setOnInfoListener(iOnInfoListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setOnMediaAssetExpireListener(ITPPlayerListener.IOnMediaAssetExpireListener iOnMediaAssetExpireListener) {
        com.tencent.thumbplayer.impl.a.f(this, iOnMediaAssetExpireListener);
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
        this.mPlayerListeners.setOnSubtitleDataOutListener(iOnSubtitleDataOutListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener) {
        this.mPlayerListeners.setOnVideoSizeChangedListener(iOnVideoSizeChangedListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public void setPlayRemuxer(ITPPlayRemuxer iTPPlayRemuxer) {
        this.mPlayerBase.setPlayRemuxer(iTPPlayRemuxer);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setPlaySpeedRatio(float f16) {
        if (this.mPlayerState.isInStates(9, 10)) {
            return;
        }
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.setPlaySpeedRatio(f16);
        }
        this.mSpeedRatio = f16;
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setRichMediaSynchronizer(ITPRichMediaSynchronizer iTPRichMediaSynchronizer) {
        com.tencent.thumbplayer.impl.a.i(this, iTPRichMediaSynchronizer);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setSurface(Surface surface) throws IllegalStateException {
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.setSurface(surface);
        }
        this.mSurfaceObj = surface;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) throws IllegalStateException {
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.setSurfaceHolder(surfaceHolder);
        }
        this.mSurfaceObj = surfaceHolder;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void snapshotAsync(TPSnapshotParams tPSnapshotParams) throws IllegalStateException {
        snapshotAsync(tPSnapshotParams, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void start() throws IllegalStateException {
        long j3;
        if (!this.mPlayerState.isInStates(3, 4, 5, 6)) {
            return;
        }
        if (this.mPlayerBase != null) {
            if (this.mPlayerState.getCurrentState() == 6) {
                int i3 = 0;
                if (this.mOptionalParamMap.containsKey(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_START_PLAYING_TIME_MS)) {
                    long longValue = ((Long) this.mOptionalParamMap.get(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_START_PLAYING_TIME_MS).getValue()).longValue();
                    int i16 = 0;
                    while (true) {
                        if (i16 < this.mClipList.size()) {
                            if (this.mClipStartPositionMsList.get(i16).longValue() <= longValue && longValue <= this.mClipStartPositionMsList.get(i16).longValue() + this.mClipDurationMsList.get(i16).longValue()) {
                                i3 = i16;
                                break;
                            }
                            i16++;
                        } else {
                            break;
                        }
                    }
                    j3 = longValue - this.mClipStartPositionMsList.get(i3).longValue();
                } else {
                    j3 = 0;
                }
                try {
                    switchPlayer(i3, j3);
                    this.mPlayerState.changeToState(4);
                    return;
                } catch (IOException e16) {
                    TPLogUtil.i(this.mTPContext.getLogTag(), "start:" + e16);
                    return;
                }
            }
            try {
                this.mPlayerBase.start();
                this.mPlayerState.changeToState(4);
                return;
            } catch (IllegalStateException unused) {
                throw new IllegalStateException("start error, state invalid");
            }
        }
        throw new IllegalStateException("start error, player is null");
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void stop() throws IllegalStateException {
        if (this.mPlayerState.isInStates(0, 1, 9, 10)) {
            return;
        }
        if (this.mPlayerBase != null) {
            try {
                try {
                    this.mPlayerState.changeToState(7);
                    this.mPlayerBase.stop();
                    return;
                } catch (IllegalStateException unused) {
                    throw new IllegalStateException("stop error, state invalid");
                }
            } finally {
                this.mPlayerState.changeToState(8);
            }
        }
        throw new IllegalStateException("stop error, player is null");
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
    public void deselectTrackAsync(int i3, long j3) {
        ITPInnerPlayer iTPInnerPlayer;
        if (isMultiMediaAsset(this.mCurrentMediaAsset) || (iTPInnerPlayer = this.mPlayerBase) == null) {
            return;
        }
        iTPInnerPlayer.deselectTrackAsync(i3, j3);
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
        ITPInnerPlayer iTPInnerPlayer;
        if (isMultiMediaAsset(this.mCurrentMediaAsset) || (iTPInnerPlayer = this.mPlayerBase) == null) {
            return;
        }
        iTPInnerPlayer.selectTrackAsync(i3, j3);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void snapshotAsync(TPSnapshotParams tPSnapshotParams, long j3) throws IllegalStateException {
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.snapshotAsync(tPSnapshotParams, j3);
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, long j3) throws IllegalStateException {
        if (isSystemPlayableAsset(iTPMediaAsset)) {
            initClipListByAsset(iTPMediaAsset);
            this.mCurrentMediaAsset = iTPMediaAsset;
            if (!isMultiMediaAsset(iTPMediaAsset)) {
                ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
                if (iTPInnerPlayer != null) {
                    iTPInnerPlayer.switchDataSourceAsync(iTPMediaAsset, j3);
                    return;
                }
                return;
            }
            try {
                this.mIsSwitchingDef = true;
                this.mSwitchingDefTagQueue.offer(Long.valueOf(j3));
                TPLogUtil.i(this.mTPContext.getLogTag(), "try to switch definition with system clip player, current clipNo:" + this.mCurrentClipIndex);
                selectClipPlayer((long) ((int) getCurrentPositionMs()));
                return;
            } catch (Exception e16) {
                TPLogUtil.e(this.mTPContext.getLogTag(), e16);
                throw new IllegalStateException("exception when system clip player switch definition!");
            }
        }
        throw new IllegalArgumentException("system media player can not play mediaAsset: " + iTPMediaAsset);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void seekToAsync(long j3, int i3) throws IllegalStateException {
        seekToAsync(j3, i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void seekToAsync(long j3, int i3, long j16) throws IllegalStateException {
        if (this.mPlayerState.isInStates(3, 4, 5, 6)) {
            if (j3 >= getCurrentClipStartPositionMs() && j3 <= getCurrentClipStartPositionMs() + getCurrentClipDurationMs()) {
                if (this.mPlayerBase != null) {
                    TPLogUtil.d(this.mTPContext.getLogTag(), "seek to positionMs:" + j3 + ", mode:" + i3 + ", opaque:" + j16);
                    this.mPlayerBase.seekToAsync((long) ((int) (j3 - getCurrentClipStartPositionMs())), i3, j16);
                    return;
                }
                return;
            }
            selectClipPlayer(j3);
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setLoopback(boolean z16, long j3, long j16) throws IllegalStateException {
        if (this.mPlayerState.isInStates(9, 10)) {
            return;
        }
        ITPInnerPlayer iTPInnerPlayer = this.mPlayerBase;
        if (iTPInnerPlayer != null) {
            iTPInnerPlayer.setLoopback(z16, j3, j16);
        }
        this.mIsLoopback = z16;
        this.mLoopStartPositionMs = j3;
        this.mLoopEndPositionMs = j16;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        switchDataSourceAsync(iTPMediaAsset, i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, long j3) throws IllegalStateException, IllegalArgumentException {
        switchDataSourceAsync(iTPMediaAsset, j3);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void pauseDownload() {
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

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void reopenPlayer(int i3, boolean z16) {
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAndSelectTrackAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, int[] iArr, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
    }
}
