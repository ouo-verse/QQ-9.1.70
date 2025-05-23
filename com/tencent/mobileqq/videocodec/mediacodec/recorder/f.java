package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int[] f312643a;

    /* renamed from: b, reason: collision with root package name */
    private Frame[] f312644b;

    /* renamed from: c, reason: collision with root package name */
    private GPUBaseFilter f312645c;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f312646d;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f312647e;

    /* renamed from: f, reason: collision with root package name */
    private int f312648f;

    /* renamed from: g, reason: collision with root package name */
    private int f312649g;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f312643a = new int[3];
        this.f312644b = new Frame[3];
        this.f312646d = 0;
        this.f312647e = 0;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f312646d = 0;
        this.f312647e = 0;
        GPUBaseFilter gPUBaseFilter = this.f312645c;
        if (gPUBaseFilter != null) {
            gPUBaseFilter.destroy();
        }
        int[] iArr = this.f312643a;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
        for (int i3 = 0; i3 < 3; i3++) {
            Frame frame = this.f312644b[i3];
            if (frame != null) {
                frame.clear();
            }
        }
    }

    public synchronized void b(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (z16) {
            this.f312646d += i3;
        } else {
            this.f312647e += i3;
        }
    }

    public void c(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        GPUBaseFilter gPUBaseFilter = new GPUBaseFilter();
        this.f312645c = gPUBaseFilter;
        gPUBaseFilter.init();
        int[] iArr = this.f312643a;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        for (int i17 = 0; i17 < 3; i17++) {
            this.f312644b[i17] = new Frame();
        }
        this.f312648f = i3;
        this.f312649g = i16;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (Math.min(1, this.f312646d - this.f312647e) == 1) {
            return this.f312643a[this.f312647e % 3];
        }
        return -1;
    }

    public boolean e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        if (Math.min(1, 3 - (this.f312646d - this.f312647e)) != 1) {
            return false;
        }
        int i16 = this.f312646d % 3;
        this.f312644b[i16].bindFrame(this.f312643a[i16], this.f312648f, this.f312649g, 1.0d);
        GlUtil.checkGlError("bindFrame");
        this.f312645c.drawTexture(i3, null, null);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glFinish();
        b(true, 1);
        return true;
    }
}
