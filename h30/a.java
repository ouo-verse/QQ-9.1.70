package h30;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends c {
    @Override // h30.c
    protected Object a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        try {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed2.mergeFrom(feedCloudMeta$StFeed.adBuffer.get().toByteArray());
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
            adInfo.mergeFrom(feedCloudMeta$StFeed2.busiData.get().toByteArray());
            return adInfo;
        } catch (Exception e16) {
            QLog.e("QCircleBaseFeedTransFormer", 1, e16, new Object[0]);
            return null;
        }
    }

    @Override // h30.c
    protected ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("DITTO_AD_FEED_BUSI_DATA");
        return arrayList;
    }

    @Override // h30.c
    protected boolean c(String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.feedType.get() == 4) {
            return true;
        }
        return false;
    }
}
