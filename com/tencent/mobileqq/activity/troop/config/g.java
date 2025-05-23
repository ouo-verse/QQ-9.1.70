package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.TroopUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g extends com.tencent.mobileqq.troop.api.config.e {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.e
    public void a(@NonNull AppInterface appInterface, TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) troopInfo);
        } else {
            if (!TextUtils.isEmpty(troopInfo.discussUin) && TroopUtils.u((QQAppInterface) appInterface, troopInfo.discussUin, troopInfo.discussToTroopTime, troopInfo.dwCmdUinJoinTime)) {
                return;
            }
            ((TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER)).d(troopInfo);
        }
    }
}
