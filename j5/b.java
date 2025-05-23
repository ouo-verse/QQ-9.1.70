package j5;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.LbsDataV2;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends com.qzone.component.cache.database.a {
    public static String CELLID = "cellId";
    public static String CELLID_TYPE = "INTEGER";
    public static final IDBCacheDataWrapper.a<b> DB_CREATOR = new a();
    public static final String GEOINFO = "geoInfo_v2";
    public static final String GEOINFO_TYPE = "BLOB";
    public static String LAC = "lac";
    public static String LAC_TYPE = "INTEGER";
    public static String MCC = "mcc";
    public static String MCC_TYPE = "INTEGER";
    public static String MNC = "mnc";
    public static String MNC_TYPE = "INTEGER";
    public static final String TIMESTAMP = "timestamp";
    public static final String TIMESTAMP_TYPE = "LONG";
    public static final String WEIGHT = "weight";
    public static final String WEIGHT_TYPE = "INTEGER";
    public int cellId;
    public LbsDataV2.GetGeoInfoRsp geoInfoRsp;
    public int lac;
    public int mcc;
    public int mnc;
    public long timestamp;
    public int weight;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements IDBCacheDataWrapper.a<b> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromCursor(Cursor cursor) {
            int i3 = cursor.getInt(cursor.getColumnIndex(b.CELLID));
            int i16 = cursor.getInt(cursor.getColumnIndex(b.MCC));
            int i17 = cursor.getInt(cursor.getColumnIndex(b.MNC));
            int i18 = cursor.getInt(cursor.getColumnIndex(b.LAC));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(b.GEOINFO));
            long j3 = cursor.getLong(cursor.getColumnIndex("timestamp"));
            int i19 = cursor.getInt(cursor.getColumnIndex("weight"));
            b bVar = new b();
            bVar.cellId = i3;
            bVar.mcc = i16;
            bVar.mnc = i17;
            bVar.lac = i18;
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(blob, 0, blob.length);
            obtain.setDataPosition(0);
            bVar.geoInfoRsp = (LbsDataV2.GetGeoInfoRsp) obtain.readParcelable(LbsDataV2.GetGeoInfoRsp.class.getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            bVar.timestamp = j3;
            bVar.weight = i19;
            return bVar;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return "timestamp DESC";
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 101;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(b.CELLID, b.CELLID_TYPE), new IDBCacheDataWrapper.c(b.MCC, b.MCC_TYPE), new IDBCacheDataWrapper.c(b.MNC, b.MNC_TYPE), new IDBCacheDataWrapper.c(b.LAC, b.LAC_TYPE), new IDBCacheDataWrapper.c(b.GEOINFO, "BLOB"), new IDBCacheDataWrapper.c("timestamp", "LONG"), new IDBCacheDataWrapper.c("weight", "INTEGER")};
        }
    }

    public b() {
    }

    public boolean isGeoInfoValid() {
        return (TextUtils.isEmpty(this.geoInfoRsp.stGeoInfo.strCountry) && TextUtils.isEmpty(this.geoInfoRsp.stGeoInfo.strProvince) && TextUtils.isEmpty(this.geoInfoRsp.stGeoInfo.strCity) && TextUtils.isEmpty(this.geoInfoRsp.stGeoInfo.strDistrict)) ? false : true;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(CELLID, Integer.valueOf(this.cellId));
        contentValues.put(MCC, Integer.valueOf(this.mcc));
        contentValues.put(MNC, Integer.valueOf(this.mnc));
        contentValues.put(LAC, Integer.valueOf(this.lac));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.writeParcelable(this.geoInfoRsp, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(GEOINFO, marshall);
        contentValues.put("timestamp", Long.valueOf(this.timestamp));
        contentValues.put("weight", Integer.valueOf(this.weight));
    }

    public b(LbsDataV2.CellInfo cellInfo, LbsDataV2.GetGeoInfoRsp getGeoInfoRsp) {
        this.cellId = cellInfo.cellId;
        this.mcc = cellInfo.mcc;
        this.mnc = cellInfo.mnc;
        this.lac = cellInfo.lac;
        this.geoInfoRsp = getGeoInfoRsp;
        this.timestamp = System.currentTimeMillis();
        this.weight = 0;
    }
}
