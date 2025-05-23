package dg;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.pymk.QZonePYMKFeedItemView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends nf.a<QZonePYMKFeedItemView> {
    @Override // nf.a
    public Class<QZonePYMKFeedItemView> a() {
        return QZonePYMKFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_PYMK_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.isPYMKFeed();
    }
}
