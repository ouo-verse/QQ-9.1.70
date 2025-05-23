package com.tencent.luggage.wxa.ar;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.a0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    public double f121704a;

    /* renamed from: b, reason: collision with root package name */
    public double f121705b;

    /* renamed from: c, reason: collision with root package name */
    public double f121706c = 1.0d;

    /* renamed from: d, reason: collision with root package name */
    public double[] f121707d = new double[0];

    public static List b(String str) {
        k0 a16;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        String[] split = str.split(";");
        if (split != null && split.length != 0) {
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2) && (a16 = a(str2)) != null) {
                    arrayList.add(a16);
                }
            }
        }
        return arrayList;
    }

    public double a(double d16) {
        double d17 = this.f121704a;
        if (d16 < d17) {
            return 0.0d;
        }
        double d18 = this.f121705b;
        if (d16 > d18) {
            return 0.0d;
        }
        double[] dArr = this.f121707d;
        if (dArr != null && dArr.length != 0) {
            int i3 = 0;
            if (dArr.length == 1) {
                return dArr[0];
            }
            if (d16 == d18) {
                return dArr[dArr.length - 1];
            }
            int length = dArr.length - 1;
            double d19 = (d18 - d17) / length;
            double d26 = d16 - d17;
            while (i3 < length) {
                int i16 = i3 + 1;
                double d27 = i3 * d19;
                if (d26 <= i16 * d19) {
                    double[] dArr2 = this.f121707d;
                    double d28 = dArr2[i3];
                    return d28 + (((dArr2[i16] - d28) * (d26 - d27)) / d19);
                }
                i3 = i16;
            }
            double[] dArr3 = this.f121707d;
            return dArr3[dArr3.length - 1];
        }
        return this.f121706c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b2, code lost:
    
        com.tencent.luggage.wxa.ar.x0.c("TimeRange", "getTimeRange, scales parse value error");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b8, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static k0 a(String str) {
        k0 k0Var = new k0();
        String[] split = str.replace("(", "-").replace(")", "").split("-");
        if (split != null && split.length >= 2) {
            int i3 = 0;
            double a16 = a0.a(split[0]);
            if (a16 >= 0.0d && a16 <= 24.0d) {
                k0Var.f121704a = a16;
                double a17 = a0.a(split[1]);
                if (a17 >= 0.0d && a17 <= 24.0d) {
                    k0Var.f121705b = a17;
                    if (split.length == 3) {
                        a0.a b16 = a0.b(split[2]);
                        if (!b16.f121611a) {
                            x0.c("TimeRange", "getTimeRange, scale parse error");
                            return null;
                        }
                        double a18 = b16.a();
                        if (a18 >= 0.0d && a18 <= 1000000.0001d) {
                            k0Var.f121706c = a18;
                        } else {
                            x0.c("TimeRange", "getTimeRange, scale parse value error");
                            return null;
                        }
                    } else if (split.length > 3) {
                        double[] dArr = new double[split.length - 2];
                        while (true) {
                            int i16 = i3 + 2;
                            if (i16 < split.length) {
                                a0.a b17 = a0.b(split[i16]);
                                if (!b17.f121611a) {
                                    x0.c("TimeRange", "getTimeRange, scales parse error");
                                    return null;
                                }
                                double a19 = b17.a();
                                if (a19 < 0.0d || a19 > 1000000.0001d) {
                                    break;
                                }
                                dArr[i3] = a19;
                                i3++;
                            } else {
                                k0Var.f121707d = dArr;
                                break;
                            }
                        }
                    }
                    return k0Var;
                }
                x0.c("TimeRange", "getTimeRange, bind.rangeFrom.timeEnd parse error");
                return null;
            }
            x0.c("TimeRange", "getTimeRange, bind.rangeFrom.timeStart parse error");
            return null;
        }
        x0.c("TimeRange", "getTimeRange, length error");
        return null;
    }
}
