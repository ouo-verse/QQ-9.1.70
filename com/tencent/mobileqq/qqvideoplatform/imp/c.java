package com.tencent.mobileqq.qqvideoplatform.imp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqvideoplatform.api.PlatformInfo;
import com.tencent.mobileqq.videoplatform.api.IRegisterTVideo;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.TVideoPlatformInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c implements IRegisterTVideo {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void a(int i3, String str, String str2) {
        SuperPlayerSDKMgr.registerTVideoPlatformInfo(new TVideoPlatformInfo.Builder().pkgName("com.tencent.mobileqq").platform(i3).sdtfrom(str).appKey(str2).build());
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IRegisterTVideo
    public void registerTVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        a(PlatformInfo.ID_KANDIAN, PlatformInfo.SDT_KANDIAN, PlatformInfo.KEY_KANDIAN);
        a(PlatformInfo.ID_QQCOMIC, PlatformInfo.SDT_QQCOMIC, PlatformInfo.KEY_QQCOMIC);
        a(30301, PlatformInfo.SDT_SUBSCRIBE, PlatformInfo.KEY_SUBSCRIBE);
        a(PlatformInfo.ID_QQGAME, PlatformInfo.SDT_QQGAME, PlatformInfo.KEY_QQGAME);
        a(PlatformInfo.ID_QQWATCH, PlatformInfo.SDT_QQWATCH, PlatformInfo.KEY_QQWATCH);
        a(PlatformInfo.ID_ZPLAN, PlatformInfo.SDT_ZPLAN, PlatformInfo.KEY_ZPLAN);
        a(PlatformInfo.ID_XIAOSHIJIE, PlatformInfo.SDT_XIAOSHIJIE, PlatformInfo.KEY_XIAOSHIJIE);
        a(PlatformInfo.ID_GDTAD, PlatformInfo.SDT_GDTAD, PlatformInfo.KET_GDTAD);
    }
}
