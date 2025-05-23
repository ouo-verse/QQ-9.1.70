package com.tencent.qidian.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.api.IQidianApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nx.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QidianApiImpl implements IQidianApi {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "QidianApiImpl";

    public QidianApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Intent getProfileCardIntentInternal(Context context, AllInOne allInOne, boolean z16) {
        boolean z17;
        Intent intent = null;
        if (allInOne == null) {
            return null;
        }
        if (a.d(allInOne.uin)) {
            intent = new Intent(context, (Class<?>) QidianProfileCardActivity.class);
            intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
        }
        if (intent == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
                if (CrmUtils.r(qQAppInterface, allInOne.uin) || QidianManager.F(qQAppInterface, allInOne.uin) || QidianManager.Q(qQAppInterface, allInOne.uin, z16)) {
                    if (!(context instanceof SplashActivity) && !(context instanceof ChatActivity)) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    return CrmUtils.n(context, null, allInOne.uin, z17, -1, false, -1);
                }
                return intent;
            }
            return intent;
        }
        return intent;
    }

    @Override // com.tencent.qidian.api.IQidianApi
    public Intent getProfileCardIntent(Context context, AllInOne allInOne) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Intent) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) allInOne);
        }
        boolean z16 = false;
        int i3 = allInOne.extras.getInt("user_type", 0);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("revert_is_qidian_master_9090", false);
        QLog.i(TAG, 1, "getProfileCardIntent disableNetReq=" + isSwitchOn);
        if (isSwitchOn || i3 != 3) {
            z16 = true;
        }
        return getProfileCardIntentInternal(context, allInOne, z16);
    }
}
