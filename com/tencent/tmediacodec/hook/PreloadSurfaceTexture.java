package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes26.dex */
public final class PreloadSurfaceTexture extends SurfaceTexture {
    static IPatchRedirector $redirector_;

    @Nullable
    private ActionCallback actionCallback;

    /* loaded from: classes26.dex */
    public interface ActionCallback {
        void onReleased();
    }

    public PreloadSurfaceTexture(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
    }

    @Override // android.graphics.SurfaceTexture
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.release();
        ActionCallback actionCallback = this.actionCallback;
        if (actionCallback != null) {
            actionCallback.onReleased();
        }
    }

    public final void setActionCallback(@Nullable ActionCallback actionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) actionCallback);
        } else {
            this.actionCallback = actionCallback;
        }
    }
}
