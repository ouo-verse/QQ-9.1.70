package com.tencent.mobileqq.cardcontainer.framework;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J0\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/CardsLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "spacePx", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "child", "widthUsed", "heightUsed", "measureChildWithMargins", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "", "immediate", "focusedChildVisible", "requestChildRectangleOnScreen", "d", "I", "mReserveSpace", "e", "Lkotlin/Lazy;", "r", "()Z", "preventAutoScroll", "Landroid/content/Context;", "context", "orientation", "reverseLayout", "<init>", "(Landroid/content/Context;IZ)V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CardsLinearLayoutManager extends LinearLayoutManager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mReserveSpace;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy preventAutoScroll;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardsLinearLayoutManager(@NotNull Context context, int i3, boolean z16) {
        super(context, i3, z16);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(CardsLinearLayoutManager$preventAutoScroll$2.INSTANCE);
            this.preventAutoScroll = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    private final boolean r() {
        return ((Boolean) this.preventAutoScroll.getValue()).booleanValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(@NotNull View child, int widthUsed, int heightUsed) {
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, child, Integer.valueOf(widthUsed), Integer.valueOf(heightUsed));
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        Object tag = child.getTag(R.id.f9217576);
        ViewGroup.LayoutParams layoutParams2 = child.getLayoutParams();
        if (tag != null && (tag instanceof ViewGroup.LayoutParams)) {
            layoutParams = (ViewGroup.LayoutParams) tag;
        } else if (layoutParams2 != null) {
            layoutParams = new ViewGroup.LayoutParams(layoutParams2);
            child.setTag(R.id.f9217576, layoutParams);
        } else {
            layoutParams = null;
        }
        if (getOrientation() == 1) {
            if (layoutParams == null || layoutParams.height != -1) {
                z16 = false;
            }
            if (z16 && this.mReserveSpace > 0 && layoutParams2 != null) {
                layoutParams2.height = getHeight() - (this.mReserveSpace * 2);
            }
        } else if (getOrientation() == 0) {
            if (layoutParams == null || layoutParams.width != -1) {
                z16 = false;
            }
            if (z16 && this.mReserveSpace > 0 && layoutParams2 != null) {
                layoutParams2.width = getWidth() - (this.mReserveSpace * 2);
            }
        }
        super.measureChildWithMargins(child, widthUsed, heightUsed);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(@NotNull RecyclerView parent, @NotNull View child, @NotNull Rect rect, boolean immediate, boolean focusedChildVisible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, parent, child, rect, Boolean.valueOf(immediate), Boolean.valueOf(focusedChildVisible))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (r()) {
            return false;
        }
        return super.requestChildRectangleOnScreen(parent, child, rect, immediate, focusedChildVisible);
    }

    public final void s(int spacePx) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, spacePx);
        } else {
            this.mReserveSpace = spacePx;
        }
    }
}
