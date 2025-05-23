package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "subuin,trunkuin")
/* loaded from: classes10.dex */
public class SubAccountInfo extends Entity {
    public static final int INIT = 0;
    public static final int LOSS_OF_LOCAL_IDENTITY = 2;
    public static final int NORMAL = 1;
    public static final int SERVER_ERROR = 3;

    @notColumn
    public String A2;
    public byte[] cookie;
    public boolean hintIsNew;
    public boolean isTop;
    public byte isbind;

    @notColumn
    public CharSequence lastMsg;

    @notColumn
    public String lastUin;

    @notColumn
    public String lastUinNick;
    public long lasttime;
    public int status;

    @Deprecated
    public String subname;
    public String subuin;
    public String trunkuin;

    @notColumn
    public int unreadMsgNum;

    @notColumn
    public int unreadTroopMsgNum;

    @notColumn
    public int unreadSenderNum = 0;

    @notColumn
    public int unNotifySender = 0;
    public int serverErrorType = 0;
    public String serverErrorMsg = null;
    public long lastCleanQZoneMessageTime = 0;

    public void cloneTo(SubAccountInfo subAccountInfo) {
        String str;
        String str2;
        if (subAccountInfo != null && (str = subAccountInfo.subuin) != null && (str2 = subAccountInfo.trunkuin) != null) {
            this.subuin = str;
            this.subname = subAccountInfo.subname;
            this.trunkuin = str2;
            this.isbind = subAccountInfo.isbind;
            this.lasttime = subAccountInfo.lasttime;
            this.lastUin = subAccountInfo.lastUin;
            this.lastUinNick = subAccountInfo.lastUinNick;
            this.lastMsg = subAccountInfo.lastMsg;
            this.A2 = subAccountInfo.A2;
            this.unreadMsgNum = subAccountInfo.unreadMsgNum;
            this.unreadSenderNum = subAccountInfo.unreadSenderNum;
            this.unreadTroopMsgNum = subAccountInfo.unreadTroopMsgNum;
            this.unNotifySender = subAccountInfo.unNotifySender;
            this.isTop = subAccountInfo.isTop;
            this.cookie = subAccountInfo.cookie;
            this.serverErrorType = subAccountInfo.serverErrorType;
            this.serverErrorMsg = subAccountInfo.serverErrorMsg;
            this.lastCleanQZoneMessageTime = subAccountInfo.lastCleanQZoneMessageTime;
        }
    }

    public String toString() {
        return "SubAccountINfo,subuin:" + this.subuin + ",subname:" + this.subname + ",trunk:" + this.trunkuin + ",isbind:" + ((int) this.isbind) + ",unreadMsgNum:" + this.unreadMsgNum + ",unreadSenderNum:" + this.unreadSenderNum + ",unreadTroopMsgNum:" + this.unreadTroopMsgNum + ",unNotificationSender:" + this.unNotifySender + ",lasttime:" + this.lasttime + ",serverErrorType:" + this.serverErrorType + ",serverErrorMsg:" + this.serverErrorMsg + ",lastCleanQZoneMessageTime:" + this.lastCleanQZoneMessageTime;
    }
}
