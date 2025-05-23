package ig;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.reprintedblog.QZoneReprintedTextBlogItemView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends nf.a<QZoneReprintedTextBlogItemView> {
    @Override // nf.a
    public Class<QZoneReprintedTextBlogItemView> a() {
        return QZoneReprintedTextBlogItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_REPRINTED_TEXT_BLOG_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || !businessFeedData.isReprintedTextBlogFeed() || businessFeedData.isNewHandBlogFeed() || businessFeedData.getOriginalInfo() == null || businessFeedData.getOriginalInfo().getPictureInfo() != null) ? false : true;
    }
}
