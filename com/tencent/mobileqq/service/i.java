package com.tencent.mobileqq.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f286138a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74907);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f286138a = new String[]{"GroupCare", "FriendClone", "groupnick", "profilelogic", "Face", "RoamWrap", "FontBubbleRecommend", "QCUniBusinessLogin", "ProfileMusicBox", "QcHomePageLogic", "QcUniBusinessUserInfo", "QCUniBusinessLogic", "QCMallChief"};
        }
    }
}
