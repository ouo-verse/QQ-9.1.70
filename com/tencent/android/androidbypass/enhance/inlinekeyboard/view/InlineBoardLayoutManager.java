package com.tencent.android.androidbypass.enhance.inlinekeyboard.view;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0013*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0004 \u001a\u001d\fB\u001b\u0012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020/0.\u00a2\u0006\u0004\b2\u00103J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0019\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006JI\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00028\u00002\b\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0018J'\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R'\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010$\u001a\u0004\b%\u0010&R\"\u0010-\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager;", "DispatchContext", "Payload", "", "Landroid/view/View;", "target", "", "e", "", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "f", "()[[Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "d", "i", "ctx", "payload", "buttonRows", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "listener", h.F, "(Ljava/lang/Object;Ljava/lang/Object;[[Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;)V", "", "fadeIn", "prelineFirstView", "Landroidx/constraintlayout/widget/ConstraintLayout;", ParseCommon.CONTAINER, "b", "", "preViewId", "c", "(ZLjava/lang/Integer;Landroidx/constraintlayout/widget/ConstraintLayout;)V", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/a;", "Lkotlin/Lazy;", "g", "()Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/a;", "mAdapter", "I", "getAnimationTimeMs", "()I", "setAnimationTimeMs", "(I)V", "animationTimeMs", "Lkotlin/Function1;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnStyleSheet;", "Lkotlin/jvm/functions/Function1;", "styleSheetProvider", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class InlineBoardLayoutManager<DispatchContext, Payload> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final b f72250e;

    /* renamed from: f, reason: collision with root package name */
    private static WeakReference<RecyclerView.RecycledViewPool> f72251f;

    /* renamed from: g, reason: collision with root package name */
    private static int f72252g;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy mAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int animationTimeMs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Function1<com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a, InlineBtnStyleSheet> styleSheetProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager$a;", "", "", "ANIMATION_TIME_IN_MS", "I", "MAX_COUNT_PER_LINE", "SPAN_COUNT", "", "TAG", "Ljava/lang/String;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager$b;", "sAnimationInterceptor", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager$b;", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "sSharedViewPool", "Ljava/lang/ref/WeakReference;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBoardLayoutManager$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ(\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager$b;", "Landroid/view/animation/Interpolator;", "", "input", "b", "c", "d", "a", "getInterpolation", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class b implements Interpolator {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        private final float a(float input, float b16, float c16, float d16) {
            return ((-c16) * ((float) Math.cos((input / d16) * 1.5707963267948966d))) + c16 + b16;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Float) iPatchRedirector.redirect((short) 1, this, Float.valueOf(input))).floatValue();
            }
            return a(input, 0.0f, 1.0f, 1.0f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager$c;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "(Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public final class c extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) InlineBoardLayoutManager.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            InlineBtnView inlineBtnView = (InlineBtnView) view;
            InlineBoardLayoutManager.this.g().i0().get(parent.getChildAdapterPosition(view));
            int d16 = com.tencent.android.androidbypass.enhance.c.a(inlineBtnView.getContext()).d(inlineBtnView.H0().d());
            int i3 = d16 / 2;
            outRect.left = i3;
            outRect.top = d16;
            outRect.right = i3;
            outRect.bottom = 0;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager$d;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "<init>", "(Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public final class d extends GridLayoutManager.SpanSizeLookup {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) InlineBoardLayoutManager.this);
            }
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this, position)).intValue();
            }
            return 2520 / Math.min(InlineBoardLayoutManager.this.g().k0()[InlineBoardLayoutManager.this.g().i0().get(position).b()].length, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "DispatchContext", "Payload", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f72260d;

        e(View view) {
            this.f72260d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullExpressionValue(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                View view = this.f72260d;
                Intrinsics.checkNotNull(view);
                view.setAlpha(floatValue);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17607);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        INSTANCE = new Companion(null);
        f72250e = new b();
        f72252g = 20;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InlineBoardLayoutManager(@NotNull Function1<? super com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a, ? extends InlineBtnStyleSheet> styleSheetProvider) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(styleSheetProvider, "styleSheetProvider");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) styleSheetProvider);
            return;
        }
        this.styleSheetProvider = styleSheetProvider;
        lazy = LazyKt__LazyJVMKt.lazy(InlineBoardLayoutManager$mAdapter$2.INSTANCE);
        this.mAdapter = lazy;
        this.animationTimeMs = 200;
    }

    private final void e(View target) {
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        animator.setInterpolator(f72250e);
        animator.addUpdateListener(new e(target));
        animator.setDuration(this.animationTimeMs * 2);
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a<DispatchContext, Payload> g() {
        return (a) this.mAdapter.getValue();
    }

    public final void b(boolean fadeIn, @Nullable View prelineFirstView, @NotNull ConstraintLayout container) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(fadeIn), prelineFirstView, container);
            return;
        }
        Intrinsics.checkNotNullParameter(container, "container");
        if (prelineFirstView != null) {
            num = Integer.valueOf(prelineFirstView.getId());
        } else {
            num = null;
        }
        c(fadeIn, num, container);
    }

    public final void c(boolean fadeIn, @Nullable Integer preViewId, @NotNull ConstraintLayout container) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(fadeIn), preViewId, container);
            return;
        }
        Intrinsics.checkNotNullParameter(container, "container");
        if (this.mRecyclerView != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(container.getContext(), 2520);
            gridLayoutManager.setSpanSizeLookup(new d());
            RecyclerView recyclerView = new RecyclerView(container.getContext());
            this.mRecyclerView = recyclerView;
            recyclerView.setLayoutManager(gridLayoutManager);
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            }
            recyclerView2.setHasFixedSize(true);
            RecyclerView recyclerView3 = this.mRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            }
            recyclerView3.setNestedScrollingEnabled(false);
            RecyclerView recyclerView4 = this.mRecyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            }
            recyclerView4.setAdapter(g());
            RecyclerView recyclerView5 = this.mRecyclerView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            }
            recyclerView5.addItemDecoration(new c());
            RecyclerView recyclerView6 = this.mRecyclerView;
            if (recyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            }
            RecyclerView.RecycledViewPool recycledViewPool = null;
            recyclerView6.setItemAnimator(null);
            WeakReference<RecyclerView.RecycledViewPool> weakReference = f72251f;
            if (weakReference != null) {
                recycledViewPool = weakReference.get();
            }
            if (recycledViewPool == null) {
                RecyclerView recyclerView7 = this.mRecyclerView;
                if (recyclerView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                }
                RecyclerView.RecycledViewPool recycledViewPool2 = recyclerView7.getRecycledViewPool();
                recycledViewPool2.setMaxRecycledViews(0, f72252g);
                Unit unit = Unit.INSTANCE;
                f72251f = new WeakReference<>(recycledViewPool2);
            } else {
                RecyclerView recyclerView8 = this.mRecyclerView;
                if (recyclerView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                }
                recyclerView8.setRecycledViewPool(recycledViewPool);
            }
        }
        RecyclerView recyclerView9 = this.mRecyclerView;
        if (recyclerView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        }
        if (recyclerView9.getParent() == null) {
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(0, -2);
            layoutParams.startToStart = 0;
            layoutParams.endToEnd = 0;
            if (preViewId != null) {
                layoutParams.topToBottom = preViewId.intValue();
            } else {
                layoutParams.topToTop = 0;
            }
            RecyclerView recyclerView10 = this.mRecyclerView;
            if (recyclerView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            }
            container.addView(recyclerView10, layoutParams);
        }
        if (fadeIn) {
            RecyclerView recyclerView11 = this.mRecyclerView;
            if (recyclerView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            }
            e(recyclerView11);
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        g().n0(null, null, new com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[0], null, this.styleSheetProvider);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            }
            if (recyclerView.getParent() != null) {
                RecyclerView recyclerView2 = this.mRecyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                }
                ViewParent parent = recyclerView2.getParent();
                if (parent != null) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    RecyclerView recyclerView3 = this.mRecyclerView;
                    if (recyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                    }
                    viewGroup.removeView(recyclerView3);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
    }

    @NotNull
    public final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return g().j0();
    }

    public final void h(DispatchContext ctx, @Nullable Payload payload, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] buttonRows, @Nullable com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<DispatchContext, Payload> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, ctx, payload, buttonRows, listener);
        } else {
            Intrinsics.checkNotNullParameter(buttonRows, "buttonRows");
            g().n0(ctx, payload, buttonRows, listener, this.styleSheetProvider);
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            g().notifyItemRangeChanged(0, g().i0().size());
        }
    }
}
