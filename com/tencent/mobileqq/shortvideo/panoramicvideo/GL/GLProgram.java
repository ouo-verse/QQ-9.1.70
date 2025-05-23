package com.tencent.mobileqq.shortvideo.panoramicvideo.GL;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

/* loaded from: classes18.dex */
public abstract class GLProgram {
    private String mFragmentShader;
    private int mProgramId;
    private String mVertexShader;
    private int maPositionHandle;
    private int maTextureCoordinateHandle;

    public GLProgram(Context context, String str, String str2) {
        this.mVertexShader = str;
        this.mFragmentShader = str2;
    }

    public void create() {
        int createProgram = GlUtil.createProgram(this.mVertexShader, this.mFragmentShader);
        this.mProgramId = createProgram;
        if (createProgram == 0) {
            return;
        }
        this.maPositionHandle = GLES20.glGetAttribLocation(getProgramId(), "aPosition");
        GlUtil.checkGlError("glGetAttribLocation aPosition");
        if (this.maPositionHandle != -1) {
            this.maTextureCoordinateHandle = GLES20.glGetAttribLocation(getProgramId(), "aTextureCoord");
            GlUtil.checkGlError("glGetAttribLocation aTextureCoord");
            if (this.maTextureCoordinateHandle != -1) {
                return;
            } else {
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
        }
        throw new RuntimeException("Could not get attrib location for aPosition");
    }

    public int getPositionHandle() {
        return this.maPositionHandle;
    }

    public int getProgramId() {
        return this.mProgramId;
    }

    public int getTextureCoordinateHandle() {
        return this.maTextureCoordinateHandle;
    }

    public void onDestroy() {
        GLES20.glDeleteProgram(this.mProgramId);
    }

    public void use() {
        GLES20.glUseProgram(getProgramId());
        GlUtil.checkGlError("glUseProgram");
    }
}
