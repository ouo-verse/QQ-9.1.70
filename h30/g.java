package h30;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends c {
    @Override // h30.c
    protected Object a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        try {
            QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
            qQCircleFeedBase$StReportInfoForClient.mergeFrom(feedCloudMeta$StFeed.reportInfoForClient.get().toByteArray());
            return qQCircleFeedBase$StReportInfoForClient;
        } catch (Exception e16) {
            QLog.e("QCircleBaseFeedTransFormer", 1, e16, new Object[0]);
            return null;
        }
    }

    @Override // h30.c
    protected ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("DITTO_REPORT_INFO_FOR_CLIENT");
        return arrayList;
    }
}
