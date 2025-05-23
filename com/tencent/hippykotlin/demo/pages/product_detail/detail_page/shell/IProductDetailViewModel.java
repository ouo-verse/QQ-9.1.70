package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell;

import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.FooterRefreshState;

/* loaded from: classes31.dex */
public interface IProductDetailViewModel {
    boolean canShare();

    c<IProductDetailCardViewModel> detailCardsViewModel();

    void doShare();

    float getHeight();

    float halfMarginTopHeight();

    void loadMore();

    boolean needShowFooter();

    FooterRefreshState refreshState();

    void setRefreshState(FooterRefreshState footerRefreshState);
}
