package com.tencent.mobileqq.vas.adv.recommendad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.adv.recommendad.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u000245B\u0011\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u00a2\u0006\u0004\b-\u0010.B\u001b\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/\u00a2\u0006\u0004\b-\u00101B#\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u0006\u00102\u001a\u00020\b\u00a2\u0006\u0004\b-\u00103J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J,\u0010\u0016\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014J&\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u000bJ\u0006\u0010\u001c\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u000bJ\u0006\u0010\u001e\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/vas/adv/recommendad/a$b;", "viewHolder", "Landroid/view/View;", "view", "", "bigPicLocation", "", "bigPicWidth", "bigPicHeight", "", DomainData.DOMAIN_NAME, "", "Lcom/tencent/gdtad/aditem/GdtAd;", "list", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$a;", "feedbackListener", "", "canAutoPlay", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$b;", "onTouchInterceptor", "f", "width", "height", "delay", "o", "j", "i", "k", tl.h.F, com.tencent.luggage.wxa.c8.c.G, "l", "Landroid/view/View$OnTouchListener;", "onTouchListener", "setRecyclerViewOnTouchListener", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdRecyclerView;", "d", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdRecyclerView;", "mRecyclerView", "e", "Landroid/view/View;", "mRecommendAdViewContainer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class RecommendAdView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecommendAdRecyclerView mRecyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRecommendAdViewContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$a;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "", "a", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        void a(@NotNull GdtAd ad5);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$b;", "", "", "backEnable", "", "a", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void a(boolean backEnable);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendAdView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(RecommendAdView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mRecyclerView.smoothScrollToPosition(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(a.b viewHolder, View view, int[] bigPicLocation, int bigPicWidth, int bigPicHeight) {
        viewHolder.y(false);
        setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(bigPicWidth / view.getWidth(), 1.0f, bigPicHeight / view.getHeight(), 1.0f);
        view.getLocationOnScreen(new int[2]);
        TranslateAnimation translateAnimation = new TranslateAnimation(bigPicLocation[0] - r8[0], 0.0f, bigPicLocation[1] - r8[1], 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.6f, 1.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(510L);
        animationSet.setAnimationListener(new c(viewHolder, this, view));
        view.startAnimation(animationSet);
    }

    public final void f(@NotNull List<? extends GdtAd> list, @NotNull a feedbackListener, boolean canAutoPlay, @NotNull b onTouchInterceptor) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(feedbackListener, "feedbackListener");
        Intrinsics.checkNotNullParameter(onTouchInterceptor, "onTouchInterceptor");
        com.tencent.mobileqq.vas.adv.recommendad.a aVar = new com.tencent.mobileqq.vas.adv.recommendad.a();
        aVar.o0(list, feedbackListener, canAutoPlay);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mRecyclerView.H(linearLayoutManager, aVar, onTouchInterceptor);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.adv.recommendad.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecommendAdView.g(view);
            }
        });
    }

    public final void h() {
        this.mRecyclerView.onDestroy();
    }

    public final void i() {
        this.mRecyclerView.I();
    }

    public final void j() {
        this.mRecyclerView.K();
    }

    public final void k() {
        this.mRecyclerView.L();
    }

    public final void l(final int pos) {
        if (pos >= 0 && pos < this.mRecyclerView.getChildCount()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.recommendad.i
                @Override // java.lang.Runnable
                public final void run() {
                    RecommendAdView.m(RecommendAdView.this, pos);
                }
            }, 20L);
        }
    }

    public final void o(@NotNull final int[] bigPicLocation, final int width, final int height, int delay) {
        Intrinsics.checkNotNullParameter(bigPicLocation, "bigPicLocation");
        if (width != 0 && height != 0) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.recommendad.RecommendAdView$startRecommendAdAnimation$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$startRecommendAdAnimation$1$a", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes20.dex */
                public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ RecommendAdView f308293d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ RecyclerView.ViewHolder f308294e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ RecommendAdCoverView f308295f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ int[] f308296h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ int f308297i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ int f308298m;

                    a(RecommendAdView recommendAdView, RecyclerView.ViewHolder viewHolder, RecommendAdCoverView recommendAdCoverView, int[] iArr, int i3, int i16) {
                        this.f308293d = recommendAdView;
                        this.f308294e = viewHolder;
                        this.f308295f = recommendAdCoverView;
                        this.f308296h = iArr;
                        this.f308297i = i3;
                        this.f308298m = i16;
                    }

                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        this.f308293d.n((a.b) this.f308294e, this.f308295f, this.f308296h, this.f308297i, this.f308298m);
                        this.f308295f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    RecommendAdRecyclerView recommendAdRecyclerView;
                    View view;
                    String str;
                    View view2;
                    RecommendAdRecyclerView recommendAdRecyclerView2;
                    recommendAdRecyclerView = RecommendAdView.this.mRecyclerView;
                    RecyclerView.LayoutManager layoutManager = recommendAdRecyclerView.getLayoutManager();
                    RecyclerView.ViewHolder viewHolder = null;
                    if (layoutManager != null) {
                        view = layoutManager.getChildAt(0);
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        recommendAdRecyclerView2 = RecommendAdView.this.mRecyclerView;
                        viewHolder = recommendAdRecyclerView2.getChildViewHolder(view);
                    }
                    RecyclerView.ViewHolder viewHolder2 = viewHolder;
                    if (viewHolder2 == null) {
                        RecommendAdView.this.setVisibility(0);
                        return;
                    }
                    if (viewHolder2 instanceof a.b) {
                        RecommendAdView.this.getLocationOnScreen(new int[2]);
                        a.b bVar = (a.b) viewHolder2;
                        View q16 = bVar.q();
                        if (q16 == null) {
                            RecommendAdView.this.setVisibility(0);
                            return;
                        }
                        q16.setVisibility(4);
                        q16.getLocationOnScreen(new int[2]);
                        Context context = RecommendAdView.this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        RecommendAdCoverView recommendAdCoverView = new RecommendAdCoverView(context);
                        recommendAdCoverView.setBackgroundColor(-16777216);
                        GdtAd ad5 = bVar.getAd();
                        if (ad5 == null || (str = ad5.getBasic_img()) == null) {
                            str = "";
                        }
                        Drawable urlDrawable = GdtUIUtils.getUrlDrawable(str);
                        Intrinsics.checkNotNullExpressionValue(urlDrawable, "getUrlDrawable((viewHolder.ad?.basic_img ?: \"\"))");
                        recommendAdCoverView.setImageDrawable(urlDrawable);
                        if (!bVar.getIsVideoAd()) {
                            recommendAdCoverView.a();
                        }
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(q16.getWidth(), q16.getHeight());
                        recommendAdCoverView.setX(r0[0] - r1[0]);
                        recommendAdCoverView.setY(r0[1] - r1[1]);
                        int childCount = RecommendAdView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            View childAt = RecommendAdView.this.getChildAt(i3);
                            if (childAt instanceof RecommendAdCoverView) {
                                RecommendAdView.this.removeView(childAt);
                            }
                        }
                        RecommendAdView.this.addView(recommendAdCoverView, layoutParams);
                        recommendAdCoverView.getViewTreeObserver().addOnGlobalLayoutListener(new a(RecommendAdView.this, viewHolder2, recommendAdCoverView, bigPicLocation, width, height));
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration(510L);
                        view2 = RecommendAdView.this.mRecommendAdViewContainer;
                        view2.startAnimation(alphaAnimation);
                    }
                }
            }, delay);
        } else {
            setVisibility(0);
        }
    }

    public final void setRecyclerViewOnTouchListener(@NotNull View.OnTouchListener onTouchListener) {
        Intrinsics.checkNotNullParameter(onTouchListener, "onTouchListener");
        this.mRecyclerView.setOnTouchListener(onTouchListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendAdView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendAdView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.hmu, this);
        setClipChildren(false);
        setClipToPadding(false);
        View findViewById = findViewById(R.id.f71153nd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.recommend_ad_view_recyclerview)");
        this.mRecyclerView = (RecommendAdRecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.f71143nc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.recommend_ad_view_container)");
        this.mRecommendAdViewContainer = findViewById2;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.b f308287d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecommendAdView f308288e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f308289f;

        c(a.b bVar, RecommendAdView recommendAdView, View view) {
            this.f308287d = bVar;
            this.f308288e = recommendAdView;
            this.f308289f = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            View q16 = this.f308287d.q();
            if (q16 != null) {
                q16.setVisibility(0);
            }
            this.f308288e.l(1);
            this.f308287d.y(true);
            this.f308288e.removeView(this.f308289f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }
}
