package com.tencent.mobileqq.fragment.blacklist.userdb.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class UserDisplayData extends Entity {
    static IPatchRedirector $redirector_;
    public String avatar;
    public String nickName;

    @unique
    public String uin;

    public UserDisplayData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public void copyProperties(UserDisplayData userDisplayData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) userDisplayData);
            return;
        }
        this.uin = userDisplayData.uin;
        this.nickName = userDisplayData.nickName;
        this.avatar = userDisplayData.avatar;
    }

    public UserDisplayData(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3);
            return;
        }
        this.uin = str;
        this.nickName = str2;
        this.avatar = str3;
    }

    public UserDisplayData(UserDisplayData userDisplayData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            copyProperties(userDisplayData);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userDisplayData);
        }
    }
}
