package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLU;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class lf {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f149182a = {"\u5317", "\u4e1c\u5317", "\u4e1c", "\u4e1c\u5357", "\u5357", "\u897f\u5357", "\u897f", "\u897f\u5317"};

    private static double a(double d16) {
        return (d16 / 3.141592653589793d) * 180.0d;
    }

    private static double b(double d16) {
        return (d16 / 180.0d) * 3.141592653589793d;
    }

    private static double c(double d16) {
        double abs = Math.abs(d16 % 360.0d);
        return abs > 270.0d ? 360.0d - abs : abs;
    }

    private static double d(double d16, double d17, double d18, double d19) {
        double asin = Math.asin((d18 - d16) / Math.sqrt(Math.pow(d16 - d18, 2.0d) + Math.pow(d17 - d19, 2.0d)));
        if (d19 - d17 < 0.0d) {
            asin = 3.141592653589793d - asin;
        }
        return (asin / 3.141592653589793d) * 180.0d;
    }

    private static String a(float f16) {
        if (f16 < 0.0f) {
            f16 += 360.0f;
        }
        int i3 = 0;
        while (true) {
            String[] strArr = f149182a;
            if (i3 >= strArr.length) {
                return strArr[0];
            }
            float f17 = (i3 * 45) - 22.0f;
            if (f16 < 45.0f + f17 && f16 >= f17) {
                return strArr[i3];
            }
            i3++;
        }
    }

    private static IntBuffer b(GL10 gl10, int i3, int i16, int i17, int i18) {
        IntBuffer wrap = IntBuffer.wrap(new int[i17 * i18]);
        wrap.position(0);
        gl10.glReadPixels(i3, i16, i17, i18, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
        return wrap;
    }

    private static double c(double d16, double d17, double d18, double d19) {
        double abs;
        double d26 = d18 - d16;
        double d27 = d19 - d17;
        double atan = Math.atan(d27 / d26);
        if (d26 > 0.0d && d27 > 0.0d) {
            abs = 1.5707963267948966d - Math.abs(atan);
        } else if (d26 >= 0.0d && d27 <= 0.0d) {
            abs = 1.5707963267948966d + Math.abs(atan);
        } else if (d26 <= 0.0d && d27 <= 0.0d) {
            abs = 4.71238898038469d - Math.abs(atan);
        } else {
            abs = Math.abs(atan) + 4.71238898038469d;
        }
        return (abs * 180.0d) / 3.141592653589793d;
    }

    private static Bitmap a(GL10 gl10, int i3, int i16, int i17, int i18, int i19, int i26) {
        int i27 = i16 + i18;
        int[] iArr = new int[i17 * i27];
        int[] iArr2 = new int[i19 * i26];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        int i28 = 0;
        wrap.position(0);
        long currentTimeMillis = System.currentTimeMillis();
        gl10.glReadPixels(i3, 0, i17, i27, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
        LogUtil.b("readPixels \u4f7f\u7528\u7684\u65f6\u95f4:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        long currentTimeMillis2 = System.currentTimeMillis();
        float f16 = ((float) i17) / ((float) i19);
        float f17 = ((float) i18) / ((float) i26);
        int i29 = 0;
        int i36 = 0;
        while (i29 < i26) {
            for (int i37 = i28; i37 < i19; i37++) {
                int i38 = iArr[(((int) Math.ceil((i29 * f17) - 0.5d)) * i17) + ((int) Math.ceil((i37 * f16) - 0.5d))];
                iArr2[(((i26 - i36) - 1) * i19) + i37] = (i38 & (-16711936)) | ((i38 << 16) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((i38 >> 16) & 255);
            }
            i29++;
            i36++;
            i28 = 0;
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr2, i19, i26, Bitmap.Config.RGB_565);
        LogUtil.b("buffer \u8f6c\u6210\u4f4d\u56fe\u4f7f\u7528\u7684\u65f6\u95f4:" + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
        return createBitmap;
    }

    private static int b(float f16) {
        int i3 = 1;
        while (true) {
            int i16 = i3 + 1;
            int i17 = 2 << i3;
            if (i17 >= ((int) Math.ceil(f16))) {
                return i17;
            }
            i3 = i16;
        }
    }

    private static double b(double d16, double d17, double d18, double d19) {
        return Math.sqrt(Math.pow(d16 - d18, 2.0d) + Math.pow(d17 - d19, 2.0d));
    }

    private static gk b(float f16, float f17, float[] fArr, float[] fArr2, int[] iArr) {
        float[] a16 = a(f16, f17, 0.0f, fArr, fArr2, iArr);
        float[] a17 = a(f16, f17, 1.0f, fArr, fArr2, iArr);
        for (int i3 = 0; i3 < 3; i3++) {
            a16[i3] = a16[i3] / a16[3];
            a17[i3] = a17[i3] / a17[3];
        }
        return new gk(a17[0] - a16[0], a17[1] - a16[1], a17[2] - a16[2]);
    }

    private static float b(gl glVar, gl glVar2) {
        double asin = Math.asin((glVar2.f148502a - glVar.f148502a) / Math.sqrt(Math.pow(glVar.f148502a - glVar2.f148502a, 2.0d) + Math.pow(glVar.f148504c - glVar2.f148504c, 2.0d)));
        if (glVar2.f148504c - glVar.f148504c < 0.0f) {
            asin = 3.141592653589793d - asin;
        }
        return (float) ((asin / 3.141592653589793d) * 180.0d);
    }

    private static gl a(float f16, float f17, float f18, float[] fArr, float f19) {
        float[] fArr2 = new float[16];
        Matrix.invertM(fArr2, 0, fArr, 0);
        gl glVar = new gl(f16, f17, f19);
        float[] fArr3 = new float[4];
        Matrix.multiplyMV(fArr3, 0, fArr2, 0, new float[]{glVar.f148502a, glVar.f148503b, glVar.f148504c, glVar.f148505d}, 0);
        float f26 = fArr3[0];
        float f27 = fArr3[3];
        gl glVar2 = new gl(f26 / f27, fArr3[1] / f27, fArr3[2] / f27);
        float f28 = glVar2.f148503b;
        float f29 = f28 != 0.0f ? f18 / f28 : 1.0f;
        return new gl(glVar2.f148502a * f29, f18, glVar2.f148504c * f29);
    }

    private static gl a(double d16, double d17, double d18, double d19) {
        return new gl((float) (d16 - d18), 0.0f, -((float) (d17 - d19)));
    }

    private static PointF a(gl glVar, double d16, double d17) {
        return new PointF((float) (glVar.f148502a + d16), (float) ((-glVar.f148504c) + d17));
    }

    private static double a(gl glVar, gl glVar2) {
        return Math.sqrt(Math.pow(glVar.f148502a - glVar2.f148502a, 2.0d) + Math.pow(glVar.f148504c - glVar2.f148504c, 2.0d));
    }

    private static float[] a(float f16, float f17, float f18, float[] fArr, float[] fArr2, int[] iArr) {
        float[] fArr3 = new float[4];
        if (GLU.gluUnProject(f16, iArr[3] - f17, f18, fArr, 0, fArr2, 0, iArr, 0, fArr3, 0) == 1) {
            return fArr3;
        }
        throw new RuntimeException("unProject fail");
    }

    private static gk a(float[] fArr) {
        float f16 = fArr[0];
        float f17 = fArr[1];
        float f18 = fArr[2];
        float f19 = fArr[3];
        float f26 = fArr[4];
        float f27 = fArr[5];
        float f28 = fArr[6];
        float[] fArr2 = {f19 - f16, f26 - f17, f27 - f18};
        float f29 = fArr[7] - f17;
        float f36 = fArr[8] - f18;
        float[] fArr3 = {f28 - f16, f29, f36};
        float f37 = fArr2[1] * f36;
        float f38 = fArr2[2];
        float f39 = fArr3[0];
        float f46 = fArr2[0];
        return new gk(f37 - (f29 * f38), (f38 * f39) - (f36 * f46), (f46 * fArr3[1]) - (fArr2[1] * f39));
    }

    private static boolean a(float[] fArr, float[] fArr2) {
        gj gjVar = new gj(fArr2);
        gl glVar = new gl(fArr[0], fArr[1], fArr[2]);
        return ((double) Math.abs(gjVar.a() - ((new gj(glVar, gjVar.f148495a, gjVar.f148496b).a() + new gj(glVar, gjVar.f148495a, gjVar.f148497c).a()) + new gj(glVar, gjVar.f148496b, gjVar.f148497c).a()))) < 0.001d;
    }

    private static float[] a(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        float[] fArr5 = new float[3];
        float f16 = fArr[0];
        float f17 = fArr[1];
        float f18 = fArr[2];
        float f19 = fArr2[0];
        float f26 = fArr2[1];
        float f27 = fArr2[2];
        float f28 = fArr3[0];
        float f29 = fArr3[1];
        float f36 = fArr3[2];
        float f37 = fArr4[0];
        float f38 = fArr4[1];
        float f39 = fArr4[2];
        float f46 = (f28 * f16) + (f29 * f17) + (f36 * f18);
        if (f46 == 0.0f) {
            return null;
        }
        float f47 = ((((f19 - f37) * f16) + ((f26 - f38) * f17)) + ((f27 - f39) * f18)) / f46;
        fArr5[0] = f37 + (f28 * f47);
        fArr5[1] = f38 + (f29 * f47);
        fArr5[2] = f39 + (f36 * f47);
        return fArr5;
    }

    private static Bitmap a(GL10 gl10, int i3, int i16, int i17, int i18) {
        int i19 = i16 + i18;
        int[] iArr = new int[i17 * i19];
        int[] iArr2 = new int[i17 * i18];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        int i26 = 0;
        wrap.position(0);
        long currentTimeMillis = System.currentTimeMillis();
        gl10.glReadPixels(i3, 0, i17, i19, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
        LogUtil.b("readPixels \u4f7f\u7528\u7684\u65f6\u95f4:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        long currentTimeMillis2 = System.currentTimeMillis();
        float f16 = (float) i17;
        float f17 = f16 / f16;
        float f18 = i18;
        float f19 = f18 / f18;
        int i27 = 0;
        int i28 = 0;
        while (i27 < i18) {
            for (int i29 = i26; i29 < i17; i29++) {
                int i36 = iArr[(((int) Math.ceil((i27 * f19) - 0.5d)) * i17) + ((int) Math.ceil((i29 * f17) - 0.5d))];
                iArr2[(((i18 - i28) - 1) * i17) + i29] = (i36 & (-16711936)) | ((i36 << 16) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((i36 >> 16) & 255);
            }
            i27++;
            i28++;
            i26 = 0;
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr2, i17, i18, Bitmap.Config.RGB_565);
        LogUtil.b("buffer \u8f6c\u6210\u4f4d\u56fe\u4f7f\u7528\u7684\u65f6\u95f4:" + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
        return createBitmap;
    }

    private static boolean a(float f16, float f17, float[] fArr, float[] fArr2, int[] iArr) {
        float f18 = fArr[0];
        float f19 = fArr[1];
        float f26 = fArr[2];
        float f27 = fArr[3];
        float f28 = fArr[4];
        float f29 = fArr[5];
        float f36 = fArr[6];
        float[] fArr3 = {f27 - f18, f28 - f19, f29 - f26};
        float f37 = fArr[7] - f19;
        float f38 = fArr[8] - f26;
        float[] fArr4 = {f36 - f18, f37, f38};
        float f39 = fArr3[1] * f38;
        float f46 = fArr3[2];
        float f47 = fArr4[0];
        float f48 = fArr3[0];
        gk gkVar = new gk(f39 - (f37 * f46), (f46 * f47) - (f38 * f48), (f48 * fArr4[1]) - (fArr3[1] * f47));
        float[] fArr5 = new float[16];
        Matrix.setIdentityM(fArr5, 0);
        float[] a16 = a(f16, f17, 0.0f, fArr5, fArr2, iArr);
        float[] a17 = a(f16, f17, 1.0f, fArr5, fArr2, iArr);
        for (int i3 = 0; i3 < 3; i3++) {
            a16[i3] = a16[i3] / a16[3];
            a17[i3] = a17[i3] / a17[3];
        }
        gk gkVar2 = new gk(a17[0] - a16[0], a17[1] - a16[1], a17[2] - a16[2]);
        float[] a18 = gkVar.a();
        float[] fArr6 = {fArr[0], fArr[1], fArr[2]};
        float[] a19 = gkVar2.a();
        float f49 = a16[0];
        float f56 = a16[1];
        float f57 = a16[2];
        float[] fArr7 = new float[3];
        float f58 = a18[0];
        float f59 = a18[1];
        float f65 = a18[2];
        float f66 = fArr6[0];
        float f67 = fArr6[1];
        float f68 = fArr6[2];
        float f69 = a19[0];
        float f75 = a19[1];
        float f76 = a19[2];
        float f77 = (f69 * f58) + (f75 * f59) + (f76 * f65);
        if (f77 == 0.0f) {
            fArr7 = null;
        } else {
            float f78 = ((((f66 - f49) * f58) + ((f67 - f56) * f59)) + ((f68 - f57) * f65)) / f77;
            fArr7[0] = f49 + (f69 * f78);
            fArr7[1] = f56 + (f75 * f78);
            fArr7[2] = f57 + (f76 * f78);
        }
        if (fArr7 == null) {
            return false;
        }
        gj gjVar = new gj(fArr);
        gl glVar = new gl(fArr7[0], fArr7[1], fArr7[2]);
        return ((double) Math.abs(gjVar.a() - ((new gj(glVar, gjVar.f148495a, gjVar.f148496b).a() + new gj(glVar, gjVar.f148495a, gjVar.f148497c).a()) + new gj(glVar, gjVar.f148496b, gjVar.f148497c).a()))) < 0.001d;
    }
}
