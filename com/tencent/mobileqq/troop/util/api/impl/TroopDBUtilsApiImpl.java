package com.tencent.mobileqq.troop.util.api.impl;

import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopDBUtilsApiImpl implements ITroopDBUtilsApi {
    static IPatchRedirector $redirector_;

    public TroopDBUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi
    public BaseTransaction getSaveTroopMemberCardInfoTransactionObj(TroopMemberCardInfo troopMemberCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseTransaction) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopMemberCardInfo);
        }
        if (troopMemberCardInfo.getStatus() == 1000) {
            return new PersistOrReplaceTransaction(troopMemberCardInfo);
        }
        if (troopMemberCardInfo.getStatus() != 1001 && troopMemberCardInfo.getStatus() != 1002) {
            return null;
        }
        return new UpdateTransaction(troopMemberCardInfo);
    }

    @Override // com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi
    public TroopMemberCardInfo getTroopMemberCardInfo(AppRuntime appRuntime, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopMemberCardInfo) iPatchRedirector.redirect((short) 4, this, appRuntime, str, str2);
        }
        if (str == null || str2 == null) {
            return null;
        }
        EntityManager createEntityManager = appRuntime.getEntityManagerFactory().createEntityManager();
        try {
            return (TroopMemberCardInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) TroopMemberCardInfo.class, str, str2);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        } finally {
            createEntityManager.close();
        }
    }

    @Override // com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi
    public boolean saveTroopMemberCardInfo(AppRuntime appRuntime, TroopMemberCardInfo troopMemberCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) troopMemberCardInfo)).booleanValue();
        }
        EntityManager createEntityManager = appRuntime.getEntityManagerFactory().createEntityManager();
        if (troopMemberCardInfo.getStatus() == 1000) {
            createEntityManager.persistOrReplace(troopMemberCardInfo);
            if (troopMemberCardInfo.getStatus() != 1001) {
                return false;
            }
            return true;
        }
        if (troopMemberCardInfo.getStatus() != 1001 && troopMemberCardInfo.getStatus() != 1002) {
            return false;
        }
        return createEntityManager.update(troopMemberCardInfo);
    }
}
