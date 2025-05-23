package bg;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.normal.QZoneMixPicVideoFeedItemView;
import com.tencent.mobileqq.utils.bl;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends nf.a<QZoneMixPicVideoFeedItemView> {
    @Override // nf.a
    public Class<QZoneMixPicVideoFeedItemView> a() {
        return QZoneMixPicVideoFeedItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_MIX_VIDEO_PIC_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return (businessFeedData.getPictureInfo() == null || bl.b(businessFeedData.getPictureInfo().pics)) ? false : true;
    }
}
