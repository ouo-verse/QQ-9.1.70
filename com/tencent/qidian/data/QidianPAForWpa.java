package com.tencent.qidian.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public class QidianPAForWpa extends Entity {
    static IPatchRedirector $redirector_;
    public String kfuin;

    @unique
    public String puin;

    public QidianPAForWpa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.puin = "";
            this.kfuin = "";
        }
    }
}
