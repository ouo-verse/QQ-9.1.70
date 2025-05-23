package com.tencent.aelight.camera.ae.flashshow.ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0014R\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/dw;", "Landroid/app/Dialog;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "mp4Path", BdhLogUtil.LogTag.Tag_Req, DKHippyEvent.EVENT_STOP, BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "videoPath", "Landroid/view/SurfaceView;", "D", "Landroid/view/SurfaceView;", "mVideoView", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mTvConfirm", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "mIvClose", "Landroid/media/MediaPlayer;", "G", "Landroid/media/MediaPlayer;", "mMediaPlayer", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "H", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class dw extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private String videoPath;

    /* renamed from: D, reason: from kotlin metadata */
    private SurfaceView mVideoView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mTvConfirm;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView mIvClose;

    /* renamed from: G, reason: from kotlin metadata */
    private MediaPlayer mMediaPlayer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/dw$b", "Landroid/view/SurfaceHolder$Callback;", "Landroid/view/SurfaceHolder;", "p0", "", "surfaceCreated", "", "p1", "p2", "p3", "surfaceChanged", "surfaceDestroyed", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements SurfaceHolder.Callback {
        b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder p06, int p16, int p26, int p36) {
            Intrinsics.checkNotNullParameter(p06, "p0");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            MediaPlayer mediaPlayer = dw.this.mMediaPlayer;
            if (mediaPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                mediaPlayer = null;
            }
            mediaPlayer.setDisplay(p06);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dw(Context ctx, String videoPath) {
        super(ctx, R.style.f243450u);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        this.videoPath = videoPath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(MediaPlayer mediaPlayer) {
        if (mediaPlayer.isPlaying()) {
            return;
        }
        mediaPlayer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(dw this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(dw this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void R(String mp4Path) {
        Intrinsics.checkNotNullParameter(mp4Path, "mp4Path");
        SurfaceView surfaceView = this.mVideoView;
        MediaPlayer mediaPlayer = null;
        if (surfaceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
            surfaceView = null;
        }
        surfaceView.getHolder().addCallback(new b());
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        this.mMediaPlayer = reportMediaPlayer;
        reportMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.dv
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer2) {
                dw.S(mediaPlayer2);
            }
        });
        try {
            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
            if (mediaPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                mediaPlayer2 = null;
            }
            mediaPlayer2.setDataSource(mp4Path);
            MediaPlayer mediaPlayer3 = this.mMediaPlayer;
            if (mediaPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                mediaPlayer3 = null;
            }
            mediaPlayer3.setVideoScalingMode(2);
            MediaPlayer mediaPlayer4 = this.mMediaPlayer;
            if (mediaPlayer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                mediaPlayer4 = null;
            }
            mediaPlayer4.setLooping(true);
            MediaPlayer mediaPlayer5 = this.mMediaPlayer;
            if (mediaPlayer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            } else {
                mediaPlayer = mediaPlayer5;
            }
            mediaPlayer.prepare();
        } catch (Exception e16) {
            ms.a.c("VideoGuideDialog", "play video error:" + e16.getMessage());
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnd);
        View findViewById = findViewById(R.id.ruk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guideVideoView)");
        this.mVideoView = (SurfaceView) findViewById;
        View findViewById2 = findViewById(R.id.s3d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_confirm)");
        TextView textView = (TextView) findViewById2;
        this.mTvConfirm = textView;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvConfirm");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.dt
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dw.U(dw.this, view);
            }
        });
        View findViewById3 = findViewById(R.id.rvm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.iv_close)");
        ImageView imageView2 = (ImageView) findViewById3;
        this.mIvClose = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvClose");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.du
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dw.W(dw.this, view);
            }
        });
        R(this.videoPath);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        MediaPlayer mediaPlayer2 = null;
        if (mediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            mediaPlayer = null;
        }
        if (mediaPlayer.isPlaying()) {
            MediaPlayer mediaPlayer3 = this.mMediaPlayer;
            if (mediaPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                mediaPlayer3 = null;
            }
            mediaPlayer3.stop();
        }
        MediaPlayer mediaPlayer4 = this.mMediaPlayer;
        if (mediaPlayer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
        } else {
            mediaPlayer2 = mediaPlayer4;
        }
        mediaPlayer2.release();
    }
}
