package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ab {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f195231a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f195231a = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE);
        }
    }
}
