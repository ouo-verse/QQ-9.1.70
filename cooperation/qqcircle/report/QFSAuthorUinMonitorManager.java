package cooperation.qqcircle.report;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QFSAuthorUinMonitorManager {
    private static final int MAX_LIST_SIZE = 10;
    private static final int MAX_MAP_SIZE = 20;
    private static final String TAG = "QFSAuthorUinMonitorManager";
    private static volatile QFSAuthorUinMonitorManager sInstance;
    private static final Map<String, String> mFeedUinMap = new ConcurrentHashMap();
    private static final List<QCircleLpReportDc05507.DataBuilder> mDataBuilderList = new CopyOnWriteArrayList();
    private static final Map<String, List<String>> mFeedIdTraceIdsMap = new ConcurrentHashMap();

    public static QFSAuthorUinMonitorManager getInstance() {
        if (sInstance == null) {
            synchronized (QFSAuthorUinMonitorManager.class) {
                if (sInstance == null) {
                    sInstance = new QFSAuthorUinMonitorManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printCollectedLog() {
        for (QCircleLpReportDc05507.DataBuilder dataBuilder : new ArrayList(mDataBuilderList)) {
            QLog.d(TAG, 1, "[Collected dataBuilder], feedId: " + dataBuilder.getFeedId() + ", authorUin: " + dataBuilder.getAuthorUin() + ", actionType: " + dataBuilder.getActionType() + ", subActionType: " + dataBuilder.getSubActionType() + ", actTime: " + dataBuilder.getActTime() + ", pos: " + dataBuilder.getPosition() + ", tag: " + dataBuilder.getFeedTag() + ", itemDetail:" + dataBuilder.getItemDetail() + ", pageId: " + dataBuilder.getPageId() + ", fpageId: " + dataBuilder.getFfPageId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printLog(QCircleLpReportDc05507.DataBuilder dataBuilder) {
        String feedId = dataBuilder.getFeedId();
        QLog.d(TAG, 1, "[authorUin changed] feedId: " + feedId + ", \u539fauthorUin: " + mFeedUinMap.get(feedId) + ", \u9519\u8befuin: " + dataBuilder.getAuthorUin() + ", actionType: " + dataBuilder.getActionType() + ", subActionType: " + dataBuilder.getSubActionType() + ", actTime: " + dataBuilder.getActTime() + ", pos: " + dataBuilder.getPosition() + ", tag: " + dataBuilder.getFeedTag() + ", itemDetail:" + dataBuilder.getItemDetail() + ", pageId: " + dataBuilder.getPageId() + ", fpageId: " + dataBuilder.getFfPageId());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[authorUin changed] feedId: ");
        sb5.append(feedId);
        sb5.append(", traceId: ");
        StringBuilder sb6 = new StringBuilder(sb5.toString());
        Map<String, List<String>> map = mFeedIdTraceIdsMap;
        if (map.containsKey(feedId)) {
            List<String> list = map.get(feedId);
            if (list != null) {
                Iterator it = new ArrayList(list).iterator();
                while (it.hasNext()) {
                    sb6.append((String) it.next());
                    sb6.append(",");
                }
                String sb7 = sb6.toString();
                qualityReport(sb7);
                QLog.d(TAG, 1, sb7);
                return;
            }
            return;
        }
        QLog.d(TAG, 1, "[authorUin changed] no traceId saved.");
    }

    private void qualityReport(String str) {
        QCircleQualityReporter.reportQualityEvent(QCircleQualityReporter.KEY_QFS_AUTHOR_UIN_MONITOR, Arrays.asList(QCircleReportHelper.newEntry("attach_info", str)), false);
    }

    public void addTraceId(final String str, final String str2) {
        if (QCircleDeviceInfoUtils.isLowDevice()) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cooperation.qqcircle.report.QFSAuthorUinMonitorManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_author_uin_monitor_9030", true)) {
                    return;
                }
                if (QFSAuthorUinMonitorManager.mFeedIdTraceIdsMap.size() > 20) {
                    QFSAuthorUinMonitorManager.mFeedIdTraceIdsMap.clear();
                }
                if (QFSAuthorUinMonitorManager.mFeedIdTraceIdsMap.containsKey(str)) {
                    List list = (List) QFSAuthorUinMonitorManager.mFeedIdTraceIdsMap.get(str);
                    if (list == null) {
                        return;
                    }
                    list.add(str2);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(str2);
                QFSAuthorUinMonitorManager.mFeedIdTraceIdsMap.put(str, arrayList);
            }
        });
    }

    public void checkFeedAuthorUin(final QCircleLpReportDc05507.DataBuilder dataBuilder) {
        if (QCircleDeviceInfoUtils.isLowDevice()) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cooperation.qqcircle.report.QFSAuthorUinMonitorManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (dataBuilder != null && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_author_uin_monitor_9030", true)) {
                    if (QFSAuthorUinMonitorManager.mFeedUinMap.size() > 20) {
                        QFSAuthorUinMonitorManager.mFeedUinMap.clear();
                    }
                    if (QFSAuthorUinMonitorManager.mDataBuilderList.size() > 10) {
                        QFSAuthorUinMonitorManager.mDataBuilderList.clear();
                    }
                    QFSAuthorUinMonitorManager.mDataBuilderList.add(dataBuilder);
                    String feedId = dataBuilder.getFeedId();
                    String authorUin = dataBuilder.getAuthorUin();
                    if (QFSAuthorUinMonitorManager.mFeedUinMap.containsKey(feedId)) {
                        if (!TextUtils.equals((CharSequence) QFSAuthorUinMonitorManager.mFeedUinMap.get(feedId), authorUin)) {
                            QFSAuthorUinMonitorManager.this.printLog(dataBuilder);
                            QFSAuthorUinMonitorManager.this.printCollectedLog();
                            return;
                        }
                        return;
                    }
                    QFSAuthorUinMonitorManager.mFeedUinMap.put(feedId, authorUin);
                }
            }
        });
    }

    public void release() {
        if (QCircleDeviceInfoUtils.isLowDevice()) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cooperation.qqcircle.report.QFSAuthorUinMonitorManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_author_uin_monitor_9030", true)) {
                    return;
                }
                QFSAuthorUinMonitorManager.mFeedUinMap.clear();
                QFSAuthorUinMonitorManager.mDataBuilderList.clear();
                QFSAuthorUinMonitorManager.mFeedIdTraceIdsMap.clear();
            }
        });
    }
}
