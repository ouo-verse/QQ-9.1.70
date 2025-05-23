package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioKeywordTipInfo extends Entity implements Serializable {
    static IPatchRedirector $redirector_;
    public String icon;

    @unique
    public int ruleId;
    public String summary;
    public String title;
    public String url;
    public int version;

    public TroopAioKeywordTipInfo() {
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
        return "ruleId=" + this.ruleId + "title=" + this.title + "summary" + this.summary + "icon" + this.icon + "url" + this.url + "version" + this.version;
    }
}
