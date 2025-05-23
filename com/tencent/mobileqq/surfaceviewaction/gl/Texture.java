package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes18.dex */
public class Texture {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    int f291254a;

    /* renamed from: b, reason: collision with root package name */
    Bitmap f291255b;

    /* renamed from: c, reason: collision with root package name */
    boolean f291256c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f291257d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f291258e;

    /* renamed from: f, reason: collision with root package name */
    private SpriteGLView f291259f;

    /* renamed from: g, reason: collision with root package name */
    private String f291260g;

    public Texture(Context context, SpriteGLView spriteGLView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, spriteGLView, str);
            return;
        }
        this.f291256c = false;
        this.f291257d = false;
        this.f291259f = spriteGLView;
        this.f291260g = str;
        try {
            this.f291258e = c(str);
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Texture", 2, QLog.getStackTraceString(e16));
            }
        }
    }

    private byte[] c(String str) throws IOException {
        File file = new File(str);
        long length = file.length();
        if (length > TTL.MAX_VALUE) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        int i3 = (int) length;
        try {
            byte[] bArr = new byte[i3];
            int i16 = 0;
            while (i16 < i3) {
                try {
                    int read = fileInputStream.read(bArr, i16, i3 - i16);
                    if (read < 0) {
                        break;
                    }
                    i16 += read;
                } catch (IOException unused) {
                    fileInputStream.close();
                    throw new IOException("Could not completely read file " + file.getName());
                }
            }
            if (i16 == i3) {
                fileInputStream.close();
                if (QLog.isColorLevel()) {
                    QLog.d("Texture", 2, "getContent: filePath = " + this.f291260g);
                }
                return bArr;
            }
            fileInputStream.close();
            throw new IOException("Could not completely read file " + file.getName());
        } catch (OutOfMemoryError unused2) {
            fileInputStream.close();
            throw new IOException("No enought memory to new bytes: " + length);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f291258e != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                byte[] bArr = this.f291258e;
                this.f291255b = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
                if (QLog.isColorLevel()) {
                    QLog.d("Texture", 2, "new Texture: decode time = " + currentTimeMillis2);
                }
                this.f291256c = true;
                this.f291259f.t(new Runnable() { // from class: com.tencent.mobileqq.surfaceviewaction.gl.Texture.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Texture.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            Texture.this.d();
                        }
                    }
                });
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Texture", 2, "Texture: cannot decode (" + this.f291260g + "): " + QLog.getStackTraceString(e16));
                }
            }
            this.f291258e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        Bitmap bitmap = this.f291255b;
        if (bitmap != null && !bitmap.isRecycled() && !this.f291257d) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            this.f291259f.n(this.f291254a);
            int i3 = iArr[0];
            this.f291254a = i3;
            this.f291259f.k(i3);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f291254a);
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, this.f291255b, 0);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9728.0f);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            if (!this.f291259f.J) {
                this.f291255b.recycle();
            }
            this.f291257d = true;
            if (QLog.isColorLevel()) {
                QLog.d("Texture", 2, "Texture->load: textureId = " + this.f291254a + ", filePath = " + this.f291260g);
            }
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            f(false);
        }
    }

    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.surfaceviewaction.gl.Texture.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Texture.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                int i3 = Texture.this.f291254a;
                if (i3 != 0) {
                    GLES20.glDeleteTextures(1, new int[]{i3}, 0);
                    GLES20.glFlush();
                    if (QLog.isColorLevel()) {
                        QLog.d("Texture", 2, "Texture->release real: textureId = " + Texture.this.f291254a + ", filePath = " + Texture.this.f291260g);
                    }
                    Texture.this.f291254a = 0;
                }
                Bitmap bitmap = Texture.this.f291255b;
                if (bitmap != null && !bitmap.isRecycled()) {
                    Texture.this.f291255b.recycle();
                    Texture.this.f291255b = null;
                }
            }
        };
        if (z16) {
            runnable.run();
        } else {
            this.f291259f.t(runnable);
        }
    }

    public Texture(SpriteGLView spriteGLView, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) spriteGLView, (Object) bitmap);
            return;
        }
        this.f291257d = false;
        this.f291259f = spriteGLView;
        this.f291255b = bitmap;
        this.f291256c = true;
        spriteGLView.t(new Runnable() { // from class: com.tencent.mobileqq.surfaceviewaction.gl.Texture.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Texture.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("Texture", 2, "runOnSurfaceViewThread load()");
                }
                Texture.this.d();
            }
        });
    }
}
