package com.tencent.biz.qqstory.takevideo.slideshow;

import android.graphics.Bitmap;
import android.os.Environment;
import com.tencent.biz.qqstory.takevideo.slideshow.ConvertRunnable;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Image2Video implements ConvertRunnable.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f94285a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f94286b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class EglHandlerThreadEx extends EglHandlerThread {
        private WeakReference<Object> G;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread, android.os.HandlerThread
        public void onLooperPrepared() {
            Object obj;
            super.onLooperPrepared();
            WeakReference<Object> weakReference = this.G;
            if (weakReference != null && (obj = weakReference.get()) != null) {
                synchronized (obj) {
                    obj.notify();
                }
            }
        }
    }

    static {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.tencent.mobileqq/qq/video/imagevideo/";
        f94285a = str;
        f94286b = str + "cache/";
    }

    public static Bitmap b(Bitmap bitmap, float f16, int i3, boolean z16) {
        int[] iArr;
        int i16 = i3;
        if (i16 >= 1 && bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(width * f16), Math.round(height * f16), false);
            Bitmap copy = createScaledBitmap.copy(createScaledBitmap.getConfig(), true);
            int width2 = copy.getWidth();
            int height2 = copy.getHeight();
            int i17 = width2 * height2;
            int[] iArr2 = new int[i17];
            copy.getPixels(iArr2, 0, width2, 0, 0, width2, height2);
            int i18 = width2 - 1;
            int i19 = height2 - 1;
            int i26 = i16 + i16 + 1;
            int[] iArr3 = new int[i17];
            int[] iArr4 = new int[i17];
            int[] iArr5 = new int[i17];
            int[] iArr6 = new int[Math.max(width2, height2)];
            int i27 = (i26 + 1) >> 1;
            int i28 = i27 * i27;
            int i29 = i28 * 256;
            int[] iArr7 = new int[i29];
            for (int i36 = 0; i36 < i29; i36++) {
                iArr7[i36] = i36 / i28;
            }
            int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i26, 3);
            int i37 = i16 + 1;
            int i38 = 0;
            int i39 = 0;
            int i46 = 0;
            while (i38 < height2) {
                int i47 = height;
                Bitmap bitmap2 = copy;
                int i48 = -i16;
                int i49 = 0;
                int i56 = 0;
                int i57 = 0;
                int i58 = 0;
                int i59 = 0;
                int i65 = 0;
                int i66 = 0;
                int i67 = 0;
                int i68 = 0;
                while (i48 <= i16) {
                    int i69 = height2;
                    int i75 = i19;
                    int i76 = iArr2[i39 + Math.min(i18, Math.max(i48, 0))];
                    int[] iArr9 = iArr8[i48 + i16];
                    iArr9[0] = (i76 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                    iArr9[1] = (i76 & 65280) >> 8;
                    iArr9[2] = i76 & 255;
                    int abs = i37 - Math.abs(i48);
                    int i77 = iArr9[0];
                    i49 += i77 * abs;
                    int i78 = iArr9[1];
                    i56 += i78 * abs;
                    int i79 = iArr9[2];
                    i57 += abs * i79;
                    if (i48 > 0) {
                        i66 += i77;
                        i67 += i78;
                        i68 += i79;
                    } else {
                        i58 += i77;
                        i59 += i78;
                        i65 += i79;
                    }
                    i48++;
                    height2 = i69;
                    i19 = i75;
                }
                int i85 = height2;
                int i86 = i19;
                int i87 = i16;
                int i88 = 0;
                while (i88 < width2) {
                    iArr3[i39] = iArr7[i49];
                    iArr4[i39] = iArr7[i56];
                    iArr5[i39] = iArr7[i57];
                    int i89 = i49 - i58;
                    int i95 = i56 - i59;
                    int i96 = i57 - i65;
                    int[] iArr10 = iArr8[((i87 - i16) + i26) % i26];
                    int i97 = i58 - iArr10[0];
                    int i98 = i59 - iArr10[1];
                    int i99 = i65 - iArr10[2];
                    if (i38 == 0) {
                        iArr = iArr7;
                        iArr6[i88] = Math.min(i88 + i16 + 1, i18);
                    } else {
                        iArr = iArr7;
                    }
                    int i100 = iArr2[i46 + iArr6[i88]];
                    int i101 = (i100 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                    iArr10[0] = i101;
                    int i102 = (i100 & 65280) >> 8;
                    iArr10[1] = i102;
                    int i103 = i100 & 255;
                    iArr10[2] = i103;
                    int i104 = i66 + i101;
                    int i105 = i67 + i102;
                    int i106 = i68 + i103;
                    i49 = i89 + i104;
                    i56 = i95 + i105;
                    i57 = i96 + i106;
                    i87 = (i87 + 1) % i26;
                    int[] iArr11 = iArr8[i87 % i26];
                    int i107 = iArr11[0];
                    i58 = i97 + i107;
                    int i108 = iArr11[1];
                    i59 = i98 + i108;
                    int i109 = iArr11[2];
                    i65 = i99 + i109;
                    i66 = i104 - i107;
                    i67 = i105 - i108;
                    i68 = i106 - i109;
                    i39++;
                    i88++;
                    iArr7 = iArr;
                }
                i46 += width2;
                i38++;
                height = i47;
                copy = bitmap2;
                height2 = i85;
                i19 = i86;
            }
            Bitmap bitmap3 = copy;
            int[] iArr12 = iArr7;
            int i110 = height;
            int i111 = height2;
            int i112 = i19;
            int i113 = 0;
            while (i113 < width2) {
                int i114 = -i16;
                int i115 = i26;
                int[] iArr13 = iArr6;
                int i116 = 0;
                int i117 = 0;
                int i118 = 0;
                int i119 = 0;
                int i120 = 0;
                int i121 = 0;
                int i122 = 0;
                int i123 = i114;
                int i124 = i114 * width2;
                int i125 = 0;
                int i126 = 0;
                while (i123 <= i16) {
                    int i127 = width2;
                    int max = Math.max(0, i124) + i113;
                    int[] iArr14 = iArr8[i123 + i16];
                    iArr14[0] = iArr3[max];
                    iArr14[1] = iArr4[max];
                    iArr14[2] = iArr5[max];
                    int abs2 = i37 - Math.abs(i123);
                    i125 += iArr3[max] * abs2;
                    i126 += iArr4[max] * abs2;
                    i116 += iArr5[max] * abs2;
                    if (i123 > 0) {
                        i120 += iArr14[0];
                        i121 += iArr14[1];
                        i122 += iArr14[2];
                    } else {
                        i117 += iArr14[0];
                        i118 += iArr14[1];
                        i119 += iArr14[2];
                    }
                    int i128 = i112;
                    if (i123 < i128) {
                        i124 += i127;
                    }
                    i123++;
                    i112 = i128;
                    width2 = i127;
                }
                int i129 = width2;
                int i130 = i112;
                int i131 = i113;
                int i132 = i16;
                int i133 = i111;
                int i134 = 0;
                while (i134 < i133) {
                    iArr2[i131] = (iArr2[i131] & (-16777216)) | (iArr12[i125] << 16) | (iArr12[i126] << 8) | iArr12[i116];
                    int i135 = i125 - i117;
                    int i136 = i126 - i118;
                    int i137 = i116 - i119;
                    int[] iArr15 = iArr8[((i132 - i16) + i115) % i115];
                    int i138 = i117 - iArr15[0];
                    int i139 = i118 - iArr15[1];
                    int i140 = i119 - iArr15[2];
                    if (i113 == 0) {
                        iArr13[i134] = Math.min(i134 + i37, i130) * i129;
                    }
                    int i141 = iArr13[i134] + i113;
                    int i142 = iArr3[i141];
                    iArr15[0] = i142;
                    int i143 = iArr4[i141];
                    iArr15[1] = i143;
                    int i144 = iArr5[i141];
                    iArr15[2] = i144;
                    int i145 = i120 + i142;
                    int i146 = i121 + i143;
                    int i147 = i122 + i144;
                    i125 = i135 + i145;
                    i126 = i136 + i146;
                    i116 = i137 + i147;
                    i132 = (i132 + 1) % i115;
                    int[] iArr16 = iArr8[i132];
                    int i148 = iArr16[0];
                    i117 = i138 + i148;
                    int i149 = iArr16[1];
                    i118 = i139 + i149;
                    int i150 = iArr16[2];
                    i119 = i140 + i150;
                    i120 = i145 - i148;
                    i121 = i146 - i149;
                    i122 = i147 - i150;
                    i131 += i129;
                    i134++;
                    i16 = i3;
                }
                i113++;
                i16 = i3;
                i112 = i130;
                i111 = i133;
                iArr6 = iArr13;
                i26 = i115;
                width2 = i129;
            }
            int i151 = width2;
            bitmap3.setPixels(iArr2, 0, i151, 0, 0, i151, i111);
            if (z16) {
                return Bitmap.createScaledBitmap(bitmap3, width, i110, true);
            }
            return bitmap3;
        }
        return null;
    }

    public static String c() {
        String str = f94285a + "/noaudio";
        FileUtils.createFileIfNotExits(str);
        return str;
    }
}
