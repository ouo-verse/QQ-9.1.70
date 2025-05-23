package gg;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneEmptyItemView;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends nf.a<QZoneEmptyItemView> {
    private boolean d(BusinessFeedData businessFeedData) {
        return businessFeedData.getCellGuiding() == null || businessFeedData.getCellGuiding().cutLineJumpTime <= 0;
    }

    @Override // nf.a
    public Class<QZoneEmptyItemView> a() {
        return QZoneEmptyItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_READ_LINE_LOAD_MORE_UP;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.isFriendFeedReadLineFeed() && d(businessFeedData);
    }
}
