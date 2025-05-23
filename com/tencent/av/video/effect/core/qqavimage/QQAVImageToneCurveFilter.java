package com.tencent.av.video.effect.core.qqavimage;

import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageToneCurveFilter extends QQAVImageFilter {
    private PointF[] mBlueControlPoints;
    private ArrayList<Float> mBlueCurve;
    private PointF[] mGreenControlPoints;
    private ArrayList<Float> mGreenCurve;
    private PointF[] mRedControlPoints;
    private ArrayList<Float> mRedCurve;
    private PointF[] mRgbCompositeControlPoints;
    private ArrayList<Float> mRgbCompositeCurve;
    private int[] mToneCurveTexture;
    private int mToneCurveTextureUniformLocation;

    public QQAVImageToneCurveFilter() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", String.valueOf(23));
        this.mToneCurveTexture = new int[]{-1};
        PointF[] pointFArr = {new PointF(0.0f, 0.0f), new PointF(0.5f, 0.5f), new PointF(1.0f, 1.0f)};
        this.mRgbCompositeControlPoints = pointFArr;
        this.mRedControlPoints = pointFArr;
        this.mGreenControlPoints = pointFArr;
        this.mBlueControlPoints = pointFArr;
    }

    private ArrayList<Double> createSecondDerivative(Point[] pointArr) {
        int i3;
        int length = pointArr.length;
        char c16 = 1;
        if (length <= 1) {
            return null;
        }
        char c17 = 2;
        char c18 = 0;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 3);
        double[] dArr2 = new double[length];
        double[] dArr3 = dArr[0];
        dArr3[1] = 1.0d;
        double d16 = 0.0d;
        dArr3[0] = 0.0d;
        dArr3[2] = 0.0d;
        int i16 = 1;
        while (true) {
            i3 = length - 1;
            if (i16 >= i3) {
                break;
            }
            Point point = pointArr[i16 - 1];
            Point point2 = pointArr[i16];
            int i17 = i16 + 1;
            Point point3 = pointArr[i17];
            double[] dArr4 = dArr[i16];
            int i18 = point2.x;
            int i19 = point.x;
            dArr4[c18] = (i18 - i19) / 6.0d;
            int i26 = point3.x;
            double[] dArr5 = dArr2;
            dArr4[c16] = (i26 - i19) / 3.0d;
            dArr4[c17] = (i26 - i18) / 6.0d;
            int i27 = point3.y;
            int i28 = point2.y;
            dArr5[i16] = ((i27 - i28) / (i26 - i18)) - ((i28 - point.y) / (i18 - i19));
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
        int i29 = 1;
        while (i29 < length) {
            double[] dArr8 = dArr[i29];
            double d18 = dArr8[c18];
            int i36 = i29 - 1;
            double[] dArr9 = dArr[i36];
            double d19 = d18 / dArr9[c19];
            dArr8[c19] = dArr8[c19] - (dArr9[c26] * d19);
            dArr8[c18] = 0.0d;
            dArr6[i29] = dArr6[i29] - (d19 * dArr6[i36]);
            i29++;
            c18 = 0;
            c26 = 2;
            c19 = 1;
        }
        for (int i37 = length - 2; i37 >= 0; i37--) {
            double[] dArr10 = dArr[i37];
            double d26 = dArr10[2];
            int i38 = i37 + 1;
            double[] dArr11 = dArr[i38];
            double d27 = d26 / dArr11[1];
            dArr10[1] = dArr10[1] - (dArr11[0] * d27);
            dArr10[2] = 0.0d;
            dArr6[i37] = dArr6[i37] - (d27 * dArr6[i38]);
        }
        ArrayList<Double> arrayList = new ArrayList<>(length);
        for (int i39 = 0; i39 < length; i39++) {
            arrayList.add(Double.valueOf(dArr6[i39] / dArr[i39][1]));
        }
        return arrayList;
    }

    private ArrayList<Float> createSplineCurve(PointF[] pointFArr) {
        ArrayList<Float> arrayList = null;
        if (pointFArr != null && pointFArr.length > 0) {
            PointF[] pointFArr2 = (PointF[]) pointFArr.clone();
            Arrays.sort(pointFArr2, new Comparator<PointF>() { // from class: com.tencent.av.video.effect.core.qqavimage.QQAVImageToneCurveFilter.2
                @Override // java.util.Comparator
                public int compare(PointF pointF, PointF pointF2) {
                    float f16 = pointF.x;
                    float f17 = pointF2.x;
                    if (f16 < f17) {
                        return -1;
                    }
                    return f16 > f17 ? 1 : 0;
                }
            });
            Point[] pointArr = new Point[pointFArr2.length];
            for (int i3 = 0; i3 < pointFArr.length; i3++) {
                PointF pointF = pointFArr2[i3];
                pointArr[i3] = new Point((int) (pointF.x * 255.0f), (int) (pointF.y * 255.0f));
            }
            ArrayList<Point> createSplineCurve2 = createSplineCurve2(pointArr);
            if (createSplineCurve2 == null) {
                return null;
            }
            int i16 = createSplineCurve2.get(0).x;
            if (i16 > 0) {
                while (i16 >= 0) {
                    createSplineCurve2.add(0, new Point(i16, 0));
                    i16--;
                }
            }
            int i17 = createSplineCurve2.get(createSplineCurve2.size() - 1).x;
            if (i17 < 255) {
                while (true) {
                    i17++;
                    if (i17 > 255) {
                        break;
                    }
                    createSplineCurve2.add(new Point(i17, 255));
                }
            }
            arrayList = new ArrayList<>(createSplineCurve2.size());
            Iterator<Point> it = createSplineCurve2.iterator();
            while (it.hasNext()) {
                Point next = it.next();
                int i18 = next.x;
                Point point = new Point(i18, i18);
                float sqrt = (float) Math.sqrt(Math.pow(point.x - next.x, 2.0d) + Math.pow(point.y - next.y, 2.0d));
                if (point.y > next.y) {
                    sqrt = -sqrt;
                }
                arrayList.add(Float.valueOf(sqrt));
            }
        }
        return arrayList;
    }

    private ArrayList<Point> createSplineCurve2(Point[] pointArr) {
        int size;
        Point[] pointArr2 = pointArr;
        ArrayList<Double> createSecondDerivative = createSecondDerivative(pointArr);
        if (createSecondDerivative == null || (size = createSecondDerivative.size()) < 1) {
            return null;
        }
        double[] dArr = new double[size];
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            dArr[i16] = createSecondDerivative.get(i16).doubleValue();
        }
        ArrayList<Point> arrayList = new ArrayList<>(size + 1);
        while (i3 < size - 1) {
            Point point = pointArr2[i3];
            int i17 = i3 + 1;
            Point point2 = pointArr2[i17];
            int i18 = point.x;
            while (true) {
                int i19 = point2.x;
                if (i18 < i19) {
                    double d16 = (i18 - r11) / (i19 - r11);
                    double d17 = 1.0d - d16;
                    double d18 = i19 - point.x;
                    int i26 = size;
                    Point point3 = point;
                    ArrayList<Point> arrayList2 = arrayList;
                    double d19 = (point.y * d17) + (point2.y * d16) + (((d18 * d18) / 6.0d) * (((((d17 * d17) * d17) - d17) * dArr[i3]) + ((((d16 * d16) * d16) - d16) * dArr[i17])));
                    double d26 = 255.0d;
                    if (d19 <= 255.0d) {
                        d26 = 0.0d;
                        if (d19 >= 0.0d) {
                            arrayList = arrayList2;
                            arrayList.add(new Point(i18, (int) Math.round(d19)));
                            i18++;
                            size = i26;
                            point = point3;
                        }
                    }
                    d19 = d26;
                    arrayList = arrayList2;
                    arrayList.add(new Point(i18, (int) Math.round(d19)));
                    i18++;
                    size = i26;
                    point = point3;
                }
            }
            pointArr2 = pointArr;
            i3 = i17;
        }
        if (arrayList.size() == 255) {
            arrayList.add(pointArr[pointArr.length - 1]);
        }
        return arrayList;
    }

    private short readShort(InputStream inputStream) throws IOException {
        return (short) (inputStream.read() | (inputStream.read() << 8));
    }

    private void updateToneCurveTexture() {
        runOnDraw(new Runnable() { // from class: com.tencent.av.video.effect.core.qqavimage.QQAVImageToneCurveFilter.1
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glActiveTexture(33987);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, QQAVImageToneCurveFilter.this.mToneCurveTexture[0]);
                if (QQAVImageToneCurveFilter.this.mRedCurve.size() >= 256 && QQAVImageToneCurveFilter.this.mGreenCurve.size() >= 256 && QQAVImageToneCurveFilter.this.mBlueCurve.size() >= 256 && QQAVImageToneCurveFilter.this.mRgbCompositeCurve.size() >= 256) {
                    byte[] bArr = new byte[1024];
                    for (int i3 = 0; i3 < 256; i3++) {
                        int i16 = i3 * 4;
                        float f16 = i3;
                        bArr[i16 + 2] = (byte) (((int) Math.min(Math.max(((Float) QQAVImageToneCurveFilter.this.mBlueCurve.get(i3)).floatValue() + f16 + ((Float) QQAVImageToneCurveFilter.this.mRgbCompositeCurve.get(i3)).floatValue(), 0.0f), 255.0f)) & 255);
                        bArr[i16 + 1] = (byte) (((int) Math.min(Math.max(((Float) QQAVImageToneCurveFilter.this.mGreenCurve.get(i3)).floatValue() + f16 + ((Float) QQAVImageToneCurveFilter.this.mRgbCompositeCurve.get(i3)).floatValue(), 0.0f), 255.0f)) & 255);
                        bArr[i16] = (byte) (((int) Math.min(Math.max(f16 + ((Float) QQAVImageToneCurveFilter.this.mRedCurve.get(i3)).floatValue() + ((Float) QQAVImageToneCurveFilter.this.mRgbCompositeCurve.get(i3)).floatValue(), 0.0f), 255.0f)) & 255);
                        bArr[i16 + 3] = -1;
                    }
                    GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, 256, 1, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, ByteBuffer.wrap(bArr));
                }
            }
        });
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    protected void onDrawArraysAfter() {
        if (this.mToneCurveTexture[0] != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            GLES20.glActiveTexture(33984);
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    protected void onDrawArraysPre() {
        if (this.mToneCurveTexture[0] != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mToneCurveTexture[0]);
            GLES20.glUniform1i(this.mToneCurveTextureUniformLocation, 3);
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mToneCurveTextureUniformLocation = GLES20.glGetUniformLocation(getProgram(), "toneCurveTexture");
        GLES20.glActiveTexture(33987);
        GLES20.glGenTextures(1, this.mToneCurveTexture, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mToneCurveTexture[0]);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInitialized() {
        super.onInitialized();
        setRgbCompositeControlPoints(this.mRgbCompositeControlPoints);
        setRedControlPoints(this.mRedControlPoints);
        setGreenControlPoints(this.mGreenControlPoints);
        setBlueControlPoints(this.mBlueControlPoints);
    }

    public void setBlueControlPoints(PointF[] pointFArr) {
        this.mBlueControlPoints = pointFArr;
        this.mBlueCurve = createSplineCurve(pointFArr);
        updateToneCurveTexture();
    }

    public void setFromCurveFileInputStream(InputStream inputStream) {
        try {
            readShort(inputStream);
            short readShort = readShort(inputStream);
            ArrayList arrayList = new ArrayList(readShort);
            for (int i3 = 0; i3 < readShort; i3++) {
                int readShort2 = readShort(inputStream);
                PointF[] pointFArr = new PointF[readShort2];
                for (int i16 = 0; i16 < readShort2; i16++) {
                    pointFArr[i16] = new PointF(readShort(inputStream) * 0.003921569f, readShort(inputStream) * 0.003921569f);
                }
                arrayList.add(pointFArr);
            }
            inputStream.close();
            this.mRgbCompositeControlPoints = (PointF[]) arrayList.get(0);
            this.mRedControlPoints = (PointF[]) arrayList.get(1);
            this.mGreenControlPoints = (PointF[]) arrayList.get(2);
            this.mBlueControlPoints = (PointF[]) arrayList.get(3);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public void setGreenControlPoints(PointF[] pointFArr) {
        this.mGreenControlPoints = pointFArr;
        this.mGreenCurve = createSplineCurve(pointFArr);
        updateToneCurveTexture();
    }

    public void setRedControlPoints(PointF[] pointFArr) {
        this.mRedControlPoints = pointFArr;
        this.mRedCurve = createSplineCurve(pointFArr);
        updateToneCurveTexture();
    }

    public void setRgbCompositeControlPoints(PointF[] pointFArr) {
        this.mRgbCompositeControlPoints = pointFArr;
        this.mRgbCompositeCurve = createSplineCurve(pointFArr);
        updateToneCurveTexture();
    }

    public QQAVImageToneCurveFilter(InputStream inputStream) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", String.valueOf(23));
        this.mToneCurveTexture = new int[]{-1};
        setFromCurveFileInputStream(inputStream);
    }
}
