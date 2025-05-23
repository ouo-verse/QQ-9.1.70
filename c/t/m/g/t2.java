package c.t.m.g;

import android.annotation.SuppressLint;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: P */
/* loaded from: classes.dex */
public class t2 extends w2 {

    /* renamed from: n, reason: collision with root package name */
    public static volatile t2 f30000n;

    /* renamed from: o, reason: collision with root package name */
    public static volatile long f30001o;

    /* renamed from: k, reason: collision with root package name */
    public List<NeighboringCellInfo> f30012k;

    /* renamed from: l, reason: collision with root package name */
    public List<t2> f30013l;

    /* renamed from: a, reason: collision with root package name */
    public a f30002a = a.NONE;

    /* renamed from: b, reason: collision with root package name */
    public int f30003b = LocaleManager.MOBILE_COUNTRY_CODE_CN_INT;

    /* renamed from: c, reason: collision with root package name */
    public int f30004c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f30005d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f30006e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f30007f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f30008g = Integer.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    public int f30009h = Integer.MAX_VALUE;

    /* renamed from: j, reason: collision with root package name */
    public boolean f30011j = false;

    /* renamed from: i, reason: collision with root package name */
    public final long f30010i = System.currentTimeMillis();

    /* renamed from: m, reason: collision with root package name */
    public List<String> f30014m = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum a {
        NONE,
        GSM,
        CDMA,
        WCDMA,
        LTE,
        NR,
        TEMP6,
        TEMP7,
        NOSIM
    }

    public static int a(int i3) {
        if (i3 < -140 || i3 > -40) {
            return -1;
        }
        return i3;
    }

    public String b() {
        return "" + this.f30003b + this.f30004c + this.f30005d + this.f30007f;
    }

    public List<t2> c() {
        if (this.f30013l == null) {
            this.f30013l = Collections.emptyList();
        }
        return this.f30013l;
    }

    public synchronized List<NeighboringCellInfo> d() {
        if (this.f30012k == null) {
            this.f30012k = Collections.emptyList();
        }
        return this.f30012k;
    }

    public long e() {
        return this.f30010i;
    }

