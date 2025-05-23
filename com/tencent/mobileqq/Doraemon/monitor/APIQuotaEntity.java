package com.tencent.mobileqq.Doraemon.monitor;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "type,appid,apiName")
/* loaded from: classes9.dex */
public class APIQuotaEntity extends Entity {
    static IPatchRedirector $redirector_;
    public String apiName;
    public String appid;
    public long expireTimeMillis;
    public long remainTimes;
    public int type;

    public APIQuotaEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
