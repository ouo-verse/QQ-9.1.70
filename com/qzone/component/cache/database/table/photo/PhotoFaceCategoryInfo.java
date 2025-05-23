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
public class PhotoFaceCategoryInfo extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String CATEGORY = "category";
    public static final IDBCacheDataWrapper.a<PhotoFaceCategoryInfo> DB_CREATOR = new a();
    public static final int OLD_TABLE_VERSION_8 = 8;
    public static final int OLD_TABLE_VERSION_9 = 9;
    private static final int PhotoFaceCategoryInfoTbVersion = 10;
    public static final String SEED_FACE_FEATURE = "seedFaceFeature";
    private static final String TAG = "LocalPhotoInfo | PhotoFaceCategoryInfo";
    public static final String TYPE_CATEGORY = "TEXT UNIQUE";
    public static final String TYPE_SEED_FACE_FEATURE = "BLOB";
    public static final String TYPE_UIN = "INTEGER";
    public static final String UIN = "uin";
    public static final String tableName = "PhotoFaceCategoryInfoTB";

    @NeedParcel
    public String category;

    @NeedParcel
    public byte[] seed_face_feature;

    @NeedParcel
    public long uin;

    public static int getTBVersion() {
        return 10;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("category", this.category);
        contentValues.put("uin", Long.valueOf(this.uin));
        contentValues.put(SEED_FACE_FEATURE, this.seed_face_feature);
    }

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.d<PhotoFaceCategoryInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhotoFaceCategoryInfo createFromCursor(Cursor cursor) {
            PhotoFaceCategoryInfo photoFaceCategoryInfo = new PhotoFaceCategoryInfo();
            photoFaceCategoryInfo.category = cursor.getString(cursor.getColumnIndex("category"));
            photoFaceCategoryInfo.uin = cursor.getLong(cursor.getColumnIndex("uin"));
            photoFaceCategoryInfo.seed_face_feature = cursor.getBlob(cursor.getColumnIndex(PhotoFaceCategoryInfo.SEED_FACE_FEATURE));
            return photoFaceCategoryInfo;
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
                QZLog.e(PhotoFaceCategoryInfo.TAG, "del localphoto event group raw sql error :" + QZLog.getStackTraceString(e16));
                return 0;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return "CREATE INDEX IF NOT EXISTS category_index  ON " + str + " (category)";
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("category", "TEXT UNIQUE"), new IDBCacheDataWrapper.c("uin", "INTEGER"), new IDBCacheDataWrapper.c(PhotoFaceCategoryInfo.SEED_FACE_FEATURE, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 10;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.d
        public String[] onUpdate(int i3, int i16) {
            if (i3 != 8) {
                return null;
            }
            return new String[]{"NOTHING"};
        }
    }
}
