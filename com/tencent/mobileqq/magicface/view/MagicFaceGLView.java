package com.tencent.mobileqq.magicface.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.magicface.view.MagicfaceView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MagicFaceGLView extends GLSurfaceView implements SurfaceHolder.Callback, b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private a f243515d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f243516e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f243517f;

    /* renamed from: h, reason: collision with root package name */
    private MagicfaceView.a f243518h;

    public MagicFaceGLView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f243516e = false;
        this.f243517f = false;
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceGLView", 2, "func [gl] MagicFaceGLView begins");
        }
        try {
            setEGLContextClientVersion(2);
            setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            a aVar = new a();
            this.f243515d = aVar;
            setRenderer(aVar);
            setRenderMode(0);
        } catch (Throwable th5) {
            QLog.d("MagicFaceGLView", 2, "create magicFaceView " + th5);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceGLView", 2, "func [gl] MagicFaceGLView ends");
        }
    }

    @Override // com.tencent.mobileqq.magicface.view.b
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f243517f;
    }

    @Override // com.tencent.mobileqq.magicface.model.MagicfaceDecoder.b
    public void b(byte[] bArr, byte[] bArr2, int i3, int i16, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, bArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceGLView", 2, "func [gl] frameDataGL begins, srcwidth:" + i3 + ",srcheight:" + i16 + ",degree:" + f16);
        }
        d(bArr, bArr2, i3, i16, f16);
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceGLView", 2, "func [gl] frameDataGL ends");
        }
    }

    @Override // com.tencent.mobileqq.magicface.model.MagicfaceDecoder.b
    public void c(int[] iArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, iArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void d(byte[] bArr, byte[] bArr2, int i3, int i16, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16));
            return;
        }
        a aVar = this.f243515d;
        if (aVar == null) {
            return;
        }
        aVar.a(bArr, bArr2, i3, i16, getWidth(), getHeight(), f16, this.f243516e);
        requestRender();
    }

    @Override // com.tencent.mobileqq.magicface.view.b
    public void setIsFullScreen(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f243516e = z16;
        }
    }

    @Override // com.tencent.mobileqq.magicface.view.b
    public void setSurfaceCreatelistener(MagicfaceView.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f243518h = aVar;
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) surfaceHolder);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceGLView", 2, "func [gl] surfaceCreated begins");
        }
        super.surfaceCreated(surfaceHolder);
        this.f243517f = true;
        MagicfaceView.a aVar = this.f243518h;
        if (aVar != null) {
            aVar.a();
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceGLView", 2, "func [gl] surfaceCreated ends");
        }
    }
}
