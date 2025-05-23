package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import c.t.m.g.t2;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: P */
/* loaded from: classes.dex */
public class i3 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f29764a = false;

    /* renamed from: b, reason: collision with root package name */
    public static long f29765b;

    /* renamed from: c, reason: collision with root package name */
    public static CellLocation f29766c;

    /* renamed from: d, reason: collision with root package name */
    public static List<CellInfo> f29767d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public static long f29768e = 0;

    public static boolean a(int i3, int i16, int i17, long j3) {
        return i3 >= 0 && i16 >= 0 && i17 > 0 && i17 < 65535 && j3 > 0 && j3 < WebSocketProtocol.PAYLOAD_SHORT_MAX && i16 != 0;
    }

    public static boolean b(int i3, int i16, int i17, long j3) {
        return (i3 < 0 || i16 < 0 || i17 <= 0 || i17 == Integer.MAX_VALUE || j3 == 268435455 || j3 == TTL.MAX_VALUE || j3 == 50594049 || j3 == WebSocketProtocol.PAYLOAD_SHORT_MAX || j3 <= 0 || j3 == WebSocketProtocol.PAYLOAD_SHORT_MAX || j3 <= 0) ? false : true;
    }

    public static List<NeighboringCellInfo> c(n1 n1Var) {
        return Collections.emptyList();
    }

    @SuppressLint({"NewApi"})
    public static boolean a(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on") == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static CellLocation b(n1 n1Var) {
        TelephonyManager d16 = n1Var.d();
        if (d16 != null) {
            try {
                if (o1.b() == 1) {
                    if (f29766c != null && System.currentTimeMillis() - f29765b < 10000) {
                        return f29766c;
                    }
                    CellLocation cellLocation = LocationMonitor.getCellLocation(d16);
                    f29766c = cellLocation;
                    f29765b = System.currentTimeMillis();
                    k3.a("CELL", "cellLoc");
                    o3.a("backgroundloc", "app in foreground , getCellLocation");
                    return cellLocation;
                }
                o3.a("backgroundloc", "app in background ,donot allow getCellLocation");
            } catch (Exception e16) {
                o3.a("Cells", "cannot get cell location", e16);
            }
        }
        return CellLocation.getEmpty();
    }

    public static void a(n1 n1Var, TelephonyManager telephonyManager, CellLocation cellLocation, long j3) {
        if (telephonyManager != null) {
            try {
                o3.a("backgroundloc", "app in foreground , getCellLocation");
                boolean z16 = false;
                if (telephonyManager.getSimState() == 5) {
                    boolean a16 = a(n1Var.f29875a);
                    if ((cellLocation == null || j3 < 0) && !a16) {
                        z16 = true;
                    }
                    f29764a = z16;
                }
            } catch (Exception e16) {
                o3.a("Cells", "cannot get cell location", e16);
                f29764a = true;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static List<CellInfo> a(n1 n1Var) {
        try {
        } catch (Throwable th5) {
            k3.a("CELL", "get cell failed, " + th5);
            o3.a("Cells", "cannot get cell info", th5);
        }
        if (o1.b() == 1) {
            o3.a("backgroundloc", "Get Cell Info in foreground");
            if (System.currentTimeMillis() - f29768e > 5000) {
                List<CellInfo> allCellInfo = LocationMonitor.getAllCellInfo(n1Var.d());
                if (allCellInfo != null) {
                    f29767d = allCellInfo;
                    f29768e = System.currentTimeMillis();
                    k3.a("CELL", "use fresh," + allCellInfo.size());
                    return allCellInfo;
                }
                k3.a("CELL", "get cell failed");
            }
            k3.a("CELL", "use cach," + f29767d.size());
            return f29767d;
        }
        o3.a("backgroundloc", "app in backgroud , donot allow getAllCellInfo");
        return new ArrayList();
    }

    public static int b(int i3, SignalStrength signalStrength, SignalStrength signalStrength2) {
        try {
            if (b(i3)) {
                return signalStrength.getGsmSignalStrength() - signalStrength2.getGsmSignalStrength();
            }
            if (a(i3)) {
                return signalStrength.getCdmaDbm() - signalStrength2.getCdmaDbm();
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean b(int i3) {
        return i3 != t2.a.CDMA.ordinal();
    }

    public static long a(CellLocation cellLocation) {
        if (o1.b() == 1) {
            if (cellLocation instanceof CdmaCellLocation) {
                return LocationMonitor.getBaseStationId((CdmaCellLocation) cellLocation);
            }
            try {
                return LocationMonitor.getCid((GsmCellLocation) cellLocation);
            } catch (Exception unused) {
            }
        }
        return -1L;
    }

    public static boolean a(CellLocation cellLocation, CellLocation cellLocation2) {
        if (!q3.b(cellLocation, cellLocation2) && cellLocation.getClass() == cellLocation2.getClass() && o1.b() == 1) {
            return cellLocation instanceof GsmCellLocation ? LocationMonitor.getCid((GsmCellLocation) cellLocation) == LocationMonitor.getCid((GsmCellLocation) cellLocation2) : (cellLocation instanceof CdmaCellLocation) && LocationMonitor.getBaseStationId((CdmaCellLocation) cellLocation) == LocationMonitor.getBaseStationId((CdmaCellLocation) cellLocation2);
        }
        return false;
    }

    public static boolean a(t2 t2Var) {
        if (q3.a(t2Var)) {
            return false;
        }
        if (a(t2Var.f30002a.ordinal())) {
            return a(t2Var.f30003b, t2Var.f30004c, t2Var.f30005d, t2Var.f30007f);
        }
        return b(t2Var.f30003b, t2Var.f30004c, t2Var.f30005d, t2Var.f30007f);
    }

    public static boolean a(int i3, SignalStrength signalStrength, SignalStrength signalStrength2) {
        if (signalStrength == null || signalStrength2 == null) {
            return true;
        }
        int abs = Math.abs(b(i3, signalStrength, signalStrength2));
        return b(i3) ? abs > 3 : a(i3) && abs > 6;
    }

    public static boolean a(int i3) {
        return i3 == t2.a.CDMA.ordinal();
    }
}
