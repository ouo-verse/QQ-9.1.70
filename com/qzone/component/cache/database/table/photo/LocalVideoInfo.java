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

/* compiled from: P */
/* loaded from: classes39.dex */
public class LocalVideoInfo extends com.qzone.component.cache.database.a implements SmartParcelable, Comparable<LocalVideoInfo> {
    public static final IDBCacheDataWrapper.a<LocalVideoInfo> DB_CREATOR = new a();
    public static final String GPS_LATITUDE = "gps_latitude";
    public static final String GPS_LONGTITUDE = "gps_longtitude";
    public static final String LOCAL_VIDEO_DURATION = "local_video_duration";
    public static final String LOCAL_VIDEO_ID = "local_photo_id";
    public static final String LOCAL_VIDEO_MIME_TYPE = "local_photo_mime_type";
    public static final String LOCAL_VIDEO_PATH = "local_photo_path";
    public static final String LOCAL_VIDEO_SIZE = "local_video_size";
    public static final String LOCAL_VIDEO_THUMB = "local_video_thumb_path";
    public static final String LOCAL_VIDEO_THUMB_HEIGHT = "local_video_thumb_height";
    public static final String LOCAL_VIDEO_THUMB_WIDTH = "local_video_thumb_width";
    public static final String LOCAL_VIDEO_TIME = "local_photo_time";
    public static final String MODIFY_VIDEO_TIME = "local_photo_modify_time";
    public static final int OLD_TABLE_VERSION_27 = 27;
    private static final String TAG = "LocalPhotoInfo | LocalVideoInfo";
    public static final String TAKE_VIDEO_TIME = "local_photo_taken_time";
    public static final String TYPE_GPS_LATITUDE = "REAL";
    public static final String TYPE_GPS_LONGTITUDE = "REAL";
    public static final String TYPE_LOCAL_VIDEO_DURATION = "INTEGER";
    public static final String TYPE_LOCAL_VIDEO_ID = "INTEGER UNIQUE";
    public static final String TYPE_LOCAL_VIDEO_MIME_TYPE = "TEXT";
    public static final String TYPE_LOCAL_VIDEO_PATH = "TEXT UNIQUE";
    public static final String TYPE_LOCAL_VIDEO_SIZE = "INTEGER";
    public static final String TYPE_LOCAL_VIDEO_THUMB = "TEXT";
    public static final String TYPE_LOCAL_VIDEO_THUMB_HEIGHT = "INTEGER";
    public static final String TYPE_LOCAL_VIDEO_THUMB_WIDTH = "INTEGER";
    public static final String TYPE_LOCAL_VIDEO_TIME = "INTEGER";
    public static final String TYPE_MODIFY_VIDEO_TIME = "INTEGER";
    public static final String TYPE_TAKE_VIDEO_TIME = "INTEGER";
    public static final int VideoTBVersion = 28;
    public static final String tableName = "LocalVideoInfoTB";

    @NeedParcel
    public float latitude;

    @NeedParcel
    public int localVideoID;

    @NeedParcel
    public String localVideoPath;

    @NeedParcel
    public long localVideoTime;

    @NeedParcel
    public float longtitude;

    @NeedParcel
    public String mimeType;

    @NeedParcel
    public long modifyVideoTime;

    @NeedParcel
    public long takeVideoTime;

    @NeedParcel
    public int videoDuration;

    @NeedParcel
    public int videoSize;

    @NeedParcel
    public int videoThumbHeight;

    @NeedParcel
    public String videoThumbPath;

    @NeedParcel
    public int videoThumbWidth;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class b {
    }

    public LocalVideoInfo() {
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("local_photo_path", this.localVideoPath);
        contentValues.put("local_photo_id", Integer.valueOf(this.localVideoID));
        contentValues.put("local_photo_time", Long.valueOf(this.localVideoTime));
        contentValues.put("local_photo_modify_time", Long.valueOf(this.modifyVideoTime));
        contentValues.put(TAKE_VIDEO_TIME, Long.valueOf(this.takeVideoTime));
        contentValues.put("local_photo_mime_type", this.mimeType);
        contentValues.put("gps_latitude", Float.valueOf(this.latitude));
        contentValues.put("gps_longtitude", Float.valueOf(this.longtitude));
        contentValues.put("local_video_duration", Integer.valueOf(this.videoDuration));
        contentValues.put(LOCAL_VIDEO_SIZE, Integer.valueOf(this.videoSize));
        contentValues.put(LOCAL_VIDEO_THUMB, this.videoThumbPath);
        contentValues.put(LOCAL_VIDEO_THUMB_WIDTH, Integer.valueOf(this.videoThumbWidth));
        contentValues.put(LOCAL_VIDEO_THUMB_HEIGHT, Integer.valueOf(this.videoThumbHeight));
    }

