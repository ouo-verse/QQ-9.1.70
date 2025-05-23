package com.tencent.ecommerce.biz.commission.forecast;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/g;", "Lcom/tencent/ecommerce/biz/commission/forecast/d;", "Lcom/tencent/ecommerce/biz/commission/forecast/f;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "emptyTipsTv", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class g extends d<f> {

    /* renamed from: E, reason: from kotlin metadata */
    private TextView emptyTipsTv;

    public g(View view) {
        super(view);
    }

    @Override // com.tencent.ecommerce.biz.commission.forecast.d
    public void m() {
        super.m();
        this.emptyTipsTv = (TextView) this.itemView.findViewById(R.id.ny6);
    }

    @Override // com.tencent.ecommerce.biz.commission.forecast.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void l(f data) {
        TextView textView = this.emptyTipsTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyTipsTv");
        }
        textView.setText(this.itemView.getResources().getString(R.string.whr));
    }
}
