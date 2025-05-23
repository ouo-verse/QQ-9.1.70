package com.tencent.mobileqq.relation.api.impl;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qqnt.ntrelation.api.IFriendDataTransApi;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ContactUtilsApiImpl implements IContactUtilsApi {
    static IPatchRedirector $redirector_;

    public ContactUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean isSelfNetworkStatusVisibleImpl(c cVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ);
        String str = MobileQQ.sMobileQQ.getString(R.string.hm8) + peekAppRuntime.getCurrentAccountUin();
        if (defaultSharedPreferences.contains(str)) {
            return defaultSharedPreferences.getBoolean(str, true);
        }
        return !b.e(cVar);
    }

    @Override // com.tencent.mobileqq.relation.api.IContactUtilsApi
    public String getBuddyName(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16));
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return ac.g((QQAppInterface) peekAppRuntime, str, z16);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.relation.api.IContactUtilsApi
    public String getDateNickName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return ac.j((QQAppInterface) peekAppRuntime, str);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.relation.api.IContactUtilsApi
    public String getDiscussionMemberShowName(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return ac.n((QQAppInterface) peekAppRuntime, str, str2);
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.relation.api.IContactUtilsApi
    public String getFriendName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return ac.B((QQAppInterface) peekAppRuntime, str);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.relation.api.IContactUtilsApi
    public String getFriendShowName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return ac.H((QQAppInterface) peekAppRuntime, str);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.relation.api.IContactUtilsApi
    public String getGrayBarShowName(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return ac.J((QQAppInterface) peekAppRuntime, str, str2);
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.relation.api.IContactUtilsApi
    public String getStatusName(Friends friends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? ac.a0(friends) : (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) friends);
    }

    @Override // com.tencent.mobileqq.relation.api.IContactUtilsApi
    public String getTroopNickName(String str, String str2, String str3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, str, str2, str3, Boolean.valueOf(z16), bundle);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return ac.j0((QQAppInterface) peekAppRuntime, str, str2, str3, z16, bundle);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.relation.api.IContactUtilsApi
    public boolean isContactShown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity == null || !(baseActivity instanceof SplashActivity) || ((SplashActivity) baseActivity).getCurrentTab() != a.f183040c) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.relation.api.IContactUtilsApi
    public boolean isSelfNetworkStatusVisible(Friends friends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? isSelfNetworkStatusVisible(((IFriendDataTransApi) QRoute.api(IFriendDataTransApi.class)).friendsConvertToOnlineStatusInfo(friends, true)) : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) friends)).booleanValue();
    }

    @Override // com.tencent.mobileqq.relation.api.IContactUtilsApi
    public String getStatusName(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? ac.b0(cVar) : (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
    }

    @Override // com.tencent.mobileqq.relation.api.IContactUtilsApi
    public boolean isSelfNetworkStatusVisible(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? isSelfNetworkStatusVisibleImpl(cVar) : ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar)).booleanValue();
    }
}
