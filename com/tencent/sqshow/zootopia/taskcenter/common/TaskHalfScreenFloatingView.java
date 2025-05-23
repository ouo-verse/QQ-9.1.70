package com.tencent.sqshow.zootopia.taskcenter.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/common/TaskHalfScreenFloatingView;", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class TaskHalfScreenFloatingView extends QUSHalfScreenFloatingView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskHalfScreenFloatingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setDraggable(false);
        v(false);
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        setHeaderView(view);
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        viewGroup.setBackgroundResource(R.drawable.i6k);
        viewGroup.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ViewParent parent2 = viewGroup.getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent2).setBackgroundResource(R.drawable.i6k);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskHalfScreenFloatingView(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskHalfScreenFloatingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
