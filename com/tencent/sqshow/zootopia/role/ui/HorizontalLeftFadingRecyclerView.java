package com.tencent.sqshow.zootopia.role.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.sqshow.zootopia.widget.ZootopiaRecycleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/ui/HorizontalLeftFadingRecyclerView;", "Lcom/tencent/sqshow/zootopia/widget/ZootopiaRecycleView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getRightFadingEdgeStrength", "", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class HorizontalLeftFadingRecyclerView extends ZootopiaRecycleView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalLeftFadingRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        return 0.0f;
    }
}
