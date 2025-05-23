package com.tencent.luggage.wxa.t9;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w0;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static volatile long f141148a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f141149b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Map f141150c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public static final Map f141151d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final Map f141152e = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public boolean f141154b;

        /* renamed from: d, reason: collision with root package name */
        public String f141156d;

        /* renamed from: e, reason: collision with root package name */
        public String f141157e;

        /* renamed from: f, reason: collision with root package name */
        public String f141158f;

        /* renamed from: c, reason: collision with root package name */
        public String f141155c = w0.b().toString();

        /* renamed from: a, reason: collision with root package name */
        public long f141153a = System.currentTimeMillis();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public static void a(int i3) {
            s.a();
        }

        public static void b(int i3, String str) {
            a(i3, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", Integer.valueOf(i3), Integer.valueOf(s.f141149b.size()), Integer.valueOf(s.f141150c.size()), Integer.valueOf(s.f141151d.size()), Integer.valueOf(s.f141152e.size()), Boolean.FALSE, "", "", "", str));
        }

        public static void a(int i3, a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            String str = aVar.f141158f;
            a(i3, String.format(Locale.US, "%d,%d,%d,%d,%d,%b,%s,%s,%s,%s", Integer.valueOf(i3), Integer.valueOf(s.f141149b.size()), Integer.valueOf(s.f141150c.size()), Integer.valueOf(s.f141151d.size()), Integer.valueOf(s.f141152e.size()), Boolean.valueOf(aVar.f141154b), aVar.f141156d, aVar.f141157e, str != null ? str.replace(",", ";") : "", aVar.f141155c));
        }

        public static void a(int i3, String str) {
            s.a();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCodecProxyUtils", "reportKVImpl xSwitch:[%s], reportKey:[%d], kv:[%s]", Boolean.FALSE, Integer.valueOf(i3), str);
        }
    }

    public static /* synthetic */ o a() {
        return null;
    }

    public static void f() {
        Map map = f141149b;
        int size = map.size();
        Map map2 = f141150c;
        int size2 = size + map2.size();
        Map map3 = f141151d;
        int size3 = size2 + map3.size();
        Map map4 = f141152e;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCodecProxyUtils", "codecCountCheck allsize:[%d], audioEncodeMap:[%d], audioDecodeMap:[%d], videoEncodeMap:[%d], videoDecodeMap:[%d]", Integer.valueOf(size3 + map4.size()), Integer.valueOf(map.size()), Integer.valueOf(map2.size()), Integer.valueOf(map3.size()), Integer.valueOf(map4.size()));
        a(map2, 12);
        a(map, 13);
        a(map4, 14);
        a(map3, 15);
    }

    public static boolean g() {
        return com.tencent.luggage.wxa.tn.z.i().contains(":appbrand");
    }

    public static a a(int i3, boolean z16, String str) {
        a aVar = new a();
        aVar.f141156d = str;
        aVar.f141154b = z16;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCodecProxyUtils", "insertMapWithMimeType, isEncode:[%b],mimeType:[%s]", Boolean.valueOf(z16), str);
        if (str.contains("video/")) {
            if (z16) {
                f141151d.put(Integer.valueOf(i3), aVar);
            } else {
                f141152e.put(Integer.valueOf(i3), aVar);
            }
        } else if (!str.contains("audio/")) {
            b.a(20);
            b.a(20, aVar);
        } else if (z16) {
            f141149b.put(Integer.valueOf(i3), aVar);
        } else {
            f141150c.put(Integer.valueOf(i3), aVar);
        }
        return aVar;
    }

    public static boolean a(int i3) {
        if (f141149b.remove(Integer.valueOf(i3)) != null) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxyUtils", "removeMap audioEncodeMap success");
            return true;
        }
        if (f141150c.remove(Integer.valueOf(i3)) != null) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxyUtils", "removeMap audioDecodeMap success");
            return true;
        }
        if (f141151d.remove(Integer.valueOf(i3)) != null) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxyUtils", "removeMap videoEncodeMap success");
            return true;
        }
        if (f141152e.remove(Integer.valueOf(i3)) != null) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxyUtils", "removeMap videoDecodeMap success");
            return true;
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxyUtils", "removeMap fail");
        b.a(22);
        b.a(22, new a());
        return false;
    }

    public static void a(Map map, int i3) {
        if (map.size() >= 8) {
            char c16 = 0;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl type:[%d], map.size:[%d], process:[%s]", Integer.valueOf(i3), Integer.valueOf(map.size()), com.tencent.luggage.wxa.tn.z.i());
            if (f141148a + 30000 >= System.currentTimeMillis()) {
                if (f141148a != 0) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl report return, time diff is %s", Long.valueOf(System.currentTimeMillis() - f141148a));
                    return;
                }
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl first time");
            }
            f141148a = System.currentTimeMillis();
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl start leak report, time:%s", Long.valueOf(f141148a));
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            Set keySet = map.keySet();
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = keySet.iterator();
            while (it.hasNext()) {
                a aVar = (a) map.get((Integer) it.next());
                if (aVar != null) {
                    String str = aVar.f141158f;
                    String replace = str != null ? str.replace(",", ";") : "";
                    sb5.append(aVar.f141154b);
                    sb5.append(";");
                    sb5.append(aVar.f141156d);
                    sb5.append(";");
                    sb5.append(aVar.f141157e);
                    sb5.append(";");
                    sb5.append(com.tencent.luggage.wxa.tn.z.i());
                    sb5.append(";");
                    sb5.append(replace);
                    sb5.append(";");
                    sb5.append(aVar.f141155c);
                    sb5.append("|");
                    long j3 = currentTimeMillis - aVar.f141153a;
                    if (j3 > 600000) {
                        Iterator it5 = it;
                        Object[] objArr = new Object[1];
                        objArr[c16] = Long.valueOf(j3);
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCodecProxyUtils", "codecCountCheckImpl diffTime:[%s] ", objArr);
                        sb6.append(j3);
                        sb6.append(";");
                        sb6.append(aVar.f141154b);
                        sb6.append(";");
                        sb6.append(aVar.f141156d);
                        sb6.append(";");
                        sb6.append(aVar.f141157e);
                        sb6.append(";");
                        sb6.append(com.tencent.luggage.wxa.tn.z.i());
                        sb6.append(";");
                        sb6.append(replace);
                        sb6.append(";");
                        sb6.append(aVar.f141155c);
                        sb6.append("|");
                        it = it5;
                        c16 = 0;
                    }
                }
            }
            if (i3 == 12) {
                b.a(12);
                if (!TextUtils.isEmpty(sb6.toString())) {
                    b.a(192);
                    if (com.tencent.luggage.wxa.tn.z.m()) {
                        b.b(192, sb5.toString());
                    }
                }
                if (com.tencent.luggage.wxa.tn.z.m()) {
                    b.a(180);
                    b.b(180, sb5.toString());
                    return;
                } else if (g()) {
                    b.a(184);
                    return;
                } else {
                    b.a(188);
                    return;
                }
            }
            if (i3 == 13) {
                b.a(13);
                if (!TextUtils.isEmpty(sb6.toString())) {
                    b.a(193);
                    if (com.tencent.luggage.wxa.tn.z.m()) {
                        b.b(193, sb5.toString());
                    }
                }
                if (com.tencent.luggage.wxa.tn.z.m()) {
                    b.a(181);
                    b.b(181, sb5.toString());
                    return;
                } else if (g()) {
                    b.a(185);
                    return;
                } else {
                    b.a(189);
                    return;
                }
            }
            if (i3 == 14) {
                b.a(14);
                if (!TextUtils.isEmpty(sb6.toString())) {
                    b.a(194);
                    if (com.tencent.luggage.wxa.tn.z.m()) {
                        b.b(194, sb5.toString());
                    }
                }
                if (com.tencent.luggage.wxa.tn.z.m()) {
                    b.a(182);
                    b.b(182, sb5.toString());
                    return;
                } else if (g()) {
                    b.a(186);
                    return;
                } else {
                    b.a(190);
                    return;
                }
            }
            if (i3 == 15) {
                b.a(15);
                if (!TextUtils.isEmpty(sb6.toString())) {
                    b.a(195);
                    if (com.tencent.luggage.wxa.tn.z.m()) {
                        b.b(195, sb5.toString());
                    }
                }
                if (com.tencent.luggage.wxa.tn.z.m()) {
                    b.a(183);
                    b.b(183, sb5.toString());
                } else if (g()) {
                    b.a(187);
                } else {
                    b.a(191);
                }
            }
        }
    }

    public static boolean a(String str, a aVar) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            for (String str2 : codecInfoAt.getSupportedTypes()) {
                if (TextUtils.equals(str2, str)) {
                    aVar.f141157e = codecInfoAt.getName();
                    return true;
                }
            }
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxyUtils", "mimeTypeSupportCheck error, type unsupport:[%s]", str);
        b.a(23);
        b.a(23, aVar);
        return false;
    }

    public static void a(boolean z16, String str, a aVar) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCodecProxyUtils", "isEncode:[%b], mimeType:[%s]", Boolean.valueOf(z16), str);
        if (str.contains("video/")) {
            if (z16) {
                b.a(6);
                b.a(6, aVar);
                return;
            } else {
                b.a(5);
                b.a(5, aVar);
                return;
            }
        }
        if (str.contains("audio/")) {
            if (z16) {
                b.a(4);
                b.a(4, aVar);
            } else {
                b.a(3);
                b.a(3, aVar);
            }
        }
    }
}
