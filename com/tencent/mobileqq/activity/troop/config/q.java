package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.info.AvatarInfoCheck;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class q extends com.tencent.mobileqq.troop.api.config.n {
    static IPatchRedirector $redirector_;

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.n
    public void a(String str, List<TroopMemberInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) list);
            return;
        }
        for (TroopMemberInfo troopMemberInfo : list) {
            ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(troopMemberInfo.memberuin, troopMemberInfo.memberUid);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.n
    public void b(@NonNull AppInterface appInterface, TroopInfo troopInfo, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, troopInfo, arrayList);
            return;
        }
        if (troopInfo != null) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopMemberListProcessor", 2, "onGetMemberListForHeadBatch uin = " + troopInfo.troopuin);
            }
            String A = GroupIconHelper.A(GroupIconHelper.I(arrayList, troopInfo), false);
            troopInfo.updateHeadMemberList(A);
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateHeaderUinNew(troopInfo.troopuin, A, "TroopMemberListProcessor");
            GroupIconHelper groupIconHelper = ((ITroopAvatarService) appInterface.getRuntimeService(ITroopAvatarService.class, "")).getGroupIconHelper();
            if (groupIconHelper != null) {
                groupIconHelper.P(troopInfo.troopuin);
            }
            AvatarInfoCheck.b(113, troopInfo.troopuin);
            AvatarInfoCheck.b(4, troopInfo.troopuin);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.n
    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                ((TroopInfoHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName())).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_TROOP_MEMBER_LEVEL_INFO_CHANGED, true, str);
            }
        }
    }
}
