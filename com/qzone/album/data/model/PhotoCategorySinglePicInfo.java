package com.qzone.album.data.model;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.PhotoFeedsData;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class PhotoCategorySinglePicInfo extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String ALBUM_ID = "albumId";
    public static final String CATEGORY_ID = "categoryId";
    public static final String CATEGORY_TYPE = "categoryType";
    public static final IDBCacheDataWrapper.a<PhotoCategorySinglePicInfo> DB_CREATOR = new a();
    public static final String HAS_MORE = "hasMore";
    public static final String LLOC = "lloc";
    public static final String OWNER = "owner";
    public static final String PAGE_STRING = "pageStr";
    public static final String SINGLE_PIC_INFO = "singlePicInfo";
    public static final String SLOC = "sloc";
    public static final String TYPE_ALBUM_ID = "TEXT";
    public static final String TYPE_CATEGORY_ID = "TEXT";
    public static final String TYPE_CATEGORY_TYPE = "INTEGER";
    public static final String TYPE_HAS_MORE = "INTEGER";
    public static final String TYPE_LLOC = "TEXT";
    public static final String TYPE_OWNER = "INTEGER";
    public static final String TYPE_PAGE_STRING = "TEXT";
    public static final String TYPE_SINGLE_PIC_INFO = "BLOB";
    public static final String TYPE_SLOC = "TEXT";
    public static final String TYPE_UIN = "INTEGER";
    public static final String TYPE_UPLOAD_TIME = "INTEGER";
    public static final String TYPE_USAGE_TYPE = "INTEGER";
    public static final String UIN = "uin";
    public static final String UPLOAD_TIME = "uploadTime";
    public static final String USAGE_TYPE = "usageType";

    @NeedParcel
    public String albumId;

    @NeedParcel
    public AlbumCacheData albumInfo;

    @NeedParcel
    public String categoryId;

    @NeedParcel
    public int categoryType;

    @NeedParcel
    public int hasMore;

    @NeedParcel
    public String lloc;

    @NeedParcel
    public long owner;

    @NeedParcel
    public String pageStr;

    @NeedParcel
    public PhotoCacheData singlePicInfo;

    @NeedParcel
    public String sloc;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public int uploadTime;

    @NeedParcel
    public int usageType;

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        contentValues.put(USAGE_TYPE, Integer.valueOf(this.usageType));
        contentValues.put("categoryType", Integer.valueOf(this.categoryType));
        contentValues.put("albumId", this.albumId);
        contentValues.put("categoryId", this.categoryId);
        contentValues.put(SLOC, this.sloc);
        contentValues.put("lloc", this.lloc);
        contentValues.put("owner", Long.valueOf(this.owner));
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain, 0, this.singlePicInfo);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(SINGLE_PIC_INFO, marshall);
        contentValues.put("hasMore", Integer.valueOf(this.hasMore));
        contentValues.put("pageStr", this.pageStr);
        contentValues.put(UPLOAD_TIME, Integer.valueOf(this.uploadTime));
    }

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.b<PhotoCategorySinglePicInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhotoCategorySinglePicInfo createFromCursor(Cursor cursor) {
            PhotoCategorySinglePicInfo photoCategorySinglePicInfo = new PhotoCategorySinglePicInfo();
            photoCategorySinglePicInfo.uin = cursor.getLong(cursor.getColumnIndex("uin"));
            photoCategorySinglePicInfo.usageType = cursor.getInt(cursor.getColumnIndex(PhotoCategorySinglePicInfo.USAGE_TYPE));
            photoCategorySinglePicInfo.categoryType = cursor.getInt(cursor.getColumnIndex("categoryType"));
            photoCategorySinglePicInfo.albumId = cursor.getString(cursor.getColumnIndex("albumId"));
            photoCategorySinglePicInfo.categoryId = cursor.getString(cursor.getColumnIndex("categoryId"));
            photoCategorySinglePicInfo.sloc = cursor.getString(cursor.getColumnIndex(PhotoCategorySinglePicInfo.SLOC));
            photoCategorySinglePicInfo.lloc = cursor.getString(cursor.getColumnIndex("lloc"));
            photoCategorySinglePicInfo.owner = cursor.getLong(cursor.getColumnIndex("owner"));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(PhotoCategorySinglePicInfo.SINGLE_PIC_INFO));
            if (blob != null) {
                try {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    photoCategorySinglePicInfo.singlePicInfo = (PhotoCacheData) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            photoCategorySinglePicInfo.hasMore = cursor.getInt(cursor.getColumnIndex("hasMore"));
            photoCategorySinglePicInfo.pageStr = cursor.getString(cursor.getColumnIndex("pageStr"));
            photoCategorySinglePicInfo.uploadTime = cursor.getInt(cursor.getColumnIndex(PhotoCategorySinglePicInfo.UPLOAD_TIME));
            return photoCategorySinglePicInfo;
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER"), new IDBCacheDataWrapper.c(PhotoCategorySinglePicInfo.USAGE_TYPE, "INTEGER"), new IDBCacheDataWrapper.c("categoryType", "INTEGER"), new IDBCacheDataWrapper.c("albumId", "TEXT"), new IDBCacheDataWrapper.c("categoryId", "TEXT"), new IDBCacheDataWrapper.c(PhotoCategorySinglePicInfo.SLOC, "TEXT"), new IDBCacheDataWrapper.c("lloc", "TEXT"), new IDBCacheDataWrapper.c("owner", "INTEGER"), new IDBCacheDataWrapper.c(PhotoCategorySinglePicInfo.SINGLE_PIC_INFO, "BLOB"), new IDBCacheDataWrapper.c("hasMore", "INTEGER"), new IDBCacheDataWrapper.c("pageStr", "TEXT"), new IDBCacheDataWrapper.c(PhotoCategorySinglePicInfo.UPLOAD_TIME, "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
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

    public static PhotoCategorySinglePicInfo createFrom(PhotoFeedsData photoFeedsData, long j3, int i3, int i16, String str, boolean z16, String str2) {
        if (photoFeedsData == null) {
            return null;
        }
        PhotoCategorySinglePicInfo photoCategorySinglePicInfo = new PhotoCategorySinglePicInfo();
        ArrayList<Photo> arrayList = photoFeedsData.photolist;
        Photo photo = (arrayList == null || arrayList.size() <= 0) ? null : photoFeedsData.photolist.get(0);
        photoCategorySinglePicInfo.singlePicInfo = PhotoCacheData.createFrom(photoFeedsData.album, photo, photoFeedsData.appid, photoFeedsData.pss_cell_id, photoFeedsData.pss_cell_comm, photoFeedsData.pss_cell_operation, photoFeedsData.pss_cell_like, photoFeedsData.pss_cell_comment, photo != null ? photo.share_info : null);
        photoCategorySinglePicInfo.uin = j3;
        photoCategorySinglePicInfo.usageType = i3;
        photoCategorySinglePicInfo.categoryType = i16;
        photoCategorySinglePicInfo.categoryId = str;
        photoCategorySinglePicInfo.hasMore = z16 ? 1 : 0;
        photoCategorySinglePicInfo.pageStr = str2;
        Album album = photoFeedsData.album;
        if (album != null) {
            photoCategorySinglePicInfo.albumId = album.albumid;
        }
        ArrayList<Photo> arrayList2 = photoFeedsData.photolist;
        if (arrayList2 != null && arrayList2.size() > 0 && photoFeedsData.photolist.get(0) != null) {
            photoCategorySinglePicInfo.sloc = photoFeedsData.photolist.get(0).sloc;
            photoCategorySinglePicInfo.lloc = photoFeedsData.photolist.get(0).lloc;
            photoCategorySinglePicInfo.owner = photoFeedsData.photolist.get(0).pic_host_nick.uin;
            photoCategorySinglePicInfo.uploadTime = photoFeedsData.photolist.get(0).uploadtime;
        }
        return photoCategorySinglePicInfo;
    }
}
