package com.tencent.qmethod.pandoraex.monitor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReflectMonitor {
    private static final String TAG = "ReflectMonitor";

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        r2 = java.lang.Class.forName(r4.f448441e).getDeclaredMethod(r4.f448442f, xr3.c.d(r4.f448443g));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
    
        if (r10 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
    
        r6 = new java.lang.Object[r11.length + 1];
        java.lang.System.arraycopy(r11, 0, r6, 1, r11.length);
        r6[0] = r10;
        r11 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
    
        com.tencent.qmethod.pandoraex.core.o.a(com.tencent.qmethod.pandoraex.monitor.ReflectMonitor.TAG, "[onInvoke] class: " + r1 + ", method: " + r5 + ", param size: " + r11.length + ", dstClass: " + r4.f448441e + ", dstMethod: " + r2.getName());
        r2.setAccessible(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00aa, code lost:
    
        return r2.invoke(null, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object invoke(Method method, Object obj, Object... objArr) throws InvocationTargetException, IllegalAccessException {
        String name = method.getDeclaringClass().getName();
        List<xr3.b> list = xr3.a.f448435a.get(name);
        if (list != null) {
            Iterator<xr3.b> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                xr3.b next = it.next();
                String name2 = method.getName();
                if (next.f448438b.equals(name2)) {
                    try {
                        if (xr3.c.b(method.getParameterTypes(), next.f448439c)) {
                            try {
                                break;
                            } catch (Throwable th5) {
                                com.tencent.qmethod.pandoraex.core.o.d(TAG, "[onInvoke] invoke replaced method err: ", th5);
                            }
                        }
                    } catch (Throwable th6) {
                        com.tencent.qmethod.pandoraex.core.o.d(TAG, "[onInvoke] find method err: ", th6);
                    }
                }
            }
        }
        method.setAccessible(true);
        return method.invoke(obj, objArr);
    }
}
