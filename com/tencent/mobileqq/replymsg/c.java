package com.tencent.mobileqq.replymsg;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.multimsg.MultiMsgController;
import com.tencent.mobileqq.multimsg.h;
import com.tencent.mobileqq.multimsg.i;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends MultiMsgController {
    static IPatchRedirector $redirector_;

    public c(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    private void A(MessageForReplyText messageForReplyText, MessageForReplyText messageForReplyText2) {
        MessageRecord messageRecord;
        if (messageForReplyText2.getSourceMessage() == null) {
            QLog.d("ReplyMsgController", 1, "originMsg is null");
            return;
        }
        messageForReplyText.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(messageForReplyText2.mSourceMsgInfo);
        MessageRecord sourceMessage = messageForReplyText2.getSourceMessage();
        if (sourceMessage != null) {
            int i3 = sourceMessage.msgtype;
            if (i3 == -1037) {
                messageRecord = ((MessageForLongMsg) sourceMessage).rebuildLongMsg(true);
            } else if (i3 == -1036) {
                messageRecord = (MessageForMixedMsg) ((MessageForLongMsg) sourceMessage).rebuildLongMsg();
            } else if (i3 == -1035) {
                messageRecord = ((MessageForMixedMsg) sourceMessage).rebuildMixedMsg();
            } else if (i3 == -2011) {
                messageRecord = new MessageForStructing(sourceMessage);
            } else if (i3 == -2000) {
                messageRecord = (MessageRecord) sourceMessage.deepCopyByReflect();
                if (!TextUtils.isEmpty(messageForReplyText.mSourceMsgInfo.mSourceMsgTroopName)) {
                    messageRecord.istroop = messageForReplyText.istroop;
                }
            } else {
                messageRecord = (MessageRecord) sourceMessage.deepCopyByReflect();
            }
        } else {
            messageRecord = null;
        }
        if (messageRecord == null && QLog.isColorLevel()) {
            QLog.d("ReplyMsgController", 2, "MessageForReplyText deepCopySourceMsg is null");
        }
        messageForReplyText.setSourceMessageRecord(messageRecord);
    }

    private void B(h hVar) {
        ArrayList<MessageRecord> arrayList;
        HashMap<String, ArrayList<MessageRecord>> hashMap = hVar.f251622f;
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext() && (arrayList = hashMap.get(it.next())) != null) {
            Iterator<MessageRecord> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                MessageRecord next = it5.next();
                if (next instanceof MessageForReplyText) {
                    MessageForReplyText messageForReplyText = (MessageForReplyText) next;
                    String str = next.f203106msg;
                    if (str == null) {
                        str = "";
                    }
                    ChatActivityFacade.M0(this.f251530d, null, hVar.f251617a, str, messageForReplyText.atInfoList, y(messageForReplyText, hVar));
                }
            }
        }
    }

    private ChatActivityFacade.d y(MessageForReplyText messageForReplyText, h hVar) {
        SessionInfo sessionInfo = hVar.f251617a;
        int i3 = hVar.f251633q;
        ChatActivityFacade.d dVar = new ChatActivityFacade.d();
        dVar.f175142f = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        dVar.f175143g = System.currentTimeMillis();
        String extInfoFromExtStr = messageForReplyText.getExtInfoFromExtStr("sens_reply_special_msg");
        String extInfoFromExtStr2 = messageForReplyText.getExtInfoFromExtStr("sens_reply_special_at_list");
        boolean z16 = true;
        if (!TextUtils.isEmpty(extInfoFromExtStr) && !TextUtils.isEmpty(extInfoFromExtStr2) && i3 <= 0) {
            dVar.f175149m = extInfoFromExtStr2;
            ArrayList<AtTroopMemberInfo> troopMemberInfoFromExtrJson = MessageForText.getTroopMemberInfoFromExtrJson(extInfoFromExtStr2);
            String z17 = ChatActivityFacade.z(extInfoFromExtStr, troopMemberInfoFromExtrJson);
            if (!TextUtils.isEmpty(z17)) {
                extInfoFromExtStr = s.d(z17, true, troopMemberInfoFromExtrJson);
            }
            dVar.f175148l = extInfoFromExtStr;
            messageForReplyText.removeExtInfoToExtStr("sens_reply_special_msg");
            messageForReplyText.removeExtInfoToExtStr("sens_reply_special_at_list");
        }
        MessageForReplyText.SourceMsgInfo sourceMsgInfo = messageForReplyText.mSourceMsgInfo;
        if (sourceMsgInfo != null) {
            dVar.f175144h = new MessageForReplyText.SourceMsgInfo(sourceMsgInfo);
            if (messageForReplyText.getSourceMessage() != null) {
                dVar.f175144h.packSourceMsg(this.f251530d, messageForReplyText.getSourceMessage());
                dVar.f175144h.setOrigNickName(messageForReplyText.getSourceMessage());
            }
            if (i3 > 0) {
                dVar.f175151o = messageForReplyText.uniseq;
                dVar.f175150n = i3;
                messageForReplyText.atInfoList = null;
            }
            MessageForReplyText.SourceMsgInfo sourceMsgInfo2 = dVar.f175144h;
            sourceMsgInfo2.mType = 0;
            if (messageForReplyText.mSourceMsgInfo.aioMsgRevokeType == s61.a.f433388b) {
                sourceMsgInfo2.mSourceMsgText = HardCodeUtil.qqStr(R.string.f181163d1);
                MessageForReplyText.SourceMsgInfo sourceMsgInfo3 = dVar.f175144h;
                sourceMsgInfo3.mType = 0;
                sourceMsgInfo3.oriMsgType = 0;
            }
        }
        if (messageForReplyText.istroop != 1 || sessionInfo.f179555d != 1 || !sessionInfo.f179557e.equals(messageForReplyText.frienduin)) {
            z16 = false;
        }
        if (!hVar.f251634r || z16) {
            dVar.f175145i = messageForReplyText.isBarrageMsg;
            dVar.f175146j = messageForReplyText.barrageTimeLocation;
            dVar.f175147k = messageForReplyText.barrageSourceMsgType;
        }
        return dVar;
    }

    @Override // com.tencent.mobileqq.multimsg.MultiMsgController
    protected void k(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReplyMsgController", 2, "onFailed");
        }
        ad.a aVar = new ad.a();
        aVar.f258608l = hVar.b();
        q(aVar);
    }

    @Override // com.tencent.mobileqq.multimsg.MultiMsgController
    protected void p(h hVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) hVar);
            return;
        }
        List<ChatMessage> list = hVar.f251618b;
        QQAppInterface qQAppInterface = this.f251530d;
        int i3 = 0;
        if (hVar.f251624h != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        ArrayList<MessageRecord> z17 = z(qQAppInterface, list, z16);
        HashMap<String, ArrayList<MessageRecord>> hashMap = new HashMap<>(1);
        Iterator<MessageRecord> it = z17.iterator();
        while (it.hasNext()) {
            MessageRecord next = it.next();
            String valueOf = String.valueOf(next.uniseq);
            ArrayList<MessageRecord> arrayList = new ArrayList<>(1);
            arrayList.add(next);
            hashMap.put(valueOf, arrayList);
        }
        hVar.f251622f = hashMap;
        int i16 = hVar.f251624h;
        if (i16 != 0 && i16 == 2) {
            i3 = 1;
        }
        Message obtainMessage = this.f251534i.obtainMessage(i3);
        obtainMessage.obj = hVar;
        obtainMessage.sendToTarget();
    }

    @Override // com.tencent.mobileqq.multimsg.MultiMsgController, com.tencent.mobileqq.pic.ad
    public void q(ad.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        if (this.f251533h.get() || this.f251530d == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReplyMsgController", 2, "onSend result.data=" + aVar.f258608l);
        }
        Object obj = aVar.f258608l;
        if (obj != null && (obj instanceof String)) {
            h hVar = this.f251532f.get((String) obj);
            if (QLog.isColorLevel()) {
                QLog.d("ReplyMsgController", 2, "onSend request=" + hVar);
            }
            if (hVar == null) {
                return;
            }
            this.f251532f.remove(hVar.b());
            B(hVar);
        }
    }

    @Override // com.tencent.mobileqq.multimsg.MultiMsgController
    protected void t(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) hVar);
        }
    }

    @Override // com.tencent.mobileqq.multimsg.MultiMsgController
    public void u(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) hVar);
            return;
        }
        if (this.f251533h.get() || this.f251530d == null) {
            return;
        }
        if (!this.f251532f.containsKey(hVar.b())) {
            this.f251532f.put(hVar.b(), hVar);
        }
        Message obtainMessage = this.f251534i.obtainMessage(-1);
        obtainMessage.obj = hVar;
        obtainMessage.sendToTarget();
    }

    @Override // com.tencent.mobileqq.multimsg.MultiMsgController
    protected void w(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) hVar);
            return;
        }
        ad.a aVar = new ad.a();
        aVar.f258608l = hVar.b();
        q(aVar);
    }

    @Override // com.tencent.mobileqq.multimsg.MultiMsgController
    public void x(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar);
            return;
        }
        if (this.f251533h.get() || this.f251530d == null) {
            return;
        }
        if (hVar.f251622f.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ReplyMsgController", 2, "uploadRichMsg dstMsgMap is empty");
            }
        } else {
            hVar.e(15);
            Iterator<com.tencent.mobileqq.multimsg.c> it = this.f251531e.iterator();
            while (it.hasNext()) {
                it.next().a(hVar, hVar.f251622f, this);
            }
            i.p("ReplyMsgController step.uploadRichStart", new Object[0]);
        }
    }

    public ArrayList<MessageRecord> z(QQAppInterface qQAppInterface, List<? extends MessageRecord> list, boolean z16) {
        MessageRecord messageRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, this, qQAppInterface, list, Boolean.valueOf(z16));
        }
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        for (MessageRecord messageRecord2 : list) {
            if (z16) {
                int i3 = messageRecord2.msgtype;
                if (i3 == -1037) {
                    messageRecord = ((MessageForLongMsg) messageRecord2).rebuildLongMsg(true);
                } else if (i3 == -1036) {
                    messageRecord = (MessageForMixedMsg) ((MessageForLongMsg) messageRecord2).rebuildLongMsg();
                } else if (i3 == -1035) {
                    messageRecord = ((MessageForMixedMsg) messageRecord2).rebuildMixedMsg();
                } else if (i3 == -2011) {
                    messageRecord = new MessageForStructing(messageRecord2);
                } else if (i3 == -1049) {
                    messageRecord = (MessageRecord) messageRecord2.deepCopyByReflect();
                    A((MessageForReplyText) messageRecord, (MessageForReplyText) messageRecord2);
                } else {
                    messageRecord = (MessageRecord) messageRecord2.deepCopyByReflect();
                }
                if (messageRecord == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReplyMsgController", 2, "preAddMultiMsg.mrTemp is null ,not normal...");
                    }
                } else {
                    if (!TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("troop_at_info_list"))) {
                        messageRecord.removeExtInfoToExtStr("troop_at_info_list");
                    }
                    if (!TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("disc_at_info_list"))) {
                        messageRecord.removeExtInfoToExtStr("disc_at_info_list");
                    }
                    messageRecord.atInfoList = null;
                    messageRecord.extLong = messageRecord2.extLong;
                }
            } else {
                messageRecord = messageRecord2;
            }
            if (messageRecord != null) {
                messageRecord.uniseq = messageRecord2.uniseq;
                messageRecord.msgseq = messageRecord2.msgseq;
                if (FileManagerUtil.isMessageRecordOfFile(messageRecord)) {
                    qQAppInterface.getFileManagerEngine().O().u(messageRecord2, messageRecord);
                }
                if (messageRecord instanceof MessageForReplyText) {
                    MessageForReplyText messageForReplyText = (MessageForReplyText) messageRecord2;
                    MessageForReplyText messageForReplyText2 = (MessageForReplyText) messageRecord;
                    if (messageForReplyText2.getSourceMessage() != null && FileManagerUtil.isMessageRecordOfFile(messageForReplyText2.getSourceMessage())) {
                        qQAppInterface.getFileManagerEngine().O().u(messageForReplyText.getSourceMessage(), messageForReplyText2.getSourceMessage());
                    }
                }
                if (messageRecord instanceof MessageForMixedMsg) {
                    MessageForReplyText replyMessage = ((MessageForMixedMsg) messageRecord).getReplyMessage(qQAppInterface);
                    MessageForReplyText replyMessage2 = ((MessageForMixedMsg) messageRecord2).getReplyMessage(qQAppInterface);
                    if (replyMessage != null && replyMessage2 != null && replyMessage.getSourceMessage() != null && FileManagerUtil.isMessageRecordOfFile(replyMessage.getSourceMessage())) {
                        qQAppInterface.getFileManagerEngine().O().u(replyMessage2.getSourceMessage(), replyMessage.getSourceMessage());
                    }
                }
                if (messageRecord.msgtype == -2022) {
                    ((MessageForShortVideo) messageRecord).redBagType = 0;
                }
                arrayList.add(messageRecord);
                if (QLog.isColorLevel()) {
                    QLog.d("ReplyMsgController", 2, "preAddMultiMsg, MessageRecord:" + messageRecord2.toString());
                }
            }
        }
        return arrayList;
    }
}
