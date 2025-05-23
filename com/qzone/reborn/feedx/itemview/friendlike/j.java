package com.qzone.reborn.feedx.itemview.friendlike;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;

/* compiled from: P */
/* loaded from: classes37.dex */
public class j extends nf.a<QZoneCircleFriendLikeItemView> {
    @Override // nf.a
    public Class<QZoneCircleFriendLikeItemView> a() {
        return QZoneCircleFriendLikeItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_QCIRCLE_FRIEND_LIKE;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.isCircleFriendLikeVideoRecomm();
    }
}
