package com.tencent.mobileqq.richmedia.mediacodec.computeShader;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLES31;
import com.tencent.filter.GLSLRender;
import java.nio.ByteOrder;

@SuppressLint({"NewApi"})
/* loaded from: classes18.dex */
public class GPUGuideFilterComputeFilter extends GPUComputeShaderFilter {
    private static final String TAG = "GPUVideoStablizationFilter";
    public static final String VIDEO_GUIDE_FILTER_COMPUTE_SHADER = "    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (std430,binding = 0) buffer guidenceImgData{                                              \n        int guidenceImg[];                                                                        \n    };                                                                                          \n    layout (std430,binding = 1) buffer transmissionData{                                              \n        float transmission[];                                                                        \n    };                                                                                          \n    layout (std430,binding = 2) buffer outputData{                                              \n        float ab[];                                                                        \n    };                                                                                          \n    uniform int r;                                                                    \n    uniform float eps;                                                                    \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n       int outputRowIndex = int(gl_GlobalInvocationID.y);                                        \n       int outputColumnIndex = int(gl_GlobalInvocationID.x);                                  \n       if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                           \n       }                                                                                            \n       int startX =  outputColumnIndex - r;                                                         \n       int startY =  outputRowIndex - r;                                                            \n       int endX =  outputColumnIndex + r;                                                              \n       int endY =  outputRowIndex + r;                                                          \n       int k=0;                                                                                          \n       int wndsize = 2 * r + 1;                                                               \n       int pixcount = wndsize * wndsize;                                                            \n       float sum_I = 0.0;                                                                               \n       float sum_p = 0.0;                                                                                \n       for(int m= startY; m<=endY; m++){                                                            \n           for(int n= startX; n<=endX; n++){                                                           \n               if(m < 0 || m >= imageHeight){                                                              \n                  k++;                                                                                            \n                  continue;                                                                                 \n               }                                                                                                \n               if(n < 0 || n >= imageWidth){                                                              \n                  k++;                                                                                            \n                  continue;                                                                                  \n               }                                                                                                \n               sum_I += float(guidenceImg[m*imageWidth+n])/255.0;                                                     \n               sum_p += transmission[m*imageWidth+n];                                                            \n           }                                                                                            \n       }                                                                                                \n       float mean_I = sum_I / float(pixcount - k);                                                      \n       float mean_p = sum_p / float(pixcount - k);                                                          \n       k = 0;                                                                                              \n       float sum_Ip = 0.0f;                                                                                \n       float sum_var_I = 0.0f;                                                                                   \n       for(int m= startY; m<=endY; m++){                                                                        \n           for(int n= startX; n<=endX; n++){                                                           \n               if(m < 0 || m >= imageHeight){                                                              \n                  k++;                                                                                            \n                  continue;                                                                                \n               }                                                                                                \n               if(n < 0 || n >= imageWidth){                                                              \n                  k++;                                                                                         \n                  continue;                                                                                      \n               }                                                                                                                     \n               sum_Ip += transmission[m * imageWidth + n] * (float(guidenceImg[m * imageWidth + n]) / 255.0);                               \n               sum_var_I += (float(guidenceImg[m * imageWidth + n])/255.0 - mean_I) * (float(guidenceImg[m * imageWidth + n])/255.0 - mean_I);       \n           }                                                                                                                                        \n       }                                                                                                                                             \n       int index = imageWidth*imageHeight;                                                                                                                           \n       ab[outputRowIndex*imageWidth + outputColumnIndex] = (sum_Ip / float(pixcount - k) - mean_I * mean_p) / (sum_var_I / float(pixcount - k) + eps);                           \n       ab[outputRowIndex*imageWidth + outputColumnIndex + index] = mean_p - ab[outputRowIndex*imageWidth+outputColumnIndex] * mean_I;                                                        \n       barrier();                                                                                                                                                \n   }                                                                                                             ";
    ByteOrder byteOrder;

    public GPUGuideFilterComputeFilter() {
        super(VIDEO_GUIDE_FILTER_COMPUTE_SHADER, GLSLRender.GL_TEXTURE_2D);
        this.byteOrder = ByteOrder.nativeOrder();
        init();
    }

    public void glDisPatchGuideFilterComputerCompute(int[] iArr, int i3, int i16, int i17, float f16) {
        int useComputeProgram = useComputeProgram();
        GLES20.glBindBuffer(37074, iArr[0]);
        GLES30.glBindBufferBase(37074, 0, iArr[0]);
        GLES20.glBindBuffer(37074, 0);
        checkGlError("fill guidenceImgData buffer");
        GLES20.glBindBuffer(37074, iArr[1]);
        GLES30.glBindBufferBase(37074, 1, iArr[1]);
        GLES20.glBindBuffer(37074, 0);
        checkGlError("fill transmission buffer");
        GLES20.glBindBuffer(37074, iArr[2]);
        GLES20.glBufferData(37074, i3 * i16 * 2 * 4, null, 35049);
        GLES30.glBindBufferBase(37074, 2, iArr[2]);
        GLES20.glBindBuffer(37074, 0);
        checkGlError("fill ab buffer");
        int glGetUniformLocation = GLES20.glGetUniformLocation(useComputeProgram, "r");
        checkLocation(glGetUniformLocation, "r");
        GLES20.glUniform1i(glGetUniformLocation, (i17 - 1) / 2);
        checkGlError("fill uniform  r");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(useComputeProgram, "eps");
        checkLocation(glGetUniformLocation2, "eps");
        GLES20.glUniform1f(glGetUniformLocation2, f16);
        checkGlError("fill uniform  eps");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(useComputeProgram, "imageHeight");
        checkLocation(glGetUniformLocation3, "imageHeight");
        GLES20.glUniform1i(glGetUniformLocation3, i16);
        checkGlError("fill uniform  imageHeight");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(useComputeProgram, "imageWidth");
        checkLocation(glGetUniformLocation4, "imageWidth");
        GLES20.glUniform1i(glGetUniformLocation4, i3);
        checkGlError("fill uniform  imageWidth");
        int alignment16 = getAlignment16(i3);
        int alignment162 = getAlignment16(i16);
        int i18 = alignment16 % 8;
        int i19 = alignment16 / 8;
        if (i18 != 0) {
            i19++;
        }
        int i26 = alignment162 % 8;
        int i27 = alignment162 / 8;
        if (i26 != 0) {
            i27++;
        }
        GLES31.glDispatchCompute(i19, i27, 1);
        checkGlError("glDispatchCompute");
        GLES31.glMemoryBarrier(32);
        checkGlError("glMemoryBarrier");
    }
}
