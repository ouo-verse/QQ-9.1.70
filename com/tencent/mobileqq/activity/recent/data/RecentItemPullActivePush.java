package com.tencent.mobileqq.activity.recent.data;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.en;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;

/* loaded from: classes10.dex */
public class RecentItemPullActivePush extends AbsRecentUserBusinessBaseData {
    static IPatchRedirector $redirector_;
    public long time;

    public RecentItemPullActivePush(RecentUser recentUser) throws NullPointerException {
        super(recentUser);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentUser);
        }
    }

    public void p(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3));
            return;
        }
        this.mTitleName = str;
        this.time = j3;
        this.mShowTime = en.p(j3, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
    }
}
