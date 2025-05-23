package com.tencent.ams.dsdk.view.image;

import android.content.Context;
import android.view.View;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.image.HippyImageViewController;

/* compiled from: P */
@HippyController(name = "Image")
/* loaded from: classes3.dex */
public class DKImageViewController extends HippyImageViewController {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKImageViewController";

    public DKImageViewController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new DKImageView(context) : (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }

    @HippyControllerProps(defaultType = "number", name = "blurRadius")
    public void setBlurRadius(DKImageView dKImageView, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, dKImageView, Float.valueOf(f16));
            return;
        }
        DLog.d(TAG, "setBlurRadius, radius: " + f16);
        if (dKImageView != null) {
            dKImageView.setBlurRadius(f16);
        }
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "hardwareAccelerated")
    public void setLayerType(DKImageView dKImageView, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, dKImageView, Boolean.valueOf(z16));
        } else {
            dKImageView.mHardwareAccelerated = z16;
        }
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) hippyMap);
        }
        DLog.i(TAG, "createViewImpl");
        DKImageView dKImageView = new DKImageView(context);
        if (hippyMap != null) {
            dKImageView.setInitProps(hippyMap);
        }
        return dKImageView;
    }
}
