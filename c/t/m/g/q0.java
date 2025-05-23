package c.t.m.g;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes.dex */
public class q0 {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, ThreadLocal<SimpleDateFormat>> f29952a = new HashMap<>();

    public static String a(String str) {
        return a(str, System.currentTimeMillis());
    }

    public static synchronized SimpleDateFormat b(String str) {
        SimpleDateFormat simpleDateFormat;
        synchronized (q0.class) {
            ThreadLocal<SimpleDateFormat> threadLocal = f29952a.get(str);
            if (threadLocal == null) {
                threadLocal = new ThreadLocal<>();
                f29952a.put(str, threadLocal);
            }
            simpleDateFormat = threadLocal.get();
            if (simpleDateFormat == null) {
                simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
                threadLocal.set(simpleDateFormat);
            }
        }
        return simpleDateFormat;
    }

    public static String a(String str, long j3) {
        return b(str).format(new Date(j3));
    }
}