    public boolean f() {
        int i3;
        int i16;
        int i17;
        int i18;
        if (this.f30002a != a.CDMA) {
            int i19 = this.f30003b;
            if (i19 >= 0 && (i17 = this.f30004c) >= 0 && i19 != 535 && i17 != 535 && (i18 = this.f30005d) >= 0 && i18 != 65535 && i18 != 25840) {
                long j3 = this.f30007f;
                if (j3 != WebSocketProtocol.PAYLOAD_SHORT_MAX && j3 != 268435455 && j3 != TTL.MAX_VALUE && j3 != 50594049 && j3 != 8 && j3 != 10 && j3 != 33 && j3 > 0) {
                    return true;
                }
            }
            return false;
        }
        int i26 = this.f30003b;
        if (i26 >= 0 && (i3 = this.f30004c) >= 0 && i26 != 535 && i3 != 535 && (i16 = this.f30005d) >= 0 && i16 != 65535) {
            long j16 = this.f30007f;
            if (j16 != WebSocketProtocol.PAYLOAD_SHORT_MAX && j16 > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean g() {
        return this.f30011j;
    }

    public String toString() {
        return "TxCellInfo [PhoneType=" + this.f30002a + ", MCC=" + this.f30003b + ", MNC=" + this.f30004c + ", LAC=" + this.f30005d + ", CID=" + this.f30007f + ", RSSI=" + this.f30006e + ", LAT=" + this.f30008g + ", LNG=" + this.f30009h + ", mTime=" + this.f30010i + "]";
    }

    public boolean a(long j3) {
        return System.currentTimeMillis() - this.f30010i < j3;
    }

    public static synchronized t2 a() {
        synchronized (t2.class) {
            if (System.currentTimeMillis() - f30001o >= 29000 || f30000n == null) {
                return null;
            }
            return f30000n;
        }
    }

    public static synchronized void a(t2 t2Var, long j3) {
        synchronized (t2.class) {
            f30001o = j3;
            f30000n = t2Var;
        }
    }

    public static t2 a(n1 n1Var) {
        if (o1.b() == 2) {
            return null;
        }
        t2 a16 = a();
        if (a16 != null) {
            return a16;
        }
        t2 a17 = a(n1Var, i3.a(n1Var));
        if (a17 == null || !a17.g()) {
            a17 = a(n1Var, i3.b(n1Var), null);
        }
        a(a17, System.currentTimeMillis());
        return a17;
    }

    public static t2 a(n1 n1Var, CellLocation cellLocation, SignalStrength signalStrength) {
        t2 t2Var = null;
        if (o1.b() == 2) {
            return null;
        }
        if (n1Var.h() && cellLocation != null) {
            t2 a16 = a();
            if (a16 != null) {
                return a16;
            }
            TelephonyManager d16 = n1Var.d();
            t2Var = new t2();
            try {
                if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    a aVar = a.CDMA;
                    t2Var.f30002a = aVar;
                    t2Var.a(d16, aVar);
                    t2Var.f30004c = cdmaCellLocation.getSystemId();
                    t2Var.f30005d = cdmaCellLocation.getNetworkId();
                    t2Var.f30007f = LocationMonitor.getBaseStationId(cdmaCellLocation);
                    t2Var.f30008g = cdmaCellLocation.getBaseStationLatitude();
                    t2Var.f30009h = cdmaCellLocation.getBaseStationLongitude();
                    if (signalStrength == null) {
                        t2Var.f30006e = -1;
                    } else {
                        t2Var.f30006e = signalStrength.getCdmaDbm();
                    }
                } else {
                    a aVar2 = a.GSM;
                    t2Var.f30002a = aVar2;
                    t2Var.a(d16, aVar2);
                    t2Var.f30005d = ((GsmCellLocation) cellLocation).getLac();
                    t2Var.f30007f = LocationMonitor.getCid(r3);
                    if (signalStrength == null) {
                        t2Var.f30006e = -1;
                    } else {
                        t2Var.f30006e = (signalStrength.getGsmSignalStrength() * 2) - 113;
                    }
                }
                i3.a(n1Var, d16, cellLocation, t2Var.f30007f);
            } catch (Throwable unused) {
            }
            if (t2Var.f()) {
                t2Var.f30011j = true;
            }
            if (!n3.a().b(n1Var.f29875a)) {
                t2Var.f30002a = a.NOSIM;
            }
            t2Var.f30014m.add(t2Var.b());
            a(t2Var, System.currentTimeMillis());
        }
        return t2Var;
    }

    @SuppressLint({"NewApi"})
    public static t2 a(n1 n1Var, CellInfo cellInfo) {
        CellIdentity cellIdentity;
        long nci;
        CellSignalStrength cellSignalStrength;
        String mncString;
        String mccString;
        if (o1.b() == 2 || cellInfo == null || n1Var == null) {
            return null;
        }
        t2 a16 = a();
        if (a16 != null) {
            return a16;
        }
        TelephonyManager d16 = n1Var.d();
        t2 t2Var = new t2();
        try {
            int i3 = -88;
            if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                a aVar = a.CDMA;
                t2Var.f30002a = aVar;
                t2Var.a(d16, aVar);
                t2Var.f30004c = cellIdentity2.getSystemId();
                t2Var.f30005d = cellIdentity2.getNetworkId();
                t2Var.f30007f = LocationMonitor.getBaseStationId(cellIdentity2);
                t2Var.f30008g = cellIdentity2.getLatitude();
                t2Var.f30009h = cellIdentity2.getLongitude();
                int dbm = cellInfoCdma.getCellSignalStrength().getDbm();
                if (dbm > -110 && dbm < -40) {
                    i3 = dbm;
                }
                t2Var.f30006e = i3;
            } else if (cellInfo instanceof CellInfoGsm) {
                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                t2Var.f30002a = a.GSM;
                CellIdentityGsm cellIdentity3 = cellInfoGsm.getCellIdentity();
                t2Var.f30005d = cellIdentity3.getLac();
                t2Var.f30007f = LocationMonitor.getCid(cellIdentity3);
                t2Var.f30003b = cellIdentity3.getMcc();
                t2Var.f30004c = cellIdentity3.getMnc();
                int dbm2 = cellInfoGsm.getCellSignalStrength().getDbm();
                if (dbm2 > -110 && dbm2 < -40) {
                    i3 = dbm2;
                }
                t2Var.f30006e = i3;
            } else if (cellInfo instanceof CellInfoWcdma) {
                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                t2Var.f30002a = a.WCDMA;
                CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                t2Var.f30005d = cellIdentity4.getLac();
                t2Var.f30007f = LocationMonitor.getCellCid(cellIdentity4);
                t2Var.f30003b = cellIdentity4.getMcc();
                t2Var.f30004c = cellIdentity4.getMnc();
                int dbm3 = cellInfoWcdma.getCellSignalStrength().getDbm();
                if (dbm3 > -110 && dbm3 < -40) {
                    i3 = dbm3;
                }
                t2Var.f30006e = i3;
            } else if (cellInfo instanceof CellInfoLte) {
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                t2Var.f30002a = a.LTE;
                CellIdentityLte cellIdentity5 = cellInfoLte.getCellIdentity();
                t2Var.f30005d = cellIdentity5.getTac();
                t2Var.f30007f = LocationMonitor.getCellCid(cellIdentity5);
                t2Var.f30003b = cellIdentity5.getMcc();
                t2Var.f30004c = cellIdentity5.getMnc();
                int dbm4 = cellInfoLte.getCellSignalStrength().getDbm();
                if (dbm4 > -110 && dbm4 < -40) {
                    i3 = dbm4;
                }
                t2Var.f30006e = i3;
            } else if (cellInfo instanceof CellInfoNr) {
                CellInfoNr cellInfoNr = (CellInfoNr) cellInfo;
                t2Var.f30002a = a.NR;
                cellIdentity = cellInfoNr.getCellIdentity();
                CellIdentityNr cellIdentityNr = (CellIdentityNr) cellIdentity;
                try {
                    mncString = cellIdentityNr.getMncString();
                    t2Var.f30004c = Integer.parseInt(mncString);
                    mccString = cellIdentityNr.getMccString();
                    t2Var.f30003b = Integer.parseInt(mccString);
                } catch (Throwable th5) {
                    o3.a("TxCellInfo", th5.toString());
                }
                t2Var.f30005d = a(cellIdentityNr);
                nci = cellIdentityNr.getNci();
                t2Var.f30007f = nci;
                cellSignalStrength = cellInfoNr.getCellSignalStrength();
                t2Var.f30006e = a(cellSignalStrength.getDbm());
            }
        } catch (Throwable unused) {
        }
        t2Var.f30011j = t2Var.f();
        if (t2Var.f30003b == 460 && t2Var.f30004c == Integer.MAX_VALUE) {
            t2Var.f30004c = 0;
        }
        if (!n3.a().b(n1Var.f29875a)) {
            t2Var.f30002a = a.NOSIM;
        }
        t2Var.f30014m.add(t2Var.b());
        a(t2Var, System.currentTimeMillis());
        return t2Var;
    }

    @SuppressLint({"InlinedApi"})
    public static int a(CellIdentityNr cellIdentityNr) {
        int tac;
        Integer num;
        if (cellIdentityNr == null) {
            return Integer.MAX_VALUE;
        }
        tac = cellIdentityNr.getTac();
        if (tac >= 0 && tac < 65535) {
            return tac;
        }
        try {
            Method method = cellIdentityNr.getClass().getMethod("getHwTac", new Class[0]);
            if (method == null || (num = (Integer) method.invoke(cellIdentityNr, new Object[0])) == null) {
                return tac;
            }
            int intValue = num.intValue();
            try {
                o3.b("TxCellInfo", "getHwTac " + intValue);
                return intValue;
            } catch (Throwable unused) {
                tac = intValue;
                o3.a("TxCellInfo", "getHwTac failed", (Throwable) null);
                return tac;
            }
        } catch (Throwable unused2) {
        }
    }

    @SuppressLint({"NewApi"})
    public static t2 a(n1 n1Var, List<CellInfo> list) {
        t2 a16;
        if (o1.b() == 2) {
            return new t2();
        }
        if (list != null && n1Var != null && list.size() != 0) {
            t2 a17 = a();
            if (a17 != null) {
                return a17;
            }
            ArrayList arrayList = new ArrayList();
            t2 t2Var = new t2();
            boolean z16 = true;
            for (CellInfo cellInfo : list) {
                if (cellInfo.isRegistered() && (a16 = a(n1Var, cellInfo)) != null && a16.f()) {
                    t2Var.f30014m.add(a16.b());
                    if (z16) {
                        a16.f30011j = true;
                        z16 = false;
                        t2Var = a16;
                    } else {
                        arrayList.add(a16);
                    }
                }
            }
            t2Var.f30013l = arrayList;
            a(t2Var, System.currentTimeMillis());
            return t2Var;
        }
        return new t2();
    }

    public final void a(TelephonyManager telephonyManager, a aVar) {
        String networkOperator = DeviceInfoMonitor.getNetworkOperator(telephonyManager);
        int i3 = LocaleManager.MOBILE_COUNTRY_CODE_CN_INT;
        int i16 = 0;
        if (networkOperator != null && networkOperator.length() >= 5) {
            try {
                int parseInt = Integer.parseInt(networkOperator.substring(0, 3));
                try {
                    i16 = Integer.parseInt(networkOperator.substring(3, 5));
                    if (parseInt == 460 && i16 == 3 && aVar != a.CDMA && networkOperator.length() == 11) {
                        i16 = Integer.parseInt(networkOperator.substring(9, 11));
                    }
                } catch (Throwable unused) {
                }
                i3 = parseInt;
            } catch (Throwable unused2) {
            }
        }
        if (i3 <= 0 || i16 < 0) {
            return;
        }
        this.f30003b = i3;
        this.f30004c = i16;
    }

    public synchronized void a(List<NeighboringCellInfo> list) {
        if (list != null) {
            this.f30012k = Collections.unmodifiableList(list);
        } else {
            this.f30012k = Collections.emptyList();
        }
    }
}
