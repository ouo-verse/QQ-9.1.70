package com.qzone.component.cache.database.table.photo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import cooperation.qzone.util.QZLog;

/* loaded from: classes39.dex */
public class LocalPhotoInfo extends com.qzone.component.cache.database.a implements SmartParcelable, Comparable<LocalPhotoInfo> {
    public static final IDBCacheDataWrapper.a<LocalPhotoInfo> DB_CREATOR = new a();
    public static final String DELETE_PHOTO_TIME = "local_photo_delete_time";
    public static final String EXIF_TAKE_PHOTO_TIME = "local_photo_exif_time";
    public static final String GPS_LATITUDE = "gps_latitude";
    public static final String GPS_LONGTITUDE = "gps_longtitude";
    public static final String LOCAL_PHOTO_HEIGHT = "local_photo_height";
    public static final String LOCAL_PHOTO_ID = "local_photo_id";
    public static final String LOCAL_PHOTO_MIME_TYPE = "local_photo_mime_type";
    public static final String LOCAL_PHOTO_PATH = "local_photo_path";
    public static final String LOCAL_PHOTO_TIME = "local_photo_time";
    public static final String LOCAL_PHOTO_WIDTH = "local_photo_width";
    public static final String MODIFY_PHOTO_TIME = "local_photo_modify_time";
    public static final int OLD_TABLE_VERSION_27 = 25;
    public static final int OLD_TABLE_VERSION_28 = 28;
    public static final int PhotoTBVersion = 29;
    public static final String SCAN_MASK = "scan_mask";
    private static final String TAG = "LocalPhotoTask | LocalPhotoInfo";
    public static final String TYPE_DELETE_PHOTO_TIME = "INTEGER";
    public static final String TYPE_EXIF_TAKE_PHOTO_TIME = "INTEGER";
    public static final String TYPE_GPS_LATITUDE = "REAL";
    public static final String TYPE_GPS_LONGTITUDE = "REAL";
    public static final String TYPE_LOCAL_PHOTO_HEIGHT = "INTEGER";
    public static final String TYPE_LOCAL_PHOTO_ID = "INTEGER UNIQUE";
    public static final String TYPE_LOCAL_PHOTO_MIME_TYPE = "TEXT";
    public static final String TYPE_LOCAL_PHOTO_PATH = "TEXT UNIQUE";
    public static final String TYPE_LOCAL_PHOTO_TIME = "INTEGER";
    public static final String TYPE_LOCAL_PHOTO_WIDTH = "INTEGER";
    public static final String TYPE_MODIFY_PHOTO_TIME = "INTEGER";
    public static final String TYPE_SCAN_MASK = "INTEGER";
    public static final String tableName = "LocalPhotoInfoTB";
    public int deletePhotoTime = 0;

    @NeedParcel
    public long exifTakePhotoTime;

    @NeedParcel
    public int height;

    @NeedParcel
    public float latitude;

    @NeedParcel
    public int localPhotoID;

    @NeedParcel
    public String localPhotoPath;

    @NeedParcel
    public long localPhotoTime;

    @NeedParcel
    public float longtitude;

    @NeedParcel
    public String mimeType;

    @NeedParcel
    public long modifyPhotoTime;

    @NeedParcel
    public int scan_mask;
    public int source;
    public int videoDuration;
    public int videoSize;
    public int videoThumbHeight;
    public String videoThumbPath;
    public int videoThumbWidth;

    @NeedParcel
    public int width;

    public static int getTBVersion() {
        return 29;
    }

    public boolean isQQCachePhoto() {
        return 1 == this.source;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("local_photo_path", this.localPhotoPath);
        contentValues.put("local_photo_id", Integer.valueOf(this.localPhotoID));
        contentValues.put("local_photo_time", Long.valueOf(this.localPhotoTime));
        contentValues.put("local_photo_exif_time", Long.valueOf(this.exifTakePhotoTime));
        contentValues.put("local_photo_modify_time", Long.valueOf(this.modifyPhotoTime));
        contentValues.put("local_photo_mime_type", this.mimeType);
        contentValues.put("gps_latitude", Float.valueOf(this.latitude));
        contentValues.put("gps_longtitude", Float.valueOf(this.longtitude));
        contentValues.put("local_photo_width", Integer.valueOf(this.width));
        contentValues.put("local_photo_height", Integer.valueOf(this.height));
        contentValues.put("local_photo_delete_time", Integer.valueOf(this.deletePhotoTime));
        contentValues.put("scan_mask", Integer.valueOf(this.scan_mask));
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalPhotoInfo localPhotoInfo) {
        if (localPhotoInfo == null) {
            return 1;
        }
        long j3 = this.localPhotoTime;
        long j16 = localPhotoInfo.localPhotoTime;
        if (j3 == j16) {
            return 0;
        }
        return j3 > j16 ? 1 : -1;
    }

