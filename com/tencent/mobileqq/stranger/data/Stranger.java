package com.tencent.mobileqq.stranger.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "uin")
/* loaded from: classes18.dex */
public class Stranger extends Entity {
    static IPatchRedirector $redirector_;
    public byte age;
    public byte gender;
    public String groupName;
    public String login;
    public byte loginId;
    public String name;
    public String remark;
    public long time;

    @unique
    public String uin;

    public Stranger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "Stranger{uin='" + this.uin + "', name='" + this.name + "', age=" + ((int) this.age) + ", remark='" + this.remark + "', gender=" + ((int) this.gender) + ", groupName='" + this.groupName + "', login='" + this.login + "', loginId=" + ((int) this.loginId) + ", time=" + this.time + '}';
    }
}
