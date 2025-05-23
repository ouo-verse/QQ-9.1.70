package com.tencent.mobileqq.guild.media.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0004H\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildFadeOutTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "animDuration", "", "f", tl.h.F, "e", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "mAlphaAnimator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildFadeOutTextView extends AppCompatTextView {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mAlphaAnimator;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFadeOutTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GuildFadeOutTextView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.setAlpha(((Float) animatedValue).floatValue());
    }

    public final void e() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.mAlphaAnimator;
        boolean z16 = false;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            z16 = true;
        }
        if (z16 && (valueAnimator = this.mAlphaAnimator) != null) {
            valueAnimator.cancel();
        }
    }

    public final void f(long animDuration) {
        if (animDuration > 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(animDuration);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.media.widget.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GuildFadeOutTextView.g(GuildFadeOutTextView.this, valueAnimator);
                }
            });
            this.mAlphaAnimator = ofFloat;
        }
    }

    public final void h() {
        ValueAnimator valueAnimator = this.mAlphaAnimator;
        boolean z16 = false;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            z16 = true;
        }
        if (z16) {
            ValueAnimator valueAnimator2 = this.mAlphaAnimator;
            Intrinsics.checkNotNull(valueAnimator2);
            valueAnimator2.start();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFadeOutTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildFadeOutTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFadeOutTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, up1.a.J3);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "getContext().obtainStyle\u2026ble.GuildFadeOutTextView)");
        int i16 = obtainStyledAttributes.getInt(up1.a.K3, 0);
        obtainStyledAttributes.recycle();
        f(i16);
    }
}
