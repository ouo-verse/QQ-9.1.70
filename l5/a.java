package l5;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends com.qzone.component.cache.database.a {
    public static final IDBCacheDataWrapper.a<a> DB_CREATOR = new C10706a();
    public String businessURL;
    public long cacheTime;
    public long endTime;
    public String imageUrl;
    public long openBusiness;
    public long openPhotoCarousel;
    public long startTime;
    public String textPhoto;
    public String textShuoshuo;
    public String textVideo;

    public boolean isEmpty() {
        return isMoodTextEmpty() && isPhotoTextEmpty() && isVideoTextEmpty();
    }

    public boolean isMoodTextEmpty() {
        return TextUtils.isEmpty(this.textShuoshuo);
    }

    public boolean isPhotoTextEmpty() {
        return TextUtils.isEmpty(this.textPhoto);
    }

    public boolean isVideoTextEmpty() {
        return TextUtils.isEmpty(this.textVideo);
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("cacheTime", Long.valueOf(this.cacheTime));
        contentValues.put("textShuoshuo", this.textShuoshuo);
        contentValues.put("textPhoto", this.textPhoto);
        contentValues.put("textVideo", this.textVideo);
        contentValues.put("startTime", Long.valueOf(this.startTime));
        contentValues.put("endTime", Long.valueOf(this.endTime));
        contentValues.put("openBusiness", Long.valueOf(this.openBusiness));
        contentValues.put("businessURL", this.businessURL);
        contentValues.put("imageUrl", this.imageUrl);
        contentValues.put("openPhotoCarousel", Long.valueOf(this.openPhotoCarousel));
    }

    public boolean isCacheExpired(long j3) {
        return j3 / 1000 > this.endTime;
    }

    public boolean isCurrentTimeValid(long j3) {
        long j16 = j3 / 1000;
        return j16 > this.startTime && j16 < this.endTime;
    }

    /* compiled from: P */
    /* renamed from: l5.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10706a implements IDBCacheDataWrapper.a<a> {
        C10706a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("cacheTime", "LONG"), new IDBCacheDataWrapper.c("textShuoshuo", "TEXT"), new IDBCacheDataWrapper.c("textPhoto", "TEXT"), new IDBCacheDataWrapper.c("textVideo", "TEXT"), new IDBCacheDataWrapper.c("startTime", "LONG"), new IDBCacheDataWrapper.c("endTime", "LONG"), new IDBCacheDataWrapper.c("openBusiness", "LONG"), new IDBCacheDataWrapper.c("businessURL", "TEXT"), new IDBCacheDataWrapper.c("imageUrl", "TEXT"), new IDBCacheDataWrapper.c("openPhotoCarousel", "LONG")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 2;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromCursor(Cursor cursor) {
            if (cursor == null) {
                return null;
            }
            a aVar = new a();
            aVar.cacheTime = cursor.getLong(cursor.getColumnIndex("cacheTime"));
            aVar.textShuoshuo = cursor.getString(cursor.getColumnIndex("textShuoshuo"));
            aVar.textPhoto = cursor.getString(cursor.getColumnIndex("textPhoto"));
            aVar.textVideo = cursor.getString(cursor.getColumnIndex("textVideo"));
            aVar.startTime = cursor.getLong(cursor.getColumnIndex("startTime"));
            aVar.endTime = cursor.getLong(cursor.getColumnIndex("endTime"));
            aVar.openBusiness = cursor.getLong(cursor.getColumnIndex("openBusiness"));
            aVar.businessURL = cursor.getString(cursor.getColumnIndex("businessURL"));
            aVar.imageUrl = cursor.getString(cursor.getColumnIndex("imageUrl"));
            aVar.openPhotoCarousel = cursor.getLong(cursor.getColumnIndex("openPhotoCarousel"));
            return aVar;
        }
    }
}
