package kg;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneEmptyItemView;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends nf.a<QZoneEmptyItemView> {
    @Override // nf.a
    public Class<QZoneEmptyItemView> a() {
        return QZoneEmptyItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_THAT_YEAR_TODAY_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.feedType == 8;
    }
}
