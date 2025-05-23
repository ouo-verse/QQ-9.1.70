package i;

import com.tencent.mobileqq.qqbattery.feature.g;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public final class a {
    public static String a() {
        return b(new Throwable().getStackTrace());
    }

    public static String b(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null) {
            ArrayList arrayList = new ArrayList(stackTraceElementArr.length);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (!className.contains("com.tencent.mobileqq.qqbattery") && !className.contains("java.lang.reflect") && !className.contains("$Proxy2") && !className.contains("android.os")) {
                    arrayList.add(stackTraceElement);
                }
            }
            StringBuilder sb5 = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                StackTraceElement stackTraceElement2 = (StackTraceElement) it.next();
                sb5.append("\n");
                sb5.append("at ");
                sb5.append(stackTraceElement2);
            }
            if (sb5.length() > 0) {
                StringBuilder a16 = g.a("QQBattery");
                a16.append(sb5.toString());
                return a16.toString();
            }
        }
        return "";
    }
}
