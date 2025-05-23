package com.tencent.mobileqq.guild.feed.nativedetail.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u0001\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b/\u00100B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u00102\u001a\u0004\u0018\u000101\u00a2\u0006\u0004\b/\u00103B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u00102\u001a\u0004\u0018\u000101\u0012\u0006\u00104\u001a\u00020\u0013\u00a2\u0006\u0004\b/\u00105J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0017J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0017J\u0014\u0010\u0017\u001a\u00020\u00052\n\u0010\u0016\u001a\u00020\u0015\"\u00020\u0013H\u0017J \u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J0\u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J \u0010\"\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J \u0010#\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J \u0010'\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0013H\u0017J\b\u0010(\u001a\u00020\u0011H\u0016J \u0010,\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0011H\u0016J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011H\u0016\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/refresh/NativeDetailRefreshFooter;", "Landroid/widget/FrameLayout;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshFooter;", "Landroid/content/Context;", "context", "", "a", "Landroid/view/View;", "getView", "Lcom/tencent/richframework/widget/refresh/layout/constant/SpinnerStyle;", "getSpinnerStyle", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshLayout;", "refreshLayout", "Lcom/tencent/richframework/widget/refresh/layout/constant/RefreshState;", "oldState", "newState", "onStateChanged", "", "success", "", "onFinish", "", NodeProps.COLORS, "setPrimaryColors", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshKernel;", "kernel", "height", "maxDragHeight", "onInitialized", "isDragging", "", "percent", "offset", "onMoving", "onReleased", "onStartAnimator", "percentX", "offsetX", "offsetMax", "onHorizontalDrag", "isSupportHorizontalDrag", "duration", "dragRate", "animationOnly", "autoOpen", "noMoreData", "setNoMoreData", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"RestrictedApi"})
/* loaded from: classes13.dex */
public final class NativeDetailRefreshFooter extends FrameLayout implements IRefreshFooter {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NativeDetailRefreshFooter(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(Context context) {
        View view = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bi.b(1), bi.b(1));
        layoutParams.gravity = 17;
        view.setLayoutParams(layoutParams);
        addView(view);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int duration, float dragRate, boolean animationOnly) {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    public SpinnerStyle getSpinnerStyle() {
        SpinnerStyle Translate = SpinnerStyle.Translate;
        Intrinsics.checkNotNullExpressionValue(Translate, "Translate");
        return Translate;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public int onFinish(@NotNull IRefreshLayout refreshLayout, boolean success) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("NativeDetailRefreshFooter", "onFinish " + refreshLayout + ", " + success);
            return 400;
        }
        return 400;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("NativeDetailRefreshFooter", "onHorizontalDrag " + percentX + ", " + offsetX + ", " + offsetMax);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onInitialized(@NotNull IRefreshKernel kernel, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("NativeDetailRefreshFooter", "onInitialized " + kernel + ", " + height + ", " + maxDragHeight);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("NativeDetailRefreshFooter", "onMoving " + isDragging + ", " + percent + ", " + offset + ", " + height + ", " + maxDragHeight);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onReleased(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("NativeDetailRefreshFooter", "onReleased " + refreshLayout + ", " + height + ", " + maxDragHeight);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onStartAnimator(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("NativeDetailRefreshFooter", "onStartAnimator " + refreshLayout + ", " + height + ", " + maxDragHeight);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    @SuppressLint({"RestrictedApi"})
    public void onStateChanged(@NotNull IRefreshLayout refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter
    public boolean setNoMoreData(boolean noMoreData) {
        return true;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void setPrimaryColors(@NotNull int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("NativeDetailRefreshFooter", "setPrimaryColors " + colors);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NativeDetailRefreshFooter(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeDetailRefreshFooter(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    public View getView() {
        return this;
    }
}
