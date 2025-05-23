package com.tencent.mobileqq.shortvideo.panoramicvideo.GL;

import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TextureUtil {
    public static final int NO_TEXTURE = 0;
    private static final String TAG = "TextureUtils";

    public static void bindTexture2D(int i3, int i16, int i17, int i18) {
        if (i3 != 0) {
            GLES20.glActiveTexture(i16);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
            GLES20.glUniform1i(i17, i18);
        }
    }
}
