package fe0;

import android.opengl.GLES20;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes5.dex */
class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String str, String str2, int i3) {
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str2);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e(str, "Error compiling shader: " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            glCreateShader = 0;
        }
        if (glCreateShader != 0) {
            return glCreateShader;
        }
        throw new RuntimeException("Error creating shader.");
    }
}
