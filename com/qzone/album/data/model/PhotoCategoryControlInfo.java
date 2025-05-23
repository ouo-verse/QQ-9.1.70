package com.qzone.album.data.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class PhotoCategoryControlInfo extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String CATEGORY_COUNTER = "categoryCounter";
    public static final String CATEGORY_COVER_URL = "categoryCoverUrl";
    public static final String CATEGORY_STATUS = "categoryStatus";
    public static final String CATEGORY_TYPE = "categoryType";
    public static final IDBCacheDataWrapper.a<PhotoCategoryControlInfo> DB_CREATOR = new a();
    public static final String TYPE_CATEGORY_COUNTER = "INTEGER";
    public static final String TYPE_CATEGORY_COVER_URL = "BLOB";
    public static final String TYPE_CATEGORY_STATUS = "INTEGER";
    public static final String TYPE_CATEGORY_TYPE = "INTEGER";
    public static final String TYPE_UIN = "INTEGER";
    public static final String TYPE_VISIBILITY = "INTEGER";
    public static final String UIN = "uin";
    public static final String VISIBILITY = "visibility";

    @NeedParcel
    public int categoryCounter;

    @NeedParcel
    public int categoryStatus;

    @NeedParcel
    public int categoryType;

    @NeedParcel
    public int visibility;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public ArrayList<String> categoryCoverUrl = new ArrayList<>();

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        contentValues.put("visibility", Integer.valueOf(this.visibility));
        contentValues.put("categoryType", Integer.valueOf(this.categoryType));
        Parcel obtain = Parcel.obtain();
        obtain.writeList(this.categoryCoverUrl);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(CATEGORY_COVER_URL, marshall);
        contentValues.put(CATEGORY_COUNTER, Integer.valueOf(this.categoryCounter));
        contentValues.put(CATEGORY_STATUS, Integer.valueOf(this.categoryStatus));
    }

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.b<PhotoCategoryControlInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhotoCategoryControlInfo createFromCursor(Cursor cursor) {
            PhotoCategoryControlInfo photoCategoryControlInfo = new PhotoCategoryControlInfo();
            photoCategoryControlInfo.uin = cursor.getLong(cursor.getColumnIndex("uin"));
            photoCategoryControlInfo.visibility = cursor.getInt(cursor.getColumnIndex("visibility"));
            photoCategoryControlInfo.categoryType = cursor.getInt(cursor.getColumnIndex("categoryType"));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(PhotoCategoryControlInfo.CATEGORY_COVER_URL));
            if (blob != null) {
                try {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    photoCategoryControlInfo.categoryCoverUrl = obtain.readArrayList(getClass().getClassLoader());
                    OaidMonitor.parcelRecycle(obtain);
                } catch (Exception e16) {
                    QZLog.w(e16);
                }
            }
            photoCategoryControlInfo.categoryCounter = cursor.getInt(cursor.getColumnIndex(PhotoCategoryControlInfo.CATEGORY_COUNTER));
            photoCategoryControlInfo.categoryStatus = cursor.getInt(cursor.getColumnIndex(PhotoCategoryControlInfo.CATEGORY_STATUS));
            return photoCategoryControlInfo;
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER"), new IDBCacheDataWrapper.c("visibility", "INTEGER"), new IDBCacheDataWrapper.c("categoryType", "INTEGER"), new IDBCacheDataWrapper.c(PhotoCategoryControlInfo.CATEGORY_COVER_URL, "BLOB"), new IDBCacheDataWrapper.c(PhotoCategoryControlInfo.CATEGORY_COUNTER, "INTEGER"), new IDBCacheDataWrapper.c(PhotoCategoryControlInfo.CATEGORY_STATUS, "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 0;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public int delRawSql(SQLiteDatabase sQLiteDatabase, String str, String str2) {
            String[] split;
            if (sQLiteDatabase == null) {
                return 0;
            }
            if (!TextUtils.isEmpty(str2) && str2.contains(ContainerUtils.KEY_VALUE_DELIMITER) && !str2.contains(" and ") && !str2.contains(" AND ") && !str2.contains(" or ") && !str2.contains(" OR ") && (split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split.length > 1 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                String trim = split[0].trim();
                String replace = split[1].trim().replace("'", "");
                if (!TextUtils.isEmpty(trim) && !TextUtils.isEmpty(replace)) {
                    return sQLiteDatabase.delete(str, trim + "=? ", new String[]{replace});
                }
            }
            return sQLiteDatabase.delete(str, str2, null);
        }
    }
}
