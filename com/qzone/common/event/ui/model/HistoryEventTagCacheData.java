package com.qzone.common.event.ui.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class HistoryEventTagCacheData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<HistoryEventTagCacheData> DB_CREATOR = new a();
    public static final String ID = "id";
    public static final String PIC_URL = "picUrl";
    public static final String TIME = "time";
    public static final String TITLE = "title";
    public static final String TYPE_ID = "TEXT";
    public static final String TYPE_PIC_URL = "TEXT";
    public static final String TYPE_TIME = "INTEGER";
    public static final String TYPE_TITLE = "TEXT";
    public static final String TYPE_UIN = "INTEGER";
    public static final String UIN = "uin";

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public long time = 0;

    @NeedParcel
    public String title = "";

    @NeedParcel
    public String picUrl = "";

    /* renamed from: id, reason: collision with root package name */
    @NeedParcel
    public String f45885id = "";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<HistoryEventTagCacheData> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HistoryEventTagCacheData createFromCursor(Cursor cursor) {
            HistoryEventTagCacheData historyEventTagCacheData = new HistoryEventTagCacheData();
            historyEventTagCacheData.uin = cursor.getInt(cursor.getColumnIndex("uin"));
            historyEventTagCacheData.time = cursor.getInt(cursor.getColumnIndex("time"));
            historyEventTagCacheData.title = cursor.getString(cursor.getColumnIndex("title"));
            historyEventTagCacheData.picUrl = cursor.getString(cursor.getColumnIndex("picUrl"));
            historyEventTagCacheData.f45885id = cursor.getString(cursor.getColumnIndex("id"));
            return historyEventTagCacheData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER"), new IDBCacheDataWrapper.c("time", "INTEGER"), new IDBCacheDataWrapper.c("title", "TEXT"), new IDBCacheDataWrapper.c("picUrl", "TEXT"), new IDBCacheDataWrapper.c("id", "TEXT")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 3;
        }
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        contentValues.put("time", Long.valueOf(this.time));
        contentValues.put("title", this.title);
        contentValues.put("picUrl", this.picUrl);
        contentValues.put("id", this.f45885id);
    }
}
