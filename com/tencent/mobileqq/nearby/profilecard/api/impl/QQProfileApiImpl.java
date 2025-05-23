package com.tencent.mobileqq.nearby.profilecard.api.impl;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.profilecard.api.IQQProfileApi;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes33.dex */
public class QQProfileApiImpl implements IQQProfileApi {
    @Override // com.tencent.mobileqq.nearby.profilecard.api.IQQProfileApi
    public int getGender(String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return -1;
        }
        return ((FriendsManager) peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(str).shGender;
    }
}
