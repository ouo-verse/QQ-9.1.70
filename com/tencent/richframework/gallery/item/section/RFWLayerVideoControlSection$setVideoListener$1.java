package com.tencent.richframework.gallery.item.section;

import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoLoadState;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider;
import com.tencent.richframework.gallery.video.ILayerVideoListener;
import com.tencent.richframework.gallery.video.RFWLayerVideoView;
import com.tencent.richframework.video.IPlayer;
import com.tencent.richframework.video.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J \u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0016\u00a8\u0006$"}, d2 = {"com/tencent/richframework/gallery/item/section/RFWLayerVideoControlSection$setVideoListener$1", "Lcom/tencent/richframework/gallery/video/ILayerVideoListener;", "onBufferEnd", "", "onBufferStart", "onCompletion", "onDownloadAllFinish", "onFirstFrameRendered", "onInitSuccess", "firstInit", "", "onProgress", "timeString", "", "videoDuration", "", "currentDuration", "onRelease", "onSeekBarProgressChanged", "seekBar", "Landroid/widget/SeekBar;", "progress", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "onVideoPlayError", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "extraInfo", "onVideoPrepared", "updateDownloadState", "downloadSpeed", "", "downloadSize", "totalSize", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerVideoControlSection$setVideoListener$1 implements ILayerVideoListener {
    final /* synthetic */ String $videoKey;
    final /* synthetic */ RFWLayerVideoControlSection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RFWLayerVideoControlSection$setVideoListener$1(RFWLayerVideoControlSection rFWLayerVideoControlSection, String str) {
        this.this$0 = rFWLayerVideoControlSection;
        this.$videoKey = str;
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onBufferEnd() {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        handler = this.this$0.handler;
        runnable = this.this$0.showBufferTipTask;
        handler.removeCallbacks(runnable);
        handler2 = this.this$0.handler;
        handler2.post(new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$setVideoListener$1$onBufferEnd$1
            @Override // java.lang.Runnable
            public final void run() {
                View rateTipLayout;
                RFWLayerVideoControlSection$setVideoListener$1.this.this$0.issShowingBuffering = false;
                rateTipLayout = RFWLayerVideoControlSection$setVideoListener$1.this.this$0.getRateTipLayout();
                Intrinsics.checkNotNullExpressionValue(rateTipLayout, "rateTipLayout");
                rateTipLayout.setVisibility(8);
            }
        });
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onBufferStart() {
        Handler handler;
        Runnable runnable;
        handler = this.this$0.handler;
        runnable = this.this$0.showBufferTipTask;
        handler.postDelayed(runnable, 2000L);
        String mediaId = RFWLayerVideoControlSection.access$getMData$p(this.this$0).getMediaId();
        if (mediaId != null) {
            RFWLayerDataCenter.INSTANCE.updateVideoPlayState(mediaId, RFWLayerVideoLoadState.PlayState.BUFFERING);
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onCompletion() {
        Handler handler;
        handler = this.this$0.handler;
        handler.post(new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$setVideoListener$1$onCompletion$1
            @Override // java.lang.Runnable
            public final void run() {
                RFWLayerVideoControlSection.access$getProgressPosition$p(RFWLayerVideoControlSection$setVideoListener$1.this.this$0).setText(RFWLayerVideoControlSection.INSTANCE.getSocialMinSeconds(0));
                RFWLayerVideoControlSection$setVideoListener$1.this.this$0.updatePlayIconStatus(false);
                RFWLayerVideoControlSection.access$getCoverImg$p(RFWLayerVideoControlSection$setVideoListener$1.this.this$0).setVisibility(0);
            }
        });
        String mediaId = RFWLayerVideoControlSection.access$getMData$p(this.this$0).getMediaId();
        if (mediaId != null) {
            RFWLayerDataCenter.INSTANCE.updateVideoPlayState(mediaId, RFWLayerVideoLoadState.PlayState.FINISH);
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onDownloadAllFinish() {
        String mediaId = RFWLayerVideoControlSection.access$getMData$p(this.this$0).getMediaId();
        if (mediaId != null) {
            RFWLayerFileDownloadState rFWLayerFileDownloadState = new RFWLayerFileDownloadState(mediaId);
            rFWLayerFileDownloadState.setFileState(RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS);
            RFWLayerDataCenter.INSTANCE.updateVideoFileState(mediaId, rFWLayerFileDownloadState);
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onFirstFrameRendered() {
        int i3;
        boolean z16;
        boolean z17;
        int i16 = RFWLog.USR;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("pos: ");
        i3 = ((Section) this.this$0).mPosition;
        sb5.append(i3);
        sb5.append(", firstFrameRenderCallBack isVisible:");
        z16 = this.this$0.isVisible;
        sb5.append(z16);
        RFWLog.d("RFWLayerVideoControlSection", i16, sb5.toString());
        z17 = this.this$0.isVisible;
        if (z17) {
            this.this$0.startPlayWithAutoPlayCheck();
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onInitSuccess(boolean firstInit) {
        boolean isVoiceMute;
        IVideoPlayStrategyProvider iVideoPlayStrategyProvider;
        boolean z16;
        a.f(this, firstInit);
        RFWLayerVideoView access$getPlayView$p = RFWLayerVideoControlSection.access$getPlayView$p(this.this$0);
        isVoiceMute = this.this$0.isVoiceMute();
        access$getPlayView$p.setOutPutMute(isVoiceMute);
        RFWLog.i("RFWLayerVideoControlSection", RFWLog.USR, "onInitSuccess " + firstInit);
        iVideoPlayStrategyProvider = this.this$0.videoStrategyProvider;
        if (iVideoPlayStrategyProvider != null) {
            RFWLayerItemMediaInfo mData = RFWLayerVideoControlSection.access$getMData$p(this.this$0);
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            z16 = iVideoPlayStrategyProvider.isLoopPlay(mData);
        } else {
            z16 = true;
        }
        RFWLayerVideoControlSection.access$getPlayView$p(this.this$0).setLoopBack(z16);
    }

    @Override // com.tencent.richframework.gallery.video.ILayerVideoListener
    public void onProgress(@NotNull String timeString, int videoDuration, int currentDuration) {
        Intrinsics.checkNotNullParameter(timeString, "timeString");
        this.this$0.doOnProgress(videoDuration, currentDuration, this.$videoKey);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onRelease() {
        RFWLayerVideoControlSection.access$getCoverImg$p(this.this$0).setVisibility(0);
    }

    @Override // com.tencent.richframework.gallery.video.ILayerVideoListener
    public void onSeekBarProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        this.this$0.doOnSeekBarProgressChange(seekBar, progress, fromUser);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onSeekComplete() {
        a.h(this);
    }

    @Override // com.tencent.richframework.gallery.video.ILayerVideoListener
    public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        RFWLog.d("RFWLayerVideoControlSection", RFWLog.USR, "onStartTrackingTouch");
        this.this$0.isDraggingProgressBar = true;
    }

    @Override // com.tencent.richframework.gallery.video.ILayerVideoListener
    public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        RFWLog.d("RFWLayerVideoControlSection", RFWLog.USR, "onStopTrackingTouch");
        this.this$0.isDraggingProgressBar = false;
        RFWLayerVideoControlSection.hideControlLayout$default(this.this$0, false, 1, null);
        this.this$0.startPlayer();
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onTimerCallback() {
        a.i(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onVideoLoopEnd() {
        a.j(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onVideoLoopStart() {
        a.k(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onVideoPassivePause(int i3, int i16, long j3, long j16) {
        a.l(this, i3, i16, j3, j16);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoPlayError(int module, int errorType, int errorCode, @Nullable String extraInfo) {
        this.this$0.showInnerError(errorCode);
        String mediaId = RFWLayerVideoControlSection.access$getMData$p(this.this$0).getMediaId();
        if (mediaId != null) {
            RFWLayerDataCenter.INSTANCE.updateVideoPlayState(mediaId, RFWLayerVideoLoadState.PlayState.ERROR);
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoPrepared() {
        int i3;
        int i16 = RFWLog.USR;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("pos: ");
        i3 = ((Section) this.this$0).mPosition;
        sb5.append(i3);
        sb5.append(", onVideoPrepared");
        RFWLog.d("RFWLayerVideoControlSection", i16, sb5.toString());
        this.this$0.doOnVideoPrepare();
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void updateDownloadState(final long downloadSpeed, final long downloadSize, final long totalSize) {
        Handler handler;
        handler = this.this$0.handler;
        handler.post(new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerVideoControlSection$setVideoListener$1$updateDownloadState$1
            @Override // java.lang.Runnable
            public final void run() {
                IVideoPlayStrategyProvider iVideoPlayStrategyProvider;
                String mediaId;
                RFWLayerFileDownloadState.FileState fileState;
                boolean z16;
                View rateTipLayout;
                String rateText;
                RFWLayerVideoControlSection$setVideoListener$1.this.this$0.downloadSpeed = downloadSpeed;
                IPlayer currentPlayer = RFWLayerVideoControlSection.access$getPlayView$p(RFWLayerVideoControlSection$setVideoListener$1.this.this$0).getCurrentPlayer();
                if (currentPlayer != null && currentPlayer.isBuffering()) {
                    z16 = RFWLayerVideoControlSection$setVideoListener$1.this.this$0.issShowingBuffering;
                    if (z16) {
                        rateTipLayout = RFWLayerVideoControlSection$setVideoListener$1.this.this$0.getRateTipLayout();
                        Intrinsics.checkNotNullExpressionValue(rateTipLayout, "rateTipLayout");
                        TextView textView = (TextView) rateTipLayout.findViewById(R.id.hvh);
                        Intrinsics.checkNotNullExpressionValue(textView, "rateTipLayout.rateText");
                        rateText = RFWLayerVideoControlSection$setVideoListener$1.this.this$0.getRateText();
                        textView.setText(rateText);
                    }
                }
                iVideoPlayStrategyProvider = RFWLayerVideoControlSection$setVideoListener$1.this.this$0.videoStrategyProvider;
                if (iVideoPlayStrategyProvider != null) {
                    RFWLayerItemMediaInfo mData = RFWLayerVideoControlSection.access$getMData$p(RFWLayerVideoControlSection$setVideoListener$1.this.this$0);
                    Intrinsics.checkNotNullExpressionValue(mData, "mData");
                    if (iVideoPlayStrategyProvider.enableDispatchFileDownloadState(mData) && (mediaId = RFWLayerVideoControlSection.access$getMData$p(RFWLayerVideoControlSection$setVideoListener$1.this.this$0).getMediaId()) != null) {
                        RFWLayerFileDownloadState rFWLayerFileDownloadState = new RFWLayerFileDownloadState(mediaId);
                        if (downloadSize == totalSize) {
                            fileState = RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS;
                        } else {
                            fileState = RFWLayerFileDownloadState.FileState.DOWNLOADING;
                        }
                        rFWLayerFileDownloadState.setFileState(fileState);
                        rFWLayerFileDownloadState.setFileSize(totalSize);
                        rFWLayerFileDownloadState.setProgressPercent((((float) downloadSize) * 1.0f) / ((float) totalSize));
                        RFWLayerDataCenter.INSTANCE.updateFileState(rFWLayerFileDownloadState);
                    }
                }
            }
        });
    }
}
