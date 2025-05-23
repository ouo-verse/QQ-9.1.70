package h30;

import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import qqcircle.QQCircleBase$StUserBusiData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class l extends c {
    @Override // h30.c
    protected Object a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        try {
            QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
            qQCircleBase$StUserBusiData.mergeFrom(feedCloudMeta$StFeed.poster.busiData.get().toByteArray());
            return qQCircleBase$StUserBusiData;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // h30.c
    protected ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("DITTO_PERSONAL_PAGE_MANTLE");
        return arrayList;
    }
}
