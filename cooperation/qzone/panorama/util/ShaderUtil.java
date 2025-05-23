package cooperation.qzone.panorama.util;

import android.opengl.GLES20;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class ShaderUtil {
    public static final String A_POSITION = "aPosition";
    public static final String A_TEXTURE_COORD = "aTextureCoord";
    private static final String TAG = "ShaderUtil";
    public static final String U_COLOR = "uColor";
    public static final String U_PROJECT_MATRIX = "uProjectMatrix";

    private static int compileShader(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader == 0) {
            QZLog.e(TAG, "glCreateShader: fail 0 ");
            return 0;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        QZLog.e(TAG, "glGetShaderiv: " + GLES20.glGetShaderInfoLog(glCreateShader));
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        GLES20.glDeleteShader(glCreateShader);
        QZLog.e(TAG, "glGetShaderiv: fail 0 ");
        return 0;
    }

    public static int getProgramId() {
        try {
            return linkProgram(compileVertexShader(GLSLUtil.VERTEX_SHADER), compileFragmentShader(GLSLUtil.FRAGMENT_SHADER));
        } catch (Exception unused) {
            QZLog.e(TAG, "glCreateShader: fail 0 ");
            return 0;
        }
    }

    private static int linkProgram(int i3, int i16) {
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            QZLog.e(TAG, "glCreateProgram: fail");
            return 0;
        }
        GLES20.glAttachShader(glCreateProgram, i3);
        GLES20.glAttachShader(glCreateProgram, i16);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        QZLog.e(TAG, "glGetShaderiv: " + GLES20.glGetShaderInfoLog(glCreateProgram));
        if (iArr[0] != 0) {
            return glCreateProgram;
        }
        GLES20.glDeleteProgram(glCreateProgram);
        QZLog.e(TAG, "glGetProgramiv: fail 0 ");
        return 0;
    }

    private static int compileFragmentShader(String str) {
        return compileShader(35632, str);
    }

    private static int compileVertexShader(String str) {
        return compileShader(35633, str);
    }
}
