package com.tencent.mobileqq.app.msgnotify;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b implements MsgNotifyManager.Callback {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.msgnotify.MsgNotifyManager.Callback
    public int getUnNotificationSenderNum(Message message, MsgNotifyManager msgNotifyManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message, (Object) msgNotifyManager)).intValue();
        }
        ISubAccountService iSubAccountService = (ISubAccountService) ((QQAppInterface) msgNotifyManager.getApp()).getRuntimeService(ISubAccountService.class, "");
        if (iSubAccountService != null) {
            return iSubAccountService.getUnNotifySenderNum(message.frienduin);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.app.msgnotify.MsgNotifyManager.Callback
    public boolean isNotCount(boolean z16, Message message, MsgNotifyManager msgNotifyManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), message, msgNotifyManager)).booleanValue();
        }
        if (z16 && com.tencent.util.notification.d.k(message)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.msgnotify.MsgNotifyManager.Callback
    public void onCancelNotification(Message message, Message message2, MsgNotifyManager msgNotifyManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, message, message2, msgNotifyManager);
        } else {
            ((QQAppInterface) msgNotifyManager.getApp()).showReadedMsgNotification(message2, message);
        }
    }

    @Override // com.tencent.mobileqq.app.msgnotify.MsgNotifyManager.Callback
    public void onRemove(String str, int i3, Message message, MsgNotifyManager msgNotifyManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), message, msgNotifyManager);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) msgNotifyManager.getApp();
        if (com.tencent.util.notification.d.j(i3, str)) {
            com.tencent.util.notification.d.h(qQAppInterface).d(str);
        } else {
            qQAppInterface.showReadedMsgNotification(message, null);
        }
    }

    @Override // com.tencent.mobileqq.app.msgnotify.MsgNotifyManager.Callback
    public void onRemove(int i3, Message message, MsgNotifyManager msgNotifyManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            ((QQAppInterface) msgNotifyManager.getApp()).showReadedMsgNotification(message, null);
        } else {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), message, msgNotifyManager);
        }
    }
}
