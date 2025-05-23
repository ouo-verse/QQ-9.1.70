package com.tencent.mobileqq.richmedia.mediacodec.computeShader;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;

@SuppressLint({"NewApi"})
/* loaded from: classes18.dex */
public class GPUComputeShaderFilter {
    private static final String TAG = "GPUComputeShaderFilter";
    private String mComputeShader;
    private boolean mIsInitialized;
    private int mProgram;
    public int mTextureType;

    public GPUComputeShaderFilter(String str, int i3) {
        this.mComputeShader = str;
        this.mTextureType = i3;
    }

    public void checkGlError(String str) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                SLog.e(TAG, new RuntimeException(str + ": glError " + glGetError));
            } else {
                return;
            }
        }
    }

    public void checkLocation(int i3, String str) {
        if (i3 < 0) {
            SLog.e(TAG, new RuntimeException("Unable to locate '" + str + "' in program"));
        }
    }

    public void destroy() {
        this.mIsInitialized = false;
        GLES20.glDeleteProgram(this.mProgram);
        this.mProgram = 0;
    }

    public int getAlignment16(int i3) {
        int i16 = i3 % 16;
        if (i16 == 0) {
            return i3;
        }
        return (i3 + 16) - i16;
    }

    public void init() {
        if (this.mIsInitialized) {
            return;
        }
        int createComputeProgram = GlUtil.createComputeProgram(this.mComputeShader);
        this.mProgram = createComputeProgram;
        if (createComputeProgram == 0) {
            SLog.e(TAG, new RuntimeException("failed creating ComputeProgram " + getClass().getSimpleName()));
        }
        this.mIsInitialized = true;
    }

    public int useComputeProgram() {
        checkGlError("onDispatchComputePrepare");
        GLES20.glUseProgram(this.mProgram);
        checkGlError("glUseProgram");
        return this.mProgram;
    }
}
