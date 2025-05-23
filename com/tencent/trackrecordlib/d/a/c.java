package com.tencent.trackrecordlib.d.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(@Nullable b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.f381089a;
    }

    public static Map<String, ?> b(@Nullable b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.f381090b;
    }

    public static Map<String, ?> c(@Nullable b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.f381093e;
    }

    public static String d(@Nullable b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.f381091c;
    }

    public static Map<String, ?> e(@Nullable b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.f381092d;
    }

    public static b f(b bVar) {
        b bVar2 = new b();
        bVar2.f381089a = bVar.f381089a;
        bVar2.f381090b = bVar.f381090b;
        bVar2.f381091c = bVar.f381091c;
        bVar2.f381092d = bVar.f381092d;
        bVar2.f381094f = bVar.f381094f;
        return bVar2;
    }

    public static void a(@NonNull b bVar, String str) {
        bVar.f381089a = str;
    }

    public static void b(@NonNull b bVar, String str) {
        Map<String, Object> map = bVar.f381093e;
        if (map != null) {
            map.remove(str);
        }
    }

    public static void c(@NonNull b bVar, String str) {
        bVar.f381091c = str;
    }

    @Nullable
    public static Object d(@NonNull b bVar, String str) {
        Map<String, Object> map = bVar.f381094f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static void e(@NonNull b bVar, String str) {
        Map<String, Object> map = bVar.f381094f;
        if (map != null) {
            map.remove(str);
        }
    }

    public static void a(@NonNull b bVar, Map<String, ?> map) {
        bVar.f381090b = map;
    }

    public static void a(@NonNull b bVar, String str, Object obj) {
        if (bVar.f381093e == null) {
            bVar.f381093e = new ArrayMap(1);
        }
        bVar.f381093e.put(str, obj);
    }

    public static void b(@NonNull b bVar, Map<String, ?> map) {
        bVar.f381092d = map;
    }

    public static void b(@NonNull b bVar, String str, Object obj) {
        if (bVar.f381094f == null) {
            bVar.f381094f = new HashMap(1);
        }
        bVar.f381094f.put(str, obj);
    }
}
