package com.qzone.album.data.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.heytap.databaseengine.utils.DateUtil;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes39.dex */
public class FacePhotoCacheData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static String COLUMN_FACEARRAY = "FACEARRAY";
    public static String COLUMN_FACECOUNT = "FACECOUNT";
    public static String COLUMN_NETWORKCONNECTED = "CONNECTED";
    public static String COLUMN_PHOTOCOUNT = "PHOTOCOUNT";
    public static String COLUMN_STARTDATE = "STARTDATE";
    public static String COLUMN_UNIKEY = "UNIKEY";
    public static String CONNECTED_TYPE = "BOOLEAN";
    public static IDBCacheDataWrapper.a<FacePhotoCacheData> DB_CREATOR = new a();
    private static final int DB_VERSION = 5;
    public static String FACEARRAY_TYPE = "BLOB";
    public static String FACECOUNT_TYPE = "INTEGER";
    public static String PHOTOCOUNT_TYPE = "INTEGER";
    public static String STARTDATE_TYPE = "LONG";
    public static String UNIKEY_TYPE = "TEXT";

    @NeedParcel
    public int faceCount;

    @NeedParcel
    public boolean isConnected;

    @NeedParcel
    public ArrayList<SharingAlbumClientAttr> mShareUserUinList;

    @NeedParcel
    public long mStartDate = Long.parseLong(new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date()));

    @NeedParcel
    public String mUniKey;

    @NeedParcel
    public int photoCount;

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<FacePhotoCacheData> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FacePhotoCacheData createFromCursor(Cursor cursor) {
            FacePhotoCacheData facePhotoCacheData = new FacePhotoCacheData();
            facePhotoCacheData.mUniKey = cursor.getString(cursor.getColumnIndex(FacePhotoCacheData.COLUMN_UNIKEY));
            facePhotoCacheData.faceCount = cursor.getInt(cursor.getColumnIndex(FacePhotoCacheData.COLUMN_FACECOUNT));
            facePhotoCacheData.photoCount = cursor.getInt(cursor.getColumnIndex(FacePhotoCacheData.COLUMN_PHOTOCOUNT));
            facePhotoCacheData.mStartDate = cursor.getLong(cursor.getColumnIndex(FacePhotoCacheData.COLUMN_STARTDATE));
            facePhotoCacheData.isConnected = cursor.getInt(cursor.getColumnIndex(FacePhotoCacheData.COLUMN_NETWORKCONNECTED)) == 1;
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    byte[] blob = cursor.getBlob(cursor.getColumnIndex(FacePhotoCacheData.COLUMN_FACEARRAY));
                    if (blob != null) {
                        obtain.unmarshall(blob, 0, blob.length);
                        obtain.setDataPosition(0);
                        facePhotoCacheData.mShareUserUinList = ParcelableWrapper.createArrayListFromParcel(obtain);
                    }
                } catch (Exception e16) {
                    j.k(e16);
                }
                return facePhotoCacheData;
            } finally {
                OaidMonitor.parcelRecycle(obtain);
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return FacePhotoCacheData.COLUMN_STARTDATE + " DESC";
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(FacePhotoCacheData.COLUMN_UNIKEY, FacePhotoCacheData.UNIKEY_TYPE), new IDBCacheDataWrapper.c(FacePhotoCacheData.COLUMN_FACECOUNT, FacePhotoCacheData.FACECOUNT_TYPE), new IDBCacheDataWrapper.c(FacePhotoCacheData.COLUMN_PHOTOCOUNT, FacePhotoCacheData.PHOTOCOUNT_TYPE), new IDBCacheDataWrapper.c(FacePhotoCacheData.COLUMN_STARTDATE, FacePhotoCacheData.STARTDATE_TYPE), new IDBCacheDataWrapper.c(FacePhotoCacheData.COLUMN_FACEARRAY, FacePhotoCacheData.FACEARRAY_TYPE), new IDBCacheDataWrapper.c(FacePhotoCacheData.COLUMN_NETWORKCONNECTED, FacePhotoCacheData.CONNECTED_TYPE)};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 5;
        }
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(COLUMN_UNIKEY, this.mUniKey);
        contentValues.put(COLUMN_FACECOUNT, Integer.valueOf(this.faceCount));
        contentValues.put(COLUMN_STARTDATE, Long.valueOf(this.mStartDate));
        contentValues.put(COLUMN_NETWORKCONNECTED, Boolean.valueOf(this.isConnected));
        contentValues.put(COLUMN_PHOTOCOUNT, Integer.valueOf(this.photoCount));
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeArrayListToParcel(obtain, 0, this.mShareUserUinList);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(COLUMN_FACEARRAY, marshall);
    }
}
