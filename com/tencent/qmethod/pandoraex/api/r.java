package com.tencent.qmethod.pandoraex.api;

import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qmethod.pandoraex.core.strategy.CacheStrategyFactory;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class r {
    public static void a(Context context) {
        if (context == null) {
            return;
        }
        CacheStrategyFactory.a(context).k(context);
    }

    public static void b() {
        DeviceInfoMonitor.clearDeviceInfoMemoryCache();
        NetworkMonitor.clearNetworkMemoryCache();
        com.tencent.qmethod.pandoraex.core.e.a();
        com.tencent.qmethod.pandoraex.core.o.c("PandoraExStorage", "PandoraEx Memory Cache Clear");
    }

    public static Boolean c(Context context, String str) {
        if (context == null) {
            return Boolean.FALSE;
        }
        return CacheStrategyFactory.a(context).m(context, str);
    }

    public static Boolean d(Context context, String str) {
        if (context == null) {
            return Boolean.FALSE;
        }
        return CacheStrategyFactory.a(context).g(context, str);
    }

    public static int e(Context context, String str) {
        return CacheStrategyFactory.a(context).b(context, str).intValue();
    }

    public static <T> List<T> f(Context context, String str, Class cls) {
        if (context == null) {
            return new ArrayList();
        }
        return CacheStrategyFactory.a(context).l(context, str, cls);
    }

    public static Long g(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return CacheStrategyFactory.a(context).f(context, str);
    }

    public static <T extends Parcelable> T h(Context context, String str, Class<T> cls) {
        return (T) CacheStrategyFactory.a(context).h(context, str, cls);
    }

    @Nullable
    public static <T> T i(Context context, String str, Class cls) {
        if (cls == String.class) {
            return (T) j(context, str);
        }
        if (cls == Integer.TYPE) {
            return (T) Integer.valueOf(e(context, str));
        }
        if (cls == Boolean.TYPE) {
            return (T) d(context, str);
        }
        if (cls == Long.TYPE) {
            return (T) g(context, str);
        }
        if (cls == List.class) {
            return (T) f(context, str, cls);
        }
        return null;
    }

    public static String j(Context context, String str) {
        if (context == null) {
            return "";
        }
        String a16 = CacheStrategyFactory.a(context).a(context, str);
        if (TextUtils.isEmpty(a16) || "data is null".equals(a16)) {
            return "";
        }
        return com.tencent.qmethod.pandoraex.core.u.a(a16);
    }

    public static void k(Context context, String str) {
        if (context == null) {
            return;
        }
        CacheStrategyFactory.a(context).j(context, str);
    }

    public static boolean l(Context context, String str, Parcelable parcelable) {
        return CacheStrategyFactory.a(context).i(context, str, parcelable);
    }

    public static boolean m(Context context, String str, Boolean bool) {
        if (context == null) {
            return false;
        }
        return CacheStrategyFactory.a(context).n(context, str, bool);
    }

    public static boolean n(Context context, String str, Integer num) {
        return CacheStrategyFactory.a(context).e(context, str, num);
    }

    public static boolean o(Context context, String str, Long l3) {
        if (context == null) {
            return false;
        }
        return CacheStrategyFactory.a(context).c(context, str, l3);
    }

    public static boolean p(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        String b16 = com.tencent.qmethod.pandoraex.core.u.b(str2);
        if (b16 == null) {
            b16 = "";
        }
        return CacheStrategyFactory.a(context).d(context, str, b16);
    }

    public static <T> boolean q(Context context, String str, List<T> list) {
        if (context == null) {
            return false;
        }
        return CacheStrategyFactory.a(context).o(context, str, list);
    }

    public static boolean r(Context context, String str, Object obj, Class cls) {
        if (obj instanceof String) {
            return p(context, str, (String) obj);
        }
        if (obj instanceof Integer) {
            return n(context, str, Integer.valueOf(((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return m(context, str, (Boolean) obj);
        }
        if (obj instanceof Long) {
            return o(context, str, Long.valueOf(((Long) obj).longValue()));
        }
        if (obj instanceof List) {
            return q(context, str, (List) obj);
        }
        if (obj == null && cls == String.class) {
            return p(context, str, "");
        }
        return false;
    }

    public static void s(g gVar) {
        CacheStrategyFactory.b(gVar);
    }

    public static void t(Context context, boolean z16) {
        CacheStrategyFactory.c(context, z16);
    }

    public static void u(Context context, boolean z16, String str) {
        CacheStrategyFactory.d(context, z16, str);
    }
}
