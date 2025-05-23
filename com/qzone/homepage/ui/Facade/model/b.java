package com.qzone.homepage.ui.Facade.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends com.qzone.component.cache.database.a {
    public static final IDBCacheDataWrapper.a<b> DB_CREATOR = new a();
    public static final String IMAGE_URL = "image_url";
    public static final String IMAGE_URL_TYPE = "TEXT UNIQUE";
    public static final String TIME_STAMP = "timestamp";
    public static final String TIME_STAMP_TEYPE = "INTEGER";
    public String imageUrl;
    public long timeStamp;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<b> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromCursor(Cursor cursor) {
            b bVar = new b();
            bVar.timeStamp = cursor.getInt(cursor.getColumnIndex("timestamp"));
            bVar.imageUrl = cursor.getString(cursor.getColumnIndex("image_url"));
            return bVar;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("image_url", "TEXT UNIQUE"), new IDBCacheDataWrapper.c("timestamp", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    public b(long j3, String str) {
        this.timeStamp = j3;
        this.imageUrl = str;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("timestamp", Long.valueOf(this.timeStamp));
        contentValues.put("image_url", this.imageUrl);
    }

    public b() {
    }
}
