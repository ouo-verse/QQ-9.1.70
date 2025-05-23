package com.tencent.mobileqq.data;

import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.FAIL, columnNames = "uin,type")
/* loaded from: classes10.dex */
public class QCallRecent extends Entity {
    public static final int DISCUSS_STATE_CALL = 4;
    public static final int DISCUSS_STATE_CALLED = 3;
    public static final int DISCUSS_STATE_DOING = 1;
    public static final int DISCUSS_STATE_IGNORE = 8;
    public static final int DISCUSS_STATE_MISS = 2;
    public static final int DOUBLE_STATE_CHATING = 6;
    public static final int DOUBLE_STATE_INVITING = 5;
    public static final int DOUBLE_STATE_OHTER_TERMINAL_CAHTING = 7;
    public static final String TABLE_NAME = "recent_call";
    public String bindId;
    public String businessLogo;
    public String businessName;
    public String businessSeId;
    public String displayName;
    public String lastCallMsg;
    public long lastCallTime;
    public byte[] lightalkSig;
    public int sendFlag;
    public String senderUin;
    public long time;
    public String troopUin;
    public String uin;
    public int type = 0;
    public int missedCallCount = 0;
    public boolean isLastCallRealMissed = false;
    public int isVideo = 0;
    public long memberCount = 0;
    public int state = 0;
    public int extraType = 0;
    public int bindType = 0;
    public long readTime = 0;
    public int contactId = -1;
    public int isSystemCall = 0;
    public String phoneNumber = null;
    public String pstnInfo = null;
    public int callType = 0;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof QCallRecent)) {
            return false;
        }
        QCallRecent qCallRecent = (QCallRecent) obj;
        String str = this.uin;
        if (str == null) {
            if (qCallRecent.uin != null || this.type != qCallRecent.type) {
                return false;
            }
            return true;
        }
        if ((!str.equals(qCallRecent.uin) || this.type != qCallRecent.type) && (!this.uin.equals(qCallRecent.uin) || !ao.r(this.type) || !ao.r(qCallRecent.type))) {
            return false;
        }
        return true;
    }

    public int getState(QQAppInterface qQAppInterface) {
        return this.state;
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return TABLE_NAME;
    }

    public boolean isMissedCall() {
        if (this.missedCallCount > 0) {
            return true;
        }
        return false;
    }

    public boolean isSend() {
        return com.tencent.mobileqq.service.message.remote.a.b(this.sendFlag);
    }

    public boolean isVideo() {
        if (this.isVideo == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("RecentCall(");
        stringBuffer.append("uin:");
        stringBuffer.append(this.uin);
        stringBuffer.append(",type:");
        stringBuffer.append(this.type);
        stringBuffer.append(",troopUin");
        stringBuffer.append(this.troopUin);
        stringBuffer.append(",sendFlag:");
        stringBuffer.append(this.sendFlag);
        stringBuffer.append(",missedCallCount:");
        stringBuffer.append(this.missedCallCount);
        stringBuffer.append(",isVideo:");
        stringBuffer.append(this.isVideo);
        stringBuffer.append(",displayName:");
        stringBuffer.append(this.displayName);
        stringBuffer.append(",lastCallTime:");
        stringBuffer.append(this.lastCallTime);
        stringBuffer.append(",lastCallMsg:");
        stringBuffer.append(this.lastCallMsg);
        stringBuffer.append(",readTime:");
        stringBuffer.append(this.readTime);
        stringBuffer.append(",extraType:");
        stringBuffer.append(this.extraType);
        stringBuffer.append(",bindType:");
        stringBuffer.append(this.bindType);
        stringBuffer.append(",bindId:");
        stringBuffer.append(this.bindId);
        stringBuffer.append(",callType:");
        stringBuffer.append(this.callType);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}
