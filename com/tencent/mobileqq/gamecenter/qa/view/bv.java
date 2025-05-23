package com.tencent.mobileqq.gamecenter.qa.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001(B\u0011\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J4\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/bv;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "", "e", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "c", "d", "", "f", "Lcom/tencent/superplayer/api/ISuperPlayer;", "p0", "onVideoPrepared", "player", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "extraInfo", "onError", "i", "j", "k", "", "progress", "l", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "contentView", "Lcom/tencent/superplayer/api/ISuperPlayer;", "mPlayer", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "mVideoView", "<init>", "(Landroid/view/ViewGroup;)V", tl.h.F, "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class bv implements ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnErrorListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ISuperPlayer mPlayer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ISPlayerVideoView mVideoView;

    public bv(@Nullable ViewGroup viewGroup) {
        this.contentView = viewGroup;
        if (QQVideoPlaySDKManager.isSDKReady()) {
            this.mVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext());
            this.mPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 123, this.mVideoView);
            e();
        }
    }

    private final void e() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setLoopback(true);
        }
        ISuperPlayer iSuperPlayer2 = this.mPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.setOnVideoPreparedListener(this);
        }
        ISuperPlayer iSuperPlayer3 = this.mPlayer;
        if (iSuperPlayer3 != null) {
            iSuperPlayer3.setOnErrorListener(this);
        }
        ISuperPlayer iSuperPlayer4 = this.mPlayer;
        if (iSuperPlayer4 != null) {
            iSuperPlayer4.setXYaxis(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(bv this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mVideoView != null) {
            ISuperPlayer iSuperPlayer = this$0.mPlayer;
            if (iSuperPlayer != null) {
                iSuperPlayer.release();
            }
            Object obj = this$0.mVideoView;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            ((View) obj).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(bv this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup viewGroup = this$0.contentView;
        if (viewGroup != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            viewGroup.addView((View) this$0.mVideoView, layoutParams);
            ISuperPlayer iSuperPlayer = this$0.mPlayer;
            if (iSuperPlayer != null) {
                iSuperPlayer.start();
            }
        }
    }

    public final long c() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            Intrinsics.checkNotNull(iSuperPlayer);
            return iSuperPlayer.getCurrentPositionMs();
        }
        return 0L;
    }

    public final long d() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            Intrinsics.checkNotNull(iSuperPlayer);
            return iSuperPlayer.getDurationMs();
        }
        return 0L;
    }

    public final boolean f() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer == null) {
            return false;
        }
        Intrinsics.checkNotNull(iSuperPlayer);
        return iSuperPlayer.isPlaying();
    }

    public final void i() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.pause();
        }
    }

    public final void j() {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.release();
        }
    }

    public final void k() {
        ISuperPlayer iSuperPlayer;
        ISuperPlayer iSuperPlayer2 = this.mPlayer;
        boolean z16 = false;
        if (iSuperPlayer2 != null && iSuperPlayer2.isPausing()) {
            z16 = true;
        }
        if (z16 && (iSuperPlayer = this.mPlayer) != null) {
            iSuperPlayer.start();
        }
    }

    public final void l(float progress) {
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.seekTo((int) (progress * ((float) d())));
        }
    }

    public final void m(@NotNull String videoUrl) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(videoUrl, 101, "");
        Intrinsics.checkNotNullExpressionValue(createVideoInfoForUrl, "createVideoInfoForUrl(\n \u2026\n            \"\"\n        )");
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.openMediaPlayer(BaseApplication.getContext(), createVideoInfoForUrl, 0L);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(@Nullable ISuperPlayer player, int module, int errorType, int errorCode, @Nullable String extraInfo) {
        if (QLog.isColorLevel()) {
            QLog.e("QQGameStrategyVideoDelegate", 1, "minibox video play err,module=" + module + " errorType=" + errorType + " errorCode=" + errorCode);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bu
            @Override // java.lang.Runnable
            public final void run() {
                bv.g(bv.this);
            }
        });
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(@Nullable ISuperPlayer p06) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bt
            @Override // java.lang.Runnable
            public final void run() {
                bv.h(bv.this);
            }
        });
    }
}
