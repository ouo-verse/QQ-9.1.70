package com.qzone.publish.business.publishqueue;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.publish.business.task.IQueueTask;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends com.qzone.component.cache.database.a {
    public static final IDBCacheDataWrapper.a<d> DB_CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private IQueueTask f51122d;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<d> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromCursor(Cursor cursor) {
            int i3 = cursor.getInt(cursor.getColumnIndex("type"));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("publish_data"));
            try {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                IQueueTask createQueueTask = d.createQueueTask(i3, obtain);
                createQueueTask.setTime(System.currentTimeMillis());
                OaidMonitor.parcelRecycle(obtain);
                return new d(createQueueTask);
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("client_key", "TEXT UNIQUE"), new IDBCacheDataWrapper.c("type", "INTEGER"), new IDBCacheDataWrapper.c("publish_data", "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 8;
        }
    }

    public d(IQueueTask iQueueTask) {
        this.f51122d = iQueueTask;
    }

    public static IQueueTask createQueueTask(int i3, Parcel parcel) {
        return (IQueueTask) ParcelableWrapper.createDataFromParcel(parcel);
    }

    public IQueueTask getQueueTask() {
        return this.f51122d;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        IQueueTask iQueueTask = this.f51122d;
        if (iQueueTask != null) {
            contentValues.put("client_key", iQueueTask.getCacheKey());
            contentValues.put("type", Integer.valueOf(this.f51122d.getExactType()));
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            ParcelableWrapper.writeDataToParcel(obtain, 0, this.f51122d);
            byte[] marshall = obtain.marshall();
            OaidMonitor.parcelRecycle(obtain);
            contentValues.put("publish_data", marshall);
        }
    }
}
