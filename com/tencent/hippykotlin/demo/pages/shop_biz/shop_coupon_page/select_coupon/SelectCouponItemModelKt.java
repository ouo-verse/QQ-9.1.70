package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon;

import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemModel;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponBasicInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponOrderInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowStyleInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponIssuer;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponShowDiscount;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class SelectCouponItemModelKt {
    public static final List<SelectCouponItemModel> toCouponItemList(ShopCouponCouponInfo shopCouponCouponInfo) {
        int collectionSizeOrDefault;
        List plus;
        List<SelectCouponItemModel> plus2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo;
        String str7;
        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo2;
        String str8;
        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo3;
        ShopCouponCouponBasicInfo shopCouponCouponBasicInfo;
        ShopCouponIssuer shopCouponIssuer;
        ShopCouponCouponBasicInfo shopCouponCouponBasicInfo2;
        ShopCouponIssuer shopCouponIssuer2;
        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo4;
        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo5;
        ShopCouponShowDiscount shopCouponShowDiscount;
        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo6;
        ShopCouponShowDiscount shopCouponShowDiscount2;
        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo7;
        List<SelectCouponItemModel> emptyList;
        ArrayList<ShopCouponCouponOrderInfo> arrayList = shopCouponCouponInfo.couponOrderInfo;
        if (arrayList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (Iterator it = arrayList.iterator(); it.hasNext(); it = it) {
            ShopCouponCouponOrderInfo shopCouponCouponOrderInfo = (ShopCouponCouponOrderInfo) it.next();
            String str9 = shopCouponCouponOrderInfo.couponId;
            ShopCouponCouponShowInfo shopCouponCouponShowInfo = shopCouponCouponOrderInfo.couponShowInfo;
            if (shopCouponCouponShowInfo == null || (shopCouponCouponShowStyleInfo7 = shopCouponCouponShowInfo.couponListStyle) == null || (str = shopCouponCouponShowStyleInfo7.couponTypeName) == null) {
                str = "";
            }
            if (shopCouponCouponShowInfo == null || (shopCouponCouponShowStyleInfo6 = shopCouponCouponShowInfo.couponListStyle) == null || (shopCouponShowDiscount2 = shopCouponCouponShowStyleInfo6.couponShowDiscount) == null || (str2 = shopCouponShowDiscount2.discountAmount) == null) {
                str2 = "";
            }
            if (shopCouponCouponShowInfo == null || (shopCouponCouponShowStyleInfo5 = shopCouponCouponShowInfo.couponListStyle) == null || (shopCouponShowDiscount = shopCouponCouponShowStyleInfo5.couponShowDiscount) == null || (str3 = shopCouponShowDiscount.discountThreshold) == null) {
                str3 = "";
            }
            if (shopCouponCouponShowInfo == null || (shopCouponCouponShowStyleInfo4 = shopCouponCouponShowInfo.couponListStyle) == null || (str4 = shopCouponCouponShowStyleInfo4.couponIssuerName) == null) {
                str4 = "";
            }
            if (shopCouponCouponShowInfo == null || (shopCouponCouponBasicInfo2 = shopCouponCouponShowInfo.basicInfo) == null || (shopCouponIssuer2 = shopCouponCouponBasicInfo2.issuer) == null || (str5 = shopCouponIssuer2.f114304id) == null) {
                str5 = "";
            }
            int i3 = (shopCouponCouponShowInfo == null || (shopCouponCouponBasicInfo = shopCouponCouponShowInfo.basicInfo) == null || (shopCouponIssuer = shopCouponCouponBasicInfo.issuer) == null) ? -1 : shopCouponIssuer.type;
            if (shopCouponCouponShowInfo == null || (shopCouponCouponShowStyleInfo3 = shopCouponCouponShowInfo.couponListStyle) == null || (str6 = shopCouponCouponShowStyleInfo3.couponUsableRange) == null) {
                str6 = "";
            }
            arrayList2.add(new CouponItem(new CommonCouponItemModel(str9, str, str2, str3, str4, str5, i3, str6, (shopCouponCouponShowInfo == null || (shopCouponCouponShowStyleInfo = shopCouponCouponShowInfo.couponListStyle) == null || (str7 = shopCouponCouponShowStyleInfo.couponTimeScope) == null) ? "" : str7, shopCouponCouponOrderInfo.canUse, (shopCouponCouponShowInfo == null || (shopCouponCouponShowStyleInfo2 = shopCouponCouponShowInfo.couponListStyle) == null || (str8 = shopCouponCouponShowStyleInfo2.couponUseRule) == null) ? "" : str8), shopCouponCouponOrderInfo.isUserSelect, shopCouponCouponOrderInfo.isInBestOptions));
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            Object next = it5.next();
            if (((CouponItem) next).commonCouponItem.isEnabled) {
                arrayList3.add(next);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            Object next2 = it6.next();
            if (!((CouponItem) next2).commonCouponItem.isEnabled) {
                arrayList4.add(next2);
            }
        }
        if (arrayList4.isEmpty()) {
            return arrayList3;
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection<? extends TitleItem>) ((Collection<? extends Object>) arrayList3), new TitleItem());
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) arrayList4);
        return plus2;
    }
}
