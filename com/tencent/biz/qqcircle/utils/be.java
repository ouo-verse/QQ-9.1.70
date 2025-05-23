package com.tencent.biz.qqcircle.utils;

import com.google.gson.annotations.SerializedName;

/* compiled from: P */
/* loaded from: classes5.dex */
public class be {

    @SerializedName("detail_url")
    private String mDetailUrl;

    @SerializedName("goods_type")
    private int mGoodsType;

    @SerializedName("media_product_id")
    private String mMediaProductId;

    public String a() {
        return this.mDetailUrl;
    }

    public int b() {
        return this.mGoodsType;
    }

    public String c() {
        return this.mMediaProductId;
    }

    public String toString() {
        return "QFSEcommerceBean{mMediaProductId='" + this.mMediaProductId + "', mGoodsType='" + this.mGoodsType + "', mDetailUrl='" + this.mDetailUrl + "'}";
    }
}
