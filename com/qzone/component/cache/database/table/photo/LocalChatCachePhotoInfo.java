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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes39.dex */
public class LocalChatCachePhotoInfo extends com.qzone.component.cache.database.a implements SmartParcelable, Comparable<LocalPhotoInfo> {
    public static final int CachePhotoTBVersion = 1;
    public static final IDBCacheDataWrapper.a<LocalChatCachePhotoInfo> DB_CREATOR = new a();
    public static final String DELETE_PHOTO_TIME = "local_photo_delete_time";
    public static final String EXIF_TAKE_PHOTO_TIME = "local_photo_exif_time";
    public static final String LOCAL_PHOTO_HEIGHT = "local_photo_height";
    public static final String LOCAL_PHOTO_ID = "local_photo_id";
    public static final String LOCAL_PHOTO_MIME_TYPE = "local_photo_mime_type";
    public static final String LOCAL_PHOTO_PATH = "local_photo_path";
    public static final String LOCAL_PHOTO_TIME = "local_photo_time";
    public static final String LOCAL_PHOTO_WIDTH = "local_photo_width";
    public static final String MODIFY_PHOTO_TIME = "local_photo_modify_time";
    public static final String SCAN_MASK = "scan_mask";
    private static final String TAG = "LocalPhotoTask | LocalChatCachePhotoInfo";
    public static final String TYPE_DELETE_PHOTO_TIME = "INTEGER";
    public static final String TYPE_EXIF_TAKE_PHOTO_TIME = "INTEGER";
    public static final String TYPE_LOCAL_PHOTO_HEIGHT = "INTEGER";
    public static final String TYPE_LOCAL_PHOTO_ID = "INTEGER UNIQUE";
    public static final String TYPE_LOCAL_PHOTO_MIME_TYPE = "TEXT";
    public static final String TYPE_LOCAL_PHOTO_PATH = "TEXT UNIQUE";
    public static final String TYPE_LOCAL_PHOTO_TIME = "INTEGER";
    public static final String TYPE_LOCAL_PHOTO_WIDTH = "INTEGER";
    public static final String TYPE_MODIFY_PHOTO_TIME = "INTEGER";
    public static final String TYPE_SCAN_MASK = "INTEGER";
    public static final String qqTableName = "QQChatCachePhotoInfoTB";
    public static final String wxTableName = "WXChatCachePhotoInfoTB";
    public int deletePhotoTime;

    @NeedParcel
    public long exifTakePhotoTime;

    @NeedParcel
    public int height;

    @NeedParcel
    public int localPhotoID;

    @NeedParcel
    public String localPhotoPath;

    @NeedParcel
    public long localPhotoTime;

    @NeedParcel
    public String mimeType;

    @NeedParcel
    public long modifyPhotoTime;

    @NeedParcel
    public int scan_mask;

