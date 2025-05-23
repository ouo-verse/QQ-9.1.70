package com.tencent.mobileqq.tofumsg;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "businessId,businessMsgId")
/* loaded from: classes18.dex */
public class TofuLimitMsgForSogou extends TofuLimitMsg {
    static IPatchRedirector $redirector_;

    public TofuLimitMsgForSogou() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static TofuLimitMsgForSogou create(@NonNull NewBeancurdMsg newBeancurdMsg) {
        TofuLimitMsgForSogou tofuLimitMsgForSogou = new TofuLimitMsgForSogou();
        tofuLimitMsgForSogou.friendUin = newBeancurdMsg.frienduin;
        tofuLimitMsgForSogou.businessId = newBeancurdMsg.busiid;
        tofuLimitMsgForSogou.businessMsgId = newBeancurdMsg.busiUuid;
        tofuLimitMsgForSogou.insertMsgTime = NetConnInfoCenter.getServerTime() * 1000;
        tofuLimitMsgForSogou.flag = 0 | 1;
        tofuLimitMsgForSogou.extra = newBeancurdMsg.pushInfoString;
        return tofuLimitMsgForSogou;
    }
}
