package com.tencent.mobileqq.data;

import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.util.aw;
import java.io.UnsupportedEncodingException;
import mqq.app.MobileQQ;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "subUin,senderuin,time")
/* loaded from: classes10.dex */
public class SubAccountMessage extends Entity implements Comparable<SubAccountMessage> {
    public static final String SUB_EXTR_RED_PACKET = "RED_PACKET";
    public int extInt;
    public int extLong;
    public String extStr;
    public int extraflag;
    public String frienduin;
    public boolean isread;
    public int issend;
    public int istroop;
    public int longMsgCount;
    public int longMsgId;
    public int longMsgIndex;

    @notColumn
    public CharSequence mEmoRecentMsg;

    @notColumn
    public String mTimeString;

    /* renamed from: msg, reason: collision with root package name */
    @notColumn
    public String f203118msg;
    public byte[] msgData;
    public long msgUid;
    public long msgseq;
    public int msgtype;

    @notColumn
    public boolean needNotify;
    public String selfuin;
    public String sendername;
    public String senderuin;
    public long shmsgseq;
    public String subExtr;
    public String subUin;
    public long time;
    public long uniseq;
    public long vipBubbleID;
    public int unreadNum = 0;
    public boolean isValid = true;

    public static SubAccountMessage clone(SubAccountMessage subAccountMessage) {
        SubAccountMessage subAccountMessage2 = new SubAccountMessage();
        subAccountMessage2.subUin = subAccountMessage.subUin;
        subAccountMessage2.selfuin = subAccountMessage.selfuin;
        subAccountMessage2.frienduin = subAccountMessage.frienduin;
        subAccountMessage2.sendername = subAccountMessage.sendername;
        subAccountMessage2.senderuin = subAccountMessage.senderuin;
        subAccountMessage2.time = subAccountMessage.time;
        subAccountMessage2.msgtype = subAccountMessage.msgtype;
        subAccountMessage2.f203118msg = subAccountMessage.f203118msg;
        subAccountMessage2.isread = subAccountMessage.isread;
        subAccountMessage2.isValid = subAccountMessage.isValid;
        subAccountMessage2.msgData = subAccountMessage.msgData;
        subAccountMessage2.extInt = subAccountMessage.extInt;
        subAccountMessage2.extLong = subAccountMessage.extInt;
        subAccountMessage2.extraflag = subAccountMessage.extraflag;
        subAccountMessage2.extStr = subAccountMessage.extStr;
        subAccountMessage2.longMsgCount = subAccountMessage.longMsgCount;
        subAccountMessage2.longMsgId = subAccountMessage.longMsgId;
        subAccountMessage2.longMsgIndex = subAccountMessage.longMsgIndex;
        subAccountMessage2.msgseq = subAccountMessage.msgseq;
        subAccountMessage2.shmsgseq = subAccountMessage.shmsgseq;
        subAccountMessage2.uniseq = subAccountMessage.uniseq;
        subAccountMessage2.unreadNum = subAccountMessage.unreadNum;
        subAccountMessage2.vipBubbleID = subAccountMessage.vipBubbleID;
        subAccountMessage2.istroop = subAccountMessage.istroop;
        subAccountMessage2.subExtr = subAccountMessage.subExtr;
        return subAccountMessage2;
    }

    public MessageRecord convertToMessageRecord() {
        MessageRecord constructMessageForText = ((IMessageFacade) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "")).constructMessageForText(this.f203118msg, this.uniseq + "", this.frienduin, this.istroop);
        constructMessageForText.selfuin = this.selfuin;
        constructMessageForText.frienduin = this.frienduin;
        constructMessageForText.senderuin = this.senderuin;
        constructMessageForText.time = this.time;
        constructMessageForText.msgtype = this.msgtype;
        constructMessageForText.f203106msg = this.f203118msg;
        constructMessageForText.isread = this.isread;
        constructMessageForText.isValid = this.isValid;
        constructMessageForText.msgData = this.msgData;
        int i3 = this.extInt;
        constructMessageForText.extInt = i3;
        constructMessageForText.extLong = i3;
        constructMessageForText.extraflag = this.extraflag;
        constructMessageForText.extStr = this.extStr;
        constructMessageForText.longMsgCount = this.longMsgCount;
        constructMessageForText.longMsgId = this.longMsgId;
        constructMessageForText.longMsgIndex = this.longMsgIndex;
        constructMessageForText.msgseq = this.msgseq;
        constructMessageForText.shmsgseq = this.shmsgseq;
        constructMessageForText.uniseq = this.uniseq;
        constructMessageForText.vipBubbleID = this.vipBubbleID;
        constructMessageForText.istroop = this.istroop;
        return constructMessageForText;
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return super.getTableName();
    }

    public boolean hasUnreadMsg() {
        if (this.unreadNum > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        try {
            this.f203118msg = new String(this.msgData, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        String str = this.f203118msg;
        if (str != null) {
            try {
                this.msgData = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
    }

    public String toString() {
        return "SubAccountMessage,subUin:" + this.subUin + ",selfUin:" + this.selfuin + ",friendUin:" + this.frienduin + ",senderUin:" + this.senderuin + ",senderName:" + this.sendername + ",time:" + this.time + ",unreadNum:" + this.unreadNum + ",isRead:" + this.isread + ",msgType:" + this.msgtype + ",subExtr:" + this.subExtr + ",msg:" + aw.a(this.f203118msg);
    }

    @Override // java.lang.Comparable
    public int compareTo(SubAccountMessage subAccountMessage) {
        if (subAccountMessage == null) {
            return 0;
        }
        return (int) (subAccountMessage.time - this.time);
    }
}
