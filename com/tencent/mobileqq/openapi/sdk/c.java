package com.tencent.mobileqq.openapi.sdk;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private com.tencent.qqnt.ntrelation.friendsinfo.bean.d f256950a;

        /* renamed from: b, reason: collision with root package name */
        private Friends f256951b;

        public a(AppRuntime appRuntime, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) str);
                return;
            }
            if (appRuntime != null && str != null) {
                if (c.a()) {
                    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
                    if (!TextUtils.isEmpty(uidFromUin)) {
                        this.f256950a = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "MobileQQApi.Util");
                        return;
                    } else {
                        QLog.e("MobileQQApi.Util", 1, "FriendWrapper uid is null or empty");
                        return;
                    }
                }
                this.f256951b = ((FriendsManager) appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).v(str);
            }
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = this.f256950a;
            if (dVar != null) {
                return dVar.e().byteValue();
            }
            Friends friends = this.f256951b;
            if (friends != null) {
                return friends.cSpecialFlag;
            }
            return -1;
        }

        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = this.f256950a;
            if (dVar != null) {
                return c.b(dVar);
            }
            Friends friends = this.f256951b;
            if (friends != null) {
                return friends.getFriendNickWithAlias();
            }
            return "";
        }

        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = this.f256950a;
            if (dVar != null) {
                return dVar.B();
            }
            Friends friends = this.f256951b;
            if (friends != null) {
                return friends.isFriend();
            }
            return false;
        }
    }

    static /* bridge */ /* synthetic */ boolean a() {
        return e();
    }

    public static String b(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar) {
        if (dVar == null) {
            return "";
        }
        String r16 = dVar.r();
        if (!TextUtils.isEmpty(r16)) {
            return r16;
        }
        String p16 = dVar.p();
        if (!TextUtils.isEmpty(p16)) {
            return p16;
        }
        String c16 = dVar.c();
        if (!TextUtils.isEmpty(c16)) {
            return c16;
        }
        return dVar.x();
    }

    public static boolean c(AppRuntime appRuntime, String str) {
        if (appRuntime == null || str == null) {
            return false;
        }
        if (e()) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            if (uidFromUin == null) {
                return false;
            }
            return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "MobileQQApi.Util");
        }
        Friends v3 = ((FriendsManager) appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).v(str);
        if (v3 == null || !v3.isFriend()) {
            return false;
        }
        return true;
    }

    public static final boolean d(int i3) {
        if (i3 == 1 || i3 == 4 || i3 == 2) {
            return true;
        }
        return false;
    }

    private static boolean e() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("openapi_manager_friend_api_switch", true);
    }
}
