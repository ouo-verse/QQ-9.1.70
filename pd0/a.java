package pd0;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static String a(int i3) {
        try {
            StackTraceElement[] stackTrace = new RuntimeException("getStackTrace").getStackTrace();
            StringBuilder sb5 = new StringBuilder();
            if (stackTrace.length <= i3) {
                i3 = stackTrace.length;
            }
            for (int i16 = 2; i16 < i3; i16++) {
                sb5.append(stackTrace[i16].toString());
            }
            return sb5.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
