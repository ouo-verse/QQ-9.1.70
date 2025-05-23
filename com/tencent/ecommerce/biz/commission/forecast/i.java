package com.tencent.ecommerce.biz.commission.forecast;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/i;", "Lcom/tencent/ecommerce/biz/commission/forecast/d;", "Lcom/tencent/ecommerce/biz/commission/forecast/h;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", "o", "Lcom/tencent/ecommerce/biz/commission/forecast/ItemOperationListener;", "E", "Lcom/tencent/ecommerce/biz/commission/forecast/ItemOperationListener;", "itemOperationListener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/commission/forecast/ItemOperationListener;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class i extends d<h> {

    /* renamed from: E, reason: from kotlin metadata */
    private final ItemOperationListener itemOperationListener;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            i.this.itemOperationListener.onRetryBtnClick(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public i(View view, ItemOperationListener itemOperationListener) {
        super(view);
        this.itemOperationListener = itemOperationListener;
    }

    @Override // com.tencent.ecommerce.biz.commission.forecast.d
    public void m() {
        this.itemView.findViewById(R.id.f163072o52).setOnClickListener(new a());
    }

    @Override // com.tencent.ecommerce.biz.commission.forecast.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(h data) {
    }
}
