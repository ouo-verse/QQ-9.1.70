package com.tencent.hippykotlin.demo.pages.vas_pages.background_shop;

import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.FuncModItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.ItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.TopBannerItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.BannerRequest;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$created$1$1$3", f = "BackgroundShopPage.kt", i = {}, l = {637}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class BackgroundShopPage$created$1$1$3 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ BackgroundShopPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundShopPage$created$1$1$3(BackgroundShopPage backgroundShopPage, Continuation<? super BackgroundShopPage$created$1$1$3> continuation) {
        super(2, continuation);
        this.this$0 = backgroundShopPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BackgroundShopPage$created$1$1$3(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((BackgroundShopPage$created$1$1$3) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            KLog.INSTANCE.i("BackgroundShopPage", "banner data!");
            BannerRequest bannerRequest = new BannerRequest();
            BackgroundShopPage backgroundShopPage = this.this$0;
            this.label = 1;
            obj = bannerRequest.fetchBanners(backgroundShopPage, "8", this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BackgroundShopPage backgroundShopPage2 = this.this$0;
        for (ItemData itemData : (Iterable) obj) {
            if (itemData instanceof FuncModItemData) {
                FuncModItemData funcModItemData = (FuncModItemData) itemData;
                backgroundShopPage2.funcModItemData.setTitle(funcModItemData.getTitle());
                backgroundShopPage2.funcModItemData.setDesc(funcModItemData.getDesc());
                backgroundShopPage2.funcModItemData.setIcon(funcModItemData.getIcon());
                backgroundShopPage2.funcModItemData.setUrl(funcModItemData.getUrl());
                backgroundShopPage2.platformApi.getSpModule().a(backgroundShopPage2.getPageName() + "_func_data_title", funcModItemData.getTitle());
                backgroundShopPage2.platformApi.getSpModule().a(backgroundShopPage2.getPageName() + "_func_data_desc", funcModItemData.getDesc());
                backgroundShopPage2.platformApi.getSpModule().a(backgroundShopPage2.getPageName() + "_func_data_icon", funcModItemData.getIcon());
                backgroundShopPage2.platformApi.getSpModule().a(backgroundShopPage2.getPageName() + "_func_data_url", funcModItemData.getUrl());
            } else if (itemData instanceof TopBannerItemData) {
                backgroundShopPage2.topBannerData.add(itemData);
            }
        }
        KLog.INSTANCE.i("BackgroundShopPage", "banner data! success");
        BackgroundShopPage backgroundShopPage3 = this.this$0;
        backgroundShopPage3.loadTopBannerDataFinished$delegate.setValue(backgroundShopPage3, BackgroundShopPage.$$delegatedProperties[0], Boolean.valueOf(backgroundShopPage3.topBannerData.size() > 0));
        return Unit.INSTANCE;
    }
}
