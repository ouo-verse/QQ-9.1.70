package com.tencent.mobileqq.qqpermission.base;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class MessageNotificationInfo extends ResponsesInfo {
    static IPatchRedirector $redirector_;
    public String hintContent;
    public String hintTitle;
    public boolean isEnable;
    public boolean isShowHintView;

    public MessageNotificationInfo(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16));
            return;
        }
        this.isEnable = true;
        this.content = str;
        this.isDefaultCheck = z16;
        this.isChecked = z16;
    }

    public void setEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        this.isEnable = z16;
        this.isDefaultCheck = true;
        this.isChecked = true;
    }

    public MessageNotificationInfo showHintView(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageNotificationInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        this.isShowHintView = true;
        this.hintTitle = str;
        this.hintContent = str2;
        return this;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "MessageNotificationInfo{isShowHintView=" + this.isShowHintView + ", hintTitle='" + this.hintTitle + "', hintContent='" + this.hintContent + "', content='" + this.content + "', isDefaultCheck=" + this.isDefaultCheck + ", isChecked=" + this.isChecked + "} " + super.toString();
    }
}
