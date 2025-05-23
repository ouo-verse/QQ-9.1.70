package com.tencent.kuikly.core.render.android.css.animation;

import android.animation.RectEvaluator;
import android.animation.TypeEvaluator;
import android.graphics.Rect;
import android.view.View;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/b;", "Landroid/animation/TypeEvaluator;", "Landroid/graphics/Rect;", "", "fraction", "startValue", "endValue", "a", "Landroid/animation/RectEvaluator;", "Landroid/animation/RectEvaluator;", "frameEvaluator", "Landroid/view/View;", "b", "Landroid/view/View;", "targetView", "<init>", "(Landroid/view/View;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b implements TypeEvaluator<Rect> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final RectEvaluator frameEvaluator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View targetView;

    public b(@NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        this.targetView = targetView;
        this.frameEvaluator = new RectEvaluator();
    }

    @Override // android.animation.TypeEvaluator
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float fraction, @NotNull Rect startValue, @NotNull Rect endValue) {
        Intrinsics.checkNotNullParameter(startValue, "startValue");
        Intrinsics.checkNotNullParameter(endValue, "endValue");
        Rect newFrame = this.frameEvaluator.evaluate(fraction, startValue, endValue);
        View view = this.targetView;
        Intrinsics.checkNotNullExpressionValue(newFrame, "newFrame");
        KRCSSViewExtensionKt.V(view, AIInput.KEY_FRAME, newFrame);
        return newFrame;
    }
}
