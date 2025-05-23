package com.tencent.mobileqq.tofumsg;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "businessId,businessMsgId")
/* loaded from: classes18.dex */
public class TofuLimitMsg extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final int FLAG_VER = 1;
    public static final long S_TO_MILLISECOND = 1000;
    public long businessId;
    public String businessMsgId;
    public String extra;
    public int flag;
    public String friendUin;
    public long insertMsgTime;

    public TofuLimitMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.friendUin = "";
        }
    }

    public static TofuLimitMsg create(@NonNull NewBeancurdMsg newBeancurdMsg) {
        TofuLimitMsg tofuLimitMsg = new TofuLimitMsg();
        tofuLimitMsg.friendUin = newBeancurdMsg.frienduin;
        tofuLimitMsg.businessId = newBeancurdMsg.busiid;
        tofuLimitMsg.businessMsgId = newBeancurdMsg.busiUuid;
        tofuLimitMsg.insertMsgTime = NetConnInfoCenter.getServerTime() * 1000;
        tofuLimitMsg.flag = 0 | 1;
        tofuLimitMsg.extra = newBeancurdMsg.pushInfoString;
        return tofuLimitMsg;
    }

    public NewBeancurdMsg.ExtraTofuInfo parseToGetPushInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (NewBeancurdMsg.ExtraTofuInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return NewBeancurdMsg.ExtraTofuInfo.parseToGetPushInfo(this.extra);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return getClass().getSimpleName() + "{friendUin='" + this.friendUin + "', businessId=" + this.businessId + ", businessMsgId=" + this.businessMsgId + ", insertMsgTime=" + this.insertMsgTime + ", flag=" + this.flag + ", extra='" + this.extra + "'}";
    }
}
