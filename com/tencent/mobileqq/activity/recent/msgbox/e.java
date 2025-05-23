package com.tencent.mobileqq.activity.recent.msgbox;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(RecentUserProxy recentUserProxy, AppInterface appInterface) {
        RecentUser findRecentUserByUin = recentUserProxy.findRecentUserByUin(AppConstants.TEMP_MSG_BOX_UIN, 10011);
        List<RecentUser> msgBoxRecentUsers = ((ITempMsgBoxManager) appInterface.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers();
        if (msgBoxRecentUsers.isEmpty()) {
            QLog.e("RecentUserCacheHelper", 1, "update: msgBoxRecentUsers.isEmpty()");
            return;
        }
        RecentUser recentUser = msgBoxRecentUsers.get(0);
        for (RecentUser recentUser2 : msgBoxRecentUsers) {
            if (Math.max(recentUser2.lastmsgtime, recentUser2.lastmsgdrafttime) > Math.max(recentUser.lastmsgtime, recentUser.lastmsgdrafttime)) {
                recentUser = recentUser2;
            }
        }
        findRecentUserByUin.uin = AppConstants.TEMP_MSG_BOX_UIN;
        findRecentUserByUin.setType(10011);
        findRecentUserByUin.lastmsgtime = recentUser.lastmsgtime;
        findRecentUserByUin.lastmsgdrafttime = recentUser.lastmsgdrafttime;
        findRecentUserByUin.opTime = recentUser.opTime;
        QLog.i("RecentUserCacheHelper", 1, "createMsgBox: " + findRecentUserByUin.uin);
        if (recentUserProxy instanceof FullCache) {
            ((FullCache) recentUserProxy).addCache(findRecentUserByUin);
        }
    }

    public void b(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface);
            return;
        }
        QLog.i("RecentUserCacheHelper", 2, "initMsgBox() called with: app = [" + appInterface + "]");
        a(((IRecentUserProxyService) appInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache(), appInterface);
    }
}
