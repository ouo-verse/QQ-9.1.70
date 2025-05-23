package com.tencent.mobileqq.data;

import com.tencent.mobileqq.confess.data.TroopConfessMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForTroopConfess extends ChatMessage {
    public boolean isToSelf;
    public TroopConfessMsg mTroopConfessMsg;

    public MessageForTroopConfess() {
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            this.mTroopConfessMsg = new TroopConfessMsg();
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
            this.mTroopConfessMsg.readExternal(objectInputStream);
            objectInputStream.close();
            this.f203106msg = this.mTroopConfessMsg.getSimpleMsg();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.TroopConfess", 2, "convert byte array to TroopConfessMsg failed", e16);
            }
            this.mTroopConfessMsg = null;
        }
    }

    public long getConfessToUin() {
        TroopConfessMsg troopConfessMsg = this.mTroopConfessMsg;
        if (troopConfessMsg != null) {
            return troopConfessMsg.getConfessToUin();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public int getConfessTopicId() {
        TroopConfessMsg troopConfessMsg = this.mTroopConfessMsg;
        if (troopConfessMsg != null) {
            return troopConfessMsg.getConfessTopicId();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public boolean needVipBubble() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        TroopConfessMsg troopConfessMsg = this.mTroopConfessMsg;
        if (troopConfessMsg != null) {
            try {
                this.msgData = troopConfessMsg.getBytes();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.TroopConfess", 2, "convert TroopConfessItem to byte array failed", e16);
                }
            }
        }
    }

    public MessageForTroopConfess(long j3, long j16, long j17, long j18, int i3, long j19) {
        init(j3, j16, j17, "[TroopConfess]", j18, MessageRecord.MSG_TYPE_TROOP_CONFESS, i3, j19);
    }
}
