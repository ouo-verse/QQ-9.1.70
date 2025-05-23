package com.tencent.state.square.media.utils;

import android.opengl.GLES20;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/media/utils/ShaderUtil;", "", "()V", "TAG", "", "compileShader", "", "shaderType", "shaderSource", "createAndLinkProgram", "vertexShaderHandle", "fragmentShaderHandle", "createProgram", "vertexSource", "fragmentSource", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ShaderUtil {
    public static final ShaderUtil INSTANCE = new ShaderUtil();
    private static final String TAG = "Square_ShaderUtil";

    ShaderUtil() {
    }

    private final int compileShader(int shaderType, String shaderSource) {
        int glCreateShader = GLES20.glCreateShader(shaderType);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, shaderSource);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "Error compiling shader: " + GLES20.glGetShaderInfoLog(glCreateShader), null, 4, null);
                GLES20.glDeleteShader(glCreateShader);
                glCreateShader = 0;
            }
        }
        if (glCreateShader != 0) {
            return glCreateShader;
        }
        throw new RuntimeException("Error creating shader.");
    }

    private final int createAndLinkProgram(int vertexShaderHandle, int fragmentShaderHandle) {
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, vertexShaderHandle);
            GLES20.glAttachShader(glCreateProgram, fragmentShaderHandle);
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] == 0) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "Error compiling program: " + GLES20.glGetProgramInfoLog(glCreateProgram), null, 4, null);
                GLES20.glDeleteProgram(glCreateProgram);
                glCreateProgram = 0;
            }
        }
        if (glCreateProgram != 0) {
            return glCreateProgram;
        }
        throw new RuntimeException("Error creating program.");
    }

    public final int createProgram(String vertexSource, String fragmentSource) {
        Intrinsics.checkNotNullParameter(vertexSource, "vertexSource");
        Intrinsics.checkNotNullParameter(fragmentSource, "fragmentSource");
        return createAndLinkProgram(compileShader(35633, vertexSource), compileShader(35632, fragmentSource));
    }
}
