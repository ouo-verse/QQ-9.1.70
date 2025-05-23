package com.tencent.mobileqq.videocodec.mediacodec.encoder;

import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.ttpic.openapi.filter.TextureRender;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes20.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static int f312577e;

    /* renamed from: a, reason: collision with root package name */
    private b f312578a;

    /* renamed from: b, reason: collision with root package name */
    private a f312579b;

    /* renamed from: c, reason: collision with root package name */
    private TextureRender f312580c;

    /* renamed from: d, reason: collision with root package name */
    private Surface f312581d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44073);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f312577e = 3;
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int c(c cVar) {
        int i3;
        if (cVar.a() == f312577e) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        com.tencent.xaction.log.b.d("EncodeInputSurface", 1, "initFlag = " + i3, null);
        return i3;
    }

    public void a(int i3, int i16, float[] fArr, float[] fArr2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), fArr, fArr2, Long.valueOf(j3));
            return;
        }
        this.f312580c.drawTexture(i3, i16, fArr, fArr2);
        this.f312578a.e(j3);
        this.f312578a.f();
    }

    public void b(c cVar, Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) surface);
            return;
        }
        this.f312581d = surface;
        a aVar = new a(cVar.b(), c(cVar));
        this.f312579b = aVar;
        b bVar = new b(aVar);
        this.f312578a = bVar;
        bVar.b(surface);
        this.f312578a.c();
        this.f312580c = new TextureRender();
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Surface surface = this.f312581d;
        if (surface != null) {
            surface.release();
            this.f312581d = null;
        }
        b bVar = this.f312578a;
        if (bVar != null) {
            bVar.d();
            this.f312578a = null;
        }
        a aVar = this.f312579b;
        if (aVar != null) {
            aVar.g();
            this.f312579b = null;
        }
        TextureRender textureRender = this.f312580c;
        if (textureRender != null) {
            textureRender.release();
            this.f312580c = null;
        }
    }
}
