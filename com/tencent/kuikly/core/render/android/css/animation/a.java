package com.tencent.kuikly.core.render.android.css.animation;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.view.View;
import com.tencent.kuikly.core.render.android.css.decoration.KRViewDecoration;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/a;", "Landroid/animation/TypeEvaluator;", "", "", "fraction", "startValue", "endValue", "a", "(FLjava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/Integer;", "Landroid/animation/ArgbEvaluator;", "Landroid/animation/ArgbEvaluator;", "argbEvaluator", "Landroid/view/View;", "b", "Landroid/view/View;", "targetView", "<init>", "(Landroid/view/View;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a implements TypeEvaluator<Integer> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArgbEvaluator argbEvaluator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View targetView;

    public a(@NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        this.targetView = targetView;
        this.argbEvaluator = new ArgbEvaluator();
    }

    @Override // android.animation.TypeEvaluator
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer evaluate(float fraction, @Nullable Integer startValue, @Nullable Integer endValue) {
        Object evaluate = this.argbEvaluator.evaluate(fraction, startValue, endValue);
        if (evaluate != null) {
            int intValue = ((Integer) evaluate).intValue();
            KRViewDecoration x16 = KRCSSViewExtensionKt.x(this.targetView);
            if (x16 != null) {
                x16.t(intValue);
            }
            return Integer.valueOf(intValue);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
