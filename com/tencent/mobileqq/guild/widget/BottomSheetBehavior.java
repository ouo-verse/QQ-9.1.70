package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ%\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\rH\u0016\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/BottomSheetBehavior;", "V", "Landroid/view/View;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "()V", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "originPeekHeightAuto", "", "peekHeightByMe", "", "onLayoutChild", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "layoutDirection", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;I)Z", "setPeekHeight", "", "peekHeight", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public class BottomSheetBehavior<V extends View> extends com.google.android.material.bottomsheet.BottomSheetBehavior<V> {
    private boolean originPeekHeightAuto;
    private int peekHeightByMe;

    public BottomSheetBehavior() {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NotNull CoordinatorLayout parent, @NotNull V child, int layoutDirection) {
        boolean z16;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Context context = parent.getContext();
        if (!AppSetting.t(context)) {
            return super.onLayoutChild(parent, child, layoutDirection);
        }
        if (context.getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && getPeekHeight() == -1) {
            Logger.f235387a.d().i("BottomSheetBehavior", 1, "onLayoutChild landscape");
            this.originPeekHeightAuto = true;
            int height = (int) (parent.getHeight() * 0.6d);
            this.peekHeightByMe = height;
            super.setPeekHeight(height);
        } else if (!z16 && this.originPeekHeightAuto && this.peekHeightByMe == getPeekHeight()) {
            Logger.f235387a.d().i("BottomSheetBehavior", 1, "onLayoutChild portrait");
            this.peekHeightByMe = -1;
            super.setPeekHeight(-1);
        }
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setPeekHeight(int peekHeight) {
        if (peekHeight != -1) {
            this.originPeekHeightAuto = false;
        }
        super.setPeekHeight(peekHeight);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetBehavior(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
