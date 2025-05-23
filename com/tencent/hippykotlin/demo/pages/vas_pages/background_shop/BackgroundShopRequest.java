package com.tencent.hippykotlin.demo.pages.vas_pages.background_shop;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.GoodsItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.ItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.ShopItemRequest;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class BackgroundShopRequest {
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|(1:(1:9)(2:32|33))(2:34|(1:36))|10|11|12|(3:14|(4:17|(4:19|20|21|22)(1:24)|23|15)|25)|27|28))|37|6|(0)(0)|10|11|12|(0)|27|28) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x011b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x011c, code lost:
    
        com.tencent.kuikly.core.log.KLog.INSTANCE.e("BackgroundShopRequest", "exception:" + r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0078 A[Catch: Exception -> 0x011b, TryCatch #0 {Exception -> 0x011b, blocks: (B:12:0x0070, B:14:0x0078, B:15:0x0081, B:17:0x0087, B:20:0x0091), top: B:11:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object firstRequest(BackgroundShopPage backgroundShopPage, Continuation<? super List<? extends ItemData>> continuation) {
        BackgroundShopRequest$firstRequest$1 backgroundShopRequest$firstRequest$1;
        Object coroutine_suspended;
        int i3;
        List list;
        BackgroundShopPage backgroundShopPage2 = backgroundShopPage;
        if (continuation instanceof BackgroundShopRequest$firstRequest$1) {
            backgroundShopRequest$firstRequest$1 = (BackgroundShopRequest$firstRequest$1) continuation;
            int i16 = backgroundShopRequest$firstRequest$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                backgroundShopRequest$firstRequest$1.label = i16 - Integer.MIN_VALUE;
                Object obj = backgroundShopRequest$firstRequest$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = backgroundShopRequest$firstRequest$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ShopItemRequest shopItemRequest = new ShopItemRequest();
                    backgroundShopRequest$firstRequest$1.L$0 = backgroundShopPage2;
                    backgroundShopRequest$firstRequest$1.label = 1;
                    obj = shopItemRequest.firstRequest(backgroundShopPage2, "8", backgroundShopRequest$firstRequest$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    backgroundShopPage2 = backgroundShopRequest$firstRequest$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj2 = obj;
                BackgroundShopPage backgroundShopPage3 = backgroundShopPage2;
                list = (List) obj2;
                e eVar = new e();
                b bVar = new b();
                e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("cname", "\u6700\u65b0\u4e0a\u67b6");
                b bVar2 = new b();
                if (list.size() >= 10) {
                    char c16 = 0;
                    for (ItemData itemData : list.subList(0, 10)) {
                        if (itemData instanceof GoodsItemData) {
                            e eVar2 = new e();
                            GoodsItemData goodsItemData = (GoodsItemData) itemData;
                            ReadWriteProperty readWriteProperty = goodsItemData.title$delegate;
                            KProperty<?>[] kPropertyArr = GoodsItemData.$$delegatedProperties;
                            eVar2.v("name", (String) readWriteProperty.getValue(goodsItemData, kPropertyArr[c16]));
                            GoodsItemData goodsItemData2 = (GoodsItemData) itemData;
                            eVar2.v("image", (String) goodsItemData2.url$delegate.getValue(goodsItemData2, kPropertyArr[2]));
                            GoodsItemData goodsItemData3 = (GoodsItemData) itemData;
                            eVar2.v(VipFunCallConstants.KEY_FEET_TYPE, (String) goodsItemData3.type$delegate.getValue(goodsItemData3, kPropertyArr[1]));
                            GoodsItemData goodsItemData4 = (GoodsItemData) itemData;
                            eVar2.v("itemId", (String) goodsItemData4.itemId$delegate.getValue(goodsItemData4, kPropertyArr[3]));
                            e eVar3 = new e();
                            GoodsItemData goodsItemData5 = (GoodsItemData) itemData;
                            eVar3.v("price", Boxing.boxFloat(((Number) goodsItemData5.price$delegate.getValue(goodsItemData5, kPropertyArr[4])).floatValue() * 100));
                            Unit unit = Unit.INSTANCE;
                            eVar2.v("extrainfo", eVar3);
                            bVar2.t(eVar2);
                            c16 = 0;
                        }
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                m3.v("vitem", bVar2);
                bVar.t(m3);
                eVar.v("modData", bVar);
                backgroundShopPage3.platformApi.getSpModule().a(backgroundShopPage3.getPageName() + "_first_data_title", eVar.toString());
                return obj2;
            }
        }
        backgroundShopRequest$firstRequest$1 = new BackgroundShopRequest$firstRequest$1(this, continuation);
        Object obj3 = backgroundShopRequest$firstRequest$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = backgroundShopRequest$firstRequest$1.label;
        if (i3 != 0) {
        }
        Object obj22 = obj3;
        BackgroundShopPage backgroundShopPage32 = backgroundShopPage2;
        list = (List) obj22;
        e eVar4 = new e();
        b bVar3 = new b();
        e m36 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("cname", "\u6700\u65b0\u4e0a\u67b6");
        b bVar22 = new b();
        if (list.size() >= 10) {
        }
        Unit unit22 = Unit.INSTANCE;
        m36.v("vitem", bVar22);
        bVar3.t(m36);
        eVar4.v("modData", bVar3);
        backgroundShopPage32.platformApi.getSpModule().a(backgroundShopPage32.getPageName() + "_first_data_title", eVar4.toString());
        return obj22;
    }
}
