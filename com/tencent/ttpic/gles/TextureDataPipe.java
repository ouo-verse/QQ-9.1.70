package com.tencent.ttpic.gles;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes27.dex */
public class TextureDataPipe {
    public static final int BUFFER_BUSY = 1;
    public static final int BUFFER_FREE = 0;
    public static final int BUFFER_READY = 2;
    public static final String TAG = "TextureDataPipe";
    private static float[] sMtxIdentity = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public long mTimestamp;
    public AtomicInteger mTextureDataFlag = new AtomicInteger(0);
    public Frame mTexFrame = new Frame();
    public List<List<PointF>> mPoints = new ArrayList();

    /* loaded from: classes27.dex */
    public interface OnFrameAvailableListener {
        void onFrameAvailable();
    }

    public int getTexureCurrentStatus() {
        return this.mTextureDataFlag.getAndAdd(0);
    }

    public void getTransformMatrix(float[] fArr) {
        if (fArr.length == 16) {
            float[] fArr2 = sMtxIdentity;
            System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    public boolean isBusy() {
        if (this.mTextureDataFlag.get() == 1) {
            return true;
        }
        return false;
    }

    public boolean isReady() {
        if (this.mTextureDataFlag.get() == 2) {
            return true;
        }
        return false;
    }

    public void makeBusy() {
        this.mTextureDataFlag.getAndSet(1);
    }

    public void makeDataReady() {
        this.mTextureDataFlag.getAndSet(2);
    }

    public void makeFree() {
        this.mTextureDataFlag.getAndSet(0);
    }

    public void release() {
        this.mTexFrame.clear();
    }
}
