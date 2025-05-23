package com.qzone.personalize.model;

import NS_QMALL_COVER.QzmallCustomPlayer;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.b;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes39.dex */
public class CustomPlayerData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String CUSTOM_PLAYER_DATA = "custom_player_data";
    public static final IDBCacheDataWrapper.a<CustomPlayerData> DB_CREATOR = new a();
    public static final String TYPE_CUSTOM_PLAYER_DATA = "BLOB";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 1;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public int iItemId = -1;

    @NeedParcel
    public String strPlayerDecoUrl = "";

    @NeedParcel
    public long lTextColor = 0;

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<CustomPlayerData> {
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
        public CustomPlayerData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(CustomPlayerData.CUSTOM_PLAYER_DATA));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    CustomPlayerData customPlayerData = (CustomPlayerData) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                    return customPlayerData;
                } catch (Exception unused) {
                } catch (OutOfMemoryError unused2) {
                    b.i("CustomPlayerData", "CustomPlayerData createFromCursor Error");
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(CustomPlayerData.CUSTOM_PLAYER_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    private void readFromParcel(Parcel parcel) {
        this.uin = parcel.readLong();
        this.iItemId = parcel.readInt();
        this.strPlayerDecoUrl = parcel.readString();
        this.lTextColor = parcel.readLong();
    }

    private void writeToParcel(Parcel parcel) {
        parcel.writeLong(this.uin);
        parcel.writeInt(this.iItemId);
        parcel.writeString(this.strPlayerDecoUrl);
        parcel.writeLong(this.lTextColor);
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(CUSTOM_PLAYER_DATA, marshall);
    }

    public static CustomPlayerData createFromJce(long j3, QzmallCustomPlayer qzmallCustomPlayer) {
        if (qzmallCustomPlayer == null) {
            return null;
        }
        CustomPlayerData customPlayerData = new CustomPlayerData();
        customPlayerData.uin = j3;
        customPlayerData.iItemId = qzmallCustomPlayer.iItemId;
        customPlayerData.strPlayerDecoUrl = qzmallCustomPlayer.strPlayerDecoUrl;
        customPlayerData.lTextColor = qzmallCustomPlayer.lTextColor;
        return customPlayerData;
    }

    @Override // com.qzone.component.cache.database.a, com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void readFrom(ContentValues contentValues) {
    }
}
