package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenDefaultHeaderView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00017B\u0011\b\u0016\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104B\u001b\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b3\u00105B#\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b3\u00106J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0002J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u001a\u0010 \u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u0004H\u0014J\u000e\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0002J\u000e\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0002R\u0016\u0010'\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010)\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/FeedHalfScreenFloatingView;", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "", "changed", "", "left", "top", "right", "bottom", "", "onLayout", "type", "P", "L", "Landroid/graphics/drawable/Drawable;", "drawable", "setBackgroundResource", "Lcom/tencent/mobileqq/widget/qus/d;", "controller", "setQUSDragFloatController", "canSlide", "setCanSlide", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "dispatchTouchEvent", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/FeedHalfScreenFloatingView$a;", "listener", "setOutsideTouchEventListener", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", BdhLogUtil.LogTag.Tag_Conn, "headNeedDragIcon", "setHeadNeedDragIcon", "allow", "setAllowConfigurationChanged", "s0", "Lcom/tencent/mobileqq/widget/qus/d;", "mController", "t0", "Z", "mHasShowTotal", "u0", "mCanSlide", "v0", "isHeadNeedDragIcon", "w0", "allowConfigurationChanged", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedHalfScreenFloatingView extends QUSHalfScreenFloatingView {

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.widget.qus.d mController;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private boolean mHasShowTotal;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private boolean mCanSlide;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private boolean isHeadNeedDragIcon;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private boolean allowConfigurationChanged;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/FeedHalfScreenFloatingView$a;", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedHalfScreenFloatingView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCanSlide = true;
        this.isHeadNeedDragIcon = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public void C(@Nullable AttributeSet attrs, int defStyleAttr) {
        super.C(attrs, defStyleAttr);
        View mHeaderView = this.F;
        Intrinsics.checkNotNullExpressionValue(mHeaderView, "mHeaderView");
        ViewGroup.LayoutParams layoutParams = mHeaderView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = cx.a(24.0f);
            mHeaderView.setLayoutParams(layoutParams);
            if (this.isHeadNeedDragIcon) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                relativeLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_r8_top);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout.addView(new QUSHalfScreenDefaultHeaderView(getContext(), null, 0));
                setHeaderView(relativeLayout);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public void L() {
        super.L();
        if (this.allowConfigurationChanged) {
            return;
        }
        if (x() != null) {
            x().setY(0.0f);
        }
        this.R = false;
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public void P(int type) {
        this.mHasShowTotal = true;
        super.P(type);
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        return super.dispatchTouchEvent(ev5);
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
        if (!this.mCanSlide) {
            return true;
        }
        return super.onInterceptTouchEvent(ev5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (!this.mHasShowTotal) {
            return;
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    public final void setAllowConfigurationChanged(boolean allow) {
        this.allowConfigurationChanged = allow;
    }

    public final void setBackgroundResource(@Nullable Drawable drawable) {
        if (x() == null) {
            return;
        }
        x().setBackground(drawable);
    }

    public final void setCanSlide(boolean canSlide) {
        this.mCanSlide = canSlide;
    }

    public final void setHeadNeedDragIcon(boolean headNeedDragIcon) {
        this.isHeadNeedDragIcon = headNeedDragIcon;
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public void setQUSDragFloatController(@NotNull com.tencent.mobileqq.widget.qus.d controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.mController = controller;
        super.setQUSDragFloatController(controller);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedHalfScreenFloatingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCanSlide = true;
        this.isHeadNeedDragIcon = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedHalfScreenFloatingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCanSlide = true;
        this.isHeadNeedDragIcon = true;
    }

    public final void setOutsideTouchEventListener(@Nullable a listener) {
    }
}
