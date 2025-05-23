package com.tencent.mobileqq.magicface.view;

import android.opengl.GLSurfaceView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements GLSurfaceView.Renderer {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private C8000a f243556d;

    /* renamed from: e, reason: collision with root package name */
    private C8000a f243557e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.magicface.model.a f243558f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.magicface.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C8000a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public byte[] f243559a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f243560b;

        /* renamed from: c, reason: collision with root package name */
        public int f243561c;

        /* renamed from: d, reason: collision with root package name */
        public int f243562d;

        /* renamed from: e, reason: collision with root package name */
        public int f243563e;

        /* renamed from: f, reason: collision with root package name */
        public int f243564f;

        /* renamed from: g, reason: collision with root package name */
        public float f243565g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f243566h;

        C8000a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            } else {
                this.f243559a = null;
                this.f243560b = null;
            }
        }

        public boolean a(byte[] bArr, byte[] bArr2, int i3, int i16, int i17, int i18, float f16, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, bArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Float.valueOf(f16), Boolean.valueOf(z16))).booleanValue();
            }
            if (bArr == null) {
                return false;
            }
            byte[] bArr3 = this.f243559a;
            if (bArr3 == null) {
                this.f243559a = new byte[bArr.length];
            } else if (bArr3.length != bArr.length) {
                this.f243559a = new byte[bArr.length];
            }
            byte[] bArr4 = this.f243559a;
            if (bArr4 == null) {
                return false;
            }
            System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
            byte[] bArr5 = this.f243560b;
            if (bArr5 == null) {
                this.f243560b = new byte[bArr2.length];
            } else if (bArr5.length != bArr2.length) {
                this.f243560b = new byte[bArr2.length];
            }
            byte[] bArr6 = this.f243560b;
            if (bArr6 == null) {
                return false;
            }
            System.arraycopy(bArr2, 0, bArr6, 0, bArr2.length);
            this.f243561c = i17;
            this.f243562d = i18;
            this.f243563e = i3;
            this.f243564f = i16;
            this.f243565g = f16;
            this.f243566h = z16;
            return true;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f243556d = null;
            this.f243557e = null;
        }
    }

    public void a(byte[] bArr, byte[] bArr2, int i3, int i16, int i17, int i18, float f16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Float.valueOf(f16), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GLRender", 2, "func copyFrame2Render begins, datas:" + bArr);
        }
        if (this.f243557e == null) {
            this.f243557e = new C8000a();
        }
        if (this.f243557e.a(bArr, bArr2, i3, i16, i17, i18, f16, z16)) {
            synchronized (this) {
                this.f243556d = this.f243557e;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("GLRender", 2, "func copyFrame2Render ends, mCurData:" + this.f243556d);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public synchronized void onDrawFrame(GL10 gl10) {
        com.tencent.mobileqq.magicface.model.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gl10);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GLRender", 2, "func onDrawFrame begins, gl:" + gl10);
        }
        C8000a c8000a = this.f243556d;
        if (c8000a != null && (aVar = this.f243558f) != null) {
            try {
                aVar.b(c8000a.f243559a, c8000a.f243560b, c8000a.f243563e, c8000a.f243564f, c8000a.f243561c, c8000a.f243562d, c8000a.f243565g, c8000a.f243566h);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            if (QLog.isColorLevel()) {
                QLog.d("GLRender", 2, "func onDrawFrame ends. One FRAME is drawn.");
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GLRender", 2, "func onDrawFrame ends, NULL data, mCurData:" + this.f243556d + ",mBitmapDisplayer:" + this.f243558f);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, gl10, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            gl10.glViewport(0, 0, i3, i16);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gl10, (Object) eGLConfig);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GLRender", 2, "func onSurfaceCreated begins");
        }
        synchronized (this) {
            this.f243558f = new com.tencent.mobileqq.magicface.model.a();
            this.f243556d = null;
        }
        gl10.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        if (QLog.isColorLevel()) {
            QLog.d("GLRender", 2, "func onSurfaceCreated ends");
        }
    }
}
