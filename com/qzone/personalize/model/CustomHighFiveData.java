package com.qzone.personalize.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CustomHighFiveData extends com.qzone.component.cache.database.a implements Parcelable {
    public static final String COLUMN_ITEM_ID = "item_id";
    public static final String COLUMN_ITEM_TEXT = "item_text";
    public static final String COLUMN_ITEM_URL = "item_url";
    public static final Parcelable.Creator<CustomHighFiveData> CREATOR = new a();
    public static IDBCacheDataWrapper.a<CustomHighFiveData> DB_CREATOR = new b();
    public static final String TYPE_COLUMN_ITEM_ID = "INTEGER";
    public static final String TYPE_COLUMN_ITEM_TEXT = "STRING";
    public static final String TYPE_COLUMN_ITEM_URL = "STRING";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 2;

    @NeedParcel
    public int itemId;

    @NeedParcel
    public String strHighFiveResUrl;

    @NeedParcel
    public String strHighFiveText;

    @NeedParcel
    public long uin;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements Parcelable.Creator<CustomHighFiveData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CustomHighFiveData createFromParcel(Parcel parcel) {
            return new CustomHighFiveData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CustomHighFiveData[] newArray(int i3) {
            return new CustomHighFiveData[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements IDBCacheDataWrapper.a<CustomHighFiveData> {
        b() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CustomHighFiveData createFromCursor(Cursor cursor) {
            CustomHighFiveData customHighFiveData = new CustomHighFiveData();
            customHighFiveData.uin = cursor.getInt(cursor.getColumnIndex("uin"));
            customHighFiveData.itemId = cursor.getInt(cursor.getColumnIndex("item_id"));
            customHighFiveData.strHighFiveResUrl = cursor.getString(cursor.getColumnIndex(CustomHighFiveData.COLUMN_ITEM_URL));
            customHighFiveData.strHighFiveText = cursor.getString(cursor.getColumnIndex(CustomHighFiveData.COLUMN_ITEM_TEXT));
            return customHighFiveData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("item_id", "INTEGER"), new IDBCacheDataWrapper.c(CustomHighFiveData.COLUMN_ITEM_URL, "STRING"), new IDBCacheDataWrapper.c(CustomHighFiveData.COLUMN_ITEM_TEXT, "STRING")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 2;
        }
    }

    public CustomHighFiveData() {
        this.uin = 0L;
        this.itemId = -1;
        this.strHighFiveResUrl = "";
        this.strHighFiveText = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!TextUtils.isEmpty(this.strHighFiveResUrl) && obj != null && (obj instanceof CustomHighFiveData)) {
            CustomHighFiveData customHighFiveData = (CustomHighFiveData) obj;
            if (customHighFiveData.uin == this.uin && customHighFiveData.itemId == this.itemId && this.strHighFiveResUrl.equals(customHighFiveData.strHighFiveResUrl)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        contentValues.put("item_id", Integer.valueOf(this.itemId));
        contentValues.put(COLUMN_ITEM_URL, this.strHighFiveResUrl);
        contentValues.put(COLUMN_ITEM_TEXT, this.strHighFiveText);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.uin);
        parcel.writeInt(this.itemId);
        parcel.writeString(this.strHighFiveResUrl);
        parcel.writeString(this.strHighFiveText);
    }

    protected CustomHighFiveData(Parcel parcel) {
        this.uin = 0L;
        this.itemId = -1;
        this.strHighFiveResUrl = "";
        this.strHighFiveText = "";
        this.uin = parcel.readLong();
        this.itemId = parcel.readInt();
        this.strHighFiveResUrl = parcel.readString();
        this.strHighFiveText = parcel.readString();
    }
}
