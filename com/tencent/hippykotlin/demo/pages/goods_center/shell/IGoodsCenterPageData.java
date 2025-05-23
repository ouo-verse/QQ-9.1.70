package com.tencent.hippykotlin.demo.pages.goods_center.shell;

import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsReq;

/* loaded from: classes31.dex */
public interface IGoodsCenterPageData {
    GoodsCenterSelectProductsReq pageDataFilterParams();

    void refreshData(GoodsCenterSelectProductsReq goodsCenterSelectProductsReq);
}
