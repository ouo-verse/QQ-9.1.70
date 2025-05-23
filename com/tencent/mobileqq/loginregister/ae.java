package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.login.api.IUidService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ae extends f {
    @Override // com.tencent.mobileqq.loginregister.f, com.tencent.mobileqq.loginregister.s
    public void h(QBaseActivity qBaseActivity, String str, boolean z16) {
        if (qBaseActivity != null && qBaseActivity.getAppRuntime() != null) {
            if (QLog.isColorLevel()) {
                QLog.d("MMKVLoginAction", 1, "onDeleteAccount uin=", str, ", clean=", Boolean.valueOf(z16));
            }
            if (z16) {
                try {
                    String uid = ((IUidService) QRoute.api(IUidService.class)).getUid(str);
                    Intent intent = new Intent("qmmkv.action.account_cleanup");
                    intent.setPackage(MobileQQ.PACKAGE_NAME);
                    intent.putExtra("uin", str);
                    intent.putExtra("uid", uid);
                    MobileQQ.sMobileQQ.sendBroadcast(intent);
                    return;
                } catch (Exception e16) {
                    QLog.e("MMKVLoginAction", 1, "get uid error:", e16);
                    return;
                }
            }
            return;
        }
        QLog.e("MMKVLoginAction", 1, "onDeleteAccount, context or app runtime illegal");
    }
}
