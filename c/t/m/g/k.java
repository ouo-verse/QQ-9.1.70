package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f29812a = "209";

    /* renamed from: b, reason: collision with root package name */
    public static volatile String f29813b = "fc_sdk";

    /* renamed from: c, reason: collision with root package name */
    public static final Comparator<Object> f29814c = new a();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            ScanResult scanResult = (ScanResult) obj;
            ScanResult scanResult2 = (ScanResult) obj2;
            int i3 = (int) (((scanResult2.timestamp / 1000) / 1000) - ((scanResult.timestamp / 1000) / 1000));
            if (i3 == 0) {
                return scanResult2.level - scanResult.level;
            }
            return i3;
        }
    }

    public static String a(c cVar, Location location, List<ScanResult> list, List<d> list2, boolean z16) {
        int size;
        int i3;
        long j3;
        int i16;
        if (list != null) {
            try {
                size = list.size();
            } catch (Throwable th5) {
                c1.a("DCUtils", "get write string error!", th5);
            }
        } else {
            size = 0;
        }
        int size2 = list2 != null ? list2.size() : 0;
        if (cVar != null && location != null && (size != 0 || size2 != 0)) {
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            StringBuilder sb7 = new StringBuilder();
            StringBuilder sb8 = new StringBuilder();
            sb5.append(0);
            sb5.append(",");
            Locale locale = Locale.ENGLISH;
            sb5.append(String.format(locale, "%.6f", Double.valueOf(location.getLatitude())));
            sb5.append(",");
            sb5.append(String.format(locale, "%.6f", Double.valueOf(location.getLongitude())));
            sb5.append(",");
            sb5.append((int) location.getAltitude());
            sb5.append(",");
            sb5.append((int) LocationMonitor.getAccuracy(location));
            sb5.append(",");
            sb5.append((int) location.getBearing());
            sb5.append(",");
            sb5.append(String.format(locale, "%.1f", Float.valueOf(location.getSpeed())));
            sb5.append(",");
            sb5.append(location.getTime());
            if (!h1.a((Collection) list2)) {
                int i17 = 0;
                while (i17 < list2.size()) {
                    d dVar = list2.get(i17);
                    sb6.append(i17 == 0 ? "" : ";");
                    sb6.append(dVar.f29522a);
                    sb6.append(",");
                    sb6.append(dVar.f29523b);
                    sb6.append(",");
                    sb6.append(dVar.f29524c);
                    sb6.append(",");
                    sb6.append(dVar.f29526e);
                    sb6.append(",");
                    sb6.append(dVar.f29525d);
                    sb6.append(",");
                    sb6.append(i17 == 0 ? f1.a(z16) : -1);
                    sb6.append(",");
                    sb6.append(dVar.f29527f);
                    i17++;
                }
            }
            if (list != null && list.size() > 0) {
                Object[] array = list.toArray();
                Arrays.sort(array, f29814c);
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                int i18 = 0;
                while (i18 < array.length) {
                    ScanResult scanResult = (ScanResult) array[i18];
                    sb7.append(i18 == 0 ? "" : ContainerUtils.FIELD_DELIMITER);
                    sb7.append(scanResult.BSSID.replaceAll(":", "").toLowerCase());
                    sb7.append(ContainerUtils.FIELD_DELIMITER);
                    sb7.append(scanResult.level);
                    StringBuilder sb9 = sb6;
                    StringBuilder sb10 = sb7;
                    long j16 = scanResult.timestamp;
                    if (j16 > 0) {
                        j3 = 1000;
                        i16 = (int) (elapsedRealtime - ((j16 / 1000) / 1000));
                    } else {
                        j3 = 1000;
                        i16 = -1;
                    }
                    sb8.append(i18 == 0 ? "" : ContainerUtils.FIELD_DELIMITER);
                    sb8.append(i16);
                    i18++;
                    sb6 = sb9;
                    sb7 = sb10;
                }
            }
            StringBuilder sb11 = sb6;
            StringBuilder sb12 = sb7;
            StringBuilder sb13 = new StringBuilder();
            String a16 = n.a();
            if (a16 != null && a16.length() > 5) {
                try {
                    JSONObject jSONObject = new JSONObject(a16);
                    sb13.append(jSONObject.optString("mac").replaceAll(":", "").toLowerCase());
                    sb13.append(ContainerUtils.FIELD_DELIMITER);
                    sb13.append(jSONObject.optString(TPDownloadProxyEnum.USER_SSID));
                    sb13.append(ContainerUtils.FIELD_DELIMITER);
                    sb13.append(jSONObject.optString("rssi"));
                    i3 = 0;
                } catch (Throwable unused) {
                    i3 = 0;
                    sb13.setLength(0);
                }
                if (sb13.length() < 5) {
                    sb13.setLength(i3);
                }
            }
            String str = cVar.b().replaceAll("[| _]", "") + "_" + cVar.c();
            String str2 = cVar.d().replaceAll("[| _]", "") + "_" + cVar.e().replaceAll("[| _]", "");
            StringBuilder sb14 = new StringBuilder();
            SimpleDateFormat b16 = q0.b("yyyy-MM-dd HH:mm:ss");
            sb14.append("[");
            sb14.append(b16.format(new Date()));
            sb14.append("]:");
            sb14.append(cVar.f());
            sb14.append("|");
            sb14.append(f29812a);
            sb14.append("|");
            sb14.append(cVar.a());
            sb14.append("|");
            sb14.append(j.f29772d ? m.a() : "");
            sb14.append("|");
            sb14.append(j.f29772d ? m.b() : "");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append((CharSequence) sb5);
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append((CharSequence) sb11);
            sb14.append("|");
            sb14.append((CharSequence) sb12);
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append(f29813b);
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append((CharSequence) sb13);
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append(j.f29772d ? m.c().replaceAll(":", "").toLowerCase() : "");
            sb14.append("|");
            sb14.append(str);
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append(str2);
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append("");
            sb14.append("|");
            sb14.append(sb8.toString());
            sb14.append("|");
            sb14.append("");
            return sb14.toString();
        }
        return "";
    }

    public static void b(String str) {
        f29812a = str;
    }

    public static void a(String str) {
        f29813b = str;
    }
}
