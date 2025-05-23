package com.tencent.mobileqq.richmedia.mediacodec.computeShader;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLES31;
import com.tencent.filter.GLSLRender;

@SuppressLint({"NewApi"})
/* loaded from: classes18.dex */
public class GPUMinMaxPixelsFilter extends GPUComputeShaderFilter {
    private static final String TAG = "GPUMinMaxPixelsFilter";
    public static final String VIDEO_IMG_FILTER_COMPUTE_SHADER = "    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (rgba8, binding = 0) readonly  uniform  highp image2D inputImage;                    \n    layout (std430,binding = 1) buffer TransmissionData{                                              \n        float transmission[];                                                                        \n    };                                                                                          \n    uniform int r;                                                                              \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n    uniform float avgLight;                                                                              \n                                                                                                \n    void main(){                                                                                \n       int outputRowIndex = int(gl_GlobalInvocationID.y);                                        \n       int outputColumnIndex = int(gl_GlobalInvocationID.x);                                  \n       if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                           \n       }                                                                                            \n       vec4 inputValue = imageLoad(inputImage, ivec2(gl_GlobalInvocationID.xy));                   \n       barrier();                                                                                          \n       int startX =  outputColumnIndex - r;                                                         \n       int startY =  outputRowIndex - r;                                                            \n       int endX =  outputColumnIndex + r;                                                              \n       int endY =  outputRowIndex + r;                                                          \n       float maxChanel = max(inputValue.r, max(inputValue.b, inputValue.g));                       \n       float minChanel = min(inputValue.r, min(inputValue.b, inputValue.g));                           \n       for(int i= startX; i<=endX; i++){                                                            \n           for(int j= startY; j<=endY; j++){                                                           \n               if(i >=0 && i<imageWidth && j >= 0 && j<imageHeight){                 \n                   vec4 arroundValue = imageLoad(inputImage, ivec2(i,j));                                  \n                   maxChanel = max(maxChanel,max(arroundValue.r, max(arroundValue.b, arroundValue.g))); \n                   minChanel = min(minChanel,min(arroundValue.r, min(arroundValue.b, arroundValue.g))); \n               }                                                                                        \n           }                                                                                            \n       }                                                                                                \n       int index = outputRowIndex*imageWidth+outputColumnIndex;                  \n                                                                                                        \n       float maxImg =  maxChanel * 255.0;                                                           \n       float darkImg  = minChanel * 255.0;                                                           \n       if(darkImg < 130.0) {                                                                               \n             transmission[index] = 1.0 - (maxImg * 0.8 / 256.0)* 0.9 * darkImg / avgLight;           \n             if(transmission[index] > 1.0){                                                             \n                  transmission[index] = 1.0;                                                               \n             }                                                                                               \n       }                                                                                             \n       else if (darkImg >= 130.0 && darkImg<200.0) {                                                       \n            transmission[index] = 1.0 - (1.8 - 0.01*darkImg)* 0.9 * darkImg/ avgLight;                   \n            if(transmission[index] > 1.0){                                                                   \n                 transmission[index] = 1.0f;                                                                 \n            }                                                                                                \n       }                                                                                                   \n       else {                                                                                            \n            transmission[index] = 1.0f;                                                                         \n       }                                                                                                     \n   }                                                        ";

    public GPUMinMaxPixelsFilter() {
        super(VIDEO_IMG_FILTER_COMPUTE_SHADER, GLSLRender.GL_TEXTURE_2D);
        init();
    }

    public void glDisPatchGPUMinMaxPixelsFilterCompute(int i3, int i16, int i17, int[] iArr, float f16, int i18) {
        int useComputeProgram = useComputeProgram();
        GLES31.glBindImageTexture(0, i3, 0, true, 0, 35000, 32856);
        checkGlError("fill inputImage texture");
        GLES20.glBindBuffer(37074, iArr[1]);
        GLES20.glBufferData(37074, i16 * i17 * 4, null, 35049);
        GLES30.glBindBufferBase(37074, 1, iArr[1]);
        GLES20.glBindBuffer(37074, 0);
        checkGlError("fill TransmissionData buffer");
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
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(useComputeProgram, "avgLight");
        checkLocation(glGetUniformLocation3, "avgLight");
        GLES20.glUniform1f(glGetUniformLocation4, f16);
        checkGlError("fill uniform  avgLight");
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
