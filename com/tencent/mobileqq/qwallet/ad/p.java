package com.tencent.mobileqq.qwallet.ad;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqcommon.api.INetworkUtilApi;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import cooperation.qwallet.plugin.QWalletPicHelper;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 C2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020#\u00a2\u0006\u0004\bA\u0010BJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0006J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010+R\u0016\u0010;\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010+R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010+R\u0016\u0010>\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010+R\u0014\u0010?\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010+R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010+\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/qwallet/ad/p;", "", "Landroid/content/Context;", "context", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "", "v", "", "l", "p", "", "imgUrl", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, BdhLogUtil.LogTag.Tag_Conn, "B", "E", "", "t", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", HippyTKDListViewAdapter.X, "", "u", "()Ljava/lang/Long;", "a", "Landroid/content/Context;", "Landroid/widget/RelativeLayout;", "b", "Landroid/widget/RelativeLayout;", "videoContainer", "Lcom/tencent/gdtad/aditem/GdtAd;", "c", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "d", "Landroid/widget/ImageView;", "defaultCoverView", "e", "Z", "isFirstPlayCompleteReported", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "f", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "videoView", "g", "Lcom/tencent/superplayer/api/ISuperPlayer;", "videoPlayer", "Lml2/b;", tl.h.F, "Lml2/b;", "videoReporter", "i", "isPauseByLandingPage", "j", "isPauseByLifecycle", "k", "isPauseByOffScreen", "isVideoMute", "isPlayLoop", "isDestroyed", "<init>", "(Landroid/content/Context;Landroid/widget/RelativeLayout;Lcom/tencent/gdtad/aditem/GdtAd;)V", "o", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class p {

    /* renamed from: p, reason: collision with root package name */
    private static final int f277067p = ViewUtils.dpToPx(24.0f);

    /* renamed from: q, reason: collision with root package name */
    private static final int f277068q = ViewUtils.dpToPx(12.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout videoContainer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GdtAd gdtAd;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView defaultCoverView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstPlayCompleteReported;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ISPlayerVideoView videoView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ISuperPlayer videoPlayer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ml2.b videoReporter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isPauseByLandingPage;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isPauseByLifecycle;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isPauseByOffScreen;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoMute;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean isPlayLoop;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroyed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qwallet/ad/p$b", "Ljm0/a;", "", QZoneJsConstants.METHOD_RECORDER_PAUSE_PLAY, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements jm0.a {
        b() {
        }

        @Override // jm0.a
        public void pausePlay() {
            p.this.B();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull Context context, @NotNull RelativeLayout videoContainer, @NotNull GdtAd gdtAd) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoContainer, "videoContainer");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        this.context = context;
        this.videoContainer = videoContainer;
        this.gdtAd = gdtAd;
        ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(context);
        Intrinsics.checkNotNullExpressionValue(createPlayerVideoView, "createPlayerVideoView(context)");
        this.videoView = createPlayerVideoView;
        String videoReportUrl = gdtAd.getVideoReportUrl();
        this.videoReporter = new ml2.b(videoReportUrl == null ? "" : videoReportUrl);
        this.isVideoMute = true;
        this.isPlayLoop = true;
        Intrinsics.checkNotNull(createPlayerVideoView, "null cannot be cast to non-null type android.view.View");
        videoContainer.addView((View) createPlayerVideoView);
        videoContainer.addView(n(context));
        String basic_img = gdtAd.getBasic_img();
        Intrinsics.checkNotNullExpressionValue(basic_img, "gdtAd.basic_img");
        ImageView m3 = m(context, basic_img);
        this.defaultCoverView = m3;
        videoContainer.addView(m3);
        if (QQVideoPlaySDKManager.isSDKReady()) {
            QLog.i("GdtVideoViewWrapper", 1, "getVideoPlayer: isSDKReady");
            v(context, p());
        } else {
            QQVideoPlaySDKManager.initSDKAsync(MobileQQ.sMobileQQ, new Companion.C8453a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        int i3;
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer == null || iSuperPlayer.isPausing()) {
            return;
        }
        iSuperPlayer.pause();
        if (this.isPauseByLandingPage) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        ml2.b.d(this.videoReporter, iSuperPlayer.getCurrentPositionMs(), 0, i3, 0, t(), 10, null);
    }

    private final void C() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer == null || iSuperPlayer.isPlaying()) {
            return;
        }
        iSuperPlayer.setOutputMute(this.isVideoMute);
        iSuperPlayer.setLoopback(this.isPlayLoop);
        iSuperPlayer.start();
        ThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qwallet.ad.m
            @Override // java.lang.Runnable
            public final void run() {
                p.D(p.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(p this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.defaultCoverView.setVisibility(8);
    }

    private final void E() {
        ThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qwallet.ad.n
            @Override // java.lang.Runnable
            public final void run() {
                p.F(p.this);
            }
        });
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(p this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.defaultCoverView.setVisibility(0);
    }

    private final boolean l() {
        if (!((INetworkUtilApi) QRoute.api(INetworkUtilApi.class)).isWifi() && ((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(IQWalletFeatureApi.QWALLET_AD_DISABLE_AUTOPLAY_CELLULAR, false)) {
            return false;
        }
        return true;
    }

    private final ImageView m(Context context, String imgUrl) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ColorDrawable colorDrawable = new ColorDrawable(0);
        imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(imgUrl, colorDrawable, colorDrawable));
        return imageView;
    }

    private final ImageView n(Context context) {
        ImageView imageView = new ImageView(context);
        int i3 = f277067p;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 51;
        int i16 = f277068q;
        layoutParams.topMargin = i16;
        layoutParams.leftMargin = i16;
        imageView.setLayoutParams(layoutParams);
        imageView.setSelected(this.isVideoMute);
        imageView.setImageResource(R.drawable.f162152lc0);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.ad.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.o(p.this, view);
            }
        });
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(p this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = !this$0.isVideoMute;
        this$0.isVideoMute = z16;
        ISuperPlayer iSuperPlayer = this$0.videoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(z16);
        }
        view.setSelected(this$0.isVideoMute);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISuperPlayer p() {
        final ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(MobileQQ.sMobileQQ, 117, this.videoView);
        createMediaPlayer.setXYaxis(2);
        createMediaPlayer.setOnVideoPreparedListener(new ISuperPlayer.OnVideoPreparedListener() { // from class: com.tencent.mobileqq.qwallet.ad.j
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
            public final void onVideoPrepared(ISuperPlayer iSuperPlayer) {
                p.q(p.this, iSuperPlayer);
            }
        });
        createMediaPlayer.setOnInfoListener(new ISuperPlayer.OnInfoListener() { // from class: com.tencent.mobileqq.qwallet.ad.k
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
            public final boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
                boolean r16;
                r16 = p.r(p.this, createMediaPlayer, iSuperPlayer, i3, j3, j16, obj);
                return r16;
            }
        });
        createMediaPlayer.setOnErrorListener(new ISuperPlayer.OnErrorListener() { // from class: com.tencent.mobileqq.qwallet.ad.l
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
            public final boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
                boolean s16;
                s16 = p.s(p.this, createMediaPlayer, iSuperPlayer, i3, i16, i17, str);
                return s16;
            }
        });
        createMediaPlayer.setOutputMute(this.isVideoMute);
        createMediaPlayer.setLoopback(this.isPlayLoop);
        Intrinsics.checkNotNullExpressionValue(createMediaPlayer, "createMediaPlayer(Mobile\u2026ack(isPlayLoop)\n        }");
        return createMediaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(p this$0, ISuperPlayer iSuperPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.l()) {
            this$0.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(p this$0, ISuperPlayer iSuperPlayer, ISuperPlayer iSuperPlayer2, int i3, long j3, long j16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("GdtVideoViewWrapper", 1, "onInfo: what=" + i3 + " isFirstComplete=" + this$0.isFirstPlayCompleteReported);
        if (i3 == 108) {
            int t16 = this$0.t();
            this$0.isFirstPlayCompleteReported = true;
            ml2.b.d(this$0.videoReporter, iSuperPlayer.getCurrentPositionMs(), 1, 0, 0, t16, 12, null);
        }
        if (i3 == 107) {
            ((IGdtAPI) QRoute.api(IGdtAPI.class)).checkAppForegroundState(1, new b());
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(p this$0, ISuperPlayer iSuperPlayer, ISuperPlayer iSuperPlayer2, int i3, int i16, int i17, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ml2.b.d(this$0.videoReporter, iSuperPlayer.getCurrentPositionMs(), 0, 0, 2, this$0.t(), 6, null);
        this$0.E();
        return false;
    }

    private final int t() {
        if (!this.isFirstPlayCompleteReported) {
            return 11;
        }
        return 14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(Context context, ISuperPlayer player) {
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(this.gdtAd.getVideoUrl(), 101, (String) null, (String) null);
        this.videoPlayer = player;
        player.openMediaPlayer(context, createVideoInfoForUrl, 0L);
    }

    public final void A() {
        boolean z16;
        boolean z17 = !this.videoContainer.getGlobalVisibleRect(new Rect());
        if (z17) {
            ISuperPlayer iSuperPlayer = this.videoPlayer;
            if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                B();
                this.isPauseByOffScreen = true;
                return;
            }
        }
        if (!z17 && this.isPauseByOffScreen) {
            C();
            this.isPauseByOffScreen = false;
        }
    }

    @Nullable
    public final Long u() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null) {
            return Long.valueOf(iSuperPlayer.getCurrentPositionMs());
        }
        return null;
    }

    public final void w() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
            this.isPauseByLandingPage = true;
            B();
        }
    }

    public final void x() {
        this.isDestroyed = true;
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        if (iSuperPlayer == null) {
            return;
        }
        if (iSuperPlayer.isPlaying()) {
            ml2.b.d(this.videoReporter, iSuperPlayer.getCurrentPositionMs(), 0, 3, 0, t(), 10, null);
        }
        iSuperPlayer.reset();
        iSuperPlayer.release();
    }

    public final void y() {
        ISuperPlayer iSuperPlayer = this.videoPlayer;
        boolean z16 = false;
        if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
            z16 = true;
        }
        if (z16) {
            B();
            this.isPauseByLifecycle = true;
        }
    }

    public final void z() {
        if (l() && !this.isPauseByOffScreen) {
            if (this.isPauseByLifecycle || this.isPauseByLandingPage) {
                C();
                this.isPauseByLandingPage = false;
                this.isPauseByLifecycle = false;
            }
        }
    }
}
