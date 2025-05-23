package com.tencent.biz.qqcircle.richframework.outbox;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.tencent.mobileqq.qcircle.api.db.DbCacheData;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smartparcelable.ParcelableWrapper;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskCacheData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleOutboxCacheData extends DbCacheData {
    public static final IDBCacheDataWrapper.DbCreator<QCircleOutboxCacheData> DB_CREATOR = new a();
    private static final int VERSION = 1;
    private b mTask;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements IDBCacheDataWrapper.DbCreator<QCircleOutboxCacheData> {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QCircleOutboxCacheData createFromCursor(Cursor cursor) {
            try {
                byte[] blob = cursor.getBlob(cursor.getColumnIndexOrThrow(QCircleReportOutboxTaskCacheData.Columns.SAVE_DATA));
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                b createQueueTask = QCircleOutboxCacheData.createQueueTask(obtain);
                createQueueTask.setTime(System.currentTimeMillis());
                OaidMonitor.parcelRecycle(obtain);
                return new QCircleOutboxCacheData(createQueueTask);
            } catch (Throwable th5) {
                QLog.w("QueueTaskCacheData", 1, th5.getMessage());
                return null;
            }
        }

        @Override // com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator
        public String sortOrder() {
            return null;
        }

        @Override // com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator
        public IDBCacheDataWrapper.Structure[] structure() {
            return new IDBCacheDataWrapper.Structure[]{new IDBCacheDataWrapper.Structure(QCircleReportOutboxTaskCacheData.Columns.CACHE_KEY, "TEXT UNIQUE"), new IDBCacheDataWrapper.Structure(QCircleReportOutboxTaskCacheData.Columns.SAVE_DATA, "BLOB")};
        }

        @Override // com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator
        public int version() {
            return 1;
        }
    }

    public QCircleOutboxCacheData(b bVar) {
        this.mTask = bVar;
    }

    public static b createQueueTask(Parcel parcel) {
        return (b) ParcelableWrapper.f(parcel);
    }

    public b getQueueTask() {
        return this.mTask;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        b bVar = this.mTask;
        if (bVar != null) {
            contentValues.put(QCircleReportOutboxTaskCacheData.Columns.CACHE_KEY, bVar.getCacheKey());
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            ParcelableWrapper.t(obtain, 0, this.mTask);
            byte[] marshall = obtain.marshall();
            OaidMonitor.parcelRecycle(obtain);
            contentValues.put(QCircleReportOutboxTaskCacheData.Columns.SAVE_DATA, marshall);
        }
    }
}
