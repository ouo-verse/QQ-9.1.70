package com.tencent.mobileqq.richmedia.mediacodec.computeShader;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLES31;
import com.tencent.filter.GLSLRender;

@SuppressLint({"NewApi"})
/* loaded from: classes18.dex */
public class GPUGuideFilterRecoverFilter extends GPUComputeShaderFilter {
    private static final String TAG = "GPUVideoStablizationFilter";
    public static final String VIDEO_GUIDE_FILTER_RECOVER_SHADER = "    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (std430,binding = 0) buffer abData{                                              \n        float ab[];                                                                        \n    };                                                                                          \n    layout (std430,binding = 1) buffer meanabData{                                              \n        float mean_ab[];                                                                        \n    };                                                                                          \n    layout (std430,binding = 2) buffer guidenceImgData{                                              \n        int guidenceImg[];                                                                        \n    };                                                                                          \n    layout (rgba8, binding = 3) writeonly uniform  highp image2D transmisionImage;                    \n    uniform int r;                                                                    \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n       int outputRowIndex = int(gl_GlobalInvocationID.y);                                        \n       int outputColumnIndex = int(gl_GlobalInvocationID.x);                                  \n       if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                           \n       }                                                                                            \n       int startX =  outputColumnIndex - r;                                                         \n       int startY =  outputRowIndex - r;                                                            \n       int endX =  outputColumnIndex + r;                                                              \n       int endY =  outputRowIndex + r;                                                          \n       int k=0;                                                                                          \n       int wndsize = 2 * r + 1;                                                               \n       int pixcount = wndsize * wndsize;                                                            \n       float sumA = 0.0;                                                                               \n       float sumB = 0.0;                                                                                \n       int index = imageWidth*imageHeight;                                                                     \n       for(int m= startY; m<=endY; m++){                                                            \n           for(int n= startX; n<=endX; n++){                                                           \n               if(m < 0 || m >= imageHeight){                                                              \n                  k++;                                                                                            \n                  continue;                                                                                 \n               }                                                                                                \n               if(n < 0 || n >= imageWidth){                                                              \n                  k++;                                                                                            \n                  continue;                                                                                  \n               }                                                                                                \n               sumA += ab[m*imageWidth+n];                                                                               \n               sumB += ab[m*imageWidth+n + index];                                                            \n           }                                                                                            \n       }                                                                                                \n       mean_ab[outputRowIndex * imageWidth + outputColumnIndex] = sumA / float(pixcount - k);                                                                                                 \n       mean_ab[outputRowIndex * imageWidth + outputColumnIndex + index] = sumB / float(pixcount - k);                                                                                                              \n       float tmp = mean_ab[outputRowIndex * imageWidth + outputColumnIndex] * float(guidenceImg[outputRowIndex*imageWidth+outputColumnIndex])/255.0 + mean_ab[outputRowIndex*imageWidth+outputColumnIndex + index];          \n       tmp = tmp > 1.0 ? 1.0f : tmp;                                                                                                                                                                        \n       tmp = tmp > 0.1 ? tmp : 0.1;                                                                                                                                                                       \n       vec4 ouputRGBA = vec4(tmp,tmp,tmp,1.0);                                                              \n       imageStore(transmisionImage,ivec2(gl_GlobalInvocationID.xy),ouputRGBA);                                         \n       barrier();                                                                                                                                                                                                \n   }                                                                                                             ";

    public GPUGuideFilterRecoverFilter() {
        super(VIDEO_GUIDE_FILTER_RECOVER_SHADER, GLSLRender.GL_TEXTURE_2D);
        init();
    }

    public void glDisPatchGuideFilterRecoverFilterCompute(int i3, int[] iArr, int i16, int i17, int i18) {
        int useComputeProgram = useComputeProgram();
        GLES20.glBindBuffer(37074, iArr[2]);
        GLES30.glBindBufferBase(37074, 0, iArr[2]);
        GLES20.glBindBuffer(37074, 0);
        checkGlError("fill ab buffer");
        GLES20.glBindBuffer(37074, iArr[3]);
        GLES20.glBufferData(37074, i16 * i17 * 2 * 4, null, 35049);
        GLES30.glBindBufferBase(37074, 1, iArr[3]);
        GLES20.glBindBuffer(37074, 0);
        checkGlError("fill aValueData buffer");
        GLES20.glBindBuffer(37074, iArr[0]);
        GLES30.glBindBufferBase(37074, 2, iArr[0]);
        GLES20.glBindBuffer(37074, 0);
        checkGlError("fill aValueData buffer");
        GLES31.glBindImageTexture(3, i3, 0, true, 0, 35001, 32856);
        checkGlError("fill tImage texture");
        int glGetUniformLocation = GLES20.glGetUniformLocation(useComputeProgram, "r");
        checkLocation(glGetUniformLocation, "r");
        GLES20.glUniform1i(glGetUniformLocation, (i18 - 1) / 2);
        checkGlError("fill uniform  r");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(useComputeProgram, "imageHeight");
        checkLocation(glGetUniformLocation2, "imageHeight");
        GLES20.glUniform1i(glGetUniformLocation2, i17);
        checkGlError("fill uniform  imageHeight");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(useComputeProgram, "imageWidth");
        checkLocation(glGetUniformLocation3, "imageWidth");
        GLES20.glUniform1i(glGetUniformLocation3, i16);
        checkGlError("fill uniform  imageWidth");
        int alignment16 = getAlignment16(i16);
        int alignment162 = getAlignment16(i17);
        int i19 = alignment16 % 8;
        int i26 = alignment16 / 8;
        if (i19 != 0) {
            i26++;
        }
        int i27 = alignment162 % 8;
        int i28 = alignment162 / 8;
        if (i27 != 0) {
            i28++;
        }
        GLES31.glDispatchCompute(i26, i28, 1);
        checkGlError("glDispatchCompute");
        GLES31.glMemoryBarrier(32);
        checkGlError("glMemoryBarrier");
    }
}
