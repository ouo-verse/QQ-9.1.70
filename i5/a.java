package i5;

import LBS_V2_PROTOCOL.GeoInfoCell_V2;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import n7.a;
import u5.d;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    private static final Object f407217g = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static a f407218h;

    /* renamed from: a, reason: collision with root package name */
    private j5.a f407219a;

    /* renamed from: b, reason: collision with root package name */
    private j5.b f407220b;

    /* renamed from: c, reason: collision with root package name */
    private final C10502a f407221c = new C10502a("QZoneLbsBatchGeoCacheV2", j5.a.class);

    /* renamed from: d, reason: collision with root package name */
    private final C10502a f407222d = new C10502a("QZoneLbsGeoCacheV2", j5.b.class);

    /* renamed from: e, reason: collision with root package name */
    private String f407223e = null;

    /* renamed from: f, reason: collision with root package name */
    private LbsDataV2.GeoInfo f407224f = new LbsDataV2.GeoInfo();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: i5.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10502a {

        /* renamed from: a, reason: collision with root package name */
        long f407225a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f407226b;

        /* renamed from: c, reason: collision with root package name */
        String f407227c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f407228d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f407229e = new C10503a();

        /* compiled from: P */
        /* renamed from: i5.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        class C10503a implements a.InterfaceC10828a {
            C10503a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                C10502a c10502a = C10502a.this;
                c10502a.f407225a = 0L;
                c10502a.f407226b = null;
            }
        }

        public C10502a(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f407227c = str;
            this.f407228d = cls;
        }
    }

    a() {
    }

    private j5.b A(LbsDataV2.CellInfo cellInfo) {
        DbCacheManager u16 = u();
        if (u16 == null) {
            return null;
        }
        return (j5.b) u16.k0(v(), new String[]{cellInfo.cellId + "", cellInfo.mcc + "", cellInfo.mnc + "", cellInfo.lac + ""});
    }

    private void e() {
        DbCacheManager n3 = n();
        if (n3 != null) {
            n3.b0("timestamp<?", new String[]{"" + (System.currentTimeMillis() - k5.a.a(k5.a.c()))});
        }
    }

    private void g() {
        DbCacheManager k3;
        if (l() <= 500 || (k3 = k()) == null) {
            return;
        }
        k3.V(300, null);
    }

    private void i() {
        DbCacheManager u16;
        e();
        if (m() <= 500 || (u16 = u()) == null) {
            return;
        }
        u16.V(300, null);
    }

    private DbCacheManager k() {
        h(this.f407221c);
        return this.f407221c.f407226b;
    }

    private int l() {
        DbCacheManager k3 = k();
        if (k3 != null) {
            return k3.e0();
        }
        return 0;
    }

    private int m() {
        DbCacheManager n3 = n();
        if (n3 != null) {
            return n3.e0();
        }
        return 0;
    }

    private DbCacheManager n() {
        h(this.f407222d);
        return this.f407222d.f407226b;
    }

    public static a s() {
        if (f407218h == null) {
            synchronized (f407217g) {
                if (f407218h == null) {
                    f407218h = new a();
                }
            }
        }
        return f407218h;
    }

    private DbCacheManager u() {
        h(this.f407222d);
        return this.f407222d.f407226b;
    }

    private String v() {
        if (TextUtils.isEmpty(this.f407223e)) {
            this.f407223e = j5.b.CELLID + "=? and " + j5.b.MCC + "=? and " + j5.b.MNC + "=? and " + j5.b.LAC + "=?";
        }
        return this.f407223e;
    }

    private boolean w(LbsDataV2.CellInfo cellInfo) {
        return A(cellInfo) != null;
    }

    private boolean x(GpsInfo4LocalImage gpsInfo4LocalImage) {
        ArrayList<? extends IDBCacheDataWrapper> g06;
        DbCacheManager k3 = k();
        if (k3 != null && (g06 = k3.g0()) != null) {
            int size = g06.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (z(gpsInfo4LocalImage, (j5.a) g06.get(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void B(LbsDataV2.GeoInfo geoInfo) {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneGeoCacheManager", 4, "saving current geo cache.");
        }
        if (geoInfo == null || geoInfo.gpsInfo == null) {
            return;
        }
        this.f407224f = geoInfo;
        u5.b.F0(geoInfo);
        QZLog.i("QZoneLbsGeoCacheV2", 1, "[QZ_LBS_MODULE]#saveCurrentGeoInfo current geo cache saved. defaultName=" + geoInfo.strDefaultName);
    }

    public void j() {
        g();
        i();
    }

    public LbsDataV2.GeoInfo r(GpsInfo4LocalImage gpsInfo4LocalImage) {
        LbsDataV2.GeoInfo geoInfo;
        j5.a q16 = q(gpsInfo4LocalImage);
        if (q16 == null || (geoInfo = q16.geoInfo) == null) {
            return null;
        }
        return geoInfo;
    }

    public LbsDataV2.GeoInfo t() {
        if (TextUtils.isEmpty(this.f407224f.strDefaultName)) {
            this.f407224f.strDefaultName = u5.b.h0("last.geo.defName", "");
            this.f407224f.address = u5.b.h0("last.geo.address", "");
            this.f407224f.strCountry = u5.b.h0("last.geo.country", "");
            this.f407224f.strProvince = u5.b.h0("last.geo.province", "");
            this.f407224f.strCity = u5.b.h0("last.geo.city", "");
            this.f407224f.gpsInfo = new LbsDataV2.GpsInfo();
            this.f407224f.gpsInfo.lat = u5.b.G("last.geo.lat", LbsDataV2.GPS_DEFAULT_VALUE);
            this.f407224f.gpsInfo.lon = u5.b.G("last.geo.lon", LbsDataV2.GPS_DEFAULT_VALUE);
            this.f407224f.gpsInfo.accuracy = u5.b.G("last.geo.acc", 0);
            this.f407224f.gpsInfo.gpsType = u5.b.G("last.geo.type", 0);
            QZLog.i("QZoneLbsGeoCacheV2", 1, "[QZ_LBS_MODULE]#getLastGeoInfo defaultName=" + this.f407224f.strDefaultName);
        }
        return this.f407224f;
    }

    private void C(LbsDataV2.CellInfo cellInfo) {
        DbCacheManager u16;
        if (cellInfo == null || (u16 = u()) == null) {
            return;
        }
        String v3 = v();
        j5.b bVar = (j5.b) u16.k0(v3, new String[]{cellInfo.cellId + "", cellInfo.mcc + "", cellInfo.mnc + "", cellInfo.lac + ""});
        if (bVar != null) {
            bVar.timestamp = System.currentTimeMillis();
            u16.v0(bVar, v3, null);
        }
    }

    private void c(GeoInfoCell_V2 geoInfoCell_V2) {
        DbCacheManager k3;
        if (geoInfoCell_V2 == null) {
            return;
        }
        GpsInfo4LocalImage createFrom = GpsInfo4LocalImage.createFrom(geoInfoCell_V2.stClientGps);
        LbsDataV2.GeoInfo convertToGeoInfo = LbsDataV2.convertToGeoInfo(geoInfoCell_V2.stGeoInfo);
        if (createFrom == null || convertToGeoInfo == null || x(createFrom) || (k3 = k()) == null) {
            return;
        }
        k3.o0(new j5.a(createFrom, convertToGeoInfo), 1);
    }

    private void f(LbsDataV2.CellInfo cellInfo) {
        DbCacheManager n3;
        if (cellInfo == null || (n3 = n()) == null) {
            return;
        }
        n3.b0(v(), new String[]{cellInfo.cellId + "", cellInfo.mcc + "", cellInfo.mnc + "", cellInfo.lac + ""});
    }

    private void h(C10502a c10502a) {
        DbCacheManager dbCacheManager;
        if (c10502a == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != c10502a.f407225a || (dbCacheManager = c10502a.f407226b) == null || dbCacheManager.isClosed()) {
            c10502a.f407225a = uin;
            DbCacheManager e16 = c.g().e(c10502a.f407228d, uin, c10502a.f407227c);
            c10502a.f407226b = e16;
            e16.U(c10502a.f407229e);
        }
    }

    public void a(List<GeoInfoCell_V2> list) {
        if (list == null) {
            return;
        }
        for (GeoInfoCell_V2 geoInfoCell_V2 : list) {
            if (geoInfoCell_V2 != null && !TextUtils.isEmpty(geoInfoCell_V2.stGeoInfo.strDefaultName)) {
                c(geoInfoCell_V2);
            }
        }
    }

    private j5.b p(LbsDataV2.CellInfo cellInfo) {
        if (cellInfo == null) {
            return null;
        }
        if (y(cellInfo, this.f407220b)) {
            return this.f407220b;
        }
        return A(cellInfo);
    }

    private j5.a q(GpsInfo4LocalImage gpsInfo4LocalImage) {
        ArrayList<? extends IDBCacheDataWrapper> g06;
        if (gpsInfo4LocalImage == null) {
            return null;
        }
        if (z(gpsInfo4LocalImage, this.f407219a)) {
            return this.f407219a;
        }
        DbCacheManager k3 = k();
        if (k3 != null && (g06 = k3.g0()) != null) {
            int size = g06.size();
            for (int i3 = 0; i3 < size; i3++) {
                j5.a aVar = (j5.a) g06.get(i3);
                if (z(gpsInfo4LocalImage, aVar)) {
                    this.f407219a = aVar;
                    return aVar;
                }
            }
        }
        return null;
    }

    public void b(LbsDataV2.CellInfo cellInfo, LbsDataV2.GetGeoInfoRsp getGeoInfoRsp) {
        if (cellInfo == null || getGeoInfoRsp == null || getGeoInfoRsp.stGeoInfo == null || !k5.a.g(getGeoInfoRsp.stGps)) {
            return;
        }
        if (w(cellInfo)) {
            C(cellInfo);
            return;
        }
        DbCacheManager n3 = n();
        if (n3 != null) {
            n3.o0(new j5.b(cellInfo, getGeoInfoRsp), 1);
        }
    }

    public j5.b o(LbsDataV2.CellInfo cellInfo) {
        if (cellInfo == null) {
            return null;
        }
        j5.b p16 = p(cellInfo);
        if (p16 != null) {
            long currentTimeMillis = System.currentTimeMillis() - p16.timestamp;
            long a16 = k5.a.a(k5.a.c());
            if (currentTimeMillis >= 0 && currentTimeMillis <= a16) {
                if (QZLog.isColorLevel()) {
                    QZLog.i("QZoneLbsGeoCacheV2", 1, "[QZ_LBS_MODULE]#getGeoInfo cachehit cell=" + cellInfo + ", record=" + p16);
                }
                this.f407220b = p16;
                return p16;
            }
            this.f407220b = null;
            f(cellInfo);
            QZLog.i("QZoneLbsGeoCacheV2", 1, "[QZ_LBS_MODULE]#getGeoInfo record expired. cell=" + cellInfo);
        }
        return p16;
    }

    public void d(LbsDataV2.GeoInfo geoInfo, GpsInfo4LocalImage gpsInfo4LocalImage) {
        DbCacheManager k3;
        if (geoInfo == null || gpsInfo4LocalImage == null || x(gpsInfo4LocalImage) || (k3 = k()) == null) {
            return;
        }
        k3.o0(new j5.a(gpsInfo4LocalImage, geoInfo), 1);
    }

    private boolean y(LbsDataV2.CellInfo cellInfo, j5.b bVar) {
        return cellInfo != null && bVar != null && cellInfo.cellId == bVar.cellId && cellInfo.mcc == bVar.mcc && cellInfo.mnc == bVar.mnc && cellInfo.lac == bVar.lac;
    }

    private boolean z(GpsInfo4LocalImage gpsInfo4LocalImage, j5.a aVar) {
        return gpsInfo4LocalImage != null && aVar != null && gpsInfo4LocalImage.gpsType == aVar.gpstype && k5.a.b((double) (gpsInfo4LocalImage.latitude * 1000000.0f), (double) (gpsInfo4LocalImage.longtitude * 1000000.0f), (double) (aVar.latitude * 1000000.0f), (double) (aVar.longtitude * 1000000.0f)) <= ((double) d.a());
    }
}
