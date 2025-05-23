package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForLimitChatConfirm extends ChatMessage {
    public static final String TAG = "com.tencent.mobileqq.data.MessageForLimitChatConfirm";
    public boolean bEnterMsg = true;
    public int leaveChatType = -1;
    public long timeStamp = 0;
    public int leftChatTime = -1;
    public int matchExpiredTime = 0;
    public int c2cExpiredTime = 0;
    public String SenderNickName = "";
    public String tipsWording = "";
    public long readyTs = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        Throwable th5;
        ObjectInputStream objectInputStream;
        Exception e16;
        if (this.msgData == null) {
            return;
        }
        ObjectInputStream objectInputStream2 = null;
        try {
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        try {
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
            } catch (Exception e18) {
                objectInputStream = null;
                e16 = e18;
            } catch (Throwable th6) {
                th5 = th6;
                if (0 != 0) {
                }
                throw th5;
            }
            try {
                try {
                    this.bEnterMsg = objectInputStream.readBoolean();
                    this.leaveChatType = objectInputStream.readInt();
                    this.leftChatTime = objectInputStream.readInt();
                    this.timeStamp = objectInputStream.readLong();
                    this.matchExpiredTime = objectInputStream.readInt();
                    this.c2cExpiredTime = objectInputStream.readInt();
                    this.SenderNickName = objectInputStream.readUTF();
                    this.tipsWording = objectInputStream.readUTF();
                    this.readyTs = objectInputStream.readLong();
                    objectInputStream.close();
                } catch (Exception e19) {
                    e16 = e19;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "doParse failure." + e16, e16);
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    new ObjectInputStream(new ByteArrayInputStream(this.msgData));
                }
                new ObjectInputStream(new ByteArrayInputStream(this.msgData));
            } catch (IOException e26) {
                e26.printStackTrace();
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (0 != 0) {
                try {
                    objectInputStream2.close();
                } catch (Exception e27) {
                    e27.printStackTrace();
                }
            }
            throw th5;
        }
    }

    public byte[] getBytes() {
        prewrite();
        return this.msgData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                    throw th5;
                } catch (Exception e18) {
                    e18.printStackTrace();
                    throw th5;
                }
            }
            try {
                try {
                    objectOutputStream.writeBoolean(this.bEnterMsg);
                    objectOutputStream.writeInt(this.leaveChatType);
                    objectOutputStream.writeInt(this.leftChatTime);
                    objectOutputStream.writeLong(this.timeStamp);
                    objectOutputStream.writeInt(this.matchExpiredTime);
                    objectOutputStream.writeInt(this.c2cExpiredTime);
                    objectOutputStream.writeUTF(this.SenderNickName);
                    objectOutputStream.writeUTF(this.tipsWording);
                    objectOutputStream.writeLong(this.readyTs);
                    objectOutputStream.close();
                    this.msgData = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                    byteArrayOutputStream.close();
                } catch (Throwable th7) {
                    th5 = th7;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception e26) {
                            e26.printStackTrace();
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th5;
                }
            } catch (Exception e27) {
                e16 = e27;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getBytes failure" + e16, e16);
                }
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Exception e28) {
                        e28.printStackTrace();
                    }
                }
                byteArrayOutputStream.close();
            }
        } catch (Exception e29) {
            e29.printStackTrace();
        }
    }
}
