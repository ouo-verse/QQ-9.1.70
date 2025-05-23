package com.tencent.ams.dsdk.bridge;

import com.tencent.ams.dsdk.view.image.DKImageViewController;
import com.tencent.ams.dsdk.view.video.DKVideoPlayerViewController;
import com.tencent.ams.dsdk.view.video.DKVideoViewController;
import com.tencent.ams.dsdk.view.video.glvideo.DKGLVideoViewController;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKHippyComponentConstant {
    static IPatchRedirector $redirector_;
    public static final Class<? extends HippyViewController>[] sComponentList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14008);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sComponentList = new Class[]{DKVideoViewController.class, DKImageViewController.class, DKWebViewController.class, DKVideoPlayerViewController.class, DKGLVideoViewController.class};
        }
    }

    public DKHippyComponentConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
