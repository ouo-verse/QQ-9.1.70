package com.tencent.mobileqq.microapp.widget.media;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class q implements TVK_IMediaPlayer.OnInfoListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniAppVideoPlayer f246240a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MiniAppVideoPlayer miniAppVideoPlayer) {
        this.f246240a = miniAppVideoPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppVideoPlayer);
        }
    }

    public boolean onInfo(TVK_IMediaPlayer tVK_IMediaPlayer, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, tVK_IMediaPlayer, Integer.valueOf(i3), obj)).booleanValue();
        }
        if (i3 != 21) {
            if (i3 == 22) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.f246240a.f246186a, 2, "video player PLAYER_INFO_ENDOF_BUFFERING--------------");
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", this.f246240a.f246190b);
                    this.f246240a.f246191c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoLoadedData\", " + jSONObject + "," + this.f246240a.f246192d + ")");
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(this.f246240a.f246186a, 2, "video player PLAYER_INFO_START_BUFFERING--------------");
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", this.f246240a.f246190b);
                this.f246240a.f246191c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoLoadStart\", " + jSONObject2 + "," + this.f246240a.f246192d + ")");
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        return false;
    }
}
