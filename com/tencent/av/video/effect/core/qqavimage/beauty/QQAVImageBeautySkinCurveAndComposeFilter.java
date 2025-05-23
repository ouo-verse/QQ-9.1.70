package com.tencent.av.video.effect.core.qqavimage.beauty;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoInputFilter;
import com.tencent.filter.GLSLRender;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageBeautySkinCurveAndComposeFilter extends QQAVImageTwoInputFilter {
    private List<Double> mBlueCurve;
    private List<Double> mGreenCurve;
    private float mMixPercent;
    private int mMixPercentUniform;
    private List<Double> mRedCurve;
    private List<Double> mRgbCompositeCurve;
    private byte[] mToneCurveByteArray;
    private ByteBuffer mToneCurveDataBuffer;
    private int mToneCurveTexture;
    private int mToneCurveTextureUniform;

    public QQAVImageBeautySkinCurveAndComposeFilter() {
        super(String.valueOf(5));
        this.mToneCurveTexture = -1;
        this.mMixPercent = 0.3f;
        this.mToneCurveDataBuffer = null;
        this.mToneCurveByteArray = new byte[1024];
        this.mToneCurveDataBuffer = ByteBuffer.allocate(1024);
    }

    private List<Double> getPreparedSplineCurve(List<PointF> list) {
        if (list != null && list.size() > 0) {
            Collections.sort(list, new Comparator<PointF>() { // from class: com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautySkinCurveAndComposeFilter.1
                @Override // java.util.Comparator
                public int compare(PointF pointF, PointF pointF2) {
                    float f16 = pointF.x;
                    float f17 = pointF2.x;
                    if (f16 > f17) {
                        return 1;
                    }
                    return f16 == f17 ? 0 : -1;
                }
            });
            ArrayList arrayList = new ArrayList(list.size());
            for (int i3 = 0; i3 < list.size(); i3++) {
                arrayList.add(new PointF(list.get(i3).x * 255.0f, list.get(i3).y * 255.0f));
            }
            List<PointF> splineCurve = splineCurve(arrayList);
            float f16 = splineCurve.get(0).x;
            if (f16 > 0.0f) {
                for (int i16 = (int) f16; i16 >= 0; i16--) {
                    splineCurve.add(0, new PointF(i16, 0.0f));
                }
            }
            float f17 = splineCurve.get(splineCurve.size() - 1).x;
            if (f17 < 255.0f) {
                for (int i17 = (int) (f17 + 1.0f); i17 <= 255; i17++) {
                    splineCurve.add(new PointF(i17, 255.0f));
                }
            }
            ArrayList arrayList2 = new ArrayList(splineCurve.size());
            for (int i18 = 0; i18 < splineCurve.size(); i18++) {
                PointF pointF = splineCurve.get(i18);
                float f18 = pointF.x;
                PointF pointF2 = new PointF(f18, f18);
                double sqrt = Math.sqrt(Math.pow(pointF2.x - pointF.x, 2.0d) + Math.pow(pointF2.y - pointF.y, 2.0d));
                if (pointF2.y > pointF.y) {
                    sqrt = -sqrt;
                }
                arrayList2.add(Double.valueOf(sqrt));
            }
            return arrayList2;
        }
        return null;
    }

    private List<Double> secondDerivative(List<PointF> list) {
        int i3;
        int size = list.size();
        if (size > 0) {
            char c16 = 1;
            if (size != 1) {
                char c17 = 2;
                char c18 = 0;
                double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
                double[] dArr2 = new double[size];
                double[] dArr3 = dArr[0];
                dArr3[1] = 1.0d;
                double d16 = 0.0d;
                dArr3[0] = 0.0d;
                dArr3[2] = 0.0d;
                int i16 = 1;
                while (true) {
                    i3 = size - 1;
                    if (i16 >= i3) {
                        break;
                    }
                    PointF pointF = list.get(i16 - 1);
                    PointF pointF2 = list.get(i16);
                    int i17 = i16 + 1;
                    PointF pointF3 = list.get(i17);
                    double[] dArr4 = dArr[i16];
                    float f16 = pointF2.x;
                    float f17 = pointF.x;
                    dArr4[c18] = (f16 - f17) / 6.0d;
                    float f18 = pointF3.x;
                    double[] dArr5 = dArr2;
                    dArr4[c16] = (f18 - f17) / 3.0d;
                    dArr4[c17] = (f18 - f16) / 6.0d;
                    float f19 = pointF3.y;
                    float f26 = pointF2.y;
                    dArr5[i16] = ((f19 - f26) / (f18 - f16)) - ((f26 - pointF.y) / (f16 - f17));
                    i16 = i17;
                    dArr2 = dArr5;
                    c16 = 1;
                    c17 = 2;
                    c18 = 0;
                    d16 = 0.0d;
                }
                double[] dArr6 = dArr2;
                double d17 = d16;
                dArr6[c18] = d17;
                dArr6[i3] = d17;
                double[] dArr7 = dArr[i3];
                char c19 = 1;
                dArr7[1] = 1.0d;
                dArr7[c18] = d17;
                char c26 = 2;
                dArr7[2] = d17;
                int i18 = 1;
                while (i18 < size) {
                    double[] dArr8 = dArr[i18];
                    double d18 = dArr8[c18];
                    int i19 = i18 - 1;
                    double[] dArr9 = dArr[i19];
                    double d19 = d18 / dArr9[c19];
                    dArr8[c19] = dArr8[c19] - (dArr9[c26] * d19);
                    dArr8[c18] = 0.0d;
                    dArr6[i18] = dArr6[i18] - (d19 * dArr6[i19]);
                    i18++;
                    c18 = 0;
                    c26 = 2;
                    c19 = 1;
                }
                for (int i26 = size - 2; i26 >= 0; i26--) {
                    double[] dArr10 = dArr[i26];
                    double d26 = dArr10[2];
                    int i27 = i26 + 1;
                    double[] dArr11 = dArr[i27];
                    double d27 = d26 / dArr11[1];
                    dArr10[1] = dArr10[1] - (dArr11[0] * d27);
                    dArr10[2] = 0.0d;
                    dArr6[i26] = dArr6[i26] - (d27 * dArr6[i27]);
                }
                double[] dArr12 = new double[size];
                for (int i28 = 0; i28 < size; i28++) {
                    dArr12[i28] = dArr6[i28] / dArr[i28][1];
                }
                ArrayList arrayList = new ArrayList(size);
                for (int i29 = 0; i29 < size; i29++) {
                    arrayList.add(Double.valueOf(dArr12[i29]));
                }
                return arrayList;
            }
            return null;
        }
        return null;
    }

    private List<PointF> splineCurve(List<PointF> list) {
        List<PointF> list2 = list;
        List<Double> secondDerivative = secondDerivative(list);
        int size = secondDerivative.size();
        if (size < 1) {
            return null;
        }
        double[] dArr = new double[size];
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            dArr[i16] = secondDerivative.get(i16).doubleValue();
        }
        ArrayList arrayList = new ArrayList(size + 1);
        while (i3 < size - 1) {
            PointF pointF = list2.get(i3);
            int i17 = i3 + 1;
            PointF pointF2 = list2.get(i17);
            int i18 = (int) pointF.x;
            while (true) {
                float f16 = pointF2.x;
                if (i18 < ((int) f16)) {
                    float f17 = i18;
                    double[] dArr2 = dArr;
                    double d16 = (f17 - r12) / (f16 - r12);
                    double d17 = 1.0d - d16;
                    float f18 = f16 - pointF.x;
                    int i19 = i18;
                    double d18 = f18;
                    ArrayList arrayList2 = arrayList;
                    double d19 = (pointF.y * d17) + (pointF2.y * d16) + (((d18 * d18) / 6.0d) * (((((d17 * d17) * d17) - d17) * dArr2[i3]) + ((((d16 * d16) * d16) - d16) * dArr2[i17])));
                    double d26 = 255.0d;
                    if (d19 <= 255.0d) {
                        d26 = 0.0d;
                        if (d19 >= 0.0d) {
                            arrayList2.add(new PointF(f17, (float) d19));
                            i18 = i19 + 1;
                            arrayList = arrayList2;
                            dArr = dArr2;
                        }
                    }
                    d19 = d26;
                    arrayList2.add(new PointF(f17, (float) d19));
                    i18 = i19 + 1;
                    arrayList = arrayList2;
                    dArr = dArr2;
                }
            }
            list2 = list;
            i3 = i17;
        }
        ArrayList arrayList3 = arrayList;
        arrayList3.add(list.get(list.size() - 1));
        return arrayList3;
    }

    private void updateToneCurveTexture() {
        List<Double> list;
        List<Double> list2;
        List<Double> list3;
        List<Double> list4 = this.mRedCurve;
        if (list4 != null) {
            if (list4.size() >= 256 && (list = this.mGreenCurve) != null && list.size() >= 256 && (list2 = this.mBlueCurve) != null && list2.size() >= 256 && (list3 = this.mRgbCompositeCurve) != null && list3.size() >= 256) {
                int i3 = 0;
                for (int i16 = 256; i3 < i16; i16 = 256) {
                    double d16 = i3;
                    int i17 = i3 * 4;
                    double min = (short) Math.min(Math.max(this.mBlueCurve.get(i3).doubleValue() + d16, 0.0d), 255.0d);
                    this.mToneCurveByteArray[i17] = (byte) Math.min(Math.max(min + this.mRgbCompositeCurve.get(r7).doubleValue(), 0.0d), 255.0d);
                    this.mToneCurveByteArray[i17 + 1] = (byte) Math.min(Math.max(min + this.mRgbCompositeCurve.get((short) Math.min(Math.max(this.mGreenCurve.get(i3).doubleValue() + d16, 0.0d), 255.0d)).doubleValue(), 0.0d), 255.0d);
                    this.mToneCurveByteArray[i17 + 2] = (byte) Math.min(Math.max(min + this.mRgbCompositeCurve.get((short) Math.min(Math.max(d16 + this.mRedCurve.get(i3).doubleValue(), 0.0d), 255.0d)).doubleValue(), 0.0d), 255.0d);
                    this.mToneCurveByteArray[i17 + 3] = -1;
                    i3++;
                }
                this.mToneCurveDataBuffer.position(0);
                ByteBuffer byteBuffer = this.mToneCurveDataBuffer;
                byte[] bArr = this.mToneCurveByteArray;
                byteBuffer.put(bArr, 0, bArr.length);
                this.mToneCurveDataBuffer.position(0);
                if (this.mToneCurveTexture == -1) {
                    GLES20.glActiveTexture(33985);
                    GLES20.glGenTextures(1, new int[]{this.mToneCurveTexture}, 0);
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mToneCurveTexture);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                    GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                } else {
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mToneCurveTexture);
                }
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, 256, 1, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.mToneCurveDataBuffer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoInputFilter, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDrawArraysAfter() {
        super.onDrawArraysAfter();
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glActiveTexture(33984);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoInputFilter, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDrawArraysPre() {
        super.onDrawArraysPre();
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mToneCurveTexture);
        GLES20.glUniform1i(this.mToneCurveTextureUniform, 1);
        GLES20.glUniform1f(this.mMixPercentUniform, this.mMixPercent);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoInputFilter, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mToneCurveTextureUniform = GLES20.glGetUniformLocation(getProgram(), "toneCurveTexture");
        this.mMixPercentUniform = GLES20.glGetUniformLocation(getProgram(), "mixPercent");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PointF(0.0f, 0.0f));
        arrayList.add(new PointF(0.5f, 0.5f));
        arrayList.add(new PointF(1.0f, 1.0f));
        setRedControlPoints(arrayList);
        setGreenControlPoints(arrayList);
        setBlueControlPoints(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new PointF(0.0f, 0.0f));
        arrayList2.add(new PointF(0.54901963f, 0.61960787f));
        arrayList2.add(new PointF(1.0f, 1.0f));
        setRgbCompositeControlPoints(arrayList2);
    }

    public void setBlueControlPoints(List<PointF> list) {
        this.mBlueCurve = getPreparedSplineCurve(list);
        updateToneCurveTexture();
    }

    public void setGreenControlPoints(List<PointF> list) {
        this.mGreenCurve = getPreparedSplineCurve(list);
        updateToneCurveTexture();
    }

    public void setMixPercent(float f16) {
        this.mMixPercent = f16;
    }

    public void setRedControlPoints(List<PointF> list) {
        this.mRedCurve = getPreparedSplineCurve(list);
        updateToneCurveTexture();
    }

    public void setRgbCompositeControlPoints(List<PointF> list) {
        this.mRgbCompositeCurve = getPreparedSplineCurve(list);
        updateToneCurveTexture();
    }
}
