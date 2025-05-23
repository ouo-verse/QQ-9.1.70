package bg;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.normal.QZoneSingleVideoFeedItemView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends nf.a<QZoneSingleVideoFeedItemView> {
    private boolean d(BusinessFeedData businessFeedData) {
        return businessFeedData.getVideoInfo() != null && businessFeedData.getVideoInfo().videoStatus == 1;
    }

    @Override // nf.a
    public Class<QZoneSingleVideoFeedItemView> a() {
        return QZoneSingleVideoFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_SINGLE_VIDEO_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.isVideo() || d(businessFeedData);
    }
}
