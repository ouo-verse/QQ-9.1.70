package com.tencent.qqperf.monitor.crash.tools;

import android.app.Activity;
import com.tencent.component.media.image.ProgressTracer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    public static String a() {
        StringBuilder sb5 = new StringBuilder(10);
        try {
            HashMap hashMap = new HashMap();
            Object[][] b16 = b(new Class[]{Activity.class});
            if (b16 != null) {
                int length = b16[0].length;
                sb5.append("\nTotal Count: ");
                sb5.append(length);
                sb5.append("\n");
                for (int i3 = 0; i3 < length; i3++) {
                    String name = b16[0][i3].getClass().getName();
                    if (!hashMap.containsKey(name)) {
                        hashMap.put(name, 1);
                    } else {
                        hashMap.put(name, Integer.valueOf(((Integer) hashMap.get(name)).intValue() + 1));
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb5.append((String) entry.getKey());
                    sb5.append(ProgressTracer.SEPARATOR);
                    sb5.append(entry.getValue());
                    sb5.append("\n");
                }
            }
        } catch (Throwable unused) {
        }
        return sb5.toString();
    }

    private static Object[][] b(Class[] clsArr) {
        try {
            return (Object[][]) Class.forName("dalvik.system.VMDebug").getDeclaredMethod("getInstancesOfClasses", Class[].class, Boolean.TYPE).invoke(null, clsArr, Boolean.TRUE);
        } catch (Throwable unused) {
            return null;
        }
    }
}
