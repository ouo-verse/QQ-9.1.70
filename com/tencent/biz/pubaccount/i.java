package com.tencent.biz.pubaccount;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i extends com.tencent.imcore.message.i {
    public i(QQAppInterface qQAppInterface, MessageHandler messageHandler) {
        super(qQAppInterface, messageHandler);
    }

    public ArrayList<MessageRecord> Y0(long j3, List<msg_comm$Msg> list) {
        ArrayList<MessageRecord> Z0 = Z0(j3, list);
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        j(Z0, arrayList, true);
        Z0.clear();
        return arrayList;
    }

    public ArrayList<MessageRecord> Z0(long j3, List<msg_comm$Msg> list) {
        List<msg_comm$Msg> arrayList = new ArrayList<>();
        h(list, arrayList);
        ArrayList<MessageRecord> arrayList2 = new ArrayList<>();
        com.tencent.mobileqq.service.message.a aVar = new com.tencent.mobileqq.service.message.a(this.f116342a.getLongAccountUin(), j3, true, true, false, false);
        aVar.f286161p = true;
        Iterator<msg_comm$Msg> it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                List<MessageRecord> L = L(it.next(), aVar);
                if (L != null && !L.isEmpty()) {
                    arrayList2.addAll(L);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("DynamicMsgProcessor", 2, "decodeSinglePBMsg_C2C error,", e16);
                }
            }
        }
        return arrayList2;
    }

    public void a1(long j3, List<msg_comm$Msg> list) {
        ArrayList<MessageRecord> Y0 = Y0(j3, list);
        if (Y0 != null && Y0.size() > 0) {
            IPublicAccountManager iPublicAccountManager = (IPublicAccountManager) QRoute.api(IPublicAccountManager.class);
            long msgID = iPublicAccountManager.getMsgID(this.f116342a, String.valueOf(j3));
            if (msgID == 0) {
                msgID = Long.MAX_VALUE;
            }
            Iterator<MessageRecord> it = Y0.iterator();
            while (it.hasNext()) {
                String extInfoFromExtStr = it.next().getExtInfoFromExtStr("pa_msgId");
                if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                    try {
                        long parseLong = Long.parseLong(extInfoFromExtStr);
                        if (parseLong < msgID && parseLong != 0) {
                            iPublicAccountManager.setMsgID(this.f116342a, String.valueOf(j3), parseLong);
                            msgID = parseLong;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).addMessage(Y0, this.f116342a.getCurrentAccountUin(), true);
    }
}
