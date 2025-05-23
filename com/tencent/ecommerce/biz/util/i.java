package com.tencent.ecommerce.biz.util;

import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.math.BigDecimal;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/util/i;", "", "", "dividend", "divisor", "", "scale", "", "a", "f", "quantity", "", "e", "moneyNum", "b", "d", "moneyString", "c", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f104869a = new i();

    i() {
    }

    private final double a(long dividend, long divisor, int scale) {
        return new BigDecimal(String.valueOf(dividend)).divide(new BigDecimal(String.valueOf(divisor)), scale, 5).doubleValue();
    }

    private final double f(long dividend, long divisor, int scale) {
        return new BigDecimal(String.valueOf(dividend)).divide(new BigDecimal(String.valueOf(divisor)), scale, 1).doubleValue();
    }

    public final String c(String moneyString) {
        try {
            double d16 = 10;
            return String.valueOf((long) (Double.parseDouble(moneyString) * d16 * d16));
        } catch (NumberFormatException e16) {
            cg0.a.a("ECNumFormatUtils", "formatMoneyStringToFen", "convert money to fen failed, error = " + e16);
            return moneyString;
        }
    }

    public final String d(long moneyNum) {
        String trim;
        String trim2;
        String trim3;
        trim = StringsKt__StringsKt.trim(String.valueOf(a(moneyNum, 100L, 2)), '0');
        trim2 = StringsKt__StringsKt.trim(trim, '0');
        trim3 = StringsKt__StringsKt.trim(trim2, '.');
        if (moneyNum == 0) {
            return "0";
        }
        long j3 = 99;
        if (1 > moneyNum || j3 < moneyNum) {
            return trim3;
        }
        return "0." + trim3;
    }

    public final String e(long quantity) {
        if (quantity < 10000) {
            return String.valueOf(quantity);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.1fw", Arrays.copyOf(new Object[]{Double.valueOf(quantity / 10000)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public final String b(long moneyNum) {
        String trim;
        String trim2;
        String sb5;
        String trim3;
        String trim4;
        String trim5;
        String trim6;
        String trim7;
        String trim8;
        long j3 = 100000;
        if (0 <= moneyNum && j3 > moneyNum) {
            trim7 = StringsKt__StringsKt.trim(String.valueOf(a(moneyNum, 100L, 2)), '0');
            trim8 = StringsKt__StringsKt.trim(trim7, '0');
            sb5 = StringsKt__StringsKt.trim(trim8, '.');
        } else {
            long j16 = 1000000;
            if (j3 <= moneyNum && j16 > moneyNum) {
                trim6 = StringsKt__StringsKt.trim(String.valueOf(a((long) f(moneyNum, 10L, 0), 10L, 1)), '0');
                sb5 = StringsKt__StringsKt.trim(trim6, '.');
            } else {
                long j17 = 10000000;
                if (j16 <= moneyNum && j17 > moneyNum) {
                    trim5 = StringsKt__StringsKt.trim(String.valueOf(f(moneyNum, 100L, 0)), '0');
                    sb5 = StringsKt__StringsKt.trim(trim5, '.');
                } else {
                    long j18 = 100000000;
                    if (j17 <= moneyNum && j18 > moneyNum) {
                        double a16 = a((long) f(moneyNum, JsonGrayBusiId.UI_RESERVE_100000_110000, 2), 10L, 1);
                        StringBuilder sb6 = new StringBuilder();
                        trim3 = StringsKt__StringsKt.trim(String.valueOf(a16), '0');
                        trim4 = StringsKt__StringsKt.trim(trim3, '.');
                        sb6.append(trim4);
                        sb6.append("w");
                        sb5 = sb6.toString();
                    } else {
                        double f16 = f(moneyNum, 1000000L, 0);
                        StringBuilder sb7 = new StringBuilder();
                        trim = StringsKt__StringsKt.trim(String.valueOf(f16), '0');
                        trim2 = StringsKt__StringsKt.trim(trim, '.');
                        sb7.append(trim2);
                        sb7.append("w");
                        sb5 = sb7.toString();
                    }
                }
            }
        }
        if (moneyNum == 0) {
            return "0";
        }
        long j19 = 99;
        if (1 > moneyNum || j19 < moneyNum) {
            return sb5;
        }
        return "0." + sb5;
    }
}
