package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes33.dex */
public final class AfterSalesDetailPageAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AfterSalesDetailPageAttr.class, "firstDataRequesting", "getFirstDataRequesting()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AfterSalesDetailPageAttr.class, "showErrorView", "getShowErrorView()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AfterSalesDetailPageAttr.class, VasWebviewConstants.KEY_PAGE_TITLE, "getPageTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AfterSalesDetailPageAttr.class, "operationPrivilege", "getOperationPrivilege()Lcom/tencent/hippykotlin/demo/pages/shop_biz/after_sales_detial_page/OperationPrivilege;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AfterSalesDetailPageAttr.class, "processStatusData", "getProcessStatusData()Lcom/tencent/hippykotlin/demo/pages/shop_biz/after_sales_detial_page/ProcessStatusCard;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AfterSalesDetailPageAttr.class, "logisticsCard", "getLogisticsCard()Lcom/tencent/hippykotlin/demo/pages/shop_biz/after_sales_detial_page/LogisticsCard;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AfterSalesDetailPageAttr.class, "refundProgressCard", "getRefundProgressCard()Lcom/tencent/hippykotlin/demo/pages/shop_biz/after_sales_detial_page/RefundProgressCard;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AfterSalesDetailPageAttr.class, "orderCard", "getOrderCard()Lcom/tencent/hippykotlin/demo/pages/shop_biz/after_sales_detial_page/OrderCard;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AfterSalesDetailPageAttr.class, "refundAmount", "getRefundAmount()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AfterSalesDetailPageAttr.class, "goodsNum", "getGoodsNum()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AfterSalesDetailPageAttr.class, "detailInfoCard", "getDetailInfoCard()Lcom/tencent/hippykotlin/demo/pages/shop_biz/after_sales_detial_page/DetailInfoCard;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AfterSalesDetailPageAttr.class, "bulletin", "getBulletin()Lcom/tencent/hippykotlin/demo/pages/shop_biz/after_sales_detial_page/Bulletin;", 0)};
    public ASDReportModel reportModel;
    public AfterSalesDetailRspModel rspModel;
    public final ReadWriteProperty firstDataRequesting$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty showErrorView$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty pageTitle$delegate = c.a("\u552e\u540e\u8be6\u60c5");
    public final ReadWriteProperty operationPrivilege$delegate = c.a(null);
    public final ReadWriteProperty processStatusData$delegate = c.a(null);
    public final ReadWriteProperty logisticsCard$delegate = c.a(null);
    public final ReadWriteProperty refundProgressCard$delegate = c.a(null);
    public final ReadWriteProperty orderCard$delegate = c.a(new OrderCard());
    public final ReadWriteProperty refundAmount$delegate = c.a(null);
    public final ReadWriteProperty goodsNum$delegate = c.a("");
    public final ReadWriteProperty detailInfoCard$delegate = c.a(null);
    public final ReadWriteProperty bulletin$delegate = c.a(null);

    public final DetailInfoCard getDetailInfoCard() {
        return (DetailInfoCard) this.detailInfoCard$delegate.getValue(this, $$delegatedProperties[10]);
    }

    public final LogisticsCard getLogisticsCard() {
        return (LogisticsCard) this.logisticsCard$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final ProcessStatusCard getProcessStatusData() {
        return (ProcessStatusCard) this.processStatusData$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final RefundProgressCard getRefundProgressCard() {
        return (RefundProgressCard) this.refundProgressCard$delegate.getValue(this, $$delegatedProperties[6]);
    }
}
