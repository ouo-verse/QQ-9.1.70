package com.tencent.mobileqq.guild.feed.qqgame.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.AdError;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.video.GdtVideoView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001Y\u0018\u0000 r2\u00020\u00012\u00020\u0002:\u0001sB\u0011\b\u0016\u0012\u0006\u0010i\u001a\u00020h\u00a2\u0006\u0004\bj\u0010kB\u001b\b\u0016\u0012\u0006\u0010i\u001a\u00020h\u0012\b\u0010m\u001a\u0004\u0018\u00010l\u00a2\u0006\u0004\bj\u0010nB#\b\u0016\u0012\u0006\u0010i\u001a\u00020h\u0012\b\u0010m\u001a\u0004\u0018\u00010l\u0012\u0006\u0010p\u001a\u00020o\u00a2\u0006\u0004\bj\u0010qJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\nJ\u000e\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\nJ\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%R\u0016\u0010*\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010/R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010/R\u0016\u0010=\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010/R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00108R\u0018\u0010E\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00108R\u0016\u0010H\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010GR\u0016\u0010L\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010GR\u0016\u0010N\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0018\u0010Q\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010GR\u0016\u0010X\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010KR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R$\u0010g\u001a\u0004\u0018\u00010a8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\b2\u0010d\"\u0004\be\u0010f\u00a8\u0006t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/qqgame/view/GameAdVideoView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/gdtad/views/video/GdtVideoView$GdtVideoListener;", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "i", "", "f", "u", "", "milliseconds", "", "g", "o", "l", "srcUrl", "j", "Lcom/tencent/gdtad/views/video/GdtVideoData;", "k", ReportConstant.COSTREPORT_PREFIX, "", "pauseByUser", "t", "Lon1/b;", "gameFeedsData", "setVideoData", "Lcom/tencent/ad/tangram/AdError;", "adError", "onError", "onCompletion", "onVideoPrepared", "onFirstTimeLoopEnd", "onCurrentLoopStart", "onFirstFrameRendered", "source", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/feed/qqgame/view/d;", "videoPlayerListener", "setVideoPlayerListener", "d", "Lon1/b;", "mGameFeedsData", "Lcom/tencent/gdtad/views/video/GdtVideoView;", "e", "Lcom/tencent/gdtad/views/video/GdtVideoView;", "mVideoView", "Landroid/widget/FrameLayout;", "mVideoViewContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", h.F, "Landroidx/constraintlayout/widget/ConstraintLayout;", "mMediaContainerLayout", "mAdViewLayout", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mVideoCoverView", BdhLogUtil.LogTag.Tag_Conn, "mPauseLayout", "D", "mRootContainer", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mVideoTime", UserInfo.SEX_FEMALE, "mMuteIcon", "G", "mAdImageBg", "H", "Z", "mIsMute", "I", "mHasPrepared", "J", "mStartVideoAfterPrepare", "K", "mVideoStartPosMs", "L", "Lcom/tencent/mobileqq/guild/feed/qqgame/view/d;", "mVideoPlayerListener", "M", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "mThirdProcessorProxy", "N", "mIsPlaying", "P", "mVideoDuration", "com/tencent/mobileqq/guild/feed/qqgame/view/GameAdVideoView$mVideoProgressUpdateRunnable$1", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/feed/qqgame/view/GameAdVideoView$mVideoProgressUpdateRunnable$1;", "mVideoProgressUpdateRunnable", "Ljava/lang/Runnable;", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/Runnable;", "mTimeStatusRunnable", "Landroid/os/Handler;", ExifInterface.LATITUDE_SOUTH, "Landroid/os/Handler;", "()Landroid/os/Handler;", "setMProgressHandler", "(Landroid/os/Handler;)V", "mProgressHandler", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "T", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GameAdVideoView extends FrameLayout implements GdtVideoView.GdtVideoListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private FrameLayout mPauseLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private FrameLayout mRootContainer;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private TextView mVideoTime;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private ImageView mMuteIcon;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView mAdImageBg;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsMute;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mHasPrepared;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mStartVideoAfterPrepare;

    /* renamed from: K, reason: from kotlin metadata */
    private long mVideoStartPosMs;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private d mVideoPlayerListener;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private GdtThirdProcessorProxy mThirdProcessorProxy;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mIsPlaying;

    /* renamed from: P, reason: from kotlin metadata */
    private long mVideoDuration;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final GameAdVideoView$mVideoProgressUpdateRunnable$1 mVideoProgressUpdateRunnable;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Runnable mTimeStatusRunnable;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private Handler mProgressHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private on1.b mGameFeedsData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtVideoView mVideoView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FrameLayout mVideoViewContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ConstraintLayout mMediaContainerLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FrameLayout mAdViewLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView mVideoCoverView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GameAdVideoView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void f() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mTimeStatusRunnable, 4000L);
    }

    private final String g(long milliseconds) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long minutes = timeUnit.toMinutes(milliseconds);
        long seconds = timeUnit.toSeconds(milliseconds) - TimeUnit.MINUTES.toSeconds(minutes);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final GdtThirdProcessorProxy i() {
        if (this.mThirdProcessorProxy == null) {
            this.mThirdProcessorProxy = new GdtThirdProcessorProxy();
        }
        return this.mThirdProcessorProxy;
    }

    private final String j(String srcUrl) {
        boolean startsWith$default;
        boolean startsWith$default2;
        if (!TextUtils.isEmpty(srcUrl)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(srcUrl, "http", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(srcUrl, "https", false, 2, null);
                if (!startsWith$default2) {
                    QLog.w("GameAdVideoView", 1, "invalid url:" + srcUrl);
                    return "";
                }
            }
            return srcUrl;
        }
        return "";
    }

    private final GdtVideoData k() {
        QLog.i("GameAdVideoView", 1, "mVideoStartPosMs:" + this.mVideoStartPosMs);
        GdtVideoData gdtVideoData = new GdtVideoData();
        on1.b bVar = this.mGameFeedsData;
        on1.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameFeedsData");
            bVar = null;
        }
        String str = bVar.f423218f;
        Intrinsics.checkNotNullExpressionValue(str, "mGameFeedsData.sourceUrl");
        gdtVideoData.setUrl(j(str));
        on1.b bVar3 = this.mGameFeedsData;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameFeedsData");
            bVar3 = null;
        }
        gdtVideoData.setVid(bVar3.f423219g);
        gdtVideoData.setStartPositionMillis(this.mVideoStartPosMs);
        gdtVideoData.setLoop(true);
        gdtVideoData.setVolumOpen(false);
        gdtVideoData.setAd(null);
        gdtVideoData.setVideoDefaultBackgroundColor(0);
        on1.b bVar4 = this.mGameFeedsData;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameFeedsData");
        } else {
            bVar2 = bVar4;
        }
        String str2 = bVar2.f423220h;
        if (str2 == null) {
            str2 = "";
        }
        gdtVideoData.setCoverUrl(str2);
        if (QLog.isDevelopLevel()) {
            QLog.i("GameAdVideoView", 1, "videoData.video_url:" + gdtVideoData + ".url");
            QLog.i("GameAdVideoView", 1, "videoData.cover_url:" + gdtVideoData + ".coverUrl");
            QLog.i("GameAdVideoView", 1, "vid:" + gdtVideoData + ".vid");
        }
        return gdtVideoData;
    }

    private final void l() {
        QLog.i("GameAdVideoView", 1, "[initVideoView] begins");
        this.mHasPrepared = false;
        GdtVideoView gdtVideoView = new GdtVideoView(getContext(), k());
        this.mVideoView = gdtVideoView;
        gdtVideoView.addVideoListener(new WeakReference<>(this));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.mVideoViewContainer.getChildCount() > 0) {
            this.mVideoViewContainer.removeAllViews();
        }
        this.mVideoViewContainer.addView(this.mVideoView, layoutParams);
        this.mVideoViewContainer.setVisibility(0);
        GdtVideoView gdtVideoView2 = this.mVideoView;
        if (gdtVideoView2 != null) {
            gdtVideoView2.setVisibility(0);
        }
        GdtVideoView gdtVideoView3 = this.mVideoView;
        if (gdtVideoView3 != null) {
            gdtVideoView3.setVideoViewVisible(true);
        }
        QLog.i("GameAdVideoView", 1, "[initVideoView] ends");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GameAdVideoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mVideoTime.setVisibility(8);
    }

    private final void o() {
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
    public static final void r(GameAdVideoView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s() {
        boolean z16;
        long j3;
        QLog.i("GameAdVideoView", 1, "[startVideo]");
        if (this.mVideoView == null) {
            l();
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
            QLog.d("GameAdVideoView", 1, "startVideo return: not prepare");
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
        GdtVideoView gdtVideoView4 = this.mVideoView;
        if (gdtVideoView4 != null) {
            j3 = gdtVideoView4.getVideoDurationMs();
        } else {
            j3 = 0;
        }
        this.mVideoDuration = j3;
        this.mIsPlaying = true;
        Handler handler = this.mProgressHandler;
        if (handler != null) {
            handler.post(this.mVideoProgressUpdateRunnable);
        }
        d dVar = this.mVideoPlayerListener;
        if (dVar != null) {
            dVar.a();
        }
        QLog.d("GameAdVideoView", 1, "startVideo mProgressTime post runnable");
    }

    private final void t(boolean pauseByUser) {
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
        this.mPauseLayout.setVisibility(0);
        this.mVideoTime.setVisibility(0);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mTimeStatusRunnable);
        this.mIsPlaying = false;
        this.mVideoView = null;
        d dVar = this.mVideoPlayerListener;
        if (dVar != null) {
            dVar.b();
        }
        QLog.i("GameAdVideoView", 1, "stopVideo:" + this.mVideoStartPosMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        long j3;
        long j16 = this.mVideoDuration;
        GdtVideoView gdtVideoView = this.mVideoView;
        if (gdtVideoView != null) {
            j3 = gdtVideoView.getCurrentPositionMs();
        } else {
            j3 = 0;
        }
        this.mVideoTime.setText(g(j16 - j3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: h, reason: from getter */
    public final Handler getMProgressHandler() {
        return this.mProgressHandler;
    }

    public final void n() {
        QLog.i("GameAdVideoView", 1, "[onDestroy]");
        t(false);
        Handler handler = this.mProgressHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mVideoProgressUpdateRunnable);
        }
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onCompletion() {
        QLog.i("GameAdVideoView", 1, "[onCompletion]");
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onCurrentLoopStart() {
        QLog.i("GameAdVideoView", 1, "[onCurrentLoopStart]");
        this.mVideoTime.setVisibility(0);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mTimeStatusRunnable);
        f();
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onError(@Nullable AdError adError) {
        QLog.e("GameAdVideoView", 1, "[onError]");
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onFirstFrameRendered() {
        QLog.i("GameAdVideoView", 1, "[onFirstFrameRendered]");
        f();
        this.mVideoCoverView.setVisibility(4);
        this.mPauseLayout.setVisibility(4);
        this.mVideoTime.setVisibility(0);
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onVideoPrepared() {
        long j3;
        QLog.i("GameAdVideoView", 1, "[onVideoPrepared], mStartVideoAfterPrepare:" + this.mStartVideoAfterPrepare);
        this.mHasPrepared = true;
        if (this.mStartVideoAfterPrepare) {
            s();
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

    public final void p(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.i("GameAdVideoView", 1, "[onPause]:" + source);
        t(false);
    }

    public final void q(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.i("GameAdVideoView", 1, "[onResume]:" + source);
        s();
    }

    public final void setVideoData(@NotNull on1.b gameFeedsData) {
        on1.b bVar;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        Intrinsics.checkNotNullParameter(gameFeedsData, "gameFeedsData");
        QLog.i("GameAdVideoView", 1, "[setVideoData]");
        this.mGameFeedsData = gameFeedsData;
        Drawable drawable = null;
        if (gameFeedsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameFeedsData");
            bVar = null;
        } else {
            bVar = gameFeedsData;
        }
        if (bVar.f423217e == 2) {
            Pair<Integer, Integer> f16 = GuildFeedMediaSizeUtils.f219296d.f(5, 7);
            ConstraintLayout constraintLayout = this.mMediaContainerLayout;
            if (constraintLayout != null) {
                layoutParams2 = constraintLayout.getLayoutParams();
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                layoutParams2.width = f16.getFirst().intValue();
            }
            ViewGroup.LayoutParams layoutParams3 = this.mAdViewLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams3).dimensionRatio = "5:7";
            QLog.i("GameAdVideoView", 1, "change ratio to 5:7, videoSize.first:" + f16.getFirst());
        } else {
            Pair<Integer, Integer> f17 = GuildFeedMediaSizeUtils.f219296d.f(16, 9);
            ConstraintLayout constraintLayout2 = this.mMediaContainerLayout;
            if (constraintLayout2 != null) {
                layoutParams = constraintLayout2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.width = f17.getFirst().intValue();
            }
            QLog.i("GameAdVideoView", 1, "video ratio is 16:9, videoSize.first:" + f17.getFirst());
        }
        try {
            on1.b bVar2 = this.mGameFeedsData;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameFeedsData");
                bVar2 = null;
            }
            String str = bVar2.f423220h;
            if (!TextUtils.isEmpty(str)) {
                QLog.e("GameAdVideoView", 1, "bindData image url is empty");
                String uri = Uri.parse(str).buildUpon().appendQueryParameter(VasProfileTemplatePreloadHelper.BACKGROUND, "blur").build().toString();
                Intrinsics.checkNotNullExpressionValue(uri, "parse(adImageUrl).buildU\u2026blur\").build().toString()");
                ImageView imageView = this.mAdImageBg;
                if (imageView != null) {
                    GdtThirdProcessorProxy i3 = i();
                    if (i3 != null) {
                        drawable = i3.getPreViewImage(getContext(), uri);
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        } catch (Throwable th5) {
            QLog.e("GameAdVideoView", 1, "[setVideoData], th:", th5);
        }
        String str2 = gameFeedsData.f423220h;
        if (str2 == null) {
            str2 = "";
        }
        this.mVideoCoverView.setImageDrawable(GdtUIUtils.getUrlDrawable(str2));
        new FrameLayout.LayoutParams(-1, -1).gravity = 17;
        this.mVideoCoverView.setVisibility(0);
        this.mIsMute = true;
        this.mMuteIcon.setImageResource(R.drawable.qui_voice_mute_icon_white);
        this.mMuteIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.qqgame.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameAdVideoView.r(GameAdVideoView.this, view);
            }
        });
        GdtUIUtils.setViewRadius(this.mAdViewLayout, 6.0f);
        u();
        if (this.mIsPlaying) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mTimeStatusRunnable);
        }
        FontSettingManager.resetViewSize2Normal(getContext(), this.mMediaContainerLayout);
    }

    public final void setVideoPlayerListener(@NotNull d videoPlayerListener) {
        Intrinsics.checkNotNullParameter(videoPlayerListener, "videoPlayerListener");
        this.mVideoPlayerListener = videoPlayerListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GameAdVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.tencent.mobileqq.guild.feed.qqgame.view.GameAdVideoView$mVideoProgressUpdateRunnable$1] */
    public GameAdVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsMute = true;
        View.inflate(getContext(), R.layout.eog, this);
        View findViewById = findViewById(R.id.vkm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.gamece\u2026_video_ad_root_container)");
        this.mRootContainer = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.vki);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.gamece\u2026video_ad_media_container)");
        this.mVideoViewContainer = (FrameLayout) findViewById2;
        this.mMediaContainerLayout = (ConstraintLayout) findViewById(R.id.vk6);
        View findViewById3 = findViewById(R.id.vkh);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.gamecenter_video_ad_layout)");
        this.mAdViewLayout = (FrameLayout) findViewById3;
        View findViewById4 = findViewById(R.id.vkf);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.gamecenter_video_ad_image)");
        this.mVideoCoverView = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.vkk);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.gamece\u2026o_ad_play_icon_container)");
        this.mPauseLayout = (FrameLayout) findViewById5;
        View findViewById6 = findViewById(R.id.vkl);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.gamece\u2026r_video_ad_progress_time)");
        this.mVideoTime = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.vko);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.gamecenter_video_ad_voice_icon)");
        this.mMuteIcon = (ImageView) findViewById7;
        this.mAdImageBg = (ImageView) findViewById(R.id.vkg);
        QLog.i("GameAdVideoView", 1, "[init] finished");
        this.mVideoProgressUpdateRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.qqgame.view.GameAdVideoView$mVideoProgressUpdateRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                GdtVideoView gdtVideoView;
                boolean z16;
                gdtVideoView = GameAdVideoView.this.mVideoView;
                boolean z17 = false;
                if (gdtVideoView != null && !gdtVideoView.isPlaying()) {
                    z17 = true;
                }
                if (!z17) {
                    z16 = GameAdVideoView.this.mIsPlaying;
                    if (z16) {
                        GameAdVideoView.this.u();
                        Handler mProgressHandler = GameAdVideoView.this.getMProgressHandler();
                        if (mProgressHandler != null) {
                            mProgressHandler.postDelayed(this, 1000L);
                            return;
                        }
                        return;
                    }
                }
                Handler mProgressHandler2 = GameAdVideoView.this.getMProgressHandler();
                if (mProgressHandler2 != null) {
                    mProgressHandler2.removeCallbacks(this);
                }
            }
        };
        this.mTimeStatusRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.qqgame.view.c
            @Override // java.lang.Runnable
            public final void run() {
                GameAdVideoView.m(GameAdVideoView.this);
            }
        };
        this.mProgressHandler = ThreadManagerV2.getUIHandlerV2();
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onFirstTimeLoopEnd() {
    }
}
