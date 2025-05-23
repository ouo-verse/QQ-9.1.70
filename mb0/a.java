package mb0;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static int a(long j3) {
        if (j3 == 0) {
            return 0;
        }
        return (int) (j3 / 1000);
    }

    public static long b(int i3) {
        if (i3 == 0) {
            return 0L;
        }
        return i3 * 1000;
    }

    public static int c(long j3, long j16) {
        if (j3 != 0 && j16 != 0) {
            long j17 = j16 / 1000;
            return ((int) j17) * ((int) (((int) (j3 / 1000)) / j17));
        }
        return 0;
    }
}
