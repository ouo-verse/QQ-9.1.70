package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BaseMessageHandlerUtils {
    static IPatchRedirector $redirector_;

    public BaseMessageHandlerUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void blankMsgFilter(List<MessageRecord> list) {
        boolean z16;
        if (list != null && list.size() > 1) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                MessageRecord messageRecord = list.get(i3);
                if (com.tencent.mobileqq.service.message.s.h(messageRecord)) {
                    if ((i3 > 0 && list.get(i3 - 1).shmsgseq == messageRecord.shmsgseq) || (i3 < list.size() - 1 && list.get(i3 + 1).shmsgseq == messageRecord.shmsgseq)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(messageRecord);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    public static boolean hasRecvAndUnreadMsg(ArrayList<MessageRecord> arrayList) {
        if (arrayList == null) {
            return false;
        }
        Iterator<MessageRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            MessageRecord next = it.next();
            if (!next.isSend() && !next.isread) {
                return true;
            }
        }
        return false;
    }
}
