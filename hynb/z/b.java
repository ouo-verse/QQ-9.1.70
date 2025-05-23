package hynb.z;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.ads.data.AdParam;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f406922a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f406923b = "";

    /* renamed from: c, reason: collision with root package name */
    public static Context f406924c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f406925d = false;

    /* renamed from: e, reason: collision with root package name */
    public static String f406926e = "";

    /* renamed from: f, reason: collision with root package name */
    public static long f406927f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static long f406928g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static String f406929h = "";

    /* renamed from: i, reason: collision with root package name */
    public static long f406930i;

    /* renamed from: j, reason: collision with root package name */
    public static int f406931j;

    /* renamed from: k, reason: collision with root package name */
    public static long f406932k;

    public static ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(f406922a);
        return arrayList;
    }

    public static void b(long j3) {
        if (f406927f > 0) {
            f406927f = j3;
            f406928g = SystemClock.elapsedRealtime();
        }
    }

    public static String c() {
        return hynb.m.a.c();
    }

    public static String d() {
        if (f406925d) {
            return "http://testws.va.huya.com/json";
        }
        return "https://wsapi.huya.com/json";
    }

    public static long e() {
        if (f406927f > 0) {
            return f406927f + (SystemClock.elapsedRealtime() - f406928g);
        }
        return System.currentTimeMillis();
    }

    public static String f() {
        return hynb.m.a.c() + "," + Build.VERSION.SDK + "," + Build.VERSION.RELEASE;
    }

    public static String g() {
        try {
            return InstalledAppListMonitor.getPackageInfo(f406924c.getPackageManager(), f406924c.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static Map<String, Object> a(String str) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("appId", f406922a);
        hashMap2.put("context", str);
        hashMap2.put("openAppId", f406926e);
        hashMap2.put("version", "1.0");
        hashMap.put("header", hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(AdParam.APPVER, g());
        hashMap3.put("sdkVer", "1.0.18");
        hashMap3.put("appSign", a(f406922a, f406923b, g()));
        hashMap.put("protoInfo", hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put(Constants.SP_DEVICE_ID, b());
        hashMap4.put("deviceName", c());
        hashMap4.put("systemVer", f());
        hashMap4.put("systemInfo", "android");
        hashMap4.put("terminalType", 1);
        hashMap.put("deviceInfo", hashMap4);
        return hashMap;
    }

    public static String b() {
        if (!f406929h.isEmpty()) {
            return f406929h;
        }
        a aVar = new a(f406924c);
        String a16 = aVar.a("HY_UDB_DEVICE_DATA");
        f406929h = a16;
        if (a16.isEmpty()) {
            String a17 = a(UUID.randomUUID().toString().getBytes());
            f406929h = a17;
            aVar.a("HY_UDB_DEVICE_DATA", a17);
        }
        return f406929h;
    }

    public static String a(String str, String str2, String str3) {
        return a((str + "_" + str3 + "_" + str2).getBytes());
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            for (int i3 = 0; i3 < digest.length; i3++) {
                if (Integer.toHexString(digest[i3] & 255).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(digest[i3] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i3] & 255));
                }
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    public static long a(long j3) {
        if (j3 == f406932k) {
            f406931j++;
        } else {
            f406931j = 0;
            f406932k = j3;
        }
        return (j3 << 16) | f406931j;
    }
}
