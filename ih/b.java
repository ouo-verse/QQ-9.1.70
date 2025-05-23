package ih;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b {
    public static void b(BusinessFeedData businessFeedData, GdtAd gdtAd, int i3, int i16) {
        if (businessFeedData == null) {
            QLog.e("QZoneAdFeedxCarouselCardPreloader", 2, "[preload] error");
            return;
        }
        int gdtInnerAdShowType = QZoneAdFeedDataExtKt.getGdtInnerAdShowType(businessFeedData);
        if (gdtInnerAdShowType != 46 && gdtInnerAdShowType != 47) {
            QLog.e("QZoneAdFeedxCarouselCardPreloader", 1, "[preload] error, not carousel card, innerAdShowType:" + gdtInnerAdShowType);
            return;
        }
        GdtAdFeedUtil.parseCarouselCardInfo(businessFeedData, gdtAd);
        List<GdtAdFeedUtil.CarouselCardInfo> carouselCardInfoList = businessFeedData.getAdData().getCarouselCardInfoList();
        if (carouselCardInfoList != null && !carouselCardInfoList.isEmpty()) {
            Set<Integer> a16 = a(i3, i16, carouselCardInfoList.size());
            if (a16 != null && !a16.isEmpty()) {
                QLog.i("QZoneAdFeedxCarouselCardPreloader", 2, "[preload] aid:" + (gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) + " centerIndex:" + i3 + " excludeIndex:" + i16 + " indexSet:" + a16);
                for (Integer num : a16) {
                    if (num == null) {
                        QLog.e("QZoneAdFeedxCarouselCardPreloader", 1, "[preload] error, index is null");
                    } else {
                        GdtAdFeedUtil.CarouselCardInfo carouselCardInfo = carouselCardInfoList.get(num.intValue());
                        if (carouselCardInfo == null) {
                            QLog.e("QZoneAdFeedxCarouselCardPreloader", 1, "[preload] error, info is null");
                        } else if (gdtInnerAdShowType != 46 && gdtInnerAdShowType != 47) {
                            QLog.e("QZoneAdFeedxCarouselCardPreloader", 1, "[preload] error, not carousel card, innerAdShowType:" + gdtInnerAdShowType);
                        } else {
                            ng.b a17 = ng.b.a();
                            c.a(carouselCardInfo.imageUrl, a17.f420123e, a17.f420124f, null);
                        }
                    }
                }
                return;
            }
            QLog.e("QZoneAdFeedxCarouselCardPreloader", 2, "[preload] error, indexSet is null");
            return;
        }
        QLog.e("QZoneAdFeedxCarouselCardPreloader", 2, "[preload] error");
    }

    private static Set<Integer> a(int i3, int i16, int i17) {
        if (i17 <= 0 || i3 < 0 || i3 >= i17) {
            return null;
        }
        int i18 = i3 - 1;
        if (i18 < 0) {
            i18 = i17 - 1;
        }
        int i19 = i3 + 1;
        if (i19 >= i17) {
            i19 = 0;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(i18));
        hashSet.add(Integer.valueOf(i3));
        hashSet.add(Integer.valueOf(i19));
        hashSet.remove(Integer.valueOf(i16));
        return hashSet;
    }
}
