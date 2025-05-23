package gg;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.readline.QZoneReadDivideLineItemView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends nf.a<QZoneReadDivideLineItemView> {
    @Override // nf.a
    public Class<QZoneReadDivideLineItemView> a() {
        return QZoneReadDivideLineItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_READ_LINE;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.isFriendFeedReadLineFeed() && businessFeedData.getCellGuiding() != null && businessFeedData.getCellGuiding().cutLineJumpTime > 0;
    }
}
