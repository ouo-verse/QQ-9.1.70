package com.tencent.ams.dsdk.view.video;

import android.content.Context;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class DKVideoPlayerView extends DKVideoView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKVideoPlayerView";

    public DKVideoPlayerView(Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoView
    protected DKVideoPlayer createPlayer(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DKVideoPlayer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        DKVideoPlayerCreator playerCreator = DKConfiguration.getPlayerCreator();
        if (playerCreator != null) {
            try {
                return playerCreator.createPlayer();
            } catch (Throwable th5) {
                DLog.e(TAG, "create outside video player error.", th5);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.dsdk.view.video.DKVideoView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        DLog.i(TAG, "onAttachedToWindow, " + this);
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.dsdk.view.video.DKVideoView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        DLog.i(TAG, "onDetachedFromWindow, " + this);
        super.onDetachedFromWindow();
    }
}
