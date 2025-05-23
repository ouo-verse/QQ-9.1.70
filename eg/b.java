package eg;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.itemview.qcircleshare.QZoneQCircleShareFeedSingleVideoItemView;
import com.qzone.reborn.util.k;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends nf.a<QZoneQCircleShareFeedSingleVideoItemView> {
    @Override // nf.a
    public Class<QZoneQCircleShareFeedSingleVideoItemView> a() {
        return QZoneQCircleShareFeedSingleVideoItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_QCIRCLE_SHARE_SINGLE_VIDEO_FEED;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData.isQCircleShareCardFeed() && (businessFeedData.getVideoInfo() != null && businessFeedData.getVideoInfo().videoUrl != null && !TextUtils.isEmpty(businessFeedData.getVideoInfo().videoUrl.url)) && !k.f59549a.g() && com.qzone.reborn.a.f52169a.b("exp_xsj_synchro_video_autoplay_exp", null);
    }
}
