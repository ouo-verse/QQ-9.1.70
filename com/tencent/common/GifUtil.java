package com.tencent.common;

import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GifUtil {
    static IPatchRedirector $redirector_;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27042);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        try {
            ((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).init();
            System.load(new File(FeatureManager.getSoDir(), "libgiflossy.so").getPath());
        } catch (Exception e16) {
            QLog.e("GifUtil", 4, "load libgiflossy.so fail, msg = " + e16.getMessage());
        }
    }

    public GifUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native int compressGif(String str, String str2, int i3);
}
