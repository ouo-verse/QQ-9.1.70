package com.tencent.mobileqq.qqlive.api.displayview.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.displayview.IDisplayViewApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import ht3.a;
import kotlin.Metadata;
import wi2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/displayview/impl/DisplayViewApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/displayview/IDisplayViewApi;", "()V", "enableHorizontalVideoSeamless", "", "getHorizontalVideoHeight", "", "videoWidth", "videoHeight", "getHorizontalVideoTopMargin", "containStatusBar", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class DisplayViewApiImpl implements IDisplayViewApi {
    static IPatchRedirector $redirector_;

    public DisplayViewApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.displayview.IDisplayViewApi
    public boolean enableHorizontalVideoSeamless() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return a.e("qqlive_enable_horizontal_video_seamless", true);
    }

    @Override // com.tencent.mobileqq.qqlive.api.displayview.IDisplayViewApi
    public int getHorizontalVideoHeight(int videoWidth, int videoHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(videoWidth), Integer.valueOf(videoHeight))).intValue();
        }
        if (videoWidth != 0 && videoHeight != 0) {
            return (int) ((videoHeight / videoWidth) * ViewUtils.getScreenWidth());
        }
        return ViewUtils.getScreenWidth() * 0;
    }

    @Override // com.tencent.mobileqq.qqlive.api.displayview.IDisplayViewApi
    public int getHorizontalVideoTopMargin(boolean containStatusBar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, containStatusBar)).intValue();
        }
        if (containStatusBar) {
            return c.a(168.0f);
        }
        return c.a(168.0f) - ViewUtils.getStatusBarHeight(BaseApplication.context);
    }
}
