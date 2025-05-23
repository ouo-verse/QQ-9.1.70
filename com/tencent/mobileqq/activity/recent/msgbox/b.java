package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static int a(AppInterface appInterface, Message message) {
        int i3 = 0;
        for (RecentUser recentUser : b(appInterface)) {
            if (message != null) {
                i3 += i.f185697a.c(appInterface, recentUser.uin, recentUser.getType(), i3, null);
            }
        }
        return i3;
    }

    public static List<RecentUser> b(AppInterface appInterface) {
        ArrayList arrayList = new ArrayList();
        List<RecentUser> recentList = ((IRecentUserProxyService) appInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().getRecentList(true, false);
        ITempMsgBoxManager iTempMsgBoxManager = (ITempMsgBoxManager) appInterface.getRuntimeService(ITempMsgBoxManager.class, "");
        for (int i3 = 0; i3 < recentList.size(); i3++) {
            RecentUser recentUser = recentList.get(i3);
            if (iTempMsgBoxManager.isBelongToFilterBox(recentUser.uin, recentUser.getType())) {
                arrayList.add(recentUser);
            }
        }
        return arrayList;
    }

    private static SharedPreferences c() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        return waitAppRuntime.getApp().getSharedPreferences("file_filter_msg" + waitAppRuntime.getAccount(), 0);
    }

    public static long d() {
        return c().getLong("filter_msg_time", 0L);
    }

    public static void e(AppInterface appInterface, boolean z16) {
        List<RecentUser> b16 = b(appInterface);
        if (QLog.isColorLevel()) {
            QLog.d("FilterMsgBoxUtil", 2, "onRecentBaseDataDelete() called with: filterBoxRecentUsers = [" + b16 + "]");
        }
        if (b16.isEmpty()) {
            RecentUserProxy recentUserCache = ((IRecentUserProxyService) appInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
            recentUserCache.delRecentUser(recentUserCache.findRecentUserByUin(AppConstants.FILTER_MSG_UIN, 10012), z16);
        }
    }

    public static void f(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("FilterMsgBoxUtil", 2, "saveUpdateTime() called with: updateTime = [" + j3 + "]");
        }
        c().edit().putLong("filter_msg_time", j3).apply();
    }
}
