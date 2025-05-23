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
public class LocalPhotoTagClassifyInfo extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<LocalPhotoTagClassifyInfo> DB_CREATOR = new a();
    public static final String LOCAL_PHOTO_ID = "local_photo_id";
    private static final String TAG = "LocalPhotoInfo | LocalPhotoTagClassifyInfo";
    public static final String TAG_CONFIDENCE = "tag_confidence";
    private static final String TAG_RESULT = "tag_result";
    public static final String TYPE_LOCAL_PHOTO_ID = "INTEGER UNIQUE";
    public static final String TYPE_TAG_CONFIDENCE = "BLOB";
    private static final String TYPE_TAG_RESULT = "BLOB";
    public static final String TYPE_VERSION = "INTEGER";
    private static final int TagClassifyTbVersion = 5;
    public static final String VERSION = "version";
    public static final String tableName = "LocalPhotoTagClassifyInfoTB";

    @NeedParcel
    public int localPhotoId;

    @NeedParcel
    public byte[] tagConfidence;

    @NeedParcel
    public byte[] tagResult;

    @NeedParcel
    public int version;

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.b<LocalPhotoTagClassifyInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalPhotoTagClassifyInfo createFromCursor(Cursor cursor) {
            LocalPhotoTagClassifyInfo localPhotoTagClassifyInfo = new LocalPhotoTagClassifyInfo();
            localPhotoTagClassifyInfo.localPhotoId = cursor.getInt(cursor.getColumnIndex("local_photo_id"));
            localPhotoTagClassifyInfo.tagResult = cursor.getBlob(cursor.getColumnIndex(LocalPhotoTagClassifyInfo.TAG_RESULT));
            localPhotoTagClassifyInfo.tagConfidence = cursor.getBlob(cursor.getColumnIndex(LocalPhotoTagClassifyInfo.TAG_CONFIDENCE));
            localPhotoTagClassifyInfo.version = cursor.getInt(cursor.getColumnIndex("version"));
            return localPhotoTagClassifyInfo;
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
                QZLog.e(LocalPhotoTagClassifyInfo.TAG, "del localphoto event group raw sql error :" + QZLog.getStackTraceString(e16));
                return 0;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return "CREATE INDEX IF NOT EXISTS tagclassify_id_index  ON " + str + " (local_photo_id)";
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("local_photo_id", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(LocalPhotoTagClassifyInfo.TAG_RESULT, "BLOB"), new IDBCacheDataWrapper.c(LocalPhotoTagClassifyInfo.TAG_CONFIDENCE, "BLOB"), new IDBCacheDataWrapper.c("version", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 5;
        }
    }

    public static int getTBVersion() {
        return 5;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("local_photo_id", Integer.valueOf(this.localPhotoId));
        contentValues.put(TAG_RESULT, this.tagResult);
        contentValues.put(TAG_CONFIDENCE, this.tagConfidence);
        contentValues.put("version", Integer.valueOf(this.version));
    }
}
