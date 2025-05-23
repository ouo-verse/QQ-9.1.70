package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base;

import com.tencent.hippykotlin.demo.pages.base.model.KTVDeviceInfo;
import com.tencent.hippykotlin.demo.pages.base.model.KTVEntry;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponDeviceInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* loaded from: classes33.dex */
public final class SCPUtilsKt {
    public static final ShopCouponDeviceInfo toShopCouponDeviceInfo(KTVDeviceInfo kTVDeviceInfo) {
        ArrayList arrayList = new ArrayList();
        ArrayList<KTVEntry> arrayList2 = kTVDeviceInfo.ext;
        if (arrayList2 != null) {
            for (KTVEntry kTVEntry : arrayList2) {
                arrayList.add(new ShopCouponEntry(kTVEntry.key, kTVEntry.value));
            }
        }
        return new ShopCouponDeviceInfo(kTVDeviceInfo.appVersion, kTVDeviceInfo.f114181os, kTVDeviceInfo.deviceId, kTVDeviceInfo.qimei, kTVDeviceInfo.qimei36, kTVDeviceInfo.network, kTVDeviceInfo.f114180ip, kTVDeviceInfo.terminalId, kTVDeviceInfo.terminalType, kTVDeviceInfo.manufacturer, kTVDeviceInfo.deviceBrandAndModel, arrayList);
    }

    public static final String priceToStr(long j3, boolean z16) {
        List split$default;
        String joinToString$default;
        String take;
        String valueOf = String.valueOf(((float) j3) / 100.0f);
        split$default = StringsKt__StringsKt.split$default((CharSequence) valueOf, new String[]{"."}, false, 0, 6, (Object) null);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(split$default, ",", null, null, 0, null, null, 62, null);
        System.out.println((Object) joinToString$default);
        if (split$default.size() < 2) {
            return valueOf;
        }
        String str = (String) split$default.get(0);
        String str2 = (String) split$default.get(1);
        if (Intrinsics.areEqual(str2, "0")) {
            return str;
        }
        if (z16 && str2.length() < 2) {
            return str + '.' + str2 + '0';
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append('.');
        take = StringsKt___StringsKt.take(str2, 2);
        sb5.append(take);
        return sb5.toString();
    }
}
