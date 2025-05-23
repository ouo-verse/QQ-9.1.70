package com.tencent.mobileqq.guild.component.banner.viewpager2;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00019B\u001f\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u0010!\u001a\u00020\u0001\u0012\u0006\u0010)\u001a\u00020\"\u00a2\u0006\u0004\b6\u00107J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J.\u0010\u0010\u001a\u00020\u000f2\n\u0010\u000b\u001a\u00060\nR\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u0013\u001a\u00020\b2\n\u0010\u000b\u001a\u00060\nR\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J0\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016R\u0014\u0010!\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001d\u00103\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/component/banner/viewpager2/ProxySmoothScrollerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "position", "", "smoothScrollToPosition", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "recycler", "action", "Landroid/os/Bundle;", "args", "", "performAccessibilityAction", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "info", "onInitializeAccessibilityNodeInfo", "", "extraLayoutSpace", "calculateExtraLayoutSpace", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "child", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "immediate", "focusedChildVisible", "requestChildRectangleOnScreen", "d", "Landroidx/recyclerview/widget/LinearLayoutManager;", "originLayoutManager", "", "e", UserInfo.SEX_FEMALE, ReportConstant.COSTREPORT_PREFIX, "()F", "t", "(F)V", "millisecondsPerInch", "", "f", "J", "lastCalculateExtraLayoutSpaceExceptionTime", "Ljava/lang/reflect/Method;", h.F, "Lkotlin/Lazy;", "r", "()Ljava/lang/reflect/Method;", "calculateExtraLayoutSpaceMethod", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroidx/recyclerview/widget/LinearLayoutManager;F)V", "i", "a", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ProxySmoothScrollerLayoutManager extends LinearLayoutManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayoutManager originLayoutManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float millisecondsPerInch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastCalculateExtraLayoutSpaceExceptionTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy calculateExtraLayoutSpaceMethod;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/component/banner/viewpager2/ProxySmoothScrollerLayoutManager$b", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends LinearSmoothScroller {
        b(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return ProxySmoothScrollerLayoutManager.this.getMillisecondsPerInch() / displayMetrics.densityDpi;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProxySmoothScrollerLayoutManager(@NotNull Context context, @NotNull LinearLayoutManager originLayoutManager, float f16) {
        super(context, originLayoutManager.getOrientation(), originLayoutManager.getReverseLayout());
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(originLayoutManager, "originLayoutManager");
        this.originLayoutManager = originLayoutManager;
        this.millisecondsPerInch = f16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: com.tencent.mobileqq.guild.component.banner.viewpager2.ProxySmoothScrollerLayoutManager$calculateExtraLayoutSpaceMethod$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Method invoke() {
                LinearLayoutManager linearLayoutManager;
                LinearLayoutManager linearLayoutManager2;
                try {
                    Field declaredField = LinearLayoutManager.class.getDeclaredField("mLayoutState");
                    declaredField.setAccessible(true);
                    linearLayoutManager = ProxySmoothScrollerLayoutManager.this.originLayoutManager;
                    declaredField.set(linearLayoutManager, declaredField.get(ProxySmoothScrollerLayoutManager.this));
                    linearLayoutManager2 = ProxySmoothScrollerLayoutManager.this.originLayoutManager;
                    Method declaredMethod = linearLayoutManager2.getClass().getDeclaredMethod("calculateExtraLayoutSpace", RecyclerView.State.class, int[].class);
                    Intrinsics.checkNotNullExpressionValue(declaredMethod, "originLayoutManager.java\u2026:class.java\n            )");
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (Exception e16) {
                    QLog.e("Guild.component.ProxySmoothScrollerLayoutManager", 1, "calculateExtraLayoutSpaceMethod", e16);
                    return null;
                }
            }
        });
        this.calculateExtraLayoutSpaceMethod = lazy;
    }

    private final Method r() {
        return (Method) this.calculateExtraLayoutSpaceMethod.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void calculateExtraLayoutSpace(@NotNull RecyclerView.State state, @NotNull int[] extraLayoutSpace) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(extraLayoutSpace, "extraLayoutSpace");
        try {
            Method r16 = r();
            if (r16 != null) {
                r16.invoke(this.originLayoutManager, state, extraLayoutSpace);
            }
        } catch (Exception e16) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.lastCalculateExtraLayoutSpaceExceptionTime > 600000) {
                this.lastCalculateExtraLayoutSpaceExceptionTime = uptimeMillis;
                QLog.e("Guild.component.ProxySmoothScrollerLayoutManager", 1, "calculateExtraLayoutSpace", e16);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfo(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state, @NotNull AccessibilityNodeInfoCompat info) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(info, "info");
        this.originLayoutManager.onInitializeAccessibilityNodeInfo(recycler, state, info);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean performAccessibilityAction(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state, int action, @Nullable Bundle args) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        return this.originLayoutManager.performAccessibilityAction(recycler, state, action, args);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(@NotNull RecyclerView parent, @NotNull View child, @NotNull Rect rect, boolean immediate, boolean focusedChildVisible) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(rect, "rect");
        return this.originLayoutManager.requestChildRectangleOnScreen(parent, child, rect, immediate, focusedChildVisible);
    }

    /* renamed from: s, reason: from getter */
    public final float getMillisecondsPerInch() {
        return this.millisecondsPerInch;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state, int position) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(state, "state");
        b bVar = new b(recyclerView.getContext());
        bVar.setTargetPosition(position);
        startSmoothScroll(bVar);
    }

    public final void t(float f16) {
        this.millisecondsPerInch = f16;
    }
}
