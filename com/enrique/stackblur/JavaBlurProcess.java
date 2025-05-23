package com.enrique.stackblur;

import android.graphics.Bitmap;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.jf.dexlib2.analysis.RegisterType;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class JavaBlurProcess implements BlurProcess {
    private static final short[] stackblur_mul = {512, 512, 456, 512, 328, 456, 335, 512, 405, 328, 271, 456, 388, 335, 292, 512, 454, 405, 364, 328, 298, 271, 496, 456, 420, 388, 360, 335, 312, 292, 273, 512, 482, 454, 428, 405, 383, 364, 345, 328, 312, 298, 284, 271, 259, 496, 475, 456, 437, 420, 404, 388, 374, 360, 347, 335, 323, 312, 302, 292, 282, 273, 265, 512, 497, 482, 468, 454, 441, 428, 417, 405, 394, 383, 373, 364, 354, 345, 337, 328, 320, 312, 305, 298, 291, 284, 278, 271, 265, 259, 507, 496, 485, 475, 465, 456, 446, 437, 428, 420, 412, 404, 396, 388, 381, 374, 367, 360, 354, 347, 341, 335, 329, 323, 318, 312, 307, 302, 297, 292, 287, 282, 278, 273, 269, 265, 261, 512, 505, 497, 489, 482, 475, 468, 461, 454, 447, 441, 435, 428, 422, 417, 411, 405, 399, 394, 389, 383, 378, 373, 368, 364, 359, 354, 350, 345, 341, 337, 332, 328, 324, 320, 316, 312, 309, 305, 301, 298, 294, 291, 287, 284, 281, 278, 274, 271, 268, 265, 262, 259, 257, 507, 501, 496, 491, 485, 480, 475, 470, 465, 460, 456, 451, 446, 442, 437, 433, 428, 424, 420, 416, 412, 408, 404, 400, 396, 392, 388, 385, 381, 377, 374, 370, 367, 363, 360, 357, 354, 350, 347, 344, 341, 338, 335, 332, 329, 326, 323, 320, 318, 315, 312, 310, 307, 304, 302, 299, 297, 294, 292, 289, 287, 285, 282, 280, 278, 275, 273, 271, 269, 267, 265, 263, 261, 259};
    private static final byte[] stackblur_shr = {9, 11, 12, 13, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, RegisterType.UNINIT_REF, RegisterType.UNINIT_REF, RegisterType.UNINIT_REF, 17, 17, 17, 17, 17, 17, 17, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24};

    /* loaded from: classes2.dex */
    private static class BlurTask implements Callable<Void> {
        private final int _coreIndex;
        private final int _h;
        private final int _radius;
        private final int _round;
        private final int[] _src;
        private final int _totalCores;
        private final int _w;

        public BlurTask(int[] iArr, int i3, int i16, int i17, int i18, int i19, int i26) {
            this._src = iArr;
            this._w = i3;
            this._h = i16;
            this._radius = i17;
            this._totalCores = i18;
            this._coreIndex = i19;
            this._round = i26;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            JavaBlurProcess.blurIteration(this._src, this._w, this._h, this._radius, this._totalCores, this._coreIndex, this._round);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void blurIteration(int[] iArr, int i3, int i16, int i17, int i18, int i19, int i26) {
        int i27;
        int i28;
        int i29 = i3;
        int i36 = i16;
        int i37 = i17;
        int i38 = i29 - 1;
        int i39 = i36 - 1;
        int i46 = (i37 * 2) + 1;
        short s16 = stackblur_mul[i37];
        byte b16 = stackblur_shr[i37];
        int[] iArr2 = new int[i46];
        if (i26 == 1) {
            int i47 = (i19 * i36) / i18;
            int i48 = ((i19 + 1) * i36) / i18;
            while (i47 < i48) {
                int i49 = i29 * i47;
                int i56 = 0;
                long j3 = 0;
                long j16 = 0;
                long j17 = 0;
                long j18 = 0;
                long j19 = 0;
                long j26 = 0;
                while (i56 <= i37) {
                    iArr2[i56] = iArr[i49];
                    int i57 = iArr[i49];
                    i56++;
                    j3 += ((i57 >>> 16) & 255) * i56;
                    j16 += ((i57 >>> 8) & 255) * i56;
                    j17 += (i57 & 255) * i56;
                    j18 += (i57 >>> 16) & 255;
                    j19 += (i57 >>> 8) & 255;
                    j26 += i57 & 255;
                }
                int i58 = i49;
                int i59 = 1;
                long j27 = 0;
                long j28 = 0;
                long j29 = 0;
                while (i59 <= i37) {
                    if (i59 <= i38) {
                        i58++;
                    }
                    iArr2[i59 + i37] = iArr[i58];
                    int i65 = iArr[i58];
                    int i66 = (i37 + 1) - i59;
                    j3 += ((i65 >>> 16) & 255) * i66;
                    j16 += ((i65 >>> 8) & 255) * i66;
                    j17 += (i65 & 255) * i66;
                    j29 += (i65 >>> 16) & 255;
                    j28 += (i65 >>> 8) & 255;
                    j27 += i65 & 255;
                    i59++;
                    i58 = i58;
                }
                if (i37 > i38) {
                    i28 = i38;
                } else {
                    i28 = i37;
                }
                int i67 = i28 + i49;
                int i68 = i37;
                int i69 = 0;
                while (i69 < i29) {
                    int i75 = i48;
                    long j36 = j27;
                    int i76 = i69;
                    int i77 = i47;
                    int i78 = i38;
                    long j37 = s16;
                    iArr[i49] = (int) ((((j37 * j17) >>> b16) & 255) | (iArr[i49] & (-16777216)) | ((((j3 * j37) >>> b16) & 255) << 16) | ((((j16 * j37) >>> b16) & 255) << 8));
                    int i79 = i49 + 1;
                    long j38 = j3 - j18;
                    long j39 = j16 - j19;
                    long j46 = j17 - j26;
                    int i85 = (i68 + i46) - i37;
                    if (i85 >= i46) {
                        i85 -= i46;
                    }
                    int i86 = iArr2[i85];
                    long j47 = j18 - ((i86 >>> 16) & 255);
                    long j48 = j19 - ((i86 >>> 8) & 255);
                    long j49 = j26 - (i86 & 255);
                    i38 = i78;
                    if (i28 < i38) {
                        i67++;
                        i28++;
                    }
                    iArr2[i85] = iArr[i67];
                    int i87 = iArr[i67];
                    long j56 = j29 + ((i87 >>> 16) & 255);
                    long j57 = j28 + ((i87 >>> 8) & 255);
                    long j58 = j36 + (i87 & 255);
                    j3 = j38 + j56;
                    j16 = j39 + j57;
                    j17 = j46 + j58;
                    i68++;
                    if (i68 >= i46) {
                        i68 = 0;
                    }
                    int i88 = iArr2[i68];
                    int i89 = i46;
                    j18 = j47 + ((i88 >>> 16) & 255);
                    j19 = j48 + ((i88 >>> 8) & 255);
                    j26 = j49 + (i88 & 255);
                    j29 = j56 - ((i88 >>> 16) & 255);
                    j28 = j57 - ((i88 >>> 8) & 255);
                    long j59 = j58 - (i88 & 255);
                    i69 = i76 + 1;
                    i49 = i79;
                    i47 = i77;
                    j27 = j59;
                    i46 = i89;
                    i48 = i75;
                    i28 = i28;
                }
                i47++;
                i48 = i48;
            }
            return;
        }
        int i95 = i46;
        if (i26 == 2) {
            int i96 = (i19 * i29) / i18;
            int i97 = ((i19 + 1) * i29) / i18;
            while (i96 < i97) {
                int i98 = 0;
                long j65 = 0;
                long j66 = 0;
                long j67 = 0;
                long j68 = 0;
                long j69 = 0;
                long j75 = 0;
                while (i98 <= i37) {
                    iArr2[i98] = iArr[i96];
                    int i99 = iArr[i96];
                    i98++;
                    j65 += ((i99 >>> 16) & 255) * i98;
                    j66 += ((i99 >>> 8) & 255) * i98;
                    j67 += (i99 & 255) * i98;
                    j68 += (i99 >>> 16) & 255;
                    j69 += (i99 >>> 8) & 255;
                    j75 += i99 & 255;
                    s16 = s16;
                    b16 = b16;
                }
                short s17 = s16;
                byte b17 = b16;
                int i100 = i96;
                int i101 = 1;
                long j76 = 0;
                long j77 = 0;
                long j78 = 0;
                while (i101 <= i37) {
                    if (i101 <= i39) {
                        i100 += i29;
                    }
                    iArr2[i101 + i37] = iArr[i100];
                    int i102 = iArr[i100];
                    int i103 = (i37 + 1) - i101;
                    j65 += ((i102 >>> 16) & 255) * i103;
                    j66 += ((i102 >>> 8) & 255) * i103;
                    j67 += (i102 & 255) * i103;
                    j78 += (i102 >>> 16) & 255;
                    j77 += (i102 >>> 8) & 255;
                    j76 += i102 & 255;
                    i101++;
                    i97 = i97;
                    i100 = i100;
                }
                int i104 = i97;
                if (i37 > i39) {
                    i27 = i39;
                } else {
                    i27 = i37;
                }
                int i105 = (i27 * i29) + i96;
                int i106 = i37;
                int i107 = i96;
                int i108 = 0;
                while (i108 < i36) {
                    long j79 = j76;
                    int i109 = i108;
                    int i110 = i27;
                    short s18 = s17;
                    int i111 = i96;
                    long j85 = s18;
                    iArr[i107] = (int) ((((j85 * j67) >>> b17) & 255) | (iArr[i107] & (-16777216)) | ((((j65 * j85) >>> b17) & 255) << 16) | ((((j66 * j85) >>> b17) & 255) << 8));
                    i107 += i29;
                    long j86 = j65 - j68;
                    long j87 = j66 - j69;
                    long j88 = j67 - j75;
                    int i112 = (i106 + i95) - i37;
                    int i113 = i95;
                    if (i112 >= i113) {
                        i112 -= i113;
                    }
                    int i114 = iArr2[i112];
                    long j89 = j68 - ((i114 >>> 16) & 255);
                    long j95 = j69 - ((i114 >>> 8) & 255);
                    long j96 = j75 - (i114 & 255);
                    int i115 = i110;
                    if (i115 < i39) {
                        i105 += i29;
                        i115++;
                    }
                    iArr2[i112] = iArr[i105];
                    int i116 = iArr[i105];
                    long j97 = j78 + ((i116 >>> 16) & 255);
                    long j98 = j77 + ((i116 >>> 8) & 255);
                    long j99 = (i116 & 255) + j79;
                    j65 = j86 + j97;
                    j66 = j87 + j98;
                    j67 = j88 + j99;
                    int i117 = i106 + 1;
                    if (i117 >= i113) {
                        i106 = 0;
                    } else {
                        i106 = i117;
                    }
                    int i118 = iArr2[i106];
                    int i119 = i115;
                    j68 = j89 + ((i118 >>> 16) & 255);
                    j69 = j95 + ((i118 >>> 8) & 255);
                    j75 = j96 + (i118 & 255);
                    j78 = j97 - ((i118 >>> 16) & 255);
                    j77 = j98 - ((i118 >>> 8) & 255);
                    long j100 = j99 - (i118 & 255);
                    i108 = i109 + 1;
                    i37 = i17;
                    j76 = j100;
                    i96 = i111;
                    s17 = s18;
                    i29 = i3;
                    i36 = i16;
                    i95 = i113;
                    i27 = i119;
                }
                i96++;
                i29 = i3;
                i36 = i16;
                i37 = i17;
                i97 = i104;
                b16 = b17;
                s16 = s17;
                i95 = i95;
            }
        }
    }

    @Override // com.enrique.stackblur.BlurProcess
    public Bitmap blur(Bitmap bitmap, float f16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = StackBlurManager.EXECUTOR_THREADS;
        ArrayList arrayList = new ArrayList(i3);
        ArrayList arrayList2 = new ArrayList(i3);
        for (int i16 = 0; i16 < i3; i16++) {
            int i17 = (int) f16;
            int i18 = i16;
            arrayList.add(new BlurTask(iArr, width, height, i17, i3, i18, 1));
            arrayList2.add(new BlurTask(iArr, width, height, i17, i3, i18, 2));
        }
        try {
            ExecutorService executorService = StackBlurManager.EXECUTOR;
            executorService.invokeAll(arrayList);
            executorService.invokeAll(arrayList2);
            return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
