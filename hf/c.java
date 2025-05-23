package hf;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.ad.QZoneAdPictureFeedItemView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends nf.a<QZoneAdPictureFeedItemView> {
    @Override // nf.a
    public Class<QZoneAdPictureFeedItemView> a() {
        return QZoneAdPictureFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_AD_PICTURE_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        int gdtInnerAdShowType = businessFeedData.isGDTAdvFeed() ? QZoneAdFeedDataExtKt.getGdtInnerAdShowType(businessFeedData) : Integer.MIN_VALUE;
        return (gdtInnerAdShowType == 1 || gdtInnerAdShowType == 2) && businessFeedData.isAdFeeds() && !TextUtils.isEmpty(QZoneAdFeedDataExtKt.getAdPictureUrl(businessFeedData)) && !QZoneAdFeedDataExtKt.isMDPAStyleB(businessFeedData);
    }
}
