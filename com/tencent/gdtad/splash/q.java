package com.tencent.gdtad.splash;

import android.text.TextUtils;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AutoLoginUtil;
import mqq.app.MobileQQ;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class q {
    public static p a() {
        if (!b()) {
            QLog.i("GdtSplashPrivacyPolicyHelper", 1, "[isAllowed] error, not allowed of device");
            return new p(2000004);
        }
        if (!c()) {
            QLog.i("GdtSplashPrivacyPolicyHelper", 1, "[isAllowed] error, not allowed of user");
            return new p(2000005);
        }
        return new p(0);
    }

    private static boolean b() {
        return PrivacyPolicyHelper.isUserAllow();
    }

    private static boolean c() {
        List<SimpleAccount> list;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        SimpleAccount simpleAccount = null;
        if (mobileQQ != null) {
            list = mobileQQ.getAllAccounts();
        } else {
            list = null;
        }
        if (list != null && list.size() > 0) {
            simpleAccount = list.get(0);
        }
        if (simpleAccount == null) {
            QLog.e("GdtSplashPrivacyPolicyHelper", 1, "[isAllowedOfUser] return false, lastAccount is null");
            return false;
        }
        String uin = simpleAccount.getUin();
        boolean isLogined = simpleAccount.isLogined();
        if (QLog.isColorLevel()) {
            QLog.i("GdtSplashPrivacyPolicyHelper", 2, "[isAllowedOfUser] uin:" + uin + " logined:" + isLogined);
        }
        if (!isLogined) {
            QLog.e("GdtSplashPrivacyPolicyHelper", 1, "[isAllowedOfUser] return false, not logined");
            return false;
        }
        if (!TextUtils.isEmpty(uin) && AutoLoginUtil.canAutoLogin(uin)) {
            return true;
        }
        QLog.e("GdtSplashPrivacyPolicyHelper", 1, "[isAllowedOfUser] return false, not auto login");
        return false;
    }
}
