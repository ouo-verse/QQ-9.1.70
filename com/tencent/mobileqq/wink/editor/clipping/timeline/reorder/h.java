package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/h;", "Landroid/animation/TypeEvaluator;", "Landroid/graphics/Rect;", "", "fraction", "startValue", "endValue", "a", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "<init>", "(Landroid/graphics/Rect;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class h implements TypeEvaluator<Rect> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect rect;

    public h(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.rect = rect;
    }

    @Override // android.animation.TypeEvaluator
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float fraction, @NotNull Rect startValue, @NotNull Rect endValue) {
        Intrinsics.checkNotNullParameter(startValue, "startValue");
        Intrinsics.checkNotNullParameter(endValue, "endValue");
        int i3 = startValue.left;
        int i16 = startValue.top;
        int i17 = (int) (startValue.right + ((endValue.right - r2) * fraction));
        int i18 = startValue.bottom;
        Rect rect = this.rect;
        rect.set(i3, i16, i17, i18);
        return rect;
    }
}
