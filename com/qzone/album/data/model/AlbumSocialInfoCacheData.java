package com.qzone.album.data.model;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.get_album_rsp;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;
import photo_share_struct.PublicShareData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumSocialInfoCacheData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String ALBUMCOVER = "albumcover";
    public static final String ALBUMDESC = "albumdesc";
    public static final String ALBUMID = "albumid";
    public static final String ALBUMNAME = "albumname";
    public static final String ALBUMTYPE = "albumtype";
    public static final String ALBUM_COMMENT_NUM = "album_comment_num";
    public static final String ALBUM_FACE_NUM = "album_face_num";
    public static final String ALBUM_IS_LIKED = "album_is_liked";
    public static final String ALBUM_LIKE_KEY = "album_like_key";
    public static final String ALBUM_LIKE_NUM = "album_like_num";
    public static final String ALBUM_LOGIN_UIN = "album_login_uin";
    public static final String ALBUM_PUBLIC_SHARE_DATA = "album_public_share_data";
    public static final String ALBUM_RECOMMEND_TYPE = "album_recommend_type";
    public static final String ALBUM_VISIT_NUM = "album_visit_num";
    public static final IDBCacheDataWrapper.a<AlbumSocialInfoCacheData> DB_CREATOR = new a();
    public static final String TYPE_ALBUMCOVER = "TEXT";
    public static final String TYPE_ALBUMDESC = "TEXT";
    public static final String TYPE_ALBUMID = "TEXT UNIQUE";
    public static final String TYPE_ALBUMNAME = "TEXT";
    public static final String TYPE_ALBUMTYPE = "INTEGER";
    public static final String TYPE_ALBUM_COMMENT_NUM = "INTEGER";
    public static final String TYPE_ALBUM_FACE_NUM = "INTEGER";
    public static final String TYPE_ALBUM_IS_LIKED = "BOOLEAN";
    public static final String TYPE_ALBUM_LIKE_KEY = "TEXT";
    public static final String TYPE_ALBUM_LIKE_NUM = "INTEGER";
    public static final String TYPE_ALBUM_LOGIN_UIN = "INTEGER";
    public static final String TYPE_ALBUM_PUBLIC_SHARE_DATA = "BLOB";
    public static final String TYPE_ALBUM_RECOMMEND_TYPE = "INTEGER";
    public static final String TYPE_ALBUM_VISIT_NUM = "INTEGER";

    @NeedParcel
    public int albumFaceNum;

    @NeedParcel
    public String albumLikeKey;

    @NeedParcel
    public int albumLikeNum;

    @NeedParcel
    public int albumRecommendType;

    @NeedParcel
    public int albumType;

    @NeedParcel
    public int albumVisitNum;

    @NeedParcel
    public String albumdesc;

    @NeedParcel
    public String albumid;

    @NeedParcel
    public String albumname;

    @NeedParcel
    public String bigCoverUrl;

    @NeedParcel
    public int commentNum;

    @NeedParcel
    public long loginUin;

    @NeedParcel
    public boolean isLiked = false;

    @NeedParcel
    public PublicShareCacheData albumPublicShareData = null;

    @NeedParcel
    public boolean isCoverUserSet = false;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<AlbumSocialInfoCacheData> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AlbumSocialInfoCacheData createFromCursor(Cursor cursor) {
            byte[] blob;
            AlbumSocialInfoCacheData albumSocialInfoCacheData = new AlbumSocialInfoCacheData();
            int columnIndex = cursor.getColumnIndex("albumid");
            if (columnIndex >= 0) {
                albumSocialInfoCacheData.albumid = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("albumname");
            if (columnIndex2 >= 0) {
                albumSocialInfoCacheData.albumname = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("albumdesc");
            if (columnIndex3 >= 0) {
                albumSocialInfoCacheData.albumdesc = cursor.getString(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex(AlbumSocialInfoCacheData.ALBUMCOVER);
            if (columnIndex4 >= 0) {
                albumSocialInfoCacheData.bigCoverUrl = cursor.getString(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex(AlbumSocialInfoCacheData.ALBUM_FACE_NUM);
            if (columnIndex5 >= 0) {
                albumSocialInfoCacheData.albumFaceNum = cursor.getInt(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex(AlbumSocialInfoCacheData.ALBUM_LIKE_NUM);
            if (columnIndex6 >= 0) {
                albumSocialInfoCacheData.albumLikeNum = cursor.getInt(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex(AlbumSocialInfoCacheData.ALBUM_LIKE_KEY);
            if (columnIndex7 >= 0) {
                albumSocialInfoCacheData.albumLikeKey = cursor.getString(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex(AlbumSocialInfoCacheData.ALBUM_VISIT_NUM);
            if (columnIndex8 >= 0) {
                albumSocialInfoCacheData.albumVisitNum = cursor.getInt(columnIndex8);
            }
            int columnIndex9 = cursor.getColumnIndex(AlbumSocialInfoCacheData.ALBUM_LOGIN_UIN);
            if (columnIndex9 >= 0) {
                albumSocialInfoCacheData.loginUin = cursor.getLong(columnIndex9);
            }
            int columnIndex10 = cursor.getColumnIndex(AlbumSocialInfoCacheData.ALBUM_IS_LIKED);
            if (columnIndex10 >= 0) {
                albumSocialInfoCacheData.isLiked = cursor.getInt(columnIndex10) == 1;
            }
            int columnIndex11 = cursor.getColumnIndex(AlbumSocialInfoCacheData.ALBUM_COMMENT_NUM);
            if (columnIndex11 >= 0) {
                albumSocialInfoCacheData.commentNum = cursor.getInt(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex("albumtype");
            if (columnIndex12 >= 0) {
                albumSocialInfoCacheData.albumType = cursor.getInt(columnIndex12);
            }
            int columnIndex13 = cursor.getColumnIndex(AlbumSocialInfoCacheData.ALBUM_PUBLIC_SHARE_DATA);
            if (columnIndex13 >= 0 && (blob = cursor.getBlob(columnIndex13)) != null) {
                try {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    albumSocialInfoCacheData.albumPublicShareData = (PublicShareCacheData) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                } catch (Exception e16) {
                    QZLog.w(e16);
                }
            }
            return albumSocialInfoCacheData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("albumid", "TEXT UNIQUE"), new IDBCacheDataWrapper.c("albumname", "TEXT"), new IDBCacheDataWrapper.c("albumdesc", "TEXT"), new IDBCacheDataWrapper.c(AlbumSocialInfoCacheData.ALBUMCOVER, "TEXT"), new IDBCacheDataWrapper.c(AlbumSocialInfoCacheData.ALBUM_FACE_NUM, "INTEGER"), new IDBCacheDataWrapper.c(AlbumSocialInfoCacheData.ALBUM_LIKE_NUM, "INTEGER"), new IDBCacheDataWrapper.c(AlbumSocialInfoCacheData.ALBUM_LIKE_KEY, "TEXT"), new IDBCacheDataWrapper.c(AlbumSocialInfoCacheData.ALBUM_VISIT_NUM, "INTEGER"), new IDBCacheDataWrapper.c(AlbumSocialInfoCacheData.ALBUM_LOGIN_UIN, "INTEGER"), new IDBCacheDataWrapper.c(AlbumSocialInfoCacheData.ALBUM_IS_LIKED, AlbumSocialInfoCacheData.TYPE_ALBUM_IS_LIKED), new IDBCacheDataWrapper.c(AlbumSocialInfoCacheData.ALBUM_COMMENT_NUM, "INTEGER"), new IDBCacheDataWrapper.c("albumtype", "INTEGER"), new IDBCacheDataWrapper.c(AlbumSocialInfoCacheData.ALBUM_PUBLIC_SHARE_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 4;
        }
    }

    public String getLloc() {
        return this.bigCoverUrl;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("albumid", this.albumid);
        contentValues.put("albumname", this.albumname);
        contentValues.put("albumdesc", this.albumdesc);
        contentValues.put(ALBUMCOVER, this.bigCoverUrl);
        contentValues.put(ALBUM_FACE_NUM, Integer.valueOf(this.albumFaceNum));
        contentValues.put(ALBUM_LIKE_NUM, Integer.valueOf(this.albumLikeNum));
        contentValues.put(ALBUM_LIKE_KEY, this.albumLikeKey);
        contentValues.put(ALBUM_VISIT_NUM, Integer.valueOf(this.albumVisitNum));
        contentValues.put(ALBUM_LOGIN_UIN, Long.valueOf(this.loginUin));
        contentValues.put(ALBUM_IS_LIKED, Boolean.valueOf(this.isLiked));
        contentValues.put(ALBUM_COMMENT_NUM, Integer.valueOf(this.commentNum));
        contentValues.put("albumtype", Integer.valueOf(this.albumType));
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain, 0, this.albumPublicShareData);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(ALBUM_PUBLIC_SHARE_DATA, marshall);
    }

    public static AlbumSocialInfoCacheData createFromResponse(get_album_rsp get_album_rspVar) {
        Album album;
        String trim;
        if (get_album_rspVar != null && (album = get_album_rspVar.album) != null) {
            AlbumSocialInfoCacheData albumSocialInfoCacheData = new AlbumSocialInfoCacheData();
            albumSocialInfoCacheData.albumid = album.albumid;
            albumSocialInfoCacheData.albumname = album.name;
            String str = album.desc;
            if (str == null) {
                trim = "";
            } else {
                trim = str.trim();
            }
            albumSocialInfoCacheData.albumdesc = trim;
            String str2 = get_album_rspVar.largeCoverUrl;
            albumSocialInfoCacheData.bigCoverUrl = str2;
            if (TextUtils.isEmpty(str2)) {
                albumSocialInfoCacheData.bigCoverUrl = album.coverurl;
            }
            albumSocialInfoCacheData.albumFaceNum = get_album_rspVar.albumFaceNum;
            albumSocialInfoCacheData.albumLikeNum = get_album_rspVar.albumLikeNum;
            albumSocialInfoCacheData.albumLikeKey = get_album_rspVar.albumLikekey;
            albumSocialInfoCacheData.albumVisitNum = get_album_rspVar.albumVisitNum;
            albumSocialInfoCacheData.loginUin = LoginData.getInstance().getUin();
            albumSocialInfoCacheData.isLiked = get_album_rspVar.isMyLiked;
            albumSocialInfoCacheData.commentNum = get_album_rspVar.albumCommentNum;
            albumSocialInfoCacheData.albumType = album.type;
            albumSocialInfoCacheData.isCoverUserSet = get_album_rspVar.isCoverUserSet;
            albumSocialInfoCacheData.albumRecommendType = album.recommend_album_type;
            if (get_album_rspVar.public_share_data != null) {
                PublicShareCacheData publicShareCacheData = new PublicShareCacheData();
                PublicShareData publicShareData = get_album_rspVar.public_share_data;
                publicShareCacheData.cover = publicShareData.cover;
                publicShareCacheData.desc = publicShareData.desc;
                publicShareCacheData.h5url = publicShareData.h5url;
                publicShareCacheData.schema = publicShareData.schema;
                albumSocialInfoCacheData.albumPublicShareData = publicShareCacheData;
            }
            return albumSocialInfoCacheData;
        }
        return new AlbumSocialInfoCacheData();
    }
}
