package com.tencent.ams.dsdk.view.video.glvideo;

import android.content.Context;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.view.video.DKVideoViewController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;

/* compiled from: P */
@HippyController(name = "DKGLVideoView")
/* loaded from: classes3.dex */
public class DKGLVideoViewController extends DKVideoViewController {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKGLVideoViewController";
    int mEngineId;

    public DKGLVideoViewController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mEngineId = -1;
        }
    }

    @HippyControllerProps(defaultType = "number", name = "formatType")
    public void setFormatType(DKGLVideoView dKGLVideoView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dKGLVideoView, i3);
            return;
        }
        DLog.d(TAG, "setFormatType:" + i3);
        if (dKGLVideoView != null) {
            dKGLVideoView.setFormatType(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.dsdk.view.video.DKVideoViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    public DKGLVideoView createViewImpl(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DKGLVideoView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        DLog.i(TAG, "createViewImpl");
        return new DKGLVideoView(context, this.mEngineId);
    }
}
