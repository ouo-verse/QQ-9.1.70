package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.group.group_member_info$MemberInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class o extends com.tencent.mobileqq.troop.api.config.l {
    static IPatchRedirector $redirector_;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.l
    public void a(String str, String str2, String str3, byte b16) {
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3, Byte.valueOf(b16));
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            ((ITroopHonorService) peekAppRuntime.getRuntimeService(ITroopHonorService.class, "")).notifyTroopMemberHonorUpdate(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.l
    public void b(TroopInfo troopInfo, TroopMemberInfo troopMemberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopInfo, (Object) troopMemberInfo);
            return;
        }
        if (troopInfo != null && troopMemberInfo != null && !TextUtils.isEmpty(troopInfo.troopuin) && !TextUtils.isEmpty(troopMemberInfo.memberuin)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                ((TroopInfoHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(TroopInfoHandler.class.getName())).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_TROOP_MEMBER_LEVEL_SINGLE_CHANGED, true, new Object[]{troopInfo.troopuin, troopMemberInfo.memberuin});
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.l
    public void c(@NonNull TroopMemberCard troopMemberCard, long j3, group_member_info$MemberInfo group_member_info_memberinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopMemberCard, Long.valueOf(j3), group_member_info_memberinfo);
            return;
        }
        if (group_member_info_memberinfo == null) {
            return;
        }
        if (group_member_info_memberinfo.str_card.has()) {
            troopMemberCard.colorCard = com.tencent.mobileqq.vas.f.j(group_member_info_memberinfo.str_card.get());
            troopMemberCard.colorCardId = com.tencent.mobileqq.vas.f.k(group_member_info_memberinfo.str_card.get().toByteArray());
            troopMemberCard.card = com.tencent.mobileqq.vas.f.o(troopMemberCard.colorCard);
        }
        if (group_member_info_memberinfo.bytes_group_honor.has()) {
            troopMemberCard.honorList = com.tencent.mobileqq.troop.honor.util.a.i(group_member_info_memberinfo.bytes_group_honor.get().toByteArray());
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberCardProcessor", 2, String.format("handleGetTroopMemberCard troopUin: %s, memberUin: %s, honorList: %s", Long.valueOf(j3), Long.valueOf(troopMemberCard.memberUin), troopMemberCard.honorList));
                return;
            }
            return;
        }
        troopMemberCard.honorList = "";
    }

    @Override // com.tencent.mobileqq.troop.api.config.l
    public void d(@NonNull TroopMemberInfo troopMemberInfo, TroopMemberCard troopMemberCard) {
        String o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopMemberInfo, (Object) troopMemberCard);
            return;
        }
        if (troopMemberCard == null) {
            return;
        }
        String str = troopMemberCard.colorCard;
        if (str == null) {
            o16 = null;
        } else {
            o16 = com.tencent.mobileqq.vas.f.o(str);
        }
        if (str != null && !str.equals(troopMemberInfo.troopColorNick)) {
            troopMemberInfo.troopColorNick = str;
        }
        if (o16 != null && !o16.equals(troopMemberInfo.troopnick)) {
            troopMemberInfo.troopnick = o16;
        }
    }
}
