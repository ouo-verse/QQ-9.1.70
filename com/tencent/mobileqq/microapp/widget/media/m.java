package com.tencent.mobileqq.microapp.widget.media;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class m implements TVK_IMediaPlayer.OnCompletionListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniAppVideoPlayer f246236a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MiniAppVideoPlayer miniAppVideoPlayer) {
        this.f246236a = miniAppVideoPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppVideoPlayer);
        }
    }

    public void onCompletion(TVK_IMediaPlayer tVK_IMediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tVK_IMediaPlayer);
            return;
        }
        if (this.f246236a.f246204p) {
            com.tencent.mobileqq.microapp.appbrand.b.a.a(new n(this));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.f246236a.f246190b);
            this.f246236a.f246191c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoEnded\", " + jSONObject + "," + this.f246236a.f246192d + ")");
            com.tencent.mobileqq.microapp.appbrand.b.a.a(new o(this));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
