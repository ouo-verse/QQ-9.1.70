package com.tencent.mobileqq.profilecard.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* loaded from: classes16.dex */
public class ProfileLabelInfo implements Cloneable, Serializable {
    static IPatchRedirector $redirector_;
    public static int STATUS_CHECKED;
    public static int STATUS_NORMAL;
    public Long labelId;
    public String labelName;
    public int labelStatus;
    public Long likeNum;
    public String typeId;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42599);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            STATUS_NORMAL = 0;
            STATUS_CHECKED = 1;
        }
    }

    public ProfileLabelInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.labelStatus = STATUS_NORMAL;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return this;
        }
    }

    public void toggleStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        int i3 = this.labelStatus;
        int i16 = STATUS_NORMAL;
        if (i3 == i16) {
            this.labelStatus = STATUS_CHECKED;
        } else if (i3 == STATUS_CHECKED) {
            this.labelStatus = i16;
        }
    }

    public ProfileLabelInfo(Long l3, Long l16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, l3, l16, str);
            return;
        }
        this.labelStatus = STATUS_NORMAL;
        this.labelId = l3;
        this.labelName = str;
        this.likeNum = l16;
    }
}
