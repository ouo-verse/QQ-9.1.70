package com.tencent.mobileqq.microapp.widget.media;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class p implements TVK_IMediaPlayer.OnErrorListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniAppVideoPlayer f246239a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MiniAppVideoPlayer miniAppVideoPlayer) {
        this.f246239a = miniAppVideoPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppVideoPlayer);
        }
    }

    public boolean onError(TVK_IMediaPlayer tVK_IMediaPlayer, int i3, int i16, int i17, String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, tVK_IMediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, obj)).booleanValue();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.f246239a.f246190b);
            this.f246239a.f246191c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoError\", " + jSONObject + "," + this.f246239a.f246192d + ")");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return true;
    }
}
