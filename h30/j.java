package h30;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends c {
    @Override // h30.c
    protected Object a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        try {
            if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 32) {
                QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = new QQCircleDitto$StCircleDittoDataNew();
                qQCircleDitto$StCircleDittoDataNew.mergeFrom(feedCloudMeta$StFeed.dittoFeed.dittoDataNew.get().toByteArray());
                return qQCircleDitto$StCircleDittoDataNew;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("QCircleBaseFeedTransFormer", 1, e16, new Object[0]);
            return null;
        }
    }

    @Override // h30.c
    protected ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("DITTO_FEED_PUBLISH_TEMPLATE");
        return arrayList;
    }

    @Override // h30.c
    protected boolean c(String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.feedType.get() == 5) {
            return true;
        }
        return false;
    }
}
