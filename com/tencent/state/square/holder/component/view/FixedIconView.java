package com.tencent.state.square.holder.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.SimpleSquarePagViewListener;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.databinding.VasSquareAvatarComponentFixedIconBinding;
import com.tencent.state.view.SquareImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0014J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\u0006\u0010\u0019\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/holder/component/view/FixedIconView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareAvatarComponentFixedIconBinding;", "fixedPag", "Lcom/tencent/state/square/api/ISquarePagView;", "hide", "", "hideAll", "hidePag", "hideStaticIcon", "initPag", NodeProps.ON_ATTACHED_TO_WINDOW, "onUpdateFixedState", "data", "Lcom/tencent/state/square/data/SquareAvatarItem;", "show", "showPag", "showStaticIcon", "updateLayout", "id", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FixedIconView extends FrameLayout {
    private final VasSquareAvatarComponentFixedIconBinding binding;
    private ISquarePagView fixedPag;

    public FixedIconView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void hideStaticIcon() {
        SquareImageView squareImageView = this.binding.fixedStatic;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.fixedStatic");
        squareImageView.setVisibility(8);
    }

    private final void initPag() {
        if (this.fixedPag == null) {
            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ISquarePagView pagImageView = commonUtils.getPagImageView(context);
            this.fixedPag = pagImageView;
            if (pagImageView != null) {
                addView(pagImageView.getView(), new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    private final void showPag() {
        View view;
        show();
        ISquarePagView iSquarePagView = this.fixedPag;
        if (iSquarePagView == null || (view = iSquarePagView.getView()) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public final void hideAll() {
        hidePag();
        hideStaticIcon();
        hide();
    }

    public final void hidePag() {
        View view;
        ISquarePagView iSquarePagView = this.fixedPag;
        if (iSquarePagView == null || (view = iSquarePagView.getView()) == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public final void onUpdateFixedState(final SquareAvatarItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        hideStaticIcon();
        showPag();
        initPag();
        ISquarePagView iSquarePagView = this.fixedPag;
        if (iSquarePagView != null) {
            iSquarePagView.setPagViewListener(new SimpleSquarePagViewListener() { // from class: com.tencent.state.square.holder.component.view.FixedIconView$onUpdateFixedState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(null, 1, null);
                }

                @Override // com.tencent.state.square.api.SimpleSquarePagViewListener, com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationEnd(ISquarePagView squarePagView) {
                    FixedIconView.this.hidePag();
                    if (data.getExtra().getIsFixed()) {
                        FixedIconView.this.showStaticIcon();
                    } else {
                        FixedIconView.this.hideAll();
                    }
                }
            });
        }
        if (data.getExtra().getIsFixed()) {
            ISquarePagView iSquarePagView2 = this.fixedPag;
            if (iSquarePagView2 != null) {
                iSquarePagView2.setPagFile(R.raw.f130971);
            }
            ISquarePagView iSquarePagView3 = this.fixedPag;
            if (iSquarePagView3 != null) {
                iSquarePagView3.playPag(1);
                return;
            }
            return;
        }
        ISquarePagView iSquarePagView4 = this.fixedPag;
        if (iSquarePagView4 != null) {
            iSquarePagView4.setPagFile(R.raw.f130960);
        }
        ISquarePagView iSquarePagView5 = this.fixedPag;
        if (iSquarePagView5 != null) {
            iSquarePagView5.playPag(1);
        }
    }

    public final void showStaticIcon() {
        show();
        SquareImageView squareImageView = this.binding.fixedStatic;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.fixedStatic");
        squareImageView.setVisibility(0);
    }

    public final void updateLayout(int id5) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.addRule(8, id5);
            layoutParams2.addRule(19, id5);
            layoutParams2.addRule(18, id5);
            layoutParams2.addRule(6, id5);
            layoutParams2.topMargin = -ViewExtensionsKt.dip(getContext(), 20);
        }
    }

    public FixedIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final void show() {
        setVisibility(0);
    }

    public /* synthetic */ FixedIconView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void hide() {
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedIconView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareAvatarComponentFixedIconBinding inflate = VasSquareAvatarComponentFixedIconBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarComponent\u2026ater.from(context), this)");
        this.binding = inflate;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) (layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null);
        if (layoutParams2 != null) {
            layoutParams2.width = -2;
            layoutParams2.height = -2;
        }
    }
}
