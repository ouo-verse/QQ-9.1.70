package com.tencent.mobileqq.microapp.widget.media;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class l implements TVK_IMediaPlayer.OnVideoPreparedListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniAppVideoPlayer f246235a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(MiniAppVideoPlayer miniAppVideoPlayer) {
        this.f246235a = miniAppVideoPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppVideoPlayer);
        }
    }

    public void onVideoPrepared(TVK_IMediaPlayer tVK_IMediaPlayer) {
        TVK_IMediaPlayer tVK_IMediaPlayer2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tVK_IMediaPlayer);
            return;
        }
        if (!this.f246235a.f246194f) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.f246235a.f246190b);
            this.f246235a.f246191c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoWaiting\", " + jSONObject + "," + this.f246235a.f246192d + ")");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        MiniAppVideoPlayer miniAppVideoPlayer = this.f246235a;
        miniAppVideoPlayer.f246194f = true;
        tVK_IMediaPlayer2 = miniAppVideoPlayer.f246207s;
        tVK_IMediaPlayer2.start();
    }
}
