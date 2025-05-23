package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.QFSPublicAccountXingHuanAdMaskView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.a;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.e;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.f;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.j;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import i50.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ?2\u00020\u0001:\u0001@B\u000f\u0012\u0006\u0010<\u001a\u00020;\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011R\u001c\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010 \u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0014\u0010!\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010:\u00a8\u0006A"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/xinghuan/QFSPublicAccountXingHuanAdMaskView;", "Landroid/widget/FrameLayout;", "", h.F, "", "imageUrl", "Landroid/widget/ImageView;", "imageView", "l", "Lorg/json/JSONObject;", "maskTaskInfo", "Lfeedcloud/FeedCloudMeta$StFeed;", QCircleScheme.AttrDetail.FEED_INFO, "g", "Landroid/view/ViewGroup;", "parentView", DomainData.DOMAIN_NAME, "", "isAutoClose", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "kotlin.jvm.PlatformType", "d", "Landroid/view/View;", "adMaskContentView", "e", "Landroid/view/ViewGroup;", "adMaskAnimationLayout", "f", "adMaskLayout", "adMaskCloseLayout", "i", "adMaskPagContainer", "adMaskEntryLayout", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "adMaskPagLayout", "D", "Landroid/widget/ImageView;", "adMaskEntryView", "Lcom/tencent/biz/qqcircle/widgets/QFSPagAnimView;", "E", "Lcom/tencent/biz/qqcircle/widgets/QFSPagAnimView;", "adMaskPagAnimView", "", UserInfo.SEX_FEMALE, "J", "startExposeTime", "G", "Lorg/json/JSONObject;", "Landroid/os/Handler;", "H", "Landroid/os/Handler;", "uiHandler", "I", "Z", "isAnimationPlaying", "Lfeedcloud/FeedCloudMeta$StFeed;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "K", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountXingHuanAdMaskView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private LinearLayout adMaskPagLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ImageView adMaskEntryView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final QFSPagAnimView adMaskPagAnimView;

    /* renamed from: F, reason: from kotlin metadata */
    private long startExposeTime;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private JSONObject maskTaskInfo;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isAnimationPlaying;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed feedInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View adMaskContentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup adMaskAnimationLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup adMaskLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup adMaskCloseLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup adMaskPagContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup adMaskEntryLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPublicAccountXingHuanAdMaskView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.adMaskContentView = LayoutInflater.from(context).inflate(R.layout.goj, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.f57682nz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_xi\u2026mask_animation_container)");
        this.adMaskAnimationLayout = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.f57722o3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_xing_huan_mask_layout)");
        this.adMaskLayout = (ViewGroup) findViewById2;
        View findViewById3 = findViewById(R.id.f57712o2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_xing_huan_mask_close_layout)");
        this.adMaskCloseLayout = (ViewGroup) findViewById3;
        View findViewById4 = findViewById(R.id.f57692o0);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_xi\u2026an_mask_animation_layout)");
        ViewGroup viewGroup = (ViewGroup) findViewById4;
        this.adMaskPagContainer = viewGroup;
        View findViewById5 = findViewById(R.id.f57702o1);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qfs_xi\u2026_huan_mask_button_layout)");
        ViewGroup viewGroup2 = (ViewGroup) findViewById5;
        this.adMaskEntryLayout = viewGroup2;
        this.uiHandler = new Handler(Looper.getMainLooper());
        ((TextView) findViewById(R.id.f57672ny)).setText(context.getString(R.string.f213715qy));
        LinearLayout linearLayout = new LinearLayout(context);
        this.adMaskPagLayout = linearLayout;
        linearLayout.setOrientation(1);
        int screenWidth = ScreenUtils.getScreenWidth(getContext());
        viewGroup.addView(this.adMaskPagLayout, new FrameLayout.LayoutParams(screenWidth, (screenWidth * 481) / QidPagView.DESIGN_PAG_WIDTH));
        ImageView imageView = new ImageView(context);
        this.adMaskEntryView = imageView;
        imageView.setAdjustViewBounds(true);
        int screenWidth2 = ScreenUtils.getScreenWidth(getContext()) - (DisplayUtil.dip2px(context, 36.0f) * 2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(screenWidth2, (screenWidth2 * 68) / 339);
        layoutParams.leftMargin = DisplayUtil.dip2px(context, 36.0f);
        layoutParams.rightMargin = DisplayUtil.dip2px(context, 36.0f);
        viewGroup2.addView(this.adMaskEntryView, layoutParams);
        QFSPagAnimView qFSPagAnimView = new QFSPagAnimView(context);
        this.adMaskPagAnimView = qFSPagAnimView;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.adMaskPagLayout.addView(qFSPagAnimView, layoutParams2);
        h();
    }

    private final void h() {
        this.adMaskEntryView.setOnClickListener(new View.OnClickListener() { // from class: l50.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountXingHuanAdMaskView.k(QFSPublicAccountXingHuanAdMaskView.this, view);
            }
        });
        this.adMaskCloseLayout.setOnClickListener(new View.OnClickListener() { // from class: l50.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountXingHuanAdMaskView.i(QFSPublicAccountXingHuanAdMaskView.this, view);
            }
        });
        this.adMaskLayout.setOnClickListener(new View.OnClickListener() { // from class: l50.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountXingHuanAdMaskView.j(QFSPublicAccountXingHuanAdMaskView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(QFSPublicAccountXingHuanAdMaskView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m(false);
        JSONObject jSONObject = this$0.maskTaskInfo;
        if (jSONObject != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this$0.feedInfo;
            if (feedCloudMeta$StFeed != null) {
                a.f87148a.a(2, feedCloudMeta$StFeed);
            }
            e.f87154a.d(j.h(jSONObject), 1);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(QFSPublicAccountXingHuanAdMaskView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m(false);
        JSONObject jSONObject = this$0.maskTaskInfo;
        if (jSONObject != null) {
            ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme(j.e(jSONObject), null);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this$0.feedInfo;
            if (feedCloudMeta$StFeed != null) {
                a.f87148a.a(3, feedCloudMeta$StFeed);
            }
            e.f87154a.f(j.h(jSONObject), 2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(QFSPublicAccountXingHuanAdMaskView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        JSONObject jSONObject = this$0.maskTaskInfo;
        if (jSONObject != null) {
            ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme(j.i(jSONObject), null);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this$0.feedInfo;
            if (feedCloudMeta$StFeed != null) {
                a.f87148a.a(1, feedCloudMeta$StFeed);
            }
            e.f87154a.f(j.h(jSONObject), 1);
        }
        this$0.m(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l(String imageUrl, ImageView imageView) {
        f fVar = f.f87155a;
        String d16 = fVar.d(imageUrl);
        if (fVar.a(d16)) {
            imageUrl = d16;
        }
        Option obtain = Option.obtain();
        obtain.setUrl(imageUrl);
        obtain.setTargetView(imageView);
        obtain.setRequestWidth(imageView.getWidth());
        obtain.setRequestHeight(imageView.getHeight());
        obtain.setLoadingDrawableColor(0);
        obtain.setNeedShowLoadingDrawable(false);
        QCircleFeedPicLoader.g().loadImage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(QFSPublicAccountXingHuanAdMaskView this$0, ViewGroup parentView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        if (this$0.adMaskContentView.getParent() != null) {
            ViewParent parent = this$0.adMaskContentView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this$0.adMaskContentView);
        }
        parentView.addView(this$0.adMaskContentView, new ViewGroup.LayoutParams(-1, -1));
        JSONObject jSONObject = this$0.maskTaskInfo;
        if (jSONObject != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this$0.feedInfo;
            if (feedCloudMeta$StFeed != null) {
                a.f87148a.c(feedCloudMeta$StFeed);
            }
            e.f87154a.h(j.h(jSONObject));
        }
        this$0.startExposeTime = System.currentTimeMillis();
        this$0.adMaskPagAnimView.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(QFSPublicAccountXingHuanAdMaskView this$0) {
        a.C10505a f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isAnimationPlaying) {
            a.C10505a c10505a = new a.C10505a(500L);
            View adMaskContentView = this$0.adMaskContentView;
            Intrinsics.checkNotNullExpressionValue(adMaskContentView, "adMaskContentView");
            f16 = r16.f(this$0.adMaskAnimationLayout, 1.0f, 0.0f, 1.0f, 0.0f, (r33 & 32) != 0 ? 0.0f : 0.5f, (r33 & 64) != 0 ? 0.0f : 0.5f, (r33 & 128) != 0 ? a.C10505a.b(c10505a, adMaskContentView, 1.0f, 0.0f, 0L, 0L, false, false, null, null, 504, null).duration : 0L, (r33 & 256) != 0, (r33 & 512) != 0 ? null : null, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? 0L : 0L);
            a.C10505a.b(a.C10505a.i(f16, this$0.adMaskAnimationLayout, 0.0f, 0.0f, r2.getWidth() / 2, 0.0f, 0L, false, null, null, 480, null), this$0.adMaskAnimationLayout, 1.0f, 0.0f, 0L, 0L, false, false, null, null, 504, null).e(new b()).c().b();
        }
    }

    public final void g(@NotNull JSONObject maskTaskInfo, @Nullable FeedCloudMeta$StFeed feedInfo) {
        Intrinsics.checkNotNullParameter(maskTaskInfo, "maskTaskInfo");
        this.feedInfo = feedInfo;
        this.maskTaskInfo = maskTaskInfo;
        this.adMaskPagAnimView.setResUrl(j.f(maskTaskInfo));
        this.adMaskPagAnimView.R(j.d(maskTaskInfo));
        l(j.b(maskTaskInfo), this.adMaskEntryView);
    }

    public final void m(boolean isAutoClose) {
        this.uiHandler.removeCallbacksAndMessages(null);
        if (this.adMaskContentView.getParent() != null) {
            ViewParent parent = this.adMaskContentView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this.adMaskContentView);
        }
        this.adMaskPagAnimView.V();
        JSONObject jSONObject = this.maskTaskInfo;
        if (jSONObject != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.startExposeTime;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feedInfo;
            if (feedCloudMeta$StFeed != null) {
                com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.a.f87148a.b(currentTimeMillis, feedCloudMeta$StFeed);
            }
            if (isAutoClose) {
                e.f87154a.d(j.h(jSONObject), 2);
            }
        }
    }

    public final void n(@NotNull final ViewGroup parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        this.uiHandler.post(new Runnable() { // from class: l50.f
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountXingHuanAdMaskView.o(QFSPublicAccountXingHuanAdMaskView.this, parentView);
            }
        });
        this.uiHandler.postDelayed(new Runnable() { // from class: l50.g
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountXingHuanAdMaskView.p(QFSPublicAccountXingHuanAdMaskView.this);
            }
        }, 5000L);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/xinghuan/QFSPublicAccountXingHuanAdMaskView$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            QFSPublicAccountXingHuanAdMaskView.this.isAnimationPlaying = false;
            QFSPublicAccountXingHuanAdMaskView.this.m(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            QFSPublicAccountXingHuanAdMaskView.this.isAnimationPlaying = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }
}
