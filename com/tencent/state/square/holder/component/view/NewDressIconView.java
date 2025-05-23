package com.tencent.state.square.holder.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.view.SquareImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/holder/component/view/NewDressIconView;", "Lcom/tencent/state/view/SquareImageView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hide", "", "show", "updateLayout", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class NewDressIconView extends SquareImageView {
    public NewDressIconView(Context context) {
        this(context, null, 0, 6, null);
    }

    public final void updateLayout() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
            layoutParams = null;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.width = ViewExtensionsKt.dip(getContext(), 26);
            layoutParams2.height = ViewExtensionsKt.dip(getContext(), 21);
            layoutParams2.topMargin = ViewExtensionsKt.dip(getContext(), 1);
        }
    }

    public NewDressIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void show() {
        setVisibility(0);
    }

    public /* synthetic */ NewDressIconView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void hide() {
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewDressIconView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) (layoutParams instanceof LinearLayout.LayoutParams ? layoutParams : null);
        if (layoutParams2 != null) {
            layoutParams2.width = -2;
            layoutParams2.height = -2;
        }
        setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.i8l));
    }
}
