package com.tencent.ecommerce.biz.orders.realname.widgets;

import android.view.View;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.biz.orders.realname.RealNameAccount;
import com.tencent.ecommerce.biz.orders.realname.widgets.SelectRealNameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
final class SelectRealNameLayout$SelectRealNameAdapter$RealNameViewHolder$bindView$2 implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ SelectRealNameLayout.SelectRealNameAdapter.RealNameViewHolder f103768d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ RealNameAccount f103769e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SelectRealNameLayout$SelectRealNameAdapter$RealNameViewHolder$bindView$2(SelectRealNameLayout.SelectRealNameAdapter.RealNameViewHolder realNameViewHolder, RealNameAccount realNameAccount) {
        this.f103768d = realNameViewHolder;
        this.f103769e = realNameAccount;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        g gVar = new g(this.f103768d.itemView.getContext());
        gVar.Y(this.f103768d.itemView.getContext().getString(R.string.wi9));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.realname.widgets.SelectRealNameLayout$SelectRealNameAdapter$RealNameViewHolder$bindView$2$$special$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                Function1<RealNameAccount, Unit> j06 = SelectRealNameLayout.SelectRealNameAdapter.this.j0();
                if (j06 != null) {
                    j06.invoke(SelectRealNameLayout$SelectRealNameAdapter$RealNameViewHolder$bindView$2.this.f103769e);
                }
            }
        });
        gVar.show();
        EventCollector.getInstance().onViewClicked(view);
    }
}
