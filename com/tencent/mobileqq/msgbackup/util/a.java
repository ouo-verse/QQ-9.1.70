package com.tencent.mobileqq.msgbackup.util;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f251368a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f251369b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f251370c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24117);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "msgbackup/");
        f251368a = sDKPrivatePath;
        f251369b = sDKPrivatePath + "multimsg/";
        f251370c = sDKPrivatePath + "db/";
    }
}
