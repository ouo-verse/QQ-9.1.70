package com.tencent.qqnt.ntrelation.intimateinfo.bean;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "uid")
/* loaded from: classes22.dex */
public class NTIntimateBaseEntity extends Entity {
    static IPatchRedirector $redirector_;
    public byte[] iconFlag;
    public int intimateChatDays;
    public int intimateLevel;
    public int intimateType;
    public boolean isExtinguish;
    public boolean isListenTogetherOpen;
    public long lastIntimatChatTime;
    public String mutualMarkStoreJson;
    public String uid;
    public String uin;

    public NTIntimateBaseEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void updateByNTIntimateSimpleInfo(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        this.uid = aVar.getUid();
        this.uin = aVar.n();
        this.intimateType = aVar.j();
        this.intimateLevel = aVar.f();
        this.intimateChatDays = aVar.e();
        this.lastIntimatChatTime = aVar.k();
        Boolean bool = Boolean.TRUE;
        this.isExtinguish = bool.equals(aVar.o());
        this.mutualMarkStoreJson = aVar.m();
        this.iconFlag = aVar.b();
        this.isListenTogetherOpen = bool.equals(aVar.p());
    }

    public void updateNTIntimateSimpleInfo(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        aVar.A(this.uid);
        aVar.B(this.uin);
        aVar.v(this.intimateType);
        aVar.u(this.intimateLevel);
        aVar.t(this.intimateChatDays);
        aVar.w(this.lastIntimatChatTime);
        aVar.r(Boolean.valueOf(this.isExtinguish));
        aVar.z(this.mutualMarkStoreJson);
        aVar.s(this.iconFlag);
        aVar.x(Boolean.valueOf(this.isListenTogetherOpen));
    }
}
