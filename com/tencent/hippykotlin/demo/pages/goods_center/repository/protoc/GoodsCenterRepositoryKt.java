package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterRepositoryKt {
    public static final boolean access$isEmpty(GoodsCenterSelectProductsReq goodsCenterSelectProductsReq) {
        if (goodsCenterSelectProductsReq.query.length() == 0) {
            if (goodsCenterSelectProductsReq.orderBy.length() == 0) {
                if ((goodsCenterSelectProductsReq.cookie.length() == 0) && goodsCenterSelectProductsReq.orderByType == 0 && ((int) goodsCenterSelectProductsReq.categoryId) == 0 && goodsCenterSelectProductsReq.cat == null && goodsCenterSelectProductsReq.filter == null && goodsCenterSelectProductsReq.filterCondList == null && goodsCenterSelectProductsReq.rangeCond == null) {
                    return true;
                }
            }
        }
        return false;
    }
}
