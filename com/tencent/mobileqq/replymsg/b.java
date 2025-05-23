package com.tencent.mobileqq.replymsg;

import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.multimsg.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends c {
    static IPatchRedirector $redirector_;

    public b(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    private HashMap<String, ArrayList<MessageRecord>> C(List<MessageRecord> list, ArrayList<ChatMessage> arrayList) {
        HashMap<String, ArrayList<MessageRecord>> hashMap = new HashMap<>(1);
        ArrayList<MessageRecord> arrayList2 = new ArrayList<>(1);
        for (MessageRecord messageRecord : list) {
            if (messageRecord instanceof MessageForMixedMsg) {
                for (MessageRecord messageRecord2 : ((MessageForMixedMsg) messageRecord).msgElemList) {
                    if ((messageRecord2 instanceof MessageForReplyText) && ((MessageForReplyText) messageRecord2).getSourceMessage() != null) {
                        arrayList2.add(messageRecord2);
                        hashMap.put(String.valueOf(messageRecord.uniseq), arrayList2);
                    }
                }
                arrayList.add((ChatMessage) messageRecord);
            }
        }
        return hashMap;
    }

    private void D(h hVar) {
        if (this.f251530d == null) {
            return;
        }
        for (ChatMessage chatMessage : hVar.f251618b) {
            if (chatMessage instanceof MessageForMixedMsg) {
                MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) chatMessage;
                ((MixedMsgManager) this.f251530d.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).l(hVar.f251617a, messageForMixedMsg, false, messageForMixedMsg.forwardID);
            }
        }
    }

    @Override // com.tencent.mobileqq.replymsg.c, com.tencent.mobileqq.multimsg.MultiMsgController
    protected void k(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar);
        } else {
            D(hVar);
        }
    }

    @Override // com.tencent.mobileqq.replymsg.c, com.tencent.mobileqq.multimsg.MultiMsgController
    protected void p(h hVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar);
            return;
        }
        List<ChatMessage> list = hVar.f251618b;
        int i3 = 1;
        ArrayList<ChatMessage> arrayList = new ArrayList<>(1);
        QQAppInterface qQAppInterface = this.f251530d;
        if (hVar.f251624h != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        HashMap<String, ArrayList<MessageRecord>> C = C(z(qQAppInterface, list, z16), arrayList);
        hVar.f251622f = C;
        hVar.f251618b = arrayList;
        if (C.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ReplyMsgController", 2, "preHandleData dstMsgMap is empty");
            }
            D(hVar);
            return;
        }
        int i16 = hVar.f251624h;
        if (i16 == 0 || i16 != 2) {
            i3 = 0;
        }
        Message obtainMessage = this.f251534i.obtainMessage(i3);
        obtainMessage.obj = hVar;
        obtainMessage.sendToTarget();
    }

    @Override // com.tencent.mobileqq.replymsg.c, com.tencent.mobileqq.multimsg.MultiMsgController
    protected void w(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) hVar);
        } else {
            D(hVar);
        }
    }
}
