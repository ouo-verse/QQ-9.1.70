package com.tencent.mobileqq.guild.main.channellist.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.widget.af;
import com.tencent.mobileqq.guild.widget.banner.OverScrollLoadingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0002\r?B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u0012\u00a2\u0006\u0004\b<\u0010=J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J \u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0000H\u0016J\u0010\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eH\u0016J\u0014\u0010\u0014\u001a\u00020\u00052\n\u0010\u0013\u001a\u00020\u0011\"\u00020\u0012H\u0016J \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J0\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J \u0010 \u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J \u0010!\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u001aH\u0016J \u0010'\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0016J\b\u0010(\u001a\u00020\u001aH\u0016J \u0010,\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001aH\u0016R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/guild/main/channellist/view/RefreshHeader;", "Landroid/widget/FrameLayout;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshHeader;", "Lcom/tencent/mobileqq/guild/widget/af;", "listener", "", "setRefreshStateListener", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshLayout;", "refreshLayout", "Lcom/tencent/richframework/widget/refresh/layout/constant/RefreshState;", "oldState", "newState", "onStateChanged", "a", "Lcom/tencent/richframework/widget/refresh/layout/constant/SpinnerStyle;", "kotlin.jvm.PlatformType", "getSpinnerStyle", "", "", NodeProps.COLORS, "setPrimaryColors", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshKernel;", "kernel", "height", "maxDragHeight", "onInitialized", "", "isDragging", "", "percent", "offset", "onMoving", "onReleased", "onStartAnimator", "success", "onFinish", "percentX", "offsetX", "offsetMax", "onHorizontalDrag", "isSupportHorizontalDrag", "duration", "dragRate", "animationOnly", "autoOpen", "Lcom/tencent/mobileqq/guild/main/channellist/view/RefreshHeader$b;", "d", "Lcom/tencent/mobileqq/guild/main/channellist/view/RefreshHeader$b;", "loadingFrameLayout", "e", "Z", "show", "f", "Lcom/tencent/mobileqq/guild/widget/af;", "refreshStateListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"RestrictedApi"})
/* loaded from: classes14.dex */
public final class RefreshHeader extends FrameLayout implements IRefreshHeader {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b loadingFrameLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean show;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private af refreshStateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/main/channellist/view/RefreshHeader$b;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView;", "d", "Lcom/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView;", "a", "()Lcom/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView;", "innerLoadingView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private static final class b extends FrameLayout {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final OverScrollLoadingView innerLoadingView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            OverScrollLoadingView overScrollLoadingView = new OverScrollLoadingView(context);
            overScrollLoadingView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.innerLoadingView = overScrollLoadingView;
            setClipChildren(false);
            setClipToPadding(false);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) cw.b(20), (int) cw.b(20));
            layoutParams.gravity = 17;
            Unit unit = Unit.INSTANCE;
            addView(overScrollLoadingView, layoutParams);
            setPadding(0, (int) cw.b(10), 0, (int) cw.b(10));
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final OverScrollLoadingView getInnerLoadingView() {
            return this.innerLoadingView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RefreshHeader(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int duration, float dragRate, boolean animationOnly) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.CLST.RefreshHeader", "autoOpen(" + duration + ", " + dragRate + ", " + animationOnly + ")");
            return false;
        }
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    /* renamed from: getSpinnerStyle */
    public SpinnerStyle getFooterSpinnerStyle() {
        return SpinnerStyle.FixedBehind;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public int onFinish(@NotNull IRefreshLayout refreshLayout, boolean success) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.CLST.RefreshHeader", "onFinish " + refreshLayout + ", " + success);
        }
        refreshLayout.finishRefresh();
        return 300;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.CLST.RefreshHeader", "onHorizontalDrag " + percentX + ", " + offsetX + ", " + offsetMax);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onInitialized(@NotNull IRefreshKernel kernel, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.CLST.RefreshHeader", "onInitialized " + kernel + ", " + height + ", " + maxDragHeight);
        }
        this.loadingFrameLayout.getInnerLoadingView().setLoadingColorType(1, false);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.CLST.RefreshHeader", "onMoving " + isDragging + ", " + percent + ", " + offset + ", " + height + ", " + maxDragHeight);
        }
        if (!isDragging) {
            if (percent < 1.0f && this.show) {
                this.show = false;
                this.loadingFrameLayout.getInnerLoadingView().setVisibility(4);
                return;
            }
            return;
        }
        if (percent >= 1.0f && !this.show) {
            this.show = true;
            this.loadingFrameLayout.getInnerLoadingView().j();
        } else if (percent < 1.0f && this.show) {
            this.show = false;
            this.loadingFrameLayout.getInnerLoadingView().i();
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onReleased(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.CLST.RefreshHeader", "onReleased " + refreshLayout + ", " + height + ", " + maxDragHeight);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onStartAnimator(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.CLST.RefreshHeader", "onStartAnimator " + refreshLayout + ", " + height + ", " + maxDragHeight);
        }
        this.loadingFrameLayout.getInnerLoadingView().setDynamicImageDrawable();
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NotNull IRefreshLayout refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.CLST.RefreshHeader", "onStateChanged " + refreshLayout + ", " + oldState + ", " + newState);
        }
        boolean z16 = false;
        if (this.show && newState == RefreshState.PullDownCanceled) {
            this.show = false;
            this.loadingFrameLayout.getInnerLoadingView().i();
        }
        af afVar = this.refreshStateListener;
        if (afVar != null) {
            if (newState != RefreshState.None) {
                z16 = true;
            }
            afVar.setRefreshState(z16);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void setPrimaryColors(@NotNull int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
    }

    public final void setRefreshStateListener(@NotNull af listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.refreshStateListener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RefreshHeader(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RefreshHeader(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RefreshHeader(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.exh, this);
        b bVar = new b(context);
        this.loadingFrameLayout = bVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) cw.d(60));
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(bVar, layoutParams);
        bVar.getInnerLoadingView().setVisibility(4);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RefreshHeader getView() {
        return this;
    }
}
