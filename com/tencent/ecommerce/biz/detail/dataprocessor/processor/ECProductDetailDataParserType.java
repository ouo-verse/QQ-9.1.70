package com.tencent.ecommerce.biz.detail.dataprocessor.processor;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/ECProductDetailDataParserType;", "", "type", "", "(Ljava/lang/String;II)V", "ECProductDetailDataUnknown", "ECProductDetailDataHostGoodsTypeSaas", "ECProductDetailDataHostGoodsTypeHonorKing", "ECProductDetailDataHostGoodsTypeTXVideo", "ECProductDetailDataCustomNormal", "ECProductDetailDataHostRelated", "ECProductDetailDataCustomRelated", "ECProductDetailDataCustomRealtime", "ECProductDetailDataUnavailable", "ECProductDetailDataBizTypeShop", "ECProductDetailDataBizTypeShopChooseSkuInfo", "ECProductDetailDataBizTypeShopRecommend", "ECProductComment", "ECOrderSnapshot", "ECProductDetailDataBizTypeShopDistributor", "ECProductDetailDataBizTypeShopSelect", "ECProductDetailDataBizTypeShopOffSale", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ECProductDetailDataParserType {
    ECProductDetailDataUnknown(0),
    ECProductDetailDataHostGoodsTypeSaas(1),
    ECProductDetailDataHostGoodsTypeHonorKing(2),
    ECProductDetailDataHostGoodsTypeTXVideo(3),
    ECProductDetailDataCustomNormal(10001),
    ECProductDetailDataHostRelated(10002),
    ECProductDetailDataCustomRelated(10003),
    ECProductDetailDataCustomRealtime(10004),
    ECProductDetailDataUnavailable(10005),
    ECProductDetailDataBizTypeShop(10006),
    ECProductDetailDataBizTypeShopChooseSkuInfo(10007),
    ECProductDetailDataBizTypeShopRecommend(10008),
    ECProductComment(10010),
    ECOrderSnapshot(10011),
    ECProductDetailDataBizTypeShopDistributor(10012),
    ECProductDetailDataBizTypeShopSelect(10013),
    ECProductDetailDataBizTypeShopOffSale(10014);

    public final int type;

    ECProductDetailDataParserType(int i3) {
        this.type = i3;
    }
}