    public LocalVideoInfo(b bVar) {
        throw null;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalVideoInfo localVideoInfo) {
        if (localVideoInfo == null) {
            return 1;
        }
        long j3 = this.localVideoTime;
        long j16 = localVideoInfo.localVideoTime;
        if (j3 == j16) {
            return 0;
        }
        return j3 > j16 ? 1 : -1;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.d<LocalVideoInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalVideoInfo createFromCursor(Cursor cursor) {
            LocalVideoInfo localVideoInfo = new LocalVideoInfo();
            localVideoInfo.localVideoPath = cursor.getString(cursor.getColumnIndex("local_photo_path"));
            localVideoInfo.localVideoID = cursor.getInt(cursor.getColumnIndex("local_photo_id"));
            localVideoInfo.localVideoTime = cursor.getLong(cursor.getColumnIndex("local_photo_time"));
            localVideoInfo.modifyVideoTime = cursor.getLong(cursor.getColumnIndex("local_photo_modify_time"));
            localVideoInfo.takeVideoTime = cursor.getLong(cursor.getColumnIndex(LocalVideoInfo.TAKE_VIDEO_TIME));
            localVideoInfo.mimeType = cursor.getString(cursor.getColumnIndex("local_photo_mime_type"));
            localVideoInfo.latitude = cursor.getFloat(cursor.getColumnIndex("gps_latitude"));
            localVideoInfo.longtitude = cursor.getFloat(cursor.getColumnIndex("gps_longtitude"));
            localVideoInfo.videoDuration = cursor.getInt(cursor.getColumnIndex("local_video_duration"));
            localVideoInfo.videoSize = cursor.getInt(cursor.getColumnIndex(LocalVideoInfo.LOCAL_VIDEO_SIZE));
            localVideoInfo.videoThumbPath = cursor.getString(cursor.getColumnIndex(LocalVideoInfo.LOCAL_VIDEO_THUMB));
            localVideoInfo.videoThumbWidth = cursor.getInt(cursor.getColumnIndex(LocalVideoInfo.LOCAL_VIDEO_THUMB_WIDTH));
            localVideoInfo.videoThumbHeight = cursor.getInt(cursor.getColumnIndex(LocalVideoInfo.LOCAL_VIDEO_THUMB_HEIGHT));
            return localVideoInfo;
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
                QZLog.e(LocalVideoInfo.TAG, "del localphoto event group raw sql error :" + QZLog.getStackTraceString(e16));
                return 0;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return "CREATE INDEX IF NOT EXISTS local_photo_path_index  ON " + str + " (local_photo_path);CREATE INDEX IF NOT EXISTS local_photo_id_index  ON " + str + " (local_photo_id);CREATE INDEX IF NOT EXISTS local_photo_time_index  ON " + str + " (local_photo_time)";
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("local_photo_path", "TEXT UNIQUE"), new IDBCacheDataWrapper.c("local_photo_id", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("local_photo_time", "INTEGER"), new IDBCacheDataWrapper.c("local_photo_modify_time", "INTEGER"), new IDBCacheDataWrapper.c(LocalVideoInfo.TAKE_VIDEO_TIME, "INTEGER"), new IDBCacheDataWrapper.c("local_photo_mime_type", "TEXT"), new IDBCacheDataWrapper.c("gps_latitude", "REAL"), new IDBCacheDataWrapper.c("gps_longtitude", "REAL"), new IDBCacheDataWrapper.c("local_video_duration", "INTEGER"), new IDBCacheDataWrapper.c(LocalVideoInfo.LOCAL_VIDEO_SIZE, "INTEGER"), new IDBCacheDataWrapper.c(LocalVideoInfo.LOCAL_VIDEO_THUMB, "TEXT"), new IDBCacheDataWrapper.c(LocalVideoInfo.LOCAL_VIDEO_THUMB_WIDTH, "INTEGER"), new IDBCacheDataWrapper.c(LocalVideoInfo.LOCAL_VIDEO_THUMB_HEIGHT, "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 28;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.d
        public String[] onUpdate(int i3, int i16) {
            if (i3 != 27) {
                return null;
            }
            return new String[]{"NOTHING"};
        }
    }
}
