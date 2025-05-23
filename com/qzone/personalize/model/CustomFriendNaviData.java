package com.qzone.personalize.model;

import NS_QMALL_COVER.FeedNavi;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.b;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CustomFriendNaviData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final int COSTOM_FRIEND_NAVI_ID_NONE = -1;
    public static final String CUSTOM_FRIENDNAVI_DATA = "custom_firendnavi_data";
    public static final IDBCacheDataWrapper.a<CustomFriendNaviData> DB_CREATOR = new a();
    public static final String PARAM_CACHE_DATA = "CustomFriendNaviData";
    public static final String TYPE_CUSTOM_FRIENDNAVI_DATA = "BLOB";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 1;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public int iItemId = -1;

    @NeedParcel
    public String strFriendNaviDecoUrl = "";

    @NeedParcel
    public String stTextColor = "";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<CustomFriendNaviData> {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
        
            if (r0 != null) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        
            com.tencent.qmethod.pandoraex.monitor.OaidMonitor.parcelRecycle(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
        
            if (r0 == null) goto L12;
         */
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public CustomFriendNaviData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(CustomFriendNaviData.CUSTOM_FRIENDNAVI_DATA));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    CustomFriendNaviData customFriendNaviData = (CustomFriendNaviData) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                    return customFriendNaviData;
                } catch (Exception unused) {
                } catch (OutOfMemoryError unused2) {
                    b.i(CustomFriendNaviData.PARAM_CACHE_DATA, "CustomFriendNaviData createFromCursor Error");
                }
            } catch (Throwable th5) {
                if (obtain != null) {
                    OaidMonitor.parcelRecycle(obtain);
                }
                throw th5;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(CustomFriendNaviData.CUSTOM_FRIENDNAVI_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    private void readFromParcel(Parcel parcel) {
        this.uin = parcel.readLong();
        this.iItemId = parcel.readInt();
        this.strFriendNaviDecoUrl = parcel.readString();
        this.stTextColor = parcel.readString();
    }

    private void writeToParcel(Parcel parcel) {
        parcel.writeLong(this.uin);
        parcel.writeInt(this.iItemId);
        parcel.writeString(this.strFriendNaviDecoUrl);
        parcel.writeString(this.stTextColor);
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(CUSTOM_FRIENDNAVI_DATA, marshall);
    }

    public static CustomFriendNaviData createFromJce(long j3, FeedNavi feedNavi) {
        if (feedNavi == null) {
            return null;
        }
        CustomFriendNaviData customFriendNaviData = new CustomFriendNaviData();
        customFriendNaviData.uin = j3;
        customFriendNaviData.iItemId = feedNavi.iItemId;
        customFriendNaviData.strFriendNaviDecoUrl = feedNavi.strFeedNaviUrl;
        customFriendNaviData.stTextColor = feedNavi.strTextColor;
        return customFriendNaviData;
    }

    @Override // com.qzone.component.cache.database.a, com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void readFrom(ContentValues contentValues) {
    }
}
