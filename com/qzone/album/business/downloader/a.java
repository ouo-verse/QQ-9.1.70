package com.qzone.album.business.downloader;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends com.qzone.component.cache.database.a {
    public static final IDBCacheDataWrapper.a<a> DB_CREATOR = new C0320a();

    /* renamed from: d, reason: collision with root package name */
    private IDownloadQueueTask f42415d;

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.downloader.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0320a implements IDBCacheDataWrapper.a<a> {
        C0320a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("task_data"));
            try {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                IDownloadQueueTask createQueueTask = a.createQueueTask(obtain);
                createQueueTask.setTime(System.currentTimeMillis());
                OaidMonitor.parcelRecycle(obtain);
                return new a(createQueueTask);
            } catch (Throwable th5) {
                QZLog.w(th5);
                return null;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("task_id", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("task_data", "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    public a(IDownloadQueueTask iDownloadQueueTask) {
        this.f42415d = iDownloadQueueTask;
    }

    public static IDownloadQueueTask createQueueTask(Parcel parcel) {
        return (IDownloadQueueTask) ParcelableWrapper.createDataFromParcel(parcel);
    }

    public IDownloadQueueTask getQueueTask() {
        return this.f42415d;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        IDownloadQueueTask iDownloadQueueTask = this.f42415d;
        if (iDownloadQueueTask != null) {
            contentValues.put("task_id", Long.valueOf(iDownloadQueueTask.getTaskId()));
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            ParcelableWrapper.writeDataToParcel(obtain, 0, this.f42415d);
            byte[] marshall = obtain.marshall();
            OaidMonitor.parcelRecycle(obtain);
            contentValues.put("task_data", marshall);
        }
    }
}
