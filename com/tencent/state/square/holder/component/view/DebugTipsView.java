package com.tencent.state.square.holder.component.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.Location;
import com.tencent.state.square.data.SquareAvatarItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/holder/component/view/DebugTipsView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hide", "", "setTipsText", "index", "data", "Lcom/tencent/state/square/data/SquareAvatarItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "updateLayout", "id", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DebugTipsView extends AppCompatTextView {
    public DebugTipsView(Context context) {
        this(context, null, 0, 6, null);
    }

    public final void setTipsText(int index, SquareAvatarItem data, float z16) {
        Location location;
        Location location2;
        Location location3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("avatar\nindex: ");
        sb5.append(index);
        sb5.append("\nname: ");
        Integer num = null;
        sb5.append(data != null ? data.getNickName() : null);
        sb5.append("\narea: ");
        sb5.append((data == null || (location3 = data.getLocation()) == null) ? null : Integer.valueOf(location3.getArea()));
        sb5.append("\nrank: ");
        sb5.append((data == null || (location2 = data.getLocation()) == null) ? null : Integer.valueOf(location2.getRank()));
        sb5.append("\ncenterY:");
        if (data != null && (location = data.getLocation()) != null) {
            num = Integer.valueOf(location.getCenterY());
        }
        sb5.append(num);
        sb5.append("\nz:");
        sb5.append(z16);
        setText(sb5.toString());
    }

    public final void updateLayout(final int id5) {
        ViewExtensionsKt.updateLayoutParams(this, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.holder.component.view.DebugTipsView$updateLayout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RelativeLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = -2;
                receiver.height = -2;
                receiver.addRule(8, id5);
                receiver.addRule(19, id5);
                receiver.addRule(18, id5);
                receiver.addRule(6, id5);
                DebugTipsView.this.setBackgroundColor(Color.parseColor("#5500FF00"));
                DebugTipsView.this.setTextSize(com.tencent.state.square.common.ViewExtensionsKt.calPx(r3.getContext(), 17));
                DebugTipsView.this.setGravity(17);
            }
        });
    }

    public DebugTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DebugTipsView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void hide() {
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugTipsView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
