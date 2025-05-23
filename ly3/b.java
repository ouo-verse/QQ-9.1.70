package ly3;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    public static boolean a(Throwable th5, Class cls) {
        boolean z16 = false;
        if (th5 != null && cls != null) {
            while (th5 != null) {
                z16 = cls.isAssignableFrom(th5.getClass());
                if (z16) {
                    break;
                }
                th5 = th5.getCause();
            }
        }
        return z16;
    }
}
