package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForLocationShare extends ChatMessage {
    private static final String TAG = "MessageForLocationShare";

    @defaultValue(defaultInteger = 1)
    public boolean isSharingLocation = true;

    public MessageForLocationShare() {
        this.msgtype = MessageRecord.MSG_TYPE_AIO_FOR_LOCATION_SHARE;
    }

    public byte[] convertToMsgData() {
        prewrite();
        return this.msgData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0074: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:117), block:B:39:0x0074 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006f -> B:15:0x0072). Please report as a decompilation issue!!! */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        Exception e16;
        if (this.msgData == null) {
            return;
        }
        ObjectInputStream objectInputStream3 = null;
        try {
            try {
                try {
                    objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
                } catch (Exception e17) {
                    objectInputStream2 = null;
                    e16 = e17;
                } catch (Throwable th5) {
                    th = th5;
                    if (objectInputStream3 != null) {
                        try {
                            objectInputStream3.close();
                        } catch (Exception e18) {
                            QLog.e(TAG, 1, "doParse: failed. ", e18);
                        }
                    }
                    throw th;
                }
                try {
                    this.isSharingLocation = objectInputStream2.readBoolean();
                    this.f203106msg = objectInputStream2.readUTF();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "doParse: invoked. ", " msg: ", this.f203106msg, " isSharingLocation: ", Boolean.valueOf(this.isSharingLocation));
                    }
                    objectInputStream2.close();
                } catch (Exception e19) {
                    e16 = e19;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "doParse failure. ", e16);
                    }
                    if (objectInputStream2 != null) {
                        objectInputStream2.close();
                    }
                }
            } catch (Exception e26) {
                QLog.e(TAG, 1, "doParse: failed. ", e26);
            }
        } catch (Throwable th6) {
            th = th6;
            objectInputStream3 = objectInputStream;
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
        ObjectOutputStream objectOutputStream;
        Exception e16;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (Exception e17) {
                    objectOutputStream = null;
                    e16 = e17;
                } catch (Throwable th5) {
                    th = th5;
                    if (0 != 0) {
                        try {
                            objectOutputStream2.close();
                        } catch (Exception e18) {
                            QLog.e(TAG, 1, "prewrite: failed. ", e18);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (Exception e19) {
                        QLog.e(TAG, 1, "prewrite: failed. ", e19);
                        throw th;
                    }
                }
                try {
                    objectOutputStream.writeBoolean(this.isSharingLocation);
                    objectOutputStream.writeUTF(this.f203106msg);
                    objectOutputStream.close();
                    this.msgData = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                    } catch (Exception e26) {
                        QLog.e(TAG, 1, "prewrite: failed. ", e26);
                    }
                    byteArrayOutputStream.close();
                } catch (Exception e27) {
                    e16 = e27;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "prewrite failure. ", e16);
                    }
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception e28) {
                            QLog.e(TAG, 1, "prewrite: failed. ", e28);
                        }
                    }
                    byteArrayOutputStream.close();
                }
            } catch (Exception e29) {
                QLog.e(TAG, 1, "prewrite: failed. ", e29);
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public String toString() {
        return "MessageForLocationShare{isSharingLocation=" + this.isSharingLocation + ", msg='" + this.f203106msg + "', mr='" + super.toString() + "'}";
    }
}
