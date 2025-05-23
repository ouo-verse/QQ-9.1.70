package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLImageView extends GlView {
    protected GLImage mBackGround;
    private String mResPath;
    private boolean mSizeChanged;

    public GLImageView(GLViewContext gLViewContext, String str) {
        super(gLViewContext, str);
        this.mSizeChanged = false;
        this.mResPath = "";
        this.mBackGround = new GLImage();
        initView(4);
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void clearStatus() {
        super.clearStatus();
    }

    public GLImage getCurrentBackGround() {
        return this.mBackGround;
    }

    public RectF getImageClipDrawRegion() {
        return this.mClipRegion;
    }

    public RectF getImageRegion() {
        return this.mSizeRegion;
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void release() {
        super.release();
        clearStatus();
        this.mBackGround.release();
        this.mResPath = "";
    }

    public void setConvertedImageAndClipRegion(RectF rectF) {
        if (!this.mSizeRegion.equals(rectF)) {
            this.mSizeRegion.set(rectF);
            this.mClipRegion.set(rectF);
            this.mSizeChanged = true;
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.mBackGround.loadTextureSync(bitmap);
        this.mCurrentTexture = this.mBackGround.getTexture();
    }

    public void setImageClipDrawRegion(RectF rectF) {
        if (!this.mClipRegion.equals(rectF)) {
            this.mClipRegion.set(rectF);
            this.mHaveMappedClipSize = false;
            mapClipRegion();
            this.mSizeChanged = true;
        }
    }

    public void setImageRegion(RectF rectF) {
        if (!this.mSizeRegion.equals(rectF)) {
            this.mSizeRegion.set(rectF);
            this.mHaveMappedSize = false;
            mapSizeRegion();
            this.mSizeChanged = true;
        }
    }

    public void setImageRes(String str) {
        if (!this.mResPath.equals(str)) {
            this.mBackGround.loadTextureSync(str);
            this.mCurrentTexture = this.mBackGround.getTexture();
            this.mResPath = str;
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public boolean updateParam() {
        boolean updateParam = super.updateParam();
        if (!updateParam) {
            boolean z16 = this.mSizeChanged;
            this.mSizeChanged = false;
            return z16;
        }
        return updateParam;
    }
}
