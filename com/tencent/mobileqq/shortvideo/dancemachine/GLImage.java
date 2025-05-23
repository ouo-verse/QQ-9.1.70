package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLImage {
    private int height;
    private boolean mIsBoyFilterTexture;
    private boolean mTemporaryRelease;
    private int texture;
    private int width;

    public GLImage() {
        this.texture = 0;
        this.mTemporaryRelease = false;
        this.mIsBoyFilterTexture = false;
    }

    private boolean reuseTextureMemory(int i3, int i16, Bitmap bitmap) {
        if (i3 != this.width || i16 != this.height) {
            return false;
        }
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.texture);
        if (bitmap != null) {
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
            return true;
        }
        return true;
    }

    public int getHeight() {
        return this.height;
    }

    public int getTexture() {
        return this.texture;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isBoyFilterTexture() {
        return this.mIsBoyFilterTexture;
    }

    public boolean isEnableTemporaryRelease() {
        return this.mTemporaryRelease;
    }

    public void loadTextureSync(String str) {
        loadTextureSync(FileUtils.loadBitmapFromNative(str, false));
    }

    public void release() {
        int i3 = this.texture;
        if (i3 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            this.texture = 0;
        }
        this.width = 0;
        this.height = 0;
    }

    public void loadTextureSync(Bitmap bitmap) {
        loadTextureSync(bitmap, true);
    }

    public void loadTextureSync(Bitmap bitmap, boolean z16) {
        if (bitmap != null) {
            if (this.texture != 0) {
                if (reuseTextureMemory(bitmap.getWidth(), bitmap.getHeight(), bitmap)) {
                    if (z16) {
                        bitmap.recycle();
                        return;
                    }
                    return;
                }
                release();
            }
            this.width = bitmap.getWidth();
            this.height = bitmap.getHeight();
            this.texture = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, bitmap);
            if (z16) {
                bitmap.recycle();
            }
        }
    }

    public GLImage(boolean z16) {
        this.texture = 0;
        this.mTemporaryRelease = z16;
        this.mIsBoyFilterTexture = false;
    }

    public GLImage(boolean z16, boolean z17) {
        this.texture = 0;
        this.mTemporaryRelease = z16;
        this.mIsBoyFilterTexture = z17;
    }
}
