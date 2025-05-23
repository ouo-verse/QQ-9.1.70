package com.android.volley.toolbox;

import androidx.annotation.Nullable;
import com.android.volley.c;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes.dex */
public class e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<com.android.volley.e> a(List<com.android.volley.e> list, c.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<com.android.volley.e> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<com.android.volley.e> list2 = aVar.f31324h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (com.android.volley.e eVar : aVar.f31324h) {
                    if (!treeSet.contains(eVar.a())) {
                        arrayList.add(eVar);
                    }
                }
            }
        } else if (!aVar.f31323g.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.f31323g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new com.android.volley.e(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    static String b(long j3) {
        return d("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> c(c.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = aVar.f31318b;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j3 = aVar.f31320d;
        if (j3 > 0) {
            hashMap.put("If-Modified-Since", b(j3));
        }
        return hashMap;
    }

    private static SimpleDateFormat d(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    @Nullable
    public static c.a e(com.android.volley.g gVar) {
        long j3;
        boolean z16;
        long j16;
        long j17;
        long j18;
        long j19;
        long j26;
        long j27;
        long j28;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = gVar.f31333c;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        if (str != null) {
            j3 = h(str);
        } else {
            j3 = 0;
        }
        String str2 = map.get("Cache-Control");
        int i3 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z16 = false;
            j16 = 0;
            j17 = 0;
            while (i3 < split.length) {
                String trim = split[i3].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j16 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j17 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z16 = true;
                }
                i3++;
            }
            i3 = 1;
        } else {
            z16 = false;
            j16 = 0;
            j17 = 0;
        }
        String str3 = map.get("Expires");
        if (str3 != null) {
            j18 = h(str3);
        } else {
            j18 = 0;
        }
        String str4 = map.get("Last-Modified");
        if (str4 != null) {
            j19 = h(str4);
        } else {
            j19 = 0;
        }
        String str5 = map.get("ETag");
        if (i3 != 0) {
            j27 = currentTimeMillis + (j16 * 1000);
            if (z16) {
                j28 = j27;
            } else {
                Long.signum(j17);
                j28 = (j17 * 1000) + j27;
            }
            j26 = j28;
        } else {
            j26 = 0;
            if (j3 > 0 && j18 >= j3) {
                j27 = currentTimeMillis + (j18 - j3);
                j26 = j27;
            } else {
                j27 = 0;
            }
        }
        c.a aVar = new c.a();
        aVar.f31317a = gVar.f31332b;
        aVar.f31318b = str5;
        aVar.f31322f = j27;
        aVar.f31321e = j26;
        aVar.f31319c = j3;
        aVar.f31320d = j19;
        aVar.f31323g = map;
        aVar.f31324h = gVar.f31334d;
        return aVar;
    }

    public static String f(@Nullable Map<String, String> map) {
        return g(map, "ISO-8859-1");
    }

    public static String g(@Nullable Map<String, String> map, String str) {
        if (map == null) {
            return str;
        }
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";", 0);
            for (int i3 = 1; i3 < split.length; i3++) {
                String[] split2 = split[i3].trim().split(ContainerUtils.KEY_VALUE_DELIMITER, 0);
                if (split2.length == 2 && split2[0].equals(HttpMsg.CHARSET)) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static long h(String str) {
        try {
            return d("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e16) {
            if (!"0".equals(str) && !"-1".equals(str)) {
                com.android.volley.k.d(e16, "Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            com.android.volley.k.e("Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<com.android.volley.e> i(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new com.android.volley.e(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> j(List<com.android.volley.e> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (com.android.volley.e eVar : list) {
            treeMap.put(eVar.a(), eVar.b());
        }
        return treeMap;
    }
}
