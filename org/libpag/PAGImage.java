package org.libpag;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;

/* loaded from: classes29.dex */
public class PAGImage {
    long nativeContext;

    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PAGImage(long j3) {
        this.nativeContext = j3;
    }

    public static PAGImage FromAssets(AssetManager assetManager, String str) {
        long LoadFromAssets = LoadFromAssets(assetManager, str);
        if (LoadFromAssets == 0) {
            return null;
        }
        return new PAGImage(LoadFromAssets);
    }

    public static PAGImage FromBitmap(Bitmap bitmap) {
        if (bitmap != null && bitmap.getConfig() == Bitmap.Config.ARGB_4444) {
            bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        }
        long LoadFromBitmap = LoadFromBitmap(bitmap);
        if (LoadFromBitmap == 0) {
            return null;
        }
        return new PAGImage(LoadFromBitmap);
    }

    public static PAGImage FromBytes(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        long LoadFromBytes = LoadFromBytes(bArr, bArr.length);
        if (LoadFromBytes == 0) {
            return null;
        }
        return new PAGImage(LoadFromBytes);
    }

    public static PAGImage FromPath(String str) {
        long LoadFromPath = LoadFromPath(str);
        if (LoadFromPath == 0) {
            return null;
        }
        return new PAGImage(LoadFromPath);
    }

    public static PAGImage FromTexture(int i3, int i16, int i17, int i18) {
        return FromTexture(i3, i16, i17, i18, false);
    }

    private static native long LoadFromAssets(AssetManager assetManager, String str);

    private static native long LoadFromBitmap(Bitmap bitmap);

    private static native long LoadFromBytes(byte[] bArr, int i3);

    private static native long LoadFromPath(String str);

    private static native long LoadFromTexture(int i3, int i16, int i17, int i18, boolean z16);

    private native void nativeFinalize();

    private native void nativeGetMatrix(float[] fArr);

    private static final native void nativeInit();

    private final native void nativeRelease();

    private native void nativeSetMatrix(float f16, float f17, float f18, float f19, float f26, float f27);

    protected void finalize() {
        nativeFinalize();
    }

    public native int height();

    public Matrix matrix() {
        float[] fArr = new float[9];
        nativeGetMatrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return matrix;
    }

    public void release() {
        nativeRelease();
    }

    public native int scaleMode();

    public void setMatrix(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        nativeSetMatrix(fArr[0], fArr[3], fArr[1], fArr[4], fArr[2], fArr[5]);
    }

    public native void setScaleMode(int i3);

    public native int width();

    public static PAGImage FromTexture(int i3, int i16, int i17, int i18, boolean z16) {
        long LoadFromTexture = LoadFromTexture(i3, i16, i17, i18, z16);
        if (LoadFromTexture == 0) {
            return null;
        }
        return new PAGImage(LoadFromTexture);
    }
}
