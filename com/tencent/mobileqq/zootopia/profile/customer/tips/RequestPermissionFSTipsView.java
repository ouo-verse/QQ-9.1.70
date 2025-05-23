package com.tencent.mobileqq.zootopia.profile.customer.tips;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.gf.d0;
import com.tencent.sqshow.zootopia.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\n\u0010\u000eB#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\n\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/profile/customer/tips/RequestPermissionFSTipsView;", "Lcom/tencent/mobileqq/zootopia/profile/customer/tips/RequestPermissionTipsView;", "Landroid/view/View;", "c", "Landroid/widget/FrameLayout$LayoutParams;", "d", "", "b", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class RequestPermissionFSTipsView extends RequestPermissionTipsView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestPermissionFSTipsView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.zootopia.profile.customer.tips.BaseTipsView
    public boolean b() {
        return false;
    }

    @Override // com.tencent.mobileqq.zootopia.profile.customer.tips.BaseTipsView
    public FrameLayout.LayoutParams d() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        return layoutParams;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestPermissionFSTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.zootopia.profile.customer.tips.RequestPermissionTipsView, com.tencent.mobileqq.zootopia.profile.customer.tips.BaseTipsView
    public View c() {
        setBackgroundColor(-1);
        View c16 = super.c();
        z().setVisibility(4);
        t().setVisibility(8);
        ViewGroup.LayoutParams layoutParams = u().getLayoutParams();
        if (layoutParams == null) {
            new LinearLayout.LayoutParams(i.b(d0.CTRL_INDEX), i.b(45));
        } else {
            layoutParams.width = i.b(d0.CTRL_INDEX);
            layoutParams.height = i.b(45);
        }
        return c16;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestPermissionFSTipsView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
