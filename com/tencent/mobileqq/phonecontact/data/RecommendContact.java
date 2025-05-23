package com.tencent.mobileqq.phonecontact.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RecommendContact extends Entity {
    static IPatchRedirector $redirector_;
    public String contactName;
    public boolean isRead;

    @unique
    public String key;
    public String mobileCode;
    public String mobileNo;
    public String nationCode;
    public String nickName;
    public long originBinder;
    public String source;
    public long timeStamp;
    public int type;
    public String uin;

    public RecommendContact() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        return this.key.equals(((RecommendContact) obj).key);
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.key.hashCode();
    }
}
