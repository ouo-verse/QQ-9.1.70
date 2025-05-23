package com.tencent.kuikly.core.render.android.css.animation;

import android.animation.TypeEvaluator;
import android.view.View;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/o;", "Landroid/animation/TypeEvaluator;", "Lcom/tencent/kuikly/core/render/android/css/animation/n;", "", "fraction", "startValue", "endValue", "a", "Lcom/tencent/kuikly/core/render/android/css/animation/n;", "reuseTransform", "Landroid/view/View;", "b", "Landroid/view/View;", "targetView", "<init>", "(Landroid/view/View;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class o implements TypeEvaluator<n> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final n reuseTransform;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View targetView;

    public o(@NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        this.targetView = targetView;
        this.reuseTransform = new n(null, targetView);
    }

    @Override // android.animation.TypeEvaluator
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n evaluate(float fraction, @NotNull n startValue, @NotNull n endValue) {
        Intrinsics.checkNotNullParameter(startValue, "startValue");
        Intrinsics.checkNotNullParameter(endValue, "endValue");
        this.reuseTransform.r(startValue.getRotate() + ((endValue.getRotate() - startValue.getRotate()) * fraction));
        this.reuseTransform.s(startValue.getScaleX() + ((endValue.getScaleX() - startValue.getScaleX()) * fraction));
        this.reuseTransform.t(startValue.getScaleY() + ((endValue.getScaleY() - startValue.getScaleY()) * fraction));
        this.reuseTransform.u(startValue.getTranslateX() + ((endValue.getTranslateX() - startValue.getTranslateX()) * fraction));
        this.reuseTransform.v(startValue.getTranslateY() + ((endValue.getTranslateY() - startValue.getTranslateY()) * fraction));
        this.reuseTransform.p(startValue.getPivotX() + ((endValue.getPivotX() - startValue.getPivotX()) * fraction));
        this.reuseTransform.q(startValue.getPivotY() + ((endValue.getPivotY() - startValue.getPivotY()) * fraction));
        KRCSSViewExtensionKt.V(this.targetView, "transform", this.reuseTransform);
        return this.reuseTransform;
    }
}
