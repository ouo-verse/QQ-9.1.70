package mf;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.blog.QZoneFeedBlogItemView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends nf.a<QZoneFeedBlogItemView> {
    @Override // nf.a
    public Class<QZoneFeedBlogItemView> a() {
        return QZoneFeedBlogItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_BLOG;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.isBlogFeed() && !businessFeedData.isNewHandBlogFeed();
    }
}
