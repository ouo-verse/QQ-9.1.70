package hf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.ad.QZoneAdVideoFeedItemView;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends nf.a<QZoneAdVideoFeedItemView> {
    @Override // nf.a
    public Class<QZoneAdVideoFeedItemView> a() {
        return QZoneAdVideoFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_AD_VIDEO_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return QZoneAdFeedUtils.f55717a.T((businessFeedData == null || !businessFeedData.isGDTAdvFeed()) ? Integer.MIN_VALUE : QZoneAdFeedDataExtKt.getGdtInnerAdShowType(businessFeedData));
    }
}
