package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.am;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0012B\u001d\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/google/android/material/appbar/AlwaysCanDragFlingAppBarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getBehavior", "", BdhLogUtil.LogTag.Tag_Req, "Z", "K", "()Z", "setCanCollapsedAppBar", "(Z)V", "canCollapsedAppBar", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "AlwaysCanDragFlingAppbarLayoutBehavior", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public class AlwaysCanDragFlingAppBarLayout extends AppBarLayout {

    /* renamed from: R, reason: from kotlin metadata */
    private boolean canCollapsedAppBar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0084\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J8\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J0\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/google/android/material/appbar/AlwaysCanDragFlingAppBarLayout$AlwaysCanDragFlingAppbarLayoutBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$BaseBehavior;", "Lcom/google/android/material/appbar/AppBarLayout;", "view", "", "c", "appBarLayout", "", "e", "Ljava/lang/Runnable;", "b", "", "canDragView", "getMaxDragOffset", "getScrollRangeForDragFling", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "child", "Landroid/view/View;", "directTargetChild", "target", "nestedScrollAxes", "type", "onStartNestedScroll", "coordinatorLayout", "", "velocityX", "velocityY", "d", "<init>", "(Lcom/google/android/material/appbar/AlwaysCanDragFlingAppBarLayout;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes2.dex */
    protected final class AlwaysCanDragFlingAppbarLayoutBehavior extends AppBarLayout.BaseBehavior<AppBarLayout> {
        public AlwaysCanDragFlingAppbarLayoutBehavior() {
        }

        private final Runnable b() {
            try {
                Field declaredField = AlwaysCanDragFlingAppbarLayoutBehavior.class.getSuperclass().getSuperclass().getDeclaredField("flingRunnable");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                if (!(obj instanceof Runnable)) {
                    return null;
                }
                return (Runnable) obj;
            } catch (Throwable unused) {
                return null;
            }
        }

        private final int c(AppBarLayout view) {
            if (view.getMeasuredHeight() > ImmersiveUtils.getScreenHeight() - am.a(80.0f)) {
                return view.getMeasuredHeight() - (ImmersiveUtils.getScreenHeight() - am.a(80.0f));
            }
            return 0;
        }

        private final void e(AppBarLayout appBarLayout) {
            Runnable b16 = b();
            if (b16 != null) {
                appBarLayout.removeCallbacks(b16);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.HeaderBehavior
        public boolean canDragView(@Nullable AppBarLayout view) {
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean onNestedPreFling(@NotNull CoordinatorLayout coordinatorLayout, @NotNull AppBarLayout child, @NotNull View target, float velocityX, float velocityY) {
            Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(target, "target");
            e(child);
            return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.HeaderBehavior
        public int getMaxDragOffset(@NotNull AppBarLayout view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return AlwaysCanDragFlingAppBarLayout.this.getCanCollapsedAppBar() ? super.getMaxDragOffset((AlwaysCanDragFlingAppbarLayoutBehavior) view) : -c(view);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.HeaderBehavior
        public int getScrollRangeForDragFling(@NotNull AppBarLayout view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return AlwaysCanDragFlingAppBarLayout.this.getCanCollapsedAppBar() ? super.getScrollRangeForDragFling((AlwaysCanDragFlingAppbarLayoutBehavior) view) : c(view);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NotNull CoordinatorLayout parent, @NotNull AppBarLayout child, @NotNull View directTargetChild, @NotNull View target, int nestedScrollAxes, int type) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
            Intrinsics.checkNotNullParameter(target, "target");
            if (AlwaysCanDragFlingAppBarLayout.this.getCanCollapsedAppBar()) {
                return super.onStartNestedScroll(parent, (CoordinatorLayout) child, directTargetChild, target, nestedScrollAxes, type);
            }
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AlwaysCanDragFlingAppBarLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: K, reason: from getter */
    public final boolean getCanCollapsedAppBar() {
        return this.canCollapsedAppBar;
    }

    @Override // com.google.android.material.appbar.AppBarLayout, androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NotNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new AlwaysCanDragFlingAppbarLayoutBehavior();
    }

    public final void setCanCollapsedAppBar(boolean z16) {
        this.canCollapsedAppBar = z16;
    }

    public /* synthetic */ AlwaysCanDragFlingAppBarLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AlwaysCanDragFlingAppBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.canCollapsedAppBar = true;
    }
}
