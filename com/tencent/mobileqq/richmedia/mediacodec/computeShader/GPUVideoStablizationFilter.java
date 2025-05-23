package com.tencent.mobileqq.richmedia.mediacodec.computeShader;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLES31;
import com.tencent.filter.GLSLRender;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressLint({"NewApi"})
/* loaded from: classes18.dex */
public class GPUVideoStablizationFilter extends GPUComputeShaderFilter {
    private static final String TAG = "GPUVideoStablizationFilter";
    public static final String VIDEO_STABILAZATION_COMPUTE_SHADER = "    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (rgba8, binding = 0) readonly uniform  highp image2D inputImage;                     \n    layout (std430,binding = 1) writeonly buffer outputVec{                                     \n        int VecData[];                                                                          \n    };                                                                                          \n    layout (std430,binding = 2)  buffer outputAvgImage{                                         \n        float avgImageData[];                                                                   \n    };                                                                                          \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n        int outputRowIndex = int(gl_GlobalInvocationID.y);                                      \n        int outputColumnIndex = int(gl_GlobalInvocationID.x);                                   \n                                                                                                \n        if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                             \n                                                                                                \n        }                                                                                       \n                                                                                                \n        vec4 inputValue = imageLoad(inputImage, ivec2(gl_GlobalInvocationID.xy));               \n        float avgValue =  float(inputValue.r*0.299 + inputValue.g*0.587 + inputValue.b*0.114);  \n        int index = outputRowIndex * imageWidth + outputColumnIndex;                            \n        avgImageData[index] = avgValue;                                                         \n        barrier();                                                                              \n                                                                                                \n        if(outputColumnIndex == imageWidth - 1){                                                \n             float rowSum = 0.0;                                                                \n             for(int i = 0; i < imageWidth; i++){                                               \n                int idx = outputRowIndex * imageWidth + i;                                      \n                rowSum += avgImageData[idx];                                                    \n             }                                                                                  \n             VecData[imageHeight-1-outputRowIndex] = int(rowSum / float(imageWidth) * 255.0);   \n        }                                                                                       \n                                                                                                \n        if(outputRowIndex == imageHeight - 1){                                                  \n            float colSum = 0.0;                                                                 \n            for(int i = 0; i < imageHeight; i++){                                               \n                int idx = i * imageWidth + outputColumnIndex;                                   \n                colSum += avgImageData[idx];                                                    \n            }                                                                                   \n            VecData[imageHeight+outputColumnIndex] = int(colSum / float(imageHeight) * 255.0);  \n        }                                                                                       \n    }                                                                                     ";
    private final int[] mGLBuffers;

    public GPUVideoStablizationFilter() {
        super(VIDEO_STABILAZATION_COMPUTE_SHADER, GLSLRender.GL_TEXTURE_2D);
        this.mGLBuffers = new int[2];
        init();
    }

    private int[][] copyDataGpuToCpu(int i3, int i16, Buffer buffer) {
        int[] iArr = new int[i3 + i16];
        int[] iArr2 = new int[i3];
        int[] iArr3 = new int[i16];
        if (buffer != null) {
            ByteBuffer byteBuffer = (ByteBuffer) buffer;
            byteBuffer.order(ByteOrder.nativeOrder());
            byteBuffer.asIntBuffer().get(iArr);
        }
        System.arraycopy(iArr, 0, iArr2, 0, i3);
        System.arraycopy(iArr, i3, iArr3, 0, i16);
        return new int[][]{iArr2, iArr3};
    }

    public int[][] glDisPatchVideoStavizationCompute(int i3, int i16, int i17) {
        int i18;
        int i19;
        int useComputeProgram = useComputeProgram();
        GLES20.glGenBuffers(2, this.mGLBuffers, 0);
        checkGlError("glGenBuffers");
        int i26 = (i17 * 4) + (i16 * 4);
        GLES31.glBindImageTexture(0, i3, 0, true, 0, 35000, 32856);
        checkGlError("fill texture");
        GLES20.glBindBuffer(37074, this.mGLBuffers[0]);
        GLES20.glBufferData(37074, i26, null, 35049);
        GLES30.glBindBufferBase(37074, 1, this.mGLBuffers[0]);
        GLES20.glBindBuffer(37074, 0);
        checkGlError("fill heightVecData buffer");
        GLES20.glBindBuffer(37074, this.mGLBuffers[1]);
        GLES20.glBufferData(37074, i16 * i17 * 4, null, 35049);
        GLES30.glBindBufferBase(37074, 2, this.mGLBuffers[1]);
        GLES20.glBindBuffer(37074, 0);
        checkGlError("fill outputAvgImage buffer");
        int glGetUniformLocation = GLES20.glGetUniformLocation(useComputeProgram, "imageHeight");
        checkLocation(glGetUniformLocation, "imageHeight");
        GLES20.glUniform1i(glGetUniformLocation, i17);
        checkGlError("fill uniform  imageHeight");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(useComputeProgram, "imageWidth");
        checkLocation(glGetUniformLocation2, "imageWidth");
        GLES20.glUniform1i(glGetUniformLocation2, i16);
        checkGlError("fill uniform  imageWidth");
        if (i16 % 8 == 0) {
            i18 = i16 / 8;
        } else {
            i18 = (i16 / 8) + 1;
        }
        if (i17 % 8 == 0) {
            i19 = i17 / 8;
        } else {
            i19 = (i17 / 8) + 1;
        }
        GLES31.glDispatchCompute(i18, i19, 1);
        checkGlError("glDispatchCompute");
        GLES31.glMemoryBarrier(32);
        checkGlError("glMemoryBarrier");
        GLES20.glBindBuffer(37074, this.mGLBuffers[0]);
        Buffer glMapBufferRange = GLES30.glMapBufferRange(37074, 0, i26, 1);
        checkGlError("glMapBufferRange");
        int[][] copyDataGpuToCpu = copyDataGpuToCpu(i17, i16, glMapBufferRange);
        GLES30.glUnmapBuffer(37074);
        GLES20.glBindBuffer(37074, 0);
        GLES20.glDeleteBuffers(2, this.mGLBuffers, 0);
        return copyDataGpuToCpu;
    }
}
