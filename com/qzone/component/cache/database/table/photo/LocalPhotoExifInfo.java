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
public class LocalPhotoExifInfo extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<LocalPhotoExifInfo> DB_CREATOR = new a();
    private static final int ExifTbVersion = 5;
    public static final String LOCAL_PHOTO_EXIF_APERTURE = "local_photo_exif_aperture";
    public static final String LOCAL_PHOTO_EXIF_BALANCE = "local_photo_exif_balance";
    public static final String LOCAL_PHOTO_EXIF_DATATIME = "local_photo_exif_datatime";
    public static final String LOCAL_PHOTO_EXIF_EXPOSURE_TIME = "local_photo_exif_exposure_time";
    public static final String LOCAL_PHOTO_EXIF_FLASH = "local_photo_exif_flash";
    public static final String LOCAL_PHOTO_EXIF_FOCAL_LENGTH = "local_photo_exif_focal_length";
    public static final String LOCAL_PHOTO_EXIF_ISO = "local_photo_exif_iso";
    public static final String LOCAL_PHOTO_EXIF_LATITUDE = "local_photo_exif_latitude";
    public static final String LOCAL_PHOTO_EXIF_LONGITUDE = "local_photo_exif_longitude";
    public static final String LOCAL_PHOTO_EXIF_MAKE = "local_photo_exif_make";
    public static final String LOCAL_PHOTO_EXIF_MODEL = "local_photo_exif_model";
    public static final String LOCAL_PHOTO_EXIF_ORIENTATION = "local_photo_exif_orientation";
    public static final String LOCAL_PHOTO_ID = "local_photo_id";
    public static final int OLD_TABLE_VERSION_4 = 4;
    private static final String TAG = "LocalPhotoInfo | LocalPhotoExifInfo";
    public static final String TYPE_LOCAL_PHOTO_EXIF_APERTURE = "TEXT";
    public static final String TYPE_LOCAL_PHOTO_EXIF_BALANCE = "TEXT";
    public static final String TYPE_LOCAL_PHOTO_EXIF_DATATIME = "TEXT";
    public static final String TYPE_LOCAL_PHOTO_EXIF_EXPOSURE_TIME = "TEXT";
    public static final String TYPE_LOCAL_PHOTO_EXIF_FLASH = "INTEGER";
    public static final String TYPE_LOCAL_PHOTO_EXIF_FOCAL_LENGTH = "TEXT";
    public static final String TYPE_LOCAL_PHOTO_EXIF_ISO = "TEXT";
    public static final String TYPE_LOCAL_PHOTO_EXIF_LATITUDE = "REAL";
    public static final String TYPE_LOCAL_PHOTO_EXIF_LONGITUDE = "REAL";
    public static final String TYPE_LOCAL_PHOTO_EXIF_MAKE = "TEXT";
    public static final String TYPE_LOCAL_PHOTO_EXIF_MODEL = "TEXT";
    public static final String TYPE_LOCAL_PHOTO_EXIF_ORIENTATION = "INTEGER";
    public static final String TYPE_LOCAL_PHOTO_ID = "INTEGER UNIQUE";
    public static final String TYPE_VERSION = "INTEGER";
    public static final String VERSION = "version";
    public static final String tableName = "LocalPhotoExifInfoTB";

    @NeedParcel
    public String localPhotoExifAperTure;

    @NeedParcel
    public String localPhotoExifBalance;

    @NeedParcel
    public String localPhotoExifDatatime;

    @NeedParcel
    public String localPhotoExifExposureTime;

    @NeedParcel
    public int localPhotoExifFlash;

    @NeedParcel
    public String localPhotoExifFocalLength;

    @NeedParcel
    public String localPhotoExifISO;

    @NeedParcel
    public float localPhotoExifLatitude;

    @NeedParcel
    public float localPhotoExifLongitude;

    @NeedParcel
    public String localPhotoExifMake;

    @NeedParcel
    public String localPhotoExifModel;

    @NeedParcel
    public int localPhotoExifOrientation;

    @NeedParcel
    public int localPhotoId;

    @NeedParcel
    public int version;

    public static int getTBVersion() {
        return 5;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("local_photo_id", Integer.valueOf(this.localPhotoId));
        contentValues.put(LOCAL_PHOTO_EXIF_ORIENTATION, Integer.valueOf(this.localPhotoExifOrientation));
        contentValues.put(LOCAL_PHOTO_EXIF_DATATIME, this.localPhotoExifDatatime);
        contentValues.put(LOCAL_PHOTO_EXIF_FLASH, Integer.valueOf(this.localPhotoExifFlash));
        contentValues.put(LOCAL_PHOTO_EXIF_LATITUDE, Float.valueOf(this.localPhotoExifLatitude));
        contentValues.put(LOCAL_PHOTO_EXIF_LONGITUDE, Float.valueOf(this.localPhotoExifLongitude));
        contentValues.put(LOCAL_PHOTO_EXIF_MAKE, this.localPhotoExifMake);
        contentValues.put(LOCAL_PHOTO_EXIF_MODEL, this.localPhotoExifModel);
        contentValues.put(LOCAL_PHOTO_EXIF_BALANCE, this.localPhotoExifBalance);
        contentValues.put(LOCAL_PHOTO_EXIF_EXPOSURE_TIME, this.localPhotoExifExposureTime);
        contentValues.put(LOCAL_PHOTO_EXIF_APERTURE, this.localPhotoExifAperTure);
        contentValues.put(LOCAL_PHOTO_EXIF_FOCAL_LENGTH, this.localPhotoExifFocalLength);
        contentValues.put(LOCAL_PHOTO_EXIF_ISO, this.localPhotoExifISO);
        contentValues.put("version", Integer.valueOf(this.version));
    }

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.d<LocalPhotoExifInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalPhotoExifInfo createFromCursor(Cursor cursor) {
            LocalPhotoExifInfo localPhotoExifInfo = new LocalPhotoExifInfo();
            localPhotoExifInfo.localPhotoId = cursor.getInt(cursor.getColumnIndex("local_photo_id"));
            localPhotoExifInfo.localPhotoExifOrientation = cursor.getInt(cursor.getColumnIndex(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_ORIENTATION));
            localPhotoExifInfo.localPhotoExifDatatime = cursor.getString(cursor.getColumnIndex(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_DATATIME));
            localPhotoExifInfo.localPhotoExifFlash = cursor.getInt(cursor.getColumnIndex(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_FLASH));
            localPhotoExifInfo.localPhotoExifLatitude = cursor.getFloat(cursor.getColumnIndex(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_LATITUDE));
            localPhotoExifInfo.localPhotoExifLongitude = cursor.getFloat(cursor.getColumnIndex(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_LONGITUDE));
            localPhotoExifInfo.localPhotoExifMake = cursor.getString(cursor.getColumnIndex(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_MAKE));
            localPhotoExifInfo.localPhotoExifModel = cursor.getString(cursor.getColumnIndex(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_MODEL));
            localPhotoExifInfo.localPhotoExifBalance = cursor.getString(cursor.getColumnIndex(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_BALANCE));
            localPhotoExifInfo.localPhotoExifExposureTime = cursor.getString(cursor.getColumnIndex(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_EXPOSURE_TIME));
            localPhotoExifInfo.localPhotoExifAperTure = cursor.getString(cursor.getColumnIndex(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_APERTURE));
            localPhotoExifInfo.localPhotoExifFocalLength = cursor.getString(cursor.getColumnIndex(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_FOCAL_LENGTH));
            localPhotoExifInfo.localPhotoExifISO = cursor.getString(cursor.getColumnIndex(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_ISO));
            localPhotoExifInfo.version = cursor.getInt(cursor.getColumnIndex("version"));
            return localPhotoExifInfo;
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
                QZLog.e(LocalPhotoExifInfo.TAG, "del localphoto event group raw sql error :" + QZLog.getStackTraceString(e16));
                return 0;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return "CREATE INDEX IF NOT EXISTS exif_id_index ON " + str + " (local_photo_id)";
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("local_photo_id", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_ORIENTATION, "INTEGER"), new IDBCacheDataWrapper.c(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_DATATIME, "TEXT"), new IDBCacheDataWrapper.c(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_FLASH, "INTEGER"), new IDBCacheDataWrapper.c(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_LATITUDE, "REAL"), new IDBCacheDataWrapper.c(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_LONGITUDE, "REAL"), new IDBCacheDataWrapper.c(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_MAKE, "TEXT"), new IDBCacheDataWrapper.c(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_MODEL, "TEXT"), new IDBCacheDataWrapper.c(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_BALANCE, "TEXT"), new IDBCacheDataWrapper.c(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_EXPOSURE_TIME, "TEXT"), new IDBCacheDataWrapper.c(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_APERTURE, "TEXT"), new IDBCacheDataWrapper.c(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_FOCAL_LENGTH, "TEXT"), new IDBCacheDataWrapper.c(LocalPhotoExifInfo.LOCAL_PHOTO_EXIF_ISO, "TEXT"), new IDBCacheDataWrapper.c("version", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 5;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.d
        public String[] onUpdate(int i3, int i16) {
            if (i3 != 4) {
                return null;
            }
            return new String[]{"NOTHING"};
        }
    }
}
