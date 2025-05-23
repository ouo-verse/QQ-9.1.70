package h30;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import weprotocols.WEProtocolsAdvert$BannerAdvert;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends c {
    @Override // h30.c
    protected Object a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        try {
            WEProtocolsAdvert$BannerAdvert wEProtocolsAdvert$BannerAdvert = new WEProtocolsAdvert$BannerAdvert();
            wEProtocolsAdvert$BannerAdvert.mergeFrom(feedCloudMeta$StFeed.recomInfo.recomSoftADTrans.get().toByteArray());
            return wEProtocolsAdvert$BannerAdvert;
        } catch (Exception e16) {
            QLog.e("QCircleBaseFeedTransFormer", 1, e16, new Object[0]);
            return null;
        }
    }

    @Override // h30.c
    protected ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("DITTO_FEED_BANNER_BUSI_DATA");
        return arrayList;
    }

    @Override // h30.c
    protected boolean c(String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.recomInfo.recomSoftADTrans.get() != null && !feedCloudMeta$StFeed.recomInfo.recomSoftADTrans.get().isEmpty()) {
            return true;
        }
        return false;
    }
}
