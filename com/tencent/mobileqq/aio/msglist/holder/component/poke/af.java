package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface af {
    public static final IPatchRedirector $redirector_ = null;
    public static final String H3;
    public static final String I3;
    public static final String J3;
    public static final String K3;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(52540), (Class<?>) af.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_NEW_POKE);
        H3 = sDKPrivatePath;
        I3 = sDKPrivatePath + "/poke_egg";
        String str = sDKPrivatePath + "/poke_normal";
        J3 = str;
        K3 = str + "/dazhao/dazhao_move.png";
    }
}
