package com.qzone.business.lbsv2.business.entity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.LbsDataV2;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class PoiListCacheRecord extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String CURRPOI = "currPoi";
    public static final String CURRPOI_TYPE = "text";
    public static final IDBCacheDataWrapper.a<PoiListCacheRecord> DB_CREATOR = new a();
    public static String GPS = "gps";
    public static String GPS_TYPE = "text unique";
    public static final String POILIST = "poiList";
    public static final String POILIST_ATTACHINFO = "poiList_attachinfo";
    public static final String POILIST_ATTACHINFO_TYPE = "text";
    public static final String POILIST_TYPE = "text";
    public static final String TIMESTAMP = "timestamp1";
    public static final String TIMESTAMP_TYPE = "long";
    private static final int VERSION = 101;
    public static final String WEIGHT = "weight";
    public static final String WEIGHT_TYPE = "int";

    @NeedParcel
    public LbsDataV2.GetGeoInfoRsp geoInfoRsp;

    @NeedParcel
    public LbsDataV2.GpsInfo gps;

    @NeedParcel
    public String poiAttachInfo;

    @NeedParcel
    public ArrayList<LbsDataV2.PoiInfo> poiList;

    @NeedParcel
    public long timestamp;

    @NeedParcel
    public int weight;

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<PoiListCacheRecord> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiListCacheRecord createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(PoiListCacheRecord.POILIST));
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(blob, 0, blob.length);
            obtain.setDataPosition(0);
            PoiListCacheRecord poiListCacheRecord = (PoiListCacheRecord) ParcelableWrapper.createDataFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            return poiListCacheRecord;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 101;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(PoiListCacheRecord.GPS, PoiListCacheRecord.GPS_TYPE), new IDBCacheDataWrapper.c(PoiListCacheRecord.POILIST, "text"), new IDBCacheDataWrapper.c(PoiListCacheRecord.POILIST_ATTACHINFO, "text"), new IDBCacheDataWrapper.c(PoiListCacheRecord.CURRPOI, "text"), new IDBCacheDataWrapper.c("weight", PoiListCacheRecord.WEIGHT_TYPE), new IDBCacheDataWrapper.c(PoiListCacheRecord.TIMESTAMP, PoiListCacheRecord.TIMESTAMP_TYPE)};
        }
    }

    public PoiListCacheRecord(LbsDataV2.GpsInfo gpsInfo, ArrayList<LbsDataV2.PoiInfo> arrayList, String str) {
        this.gps = gpsInfo;
        this.poiList = arrayList;
        this.poiAttachInfo = str;
        this.weight = 0;
        this.timestamp = System.currentTimeMillis();
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(POILIST, marshall);
    }

    public PoiListCacheRecord() {
    }
}
