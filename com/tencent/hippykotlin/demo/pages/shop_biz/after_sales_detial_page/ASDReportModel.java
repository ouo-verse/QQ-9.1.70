package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDReportModel {
    public String pagerID;
    public AfterSalesDetailRspModel rspModel;

    public ASDReportModel(String str, AfterSalesDetailRspModel afterSalesDetailRspModel) {
        this.pagerID = str;
        this.rspModel = afterSalesDetailRspModel;
    }

    public final void reportBottomButtonClick$enumunboxing$(int i3) {
        e eVar = new e();
        eVar.t("button_type", ASDButtonType$EnumUnboxingLocalUtility.getValue(i3));
        reportDT("qstore_after_sales_detail_bottom_button_clk", eVar);
    }

    public final void reportDT(String str, e eVar) {
        e eVar2;
        OrderCard orderCard;
        ShopInfo shopInfo;
        e eVar3 = new e();
        c cVar = c.f117352a;
        String p16 = cVar.k(this.pagerID).getPageData().n().p(WadlProxyConsts.CHANNEL);
        String p17 = cVar.k(this.pagerID).getPageData().n().p("order_id");
        eVar3.v("bus_id", p16);
        eVar3.v("order_id", p17);
        AfterSalesDetailPageData afterSalesDetailPageData = this.rspModel.detailPage;
        if (afterSalesDetailPageData != null && (orderCard = afterSalesDetailPageData.orderCard) != null && (shopInfo = orderCard.shopInfo) != null) {
            eVar3.v("shop_id", shopInfo.shopId);
            eVar3.v("shop_id", shopInfo.shopId);
        }
        AfterSalesDetailPageData afterSalesDetailPageData2 = this.rspModel.detailPage;
        if (afterSalesDetailPageData2 != null && (eVar2 = afterSalesDetailPageData2.reportExt) != null) {
            Iterator<String> c16 = eVar2.c();
            while (c16.hasNext()) {
                String next = c16.next();
                eVar3.v(next, eVar2.p(next));
            }
        }
        Iterator<String> c17 = eVar.c();
        while (c17.hasNext()) {
            String next2 = c17.next();
            eVar3.v(next2, eVar.p(next2));
        }
        Utils.INSTANCE.bridgeModule(this.pagerID).reportDT(str, eVar3);
    }
}
