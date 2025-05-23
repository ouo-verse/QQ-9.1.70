package com.tencent.mobileqq.troopAddFrd.strategy;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.x;
import com.tencent.mobileqq.troopAddFrd.h;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAddFriendTipsNewComerStrategy extends a {
    static IPatchRedirector $redirector_;

    public TroopAddFriendTipsNewComerStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(QQAppInterface qQAppInterface, com.tencent.mobileqq.relationx.batchAdd.c cVar, String str) {
        ThreadManagerV2.excute(new Runnable(qQAppInterface, str, cVar) { // from class: com.tencent.mobileqq.troopAddFrd.strategy.TroopAddFriendTipsNewComerStrategy.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f302705d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f302706e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.relationx.batchAdd.c f302707f;

            {
                this.f302705d = qQAppInterface;
                this.f302706e = str;
                this.f302707f = cVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopAddFriendTipsNewComerStrategy.this, qQAppInterface, str, cVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                x troopBatchAddFriendMgr = ((ITroopBatchAddFriendService) this.f302705d.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
                ArrayList<h> p16 = troopBatchAddFriendMgr.p(this.f302706e);
                if (p16 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopAddFriendTipsNewComerStrategy", 2, "doCheckAndInsertTipsStrategyB newMemberList is empty");
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<h> it = p16.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (TroopAddFriendTipsNewComerStrategy.this.d(this.f302707f, next)) {
                        arrayList.add(next.f302681a);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAddFriendTipsNewComerStrategy", 2, "validMemberList.size=" + arrayList.size());
                }
                if (arrayList.size() > 0) {
                    troopBatchAddFriendMgr.M(this.f302706e, arrayList, 4);
                }
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(com.tencent.mobileqq.relationx.batchAdd.c cVar, h hVar) {
        if (hVar != null && !TextUtils.isEmpty(hVar.f302682b)) {
            long currentTimeMillis = System.currentTimeMillis() - Long.parseLong(hVar.f302682b);
            if (QLog.isColorLevel()) {
                QLog.d("TroopAddFriendTipsNewComerStrategy", 2, "joinTimeLen: " + currentTimeMillis);
            }
            if (currentTimeMillis < 0 || currentTimeMillis > cVar.mNewComerJoinTimeLimit * 60000) {
                return false;
            }
            return true;
        }
        QLog.e("TroopAddFriendTipsNewComerStrategy", 1, "isNewMemberSatisfied memberInfo invalid");
        return false;
    }

    @Override // com.tencent.mobileqq.troopAddFrd.strategy.a
    public void a(QQAppInterface qQAppInterface, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) strArr);
            return;
        }
        if (qQAppInterface != null && strArr != null && strArr.length != 0) {
            String str = strArr[0];
            TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (troopManager == null) {
                QLog.e("TroopAddFriendTipsNewComerStrategy", 1, "checkAndInsertTips fail, troopManager is null");
                return;
            } else {
                c(qQAppInterface, troopManager.o(), str);
                return;
            }
        }
        QLog.e("TroopAddFriendTipsNewComerStrategy", 1, "checkAndInsertTips fail, wrong parameters");
    }
}
