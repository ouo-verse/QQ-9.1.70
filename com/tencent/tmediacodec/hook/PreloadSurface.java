package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes26.dex */
public final class PreloadSurface extends Surface {
    static IPatchRedirector $redirector_;

    @NonNull
    private final SurfaceTexture surfaceTexture;

    public PreloadSurface(@NonNull SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceTexture);
        } else {
            this.surfaceTexture = surfaceTexture;
        }
    }

    @NonNull
    public final SurfaceTexture getSurfaceTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (SurfaceTexture) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.surfaceTexture;
    }
}
