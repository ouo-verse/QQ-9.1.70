package com.qzone.album.data.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.io.Serializable;

/* loaded from: classes39.dex */
public class PicContInfoCacheData extends com.qzone.component.cache.database.a implements Serializable, SmartParcelable {
    public static final String ALBUMID = "albumid";
    public static final IDBCacheDataWrapper.a<PicContInfoCacheData> DB_CREATOR = new a();
    public static final String MD5 = "md5";
    public static final String SIZE = "size";
    public static final String TYPE_ALBUMID = "TEXT";
    public static final String TYPE_MD5 = "TEXT";
    public static final String TYPE_SIZE = "INTEGER";
    public static final String TYPE_URL = "TEXT UNIQUE";
    public static final String URL = "url";

    @NeedParcel
    public String albumid;

    @NeedParcel
    public String md5;

    @NeedParcel
    public long size;

    @NeedParcel
    public String url;

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.b<PicContInfoCacheData> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PicContInfoCacheData createFromCursor(Cursor cursor) {
            PicContInfoCacheData picContInfoCacheData = new PicContInfoCacheData();
            picContInfoCacheData.albumid = cursor.getString(cursor.getColumnIndex("albumid"));
            picContInfoCacheData.url = cursor.getString(cursor.getColumnIndex("url"));
            picContInfoCacheData.md5 = cursor.getString(cursor.getColumnIndex("md5"));
            picContInfoCacheData.size = cursor.getInt(cursor.getColumnIndex("size"));
            return picContInfoCacheData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public int delRawSql(SQLiteDatabase sQLiteDatabase, String str, String str2) {
            return 0;
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("albumid", "TEXT"), new IDBCacheDataWrapper.c("url", "TEXT UNIQUE"), new IDBCacheDataWrapper.c("md5", "TEXT"), new IDBCacheDataWrapper.c("size", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    public String toString() {
        return "PicContInfoCacheData{albumid='" + this.albumid + "', url='" + this.url + "', md5='" + this.md5 + "', size=" + this.size + '}';
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("albumid", this.albumid);
        contentValues.put("url", this.url);
        contentValues.put("md5", this.md5);
        contentValues.put("size", Long.valueOf(this.size));
    }
}
