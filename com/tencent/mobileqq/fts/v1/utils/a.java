package com.tencent.mobileqq.fts.v1.utils;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.data.msg.FTSMessageDelete;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static FTSMessage a(MessageRecord messageRecord) {
        FTSMessage fTSMessage = new FTSMessage();
        fTSMessage.mType = 1;
        fTSMessage.mContent = messageRecord.getContentForSearch();
        fTSMessage.mOId = messageRecord.getId();
        fTSMessage.uin = Long.parseLong(messageRecord.frienduin);
        fTSMessage.istroop = messageRecord.istroop;
        fTSMessage.senderuin = messageRecord.senderuin;
        fTSMessage.msgtype = messageRecord.msgtype;
        return fTSMessage;
    }

    public static FTSMessageDelete b(FTSMessage fTSMessage) {
        if (fTSMessage == null) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.fts.utils", 2, "codecFTSMessage ftsMessage is null");
            }
            return null;
        }
        FTSMessageDelete fTSMessageDelete = new FTSMessageDelete();
        fTSMessageDelete.mOpt = fTSMessage.mOpt;
        fTSMessageDelete.mType = fTSMessage.mType;
        fTSMessageDelete.mContent = fTSMessage.mContent;
        fTSMessageDelete.mOId = fTSMessage.mOId;
        fTSMessageDelete.uin = fTSMessage.uin;
        fTSMessageDelete.istroop = fTSMessage.istroop;
        fTSMessageDelete.senderuin = fTSMessage.senderuin;
        fTSMessageDelete.msgtype = fTSMessage.msgtype;
        try {
            MsgExts msgExts = fTSMessage.msgExts;
            if (msgExts != null) {
                fTSMessageDelete.msgExts = (MsgExts) msgExts.clone();
            } else {
                fTSMessageDelete.msgExts = null;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.fts.utils", 2, "codecFTSMessage, ", e16);
            }
            fTSMessageDelete.msgExts = null;
        }
        return fTSMessageDelete;
    }

    public static FTSMessage c(MessageRecord messageRecord) {
        if (messageRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.fts.utils", 2, "encodeMessageRecord message is null");
            }
            return null;
        }
        FTSMessage a16 = a(messageRecord);
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.fts.utils", 2, "encodeMessageRecord message is null");
            }
            return null;
        }
        int i3 = messageRecord.msgtype;
        if (i3 == -2011 || i3 == -1051 || i3 == -1049 || i3 == -1035 || i3 == -1000) {
            TextMsgExts textMsgExts = new TextMsgExts();
            textMsgExts.time = messageRecord.time;
            textMsgExts.shmsgseq = messageRecord.shmsgseq;
            a16.msgExts = textMsgExts;
        }
        return a16;
    }
}
