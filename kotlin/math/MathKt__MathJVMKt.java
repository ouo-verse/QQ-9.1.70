package kotlin.math;

import com.heytap.databaseengine.apiv3.data.Element;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b8\u001a\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010!\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010!\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010#\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010#\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010%\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010%\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010&\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010&\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010'\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010'\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010(\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010)\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010)\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010*\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0018\u0010+\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0007\u001a\u0018\u0010+\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0007\u001a\u0011\u0010-\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u0010.\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0019\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0087\b\u001a\u0019\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0087\b\u001a\u0019\u00102\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0087\b\u001a\u0019\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0087\b\u001a\u0019\u00102\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0087\b\u001a\u0019\u00102\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0087\b\u001a\u0011\u00103\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00103\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00104\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00104\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00105\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00105\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00106\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00106\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00108\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00108\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u00109\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u00109\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0015\u0010:\u001a\u00020\u0001*\u00020\u00012\u0006\u0010;\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010:\u001a\u00020\u0006*\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0087\b\u001a\r\u0010<\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010<\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u0010=\u001a\u00020\u0001*\u00020\u00012\u0006\u0010>\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010=\u001a\u00020\u0006*\u00020\u00062\u0006\u0010>\u001a\u00020\u0006H\u0087\b\u001a\r\u0010?\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010?\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\f\u0010A\u001a\u00020\t*\u00020\u0001H\u0007\u001a\f\u0010A\u001a\u00020\t*\u00020\u0006H\u0007\u001a\f\u0010B\u001a\u00020\f*\u00020\u0001H\u0007\u001a\f\u0010B\u001a\u00020\f*\u00020\u0006H\u0007\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\tH\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0087\b\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\u0000\u001a\u00020\u0006*\u00020\u00068\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0002\u0010\u0007\u001a\u0004\b\u0004\u0010\b\"\u001f\u0010\u0000\u001a\u00020\t*\u00020\t8\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0002\u0010\n\u001a\u0004\b\u0004\u0010\u000b\"\u001f\u0010\u0000\u001a\u00020\f*\u00020\f8\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0002\u0010\r\u001a\u0004\b\u0004\u0010\u000e\"\u001f\u0010\u000f\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"\u001f\u0010\u000f\u001a\u00020\u0006*\u00020\u00068\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\t8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\"\u001f\u0010\u0013\u001a\u00020\u0006*\u00020\u00068\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\b\u00a8\u0006D"}, d2 = {"absoluteValue", "", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "getSign$annotations", "getSign", "(J)I", "ulp", "getUlp$annotations", "getUlp", "abs", HippyTKDListViewAdapter.X, DomainData.DOMAIN_NAME, "acos", "acosh", "asin", "asinh", "atan", "atan2", "y", "atanh", "cbrt", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", "log", PM.BASE, "log10", "log2", "max", "a", "b", Element.ELEMENT_NAME_MIN, "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", "to", "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/math/MathKt")
/* loaded from: classes28.dex */
public class MathKt__MathJVMKt extends MathKt__MathHKt {
    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double IEEErem(double d16, double d17) {
        return Math.IEEEremainder(d16, d17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double abs(double d16) {
        return Math.abs(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double acos(double d16) {
        return Math.acos(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static final double acosh(double d16) {
        if (d16 < 1.0d) {
            return Double.NaN;
        }
        if (d16 > Constants.upper_taylor_2_bound) {
            return Math.log(d16) + Constants.LN2;
        }
        double d17 = 1;
        double d18 = d16 - d17;
        if (d18 >= Constants.taylor_n_bound) {
            return Math.log(d16 + Math.sqrt((d16 * d16) - d17));
        }
        double sqrt = Math.sqrt(d18);
        if (sqrt >= Constants.taylor_2_bound) {
            sqrt -= ((sqrt * sqrt) * sqrt) / 12;
        }
        return sqrt * Math.sqrt(2.0d);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double asin(double d16) {
        return Math.asin(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static final double asinh(double d16) {
        double d17 = Constants.taylor_n_bound;
        if (d16 < d17) {
            if (d16 <= (-d17)) {
                return -asinh(-d16);
            }
            return Math.abs(d16) >= Constants.taylor_2_bound ? d16 - (((d16 * d16) * d16) / 6) : d16;
        }
        if (d16 <= Constants.upper_taylor_n_bound) {
            return Math.log(d16 + Math.sqrt((d16 * d16) + 1));
        }
        if (d16 > Constants.upper_taylor_2_bound) {
            return Math.log(d16) + Constants.LN2;
        }
        double d18 = d16 * 2;
        return Math.log(d18 + (1 / d18));
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double atan(double d16) {
        return Math.atan(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double atan2(double d16, double d17) {
        return Math.atan2(d16, d17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static final double atanh(double d16) {
        if (Math.abs(d16) < Constants.taylor_n_bound) {
            return Math.abs(d16) > Constants.taylor_2_bound ? d16 + (((d16 * d16) * d16) / 3) : d16;
        }
        double d17 = 1;
        return Math.log((d17 + d16) / (d17 - d16)) / 2;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final double cbrt(double d16) {
        return Math.cbrt(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double ceil(double d16) {
        return Math.ceil(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double cos(double d16) {
        return Math.cos(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double cosh(double d16) {
        return Math.cosh(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double exp(double d16) {
        return Math.exp(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double expm1(double d16) {
        return Math.expm1(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double floor(double d16) {
        return Math.floor(d16);
    }

    private static final double getAbsoluteValue(double d16) {
        return Math.abs(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(double d16) {
    }

    public static int getSign(int i3) {
        if (i3 < 0) {
            return -1;
        }
        return i3 > 0 ? 1 : 0;
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(double d16) {
    }

    private static final double getUlp(double d16) {
        return Math.ulp(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(double d16) {
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double hypot(double d16, double d17) {
        return Math.hypot(d16, d17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double ln(double d16) {
        return Math.log(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double ln1p(double d16) {
        return Math.log1p(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static final double log(double d16, double d17) {
        if (d17 <= 0.0d) {
            return Double.NaN;
        }
        if (d17 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d16) / Math.log(d17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double log10(double d16) {
        return Math.log10(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static final double log2(double d16) {
        return Math.log(d16) / Constants.LN2;
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double max(double d16, double d17) {
        return Math.max(d16, d17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double min(double d16, double d17) {
        return Math.min(d16, d17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double nextDown(double d16) {
        return Math.nextAfter(d16, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double nextTowards(double d16, double d17) {
        return Math.nextAfter(d16, d17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double nextUp(double d16) {
        return Math.nextUp(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double pow(double d16, double d17) {
        return Math.pow(d16, d17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double round(double d16) {
        return Math.rint(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static int roundToInt(double d16) {
        if (Double.isNaN(d16)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d16 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d16 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static long roundToLong(double d16) {
        if (Double.isNaN(d16)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double sign(double d16) {
        return Math.signum(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double sin(double d16) {
        return Math.sin(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double sinh(double d16) {
        return Math.sinh(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double sqrt(double d16) {
        return Math.sqrt(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double tan(double d16) {
        return Math.tan(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double tanh(double d16) {
        return Math.tanh(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static final double truncate(double d16) {
        if (Double.isNaN(d16) || Double.isInfinite(d16)) {
            return d16;
        }
        if (d16 > 0.0d) {
            return Math.floor(d16);
        }
        return Math.ceil(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double withSign(double d16, double d17) {
        return Math.copySign(d16, d17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float IEEErem(float f16, float f17) {
        return (float) Math.IEEEremainder(f16, f17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float abs(float f16) {
        return Math.abs(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float acos(float f16) {
        return (float) Math.acos(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float asin(float f16) {
        return (float) Math.asin(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float atan(float f16) {
        return (float) Math.atan(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float atan2(float f16, float f17) {
        return (float) Math.atan2(f16, f17);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final float cbrt(float f16) {
        return (float) Math.cbrt(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float ceil(float f16) {
        return (float) Math.ceil(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float cos(float f16) {
        return (float) Math.cos(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float cosh(float f16) {
        return (float) Math.cosh(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float exp(float f16) {
        return (float) Math.exp(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float expm1(float f16) {
        return (float) Math.expm1(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float floor(float f16) {
        return (float) Math.floor(f16);
    }

    private static final float getAbsoluteValue(float f16) {
        return Math.abs(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(float f16) {
    }

    public static int getSign(long j3) {
        if (j3 < 0) {
            return -1;
        }
        return j3 > 0 ? 1 : 0;
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(float f16) {
    }

    private static final float getUlp(float f16) {
        return Math.ulp(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(float f16) {
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float hypot(float f16, float f17) {
        return (float) Math.hypot(f16, f17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float ln(float f16) {
        return (float) Math.log(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float ln1p(float f16) {
        return (float) Math.log1p(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static float log(float f16, float f17) {
        if (f17 <= 0.0f) {
            return Float.NaN;
        }
        if (f17 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log(f16) / Math.log(f17));
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float log10(float f16) {
        return (float) Math.log10(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static final float log2(float f16) {
        return (float) (Math.log(f16) / Constants.LN2);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float max(float f16, float f17) {
        return Math.max(f16, f17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float min(float f16, float f17) {
        return Math.min(f16, f17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float nextDown(float f16) {
        return Math.nextAfter(f16, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float nextTowards(float f16, float f17) {
        return Math.nextAfter(f16, f17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float nextUp(float f16) {
        return Math.nextUp(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double pow(double d16, int i3) {
        return Math.pow(d16, i3);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float round(float f16) {
        return (float) Math.rint(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static long roundToLong(float f16) {
        long roundToLong;
        roundToLong = roundToLong(f16);
        return roundToLong;
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float sign(float f16) {
        return Math.signum(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float sin(float f16) {
        return (float) Math.sin(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float sinh(float f16) {
        return (float) Math.sinh(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float sqrt(float f16) {
        return (float) Math.sqrt(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float tan(float f16) {
        return (float) Math.tan(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float tanh(float f16) {
        return (float) Math.tanh(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double withSign(double d16, int i3) {
        return Math.copySign(d16, i3);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final int abs(int i3) {
        return Math.abs(i3);
    }

    private static final int getAbsoluteValue(int i3) {
        return Math.abs(i3);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(int i3) {
    }

    private static final double getSign(double d16) {
        return Math.signum(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static /* synthetic */ void getSign$annotations(int i3) {
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final int max(int i3, int i16) {
        return Math.max(i3, i16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final int min(int i3, int i16) {
        return Math.min(i3, i16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float pow(float f16, float f17) {
        return (float) Math.pow(f16, f17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float withSign(float f16, float f17) {
        return Math.copySign(f16, f17);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final long abs(long j3) {
        return Math.abs(j3);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float atanh(float f16) {
        return (float) atanh(f16);
    }

    private static final long getAbsoluteValue(long j3) {
        return Math.abs(j3);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(long j3) {
    }

    private static final float getSign(float f16) {
        return Math.signum(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static /* synthetic */ void getSign$annotations(long j3) {
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final long max(long j3, long j16) {
        return Math.max(j3, j16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final long min(long j3, long j16) {
        return Math.min(j3, j16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float pow(float f16, int i3) {
        return (float) Math.pow(f16, i3);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static int roundToInt(float f16) {
        if (Float.isNaN(f16)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    public static final float truncate(float f16) {
        double ceil;
        if (Float.isNaN(f16) || Float.isInfinite(f16)) {
            return f16;
        }
        if (f16 > 0.0f) {
            ceil = Math.floor(f16);
        } else {
            ceil = Math.ceil(f16);
        }
        return (float) ceil;
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float withSign(float f16, int i3) {
        return Math.copySign(f16, i3);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float acosh(float f16) {
        return (float) acosh(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float asinh(float f16) {
        return (float) asinh(f16);
    }
}
