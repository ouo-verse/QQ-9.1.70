package com.tencent.imcore.message.messageprocessor;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(AppInterface appInterface, String str, String str2) {
        MessageRecord messageRecord;
        List<MessageRecord> msgList = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(str, 0);
        if (msgList != null) {
            for (int size = msgList.size() - 1; size >= 0; size--) {
                messageRecord = msgList.get(size);
                if (messageRecord.senderuin.equals(str2)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("vip", 2, "getLastC2CBubleID find in cache");
                    }
                    if (messageRecord != null) {
                        return 0L;
                    }
                    return messageRecord.vipBubbleID;
                }
            }
        }
        messageRecord = null;
        if (messageRecord != null) {
        }
    }
}
