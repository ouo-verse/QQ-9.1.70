package com.tencent.filter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;

/* loaded from: classes6.dex */
public class TextureResParam extends UniformParam.TextureParam {
    static IPatchRedirector $redirector_;
    private int flipy;
    private double ratio;
    private String textureResName;

    public TextureResParam(String str, String str2, int i3, double d16) {
        super(str, 0, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), Double.valueOf(d16));
            return;
        }
        this.flipy = 0;
        this.textureResName = str2;
        this.ratio = d16;
    }

    @Override // com.tencent.aekit.openrender.UniformParam.TextureParam, com.tencent.aekit.openrender.UniformParam
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        GLES20.glActiveTexture(this.textureId);
        GlUtil.glDeleteTextures(1, this.texture, 0);
        super.clear();
    }

    @Override // com.tencent.aekit.openrender.UniformParam
    public void initialParams(int i3) {
        Bitmap decodeBitmap;
        Bitmap cropCenter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        super.initialParams(i3);
        if (this.textureResName == null) {
            return;
        }
        GLES20.glActiveTexture(this.textureId);
        GlUtil.glGenTextures(1, this.texture, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.texture[0]);
        if (this.textureResName.startsWith("assets://")) {
            decodeBitmap = BitmapUtils.decodeBitmap(FileUtils.getRealPath(this.textureResName), false);
        } else {
            decodeBitmap = BitmapUtils.decodeBitmap(this.textureResName, false);
            if (decodeBitmap == null) {
                decodeBitmap = BitmapUtils.decodeBitmap(this.textureResName, true);
            }
        }
        Bitmap bitmap = null;
        if (decodeBitmap != null) {
            double d16 = this.ratio;
            if (d16 > 0.0d) {
                if (d16 < 1.0d) {
                    cropCenter = BitmapUtils.cropCenter(decodeBitmap, (int) (decodeBitmap.getHeight() * this.ratio), decodeBitmap.getHeight(), false);
                } else {
                    cropCenter = BitmapUtils.cropCenter(decodeBitmap, decodeBitmap.getWidth(), (int) (decodeBitmap.getWidth() / this.ratio), false);
                }
                decodeBitmap.recycle();
                decodeBitmap = null;
                bitmap = cropCenter;
            } else {
                bitmap = decodeBitmap;
            }
        } else {
            Log.e("Param", "lastBitmap is null " + this.textureResName);
        }
        if (this.flipy == 1) {
            Matrix matrix = new Matrix();
            matrix.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, decodeBitmap.getHeight(), 0.0f, 0.0f, 1.0f});
            Bitmap createBitmap = BitmapUtils.createBitmap(decodeBitmap, 0, 0, decodeBitmap.getWidth(), decodeBitmap.getHeight(), matrix);
            if (createBitmap != null) {
                decodeBitmap.recycle();
                decodeBitmap = createBitmap;
            }
        } else {
            decodeBitmap = bitmap;
        }
        if (decodeBitmap != null) {
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, decodeBitmap, 0);
            decodeBitmap.recycle();
        } else {
            Log.e("Param", "bitmap is null");
        }
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
    }

    public TextureResParam(String str, String str2, int i3) {
        super(str, 0, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3));
            return;
        }
        this.ratio = 0.0d;
        this.flipy = 0;
        this.textureResName = str2;
    }

    public TextureResParam(String str, String str2, int i3, int i16) {
        super(str, 0, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.ratio = 0.0d;
        this.textureResName = str2;
        this.flipy = i16;
    }
}
