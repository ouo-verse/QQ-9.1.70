package com.tencent.mapsdk.core.utils.log;

import android.support.annotation.Keep;
import com.tencent.mapsdk.internal.hq;
import com.tencent.mapsdk.internal.kz;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LogUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, kz> f147660a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private static kz f147661b;

    public static kz a(int i3) {
        kz kzVar;
        Map<Integer, kz> map = f147660a;
        if (map.containsKey(Integer.valueOf(i3)) && (kzVar = map.get(Integer.valueOf(i3))) != null) {
            return kzVar;
        }
        if (f147661b == null) {
            f147661b = (kz) hq.a(kz.class, "Methods invoke by default Logger !");
        }
        return f147661b;
    }

    public static void b(int i3) {
        Map<Integer, kz> map = f147660a;
        if (map.containsKey(Integer.valueOf(i3))) {
            map.remove(Integer.valueOf(i3));
        }
    }

    public static void c(String str, String str2) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.c(str, str2);
        } else {
            f(str, str2);
        }
    }

    private static void d(String str, Throwable th5) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.a(str, th5);
        } else {
            f(str, th5);
        }
    }

    private static void e(String str, Throwable th5) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.c(str, th5);
        } else {
            f(str, th5);
        }
    }

    private static void f(String str) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.a(str);
        } else {
            System.out.println(str);
        }
    }

    private static void g(String str) {
        System.out.println(str);
    }

    @Keep
    static void printNativeLog(String str, String str2) {
        Map<Integer, kz> map = f147660a;
        if (map.isEmpty()) {
            return;
        }
        a(((Integer) new ArrayList(map.keySet()).get(0)).intValue()).b(str, str2);
    }

    public static void b(String str, String str2) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.b(str, str2);
        } else {
            f(str, str2);
        }
    }

    public static void c(String str) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.d(str);
        } else {
            System.out.println(str);
        }
    }

    private static void d(String str, String str2, Throwable th5) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.a(str, str2, th5);
        } else {
            f(str, str2, th5);
        }
    }

    private static void e(String str, String str2, Throwable th5) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.c(str, str2, th5);
        } else {
            f(str, str2, th5);
        }
    }

    private static void f(String str, String str2, Throwable th5) {
        System.out.println("[" + str + "]:" + str2 + th5);
    }

    public static void b(String str) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.c(str);
        } else {
            System.out.println(str);
        }
    }

    private static void f(String str, Throwable th5) {
        System.out.println(str + th5);
    }

    public static void c(String str, Throwable th5) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.e(str, th5);
        } else {
            f(str, th5);
        }
    }

    public static void d(String str, String str2) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.d(str, str2);
        } else {
            f(str, str2);
        }
    }

    public static void e(String str, String str2) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.e(str, str2);
        } else {
            f(str, str2);
        }
    }

    public static void a(int i3, kz kzVar) {
        Map<Integer, kz> map = f147660a;
        if (map.containsKey(Integer.valueOf(i3))) {
            return;
        }
        map.put(Integer.valueOf(i3), kzVar);
    }

    private static void f(String str, String str2) {
        System.out.println("[" + str + "]:" + str2);
    }

    public static void b(String str, Throwable th5) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.d(str, th5);
        } else {
            f(str, th5);
        }
    }

    public static void a(kz kzVar) {
        f147661b = kzVar;
    }

    public static void c(String str, String str2, Throwable th5) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.e(str, str2, th5);
        } else {
            f(str, str2, th5);
        }
    }

    public static void d(String str) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.e(str);
        } else {
            System.out.println(str);
        }
    }

    public static boolean e(String str) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            return kzVar.a(3, str);
        }
        return false;
    }

    public static void a(String str, String str2) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.a(str, str2);
        } else {
            f(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th5) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.d(str, str2, th5);
        } else {
            f(str, str2, th5);
        }
    }

    public static void a(String str) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.b(str);
        } else {
            System.out.println(str);
        }
    }

    public static void a(String str, Throwable th5) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.b(str, th5);
        } else {
            f(str, th5);
        }
    }

    public static void a(String str, String str2, Throwable th5) {
        kz kzVar = f147661b;
        if (kzVar != null) {
            kzVar.b(str, str2, th5);
        } else {
            f(str, str2, th5);
        }
    }

    public static String a() {
        kz kzVar = f147661b;
        if (kzVar != null) {
            return kzVar.c();
        }
        return null;
    }
}
