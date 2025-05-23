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
public class PhotoQualityInfo extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<PhotoQualityInfo> DB_CREATOR = new a();
    public static final String PHOTO_ID = "photo_id";
    private static final int PhotoQualityTbVersion = 3;
    public static final String QUALITY_SCORE = "quality_score";
    private static final String TAG = "LocalPhotoInfo | PhotoQualityInfo";
    public static final String TYPE_PHOTO_ID = "INTEGER UNIQUE";
    public static final String TYPE_QUALITY_SCORE = "REAL";
    private static final String TYPE_VERSION = "INTEGER";
    private static final String VERSION = "version";
    public static final String tableName = "PhotoQualityInfoTB";

    @NeedParcel
    public int photoId;

    @NeedParcel
    public float qualityScore;

    @NeedParcel
    public int version;

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.b<PhotoQualityInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhotoQualityInfo createFromCursor(Cursor cursor) {
            PhotoQualityInfo photoQualityInfo = new PhotoQualityInfo();
            photoQualityInfo.photoId = cursor.getInt(cursor.getColumnIndex("photo_id"));
            photoQualityInfo.qualityScore = cursor.getFloat(cursor.getColumnIndex(PhotoQualityInfo.QUALITY_SCORE));
            photoQualityInfo.version = cursor.getInt(cursor.getColumnIndex("version"));
            return photoQualityInfo;
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
                QZLog.e(PhotoQualityInfo.TAG, "del localphoto event group raw sql error :" + QZLog.getStackTraceString(e16));
                return 0;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            TextUtils.isEmpty(str);
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("photo_id", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(PhotoQualityInfo.QUALITY_SCORE, "REAL"), new IDBCacheDataWrapper.c("version", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 3;
        }
    }

    public static int getTBVersion() {
        return 3;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("photo_id", Integer.valueOf(this.photoId));
        contentValues.put(QUALITY_SCORE, Float.valueOf(this.qualityScore));
        contentValues.put("version", Integer.valueOf(this.version));
    }
}