    public boolean isWXCachePhoto() {
        return 2 == this.source;
    }

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.d<LocalPhotoInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalPhotoInfo createFromCursor(Cursor cursor) {
            LocalPhotoInfo localPhotoInfo = new LocalPhotoInfo();
            localPhotoInfo.localPhotoPath = cursor.getString(cursor.getColumnIndex("local_photo_path"));
            localPhotoInfo.localPhotoID = cursor.getInt(cursor.getColumnIndex("local_photo_id"));
            localPhotoInfo.localPhotoTime = cursor.getLong(cursor.getColumnIndex("local_photo_time"));
            localPhotoInfo.exifTakePhotoTime = cursor.getLong(cursor.getColumnIndex("local_photo_exif_time"));
            localPhotoInfo.modifyPhotoTime = cursor.getLong(cursor.getColumnIndex("local_photo_modify_time"));
            localPhotoInfo.mimeType = cursor.getString(cursor.getColumnIndex("local_photo_mime_type"));
            localPhotoInfo.latitude = cursor.getFloat(cursor.getColumnIndex("gps_latitude"));
            localPhotoInfo.longtitude = cursor.getFloat(cursor.getColumnIndex("gps_longtitude"));
            localPhotoInfo.width = cursor.getInt(cursor.getColumnIndex("local_photo_width"));
            localPhotoInfo.height = cursor.getInt(cursor.getColumnIndex("local_photo_height"));
            localPhotoInfo.deletePhotoTime = cursor.getInt(cursor.getColumnIndex("local_photo_delete_time"));
            localPhotoInfo.scan_mask = cursor.getInt(cursor.getColumnIndex("scan_mask"));
            return localPhotoInfo;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public int delRawSql(SQLiteDatabase sQLiteDatabase, String str, String str2) {
            String[] split;
            if (sQLiteDatabase == null) {
                return 0;
            }
            try {
                if (!TextUtils.isEmpty(str2) && str2.contains(ContainerUtils.KEY_VALUE_DELIMITER) && !str2.contains(" and ") && !str2.contains(" AND ") && !str2.contains(" or ") && !str2.contains(" OR ") && (split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split.length > 1 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                    String trim = split[0].trim();
                    String replace = split[1].trim().replace("'", "");
                    if (!TextUtils.isEmpty(trim) && !TextUtils.isEmpty(replace)) {
                        return sQLiteDatabase.delete(str, trim + "=? ", new String[]{replace});
                    }
                }
                return sQLiteDatabase.delete(str, str2, null);
            } catch (Exception e16) {
                QZLog.e(LocalPhotoInfo.TAG, "del localphoto event group raw sql error :" + QZLog.getStackTraceString(e16));
                return 0;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return "CREATE INDEX IF NOT EXISTS local_photo_id_index  ON " + str + " (local_photo_id);CREATE INDEX IF NOT EXISTS local_photo_time_index  ON " + str + " (local_photo_time);CREATE INDEX IF NOT EXISTS local_photo_modify_time_index  ON " + str + " (local_photo_modify_time);CREATE INDEX IF NOT EXISTS gps_index  ON " + str + " (gps_latitude, gps_longtitude)";
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.d
        public boolean needEncrypt(int i3, int i16) {
            return false;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("local_photo_path", "TEXT UNIQUE"), new IDBCacheDataWrapper.c("local_photo_id", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("local_photo_time", "INTEGER"), new IDBCacheDataWrapper.c("local_photo_exif_time", "INTEGER"), new IDBCacheDataWrapper.c("local_photo_modify_time", "INTEGER"), new IDBCacheDataWrapper.c("local_photo_mime_type", "TEXT"), new IDBCacheDataWrapper.c("gps_latitude", "REAL"), new IDBCacheDataWrapper.c("gps_longtitude", "REAL"), new IDBCacheDataWrapper.c("local_photo_width", "INTEGER"), new IDBCacheDataWrapper.c("local_photo_height", "INTEGER"), new IDBCacheDataWrapper.c("local_photo_delete_time", "INTEGER"), new IDBCacheDataWrapper.c("scan_mask", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 29;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.d
        public String[] onUpdate(int i3, int i16) {
            if (i3 == 25) {
                return new String[]{"ALTER TABLE LocalPhotoInfoTB ADD COLUMN local_photo_delete_time INTEGER", "ALTER TABLE LocalPhotoInfoTB ADD COLUMN scan_mask INTEGER"};
            }
            if (i3 != 28) {
                return null;
            }
            return new String[]{"NOTHING"};
        }
    }
}
