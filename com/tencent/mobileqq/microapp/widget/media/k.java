package com.tencent.mobileqq.microapp.widget.media;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class k implements TVK_IMediaPlayer.OnControllerClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniAppVideoPlayer f246234a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MiniAppVideoPlayer miniAppVideoPlayer) {
        this.f246234a = miniAppVideoPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppVideoPlayer);
        }
    }

    public void onAttationClick(TVK_PlayerVideoInfo tVK_PlayerVideoInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tVK_PlayerVideoInfo);
        }
    }

    public void onBackClick(TVK_PlayerVideoInfo tVK_PlayerVideoInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tVK_PlayerVideoInfo);
            return;
        }
        QLog.d(this.f246234a.f246186a, 2, "video player onBackClick");
        if (((Activity) this.f246234a.f246201m.get()) == null) {
            return;
        }
        MiniAppVideoPlayer miniAppVideoPlayer = this.f246234a;
        if (miniAppVideoPlayer.f246204p) {
            miniAppVideoPlayer.g();
        }
    }

    public void onBackOnFullScreenClick(TVK_PlayerVideoInfo tVK_PlayerVideoInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tVK_PlayerVideoInfo);
            return;
        }
        QLog.d(this.f246234a.f246186a, 2, "video player onBackOnFullScreenClick");
        if (((Activity) this.f246234a.f246201m.get()) == null) {
            return;
        }
        MiniAppVideoPlayer miniAppVideoPlayer = this.f246234a;
        if (miniAppVideoPlayer.f246204p) {
            miniAppVideoPlayer.g();
        }
    }

    public void onCacheClick(TVK_PlayerVideoInfo tVK_PlayerVideoInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tVK_PlayerVideoInfo);
        }
    }

    public void onFeedbackClick(TVK_PlayerVideoInfo tVK_PlayerVideoInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) tVK_PlayerVideoInfo);
        }
    }

    public void onFullScreenClick(TVK_PlayerVideoInfo tVK_PlayerVideoInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) tVK_PlayerVideoInfo);
            return;
        }
        MiniAppVideoPlayer miniAppVideoPlayer = this.f246234a;
        if (!miniAppVideoPlayer.f246204p) {
            miniAppVideoPlayer.h();
        } else {
            miniAppVideoPlayer.g();
        }
    }

    public void onReopenClick(TVK_NetVideoInfo.RecommadInfo recommadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) recommadInfo);
        }
    }
}
