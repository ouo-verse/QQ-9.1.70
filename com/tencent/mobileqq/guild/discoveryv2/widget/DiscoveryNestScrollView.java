package com.tencent.mobileqq.guild.discoveryv2.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.widget.NestedScrollView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.base.extension.t;
import com.tencent.mobileqq.guild.discoveryv2.content.refresh.MVPFeedsRefreshLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.richframework.widget.refresh.layout.util.SmartUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J0\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/widget/DiscoveryNestScrollView;", "Landroidx/core/widget/NestedScrollView;", "Landroid/view/View;", "target", "", "velocityY", "", HippyTKDListViewAdapter.X, "velocityX", "v", "", "dx", "dy", "", "consumed", "type", "", "w", "getScrollRange", "onNestedPreScroll", "onNestedPreFling", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "computeScrollDeltaToGetChildRectOnScreen", "d", "Z", "isInPreFling", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DiscoveryNestScrollView extends NestedScrollView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isInPreFling;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoveryNestScrollView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = getChildAt(0).getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        return (int) Math.max(0.0d, ((r0.getHeight() + layoutParams2.topMargin) + layoutParams2.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    private final boolean v(View target, float velocityX, float velocityY) {
        if (velocityY > 0.0f) {
            if (x(target, velocityY)) {
                return true;
            }
            SmartUtil.fling(target, (int) velocityY);
            return true;
        }
        return false;
    }

    private final void w(View target, int dx5, int dy5, int[] consumed, int type) {
        int scrollRange;
        if (dy5 > 0 && (scrollRange = getScrollRange() - getScrollY()) > 0) {
            int min = Math.min(dy5, scrollRange);
            scrollBy(0, min);
            consumed[1] = min;
        }
    }

    private final boolean x(View target, final float velocityY) {
        final MVPFeedsRefreshLayout mVPFeedsRefreshLayout;
        if (target instanceof MVPFeedsRefreshLayout) {
            mVPFeedsRefreshLayout = (MVPFeedsRefreshLayout) target;
        } else {
            mVPFeedsRefreshLayout = null;
        }
        if (mVPFeedsRefreshLayout == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[fling] tryFlingChild: target is not MVPFeedsRefreshLayout");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.DiscoveryNestScrollView", 1, (String) it.next(), null);
            }
            return false;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.DiscoveryNestScrollView", "tryFlingChild: target=" + target.getClass().getSimpleName() + ", velocityY=" + velocityY);
        }
        mVPFeedsRefreshLayout.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                DiscoveryNestScrollView.y(MVPFeedsRefreshLayout.this, velocityY);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(MVPFeedsRefreshLayout child, float f16) {
        Intrinsics.checkNotNullParameter(child, "$child");
        child.c(f16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.widget.NestedScrollView
    public int computeScrollDeltaToGetChildRectOnScreen(@Nullable Rect rect) {
        int computeScrollDeltaToGetChildRectOnScreen = super.computeScrollDeltaToGetChildRectOnScreen(rect);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.DiscoveryNestScrollView", "computeScrollDeltaToGetChildRectOnScreen: [isInLayout: " + isInLayout() + "] " + rect + ", " + computeScrollDeltaToGetChildRectOnScreen);
        }
        if (isInLayout()) {
            return 0;
        }
        return computeScrollDeltaToGetChildRectOnScreen;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NotNull View target, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(target, "target");
        boolean z16 = true;
        if (this.isInPreFling) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("onNestedPreFling: reEntered, ignore fling");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.DiscoveryNestScrollView", 1, (String) it.next(), null);
            }
            return false;
        }
        Logger logger2 = Logger.f235387a;
        Throwable th5 = new Throwable("onNestedPreFling");
        if (QLog.isDevelopLevel()) {
            Logger.b bVar2 = new Logger.b();
            String str = "onNestedPreFling: inPreFling=" + this.isInPreFling + " target=" + target.getClass().getSimpleName() + ", " + velocityX + "/" + velocityY + ", " + t.a(target) + "/" + t.b(target);
            if (str instanceof String) {
                bVar2.a().add(str);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.DiscoveryNestScrollView", 4, (String) it5.next(), th5);
            }
        }
        this.isInPreFling = true;
        boolean v3 = v(target, velocityX, velocityY);
        Logger.f235387a.d().i("Guild.NewHome.DiscoveryNestScrollView", 1, "flingInternal() ret: " + v3);
        if (!v3 && !super.onNestedPreFling(target, velocityX, velocityY)) {
            z16 = false;
        }
        this.isInPreFling = false;
        return z16;
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NotNull View target, int dx5, int dy5, @NotNull int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.DiscoveryNestScrollView", "onNestedPreScroll: target=" + target.getClass().getSimpleName() + ", " + dx5 + "/" + dy5 + ", " + t.a(target) + "/" + t.b(target));
        }
        w(target, dx5, dy5, consumed, type);
        super.onNestedPreScroll(target, dx5, dy5, consumed, type);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoveryNestScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DiscoveryNestScrollView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoveryNestScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setOverScrollMode(2);
    }
}
