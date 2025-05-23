package jg;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.timeline.QZoneUserHomeTimeLineEmptyView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends nf.a<QZoneUserHomeTimeLineEmptyView> {
    @Override // nf.a
    public Class<QZoneUserHomeTimeLineEmptyView> a() {
        return QZoneUserHomeTimeLineEmptyView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_TIMELINE_EMPTY;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.isTimelineEmptyFeed();
    }
}
