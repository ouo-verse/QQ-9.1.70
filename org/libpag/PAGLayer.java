package org.libpag;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;

/* loaded from: classes29.dex */
public class PAGLayer {
    public static final int LayerTypeImage = 5;
    public static final int LayerTypeNull = 1;
    public static final int LayerTypePreCompose = 6;
    public static final int LayerTypeShape = 4;
    public static final int LayerTypeSolid = 2;
    public static final int LayerTypeText = 3;
    public static final int LayerTypeUnknown = 0;
    protected long nativeContext;

    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    public PAGLayer(long j3) {
        this.nativeContext = j3;
    }

    private native void getTotalMatrix(float[] fArr);

    private native void matrix(float[] fArr);

    private native boolean nativeEquals(PAGLayer pAGLayer);

    private static native void nativeInit();

    private native void nativeRelease();

    private native void setMatrix(float[] fArr);

    public native long currentTime();

    public native long duration();

    public native int editableIndex();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PAGLayer)) {
            return false;
        }
        return nativeEquals((PAGLayer) obj);
    }

    public native boolean excludedFromTimeline();

    protected void finalize() {
        PagViewMonitor.finalize(this);
        nativeRelease();
    }

    public native float frameRate();

    public native RectF getBounds();

    public native double getProgress();

    public Matrix getTotalMatrix() {
        float[] fArr = new float[9];
        getTotalMatrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return matrix;
    }

    public native long globalToLocalTime(long j3);

    public int hashCode() {
        long j3 = this.nativeContext;
        return ((int) (j3 ^ (j3 >>> 32))) + 527;
    }

    public native String layerName();

    public native int layerType();

    public native long localTimeToGlobal(long j3);

    public native PAGMarker[] markers();

    public Matrix matrix() {
        float[] fArr = new float[9];
        matrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return matrix;
    }

    public native PAGComposition parent();

    public native void resetMatrix();

    public native void setCurrentTime(long j3);

    public native void setExcludedFromTimeline(boolean z16);

    public void setMatrix(Matrix matrix) {
        if (matrix == null) {
            return;
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        setMatrix(fArr);
    }

    public native void setProgress(double d16);

    public native void setStartTime(long j3);

    public native void setVisible(boolean z16);

    public native long startTime();

    public native PAGLayer trackMatteLayer();

    public native boolean visible();
}
