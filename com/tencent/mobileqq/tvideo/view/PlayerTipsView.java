package com.tencent.mobileqq.tvideo.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.view.PlayerTipsView;
import com.tencent.qqlive.common.screen.ScreenUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vx2.PlayerTips;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u00a2\u0006\u0004\b!\u0010\"J \u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001a\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/tvideo/view/PlayerTipsView;", "Landroid/widget/FrameLayout;", "", "Lvx2/c;", "tipsList", "", "isInfiniteTips", "", "j", "", "tips", h.F, "", "height", "f", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "containerLayout", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "hideRunnable", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "flyInAnimator", "Z", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class PlayerTipsView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout containerLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable hideRunnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ValueAnimator flyInAnimator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isInfiniteTips;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlayerTipsView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PlayerTipsView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.setTranslationY((((Float) animatedValue).floatValue() * this$0.getHeight()) - this$0.f(this$0.getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(PlayerTipsView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVisibility(8);
    }

    public static /* synthetic */ void i(PlayerTipsView playerTipsView, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        playerTipsView.h(str, z16);
    }

    public final int f(int height) {
        if (ScreenUtils.isLandscape()) {
            return height;
        }
        return height / 2;
    }

    @JvmOverloads
    public final void h(@NotNull String tips, boolean isInfiniteTips) {
        List<PlayerTips> listOf;
        Intrinsics.checkNotNullParameter(tips, "tips");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new PlayerTips(tips, 0, 2, null));
        j(listOf, isInfiniteTips);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void j(@NotNull List<PlayerTips> tipsList, boolean isInfiniteTips) {
        Intrinsics.checkNotNullParameter(tipsList, "tipsList");
        this.isInfiniteTips = isInfiniteTips;
        removeCallbacks(this.hideRunnable);
        this.flyInAnimator.cancel();
        this.containerLayout.removeAllViews();
        for (PlayerTips playerTips : tipsList) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(1, 14.0f);
            textView.setText(playerTips.getTipsContent());
            textView.setTextColor(getResources().getColor(playerTips.getTipsColor()));
            this.containerLayout.addView(textView);
        }
        this.flyInAnimator.start();
        setVisibility(0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlayerTipsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlayerTipsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PlayerTipsView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlayerTipsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.hideRunnable = new Runnable() { // from class: ky2.a
            @Override // java.lang.Runnable
            public final void run() {
                PlayerTipsView.g(PlayerTipsView.this);
            }
        };
        LayoutInflater.from(context).inflate(R.layout.gh8, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.f97855li);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tips_container)");
        this.containerLayout = (LinearLayout) findViewById;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(0.0f, 1.0f)");
        this.flyInAnimator = ofFloat;
        ofFloat.setDuration(250L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addListener(new a());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ky2.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlayerTipsView.c(PlayerTipsView.this, valueAnimator);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/tvideo/view/PlayerTipsView$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator p06) {
            if (!PlayerTipsView.this.isInfiniteTips) {
                PlayerTipsView playerTipsView = PlayerTipsView.this;
                playerTipsView.postDelayed(playerTipsView.hideRunnable, 3000L);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator p06) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator p06) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator p06) {
        }
    }
}
