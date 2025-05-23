package com.tencent.mobileqq.richmedia.mediacodec.computeShader;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLES31;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@SuppressLint({"NewApi"})
/* loaded from: classes18.dex */
public class GPUImgFilterRecoverFilter extends GPUComputeShaderFilter {
    private static final String TAG = "GPUVideoStablizationFilter";
    public static final String VIDEO_IMG_FILTER_COMPUTE_SHADER = "    #version 310 es                                                                             \n                                                                                                \n    layout (local_size_x = 8, local_size_y = 8, local_size_z = 1) in;                           \n    layout (rgba8, binding = 0) readonly  uniform  highp image2D inputImage;                    \n    layout (rgba8, binding = 1) writeonly uniform  highp image2D outputImage;                   \n    layout (rgba8, binding = 2) readonly  uniform  highp image2D TImage;                        \n    layout (std430,binding = 3) buffer Avalue{                                                  \n        float aValueData[3];                                                                    \n    };                                                                                          \n    uniform int imageHeight;                                                                    \n    uniform int imageWidth;                                                                     \n                                                                                                \n    void main(){                                                                                \n        int outputRowIndex = int(gl_GlobalInvocationID.y);                                      \n        int outputColumnIndex = int(gl_GlobalInvocationID.x);                                   \n        if(outputRowIndex >= imageHeight || outputColumnIndex >= imageWidth){                   \n            return;                                                                             \n        }                                                                                       \n        vec4 inputValue = imageLoad(inputImage, ivec2(gl_GlobalInvocationID.xy));               \n        vec4 TValue = imageLoad(TImage, ivec2(gl_GlobalInvocationID.xy));                       \n        barrier();                                                                              \n        int index = (imageHeight - 1 - outputRowIndex) * imageWidth + outputColumnIndex;        \n        float Tx = TValue.r;                                         \n        Tx = TValue.r >= 1.0 ? 1.0 :  TValue.r;                                   \n        Tx = Tx >= 0.1 ? Tx :  0.1;                                   \n        float outputR = (inputValue.r - aValueData[0])/Tx +  aValueData[0];              \n        float outputG = (inputValue.g - aValueData[1])/Tx +  aValueData[1];              \n        float outputB = (inputValue.b - aValueData[2])/Tx +  aValueData[2];              \n        outputR = outputR < 0.0 ? 0.0 : outputR;              \n        outputR = outputR > 1.0 ? 1.0 : outputR;              \n        outputG = outputG < 0.0 ? 0.0 : outputG;              \n        outputG = outputG > 1.0 ? 1.0 : outputG;              \n        outputB = outputB < 0.0 ? 0.0 : outputB;              \n        outputB = outputB > 1.0 ? 1.0 : outputB;              \n        vec4 ouputRGBA = vec4(outputR,outputG,outputB,inputValue.a);                            \n        imageStore(outputImage,ivec2(gl_GlobalInvocationID.xy),ouputRGBA);                      \n    }                                                                                     ";
    ByteOrder byteOrder;

    public GPUImgFilterRecoverFilter() {
        super(VIDEO_IMG_FILTER_COMPUTE_SHADER, GLSLRender.GL_TEXTURE_2D);
        this.byteOrder = ByteOrder.nativeOrder();
        init();
    }

    public int glDisPatchImgFilterCompute(int[] iArr, int i3, int i16, int i17, float f16, int i18, int i19, float[] fArr) {
        int useComputeProgram = useComputeProgram();
        GLES31.glBindImageTexture(0, i3, 0, true, 0, 35000, 32856);
        checkGlError("fill inputImage texture");
        GLES31.glBindImageTexture(1, i16, 0, true, 0, 35001, 32856);
        checkGlError("fill outputImage texture");
        GLES31.glBindImageTexture(2, i17, 0, true, 0, 35000, 32856);
        checkGlError("fill tImage texture");
        float[] fArr2 = new float[3];
        for (int i26 = 0; i26 < 3; i26++) {
            fArr2[i26] = f16 / 255.0f;
        }
        FloatBuffer createFloatBuffer = GlUtil.createFloatBuffer(fArr2, this.byteOrder);
        GLES20.glBindBuffer(37074, iArr[4]);
        GLES20.glBufferData(37074, 12, createFloatBuffer, 35049);
        GLES30.glBindBufferBase(37074, 3, iArr[4]);
        GLES20.glBindBuffer(37074, 0);
        checkGlError("fill aValueData buffer");
        int glGetUniformLocation = GLES20.glGetUniformLocation(useComputeProgram, "imageHeight");
        checkLocation(glGetUniformLocation, "imageHeight");
        GLES20.glUniform1i(glGetUniformLocation, i19);
        checkGlError("fill uniform  imageHeight");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(useComputeProgram, "imageWidth");
        checkLocation(glGetUniformLocation2, "imageWidth");
        GLES20.glUniform1i(glGetUniformLocation2, i18);
        checkGlError("fill uniform  imageWidth");
        int alignment16 = getAlignment16(i18);
        int alignment162 = getAlignment16(i19);
        int i27 = alignment16 % 8;
        int i28 = alignment16 / 8;
        if (i27 != 0) {
            i28++;
        }
        int i29 = alignment162 % 8;
        int i36 = alignment162 / 8;
        if (i29 != 0) {
            i36++;
        }
        GLES31.glDispatchCompute(i28, i36, 1);
        checkGlError("glDispatchCompute");
        GLES31.glMemoryBarrier(32);
        checkGlError("glMemoryBarrier");
        return i16;
    }
}
