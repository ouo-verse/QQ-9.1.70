package com.tencent.qidian.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BmqqAccountType extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_ACCOUNT_BMQQ_EXT = 0;
    public static final int TYPE_ACCOUNT_CRM_EXT = 2;
    public static final int TYPE_ACCOUNT_CRM_MAIN = 3;
    public static final int TYPE_ACCOUNT_NOT_UIN = 5;
    public static final int TYPE_ACCOUNT_QIDIAN_EXT = 1;
    public static final int TYPE_ACCOUNT_QIDIAN_MAIN = 6;
    public static final int TYPE_ACCOUNT_UNKNOW = 4;
    public int mAccountType;

    @unique
    public String mUin;

    public BmqqAccountType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mUin = "";
            this.mAccountType = 0;
        }
    }

    public int getAccountType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mAccountType;
    }

    public String getUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mUin;
    }

    public void setAccountType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mAccountType = i3;
        }
    }

    public BmqqAccountType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        } else {
            this.mUin = str;
            this.mAccountType = i3;
        }
    }
}
