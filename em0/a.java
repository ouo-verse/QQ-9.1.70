package em0;

import com.tencent.gdtad.log.GdtLog;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Double f396582a = Double.valueOf(10000.0d);

    /* renamed from: b, reason: collision with root package name */
    private static final Double f396583b = Double.valueOf(1000000.0d);

    /* renamed from: c, reason: collision with root package name */
    private static final Double f396584c = Double.valueOf(1.0E8d);

    public static String a(long j3) {
        double doubleValue;
        double doubleValue2;
        String valueOf = String.valueOf(j3);
        double d16 = j3;
        Double d17 = f396582a;
        if (d16 > d17.doubleValue() && d16 < f396584c.doubleValue()) {
            double doubleValue3 = d16 / d17.doubleValue();
            if (d16 % d17.doubleValue() < d17.doubleValue() / 2.0d) {
                doubleValue2 = b(doubleValue3, 1, false).doubleValue();
            } else {
                doubleValue2 = b(doubleValue3, 1, true).doubleValue();
            }
            if (doubleValue2 == d17.doubleValue()) {
                return (doubleValue2 / d17.doubleValue()) + "\u4ebf\u4eba\u5df2\u4e0b\u8f7d";
            }
            return doubleValue2 + "\u4e07\u4eba\u5df2\u4e0b\u8f7d";
        }
        Double d18 = f396584c;
        if (d16 > d18.doubleValue()) {
            double doubleValue4 = d16 / d18.doubleValue();
            if (d16 % d18.doubleValue() < d18.doubleValue() / 2.0d) {
                doubleValue = b(doubleValue4, 1, false).doubleValue();
            } else {
                doubleValue = b(doubleValue4, 1, true).doubleValue();
            }
            return doubleValue + "\u4ebf\u4eba\u5df2\u4e0b\u8f7d";
        }
        return valueOf + "\u4eba\u5df2\u4e0b\u8f7d";
    }

    public static Double b(double d16, int i3, boolean z16) {
        BigDecimal bigDecimal = new BigDecimal(d16);
        try {
            if (z16) {
                return Double.valueOf(bigDecimal.setScale(i3, RoundingMode.HALF_UP).doubleValue());
            }
            return Double.valueOf(bigDecimal.setScale(i3, RoundingMode.DOWN).doubleValue());
        } catch (Throwable th5) {
            GdtLog.e("GdtDownloadNumFormatter", "formatNumber", th5);
            return Double.valueOf(0.0d);
        }
    }
}
