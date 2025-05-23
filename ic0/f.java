package ic0;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {
    public static int a(String str, int i3) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i3;
        }
    }

    public static long b(String str, long j3) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j3;
        }
    }
}
