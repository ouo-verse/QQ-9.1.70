package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.biz.richframework.video.rfw.player.report.RFWPlayerFirstFrameHelper;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class RFWPlayerFirstFrameInterceptor extends RFWPlayerBaseInterceptor {
    private long mCurrentPlayerDownloadTime;
    private int mErrorCode;
    private boolean mIsCheckFirstBufferForBandWidthReport;
    private boolean mIsCheckFirstBufferForCacheFlowReport;
    private int mPlayerState;
    private long mPrepareFileLength;
    private long mStartPreparedCostTimeSecond;
    private long mStartPreparedStartTime;

    public RFWPlayerFirstFrameInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        super(rFWBaseInterceptorController);
        this.mStartPreparedStartTime = -1L;
        this.mStartPreparedCostTimeSecond = 0L;
        this.mCurrentPlayerDownloadTime = 0L;
        this.mErrorCode = 0;
        this.mPlayerState = 1;
        this.mPrepareFileLength = 0L;
        this.mIsCheckFirstBufferForCacheFlowReport = false;
        this.mIsCheckFirstBufferForBandWidthReport = false;
    }

    private void asyncPrepareFinishCheckFirstFrame() {
        if (!RFWPlayerFirstFrameHelper.instance().isEnabledFirstFrameMonitor()) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.a
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerFirstFrameInterceptor.this.lambda$asyncPrepareFinishCheckFirstFrame$1();
            }
        });
    }

    private void asyncTriggerCheckFirstFrame(final int i3) {
        if (!RFWPlayerFirstFrameHelper.instance().isEnabledFirstFrameMonitor()) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.b
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerFirstFrameInterceptor.this.lambda$asyncTriggerCheckFirstFrame$0(i3);
            }
        });
    }

    private void handlerDownloadProgress(ISuperPlayer iSuperPlayer, TPDownloadProgressInfo tPDownloadProgressInfo) {
        int i3;
        long hashCode;
        View videoView;
        long hashCode2;
        if (iSuperPlayer == null || tPDownloadProgressInfo == null || !RFWPlayerFirstFrameHelper.instance().isEnabledFirstFrameMonitor()) {
            return;
        }
        try {
            ISPlayerVideoView videoView2 = iSuperPlayer.getVideoView();
            if (videoView2 == null) {
                hashCode = 0;
            } else {
                hashCode = videoView2.hashCode();
            }
            RFWPlayer rFWPlayer = this.mPlayer;
            if (rFWPlayer == null) {
                videoView = null;
            } else {
                videoView = rFWPlayer.getVideoView();
            }
            if (videoView == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = videoView.hashCode();
            }
        } catch (Throwable th5) {
            QLog.e("FFR-RFWPlayerFirstFrameInterceptor", 4, "[handlerDownloadProgress] ex: ", th5);
            i3 = -1;
        }
        if (hashCode != 0 && hashCode == hashCode2) {
            i3 = new JSONObject(tPDownloadProgressInfo.getExtraInfo()).getInt("codeRate");
            if (tPDownloadProgressInfo.getDownloadBytes() > 0 && i3 > 0) {
                this.mCurrentPlayerDownloadTime = tPDownloadProgressInfo.getDownloadBytes() / i3;
            } else {
                this.mCurrentPlayerDownloadTime = 0L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$asyncPrepareFinishCheckFirstFrame$1() {
        if (this.mPlayerOptions == null || this.mStartPreparedStartTime <= 0) {
            return;
        }
        this.mPrepareFileLength = RFWPlayerFirstFrameHelper.instance().getFileNameLength(this.mPlayerOptions.getSceneId(), this.mPlayerOptions.getRealPlayUrl(), this.mPlayerOptions.getPlayVid());
        if (System.currentTimeMillis() - this.mStartPreparedStartTime <= 0) {
            return;
        }
        this.mStartPreparedCostTimeSecond = Math.round(((float) r0) / 1000.0f);
        QLog.d("FFR-RFWPlayerFirstFrameInterceptor", 1, "[asyncPrepareFinishCheckFirstFrame] second: " + this.mStartPreparedCostTimeSecond + " | mPrepareFileLength: " + this.mPrepareFileLength);
        lambda$asyncTriggerCheckFirstFrame$0(1);
    }

    private void updateFirstFrameInfo(@NonNull RFWPlayerFirstFrameHelper.RFWFirstFrameBufferReportParam rFWFirstFrameBufferReportParam) {
        long fileNameLength = RFWPlayerFirstFrameHelper.instance().getFileNameLength(rFWFirstFrameBufferReportParam.mPlayerScene, rFWFirstFrameBufferReportParam.mPlayUrl, rFWFirstFrameBufferReportParam.mVid);
        long j3 = rFWFirstFrameBufferReportParam.mVideoRate;
        rFWFirstFrameBufferReportParam.setPlayFileLength(fileNameLength);
        if (fileNameLength > 0 && j3 > 0) {
            rFWFirstFrameBufferReportParam.setPlayFileTimeCost((int) (fileNameLength / j3));
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void afterOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        super.afterOpenMedia(superPlayerOption, iSuperPlayer);
        this.mPlayerState = 2;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        this.mErrorCode = i17;
        this.mPlayerState = 7;
        return super.onError(iSuperPlayer, i3, i16, i17, str);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPause() {
        super.onPause();
        this.mPlayerState = 5;
        asyncTriggerCheckFirstFrame(2);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerInfoDownloadProgressUpdate(ISuperPlayer iSuperPlayer, Object obj) {
        if (obj instanceof TPDownloadProgressInfo) {
            handlerDownloadProgress(iSuperPlayer, (TPDownloadProgressInfo) obj);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerInfoFirstVideoFrameRendered() {
        super.onPlayerInfoFirstVideoFrameRendered();
        this.mPlayerState = 3;
        asyncPrepareFinishCheckFirstFrame();
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerParamsReset() {
        super.onPlayerParamsReset();
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStart() {
        super.onStart();
        this.mPlayerState = 4;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStop() {
        super.onStop();
        this.mPlayerState = 6;
        asyncTriggerCheckFirstFrame(3);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onVideoPrepare() {
        super.onVideoPrepare();
        this.mPlayerState = 3;
        asyncPrepareFinishCheckFirstFrame();
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void playerStartPlayState() {
        super.playerStartPlayState();
        this.mStartPreparedStartTime = System.currentTimeMillis();
        this.mPlayerState = 1;
        this.mCurrentPlayerDownloadTime = 0L;
        this.mIsCheckFirstBufferForCacheFlowReport = false;
        this.mIsCheckFirstBufferForBandWidthReport = false;
    }

    public void trigger(RFWPlayerFirstFrameHelper.RFWFirstFrameBufferReportParam rFWFirstFrameBufferReportParam) {
        if (rFWFirstFrameBufferReportParam == null) {
            QLog.e("FFR-RFWPlayerFirstFrameInterceptor", 1, "[trigger] param should not be null.");
            return;
        }
        updateFirstFrameInfo(rFWFirstFrameBufferReportParam);
        if (!this.mIsCheckFirstBufferForCacheFlowReport) {
            this.mIsCheckFirstBufferForCacheFlowReport = RFWPlayerFirstFrameHelper.instance().checkFirstBufferForCacheFlow(rFWFirstFrameBufferReportParam);
        }
        if (!this.mIsCheckFirstBufferForBandWidthReport) {
            this.mIsCheckFirstBufferForBandWidthReport = RFWPlayerFirstFrameHelper.instance().checkFirstBufferForBandWidth(rFWFirstFrameBufferReportParam);
        }
    }

    /* renamed from: triggerCheckFirstFrame, reason: merged with bridge method [inline-methods] */
    public void lambda$asyncTriggerCheckFirstFrame$0(int i3) {
        long duration;
        int i16;
        RFWPlayerReportInfo businessReportInfo;
        boolean z16;
        if (!RFWPlayerFirstFrameHelper.instance().isEnabledFirstFrameMonitor()) {
            return;
        }
        RFWPlayerOptions rFWPlayerOptions = this.mPlayerOptions;
        if (rFWPlayerOptions == null) {
            QLog.e("FFR-RFWPlayerFirstFrameInterceptor", 1, "[triggerFirstFrame] mPlayerOptions == null.");
            return;
        }
        try {
            long j3 = 0;
            if (rFWPlayerOptions.getStVideo() == null) {
                duration = 0;
            } else {
                duration = this.mPlayerOptions.getStVideo().getDuration();
            }
            int i17 = 0;
            if (duration <= 0) {
                i16 = 0;
            } else {
                i16 = (int) (duration / 1000);
            }
            String fileId = this.mPlayerOptions.getFileId();
            int videoRate = this.mPlayerOptions.getStVideo().getVideoRate();
            if (this.mPlayerOptions.getIOC() == null) {
                businessReportInfo = null;
            } else {
                businessReportInfo = this.mPlayerOptions.getIOC().getBusinessReportInfo();
            }
            RFWPlayerFirstFrameHelper.RFWFirstFrameBufferReportParam rFWFirstFrameBufferReportParam = new RFWPlayerFirstFrameHelper.RFWFirstFrameBufferReportParam();
            rFWFirstFrameBufferReportParam.setFileId(fileId);
            rFWFirstFrameBufferReportParam.setVid(this.mPlayerOptions.getPlayVid());
            rFWFirstFrameBufferReportParam.setPlayUrl(this.mPlayerOptions.getRealPlayUrl());
            rFWFirstFrameBufferReportParam.setPlayerDurationTime(i16);
            rFWFirstFrameBufferReportParam.setPlayerErrorCode(this.mErrorCode);
            rFWFirstFrameBufferReportParam.setPlayerState(this.mPlayerState);
            rFWFirstFrameBufferReportParam.setTriggerScene(i3);
            rFWFirstFrameBufferReportParam.setPlayerBufferTime((int) this.mCurrentPlayerDownloadTime);
            if (this.mStartPreparedCostTimeSecond == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            rFWFirstFrameBufferReportParam.setPreparedSuccess(z16);
            rFWFirstFrameBufferReportParam.setStartPreparedTime((int) this.mStartPreparedCostTimeSecond);
            rFWFirstFrameBufferReportParam.setPlayerScene(this.mPlayerOptions.getSceneId());
            RFWPlayer rFWPlayer = this.mPlayer;
            if (rFWPlayer != null) {
                j3 = rFWPlayer.getVideoPlayId();
            }
            rFWFirstFrameBufferReportParam.setVideoPlayerId(j3);
            rFWFirstFrameBufferReportParam.setReportFeed(businessReportInfo);
            rFWFirstFrameBufferReportParam.setVideoRate(videoRate);
            rFWFirstFrameBufferReportParam.setPrepareFileLength(this.mPrepareFileLength);
            RFWPlayer rFWPlayer2 = this.mPlayer;
            if (rFWPlayer2 != null && rFWPlayer2.getVideoView() != null) {
                i17 = this.mPlayer.getVideoView().hashCode();
            }
            QLog.d("FFR-RFWPlayerFirstFrameInterceptor", 1, "[triggerCheckFirstFrame] mCurrentPlayerDownloadTime: " + this.mCurrentPlayerDownloadTime + " | hashCode: " + i17);
            trigger(rFWFirstFrameBufferReportParam);
        } catch (Throwable th5) {
            QLog.e("FFR-RFWPlayerFirstFrameInterceptor", 1, "[triggerCheckFirstFrame] ex:", th5);
        }
    }
}
