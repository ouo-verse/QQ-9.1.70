package ih;

import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d {
    public static void a(BusinessFeedData businessFeedData, int i3) {
        GdtAd gdtAd = new GdtAd(GdtFeedUtilForQZone.f(businessFeedData));
        GdtPreLoader.c().h(gdtAd);
        if (i3 == 0) {
            b(businessFeedData, gdtAd);
        }
    }

    private static void b(BusinessFeedData businessFeedData, GdtAd gdtAd) {
        int intValue = (businessFeedData != null ? Integer.valueOf(QZoneAdFeedDataExtKt.getGdtInnerAdShowType(businessFeedData)) : null).intValue();
        if (intValue == 46 || intValue == 47) {
            b.b(businessFeedData, gdtAd, 0, Integer.MIN_VALUE);
        }
    }
}
