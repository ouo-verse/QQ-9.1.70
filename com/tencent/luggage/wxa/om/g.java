package com.tencent.luggage.wxa.om;

import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.x;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static x f137032a = new x(20);

    /* renamed from: b, reason: collision with root package name */
    public static x f137033b = new x(20);

    /* renamed from: c, reason: collision with root package name */
    public static x f137034c = new x(20);

    /* renamed from: d, reason: collision with root package name */
    public static x f137035d = new x(20);

    /* renamed from: e, reason: collision with root package name */
    public static x f137036e = new x(20);

    /* renamed from: f, reason: collision with root package name */
    public static x f137037f = new x(20);

    /* renamed from: g, reason: collision with root package name */
    public static x f137038g = new x(20);

    /* renamed from: h, reason: collision with root package name */
    public static String f137039h = null;

    /* renamed from: i, reason: collision with root package name */
    public static int f137040i = 0;

    public static String a() {
        String str = f137039h;
        if (str != null) {
            return str;
        }
        String a16 = e.a();
        if (TextUtils.isEmpty(a16)) {
            w.d("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", a16);
            return com.tencent.luggage.wxa.wm.b.a();
        }
        w.d("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", a16);
        f137039h = a16;
        return a16;
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f137032a.put(str, str2);
    }

    public static void c(String str, String str2) {
        String e16 = e(str);
        if (TextUtils.isEmpty(e16)) {
            w.b("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
        } else if (TextUtils.isEmpty(d(str))) {
            w.d("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", str, str2);
            a(str, str2);
            e.a(e16, str2);
        }
    }

    public static String d(String str) {
        if (f137037f.a(str)) {
            return (String) f137037f.get(str);
        }
        return null;
    }

    public static String e(String str) {
        if (f137032a.a(str)) {
            return (String) f137032a.get(str);
        }
        return "";
    }

    public static boolean f(String str) {
        if (f137033b.a(str)) {
            return ((Boolean) f137033b.get(str)).booleanValue();
        }
        return false;
    }

    public static String g(String str) {
        String e16 = e(str);
        if (TextUtils.isEmpty(e16)) {
            w.b("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
            return null;
        }
        return e.c(e16);
    }

    public static boolean h(String str) {
        if (f137038g.a(str)) {
            return ((Boolean) f137038g.get(str)).booleanValue();
        }
        return false;
    }

    public static void i(String str) {
        if (!TextUtils.isEmpty(e(str))) {
            return;
        }
        String f16 = e.f(str);
        if (!TextUtils.isEmpty(f16)) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(f16);
            new f(arrayList).a();
            b(str, f16);
        }
    }

    public static long b(String str) {
        return h.e(str);
    }

    public static void b(String str, int i3) {
        if (str != null) {
            f137034c.put(str, Integer.valueOf(i3));
        }
    }

    public static void b(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f137038g.put(str, Boolean.valueOf(z16));
    }

    public static int a(int i3) {
        int i16 = f137040i;
        if (i16 != 0) {
            return i16;
        }
        int a16 = e.a(i3);
        f137040i = a16;
        w.d("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", Integer.valueOf(a16));
        if (f137040i == 0) {
            f137040i = i3;
        }
        return f137040i;
    }

    public static long c(String str) {
        if (f137036e.a(str)) {
            return ((Long) f137036e.get(str)).longValue();
        }
        return -1L;
    }

    public static void a(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f137033b.put(str, Boolean.valueOf(z16));
    }

    public static void a(String str, Map map) {
        if (map != null) {
            f(str);
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f137037f.put(str, str2);
    }

    public static void a(String str, long j3) {
        if (j3 > 0) {
            f137036e.put(str, Long.valueOf(j3));
        }
    }

    public static void a(String str) {
        h.b(str);
    }

    public static void a(String str, int i3) {
        if (str != null) {
            f137035d.put(str, Integer.valueOf(i3));
        }
    }
}
