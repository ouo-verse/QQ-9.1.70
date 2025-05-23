package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.huawei.hms.common.AccountPicker;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import com.tencent.ecommerce.biz.orders.realname.RealNameAccount;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH&J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H&J\u001a\u0010\u0018\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u000bH&J\b\u0010\u0019\u001a\u00020\u0004H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "payType", "", "onPayTypeSwitch", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "onAddressClick", "", "skuId", "", "quantity", "onChangedOrderGoodsQuantity", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "note", "onChangedOrderNote", "accountValue", "onChangeAccountValue", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "account", "onChangeRealAccountValue", AccountPicker.EXTRA_SELECTED_ACCOUNT, "triggerFrom", "onSelectRealAccount", "onCouponClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface OrderSubmitListItemOperationListener {
    void onAddressClick(ECAddress address);

    void onChangeAccountValue(String accountValue);

    void onChangeRealAccountValue(RealNameAccount account);

    void onChangedOrderGoodsQuantity(String skuId, int quantity);

    void onChangedOrderNote(String orderId, String note);

    void onCouponClick();

    void onPayTypeSwitch(PayType payType);

    void onSelectRealAccount(RealNameAccount selectedAccount, int triggerFrom);
}
