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
public class GPUAvgPixelsFilter extends GPUComputeShaderFilter {
    private static final String TAG = "GPUVideoStablizationFilter";
    public static final String VIDEO_IMG_FILTER_COMPUTE_SHADER = "    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (rgba8, binding = 0) readonly  uniform  highp image2D inputImage;                    \n    layout (std430,binding = 1) buffer AvgPixlesData{                                              \n        int avgPixels[];                                                                        \n    };                                                                                          \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n       int outputRowIndex = int(gl_GlobalInvocationID.y);                                        \n       int outputColumnIndex = int(gl_GlobalInvocationID.x);                                  \n       if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                           \n       }                                                                                            \n       vec4 inputValue = imageLoad(inputImage, ivec2(gl_GlobalInvocationID.xy));                   \n       barrier();                                                                                          \n       int index = outputRowIndex*imageWidth+outputColumnIndex;                  \n       float avgValue =  float(inputValue.r*0.299 + inputValue.g*0.587 + inputValue.b*0.114);              \n       avgPixels[index] = int(avgValue * 255.0);                                                            \n   }                                                        ";
    ByteOrder byteOrder;

    public GPUAvgPixelsFilter() {
        super(VIDEO_IMG_FILTER_COMPUTE_SHADER, GLSLRender.GL_TEXTURE_2D);
        this.byteOrder = ByteOrder.nativeOrder();
        init();
    }

    private int[] copyDataGpuToCpu(int i3, int i16, Buffer buffer) {
        int[] iArr = new int[i3 * i16];
        if (buffer != null) {
            ByteBuffer byteBuffer = (ByteBuffer) buffer;
            byteBuffer.order(this.byteOrder);
            byteBuffer.asIntBuffer().get(iArr);
        }
        return iArr;
    }

    public int[] glDisPatchGPUAvgPixelsFilterCompute(int i3, int i16, int i17, int[] iArr, int i18) {
        int useComputeProgram = useComputeProgram();
        GLES31.glBindImageTexture(0, i3, 0, true, 0, 35000, 32856);
        checkGlError("fill inputImage texture");
        GLES20.glBindBuffer(37074, iArr[0]);
        int i19 = i16 * i17 * 4;
        GLES20.glBufferData(37074, i19, null, 35049);
        GLES30.glBindBufferBase(37074, 1, iArr[0]);
        GLES20.glBindBuffer(37074, 0);
        checkGlError("fill avgData buffer");
        int glGetUniformLocation = GLES20.glGetUniformLocation(useComputeProgram, "imageHeight");
        checkLocation(glGetUniformLocation, "imageHeight");
        GLES20.glUniform1i(glGetUniformLocation, i17);
        checkGlError("fill uniform  imageHeight");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(useComputeProgram, "imageWidth");
        checkLocation(glGetUniformLocation2, "imageWidth");
        GLES20.glUniform1i(glGetUniformLocation2, i16);
        checkGlError("fill uniform  imageWidth");
        int alignment16 = getAlignment16(i16);
        int alignment162 = getAlignment16(i17);
        int i26 = alignment16 % 8;
        int i27 = alignment16 / 8;
        if (i26 != 0) {
            i27++;
        }
        int i28 = alignment162 % 8;
        int i29 = alignment162 / 8;
        if (i28 != 0) {
            i29++;
        }
        GLES31.glDispatchCompute(i27, i29, 1);
        checkGlError("glDispatchCompute");
        GLES31.glMemoryBarrier(32);
        checkGlError("glMemoryBarrier");
        GLES20.glBindBuffer(37074, iArr[0]);
        Buffer glMapBufferRange = GLES30.glMapBufferRange(37074, 0, i19, 1);
        checkGlError("glMapBufferRange");
        int[] copyDataGpuToCpu = copyDataGpuToCpu(i17, i16, glMapBufferRange);
        GLES30.glUnmapBuffer(37074);
        GLES20.glBindBuffer(37074, 0);
        return copyDataGpuToCpu;
    }
}
