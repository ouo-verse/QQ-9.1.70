package com.tencent.imcore.message.facade;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes7.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(QQAppInterface qQAppInterface, String str) {
        MessageRecord messageRecord;
        List<MessageRecord> p16 = qQAppInterface.getMessageProxy(0).p(str, 0);
        if (p16 != null) {
            for (int size = p16.size() - 1; size >= 0; size--) {
                messageRecord = p16.get(size);
                String str2 = messageRecord.senderuin;
                if (str2 != null && str2.equals(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("vip", 2, "getLastC2CBubleID find in cache");
                    }
                    if (messageRecord == null) {
                        List<MessageRecord> V = qQAppInterface.getMessageProxy(0).V(str, 0, Long.MAX_VALUE, 1, String.format(Locale.US, "issend<>%d and issend<>%d", 1, 2));
                        if (V != null && !V.isEmpty()) {
                            messageRecord = V.get(0);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("vip", 2, "getLastC2CBubleID find in db");
                        }
                    }
                    if (messageRecord != null) {
                        return 0L;
                    }
                    return messageRecord.vipBubbleID;
                }
            }
        }
        messageRecord = null;
        if (messageRecord == null) {
        }
        if (messageRecord != null) {
        }
    }
}
