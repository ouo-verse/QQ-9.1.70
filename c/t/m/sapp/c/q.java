package c.t.m.sapp.c;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.Pair;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qzone.patch.QZonePatchService;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class q {

    /* renamed from: b, reason: collision with root package name */
    public static String f30189b = "TencentLocation_sapp/comp";

    /* renamed from: c, reason: collision with root package name */
    public static String f30190c = "TencentLocation_sapp/odex";

    /* renamed from: d, reason: collision with root package name */
    public static String f30191d = "complist_loading_sapp";

    /* renamed from: e, reason: collision with root package name */
    public static long f30192e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static String f30193f = "01234567890ABCDEF";

    /* renamed from: g, reason: collision with root package name */
    public static String f30194g = "key-locselfid";

    /* renamed from: h, reason: collision with root package name */
    public static String f30195h = "key-locoutid";

    /* renamed from: i, reason: collision with root package name */
    public static String f30196i = "01234567890ABCDEF";

    /* renamed from: a, reason: collision with root package name */
    public static final Object f30188a = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static HashMap<String, r> f30197j = new HashMap<>();

    public static double a(double d16) {
        return (d16 * 3.141592653589793d) / 180.0d;
    }

    public static boolean b(Context context, String str, Long l3) {
        return a(context, str).a(String.valueOf(l3).getBytes(), false);
    }

    public static String c(Context context, String str, String str2) {
        return a(context, str).a(str2);
    }

    public static boolean d(Context context, String str, String str2) {
        return a(context, str).a(str2.getBytes(), false);
    }

    public static String e() {
        try {
            return Build.MANUFACTURER.replaceAll("[_]", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String f() {
        return "";
    }

    public static int g() {
        return Process.myPid();
    }

    public static String h(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + f30190c;
    }

    public static boolean i(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean j(Context context) {
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception unused) {
        }
        if (telephonyManager == null) {
            return false;
        }
        if (telephonyManager.getSimState() != 5) {
            return false;
        }
        return true;
    }

    public static String k(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                if (bundle.containsKey("TencentGeoLocationSDK")) {
                    return bundle.getString("TencentGeoLocationSDK");
                }
                if (bundle.containsKey("TencentMapSDK")) {
                    return bundle.getString("TencentMapSDK");
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static r a(Context context, String str) {
        if (f30197j.containsKey(str)) {
            return f30197j.get(str);
        }
        r rVar = new r(context.getFilesDir().getAbsolutePath() + "/TencentLocation_sapp/conf/" + str);
        f30197j.put(str, rVar);
        return rVar;
    }

    public static String e(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception unused) {
            Log.e(i.f30173a, "getProcessNameByService,ignore this");
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:5|(2:6|7)|(4:9|11|12|(14:14|15|16|17|(13:47|48|50|51|(1:54)|53|21|(1:23)|(1:25)|(1:27)|(1:29)|(1:31)|(1:(2:34|(2:36|(1:40)(2:38|39))(2:41|42))(2:43|44))(2:45|46))|19|20|21|(0)|(0)|(0)|(0)|(0)|(0)(0))(13:60|16|17|(0)|19|20|21|(0)|(0)|(0)|(0)|(0)|(0)(0)))|64|63|15|16|17|(0)|19|20|21|(0)|(0)|(0)|(0)|(0)|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int f(Context context) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i3;
        boolean z26;
        LocationManager locationManager;
        WifiManager wifiManager;
        if (context == null) {
            return -1;
        }
        boolean j3 = j(context);
        try {
            wifiManager = (WifiManager) context.getSystemService("wifi");
        } catch (Throwable unused) {
        }
        if (wifiManager != null) {
            z16 = wifiManager.isWifiEnabled();
            if (wifiManager.isScanAlwaysAvailable()) {
                z17 = true;
                z18 = z17;
                z19 = z17;
                locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager != null) {
                    try {
                        i3 = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
                    } catch (Throwable unused2) {
                        i3 = 0;
                    }
                    try {
                        boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                        List<String> allProviders = locationManager.getAllProviders();
                        z26 = allProviders != null ? allProviders.contains("gps") : false;
                        r3 = isProviderEnabled;
                    } catch (Exception unused3) {
                    }
                    int i16 = !j3 ? 1 : 0;
                    if (!z16) {
                        i16 += 2;
                    }
                    if (!r3) {
                        i16 += 4;
                    }
                    if (!z18) {
                        i16 += 8;
                    }
                    if (!z26) {
                        i16 += 16;
                    }
                    if (!z19) {
                        i16 += 32;
                    }
                    return i3 == 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i16 : i16 + 512 : i16 + 256 : i16 + 128 : i16 + 64;
                }
                i3 = 0;
                z26 = false;
                int i162 = !j3 ? 1 : 0;
                if (!z16) {
                }
                if (!r3) {
                }
                if (!z18) {
                }
                if (!z26) {
                }
                if (!z19) {
                }
                if (i3 == 0) {
                }
            } else {
                z18 = true;
                z19 = false;
                locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager != null) {
                }
                i3 = 0;
                z26 = false;
                int i1622 = !j3 ? 1 : 0;
                if (!z16) {
                }
                if (!r3) {
                }
                if (!z18) {
                }
                if (!z26) {
                }
                if (!z19) {
                }
                if (i3 == 0) {
                }
            }
        }
        z16 = false;
        z17 = false;
        z18 = z17;
        z19 = z17;
        locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
        }
        i3 = 0;
        z26 = false;
        int i16222 = !j3 ? 1 : 0;
        if (!z16) {
        }
        if (!r3) {
        }
        if (!z18) {
        }
        if (!z26) {
        }
        if (!z19) {
        }
        if (i3 == 0) {
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String g(Context context) {
        try {
            String str = f30193f;
            if (str != null && str.length() != 0 && !"01234567890ABCDEF".equals(f30193f)) {
                return f30193f;
            }
            String a16 = l.a(b(context, "LocationSDK", "_col_ooo_"));
            if (!"01234567890ABCDEF".equals(a16) && !"".equals(a16)) {
                f30193f = a16;
                return a16;
            }
            String b16 = b(context, "TLocationSDK", f30195h);
            if (!"01234567890ABCDEF".equals(b16)) {
                f30193f = b16;
                return b16;
            }
            String b17 = b(context, "TLocationSDK", f30194g);
            if (!"01234567890ABCDEF".equals(b17)) {
                f30193f = b17;
                return b17;
            }
            String b18 = b(context, "LocationSDK", "loc_id_LocCommId");
            f30193f = b18;
            return b18;
        } catch (Throwable unused) {
            f30193f = "01234567890ABCDEF";
            return "01234567890ABCDEF";
        }
    }

    public static String c(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + f30189b;
    }

    public static String d(Context context) {
        String e16 = e(context);
        return e16 == null ? c() : e16;
    }

    public static String b(Context context) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i3 = packageInfo.versionCode;
            if (str != null && str.trim().length() > 0) {
                return str;
            }
            return "" + i3;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Exception unused) {
            Log.e(i.f30173a, "getProcessNameByReadLocalFile,ignore this");
            return null;
        }
    }

    public static long d() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static Long a(Context context, String str, Long l3) {
        try {
            return Long.valueOf(Long.parseLong(a(context, str).a(String.valueOf(l3))));
        } catch (Exception unused) {
            return l3;
        }
    }

    public static String c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("status");
            e.b().a("DRG", "statucode:" + string);
            if (string.equals("-3")) {
                return null;
            }
            if (string.equals("0")) {
                JSONArray jSONArray = jSONObject.getJSONArray("compList");
                String str2 = "";
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    int i16 = jSONObject2.getInt("compId");
                    String string2 = jSONObject2.getString("compVer");
                    String string3 = jSONObject2.getString("md5");
                    int i17 = jSONObject2.getInt("size");
                    str2 = str2 + i16 + "," + string2 + "," + jSONObject2.getString("compName") + "," + i17 + "," + string3 + ",;";
                }
                return str2;
            }
            if (string.equals("-1") || string.equals("-2") || string.equals("-4")) {
                return null;
            }
            string.equals("-5");
            return null;
        } catch (Exception e16) {
            e.b().a("DRG", "statucode:" + e16.toString());
            return null;
        }
    }

    public static List<a> d(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str2 : str.split(";")) {
                String[] split = str2.split(",");
                if (split.length >= 5) {
                    try {
                        a aVar = new a();
                        aVar.f30128a = Integer.valueOf(split[0]).intValue();
                        aVar.f30129b = split[1];
                        aVar.f30130c = split[2];
                        aVar.f30131d = Integer.valueOf(split[3]).intValue();
                        aVar.f30132e = split[4];
                        if (split.length > 5) {
                            aVar.f30133f = split[5];
                        }
                        arrayList.add(aVar);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return arrayList;
    }

    public static void a() {
        long currentTimeMillis = System.currentTimeMillis();
        f30189b = "TencentLocation_sapp/comp";
        f30190c = "TencentLocation_sapp/odex";
        f30189b += "_atuo_" + currentTimeMillis;
        f30190c += "_atuo_" + currentTimeMillis;
    }

    public static int b() {
        return Build.VERSION.SDK_INT;
    }

    public static String b(Context context, String str, String str2) {
        try {
            if (p.f30187b == null) {
                p.f30187b = context;
            }
            return (String) p.a(str, str2, "01234567890ABCDEF");
        } catch (Throwable unused) {
            return "01234567890ABCDEF";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x007a, code lost:
    
        if (r1 != null) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        byte[] bArr2 = null;
        bArr2 = null;
        bArr2 = null;
        bArr2 = null;
        r0 = null;
        r0 = null;
        GZIPInputStream gZIPInputStream2 = null;
        bArr2 = null;
        bArr2 = null;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(bArr);
                            try {
                                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                            } catch (Error unused) {
                                gZIPInputStream = null;
                            } catch (Exception unused2) {
                                gZIPInputStream = null;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (Error unused3) {
                            gZIPInputStream = null;
                            byteArrayInputStream = null;
                        } catch (Exception unused4) {
                            gZIPInputStream = null;
                            byteArrayInputStream = null;
                        } catch (Throwable th6) {
                            th = th6;
                            byteArrayInputStream = null;
                        }
                        try {
                            byte[] bArr3 = new byte[307200];
                            while (true) {
                                int read = gZIPInputStream.read(bArr3);
                                if (read < 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr3, 0, read);
                            }
                            bArr2 = byteArrayOutputStream.toByteArray();
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                        } catch (Error unused5) {
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return bArr2;
                        } catch (Exception unused6) {
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                        } catch (Throwable th7) {
                            gZIPInputStream2 = gZIPInputStream;
                            th = th7;
                            if (gZIPInputStream2 != null) {
                                try {
                                    gZIPInputStream2.close();
                                } catch (Exception unused7) {
                                    throw th;
                                }
                            }
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Error unused8) {
                        gZIPInputStream = null;
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                    } catch (Exception unused9) {
                        gZIPInputStream = null;
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                    } catch (Throwable th8) {
                        th = th8;
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                    }
                }
            } catch (Exception unused10) {
            }
        }
        return bArr2;
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            File[] listFiles = new File(context.getFilesDir().getAbsolutePath() + "/TencentLocation_sapp").listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                String name = file.getName();
                if (file.isDirectory() && name.contains("_atuo_") && !f30189b.contains(name)) {
                    if (name.startsWith("odex_")) {
                        if (f30189b.contains(name.replaceAll("odex_", "comp_"))) {
                        }
                    }
                    b(file.getAbsolutePath());
                    file.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static List<String> a(Context context, File file) {
        ArrayList arrayList;
        File[] listFiles;
        String str = "";
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (File file2 : listFiles) {
                arrayList.add(file2.getName() + "," + file2.length() + "," + a(file2));
                str = str + file2.getName() + "," + file2.length() + "," + a(file2) + ";";
            }
        }
        i.a("before check ,private dir files:" + str);
        return arrayList;
    }

    public static boolean b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        String[] list = file.list();
        if (list != null && list.length != 0) {
            for (String str2 : list) {
                File file2 = new File(str, str2);
                if (file2.isDirectory()) {
                    b(file2.getAbsolutePath());
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
        return true;
    }

    public static void a(Context context, Pair<String, String> pair) {
        Object obj;
        try {
            if (!"oaId".equals(pair.first) || (obj = pair.second) == null || ((String) obj).length() <= 0) {
                return;
            }
            Object obj2 = pair.second;
            f30196i = (String) obj2;
            a(context, f30195h, (String) obj2);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            if (p.f30187b == null) {
                p.f30187b = context;
            }
            p.b("TLocationSDK", str, str2);
        } catch (Throwable unused) {
        }
    }

    public static String a(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return a(messageDigest.digest());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(Context context, String str, String str2, String str3, long j3, byte[] bArr) {
        String str4 = str2 + File.separator + str3;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        boolean z16 = false;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str4);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    z16 = true;
                    fileInputStream.close();
                    return true;
                }
            }
        } catch (Exception unused) {
            return z16;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toLowerCase();
    }

    public static String b(Context context, String str) {
        StringBuilder sb5 = new StringBuilder();
        try {
            InputStream open = context.getAssets().open(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb5.append(readLine);
            }
            bufferedReader.close();
            open.close();
        } catch (UnsupportedEncodingException | IOException unused) {
        }
        return sb5.toString();
    }

    public static void a(long j3) {
        try {
            LockMethodProxy.sleep(j3);
        } catch (InterruptedException unused) {
        }
    }

    public static String a(List<a> list) {
        StringBuilder sb5 = new StringBuilder();
        for (a aVar : list) {
            sb5.append(aVar.f30128a);
            sb5.append(",");
            sb5.append(aVar.f30129b);
            sb5.append(",");
            if (!aVar.f30130c.contains(QZonePatchService.PATCH_SUFFIX_DEX)) {
                aVar.f30130c += QZonePatchService.PATCH_SUFFIX_DEX;
            }
            sb5.append(aVar.f30130c);
            sb5.append(",");
            sb5.append(aVar.f30131d);
            sb5.append(",");
            sb5.append(aVar.f30132e);
            sb5.append(",");
            sb5.append(aVar.f30133f);
            sb5.append(";");
        }
        return sb5.toString();
    }

    public static boolean a(Context context, List<a> list) {
        List<a> d16 = d(c(context, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", ""));
        if (list.size() == 0) {
            return false;
        }
        if (d16.size() == 0) {
            return d(context, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", a(list));
        }
        for (int i3 = 0; i3 < d16.size(); i3++) {
            a aVar = d16.get(i3);
            int i16 = 0;
            while (true) {
                if (i16 < list.size()) {
                    a aVar2 = list.get(i16);
                    if (aVar2.f30128a == aVar.f30128a) {
                        aVar.f30130c = aVar2.f30130c;
                        aVar.f30129b = aVar2.f30129b;
                        aVar.f30131d = aVar2.f30131d;
                        aVar.f30132e = aVar2.f30132e;
                        break;
                    }
                    i16++;
                }
            }
        }
        return d(context, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", a(d16));
    }

    public static boolean a(Context context, String str, String str2, String str3, long j3, byte[] bArr) {
        String str4 = str2 + File.separator + str3;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        boolean z16 = false;
        try {
            InputStream open = context.getResources().getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            open.available();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str4, true), 1024);
            while (true) {
                int read = open.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.close();
            byte[] b16 = b(l.a(byteArrayOutputStream.toByteArray(), "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
            if (b16 != null) {
                bufferedOutputStream.write(b16);
                bufferedOutputStream.close();
                z16 = true;
            }
            open.close();
        } catch (Exception e16) {
            i.a("copy base to private dir", e16);
        }
        return z16;
    }

    public static boolean a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
            return true;
        }
        String[] list = file.list();
        if (list != null && list.length != 0) {
            for (String str2 : list) {
                File file2 = new File(str, str2);
                if (file2.isDirectory()) {
                    b(file2.getAbsolutePath());
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
        return true;
    }

    public static double a(double d16, double d17, double d18, double d19) {
        double a16 = a(d16);
        double a17 = a(d18);
        return (Math.round(((Math.asin(Math.sqrt(Math.pow(Math.sin((a16 - a17) / 2.0d), 2.0d) + ((Math.cos(a16) * Math.cos(a17)) * Math.pow(Math.sin((a(d17) - a(d19)) / 2.0d), 2.0d)))) * 2.0d) * 6378.137d) * 10000.0d) / 10000.0d) * 1000.0d;
    }
}
