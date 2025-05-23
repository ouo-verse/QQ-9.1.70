package cooperation.qqcircle.report;

import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleMapReporter {
    private static final String TAG = "[upload2]QCircleMapReporter";
    private static final QCircleMapReporter ourInstance = new QCircleMapReporter();
    private HashMap<String, Long> clickTimesMap = new HashMap<>();

    QCircleMapReporter() {
    }

    public static QCircleMapReporter getInstance() {
        return ourInstance;
    }

    public long endKey(String str) {
        if (this.clickTimesMap.containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis() - this.clickTimesMap.remove(str).longValue();
            if (currentTimeMillis < 0) {
                QLog.d(TAG, 1, "endKey... cost < 0 key:" + str);
                return -1L;
            }
            return currentTimeMillis;
        }
        QLog.w(TAG, 1, "endKey... clickTimesMap not contain key:" + str);
        return -1L;
    }

    public void removeKey(String str) {
        this.clickTimesMap.remove(str);
    }

    public void reportEnd(String str, String str2, List<FeedCloudCommon$Entry> list) {
        long endKey = endKey(str2);
        if (endKey > 0) {
            ArrayList arrayList = new ArrayList(list);
            arrayList.add(QCircleReportHelper.newEntry("ext1", String.valueOf(endKey)));
            QCirclePublishQualityReporter.report(str, arrayList);
            QLog.d(TAG, 1, "reportEnd... eventId:" + str + " missionId:" + str2 + " cost:" + endKey);
            return;
        }
        QLog.w(TAG, 1, "reportEnd... cost < 0 id:" + str2);
    }

    public void startKey(String str) {
        this.clickTimesMap.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public void reportEnd(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        long endKey = endKey(qCirclePublishQualityDataBuilder.getKey());
        if (endKey > 0) {
            qCirclePublishQualityDataBuilder.setExt1(String.valueOf(endKey));
            QCirclePublishQualityReporter.report(qCirclePublishQualityDataBuilder);
            QLog.d(TAG, 1, "reportEnd... builder:" + qCirclePublishQualityDataBuilder.toString());
            return;
        }
        QLog.w(TAG, 1, "reportEnd... cost < 0 id:" + qCirclePublishQualityDataBuilder.getKey());
    }
}
