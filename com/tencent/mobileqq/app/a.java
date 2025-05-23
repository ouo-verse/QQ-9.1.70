package com.tencent.mobileqq.app;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.troop.ITroopNotificationRepoApi;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements qy2.a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // qy2.a
    public void a() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            if (!SettingCloneUtil.readValue((Context) BaseApplication.context, (String) null, (String) null, BadgeUtilImpl.QQSETTING_SHOW_BADGEUNREAD_KEY, true)) {
                SettingCloneUtil.writeValue((Context) BaseApplication.context, (String) null, (String) null, BadgeUtilImpl.QQSETTING_SHOW_BADGEUNREAD_KEY, true);
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("AppBadgeCountInjector", 1, "[resetOldSwitchFlag] update isResetOldSwitchFlag: " + z16);
        } catch (Throwable th5) {
            QLog.e("AppBadgeCountInjector", 1, "[resetOldSwitchFlag] error:", th5);
        }
    }

    @Override // qy2.a
    public int b(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return c(i3, i16).getTotalCount();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    @Override // qy2.a
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ry2.a c(int i3, int i16) {
        int i17;
        int notificationUnreadCount;
        boolean isSwitchOn;
        int i18;
        Map<Integer, Integer> unreadCountNoiseMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ry2.a) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        new HashMap();
        if (peekAppRuntime.hashCode() != i3) {
            QLog.d("AppBadgeCountInjector", 1, "lastRuntimeHashcode=", Integer.valueOf(i3), ", newRuntimeHashcode=", Integer.valueOf(peekAppRuntime.hashCode()));
            return new ry2.a(0);
        }
        if (peekAppRuntime instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            if (i16 == -1) {
                i17 = com.tencent.imcore.message.facade.unread.count.g.a();
            } else {
                i17 = i16;
            }
            int allUnreadMessageCount = ((INewFriendService) qQAppInterface.getRuntimeService(INewFriendService.class)).getAllUnreadMessageCount();
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notification_badge_count_group_notification_9025_121000545", true)) {
                try {
                    notificationUnreadCount = ((ITroopNotificationRepoApi) QRoute.api(ITroopNotificationRepoApi.class)).getNotificationUnreadCount();
                } catch (Exception e16) {
                    QLog.w("AppBadgeCountInjector", 1, "[getUnReadGroupSystemMsgNum] exception=" + QLog.getStackTraceString(e16));
                }
                isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106064", false);
                if (QLog.isColorLevel()) {
                    QLog.e("AppBadgeCountInjector", 2, "shelfContactsRedNumSwitch = " + isSwitchOn);
                }
                if (!isSwitchOn) {
                    i18 = i17;
                } else {
                    i18 = i17 + allUnreadMessageCount + notificationUnreadCount;
                }
                if (com.tencent.util.b.a() && i18 > 0 && (i19 = com.tencent.imcore.message.facade.unread.count.g.b()) > 0) {
                    i18 = (i18 - i19) + 1;
                }
                int i26 = i18;
                HashMap hashMap = new HashMap();
                unreadCountNoiseMap = ((IChatsUtil) QRoute.api(IChatsUtil.class)).getUnreadCountNoiseMap();
                if (unreadCountNoiseMap != null) {
                    hashMap.putAll(unreadCountNoiseMap);
                }
                QLog.i("AppBadgeCountInjector", 1, "getAppBadgeCount : unread=" + i26 + ",unreadMsgNew=" + i17 + ",newFriendCount=" + allUnreadMessageCount + ",groupNotificationCount=" + notificationUnreadCount + ",unreadCnt=" + i16 + ",unreadNoise=" + i19);
                return new ry2.a(i26, i17, allUnreadMessageCount, notificationUnreadCount, hashMap);
            }
            notificationUnreadCount = 0;
            isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106064", false);
            if (QLog.isColorLevel()) {
            }
            if (!isSwitchOn) {
            }
            if (com.tencent.util.b.a()) {
                i18 = (i18 - i19) + 1;
            }
            int i262 = i18;
            HashMap hashMap2 = new HashMap();
            unreadCountNoiseMap = ((IChatsUtil) QRoute.api(IChatsUtil.class)).getUnreadCountNoiseMap();
            if (unreadCountNoiseMap != null) {
            }
            QLog.i("AppBadgeCountInjector", 1, "getAppBadgeCount : unread=" + i262 + ",unreadMsgNew=" + i17 + ",newFriendCount=" + allUnreadMessageCount + ",groupNotificationCount=" + notificationUnreadCount + ",unreadCnt=" + i16 + ",unreadNoise=" + i19);
            return new ry2.a(i262, i17, allUnreadMessageCount, notificationUnreadCount, hashMap2);
        }
        if (QLog.isColorLevel()) {
            QLog.e("AppBadgeCountInjector", 2, "not appinterface");
        }
        return new ry2.a(0);
    }
}
