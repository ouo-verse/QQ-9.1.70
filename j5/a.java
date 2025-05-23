package j5;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.GpsInfo4LocalImage;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends com.qzone.component.cache.database.a {
    public static final IDBCacheDataWrapper.a<a> DB_CREATOR = new C10570a();
    public static final String GEOINFO = "geoinfo_v2";
    public static final String GEOINFO_TYPE = "BLOB";
    public static String GPSTYPE = "gpsType";
    public static String GPSTYPE_TYPE = "INTEGER";
    public static String LAONGTITUDE_TYPE = "FLOAT";
    public static String LATITUDE = "latitude";
    public static String LATITUDE_TYPE = "FLOAT";
    public static String LONGTITUDE = "longtitude";
    public static final String TIMESTAMP = "timestamp";
    public static final String TIMESTAMP_TYPE = "LONG";
    public static final String WEIGHT = "weight";
    public static final String WEIGHT_TYPE = "INTEGER";
    public LbsDataV2.GeoInfo geoInfo;
    public int gpstype;
    public float latitude;
    public float longtitude;
    public long timestamp;
    public int weight;

    /* compiled from: P */
    /* renamed from: j5.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10570a implements IDBCacheDataWrapper.a<a> {
        C10570a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromCursor(Cursor cursor) {
            float f16 = cursor.getFloat(cursor.getColumnIndex(a.LATITUDE));
            float f17 = cursor.getFloat(cursor.getColumnIndex(a.LONGTITUDE));
            int i3 = cursor.getInt(cursor.getColumnIndex(a.GPSTYPE));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(a.GEOINFO));
            long j3 = cursor.getLong(cursor.getColumnIndex("timestamp"));
            int i16 = cursor.getInt(cursor.getColumnIndex("weight"));
            a aVar = new a();
            aVar.latitude = f16;
            aVar.longtitude = f17;
            aVar.gpstype = i3;
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(blob, 0, blob.length);
            obtain.setDataPosition(0);
            aVar.geoInfo = (LbsDataV2.GeoInfo) obtain.readParcelable(LbsDataV2.GeoInfo.class.getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            aVar.timestamp = j3;
            aVar.weight = i16;
            return aVar;
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(a.LATITUDE, a.LATITUDE_TYPE), new IDBCacheDataWrapper.c(a.LONGTITUDE, a.LAONGTITUDE_TYPE), new IDBCacheDataWrapper.c(a.GPSTYPE, a.GPSTYPE_TYPE), new IDBCacheDataWrapper.c(a.GEOINFO, "BLOB"), new IDBCacheDataWrapper.c("timestamp", "LONG"), new IDBCacheDataWrapper.c("weight", "INTEGER")};
        }
    }

    public a() {
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(LATITUDE, Float.valueOf(this.latitude));
        contentValues.put(LONGTITUDE, Float.valueOf(this.longtitude));
        contentValues.put(GPSTYPE, Integer.valueOf(this.gpstype));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.writeParcelable(this.geoInfo, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(GEOINFO, marshall);
        contentValues.put("timestamp", Long.valueOf(this.timestamp));
        contentValues.put("weight", Integer.valueOf(this.weight));
    }

    public a(GpsInfo4LocalImage gpsInfo4LocalImage, LbsDataV2.GeoInfo geoInfo) {
        this.latitude = gpsInfo4LocalImage.latitude;
        this.longtitude = gpsInfo4LocalImage.longtitude;
        this.gpstype = gpsInfo4LocalImage.gpsType;
        this.geoInfo = geoInfo;
        this.timestamp = System.currentTimeMillis();
        this.weight = 0;
    }
}
