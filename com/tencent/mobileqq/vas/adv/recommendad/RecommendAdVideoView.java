package com.tencent.mobileqq.vas.adv.recommendad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.AdError;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.video.GdtVideoView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0002NOB\u0011\b\u0016\u0012\u0006\u0010D\u001a\u00020C\u00a2\u0006\u0004\bE\u0010FB\u001b\b\u0016\u0012\u0006\u0010D\u001a\u00020C\u0012\b\u0010H\u001a\u0004\u0018\u00010G\u00a2\u0006\u0004\bE\u0010IB#\b\u0016\u0012\u0006\u0010D\u001a\u00020C\u0012\b\u0010H\u001a\u0004\u0018\u00010G\u0012\u0006\u0010K\u001a\u00020J\u00a2\u0006\u0004\bE\u0010LJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0017J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0003H\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010$R\u0016\u0010'\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00106R\u0016\u0010?\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00106R\u0016\u0010B\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdVideoView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/gdtad/views/video/GdtVideoView$GdtVideoListener;", "", "g", "r", "", "pauseByUser", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "i", "Lcom/tencent/gdtad/views/video/GdtVideoData;", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "setVideoData", "k", "j", "l", tl.h.F, "o", "", "e", "Lcom/tencent/ad/tangram/AdError;", "adError", "onError", "onCompletion", "onVideoPrepared", "onFirstTimeLoopEnd", "onCurrentLoopStart", "onFirstFrameRendered", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "Lcom/tencent/gdtad/views/video/GdtVideoView;", "Lcom/tencent/gdtad/views/video/GdtVideoView;", "mVideoView", "Landroid/widget/FrameLayout;", "mVideoViewContainer", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdCoverView;", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdCoverView;", "mVideoCoverView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mVideoTimeMute", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mVideoTime", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mMuteIcon", "D", "Z", "mIsMute", "Ljava/util/Timer;", "E", "Ljava/util/Timer;", "mTimer", UserInfo.SEX_FEMALE, "mHasPrepared", "G", "mStartVideoAfterPrepare", "H", "J", "mVideoStartPosMs", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "I", "a", "TimeUpdateTimerTask", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class RecommendAdVideoView extends FrameLayout implements GdtVideoView.GdtVideoListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ImageView mMuteIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsMute;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Timer mTimer;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mHasPrepared;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mStartVideoAfterPrepare;

    /* renamed from: H, reason: from kotlin metadata */
    private long mVideoStartPosMs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtAd mAd;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtVideoView mVideoView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FrameLayout mVideoViewContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RecommendAdCoverView mVideoCoverView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout mVideoTimeMute;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mVideoTime;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdVideoView$TimeUpdateTimerTask;", "Ljava/util/TimerTask;", "", TencentLocation.RUN_MODE, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdVideoView;", "d", "Lmqq/util/WeakReference;", "mRecommendAdVideoViewWeakRef", "recommendAdVideoView", "<init>", "(Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdVideoView;)V", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class TimeUpdateTimerTask extends TimerTask {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<RecommendAdVideoView> mRecommendAdVideoViewWeakRef;

        public TimeUpdateTimerTask(@NotNull RecommendAdVideoView recommendAdVideoView) {
            Intrinsics.checkNotNullParameter(recommendAdVideoView, "recommendAdVideoView");
            this.mRecommendAdVideoViewWeakRef = new WeakReference<>(recommendAdVideoView);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            RecommendAdVideoView recommendAdVideoView = this.mRecommendAdVideoViewWeakRef.get();
            if (recommendAdVideoView != null) {
                recommendAdVideoView.m();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendAdVideoView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mTimer = null;
    }

    private final GdtVideoData f() {
        String str;
        long j3;
        GdtImageData imageData;
        String str2;
        GdtVideoData gdtVideoData = new GdtVideoData();
        GdtAd gdtAd = this.mAd;
        String str3 = "";
        if (gdtAd == null || (str = gdtAd.getVideoUrl()) == null) {
            str = "";
        }
        gdtVideoData.setUrl(str);
        gdtVideoData.setStartPositionMillis(this.mVideoStartPosMs);
        gdtVideoData.setLoop(true);
        gdtVideoData.setVolumOpen(false);
        gdtVideoData.setAd(this.mAd);
        gdtVideoData.setVideoDefaultBackgroundColor(0);
        GdtAd gdtAd2 = this.mAd;
        if (gdtAd2 != null && (imageData = gdtAd2.getImageData()) != null && (str2 = imageData.url) != null) {
            str3 = str2;
        }
        gdtVideoData.setCoverUrl(str3);
        GdtAd gdtAd3 = this.mAd;
        if (gdtAd3 != null) {
            j3 = gdtAd3.getVideoDuration();
        } else {
            j3 = 0;
        }
        gdtVideoData.setDurationMillis(j3);
        return gdtVideoData;
    }

    private final void g() {
        this.mHasPrepared = false;
        GdtVideoData f16 = f();
        f16.getUrl();
        GdtVideoView gdtVideoView = new GdtVideoView(getContext(), f16);
        this.mVideoView = gdtVideoView;
        gdtVideoView.addVideoListener(new WeakReference<>(this));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.mVideoViewContainer.getChildCount() > 0) {
            this.mVideoViewContainer.removeAllViews();
        }
        this.mVideoViewContainer.addView(this.mVideoView, layoutParams);
        GdtVideoView gdtVideoView2 = this.mVideoView;
        if (gdtVideoView2 != null) {
            gdtVideoView2.setVisibility(0);
        }
        GdtVideoView gdtVideoView3 = this.mVideoView;
        if (gdtVideoView3 != null) {
            gdtVideoView3.setVideoViewVisible(true);
        }
    }

    private final void i() {
        boolean z16 = !this.mIsMute;
        this.mIsMute = z16;
        if (z16) {
            this.mMuteIcon.setImageResource(R.drawable.qui_voice_mute_icon_white);
        } else {
            this.mMuteIcon.setImageResource(R.drawable.qui_voice_high_icon_white);
        }
        GdtVideoView gdtVideoView = this.mVideoView;
        if (gdtVideoView != null) {
            gdtVideoView.setVolumeState(!this.mIsMute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        GdtVideoView gdtVideoView;
        long j3;
        long j16;
        GdtVideoView gdtVideoView2 = this.mVideoView;
        boolean z16 = false;
        if (gdtVideoView2 != null && gdtVideoView2.isPlaying()) {
            z16 = true;
        }
        if (z16 && (gdtVideoView = this.mVideoView) != null) {
            if (gdtVideoView != null) {
                j3 = gdtVideoView.getCurrentPositionMs();
            } else {
                j3 = 0;
            }
            GdtVideoView gdtVideoView3 = this.mVideoView;
            if (gdtVideoView3 != null) {
                j16 = gdtVideoView3.getVideoDurationMs();
            } else {
                j16 = 0;
            }
            if (j3 != 0 && j16 != 0) {
                final long j17 = j16 - j3;
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.recommendad.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecommendAdVideoView.n(RecommendAdVideoView.this, j17);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(RecommendAdVideoView this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mVideoTime.setText(GdtUIUtils.getSocialMinSeconds((int) j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(RecommendAdVideoView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
        BaseTimer baseTimer = new BaseTimer();
        this.mTimer = baseTimer;
        baseTimer.schedule(new TimeUpdateTimerTask(this), 0L, 33L);
    }

    private final void r() {
        boolean z16;
        if (this.mVideoView == null) {
            g();
        }
        GdtVideoView gdtVideoView = this.mVideoView;
        if (gdtVideoView != null && gdtVideoView.isPlaying()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (!this.mHasPrepared) {
            this.mStartVideoAfterPrepare = true;
            QLog.d("RecommendAdVideoView", 1, "startVideo return: not prepare");
            return;
        }
        GdtVideoView gdtVideoView2 = this.mVideoView;
        if (gdtVideoView2 != null) {
            gdtVideoView2.play(false);
        }
        GdtVideoView gdtVideoView3 = this.mVideoView;
        if (gdtVideoView3 != null) {
            gdtVideoView3.setVolumeState(!this.mIsMute);
        }
        q();
    }

    private final void s(boolean pauseByUser) {
        long j3;
        GdtVideoView gdtVideoView = this.mVideoView;
        if (gdtVideoView == null) {
            return;
        }
        if (gdtVideoView != null) {
            j3 = gdtVideoView.getCurrentPositionMs();
        } else {
            j3 = 0;
        }
        this.mVideoStartPosMs = j3;
        GdtVideoView gdtVideoView2 = this.mVideoView;
        if (gdtVideoView2 != null) {
            gdtVideoView2.pause(pauseByUser);
        }
        GdtVideoView gdtVideoView3 = this.mVideoView;
        if (gdtVideoView3 != null) {
            gdtVideoView3.destroy();
        }
        this.mVideoCoverView.setVisibility(0);
        d();
        this.mVideoView = null;
    }

    public final long e() {
        GdtVideoView gdtVideoView = this.mVideoView;
        if (gdtVideoView != null) {
            return gdtVideoView.getCurrentPositionMs();
        }
        return 0L;
    }

    public final void h() {
        s(false);
    }

    public final void j() {
        s(false);
    }

    public final void k() {
        r();
    }

    public final void l() {
        s(false);
    }

    public final void o() {
        GdtVideoView gdtVideoView = this.mVideoView;
        if (gdtVideoView != null) {
            gdtVideoView.click();
        }
        s(true);
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onFirstFrameRendered() {
        this.mVideoCoverView.setVisibility(4);
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onVideoPrepared() {
        long j3;
        this.mHasPrepared = true;
        if (this.mStartVideoAfterPrepare) {
            r();
        }
        TextView textView = this.mVideoTime;
        GdtVideoView gdtVideoView = this.mVideoView;
        if (gdtVideoView != null) {
            j3 = gdtVideoView.getVideoDurationMs();
        } else {
            j3 = 0;
        }
        textView.setText(GdtUIUtils.getSocialMinSeconds((int) j3));
    }

    public final void setVideoData(@NotNull GdtAd ad5) {
        String str;
        GdtImageData imageData;
        Intrinsics.checkNotNullParameter(ad5, "ad");
        this.mAd = ad5;
        if (ad5 != null && (imageData = ad5.getImageData()) != null) {
            str = imageData.url;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        Drawable imageDrawable = GdtUIUtils.getUrlDrawable(str);
        RecommendAdCoverView recommendAdCoverView = this.mVideoCoverView;
        Intrinsics.checkNotNullExpressionValue(imageDrawable, "imageDrawable");
        recommendAdCoverView.setImageDrawable(imageDrawable);
        new FrameLayout.LayoutParams(-1, -1).gravity = 17;
        this.mVideoCoverView.setVisibility(0);
        this.mIsMute = true;
        this.mMuteIcon.setImageResource(R.drawable.qui_voice_mute_icon_white);
        this.mVideoTimeMute.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.adv.recommendad.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecommendAdVideoView.p(RecommendAdVideoView.this, view);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendAdVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendAdVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsMute = true;
        View.inflate(getContext(), R.layout.hmt, this);
        View findViewById = findViewById(R.id.f71133nb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.recomm\u2026_ad_video_view_container)");
        this.mVideoViewContainer = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.f71093n8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.recommend_ad_video_cover_view)");
        this.mVideoCoverView = (RecommendAdCoverView) findViewById2;
        View findViewById3 = findViewById(R.id.f71123na);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.recomm\u2026_ad_video_time_mute_view)");
        this.mVideoTimeMute = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.f71113n_);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.recommend_ad_video_time)");
        this.mVideoTime = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f71103n9);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.recommend_ad_video_mute_icon)");
        this.mMuteIcon = (ImageView) findViewById5;
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onCompletion() {
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onCurrentLoopStart() {
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onFirstTimeLoopEnd() {
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onError(@Nullable AdError adError) {
    }
}
