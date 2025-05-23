package com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder;

import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ErrorTipsItemData;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.q;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/viewholder/b;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/q;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/m;", "", "o", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "", "payloads", "r", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "tipsTv", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b extends q<ErrorTipsItemData> {

    /* renamed from: F, reason: from kotlin metadata */
    private TextView tipsTv;

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    public void o() {
        super.o();
        this.tipsTv = (TextView) this.itemView.findViewById(R.id.nyh);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void m(ErrorTipsItemData data) {
        TextView textView = this.tipsTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsTv");
        }
        textView.setText(data.msg);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void n(ErrorTipsItemData data, List<? extends Object> payloads) {
        m(data);
    }

    public b(View view) {
        super(view, null, 2, null);
    }
}
