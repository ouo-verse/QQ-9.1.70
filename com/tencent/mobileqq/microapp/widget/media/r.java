package com.tencent.mobileqq.microapp.widget.media;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class r implements TVK_IMediaPlayer.OnSeekCompleteListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniAppVideoPlayer f246241a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MiniAppVideoPlayer miniAppVideoPlayer) {
        this.f246241a = miniAppVideoPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppVideoPlayer);
        }
    }

    public void onSeekComplete(TVK_IMediaPlayer tVK_IMediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tVK_IMediaPlayer);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.f246241a.f246190b);
            this.f246241a.f246191c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoSeeked\", " + jSONObject + "," + this.f246241a.f246192d + ")");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }
}
