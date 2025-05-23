package com.tencent.qfsmonet.outputstream;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.api.MonetContext;
import com.tencent.qfsmonet.api.data.MonetGLTexturePacket;
import com.tencent.qfsmonet.api.data.MonetPacket;
import com.tencent.qfsmonet.api.outputstream.IMonetSurfaceOutputStream;
import com.tencent.qfsmonet.api.outputstream.OnNewPacketAvailableListener;
import com.tencent.qfsmonet.gles.w;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements IMonetSurfaceOutputStream, a, OnNewPacketAvailableListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private w f342562a;

    /* renamed from: b, reason: collision with root package name */
    private MonetContext f342563b;

    public b(@NonNull MonetContext monetContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) monetContext);
        } else {
            this.f342563b = monetContext;
        }
    }

    @Override // com.tencent.qfsmonet.outputstream.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        w wVar = this.f342562a;
        if (wVar != null) {
            wVar.y();
        }
    }

    public Size b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Size) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        w wVar = this.f342562a;
        if (wVar == null) {
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceOutput", "render not init");
            return null;
        }
        return wVar.j();
    }

    public synchronized boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f342562a != null) {
            com.tencent.qfsmonet.utils.a.c("MonetSurfaceOutput", "repeat init!");
            return true;
        }
        w wVar = new w(this.f342563b);
        this.f342562a = wVar;
        if (!wVar.r()) {
            this.f342562a = null;
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceOutput", "initRender failed!");
            return false;
        }
        com.tencent.qfsmonet.utils.a.c("MonetSurfaceOutput", "initRender success!");
        return true;
    }

    @Override // com.tencent.qfsmonet.outputstream.a
    public synchronized void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.qfsmonet.utils.a.c("MonetSurfaceOutput", "destroy");
        w wVar = this.f342562a;
        if (wVar != null) {
            wVar.h();
        }
        this.f342562a = null;
    }

    @Override // com.tencent.qfsmonet.api.outputstream.IMonetOutputStream
    public int getOutputStreamType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.qfsmonet.api.outputstream.OnNewPacketAvailableListener
    public void onNewPacketAvailable(@NonNull MonetPacket monetPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) monetPacket);
            return;
        }
        if (1 != monetPacket.packetType()) {
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceOutput", "invalid packet. type = " + monetPacket.packetType());
            return;
        }
        if (this.f342562a == null) {
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceOutput", "render not init");
            return;
        }
        MonetGLTexturePacket monetGLTexturePacket = (MonetGLTexturePacket) monetPacket;
        int textureId = monetGLTexturePacket.textureId();
        if (textureId > 0) {
            this.f342562a.z(monetGLTexturePacket.textureId());
            return;
        }
        com.tencent.qfsmonet.utils.a.b("MonetSurfaceOutput", "invalid textureId. id = " + textureId);
    }

    @Override // com.tencent.qfsmonet.api.outputstream.IMonetSurfaceOutputStream
    public synchronized void updateSurface(@Nullable Surface surface) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) surface);
            return;
        }
        if (surface != null && !surface.isValid()) {
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceOutput", "surface invalid!");
            throw new IllegalStateException("surface invalid!");
        }
        w wVar = this.f342562a;
        if (wVar != null) {
            wVar.A(surface);
        } else {
            com.tencent.qfsmonet.utils.a.b("MonetSurfaceOutput", "render not init!");
        }
    }
}
