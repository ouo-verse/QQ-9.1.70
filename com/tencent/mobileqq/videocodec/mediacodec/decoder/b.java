package com.tencent.mobileqq.videocodec.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Surface f312547a;

    /* renamed from: b, reason: collision with root package name */
    public int f312548b;

    /* renamed from: c, reason: collision with root package name */
    public SurfaceTexture f312549c;

    public b(int i3, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) onFrameAvailableListener);
            return;
        }
        this.f312548b = i3;
        SurfaceTexture surfaceTexture = new SurfaceTexture(i3);
        this.f312549c = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
        this.f312547a = new Surface(this.f312549c);
    }
}
