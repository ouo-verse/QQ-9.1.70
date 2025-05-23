package com.tencent.mobileqq.tvideo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.r;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.view.ToastTipView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001'B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\f\u0012\b\b\u0002\u0010$\u001a\u00020\f\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0004R$\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/tvideo/view/ToastTipView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "", h.F, "e", "d", "c", "", "text", IECSearchBar.METHOD_SET_TEXT, "", "duration", "j", "f", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "getFadeInAnimator", "()Landroid/animation/ValueAnimator;", "setFadeInAnimator", "(Landroid/animation/ValueAnimator;)V", "fadeInAnimator", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "hideRunnable", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class ToastTipView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView textView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator fadeInAnimator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable hideRunnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ToastTipView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c() {
        if (r.a(getAlpha(), 0.0f)) {
            return;
        }
        ValueAnimator valueAnimator = this.fadeInAnimator;
        Intrinsics.checkNotNull(valueAnimator);
        valueAnimator.reverse();
    }

    private final void d() {
        ValueAnimator valueAnimator = this.fadeInAnimator;
        Intrinsics.checkNotNull(valueAnimator);
        valueAnimator.start();
    }

    private final void e() {
        ValueAnimator valueAnimator = this.fadeInAnimator;
        Intrinsics.checkNotNull(valueAnimator);
        valueAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ToastTipView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c();
    }

    private final void h(Context context) {
        View inflate = View.inflate(context, R.layout.gti, null);
        inflate.findViewById(R.id.icon).setVisibility(8);
        inflate.setBackgroundResource(R.drawable.lyh);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(inflate, layoutParams);
        setVisibility(0);
        setAlpha(0.0f);
        this.textView = (TextView) findViewById(R.id.jfb);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        this.fadeInAnimator = duration;
        if (duration != null) {
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ky2.n
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ToastTipView.i(ToastTipView.this, valueAnimator);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ToastTipView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.setAlpha(((Float) animatedValue).floatValue());
    }

    public final void f() {
        removeCallbacks(this.hideRunnable);
        c();
    }

    public final void j(int duration) {
        e();
        removeCallbacks(this.hideRunnable);
        d();
        postDelayed(this.hideRunnable, duration);
    }

    public final void setFadeInAnimator(@Nullable ValueAnimator valueAnimator) {
        this.fadeInAnimator = valueAnimator;
    }

    public final void setText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.textView;
        Intrinsics.checkNotNull(textView);
        textView.setText(text);
    }

    public final void setTextView(@Nullable TextView textView) {
        this.textView = textView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ToastTipView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ToastTipView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ToastTipView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ToastTipView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.hideRunnable = new Runnable() { // from class: ky2.m
            @Override // java.lang.Runnable
            public final void run() {
                ToastTipView.g(ToastTipView.this);
            }
        };
        h(context);
    }
}
