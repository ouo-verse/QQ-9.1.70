package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.group.group_member_info$MemberInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class l {
    static IPatchRedirector $redirector_;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(String str, String str2, String str3, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3, Byte.valueOf(b16));
        }
    }

    public void b(TroopInfo troopInfo, TroopMemberInfo troopMemberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopInfo, (Object) troopMemberInfo);
        }
    }

    public void c(@NonNull TroopMemberCard troopMemberCard, long j3, group_member_info$MemberInfo group_member_info_memberinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopMemberCard, Long.valueOf(j3), group_member_info_memberinfo);
        }
    }

    public void d(@NonNull TroopMemberInfo troopMemberInfo, TroopMemberCard troopMemberCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopMemberInfo, (Object) troopMemberCard);
        }
    }
}
