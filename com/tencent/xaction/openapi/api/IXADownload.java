package com.tencent.xaction.openapi.api;

import com.tencent.mobileqq.cooperation.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes27.dex */
public interface IXADownload extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;
    public static final String SCID;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(48499), (Class<?>) IXADownload.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        SCID = "XA_" + a.c(BaseApplication.getContext()).replaceAll("\\.", "");
    }

    File getDownloadPath();

    File getInstallRoot();

    boolean isNoNeedDownload();

    void onComplete(int i3);

    void requestDownload();
}
