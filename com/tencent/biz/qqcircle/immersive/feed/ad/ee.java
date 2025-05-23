package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u0080\u00012\u00020\u0001:\u0004\u0081\u0001\u0082\u0001B\u0007\u00a2\u0006\u0004\b~\u0010\u007fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\u001a\u0010 \u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J\u0012\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010$\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010%\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010&\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016R\u0016\u0010)\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00104R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00108R\u0018\u0010G\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u00108R\u0018\u0010I\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010BR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u00108R\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u00108R\u0018\u0010W\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u00108R\u0018\u0010Y\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010RR\u0018\u0010[\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010RR\u0018\u0010]\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010RR\u0018\u0010_\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010RR\u0018\u0010a\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010RR\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010g\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010BR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010s\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010pR\u0018\u0010u\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010pR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010{\u001a\u00020v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010xR\u0016\u0010}\u001a\u00020v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010x\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/ee;", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSFeedChildAdCardPresenter;", "", "j2", "l2", "", "y", "z2", "k2", "w2", "y2", "E2", "F2", "M2", "x2", "", "text", "", "lines", "", "v2", Constants.MMCCID, "i2", "t2", "o2", "q2", ICustomDataEditor.NUMBER_PARAM_2, "p2", ICustomDataEditor.STRING_PARAM_2, "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "position", Constants.BASE_IN_PLUGIN_ID, "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedUnSelected", "onPaused", "onResumed", "onFeedSelected", "p0", "Z", "mIsTransparentCard", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/ee$b;", "q0", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/ee$b;", "mExternalTagInfo", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "r0", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "mAdBannerAuthorAvatarView", "Landroid/view/ViewGroup;", "s0", "Landroid/view/ViewGroup;", "mAdBigBannerTitleAndExternalTagContainer", "Landroid/widget/TextView;", "t0", "Landroid/widget/TextView;", "mAdBigBannerTitle", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "u0", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "mAdBigBannerPupDes", "v0", "mAdBigBannerExternalTagContainer", "Landroid/widget/ImageView;", "w0", "Landroid/widget/ImageView;", "mAdBigBannerExternalTagLeftIcon", "x0", "mAdBigBannerExternalTagGameTv", "y0", "mAdBigBannerExternalTagTagTv", "z0", "mAdBigBannerFeedBack", "Landroid/widget/FrameLayout;", "A0", "Landroid/widget/FrameLayout;", "mAdBigBannerButton", "B0", "mAdBigBannerButtonText", "Landroid/view/View;", "C0", "Landroid/view/View;", "bottomActionBtn", "D0", "bannerHint", "E0", "bannerTv", "F0", "author", "G0", "content", "H0", "feedback", "I0", "adFeedInfo", "J0", "bigCard", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "K0", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "bottomShakeIcon", "L0", "bigCardShakeIcon", "M0", "bigCardCloseBtn", "Landroid/graphics/drawable/Drawable;", "N0", "Landroid/graphics/drawable/Drawable;", "mFeedBackDrawable", "Landroid/animation/ValueAnimator;", "O0", "Landroid/animation/ValueAnimator;", "showBottomBannerAnim", "P0", "showBigCardAnim", "Q0", "hideBigCardAnim", "Ljava/lang/Runnable;", "R0", "Ljava/lang/Runnable;", "mCurrentRunnable", "S0", "showBottomBannerRunnable", "T0", "showBigCardRunnable", "<init>", "()V", "U0", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ee extends QFSFeedChildAdCardPresenter {

    @NotNull
    private static final a U0 = new a(null);

    /* renamed from: A0, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mAdBigBannerButton;

    /* renamed from: B0, reason: from kotlin metadata */
    @Nullable
    private TextView mAdBigBannerButtonText;

    /* renamed from: C0, reason: from kotlin metadata */
    @Nullable
    private View bottomActionBtn;

    /* renamed from: D0, reason: from kotlin metadata */
    @Nullable
    private TextView bannerHint;

    /* renamed from: E0, reason: from kotlin metadata */
    @Nullable
    private TextView bannerTv;

    /* renamed from: F0, reason: from kotlin metadata */
    @Nullable
    private View author;

    /* renamed from: G0, reason: from kotlin metadata */
    @Nullable
    private View content;

    /* renamed from: H0, reason: from kotlin metadata */
    @Nullable
    private View feedback;

    /* renamed from: I0, reason: from kotlin metadata */
    @Nullable
    private View adFeedInfo;

    /* renamed from: J0, reason: from kotlin metadata */
    @Nullable
    private View bigCard;

    /* renamed from: K0, reason: from kotlin metadata */
    @Nullable
    private GdtShakeIconView bottomShakeIcon;

    /* renamed from: L0, reason: from kotlin metadata */
    @Nullable
    private GdtShakeIconView bigCardShakeIcon;

    /* renamed from: M0, reason: from kotlin metadata */
    @Nullable
    private ImageView bigCardCloseBtn;

    /* renamed from: N0, reason: from kotlin metadata */
    @Nullable
    private Drawable mFeedBackDrawable;

    /* renamed from: O0, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator showBottomBannerAnim;

    /* renamed from: P0, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator showBigCardAnim;

    /* renamed from: Q0, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator hideBigCardAnim;

    /* renamed from: R0, reason: from kotlin metadata */
    @Nullable
    private Runnable mCurrentRunnable;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsTransparentCard;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleAvatarView mAdBannerAuthorAvatarView;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mAdBigBannerTitleAndExternalTagContainer;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBigBannerTitle;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleAsyncTextView mAdBigBannerPupDes;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mAdBigBannerExternalTagContainer;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mAdBigBannerExternalTagLeftIcon;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBigBannerExternalTagGameTv;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBigBannerExternalTagTagTv;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mAdBigBannerFeedBack;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b mExternalTagInfo = new b("", "", false, null);

    /* renamed from: S0, reason: from kotlin metadata */
    @NotNull
    private Runnable showBottomBannerRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ds
        @Override // java.lang.Runnable
        public final void run() {
            ee.C2(ee.this);
        }
    };

    /* renamed from: T0, reason: from kotlin metadata */
    @NotNull
    private Runnable showBigCardRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dv
        @Override // java.lang.Runnable
        public final void run() {
            ee.A2(ee.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/ee$a;", "", "", "BOTTOM_BANNER_HINT_TEXT", "Ljava/lang/String;", "", "DP_BOTTOM_BANNER_HEIGHT", UserInfo.SEX_FEMALE, "ELLIPSIS_NORMAL", "FEEDBACK_SPACE", "TAG", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0007\b\u0082\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\tB/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u000e\u0010\u0012R\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\t\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/ee$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "gameTxt", "b", "d", "tagTxt", "Z", "()Z", "dismissCloseButton", "", "Ljava/util/List;", "()Ljava/util/List;", "clientAdTypes", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "e", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final /* data */ class b {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String gameTxt;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tagTxt;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean dismissCloseButton;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final List<String> clientAdTypes;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/ee$b$a;", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "adFeed", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/ee$b;", "a", "", "BIG_CARD_TOP_GAME_TXT_KEY", "Ljava/lang/String;", "BIG_CARD_TOP_TAG_TXT_KEY", "CLIENT_AD_TYPES_GAME_DOWNLOAD", "CLIENT_AD_TYPES_KEY", "CLIENT_AD_TYPES_WX_MINI_GAME", "IS_DELETE_BIG_CARD_CLOSE_BUTTON_KEY", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.biz.qqcircle.immersive.feed.ad.ee$b$a, reason: from kotlin metadata */
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final b a(@Nullable FeedCloudMeta$StFeed adFeed) {
                List<FeedCloudCommon$Entry> list;
                PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField;
                List list2 = null;
                if (adFeed != null && (pBRepeatMessageField = adFeed.extInfo) != null) {
                    list = pBRepeatMessageField.get();
                } else {
                    list = null;
                }
                if (list == null) {
                    return new b("", "", false, null);
                }
                String d16 = com.tencent.biz.qqcircle.utils.bh.d(list, "bigCardTopGameTxtKey");
                Intrinsics.checkNotNullExpressionValue(d16, "getValueFromExtInfo(extI\u2026IG_CARD_TOP_GAME_TXT_KEY)");
                String d17 = com.tencent.biz.qqcircle.utils.bh.d(list, "bigCardTopTagTxtKey");
                Intrinsics.checkNotNullExpressionValue(d17, "getValueFromExtInfo(extI\u2026BIG_CARD_TOP_TAG_TXT_KEY)");
                boolean areEqual = Intrinsics.areEqual(com.tencent.biz.qqcircle.utils.bh.d(list, "isDeleteBigCardCloseButtonKey"), "1");
                String d18 = com.tencent.biz.qqcircle.utils.bh.d(list, "clientAdTypesKey");
                if (d18 != null) {
                    list2 = StringsKt__StringsKt.split$default((CharSequence) d18, new String[]{"|"}, false, 0, 6, (Object) null);
                }
                return new b(d16, d17, areEqual, list2);
            }

            Companion() {
            }
        }

        public b(@NotNull String gameTxt, @NotNull String tagTxt, boolean z16, @Nullable List<String> list) {
            Intrinsics.checkNotNullParameter(gameTxt, "gameTxt");
            Intrinsics.checkNotNullParameter(tagTxt, "tagTxt");
            this.gameTxt = gameTxt;
            this.tagTxt = tagTxt;
            this.dismissCloseButton = z16;
            this.clientAdTypes = list;
        }

        @Nullable
        public final List<String> a() {
            return this.clientAdTypes;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getDismissCloseButton() {
            return this.dismissCloseButton;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getGameTxt() {
            return this.gameTxt;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getTagTxt() {
            return this.tagTxt;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.gameTxt, bVar.gameTxt) && Intrinsics.areEqual(this.tagTxt, bVar.tagTxt) && this.dismissCloseButton == bVar.dismissCloseButton && Intrinsics.areEqual(this.clientAdTypes, bVar.clientAdTypes)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.gameTxt.hashCode() * 31) + this.tagTxt.hashCode()) * 31;
            boolean z16 = this.dismissCloseButton;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode2 + i3) * 31;
            List<String> list = this.clientAdTypes;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return i16 + hashCode;
        }

        @NotNull
        public String toString() {
            String str;
            String str2 = this.gameTxt;
            String str3 = this.tagTxt;
            boolean z16 = this.dismissCloseButton;
            List<String> list = this.clientAdTypes;
            if (list != null) {
                str = CollectionsKt___CollectionsKt.joinToString$default(list, "|", null, null, 0, null, null, 62, null);
            } else {
                str = null;
            }
            return "TransparentCardExternalTagInfo(gameTxt=" + str2 + ", tagTxt=" + str3 + ", dismissCloseButton=" + z16 + ", clientAdTypes=" + str + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/ad/ee$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f85678e;

        c(float f16) {
            this.f85678e = f16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            View view = ee.this.adFeedInfo;
            if (view != null) {
                view.setTranslationX(0.0f);
            }
            View view2 = ee.this.f85346b0;
            if (view2 != null) {
                view2.setTranslationX(-this.f85678e);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            af.n0(ee.this.bigCardShakeIcon);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            View view = ee.this.adFeedInfo;
            if (view != null) {
                view.setVisibility(0);
            }
            if (af.Z(ee.this.W)) {
                af.m0(ee.this.bottomShakeIcon);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/ad/ee$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f85680e;

        d(float f16) {
            this.f85680e = f16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            View view = ee.this.adFeedInfo;
            if (view != null) {
                view.setTranslationX(0.0f);
            }
            View view2 = ee.this.f85346b0;
            if (view2 != null) {
                view2.setTranslationX(-this.f85680e);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            af.n0(ee.this.bottomShakeIcon);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            View view = ee.this.f85346b0;
            if (view != null) {
                view.setVisibility(0);
            }
            if (af.Z(ee.this.W)) {
                af.m0(ee.this.bigCardShakeIcon);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/ad/ee$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            ee.this.z2(0.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            ee.this.E2();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            View view = ee.this.bottomActionBtn;
            if (view != null) {
                view.setVisibility(0);
            }
            if (af.Z(ee.this.W)) {
                af.m0(ee.this.bottomShakeIcon);
                ee eeVar = ee.this;
                eeVar.T0(new com.tencent.biz.qqcircle.immersive.feed.event.c(eeVar.W.getTraceId(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2(final ee this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mCurrentRunnable = null;
        final float p16 = af.p();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, p16);
        this$0.showBigCardAnim = ofFloat;
        if (ofFloat != null) {
            ofFloat.setInterpolator(new DecelerateInterpolator());
        }
        ValueAnimator valueAnimator = this$0.showBigCardAnim;
        if (valueAnimator != null) {
            valueAnimator.setDuration(300L);
        }
        ValueAnimator valueAnimator2 = this$0.showBigCardAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dw
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ee.B2(ee.this, p16, valueAnimator3);
                }
            });
        }
        ValueAnimator valueAnimator3 = this$0.showBigCardAnim;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new d(p16));
        }
        ValueAnimator valueAnimator4 = this$0.showBigCardAnim;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
        QLog.d("QFSFeedChildTransparentCardPresenter", 1, "[showBigCardAnim] start");
        com.tencent.biz.qqcircle.immersive.utils.d.f90201a.n("threecard", "3");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B2(ee this$0, float f16, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.adFeedInfo;
        if (view != null) {
            view.setTranslationX(-floatValue);
        }
        View view2 = this$0.f85346b0;
        if (view2 != null) {
            view2.setTranslationX(floatValue - f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(final ee this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j2();
        this$0.mCurrentRunnable = null;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(com.tencent.biz.qqcircle.utils.cx.a(32.0f), 0.0f);
        this$0.showBottomBannerAnim = ofFloat;
        if (ofFloat != null) {
            ofFloat.addListener(new e());
        }
        ValueAnimator valueAnimator = this$0.showBottomBannerAnim;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dx
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    ee.D2(ee.this, valueAnimator2);
                }
            });
        }
        ValueAnimator valueAnimator2 = this$0.showBottomBannerAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(250L);
        }
        ValueAnimator valueAnimator3 = this$0.showBottomBannerAnim;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
        QLog.d("QFSFeedChildTransparentCardPresenter", 1, "[showBottomBannerAnim] start");
        com.tencent.biz.qqcircle.immersive.utils.d.f90201a.n("threecard", "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D2(ee this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.z2(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E2() {
        long j3 = 1000;
        long j16 = (this.X.createTimeNs.get() * j3) + (this.X.syncTime.get() * j3);
        x0().removeCallbacks(this.showBigCardRunnable);
        x0().postDelayed(this.showBigCardRunnable, j16);
        this.mCurrentRunnable = this.showBigCardRunnable;
    }

    private final void F2() {
        long j3 = this.X.createTime.get() * 1000;
        x0().removeCallbacks(this.showBottomBannerRunnable);
        x0().postDelayed(this.showBottomBannerRunnable, j3);
        this.mCurrentRunnable = this.showBottomBannerRunnable;
    }

    private final void G2() {
        int i3;
        String str;
        boolean contains$default;
        int i16;
        List split$default;
        String str2;
        ImageView imageView;
        i2();
        TextView textView = this.mAdBigBannerTitle;
        if (textView != null) {
            textView.setTextColor(m0().getColor(R.color.cla));
        }
        QCircleAvatarView qCircleAvatarView = this.mAdBannerAuthorAvatarView;
        boolean z16 = false;
        if (qCircleAvatarView != null) {
            i3 = qCircleAvatarView.getWidth();
        } else {
            i3 = 0;
        }
        String str3 = this.X.poster.icon.iconUrl.get();
        if (!TextUtils.isEmpty(str3)) {
            Option requestHeight = Option.obtain().setRequestWidth(i3).setRequestHeight(i3);
            QCircleAvatarView qCircleAvatarView2 = this.mAdBannerAuthorAvatarView;
            if (qCircleAvatarView2 != null) {
                imageView = qCircleAvatarView2.k();
            } else {
                imageView = null;
            }
            Option regionWidth = requestHeight.setTargetView(imageView).setUrl(str3).setRegionHeight(i3).setRegionWidth(i3);
            regionWidth.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(regionWidth);
        }
        TextView textView2 = this.mAdBigBannerTitle;
        if (textView2 != null) {
            textView2.setText(this.X.poster.nick.get());
        }
        String contentText = this.X.content.get();
        if (com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.k(this.E)) {
            str = " \u8fbe\u4eba\u5171\u4eab";
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(contentText, "contentText");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) contentText, (CharSequence) "\n", false, 2, (Object) null);
        if (contains$default) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) contentText, new String[]{"\n"}, false, 0, 6, (Object) null);
            if (v2(split$default.get(0) + str + "  ", 1)) {
                if (!v2(r8, 2)) {
                    str2 = split$default.get(0) + "\u2026";
                } else {
                    str2 = (String) split$default.get(0);
                }
                contentText = str2;
            } else {
                boolean z17 = !v2(split$default.get(1) + str + "  ", 1);
                contentText = split$default.get(0) + "\n" + split$default.get(1);
                if (z17) {
                    contentText = contentText + "\u2026";
                }
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(contentText);
        spannableStringBuilder.append((CharSequence) "  ");
        s2();
        QCircleAsyncTextView.e(spannableStringBuilder, spannableStringBuilder.length(), this.mFeedBackDrawable);
        QCircleAsyncTextView qCircleAsyncTextView = this.mAdBigBannerPupDes;
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.showEllipseEndImageSpan(true);
        }
        this.f85345a0.listenOnTouchEvent(this.mAdBigBannerPupDes);
        QCircleAsyncTextView qCircleAsyncTextView2 = this.mAdBigBannerPupDes;
        if (qCircleAsyncTextView2 != null) {
            qCircleAsyncTextView2.d(spannableStringBuilder, 0, spannableStringBuilder.length() - 1, new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dz
                @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                public final void onClick() {
                    ee.K2(ee.this);
                }
            }, R.color.cl7, false);
        }
        QCircleAsyncTextView qCircleAsyncTextView3 = this.mAdBigBannerPupDes;
        if (qCircleAsyncTextView3 != null) {
            qCircleAsyncTextView3.d(spannableStringBuilder, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ea
                @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                public final void onClick() {
                    ee.L2(ee.this);
                }
            }, R.color.cl7, false);
        }
        QCircleAsyncTextView qCircleAsyncTextView4 = this.mAdBigBannerPupDes;
        if (qCircleAsyncTextView4 != null) {
            qCircleAsyncTextView4.setOnTriggerEllipseListener(new RFWAsyncRichTextView.OnTriggerEllipseListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.eb
                @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnTriggerEllipseListener
                public final void triggerEllipse() {
                    ee.H2(ee.this);
                }
            });
        }
        QCircleAsyncTextView qCircleAsyncTextView5 = this.mAdBigBannerPupDes;
        if (qCircleAsyncTextView5 != null) {
            qCircleAsyncTextView5.setPreloadParserInfo(null);
        }
        QCircleAsyncTextView qCircleAsyncTextView6 = this.mAdBigBannerPupDes;
        if (qCircleAsyncTextView6 != null) {
            qCircleAsyncTextView6.setText(spannableStringBuilder);
        }
        ImageView imageView2 = this.mAdBigBannerFeedBack;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        QCircleAsyncTextView qCircleAsyncTextView7 = this.mAdBigBannerPupDes;
        if (qCircleAsyncTextView7 != null) {
            qCircleAsyncTextView7.setTextColor(m0().getResources().getColor(R.color.cl7));
        }
        QCircleAsyncTextView qCircleAsyncTextView8 = this.mAdBigBannerPupDes;
        if (qCircleAsyncTextView8 != null) {
            qCircleAsyncTextView8.setClickAreaTextColor(R.color.cl7);
        }
        if (af.Z(this.W) && af.z(this.W) == 1) {
            String x16 = af.x(this.W);
            if (TextUtils.isEmpty(x16)) {
                x16 = "\u6447\u52a8\u6216\u70b9\u51fb\u67e5\u770b\u8be6\u60c5";
            }
            TextView textView3 = this.mAdBigBannerButtonText;
            if (textView3 != null) {
                textView3.setText(x16);
            }
        } else {
            TextView textView4 = this.mAdBigBannerButtonText;
            if (textView4 != null) {
                textView4.setText(this.X.subtitle.get());
            }
            GdtShakeIconView gdtShakeIconView = this.bigCardShakeIcon;
            if (gdtShakeIconView != null) {
                gdtShakeIconView.setVisibility(8);
            }
            GdtShakeIconView gdtShakeIconView2 = this.bigCardShakeIcon;
            if (gdtShakeIconView2 != null) {
                gdtShakeIconView2.stop();
            }
        }
        List<String> a16 = this.mExternalTagInfo.a();
        if (a16 != null && a16.contains("1")) {
            z16 = true;
        }
        if (z16) {
            i16 = R.drawable.klu;
        } else {
            i16 = R.drawable.klt;
        }
        ImageView imageView3 = this.mAdBigBannerExternalTagLeftIcon;
        if (imageView3 != null) {
            imageView3.setImageResource(i16);
        }
        TextView textView5 = this.mAdBigBannerExternalTagGameTv;
        if (textView5 != null) {
            textView5.setText(this.mExternalTagInfo.getGameTxt());
        }
        TextView textView6 = this.mAdBigBannerExternalTagTagTv;
        if (textView6 != null) {
            textView6.setText(this.mExternalTagInfo.getTagTxt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H2(final ee this$0) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSFeedChildTransparentCardPresenter", 1, "reset click event. ");
        QCircleAsyncTextView qCircleAsyncTextView = this$0.mAdBigBannerPupDes;
        if (qCircleAsyncTextView != null) {
            charSequence = qCircleAsyncTextView.getText();
        } else {
            charSequence = null;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        ClickableSpan[] clkSpans = (ClickableSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ClickableSpan.class);
        Intrinsics.checkNotNullExpressionValue(clkSpans, "clkSpans");
        for (ClickableSpan clickableSpan : clkSpans) {
            spannableStringBuilder.removeSpan(clickableSpan);
        }
        QCircleAsyncTextView qCircleAsyncTextView2 = this$0.mAdBigBannerPupDes;
        if (qCircleAsyncTextView2 != null) {
            qCircleAsyncTextView2.d(spannableStringBuilder, 0, spannableStringBuilder.length() - 1, new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ec
                @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                public final void onClick() {
                    ee.J2(ee.this);
                }
            }, R.color.cl7, false);
        }
        QCircleAsyncTextView qCircleAsyncTextView3 = this$0.mAdBigBannerPupDes;
        if (qCircleAsyncTextView3 != null) {
            qCircleAsyncTextView3.d(spannableStringBuilder, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ed
                @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                public final void onClick() {
                    ee.I2(ee.this);
                }
            }, R.color.cl7, false);
        }
        QCircleAsyncTextView qCircleAsyncTextView4 = this$0.mAdBigBannerPupDes;
        if (qCircleAsyncTextView4 != null) {
            qCircleAsyncTextView4.setText(spannableStringBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(ee this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E1(this$0.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(ee this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r1(this$0.mAdBigBannerPupDes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K2(ee this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r1(this$0.mAdBigBannerPupDes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L2(ee this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E1(this$0.C);
    }

    private final void M2() {
        String d16 = com.tencent.biz.qqcircle.utils.bh.d(this.X.extInfo.get(), "small_card_left_txt");
        if (d16 == null) {
            d16 = "";
        }
        TextView textView = this.bannerHint;
        if (textView != null) {
            textView.setText(d16);
        }
        TextView textView2 = this.bannerTv;
        if (textView2 != null) {
            textView2.setText(this.X.subtitle.get());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r0 != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void i2() {
        boolean z16;
        float dimension;
        ImageView imageView;
        QCircleRoundImageView qCircleRoundImageView;
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        Object obj;
        int i3;
        int i16;
        float dimension2;
        int i17;
        boolean z17;
        boolean z18 = true;
        int i18 = 0;
        if (this.mExternalTagInfo.getGameTxt().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.mExternalTagInfo.getTagTxt().length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z18 = false;
        Resources resources = m0().getResources();
        if (z18) {
            dimension = resources.getDimension(R.dimen.d16);
        } else {
            dimension = resources.getDimension(R.dimen.f159398d15);
        }
        QCircleAvatarView qCircleAvatarView = this.mAdBannerAuthorAvatarView;
        RelativeLayout.LayoutParams layoutParams3 = null;
        if (qCircleAvatarView != null) {
            imageView = qCircleAvatarView.k();
        } else {
            imageView = null;
        }
        if (imageView instanceof QCircleRoundImageView) {
            qCircleRoundImageView = (QCircleRoundImageView) imageView;
        } else {
            qCircleRoundImageView = null;
        }
        if (qCircleRoundImageView != null) {
            if (z18) {
                i17 = com.tencent.biz.qqcircle.utils.cx.a(12.0f);
            } else {
                i17 = 90;
            }
            qCircleRoundImageView.setRoundRect(i17);
        }
        QCircleAvatarView qCircleAvatarView2 = this.mAdBannerAuthorAvatarView;
        if (qCircleAvatarView2 != null) {
            layoutParams = qCircleAvatarView2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        } else {
            layoutParams2 = null;
        }
        if (layoutParams2 != null) {
            int i19 = (int) dimension;
            layoutParams2.width = i19;
            layoutParams2.height = i19;
        }
        ViewGroup viewGroup = this.mAdBigBannerTitleAndExternalTagContainer;
        if (viewGroup != null) {
            obj = viewGroup.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) obj;
        }
        if (layoutParams3 != null) {
            if (z18) {
                i16 = (int) m0().getResources().getDimension(R.dimen.d16);
            } else {
                i16 = -2;
            }
            layoutParams3.height = i16;
            if (z18) {
                dimension2 = m0().getResources().getDimension(R.dimen.f159397d14);
            } else {
                dimension2 = m0().getResources().getDimension(R.dimen.d17);
            }
            layoutParams3.topMargin = (int) dimension2;
        }
        ViewGroup viewGroup2 = this.mAdBigBannerExternalTagContainer;
        if (viewGroup2 != null) {
            if (z18) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            viewGroup2.setVisibility(i3);
        }
        ImageView imageView2 = this.bigCardCloseBtn;
        if (imageView2 != null) {
            if (this.mExternalTagInfo.getDismissCloseButton()) {
                i18 = 8;
            }
            imageView2.setVisibility(i18);
        }
    }

    private final void j2() {
        int i3;
        View view = this.bottomActionBtn;
        if (view != null) {
            View view2 = this.feedback;
            boolean z16 = false;
            if (view2 != null && view2.getVisibility() == 0) {
                z16 = true;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.removeRule(3);
            if (z16) {
                i3 = R.id.f380218u;
            } else {
                i3 = R.id.v9j;
            }
            layoutParams2.addRule(3, i3);
            view.setLayoutParams(layoutParams2);
        }
    }

    private final void k2() {
        if (!this.mIsTransparentCard) {
            return;
        }
        G2();
        M2();
    }

    private final void l2() {
        final float p16 = af.p();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, p16);
        this.hideBigCardAnim = ofFloat;
        if (ofFloat != null) {
            ofFloat.setInterpolator(new DecelerateInterpolator());
        }
        ValueAnimator valueAnimator = this.hideBigCardAnim;
        if (valueAnimator != null) {
            valueAnimator.setDuration(300L);
        }
        ValueAnimator valueAnimator2 = this.hideBigCardAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.du
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ee.m2(ee.this, p16, valueAnimator3);
                }
            });
        }
        ValueAnimator valueAnimator3 = this.hideBigCardAnim;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new c(p16));
        }
        ValueAnimator valueAnimator4 = this.hideBigCardAnim;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
        QLog.d("QFSFeedChildTransparentCardPresenter", 1, "[hideBigCardAnim] start");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(ee this$0, float f16, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.adFeedInfo;
        if (view != null) {
            view.setTranslationX(floatValue - f16);
        }
        View view2 = this$0.f85346b0;
        if (view2 != null) {
            view2.setTranslationX(-floatValue);
        }
    }

    private final void n2() {
        QCircleAvatarView qCircleAvatarView = (QCircleAvatarView) this.f85356l0.findViewById(R.id.f374617b);
        int color = this.f85356l0.getContext().getColor(R.color.ciz);
        if (qCircleAvatarView != null) {
            qCircleAvatarView.setStrokes(com.tencent.biz.qqcircle.utils.cx.a(0.5f), color, 0, 0);
        }
    }

    private final void o2() {
        this.mAdBigBannerExternalTagLeftIcon = (ImageView) this.f85356l0.findViewById(R.id.f376117q);
        int c16 = QFSQUIUtilsKt.c(m0(), R.color.qui_common_feedback_warning, 0.2f);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{c16, c16});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(com.tencent.biz.qqcircle.utils.cx.a(4.0f));
        ImageView imageView = this.mAdBigBannerExternalTagLeftIcon;
        if (imageView != null) {
            imageView.setBackground(gradientDrawable);
        }
    }

    private final void p2() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(QFSQUIUtilsKt.a(Color.parseColor("#2F2F2F"), 0.8f));
        gradientDrawable.setCornerRadius(com.tencent.biz.qqcircle.utils.cx.a(4.0f));
        View view = this.bigCard;
        if (view != null) {
            view.setBackground(gradientDrawable);
        }
    }

    private final void q2() {
        ViewGroup.LayoutParams layoutParams;
        ImageView imageView = (ImageView) this.f85356l0.findViewById(R.id.f375417j);
        this.bigCardCloseBtn = imageView;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.f161623ki1);
        }
        ImageView imageView2 = this.bigCardCloseBtn;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dt
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ee.r2(ee.this, view);
                }
            });
        }
        ImageView imageView3 = this.bigCardCloseBtn;
        if (imageView3 != null) {
            layoutParams = imageView3.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            ((ViewGroup.LayoutParams) layoutParams2).width = com.tencent.biz.qqcircle.utils.cx.a(16.0f);
            ((ViewGroup.LayoutParams) layoutParams2).height = com.tencent.biz.qqcircle.utils.cx.a(16.0f);
            layoutParams2.topMargin = com.tencent.biz.qqcircle.utils.cx.a(6.0f);
            layoutParams2.rightMargin = com.tencent.biz.qqcircle.utils.cx.a(6.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(ee this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l2();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s2() {
        int i3;
        int i16;
        boolean k3 = com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.k(this.E);
        if (k3) {
            i3 = 78;
        } else {
            i3 = 38;
        }
        QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
        Context m06 = m0();
        if (k3) {
            i16 = R.drawable.o1c;
        } else {
            i16 = R.drawable.mhq;
        }
        Drawable mutate = qCircleSkinHelper.getDrawable(m06, i16).mutate();
        this.mFeedBackDrawable = mutate;
        if (mutate != null) {
            mutate.setBounds(0, ImmersiveUtils.dpToPx(1.0f), ImmersiveUtils.dpToPx(i3), ImmersiveUtils.dpToPx(18.0f));
        }
    }

    private final void t2() {
        TextView textView;
        if (this.bottomActionBtn != null) {
            return;
        }
        View inflate = ((ViewStub) this.C.findViewById(R.id.f3771180)).inflate();
        this.bottomActionBtn = inflate;
        TextView textView2 = null;
        if (inflate != null) {
            textView = (TextView) inflate.findViewById(R.id.f376917y);
        } else {
            textView = null;
        }
        this.bannerHint = textView;
        View view = this.bottomActionBtn;
        if (view != null) {
            textView2 = (TextView) view.findViewById(R.id.f377017z);
        }
        this.bannerTv = textView2;
        n2();
        this.author = this.f85356l0.findViewById(R.id.f3739175);
        this.content = this.f85356l0.findViewById(R.id.v9j);
        this.feedback = this.f85356l0.findViewById(R.id.f380218u);
        this.adFeedInfo = this.f85356l0.findViewById(R.id.f38711_p);
        this.f85346b0 = this.f85356l0.findViewById(R.id.f3742178);
        this.bigCard = this.f85356l0.findViewById(R.id.f3741177);
        p2();
        this.bottomShakeIcon = (GdtShakeIconView) this.f85356l0.findViewById(R.id.f3773182);
        this.bigCardShakeIcon = (GdtShakeIconView) this.f85356l0.findViewById(R.id.f374917e);
        q2();
        this.mAdBannerAuthorAvatarView = (QCircleAvatarView) this.f85356l0.findViewById(R.id.f374617b);
        this.mAdBigBannerTitleAndExternalTagContainer = (ViewGroup) this.f85356l0.findViewById(R.id.f376717w);
        this.mAdBigBannerTitle = (TextView) this.f85356l0.findViewById(R.id.f376617v);
        this.mAdBigBannerPupDes = (QCircleAsyncTextView) this.f85356l0.findViewById(R.id.f375617l);
        this.mAdBigBannerExternalTagContainer = (ViewGroup) this.f85356l0.findViewById(R.id.f375917o);
        o2();
        this.mAdBigBannerExternalTagGameTv = (TextView) this.f85356l0.findViewById(R.id.f376017p);
        this.mAdBigBannerExternalTagTagTv = (TextView) this.f85356l0.findViewById(R.id.f376217r);
        this.mAdBigBannerFeedBack = (ImageView) this.f85356l0.findViewById(R.id.f374417_);
        this.mAdBigBannerButton = (FrameLayout) this.f85356l0.findViewById(R.id.f374817d);
        this.mAdBigBannerButtonText = (TextView) this.f85356l0.findViewById(R.id.f375317i);
        F1(this.mAdBigBannerButton);
        F1(this.mAdBigBannerPupDes);
        F1(this.f85346b0);
        F1(this.mAdBigBannerTitle);
        F1(this.mAdBannerAuthorAvatarView);
        F1(this.bottomActionBtn);
        F1(this.bannerTv);
        F1(this.mAdBigBannerExternalTagContainer);
        ImageView imageView = this.mAdBigBannerFeedBack;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dy
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ee.u2(ee.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u2(ee this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean v2(String text, int lines) {
        return af.S(this.mAdBigBannerPupDes, text, com.tencent.biz.qqcircle.utils.cx.a(248.0f), lines);
    }

    private final void w2() {
        boolean z16;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        ValueAnimator valueAnimator3 = this.showBottomBannerAnim;
        boolean z17 = true;
        if (valueAnimator3 != null && valueAnimator3.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (valueAnimator2 = this.showBottomBannerAnim) != null) {
            valueAnimator2.pause();
        }
        ValueAnimator valueAnimator4 = this.showBigCardAnim;
        if (valueAnimator4 == null || !valueAnimator4.isRunning()) {
            z17 = false;
        }
        if (z17 && (valueAnimator = this.showBigCardAnim) != null) {
            valueAnimator.pause();
        }
        x0().removeCallbacks(this.showBottomBannerRunnable);
        x0().removeCallbacks(this.showBigCardRunnable);
        af.i0(this.bottomShakeIcon);
        af.i0(this.bigCardShakeIcon);
    }

    private final void x2() {
        boolean z16;
        boolean z17;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        ValueAnimator valueAnimator3;
        View view = this.bottomActionBtn;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.f85346b0;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.adFeedInfo;
        if (view3 != null) {
            view3.setTranslationX(0.0f);
        }
        View view4 = this.f85346b0;
        if (view4 != null) {
            view4.setTranslationX(-af.p());
        }
        x0().removeCallbacks(this.showBottomBannerRunnable);
        x0().removeCallbacks(this.showBigCardRunnable);
        ValueAnimator valueAnimator4 = this.showBottomBannerAnim;
        boolean z18 = true;
        if (valueAnimator4 != null && valueAnimator4.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (valueAnimator3 = this.showBottomBannerAnim) != null) {
            valueAnimator3.cancel();
        }
        ValueAnimator valueAnimator5 = this.showBigCardAnim;
        if (valueAnimator5 != null && valueAnimator5.isRunning()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && (valueAnimator2 = this.showBigCardAnim) != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator6 = this.hideBigCardAnim;
        if (valueAnimator6 == null || !valueAnimator6.isRunning()) {
            z18 = false;
        }
        if (z18 && (valueAnimator = this.hideBigCardAnim) != null) {
            valueAnimator.cancel();
        }
        af.n0(this.bottomShakeIcon);
        af.n0(this.bigCardShakeIcon);
    }

    private final void y2() {
        boolean z16;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        ValueAnimator valueAnimator3 = this.showBottomBannerAnim;
        boolean z17 = true;
        if (valueAnimator3 != null && valueAnimator3.isPaused()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (valueAnimator2 = this.showBottomBannerAnim) != null) {
            valueAnimator2.resume();
        }
        ValueAnimator valueAnimator4 = this.showBigCardAnim;
        if (valueAnimator4 == null || !valueAnimator4.isPaused()) {
            z17 = false;
        }
        if (z17 && (valueAnimator = this.showBigCardAnim) != null) {
            valueAnimator.resume();
        }
        if (Intrinsics.areEqual(this.mCurrentRunnable, this.showBottomBannerRunnable)) {
            F2();
        } else if (Intrinsics.areEqual(this.mCurrentRunnable, this.showBigCardRunnable)) {
            E2();
        }
        if (af.Z(this.W)) {
            af.m0(this.bottomShakeIcon);
            af.m0(this.bigCardShakeIcon);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z2(float y16) {
        View view = this.bottomActionBtn;
        if (view != null) {
            view.setTranslationY(y16);
        }
        View view2 = this.author;
        if (view2 != null) {
            view2.setTranslationY(y16);
        }
        View view3 = this.content;
        if (view3 != null) {
            view3.setTranslationY(y16);
        }
        View view4 = this.feedback;
        if (view4 != null) {
            view4.setTranslationY(y16);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: D1 */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        String str;
        PBStringField pBStringField;
        super.L0(data, position);
        boolean m3 = eq.f85700a.m(this.W, this.Y);
        this.mIsTransparentCard = m3;
        if (!m3) {
            return;
        }
        this.mExternalTagInfo = b.INSTANCE.a(this.X);
        String tag = getTAG();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.X;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        QLog.d(tag, 1, "[onBindData] feedId:" + str + ", " + this.mExternalTagInfo);
        t2();
        k2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        String str;
        super.onFeedSelected(selectInfo);
        if (this.mIsTransparentCard) {
            if (selectInfo != null) {
                str = selectInfo.getSelectedType();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "TYPE_SELECT_NORMAL")) {
                x2();
                F2();
                return;
            }
        }
        y2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        String str;
        super.onFeedUnSelected(selectInfo);
        if (!this.mIsTransparentCard) {
            return;
        }
        String str2 = null;
        if (selectInfo != null) {
            str = selectInfo.getUnSelectedType();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, "TYPE_UNSELECTED_NORMAL")) {
            if (selectInfo != null) {
                str2 = selectInfo.getUnSelectedType();
            }
            if (str2 != null) {
                return;
            }
        }
        x2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onPaused(selectInfo);
        if (this.mIsTransparentCard) {
            w2();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onResumed(selectInfo);
        if (this.mIsTransparentCard) {
            y2();
        }
    }
}
