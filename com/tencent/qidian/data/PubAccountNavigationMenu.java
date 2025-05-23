package com.tencent.qidian.data;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = IPublicAccountBrowser.KEY_PUB_UIN)
/* loaded from: classes22.dex */
public class PubAccountNavigationMenu extends Entity {
    static IPatchRedirector $redirector_;

    @unique
    public long puin;
    public int version;
    public String xml;

    public PubAccountNavigationMenu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.puin = 0L;
        this.xml = "";
        this.version = 0;
    }
}
