package fg;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.normal.QZoneMixPicVideoFeedItemView;
import com.tencent.mobileqq.utils.bl;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends nf.a<QZoneMixPicVideoFeedItemView> {
    private boolean d(BusinessFeedData businessFeedData) {
        return businessFeedData.isQQLiveFeed() || businessFeedData.isLiveVideoFeed() || businessFeedData.isRecommendLiveShowContainerFeed() || businessFeedData.isThirdLiveVideoFeed();
    }

    @Override // nf.a
    public Class<QZoneMixPicVideoFeedItemView> a() {
        return QZoneMixPicVideoFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_QQ_LIVE_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return (!d(businessFeedData) || businessFeedData.getPictureInfo() == null || bl.b(businessFeedData.getPictureInfo().pics)) ? false : true;
    }
}
