package h30;

import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends c {
    @Override // h30.c
    protected Object a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        try {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed2.mergeFrom(feedCloudMeta$StFeed.adBuffer.get().toByteArray());
            return feedCloudMeta$StFeed2;
        } catch (Exception e16) {
            QLog.e("QCircleBaseFeedTransFormer", 1, e16, new Object[0]);
            QCircleQualityReporter.reportQualityEvent(QCircleQualityReporter.KEY_QFS_AD_FEED_TRANSFORMER_MERGE_ERROR, Arrays.asList(QCircleReportHelper.newEntry("attach_info", "QCircleAdFeedTransFormer adBuffer merge error")), false);
            return new FeedCloudMeta$StFeed();
        }
    }

    @Override // h30.c
    protected ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("DITTO_FEED_AD_FEED");
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
