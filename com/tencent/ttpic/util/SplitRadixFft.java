package com.tencent.ttpic.util;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SplitRadixFft {
    private static final int CDFT_RECURSIVE_N = 512;

    private final void bitrv2(int i3, int[] iArr, int i16, double[] dArr) {
        int i17;
        iArr[i16 + 0] = 0;
        int i18 = i3;
        int i19 = 1;
        while (true) {
            i17 = i19 << 3;
            if (i17 >= i18) {
                break;
            }
            i18 >>= 1;
            for (int i26 = 0; i26 < i19; i26++) {
                iArr[i16 + i19 + i26] = iArr[i16 + i26] + i18;
            }
            i19 <<= 1;
        }
        int i27 = i19 * 2;
        if (i17 == i18) {
            for (int i28 = 0; i28 < i19; i28++) {
                for (int i29 = 0; i29 < i28; i29++) {
                    int i36 = (i29 * 2) + iArr[i16 + i28];
                    int i37 = (i28 * 2) + iArr[i16 + i29];
                    double d16 = dArr[i36];
                    int i38 = i36 + 1;
                    double d17 = dArr[i38];
                    double d18 = dArr[i37];
                    int i39 = i37 + 1;
                    double d19 = dArr[i39];
                    dArr[i36] = d18;
                    dArr[i38] = d19;
                    dArr[i37] = d16;
                    dArr[i39] = d17;
                    int i46 = i36 + i27;
                    int i47 = i27 * 2;
                    int i48 = i37 + i47;
                    double d26 = dArr[i46];
                    int i49 = i46 + 1;
                    double d27 = dArr[i49];
                    double d28 = dArr[i48];
                    int i56 = i48 + 1;
                    double d29 = dArr[i56];
                    dArr[i46] = d28;
                    dArr[i49] = d29;
                    dArr[i48] = d26;
                    dArr[i56] = d27;
                    int i57 = i46 + i27;
                    int i58 = i48 - i27;
                    double d36 = dArr[i57];
                    int i59 = i57 + 1;
                    double d37 = dArr[i59];
                    double d38 = dArr[i58];
                    int i65 = i58 + 1;
                    double d39 = dArr[i65];
                    dArr[i57] = d38;
                    dArr[i59] = d39;
                    dArr[i58] = d36;
                    dArr[i65] = d37;
                    int i66 = i57 + i27;
                    int i67 = i58 + i47;
                    double d46 = dArr[i66];
                    int i68 = i66 + 1;
                    double d47 = dArr[i68];
                    double d48 = dArr[i67];
                    int i69 = i67 + 1;
                    double d49 = dArr[i69];
                    dArr[i66] = d48;
                    dArr[i68] = d49;
                    dArr[i67] = d46;
                    dArr[i69] = d47;
                }
                int i75 = (i28 * 2) + i27 + iArr[i16 + i28];
                int i76 = i75 + i27;
                double d56 = dArr[i75];
                int i77 = i75 + 1;
                double d57 = dArr[i77];
                double d58 = dArr[i76];
                int i78 = i76 + 1;
                double d59 = dArr[i78];
                dArr[i75] = d58;
                dArr[i77] = d59;
                dArr[i76] = d56;
                dArr[i78] = d57;
            }
            return;
        }
        for (int i79 = 1; i79 < i19; i79++) {
            for (int i85 = 0; i85 < i79; i85++) {
                int i86 = (i85 * 2) + iArr[i16 + i79];
                int i87 = (i79 * 2) + iArr[i16 + i85];
                double d65 = dArr[i86];
                int i88 = i86 + 1;
                double d66 = dArr[i88];
                double d67 = dArr[i87];
                int i89 = i87 + 1;
                double d68 = dArr[i89];
                dArr[i86] = d67;
                dArr[i88] = d68;
                dArr[i87] = d65;
                dArr[i89] = d66;
                int i95 = i86 + i27;
                int i96 = i87 + i27;
                double d69 = dArr[i95];
                int i97 = i95 + 1;
                double d75 = dArr[i97];
                double d76 = dArr[i96];
                int i98 = i96 + 1;
                double d77 = dArr[i98];
                dArr[i95] = d76;
                dArr[i97] = d77;
                dArr[i96] = d69;
                dArr[i98] = d75;
            }
        }
    }

    private void bitrv208(double[] dArr) {
        double d16 = dArr[2];
        double d17 = dArr[3];
        double d18 = dArr[6];
        double d19 = dArr[7];
        double d26 = dArr[8];
        double d27 = dArr[9];
        double d28 = dArr[12];
        double d29 = dArr[13];
        dArr[2] = d26;
        dArr[3] = d27;
        dArr[6] = d28;
        dArr[7] = d29;
        dArr[8] = d16;
        dArr[9] = d17;
        dArr[12] = d18;
        dArr[13] = d19;
    }

    private void bitrv208neg(double[] dArr) {
        double d16 = dArr[2];
        double d17 = dArr[3];
        double d18 = dArr[4];
        double d19 = dArr[5];
        double d26 = dArr[6];
        double d27 = dArr[7];
        double d28 = dArr[8];
        double d29 = dArr[9];
        double d36 = dArr[10];
        double d37 = dArr[11];
        double d38 = dArr[12];
        double d39 = dArr[13];
        double d46 = dArr[14];
        double d47 = dArr[15];
        dArr[2] = d46;
        dArr[3] = d47;
        dArr[4] = d26;
        dArr[5] = d27;
        dArr[6] = d36;
        dArr[7] = d37;
        dArr[8] = d16;
        dArr[9] = d17;
        dArr[10] = d38;
        dArr[11] = d39;
        dArr[12] = d18;
        dArr[13] = d19;
        dArr[14] = d28;
        dArr[15] = d29;
    }

    private void bitrv216(double[] dArr) {
        double d16 = dArr[2];
        double d17 = dArr[3];
        double d18 = dArr[4];
        double d19 = dArr[5];
        double d26 = dArr[6];
        double d27 = dArr[7];
        double d28 = dArr[8];
        double d29 = dArr[9];
        double d36 = dArr[10];
        double d37 = dArr[11];
        double d38 = dArr[14];
        double d39 = dArr[15];
        double d46 = dArr[16];
        double d47 = dArr[17];
        double d48 = dArr[20];
        double d49 = dArr[21];
        double d56 = dArr[22];
        double d57 = dArr[23];
        double d58 = dArr[24];
        double d59 = dArr[25];
        double d65 = dArr[26];
        double d66 = dArr[27];
        double d67 = dArr[28];
        double d68 = dArr[29];
        dArr[2] = d46;
        dArr[3] = d47;
        dArr[4] = d28;
        dArr[5] = d29;
        dArr[6] = d58;
        dArr[7] = d59;
        dArr[8] = d18;
        dArr[9] = d19;
        dArr[10] = d48;
        dArr[11] = d49;
        dArr[14] = d67;
        dArr[15] = d68;
        dArr[16] = d16;
        dArr[17] = d17;
        dArr[20] = d36;
        dArr[21] = d37;
        dArr[22] = d65;
        dArr[23] = d66;
        dArr[24] = d26;
        dArr[25] = d27;
        dArr[26] = d56;
        dArr[27] = d57;
        dArr[28] = d38;
        dArr[29] = d39;
    }

    private void bitrv216neg(double[] dArr) {
        double d16 = dArr[2];
        double d17 = dArr[3];
        double d18 = dArr[4];
        double d19 = dArr[5];
        double d26 = dArr[6];
        double d27 = dArr[7];
        double d28 = dArr[8];
        double d29 = dArr[9];
        double d36 = dArr[10];
        double d37 = dArr[11];
        double d38 = dArr[12];
        double d39 = dArr[13];
        double d46 = dArr[14];
        double d47 = dArr[15];
        double d48 = dArr[16];
        double d49 = dArr[17];
        double d56 = dArr[18];
        double d57 = dArr[19];
        double d58 = dArr[20];
        double d59 = dArr[21];
        double d65 = dArr[22];
        double d66 = dArr[23];
        double d67 = dArr[24];
        double d68 = dArr[25];
        double d69 = dArr[26];
        double d75 = dArr[27];
        double d76 = dArr[28];
        double d77 = dArr[29];
        double d78 = dArr[30];
        double d79 = dArr[31];
        dArr[2] = d78;
        dArr[3] = d79;
        dArr[4] = d46;
        dArr[5] = d47;
        dArr[6] = d65;
        dArr[7] = d66;
        dArr[8] = d26;
        dArr[9] = d27;
        dArr[10] = d69;
        dArr[11] = d75;
        dArr[12] = d36;
        dArr[13] = d37;
        dArr[14] = d56;
        dArr[15] = d57;
        dArr[16] = d16;
        dArr[17] = d17;
        dArr[18] = d76;
        dArr[19] = d77;
        dArr[20] = d38;
        dArr[21] = d39;
        dArr[22] = d58;
        dArr[23] = d59;
        dArr[24] = d18;
        dArr[25] = d19;
        dArr[26] = d67;
        dArr[27] = d68;
        dArr[28] = d28;
        dArr[29] = d29;
        dArr[30] = d48;
        dArr[31] = d49;
    }

    private final void bitrv2conj(int i3, int[] iArr, int i16, double[] dArr) {
        int i17;
        int i18 = 0;
        iArr[i16 + 0] = 0;
        int i19 = i3;
        int i26 = 1;
        while (true) {
            i17 = i26 << 3;
            if (i17 >= i19) {
                break;
            }
            i19 >>= 1;
            for (int i27 = 0; i27 < i26; i27++) {
                iArr[i16 + i26 + i27] = iArr[i16 + i27] + i19;
            }
            i26 <<= 1;
        }
        int i28 = i26 * 2;
        if (i17 == i19) {
            int i29 = 0;
            while (i29 < i26) {
                int i36 = i18;
                while (i36 < i29) {
                    int i37 = (i36 * 2) + iArr[i16 + i29];
                    int i38 = (i29 * 2) + iArr[i16 + i36];
                    double d16 = dArr[i37];
                    int i39 = i37 + 1;
                    double d17 = -dArr[i39];
                    double d18 = dArr[i38];
                    int i46 = i38 + 1;
                    double d19 = -dArr[i46];
                    dArr[i37] = d18;
                    dArr[i39] = d19;
                    dArr[i38] = d16;
                    dArr[i46] = d17;
                    int i47 = i37 + i28;
                    int i48 = i28 * 2;
                    int i49 = i38 + i48;
                    double d26 = dArr[i47];
                    int i56 = i47 + 1;
                    double d27 = -dArr[i56];
                    double d28 = dArr[i49];
                    int i57 = i49 + 1;
                    int i58 = i29;
                    int i59 = i26;
                    double d29 = -dArr[i57];
                    dArr[i47] = d28;
                    dArr[i56] = d29;
                    dArr[i49] = d26;
                    dArr[i57] = d27;
                    int i65 = i47 + i28;
                    int i66 = i49 - i28;
                    double d36 = dArr[i65];
                    int i67 = i65 + 1;
                    double d37 = -dArr[i67];
                    double d38 = dArr[i66];
                    int i68 = i66 + 1;
                    double d39 = -dArr[i68];
                    dArr[i65] = d38;
                    dArr[i67] = d39;
                    dArr[i66] = d36;
                    dArr[i68] = d37;
                    int i69 = i65 + i28;
                    int i75 = i66 + i48;
                    double d46 = dArr[i69];
                    int i76 = i69 + 1;
                    double d47 = -dArr[i76];
                    double d48 = dArr[i75];
                    int i77 = i75 + 1;
                    double d49 = -dArr[i77];
                    dArr[i69] = d48;
                    dArr[i76] = d49;
                    dArr[i75] = d46;
                    dArr[i77] = d47;
                    i36++;
                    i26 = i59;
                    i29 = i58;
                }
                int i78 = i29;
                int i79 = i26;
                int i85 = (i78 * 2) + iArr[i16 + i78];
                int i86 = i85 + 1;
                dArr[i86] = -dArr[i86];
                int i87 = i85 + i28;
                int i88 = i87 + i28;
                double d56 = dArr[i87];
                int i89 = i87 + 1;
                double d57 = -dArr[i89];
                double d58 = dArr[i88];
                int i95 = i88 + 1;
                double d59 = -dArr[i95];
                dArr[i87] = d58;
                dArr[i89] = d59;
                dArr[i88] = d56;
                dArr[i95] = d57;
                int i96 = i88 + i28 + 1;
                dArr[i96] = -dArr[i96];
                i29 = i78 + 1;
                i26 = i79;
                i18 = 0;
            }
            return;
        }
        int i97 = i26;
        dArr[1] = -dArr[1];
        int i98 = i28 + 1;
        dArr[i98] = -dArr[i98];
        for (int i99 = 1; i99 < i97; i99++) {
            for (int i100 = 0; i100 < i99; i100++) {
                int i101 = (i100 * 2) + iArr[i16 + i99];
                int i102 = (i99 * 2) + iArr[i16 + i100];
                double d65 = dArr[i101];
                int i103 = i101 + 1;
                double d66 = -dArr[i103];
                double d67 = dArr[i102];
                int i104 = i102 + 1;
                double d68 = -dArr[i104];
                dArr[i101] = d67;
                dArr[i103] = d68;
                dArr[i102] = d65;
                dArr[i104] = d66;
                int i105 = i101 + i28;
                int i106 = i102 + i28;
                double d69 = dArr[i105];
                int i107 = i105 + 1;
                double d75 = -dArr[i107];
                double d76 = dArr[i106];
                int i108 = i106 + 1;
                double d77 = -dArr[i108];
                dArr[i105] = d76;
                dArr[i107] = d77;
                dArr[i106] = d69;
                dArr[i108] = d75;
            }
            int i109 = (i99 * 2) + iArr[i16 + i99];
            int i110 = i109 + 1;
            dArr[i110] = -dArr[i110];
            int i111 = i109 + i28 + 1;
            dArr[i111] = -dArr[i111];
        }
    }

    private void cftb040(double[] dArr) {
        double d16 = dArr[0];
        double d17 = dArr[4];
        double d18 = d16 + d17;
        double d19 = dArr[1];
        double d26 = dArr[5];
        double d27 = d19 + d26;
        double d28 = d16 - d17;
        double d29 = d19 - d26;
        double d36 = dArr[2];
        double d37 = dArr[6];
        double d38 = d36 + d37;
        double d39 = dArr[3];
        double d46 = dArr[7];
        double d47 = d39 + d46;
        double d48 = d36 - d37;
        double d49 = d39 - d46;
        dArr[0] = d18 + d38;
        dArr[1] = d27 + d47;
        dArr[4] = d18 - d38;
        dArr[5] = d27 - d47;
        dArr[2] = d28 + d49;
        dArr[3] = d29 - d48;
        dArr[6] = d28 - d49;
        dArr[7] = d29 + d48;
    }

    private final void cftb1st(int i3, double[] dArr, double[] dArr2, int i16) {
        int i17 = i3 >> 3;
        int i18 = i17 * 2;
        int i19 = i18 + i18;
        int i26 = i19 + i18;
        int i27 = 0;
        double d16 = dArr[0];
        double d17 = dArr[i19];
        double d18 = d16 + d17;
        double d19 = dArr[1];
        int i28 = i19 + 1;
        double d26 = dArr[i28];
        double d27 = (-d19) - d26;
        double d28 = d16 - d17;
        double d29 = (-d19) + d26;
        double d36 = dArr[i18];
        double d37 = dArr[i26];
        double d38 = d36 + d37;
        int i29 = i18 + 1;
        double d39 = dArr[i29];
        int i36 = i26 + 1;
        double d46 = dArr[i36];
        double d47 = d39 + d46;
        double d48 = d36 - d37;
        double d49 = d39 - d46;
        dArr[0] = d18 + d38;
        dArr[1] = d27 - d47;
        dArr[i18] = d18 - d38;
        dArr[i29] = d27 + d47;
        dArr[i19] = d28 + d49;
        dArr[i28] = d29 + d48;
        dArr[i26] = d28 - d49;
        dArr[i36] = d29 - d48;
        double d56 = dArr2[i16 + 1];
        double d57 = dArr2[i16 + 2];
        double d58 = dArr2[i16 + 3];
        int i37 = 2;
        double d59 = 1.0d;
        double d65 = 0.0d;
        double d66 = 0.0d;
        double d67 = 1.0d;
        while (true) {
            double d68 = d56;
            int i38 = i17 - 2;
            if (i37 < i38) {
                int i39 = i27 + 4;
                int i46 = i16 + i39;
                double d69 = dArr2[i46];
                double d75 = (d59 + d69) * d57;
                double d76 = dArr2[i46 + 1];
                double d77 = (d65 + d76) * d57;
                double d78 = dArr2[i46 + 2];
                double d79 = (d67 + d78) * d58;
                double d85 = dArr2[i46 + 3];
                double d86 = (d66 - d85) * d58;
                double d87 = -d85;
                int i47 = i37 + i18;
                int i48 = i47 + i18;
                int i49 = i48 + i18;
                double d88 = dArr[i37];
                double d89 = dArr[i48];
                double d95 = d88 + d89;
                int i56 = i37 + 1;
                double d96 = d58;
                double d97 = dArr[i56];
                int i57 = i48 + 1;
                double d98 = dArr[i57];
                double d99 = (-d97) - d98;
                double d100 = d88 - d89;
                double d101 = (-d97) + d98;
                int i58 = i37 + 2;
                double d102 = dArr[i58];
                int i59 = i48 + 2;
                double d103 = dArr[i59];
                double d104 = d102 + d103;
                int i65 = i37 + 3;
                int i66 = i17;
                int i67 = i18;
                double d105 = dArr[i65];
                int i68 = i48 + 3;
                double d106 = dArr[i68];
                double d107 = (-d105) - d106;
                double d108 = d102 - d103;
                double d109 = (-d105) + d106;
                double d110 = dArr[i47];
                double d111 = dArr[i49];
                double d112 = d110 + d111;
                int i69 = i47 + 1;
                double d113 = dArr[i69];
                int i75 = i49 + 1;
                double d114 = dArr[i75];
                double d115 = d113 + d114;
                double d116 = d110 - d111;
                double d117 = d113 - d114;
                int i76 = i47 + 2;
                double d118 = dArr[i76];
                int i77 = i49 + 2;
                double d119 = dArr[i77];
                double d120 = d118 + d119;
                int i78 = i47 + 3;
                double d121 = dArr[i78];
                int i79 = i49 + 3;
                double d122 = dArr[i79];
                double d123 = d121 + d122;
                double d124 = d118 - d119;
                double d125 = d121 - d122;
                dArr[i37] = d95 + d112;
                dArr[i56] = d99 - d115;
                dArr[i58] = d104 + d120;
                dArr[i65] = d107 - d123;
                dArr[i47] = d95 - d112;
                dArr[i69] = d99 + d115;
                dArr[i76] = d104 - d120;
                dArr[i78] = d107 + d123;
                double d126 = d100 + d117;
                double d127 = d101 + d116;
                dArr[i48] = (d75 * d126) - (d77 * d127);
                dArr[i57] = (d127 * d75) + (d126 * d77);
                double d128 = d108 + d125;
                double d129 = d109 + d124;
                dArr[i59] = (d69 * d128) - (d76 * d129);
                dArr[i68] = (d129 * d69) + (d128 * d76);
                double d130 = d100 - d117;
                double d131 = d101 - d116;
                dArr[i49] = (d79 * d130) + (d86 * d131);
                dArr[i75] = (d131 * d79) - (d130 * d86);
                double d132 = d108 - d125;
                double d133 = d109 - d124;
                dArr[i77] = (d78 * d132) + (d87 * d133);
                dArr[i79] = (d133 * d78) - (d87 * d132);
                int i85 = i67 - i37;
                int i86 = i85 + i67;
                int i87 = i86 + i67;
                int i88 = i87 + i67;
                double d134 = dArr[i85];
                double d135 = dArr[i87];
                double d136 = d134 + d135;
                int i89 = i85 + 1;
                double d137 = dArr[i89];
                int i95 = i37;
                int i96 = i87 + 1;
                double d138 = dArr[i96];
                double d139 = (-d137) - d138;
                double d140 = d134 - d135;
                double d141 = (-d137) + d138;
                int i97 = i85 - 2;
                double d142 = dArr[i97];
                int i98 = i87 - 2;
                double d143 = dArr[i98];
                double d144 = d142 + d143;
                int i99 = i85 - 1;
                double d145 = dArr[i99];
                int i100 = i87 - 1;
                double d146 = dArr[i100];
                double d147 = (-d145) - d146;
                double d148 = d142 - d143;
                double d149 = (-d145) + d146;
                double d150 = dArr[i86];
                double d151 = dArr[i88];
                double d152 = d150 + d151;
                int i101 = i86 + 1;
                double d153 = dArr[i101];
                int i102 = i88 + 1;
                double d154 = dArr[i102];
                double d155 = d153 + d154;
                double d156 = d150 - d151;
                double d157 = d153 - d154;
                int i103 = i86 - 2;
                double d158 = dArr[i103];
                int i104 = i88 - 2;
                double d159 = dArr[i104];
                double d160 = d158 + d159;
                int i105 = i86 - 1;
                double d161 = dArr[i105];
                int i106 = i88 - 1;
                double d162 = dArr[i106];
                double d163 = d161 + d162;
                double d164 = d158 - d159;
                double d165 = d161 - d162;
                dArr[i85] = d136 + d152;
                dArr[i89] = d139 - d155;
                dArr[i97] = d144 + d160;
                dArr[i99] = d147 - d163;
                dArr[i86] = d136 - d152;
                dArr[i101] = d139 + d155;
                dArr[i103] = d144 - d160;
                dArr[i105] = d147 + d163;
                double d166 = d140 + d157;
                double d167 = d141 + d156;
                dArr[i87] = (d77 * d166) - (d75 * d167);
                dArr[i96] = (d167 * d77) + (d166 * d75);
                double d168 = d148 + d165;
                double d169 = d149 + d164;
                dArr[i98] = (d76 * d168) - (d69 * d169);
                dArr[i100] = (d169 * d76) + (d168 * d69);
                double d170 = d140 - d157;
                double d171 = d141 - d156;
                dArr[i88] = (d86 * d170) + (d79 * d171);
                dArr[i102] = (d86 * d171) - (d79 * d170);
                double d172 = d148 - d165;
                double d173 = d149 - d164;
                dArr[i104] = (d87 * d172) + (d78 * d173);
                dArr[i106] = (d87 * d173) - (d172 * d78);
                i37 = i95 + 4;
                i27 = i39;
                d56 = d68;
                d59 = d69;
                d65 = d76;
                d67 = d78;
                d58 = d96;
                d57 = d57;
                i17 = i66;
                i18 = i67;
                d66 = d87;
            } else {
                int i107 = i17;
                int i108 = i18;
                double d174 = d57;
                double d175 = d58;
                double d176 = d174 * (d59 + d68);
                double d177 = d174 * (d65 + d68);
                double d178 = d175 * (d67 - d68);
                double d179 = d175 * (d66 - d68);
                int i109 = i107 + i108;
                int i110 = i109 + i108;
                int i111 = i110 + i108;
                double d180 = dArr[i38];
                int i112 = i110 - 2;
                double d181 = dArr[i112];
                double d182 = d180 + d181;
                int i113 = i107 - 1;
                double d183 = dArr[i113];
                int i114 = i110 - 1;
                double d184 = dArr[i114];
                double d185 = (-d183) - d184;
                double d186 = d180 - d181;
                double d187 = (-d183) + d184;
                int i115 = i109 - 2;
                double d188 = dArr[i115];
                int i116 = i111 - 2;
                double d189 = dArr[i116];
                double d190 = d188 + d189;
                int i117 = i109 - 1;
                double d191 = dArr[i117];
                int i118 = i111 - 1;
                double d192 = dArr[i118];
                double d193 = d191 + d192;
                double d194 = d188 - d189;
                double d195 = d191 - d192;
                dArr[i38] = d182 + d190;
                dArr[i113] = d185 - d193;
                dArr[i115] = d182 - d190;
                dArr[i117] = d185 + d193;
                double d196 = d186 + d195;
                double d197 = d187 + d194;
                dArr[i112] = (d176 * d196) - (d177 * d197);
                dArr[i114] = (d197 * d176) + (d196 * d177);
                double d198 = d186 - d195;
                double d199 = d187 - d194;
                dArr[i116] = (d178 * d198) + (d179 * d199);
                dArr[i118] = (d178 * d199) - (d179 * d198);
                double d200 = dArr[i107];
                double d201 = dArr[i110];
                double d202 = d200 + d201;
                int i119 = i107 + 1;
                double d203 = dArr[i119];
                int i120 = i110 + 1;
                double d204 = dArr[i120];
                double d205 = (-d203) - d204;
                double d206 = d200 - d201;
                double d207 = (-d203) + d204;
                double d208 = dArr[i109];
                double d209 = dArr[i111];
                double d210 = d208 + d209;
                int i121 = i109 + 1;
                double d211 = dArr[i121];
                int i122 = i111 + 1;
                double d212 = dArr[i122];
                double d213 = d211 + d212;
                double d214 = d208 - d209;
                double d215 = d211 - d212;
                dArr[i107] = d202 + d210;
                dArr[i119] = d205 - d213;
                dArr[i109] = d202 - d210;
                dArr[i121] = d205 + d213;
                double d216 = d206 + d215;
                double d217 = d207 + d214;
                dArr[i110] = (d216 - d217) * d68;
                dArr[i120] = d68 * (d217 + d216);
                double d218 = d206 - d215;
                double d219 = d207 - d214;
                double d220 = -d68;
                dArr[i111] = (d218 + d219) * d220;
                dArr[i122] = d220 * (d219 - d218);
                int i123 = i107 + 2;
                double d221 = dArr[i123];
                int i124 = i110 + 2;
                double d222 = dArr[i124];
                double d223 = d221 + d222;
                int i125 = i107 + 3;
                double d224 = dArr[i125];
                int i126 = i110 + 3;
                double d225 = dArr[i126];
                double d226 = (-d224) - d225;
                double d227 = d221 - d222;
                double d228 = (-d224) + d225;
                int i127 = i109 + 2;
                double d229 = dArr[i127];
                int i128 = i111 + 2;
                double d230 = dArr[i128];
                double d231 = d229 + d230;
                int i129 = i109 + 3;
                double d232 = dArr[i129];
                int i130 = i111 + 3;
                double d233 = dArr[i130];
                double d234 = d232 + d233;
                double d235 = d229 - d230;
                double d236 = d232 - d233;
                dArr[i123] = d223 + d231;
                dArr[i125] = d226 - d234;
                dArr[i127] = d223 - d231;
                dArr[i129] = d226 + d234;
                double d237 = d227 + d236;
                double d238 = d228 + d235;
                dArr[i124] = (d177 * d237) - (d176 * d238);
                dArr[i126] = (d238 * d177) + (d237 * d176);
                double d239 = d227 - d236;
                double d240 = d228 - d235;
                dArr[i128] = (d179 * d239) + (d178 * d240);
                dArr[i130] = (d179 * d240) - (d178 * d239);
                return;
            }
        }
    }

    private void cftbsub(int i3, double[] dArr, int[] iArr, int i16, int i17, double[] dArr2) {
        if (i3 > 32) {
            int i18 = i3 >> 2;
            cftb1st(i3, dArr, dArr2, i17 - i18);
            if (i3 > 512) {
                cftrec1(i18, dArr, 0, i17, dArr2);
                cftrec2(i18, dArr, i18, i17, dArr2);
                cftrec1(i18, dArr, i18 * 2, i17, dArr2);
                cftrec1(i18, dArr, i18 * 3, i17, dArr2);
            } else if (i18 > 32) {
                cftexp1(i3, dArr, 0, i17, dArr2);
            } else {
                cftfx41(i3, dArr, 0, i17, dArr2);
            }
            bitrv2conj(i3, iArr, i16, dArr);
            return;
        }
        if (i3 > 8) {
            if (i3 == 32) {
                cftf161(dArr, 0, dArr2, i17 - 8);
                bitrv216neg(dArr);
                return;
            } else {
                cftf081(dArr, 0, dArr2, 0);
                bitrv208neg(dArr);
                return;
            }
        }
        if (i3 == 8) {
            cftb040(dArr);
        } else if (i3 == 4) {
            cftx020(dArr);
        }
    }

    private void cftexp1(int i3, double[] dArr, int i16, int i17, double[] dArr2) {
        int i18 = i3 >> 2;
        while (i18 > 128) {
            for (int i19 = i18; i19 < i3; i19 <<= 2) {
                for (int i26 = i19 - i18; i26 < i3; i26 += i19 * 4) {
                    int i27 = i17 - (i18 >> 1);
                    int i28 = i18;
                    cftmdl1(i28, dArr, i16 + i26, dArr2, i27);
                    cftmdl2(i28, dArr, i16 + i19 + i26, dArr2, i17 - i18);
                    cftmdl1(i28, dArr, i16 + (i19 * 2) + i26, dArr2, i27);
                }
            }
            cftmdl1(i18, dArr, (i16 + i3) - i18, dArr2, i17 - (i18 >> 1));
            i18 >>= 2;
        }
        for (int i29 = i18; i29 < i3; i29 <<= 2) {
            for (int i36 = i29 - i18; i36 < i3; i36 += i29 * 4) {
                int i37 = i16 + i36;
                int i38 = i17 - (i18 >> 1);
                cftmdl1(i18, dArr, i37, dArr2, i38);
                cftfx41(i18, dArr, i37, i17, dArr2);
                int i39 = i16 + i29 + i36;
                cftmdl2(i18, dArr, i39, dArr2, i17 - i18);
                cftfx42(i18, dArr, i39, i17, dArr2);
                int i46 = i16 + (i29 * 2) + i36;
                cftmdl1(i18, dArr, i46, dArr2, i38);
                cftfx41(i18, dArr, i46, i17, dArr2);
            }
        }
        int i47 = (i16 + i3) - i18;
        cftmdl1(i18, dArr, i47, dArr2, i17 - (i18 >> 1));
        cftfx41(i18, dArr, i47, i17, dArr2);
    }

    private void cftexp2(int i3, double[] dArr, int i16, int i17, double[] dArr2) {
        int i18 = i3 >> 1;
        int i19 = i3 >> 2;
        while (i19 > 128) {
            for (int i26 = i19; i26 < i18; i26 <<= 2) {
                for (int i27 = i26 - i19; i27 < i18; i27 += i26 * 2) {
                    int i28 = i17 - (i19 >> 1);
                    int i29 = i19;
                    cftmdl1(i29, dArr, i16 + i27, dArr2, i28);
                    cftmdl1(i29, dArr, i16 + i18 + i27, dArr2, i28);
                }
                for (int i36 = (i26 * 2) - i19; i36 < i18; i36 += i26 * 4) {
                    int i37 = i17 - i19;
                    int i38 = i19;
                    cftmdl2(i38, dArr, i16 + i36, dArr2, i37);
                    cftmdl2(i38, dArr, i16 + i18 + i36, dArr2, i37);
                }
            }
            i19 >>= 2;
        }
        for (int i39 = i19; i39 < i18; i39 <<= 2) {
            for (int i46 = i39 - i19; i46 < i18; i46 += i39 * 2) {
                int i47 = i16 + i46;
                int i48 = i17 - (i19 >> 1);
                int i49 = i19;
                cftmdl1(i49, dArr, i47, dArr2, i48);
                int i56 = i19;
                cftfx41(i56, dArr, i47, i17, dArr2);
                int i57 = i16 + i18 + i46;
                cftmdl1(i49, dArr, i57, dArr2, i48);
                cftfx41(i56, dArr, i57, i17, dArr2);
            }
            for (int i58 = (i39 * 2) - i19; i58 < i18; i58 += i39 * 4) {
                int i59 = i16 + i58;
                int i65 = i17 - i19;
                int i66 = i19;
                cftmdl2(i66, dArr, i59, dArr2, i65);
                int i67 = i19;
                cftfx42(i67, dArr, i59, i17, dArr2);
                int i68 = i16 + i18 + i58;
                cftmdl2(i66, dArr, i68, dArr2, i65);
                cftfx42(i67, dArr, i68, i17, dArr2);
            }
        }
    }

    private void cftf040(double[] dArr) {
        double d16 = dArr[0];
        double d17 = dArr[4];
        double d18 = d16 + d17;
        double d19 = dArr[1];
        double d26 = dArr[5];
        double d27 = d19 + d26;
        double d28 = d16 - d17;
        double d29 = d19 - d26;
        double d36 = dArr[2];
        double d37 = dArr[6];
        double d38 = d36 + d37;
        double d39 = dArr[3];
        double d46 = dArr[7];
        double d47 = d39 + d46;
        double d48 = d36 - d37;
        double d49 = d39 - d46;
        dArr[0] = d18 + d38;
        dArr[1] = d27 + d47;
        dArr[4] = d18 - d38;
        dArr[5] = d27 - d47;
        dArr[2] = d28 - d49;
        dArr[3] = d29 + d48;
        dArr[6] = d28 + d49;
        dArr[7] = d29 - d48;
    }

    private void cftf081(double[] dArr, int i3, double[] dArr2, int i16) {
        double d16 = dArr2[i16 + 1];
        int i17 = i3 + 0;
        double d17 = dArr[i17];
        int i18 = i3 + 8;
        double d18 = dArr[i18];
        double d19 = d17 + d18;
        int i19 = i3 + 1;
        double d26 = dArr[i19];
        int i26 = i3 + 9;
        double d27 = dArr[i26];
        double d28 = d26 + d27;
        double d29 = d17 - d18;
        double d36 = d26 - d27;
        int i27 = i3 + 4;
        double d37 = dArr[i27];
        int i28 = i3 + 12;
        double d38 = dArr[i28];
        double d39 = d37 + d38;
        int i29 = i3 + 5;
        double d46 = dArr[i29];
        int i36 = i3 + 13;
        double d47 = dArr[i36];
        double d48 = d46 + d47;
        double d49 = d37 - d38;
        double d56 = d46 - d47;
        double d57 = d19 + d39;
        double d58 = d28 + d48;
        double d59 = d19 - d39;
        double d65 = d28 - d48;
        double d66 = d29 - d56;
        double d67 = d36 + d49;
        double d68 = d29 + d56;
        double d69 = d36 - d49;
        int i37 = i3 + 2;
        double d75 = dArr[i37];
        int i38 = i3 + 10;
        double d76 = dArr[i38];
        double d77 = d75 + d76;
        int i39 = i3 + 3;
        double d78 = dArr[i39];
        int i46 = i3 + 11;
        double d79 = dArr[i46];
        double d85 = d78 + d79;
        double d86 = d75 - d76;
        double d87 = d78 - d79;
        int i47 = i3 + 6;
        double d88 = dArr[i47];
        int i48 = i3 + 14;
        double d89 = dArr[i48];
        double d95 = d88 + d89;
        int i49 = i3 + 7;
        double d96 = dArr[i49];
        int i56 = i3 + 15;
        double d97 = dArr[i56];
        double d98 = d96 + d97;
        double d99 = d88 - d89;
        double d100 = d96 - d97;
        double d101 = d77 + d95;
        double d102 = d85 + d98;
        double d103 = d77 - d95;
        double d104 = d85 - d98;
        double d105 = d86 - d100;
        double d106 = d87 + d99;
        double d107 = d86 + d100;
        double d108 = d87 - d99;
        double d109 = (d105 - d106) * d16;
        double d110 = (d105 + d106) * d16;
        double d111 = (d107 - d108) * d16;
        double d112 = d16 * (d107 + d108);
        dArr[i18] = d66 + d109;
        dArr[i26] = d67 + d110;
        dArr[i38] = d66 - d109;
        dArr[i46] = d67 - d110;
        dArr[i28] = d68 - d112;
        dArr[i36] = d69 + d111;
        dArr[i48] = d68 + d112;
        dArr[i56] = d69 - d111;
        dArr[i17] = d57 + d101;
        dArr[i19] = d58 + d102;
        dArr[i37] = d57 - d101;
        dArr[i39] = d58 - d102;
        dArr[i27] = d59 - d104;
        dArr[i29] = d65 + d103;
        dArr[i47] = d59 + d104;
        dArr[i49] = d65 - d103;
    }

    private void cftf082(double[] dArr, int i3, double[] dArr2, int i16) {
        double d16 = dArr2[i16 + 1];
        double d17 = dArr2[i16 + 4];
        double d18 = dArr2[i16 + 5];
        int i17 = i3 + 0;
        double d19 = dArr[i17];
        int i18 = i3 + 9;
        double d26 = dArr[i18];
        double d27 = d19 - d26;
        int i19 = i3 + 1;
        double d28 = dArr[i19];
        int i26 = i3 + 8;
        double d29 = dArr[i26];
        double d36 = d28 + d29;
        double d37 = d19 + d26;
        double d38 = d28 - d29;
        int i27 = i3 + 4;
        double d39 = dArr[i27];
        int i28 = i3 + 13;
        double d46 = dArr[i28];
        double d47 = d39 - d46;
        int i29 = i3 + 5;
        double d48 = dArr[i29];
        int i36 = i3 + 12;
        double d49 = dArr[i36];
        double d56 = d48 + d49;
        double d57 = (d47 - d56) * d16;
        double d58 = (d56 + d47) * d16;
        double d59 = d39 + d46;
        double d65 = d48 - d49;
        double d66 = (d59 - d65) * d16;
        double d67 = d16 * (d65 + d59);
        int i37 = i3 + 2;
        double d68 = dArr[i37];
        int i38 = i3 + 11;
        double d69 = dArr[i38];
        double d75 = d68 - d69;
        int i39 = i3 + 3;
        double d76 = dArr[i39];
        int i46 = i3 + 10;
        double d77 = dArr[i46];
        double d78 = d76 + d77;
        double d79 = (d17 * d75) - (d18 * d78);
        double d85 = (d78 * d17) + (d75 * d18);
        double d86 = d68 + d69;
        double d87 = d76 - d77;
        double d88 = (d18 * d86) - (d17 * d87);
        double d89 = (d87 * d18) + (d86 * d17);
        int i47 = i3 + 6;
        double d95 = dArr[i47];
        int i48 = i3 + 15;
        double d96 = dArr[i48];
        double d97 = d95 - d96;
        int i49 = i3 + 7;
        double d98 = dArr[i49];
        int i56 = i3 + 14;
        double d99 = dArr[i56];
        double d100 = d98 + d99;
        double d101 = (d18 * d97) - (d17 * d100);
        double d102 = (d100 * d18) + (d97 * d17);
        double d103 = d95 + d96;
        double d104 = d98 - d99;
        double d105 = (d17 * d103) - (d18 * d104);
        double d106 = (d17 * d104) + (d18 * d103);
        double d107 = d27 + d57;
        double d108 = d36 + d58;
        double d109 = d79 + d101;
        double d110 = d85 + d102;
        dArr[i17] = d107 + d109;
        dArr[i19] = d108 + d110;
        dArr[i37] = d107 - d109;
        dArr[i39] = d108 - d110;
        double d111 = d27 - d57;
        double d112 = d36 - d58;
        double d113 = d79 - d101;
        double d114 = d85 - d102;
        dArr[i27] = d111 - d114;
        dArr[i29] = d112 + d113;
        dArr[i47] = d111 + d114;
        dArr[i49] = d112 - d113;
        double d115 = d37 - d67;
        double d116 = d38 + d66;
        double d117 = d88 - d105;
        double d118 = d89 - d106;
        dArr[i26] = d115 + d117;
        dArr[i18] = d116 + d118;
        dArr[i46] = d115 - d117;
        dArr[i38] = d116 - d118;
        double d119 = d37 + d67;
        double d120 = d38 - d66;
        double d121 = d88 + d105;
        double d122 = d89 + d106;
        dArr[i36] = d119 - d122;
        dArr[i28] = d120 + d121;
        dArr[i56] = d119 + d122;
        dArr[i48] = d120 - d121;
    }

    private void cftf161(double[] dArr, int i3, double[] dArr2, int i16) {
        double d16 = dArr2[i16 + 1];
        double d17 = dArr2[i16 + 2];
        double d18 = d16 * d17;
        double d19 = d17 + d18;
        int i17 = i3 + 0;
        double d26 = dArr[i17];
        int i18 = i3 + 16;
        double d27 = dArr[i18];
        double d28 = d26 + d27;
        int i19 = i3 + 1;
        double d29 = dArr[i19];
        int i26 = i3 + 17;
        double d36 = dArr[i26];
        double d37 = d29 + d36;
        double d38 = d26 - d27;
        double d39 = d29 - d36;
        int i27 = i3 + 8;
        double d46 = dArr[i27];
        int i28 = i3 + 24;
        double d47 = dArr[i28];
        double d48 = d46 + d47;
        int i29 = i3 + 9;
        double d49 = dArr[i29];
        int i36 = i3 + 25;
        double d56 = dArr[i36];
        double d57 = d49 + d56;
        double d58 = d46 - d47;
        double d59 = d49 - d56;
        double d65 = d28 + d48;
        double d66 = d37 + d57;
        double d67 = d28 - d48;
        double d68 = d37 - d57;
        double d69 = d38 - d59;
        double d75 = d39 + d58;
        double d76 = d38 + d59;
        double d77 = d39 - d58;
        int i37 = i3 + 2;
        double d78 = dArr[i37];
        int i38 = i3 + 18;
        double d79 = dArr[i38];
        double d85 = d78 + d79;
        int i39 = i3 + 3;
        double d86 = dArr[i39];
        int i46 = i3 + 19;
        double d87 = dArr[i46];
        double d88 = d86 + d87;
        double d89 = d78 - d79;
        double d95 = d86 - d87;
        int i47 = i3 + 10;
        double d96 = dArr[i47];
        int i48 = i3 + 26;
        double d97 = dArr[i48];
        double d98 = d96 + d97;
        int i49 = i3 + 11;
        double d99 = dArr[i49];
        int i56 = i3 + 27;
        double d100 = dArr[i56];
        double d101 = d99 + d100;
        double d102 = d96 - d97;
        double d103 = d99 - d100;
        double d104 = d85 + d98;
        double d105 = d88 + d101;
        double d106 = d85 - d98;
        double d107 = d88 - d101;
        double d108 = d89 - d103;
        double d109 = d95 + d102;
        double d110 = (d19 * d108) - (d18 * d109);
        double d111 = (d109 * d19) + (d108 * d18);
        double d112 = d89 + d103;
        double d113 = d95 - d102;
        double d114 = (d18 * d112) - (d19 * d113);
        double d115 = (d113 * d18) + (d112 * d19);
        int i57 = i3 + 4;
        double d116 = dArr[i57];
        int i58 = i3 + 20;
        double d117 = dArr[i58];
        double d118 = d116 + d117;
        int i59 = i3 + 5;
        double d119 = dArr[i59];
        int i65 = i3 + 21;
        double d120 = dArr[i65];
        double d121 = d119 + d120;
        double d122 = d116 - d117;
        double d123 = d119 - d120;
        int i66 = i3 + 12;
        double d124 = dArr[i66];
        int i67 = i3 + 28;
        double d125 = dArr[i67];
        double d126 = d124 + d125;
        int i68 = i3 + 13;
        double d127 = dArr[i68];
        int i69 = i3 + 29;
        double d128 = dArr[i69];
        double d129 = d127 + d128;
        double d130 = d124 - d125;
        double d131 = d127 - d128;
        double d132 = d118 + d126;
        double d133 = d121 + d129;
        double d134 = d118 - d126;
        double d135 = d121 - d129;
        double d136 = d122 - d131;
        double d137 = d123 + d130;
        double d138 = (d136 - d137) * d16;
        double d139 = (d137 + d136) * d16;
        double d140 = d122 + d131;
        double d141 = d123 - d130;
        double d142 = (d140 + d141) * d16;
        double d143 = (d141 - d140) * d16;
        int i75 = i3 + 6;
        double d144 = dArr[i75];
        int i76 = i3 + 22;
        double d145 = dArr[i76];
        double d146 = d144 + d145;
        int i77 = i3 + 7;
        double d147 = dArr[i77];
        int i78 = i3 + 23;
        double d148 = dArr[i78];
        double d149 = d147 + d148;
        double d150 = d144 - d145;
        double d151 = d147 - d148;
        int i79 = i3 + 14;
        double d152 = dArr[i79];
        int i85 = i3 + 30;
        double d153 = dArr[i85];
        double d154 = d152 + d153;
        int i86 = i3 + 15;
        double d155 = dArr[i86];
        int i87 = i3 + 31;
        double d156 = dArr[i87];
        double d157 = d155 + d156;
        double d158 = d152 - d153;
        double d159 = d155 - d156;
        double d160 = d146 + d154;
        double d161 = d149 + d157;
        double d162 = d146 - d154;
        double d163 = d149 - d157;
        double d164 = d150 - d159;
        double d165 = d151 + d158;
        double d166 = (d18 * d164) - (d19 * d165);
        double d167 = (d165 * d18) + (d164 * d19);
        double d168 = d150 + d159;
        double d169 = d151 - d158;
        double d170 = (d19 * d168) - (d18 * d169);
        double d171 = (d19 * d169) + (d18 * d168);
        double d172 = d76 - d142;
        double d173 = d77 - d143;
        double d174 = d76 + d142;
        double d175 = d77 + d143;
        double d176 = d114 - d170;
        double d177 = d115 - d171;
        double d178 = d114 + d170;
        double d179 = d115 + d171;
        dArr[i28] = d172 + d176;
        dArr[i36] = d173 + d177;
        dArr[i48] = d172 - d176;
        dArr[i56] = d173 - d177;
        dArr[i67] = d174 - d179;
        dArr[i69] = d175 + d178;
        dArr[i85] = d174 + d179;
        dArr[i87] = d175 - d178;
        double d180 = d69 + d138;
        double d181 = d75 + d139;
        double d182 = d69 - d138;
        double d183 = d75 - d139;
        double d184 = d110 + d166;
        double d185 = d111 + d167;
        double d186 = d110 - d166;
        double d187 = d111 - d167;
        dArr[i18] = d180 + d184;
        dArr[i26] = d181 + d185;
        dArr[i38] = d180 - d184;
        dArr[i46] = d181 - d185;
        dArr[i58] = d182 - d187;
        dArr[i65] = d183 + d186;
        dArr[i76] = d182 + d187;
        dArr[i78] = d183 - d186;
        double d188 = d106 - d163;
        double d189 = d107 + d162;
        double d190 = (d188 - d189) * d16;
        double d191 = (d189 + d188) * d16;
        double d192 = d106 + d163;
        double d193 = d107 - d162;
        double d194 = (d192 - d193) * d16;
        double d195 = d16 * (d193 + d192);
        double d196 = d67 - d135;
        double d197 = d68 + d134;
        double d198 = d67 + d135;
        double d199 = d68 - d134;
        dArr[i27] = d196 + d190;
        dArr[i29] = d197 + d191;
        dArr[i47] = d196 - d190;
        dArr[i49] = d197 - d191;
        dArr[i66] = d198 - d195;
        dArr[i68] = d199 + d194;
        dArr[i79] = d198 + d195;
        dArr[i86] = d199 - d194;
        double d200 = d65 + d132;
        double d201 = d66 + d133;
        double d202 = d65 - d132;
        double d203 = d66 - d133;
        double d204 = d104 + d160;
        double d205 = d105 + d161;
        double d206 = d104 - d160;
        double d207 = d105 - d161;
        dArr[i17] = d200 + d204;
        dArr[i19] = d201 + d205;
        dArr[i37] = d200 - d204;
        dArr[i39] = d201 - d205;
        dArr[i57] = d202 - d207;
        dArr[i59] = d203 + d206;
        dArr[i75] = d202 + d207;
        dArr[i77] = d203 - d206;
    }

    private void cftf162(double[] dArr, int i3, double[] dArr2, int i16) {
        double d16 = dArr2[i16 + 1];
        double d17 = dArr2[i16 + 4];
        double d18 = dArr2[i16 + 5];
        double d19 = dArr2[i16 + 6];
        double d26 = dArr2[i16 + 7];
        double d27 = dArr2[i16 + 8];
        double d28 = dArr2[i16 + 9];
        int i17 = i3 + 0;
        double d29 = dArr[i17];
        int i18 = i3 + 17;
        double d36 = dArr[i18];
        double d37 = d29 - d36;
        int i19 = i3 + 1;
        double d38 = dArr[i19];
        int i26 = i3 + 16;
        double d39 = dArr[i26];
        double d46 = d38 + d39;
        int i27 = i3 + 8;
        double d47 = dArr[i27];
        int i28 = i3 + 25;
        double d48 = dArr[i28];
        double d49 = d47 - d48;
        int i29 = i3 + 9;
        double d56 = dArr[i29];
        int i36 = i3 + 24;
        double d57 = dArr[i36];
        double d58 = d56 + d57;
        double d59 = (d49 - d58) * d16;
        double d65 = (d58 + d49) * d16;
        double d66 = d37 + d59;
        double d67 = d46 + d65;
        double d68 = d37 - d59;
        double d69 = d46 - d65;
        double d75 = d29 + d36;
        double d76 = d38 - d39;
        double d77 = d47 + d48;
        double d78 = d56 - d57;
        double d79 = (d77 - d78) * d16;
        double d85 = (d78 + d77) * d16;
        double d86 = d75 - d85;
        double d87 = d76 + d79;
        double d88 = d75 + d85;
        double d89 = d76 - d79;
        int i37 = i3 + 2;
        double d95 = dArr[i37];
        int i38 = i3 + 19;
        double d96 = dArr[i38];
        double d97 = d95 - d96;
        int i39 = i3 + 3;
        double d98 = dArr[i39];
        int i46 = i3 + 18;
        double d99 = dArr[i46];
        double d100 = d98 + d99;
        double d101 = (d17 * d97) - (d18 * d100);
        double d102 = (d100 * d17) + (d97 * d18);
        int i47 = i3 + 10;
        double d103 = dArr[i47];
        int i48 = i3 + 27;
        double d104 = dArr[i48];
        double d105 = d103 - d104;
        int i49 = i3 + 11;
        double d106 = dArr[i49];
        int i56 = i3 + 26;
        double d107 = dArr[i56];
        double d108 = d106 + d107;
        double d109 = (d26 * d105) - (d19 * d108);
        double d110 = (d108 * d26) + (d105 * d19);
        double d111 = d101 + d109;
        double d112 = d102 + d110;
        double d113 = d101 - d109;
        double d114 = d102 - d110;
        double d115 = d95 + d96;
        double d116 = d98 - d99;
        double d117 = (d19 * d115) - (d26 * d116);
        double d118 = (d116 * d19) + (d115 * d26);
        double d119 = d103 + d104;
        double d120 = d106 - d107;
        double d121 = (d17 * d119) + (d18 * d120);
        double d122 = (d120 * d17) - (d119 * d18);
        double d123 = d117 - d121;
        double d124 = d118 - d122;
        double d125 = d117 + d121;
        double d126 = d118 + d122;
        int i57 = i3 + 4;
        double d127 = dArr[i57];
        int i58 = i3 + 21;
        double d128 = dArr[i58];
        double d129 = d127 - d128;
        int i59 = i3 + 5;
        double d130 = dArr[i59];
        int i65 = i3 + 20;
        double d131 = dArr[i65];
        double d132 = d130 + d131;
        double d133 = (d27 * d129) - (d28 * d132);
        double d134 = (d132 * d27) + (d129 * d28);
        int i66 = i3 + 12;
        double d135 = dArr[i66];
        int i67 = i3 + 29;
        double d136 = dArr[i67];
        double d137 = d135 - d136;
        int i68 = i3 + 13;
        double d138 = dArr[i68];
        int i69 = i3 + 28;
        double d139 = dArr[i69];
        double d140 = d138 + d139;
        double d141 = (d28 * d137) - (d27 * d140);
        double d142 = (d140 * d28) + (d137 * d27);
        double d143 = d133 + d141;
        double d144 = d134 + d142;
        double d145 = d133 - d141;
        double d146 = d134 - d142;
        double d147 = d127 + d128;
        double d148 = d130 - d131;
        double d149 = (d28 * d147) - (d27 * d148);
        double d150 = (d148 * d28) + (d147 * d27);
        double d151 = d135 + d136;
        double d152 = d138 - d139;
        double d153 = (d27 * d151) - (d28 * d152);
        double d154 = (d27 * d152) + (d28 * d151);
        double d155 = d149 - d153;
        double d156 = d150 - d154;
        double d157 = d149 + d153;
        double d158 = d150 + d154;
        int i75 = i3 + 6;
        double d159 = dArr[i75];
        int i76 = i3 + 23;
        double d160 = dArr[i76];
        double d161 = d159 - d160;
        int i77 = i3 + 7;
        double d162 = dArr[i77];
        int i78 = i3 + 22;
        double d163 = dArr[i78];
        double d164 = d162 + d163;
        double d165 = (d19 * d161) - (d26 * d164);
        double d166 = (d164 * d19) + (d161 * d26);
        int i79 = i3 + 14;
        double d167 = dArr[i79];
        int i85 = i3 + 31;
        double d168 = dArr[i85];
        double d169 = d167 - d168;
        int i86 = i3 + 15;
        double d170 = dArr[i86];
        int i87 = i3 + 30;
        double d171 = dArr[i87];
        double d172 = d170 + d171;
        double d173 = (d18 * d169) - (d17 * d172);
        double d174 = (d172 * d18) + (d169 * d17);
        double d175 = d165 + d173;
        double d176 = d166 + d174;
        double d177 = d165 - d173;
        double d178 = d166 - d174;
        double d179 = d159 + d160;
        double d180 = d162 - d163;
        double d181 = (d18 * d179) + (d17 * d180);
        double d182 = (d18 * d180) - (d17 * d179);
        double d183 = d167 + d168;
        double d184 = d170 - d171;
        double d185 = (d26 * d183) - (d19 * d184);
        double d186 = (d26 * d184) + (d19 * d183);
        double d187 = d181 + d185;
        double d188 = d182 + d186;
        double d189 = d181 - d185;
        double d190 = d182 - d186;
        double d191 = d66 + d143;
        double d192 = d67 + d144;
        double d193 = d111 + d175;
        double d194 = d112 + d176;
        dArr[i17] = d191 + d193;
        dArr[i19] = d192 + d194;
        dArr[i37] = d191 - d193;
        dArr[i39] = d192 - d194;
        double d195 = d66 - d143;
        double d196 = d67 - d144;
        double d197 = d111 - d175;
        double d198 = d112 - d176;
        dArr[i57] = d195 - d198;
        dArr[i59] = d196 + d197;
        dArr[i75] = d195 + d198;
        dArr[i77] = d196 - d197;
        double d199 = d68 - d146;
        double d200 = d69 + d145;
        double d201 = d113 - d178;
        double d202 = d114 + d177;
        double d203 = (d201 - d202) * d16;
        double d204 = (d202 + d201) * d16;
        dArr[i27] = d199 + d203;
        dArr[i29] = d200 + d204;
        dArr[i47] = d199 - d203;
        dArr[i49] = d200 - d204;
        double d205 = d68 + d146;
        double d206 = d69 - d145;
        double d207 = d113 + d178;
        double d208 = d114 - d177;
        double d209 = (d207 - d208) * d16;
        double d210 = (d208 + d207) * d16;
        dArr[i66] = d205 - d210;
        dArr[i68] = d206 + d209;
        dArr[i79] = d205 + d210;
        dArr[i86] = d206 - d209;
        double d211 = d86 + d155;
        double d212 = d87 + d156;
        double d213 = d123 - d187;
        double d214 = d124 - d188;
        dArr[i26] = d211 + d213;
        dArr[i18] = d212 + d214;
        dArr[i46] = d211 - d213;
        dArr[i38] = d212 - d214;
        double d215 = d86 - d155;
        double d216 = d87 - d156;
        double d217 = d123 + d187;
        double d218 = d124 + d188;
        dArr[i65] = d215 - d218;
        dArr[i58] = d216 + d217;
        dArr[i78] = d215 + d218;
        dArr[i76] = d216 - d217;
        double d219 = d88 - d158;
        double d220 = d89 + d157;
        double d221 = d125 + d190;
        double d222 = d126 - d189;
        double d223 = (d221 - d222) * d16;
        double d224 = (d222 + d221) * d16;
        dArr[i36] = d219 + d223;
        dArr[i28] = d220 + d224;
        dArr[i56] = d219 - d223;
        dArr[i48] = d220 - d224;
        double d225 = d88 + d158;
        double d226 = d89 - d157;
        double d227 = d125 - d190;
        double d228 = d126 + d189;
        double d229 = (d227 - d228) * d16;
        double d230 = d16 * (d228 + d227);
        dArr[i69] = d225 - d230;
        dArr[i67] = d226 + d229;
        dArr[i87] = d225 + d230;
        dArr[i85] = d226 - d229;
    }

    private void cftf1st(int i3, double[] dArr, double[] dArr2, int i16) {
        int i17 = i3 >> 3;
        int i18 = i17 * 2;
        int i19 = i18 + i18;
        int i26 = i19 + i18;
        int i27 = 0;
        double d16 = dArr[0];
        double d17 = dArr[i19];
        double d18 = d16 + d17;
        double d19 = dArr[1];
        int i28 = i19 + 1;
        double d26 = dArr[i28];
        double d27 = d19 + d26;
        double d28 = d16 - d17;
        double d29 = d19 - d26;
        double d36 = dArr[i18];
        double d37 = dArr[i26];
        double d38 = d36 + d37;
        int i29 = i18 + 1;
        double d39 = dArr[i29];
        int i36 = i26 + 1;
        double d46 = dArr[i36];
        double d47 = d39 + d46;
        double d48 = d36 - d37;
        double d49 = d39 - d46;
        dArr[0] = d18 + d38;
        dArr[1] = d27 + d47;
        dArr[i18] = d18 - d38;
        dArr[i29] = d27 - d47;
        dArr[i19] = d28 - d49;
        dArr[i28] = d29 + d48;
        dArr[i26] = d28 + d49;
        dArr[i36] = d29 - d48;
        double d56 = dArr2[i16 + 1];
        double d57 = dArr2[i16 + 2];
        double d58 = dArr2[i16 + 3];
        int i37 = 2;
        double d59 = 1.0d;
        double d65 = 0.0d;
        double d66 = 0.0d;
        double d67 = 1.0d;
        while (true) {
            double d68 = d56;
            int i38 = i17 - 2;
            if (i37 < i38) {
                i27 += 4;
                int i39 = i16 + i27;
                double d69 = dArr2[i39];
                double d75 = (d59 + d69) * d57;
                double d76 = dArr2[i39 + 1];
                double d77 = (d65 + d76) * d57;
                double d78 = dArr2[i39 + 2];
                double d79 = (d67 + d78) * d58;
                double d85 = dArr2[i39 + 3];
                double d86 = (d66 - d85) * d58;
                double d87 = -d85;
                int i46 = i37 + i18;
                int i47 = i46 + i18;
                int i48 = i47 + i18;
                double d88 = dArr[i37];
                double d89 = dArr[i47];
                double d95 = d88 + d89;
                int i49 = i37 + 1;
                double d96 = dArr[i49];
                int i56 = i47 + 1;
                double d97 = dArr[i56];
                double d98 = d96 + d97;
                double d99 = d88 - d89;
                double d100 = d96 - d97;
                int i57 = i37 + 2;
                double d101 = dArr[i57];
                int i58 = i47 + 2;
                double d102 = dArr[i58];
                double d103 = d101 + d102;
                int i59 = i37 + 3;
                double d104 = dArr[i59];
                int i65 = i47 + 3;
                double d105 = dArr[i65];
                double d106 = d104 + d105;
                double d107 = d101 - d102;
                double d108 = d104 - d105;
                double d109 = dArr[i46];
                double d110 = dArr[i48];
                double d111 = d109 + d110;
                int i66 = i46 + 1;
                double d112 = dArr[i66];
                int i67 = i48 + 1;
                double d113 = dArr[i67];
                double d114 = d112 + d113;
                double d115 = d109 - d110;
                double d116 = d112 - d113;
                int i68 = i46 + 2;
                double d117 = dArr[i68];
                int i69 = i48 + 2;
                double d118 = dArr[i69];
                double d119 = d117 + d118;
                int i75 = i46 + 3;
                double d120 = dArr[i75];
                int i76 = i48 + 3;
                double d121 = dArr[i76];
                double d122 = d120 + d121;
                double d123 = d117 - d118;
                double d124 = d120 - d121;
                dArr[i37] = d95 + d111;
                dArr[i49] = d98 + d114;
                dArr[i57] = d103 + d119;
                dArr[i59] = d106 + d122;
                dArr[i46] = d95 - d111;
                dArr[i66] = d98 - d114;
                dArr[i68] = d103 - d119;
                dArr[i75] = d106 - d122;
                double d125 = d99 - d116;
                double d126 = d100 + d115;
                dArr[i47] = (d75 * d125) - (d77 * d126);
                dArr[i56] = (d126 * d75) + (d125 * d77);
                double d127 = d107 - d124;
                double d128 = d108 + d123;
                dArr[i58] = (d69 * d127) - (d76 * d128);
                dArr[i65] = (d128 * d69) + (d127 * d76);
                double d129 = d99 + d116;
                double d130 = d100 - d115;
                dArr[i48] = (d79 * d129) + (d86 * d130);
                dArr[i67] = (d130 * d79) - (d129 * d86);
                double d131 = d107 + d124;
                double d132 = d108 - d123;
                dArr[i69] = (d78 * d131) + (d87 * d132);
                dArr[i76] = (d132 * d78) - (d131 * d87);
                int i77 = i18 - i37;
                int i78 = i77 + i18;
                int i79 = i78 + i18;
                int i85 = i79 + i18;
                double d133 = dArr[i77];
                double d134 = dArr[i79];
                double d135 = d133 + d134;
                int i86 = i77 + 1;
                double d136 = dArr[i86];
                int i87 = i79 + 1;
                double d137 = dArr[i87];
                double d138 = d136 + d137;
                double d139 = d133 - d134;
                double d140 = d136 - d137;
                int i88 = i77 - 2;
                double d141 = dArr[i88];
                int i89 = i79 - 2;
                double d142 = dArr[i89];
                double d143 = d141 + d142;
                int i95 = i77 - 1;
                double d144 = dArr[i95];
                int i96 = i79 - 1;
                double d145 = dArr[i96];
                double d146 = d144 + d145;
                double d147 = d141 - d142;
                double d148 = d144 - d145;
                double d149 = dArr[i78];
                double d150 = dArr[i85];
                double d151 = d149 + d150;
                int i97 = i78 + 1;
                double d152 = dArr[i97];
                int i98 = i85 + 1;
                double d153 = dArr[i98];
                double d154 = d152 + d153;
                double d155 = d149 - d150;
                double d156 = d152 - d153;
                int i99 = i78 - 2;
                double d157 = dArr[i99];
                int i100 = i85 - 2;
                double d158 = dArr[i100];
                double d159 = d157 + d158;
                int i101 = i78 - 1;
                double d160 = dArr[i101];
                int i102 = i85 - 1;
                double d161 = dArr[i102];
                double d162 = d160 + d161;
                double d163 = d157 - d158;
                double d164 = d160 - d161;
                dArr[i77] = d135 + d151;
                dArr[i86] = d138 + d154;
                dArr[i88] = d143 + d159;
                dArr[i95] = d146 + d162;
                dArr[i78] = d135 - d151;
                dArr[i97] = d138 - d154;
                dArr[i99] = d143 - d159;
                dArr[i101] = d146 - d162;
                double d165 = d139 - d156;
                double d166 = d140 + d155;
                dArr[i79] = (d77 * d165) - (d75 * d166);
                dArr[i87] = (d77 * d166) + (d75 * d165);
                double d167 = d147 - d164;
                double d168 = d148 + d163;
                dArr[i89] = (d76 * d167) - (d69 * d168);
                dArr[i96] = (d168 * d76) + (d167 * d69);
                double d169 = d139 + d156;
                double d170 = d140 - d155;
                dArr[i85] = (d86 * d169) + (d79 * d170);
                dArr[i98] = (d86 * d170) - (d79 * d169);
                double d171 = d147 + d164;
                double d172 = d148 - d163;
                dArr[i100] = (d87 * d171) + (d78 * d172);
                dArr[i102] = (d172 * d87) - (d171 * d78);
                i37 += 4;
                d66 = d87;
                d56 = d68;
                d59 = d69;
                d65 = d76;
                d67 = d78;
            } else {
                double d173 = (d59 + d68) * d57;
                double d174 = d57 * (d65 + d68);
                double d175 = (d67 - d68) * d58;
                double d176 = d58 * (d66 - d68);
                int i103 = i17 + i18;
                int i104 = i103 + i18;
                int i105 = i18 + i104;
                double d177 = dArr[i38];
                int i106 = i104 - 2;
                double d178 = dArr[i106];
                double d179 = d177 + d178;
                int i107 = i17 - 1;
                double d180 = dArr[i107];
                int i108 = i104 - 1;
                double d181 = dArr[i108];
                double d182 = d180 + d181;
                double d183 = d177 - d178;
                double d184 = d180 - d181;
                int i109 = i103 - 2;
                double d185 = dArr[i109];
                int i110 = i105 - 2;
                double d186 = dArr[i110];
                double d187 = d185 + d186;
                int i111 = i103 - 1;
                double d188 = dArr[i111];
                int i112 = i105 - 1;
                double d189 = dArr[i112];
                double d190 = d188 + d189;
                double d191 = d185 - d186;
                double d192 = d188 - d189;
                dArr[i38] = d179 + d187;
                dArr[i107] = d182 + d190;
                dArr[i109] = d179 - d187;
                dArr[i111] = d182 - d190;
                double d193 = d183 - d192;
                double d194 = d184 + d191;
                dArr[i106] = (d173 * d193) - (d174 * d194);
                dArr[i108] = (d194 * d173) + (d193 * d174);
                double d195 = d183 + d192;
                double d196 = d184 - d191;
                dArr[i110] = (d175 * d195) + (d176 * d196);
                dArr[i112] = (d196 * d175) - (d195 * d176);
                double d197 = dArr[i17];
                double d198 = dArr[i104];
                double d199 = d197 + d198;
                int i113 = i17 + 1;
                double d200 = dArr[i113];
                int i114 = i104 + 1;
                double d201 = dArr[i114];
                double d202 = d200 + d201;
                double d203 = d197 - d198;
                double d204 = d200 - d201;
                double d205 = dArr[i103];
                double d206 = dArr[i105];
                double d207 = d205 + d206;
                int i115 = i103 + 1;
                double d208 = dArr[i115];
                int i116 = i105 + 1;
                double d209 = dArr[i116];
                double d210 = d208 + d209;
                double d211 = d205 - d206;
                double d212 = d208 - d209;
                dArr[i17] = d199 + d207;
                dArr[i113] = d202 + d210;
                dArr[i103] = d199 - d207;
                dArr[i115] = d202 - d210;
                double d213 = d203 - d212;
                double d214 = d204 + d211;
                dArr[i104] = (d213 - d214) * d68;
                dArr[i114] = d68 * (d214 + d213);
                double d215 = d203 + d212;
                double d216 = d204 - d211;
                double d217 = -d68;
                dArr[i105] = (d215 + d216) * d217;
                dArr[i116] = d217 * (d216 - d215);
                int i117 = i17 + 2;
                double d218 = dArr[i117];
                int i118 = i104 + 2;
                double d219 = dArr[i118];
                double d220 = d218 + d219;
                int i119 = i17 + 3;
                double d221 = dArr[i119];
                int i120 = i104 + 3;
                double d222 = dArr[i120];
                double d223 = d221 + d222;
                double d224 = d218 - d219;
                double d225 = d221 - d222;
                int i121 = i103 + 2;
                double d226 = dArr[i121];
                int i122 = i105 + 2;
                double d227 = dArr[i122];
                double d228 = d226 + d227;
                int i123 = i103 + 3;
                double d229 = dArr[i123];
                int i124 = i105 + 3;
                double d230 = dArr[i124];
                double d231 = d229 + d230;
                double d232 = d226 - d227;
                double d233 = d229 - d230;
                dArr[i117] = d220 + d228;
                dArr[i119] = d223 + d231;
                dArr[i121] = d220 - d228;
                dArr[i123] = d223 - d231;
                double d234 = d224 - d233;
                double d235 = d225 + d232;
                dArr[i118] = (d174 * d234) - (d173 * d235);
                dArr[i120] = (d174 * d235) + (d173 * d234);
                double d236 = d224 + d233;
                double d237 = d225 - d232;
                dArr[i122] = (d176 * d236) + (d175 * d237);
                dArr[i124] = (d176 * d237) - (d236 * d175);
                return;
            }
        }
    }

    private void cftfsub(int i3, double[] dArr, int[] iArr, int i16, int i17, double[] dArr2) {
        if (i3 > 32) {
            int i18 = i3 >> 2;
            cftf1st(i3, dArr, dArr2, i17 - i18);
            if (i3 > 512) {
                cftrec1(i18, dArr, 0, i17, dArr2);
                cftrec2(i18, dArr, i18, i17, dArr2);
                cftrec1(i18, dArr, i18 * 2, i17, dArr2);
                cftrec1(i18, dArr, i18 * 3, i17, dArr2);
            } else if (i18 > 32) {
                cftexp1(i3, dArr, 0, i17, dArr2);
            } else {
                cftfx41(i3, dArr, 0, i17, dArr2);
            }
            bitrv2(i3, iArr, i16, dArr);
            return;
        }
        if (i3 > 8) {
            if (i3 == 32) {
                cftf161(dArr, 0, dArr2, i17 - 8);
                bitrv216(dArr);
                return;
            } else {
                cftf081(dArr, 0, dArr2, 0);
                bitrv208(dArr);
                return;
            }
        }
        if (i3 == 8) {
            cftf040(dArr);
        } else if (i3 == 4) {
            cftx020(dArr);
        }
    }

    private void cftfx41(int i3, double[] dArr, int i16, int i17, double[] dArr2) {
        if (i3 == 128) {
            int i18 = i17 - 8;
            cftf161(dArr, i16, dArr2, i18);
            cftf162(dArr, i16 + 32, dArr2, i17 - 32);
            cftf161(dArr, i16 + 64, dArr2, i18);
            cftf161(dArr, i16 + 96, dArr2, i18);
            return;
        }
        int i19 = i17 - 16;
        cftf081(dArr, i16, dArr2, i19);
        cftf082(dArr, i16 + 16, dArr2, i19);
        cftf081(dArr, i16 + 32, dArr2, i19);
        cftf081(dArr, i16 + 48, dArr2, i19);
    }

    private void cftfx42(int i3, double[] dArr, int i16, int i17, double[] dArr2) {
        if (i3 == 128) {
            int i18 = i17 - 8;
            cftf161(dArr, i16, dArr2, i18);
            int i19 = i17 - 32;
            cftf162(dArr, i16 + 32, dArr2, i19);
            cftf161(dArr, i16 + 64, dArr2, i18);
            cftf162(dArr, i16 + 96, dArr2, i19);
            return;
        }
        int i26 = i17 - 16;
        cftf081(dArr, i16, dArr2, i26);
        cftf082(dArr, i16 + 16, dArr2, i26);
        cftf081(dArr, i16 + 32, dArr2, i26);
        cftf082(dArr, i16 + 48, dArr2, i26);
    }

    private final void cftmdl1(int i3, double[] dArr, int i16, double[] dArr2, int i17) {
        int i18 = i3 >> 3;
        int i19 = i18 * 2;
        int i26 = i19 + i19;
        int i27 = i26 + i19;
        int i28 = i16 + 0;
        double d16 = dArr[i28];
        int i29 = i16 + i26;
        double d17 = dArr[i29];
        double d18 = d16 + d17;
        int i36 = i16 + 1;
        double d19 = dArr[i36];
        int i37 = i29 + 1;
        double d26 = dArr[i37];
        double d27 = d19 + d26;
        double d28 = d16 - d17;
        double d29 = d19 - d26;
        int i38 = i16 + i19;
        double d36 = dArr[i38];
        int i39 = i16 + i27;
        double d37 = dArr[i39];
        double d38 = d36 + d37;
        int i46 = i38 + 1;
        double d39 = dArr[i46];
        int i47 = i39 + 1;
        double d46 = dArr[i47];
        double d47 = d39 + d46;
        double d48 = d36 - d37;
        double d49 = d39 - d46;
        dArr[i28] = d18 + d38;
        dArr[i36] = d27 + d47;
        dArr[i38] = d18 - d38;
        dArr[i46] = d27 - d47;
        dArr[i29] = d28 - d49;
        dArr[i37] = d29 + d48;
        dArr[i39] = d28 + d49;
        dArr[i47] = d29 - d48;
        double d56 = dArr2[i17 + 1];
        int i48 = 0;
        for (int i49 = 2; i49 < i18; i49 += 2) {
            i48 += 4;
            int i56 = i17 + i48;
            double d57 = dArr2[i56];
            double d58 = dArr2[i56 + 1];
            double d59 = dArr2[i56 + 2];
            double d65 = -dArr2[i56 + 3];
            int i57 = i49 + i19;
            int i58 = i57 + i19;
            int i59 = i58 + i19;
            int i65 = i16 + i49;
            double d66 = dArr[i65];
            int i66 = i16 + i58;
            double d67 = dArr[i66];
            double d68 = d66 + d67;
            int i67 = i65 + 1;
            double d69 = dArr[i67];
            int i68 = i66 + 1;
            double d75 = dArr[i68];
            double d76 = d69 + d75;
            double d77 = d66 - d67;
            double d78 = d69 - d75;
            int i69 = i16 + i57;
            double d79 = dArr[i69];
            int i75 = i16 + i59;
            double d85 = dArr[i75];
            double d86 = d79 + d85;
            int i76 = i69 + 1;
            double d87 = dArr[i76];
            int i77 = i75 + 1;
            double d88 = dArr[i77];
            double d89 = d87 + d88;
            double d95 = d79 - d85;
            double d96 = d87 - d88;
            dArr[i65] = d68 + d86;
            dArr[i67] = d76 + d89;
            dArr[i69] = d68 - d86;
            dArr[i76] = d76 - d89;
            double d97 = d77 - d96;
            double d98 = d78 + d95;
            dArr[i66] = (d57 * d97) - (d58 * d98);
            dArr[i68] = (d98 * d57) + (d97 * d58);
            double d99 = d77 + d96;
            double d100 = d78 - d95;
            dArr[i75] = (d59 * d99) + (d65 * d100);
            dArr[i77] = (d100 * d59) - (d99 * d65);
            int i78 = i19 - i49;
            int i79 = i78 + i19;
            int i85 = i79 + i19;
            int i86 = i85 + i19;
            int i87 = i16 + i78;
            double d101 = dArr[i87];
            int i88 = i16 + i85;
            double d102 = dArr[i88];
            double d103 = d101 + d102;
            int i89 = i87 + 1;
            double d104 = dArr[i89];
            int i95 = i88 + 1;
            double d105 = dArr[i95];
            double d106 = d104 + d105;
            double d107 = d101 - d102;
            double d108 = d104 - d105;
            int i96 = i16 + i79;
            double d109 = dArr[i96];
            int i97 = i16 + i86;
            double d110 = dArr[i97];
            double d111 = d109 + d110;
            int i98 = i96 + 1;
            double d112 = dArr[i98];
            int i99 = i97 + 1;
            double d113 = dArr[i99];
            double d114 = d112 + d113;
            double d115 = d109 - d110;
            double d116 = d112 - d113;
            dArr[i87] = d103 + d111;
            dArr[i89] = d106 + d114;
            dArr[i96] = d103 - d111;
            dArr[i98] = d106 - d114;
            double d117 = d107 - d116;
            double d118 = d108 + d115;
            dArr[i88] = (d58 * d117) - (d57 * d118);
            dArr[i95] = (d58 * d118) + (d57 * d117);
            double d119 = d107 + d116;
            double d120 = d108 - d115;
            dArr[i97] = (d65 * d119) + (d59 * d120);
            dArr[i99] = (d65 * d120) - (d59 * d119);
        }
        int i100 = i18 + i19;
        int i101 = i100 + i19;
        int i102 = i19 + i101;
        int i103 = i16 + i18;
        double d121 = dArr[i103];
        int i104 = i16 + i101;
        double d122 = dArr[i104];
        double d123 = d121 + d122;
        int i105 = i103 + 1;
        double d124 = dArr[i105];
        int i106 = i104 + 1;
        double d125 = dArr[i106];
        double d126 = d124 + d125;
        double d127 = d121 - d122;
        double d128 = d124 - d125;
        int i107 = i16 + i100;
        double d129 = dArr[i107];
        int i108 = i16 + i102;
        double d130 = dArr[i108];
        double d131 = d129 + d130;
        int i109 = i107 + 1;
        double d132 = dArr[i109];
        int i110 = i108 + 1;
        double d133 = dArr[i110];
        double d134 = d132 + d133;
        double d135 = d129 - d130;
        double d136 = d132 - d133;
        dArr[i103] = d123 + d131;
        dArr[i105] = d126 + d134;
        dArr[i107] = d123 - d131;
        dArr[i109] = d126 - d134;
        double d137 = d127 - d136;
        double d138 = d128 + d135;
        dArr[i104] = (d137 - d138) * d56;
        dArr[i106] = (d138 + d137) * d56;
        double d139 = d127 + d136;
        double d140 = d128 - d135;
        double d141 = -d56;
        dArr[i108] = (d139 + d140) * d141;
        dArr[i110] = d141 * (d140 - d139);
    }

    private final void cftmdl2(int i3, double[] dArr, int i16, double[] dArr2, int i17) {
        int i18 = i3 >> 3;
        int i19 = i18 * 2;
        double d16 = dArr2[i17 + 1];
        int i26 = i19 + i19;
        int i27 = i26 + i19;
        int i28 = i16 + 0;
        double d17 = dArr[i28];
        int i29 = i16 + i26;
        int i36 = i29 + 1;
        double d18 = dArr[i36];
        double d19 = d17 - d18;
        int i37 = i16 + 1;
        double d26 = dArr[i37];
        double d27 = dArr[i29];
        double d28 = d26 + d27;
        double d29 = d17 + d18;
        double d36 = d26 - d27;
        int i38 = i16 + i19;
        double d37 = dArr[i38];
        int i39 = i16 + i27;
        int i46 = i39 + 1;
        double d38 = dArr[i46];
        double d39 = d37 - d38;
        int i47 = i38 + 1;
        double d46 = dArr[i47];
        double d47 = dArr[i39];
        double d48 = d46 + d47;
        double d49 = d37 + d38;
        double d56 = d46 - d47;
        double d57 = (d39 - d48) * d16;
        double d58 = (d48 + d39) * d16;
        dArr[i28] = d19 + d57;
        dArr[i37] = d28 + d58;
        dArr[i38] = d19 - d57;
        dArr[i47] = d28 - d58;
        double d59 = (d49 - d56) * d16;
        double d65 = d16 * (d56 + d49);
        dArr[i29] = d29 - d65;
        dArr[i36] = d36 + d59;
        dArr[i39] = d29 + d65;
        dArr[i46] = d36 - d59;
        int i48 = i19 * 2;
        int i49 = 2;
        int i56 = 0;
        while (i49 < i18) {
            int i57 = i56 + 4;
            int i58 = i17 + i57;
            double d66 = dArr2[i58];
            double d67 = dArr2[i58 + 1];
            double d68 = dArr2[i58 + 2];
            double d69 = -dArr2[i58 + 3];
            i48 -= 4;
            int i59 = i17 + i48;
            double d75 = dArr2[i59];
            double d76 = dArr2[i59 + 1];
            double d77 = dArr2[i59 + 2];
            double d78 = -dArr2[i59 + 3];
            int i65 = i49 + i19;
            int i66 = i65 + i19;
            int i67 = i66 + i19;
            int i68 = i16 + i49;
            double d79 = dArr[i68];
            int i69 = i16 + i66;
            int i75 = i69 + 1;
            double d85 = dArr[i75];
            double d86 = d79 - d85;
            int i76 = i68 + 1;
            double d87 = dArr[i76];
            double d88 = dArr[i69];
            double d89 = d87 + d88;
            double d95 = d79 + d85;
            double d96 = d87 - d88;
            int i77 = i16 + i65;
            double d97 = dArr[i77];
            int i78 = i16 + i67;
            int i79 = i78 + 1;
            double d98 = dArr[i79];
            double d99 = d97 - d98;
            int i85 = i77 + 1;
            double d100 = dArr[i85];
            double d101 = dArr[i78];
            double d102 = d100 + d101;
            double d103 = d97 + d98;
            double d104 = d100 - d101;
            double d105 = (d66 * d86) - (d67 * d89);
            double d106 = (d89 * d66) + (d86 * d67);
            double d107 = (d76 * d99) - (d75 * d102);
            double d108 = (d102 * d76) + (d99 * d75);
            dArr[i68] = d105 + d107;
            dArr[i76] = d106 + d108;
            dArr[i77] = d105 - d107;
            dArr[i85] = d106 - d108;
            double d109 = (d68 * d95) + (d69 * d96);
            double d110 = (d96 * d68) - (d95 * d69);
            double d111 = (d78 * d103) + (d77 * d104);
            double d112 = (d104 * d78) - (d103 * d77);
            dArr[i69] = d109 + d111;
            dArr[i75] = d110 + d112;
            dArr[i78] = d109 - d111;
            dArr[i79] = d110 - d112;
            int i86 = i19 - i49;
            int i87 = i86 + i19;
            int i88 = i87 + i19;
            int i89 = i88 + i19;
            int i95 = i16 + i86;
            double d113 = dArr[i95];
            int i96 = i16 + i88;
            int i97 = i96 + 1;
            double d114 = dArr[i97];
            double d115 = d113 - d114;
            int i98 = i95 + 1;
            double d116 = dArr[i98];
            double d117 = dArr[i96];
            double d118 = d116 + d117;
            double d119 = d113 + d114;
            double d120 = d116 - d117;
            int i99 = i16 + i87;
            double d121 = dArr[i99];
            int i100 = i16 + i89;
            int i101 = i100 + 1;
            double d122 = dArr[i101];
            double d123 = d121 - d122;
            int i102 = i99 + 1;
            double d124 = dArr[i102];
            double d125 = dArr[i100];
            double d126 = d124 + d125;
            double d127 = d121 + d122;
            double d128 = d124 - d125;
            double d129 = (d75 * d115) - (d76 * d118);
            double d130 = (d75 * d118) + (d76 * d115);
            double d131 = (d67 * d123) - (d66 * d126);
            double d132 = (d67 * d126) + (d66 * d123);
            dArr[i95] = d129 + d131;
            dArr[i98] = d130 + d132;
            dArr[i99] = d129 - d131;
            dArr[i102] = d130 - d132;
            double d133 = (d77 * d119) + (d78 * d120);
            double d134 = (d77 * d120) - (d78 * d119);
            double d135 = (d69 * d127) + (d68 * d128);
            double d136 = (d69 * d128) - (d68 * d127);
            dArr[i96] = d133 + d135;
            dArr[i97] = d134 + d136;
            dArr[i100] = d133 - d135;
            dArr[i101] = d134 - d136;
            i49 += 2;
            i56 = i57;
        }
        int i103 = i17 + i19;
        double d137 = dArr2[i103];
        double d138 = dArr2[i103 + 1];
        int i104 = i18 + i19;
        int i105 = i104 + i19;
        int i106 = i19 + i105;
        int i107 = i16 + i18;
        double d139 = dArr[i107];
        int i108 = i16 + i105;
        int i109 = i108 + 1;
        double d140 = dArr[i109];
        double d141 = d139 - d140;
        int i110 = i107 + 1;
        double d142 = dArr[i110];
        double d143 = dArr[i108];
        double d144 = d142 + d143;
        double d145 = d139 + d140;
        double d146 = d142 - d143;
        int i111 = i16 + i104;
        double d147 = dArr[i111];
        int i112 = i16 + i106;
        int i113 = i112 + 1;
        double d148 = dArr[i113];
        double d149 = d147 - d148;
        int i114 = i111 + 1;
        double d150 = dArr[i114];
        double d151 = dArr[i112];
        double d152 = d150 + d151;
        double d153 = d147 + d148;
        double d154 = d150 - d151;
        double d155 = (d137 * d141) - (d138 * d144);
        double d156 = (d144 * d137) + (d141 * d138);
        double d157 = (d138 * d149) - (d137 * d152);
        double d158 = (d152 * d138) + (d149 * d137);
        dArr[i107] = d155 + d157;
        dArr[i110] = d156 + d158;
        dArr[i111] = d155 - d157;
        dArr[i114] = d156 - d158;
        double d159 = (d138 * d145) - (d137 * d146);
        double d160 = (d146 * d138) + (d145 * d137);
        double d161 = (d137 * d153) - (d138 * d154);
        double d162 = (d137 * d154) + (d138 * d153);
        dArr[i108] = d159 - d161;
        dArr[i109] = d160 - d162;
        dArr[i112] = d159 + d161;
        dArr[i113] = d160 + d162;
    }

    private void cftrec1(int i3, double[] dArr, int i16, int i17, double[] dArr2) {
        int i18 = i3 >> 2;
        int i19 = i18 * 2;
        cftmdl1(i3, dArr, i16, dArr2, i17 - i19);
        if (i3 > 512) {
            cftrec1(i18, dArr, i16, i17, dArr2);
            cftrec2(i18, dArr, i16 + i18, i17, dArr2);
            cftrec1(i18, dArr, i16 + i19, i17, dArr2);
            cftrec1(i18, dArr, i16 + (i18 * 3), i17, dArr2);
            return;
        }
        cftexp1(i3, dArr, i16, i17, dArr2);
    }

    private void cftrec2(int i3, double[] dArr, int i16, int i17, double[] dArr2) {
        int i18 = i3 >> 2;
        cftmdl2(i3, dArr, i16, dArr2, i17 - i3);
        if (i3 > 512) {
            cftrec1(i18, dArr, i16, i17, dArr2);
            cftrec2(i18, dArr, i16 + i18, i17, dArr2);
            cftrec1(i18, dArr, i16 + (i18 * 2), i17, dArr2);
            cftrec2(i18, dArr, i16 + (i18 * 3), i17, dArr2);
            return;
        }
        cftexp2(i3, dArr, i16, i17, dArr2);
    }

    private void cftx020(double[] dArr) {
        double d16 = dArr[0];
        double d17 = dArr[2];
        double d18 = dArr[1];
        double d19 = dArr[3];
        dArr[0] = d16 + d17;
        dArr[1] = d18 + d19;
        dArr[2] = d16 - d17;
        dArr[3] = d18 - d19;
    }

    private void dctsub(int i3, double[] dArr, int i16, double[] dArr2, int i17) {
        int i18 = i3 >> 1;
        int i19 = i16 / i3;
        int i26 = 0;
        for (int i27 = 1; i27 < i18; i27++) {
            int i28 = i3 - i27;
            i26 += i19;
            double d16 = dArr2[i17 + i26];
            double d17 = dArr2[(i17 + i16) - i26];
            double d18 = d16 - d17;
            double d19 = d16 + d17;
            double d26 = dArr[i27];
            double d27 = dArr[i28];
            dArr[i27] = (d18 * d26) + (d19 * d27);
            dArr[i28] = (d19 * d26) - (d18 * d27);
        }
        dArr[i18] = dArr[i18] * dArr2[i17 + 0];
    }

    private void dstsub(int i3, double[] dArr, int i16, double[] dArr2, int i17) {
        int i18 = i3 >> 1;
        int i19 = i16 / i3;
        int i26 = 0;
        for (int i27 = 1; i27 < i18; i27++) {
            int i28 = i3 - i27;
            i26 += i19;
            double d16 = dArr2[i17 + i26];
            double d17 = dArr2[(i17 + i16) - i26];
            double d18 = d16 - d17;
            double d19 = d16 + d17;
            double d26 = dArr[i28];
            double d27 = dArr[i27];
            dArr[i28] = (d18 * d26) + (d19 * d27);
            dArr[i27] = (d19 * d26) - (d18 * d27);
        }
        dArr[i18] = dArr[i18] * dArr2[i17 + 0];
    }

    private void makect(int i3, int[] iArr, double[] dArr, int i16) {
        iArr[1] = i3;
        if (i3 > 1) {
            int i17 = i3 >> 1;
            double d16 = i17;
            double d17 = 0.7853981633974483d / d16;
            double cos = Math.cos(d16 * d17);
            dArr[i16 + 0] = cos;
            dArr[i16 + i17] = cos * 0.5d;
            for (int i18 = 1; i18 < i17; i18++) {
                double d18 = i18 * d17;
                dArr[i16 + i18] = Math.cos(d18) * 0.5d;
                dArr[(i16 + i3) - i18] = Math.sin(d18) * 0.5d;
            }
        }
    }

    private void makewt(int i3, int[] iArr, double[] dArr) {
        int i16 = 0;
        iArr[0] = i3;
        iArr[1] = 1;
        if (i3 > 2) {
            int i17 = i3 >> 1;
            double d16 = i17;
            double d17 = 0.7853981633974483d / d16;
            double cos = Math.cos(d16 * d17);
            dArr[0] = 1.0d;
            dArr[1] = cos;
            if (i17 >= 4) {
                dArr[2] = 0.5d / Math.cos(2.0d * d17);
                dArr[3] = 0.5d / Math.cos(6.0d * d17);
            }
            for (int i18 = 4; i18 < i17; i18 += 4) {
                double d18 = i18;
                double d19 = d17 * d18;
                dArr[i18] = Math.cos(d19);
                dArr[i18 + 1] = Math.sin(d19);
                double d26 = 3.0d * d17 * d18;
                dArr[i18 + 2] = Math.cos(d26);
                dArr[i18 + 3] = Math.sin(d26);
            }
            while (i17 > 2) {
                int i19 = i16 + i17;
                i17 >>= 1;
                dArr[i19] = 1.0d;
                dArr[i19 + 1] = cos;
                if (i17 >= 4) {
                    double d27 = dArr[i16 + 4];
                    double d28 = dArr[i16 + 6];
                    dArr[i19 + 2] = 0.5d / d27;
                    dArr[i19 + 3] = 0.5d / d28;
                }
                for (int i26 = 4; i26 < i17; i26 += 4) {
                    int i27 = (i26 * 2) + i16;
                    double d29 = dArr[i27];
                    double d36 = dArr[i27 + 1];
                    double d37 = dArr[i27 + 2];
                    double d38 = dArr[i27 + 3];
                    int i28 = i19 + i26;
                    dArr[i28] = d29;
                    dArr[i28 + 1] = d36;
                    dArr[i28 + 2] = d37;
                    dArr[i28 + 3] = d38;
                }
                i16 = i19;
            }
        }
    }

    private void rftbsub(int i3, double[] dArr, int i16, double[] dArr2, int i17) {
        int i18 = i3 >> 1;
        int i19 = (i16 * 2) / i18;
        int i26 = 0;
        for (int i27 = 2; i27 < i18; i27 += 2) {
            int i28 = i3 - i27;
            i26 += i19;
            double d16 = 0.5d - dArr2[(i17 + i16) - i26];
            double d17 = dArr2[i17 + i26];
            double d18 = dArr[i27];
            double d19 = d18 - dArr[i28];
            int i29 = i27 + 1;
            int i36 = i28 + 1;
            double d26 = dArr[i29] + dArr[i36];
            double d27 = (d16 * d19) + (d17 * d26);
            double d28 = (d16 * d26) - (d17 * d19);
            dArr[i27] = d18 - d27;
            dArr[i29] = dArr[i29] - d28;
            dArr[i28] = dArr[i28] + d27;
            dArr[i36] = dArr[i36] - d28;
        }
    }

    private void rftfsub(int i3, double[] dArr, int i16, double[] dArr2, int i17) {
        int i18 = i3 >> 1;
        int i19 = (i16 * 2) / i18;
        int i26 = 0;
        for (int i27 = 2; i27 < i18; i27 += 2) {
            int i28 = i3 - i27;
            i26 += i19;
            double d16 = 0.5d - dArr2[(i17 + i16) - i26];
            double d17 = dArr2[i17 + i26];
            double d18 = dArr[i27];
            double d19 = d18 - dArr[i28];
            int i29 = i27 + 1;
            int i36 = i28 + 1;
            double d26 = dArr[i29] + dArr[i36];
            double d27 = (d16 * d19) - (d17 * d26);
            double d28 = (d16 * d26) + (d17 * d19);
            dArr[i27] = d18 - d27;
            dArr[i29] = dArr[i29] - d28;
            dArr[i28] = dArr[i28] + d27;
            dArr[i36] = dArr[i36] - d28;
        }
    }

    public void cdft(int i3, int i16, double[] dArr, int[] iArr, double[] dArr2) {
        int i17 = iArr[0];
        if (i3 > (i17 << 2)) {
            i17 = i3 >> 2;
            makewt(i17, iArr, dArr2);
        }
        int i18 = i17;
        if (i16 >= 0) {
            cftfsub(i3, dArr, iArr, 2, i18, dArr2);
        } else {
            cftbsub(i3, dArr, iArr, 2, i18, dArr2);
        }
    }

    public void ddct(int i3, int i16, double[] dArr, int[] iArr, double[] dArr2) {
        int i17;
        int i18;
        int i19 = iArr[0];
        if (i3 > (i19 << 2)) {
            i19 = i3 >> 2;
            makewt(i19, iArr, dArr2);
        }
        int i26 = i19;
        int i27 = iArr[1];
        if (i3 > i27) {
            makect(i3, iArr, dArr2, i26);
            i17 = i3;
        } else {
            i17 = i27;
        }
        if (i16 < 0) {
            double d16 = dArr[i3 - 1];
            for (int i28 = i3 - 2; i28 >= 2; i28 -= 2) {
                int i29 = i28 - 1;
                dArr[i28 + 1] = dArr[i28] - dArr[i29];
                dArr[i28] = dArr[i28] + dArr[i29];
            }
            double d17 = dArr[0];
            dArr[1] = d17 - d16;
            dArr[0] = d17 + d16;
            if (i3 > 4) {
                rftbsub(i3, dArr, i17, dArr2, i26);
                i18 = 2;
                cftbsub(i3, dArr, iArr, 2, i26, dArr2);
            } else {
                i18 = 2;
                if (i3 == 4) {
                    cftbsub(i3, dArr, iArr, 2, i26, dArr2);
                }
            }
        } else {
            i18 = 2;
        }
        dctsub(i3, dArr, i17, dArr2, i26);
        if (i16 >= 0) {
            if (i3 > 4) {
                cftfsub(i3, dArr, iArr, 2, i26, dArr2);
                rftfsub(i3, dArr, i17, dArr2, i26);
            } else if (i3 == 4) {
                cftfsub(i3, dArr, iArr, 2, i26, dArr2);
            }
            double d18 = dArr[0];
            double d19 = dArr[1];
            double d26 = d18 - d19;
            dArr[0] = d18 + d19;
            for (int i36 = i18; i36 < i3; i36 += 2) {
                int i37 = i36 + 1;
                dArr[i36 - 1] = dArr[i36] - dArr[i37];
                dArr[i36] = dArr[i36] + dArr[i37];
            }
            dArr[i3 - 1] = d26;
        }
    }

    public void ddst(int i3, int i16, double[] dArr, int[] iArr, double[] dArr2) {
        int i17;
        int i18;
        int i19 = iArr[0];
        if (i3 > (i19 << 2)) {
            i19 = i3 >> 2;
            makewt(i19, iArr, dArr2);
        }
        int i26 = i19;
        int i27 = iArr[1];
        if (i3 > i27) {
            makect(i3, iArr, dArr2, i26);
            i17 = i3;
        } else {
            i17 = i27;
        }
        if (i16 < 0) {
            double d16 = dArr[i3 - 1];
            for (int i28 = i3 - 2; i28 >= 2; i28 -= 2) {
                int i29 = i28 - 1;
                dArr[i28 + 1] = (-dArr[i28]) - dArr[i29];
                dArr[i28] = dArr[i28] - dArr[i29];
            }
            double d17 = dArr[0];
            dArr[1] = d17 + d16;
            dArr[0] = d17 - d16;
            if (i3 > 4) {
                rftbsub(i3, dArr, i17, dArr2, i26);
                i18 = 2;
                cftbsub(i3, dArr, iArr, 2, i26, dArr2);
            } else {
                i18 = 2;
                if (i3 == 4) {
                    cftbsub(i3, dArr, iArr, 2, i26, dArr2);
                }
            }
        } else {
            i18 = 2;
        }
        dstsub(i3, dArr, i17, dArr2, i26);
        if (i16 >= 0) {
            if (i3 > 4) {
                cftfsub(i3, dArr, iArr, 2, i26, dArr2);
                rftfsub(i3, dArr, i17, dArr2, i26);
            } else if (i3 == 4) {
                cftfsub(i3, dArr, iArr, 2, i26, dArr2);
            }
            double d18 = dArr[0];
            double d19 = dArr[1];
            double d26 = d18 - d19;
            dArr[0] = d18 + d19;
            for (int i36 = i18; i36 < i3; i36 += 2) {
                int i37 = i36 + 1;
                dArr[i36 - 1] = (-dArr[i36]) - dArr[i37];
                dArr[i36] = dArr[i36] - dArr[i37];
            }
            dArr[i3 - 1] = -d26;
        }
    }

    public void dfct(int i3, double[] dArr, double[] dArr2, int[] iArr, double[] dArr3) {
        int i16;
        int i17;
        int i18 = iArr[0];
        if (i3 > (i18 << 3)) {
            i18 = i3 >> 3;
            makewt(i18, iArr, dArr3);
        }
        int i19 = i18;
        int i26 = iArr[1];
        if (i3 > (i26 << 1)) {
            i26 = i3 >> 1;
            makect(i26, iArr, dArr3, i19);
        }
        int i27 = i26;
        int i28 = i3 >> 1;
        double d16 = dArr[i28];
        double d17 = dArr[0];
        double d18 = dArr[i3];
        double d19 = d17 + d18;
        dArr[0] = d17 - d18;
        dArr2[0] = d19 - d16;
        dArr2[i28] = d19 + d16;
        if (i3 > 2) {
            int i29 = i28 >> 1;
            for (int i36 = 1; i36 < i29; i36++) {
                int i37 = i28 - i36;
                double d26 = dArr[i36];
                double d27 = dArr[i3 - i36];
                double d28 = d26 - d27;
                double d29 = d26 + d27;
                double d36 = dArr[i37];
                double d37 = dArr[i3 - i37];
                double d38 = d36 - d37;
                double d39 = d36 + d37;
                dArr[i36] = d28;
                dArr[i37] = d38;
                dArr2[i36] = d29 - d39;
                dArr2[i37] = d29 + d39;
            }
            int i38 = i3 - i29;
            dArr2[i29] = dArr[i29] + dArr[i38];
            dArr[i29] = dArr[i29] - dArr[i38];
            dctsub(i28, dArr, i27, dArr3, i19);
            if (i28 > 4) {
                i16 = 4;
                cftfsub(i28, dArr, iArr, 2, i19, dArr3);
                rftfsub(i28, dArr, i27, dArr3, i19);
            } else {
                i16 = 4;
                if (i28 == 4) {
                    cftfsub(i28, dArr, iArr, 2, i19, dArr3);
                }
            }
            dArr[i3 - 1] = dArr[0] - dArr[1];
            dArr[1] = dArr[0] + dArr[1];
            int i39 = 2;
            for (int i46 = i28 - 2; i46 >= 2; i46 -= 2) {
                int i47 = i46 * 2;
                int i48 = i46 + 1;
                dArr[i47 + 1] = dArr[i46] + dArr[i48];
                dArr[i47 - 1] = dArr[i46] - dArr[i48];
            }
            int i49 = i29;
            int i56 = 2;
            while (i49 >= i39) {
                dctsub(i49, dArr2, i27, dArr3, i19);
                if (i49 > i16) {
                    int i57 = i49;
                    i17 = i39;
                    cftfsub(i57, dArr2, iArr, 2, i19, dArr3);
                    rftfsub(i57, dArr2, i27, dArr3, i19);
                } else {
                    i17 = i39;
                    if (i49 == i16) {
                        cftfsub(i49, dArr2, iArr, 2, i19, dArr3);
                    }
                }
                dArr[i3 - i56] = dArr2[0] - dArr2[1];
                dArr[i56] = dArr2[0] + dArr2[1];
                int i58 = 0;
                for (int i59 = i17; i59 < i49; i59 += 2) {
                    i58 += i56 << 2;
                    int i65 = i59 + 1;
                    dArr[i58 - i56] = dArr2[i59] - dArr2[i65];
                    dArr[i58 + i56] = dArr2[i59] + dArr2[i65];
                }
                i56 <<= 1;
                int i66 = i49 >> 1;
                for (int i67 = 0; i67 < i66; i67++) {
                    int i68 = i49 - i67;
                    int i69 = i49 + i68;
                    int i75 = i49 + i67;
                    dArr2[i67] = dArr2[i69] - dArr2[i75];
                    dArr2[i68] = dArr2[i69] + dArr2[i75];
                }
                dArr2[i66] = dArr2[i49 + i66];
                i49 = i66;
                i39 = i17;
            }
            int i76 = i39;
            dArr[i56] = dArr2[0];
            dArr[i3] = dArr2[i76] - dArr2[1];
            dArr[0] = dArr2[i76] + dArr2[1];
            return;
        }
        dArr[1] = dArr[0];
        dArr[2] = dArr2[0];
        dArr[0] = dArr2[1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v24 */
    public void dfst(int i3, double[] dArr, double[] dArr2, int[] iArr, double[] dArr3) {
        ?? r26;
        int i16;
        int i17;
        int i18;
        boolean z16 = false;
        int i19 = iArr[0];
        if (i3 > (i19 << 3)) {
            i19 = i3 >> 3;
            makewt(i19, iArr, dArr3);
        }
        int i26 = i19;
        int i27 = iArr[1];
        if (i3 > (i27 << 1)) {
            i27 = i3 >> 1;
            makect(i27, iArr, dArr3, i26);
        }
        int i28 = i27;
        if (i3 > 2) {
            int i29 = i3 >> 1;
            int i36 = i29 >> 1;
            for (int i37 = 1; i37 < i36; i37++) {
                int i38 = i29 - i37;
                double d16 = dArr[i37];
                double d17 = dArr[i3 - i37];
                double d18 = d16 + d17;
                double d19 = d16 - d17;
                double d26 = dArr[i38];
                double d27 = dArr[i3 - i38];
                double d28 = d26 + d27;
                double d29 = d26 - d27;
                dArr[i37] = d18;
                dArr[i38] = d28;
                dArr2[i37] = d19 + d29;
                dArr2[i38] = d19 - d29;
            }
            int i39 = i3 - i36;
            dArr2[0] = dArr[i36] - dArr[i39];
            dArr[i36] = dArr[i36] + dArr[i39];
            dArr[0] = dArr[i29];
            dstsub(i29, dArr, i28, dArr3, i26);
            if (i29 > 4) {
                i16 = 4;
                i17 = i29;
                cftfsub(i29, dArr, iArr, 2, i26, dArr3);
                rftfsub(i17, dArr, i28, dArr3, i26);
            } else {
                i16 = 4;
                if (i29 == 4) {
                    i17 = i29;
                    cftfsub(i29, dArr, iArr, 2, i26, dArr3);
                } else {
                    i17 = i29;
                }
            }
            dArr[i3 - 1] = dArr[1] - dArr[0];
            dArr[1] = dArr[0] + dArr[1];
            int i46 = i17 - 2;
            for (int i47 = 2; i46 >= i47; i47 = 2) {
                int i48 = i46 * 2;
                int i49 = i46 + 1;
                dArr[i48 + 1] = dArr[i46] - dArr[i49];
                dArr[i48 - 1] = (-dArr[i46]) - dArr[i49];
                i46 -= 2;
            }
            int i56 = i36;
            int i57 = 2;
            int i58 = 2;
            while (i56 >= i57) {
                int i59 = i56;
                dstsub(i56, dArr2, i28, dArr3, i26);
                if (i59 > i16) {
                    i18 = i57;
                    cftfsub(i59, dArr2, iArr, 2, i26, dArr3);
                    rftfsub(i59, dArr2, i28, dArr3, i26);
                } else {
                    i18 = i57;
                    if (i59 == i16) {
                        cftfsub(i59, dArr2, iArr, 2, i26, dArr3);
                    }
                }
                dArr[i3 - i58] = dArr2[1] - dArr2[0];
                dArr[i58] = dArr2[0] + dArr2[1];
                int i65 = 0;
                for (int i66 = i18; i66 < i59; i66 += 2) {
                    i65 += i58 << 2;
                    int i67 = i66 + 1;
                    dArr[i65 - i58] = (-dArr2[i66]) - dArr2[i67];
                    dArr[i65 + i58] = dArr2[i66] - dArr2[i67];
                }
                i58 <<= 1;
                i56 = i59 >> 1;
                for (int i68 = 1; i68 < i56; i68++) {
                    int i69 = i59 - i68;
                    int i75 = i59 + i69;
                    int i76 = i59 + i68;
                    dArr2[i68] = dArr2[i75] + dArr2[i76];
                    dArr2[i69] = dArr2[i75] - dArr2[i76];
                }
                dArr2[0] = dArr2[i59 + i56];
                z16 = false;
                i57 = i18;
            }
            boolean z17 = z16;
            dArr[i58] = dArr2[z17 ? 1 : 0];
            r26 = z17;
        } else {
            r26 = 0;
        }
        dArr[r26] = 0.0d;
    }

    public void rdft(int i3, int i16, double[] dArr, int[] iArr, double[] dArr2) {
        int i17 = iArr[0];
        if (i3 > (i17 << 2)) {
            i17 = i3 >> 2;
            makewt(i17, iArr, dArr2);
        }
        int i18 = i17;
        int i19 = iArr[1];
        if (i3 > (i19 << 2)) {
            i19 = i3 >> 2;
            makect(i19, iArr, dArr2, i18);
        }
        int i26 = i19;
        if (i16 >= 0) {
            if (i3 > 4) {
                cftfsub(i3, dArr, iArr, 2, i18, dArr2);
                rftfsub(i3, dArr, i26, dArr2, i18);
            } else if (i3 == 4) {
                cftfsub(i3, dArr, iArr, 2, i18, dArr2);
            }
            double d16 = dArr[0];
            double d17 = dArr[1];
            dArr[0] = d16 + d17;
            dArr[1] = d16 - d17;
            return;
        }
        double d18 = dArr[0];
        double d19 = (d18 - dArr[1]) * 0.5d;
        dArr[1] = d19;
        dArr[0] = d18 - d19;
        if (i3 > 4) {
            rftbsub(i3, dArr, i26, dArr2, i18);
            cftbsub(i3, dArr, iArr, 2, i18, dArr2);
        } else if (i3 == 4) {
            cftbsub(i3, dArr, iArr, 2, i18, dArr2);
        }
    }
}
