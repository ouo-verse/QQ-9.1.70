package com.qzone.common.business.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import v4.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BusinessContentCacheData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<BusinessContentCacheData> DB_CREATOR = new a();
    private static final int VERSION = 1;

    @NeedParcel
    private String content;

    @NeedParcel
    private int timestamp;

    @NeedParcel
    private long uin;

    @NeedParcel
    private String unikey;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<BusinessContentCacheData> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusinessContentCacheData createFromCursor(Cursor cursor) {
            BusinessContentCacheData businessContentCacheData = new BusinessContentCacheData();
            businessContentCacheData.setUin(cursor.getLong(cursor.getColumnIndex("uin")));
            businessContentCacheData.setTimestamp(cursor.getInt(cursor.getColumnIndex("timestamp")));
            businessContentCacheData.setUnikey(cursor.getString(cursor.getColumnIndex(b.UNIKEY)));
            businessContentCacheData.setContent(cursor.getString(cursor.getColumnIndex("content")));
            return businessContentCacheData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return "timestamp DESC";
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "STRING "), new IDBCacheDataWrapper.c("timestamp", "INTEGER"), new IDBCacheDataWrapper.c(b.UNIKEY, "TEXT"), new IDBCacheDataWrapper.c("content", "STRING ")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    public BusinessContentCacheData() {
    }

    public String getContent() {
        return this.content;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public long getUin() {
        return this.uin;
    }

    public String getUnikey() {
        return this.unikey;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setTimestamp(int i3) {
        this.timestamp = i3;
    }

    public void setUin(long j3) {
        this.uin = j3;
    }

    public void setUnikey(String str) {
        this.unikey = str;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.toString(this.uin));
        contentValues.put("timestamp", Integer.toString(this.timestamp));
        contentValues.put(b.UNIKEY, this.unikey);
        contentValues.put("content", this.content);
    }

    public BusinessContentCacheData(BusinessContentCacheData businessContentCacheData) {
        this.content = businessContentCacheData.getContent();
        this.unikey = businessContentCacheData.getUnikey();
        this.timestamp = businessContentCacheData.getTimestamp();
        this.uin = businessContentCacheData.getUin();
    }
}