    @NeedParcel
    public int width;

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.b<LocalChatCachePhotoInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalChatCachePhotoInfo createFromCursor(Cursor cursor) {
            LocalChatCachePhotoInfo localChatCachePhotoInfo = new LocalChatCachePhotoInfo();
            localChatCachePhotoInfo.localPhotoPath = cursor.getString(cursor.getColumnIndex("local_photo_path"));
            localChatCachePhotoInfo.localPhotoID = cursor.getInt(cursor.getColumnIndex("local_photo_id"));
            localChatCachePhotoInfo.localPhotoTime = cursor.getLong(cursor.getColumnIndex("local_photo_time"));
            localChatCachePhotoInfo.exifTakePhotoTime = cursor.getLong(cursor.getColumnIndex("local_photo_exif_time"));
            localChatCachePhotoInfo.modifyPhotoTime = cursor.getLong(cursor.getColumnIndex("local_photo_modify_time"));
            localChatCachePhotoInfo.mimeType = cursor.getString(cursor.getColumnIndex("local_photo_mime_type"));
            localChatCachePhotoInfo.width = cursor.getInt(cursor.getColumnIndex("local_photo_width"));
            localChatCachePhotoInfo.height = cursor.getInt(cursor.getColumnIndex("local_photo_height"));
            localChatCachePhotoInfo.deletePhotoTime = cursor.getInt(cursor.getColumnIndex("local_photo_delete_time"));
            localChatCachePhotoInfo.scan_mask = cursor.getInt(cursor.getColumnIndex("scan_mask"));
            return localChatCachePhotoInfo;
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
                QZLog.e(LocalChatCachePhotoInfo.TAG, "del localphoto event group raw sql error :" + QZLog.getStackTraceString(e16));
                return 0;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("local_photo_path", "TEXT UNIQUE"), new IDBCacheDataWrapper.c("local_photo_id", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("local_photo_time", "INTEGER"), new IDBCacheDataWrapper.c("local_photo_exif_time", "INTEGER"), new IDBCacheDataWrapper.c("local_photo_modify_time", "INTEGER"), new IDBCacheDataWrapper.c("local_photo_mime_type", "TEXT"), new IDBCacheDataWrapper.c("local_photo_width", "INTEGER"), new IDBCacheDataWrapper.c("local_photo_height", "INTEGER"), new IDBCacheDataWrapper.c("local_photo_delete_time", "INTEGER"), new IDBCacheDataWrapper.c("scan_mask", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    public static int getTBVersion() {
        return 1;
    }

    public LocalPhotoInfo toLocalPhotoInfo() {
        return toLocalPhotoInfo(this);
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("local_photo_path", this.localPhotoPath);
        contentValues.put("local_photo_id", Integer.valueOf(this.localPhotoID));
        contentValues.put("local_photo_time", Long.valueOf(this.localPhotoTime));
        contentValues.put("local_photo_exif_time", Long.valueOf(this.exifTakePhotoTime));
        contentValues.put("local_photo_modify_time", Long.valueOf(this.modifyPhotoTime));
        contentValues.put("local_photo_mime_type", this.mimeType);
        contentValues.put("local_photo_width", Integer.valueOf(this.width));
        contentValues.put("local_photo_height", Integer.valueOf(this.height));
        contentValues.put("local_photo_delete_time", Integer.valueOf(this.deletePhotoTime));
        contentValues.put("scan_mask", Integer.valueOf(this.scan_mask));
    }

    public static LocalPhotoInfo toLocalPhotoInfo(LocalChatCachePhotoInfo localChatCachePhotoInfo) {
        LocalPhotoInfo localPhotoInfo = new LocalPhotoInfo();
        if (localChatCachePhotoInfo != null) {
            localPhotoInfo.localPhotoPath = localChatCachePhotoInfo.localPhotoPath;
            localPhotoInfo.localPhotoID = localChatCachePhotoInfo.localPhotoID;
            localPhotoInfo.localPhotoTime = localChatCachePhotoInfo.localPhotoTime;
            localPhotoInfo.exifTakePhotoTime = localChatCachePhotoInfo.exifTakePhotoTime;
            localPhotoInfo.modifyPhotoTime = localChatCachePhotoInfo.modifyPhotoTime;
            localPhotoInfo.mimeType = localChatCachePhotoInfo.mimeType;
            localPhotoInfo.width = localChatCachePhotoInfo.width;
            localPhotoInfo.height = localChatCachePhotoInfo.height;
            localPhotoInfo.deletePhotoTime = localChatCachePhotoInfo.deletePhotoTime;
            localPhotoInfo.scan_mask = localChatCachePhotoInfo.scan_mask;
        }
        return localPhotoInfo;
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

    public static List<LocalPhotoInfo> toLocalPhotoInfo(Collection<LocalChatCachePhotoInfo> collection) {
        ArrayList arrayList = new ArrayList();
        if (collection != null && collection.size() != 0) {
            Iterator<LocalChatCachePhotoInfo> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(toLocalPhotoInfo(it.next()));
            }
        }
        return arrayList;
    }

    public static List<LocalPhotoInfo> toLocalPhotoInfo(Collection<LocalChatCachePhotoInfo> collection, int i3) {
        ArrayList arrayList = new ArrayList();
        if (collection != null && collection.size() != 0) {
            Iterator<LocalChatCachePhotoInfo> it = collection.iterator();
            while (it.hasNext()) {
                LocalPhotoInfo localPhotoInfo = toLocalPhotoInfo(it.next());
                localPhotoInfo.source = i3;
                arrayList.add(localPhotoInfo);
            }
        }
        return arrayList;
    }
}
