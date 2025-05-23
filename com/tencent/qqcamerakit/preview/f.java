package com.tencent.qqcamerakit.preview;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f344952a;

    /* renamed from: b, reason: collision with root package name */
    private int f344953b;

    /* renamed from: c, reason: collision with root package name */
    private int f344954c;

    /* renamed from: d, reason: collision with root package name */
    private int f344955d;

    /* renamed from: e, reason: collision with root package name */
    private int f344956e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f344957f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f344958g;

    /* renamed from: h, reason: collision with root package name */
    private int f344959h;

    /* renamed from: i, reason: collision with root package name */
    private int f344960i;

    public f(int i3, int i16, int i17) {
        this(true, i3, i16, i17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        GLES20.glViewport(0, 0, this.f344959h, this.f344960i);
        GLES20.glBindFramebuffer(36160, this.f344956e);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.f344952a, 0);
        if (this.f344957f) {
            GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.f344955d);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f344960i;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f344952a;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f344959h;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    public f(boolean z16, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f344952a = 0;
        this.f344953b = 0;
        this.f344955d = 0;
        this.f344956e = 0;
        this.f344958g = false;
        this.f344959h = i3;
        this.f344960i = i16;
        this.f344954c = i17;
        this.f344957f = z16;
        int[] iArr = new int[1];
        GLES20.glActiveTexture(i17);
        int d16 = e.d(GLSLRender.GL_TEXTURE_2D);
        this.f344952a = d16;
        this.f344953b = d16;
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i18 = iArr[0];
        this.f344956e = i18;
        GLES20.glBindFramebuffer(36160, i18);
        if (z16) {
            GLES20.glGenRenderbuffers(1, iArr, 0);
            int i19 = iArr[0];
            this.f344955d = i19;
            GLES20.glBindRenderbuffer(36161, i19);
            GLES20.glRenderbufferStorage(36161, 33189, i3, i16);
        }
        e();
    }
}
