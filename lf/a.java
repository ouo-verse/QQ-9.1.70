package lf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.appshare.QZoneAppShareFeedItemView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends nf.a<QZoneAppShareFeedItemView> {
    @Override // nf.a
    public Class<QZoneAppShareFeedItemView> a() {
        return QZoneAppShareFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_APP_SHARE_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.isAppShareCardFeed();
    }
}
