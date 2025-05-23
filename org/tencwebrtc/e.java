package org.tencwebrtc;

import android.content.Context;
import android.graphics.Matrix;
import android.view.WindowManager;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
/* loaded from: classes29.dex */
public final /* synthetic */ class e {
    public static VideoFrame.TextureBuffer a(TextureBufferImpl textureBufferImpl, boolean z16, int i3) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        if (z16) {
            matrix.preScale(-1.0f, 1.0f);
        }
        matrix.preRotate(i3);
        matrix.preTranslate(-0.5f, -0.5f);
        return textureBufferImpl.applyTransformMatrix(matrix, textureBufferImpl.getWidth(), textureBufferImpl.getHeight());
    }

    public static int b(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    return 0;
                }
                return 270;
            }
            return 180;
        }
        return 90;
    }
}
