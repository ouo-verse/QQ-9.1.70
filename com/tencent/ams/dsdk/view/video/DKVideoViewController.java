package com.tencent.ams.dsdk.view.video;

import android.content.Context;
import android.view.View;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;

/* compiled from: P */
@HippyController(name = "DKVideoView")
/* loaded from: classes3.dex */
public class DKVideoViewController extends DKAbsVideoController {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKVideoViewController";

    public DKVideoViewController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public View createView(HippyRootView hippyRootView, int i3, HippyEngineContext hippyEngineContext, String str, HippyMap hippyMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, hippyRootView, Integer.valueOf(i3), hippyEngineContext, str, hippyMap);
        }
        if (hippyEngineContext != null) {
            this.mEngineId = hippyEngineContext.getEngineId();
        }
        return super.createView(hippyRootView, i3, hippyEngineContext, str, hippyMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public DKVideoView createViewImpl(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DKVideoView) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        DLog.i(TAG, "createViewImpl");
        return new DKVideoView(context, this.mEngineId);
    }
}
