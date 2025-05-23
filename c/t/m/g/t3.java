package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class t3 {
    public static double a(double d16) {
        return (d16 * 3.141592653589793d) / 180.0d;
    }

    public static byte[] b(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        int i3 = (length % 5) + 7;
        int i16 = 0;
        while (true) {
            int i17 = (i3 << 1) + i16;
            if (i17 < length) {
                byte byteValue = Integer.valueOf(i16).byteValue();
                for (int i18 = 0; i18 < i3; i18++) {
                    int i19 = i16 + i18;
                    byte b16 = bArr2[i19];
                    int i26 = i16 + i3 + i18;
                    bArr2[i19] = (byte) (bArr2[i26] ^ byteValue);
                    bArr2[i26] = (byte) (b16 ^ byteValue);
                }
                i16 = i17;
            } else {
                return bArr2;
            }
        }
    }

    public static int a(char c16) {
        int i3 = (c16 < 'A' || c16 > 'Z') ? 256 : c16 - 'A';
        if (c16 >= 'a' && c16 <= 'z') {
            i3 = (c16 - 'a') + 64;
        }
        return (c16 < '0' || c16 > '9') ? i3 : (c16 + '\u0080') - 48;
    }

    public static void a(String str, int i3, int i16, int i17, int i18, long j3) {
    }

    public static boolean a(int i3) {
        return i3 == 0;
    }

    public static boolean a(ScanResult scanResult, int i3) {
        return true;
    }

    public static byte[] a(byte[] bArr) {
        byte[] b16 = b(u3.a(bArr));
        byte[] bArr2 = new byte[b16.length + 4];
        int length = b16.length;
        bArr2[0] = Integer.valueOf(length >> 8).byteValue();
        bArr2[1] = Integer.valueOf(length >> 24).byteValue();
        bArr2[2] = Integer.valueOf(length >> 16).byteValue();
        bArr2[3] = Integer.valueOf(length).byteValue();
        System.arraycopy(b16, 0, bArr2, 4, length);
        return bArr2;
    }

    public static boolean a(Location location, double[] dArr) {
        int latitude = (int) (location.getLatitude() * 1000000.0d);
        int longitude = (int) (location.getLongitude() * 1000000.0d);
        String a16 = u3.a("tencent_loc_lib");
        int i3 = 0;
        for (int i16 = 0; i16 < a16.length(); i16++) {
            i3 += a(a16.charAt(i16));
        }
        double[] dArr2 = new double[2];
        try {
            com.tencent.tencentmap.lbssdk.service.e.b(latitude ^ i3, longitude ^ i3, dArr2);
        } catch (UnsatisfiedLinkError unused) {
        }
        dArr[0] = dArr2[0];
        dArr[1] = dArr2[1];
        return true;
    }

    public static double a(double d16, int i3) {
        try {
            if (Double.isNaN(d16)) {
                return 0.0d;
            }
            return BigDecimal.valueOf(d16).setScale(i3, RoundingMode.HALF_DOWN).doubleValue();
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static String a(u2 u2Var) {
        if (u2Var == null) {
            return "{}";
        }
        Location location = u2Var.f30053a;
        StringBuilder sb5 = new StringBuilder();
        double a16 = a(location.getLatitude(), 6);
        double a17 = a(location.getLongitude(), 6);
        double a18 = a(location.getAltitude(), 1);
        double a19 = a(LocationMonitor.getAccuracy(location), 1);
        double a26 = a(location.getBearing(), 1);
        double a27 = a(location.getSpeed(), 1);
        sb5.append("{");
        sb5.append("\"latitude\":");
        sb5.append(a16);
        sb5.append(",\"longitude\":");
        sb5.append(a17);
        sb5.append(",\"additional\":");
        sb5.append("\"" + a18 + "," + a19 + "," + a26 + "," + a27 + "," + u2Var.f30054b + "\"");
        sb5.append(",\"source\":");
        sb5.append(u2Var.f30058f.ordinal());
        sb5.append("}");
        return sb5.toString();
    }

    public static String a(t2 t2Var, boolean z16) {
        if (t2Var == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        int i3 = t2Var.f30003b;
        int i16 = t2Var.f30004c;
        int ordinal = t2Var.f30002a.ordinal();
        ArrayList arrayList = new ArrayList();
        t2Var.d();
        long currentTimeMillis = System.currentTimeMillis();
        if (i3.a(t2Var)) {
            arrayList.add(a(i3, i16, t2Var.f30005d, t2Var.f30007f, t2Var.f30006e, t2Var.f30008g, t2Var.f30009h, z16, ordinal, (currentTimeMillis - t2Var.e()) / 1000));
        } else {
            a("illeagal main cell! ", i3, i16, ordinal, t2Var.f30005d, t2Var.f30007f);
        }
        try {
            for (t2 t2Var2 : t2Var.c()) {
                arrayList.add(a(t2Var2.f30003b, t2Var2.f30004c, t2Var2.f30005d, t2Var2.f30007f, t2Var2.f30006e, t2Var2.f30008g, t2Var2.f30009h, (currentTimeMillis - t2Var2.e()) / 1000));
            }
        } catch (Throwable unused) {
        }
        return "[" + m3.b(",").a(arrayList) + "]";
    }

    public static String a(int i3, int i16, int i17, long j3, int i18, int i19, int i26, boolean z16, int i27, long j16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        sb5.append("\"mcc\":");
        sb5.append(i3);
        sb5.append(",\"mnc\":");
        sb5.append(i16);
        sb5.append(",\"lac\":");
        sb5.append(i17);
        sb5.append(",\"cellid\":");
        sb5.append(j3);
        sb5.append(",\"rss\":");
        sb5.append(i18);
        sb5.append(",\"seed\":");
        sb5.append(z16 ? 1 : 0);
        sb5.append(",\"networktype\":");
        sb5.append(i27);
        if (i19 != Integer.MAX_VALUE && i26 != Integer.MAX_VALUE) {
            sb5.append(",\"stationLat\":");
            sb5.append(String.format("%.6f", Float.valueOf(i19 / 14400.0f)));
            sb5.append(",\"stationLng\":");
            sb5.append(String.format("%.6f", Float.valueOf(i26 / 14400.0f)));
        }
        sb5.append(",\"ts\":");
        sb5.append(j16);
        sb5.append("}");
        return sb5.toString();
    }

    public static String a(int i3, int i16, int i17, long j3, int i18, int i19, int i26, long j16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        sb5.append("\"mcc\":");
        sb5.append(i3);
        sb5.append(",\"mnc\":");
        sb5.append(i16);
        sb5.append(",\"lac\":");
        sb5.append(i17);
        sb5.append(",\"cellid\":");
        sb5.append(j3);
        sb5.append(",\"rss\":");
        sb5.append(i18);
        if (i19 != Integer.MAX_VALUE && i26 != Integer.MAX_VALUE) {
            sb5.append(",\"stationLat\":");
            sb5.append(String.format("%.6f", Float.valueOf(i19 / 14400.0f)));
            sb5.append(",\"stationLng\":");
            sb5.append(String.format("%.6f", Float.valueOf(i26 / 14400.0f)));
        }
        sb5.append(",\"ts\":");
        sb5.append(j16);
        sb5.append("}");
        return sb5.toString();
    }

    public static String a(x2 x2Var) {
        List<ScanResult> a16 = x2Var == null ? null : x2Var.a();
        if (a16 == null) {
            k3.a("wifis", "scanResult null");
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[");
        if (a16.size() <= 0) {
            sb5.append("]");
            k3.a("wifis", "scanResult 0");
            return sb5.toString();
        }
        int i3 = 0;
        for (ScanResult scanResult : a16) {
            if (a(scanResult, a16.size())) {
                if (i3 > 0) {
                    sb5.append(",");
                }
                sb5.append("{\"mac\":\"");
                sb5.append(scanResult.BSSID);
                sb5.append("\",");
                sb5.append("\"rssi\":");
                sb5.append(scanResult.level);
                sb5.append("}");
                i3++;
            }
        }
        sb5.append("]");
        k3.a("wifis", "scanResult " + a16.size() + "," + i3);
        return sb5.toString();
    }

    public static boolean a(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
        }
        if (str.contains("latitude")) {
            return true;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("cells");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            return true;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("wifis");
        return optJSONArray2 != null && optJSONArray2.length() > 0;
    }

    public static double a(double d16, double d17, double d18, double d19) {
        double a16 = a(d16);
        double a17 = a(d18);
        return (Math.round(((Math.asin(Math.sqrt(Math.pow(Math.sin((a16 - a17) / 2.0d), 2.0d) + ((Math.cos(a16) * Math.cos(a17)) * Math.pow(Math.sin((a(d17) - a(d19)) / 2.0d), 2.0d)))) * 2.0d) * 6378.137d) * 10000.0d) / 10000.0d) * 1000.0d;
    }
}
