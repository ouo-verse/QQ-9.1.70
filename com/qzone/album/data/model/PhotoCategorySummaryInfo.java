package com.qzone.album.data.model;

import NS_MOBILE_FEEDS.cell_lbs;
import NS_MOBILE_PHOTO.CategoryPhoto;
import NS_MOBILE_PHOTO.PhotoFeedsData;
import NS_MOBILE_PHOTO.SummaryInfo;
import NS_MOBILE_PHOTO.face_show_info;
import NS_MOBILE_PHOTO.label_show_info;
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
import photo_share_struct.uin_nick_info;

/* loaded from: classes39.dex */
public class PhotoCategorySummaryInfo extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String AVATAR_URL = "avatarUrl";
    public static final String CATEGORY_ID = "categoryId";
    public static final String CATEGORY_TYPE = "categoryType";
    public static final IDBCacheDataWrapper.a<PhotoCategorySummaryInfo> DB_CREATOR = new a();
    public static final String FACEUIN = "faceUin";
    public static final String FACE_STATUS = "faceStatus";
    public static final String GROUP_ID = "groupid_list";
    public static final String HAS_MORE = "hasMore";
    public static final String NICK = "nick";
    public static final String PAGE_STRING = "pageStr";
    public static final String PHOTO_NUMBER = "photoNumber";
    public static final String TYPE_AVATAR_URL = "TEXT";
    public static final String TYPE_CATEGORY_ID = "TEXT";
    public static final String TYPE_CATEGORY_TYPE = "INTEGER";
    public static final String TYPE_FACEUIN = "INTEGER";
    public static final String TYPE_FACE_STATUS = "INTEGER";
    public static final String TYPE_GROUP_ID = "BLOB";
    public static final String TYPE_HAS_MORE = "INTEGER";
    public static final String TYPE_NICK = "TEXT";
    public static final String TYPE_PAGE_STRING = "TEXT";
    public static final String TYPE_PHOTO_NUMBER = "INTEGER";
    public static final String TYPE_UIN = "INTEGER";
    public static final String UIN = "uin";

    @NeedParcel
    public String avatarUrl;

    @NeedParcel
    public String categoryId;

    @NeedParcel
    public int categoryType;

    @NeedParcel
    public int hasMore;

    @NeedParcel
    public String nick;

    @NeedParcel
    public String pageStr;

    @NeedParcel
    public long photoNumber;

    @NeedParcel
    public ArrayList<PhotoCategorySinglePicInfo> previewPhotos;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public int faceStatus = 0;

    @NeedParcel
    public ArrayList<String> groupid_list = new ArrayList<>();

    @NeedParcel
    public long faceUin = 0;
    public boolean needShow = false;

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        contentValues.put(PHOTO_NUMBER, Long.valueOf(this.photoNumber));
        contentValues.put("categoryType", Integer.valueOf(this.categoryType));
        contentValues.put("categoryId", this.categoryId);
        contentValues.put(AVATAR_URL, this.avatarUrl);
        contentValues.put(FACE_STATUS, Integer.valueOf(this.faceStatus));
        contentValues.put("nick", this.nick);
        contentValues.put("hasMore", Integer.valueOf(this.hasMore));
        contentValues.put("pageStr", this.pageStr);
        Parcel obtain = Parcel.obtain();
        obtain.writeList(this.groupid_list);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(GROUP_ID, marshall);
        contentValues.put(FACEUIN, Long.valueOf(this.faceUin));
    }

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.b<PhotoCategorySummaryInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhotoCategorySummaryInfo createFromCursor(Cursor cursor) {
            PhotoCategorySummaryInfo photoCategorySummaryInfo = new PhotoCategorySummaryInfo();
            photoCategorySummaryInfo.uin = cursor.getLong(cursor.getColumnIndex("uin"));
            photoCategorySummaryInfo.photoNumber = cursor.getLong(cursor.getColumnIndex(PhotoCategorySummaryInfo.PHOTO_NUMBER));
            photoCategorySummaryInfo.categoryType = cursor.getInt(cursor.getColumnIndex("categoryType"));
            photoCategorySummaryInfo.categoryId = cursor.getString(cursor.getColumnIndex("categoryId"));
            photoCategorySummaryInfo.avatarUrl = cursor.getString(cursor.getColumnIndex(PhotoCategorySummaryInfo.AVATAR_URL));
            photoCategorySummaryInfo.faceStatus = cursor.getInt(cursor.getColumnIndex(PhotoCategorySummaryInfo.FACE_STATUS));
            photoCategorySummaryInfo.nick = cursor.getString(cursor.getColumnIndex("nick"));
            photoCategorySummaryInfo.hasMore = cursor.getInt(cursor.getColumnIndex("hasMore"));
            photoCategorySummaryInfo.pageStr = cursor.getString(cursor.getColumnIndex("pageStr"));
            photoCategorySummaryInfo.faceUin = cursor.getLong(cursor.getColumnIndex(PhotoCategorySummaryInfo.FACEUIN));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(PhotoCategorySummaryInfo.GROUP_ID));
            if (blob != null) {
                try {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    photoCategorySummaryInfo.groupid_list = obtain.readArrayList(getClass().getClassLoader());
                    OaidMonitor.parcelRecycle(obtain);
                } catch (Exception e16) {
                    QZLog.w(e16);
                }
            }
            return photoCategorySummaryInfo;
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER"), new IDBCacheDataWrapper.c(PhotoCategorySummaryInfo.PHOTO_NUMBER, "INTEGER"), new IDBCacheDataWrapper.c("categoryType", "INTEGER"), new IDBCacheDataWrapper.c("categoryId", "TEXT"), new IDBCacheDataWrapper.c(PhotoCategorySummaryInfo.AVATAR_URL, "TEXT"), new IDBCacheDataWrapper.c(PhotoCategorySummaryInfo.FACE_STATUS, "INTEGER"), new IDBCacheDataWrapper.c("nick", "TEXT"), new IDBCacheDataWrapper.c("hasMore", "INTEGER"), new IDBCacheDataWrapper.c("pageStr", "TEXT"), new IDBCacheDataWrapper.c(PhotoCategorySummaryInfo.GROUP_ID, "BLOB"), new IDBCacheDataWrapper.c(PhotoCategorySummaryInfo.FACEUIN, "INTEGER")};
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

    public static PhotoCategorySummaryInfo createFrom(SummaryInfo summaryInfo, boolean z16, String str, long j3) {
        cell_lbs cell_lbsVar;
        face_show_info face_show_infoVar;
        uin_nick_info uin_nick_infoVar;
        ArrayList<PhotoFeedsData> arrayList;
        label_show_info label_show_infoVar;
        ArrayList<String> arrayList2;
        face_show_info face_show_infoVar2;
        ArrayList<String> arrayList3;
        label_show_info label_show_infoVar2;
        if (summaryInfo == null) {
            return null;
        }
        PhotoCategorySummaryInfo photoCategorySummaryInfo = new PhotoCategorySummaryInfo();
        photoCategorySummaryInfo.uin = j3;
        photoCategorySummaryInfo.avatarUrl = summaryInfo.url;
        photoCategorySummaryInfo.photoNumber = summaryInfo.photo_num;
        int i3 = summaryInfo.type;
        photoCategorySummaryInfo.categoryType = i3;
        photoCategorySummaryInfo.categoryId = summaryInfo.categoryid;
        photoCategorySummaryInfo.hasMore = z16 ? 1 : 0;
        photoCategorySummaryInfo.pageStr = str;
        if (i3 == 4 && (label_show_infoVar2 = summaryInfo.label_show) != null) {
            photoCategorySummaryInfo.nick = label_show_infoVar2.label;
        } else if (i3 == 1 && (face_show_infoVar = summaryInfo.face_show) != null && (uin_nick_infoVar = face_show_infoVar.pic_host) != null) {
            photoCategorySummaryInfo.nick = uin_nick_infoVar.nick;
            photoCategorySummaryInfo.faceUin = uin_nick_infoVar.uin;
            photoCategorySummaryInfo.faceStatus = face_show_infoVar.status;
        } else if (i3 == 2 && (cell_lbsVar = summaryInfo.poi_info) != null) {
            photoCategorySummaryInfo.nick = cell_lbsVar.location;
        }
        if (i3 == 1 && (face_show_infoVar2 = summaryInfo.face_show) != null && (arrayList3 = face_show_infoVar2.groupids) != null && arrayList3.size() > 0) {
            photoCategorySummaryInfo.groupid_list = summaryInfo.face_show.groupids;
        }
        if (summaryInfo.type == 4 && (label_show_infoVar = summaryInfo.label_show) != null && (arrayList2 = label_show_infoVar.labelids) != null && arrayList2.size() > 0) {
            photoCategorySummaryInfo.groupid_list = summaryInfo.label_show.labelids;
        }
        ArrayList<PhotoCategorySinglePicInfo> arrayList4 = new ArrayList<>();
        CategoryPhoto categoryPhoto = summaryInfo.preview_elements;
        if (categoryPhoto != null && (arrayList = categoryPhoto.photos) != null && arrayList.size() > 0) {
            for (int i16 = 0; i16 < summaryInfo.preview_elements.photos.size(); i16++) {
                arrayList4.add(PhotoCategorySinglePicInfo.createFrom(summaryInfo.preview_elements.photos.get(i16), photoCategorySummaryInfo.uin, 0, photoCategorySummaryInfo.categoryType, photoCategorySummaryInfo.categoryId, false, null));
            }
        }
        photoCategorySummaryInfo.previewPhotos = arrayList4;
        return photoCategorySummaryInfo;
    }
}
