package com.tencent.view;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.ttpic.baseutils.device.DeviceAttrs;

/* loaded from: classes27.dex */
public class Photo {
    static IPatchRedirector $redirector_ = null;
    private static final String FRAGMENT_SHADER = "precision mediump float;\nuniform sampler2D tex_sampler;\nvarying vec2 v_texcoord;\nvoid main() {\ngl_FragColor = texture2D(tex_sampler, v_texcoord);\n}\n";
    private static final float[] POS_VERTICES;
    private static final int TEXTUREUNSET = -20000;
    private static final float[] TEX_VERTICES;
    private static final String VERTEX_SHADER = "attribute vec4 a_position;\nattribute vec2 a_texcoord;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_Position = a_position;\n  v_texcoord = a_texcoord;\n}\n";
    private int height;
    private int texture;
    private int width;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ErrorCode.SRERR_EMPTY_VOICE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            TEX_VERTICES = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
            POS_VERTICES = new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
        }
    }

    public Photo(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.texture = i3;
        this.width = i16;
        this.height = i17;
    }

    private void copyFBO(Photo photo) {
        this.width = photo.width;
        this.height = photo.height;
        int i3 = this.texture;
        if (i3 != -20000) {
            RendererUtils.clearTexture(i3);
        }
        this.texture = RendererUtils.createTexture();
        GLES20.glActiveTexture(33984);
        GlUtil.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.texture);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        RendererUtils.renderTexture2FBO(RendererUtils.createFilterProgram(VERTEX_SHADER, FRAGMENT_SHADER, POS_VERTICES, TEX_VERTICES), photo.texture(), this.texture, this.width, this.height);
    }

    private void copySave(Photo photo) {
        this.width = photo.width;
        this.height = photo.height;
        int i3 = this.texture;
        if (i3 != -20000) {
            RendererUtils.clearTexture(i3);
        }
        Bitmap save = photo.save();
        this.texture = RendererUtils.createTexture(save);
        if (save != null && !save.isRecycled()) {
            save.recycle();
        }
    }

    public static Photo create(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Photo photo = new Photo(RendererUtils.createTexture(bitmap), bitmap.getWidth(), bitmap.getHeight());
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return photo;
    }

    public static Photo createWithoutRecycle(Bitmap bitmap) {
        if (bitmap != null) {
            return new Photo(RendererUtils.createTexture(bitmap), bitmap.getWidth(), bitmap.getHeight());
        }
        return null;
    }

    public void changeBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap);
            return;
        }
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
        RendererUtils.clearTexture(this.texture);
        this.texture = RendererUtils.createTexture(bitmap);
    }

    public void changeDimension(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.width = i3;
        this.height = i16;
        RendererUtils.clearTexture(this.texture);
        this.texture = RendererUtils.createTexture();
    }

    public void changeImage(QImage qImage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qImage);
            return;
        }
        this.width = qImage.getWidth();
        this.height = qImage.getHeight();
        GLSLRender.nativeTextImage(qImage, this.texture);
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        int i3 = this.texture;
        if (i3 != -20000) {
            RendererUtils.clearTexture(i3);
            this.texture = -20000;
        }
    }

    public void copy(Photo photo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) photo);
        } else {
            if (this.texture != photo.texture()) {
                copyFBO(photo);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public int height() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.height;
    }

    public boolean matchDimension(Photo photo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) photo)).booleanValue();
        }
        if (photo.width == this.width && photo.height == this.height) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap save() {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Bitmap) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        int i3 = this.texture;
        if (DeviceAttrs.getInstance().gpuProcessNeedBackTexture) {
            i3 = RendererUtils.createTexture();
            GLES20.glActiveTexture(33984);
            GlUtil.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            RendererUtils.renderTexture2FBO(RendererUtils.createFilterProgram(VERTEX_SHADER, FRAGMENT_SHADER, POS_VERTICES, TEX_VERTICES), this.texture, i3, this.width, this.height);
        }
        try {
            bitmap = RendererUtils.saveTexture(i3, this.width, this.height);
        } catch (Exception e16) {
            e16.printStackTrace();
            bitmap = null;
            if (DeviceAttrs.getInstance().gpuProcessNeedBackTexture) {
            }
            return bitmap;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            bitmap = null;
            if (DeviceAttrs.getInstance().gpuProcessNeedBackTexture) {
            }
            return bitmap;
        }
        if (DeviceAttrs.getInstance().gpuProcessNeedBackTexture) {
            RendererUtils.clearTexture(i3);
        }
        return bitmap;
    }

    public QImage saveImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (QImage) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (DeviceAttrs.getInstance().gpuProcessNeedBackTexture) {
            Bitmap save = save();
            QImage Bitmap2QImage = QImage.Bitmap2QImage(save);
            if (save != null && !save.isRecycled()) {
                save.recycle();
            }
            return Bitmap2QImage;
        }
        return RendererUtils.saveTexture2QImage(this.texture, this.width, this.height);
    }

    public void setHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.height = i3;
        }
    }

    public void setTexture(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.texture = i3;
        }
    }

    public void setWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.width = i3;
        }
    }

    public void swap(Photo photo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) photo);
            return;
        }
        int i3 = photo.texture;
        photo.texture = this.texture;
        this.texture = i3;
        int i16 = photo.height;
        photo.height = this.height;
        this.height = i16;
        int i17 = photo.width;
        photo.width = this.width;
        this.width = i17;
    }

    public int texture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.texture;
    }

    public int width() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.width;
    }

    public static Photo create(int i3, int i16) {
        return new Photo(RendererUtils.createTexture(), i3, i16);
    }

    public static Photo create(Photo photo) {
        if (photo == null) {
            return null;
        }
        Photo photo2 = new Photo(-20000, photo.width, photo.height);
        photo2.copy(photo);
        return photo2;
    }

    public static Photo create(int i3, int i16, int i17) {
        return new Photo(i3, i16, i17);
    }
}
