package com.tencent.qqnt.doutu.api;

import android.content.Context;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IDoutuUtils extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;
    public static final String DOUTU_ANIMA_RES_PATH;
    public static final String DUI_ICONS_RES_PATH = "dui_icon";

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(31223), (Class<?>) IDoutuUtils.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        DOUTU_ANIMA_RES_PATH = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "DoutuRes" + File.separator);
    }

    void markResDamaged(Context context);
}
