package com.tencent.mobileqq.profilecard.bussiness.miniapp;

import NS_MINI_APP_MISC.MISC$StAppPlayingInfo;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes16.dex */
public class ProfileMiniAppInfo implements IProfileBusinessInfo {
    static IPatchRedirector $redirector_;
    public List<MISC$StAppPlayingInfo> appPlayingInfos;
    public int guestAppTotal;
    public String guestJumpUrl;
    public boolean isShowMiniPlaying;
    public ArrayList<INTERFACE$StApiAppInfo> miniAppInfoArrayList;
    public String tabJumpUrl;

    public ProfileMiniAppInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
