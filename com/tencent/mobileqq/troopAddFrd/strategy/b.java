package com.tencent.mobileqq.troopAddFrd.strategy;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.x;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(QQAppInterface qQAppInterface, String str) {
        x troopBatchAddFriendMgr = ((ITroopBatchAddFriendService) qQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
        if (troopBatchAddFriendMgr == null) {
            return;
        }
        troopBatchAddFriendMgr.M(str, null, 1);
    }

    @Override // com.tencent.mobileqq.troopAddFrd.strategy.a
    public void a(QQAppInterface qQAppInterface, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) strArr);
            return;
        }
        if (qQAppInterface != null && strArr != null && strArr.length >= 1) {
            b(qQAppInterface, strArr[0]);
        } else if (QLog.isColorLevel()) {
            QLog.d("TroopAddFriendTipsJoinStrategy", 2, "checkAndInsertTips fail, wrong parameters");
        }
    }
}
