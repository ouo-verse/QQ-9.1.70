package cooperation.qzone.panorama.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.filter.GLSLRender;
import cooperation.qzone.panorama.piece.PieceCacheList;
import cooperation.qzone.panorama.piece.PieceData;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TextureUtil {
    private static final String TAG = "TextureUtil";

    public static void deleteTexture(int i3) {
        GLES20.glDeleteTextures(1, new int[]{i3}, 0);
        GLES20.glFinish();
    }

    public static int genTextureId(Bitmap bitmap, boolean z16) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] == 0) {
            QZLog.e(TAG, "glGenTextures: fail 0 ");
            return 0;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
            if (z16) {
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9728);
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9728);
            } else {
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9728);
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
            }
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
            GLES20.glGenerateMipmap(GLSLRender.GL_TEXTURE_2D);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            return iArr[0];
        }
        QZLog.e(TAG, "loadTexture: bitmap  == null || isRecycled");
        GLES20.glDeleteTextures(1, iArr, 0);
        return 0;
    }

    public static void deleteTexture(PieceCacheList pieceCacheList) {
        if (pieceCacheList == null) {
            return;
        }
        for (int i3 = 0; i3 < pieceCacheList.size(); i3++) {
            PieceData valueAt = pieceCacheList.valueAt(i3);
            if (valueAt != null) {
                valueAt.recycleOrgTexture();
            }
        }
    }
}
