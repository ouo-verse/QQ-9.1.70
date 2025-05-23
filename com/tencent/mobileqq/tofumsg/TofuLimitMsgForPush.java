package com.tencent.mobileqq.tofumsg;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "businessId,businessMsgId")
/* loaded from: classes18.dex */
public class TofuLimitMsgForPush extends TofuLimitMsg {
    static IPatchRedirector $redirector_;

    public TofuLimitMsgForPush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static TofuLimitMsgForPush create(@NonNull NewBeancurdMsg newBeancurdMsg) {
        TofuLimitMsgForPush tofuLimitMsgForPush = new TofuLimitMsgForPush();
        tofuLimitMsgForPush.friendUin = newBeancurdMsg.frienduin;
        tofuLimitMsgForPush.businessId = newBeancurdMsg.busiid;
        tofuLimitMsgForPush.businessMsgId = newBeancurdMsg.busiUuid;
        tofuLimitMsgForPush.insertMsgTime = NetConnInfoCenter.getServerTime() * 1000;
        tofuLimitMsgForPush.flag = 0 | 1;
        tofuLimitMsgForPush.extra = newBeancurdMsg.pushInfoString;
        return tofuLimitMsgForPush;
    }
}
