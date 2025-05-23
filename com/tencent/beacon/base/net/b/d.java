package com.tencent.beacon.base.net.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.beacon.a.b.i;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.d.h;
import com.tencent.beacon.pack.RequestPackage;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, String> f77725a;

    public static void a(Map<String, List<String>> map) {
        List<String> list;
        if (map == null) {
            return;
        }
        try {
            if (map.containsKey("sid") && (list = map.get("sid")) != null) {
                c(String.valueOf(list.get(0)));
            }
            if (map.containsKey("Set-Cookie")) {
                for (String str : map.get("Set-Cookie")) {
                    if (str.contains("tgw_l7_route")) {
                        b(str.substring(0, str.indexOf(59)));
                    }
                }
            }
        } catch (Throwable th5) {
            String str2 = "parse http header fail message: " + th5.getMessage();
            com.tencent.beacon.base.util.c.b(str2, new Object[0]);
            i.e().a("457", str2);
        }
    }

    private static void b(String str) {
        if (str == null) {
            return;
        }
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "update ias cookie: %s", str);
        h.c().c(str);
    }

    public static void c(Map<String, String> map) {
        if (map == null) {
            return;
        }
        try {
            if (map.containsKey("sid")) {
                c(String.valueOf(map.get("sid")));
            }
        } catch (Throwable th5) {
            String str = "parse socket header fail message: " + th5.getMessage();
            com.tencent.beacon.base.util.c.b(str, new Object[0]);
            i.e().a("407", str);
        }
    }

    public static boolean d() {
        NetworkInfo b16 = b();
        if (b16 != null && b16.isConnected()) {
            return true;
        }
        return false;
    }

    private static void e() {
        h c16 = h.c();
        if (c16 == null) {
            return;
        }
        String b16 = c16.b();
        if (b16 != null) {
            f77725a.put("Cookie", b16);
        } else {
            com.tencent.beacon.base.util.c.a("no iasCookie in http header!", new Object[0]);
            i.e().a("519", "no iasCookie in http header!");
        }
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static NetworkInfo b() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) com.tencent.beacon.a.c.c.c().b().getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th5) {
            com.tencent.beacon.base.util.c.a(th5);
            return null;
        }
    }

    public static String b(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.trim().length() > 0 && a(key)) {
                String trim = key.trim();
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append(trim.replace("|", "%7C").replace(ContainerUtils.FIELD_DELIMITER, "%26").replace(ContainerUtils.KEY_VALUE_DELIMITER, "%3D"));
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                String value = entry.getValue();
                if (value != null) {
                    sb5.append(value.trim().replace('\n', TokenParser.SP).replace('\r', TokenParser.SP).replace("|", "%7C").replace(ContainerUtils.FIELD_DELIMITER, "%26").replace(ContainerUtils.KEY_VALUE_DELIMITER, "%3D"));
                }
            } else {
                com.tencent.beacon.base.util.c.e("[core] '%s' should be ASCII code in 32-126!", key);
            }
        }
        return sb5.length() > 0 ? sb5.substring(1) : "";
    }

    private static void c(String str) {
        if (str == null) {
            return;
        }
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "update strategy sid: %s", str);
        h.c().b(str);
    }

    public static String c() {
        NetworkInfo b16 = b();
        if (b16 == null) {
            return "unknown";
        }
        if (NetworkMonitor.getType(b16) == 1) {
            return "wifi";
        }
        String netGetExInfo = NetworkMonitor.netGetExInfo(b16);
        if (netGetExInfo != null && netGetExInfo.length() > 64) {
            netGetExInfo = netGetExInfo.substring(0, 64);
        }
        return "" + netGetExInfo;
    }

    public static RequestPackage a(int i3, byte[] bArr, Map<String, String> map, String str) {
        com.tencent.beacon.a.c.c c16 = com.tencent.beacon.a.c.c.c();
        com.tencent.beacon.a.c.e l3 = com.tencent.beacon.a.c.e.l();
        RequestPackage requestPackage = new RequestPackage();
        requestPackage.model = f.e().h();
        requestPackage.osVersion = l3.t();
        requestPackage.platformId = c16.g();
        requestPackage.appkey = str;
        requestPackage.appVersion = com.tencent.beacon.a.c.b.a();
        requestPackage.sdkId = c16.h();
        requestPackage.sdkVersion = c16.i();
        requestPackage.cmd = i3;
        requestPackage.encryType = (byte) 3;
        requestPackage.zipType = (byte) 2;
        requestPackage.sBuffer = bArr;
        requestPackage.reserved = b(map);
        return requestPackage;
    }

    @Nullable
    public static Map<String, String> a(String str, Map<String, String> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int i3 = 0;
        int i16 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() == null) {
                com.tencent.beacon.base.util.c.b("BeaconEvent key can't be null!!!", new Object[i3]);
            } else {
                String valueOf = String.valueOf(entry.getKey());
                int length = valueOf.trim().length();
                if (length > 0 && a(valueOf)) {
                    String trim = valueOf.trim();
                    if (length > 64) {
                        trim = trim.substring(i3, 64);
                        String str2 = "[event] eventName: " + str + ", key: " + trim + " should be less than 64!";
                        i.e().a("102", str2);
                        com.tencent.beacon.base.util.e.a(str2);
                    }
                    String replace = trim.replace("|", "%7C").replace(ContainerUtils.FIELD_DELIMITER, "%26").replace(ContainerUtils.KEY_VALUE_DELIMITER, "%3D");
                    String trim2 = entry.getValue() == null ? "" : String.valueOf(entry.getValue()).trim();
                    if (trim2.length() > 20480) {
                        String str3 = "[event] eventName: " + str + ", key: " + replace + "'s value > 20K.";
                        i.e().a("103", str3);
                        com.tencent.beacon.base.util.e.a(str3);
                        trim2 = trim2.substring(0, 20480);
                    }
                    String replace2 = trim2.replace('\n', TokenParser.SP).replace('\r', TokenParser.SP).replace("|", "%7C").replace(ContainerUtils.FIELD_DELIMITER, "%26").replace(ContainerUtils.KEY_VALUE_DELIMITER, "%3D");
                    hashMap.put(replace, replace2);
                    i16 += replace.length() + replace2.length();
                    i3 = 0;
                } else {
                    i3 = 0;
                    com.tencent.beacon.base.util.c.e("[core] '%s' should be ASCII code in 32-126!", valueOf);
                    i.e().a("102", "[event] eventName: " + str + ", key: " + valueOf + " should be ASCII code in 32-126!");
                }
            }
        }
        if (i16 <= 46080) {
            return hashMap;
        }
        String str4 = "[event] eventName: " + str + " params > 45K";
        i.e().a("104", str4);
        com.tencent.beacon.base.util.e.a(str4);
        return null;
    }

    public static boolean a(String str) {
        int length = str.length();
        boolean z16 = true;
        while (true) {
            length--;
            if (length < 0) {
                return z16;
            }
            char charAt = str.charAt(length);
            if (charAt < ' ' || charAt >= '\u007f') {
                z16 = false;
            }
        }
    }

    public static synchronized Map<String, String> a() {
        Map<String, String> map;
        synchronized (d.class) {
            if (f77725a == null) {
                HashMap hashMap = new HashMap(4);
                f77725a = hashMap;
                hashMap.put("wup_version", "3.0");
                f77725a.put("TYPE_COMPRESS", String.valueOf(2));
                f77725a.put("encr_type", "rsapost");
                f77725a.put("Content-Type", "jce");
                h c16 = h.c();
                if (c16 != null) {
                    f77725a.put("bea_key", c16.e());
                }
            }
            if (!com.tencent.beacon.d.b.a().m()) {
                e();
            }
            map = f77725a;
        }
        return map;
    }

    public static void a(long j3, long j16, String str) {
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "fixBeaconInfo, serverTime: " + j16 + ",ip: " + str, new Object[0]);
        com.tencent.beacon.a.c.c c16 = com.tencent.beacon.a.c.c.c();
        c16.b(str);
        c16.a(j16 - ((j3 + new Date().getTime()) / 2));
    }
}
