package com.tencent.imcore.message.facade.add.inner;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
class c implements com.tencent.imcore.message.facade.b {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.facade.b
    public void a(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) messageRecord);
            return;
        }
        int m3 = FlashChatManager.m(messageRecord);
        if (m3 != -1) {
            try {
                ((FlashChatManager) baseQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).b(m3, messageRecord);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QIMProcessor", 2, "addMultiMessagesInner type " + m3, e16);
                }
            }
        }
    }
}
