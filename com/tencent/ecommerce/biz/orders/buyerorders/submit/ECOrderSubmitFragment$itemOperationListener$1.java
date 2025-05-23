package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import android.net.Uri;
import com.huawei.hms.common.AccountPicker;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.base.list.ListViewModel;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.ui.SlidingUpDialog;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.CalculatePriceScene;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import com.tencent.ecommerce.biz.orders.realname.RealNameAccount;
import com.tencent.ecommerce.biz.orders.realname.RealNameAccountsReqInfo;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import common.config.service.QzoneConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001a\u0010\u0018\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016\u00a8\u0006\u001a"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitFragment$itemOperationListener$1", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "payType", "", "onPayTypeSwitch", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "onAddressClick", "", "skuId", "", "quantity", "onChangedOrderGoodsQuantity", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "note", "onChangedOrderNote", "accountValue", "onChangeAccountValue", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "account", "onChangeRealAccountValue", AccountPicker.EXTRA_SELECTED_ACCOUNT, "triggerFrom", "onSelectRealAccount", "onCouponClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSubmitFragment$itemOperationListener$1 implements OrderSubmitListItemOperationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ECOrderSubmitFragment f103482a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECOrderSubmitFragment$itemOperationListener$1(ECOrderSubmitFragment eCOrderSubmitFragment) {
        this.f103482a = eCOrderSubmitFragment;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.OrderSubmitListItemOperationListener
    public void onChangeAccountValue(String accountValue) {
        this.f103482a.Li().f3(accountValue);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.OrderSubmitListItemOperationListener
    public void onChangeRealAccountValue(RealNameAccount account) {
        this.f103482a.Li().e3(account);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.OrderSubmitListItemOperationListener
    public void onChangedOrderGoodsQuantity(String skuId, int quantity) {
        ECOrderSubmitViewModel.n2(this.f103482a.Li(), skuId, quantity, CalculatePriceScene.CHANGE_GOODS_AMOUNT, false, null, 24, null);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.OrderSubmitListItemOperationListener
    public void onChangedOrderNote(String orderId, String note) {
        this.f103482a.Li().c3(note);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.OrderSubmitListItemOperationListener
    public void onCouponClick() {
        Uri.Builder appendQueryParameter = Uri.parse("mqqapi://ecommerce/open").buildUpon().appendQueryParameter("target", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE).appendQueryParameter("page_name", "select_coupon_page").appendQueryParameter(KuiklyLaunchParams.PARAM_MODAL_MODE, "1");
        if (!this.f103482a.Pi()) {
            appendQueryParameter.appendQueryParameter(LayoutAttrDefine.MARGIN_TOP, String.valueOf(this.f103482a.getCom.tencent.mtt.hippy.dom.node.NodeProps.MARGIN_TOP java.lang.String()));
        }
        ECScheme.g(appendQueryParameter.build().toString(), null, 2, null);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.OrderSubmitListItemOperationListener
    public void onPayTypeSwitch(PayType payType) {
        this.f103482a.Li().d3(payType);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.OrderSubmitListItemOperationListener
    public void onSelectRealAccount(RealNameAccount selectedAccount, int triggerFrom) {
        SlidingUpDialog Ei;
        ListViewModel Ii;
        Map emptyMap;
        if (!this.f103482a.Li().z2() && selectedAccount == null) {
            this.f103482a.Xi(triggerFrom);
            return;
        }
        ECOrderSubmitFragment eCOrderSubmitFragment = this.f103482a;
        Ei = eCOrderSubmitFragment.Ei();
        Ei.show();
        Unit unit = Unit.INSTANCE;
        eCOrderSubmitFragment.selectRealNameDialog = Ei;
        Ii = this.f103482a.Ii();
        Ii.X1(new RealNameAccountsReqInfo(null, 1, null));
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        emptyMap = MapsKt__MapsKt.emptyMap();
        IECDataReport.a.a(bVar, "qstore_order_submit_checked_id_list_expo", emptyMap, false, 4, null);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.OrderSubmitListItemOperationListener
    public void onAddressClick(ECAddress address) {
        if (address == null) {
            com.tencent.ecommerce.biz.orders.address.c.e(2, null, new Function1<ECAddress, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$itemOperationListener$1$onAddressClick$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECAddress eCAddress) {
                    invoke2(eCAddress);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECAddress eCAddress) {
                    ECOrderSubmitFragment$itemOperationListener$1.this.f103482a.Li().o2(eCAddress);
                }
            });
        } else {
            com.tencent.ecommerce.biz.orders.address.c.b(this.f103482a.requireActivity(), address.id, false, new Function1<ECAddress, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$itemOperationListener$1$onAddressClick$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECAddress eCAddress) {
                    invoke2(eCAddress);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECAddress eCAddress) {
                    ECOrderSubmitFragment$itemOperationListener$1.this.f103482a.Li().o2(eCAddress);
                }
            }, 4, null);
        }
        this.f103482a.Si(address);
    }
}
