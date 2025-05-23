package com.tencent.mobileqq.qqlive.data.supervision;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.PageData;
import com.tencent.mobileqq.qqlive.data.user.LimitUserInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class BanChatUserListData extends PageData<LimitUserInfo> {
    static IPatchRedirector $redirector_;

    public BanChatUserListData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
