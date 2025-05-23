package com.tencent.mobileqq.persistence;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.g;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class h implements g.a {
    @Override // com.tencent.mobileqq.persistence.g.a
    public void a(List<MessageRecord> list) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (list != null && list.size() > 0 && peekAppRuntime != null) {
            try {
                QQMessageFacade qQMessageFacade = (QQMessageFacade) peekAppRuntime.getManager(QQManagerFactory.MGR_MSG_FACADE);
                if (qQMessageFacade == null) {
                    return;
                }
                for (MessageRecord messageRecord : list) {
                    qQMessageFacade.U0(messageRecord.frienduin, messageRecord.istroop, messageRecord);
                }
            } catch (Throwable th5) {
                QLog.d("MessageRecordEntityManagerCallback", 1, "error ", th5);
            }
        }
    }
}
