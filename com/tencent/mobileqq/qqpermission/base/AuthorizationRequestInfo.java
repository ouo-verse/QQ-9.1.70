package com.tencent.mobileqq.qqpermission.base;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AuthorizationRequestInfo {
    static IPatchRedirector $redirector_;
    public boolean bottomIsDefaultCheck;
    public String bottomText;
    public Drawable businessIconDrawable;
    public int businessIconResId;
    public int dialogType;
    public String hintContent;
    public String hintTitle;
    public String iconText;
    public boolean isShowBottomCheck;
    public boolean isShowTitleHint;
    public QQAuthorizationDialog.AuthorizationListener listener;
    public String messageContent;
    public Drawable messageIconDrawable;
    public int messageIconResId;
    public List<AuthorizationMessage> messageList;
    public String messageSupplement;
    public List<MessageNotificationInfo> notificationInfoList;
    public String requestContent;
    public String requestSupplement;
    public String subHead;

    public AuthorizationRequestInfo(int i3, String str, String str2, QQAuthorizationDialog.AuthorizationListener authorizationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, authorizationListener);
            return;
        }
        this.businessIconResId = i3;
        this.iconText = str;
        this.requestContent = str2;
        this.listener = authorizationListener;
    }

    public AuthorizationRequestInfo checkTextListDialog(List<AuthorizationMessage> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AuthorizationRequestInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
        }
        this.dialogType = 2;
        this.messageList = list;
        return this;
    }

    public AuthorizationRequestInfo imageTextDialog(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AuthorizationRequestInfo) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, str2);
        }
        this.dialogType = 1;
        this.messageIconResId = i3;
        this.messageContent = str;
        this.messageSupplement = str2;
        return this;
    }

    public AuthorizationRequestInfo messageNotificationDialog(List<MessageNotificationInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AuthorizationRequestInfo) iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        }
        this.dialogType = 3;
        if (list != null && list.size() == 1) {
            Iterator<MessageNotificationInfo> it = list.iterator();
            while (it.hasNext()) {
                it.next().setEnable(false);
            }
        }
        this.notificationInfoList = list;
        return this;
    }

    public AuthorizationRequestInfo plainTextDialog(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AuthorizationRequestInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.dialogType = 0;
        this.requestSupplement = str;
        return this;
    }

    public AuthorizationRequestInfo setSubHead(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AuthorizationRequestInfo) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        this.subHead = str;
        return this;
    }

    public AuthorizationRequestInfo showBottomCheck(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AuthorizationRequestInfo) iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), str);
        }
        this.isShowBottomCheck = true;
        this.bottomIsDefaultCheck = z16;
        this.bottomText = str;
        return this;
    }

    public AuthorizationRequestInfo showHintView(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AuthorizationRequestInfo) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        }
        this.isShowTitleHint = true;
        this.hintTitle = str;
        this.hintContent = str2;
        return this;
    }

    public AuthorizationRequestInfo imageTextDialog(Drawable drawable, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AuthorizationRequestInfo) iPatchRedirector.redirect((short) 5, this, drawable, str, str2);
        }
        this.dialogType = 1;
        this.messageIconDrawable = drawable;
        this.messageContent = str;
        this.messageSupplement = str2;
        return this;
    }

    public AuthorizationRequestInfo(Drawable drawable, String str, String str2, QQAuthorizationDialog.AuthorizationListener authorizationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, drawable, str, str2, authorizationListener);
            return;
        }
        this.businessIconDrawable = drawable;
        this.iconText = str;
        this.requestContent = str2;
        this.listener = authorizationListener;
    }
}
