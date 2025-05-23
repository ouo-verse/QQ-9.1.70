package com.tencent.state.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.state.square.bubblesetting.SquareBubbleColor;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.databinding.VasSquareItemBubbleSimpleMainContainerBinding;
import com.tencent.state.utils.ColorFormatUtils;
import com.tencent.state.view.ICommonBubbleMainContainer;
import com.tencent.state.view.IDetailBubbleMainContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/view/CommonBubbleMainContainer;", "Landroid/widget/FrameLayout;", "Lcom/tencent/state/view/IDetailBubbleMainContainer;", "Lcom/tencent/state/view/ICommonBubbleMainContainer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemBubbleSimpleMainContainerBinding;", "getAddViewLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "getCommonMainContainerView", "Landroid/view/View;", "getSimpleSmallIconView", "Landroid/widget/ImageView;", "getSimpleTextView", "Landroid/widget/TextView;", "getTextString", "", "showCommonView", "", "onlineStatus", "Lcom/tencent/state/square/data/OnlineStatus;", "updateBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CommonBubbleMainContainer extends FrameLayout implements IDetailBubbleMainContainer, ICommonBubbleMainContainer {
    private final VasSquareItemBubbleSimpleMainContainerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonBubbleMainContainer(Context context) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareItemBubbleSimpleMainContainerBinding inflate = VasSquareItemBubbleSimpleMainContainerBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareItemBubbleSimpl\u2026ater.from(context), this)");
        this.binding = inflate;
    }

    @Override // com.tencent.state.view.ICommonBubbleMainContainer
    public void bindSimpleView(boolean z16, OnlineStatus status, boolean z17, Drawable drawable, String str) {
        Intrinsics.checkNotNullParameter(status, "status");
        ICommonBubbleMainContainer.DefaultImpls.bindSimpleView(this, z16, status, z17, drawable, str);
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void clearText() {
        IDetailBubbleMainContainer.DefaultImpls.clearText(this);
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public LinearLayout.LayoutParams getAddViewLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    @Override // com.tencent.state.view.ICommonBubbleMainContainer
    public View getCommonMainContainerView() {
        return this.binding.getRoot();
    }

    @Override // com.tencent.state.view.ICommonBubbleMainContainer
    public String getMainText(boolean z16, boolean z17, OnlineStatus status, String str) {
        Intrinsics.checkNotNullParameter(status, "status");
        return ICommonBubbleMainContainer.DefaultImpls.getMainText(this, z16, z17, status, str);
    }

    @Override // com.tencent.state.view.ICommonBubbleMainContainer
    public ImageView getSimpleSmallIconView() {
        return this.binding.avatarSimpleBubbleIcon;
    }

    @Override // com.tencent.state.view.ICommonBubbleMainContainer
    public TextView getSimpleTextView() {
        return this.binding.avatarSimpleBubbleMainText;
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public String getTextString() {
        TextView textView = this.binding.avatarSimpleBubbleMainText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.avatarSimpleBubbleMainText");
        return textView.getText().toString();
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    /* renamed from: getTrulyText */
    public String getShowText() {
        return IDetailBubbleMainContainer.DefaultImpls.getTrulyText(this);
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void init(OnlineStatus onlineStatus) {
        IDetailBubbleMainContainer.DefaultImpls.init(this, onlineStatus);
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void setFocus(boolean z16) {
        IDetailBubbleMainContainer.DefaultImpls.setFocus(this, z16);
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void showChangeStatusView(OnlineStatus onlineStatus) {
        IDetailBubbleMainContainer.DefaultImpls.showChangeStatusView(this, onlineStatus);
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void showEditedView(OnlineStatus onlineStatus, String str, boolean z16) {
        IDetailBubbleMainContainer.DefaultImpls.showEditedView(this, onlineStatus, str, z16);
    }

    @Override // com.tencent.state.view.ICommonBubbleMainContainer
    public void showSmallIcon(boolean z16, OnlineStatus status, boolean z17, Drawable drawable) {
        Intrinsics.checkNotNullParameter(status, "status");
        ICommonBubbleMainContainer.DefaultImpls.showSmallIcon(this, z16, status, z17, drawable);
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void updateBubbleSkin(SquareBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        ColorFormatUtils colorFormatUtils = ColorFormatUtils.INSTANCE;
        SquareBubbleColor color = bubbleInfo.getColor();
        Integer parse = colorFormatUtils.parse(color != null ? color.getFontColor() : null);
        if (parse != null) {
            this.binding.avatarSimpleBubbleMainText.setTextColor(parse.intValue());
        }
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void updateStatusIcon(OnlineStatus onlineStatus) {
        Intrinsics.checkNotNullParameter(onlineStatus, "onlineStatus");
        IDetailBubbleMainContainer.DefaultImpls.updateStatusIcon(this, onlineStatus);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonBubbleMainContainer(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        VasSquareItemBubbleSimpleMainContainerBinding inflate = VasSquareItemBubbleSimpleMainContainerBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareItemBubbleSimpl\u2026ater.from(context), this)");
        this.binding = inflate;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonBubbleMainContainer(Context context, AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        VasSquareItemBubbleSimpleMainContainerBinding inflate = VasSquareItemBubbleSimpleMainContainerBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareItemBubbleSimpl\u2026ater.from(context), this)");
        this.binding = inflate;
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void showCommonView(OnlineStatus onlineStatus) {
        if (onlineStatus != null) {
            ICommonBubbleMainContainer.DefaultImpls.bindSimpleView$default(this, true, onlineStatus, false, null, null, 24, null);
        }
    }
}
