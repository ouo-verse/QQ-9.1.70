package com.tencent.biz.qqcircle.immersive.utils.ad;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdVideoView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001-\u0018\u00002\u00020\u0001:\u0001\nB\u001f\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00105\u001a\u000204\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R*\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00168\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0016\u0010\"\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019R\u0016\u0010$\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0019R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010.\u00a8\u00068"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdVideoView;", "", "Lcom/tencent/superplayer/api/ISuperPlayer;", "i", "", "t", "w", "r", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "a", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "videoView", "b", "Lkotlin/Lazy;", "p", "()Lcom/tencent/superplayer/api/ISuperPlayer;", "videoPlayer", "Lcom/tencent/biz/qqcircle/immersive/utils/ad/g;", "c", "Lcom/tencent/biz/qqcircle/immersive/utils/ad/g;", "videoReporter", "", "value", "d", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "v", "(Z)V", "isVideoMute", "e", "isPlayLoop", "f", "isPauseByLandingPage", "g", "isPlayCompleted", "Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdVideoView$a;", tl.h.F, "Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdVideoView$a;", "o", "()Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdVideoView$a;", "u", "(Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdVideoView$a;)V", "onPlayProgressListener", "com/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdVideoView$getProgressRunnable$1", "Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdVideoView$getProgressRunnable$1;", "getProgressRunnable", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "videoContainer", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "<init>", "(Landroid/content/Context;Landroid/widget/RelativeLayout;Lcom/tencent/gdtad/aditem/GdtAd;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPauseAdVideoView {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ISPlayerVideoView videoView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy videoPlayer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g videoReporter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoMute;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isPlayLoop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isPauseByLandingPage;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isPlayCompleted;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a onPlayProgressListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QFSPauseAdVideoView$getProgressRunnable$1 getProgressRunnable;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdVideoView$a;", "", "", "position", "duration", "", "onPlayProgress", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface a {
        void onPlayProgress(long position, long duration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdVideoView$getProgressRunnable$1] */
    public QFSPauseAdVideoView(@NotNull Context context, @NotNull RelativeLayout videoContainer, @NotNull GdtAd gdtAd) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoContainer, "videoContainer");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(context);
        Intrinsics.checkNotNullExpressionValue(createPlayerVideoView, "createPlayerVideoView(context)");
        this.videoView = createPlayerVideoView;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ISuperPlayer>() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdVideoView$videoPlayer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ISuperPlayer invoke() {
                ISuperPlayer i3;
                i3 = QFSPauseAdVideoView.this.i();
                return i3;
            }
        });
        this.videoPlayer = lazy;
        String videoReportUrl = gdtAd.getVideoReportUrl();
        this.videoReporter = new g(videoReportUrl == null ? "" : videoReportUrl);
        this.isVideoMute = true;
        this.isPlayLoop = true;
        this.getProgressRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdVideoView$getProgressRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                ISuperPlayer p16;
                ISuperPlayer p17;
                QFSPauseAdVideoView.a onPlayProgressListener = QFSPauseAdVideoView.this.getOnPlayProgressListener();
                if (onPlayProgressListener != null) {
                    p16 = QFSPauseAdVideoView.this.p();
                    long currentPositionMs = p16.getCurrentPositionMs();
                    p17 = QFSPauseAdVideoView.this.p();
                    onPlayProgressListener.onPlayProgress(currentPositionMs, p17.getDurationMs());
                }
                obj = QFSPauseAdVideoView.this.videoView;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
                ((View) obj).postDelayed(this, 100L);
            }
        };
        Intrinsics.checkNotNull(createPlayerVideoView, "null cannot be cast to non-null type android.view.View");
        videoContainer.addView((View) createPlayerVideoView);
        p().openMediaPlayer(context, SuperPlayerFactory.createVideoInfoForUrl(gdtAd.getVideoUrl(), 101, (String) null, (String) null), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISuperPlayer i() {
        final ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(MobileQQ.sMobileQQ, 117, this.videoView);
        createMediaPlayer.setXYaxis(2);
        createMediaPlayer.setOnVideoPreparedListener(new ISuperPlayer.OnVideoPreparedListener() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.u
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
            public final void onVideoPrepared(ISuperPlayer iSuperPlayer) {
                QFSPauseAdVideoView.j(ISuperPlayer.this, this, iSuperPlayer);
            }
        });
        createMediaPlayer.setOnInfoListener(new ISuperPlayer.OnInfoListener() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.v
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
            public final boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
                boolean k3;
                k3 = QFSPauseAdVideoView.k(QFSPauseAdVideoView.this, createMediaPlayer, iSuperPlayer, i3, j3, j16, obj);
                return k3;
            }
        });
        createMediaPlayer.setOnCompletionListener(new ISuperPlayer.OnCompletionListener() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.w
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
            public final void onCompletion(ISuperPlayer iSuperPlayer) {
                QFSPauseAdVideoView.l(QFSPauseAdVideoView.this, createMediaPlayer, iSuperPlayer);
            }
        });
        createMediaPlayer.setOnErrorListener(new ISuperPlayer.OnErrorListener() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.x
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
            public final boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
                boolean n3;
                n3 = QFSPauseAdVideoView.n(QFSPauseAdVideoView.this, createMediaPlayer, iSuperPlayer, i3, i16, i17, str);
                return n3;
            }
        });
        createMediaPlayer.setOutputMute(this.isVideoMute);
        createMediaPlayer.setLoopback(this.isPlayLoop);
        Intrinsics.checkNotNullExpressionValue(createMediaPlayer, "createMediaPlayer(Mobile\u2026ack(isPlayLoop)\n        }");
        return createMediaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ISuperPlayer iSuperPlayer, QFSPauseAdVideoView this$0, ISuperPlayer iSuperPlayer2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object videoView = iSuperPlayer.getVideoView();
        Intrinsics.checkNotNull(videoView, "null cannot be cast to non-null type android.view.View");
        ((View) videoView).post(this$0.getProgressRunnable);
        this$0.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(QFSPauseAdVideoView this$0, ISuperPlayer iSuperPlayer, ISuperPlayer iSuperPlayer2, int i3, long j3, long j16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 108) {
            g.d(this$0.videoReporter, iSuperPlayer.getCurrentPositionMs(), this$0.isPlayCompleted, 1, 0, 0, 24, null);
            this$0.isPlayCompleted = true;
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final QFSPauseAdVideoView this$0, final ISuperPlayer iSuperPlayer, ISuperPlayer iSuperPlayer2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.y
            @Override // java.lang.Runnable
            public final void run() {
                QFSPauseAdVideoView.m(QFSPauseAdVideoView.this, iSuperPlayer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(QFSPauseAdVideoView this$0, ISuperPlayer iSuperPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g.d(this$0.videoReporter, iSuperPlayer.getCurrentPositionMs(), this$0.isPlayCompleted, 1, 0, 0, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(QFSPauseAdVideoView this$0, ISuperPlayer iSuperPlayer, ISuperPlayer iSuperPlayer2, int i3, int i16, int i17, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g.d(this$0.videoReporter, iSuperPlayer.getCurrentPositionMs(), this$0.isPlayCompleted, 0, 0, 2, 12, null);
        this$0.w();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISuperPlayer p() {
        return (ISuperPlayer) this.videoPlayer.getValue();
    }

    private final void t() {
        if (p().isPlaying()) {
            return;
        }
        ISuperPlayer p16 = p();
        p16.setOutputMute(this.isVideoMute);
        p16.setLoopback(this.isPlayLoop);
        p16.start();
    }

    private final void w() {
        p().stop();
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    public final a getOnPlayProgressListener() {
        return this.onPlayProgressListener;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsVideoMute() {
        return this.isVideoMute;
    }

    public final void r() {
        if (p().isPlaying()) {
            this.isPauseByLandingPage = true;
            g.d(this.videoReporter, p().getCurrentPositionMs(), this.isPlayCompleted, 0, 2, 0, 20, null);
            p().pause();
        }
    }

    public final void s() {
        if (!this.isPauseByLandingPage) {
            g.d(this.videoReporter, p().getCurrentPositionMs(), this.isPlayCompleted, 0, 0, 0, 28, null);
        }
        p().release();
    }

    public final void u(@Nullable a aVar) {
        this.onPlayProgressListener = aVar;
    }

    public final void v(boolean z16) {
        p().setOutputMute(z16);
        this.isVideoMute = z16;
    }
}
