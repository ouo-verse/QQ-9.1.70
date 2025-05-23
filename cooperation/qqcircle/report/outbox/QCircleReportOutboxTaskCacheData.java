package cooperation.qqcircle.report.outbox;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.tencent.mobileqq.qcircle.api.db.DbCacheData;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smartparcelable.ParcelableWrapper;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleReportOutboxTaskCacheData extends DbCacheData {
    public static final IDBCacheDataWrapper.DbCreator<QCircleReportOutboxTaskCacheData> DB_CREATOR = new IDBCacheDataWrapper.DbCreator<QCircleReportOutboxTaskCacheData>() { // from class: cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskCacheData.1
        @Override // com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator
        public String sortOrder() {
            return null;
        }

        @Override // com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator
        public IDBCacheDataWrapper.Structure[] structure() {
            return new IDBCacheDataWrapper.Structure[]{new IDBCacheDataWrapper.Structure(Columns.CACHE_KEY, "TEXT UNIQUE"), new IDBCacheDataWrapper.Structure(Columns.SAVE_DATA, "BLOB")};
        }

        @Override // com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator
        public int version() {
            return 1;
        }

        @Override // com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator
        public QCircleReportOutboxTaskCacheData createFromCursor(Cursor cursor) {
            try {
                byte[] blob = cursor.getBlob(cursor.getColumnIndexOrThrow(Columns.SAVE_DATA));
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                QCircleReportOutboxTask createQueueTask = QCircleReportOutboxTaskCacheData.createQueueTask(obtain);
                createQueueTask.setTime(System.currentTimeMillis());
                OaidMonitor.parcelRecycle(obtain);
                return new QCircleReportOutboxTaskCacheData(createQueueTask);
            } catch (Throwable th5) {
                QLog.w("QueueTaskCacheData", 1, th5.getMessage());
                return null;
            }
        }
    };
    private static final int VERSION = 1;
    private QCircleReportOutboxTask mTask;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Columns {
        public static final String CACHE_KEY = "cache_key";
        public static final String SAVE_DATA = "save_data";
    }

    public QCircleReportOutboxTaskCacheData(QCircleReportOutboxTask qCircleReportOutboxTask) {
        this.mTask = qCircleReportOutboxTask;
    }

    public static QCircleReportOutboxTask createQueueTask(Parcel parcel) {
        return (QCircleReportOutboxTask) ParcelableWrapper.f(parcel);
    }

    public QCircleReportOutboxTask getQueueTask() {
        return this.mTask;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        QCircleReportOutboxTask qCircleReportOutboxTask = this.mTask;
        if (qCircleReportOutboxTask != null) {
            contentValues.put(Columns.CACHE_KEY, qCircleReportOutboxTask.getCacheKey());
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            ParcelableWrapper.t(obtain, 0, this.mTask);
            byte[] marshall = obtain.marshall();
            OaidMonitor.parcelRecycle(obtain);
            contentValues.put(Columns.SAVE_DATA, marshall);
        }
    }
}
