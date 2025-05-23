package com.tencent.imcore.message.facade.send.sender;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes7.dex */
class g implements com.tencent.imcore.message.facade.f<QQAppInterface> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.facade.f
    public boolean a(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord)).booleanValue();
        }
        int i3 = messageRecord.msgtype;
        if (i3 != -1000 && i3 != -1049) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.imcore.message.facade.f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(QQAppInterface qQAppInterface, MessageRecord messageRecord, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, messageRecord, businessObserver, Boolean.valueOf(z16));
            return;
        }
        int i3 = messageRecord.istroop;
        if (i3 == 1001) {
            if (!qQAppInterface.isLBSFriendNewClient(messageRecord.frienduin)) {
                ReportController.o(qQAppInterface, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, messageRecord.frienduin, String.valueOf(messageRecord.msgtype), String.valueOf(messageRecord.istroop), "");
            }
        } else if (i3 == 1003) {
            ReportController.o(qQAppInterface, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, messageRecord.frienduin, String.valueOf(messageRecord.msgtype), String.valueOf(messageRecord.istroop), "");
        }
        qQAppInterface.getMsgHandler().j5(messageRecord, null, z16);
    }
}
