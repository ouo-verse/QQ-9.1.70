package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.activity.aio.helper.ab;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.i;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForStructing extends MessageForRichText implements IMultiMsgRecordOp {

    @notColumn
    public boolean bDynicMsg = false;
    public AbsStructMsg structingMsg;

    public MessageForStructing() {
    }

    public static String getReplySummary(ChatMessage chatMessage) {
        StringBuilder sb5 = new StringBuilder(32);
        if (chatMessage instanceof MessageForStructing) {
            MessageForStructing messageForStructing = (MessageForStructing) chatMessage;
            AbsStructMsg absStructMsg = messageForStructing.structingMsg;
            if (absStructMsg instanceof StructMsgForGeneralShare) {
                int i3 = absStructMsg.mMsgServiceID;
                if (i3 == 95) {
                    sb5.append("[\u5728\u7ebf\u6587\u6863]");
                    sb5.append(((StructMsgForGeneralShare) messageForStructing.structingMsg).mContentTitle);
                } else if (i3 == 33) {
                    sb5.append("[\u94fe\u63a5]");
                    sb5.append(((StructMsgForGeneralShare) messageForStructing.structingMsg).mContentTitle);
                } else if (ab.b() && messageForStructing.structingMsg.mMsgServiceID == 35) {
                    ab.a(sb5, messageForStructing, true);
                }
            }
        }
        if (sb5.length() == 0) {
            sb5.append(chatMessage.getSummaryMsg());
        }
        return sb5.toString();
    }

    public void copyStructingMsg(MessageRecord messageRecord) {
        this.extInt = messageRecord.extInt;
        this.extLong = messageRecord.extLong;
        this.extraflag = messageRecord.extraflag;
        this.extStr = messageRecord.extStr;
        this.frienduin = messageRecord.frienduin;
        this.isread = messageRecord.isread;
        this.issend = messageRecord.issend;
        this.istroop = messageRecord.istroop;
        this.isValid = messageRecord.isValid;
        this.longMsgCount = messageRecord.longMsgCount;
        this.longMsgId = messageRecord.longMsgId;
        this.longMsgIndex = messageRecord.longMsgIndex;
        this.f203106msg = messageRecord.f203106msg;
        byte[] bArr = messageRecord.msgData;
        this.msgData = bArr;
        this.msgseq = messageRecord.msgseq;
        this.msgtype = messageRecord.msgtype;
        this.msgUid = messageRecord.msgUid;
        this.selfuin = messageRecord.selfuin;
        this.senderuin = messageRecord.senderuin;
        this.sendFailCode = messageRecord.sendFailCode;
        this.shmsgseq = messageRecord.shmsgseq;
        this.time = messageRecord.time;
        this.versionCode = messageRecord.versionCode;
        this.vipBubbleID = messageRecord.vipBubbleID;
        this.structingMsg = i.d(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        if (!this.bDynicMsg) {
            this.structingMsg = i.d(this.msgData);
        }
    }

    public void doPrewrite() {
        prewrite();
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public String getContentForSearch() {
        AbsStructMsg absStructMsg = this.structingMsg;
        if (absStructMsg != null) {
            boolean c16 = com.tencent.mobileqq.app.fms.c.c(String.valueOf(absStructMsg.mMsgServiceID));
            AbsStructMsg absStructMsg2 = this.structingMsg;
            if ((absStructMsg2 instanceof AbsShareMsg) && c16) {
                String str = ((AbsShareMsg) absStructMsg2).mContentTitle;
                if (TextUtils.isEmpty(str)) {
                    AbsStructMsg absStructMsg3 = this.structingMsg;
                    if (absStructMsg3 instanceof AbsStructMsg) {
                        return ((AbsShareMsg) absStructMsg3).mMsgBrief;
                    }
                    return str;
                }
                return str;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.data.IMultiMsgRecordOp
    public String getFilename() {
        AbsStructMsg absStructMsg = this.structingMsg;
        if (absStructMsg != null) {
            return absStructMsg.mFileName;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        String str;
        AbsStructMsg absStructMsg = this.structingMsg;
        if (absStructMsg == null || (str = absStructMsg.mMsgBrief) == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.data.IMultiMsgRecordOp
    public int getTSum() {
        AbsStructMsg absStructMsg = this.structingMsg;
        if (absStructMsg != null && "viewMultiMsg".equals(absStructMsg.mMsgAction)) {
            return this.structingMsg.mTSum;
        }
        return 0;
    }

    public boolean isHotPicsStruct() {
        if (!StructMsgForImageShare.class.isInstance(this.structingMsg) || ((StructMsgForImageShare) this.structingMsg).mImageBizType != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public boolean isSupportFTS() {
        return ad.s(this.istroop);
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        AbsStructMsg absStructMsg = this.structingMsg;
        if (absStructMsg != null) {
            try {
                if (!this.bDynicMsg) {
                    this.msgData = absStructMsg.getBytes();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.data.IMultiMsgRecordOp
    public void updateFilename(String str) {
        if (this.structingMsg != null && !TextUtils.isEmpty(str)) {
            this.structingMsg.mFileName = str;
        }
    }

    public MessageForStructing(MessageRecord messageRecord) {
        copyStructingMsg(messageRecord);
        this.uniseq = messageRecord.uniseq;
    }
}
