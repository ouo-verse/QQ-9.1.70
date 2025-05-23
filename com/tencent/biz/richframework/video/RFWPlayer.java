package com.tencent.biz.richframework.video;

import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.avbiz.Constants;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.video.QUICStatus;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.video.IPlayer;
import com.tencent.richframework.video.IPlayerStateCallback;
import com.tencent.richframework.video.MediaInfo;
import com.tencent.richframework.video.RFWPlayerVideoInfo;
import com.tencent.richframework.video.SwitchUrlType;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class RFWPlayer implements IPlayer, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnCompletionListener {
    private static long mLastDownloadAvgSpeed;
    public static String sIsSupportHEVC = QMMKV.from(RFWApplication.getApplication(), "common_mmkv_configurations").decodeString("key_sp_is_support_hevc", "");
    private long mBufferBeginTime;
    private String mCDNIp;
    private RFWPlayerVideoInfo mCurrentPlayerVideoInfo;
    private SuperPlayerVideoInfo mCurrentVideoInfo;
    private int mDownloadTime;
    private int mDownloadTotalSpeed;
    private boolean mHasDownloadComplete;
    private boolean mHasHitCache;
    private String mIp;
    private boolean mIsLoopback;
    private volatile boolean mIsRelease;
    private boolean mIsSeeking;
    private long mLocalCacheSize;
    private boolean mOutputMute;
    private ISuperPlayer mPlayer;
    private volatile IPlayerStateCallback mPlayerCallback;
    private ISPlayerVideoView mPlayerVideoView;
    private QUICStatus mQUICStatus;
    private RFWMediaFocusManager mRFWMediaFocusManager;
    private long mReportPlayerTime;
    private long mReportRecordPauseTime;
    private int mSecondBufferCount;
    private long mSecondBufferTime;
    private long mStartPlayPositionForReport;
    private long mStartPreparedTime;
    private long mStartSeekTime;
    private long mTimelineAvgSpeedKB;
    private long mTotalFileSize;
    private final boolean mNeedCheckBackgroundState = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("START_CHECK_STATE", true);
    private final boolean mRequestAudio = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("REQUEST_AUDIO", true);
    private final boolean mVideoInfoRequestAudio = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("REQUEST_AUDIO", true);
    private final boolean mSetBusinessDownload = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("SET_BUSINESS_DOWNLOAD", true);
    private final boolean mEnableRestartByVideoInfo = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("ENABLE_START_PLAYER_BY_VIDEO_INFO_AFTER_INIT_SUCCESS", true);
    private boolean mEnablePerfReport = true;
    private boolean mHasDetectedHEVC = false;
    private int mMinDownLoadKbs = 0;
    private int mMaxDownLoadKbs = 0;
    private boolean mHasBufferEnd = false;
    public String mDownloadRetCode = "0";
    private long mVideoPlayId = 0;
    private Stack<Pair<Long, Long>> mVideoSoloPlayTimeRangeList = new Stack<>();
    private float mPlayRate = 1.0f;

    private synchronized void addToVideoSoloPlayTimeRangeList(long j3, long j16) {
        if (!this.mEnablePerfReport) {
            return;
        }
        QLog.d(getTag(), 1, "addToVideoSoloPlayTimeRangeList: [start=" + j3 + ", end=" + j16 + "]");
        Iterator<Pair<Long, Long>> it = this.mVideoSoloPlayTimeRangeList.iterator();
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            if (((Long) next.first).longValue() <= j3 && ((Long) next.second).longValue() >= j16) {
                QLog.d(getTag(), 1, "addToVideoSoloPlayTimeRangeList: already contained [start=" + j3 + ", end=" + j16 + "]");
                return;
            }
        }
        Iterator<Pair<Long, Long>> it5 = this.mVideoSoloPlayTimeRangeList.iterator();
        while (it5.hasNext()) {
            Pair<Long, Long> next2 = it5.next();
            if (j3 <= ((Long) next2.first).longValue() && j16 >= ((Long) next2.second).longValue()) {
                QLog.d(getTag(), 1, "addToVideoSoloPlayTimeRangeList: remove [start=" + next2.first + ", end=" + next2.second + "]");
                it5.remove();
            }
        }
        Iterator<Pair<Long, Long>> it6 = this.mVideoSoloPlayTimeRangeList.iterator();
        while (it6.hasNext()) {
            Pair<Long, Long> next3 = it6.next();
            if (j3 >= ((Long) next3.first).longValue() && j3 <= ((Long) next3.second).longValue()) {
                j3 = ((Long) next3.second).longValue();
            }
            if (j16 >= ((Long) next3.first).longValue() && j16 <= ((Long) next3.second).longValue()) {
                j16 = ((Long) next3.first).longValue();
            }
        }
        if (j3 >= 0 && j3 <= j16) {
            QLog.d(getTag(), 1, "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + j3 + ", end=" + j16 + "]");
            this.mVideoSoloPlayTimeRangeList.add(new Pair<>(Long.valueOf(j3), Long.valueOf(j16)));
            return;
        }
        QLog.d(getTag(), 1, "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + j3 + ", end=" + j16 + "]");
    }

    private void checkIsCompleteCache(String str, String str2) {
        this.mHasDownloadComplete = RFWBaseVideoUtils.checkCacheExist(str2, str);
    }

    private void downloadComplete() {
        this.mHasDownloadComplete = true;
        if (getAverageDownloadSpeeds() == 0) {
            this.mHasHitCache = true;
        } else {
            long averageDownloadSpeeds = getAverageDownloadSpeeds();
            if (averageDownloadSpeeds == 0) {
                averageDownloadSpeeds = this.mTimelineAvgSpeedKB;
            }
            mLastDownloadAvgSpeed = averageDownloadSpeeds;
        }
        if (this.mPlayerCallback != null) {
            this.mPlayerCallback.onDownloadAllFinish();
        }
        QLog.d(getTag(), 1, String.format("DownloadComplete  DownLoadSpeed:%d kb/s", Long.valueOf(getAverageDownloadSpeeds())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureSuperPlayer(Surface surface, int i3) {
        boolean z16;
        if (this.mPlayer == null) {
            MMKVOptionEntity from = QMMKV.from(RFWApplication.getApplication(), "common_mmkv_configurations");
            if (surface == null) {
                this.mPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(RFWApplication.getApplication());
                this.mPlayer = SuperPlayerFactory.createMediaPlayer(RFWApplication.getApplication(), i3, this.mPlayerVideoView);
            } else {
                ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(RFWApplication.getApplication(), i3, null);
                this.mPlayer = createMediaPlayer;
                createMediaPlayer.setSurface(surface);
            }
            this.mPlayer.setOnVideoPreparedListener(this);
            this.mPlayer.setOnErrorListener(this);
            this.mPlayer.setOnInfoListener(this);
            this.mPlayer.setOnCompletionListener(this);
            this.mPlayer.setOnSeekCompleteListener(this);
            this.mPlayer.setOnInfoListener(this);
            if (from.isAccessible()) {
                boolean z17 = !from.decodeString("key_sp_is_detect_hevc", "").equals("");
                this.mHasDetectedHEVC = z17;
                if (!z17) {
                    try {
                        if (com.tencent.superplayer.utils.e.d(172, 102).getMaxFramerateFormaxLumaSamples() > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        sIsSupportHEVC = String.valueOf(z16);
                    } catch (Exception e16) {
                        QLog.e(getTag(), 1, "getThumbPlayerVCodecTypeMaxCapability() error,", e16);
                    }
                    from.encodeString("key_sp_is_detect_hevc", "1");
                    from.encodeString("key_sp_is_support_hevc", sIsSupportHEVC);
                    from.commitAsync();
                    QLog.i(getTag(), 1, "this phone is support hevc");
                }
            }
        }
    }

    private void fixVideoWH(int i3, int i16) {
        ISPlayerVideoView iSPlayerVideoView;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("RFW_PLAYER_ENABLE_FIX_VIDEO_WIDTH_HEIGHT", true) && i3 > 0 && i16 > 0 && (iSPlayerVideoView = this.mPlayerVideoView) != null) {
            iSPlayerVideoView.setFixedSize(i3, i16);
            QLog.i(getTag(), 1, "fix video :" + i3 + "-" + i16);
        }
    }

    private long getAverageDownloadSpeeds() {
        if (this.mDownloadTime == 0) {
            return 0L;
        }
        return this.mDownloadTotalSpeed / r0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTag() {
        return "RFWPlayer_" + hashCode();
    }

    private void handleCDNUrlInfo(TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo) {
        this.mCDNIp = tPCDNURLInfo.cdnIp;
        this.mIp = tPCDNURLInfo.uIp;
    }

    private void handleDownloadInfo(TPDownloadProgressInfo tPDownloadProgressInfo) {
        int downloadSpeedbps = (int) tPDownloadProgressInfo.getDownloadSpeedbps();
        if (QLog.isColorLevel()) {
            QLog.d(getTag(), 1, "extra info handleDownloadInfo = " + tPDownloadProgressInfo.getExtraInfo());
        }
        this.mTotalFileSize = tPDownloadProgressInfo.getFileTotalBytes();
        this.mMinDownLoadKbs = Math.min(downloadSpeedbps, this.mMinDownLoadKbs);
        this.mMaxDownLoadKbs = Math.max(downloadSpeedbps, this.mMaxDownLoadKbs);
        this.mDownloadTime++;
        this.mDownloadTotalSpeed += downloadSpeedbps;
        parseExtraInfo(tPDownloadProgressInfo);
    }

    private boolean isQUIC() {
        QLog.w(getTag(), 1, "isQUIC() false? mPlayerController is null");
        return false;
    }

    private boolean isVideoRequestAudio() {
        RFWPlayerVideoInfo rFWPlayerVideoInfo;
        if (this.mVideoInfoRequestAudio && (rFWPlayerVideoInfo = this.mCurrentPlayerVideoInfo) != null) {
            return rFWPlayerVideoInfo.mRequestAudio;
        }
        return false;
    }

    private void notifyDownloadStateChange(long j3, long j16, long j17) {
        if (this.mPlayerCallback != null) {
            this.mPlayerCallback.updateDownloadState(j3, j16, j17);
        }
    }

    private void onPlayerCDNInfoUpdate(Object obj) {
        if (obj instanceof TPPlayerMsg.TPCDNURLInfo) {
            TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = (TPPlayerMsg.TPCDNURLInfo) obj;
            handleCDNUrlInfo(tPCDNURLInfo);
            QLog.i(getTag(), 1, String.format("hashCode:%d,TPPlayerMsg.TPCDNURLInfo:cdnIp:%s, errStr:%s, ip:%s, url:%s", Integer.valueOf(hashCode()), tPCDNURLInfo.cdnIp, tPCDNURLInfo.errorStr, tPCDNURLInfo.uIp, tPCDNURLInfo.url));
        }
    }

    private void onPlayerCurrentLoopStart() {
        this.mStartPlayPositionForReport = 0L;
        if (this.mPlayerCallback != null) {
            this.mPlayerCallback.onVideoLoopStart();
        }
    }

    private void onPlayerInfoBufferingEnd() {
        if (!this.mIsSeeking) {
            this.mHasBufferEnd = true;
            this.mSecondBufferTime += System.currentTimeMillis() - this.mBufferBeginTime;
            QLog.i(getTag(), 1, String.format("PLAYER_INFO_BUFFERING_END mSecondBufferCount:%d, mSecondBufferTime:%d", Integer.valueOf(this.mSecondBufferCount), Long.valueOf(this.mSecondBufferTime)));
        }
        if (this.mPlayerCallback != null) {
            this.mPlayerCallback.onBufferEnd();
        }
    }

    private void onPlayerInfoBufferingStart() {
        this.mBufferBeginTime = System.currentTimeMillis();
        if (!this.mIsSeeking) {
            this.mHasBufferEnd = false;
            this.mSecondBufferCount++;
            QLog.i(getTag(), 1, String.format("PLAYER_INFO_BUFFERING_START mSecondBufferCount:%d, mSecondBufferTime:%d", Integer.valueOf(this.mSecondBufferCount), Long.valueOf(this.mSecondBufferTime)));
        }
        if (this.mPlayerCallback != null) {
            this.mPlayerCallback.onBufferStart();
        }
    }

    private void onPlayerInfoCurrentLoopEnd() {
        addToVideoSoloPlayTimeRangeList(this.mStartPlayPositionForReport, this.mPlayer.getDurationMs());
        if (this.mPlayerCallback != null) {
            this.mPlayerCallback.onVideoLoopEnd();
        }
    }

    private void onPlayerInfoDownloadProgressUpdate(Object obj) {
        if (obj instanceof TPDownloadProgressInfo) {
            handleDownloadInfo((TPDownloadProgressInfo) obj);
        }
    }

    private void onPlayerInfoFirstVideoFrameRendered() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.RFWPlayer.4
            @Override // java.lang.Runnable
            public void run() {
                if (RFWPlayer.this.mPlayerCallback != null) {
                    RFWPlayer.this.mPlayerCallback.onFirstFrameRendered();
                }
            }
        });
    }

    private void onPlayerQUICUpdate(Object obj) {
        if (obj instanceof String) {
            onQUICInfoUpdate((String) obj);
        }
    }

    private void onQUICComplete(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("downloadComplete") && this.mQUICStatus != null) {
            String string = jSONObject.getString("downloadComplete");
            if (TextUtils.equals(string, "quic")) {
                this.mQUICStatus.increaseQUICCompleteCount();
            } else if (TextUtils.equals(string, "http")) {
                this.mQUICStatus.increaseHttpCompleteCount();
            }
        }
    }

    private void onQUICDownload(JSONObject jSONObject) {
        QUICStatus qUICStatus;
        if (jSONObject.has("isDownloadByQuic") && (qUICStatus = this.mQUICStatus) != null) {
            qUICStatus.setIsDownLoadByQUIC();
        }
    }

    private void onQUICFailed(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("downloadFailed") && this.mQUICStatus != null) {
            String string = jSONObject.getString("downloadFailed");
            if (TextUtils.equals(string, "quic")) {
                this.mQUICStatus.increaseQUICFailedCount();
            } else if (TextUtils.equals(string, "http")) {
                this.mQUICStatus.increaseHTTPFailedCount();
            }
        }
    }

    private void onQUICInfoUpdate(String str) {
        if (this.mQUICStatus == null) {
            QLog.d(getTag(), 1, "mQUICStatus null ");
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d(getTag(), 1, "onQUICInfoUpdate np json");
            return;
        }
        QLog.d(getTag(), 1, "onQUICInfoUpdate:" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            onQUICDownload(jSONObject);
            onQUICComplete(jSONObject);
            onQUICFailed(jSONObject);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void parseExtraInfo(TPDownloadProgressInfo tPDownloadProgressInfo) {
        boolean z16;
        try {
            JSONObject jSONObject = new JSONObject(tPDownloadProgressInfo.getExtraInfo());
            if (jSONObject.has("hitDownloaded")) {
                if (jSONObject.getInt("hitDownloaded") == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.mHasHitCache = z16;
                QLog.d(getTag(), 1, "extra info hitDownloaded = " + this.mHasHitCache);
            }
            long downloadBytes = tPDownloadProgressInfo.getDownloadBytes();
            this.mLocalCacheSize = downloadBytes;
            if (downloadBytes == 0 && jSONObject.has("localCacheSize")) {
                this.mLocalCacheSize = jSONObject.getLong("localCacheSize");
            }
            if (jSONObject.has("httpAvgSpeedKB")) {
                this.mTimelineAvgSpeedKB = jSONObject.getLong("httpAvgSpeedKB");
            }
            notifyDownloadStateChange(this.mTimelineAvgSpeedKB, this.mLocalCacheSize, tPDownloadProgressInfo.getFileTotalBytes());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void playerReport() {
        totalTimeReport();
    }

    private void resetParams() {
        this.mPlayer.reset();
        this.mPlayer.setLoopback(this.mIsLoopback);
        this.mPlayer.updatePlayerVideoView(this.mPlayerVideoView);
        this.mPlayer.setOutputMute(this.mOutputMute);
    }

    private void resetVariablesWhenChangeDataSource() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
            stop();
        }
        this.mTimelineAvgSpeedKB = 0L;
        this.mTotalFileSize = 0L;
        this.mHasHitCache = false;
        this.mIsSeeking = false;
        this.mBufferBeginTime = 0L;
        this.mSecondBufferCount = 0;
        this.mSecondBufferTime = 0L;
        this.mDownloadRetCode = "0";
        this.mHasDownloadComplete = false;
        this.mDownloadTotalSpeed = 0;
        this.mDownloadTime = 0;
        this.mMinDownLoadKbs = Integer.MAX_VALUE;
        this.mMaxDownLoadKbs = Integer.MIN_VALUE;
        this.mHasBufferEnd = true;
        this.mVideoPlayId = 0L;
        this.mLocalCacheSize = 0L;
        this.mCDNIp = null;
        this.mIp = null;
        cleanSoPlayTimeRangList();
    }

    private void setQUICStatusListener(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QUICStatus qUICStatus = new QUICStatus(str);
        this.mQUICStatus = qUICStatus;
        qUICStatus.setQUICListener(new QUICStatus.QUICListener() { // from class: com.tencent.biz.richframework.video.RFWPlayer.2
            @Override // com.tencent.biz.richframework.video.QUICStatus.QUICListener
            public void reportQUICTOHttp(QUICStatus qUICStatus2) {
            }
        });
    }

    public synchronized void cleanSoPlayTimeRangList() {
        Stack<Pair<Long, Long>> stack = this.mVideoSoloPlayTimeRangeList;
        if (stack != null) {
            stack.clear();
        }
    }

    @Override // com.tencent.richframework.video.IPlayer
    public long getCurrentPositionMs() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer == null) {
            QLog.w(getTag(), 1, "[getCurrentPositionMs] null mPlayer");
            return -1L;
        }
        return iSuperPlayer.getCurrentPositionMs();
    }

    @Override // com.tencent.richframework.video.IPlayer
    public long getDurationMs() {
        if (getRealPlayer() == null) {
            return 0L;
        }
        return getRealPlayer().getDurationMs();
    }

    @Override // com.tencent.richframework.video.IPlayer
    @Nullable
    public MediaInfo getMediaInfo() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return PlayerUtil.INSTANCE.convertMediaInfo(iSuperPlayer.getMediaInfo());
        }
        return null;
    }

    public long getPlayTime() {
        return System.currentTimeMillis() - this.mReportPlayerTime;
    }

    public ISuperPlayer getRealPlayer() {
        return this.mPlayer;
    }

    @Override // com.tencent.richframework.video.IPlayer
    public TextureView getRenderTextureView() {
        if (getRealPlayer() != null && getRealPlayer().getVideoView() != null && (getRealPlayer().getVideoView().getRenderView() instanceof TextureView)) {
            return (TextureView) getRealPlayer().getVideoView().getRenderView();
        }
        return null;
    }

    public synchronized long getVideoSoloPlayTime() {
        long j3;
        Iterator<Pair<Long, Long>> it = this.mVideoSoloPlayTimeRangeList.iterator();
        j3 = 0;
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            j3 += ((Long) next.second).longValue() - ((Long) next.first).longValue();
        }
        return j3;
    }

    @Override // com.tencent.richframework.video.IPlayer
    public View getVideoView() {
        return (View) this.mPlayerVideoView;
    }

    @Override // com.tencent.richframework.video.IPlayer
    @UiThread
    public void init(@Nullable IPlayerStateCallback iPlayerStateCallback, @Nullable final Surface surface, final int i3) {
        this.mPlayerCallback = iPlayerStateCallback;
        this.mRFWMediaFocusManager = RFWMediaFocusManager.createMediaFocusManager(Constants.Business.QQ_LAYER);
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QLog.i(getTag(), 1, "sdk init is not ready");
            QQVideoPlaySDKManager.initSDKAsync(RFWApplication.getApplication(), new SDKInitListener() { // from class: com.tencent.biz.richframework.video.RFWPlayer.1
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public void onSDKInited(boolean z16) {
                    if (!z16) {
                        QLog.e(RFWPlayer.this.getTag(), 1, "onSDKInited failed");
                    } else {
                        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.RFWPlayer.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QLog.i(RFWPlayer.this.getTag(), 1, "sdk init success");
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                RFWPlayer.this.ensureSuperPlayer(surface, i3);
                                if (RFWPlayer.this.mPlayerCallback != null) {
                                    RFWPlayer.this.mPlayerCallback.onInitSuccess(true);
                                }
                            }
                        });
                    }
                }
            });
        } else {
            ensureSuperPlayer(surface, i3);
            if (iPlayerStateCallback != null) {
                iPlayerStateCallback.onInitSuccess(false);
            }
        }
    }

    @Override // com.tencent.richframework.video.IPlayer
    public boolean isBuffering() {
        if (getRealPlayer() == null) {
            return false;
        }
        return getRealPlayer().isBuffering();
    }

    public boolean isOutputMute() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer == null) {
            return false;
        }
        return iSuperPlayer.isOutputMute();
    }

    @Override // com.tencent.richframework.video.IPlayer
    public boolean isPausing() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isPausing();
        }
        return false;
    }

    @Override // com.tencent.richframework.video.IPlayer
    public boolean isPlaying() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.richframework.video.IPlayer
    public boolean isReady() {
        if (this.mPlayer != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.richframework.video.IPlayer
    public boolean isRelease() {
        return this.mIsRelease;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public synchronized void onCompletion(ISuperPlayer iSuperPlayer) {
        if (isRelease()) {
            return;
        }
        if (this.mPlayerCallback != null) {
            QLog.d(getTag(), 1, "[onCompletion]");
            this.mPlayerCallback.onCompletion();
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        String format = String.format("module:%d, errorType:%d, errorCode:%d, extraInfo:%s", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
        QLog.e(getTag(), 1, "onError, msg =" + format);
        if (this.mPlayerCallback != null) {
            this.mPlayerCallback.onVideoPassivePause(i17, i3, 0L, 0L);
            this.mPlayerCallback.onVideoPlayError(i3, i16, i17, str);
        }
        if (String.valueOf(i17).startsWith("140") || String.valueOf(i17).startsWith("160")) {
            this.mDownloadRetCode = String.valueOf(i17);
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        if (i3 != 105) {
            if (i3 != 127) {
                if (i3 != 201) {
                    if (i3 != 204) {
                        if (i3 != 207) {
                            if (i3 != 250) {
                                if (i3 != 107) {
                                    if (i3 != 108) {
                                        switch (i3) {
                                            case 111:
                                                QLog.i(getTag(), 1, "PLAYER_INFO_SWITCH_DEFINITION");
                                                return false;
                                            case 112:
                                                onPlayerInfoBufferingStart();
                                                return false;
                                            case 113:
                                                onPlayerInfoBufferingEnd();
                                                return false;
                                            default:
                                                return false;
                                        }
                                    }
                                    onPlayerInfoCurrentLoopEnd();
                                    return false;
                                }
                                onPlayerCurrentLoopStart();
                                return false;
                            }
                            onPlayerQUICUpdate(obj);
                            return false;
                        }
                        onPlayerInfoDownloadProgressUpdate(obj);
                        return false;
                    }
                    onPlayerCDNInfoUpdate(obj);
                    return false;
                }
                downloadComplete();
                return false;
            }
            QLog.i(getTag(), 1, "on media info ready");
            if (obj instanceof com.tencent.superplayer.player.MediaInfo) {
                com.tencent.superplayer.player.MediaInfo mediaInfo = (com.tencent.superplayer.player.MediaInfo) obj;
                fixVideoWH(mediaInfo.getVideoWidth(), mediaInfo.getVideoHeight());
                return false;
            }
            return false;
        }
        onPlayerInfoFirstVideoFrameRendered();
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public synchronized void onSeekComplete(ISuperPlayer iSuperPlayer) {
        this.mIsSeeking = false;
        if (this.mStartSeekTime > 0) {
            this.mReportPlayerTime += System.currentTimeMillis() - this.mStartSeekTime;
            this.mStartSeekTime = 0L;
        }
        if (this.mPlayerCallback != null) {
            QLog.d(getTag(), 1, "[seekComplete]");
            this.mPlayerCallback.onSeekComplete();
        }
    }

    public void onStartTrackingTouch() {
        if (this.mPlayer == null) {
            QLog.w(getTag(), 1, "[onStartTrackingTouch] null mPlayer");
            return;
        }
        QLog.d(getTag(), 1, "[startTracking]");
        this.mStartSeekTime = System.currentTimeMillis();
        addToVideoSoloPlayTimeRangeList(this.mStartPlayPositionForReport, this.mPlayer.getCurrentPositionMs());
    }

    public void onStopTrackingTouch(int i3, int i16) {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer == null) {
            QLog.w(getTag(), 1, "[onStopTrackingTouch] null mPlayer");
            return;
        }
        int durationMs = (int) ((i3 / (i16 * 1.0f)) * ((float) iSuperPlayer.getDurationMs()));
        long j3 = durationMs;
        this.mStartPlayPositionForReport = j3;
        QLog.d(getTag(), 1, String.format("seek onStopTrackingTouch seekBar progress:%d, position:%d", Integer.valueOf(i3), Integer.valueOf(durationMs)));
        seek(j3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public synchronized void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        if (this.mIsRelease) {
            return;
        }
        ISPlayerVideoView iSPlayerVideoView = this.mPlayerVideoView;
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.setXYaxis(0);
        }
        String valueOf = String.valueOf(((float) (System.currentTimeMillis() - this.mStartPreparedTime)) / 1000.0f);
        if (this.mPlayerCallback == null) {
            QLog.e(getTag(), 1, "[prepared] player call back is null");
            return;
        }
        QLog.d(getTag(), 1, "[prepared], preparedTime = " + valueOf);
        this.mPlayerCallback.onVideoPrepared();
    }

    public boolean openMediaPlayer(RFWPlayerVideoInfo rFWPlayerVideoInfo) {
        setQUICStatusListener(rFWPlayerVideoInfo.mUrl);
        SuperPlayerVideoInfo createSuperVideoInfo = RFWBaseVideoUtils.createSuperVideoInfo(rFWPlayerVideoInfo);
        this.mCurrentVideoInfo = createSuperVideoInfo;
        if (createSuperVideoInfo == null) {
            QLog.d(getTag(), 1, "openMediaPlayer failed superVideoInfo is null");
            return false;
        }
        if (!TextUtils.isEmpty(rFWPlayerVideoInfo.mStorePath)) {
            this.mCurrentVideoInfo.setLocalSavePath(rFWPlayerVideoInfo.mStorePath);
        }
        List<String> list = rFWPlayerVideoInfo.mCookies;
        if (list != null && list.size() > 0) {
            this.mCurrentVideoInfo.setCookies(new ArrayList<>(rFWPlayerVideoInfo.mCookies));
        }
        if (this.mPlayer != null) {
            resetParams();
            SuperPlayerOption obtain = SuperPlayerOption.obtain();
            obtain.accurateSeekOnOpen = true;
            obtain.httpHeader = rFWPlayerVideoInfo.mHttpHeader;
            long j3 = rFWPlayerVideoInfo.mMinBufferingPacketDurationMs;
            if (j3 > 0 && this.mSetBusinessDownload) {
                obtain.bufferPacketMinTotalDurationMs = j3;
                this.mPlayer.setBusinessDownloadStrategy(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
            }
            if (isQUIC()) {
                obtain.superPlayerDownOption.quicEnableMode = 2;
                QLog.d(getTag(), 1, "setVideoPath us QUIC: true | " + rFWPlayerVideoInfo.mUrl);
            } else {
                QLog.d(getTag(), 1, "setVideoPath us QUIC: false | " + rFWPlayerVideoInfo.mUrl);
            }
            this.mPlayer.openMediaPlayer(RFWApplication.getApplication(), this.mCurrentVideoInfo, rFWPlayerVideoInfo.mStartOffset, obtain);
            return true;
        }
        QLog.d(getTag(), 1, "openMediaPlayer failed");
        return false;
    }

    @Override // com.tencent.richframework.video.IPlayer
    public void pause() {
        if (this.mPlayer != null && !this.mIsRelease) {
            QLog.d(getTag(), 1, "[pause] video");
            this.mPlayer.pause();
            addToVideoSoloPlayTimeRangeList(this.mStartPlayPositionForReport, this.mPlayer.getCurrentPositionMs());
            this.mReportRecordPauseTime = System.currentTimeMillis();
            RFWMediaFocusManager rFWMediaFocusManager = this.mRFWMediaFocusManager;
            if (rFWMediaFocusManager != null) {
                rFWMediaFocusManager.requestMediaUnFocus();
                return;
            }
            return;
        }
        QLog.w(getTag(), 1, "[pause] mPlayer:" + this.mPlayer + " mIsRelease:" + this.mIsRelease);
    }

    public void playerParamesReset(String str, String str2) {
        resetVariablesWhenChangeDataSource();
        checkIsCompleteCache(str, str2);
    }

    public void playerStartPlayState() {
        this.mStartPreparedTime = System.currentTimeMillis();
    }

    public synchronized void release() {
        if (this.mEnablePerfReport) {
            playerReport();
        }
        this.mIsRelease = true;
        if (this.mPlayerCallback != null) {
            this.mPlayerCallback.onRelease();
        }
        this.mPlayerCallback = null;
        RFWThreadManager.getInstance().getVideoHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.RFWPlayer.3
            @Override // java.lang.Runnable
            public void run() {
                if (RFWPlayer.this.mPlayer != null) {
                    QLog.d(RFWPlayer.this.getTag(), 1, "[release]");
                    RFWPlayer.this.mPlayer.stop();
                    RFWPlayer.this.mPlayer.release();
                }
            }
        });
        RFWMediaFocusManager rFWMediaFocusManager = this.mRFWMediaFocusManager;
        if (rFWMediaFocusManager != null) {
            rFWMediaFocusManager.requestMediaUnFocus();
        }
    }

    public void replay() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
        }
        if (this.mCurrentVideoInfo == null) {
            QLog.w(getTag(), 1, "[replay] no replay data");
            return;
        }
        QLog.d(getTag(), 1, "[replay], fileId = " + this.mCurrentVideoInfo.getFileId() + ", url = " + this.mCurrentVideoInfo.getPlayUrl());
        if (this.mEnableRestartByVideoInfo && this.mCurrentPlayerVideoInfo != null) {
            QLog.d(getTag(), 1, "replay by info");
            setVideoInfo(this.mCurrentPlayerVideoInfo);
        } else {
            setVideoPath(this.mCurrentVideoInfo.getFileId(), this.mCurrentVideoInfo.getPlayUrl(), 0);
        }
    }

    @Override // com.tencent.richframework.video.IPlayer
    public void seek(long j3) {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer == null) {
            QLog.w(getTag(), 1, "[seek] null mPlayer");
            return;
        }
        try {
            long durationMs = iSuperPlayer.getDurationMs();
            long j16 = 0;
            if (j3 > durationMs && durationMs != 0) {
                QLog.d(getTag(), 1, "seek over position=" + j3 + "duration=" + durationMs);
                j3 = durationMs;
            }
            if (j3 < 0) {
                QLog.d(getTag(), 1, "seek invalid position=" + j3 + "duration=" + this.mPlayer.getDurationMs());
            } else {
                j16 = j3;
            }
            this.mPlayer.seekTo((int) j16, 3);
            this.mIsSeeking = true;
            QLog.d(getTag(), 1, "seek position=" + j16 + "duration=" + this.mPlayer.getDurationMs());
        } catch (Exception e16) {
            QLog.e(getTag(), 1, "[seek]", e16);
        }
    }

    @Override // com.tencent.richframework.video.IPlayer
    public void setLoopback(boolean z16) {
        this.mIsLoopback = z16;
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setLoopback(z16);
        }
    }

    @Override // com.tencent.richframework.video.IPlayer
    public void setOutputMute(boolean z16) {
        this.mOutputMute = z16;
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(z16);
        }
    }

    @Override // com.tencent.richframework.video.IPlayer
    public void setPlayRate(float f16) {
        if (this.mPlayRate == f16) {
            QLog.d(getTag(), 1, "setPlayRate return same rate:" + f16);
            return;
        }
        this.mPlayRate = f16;
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setPlaySpeedRatio(f16);
            QLog.d(getTag(), 1, "setPlayRate:" + f16);
            return;
        }
        QLog.d(getTag(), 1, "setPlayRate, play is empty");
    }

    @Override // com.tencent.richframework.video.IPlayer
    public void setVideoInfo(RFWPlayerVideoInfo rFWPlayerVideoInfo) {
        int i3;
        this.mCurrentPlayerVideoInfo = rFWPlayerVideoInfo;
        playerParamesReset(rFWPlayerVideoInfo.mVid, rFWPlayerVideoInfo.mUrl);
        int i16 = rFWPlayerVideoInfo.width;
        if (i16 > 0 && (i3 = rFWPlayerVideoInfo.height) > 0) {
            fixVideoWH(i16, i3);
        }
        if (openMediaPlayer(rFWPlayerVideoInfo)) {
            playerStartPlayState();
        }
    }

    @Deprecated
    public void setVideoPath(String str, String str2, int i3) {
        playerParamesReset(str, str2);
        if (openMediaPlayer(RFWPlayerVideoInfo.RFWVideoInfoBuilder.builder().setVid(str).setUrl(str2).setStartOffset(i3).build())) {
            playerStartPlayState();
        }
    }

    @Override // com.tencent.richframework.video.IPlayer
    public void start() {
        if (this.mNeedCheckBackgroundState && RFWLifecycleHelper.getInstance().isRunningInBackground()) {
            QLog.w(getTag(), 1, "[start] mPlayer but is in Background");
            return;
        }
        if (this.mPlayer != null && !this.mIsRelease) {
            if (this.mPlayer.isPlaying()) {
                QLog.w(getTag(), 1, "[start] mPlayer is playing");
                return;
            }
            if (isPausing() && this.mReportRecordPauseTime > 0) {
                this.mReportPlayerTime += System.currentTimeMillis() - this.mReportRecordPauseTime;
                this.mReportRecordPauseTime = 0L;
            }
            if (!isPausing()) {
                this.mReportPlayerTime = System.currentTimeMillis();
                this.mStartPlayPositionForReport = this.mPlayer.getCurrentPositionMs();
            }
            QLog.d(getTag(), 1, "[start]");
            if (this.mRequestAudio && isVideoRequestAudio()) {
                RFWAudioFocusManager.g().requestAudioFocus();
            }
            this.mPlayer.start();
            RFWMediaFocusManager rFWMediaFocusManager = this.mRFWMediaFocusManager;
            if (rFWMediaFocusManager != null) {
                rFWMediaFocusManager.requestMediaFocus();
                return;
            }
            return;
        }
        QLog.w(getTag(), 1, "[start] mPlayer:" + this.mPlayer + " mIsRelease:" + this.mIsRelease);
    }

    public void stop() {
        if (this.mEnablePerfReport) {
            playerReport();
        }
        if (this.mPlayer != null) {
            QLog.d(getTag(), 1, "[stop]");
            this.mPlayer.stop();
        }
        RFWMediaFocusManager rFWMediaFocusManager = this.mRFWMediaFocusManager;
        if (rFWMediaFocusManager != null) {
            rFWMediaFocusManager.requestMediaUnFocus();
        }
    }

    @Override // com.tencent.richframework.video.IPlayer
    public void switchDefinitionForUrl(@NonNull String str, @NonNull SwitchUrlType switchUrlType) {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.switchDefinitionForUrl(str, switchUrlType.getType());
        }
    }

    private void totalTimeReport() {
    }
}
