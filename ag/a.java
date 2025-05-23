package ag;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneEmptyItemView;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends nf.a<QZoneEmptyItemView> {
    @Override // nf.a
    public Class<QZoneEmptyItemView> a() {
        return QZoneEmptyItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_NEW_GUIDE;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.isNewGuideFeed();
    }
}
