package com.tencent.mobileqq.widget.listitem;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\u001a\u001a\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u001a\n\u0010\t\u001a\u00020\u0004*\u00020\u0000\"(\u0010\u000f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\"\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\f\"\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0014"}, d2 = {"Landroid/view/View;", "", "width", "height", "", "f", "", "radius", "d", "c", "value", "getMarginHorizontal", "(Landroid/view/View;)I", "e", "(Landroid/view/View;I)V", NodeProps.MARGIN_HORIZONTAL, "a", NodeProps.PADDING_HORIZONTAL, "b", NodeProps.PADDING_VERTICAL, "qqui_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ab {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/widget/listitem/ab$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f317004a;

        a(float f16) {
            this.f317004a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f317004a);
        }
    }

    public static final int a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getPaddingLeft() + view.getPaddingRight();
    }

    public static final int b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getPaddingTop() + view.getPaddingBottom();
    }

    public static final void c(@NotNull View view) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }

    public static final void d(@NotNull View view, float f16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setClipToOutline(true);
        view.setOutlineProvider(new a(f16));
    }

    public static final void e(@NotNull View view, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i16;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            int i17 = -2;
            if (layoutParams2 != null) {
                i16 = layoutParams2.width;
            } else {
                i16 = -2;
            }
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            if (layoutParams3 != null) {
                i17 = layoutParams3.height;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i17);
        }
        if (i3 != marginLayoutParams.leftMargin || i3 != marginLayoutParams.rightMargin) {
            marginLayoutParams.leftMargin = i3;
            marginLayoutParams.rightMargin = i3;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static final void f(@NotNull View view, int i3, int i16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(i3, i16));
        } else if (view.getLayoutParams().width != i3 || view.getLayoutParams().height != i16) {
            view.getLayoutParams().width = i3;
            view.getLayoutParams().height = i16;
            view.setLayoutParams(view.getLayoutParams());
        }
    }
}
