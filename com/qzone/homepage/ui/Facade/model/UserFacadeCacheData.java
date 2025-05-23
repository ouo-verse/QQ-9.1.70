package com.qzone.homepage.ui.Facade.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UserFacadeCacheData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<UserFacadeCacheData> DB_CREATOR = new a();
    public static final String FACADE_DATA = "cate";
    public static final String FACADE_DATA_DB_TYPE = "BLOB";
    public static final String UIN = "uin";
    public static final String UIN_TYPE = "INTEGER UNIQUE";
    public static final int VERSION = 2;

    @NeedParcel
    public FacadeCacheData mFacadeCacheData;

    @NeedParcel
    public long mUin;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<UserFacadeCacheData> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserFacadeCacheData createFromCursor(Cursor cursor) {
            UserFacadeCacheData userFacadeCacheData = new UserFacadeCacheData();
            userFacadeCacheData.mUin = cursor.getLong(cursor.getColumnIndex("uin"));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("cate"));
            if (blob != null) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                userFacadeCacheData.mFacadeCacheData = (FacadeCacheData) ParcelableWrapper.createDataFromParcel(obtain);
                OaidMonitor.parcelRecycle(obtain);
            }
            return userFacadeCacheData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("cate", "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 2;
        }
    }

    public UserFacadeCacheData() {
    }

    public String toString() {
        return this.mUin + "";
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.mUin));
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain, 0, this.mFacadeCacheData);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put("cate", marshall);
    }

    public UserFacadeCacheData(long j3, FacadeCacheData facadeCacheData) {
        this.mUin = j3;
        this.mFacadeCacheData = facadeCacheData;
    }
}
