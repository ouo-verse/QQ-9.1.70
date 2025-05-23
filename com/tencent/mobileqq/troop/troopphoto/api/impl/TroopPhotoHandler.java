package com.tencent.mobileqq.troop.troopphoto.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.troopphoto.api.b;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.TroopInfoRepo;
import cooperation.qzone.LocalMultiProcConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* loaded from: classes19.dex */
public class TroopPhotoHandler extends TroopBaseHandler implements com.tencent.mobileqq.troop.troopphoto.api.a {
    static IPatchRedirector $redirector_;

    public TroopPhotoHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit G2(boolean z16, String str, Boolean bool, Integer num, String str2, TroopInfo troopInfo) {
        if (bool.booleanValue() && troopInfo != null && z16) {
            H2(str);
            return null;
        }
        return null;
    }

    public void H2(String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(str);
        if (QLog.isColorLevel() && troopInfoFromCache != null) {
            QLog.d("TroopPhotoHandler", 2, "PrivilegeFlag:" + troopInfoFromCache.troopPrivilegeFlag);
            QLog.d("TroopPhotoHandler", 2, "troop.isAdmin:" + troopInfoFromCache.isOwnerOrAdmin());
        }
        if (troopInfoFromCache != null && (troopInfoFromCache.troopPrivilegeFlag & 1) == 1 && !troopInfoFromCache.isOwnerOrAdmin()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        long longValue = Long.valueOf(this.appRuntime.getCurrentAccountUin()).longValue();
        if (i3 != LocalMultiProcConfig.getInt4Uin(this.appRuntime.getCurrentAccountUin() + "__qzone_pic_permission__" + str, -1, longValue)) {
            LocalMultiProcConfig.putInt4Uin(this.appRuntime.getCurrentAccountUin() + "__qzone_pic_permission__" + str, i3, longValue);
        }
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopPhotoHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopphoto.api.a
    public void t(final String str, final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16));
        } else {
            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopPhotoPrivilege(str, "TroopPhotoHandler", null, new Function4() { // from class: com.tencent.mobileqq.troop.troopphoto.api.impl.a
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit G2;
                    G2 = TroopPhotoHandler.this.G2(z16, str, (Boolean) obj, (Integer) obj2, (String) obj3, (TroopInfo) obj4);
                    return G2;
                }
            });
        }
    }
}
