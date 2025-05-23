package com.tencent.mobileqq.troop.data;

import PushNotifyPack.GroupMsgReadedNotify;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.y;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbGetGroupMsgResp;

/* compiled from: P */
/* loaded from: classes19.dex */
public class z implements y.a {
    static IPatchRedirector $redirector_;

    public z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static byte[] c(MessageRecord messageRecord, MessageRecord messageRecord2) {
        int i3;
        MessageForTroopFile messageForTroopFile = (MessageForTroopFile) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_TROOP_OBJ_MSG);
        MessageRecord.copyMessageRecordBaseField(messageForTroopFile, messageRecord);
        messageForTroopFile.doParse();
        MessageForTroopFile messageForTroopFile2 = (MessageForTroopFile) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_TROOP_OBJ_MSG);
        MessageRecord.copyMessageRecordBaseField(messageForTroopFile2, messageRecord2);
        messageForTroopFile2.doParse();
        messageForTroopFile.bisID = messageForTroopFile2.bisID;
        messageForTroopFile.dspFileName = messageForTroopFile2.dspFileName;
        messageForTroopFile.dspFileSize = messageForTroopFile2.dspFileSize;
        messageForTroopFile.fileSize = messageForTroopFile2.fileSize;
        messageForTroopFile.fileName = messageForTroopFile2.fileName;
        messageForTroopFile.md5 = messageForTroopFile2.md5;
        messageForTroopFile.url = messageForTroopFile2.url;
        int i16 = messageForTroopFile2.width;
        if (i16 != 0 && (i3 = messageForTroopFile2.height) != 0) {
            messageForTroopFile.width = i16;
            messageForTroopFile.height = i3;
        }
        int i17 = messageForTroopFile2.duration;
        if (i17 != 0) {
            messageForTroopFile.duration = i17;
        }
        messageForTroopFile.serial();
        return messageForTroopFile.msgData;
    }

    @Override // com.tencent.mobileqq.troop.data.y.a
    public void a(String str, msg_svc$PbGetGroupMsgResp msg_svc_pbgetgroupmsgresp, int i3, y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, msg_svc_pbgetgroupmsgresp, Integer.valueOf(i3), yVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMessageProcessor", 2, "doSomeAfterGetPullTroopMsg doSome:" + i3 + " troopUin:" + str);
        }
        if (yVar.d() instanceof QQAppInterface) {
            TroopUtils.W((QQAppInterface) yVar.d(), str);
        }
    }

    @Override // com.tencent.mobileqq.troop.data.y.a
    public void b(GroupMsgReadedNotify groupMsgReadedNotify, y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) groupMsgReadedNotify, (Object) yVar);
            return;
        }
        String valueOf = String.valueOf(groupMsgReadedNotify.lGroupCode);
        com.tencent.mobileqq.troop.utils.z zVar = (com.tencent.mobileqq.troop.utils.z) yVar.d().getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
        if (zVar.f(valueOf)) {
            zVar.a(valueOf);
            if (!zVar.e(valueOf)) {
                zVar.h(valueOf);
            }
        }
    }
}
