package h30;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends c {
    @Override // h30.c
    protected Object a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        try {
            if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 1) {
                QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = new QQCircleDitto$StItemContainer();
                qQCircleDitto$StItemContainer.mergeFrom(feedCloudMeta$StFeed.dittoFeed.dittoData.get().toByteArray());
                return qQCircleDitto$StItemContainer;
            }
            QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = new QQCircleDitto$StCircleDittoDataNew();
            qQCircleDitto$StCircleDittoDataNew.mergeFrom(feedCloudMeta$StFeed.dittoFeed.dittoDataNew.get().toByteArray());
            return qQCircleDitto$StCircleDittoDataNew;
        } catch (Exception e16) {
            QLog.e("QCircleBaseFeedTransFormer", 1, e16, new Object[0]);
            return null;
        }
    }

    @Override // h30.c
    protected ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(String.valueOf(1));
        arrayList.add(String.valueOf(15));
        arrayList.add(String.valueOf(34));
        arrayList.add(String.valueOf(35));
        arrayList.add(String.valueOf(36));
        arrayList.add(String.valueOf(37));
        arrayList.add(String.valueOf(38));
        arrayList.add(String.valueOf(41));
        arrayList.add(String.valueOf(48));
        arrayList.add(String.valueOf(16));
        arrayList.add(String.valueOf(20));
        arrayList.add(String.valueOf(21));
        arrayList.add(String.valueOf(27));
        arrayList.add(String.valueOf(22));
        arrayList.add(String.valueOf(24));
        arrayList.add(String.valueOf(25));
        arrayList.add(String.valueOf(26));
        arrayList.add(String.valueOf(44));
        arrayList.add(String.valueOf(47));
        arrayList.add(String.valueOf(51));
        arrayList.add(String.valueOf(52));
        arrayList.add(String.valueOf(53));
        return arrayList;
    }

    @Override // h30.c
    protected boolean c(String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return str.equals(String.valueOf(feedCloudMeta$StFeed.dittoFeed.dittoId.get()));
    }
}
