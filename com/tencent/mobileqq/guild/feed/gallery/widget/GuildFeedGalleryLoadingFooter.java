package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener;
import com.tencent.util.LoadingUtil;
import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001_B'\b\u0007\u0012\u0006\u0010X\u001a\u00020W\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\b\b\u0002\u0010[\u001a\u00020\b\u00a2\u0006\u0004\b\\\u0010]J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J \u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0000H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\fH\u0016J \u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0016J \u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0016J0\u0010$\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0016J \u0010%\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0016J \u0010&\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0016J \u0010*\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'H\u0016J\u0010\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0016J\u0014\u0010/\u001a\u00020\u00032\n\u0010.\u001a\u00020-\"\u00020\bH\u0016J\u0010\u00102\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u000100J\u0010\u00104\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u000103J\u0014\u00106\u001a\u00020\u00032\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000305J\u000e\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u00020\fJ\u0006\u00109\u001a\u00020\u0003R\u0018\u0010;\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010:R\u0018\u0010=\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010<R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010?R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010BR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010ER\u0014\u0010H\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010?R\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010N\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010ER\u0016\u0010Q\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\"\u0010S\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010P\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryLoadingFooter;", "Landroid/widget/FrameLayout;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshFooter;", "", "i", "g", "d", "k", "", "duration", "", "dragRate", "", "animationOnly", "autoOpen", "Lcom/tencent/richframework/widget/refresh/layout/constant/SpinnerStyle;", "kotlin.jvm.PlatformType", "getSpinnerStyle", "e", "isSupportHorizontalDrag", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshLayout;", "refreshLayout", "success", "onFinish", "percentX", "offsetX", "offsetMax", "onHorizontalDrag", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshKernel;", "kernel", "height", "maxDragHeight", "onInitialized", "isDragging", "percent", "offset", "onMoving", "onReleased", "onStartAnimator", "Lcom/tencent/richframework/widget/refresh/layout/constant/RefreshState;", "oldState", "newState", "onStateChanged", "noMoreData", "setNoMoreData", "", NodeProps.COLORS, "setPrimaryColors", "Lcom/tencent/richframework/widget/refresh/layout/listener/OnLoadMoreListener;", "callback", "setOnLoadMoreFinishListener", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/q;", "setOnLoadingListener", "Lkotlin/Function0;", tl.h.F, "show", "l", "f", "Lcom/tencent/richframework/widget/refresh/layout/listener/OnLoadMoreListener;", "outLoadMoreCallback", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/q;", "outLoadingCallback", "Landroid/view/View;", "Landroid/view/View;", "innerLoadingLayout", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "innerLoadingView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "innerLoadingTips", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "innerRefreshLayout", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "innerRefreshView", "D", "innerRefreshTips", "E", "Z", "showGuide", UserInfo.SEX_FEMALE, "isLoading", "()Z", "setLoading", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"RestrictedApi"})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryLoadingFooter extends FrameLayout implements IRefreshFooter {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ImageView innerRefreshView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TextView innerRefreshTips;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean showGuide;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OnLoadMoreListener outLoadMoreCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private q outLoadingCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View innerLoadingLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LottieAnimationView innerLoadingView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView innerLoadingTips;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View innerRefreshLayout;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f219825a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RefreshState.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RefreshState.LoadReleased.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RefreshState.Refreshing.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f219825a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryLoadingFooter$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            q qVar = GuildFeedGalleryLoadingFooter.this.outLoadingCallback;
            if (qVar != null) {
                qVar.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedGalleryLoadingFooter(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d() {
        LottieAnimationView lottieAnimationView = this.innerLoadingView;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.addAnimatorListener(new c());
        this.innerLoadingView.playAnimation();
    }

    private final void g() {
        boolean z16;
        if (this.showGuide) {
            if (this.innerLoadingLayout.getAlpha() == 1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(150L);
                alphaAnimation.setAnimationListener(new d());
                this.innerLoadingLayout.startAnimation(alphaAnimation);
            }
        }
    }

    private final void i() {
        this.innerRefreshView.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(boolean z16, GuildFeedGalleryLoadingFooter this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        this$0.innerLoadingTips.setVisibility(i3);
        this$0.innerLoadingView.setVisibility(i3);
    }

    private final void k() {
        if (this.showGuide) {
            return;
        }
        this.innerRefreshView.setImageResource(R.drawable.guild_loading_white);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int duration, float dragRate, boolean animationOnly) {
        return false;
    }

    public final void f() {
        this.showGuide = false;
        this.innerLoadingLayout.setVisibility(8);
        this.innerRefreshLayout.setVisibility(4);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.FixedBehind;
    }

    public final void h(@NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setAnimationListener(new e(callback));
        this.innerLoadingLayout.startAnimation(alphaAnimation);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public final void l(boolean show) {
        if (this.showGuide == show) {
            return;
        }
        this.innerLoadingView.setAnimation("guild_feed/feed_gallery/arrow_anim.json");
        this.innerLoadingView.setImageAssetsFolder("guild_feed/feed_gallery/images/");
        this.showGuide = show;
        if (show) {
            this.innerLoadingLayout.setVisibility(0);
            this.innerRefreshLayout.setVisibility(8);
        } else {
            this.innerLoadingLayout.setVisibility(8);
            this.innerRefreshLayout.setVisibility(0);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public int onFinish(@NotNull IRefreshLayout refreshLayout, boolean success) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        k();
        return 0;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onInitialized(@NotNull IRefreshKernel kernel, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onReleased(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onStartAnimator(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        if (this.showGuide) {
            d();
        } else {
            i();
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NotNull IRefreshLayout refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
        OnLoadMoreListener onLoadMoreListener;
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild_Feed_GAL_GuildFeedGalleryLoadingFooter", 2, "onStateChanged " + refreshLayout + ", " + oldState + ", " + newState);
        }
        int i3 = b.f219825a[newState.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if ((i3 == 4 || i3 == 5) && !this.showGuide) {
                        i();
                    }
                } else {
                    g();
                }
            } else {
                k();
            }
        } else {
            q qVar = this.outLoadingCallback;
            if (qVar != null) {
                qVar.onCancel();
            }
            k();
        }
        if (oldState == RefreshState.LoadFinish && newState == RefreshState.None && (onLoadMoreListener = this.outLoadMoreCallback) != null) {
            onLoadMoreListener.onLoadMore(refreshLayout);
        }
    }

    public final void setLoading(boolean z16) {
        this.isLoading = z16;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter
    public boolean setNoMoreData(final boolean noMoreData) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedGalleryLoadingFooter.j(noMoreData, this);
            }
        });
        return true;
    }

    public final void setOnLoadMoreFinishListener(@Nullable OnLoadMoreListener callback) {
        this.outLoadMoreCallback = callback;
    }

    public final void setOnLoadingListener(@Nullable q callback) {
        this.outLoadingCallback = callback;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void setPrimaryColors(@NotNull int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedGalleryLoadingFooter(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildFeedGalleryLoadingFooter(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedGalleryLoadingFooter(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.eod, this);
        View findViewById = findViewById(R.id.v2g);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.feed_gallery_more_footer_layout)");
        this.innerLoadingLayout = findViewById;
        View findViewById2 = findViewById(R.id.v2h);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.feed_gallery_more_loading)");
        this.innerLoadingView = (LottieAnimationView) findViewById2;
        View findViewById3 = findViewById(R.id.v2i);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.feed_gallery_more_tips)");
        this.innerLoadingTips = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.v2k);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.feed_gallery_refresh_ll)");
        this.innerRefreshLayout = findViewById4;
        View findViewById5 = findViewById(R.id.v2l);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.feed_gallery_refresh_loading)");
        this.innerRefreshView = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.v2m);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.feed_gallery_refresh_tips)");
        this.innerRefreshTips = (TextView) findViewById6;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public GuildFeedGalleryLoadingFooter getView() {
        return this;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryLoadingFooter$d", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            GuildFeedGalleryLoadingFooter.this.innerLoadingLayout.setAlpha(1.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            q qVar = GuildFeedGalleryLoadingFooter.this.outLoadingCallback;
            if (qVar != null) {
                qVar.onLoading();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryLoadingFooter$e", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements Animation.AnimationListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f219829e;

        e(Function0<Unit> function0) {
            this.f219829e = function0;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            GuildFeedGalleryLoadingFooter.this.innerLoadingLayout.setAlpha(0.0f);
            this.f219829e.invoke();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
    }
}
