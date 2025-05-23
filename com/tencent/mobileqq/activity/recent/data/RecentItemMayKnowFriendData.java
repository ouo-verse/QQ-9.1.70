package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentItemMayKnowFriendData extends AbsRecentUserBusinessBaseData {
    static IPatchRedirector $redirector_;
    public String curUin;

    public RecentItemMayKnowFriendData(RecentUser recentUser) throws NullPointerException {
        super(recentUser);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) recentUser);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.data.AbsRecentUserBusinessBaseData
    public void o(QQAppInterface qQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface, (Object) context);
        } else {
            super.o(qQAppInterface, context);
            this.mMenuFlag = 0;
        }
    }
}
