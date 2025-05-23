package com.tencent.mobileqq.enterpriseqq;

import com.tencent.crmqq.structmsg.StructMsg$GetCRMMenuResponse;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EnterpriseQQMenuEntity extends Entity {
    static IPatchRedirector $redirector_;
    public byte[] data;
    public long savedDateTime;
    public int seqno;

    @unique
    public String uin;

    public EnterpriseQQMenuEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.data = null;
        this.seqno = 0;
        this.savedDateTime = 0L;
    }

    public EnterpriseQQMenuEntity(String str, StructMsg$GetCRMMenuResponse structMsg$GetCRMMenuResponse, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, structMsg$GetCRMMenuResponse, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        this.data = null;
        this.seqno = 0;
        this.savedDateTime = 0L;
        this.uin = str;
        this.data = structMsg$GetCRMMenuResponse.toByteArray();
        this.seqno = i3;
        this.savedDateTime = j3;
    }
}
