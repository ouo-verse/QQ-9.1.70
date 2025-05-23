package com.tencent.biz.qqcircle.beans;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleShoppingGoodsInfoBean extends QCircleInitBean {
    private static final String TAG = "QCircleShoppingGoodsInfoBean";
    private static final long serialVersionUID = 1521697368712506013L;
    private int mCurPos;
    private String mDesc;
    private String mId;
    private ArrayList<String> mImageUrls;
    private String mJumpUrl;
    private String mPrice;
    private String mSales;

    public int getCurPos() {
        return this.mCurPos;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public String getId() {
        return this.mId;
    }

    public ArrayList<String> getImageUrls() {
        return this.mImageUrls;
    }

    public String getJumpUrl() {
        return this.mJumpUrl;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public String getSales() {
        return this.mSales;
    }

    public void setCurPos(int i3) {
        this.mCurPos = i3;
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setImageUrls(ArrayList<String> arrayList) {
        this.mImageUrls = arrayList;
    }

    public void setJumpUrl(String str) {
        this.mJumpUrl = str;
    }

    public void setPrice(String str) {
        this.mPrice = str;
    }

    public void setSales(String str) {
        this.mSales = str;
    }

    public String toString() {
        return "QCircleShoppingGoodsInfoBean{mId='" + this.mId + "', mDesc='" + this.mDesc + "', mPrice='" + this.mPrice + "', mSales='" + this.mSales + "', mJumpUrl='" + this.mJumpUrl + "', mImageUrls=" + this.mImageUrls + ", mCurPos=" + this.mCurPos + '}';
    }
}
