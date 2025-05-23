package hg;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.reedit.QZoneReeditItemView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends nf.a<QZoneReeditItemView> {
    @Override // nf.a
    public Class<QZoneReeditItemView> a() {
        return QZoneReeditItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_REEDIT;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.isReeditFeed();
    }
}
