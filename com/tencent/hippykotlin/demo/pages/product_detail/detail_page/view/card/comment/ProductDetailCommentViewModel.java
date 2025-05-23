package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public abstract class ProductDetailCommentViewModel implements IProductDetailCardViewModel, IProductDetailShopCommentViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailCommentViewModel.class, "canJumpToList", "getCanJumpToList()Z", 0)};
    public final ReadWriteProperty canJumpToList$delegate = c.a(Boolean.FALSE);

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.IProductDetailShopCommentViewModel
    public String cardFrameChangeEventName() {
        return null;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public boolean isShowCard() {
        return true;
    }
}
