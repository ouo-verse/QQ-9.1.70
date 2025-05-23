package hf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.ad.QZoneAdCarouselCardFeedItemView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends nf.a<QZoneAdCarouselCardFeedItemView> {
    @Override // nf.a
    public Class<QZoneAdCarouselCardFeedItemView> a() {
        return QZoneAdCarouselCardFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_AD_CAROUSEL_CARD_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        int gdtInnerAdShowType = (businessFeedData == null || !businessFeedData.isGDTAdvFeed()) ? Integer.MIN_VALUE : QZoneAdFeedDataExtKt.getGdtInnerAdShowType(businessFeedData);
        return gdtInnerAdShowType == 46 || gdtInnerAdShowType == 47;
    }
}
