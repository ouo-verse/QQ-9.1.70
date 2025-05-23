package of;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.forward.QZoneForwardFeedItemView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends nf.a<QZoneForwardFeedItemView> {
    @Override // nf.a
    public Class<QZoneForwardFeedItemView> a() {
        return QZoneForwardFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_FORWARD_TEXT_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return com.qzone.reborn.feedx.itemview.d.d(businessFeedData) && com.qzone.reborn.feedx.itemview.d.b(businessFeedData.getOriginalInfo()) == 0;
    }
}
