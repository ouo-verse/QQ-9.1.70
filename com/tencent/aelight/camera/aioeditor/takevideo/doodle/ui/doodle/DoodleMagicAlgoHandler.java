package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleMagicAlgoHandler {
    public static final String TAG = "Doodle_Strokes_MagicAlgoHandler";
    public static final int TOUCH_DOWN = 0;
    public static final int TOUCH_MOVE = 1;
    public static final int TOUCH_UP = 2;
    private static WeakReference<VideoFilterBase> mFilter;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class RenderPoint implements Serializable {
        private static final long serialVersionUID = 1;
        public float[] aList;
        public float[] xList;
        public float[] yList;

        public RenderPoint() {
        }

        public RenderPoint(float[] fArr, float[] fArr2, float[] fArr3, int i3) {
            this.xList = new float[i3];
            this.yList = new float[i3];
            this.aList = new float[i3];
            for (int i16 = 0; i16 < i3; i16++) {
                this.xList[i16] = fArr[i16];
                this.yList[i16] = fArr2[i16];
                this.aList[i16] = fArr3[i16];
            }
        }
    }

    public static void OnUpdateSize(int i3, int i16, float f16) {
        try {
            updateSize(i3, i16, f16);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
    }

    public static native void processTouch();

    public static void renderToTemp(int i3, float[] fArr, float[] fArr2, float[] fArr3) {
        VideoFilterBase videoFilterBase;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "size= " + i3);
        }
        WeakReference<VideoFilterBase> weakReference = mFilter;
        if (weakReference == null || weakReference.get() == null || (videoFilterBase = mFilter.get()) == null) {
            return;
        }
        RenderPoint renderPoint = new RenderPoint();
        renderPoint.xList = fArr;
        renderPoint.yList = fArr2;
        renderPoint.aList = fArr3;
        if (videoFilterBase instanceof i) {
            ((i) videoFilterBase).f(renderPoint);
        }
    }

    public static void setFilter(VideoFilterBase videoFilterBase) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setFilter");
        }
        mFilter = new WeakReference<>(videoFilterBase);
    }

    public static native void touchBegin(float f16, float f17);

    public static native void touchEnd(float f16, float f17);

    public static native void touchMove(float f16, float f17);

    public static native void updateSize(int i3, int i16, float f16);

    public static void onTouchEvent(int i3, float f16, float f17) {
        try {
            if (i3 == 0) {
                touchBegin(f16, f17);
            } else if (i3 == 1) {
                touchMove(f16, f17);
            } else if (i3 == 2) {
                touchEnd(f16, f17);
            }
            long currentTimeMillis = System.currentTimeMillis();
            processTouch();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onTouchEvent|processTouch time= " + (currentTimeMillis2 - currentTimeMillis));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        } catch (UnsatisfiedLinkError e17) {
            e17.printStackTrace();
        }
    }
}
