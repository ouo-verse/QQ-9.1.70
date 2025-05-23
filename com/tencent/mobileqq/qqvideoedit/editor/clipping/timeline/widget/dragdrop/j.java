package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/j;", "Landroid/view/View$DragShadowBuilder;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDrawShadow", "Landroid/graphics/Point;", "shadowSize", "shadowTouchPoint", "onProvideShadowMetrics", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class j extends View.DragShadowBuilder {
    public j(@Nullable View view) {
        super(view);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(@NotNull Point shadowSize, @NotNull Point shadowTouchPoint) {
        Intrinsics.checkNotNullParameter(shadowSize, "shadowSize");
        Intrinsics.checkNotNullParameter(shadowTouchPoint, "shadowTouchPoint");
        shadowSize.set(1, 1);
        shadowTouchPoint.set(0, 0);
    }
}
