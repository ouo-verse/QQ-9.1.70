package com.tencent.mobileqq.activity.contacts.topentry;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f181777a;

    /* renamed from: b, reason: collision with root package name */
    private MayknowRecommendManager f181778b;

    /* renamed from: c, reason: collision with root package name */
    private FriendsManager f181779c;

    /* renamed from: d, reason: collision with root package name */
    private FriendListHandler f181780d;

    /* renamed from: e, reason: collision with root package name */
    private SharedPreferences f181781e;

    public e(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardViewController", 2, "CardViewController create");
        }
        this.f181777a = qQAppInterface;
        this.f181778b = (MayknowRecommendManager) qQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        this.f181779c = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.f181780d = (FriendListHandler) this.f181777a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    }

    private long c() {
        if (((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).pymkTestSwitch()) {
            QLog.d("CardViewController", 2, "getCardDisplayInterval = 90000");
            return 90000L;
        }
        QLog.d("CardViewController", 2, "getCardDisplayInterval = 86400000");
        return 86400000L;
    }

    private SharedPreferences e() {
        if (this.f181781e == null) {
            this.f181781e = BaseApplicationImpl.getApplication().getSharedPreferences("CardViewControllermay_know_sp" + this.f181777a.getCurrentAccountUin(), 0);
        }
        return this.f181781e;
    }

    private SharedPreferences.Editor f() {
        return e().edit();
    }

    private int i() {
        int i3 = 0;
        int i16 = e().getInt("CardViewControllerdelete_count", 0);
        if (i16 >= 0) {
            i3 = i16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardViewController", 2, "loadCurrentDelCount = " + i3);
        }
        return i3;
    }

    public boolean a(MayKnowRecommend mayKnowRecommend) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) mayKnowRecommend)).booleanValue();
        }
        if (mayKnowRecommend != null) {
            if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(mayKnowRecommend.uin), "CardViewController")) {
                boolean R = this.f181779c.R(mayKnowRecommend.uin, false, true);
                mayKnowRecommend.friendStatus = R ? 1 : 0;
                return !R;
            }
            mayKnowRecommend.friendStatus = 2;
        }
        return false;
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardViewController", 2, "deleteMayKnowRecommend, uin = " + str);
        }
        g();
        this.f181780d.cancelMayKnowRecommend(str);
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i3 = 2 - i();
        if (i3 < 0) {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardViewController", 2, "getCurrentCardSize = " + i3);
        }
        return i3;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardViewController", 2, "increaseCurrentDelCount");
        }
        int i3 = i();
        SharedPreferences.Editor f16 = f();
        if (f16 == null) {
            return;
        }
        int i16 = i3 + 1;
        f16.putInt("CardViewControllerdelete_count", i16);
        if (i16 == 1) {
            f16.putLong("CardViewControllerdisplay_not_2", NetConnInfoCenter.getServerTimeMillis());
        }
        f16.apply();
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (e().getLong("CardViewControllerdisplay_not_2", 0L) + c() < NetConnInfoCenter.getServerTimeMillis()) {
            k();
        }
        int i3 = 2 - i();
        if (i3 < 0) {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardViewController", 2, "loadCardSize = " + i3);
        }
        return i3;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CardViewController", 2, "resetCurrentDelCount");
        }
        SharedPreferences.Editor f16 = f();
        if (f16 == null) {
            return;
        }
        f16.putInt("CardViewControllerdelete_count", 0);
        f16.putLong("CardViewControllerdisplay_not_2", 0L);
        f16.apply();
    }
}
