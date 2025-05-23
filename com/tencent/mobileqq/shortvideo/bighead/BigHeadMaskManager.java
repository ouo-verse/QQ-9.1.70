package com.tencent.mobileqq.shortvideo.bighead;

import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BigHeadMaskManager {
    private int mHeight;
    private BGMask[] mMaskArray;
    private TextureRender mRender;
    private RenderBuffer mRenderMerge;
    private int mWidth;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class BGMask {
        public int mTextureId = 0;
        public boolean mUsed = false;
        public boolean hasValidData = false;
        public boolean last = false;

        public void destroy() {
            int i3 = this.mTextureId;
            if (i3 != 0) {
                GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            }
        }
    }

    public BigHeadMaskManager(int i3, int i16) {
        BGMask[] bGMaskArr = new BGMask[2];
        this.mMaskArray = bGMaskArr;
        this.mWidth = i3;
        this.mHeight = i16;
        bGMaskArr[0] = createTexture();
        this.mMaskArray[1] = createTexture();
        this.mRenderMerge = new RenderBuffer(this.mWidth, this.mHeight);
        this.mRender = new TextureRender();
    }

    private BGMask createTexture() {
        BGMask bGMask = new BGMask();
        bGMask.mTextureId = GlUtil.createTextureAllocate(this.mWidth, this.mHeight, true);
        return bGMask;
    }

    public int getMergedMask(boolean z16) {
        BGMask[] bGMaskArr;
        BGMask[] bGMaskArr2 = this.mMaskArray;
        BGMask bGMask = bGMaskArr2[0];
        boolean z17 = bGMask.hasValidData;
        if (z17 && !bGMaskArr2[1].hasValidData) {
            return bGMask.mTextureId;
        }
        if (!z17) {
            BGMask bGMask2 = bGMaskArr2[1];
            if (bGMask2.hasValidData) {
                return bGMask2.mTextureId;
            }
        }
        if (!z17) {
            return 0;
        }
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            bGMaskArr = this.mMaskArray;
            if (i3 >= bGMaskArr.length) {
                break;
            }
            if (bGMaskArr[i3].last) {
                i16 = i3;
            } else {
                i17 = i3;
            }
            i3++;
        }
        if (z16) {
            this.mRenderMerge.setUserTextureId(bGMaskArr[i17].mTextureId);
            this.mRenderMerge.bind();
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(0, 768);
            this.mRender.drawTexture(GLSLRender.GL_TEXTURE_2D, this.mMaskArray[i16].mTextureId, null, null);
            GLES20.glDisable(3042);
            this.mRenderMerge.unbind();
            return this.mMaskArray[i17].mTextureId;
        }
        return bGMaskArr[i16].mTextureId;
    }

    public int getSpaceMask() {
        for (BGMask bGMask : this.mMaskArray) {
            if (!bGMask.last && !bGMask.mUsed) {
                bGMask.mUsed = true;
                bGMask.hasValidData = false;
                return bGMask.mTextureId;
            }
        }
        return 0;
    }

    public void queueMask(int i3) {
        for (BGMask bGMask : this.mMaskArray) {
            if (bGMask.mTextureId == i3) {
                if (bGMask.mUsed) {
                    bGMask.mUsed = false;
                    bGMask.hasValidData = true;
                    bGMask.last = true;
                } else {
                    throw new RuntimeException("\u72b6\u6001\u9519\u8bef\u6216\u8005\u4f7f\u7528\u9519\u8bef...");
                }
            } else {
                bGMask.last = false;
            }
        }
    }

    public void release() {
        for (BGMask bGMask : this.mMaskArray) {
            if (bGMask != null) {
                bGMask.destroy();
            }
        }
        TextureRender textureRender = this.mRender;
        if (textureRender != null) {
            textureRender.release();
        }
        RenderBuffer renderBuffer = this.mRenderMerge;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
    }
}
