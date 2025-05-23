package com.tencent.qqnt.emotion.stickerrecommended;

import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;

/* compiled from: P */
/* loaded from: classes24.dex */
public class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f356597a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45444);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f356597a = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".sticker_recommended_pics/");
    }

    public static String a(String str) {
        try {
            return f356597a + Utils.Crc64String(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
