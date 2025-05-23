package com.tencent.ttpic.openapi;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;

/* loaded from: classes27.dex */
public class PTSkyAttr {
    private Bitmap maskBitmap;
    private Frame maskFrame;
    private long nextSurfaceTime;
    private float[] rotationMatrix;
    private long surfaceTime;

    public Bitmap getMaskBitmap() {
        return this.maskBitmap;
    }

    public Frame getMaskFrame() {
        return this.maskFrame;
    }

    public long getNextSurfaceTime() {
        return this.nextSurfaceTime;
    }

    public float[] getRotationMatrix() {
        return this.rotationMatrix;
    }

    public long getSurfaceTime() {
        return this.surfaceTime;
    }

    public boolean isReady() {
        return BitmapUtils.isLegal(this.maskBitmap);
    }

    public void setMaskBitmap(Bitmap bitmap) {
        this.maskBitmap = bitmap;
    }

    public void setMaskFrame(Frame frame) {
        this.maskFrame = frame;
    }

    public void setNextSurfaceTime(long j3) {
        this.nextSurfaceTime = j3;
    }

    public void setRotationMatrix(float[] fArr) {
        this.rotationMatrix = fArr;
    }

    public void setSurfaceTime(long j3) {
        this.surfaceTime = j3;
    }
}
