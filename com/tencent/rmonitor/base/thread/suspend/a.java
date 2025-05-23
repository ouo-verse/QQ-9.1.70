package com.tencent.rmonitor.base.thread.suspend;

import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static WeakHashMap<Thread, Long> f365441a = new WeakHashMap<>();

    public static long a(Thread thread) {
        try {
            Long l3 = f365441a.get(thread);
            if (l3 != null && l3.intValue() != 0) {
                return l3.longValue();
            }
            Long l16 = (Long) b(thread, "nativePeer");
            if (l16 != null) {
                f365441a.put(thread, l16);
                return l16.longValue();
            }
            return -1L;
        } catch (Throwable th5) {
            Logger.f365497g.e("RMonitor_ThreadSuspend", "getNativeThreadAddr " + th5);
            return -1L;
        }
    }

    private static Object b(Object obj, String str) {
        try {
            Field declaredField = Thread.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th5) {
            Logger.f365497g.e("RMonitor_ThreadSuspend", "getPrivateField " + th5);
            return null;
        }
    }
}
