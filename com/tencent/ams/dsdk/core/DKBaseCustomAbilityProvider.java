package com.tencent.ams.dsdk.core;

import android.content.Context;
import com.tencent.ams.dsdk.download.DKDownloadManager;
import com.tencent.ams.dsdk.view.video.DKVideoPlayer;
import com.tencent.ams.dsdk.view.video.glvideo.DKGLVideoPlayer;
import com.tencent.ams.dsdk.view.webview.DKWebView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class DKBaseCustomAbilityProvider implements DKCustomAbilityProvider {
    static IPatchRedirector $redirector_;

    public DKBaseCustomAbilityProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.dsdk.core.DKCustomAbilityProvider
    public DKGLVideoPlayer getDKGLVideoPlayer(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DKGLVideoPlayer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        return null;
    }

    @Override // com.tencent.ams.dsdk.core.DKCustomAbilityProvider
    public DKVideoPlayer getDKVideoPlayer(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DKVideoPlayer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        return null;
    }

    @Override // com.tencent.ams.dsdk.core.DKCustomAbilityProvider
    public DKWebView getDKWebView(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (DKWebView) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        return null;
    }

    @Override // com.tencent.ams.dsdk.core.DKCustomAbilityProvider
    public DKDownloadManager getDownloadManager(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DKDownloadManager) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        return null;
    }
}
