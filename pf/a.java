package pf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.forwardblog.QZoneForwardBlogItemView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends nf.a<QZoneForwardBlogItemView> {
    @Override // nf.a
    public Class<QZoneForwardBlogItemView> a() {
        return QZoneForwardBlogItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_FORWARD_BLOG;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return (!businessFeedData.isForwardBlogFeed() || businessFeedData.getOriginalInfo() == null || businessFeedData.getOriginalInfo().isNewHandBlogFeed()) ? false : true;
    }
}
