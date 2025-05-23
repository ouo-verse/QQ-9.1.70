package org.tencwebrtc;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class GlUtil {
    GlUtil() {
    }

    public static void checkNoGLES2Error(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": GLES20 error: " + glGetError);
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int generateTexture(int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i16 = iArr[0];
        GLES20.glBindTexture(i3, i16);
        GLES20.glTexParameterf(i3, 10241, 9729.0f);
        GLES20.glTexParameterf(i3, 10240, 9729.0f);
        GLES20.glTexParameterf(i3, 10242, 33071.0f);
        GLES20.glTexParameterf(i3, 10243, 33071.0f);
        checkNoGLES2Error("generateTexture");
        return i16;
    }
}
