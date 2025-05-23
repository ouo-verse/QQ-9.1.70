package cooperation.qqcircle.report.outbox;

import com.tencent.mobileqq.qcircle.api.db.DbCacheManager;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper;
import com.tencent.mobileqq.qcircle.api.db.b;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleReportOutboxTaskCacheManager {
    private static final String TAG = "QCircleReportOutboxTaskCacheManager";
    private static final String WHERE_CLAUSE = "cache_key";
    private String mCacheName;
    private final CacheHolder mSenderQueueCache;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class CacheHolder {
        DbCacheManager cache;
        long uin;

        CacheHolder() {
        }
    }

    public QCircleReportOutboxTaskCacheManager() {
        this("sender_queue");
    }

    private void ensureCacheHolder(CacheHolder cacheHolder) {
        DbCacheManager dbCacheManager;
        if (cacheHolder == null) {
            return;
        }
        long currentAccountLongUin = QCircleHostStubUtil.getCurrentAccountLongUin();
        if (currentAccountLongUin != cacheHolder.uin || (dbCacheManager = cacheHolder.cache) == null || dbCacheManager.isClosed()) {
            cacheHolder.uin = currentAccountLongUin;
            cacheHolder.cache = b.g().e(QCircleReportOutboxTaskCacheData.class, currentAccountLongUin, this.mCacheName);
        }
    }

    public void release() {
        DbCacheManager dbCacheManager = this.mSenderQueueCache.cache;
        if (dbCacheManager == null) {
            return;
        }
        dbCacheManager.close();
        this.mSenderQueueCache.cache = null;
    }

    public void removeTask(QCircleReportOutboxTask qCircleReportOutboxTask) {
        QLog.i(TAG, 1, "removeTask id:" + qCircleReportOutboxTask.getTaskId());
        ensureCacheHolder(this.mSenderQueueCache);
        this.mSenderQueueCache.cache.deleteData("cache_key=?", new String[]{qCircleReportOutboxTask.getCacheKey()});
    }

    public ArrayList<QCircleReportOutboxTask> restoreTasks() {
        ensureCacheHolder(this.mSenderQueueCache);
        ArrayList<? extends IDBCacheDataWrapper> queryData = this.mSenderQueueCache.cache.queryData();
        ArrayList<QCircleReportOutboxTask> arrayList = new ArrayList<>();
        if (queryData != null && queryData.size() > 0) {
            for (int i3 = 0; i3 < queryData.size(); i3++) {
                QCircleReportOutboxTaskCacheData qCircleReportOutboxTaskCacheData = (QCircleReportOutboxTaskCacheData) queryData.get(i3);
                if (qCircleReportOutboxTaskCacheData != null && qCircleReportOutboxTaskCacheData.getQueueTask() != null) {
                    QCircleReportOutboxTask queueTask = qCircleReportOutboxTaskCacheData.getQueueTask();
                    if (!queueTask.isNullTask()) {
                        queueTask.printTaskInfo(TAG, "restoreTask");
                        queueTask.setState(2);
                        arrayList.add(qCircleReportOutboxTaskCacheData.getQueueTask());
                    } else {
                        removeTask(queueTask);
                        QLog.w(TAG, 1, "remove null task, id:" + queueTask.getTaskId());
                    }
                }
            }
        }
        return arrayList;
    }

    public void saveTask(QCircleReportOutboxTask qCircleReportOutboxTask) {
        if (!qCircleReportOutboxTask.isNullTask()) {
            QLog.i(TAG, 1, "saveTask id:" + qCircleReportOutboxTask.getTaskId());
            ensureCacheHolder(this.mSenderQueueCache);
            this.mSenderQueueCache.cache.saveData(new QCircleReportOutboxTaskCacheData(qCircleReportOutboxTask), 1);
            return;
        }
        QLog.w(TAG, 1, "save null task, id:" + qCircleReportOutboxTask.getTaskId());
    }

    public void updateTask(QCircleReportOutboxTask qCircleReportOutboxTask) {
        ensureCacheHolder(this.mSenderQueueCache);
        this.mSenderQueueCache.cache.f0(new QCircleReportOutboxTaskCacheData(qCircleReportOutboxTask), "cache_key='" + qCircleReportOutboxTask.getCacheKey() + "'");
    }

    public QCircleReportOutboxTaskCacheManager(String str) {
        this.mCacheName = "sender_queue";
        this.mSenderQueueCache = new CacheHolder();
        this.mCacheName = str;
    }
}
