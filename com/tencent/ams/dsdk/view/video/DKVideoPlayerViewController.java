package com.tencent.ams.dsdk.view.video;

import android.content.Context;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.annotation.HippyController;

@HippyController(name = "DKVideo")
/* loaded from: classes3.dex */
public class DKVideoPlayerViewController extends DKVideoViewController {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKVideoPlayerViewController";

    public DKVideoPlayerViewController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKAbsVideoController, com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(DKVideoView dKVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dKVideoView);
            return;
        }
        DLog.i(TAG, "onViewDestroy, view: " + dKVideoView);
        super.onViewDestroy(dKVideoView);
        if (dKVideoView != null) {
            dKVideoView.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.dsdk.view.video.DKVideoViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    public DKVideoPlayerView createViewImpl(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DKVideoPlayerView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        DLog.i(TAG, "createViewImpl");
        return new DKVideoPlayerView(context, this.mEngineId);
    }
}
