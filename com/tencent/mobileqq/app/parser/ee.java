package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ee extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;
    private QQAppInterface Q;

    public ee(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        } else {
            this.Q = qQAppInterface;
        }
    }

    private boolean F() {
        boolean z16;
        TroopInfo k3;
        String str = this.f307441f.get("groupcode");
        if (str != null && !"".equals(str) && str.length() >= 5) {
            if (this.f307437b instanceof Activity) {
                TroopManager troopManager = (TroopManager) this.Q.getManager(QQManagerFactory.TROOP_MANAGER);
                if (troopManager != null && (k3 = troopManager.k(str)) != null && k3.isOwnerOrAdmin()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopManagerAction", 2, "gotoGroupManager not admin " + str);
                    }
                    return false;
                }
                Intent intent = new Intent();
                intent.putExtra("uin", this.Q.getCurrentAccountUin());
                intent.putExtra("troop_uin", str);
                intent.putExtra(AppConstants.Key.KEY_IS_UPDATE_BEFORE_805, ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isUpdateBeforeSomeVersion(this.f307437b, "8.0.5"));
                intent.putExtra("troop_manage_from_jump_action", true);
                QPublicFragmentActivity.startForResult((Activity) this.f307437b, intent, com.tencent.mobileqq.troopmanage.base.b.c(), -1);
                if (QLog.isColorLevel()) {
                    QLog.i("TroopManagerAction", 2, "gotoGroupManager " + str);
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopManagerAction", 2, "gotoGroupManager context not activity");
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            return F();
        } catch (Exception e16) {
            QLog.e("TroopManagerAction", 1, "doAction error: " + e16.getMessage());
            i("TroopManagerAction");
            return false;
        }
    }
}
