package com.tencent.ecommerce.biz.commission.forecast;

import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/a;", "Lcom/tencent/ecommerce/biz/commission/forecast/d;", "Lcom/tencent/ecommerce/biz/commission/forecast/c;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "titleTv", UserInfo.SEX_FEMALE, "commissionTv", "G", "timeTv", "H", "orderPriceTv", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends d<CommissionForecastInfo> {

    /* renamed from: E, reason: from kotlin metadata */
    private TextView titleTv;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView commissionTv;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView timeTv;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView orderPriceTv;

    public a(View view) {
        super(view);
    }

    @Override // com.tencent.ecommerce.biz.commission.forecast.d
    public void m() {
        this.titleTv = (TextView) this.itemView.findViewById(R.id.ocm);
        this.commissionTv = (TextView) this.itemView.findViewById(R.id.nzs);
        this.timeTv = (TextView) this.itemView.findViewById(R.id.ocb);
        this.orderPriceTv = (TextView) this.itemView.findViewById(R.id.o68);
    }

    @Override // com.tencent.ecommerce.biz.commission.forecast.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void l(CommissionForecastInfo data) {
        TextView textView = this.titleTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        }
        textView.setText(data.productName);
        TextView textView2 = this.commissionTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionTv");
        }
        com.tencent.ecommerce.biz.util.i iVar = com.tencent.ecommerce.biz.util.i.f104869a;
        textView2.setText(iVar.b(data.forecastAmount));
        TextView textView3 = this.timeTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeTv");
        }
        textView3.setText(data.orderCreateTime);
        TextView textView4 = this.orderPriceTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderPriceTv");
        }
        textView4.setText(this.itemView.getResources().getString(R.string.f169598wi3, iVar.b(data.payAmount)));
    }
}
