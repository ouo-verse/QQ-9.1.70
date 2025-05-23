package com.tencent.ttpic.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.Matrix;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.model.FILL_STYLE;
import com.tencent.ttpic.model.SizeI;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AlgoUtils {
    private static final String TAG = "AlgoUtils";
    private static final Random mRandom = new Random(System.currentTimeMillis());
    private static int mAverageHistogram = -1;

    private static float[] GLKVector4Subtract(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[fArr.length];
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr3[i3] = fArr[i3] - fArr2[i3];
        }
        return fArr3;
    }

    public static native void RGBA2YUV420SP(byte[] bArr, byte[] bArr2, int i3, int i16);

    public static native void RGBA2YUV420SP2(byte[] bArr, byte[] bArr2, int i3, int i16);

    public static native void RGBA2YUV420SP3(byte[] bArr, byte[] bArr2, int i3, int i16);

    public static void XYZ2Lab(double[] dArr, double[] dArr2) {
        double d16;
        double d17;
        double d18;
        double d19 = dArr[0];
        double d26 = d19 / 95.04d;
        double d27 = dArr[1] / 100.0d;
        double d28 = dArr[2] / 108.89d;
        if (d26 > 0.008856d) {
            d16 = Math.pow(d26, 0.333333d);
        } else {
            d16 = (d26 * 7.787d) + 0.137931d;
        }
        if (d27 > 0.008856d) {
            d17 = Math.pow(d27, 0.333333d);
        } else {
            d17 = (d27 * 7.787d) + 0.137931d;
        }
        if (d28 > 0.008856d) {
            d18 = Math.pow(d28, 0.333333d);
        } else {
            d18 = (d28 * 7.787d) + 0.137931d;
        }
        dArr2[0] = (116.0d * d17) - 16.0d;
        dArr2[1] = (d16 - d17) * 500.0d;
        dArr2[2] = (d17 - d18) * 200.0d;
    }

    public static native void YUVNV21TORGBA(byte[] bArr, byte[] bArr2, byte[] bArr3, int i3, int i16);

    public static native void YUVX2YUV(byte[] bArr, byte[] bArr2, int i3, int i16);

    public static float[] adjustPosition(float[] fArr, float f16) {
        float f17 = (fArr[0] + fArr[4]) / 2.0f;
        float f18 = (fArr[1] + fArr[3]) / 2.0f;
        for (int i3 = 0; i3 < fArr.length / 2; i3++) {
            int i16 = i3 * 2;
            fArr[i16] = ((fArr[i16] - f17) * f16) + f17;
            int i17 = i16 + 1;
            fArr[i17] = ((fArr[i17] - f18) * f16) + f18;
        }
        return fArr;
    }

    public static float[] adjustPositionTriangles(float[] fArr, float f16, double[] dArr, int i3) {
        int i16 = 0;
        float f17 = fArr[0];
        float f18 = f17 + ((fArr[10] - f17) * ((float) dArr[0]));
        float f19 = fArr[1];
        float f26 = f19 + ((fArr[3] - f19) * ((float) dArr[1]));
        if (i3 == 0) {
            while (i16 < fArr.length / 2) {
                int i17 = i16 * 2;
                fArr[i17] = ((fArr[i17] - f18) * f16) + f18;
                int i18 = i17 + 1;
                fArr[i18] = ((fArr[i18] - f26) * f16) + f26;
                i16++;
            }
        } else if (i3 == 1) {
            while (i16 < fArr.length / 2) {
                int i19 = (i16 * 2) + 1;
                fArr[i19] = ((fArr[i19] - f26) * f16) + f26;
                i16++;
            }
        } else if (i3 == 2) {
            while (i16 < fArr.length / 2) {
                int i26 = i16 * 2;
                fArr[i26] = ((fArr[i26] - f18) * f16) + f18;
                i16++;
            }
        }
        return fArr;
    }

    public static boolean between(float f16, float f17, float f18) {
        if (f18 >= Math.min(f16, f17) && f18 <= Math.max(f16, f17)) {
            return true;
        }
        return false;
    }

    public static double calBrightnessAdjustment(byte[] bArr, int i3, int i16, List<List<PointF>> list, int[] iArr, int[] iArr2) {
        if (list != null && list.size() > 0 && list.get(0).size() > 0) {
            ArrayList arrayList = new ArrayList(list.get(0));
            return createBrightnessCurve((int) ((PointF) arrayList.get(4)).x, (int) ((PointF) arrayList.get(14)).x, (int) ((PointF) arrayList.get(0)).y, (int) ((PointF) arrayList.get(3)).y, i3, i16, bArr, iArr, iArr2);
        }
        resetBrightnessAdjustmentCurve(iArr2);
        return 60.0d;
    }

    public static int[] calBrightnessCurve(byte[] bArr, int i3, int i16, List<List<PointF>> list) {
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int[] iArr3 = new int[256];
        if (bArr != null && bArr.length >= 256 && i3 > 0 && i16 > 0 && !CollectionUtils.isEmpty(list)) {
            getHistogram(bArr, i3, i16, list, iArr, iArr2);
            calBrightnessAdjustment(bArr, i3, i16, list, iArr2, iArr3);
            return mergeCurve(iArr2, iArr3);
        }
        resetBrightnessAdjustmentCurve(iArr3);
        return iArr3;
    }

    private static SizeI calCutAspectSize(int i3, int i16, int i17, int i18) {
        double d16 = i3 / i16;
        double d17 = i18;
        double d18 = (int) (d17 * d16);
        double d19 = i17;
        if (d18 < d19) {
            d17 = d19 / d16;
            d18 = d19;
        }
        return new SizeI((int) d18, (int) d17);
    }

    public static SizeI calCutSize(int i3, int i16, double d16) {
        double d17 = i3;
        double d18 = i16;
        if (d17 / d18 >= d16) {
            return new SizeI((int) Math.round(d18 * d16), i16);
        }
        return new SizeI(i3, (int) Math.round(d17 / d16));
    }

    public static List<Integer> calFaceAvgColor(byte[] bArr, int i3, int i16, List<List<PointF>> list) {
        if (list != null && list.size() > 0 && list.get(0).size() > 0) {
            ArrayList arrayList = new ArrayList(list.get(0));
            return createFaceAvgColor(bArr, (int) ((PointF) arrayList.get(4)).x, (int) ((PointF) arrayList.get(14)).x, (int) ((PointF) arrayList.get(0)).y, (int) ((PointF) arrayList.get(3)).y, i3, i16);
        }
        return Arrays.asList(0, 0, 0);
    }

    private float[] calPlaneLineIntersectPoint(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
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

    public static float[] calPositions(float f16, float f17, float f18, float f19, int i3, int i16) {
        float f26 = i3;
        float f27 = ((f16 / f26) * 2.0f) - 1.0f;
        float f28 = i16;
        float f29 = ((f17 / f28) * 2.0f) - 1.0f;
        float f36 = ((f18 / f26) * 2.0f) - 1.0f;
        float f37 = ((f19 / f28) * 2.0f) - 1.0f;
        return new float[]{f27, f37, f27, f29, f36, f29, f36, f37};
    }

    public static float[] calPositionsTriangles(float f16, float f17, float f18, float f19, int i3, int i16) {
        float f26 = i3;
        float f27 = ((f16 / f26) * 2.0f) - 1.0f;
        float f28 = i16;
        float f29 = ((f17 / f28) * 2.0f) - 1.0f;
        float f36 = ((f18 / f26) * 2.0f) - 1.0f;
        float f37 = ((f19 / f28) * 2.0f) - 1.0f;
        return new float[]{f27, f29, f27, f37, f36, f37, f27, f29, f36, f37, f36, f29};
    }

    private static SizeI calSpaceAspectSize(int i3, int i16, int i17, int i18) {
        double d16 = i3 / i16;
        double d17 = i18;
        double d18 = (int) (d17 * d16);
        double d19 = i17;
        if (d18 > d19) {
            d17 = d19 / d16;
            d18 = d19;
        }
        return new SizeI((int) d18, (int) d17);
    }

    public static float[] calTexCoords(float f16, float f17, float f18, float f19, int i3, int i16) {
        float[] calPositions = calPositions(f16, f17, f18, f19, i3, i16);
        for (int i17 = 0; i17 < calPositions.length; i17++) {
            calPositions[i17] = (calPositions[i17] * 0.5f) + 0.5f;
        }
        return calPositions;
    }

    public static float[] calTexCoordsFill(Rect rect, int i3, int i16) {
        float f16 = i3 - rect.left;
        int i17 = rect.top;
        return calTexCoords(-r0, i16 - i17, f16, -i17, rect.width(), rect.height());
    }

    public static float[] calTexCords(com.tencent.ttpic.openapi.model.Rect rect, int i3, int i16, int i17) {
        if (i17 != FILL_STYLE.CUT.value && i17 != FILL_STYLE.FRAME_STYLE_CUT.value) {
            return GlUtil.ORIGIN_TEX_COORDS;
        }
        return calTexCoords(i3, i16, rect.width / rect.height);
    }

    public static float[] calcPerspectiveProjTransformMatrix(float[] fArr, int i3, int i16, float f16) {
        float[] fArr2 = {fArr[0], fArr[1], fArr[2]};
        float f17 = fArr[3];
        float[] fArr3 = {fArr[4] * f17, fArr[5] * f17};
        float f18 = f17 * 110.0f;
        float tan = (float) ((i16 / 2.0d) / Math.tan(0.5235987755982988d));
        float[] fArr4 = new float[16];
        Matrix.setIdentityM(fArr4, 0);
        Matrix.translateM(fArr4, 0, fArr3[0] - (i3 * 0.5f), -(fArr3[1] - (i16 * 0.5f)), tan);
        Matrix.rotateM(fArr4, 0, -fArr2[2], 0.0f, 0.0f, 1.0f);
        Matrix.rotateM(fArr4, 0, -fArr2[1], 0.0f, 1.0f, 0.0f);
        Matrix.rotateM(fArr4, 0, fArr2[0], 1.0f, 0.0f, 0.0f);
        Matrix.scaleM(fArr4, 0, f18, f18, f18);
        float[] fArr5 = new float[4];
        float[] fArr6 = new float[4];
        float[] fArr7 = new float[16];
        float[] fArr8 = new float[16];
        Matrix.multiplyMV(fArr5, 0, fArr4, 0, new float[]{0.0f, 0.10727273f, 1.0290909f, 1.0f}, 0);
        Matrix.multiplyMV(fArr6, 0, fArr4, 0, new float[]{0.0f, 0.0f, 0.0f, 1.0f}, 0);
        float[] GLKVector4Subtract = GLKVector4Subtract(fArr5, fArr6);
        Matrix.setIdentityM(fArr7, 0);
        Matrix.translateM(fArr7, 0, GLKVector4Subtract[0], GLKVector4Subtract[1], GLKVector4Subtract[2]);
        Matrix.multiplyMM(fArr8, 0, fArr7, 0, fArr4, 0);
        return fArr8;
    }

    public static void calcRotateMatrix(float[] fArr, float[] fArr2) {
        float cos = (float) Math.cos(fArr[0]);
        float sin = (float) Math.sin(fArr[0]);
        float cos2 = (float) Math.cos(fArr[1]);
        float sin2 = (float) Math.sin(fArr[1]);
        float cos3 = (float) Math.cos(fArr[2]);
        float sin3 = (float) Math.sin(fArr[2]);
        fArr2[0] = cos2 * cos3;
        fArr2[1] = cos2 * sin3;
        fArr2[2] = -sin2;
        fArr2[3] = 0.0f;
        fArr2[4] = ((cos3 * sin2) * sin) - (cos * sin3);
        float f16 = cos3 * cos;
        fArr2[5] = (sin * sin2 * sin3) + f16;
        fArr2[6] = cos2 * sin;
        fArr2[7] = 0.0f;
        fArr2[8] = (sin3 * sin) + (f16 * sin2);
        fArr2[9] = ((sin2 * cos) * sin3) - (cos3 * sin);
        fArr2[10] = cos * cos2;
        fArr2[11] = 0.0f;
        fArr2[12] = 0.0f;
        fArr2[13] = 0.0f;
        fArr2[14] = 0.0f;
        fArr2[15] = 1.0f;
    }

    public static void calcTransformMatrix(float[] fArr, float[] fArr2, float f16) {
        float cos = (float) Math.cos(fArr[0]);
        float sin = (float) Math.sin(fArr[0]);
        float cos2 = (float) Math.cos(fArr[1]);
        float sin2 = (float) Math.sin(fArr[1]);
        float cos3 = (float) Math.cos(fArr[2]);
        float sin3 = (float) Math.sin(fArr[2]);
        fArr2[0] = cos2 * cos3;
        fArr2[1] = cos2 * sin3;
        fArr2[2] = -sin2;
        fArr2[3] = 0.0f;
        fArr2[4] = ((cos3 * sin2) * sin) - (cos * sin3);
        float f17 = cos3 * cos;
        fArr2[5] = (sin * sin2 * sin3) + f17;
        fArr2[6] = cos2 * sin;
        fArr2[7] = 0.0f;
        fArr2[8] = (sin3 * sin) + (f17 * sin2);
        fArr2[9] = ((sin2 * cos) * sin3) - (cos3 * sin);
        fArr2[10] = cos * cos2;
        fArr2[11] = 0.0f;
        fArr2[12] = fArr[4];
        fArr2[13] = fArr[5];
        fArr2[14] = 0.0f;
        fArr2[15] = 1.0f;
        for (int i3 = 0; i3 < 15; i3++) {
            fArr2[i3] = fArr2[i3] * fArr[3];
        }
        fArr2[0] = fArr2[0] / f16;
        fArr2[4] = fArr2[4] / f16;
        fArr2[8] = fArr2[8] / f16;
        fArr2[12] = fArr2[12] / f16;
        fArr2[1] = fArr2[1] / f16;
        fArr2[5] = fArr2[5] / f16;
        fArr2[9] = fArr2[9] / f16;
        fArr2[13] = fArr2[13] / f16;
    }

    private static double createBrightnessCurve(int i3, int i16, int i17, int i18, int i19, int i26, byte[] bArr, int[] iArr, int[] iArr2) {
        int i27;
        int i28;
        byte[] bArr2 = bArr;
        double[] dArr = new double[3];
        double[] dArr2 = new double[3];
        double[] dArr3 = new double[3];
        double d16 = 0.0d;
        double d17 = 0.0d;
        int i29 = i3;
        while (i29 <= i16) {
            int i36 = i17;
            while (i36 <= i18) {
                int i37 = ((i36 * i19) + i29) * 4;
                if (i37 >= 0 && (i28 = i37 + 2) < bArr2.length) {
                    int i38 = bArr2[i37] & 255;
                    int i39 = bArr2[i37 + 1] & 255;
                    int i46 = bArr2[i28] & 255;
                    int i47 = iArr[i38];
                    int i48 = iArr[i39];
                    int i49 = iArr[i46];
                    dArr[0] = i47;
                    dArr[1] = i48;
                    dArr[2] = i49;
                    sRGB2XYZ(dArr, dArr2);
                    XYZ2Lab(dArr2, dArr3);
                    d17 += dArr3[0];
                    d16 += 1.0d;
                }
                i36++;
                bArr2 = bArr;
            }
            i29++;
            bArr2 = bArr;
        }
        if (d16 == 0.0d) {
            return 60.0d;
        }
        double d18 = d17 / d16;
        if (d18 >= 60.0d && d18 <= 75.0d) {
            resetBrightnessAdjustmentCurve(iArr2);
        } else {
            if (d18 < 60.0d) {
                i27 = (int) (((60.0d - d18) * 1.0d) + 128.0d);
            } else {
                i27 = (int) (((75.0d - d18) * 0.8d) + 128.0d);
            }
            getPreparedSpline(new int[]{0, 128, 255}, new int[]{0, i27, 255}, iArr2);
        }
        return d18;
    }

    private static List<Integer> createFaceAvgColor(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26) {
        int i27;
        double d16 = 0.0d;
        double d17 = 0.0d;
        double d18 = 0.0d;
        int i28 = 0;
        for (int i29 = i3; i29 <= i16; i29++) {
            for (int i36 = i17; i36 <= i18; i36++) {
                int i37 = ((i36 * i19) + i29) * 4;
                if (i37 >= 0 && (i27 = i37 + 2) < bArr.length) {
                    d16 += bArr[i37] & 255;
                    d17 += bArr[i37 + 1] & 255;
                    d18 += bArr[i27] & 255;
                    i28++;
                }
            }
        }
        double d19 = i28;
        return Arrays.asList(Integer.valueOf((int) (d16 / d19)), Integer.valueOf((int) (d17 / d19)), Integer.valueOf((int) (d18 / d19)));
    }

    public static float distanceOfPoint2Line(PointF pointF, PointF pointF2, float f16, PointF pointF3) {
        float distance = getDistance(pointF, pointF3);
        float distance2 = getDistance(pointF2, pointF3);
        float f17 = ((f16 + distance) + distance2) / 2.0f;
        double d16 = (f17 - f16) * f17 * (f17 - distance) * (f17 - distance2);
        if (d16 < 1.0E-6d) {
            return 0.0f;
        }
        return (((float) Math.sqrt(d16)) * 2.0f) / f16;
    }

    public static float[] double2FloatArray(double[] dArr) {
        float[] fArr = new float[dArr.length];
        for (int i3 = 0; i3 < dArr.length; i3++) {
            fArr[i3] = (float) dArr[i3];
        }
        return fArr;
    }

    public static PointF genVector(PointF pointF, PointF pointF2) {
        return new PointF(pointF2.x - pointF.x, pointF2.y - pointF.y);
    }

    public static int getAverageHistogram(byte[] bArr, int i3, int i16) {
        int i17;
        int i18 = 0;
        int i19 = 0;
        for (int i26 = 0; i26 < i3; i26 += 20) {
            for (int i27 = 0; i27 < i16; i27 += 20) {
                int i28 = ((i27 * i3) + i26) * 4;
                if (i28 >= 0 && (i17 = i28 + 2) < bArr.length) {
                    i18 += (int) (((bArr[i28] & 255) * 0.299d) + ((bArr[i28 + 1] & 255) * 0.587d) + ((bArr[i17] & 255) * 0.114d));
                    i19++;
                }
            }
        }
        int i29 = i18 / i19;
        Log.d(TAG, "getAverageHistogram:result:" + i29);
        mAverageHistogram = i29;
        return i29;
    }

    public static PointF getBetweenPoint(PointF pointF, PointF pointF2, float f16) {
        if (pointF != null && pointF2 != null) {
            float f17 = 1.0f - f16;
            return new PointF((pointF.x * f17) + (pointF2.x * f16), (pointF.y * f17) + (pointF2.y * f16));
        }
        return new PointF();
    }

    public static int getBitmapHistogram(String str) {
        Bitmap decodeBitmap = BitmapUtils.decodeBitmap(str, true);
        int width = decodeBitmap.getWidth();
        int height = decodeBitmap.getHeight();
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < height; i17 += 20) {
            for (int i18 = 0; i18 < width; i18 += 20) {
                int pixel = decodeBitmap.getPixel(i18, i17);
                i3 += (int) ((Color.red(pixel) * 0.299d) + (Color.green(pixel) * 0.587d) + (Color.blue(pixel) * 0.114d));
                i16++;
            }
        }
        int i19 = i3 / i16;
        mAverageHistogram = i19;
        return i19;
    }

    public static PointF getCrossPoint(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        boolean z16;
        float f16;
        float f17;
        float f18;
        float f19 = pointF.x;
        float f26 = pointF.y;
        float f27 = pointF2.x;
        float f28 = pointF2.y;
        float f29 = pointF3.x;
        float f36 = pointF3.y;
        float f37 = pointF4.x;
        float f38 = pointF4.y;
        float f39 = f19 - f27;
        boolean z17 = true;
        if (Math.abs(f39) < 1.0E-8d) {
            z16 = true;
        } else {
            z16 = false;
        }
        float f46 = f29 - f37;
        if (Math.abs(f46) >= 1.0E-8d) {
            z17 = false;
        }
        float f47 = Float.MAX_VALUE;
        if (!z16) {
            f16 = (f26 - f28) / f39;
        } else {
            f16 = Float.MAX_VALUE;
        }
        if (!z17) {
            f47 = (f36 - f38) / f46;
        }
        float f48 = f16 - f47;
        if (Math.abs(f48) < 1.0E-8d) {
            return null;
        }
        if (z16) {
            if (z17) {
                return null;
            }
            if (Math.abs(f47) < 1.0E-8d) {
                f18 = f36;
            } else {
                f18 = (f47 * (f19 - f37)) + f38;
            }
            f17 = f19;
        } else if (z17) {
            if (Math.abs(f16) < 1.0E-8d) {
                f18 = f26;
            } else {
                f18 = (f16 * (f29 - f27)) + f28;
            }
            f17 = f29;
        } else if (Math.abs(f16) < 1.0E-8d) {
            f17 = ((f26 - f38) / f47) + f37;
            f18 = f26;
        } else if (Math.abs(f47) < 1.0E-8d) {
            f17 = ((f36 - f28) / f16) + f27;
            f18 = f36;
        } else {
            f17 = ((((f16 * f27) - (f47 * f37)) + f38) - f28) / f48;
            f18 = (f16 * (f17 - f27)) + f28;
        }
        if (!between(f19, f27, f17) || !between(f26, f28, f18) || !between(f29, f37, f17) || !between(f36, f38, f18)) {
            return null;
        }
        return new PointF(f17, f18);
    }

    public static float getDistance(PointF pointF, PointF pointF2) {
        if (pointF == null || pointF2 == null) {
            return 0.0f;
        }
        double d16 = pointF.x - pointF2.x;
        double d17 = pointF.y - pointF2.y;
        return (float) Math.sqrt((d16 * d16) + (d17 * d17));
    }

    public static RectF getFaceRectF(List<PointF> list) {
        if (list != null && list.size() > 0) {
            float f16 = Float.MIN_VALUE;
            float f17 = Float.MAX_VALUE;
            float f18 = Float.MAX_VALUE;
            float f19 = Float.MIN_VALUE;
            for (PointF pointF : list) {
                f17 = Math.min(f17, pointF.x);
                f16 = Math.max(f16, pointF.x);
                f18 = Math.min(f18, pointF.y);
                f19 = Math.max(f19, pointF.y);
            }
            return new RectF(f17, f18, f16, f19);
        }
        return null;
    }

    public static Pair<Integer, int[]> getHistogram(byte[] bArr, int i3, int i16, List<List<PointF>> list, int[] iArr, int[] iArr2) {
        int i17;
        int i18;
        int i19;
        int i26;
        int i27 = 0;
        Arrays.fill(iArr, 0);
        int[] iArr3 = new int[256];
        int[] iArr4 = new int[256];
        Rect rect = new Rect();
        int i28 = 4;
        if (list != null && list.size() > 0 && list.get(0).size() > 0) {
            ArrayList arrayList = new ArrayList(list.get(0));
            int i29 = (int) ((PointF) arrayList.get(25)).x;
            int i36 = (int) ((PointF) arrayList.get(33)).x;
            int i37 = (int) ((PointF) arrayList.get(87)).y;
            int i38 = (int) ((PointF) arrayList.get(4)).y;
            rect.left = i29;
            rect.right = i36;
            rect.top = i37;
            rect.bottom = i38;
        } else {
            rect.left = 0;
            rect.right = i3;
            rect.top = 0;
            rect.bottom = i16;
        }
        int i39 = 0;
        int i46 = 0;
        while (true) {
            byte b16 = 255;
            if (i39 >= i3) {
                break;
            }
            if (i16 > 2560) {
                LogUtils.d("GetHistogram", "illegal imageHeight = " + i16);
                break;
            }
            int i47 = i27;
            while (i47 < i16) {
                int i48 = ((i47 * i3) + i39) * i28;
                if (i48 >= 0 && (i19 = i48 + 2) < bArr.length) {
                    int i49 = bArr[i48] & b16;
                    int i56 = bArr[i48 + 1] & b16;
                    int i57 = bArr[i19] & b16;
                    iArr[i49] = iArr[i49] + 1;
                    iArr[i56] = iArr[i56] + 1;
                    iArr[i57] = iArr[i57] + 1;
                    i46 += 3;
                    int i58 = i47;
                    int i59 = (int) ((i49 * 0.3d) + (i56 * 0.59d) + (i57 * 0.11d));
                    if (i59 >= 256) {
                        i26 = 255;
                    } else {
                        i26 = i59;
                    }
                    iArr4[i26] = iArr4[i26] + 1;
                    i18 = i58;
                    if (rect.contains(i39, i18)) {
                        if (i59 >= 256) {
                            i59 = 255;
                        }
                        iArr3[i59] = iArr3[i59] + 1;
                    }
                } else {
                    i18 = i47;
                }
                i47 = i18 + 2;
                i28 = 4;
                b16 = 255;
            }
            i39 += 2;
            i27 = 0;
            i28 = 4;
        }
        int i65 = 0;
        int i66 = 0;
        for (int i67 = 0; i67 < 256; i67++) {
            int i68 = iArr3[i67];
            i65 += i68;
            i66 += i68 * i67;
        }
        if (i65 > 0) {
            i17 = i66 / i65;
        } else {
            i17 = 255;
        }
        int i69 = 0;
        int i75 = 0;
        int i76 = 255;
        for (int i77 = 0; i77 < 256; i77++) {
            i69 += iArr[i77];
            double d16 = i69;
            double d17 = i46;
            if (d16 >= 0.00105d * d17 && i75 == 0) {
                i75 = i77;
            }
            if (d16 >= d17 * 0.99895d && i76 == 255) {
                i76 = i77;
            }
        }
        int max = Math.max(Math.min(i75, 32), 0);
        int max2 = Math.max(Math.min(i76, 255), 224);
        int i78 = max2 - max;
        int i79 = ((i76 - max) * 255) / i78;
        if (((i75 - max) * 255) / i78 <= i75 && i79 >= i76) {
            for (int i85 = 0; i85 < 256; i85++) {
                if (i85 < max) {
                    iArr2[i85] = 0;
                } else if (i85 > max2) {
                    iArr2[i85] = 255;
                } else {
                    iArr2[i85] = ((i85 - max) * 255) / i78;
                }
            }
        } else {
            for (int i86 = 0; i86 < 256; i86++) {
                iArr2[i86] = i86;
            }
        }
        return Pair.create(Integer.valueOf(i17), iArr4);
    }

    public static RectF getLeftEyeRectF(List<PointF> list) {
        if (list != null && list.size() > 0) {
            float f16 = Float.MIN_VALUE;
            float f17 = Float.MAX_VALUE;
            float f18 = Float.MIN_VALUE;
            float f19 = Float.MAX_VALUE;
            for (int i3 = 19; i3 <= 26; i3++) {
                PointF pointF = list.get(i3);
                f19 = Math.min(f19, pointF.x);
                f16 = Math.max(f16, pointF.x);
                f17 = Math.min(f17, pointF.y);
                f18 = Math.max(f18, pointF.y);
            }
            for (int i16 = 35; i16 <= 44; i16++) {
                PointF pointF2 = list.get(i16);
                f19 = Math.min(f19, pointF2.x);
                f16 = Math.max(f16, pointF2.x);
                f17 = Math.min(f17, pointF2.y);
                f18 = Math.max(f18, pointF2.y);
            }
            return new RectF(f19, f17, f16, f18);
        }
        return null;
    }

    public static void getPreparedSpline(int[] iArr, int[] iArr2, int[] iArr3) {
        char c16;
        if (iArr3 != null && iArr3.length >= 256) {
            for (int i3 = 0; i3 < 256; i3++) {
                iArr3[i3] = i3;
            }
            double[] secondDerivative = secondDerivative(iArr, iArr2);
            int i16 = 0;
            while (i16 < iArr.length - 1) {
                int i17 = iArr[i16];
                int i18 = iArr2[i16];
                int i19 = i16 + 1;
                int i26 = iArr[i19];
                int i27 = iArr2[i19];
                int i28 = i17;
                while (i28 < i26) {
                    double d16 = i26 - i17;
                    double d17 = (i28 - i17) / d16;
                    double d18 = 1.0d - d17;
                    int i29 = i17;
                    int i36 = i18;
                    double d19 = (i18 * d18) + (i27 * d17) + (((d16 * d16) / 6.0d) * (((((d18 * d18) * d18) - d18) * secondDerivative[i16]) + ((((d17 * d17) * d17) - d17) * secondDerivative[i19])));
                    if (i28 >= 0) {
                        c16 = '\u0100';
                        if (i28 < 256) {
                            iArr3[i28] = Math.max(0, Math.min(255, (int) d19));
                        }
                    } else {
                        c16 = '\u0100';
                    }
                    i28++;
                    i17 = i29;
                    i18 = i36;
                }
                i16 = i19;
            }
        }
    }

    public static RectF getRightEyeRectF(List<PointF> list) {
        if (list != null && list.size() > 0) {
            float f16 = Float.MIN_VALUE;
            float f17 = Float.MAX_VALUE;
            float f18 = Float.MIN_VALUE;
            float f19 = Float.MAX_VALUE;
            for (int i3 = 27; i3 <= 34; i3++) {
                PointF pointF = list.get(i3);
                f19 = Math.min(f19, pointF.x);
                f16 = Math.max(f16, pointF.x);
                f17 = Math.min(f17, pointF.y);
                f18 = Math.max(f18, pointF.y);
            }
            for (int i16 = 45; i16 <= 54; i16++) {
                PointF pointF2 = list.get(i16);
                f19 = Math.min(f19, pointF2.x);
                f16 = Math.max(f16, pointF2.x);
                f17 = Math.min(f17, pointF2.y);
                f18 = Math.max(f18, pointF2.y);
            }
            return new RectF(f19, f17, f16, f18);
        }
        return null;
    }

    public static int getmAverageHistogram() {
        return mAverageHistogram;
    }

    public static boolean isFace3DPointsValid(float[] fArr) {
        if (fArr == null || fArr.length < 9 || Float.isNaN(fArr[0])) {
            return false;
        }
        PointF pointF = new PointF(fArr[0], fArr[1]);
        for (int i3 = 0; i3 < fArr.length / 3; i3++) {
            int i16 = i3 * 3;
            if (getDistance(new PointF(fArr[i16], fArr[i16 + 1]), pointF) > 0.001f) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFacePointsValid(List<PointF> list) {
        if (list != null && !list.isEmpty()) {
            PointF pointF = list.get(0);
            Iterator<PointF> it = list.iterator();
            while (it.hasNext()) {
                if (getDistance(it.next(), pointF) > 0.001f) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int is_skin(int i3, int i16, int i17) {
        if (i3 <= 45 || i16 <= 40 || i17 <= 20 || i3 <= i16 || i3 <= i17 || Math.max(Math.max(i3, i16), i17) - Math.min(Math.min(i3, i16), i17) <= 3 || i3 < i16 + 3) {
            return 0;
        }
        return 1;
    }

    public static float[] linearRegression(List<PointF> list) {
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        for (int i3 = 0; i3 < list.size(); i3++) {
            f17 += list.get(i3).x;
            f18 += list.get(i3).y;
        }
        float size = f17 / list.size();
        float size2 = f18 / list.size();
        float f19 = 0.0f;
        for (int i16 = 0; i16 < list.size(); i16++) {
            float f26 = list.get(i16).x - size;
            f16 += (list.get(i16).y - size2) * f26;
            f19 += f26 * f26;
        }
        float f27 = f16 / f19;
        return new float[]{f27, size2 - (size * f27)};
    }

    public static PointF mapPoint(PointF pointF, android.graphics.Matrix matrix) {
        float[] fArr = new float[2];
        matrix.mapPoints(fArr, new float[]{pointF.x, pointF.y});
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        return pointF;
    }

    public static List<PointF> mapPoints(List<PointF> list, android.graphics.Matrix matrix) {
        float[] fArr = new float[2];
        float[] fArr2 = new float[2];
        for (PointF pointF : list) {
            fArr[0] = pointF.x;
            fArr[1] = pointF.y;
            matrix.mapPoints(fArr2, fArr);
            pointF.x = fArr2[0];
            pointF.y = fArr2[1];
        }
        return list;
    }

    public static int[] mergeCurve(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr2 == null) {
            return null;
        }
        int min = Math.min(iArr.length, iArr2.length);
        int[] iArr3 = new int[min];
        for (int i3 = 0; i3 < min; i3++) {
            iArr3[i3] = iArr2[iArr[i3]];
        }
        return iArr3;
    }

    public static PointF middlePoint(PointF pointF, PointF pointF2) {
        if (pointF != null && pointF2 != null) {
            return new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        }
        return new PointF();
    }

    public static native void nativeRotatePlane(byte[] bArr, byte[] bArr2, int i3, int i16, int i17);

    public static native void nativeScalePlane(byte[] bArr, byte[] bArr2, int i3, int i16, float f16, float f17, boolean z16, boolean z17);

    public static int randValueDiff(int i3, int i16) {
        int nextInt;
        if (i16 <= 1) {
            return 1;
        }
        do {
            nextInt = mRandom.nextInt(i16) + 1;
        } while (i3 == nextInt);
        return nextInt;
    }

    public static void resetBrightnessAdjustmentCurve(int[] iArr) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = i3;
        }
    }

    public static float[] rgb2HSV(int i3, int i16, int i17) {
        float[] fArr = new float[3];
        int max = Math.max(Math.max(i3, i16), i17);
        int min = Math.min(Math.min(i3, i16), i17);
        if (max == min) {
            fArr[0] = 0.0f;
        } else if (max == i3 && i16 >= i17) {
            fArr[0] = (((i16 - i17) * 60.0f) / (max - min)) / 360.0f;
        } else if (max == i3) {
            fArr[0] = ((((i16 - i17) * 60.0f) / (max - min)) + 360.0f) / 360.0f;
        } else if (max == i16) {
            fArr[0] = ((((i17 - i3) * 60.0f) / (max - min)) + 120.0f) / 360.0f;
        } else {
            fArr[0] = ((((i3 - i16) * 60.0f) / (max - min)) + 240.0f) / 360.0f;
        }
        float f16 = ((max + min) * 0.5f) / 255.0f;
        fArr[2] = f16;
        if (max == min) {
            fArr[1] = 0.0f;
        } else if (f16 <= 0.5d) {
            fArr[1] = ((max - min) / (f16 * 2.0f)) / 255.0f;
        } else {
            fArr[1] = ((max - min) / (2.0f - (f16 * 2.0f))) / 255.0f;
        }
        return fArr;
    }

    public static Point rotate(int i3, int i16, int i17) {
        if (i17 == 90 || i17 == 270) {
            int i18 = i3 + i16;
            i16 = i18 - i16;
            i3 = i18 - i16;
        }
        return new Point(i3, i16);
    }

    public static List<float[]> rotateAngles(List<float[]> list, int i3) {
        if (list == null) {
            return null;
        }
        int i16 = (i3 + 360) % 360;
        ArrayList arrayList = new ArrayList(list.size());
        for (float[] fArr : list) {
            if (i16 == 90 || i16 == 270) {
                arrayList.add(new float[]{-fArr[1], -fArr[0], (float) (fArr[2] + ((i16 * 3.141592653589793d) / 180.0d))});
            } else {
                arrayList.add(new float[]{fArr[0], fArr[1], (float) (fArr[2] + ((i16 * 3.141592653589793d) / 180.0d))});
            }
        }
        return arrayList;
    }

    public static List<FaceStatus> rotateFaceStatusFor3D(List<FaceStatus> list, int i3, int i16, int i17) {
        if (list != null) {
            for (int i18 = 0; i18 < list.size(); i18++) {
                FaceStatus faceStatus = list.get(i18);
                i17 = (i17 + 360) % 360;
                if (i17 == 90) {
                    float f16 = faceStatus.pitch;
                    faceStatus.pitch = -faceStatus.yaw;
                    faceStatus.yaw = f16;
                    faceStatus.roll += i17;
                } else if (i17 == 180) {
                    faceStatus.pitch = -faceStatus.pitch;
                    faceStatus.yaw = -faceStatus.yaw;
                    faceStatus.roll += i17;
                } else if (i17 == 270) {
                    float f17 = faceStatus.pitch;
                    faceStatus.pitch = faceStatus.yaw;
                    faceStatus.yaw = -f17;
                    faceStatus.roll += i17;
                }
                android.graphics.Matrix matrix = new android.graphics.Matrix();
                matrix.reset();
                matrix.postTranslate((-i3) / 2.0f, (-i16) / 2.0f);
                matrix.postRotate(i17, 0.0f, 0.0f);
                if (i17 != 90 && i17 != 270) {
                    matrix.postTranslate(i3 / 2.0f, i16 / 2.0f);
                } else {
                    matrix.postTranslate(i16 / 2.0f, i3 / 2.0f);
                }
                float[] fArr = new float[2];
                matrix.mapPoints(fArr, new float[]{faceStatus.f381696tx, faceStatus.f381697ty});
                faceStatus.f381696tx = fArr[0];
                faceStatus.f381697ty = fArr[1];
            }
        }
        return list;
    }

    public static PointF rotatePoint(PointF pointF, int i3, int i16, int i17) {
        if (pointF == null) {
            return null;
        }
        int i18 = (i17 + 360) % 360;
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.reset();
        matrix.postTranslate((-i3) / 2.0f, (-i16) / 2.0f);
        matrix.postRotate(i18, 0.0f, 0.0f);
        if (i18 != 90 && i18 != 270) {
            matrix.postTranslate(i3 / 2.0f, i16 / 2.0f);
        } else {
            matrix.postTranslate(i16 / 2.0f, i3 / 2.0f);
        }
        float[] fArr = new float[2];
        matrix.mapPoints(fArr, new float[]{pointF.x, pointF.y});
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        return pointF;
    }

    public static List<PointF> rotatePoints(List<PointF> list, int i3, int i16, int i17) {
        if (list == null) {
            return null;
        }
        int i18 = (i17 + 360) % 360;
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.reset();
        matrix.postTranslate((-i3) / 2.0f, (-i16) / 2.0f);
        matrix.postRotate(i18, 0.0f, 0.0f);
        if (i18 != 90 && i18 != 270) {
            matrix.postTranslate(i3 / 2.0f, i16 / 2.0f);
        } else {
            matrix.postTranslate(i16 / 2.0f, i3 / 2.0f);
        }
        float[] fArr = new float[2];
        float[] fArr2 = new float[2];
        for (PointF pointF : list) {
            fArr[0] = pointF.x;
            fArr[1] = pointF.y;
            matrix.mapPoints(fArr2, fArr);
            pointF.x = fArr2[0];
            pointF.y = fArr2[1];
        }
        return list;
    }

    public static List<float[]> rotatePointsForFloat3DList(List<float[]> list, int i3, int i16, int i17, int i18) {
        if (i18 == 0) {
            return list;
        }
        if (list != null && i3 > 0) {
            for (int i19 = 0; i19 < list.size(); i19++) {
                float[] fArr = list.get(i19);
                if (fArr != null && fArr.length >= i3 * 3) {
                    i18 = (i18 + 360) % 360;
                    for (int i26 = 0; i26 < fArr.length; i26 += 3) {
                        if (i18 == 90) {
                            int i27 = i26 + 1;
                            float f16 = fArr[i27];
                            float f17 = (i16 - 1) - fArr[i26];
                            fArr[i26] = f16;
                            fArr[i27] = f17;
                        } else if (i18 == 180) {
                            float f18 = (i16 - 1) - fArr[i26];
                            int i28 = i26 + 1;
                            float f19 = (i17 - 1) - fArr[i28];
                            fArr[i26] = f18;
                            fArr[i28] = f19;
                        } else if (i18 == 270) {
                            int i29 = i26 + 1;
                            float f26 = (i17 - 1) - fArr[i29];
                            float f27 = fArr[i26];
                            fArr[i26] = f26;
                            fArr[i29] = f27;
                        }
                    }
                }
            }
        }
        return list;
    }

    public static List<List<PointF>> rotatePointsForList(List<List<PointF>> list, int i3, int i16, int i17) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<List<PointF>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(rotatePoints(it.next(), i3, i16, i17));
        }
        return arrayList;
    }

    public static void sRGB2XYZ(double[] dArr, double[] dArr2) {
        double pow;
        double pow2;
        double pow3;
        double d16 = dArr[0];
        double d17 = d16 / 255.0d;
        double d18 = dArr[1] / 255.0d;
        double d19 = dArr[2] / 255.0d;
        if (d17 <= 0.04045d) {
            pow = d17 / 12.92d;
        } else {
            pow = Math.pow((d17 + 0.055d) / 1.055d, 2.4d);
        }
        if (d18 <= 0.04045d) {
            pow2 = d18 / 12.92d;
        } else {
            pow2 = Math.pow((d18 + 0.055d) / 1.055d, 2.4d);
        }
        if (d19 <= 0.04045d) {
            pow3 = d19 / 12.92d;
        } else {
            pow3 = Math.pow((d19 + 0.055d) / 1.055d, 2.4d);
        }
        dArr2[0] = (41.24d * pow) + (35.76d * pow2) + (18.05d * pow3);
        dArr2[1] = (21.26d * pow) + (71.52d * pow2) + (7.2d * pow3);
        dArr2[2] = (pow * 1.93d) + (pow2 * 11.92d) + (pow3 * 95.05d);
    }

    public static boolean samePeople(List<PointF> list, List<PointF> list2) {
        if (list.size() < 83 || list2.size() < 83) {
            return false;
        }
        PointF pointF = new PointF((list.get(0).x + list.get(18).x) / 2.0f, (list.get(0).y + list.get(18).y) / 2.0f);
        PointF pointF2 = new PointF((list2.get(0).x + list2.get(18).x) / 2.0f, (list2.get(0).y + list2.get(18).y) / 2.0f);
        if (getDistance(pointF, pointF2) >= Math.min(getDistance(list.get(0), list.get(18)), getDistance(list2.get(0), list2.get(18))) * 0.5f) {
            return false;
        }
        return true;
    }

    private static double[] secondDerivative(int[] iArr, int[] iArr2) {
        int i3;
        int length = iArr.length;
        char c16 = 1;
        char c17 = 0;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 3);
        double[] dArr2 = new double[length];
        dArr[0][1] = 1.0d;
        int i16 = 1;
        while (true) {
            i3 = length - 1;
            if (i16 >= i3) {
                break;
            }
            double[] dArr3 = dArr[i16];
            int i17 = iArr[i16];
            int i18 = iArr[i16 - 1];
            dArr3[c17] = (i17 - i18) / 6.0d;
            int i19 = i16 + 1;
            int i26 = iArr[i19];
            dArr3[c16] = (i26 - i18) / 3.0d;
            dArr3[2] = (i26 - i17) / 6.0d;
            int i27 = iArr2[i19];
            int i28 = iArr2[i16];
            dArr2[i16] = ((i27 - i28) / (i26 - i17)) - ((i28 - iArr2[r12]) / (i17 - i18));
            i16 = i19;
            c16 = 1;
            c17 = 0;
        }
        char c18 = 1;
        dArr[i3][1] = 1.0d;
        int i29 = 1;
        while (i29 < length) {
            double[] dArr4 = dArr[i29];
            double d16 = dArr4[0];
            int i36 = i29 - 1;
            double[] dArr5 = dArr[i36];
            double d17 = d16 / dArr5[c18];
            dArr4[c18] = dArr4[c18] - (dArr5[2] * d17);
            dArr4[0] = 0.0d;
            dArr2[i29] = dArr2[i29] - (d17 * dArr2[i36]);
            i29++;
            c18 = 1;
        }
        for (int i37 = length - 2; i37 >= 0; i37--) {
            double[] dArr6 = dArr[i37];
            double d18 = dArr6[2];
            int i38 = i37 + 1;
            double[] dArr7 = dArr[i38];
            double d19 = d18 / dArr7[1];
            dArr6[1] = dArr6[1] - (dArr7[0] * d19);
            dArr6[2] = 0.0d;
            dArr2[i37] = dArr2[i37] - (d19 * dArr2[i38]);
        }
        double[] dArr8 = new double[length];
        for (int i39 = 0; i39 < length; i39++) {
            dArr8[i39] = dArr2[i39] / dArr[i39][1];
        }
        return dArr8;
    }

    public static double spacing(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 2) {
            float x16 = motionEvent.getX(0) - motionEvent.getX(1);
            float y16 = motionEvent.getY(0) - motionEvent.getY(1);
            return Math.sqrt((x16 * x16) + (y16 * y16));
        }
        return 0.0d;
    }

    public static List<Float> substract(List<Float> list, float[] fArr) {
        ArrayList arrayList = new ArrayList();
        if (list != null && fArr != null) {
            for (int i3 = 0; i3 < Math.min(list.size(), fArr.length); i3++) {
                arrayList.add(Float.valueOf(list.get(i3).floatValue() - fArr[i3]));
            }
        }
        return arrayList;
    }

    public static float[] calPositions(com.tencent.ttpic.openapi.model.Rect rect, int i3, int i16, int i17, int i18, int i19) {
        if (i19 == FILL_STYLE.SPACE.value) {
            SizeI calSpaceAspectSize = calSpaceAspectSize(i3, i16, rect.width, rect.height);
            return calPositions(rect.f381702x + ((rect.width - calSpaceAspectSize.width) / 2), r8 + r12, r0 + r9, rect.f381703y + ((rect.height - calSpaceAspectSize.height) / 2), i17, i18);
        }
        return calPositions(rect.f381702x, rect.height + r9, rect.width + r8, rect.f381703y, i17, i18);
    }

    public static float[] calTexCoords(int i3, int i16, double d16) {
        int i17;
        int i18;
        int i19;
        int i26;
        double d17 = i3;
        double d18 = i16;
        if (d17 / d18 >= d16) {
            int i27 = (int) (d18 * d16);
            int i28 = (i3 - i27) / 2;
            i26 = i27 + i28;
            i18 = i28;
            i17 = 0;
            i19 = i16;
        } else {
            int i29 = (int) (d17 / d16);
            int i36 = (i16 - i29) / 2;
            i17 = i36;
            i18 = 0;
            i19 = i29 + i36;
            i26 = i3;
        }
        float f16 = i3;
        float f17 = i18 / f16;
        float f18 = i26 / f16;
        float f19 = i16;
        float f26 = i19 / f19;
        float f27 = i17 / f19;
        return new float[]{f17, f27, f17, f26, f18, f26, f18, f27};
    }

    public static float getDistance(float[] fArr, float[] fArr2) {
        if (fArr == null || fArr2 == null) {
            return 0.0f;
        }
        double d16 = fArr[0] - fArr2[0];
        double d17 = fArr[1] - fArr2[1];
        return (float) Math.sqrt((d16 * d16) + (d17 * d17));
    }

    public static int[] mergeCurve(int[] iArr, int[] iArr2, float f16, float f17) {
        if (iArr == null || iArr2 == null) {
            return null;
        }
        int min = Math.min(iArr.length, iArr2.length);
        int[] iArr3 = new int[min];
        for (int i3 = 0; i3 < min; i3++) {
            int i16 = (int) ((iArr[i3] * f16) + (i3 * (1.0f - f16)));
            if (i16 < 0) {
                i16 = 0;
            }
            iArr3[i3] = (int) ((iArr2[i16] * f17) + (i16 * (1.0f - f17)));
        }
        return iArr3;
    }

    public static float[] adjustPosition(float[] fArr, float f16, double[] dArr, int i3) {
        int i16 = 0;
        float f17 = fArr[0];
        float f18 = f17 + ((fArr[4] - f17) * ((float) dArr[0]));
        float f19 = fArr[3];
        float f26 = f19 + ((fArr[1] - f19) * ((float) dArr[1]));
        if (i3 == 0) {
            while (i16 < fArr.length / 2) {
                int i17 = i16 * 2;
                fArr[i17] = ((fArr[i17] - f18) * f16) + f18;
                int i18 = i17 + 1;
                fArr[i18] = ((fArr[i18] - f26) * f16) + f26;
                i16++;
            }
        } else if (i3 == 1) {
            while (i16 < fArr.length / 2) {
                int i19 = (i16 * 2) + 1;
                fArr[i19] = ((fArr[i19] - f26) * f16) + f26;
                i16++;
            }
        } else if (i3 == 2) {
            while (i16 < fArr.length / 2) {
                int i26 = i16 * 2;
                fArr[i26] = ((fArr[i26] - f18) * f16) + f18;
                i16++;
            }
        }
        return fArr;
    }

    public static float[] calTexCoords(int i3, int i16, int i17, double d16) {
        int i18;
        int i19;
        int i26;
        int i27;
        if (i17 == 90 || i17 == 270) {
            i16 = i3;
            i3 = i16;
        }
        double d17 = i3;
        double d18 = i16;
        if (d17 / d18 >= d16) {
            int i28 = (int) (d18 * d16);
            int i29 = (i3 - i28) / 2;
            i27 = i28 + i29;
            i19 = i29;
            i18 = 0;
            i26 = i16;
        } else {
            int i36 = (int) (d17 / d16);
            int i37 = (i16 - i36) / 2;
            i18 = i37;
            i19 = 0;
            i26 = i36 + i37;
            i27 = i3;
        }
        float f16 = i3;
        float f17 = i19 / f16;
        float f18 = i27 / f16;
        float f19 = i16;
        float f26 = i26 / f19;
        float f27 = i18 / f19;
        return new float[]{f17, f27, f17, f26, f18, f26, f18, f27};
    }

    public static float[] rotateAngles(float[] fArr, int i3) {
        float[] fArr2 = new float[3];
        if (fArr == null) {
            return fArr2;
        }
        int i16 = (i3 + 360) % 360;
        return (i16 == 90 || i16 == 270) ? new float[]{-fArr[1], -fArr[0], (float) (fArr[2] + ((i16 * 3.141592653589793d) / 180.0d))} : new float[]{fArr[0], fArr[1], (float) (fArr[2] + ((i16 * 3.141592653589793d) / 180.0d))};
    }
}
