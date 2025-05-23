package mqq.util;

import java.util.Random;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SampleUtils {
    public static Random random = new Random(0);

    public static boolean hitReport(int i3, int i16) {
        if (random.nextInt(i3) < i16) {
            return true;
        }
        return false;
    }
}
