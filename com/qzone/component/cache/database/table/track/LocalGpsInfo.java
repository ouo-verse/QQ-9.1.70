package com.qzone.component.cache.database.table.track;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class LocalGpsInfo extends com.qzone.component.cache.database.a implements SmartParcelable, Comparable<LocalGpsInfo> {
    public static final IDBCacheDataWrapper.a<LocalGpsInfo> DB_CREATOR = new a();
    public static final String LOCAL_ENTER_TIME = "local_enter_time";
    public static final String LOCAL_X = "local_ew";
    public static final String LOCAL_Y = "local_ns";
    public static final int PhotoTBVersion = 28;
    private static final String TAG = "LocalXYZInfoTB_New";
    public static final String TYPE_LOCAL_ENTER_TIME = "INTEGER";
    public static final String TYPE_LOCAL_X = "REAL";
    public static final String TYPE_LOCAL_Y = "REAL";
    public static final String TYPE_UIN = "INTEGER";
    public static final String UIN = "uin";
    public static final String tableName = "LocalXYZInfoTB_New";

    @NeedParcel
    public float latitude;

    @NeedParcel
    public long localEnterTime;

    @NeedParcel
    public float longtitude;

    @NeedParcel
    public long uin;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.b<LocalGpsInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalGpsInfo createFromCursor(Cursor cursor) {
            LocalGpsInfo localGpsInfo = new LocalGpsInfo();
            localGpsInfo.localEnterTime = cursor.getLong(cursor.getColumnIndex(LocalGpsInfo.LOCAL_ENTER_TIME));
            localGpsInfo.latitude = (cursor.getFloat(cursor.getColumnIndex(LocalGpsInfo.LOCAL_Y)) - 500.0f) / 365.0f;
            localGpsInfo.longtitude = (cursor.getFloat(cursor.getColumnIndex(LocalGpsInfo.LOCAL_X)) - 500.0f) / 365.0f;
            localGpsInfo.uin = cursor.getLong(cursor.getColumnIndex("uin"));
            return localGpsInfo;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public int delRawSql(SQLiteDatabase sQLiteDatabase, String str, String str2) {
            return 0;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return " CREATE INDEX IF NOT EXISTS local_xyz_time_index  ON " + str + " (" + LocalGpsInfo.LOCAL_ENTER_TIME + ")";
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(LocalGpsInfo.LOCAL_ENTER_TIME, "INTEGER"), new IDBCacheDataWrapper.c(LocalGpsInfo.LOCAL_Y, "REAL"), new IDBCacheDataWrapper.c(LocalGpsInfo.LOCAL_X, "REAL"), new IDBCacheDataWrapper.c("uin", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 28;
        }
    }

    public static int getTBVersion() {
        return 28;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(LOCAL_ENTER_TIME, Long.valueOf(this.localEnterTime));
        contentValues.put(LOCAL_X, Float.valueOf((this.longtitude * 365.0f) + 500.0f));
        contentValues.put(LOCAL_Y, Float.valueOf((this.latitude * 365.0f) + 500.0f));
        contentValues.put("uin", Long.valueOf(this.uin));
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalGpsInfo localGpsInfo) {
        if (localGpsInfo == null) {
            return 1;
        }
        long j3 = this.localEnterTime;
        long j16 = localGpsInfo.localEnterTime;
        if (j3 == j16) {
            return 0;
        }
        return j3 > j16 ? 1 : -1;
    }
}
