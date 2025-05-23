package eg;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.qcircleshare.QZoneQCircleShareFeedItemView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends nf.a<QZoneQCircleShareFeedItemView> {
    @Override // nf.a
    public Class<QZoneQCircleShareFeedItemView> a() {
        return QZoneQCircleShareFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_QCIRCLE_SHARE_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.isQCircleShareCardFeed();
    }
}
