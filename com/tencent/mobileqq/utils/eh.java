package com.tencent.mobileqq.utils;

import android.graphics.Bitmap;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes20.dex */
public class eh {
    public static void a(Bitmap bitmap, int i3) {
        int i16;
        int i17 = i3;
        if (i17 < 1) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i18 = width * height;
        int[] iArr = new int[i18];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i19 = width - 1;
        int i26 = height - 1;
        int i27 = i17 + i17 + 1;
        int[] iArr2 = new int[i18];
        int[] iArr3 = new int[i18];
        int[] iArr4 = new int[i18];
        int[] iArr5 = new int[Math.max(width, height)];
        int i28 = (i27 + 1) >> 1;
        int i29 = i28 * i28;
        int i36 = i29 * 256;
        int[] iArr6 = new int[i36];
        for (int i37 = 0; i37 < i36; i37++) {
            iArr6[i37] = i37 / i29;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i27, 3);
        int i38 = i17 + 1;
        int i39 = 0;
        int i46 = 0;
        int i47 = 0;
        while (i39 < height) {
            int i48 = height;
            int i49 = -i17;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            int i68 = 0;
            int i69 = 0;
            while (i49 <= i17) {
                int i75 = i26;
                int[] iArr8 = iArr5;
                int i76 = iArr[i46 + Math.min(i19, Math.max(i49, 0))];
                int[] iArr9 = iArr7[i49 + i17];
                iArr9[0] = (i76 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                iArr9[1] = (i76 & 65280) >> 8;
                iArr9[2] = i76 & 255;
                int abs = i38 - Math.abs(i49);
                int i77 = iArr9[0];
                i56 += i77 * abs;
                int i78 = iArr9[1];
                i57 += i78 * abs;
                int i79 = iArr9[2];
                i58 += abs * i79;
                if (i49 > 0) {
                    i67 += i77;
                    i68 += i78;
                    i69 += i79;
                } else {
                    i59 += i77;
                    i65 += i78;
                    i66 += i79;
                }
                i49++;
                i26 = i75;
                iArr5 = iArr8;
            }
            int i85 = i26;
            int[] iArr10 = iArr5;
            int i86 = i56;
            int i87 = i57;
            int i88 = 0;
            int i89 = i17;
            int i95 = i38;
            int i96 = i58;
            while (i88 < width) {
                if (i86 < i36 && i87 < i36 && i96 < i36) {
                    iArr2[i46] = iArr6[i86];
                    iArr3[i46] = iArr6[i87];
                    iArr4[i46] = iArr6[i96];
                    int i97 = i86 - i59;
                    int i98 = i87 - i65;
                    int i99 = i96 - i66;
                    int[] iArr11 = iArr7[((i89 - i17) + i27) % i27];
                    int i100 = i59 - iArr11[0];
                    int i101 = i65 - iArr11[1];
                    int i102 = i66 - iArr11[2];
                    if (i39 == 0) {
                        i16 = i36;
                        iArr10[i88] = Math.min(i88 + i17 + 1, i19);
                    } else {
                        i16 = i36;
                    }
                    int i103 = iArr[i47 + iArr10[i88]];
                    int i104 = (i103 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                    iArr11[0] = i104;
                    int i105 = (i103 & 65280) >> 8;
                    iArr11[1] = i105;
                    int i106 = i103 & 255;
                    iArr11[2] = i106;
                    int i107 = i67 + i104;
                    int i108 = i68 + i105;
                    int i109 = i69 + i106;
                    i86 = i97 + i107;
                    i87 = i98 + i108;
                    i96 = i99 + i109;
                    i89 = (i89 + 1) % i27;
                    int[] iArr12 = iArr7[i89 % i27];
                    int i110 = iArr12[0];
                    i59 = i100 + i110;
                    int i111 = iArr12[1];
                    i65 = i101 + i111;
                    int i112 = iArr12[2];
                    i66 = i102 + i112;
                    i67 = i107 - i110;
                    i68 = i108 - i111;
                    i69 = i109 - i112;
                    i46++;
                    i88++;
                    i36 = i16;
                } else {
                    return;
                }
            }
            i47 += width;
            i39++;
            height = i48;
            i38 = i95;
            i26 = i85;
            iArr5 = iArr10;
        }
        int i113 = i26;
        int[] iArr13 = iArr5;
        int i114 = height;
        int i115 = i38;
        int i116 = 0;
        while (i116 < width) {
            int i117 = -i17;
            int i118 = i117 * width;
            int i119 = 0;
            int i120 = 0;
            int i121 = 0;
            int i122 = 0;
            int i123 = 0;
            int i124 = 0;
            int i125 = 0;
            int i126 = 0;
            int i127 = 0;
            while (i117 <= i17) {
                int i128 = i27;
                int max = Math.max(0, i118) + i116;
                int[] iArr14 = iArr7[i117 + i17];
                iArr14[0] = iArr2[max];
                iArr14[1] = iArr3[max];
                iArr14[2] = iArr4[max];
                int abs2 = i115 - Math.abs(i117);
                i119 += iArr2[max] * abs2;
                i120 += iArr3[max] * abs2;
                i121 += iArr4[max] * abs2;
                if (i117 > 0) {
                    i125 += iArr14[0];
                    i126 += iArr14[1];
                    i127 += iArr14[2];
                } else {
                    i122 += iArr14[0];
                    i123 += iArr14[1];
                    i124 += iArr14[2];
                }
                int i129 = i113;
                if (i117 < i129) {
                    i118 += width;
                }
                i117++;
                i113 = i129;
                i27 = i128;
            }
            int i130 = i27;
            int i131 = i113;
            int i132 = i17;
            int i133 = i114;
            int i134 = 0;
            int i135 = i116;
            while (i134 < i133) {
                iArr[i135] = (iArr6[i119] << 16) | (-16777216) | (iArr6[i120] << 8) | iArr6[i121];
                int i136 = i119 - i122;
                int i137 = i120 - i123;
                int i138 = i121 - i124;
                int[] iArr15 = iArr7[((i132 - i17) + i130) % i130];
                int i139 = i122 - iArr15[0];
                int i140 = i123 - iArr15[1];
                int i141 = i124 - iArr15[2];
                if (i116 == 0) {
                    iArr13[i134] = Math.min(i134 + i115, i131) * width;
                }
                int i142 = iArr13[i134] + i116;
                int i143 = iArr2[i142];
                iArr15[0] = i143;
                int i144 = iArr3[i142];
                iArr15[1] = i144;
                int i145 = iArr4[i142];
                iArr15[2] = i145;
                int i146 = i125 + i143;
                int i147 = i126 + i144;
                int i148 = i127 + i145;
                i119 = i136 + i146;
                i120 = i137 + i147;
                i121 = i138 + i148;
                i132 = (i132 + 1) % i130;
                int[] iArr16 = iArr7[i132];
                int i149 = iArr16[0];
                i122 = i139 + i149;
                int i150 = iArr16[1];
                i123 = i140 + i150;
                int i151 = iArr16[2];
                i124 = i141 + i151;
                i125 = i146 - i149;
                i126 = i147 - i150;
                i127 = i148 - i151;
                i135 += width;
                i134++;
                i17 = i3;
            }
            i116++;
            i17 = i3;
            i114 = i133;
            i113 = i131;
            i27 = i130;
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, i114);
    }
}
