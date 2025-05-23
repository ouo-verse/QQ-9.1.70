package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ItemInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class BaseReportTask {
    private static final String TAG = "BaseReportTask";
    private final AtomicBoolean mIsTaskWait = new AtomicBoolean(false);
    private final HashMap<ReportKey, ArrayList<ItemInfo>> mReportMap = new HashMap<>();

    abstract void doMobileReport(HashMap<ReportKey, ArrayList<ItemInfo>> hashMap);

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportByKey(ReportKey reportKey, ItemInfo itemInfo) {
        synchronized (this.mReportMap) {
            ArrayList<ItemInfo> arrayList = this.mReportMap.get(reportKey);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(itemInfo);
            this.mReportMap.put(reportKey, arrayList);
        }
        if (this.mIsTaskWait.compareAndSet(false, true)) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "start report!!!");
            }
            ThreadManagerV2.executeDelay(new Runnable() { // from class: cooperation.qzone.mobilereport.BaseReportTask.1
                @Override // java.lang.Runnable
                public void run() {
                    HashMap<ReportKey, ArrayList<ItemInfo>> hashMap = new HashMap<>();
                    synchronized (BaseReportTask.this.mReportMap) {
                        hashMap.putAll(BaseReportTask.this.mReportMap);
                        BaseReportTask.this.mReportMap.clear();
                        BaseReportTask.this.mIsTaskWait.set(false);
                    }
                    BaseReportTask.this.doMobileReport(hashMap);
                    if (QLog.isDevelopLevel()) {
                        QLog.d(BaseReportTask.TAG, 4, "report finish!!!");
                    }
                }
            }, 128, null, false, 3000L);
        } else if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "wait to report...");
        }
    }
}
