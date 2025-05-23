package com.tencent.ttpic.openapi;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;

/* loaded from: classes27.dex */
public class PTHairAttr {
    private int faceBright;
    private int hairBright;
    private PointF[] hairRect;
    private Bitmap maskBitmap;
    private Frame maskFrame;
    private PointF[] maskYYAnchor;
    private float materialCrop;

    public int getFaceBright() {
        return this.faceBright;
    }

    public int getHairBright() {
        return this.hairBright;
    }

    public PointF[] getHairRect() {
        return this.hairRect;
    }

    public Bitmap getMaskBitmap() {
        return this.maskBitmap;
    }

    public Frame getMaskFrame() {
        return this.maskFrame;
    }

    public PointF[] getMaskYYAnchor() {
        return this.maskYYAnchor;
    }

    public float getMaterialCrop() {
        return this.materialCrop;
    }

    public boolean isReady() {
        return BitmapUtils.isLegal(this.maskBitmap);
    }

    public void setFaceBright(int i3) {
        this.faceBright = i3;
    }

    public void setHairBright(int i3) {
        this.hairBright = i3;
    }

    public void setHairRect(PointF[] pointFArr) {
        this.hairRect = pointFArr;
    }

    public void setMaskBitmap(Bitmap bitmap) {
        this.maskBitmap = bitmap;
    }

    public void setMaskFrame(Frame frame) {
        this.maskFrame = frame;
    }

    public void setMaskYYAnchor(PointF[] pointFArr) {
        this.maskYYAnchor = pointFArr;
    }

    public void setMaterialCrop(float f16) {
        this.materialCrop = f16;
    }
}
