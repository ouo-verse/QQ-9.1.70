package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForShakeWindow extends ChatMessage {
    public ShakeWindowMsg mShakeWindowMsg;

    public MessageForShakeWindow() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            this.mShakeWindowMsg = new ShakeWindowMsg();
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
            this.mShakeWindowMsg.readExternal(objectInputStream);
            objectInputStream.close();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.SHAKE_MSG, 2, "convert byte array to ShakeWindowMsg failed", e16);
            }
            this.mShakeWindowMsg = null;
        }
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
        ShakeWindowMsg shakeWindowMsg = this.mShakeWindowMsg;
        if (shakeWindowMsg != null) {
            try {
                this.msgData = shakeWindowMsg.getBytes();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.SHAKE_MSG, 2, "convert ShakeWindowMsg to byte array failed", e16);
                }
            }
        }
    }

    public MessageForShakeWindow(long j3, long j16, long j17, long j18, int i3, long j19) {
        init(j3, j16, j17, "[Shake Window]", j18, MessageRecord.MSG_TYPE_SHAKE_WINDOW, i3, j19);
    }
}
