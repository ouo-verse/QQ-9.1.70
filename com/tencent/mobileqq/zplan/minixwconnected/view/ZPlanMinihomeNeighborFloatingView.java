package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/ZPlanMinihomeNeighborFloatingView;", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMinihomeNeighborFloatingView extends QUSHalfScreenFloatingView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanMinihomeNeighborFloatingView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZPlanMinihomeNeighborFloatingView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public void C(AttributeSet attrs, int defStyleAttr) {
        this.N = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMinihomeNeighborFloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setDraggable(false);
        v(false);
    }
}
