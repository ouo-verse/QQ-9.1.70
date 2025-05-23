package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_goods;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellGoods implements SmartParcelable {

    @NeedParcel
    public int btnActionType;

    @NeedParcel
    public int btnColor;

    @NeedParcel
    public String btnTitle;

    @NeedParcel
    public String btnUrl;

    @NeedParcel
    public int buyCount;

    @NeedParcel
    public int canChange;

    @NeedParcel
    public String disPrice;

    @NeedParcel
    public String goodId;

    @NeedParcel
    public String goodsDesc;

    @NeedParcel
    public String goodsName;

    @NeedParcel
    public int goodsType;
    public int iBuyCount;

    @NeedParcel
    public int layoutType;

    @NeedParcel
    public String leftPriceDesc;

    @NeedParcel
    public int openMonth;

    @NeedParcel
    public String payOfferId;

    @NeedParcel
    public String payRemark;

    /* renamed from: pf, reason: collision with root package name */
    @NeedParcel
    public String f50230pf;

    @NeedParcel
    public String pfkey;

    @NeedParcel
    public String price;

    @NeedParcel
    public String rightPriceDesc;

    @NeedParcel
    public String underPriceDesc;

    @NeedParcel
    public String upperPriceDesc;

    @NeedParcel
    public String zoneid = "";
    public String strItemId = "";

    public int getVipType() {
        return this.goodsType;
    }

    public boolean isVipType() {
        int i3 = this.goodsType;
        return i3 == 1 || i3 == 2;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellGoods {\n");
        sb5.append("goodsType: ");
        sb5.append(this.goodsType);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.goodsDesc)) {
            sb5.append("goodsDesc: ");
            sb5.append(this.goodsDesc);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.price)) {
            sb5.append("price: ");
            sb5.append(this.price);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.disPrice)) {
            sb5.append("disPrice: ");
            sb5.append(this.disPrice);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.btnTitle)) {
            sb5.append("btnTitle: ");
            sb5.append(this.btnTitle);
            sb5.append("\n");
        }
        sb5.append("btnColor: ");
        sb5.append(this.btnColor);
        sb5.append("\n");
        sb5.append("btnActionType: ");
        sb5.append(this.btnActionType);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.btnUrl)) {
            sb5.append("btnUrl: ");
            sb5.append(this.btnUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.upperPriceDesc)) {
            sb5.append("upperPriceDesc: ");
            sb5.append(this.upperPriceDesc);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.underPriceDesc)) {
            sb5.append("underPriceDesc: ");
            sb5.append(this.underPriceDesc);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.leftPriceDesc)) {
            sb5.append("leftPriceDesc: ");
            sb5.append(this.leftPriceDesc);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.rightPriceDesc)) {
            sb5.append("rightPriceDesc: ");
            sb5.append(this.rightPriceDesc);
            sb5.append("\n");
        }
        sb5.append("}");
        return sb5.toString();
    }

    public static CellGoods create(l lVar) {
        if (lVar == null || lVar.E == null) {
            return null;
        }
        CellGoods cellGoods = new CellGoods();
        cell_goods cell_goodsVar = lVar.E;
        cellGoods.goodsType = cell_goodsVar.goods_type;
        cellGoods.goodsDesc = cell_goodsVar.goods_desc;
        cellGoods.price = cell_goodsVar.price;
        cellGoods.disPrice = cell_goodsVar.dis_price;
        cellGoods.btnTitle = cell_goodsVar.btn_title;
        cellGoods.btnColor = cell_goodsVar.btn_color;
        cellGoods.btnActionType = cell_goodsVar.btn_actiontype;
        cellGoods.btnUrl = cell_goodsVar.btn_url;
        cellGoods.upperPriceDesc = cell_goodsVar.upper_price_desc;
        cellGoods.underPriceDesc = cell_goodsVar.under_price_desc;
        cellGoods.leftPriceDesc = cell_goodsVar.left_price_desc;
        cellGoods.rightPriceDesc = cell_goodsVar.right_price_desc;
        cellGoods.payRemark = cell_goodsVar.payremark;
        cellGoods.payOfferId = cell_goodsVar.payofferid;
        cellGoods.openMonth = cell_goodsVar.iOpenMonth;
        cellGoods.canChange = cell_goodsVar.isCanChange;
        cellGoods.f50230pf = cell_goodsVar.f24984pf;
        cellGoods.pfkey = cell_goodsVar.pfkey;
        cellGoods.zoneid = cell_goodsVar.zoneid;
        String str = cell_goodsVar.strItemId;
        cellGoods.strItemId = str;
        int i3 = cell_goodsVar.iBuyCount;
        cellGoods.iBuyCount = i3;
        cellGoods.goodId = str;
        cellGoods.buyCount = i3;
        cellGoods.goodsName = cell_goodsVar.goods_name;
        cellGoods.layoutType = cell_goodsVar.layout_type;
        return cellGoods;
    }
}
