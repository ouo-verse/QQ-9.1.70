package com.tencent.mobileqq.guild.profile.profilecard.joined.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.widget.banner.OverScrollLoadingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import kotlin.C11734b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0002\n@B'\b\u0007\u0012\u0006\u00109\u001a\u000208\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:\u0012\b\b\u0002\u0010<\u001a\u00020\u000f\u00a2\u0006\u0004\b=\u0010>J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0000H\u0016J\u0010\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bH\u0016J\u0014\u0010\u0011\u001a\u00020\b2\n\u0010\u0010\u001a\u00020\u000e\"\u00020\u000fH\u0016J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J0\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J \u0010\u001d\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J \u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J \u0010)\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0017H\u0016J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0017H\u0016R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010*\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileRefreshFooter;", "Landroid/widget/FrameLayout;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshFooter;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshLayout;", "refreshLayout", "Lcom/tencent/richframework/widget/refresh/layout/constant/RefreshState;", "oldState", "newState", "", "onStateChanged", "a", "Lcom/tencent/richframework/widget/refresh/layout/constant/SpinnerStyle;", "kotlin.jvm.PlatformType", "getSpinnerStyle", "", "", NodeProps.COLORS, "setPrimaryColors", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshKernel;", "kernel", "height", "maxDragHeight", "onInitialized", "", "isDragging", "", "percent", "offset", "onMoving", "onReleased", "onStartAnimator", "success", "onFinish", "percentX", "offsetX", "offsetMax", "onHorizontalDrag", "isSupportHorizontalDrag", "duration", "dragRate", "animationOnly", "autoOpen", "noMoreData", "setNoMoreData", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileRefreshFooter$b;", "d", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileRefreshFooter$b;", "loadingFrameLayout", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvTips", "f", "Z", "show", tl.h.F, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"RestrictedApi"})
/* loaded from: classes14.dex */
public final class GuildProfileRefreshFooter extends FrameLayout implements IRefreshFooter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b loadingFrameLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView tvTips;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean show;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean noMoreData;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileRefreshFooter$b;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView;", "d", "Lcom/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView;", "a", "()Lcom/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView;", "innerLoadingView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
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
    public GuildProfileRefreshFooter(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int duration, float dragRate, boolean animationOnly) {
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isColorLevel()) {
            QLog.w("Guild.component.Guild.profile.GuildProfileRefreshFooter", 2, "autoOpen(" + duration + ", " + dragRate + ", " + animationOnly + ")", null);
            return false;
        }
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.FixedBehind;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public int onFinish(@NotNull IRefreshLayout refreshLayout, boolean success) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.component.Guild.profile.GuildProfileRefreshFooter", 2, "onFinish " + refreshLayout + ", " + success, (Throwable) null);
        }
        refreshLayout.finishRefresh();
        return 300;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.component.Guild.profile.GuildProfileRefreshFooter", 2, "onHorizontalDrag " + percentX + ", " + offsetX + ", " + offsetMax, (Throwable) null);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onInitialized(@NotNull IRefreshKernel kernel, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.component.Guild.profile.GuildProfileRefreshFooter", 2, "onInitialized " + kernel + ", " + height + ", " + maxDragHeight, (Throwable) null);
        }
        this.loadingFrameLayout.getInnerLoadingView().setLoadingColorType(1, false);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.component.Guild.profile.GuildProfileRefreshFooter", 2, "onMoving " + isDragging + ", " + percent + ", " + offset + ", " + height + ", " + maxDragHeight, (Throwable) null);
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
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.component.Guild.profile.GuildProfileRefreshFooter", 2, "onReleased " + refreshLayout + ", " + height + ", " + maxDragHeight, (Throwable) null);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onStartAnimator(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.component.Guild.profile.GuildProfileRefreshFooter", 2, "onStartAnimator " + refreshLayout + ", " + height + ", " + maxDragHeight, (Throwable) null);
        }
        this.loadingFrameLayout.getInnerLoadingView().setDynamicImageDrawable();
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NotNull IRefreshLayout refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isColorLevel()) {
            QLog.w("Guild.component.Guild.profile.GuildProfileRefreshFooter", 2, "onStateChanged " + refreshLayout + ", " + oldState + ", " + newState, null);
        }
        if (this.show && newState == RefreshState.PullDownCanceled) {
            this.show = false;
            this.loadingFrameLayout.getInnerLoadingView().i();
        }
        if (this.noMoreData && this.tvTips.getVisibility() == 8) {
            this.tvTips.setVisibility(0);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter
    public boolean setNoMoreData(boolean noMoreData) {
        this.noMoreData = noMoreData;
        if (noMoreData) {
            this.loadingFrameLayout.setVisibility(8);
        } else {
            this.tvTips.setVisibility(8);
            this.loadingFrameLayout.setVisibility(0);
        }
        return noMoreData;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void setPrimaryColors(@NotNull int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildProfileRefreshFooter(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildProfileRefreshFooter(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildProfileRefreshFooter(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.ela, this);
        View findViewById = inflate.findViewById(R.id.kbr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tv_tips)");
        TextView textView = (TextView) findViewById;
        this.tvTips = textView;
        textView.setVisibility(8);
        b bVar = new b(context);
        this.loadingFrameLayout = bVar;
        View rootView = inflate.getRootView();
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) cw.d(60));
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        ((FrameLayout) rootView).addView(bVar, layoutParams);
        bVar.getInnerLoadingView().setVisibility(4);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GuildProfileRefreshFooter getView() {
        return this;
    }
}
