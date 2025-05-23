package com.tencent.mobileqq.data;

import com.tencent.mobileqq.dating.i;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForInteractAndFollow extends ChatMessage {
    public static final String TAG = "Q.msg_box.MessageForInteractAndFollow";
    public static final int TYPE_FOLLOW = 2;
    public static final int TYPE_INTERACT = 1;
    public static final int TYPE_MOMENT = 3;
    public QQText context;
    public int msgBoxUnreadCount;
    public String rawContext;
    public long timeStamp;
    public int type;
    public int unReadCount;

    private void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.unReadCount = objectInput.readInt();
        this.msgBoxUnreadCount = objectInput.readInt();
        this.type = objectInput.readInt();
        this.rawContext = objectInput.readUTF();
        long readLong = objectInput.readLong();
        this.timeStamp = readLong;
        this.time = readLong;
        this.context = i.d(this.rawContext, 14);
    }

    private void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.unReadCount);
        objectOutput.writeInt(this.msgBoxUnreadCount);
        objectOutput.writeInt(this.type);
        objectOutput.writeUTF(this.rawContext);
        objectOutput.writeLong(this.timeStamp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        ObjectInputStream objectInputStream;
        Throwable th5;
        Exception e16;
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
        } catch (Exception e17) {
            objectInputStream = null;
            e16 = e17;
        } catch (Throwable th6) {
            objectInputStream = null;
            th5 = th6;
            if (objectInputStream != null) {
            }
            throw th5;
        }
        try {
            try {
                readExternal(objectInputStream);
                try {
                    objectInputStream.close();
                } catch (Exception e18) {
                    QLog.e(TAG, 2, "ois.close() failed", e18, e18);
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e19) {
                        QLog.e(TAG, 2, "ois.close() failed", e19, e19);
                    }
                }
                throw th5;
            }
        } catch (Exception e26) {
            e16 = e26;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "convert byte array to MessageForInteractAndFollow failed", e16, e16);
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (Exception e27) {
                    QLog.e(TAG, 2, "ois.close() failed", e27, e27);
                }
            }
        }
    }

    public void getBytes() {
        prewrite();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prewrite() {
        ObjectOutputStream objectOutputStream;
        Throwable th5;
        Exception e16;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Exception e17) {
            objectOutputStream = null;
            e16 = e17;
        } catch (Throwable th6) {
            objectOutputStream = null;
            th5 = th6;
            if (objectOutputStream != null) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception e18) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "convert MessageForInteractAndFollow to byte array failed", e18, e18);
                }
            }
            throw th5;
        }
        try {
            try {
                writeExternal(objectOutputStream);
                objectOutputStream.close();
                this.msgData = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "convert MessageForInteractAndFollow to byte array failed", e19, e19);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e26) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "convert MessageForInteractAndFollow to byte array failed", e26, e26);
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Exception e27) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "convert MessageForInteractAndFollow to byte array failed", e27, e27);
                        }
                    }
                }
                byteArrayOutputStream.close();
                throw th5;
            }
        } catch (Exception e28) {
            e16 = e28;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "convert MessageForInteractAndFollow to byte array failed", e16, e16);
            }
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Exception e29) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "convert MessageForInteractAndFollow to byte array failed", e29, e29);
                    }
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception e36) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "convert MessageForInteractAndFollow to byte array failed", e36, e36);
                }
            }
        }
    }
}
