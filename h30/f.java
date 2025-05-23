package h30;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends c {
    @Override // h30.c
    protected Object a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        try {
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
            qQCircleFeedBase$StFeedBusiReqData.mergeFrom(feedCloudMeta$StFeed.busiData.get().toByteArray());
            return qQCircleFeedBase$StFeedBusiReqData;
        } catch (Exception e16) {
            QLog.e("QCircleBaseFeedTransFormer", 1, e16, new Object[0]);
            return null;
        }
    }

    @Override // h30.c
    protected ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("DITTO_FEED_BUSI_REQ_DATA");
        return arrayList;
    }
}
