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
public class LocalPhotoFaceInfo extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String CATEGORY = "category";
    public static final String CATEGORY_SYMBOL = "$";
    public static final IDBCacheDataWrapper.a<LocalPhotoFaceInfo> DB_CREATOR = new a();
    public static final String FACE_BMP = "face_bmp";
    public static final String FACE_FEATURE = "face_feature";
    public static final String FACE_HEIGHT = "face_height";
    public static final String FACE_WIDTH = "face_width";
    public static final String IS_SEED_FACE = "is_seed_face";
    public static final String LEFT_EYE_OPEN = "left_eye_open";
    private static final int LocalPhotoFaceInfoTbVersion = 14;
    public static final String MAIN_FACE = "main_face";
    public static final int OLD_TABLE_VERSION_12 = 12;
    public static final int OLD_TABLE_VERSION_13 = 13;
    public static final String PHOTO_ID = "photo_id";
    public static final String POSITION_X = "position_x";
    public static final String POSITION_Y = "position_y";
    public static final String RATIO = "ratio";
    public static final String RIGHT_EYE_OPEN = "right_eye_open";
    public static final String SCORE = "score";
    public static final String SMILE = "smile";
    private static final String TAG = "LocalPhotoInfo | LocalPhotoFaceInfo";
    public static final String TYPE_CATEGORY = "TEXT";
    public static final String TYPE_FACE_BMP = "BLOB";
    public static final String TYPE_FACE_FEATURE = "BLOB";
    public static final String TYPE_FACE_HEIGHT = "INTEGER";
    public static final String TYPE_FACE_WIDTH = "INTEGER";
    public static final String TYPE_IS_SEED_FACE = "INTEGER";
    public static final String TYPE_LEFT_EYE_OPEN = "INTEGER";
    public static final String TYPE_MAIN_FACE = "INTEGER";
    public static final String TYPE_PHOTO_ID = "INTEGER";
    public static final String TYPE_POSITION_X = "INTEGER";
    public static final String TYPE_POSITION_Y = "INTEGER";
    public static final String TYPE_RATIO = "INTEGER";
    public static final String TYPE_RIGHT_EYE_OPEN = "INTEGER";
    public static final String TYPE_SCORE = "REAL";
    public static final String TYPE_SMILE = "INTEGER";
    public static final String TYPE_VERSION = "INTEGER";
    public static final String VERSION = "version";
    public static final String tableName = "LocalPhotoFaceInfoTB";

    @NeedParcel
    public String category;

    @NeedParcel
    public byte[] face_bmp;

    @NeedParcel
    public byte[] face_feature;

    @NeedParcel
    public int face_height;

    @NeedParcel
    public int face_width;

    @NeedParcel
    public int is_seed_face;

    @NeedParcel
    public int left_eye_open;

    @NeedParcel
    public int main_face;

    @NeedParcel
    public int photo_id;

    @NeedParcel
    public int position_x;

    @NeedParcel
    public int position_y;

    @NeedParcel
    public int ratio;

    @NeedParcel
    public int right_eye_open;

    @NeedParcel
    public float score;

    @NeedParcel
    public int smile;

    @NeedParcel
    public int version = 1;

    public static int getTBVersion() {
        return 14;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("photo_id", Integer.valueOf(this.photo_id));
        contentValues.put(FACE_FEATURE, this.face_feature);
        contentValues.put(POSITION_X, Integer.valueOf(this.position_x));
        contentValues.put(POSITION_Y, Integer.valueOf(this.position_y));
        contentValues.put(FACE_WIDTH, Integer.valueOf(this.face_width));
        contentValues.put(FACE_HEIGHT, Integer.valueOf(this.face_height));
        contentValues.put(LEFT_EYE_OPEN, Integer.valueOf(this.left_eye_open));
        contentValues.put(RIGHT_EYE_OPEN, Integer.valueOf(this.right_eye_open));
        contentValues.put(SMILE, Integer.valueOf(this.smile));
        contentValues.put(MAIN_FACE, Integer.valueOf(this.main_face));
        contentValues.put("category", this.category);
        contentValues.put(IS_SEED_FACE, Integer.valueOf(this.is_seed_face));
        contentValues.put(SCORE, Float.valueOf(this.score));
        contentValues.put(FACE_BMP, this.face_bmp);
        contentValues.put("version", Integer.valueOf(this.version));
        contentValues.put("ratio", Integer.valueOf(this.ratio));
    }

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.d<LocalPhotoFaceInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalPhotoFaceInfo createFromCursor(Cursor cursor) {
            LocalPhotoFaceInfo localPhotoFaceInfo = new LocalPhotoFaceInfo();
            localPhotoFaceInfo.photo_id = cursor.getInt(cursor.getColumnIndex("photo_id"));
            localPhotoFaceInfo.face_feature = cursor.getBlob(cursor.getColumnIndex(LocalPhotoFaceInfo.FACE_FEATURE));
            localPhotoFaceInfo.position_x = cursor.getInt(cursor.getColumnIndex(LocalPhotoFaceInfo.POSITION_X));
            localPhotoFaceInfo.position_y = cursor.getInt(cursor.getColumnIndex(LocalPhotoFaceInfo.POSITION_Y));
            localPhotoFaceInfo.face_width = cursor.getInt(cursor.getColumnIndex(LocalPhotoFaceInfo.FACE_WIDTH));
            localPhotoFaceInfo.face_height = cursor.getInt(cursor.getColumnIndex(LocalPhotoFaceInfo.FACE_HEIGHT));
            localPhotoFaceInfo.left_eye_open = cursor.getInt(cursor.getColumnIndex(LocalPhotoFaceInfo.LEFT_EYE_OPEN));
            localPhotoFaceInfo.right_eye_open = cursor.getInt(cursor.getColumnIndex(LocalPhotoFaceInfo.RIGHT_EYE_OPEN));
            localPhotoFaceInfo.smile = cursor.getInt(cursor.getColumnIndex(LocalPhotoFaceInfo.SMILE));
            localPhotoFaceInfo.main_face = cursor.getInt(cursor.getColumnIndex(LocalPhotoFaceInfo.MAIN_FACE));
            localPhotoFaceInfo.category = cursor.getString(cursor.getColumnIndex("category"));
            localPhotoFaceInfo.is_seed_face = cursor.getInt(cursor.getColumnIndex(LocalPhotoFaceInfo.IS_SEED_FACE));
            localPhotoFaceInfo.score = cursor.getFloat(cursor.getColumnIndex(LocalPhotoFaceInfo.SCORE));
            localPhotoFaceInfo.face_bmp = cursor.getBlob(cursor.getColumnIndex(LocalPhotoFaceInfo.FACE_BMP));
            localPhotoFaceInfo.version = cursor.getInt(cursor.getColumnIndex("version"));
            localPhotoFaceInfo.ratio = cursor.getInt(cursor.getColumnIndex("ratio"));
            return localPhotoFaceInfo;
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
                QZLog.e(LocalPhotoFaceInfo.TAG, "del localphoto event group raw sql error :" + QZLog.getStackTraceString(e16));
                return 0;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return "CREATE INDEX IF NOT EXISTS face_id_index  ON " + str + " (photo_id)";
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("photo_id", "INTEGER"), new IDBCacheDataWrapper.c(LocalPhotoFaceInfo.FACE_FEATURE, "BLOB"), new IDBCacheDataWrapper.c(LocalPhotoFaceInfo.POSITION_X, "INTEGER"), new IDBCacheDataWrapper.c(LocalPhotoFaceInfo.POSITION_Y, "INTEGER"), new IDBCacheDataWrapper.c(LocalPhotoFaceInfo.FACE_WIDTH, "INTEGER"), new IDBCacheDataWrapper.c(LocalPhotoFaceInfo.FACE_HEIGHT, "INTEGER"), new IDBCacheDataWrapper.c(LocalPhotoFaceInfo.LEFT_EYE_OPEN, "INTEGER"), new IDBCacheDataWrapper.c(LocalPhotoFaceInfo.RIGHT_EYE_OPEN, "INTEGER"), new IDBCacheDataWrapper.c(LocalPhotoFaceInfo.SMILE, "INTEGER"), new IDBCacheDataWrapper.c(LocalPhotoFaceInfo.MAIN_FACE, "INTEGER"), new IDBCacheDataWrapper.c("category", "TEXT"), new IDBCacheDataWrapper.c(LocalPhotoFaceInfo.IS_SEED_FACE, "INTEGER"), new IDBCacheDataWrapper.c(LocalPhotoFaceInfo.SCORE, "REAL"), new IDBCacheDataWrapper.c(LocalPhotoFaceInfo.FACE_BMP, "BLOB"), new IDBCacheDataWrapper.c("version", "INTEGER"), new IDBCacheDataWrapper.c("ratio", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 14;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.d
        public String[] onUpdate(int i3, int i16) {
            if (i3 == 12 || i3 == 13) {
                return new String[]{"DELETE from LocalPhotoFaceInfoTB where _id not in(select _id from LocalPhotoFaceInfoTB group by photo_id, position_x,position_y)"};
            }
            return null;
        }
    }
}
