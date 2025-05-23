package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/y;", "", "", "isCollapse", "", "totalHeight", "Landroid/animation/Animator;", "j", "", "i", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "k", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "g", "()Landroidx/recyclerview/widget/RecyclerView;", "feedListView", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", tl.h.F, "()Landroid/view/ViewGroup;", "selectTitle", "c", "I", "state", "d", "Z", "disableTouch", "e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "scrollListener", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/ViewGroup;)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class y {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final a f231817g = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView feedListView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup selectTitle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean disableTouch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RecyclerView.OnScrollListener scrollListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/resultview/feed/y$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            int measuredHeight;
            boolean z16;
            boolean z17;
            float coerceIn;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("QuickSearchFilterTitleAnimator", "onScrollStateChanged newState=" + newState);
            }
            y.this.state = newState;
            if (newState != 0 || (measuredHeight = y.this.getSelectTitle().getMeasuredHeight()) == 0) {
                return;
            }
            boolean z18 = true;
            if (y.this.getSelectTitle().getTranslationY() == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                float f16 = measuredHeight;
                if (y.this.getSelectTitle().getTranslationY() == (-f16)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    coerceIn = RangesKt___RangesKt.coerceIn(Math.abs(y.this.getSelectTitle().getTranslationY()) / f16, 0.0f, 1.0f);
                    y yVar = y.this;
                    if (coerceIn <= 0.5f) {
                        z18 = false;
                    }
                    yVar.j(z18, measuredHeight).start();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            float coerceIn;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            int measuredHeight = y.this.getSelectTitle().getMeasuredHeight();
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("QuickSearchFilterTitleAnimator", "onScrolled dx=" + dx5 + " dy=" + dy5);
            }
            if (!y.this.disableTouch && y.this.state != 0) {
                y yVar = y.this;
                if (QLog.isDevelopLevel()) {
                    Log.d("QuickSearchFilterTitleAnimator", "selectTitle.translateY = " + yVar.getSelectTitle().getTranslationY() + " - " + dy5 + " = " + (yVar.getSelectTitle().getTranslationY() - dy5));
                }
                ViewGroup selectTitle = y.this.getSelectTitle();
                coerceIn = RangesKt___RangesKt.coerceIn(y.this.getSelectTitle().getTranslationY() - dy5, -measuredHeight, 0.0f);
                selectTitle.setTranslationY(coerceIn);
            }
        }
    }

    public y(@NotNull RecyclerView feedListView, @NotNull ViewGroup selectTitle) {
        Intrinsics.checkNotNullParameter(feedListView, "feedListView");
        Intrinsics.checkNotNullParameter(selectTitle, "selectTitle");
        this.feedListView = feedListView;
        this.selectTitle = selectTitle;
        this.scrollListener = k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Animator j(boolean isCollapse, int totalHeight) {
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        c cVar = new c(isCollapse, totalHeight);
        animator.addUpdateListener(cVar);
        animator.addListener(cVar);
        animator.setDuration(300L);
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return animator;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final RecyclerView getFeedListView() {
        return this.feedListView;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final ViewGroup getSelectTitle() {
        return this.selectTitle;
    }

    public final void i() {
        this.feedListView.addOnScrollListener(this.scrollListener);
    }

    @NotNull
    public final RecyclerView.OnScrollListener k() {
        return new d();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/resultview/feed/y$a", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Landroid/view/MotionEvent;", "e", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "", "onTouchEvent", "disallowIntercept", "onRequestDisallowInterceptTouchEvent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements RecyclerView.OnItemTouchListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NotNull RecyclerView rv5, @NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(rv5, "rv");
            Intrinsics.checkNotNullParameter(e16, "e");
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NotNull RecyclerView rv5, @NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(rv5, "rv");
            Intrinsics.checkNotNullParameter(e16, "e");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\rH\u0016R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/resultview/feed/y$c", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/Animator$AnimatorListener;", "", "source", "", "a", "", "calcRatio", "b", "Landroid/animation/ValueAnimator;", "animation", "onAnimationUpdate", "Landroid/animation/Animator;", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "", "d", "I", "getPrevTranslation", "()I", "setPrevTranslation", "(I)V", "prevTranslation", "e", "getStartTranslation", "startTranslation", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int prevTranslation;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int startTranslation;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f231826h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f231827i;

        c(boolean z16, int i3) {
            this.f231826h = z16;
            this.f231827i = i3;
            this.prevTranslation = (int) y.this.getSelectTitle().getTranslationY();
            this.startTranslation = (int) y.this.getSelectTitle().getTranslationY();
        }

        private final void a(String source) {
            float f16;
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("QuickSearchFilterTitleAnimator", "finishAnimation(" + source + ")");
            }
            if (this.f231826h) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            b(f16);
            y.this.getFeedListView().removeOnItemTouchListener(y.f231817g);
            y.this.disableTouch = false;
        }

        private final void b(float calcRatio) {
            y.this.getSelectTitle().setTranslationY((-this.f231827i) * calcRatio);
            int translationY = ((int) y.this.getSelectTitle().getTranslationY()) - this.prevTranslation;
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("QuickSearchFilterTitleAnimator", "updateByCalcRatio calcRatio=" + calcRatio + " dy=" + translationY);
            }
            y.this.getFeedListView().scrollBy(0, -translationY);
            this.prevTranslation = (int) y.this.getSelectTitle().getTranslationY();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            a("onAnimationCancel");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            a("onAnimationEnd");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            y.this.disableTouch = true;
            y.this.getFeedListView().addOnItemTouchListener(y.f231817g);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NotNull ValueAnimator animation) {
            float f16;
            float f17;
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            if (this.f231826h) {
                int i3 = this.startTranslation;
                f16 = (floatValue * (i3 + r1)) + (-i3);
                f17 = this.f231827i;
            } else {
                f16 = (floatValue * this.startTranslation) + (-r0);
                f17 = this.f231827i;
            }
            b(f16 / f17);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }
}
