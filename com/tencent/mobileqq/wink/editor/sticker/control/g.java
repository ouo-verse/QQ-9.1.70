package com.tencent.mobileqq.wink.editor.sticker.control;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel;", "", "horizontalPaddingDp", "cursorHeightDp", "", "cursorTouchAreaScale", "Lcom/tencent/mobileqq/wink/editor/sticker/control/c;", "a", "Landroid/content/Context;", "context", "c", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g {
    @TargetApi(17)
    @NotNull
    public static final c a(@NotNull TimelinePanel timelinePanel, float f16, float f17, int i3) {
        Intrinsics.checkNotNullParameter(timelinePanel, "<this>");
        timelinePanel.F0().setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(timelinePanel.getContext());
        View view = new View(timelinePanel.getContext());
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        view.setLayoutParams(new FrameLayout.LayoutParams((int) c(3.0f, context), -1));
        Drawable drawable = view.getResources().getDrawable(R.drawable.f162675m34);
        drawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        view.setBackground(drawable);
        frameLayout.addView(view);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        Context context2 = timelinePanel.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        layoutParams.setMarginStart((int) c(f16, context2));
        Context context3 = timelinePanel.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        layoutParams.setMarginEnd((int) c(f16, context3));
        Unit unit = Unit.INSTANCE;
        timelinePanel.addView(frameLayout, layoutParams);
        return new c(view, frameLayout, i3);
    }

    public static /* synthetic */ c b(TimelinePanel timelinePanel, float f16, float f17, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            f16 = 40.0f;
        }
        if ((i16 & 2) != 0) {
            f17 = 76.0f;
        }
        if ((i16 & 4) != 0) {
            i3 = 2;
        }
        return a(timelinePanel, f16, f17, i3);
    }

    private static final float c(float f16, Context context) {
        return TypedValue.applyDimension(1, f16, context.getResources().getDisplayMetrics());
    }
}
