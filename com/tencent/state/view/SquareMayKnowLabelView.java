package com.tencent.state.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareMayKnowLabelBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ-\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/view/SquareMayKnowLabelView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareMayKnowLabelBinding;", VasPerfReportUtils.WHILE_UPDATE_ITEM, "", "text", "", "iconRes", NodeProps.MARGIN_RIGHT, "(Ljava/lang/String;Ljava/lang/Integer;I)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareMayKnowLabelView extends LinearLayout {
    private static final String TAG = "MayKnowTabLayout";
    private final VasSquareMayKnowLabelBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareMayKnowLabelView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareMayKnowLabelBinding inflate = VasSquareMayKnowLabelBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareMayKnowLabelBin\u2026ater.from(context), this)");
        this.binding = inflate;
        setVisibility(8);
        setBackgroundResource(R.drawable.gui);
        setPadding(ViewExtensionsKt.dip(getContext(), 3), 0, ViewExtensionsKt.dip(getContext(), 3), 0);
        setOrientation(0);
    }

    public final void updateView(String text, Integer iconRes, int marginRight) {
        if ((text == null || text.length() == 0) && iconRes == null) {
            return;
        }
        setVisibility(0);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
            layoutParams = null;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (layoutParams2 == null) {
            layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams2.rightMargin = marginRight;
        setLayoutParams(layoutParams2);
        if (iconRes == null) {
            SquareImageView squareImageView = this.binding.mayKnowIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.mayKnowIcon");
            squareImageView.setVisibility(8);
        } else {
            this.binding.mayKnowIcon.setImageResource(iconRes.intValue());
            SquareImageView squareImageView2 = this.binding.mayKnowIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.mayKnowIcon");
            squareImageView2.setVisibility(0);
        }
        TextView textView = this.binding.mayKnowText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.mayKnowText");
        textView.setText(text);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareMayKnowLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareMayKnowLabelBinding inflate = VasSquareMayKnowLabelBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareMayKnowLabelBin\u2026ater.from(context), this)");
        this.binding = inflate;
        setVisibility(8);
        setBackgroundResource(R.drawable.gui);
        setPadding(ViewExtensionsKt.dip(getContext(), 3), 0, ViewExtensionsKt.dip(getContext(), 3), 0);
        setOrientation(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareMayKnowLabelView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareMayKnowLabelBinding inflate = VasSquareMayKnowLabelBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareMayKnowLabelBin\u2026ater.from(context), this)");
        this.binding = inflate;
        setVisibility(8);
        setBackgroundResource(R.drawable.gui);
        setPadding(ViewExtensionsKt.dip(getContext(), 3), 0, ViewExtensionsKt.dip(getContext(), 3), 0);
        setOrientation(0);
    }

    public static /* synthetic */ void updateView$default(SquareMayKnowLabelView squareMayKnowLabelView, String str, Integer num, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = null;
        }
        if ((i16 & 2) != 0) {
            num = null;
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        squareMayKnowLabelView.updateView(str, num, i3);
    }
}
