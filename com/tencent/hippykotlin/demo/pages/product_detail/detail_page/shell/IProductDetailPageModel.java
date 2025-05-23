package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell;

import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;

/* loaded from: classes31.dex */
public interface IProductDetailPageModel extends IProductDetailPageSubViewModel, IProductDetailPageUIData, IProductDetailPageReport, IProductDetailPageLifeCycle {

    /* loaded from: classes31.dex */
    public static final class DefaultImpls {
        public static float detailViewTopOffset() {
            return c.f117352a.k(BridgeManager.f117344a.u()).getPageData().getNavigationBarHeight();
        }
    }
}
