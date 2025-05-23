package kotlin;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.ams.adcore.mma.api.Global;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\rH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000eH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000fH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u00a8\u0006\u0011"}, d2 = {"dec", "Ljava/math/BigDecimal;", "div", "other", "inc", "minus", QCircleDaTongConstant.ElementParamValue.PLUS, "rem", Element.ELEMENT_NAME_TIMES, "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "unaryMinus", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/NumbersKt")
/* loaded from: classes28.dex */
class NumbersKt__BigDecimalsKt {
    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigDecimal dec(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        BigDecimal subtract = bigDecimal.subtract(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }

    @InlineOnly
    private static final BigDecimal div(BigDecimal bigDecimal, BigDecimal other) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal divide = bigDecimal.divide(other, RoundingMode.HALF_EVEN);
        Intrinsics.checkNotNullExpressionValue(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigDecimal inc(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        BigDecimal add = bigDecimal.add(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(BigDecimal.ONE)");
        return add;
    }

    @InlineOnly
    private static final BigDecimal minus(BigDecimal bigDecimal, BigDecimal other) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal subtract = bigDecimal.subtract(other);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(other)");
        return subtract;
    }

    @InlineOnly
    private static final BigDecimal plus(BigDecimal bigDecimal, BigDecimal other) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal add = bigDecimal.add(other);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
        return add;
    }

    @InlineOnly
    private static final BigDecimal rem(BigDecimal bigDecimal, BigDecimal other) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal remainder = bigDecimal.remainder(other);
        Intrinsics.checkNotNullExpressionValue(remainder, "this.remainder(other)");
        return remainder;
    }

    @InlineOnly
    private static final BigDecimal times(BigDecimal bigDecimal, BigDecimal other) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal multiply = bigDecimal.multiply(other);
        Intrinsics.checkNotNullExpressionValue(multiply, "this.multiply(other)");
        return multiply;
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigDecimal toBigDecimal(int i3) {
        BigDecimal valueOf = BigDecimal.valueOf(i3);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        return valueOf;
    }

    @InlineOnly
    private static final BigDecimal unaryMinus(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        BigDecimal negate = bigDecimal.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "this.negate()");
        return negate;
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigDecimal toBigDecimal(int i3, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(i3, mathContext);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigDecimal toBigDecimal(long j3) {
        BigDecimal valueOf = BigDecimal.valueOf(j3);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this)");
        return valueOf;
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigDecimal toBigDecimal(long j3, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(j3, mathContext);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigDecimal toBigDecimal(float f16) {
        return new BigDecimal(String.valueOf(f16));
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigDecimal toBigDecimal(float f16, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(f16), mathContext);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigDecimal toBigDecimal(double d16) {
        return new BigDecimal(String.valueOf(d16));
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigDecimal toBigDecimal(double d16, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(d16), mathContext);
    }
}
