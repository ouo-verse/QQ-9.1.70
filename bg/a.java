package bg;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.normal.QZoneDefaultTextFeedItemView;
import com.qzone.reborn.feedx.util.n;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends nf.a<QZoneDefaultTextFeedItemView> {
    @Override // nf.a
    public Class<QZoneDefaultTextFeedItemView> a() {
        return QZoneDefaultTextFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_TEXT_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return (businessFeedData.isAdFeeds() || TextUtils.isEmpty(n.e(businessFeedData))) ? false : true;
    }
}
