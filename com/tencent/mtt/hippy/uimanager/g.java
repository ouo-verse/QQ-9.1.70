package com.tencent.mtt.hippy.uimanager;

import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final double[] f337683a = new double[4];

        /* renamed from: b, reason: collision with root package name */
        final double[] f337684b = new double[4];

        /* renamed from: c, reason: collision with root package name */
        final double[] f337685c = new double[3];

        /* renamed from: d, reason: collision with root package name */
        final double[] f337686d = new double[3];

        /* renamed from: e, reason: collision with root package name */
        final double[] f337687e = new double[3];

        /* renamed from: f, reason: collision with root package name */
        final double[] f337688f = new double[3];

        public void a() {
            double[] dArr = this.f337683a;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
            dArr[2] = 0.0d;
            dArr[3] = 0.0d;
            double[] dArr2 = this.f337684b;
            dArr2[0] = 0.0d;
            dArr2[1] = 0.0d;
            dArr2[2] = 0.0d;
            dArr2[3] = 0.0d;
            double[] dArr3 = this.f337685c;
            dArr3[0] = 0.0d;
            dArr3[1] = 0.0d;
            dArr3[2] = 0.0d;
            double[] dArr4 = this.f337686d;
            dArr4[0] = 0.0d;
            dArr4[1] = 0.0d;
            dArr4[2] = 0.0d;
            double[] dArr5 = this.f337687e;
            dArr5[0] = 0.0d;
            dArr5[1] = 0.0d;
            dArr5[2] = 0.0d;
            double[] dArr6 = this.f337688f;
            dArr6[0] = 0.0d;
            dArr6[1] = 0.0d;
            dArr6[2] = 0.0d;
        }
    }

    public static double a(double d16) {
        return Math.round(d16 * 1000.0d) * 0.001d;
    }

    public static double b(double d16) {
        return (d16 * 3.141592653589793d) / 180.0d;
    }

    public static void c(double[] dArr, double d16) {
        dArr[0] = d16;
    }

    public static double d(double[] dArr) {
        double d16 = dArr[0];
        double d17 = dArr[1];
        double d18 = (d16 * d16) + (d17 * d17);
        double d19 = dArr[2];
        return Math.sqrt(d18 + (d19 * d19));
    }

    public static void e(double[] dArr) {
        dArr[14] = 0.0d;
        dArr[13] = 0.0d;
        dArr[12] = 0.0d;
        dArr[11] = 0.0d;
        dArr[9] = 0.0d;
        dArr[8] = 0.0d;
        dArr[7] = 0.0d;
        dArr[6] = 0.0d;
        dArr[4] = 0.0d;
        dArr[3] = 0.0d;
        dArr[2] = 0.0d;
        dArr[1] = 0.0d;
        dArr[15] = 1.0d;
        dArr[10] = 1.0d;
        dArr[5] = 1.0d;
        dArr[0] = 1.0d;
    }

    public static void f(double[] dArr, double d16) {
        dArr[0] = Math.cos(d16);
        dArr[1] = Math.sin(d16);
    }

    public static void g(double[] dArr, double d16) {
        dArr[5] = Math.cos(d16);
        dArr[6] = Math.sin(d16);
        dArr[9] = -Math.sin(d16);
        dArr[10] = Math.cos(d16);
    }

    public static void h(double[] dArr, double d16) {
        dArr[0] = Math.cos(d16);
        dArr[2] = -Math.sin(d16);
        dArr[8] = Math.sin(d16);
        dArr[10] = Math.cos(d16);
    }

    public static void i(double[] dArr, double d16) {
        dArr[0] = Math.cos(d16);
        dArr[1] = Math.sin(d16);
        dArr[4] = -Math.sin(d16);
        dArr[5] = Math.cos(d16);
    }

    public static double a(double[] dArr) {
        double d16 = dArr[0];
        double d17 = dArr[1];
        double d18 = dArr[2];
        double d19 = dArr[3];
        double d26 = dArr[4];
        double d27 = dArr[5];
        double d28 = dArr[6];
        double d29 = dArr[7];
        double d36 = dArr[8];
        double d37 = dArr[9];
        double d38 = dArr[10];
        double d39 = dArr[11];
        double d46 = dArr[12];
        double d47 = dArr[13];
        double d48 = dArr[14];
        double d49 = dArr[15];
        double d56 = d19 * d28;
        double d57 = d18 * d29;
        double d58 = d19 * d27;
        double d59 = d17 * d29;
        double d65 = d18 * d27;
        double d66 = d17 * d28;
        double d67 = d19 * d26;
        double d68 = d29 * d16;
        double d69 = d18 * d26;
        double d75 = d28 * d16;
        double d76 = d17 * d26;
        double d77 = d16 * d27;
        return ((((((((((((((((((((((((d56 * d37) * d46) - ((d57 * d37) * d46)) - ((d58 * d38) * d46)) + ((d59 * d38) * d46)) + ((d65 * d39) * d46)) - ((d66 * d39) * d46)) - ((d56 * d36) * d47)) + ((d57 * d36) * d47)) + ((d67 * d38) * d47)) - ((d68 * d38) * d47)) - ((d69 * d39) * d47)) + ((d75 * d39) * d47)) + ((d58 * d36) * d48)) - ((d59 * d36) * d48)) - ((d67 * d37) * d48)) + ((d68 * d37) * d48)) + ((d76 * d39) * d48)) - ((d39 * d77) * d48)) - ((d65 * d36) * d49)) + ((d66 * d36) * d49)) + ((d69 * d37) * d49)) - ((d75 * d37) * d49)) - ((d76 * d38) * d49)) + (d77 * d38 * d49);
    }

    public static void b(double[] dArr, double d16) {
        dArr[11] = (-1.0d) / d16;
    }

    public static void c(double[] dArr, double[] dArr2) {
        double d16 = dArr[0];
        double d17 = dArr[1];
        double d18 = dArr[2];
        double d19 = dArr[3];
        double d26 = d16 * d16;
        double d27 = d17 * d17;
        double d28 = d18 * d18;
        double d29 = (d16 * d17) + (d18 * d19);
        double d36 = (d19 * d19) + d26 + d27 + d28;
        if (d29 > 0.49999d * d36) {
            dArr2[0] = 0.0d;
            dArr2[1] = Math.atan2(d16, d19) * 2.0d * 57.29577951308232d;
            dArr2[2] = 90.0d;
        } else if (d29 < d36 * (-0.49999d)) {
            dArr2[0] = 0.0d;
            dArr2[1] = Math.atan2(d16, d19) * (-2.0d) * 57.29577951308232d;
            dArr2[2] = -90.0d;
        } else {
            double d37 = d16 * 2.0d;
            double d38 = d17 * 2.0d;
            double d39 = d28 * 2.0d;
            dArr2[0] = a(Math.atan2((d37 * d19) - (d38 * d18), (1.0d - (d26 * 2.0d)) - d39) * 57.29577951308232d);
            dArr2[1] = a(Math.atan2((d38 * d19) - (d37 * d18), (1.0d - (d27 * 2.0d)) - d39) * 57.29577951308232d);
            dArr2[2] = a(Math.asin((d37 * d17) + (d18 * 2.0d * d19)) * 57.29577951308232d);
        }
    }

    public static void d(double[] dArr, double d16) {
        dArr[5] = d16;
    }

    public static void e(double[] dArr, double d16) {
        dArr[4] = Math.sin(d16);
        dArr[5] = Math.cos(d16);
    }

    public static double a(double[] dArr, double[] dArr2) {
        return (dArr[0] * dArr2[0]) + (dArr[1] * dArr2[1]) + (dArr[2] * dArr2[2]);
    }

    public static void b(double[] dArr, double[] dArr2, double[] dArr3) {
        double d16 = dArr[0];
        double d17 = dArr[1];
        double d18 = dArr[2];
        double d19 = dArr[3];
        dArr3[0] = (dArr2[0] * d16) + (dArr2[4] * d17) + (dArr2[8] * d18) + (dArr2[12] * d19);
        dArr3[1] = (dArr2[1] * d16) + (dArr2[5] * d17) + (dArr2[9] * d18) + (dArr2[13] * d19);
        dArr3[2] = (dArr2[2] * d16) + (dArr2[6] * d17) + (dArr2[10] * d18) + (dArr2[14] * d19);
        dArr3[3] = (d16 * dArr2[3]) + (d17 * dArr2[7]) + (d18 * dArr2[11]) + (d19 * dArr2[15]);
    }

    private static boolean c(double d16) {
        return !Double.isNaN(d16) && Math.abs(d16) < 1.0E-5d;
    }

    public static void a(double[] dArr, double d16, double d17) {
        dArr[12] = d16;
        dArr[13] = d17;
    }

    public static double[] b(double[] dArr) {
        double a16 = a(dArr);
        if (c(a16)) {
            return dArr;
        }
        double d16 = dArr[0];
        double d17 = dArr[1];
        double d18 = dArr[2];
        double d19 = dArr[3];
        double d26 = dArr[4];
        double d27 = dArr[5];
        double d28 = dArr[6];
        double d29 = dArr[7];
        double d36 = dArr[8];
        double d37 = dArr[9];
        double d38 = dArr[10];
        double d39 = dArr[11];
        double d46 = dArr[12];
        double d47 = dArr[13];
        double d48 = dArr[14];
        double d49 = dArr[15];
        double d56 = d28 * d39;
        double d57 = d29 * d38;
        double d58 = d29 * d37;
        double d59 = d27 * d39;
        double d65 = d28 * d37;
        double d66 = ((((d56 * d47) - (d57 * d47)) + (d58 * d48)) - (d59 * d48)) - (d65 * d49);
        double d67 = d27 * d38;
        double d68 = d19 * d38;
        double d69 = d18 * d39;
        double d75 = d19 * d37;
        double d76 = d17 * d39;
        double d77 = d18 * d37;
        double d78 = (((d68 * d47) - (d69 * d47)) - (d75 * d48)) + (d76 * d48) + (d77 * d49);
        double d79 = d17 * d38;
        double d85 = d18 * d29;
        double d86 = d19 * d28;
        double d87 = d19 * d27;
        double d88 = d17 * d29;
        double d89 = d18 * d27;
        double d95 = d17 * d28;
        double d96 = (d57 * d46) - (d56 * d46);
        double d97 = d29 * d36;
        double d98 = d26 * d39;
        double d99 = d28 * d36;
        double d100 = (d96 - (d97 * d48)) + (d98 * d48) + (d99 * d49);
        double d101 = d26 * d38;
        double d102 = (d69 * d46) - (d68 * d46);
        double d103 = d19 * d36;
        double d104 = d16 * d39;
        double d105 = d18 * d36;
        double d106 = d16 * d38;
        double d107 = d19 * d26;
        double d108 = d29 * d16;
        double d109 = d18 * d26;
        double d110 = d28 * d16;
        double d111 = d27 * d36;
        double d112 = ((((d59 * d46) - (d58 * d46)) + (d97 * d47)) - (d98 * d47)) - (d111 * d49);
        double d113 = d26 * d37;
        double d114 = d17 * d36;
        double d115 = d16 * d37;
        double d116 = d17 * d26;
        double d117 = d16 * d27;
        return new double[]{(d66 + (d67 * d49)) / a16, (d78 - (d79 * d49)) / a16, ((((((d85 * d47) - (d86 * d47)) + (d87 * d48)) - (d88 * d48)) - (d89 * d49)) + (d95 * d49)) / a16, ((((((d86 * d37) - (d85 * d37)) - (d87 * d38)) + (d88 * d38)) + (d89 * d39)) - (d95 * d39)) / a16, (d100 - (d101 * d49)) / a16, ((((d102 + (d103 * d48)) - (d104 * d48)) - (d105 * d49)) + (d106 * d49)) / a16, ((((((d86 * d46) - (d85 * d46)) - (d107 * d48)) + (d108 * d48)) + (d109 * d49)) - (d110 * d49)) / a16, ((((((d85 * d36) - (d86 * d36)) + (d107 * d38)) - (d108 * d38)) - (d109 * d39)) + (d110 * d39)) / a16, (d112 + (d113 * d49)) / a16, ((((((d75 * d46) - (d76 * d46)) - (d103 * d47)) + (d104 * d47)) + (d114 * d49)) - (d115 * d49)) / a16, ((((((d88 * d46) - (d87 * d46)) + (d107 * d47)) - (d108 * d47)) - (d116 * d49)) + (d49 * d117)) / a16, ((((((d87 * d36) - (d88 * d36)) - (d107 * d37)) + (d108 * d37)) + (d116 * d39)) - (d39 * d117)) / a16, ((((((d65 * d46) - (d67 * d46)) - (d99 * d47)) + (d101 * d47)) + (d111 * d48)) - (d113 * d48)) / a16, ((((((d79 * d46) - (d77 * d46)) + (d105 * d47)) - (d106 * d47)) - (d114 * d48)) + (d115 * d48)) / a16, ((((((d89 * d46) - (d46 * d95)) - (d109 * d47)) + (d47 * d110)) + (d116 * d48)) - (d48 * d117)) / a16, ((((((d95 * d36) - (d89 * d36)) + (d109 * d37)) - (d110 * d37)) - (d116 * d38)) + (d117 * d38)) / a16};
    }

    public static double[] c(double[] dArr) {
        return new double[]{dArr[0], dArr[4], dArr[8], dArr[12], dArr[1], dArr[5], dArr[9], dArr[13], dArr[2], dArr[6], dArr[10], dArr[14], dArr[3], dArr[7], dArr[11], dArr[15]};
    }

    public static void a(double[] dArr, double d16, double d17, double d18) {
        dArr[12] = d16;
        dArr[13] = d17;
        dArr[14] = d18;
    }

    public static double[] b(double[] dArr, double[] dArr2) {
        double d16 = dArr[1];
        double d17 = dArr2[2];
        double d18 = dArr[2];
        double d19 = dArr2[0];
        double d26 = dArr[0];
        return new double[]{(d16 * d17) - (dArr2[1] * d18), (d18 * d19) - (d17 * d26), (d26 * dArr2[1]) - (dArr[1] * d19)};
    }

    public static void a(double[] dArr, a aVar) {
        double[] dArr2 = aVar.f337683a;
        double[] dArr3 = aVar.f337684b;
        double[] dArr4 = aVar.f337685c;
        double[] dArr5 = aVar.f337686d;
        double[] dArr6 = aVar.f337687e;
        double[] dArr7 = aVar.f337688f;
        if (c(dArr[15])) {
            return;
        }
        double[][] dArr8 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 4, 4);
        double[] dArr9 = new double[16];
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i16 = 0; i16 < 4; i16++) {
                int i17 = (i3 * 4) + i16;
                double d16 = dArr[i17] / dArr[15];
                dArr8[i3][i16] = d16;
                if (i16 == 3) {
                    d16 = 0.0d;
                }
                dArr9[i17] = d16;
            }
        }
        dArr9[15] = 1.0d;
        if (c(a(dArr9))) {
            return;
        }
        if (c(dArr8[0][3]) && c(dArr8[1][3]) && c(dArr8[2][3])) {
            dArr2[2] = 0.0d;
            dArr2[1] = 0.0d;
            dArr2[0] = 0.0d;
            dArr2[3] = 1.0d;
        } else {
            b(new double[]{dArr8[0][3], dArr8[1][3], dArr8[2][3], dArr8[3][3]}, c(b(dArr9)), dArr2);
        }
        System.arraycopy(dArr8[3], 0, dArr6, 0, 3);
        double[][] dArr10 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 3, 3);
        for (int i18 = 0; i18 < 3; i18++) {
            double[] dArr11 = dArr10[i18];
            double[] dArr12 = dArr8[i18];
            dArr11[0] = dArr12[0];
            dArr11[1] = dArr12[1];
            dArr11[2] = dArr12[2];
        }
        double d17 = d(dArr10[0]);
        dArr4[0] = d17;
        double[] a16 = a(dArr10[0], d17);
        dArr10[0] = a16;
        double a17 = a(a16, dArr10[1]);
        dArr5[0] = a17;
        double[] a18 = a(dArr10[1], dArr10[0], 1.0d, -a17);
        dArr10[1] = a18;
        double a19 = a(dArr10[0], a18);
        dArr5[0] = a19;
        double[] a26 = a(dArr10[1], dArr10[0], 1.0d, -a19);
        dArr10[1] = a26;
        double d18 = d(a26);
        dArr4[1] = d18;
        dArr10[1] = a(dArr10[1], d18);
        dArr5[0] = dArr5[0] / dArr4[1];
        double a27 = a(dArr10[0], dArr10[2]);
        dArr5[1] = a27;
        double[] a28 = a(dArr10[2], dArr10[0], 1.0d, -a27);
        dArr10[2] = a28;
        double a29 = a(dArr10[1], a28);
        dArr5[2] = a29;
        double[] a36 = a(dArr10[2], dArr10[1], 1.0d, -a29);
        dArr10[2] = a36;
        double d19 = d(a36);
        dArr4[2] = d19;
        double[] a37 = a(dArr10[2], d19);
        dArr10[2] = a37;
        double d26 = dArr5[1];
        double d27 = dArr4[2];
        dArr5[1] = d26 / d27;
        dArr5[2] = dArr5[2] / d27;
        if (a(dArr10[0], b(dArr10[1], a37)) < 0.0d) {
            for (int i19 = 0; i19 < 3; i19++) {
                dArr4[i19] = dArr4[i19] * (-1.0d);
                double[] dArr13 = dArr10[i19];
                dArr13[0] = dArr13[0] * (-1.0d);
                dArr13[1] = dArr13[1] * (-1.0d);
                dArr13[2] = dArr13[2] * (-1.0d);
            }
        }
        dArr3[0] = Math.sqrt(Math.max(((dArr10[0][0] + 1.0d) - dArr10[1][1]) - dArr10[2][2], 0.0d)) * 0.5d;
        dArr3[1] = Math.sqrt(Math.max(((1.0d - dArr10[0][0]) + dArr10[1][1]) - dArr10[2][2], 0.0d)) * 0.5d;
        dArr3[2] = Math.sqrt(Math.max(((1.0d - dArr10[0][0]) - dArr10[1][1]) + dArr10[2][2], 0.0d)) * 0.5d;
        dArr3[3] = Math.sqrt(Math.max(dArr10[0][0] + 1.0d + dArr10[1][1] + dArr10[2][2], 0.0d)) * 0.5d;
        double[] dArr14 = dArr10[2];
        double d28 = dArr14[1];
        double[] dArr15 = dArr10[1];
        if (d28 > dArr15[2]) {
            dArr3[0] = -dArr3[0];
        }
        double[] dArr16 = dArr10[0];
        if (dArr16[2] > dArr14[0]) {
            dArr3[1] = -dArr3[1];
        }
        if (dArr15[0] > dArr16[1]) {
            dArr3[2] = -dArr3[2];
        }
        double d29 = dArr3[0];
        if (d29 < 0.001d && d29 >= 0.0d) {
            double d36 = dArr3[1];
            if (d36 < 0.001d && d36 >= 0.0d) {
                dArr7[1] = 0.0d;
                dArr7[0] = 0.0d;
                dArr7[2] = a((Math.atan2(dArr16[1], dArr16[0]) * 180.0d) / 3.141592653589793d);
                return;
            }
        }
        c(dArr3, dArr7);
    }

    public static void a(double[] dArr, double[] dArr2, double[] dArr3) {
        double d16 = dArr3[0];
        double d17 = dArr3[1];
        double d18 = dArr3[2];
        double d19 = dArr3[3];
        double d26 = dArr3[4];
        double d27 = dArr3[5];
        double d28 = dArr3[6];
        double d29 = dArr3[7];
        double d36 = dArr3[8];
        double d37 = dArr3[9];
        double d38 = dArr3[10];
        double d39 = dArr3[11];
        double d46 = dArr3[12];
        double d47 = dArr3[13];
        double d48 = dArr3[14];
        double d49 = dArr3[15];
        double d56 = dArr2[0];
        double d57 = dArr2[1];
        double d58 = dArr2[2];
        double d59 = dArr2[3];
        dArr[0] = (d56 * d16) + (d57 * d26) + (d58 * d36) + (d59 * d46);
        dArr[1] = (d56 * d17) + (d57 * d27) + (d58 * d37) + (d59 * d47);
        dArr[2] = (d56 * d18) + (d57 * d28) + (d58 * d38) + (d59 * d48);
        dArr[3] = (d56 * d19) + (d57 * d29) + (d58 * d39) + (d59 * d49);
        double d65 = dArr2[4];
        double d66 = dArr2[5];
        double d67 = dArr2[6];
        double d68 = dArr2[7];
        dArr[4] = (d65 * d16) + (d66 * d26) + (d67 * d36) + (d68 * d46);
        dArr[5] = (d65 * d17) + (d66 * d27) + (d67 * d37) + (d68 * d47);
        dArr[6] = (d65 * d18) + (d66 * d28) + (d67 * d38) + (d68 * d48);
        dArr[7] = (d65 * d19) + (d66 * d29) + (d67 * d39) + (d68 * d49);
        double d69 = dArr2[8];
        double d75 = dArr2[9];
        double d76 = dArr2[10];
        double d77 = dArr2[11];
        dArr[8] = (d69 * d16) + (d75 * d26) + (d76 * d36) + (d77 * d46);
        dArr[9] = (d69 * d17) + (d75 * d27) + (d76 * d37) + (d77 * d47);
        dArr[10] = (d69 * d18) + (d75 * d28) + (d76 * d38) + (d77 * d48);
        dArr[11] = (d69 * d19) + (d75 * d29) + (d76 * d39) + (d77 * d49);
        double d78 = dArr2[12];
        double d79 = dArr2[13];
        double d85 = dArr2[14];
        double d86 = dArr2[15];
        dArr[12] = (d16 * d78) + (d26 * d79) + (d36 * d85) + (d46 * d86);
        dArr[13] = (d17 * d78) + (d27 * d79) + (d37 * d85) + (d47 * d86);
        dArr[14] = (d18 * d78) + (d28 * d79) + (d38 * d85) + (d48 * d86);
        dArr[15] = (d78 * d19) + (d79 * d29) + (d85 * d39) + (d86 * d49);
    }

    public static double[] a(double[] dArr, double d16) {
        if (c(d16)) {
            d16 = d(dArr);
        }
        double d17 = 1.0d / d16;
        return new double[]{dArr[0] * d17, dArr[1] * d17, dArr[2] * d17};
    }

    public static double[] a(double[] dArr, double[] dArr2, double d16, double d17) {
        return new double[]{(dArr[0] * d16) + (dArr2[0] * d17), (dArr[1] * d16) + (dArr2[1] * d17), (d16 * dArr[2]) + (d17 * dArr2[2])};
    }
}
