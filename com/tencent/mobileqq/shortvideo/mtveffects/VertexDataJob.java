package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
class VertexDataJob implements Runnable {
    private static final String TAG = "VertexDataJob";
    private int mHeight;
    private WeakReference<VertexDataJobListener> mListenerRef;
    private int mMaxHeight;
    private int mMaxWidth;
    private RectF mRcSrc;
    private int mWidth;

    public VertexDataJob(RectF rectF, int i3, int i16, int i17, int i18, VertexDataJobListener vertexDataJobListener) {
        this.mRcSrc = rectF;
        this.mWidth = i3;
        this.mHeight = i16;
        this.mMaxWidth = i17;
        this.mMaxHeight = i18;
        this.mListenerRef = new WeakReference<>(vertexDataJobListener);
    }

    private FloatBuffer getFloatBuffer(RectF rectF, int i3, int i16, int i17, int i18) {
        if (rectF == null || i17 == 0 || i18 == 0 || i3 == 0 || i16 == 0) {
            return null;
        }
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3 * i16 * 2 * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            float f16 = rectF.left;
            float f17 = rectF.bottom;
            float f18 = 1.0f / i17;
            float f19 = 1.0f / i18;
            for (int i19 = 0; i19 < i16; i19++) {
                for (int i26 = 0; i26 < i3; i26++) {
                    asFloatBuffer.put((((i26 * f18) + f16) * 2.0f) - 1.0f);
                    asFloatBuffer.put((((i19 * f19) + f17) * 2.0f) - 1.0f);
                }
            }
            asFloatBuffer.rewind();
            return asFloatBuffer;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        VertexDataJobListener vertexDataJobListener;
        FloatBuffer floatBuffer = getFloatBuffer(this.mRcSrc, this.mWidth, this.mHeight, this.mMaxWidth, this.mMaxHeight);
        WeakReference<VertexDataJobListener> weakReference = this.mListenerRef;
        if (weakReference == null || (vertexDataJobListener = weakReference.get()) == null) {
            return;
        }
        vertexDataJobListener.onResult(floatBuffer);
    }
}
