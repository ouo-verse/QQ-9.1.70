package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForSplitLineTips extends ChatMessage {
    public static final String TAG = "com.tencent.mobileqq.data.MessageForSplitLineTips";
    public static final int TYPE_TROOP_HISTORY_MESSAGE_TIPS = 1;
    public static final int TYPE_TROOP_SHARE_MESSAGE_TIPS = 2;
    public static int VERSION = 1;
    public String msgContent;
    public int subType = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        ObjectInputStream objectInputStream;
        Throwable th5;
        Exception e16;
        if (this.msgData == null) {
            return;
        }
        try {
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
                    objectInputStream.readInt();
                    this.subType = objectInputStream.readInt();
                    this.msgContent = objectInputStream.readUTF();
                    this.f203106msg = getSummaryMsg();
                    objectInputStream.close();
                } catch (Throwable th7) {
                    th5 = th7;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th5;
                }
            } catch (Exception e19) {
                e16 = e19;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "doParse failure." + e16, e16);
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            }
        } catch (Exception e26) {
            e26.printStackTrace();
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

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prewrite() {
        Throwable th5;
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
                } catch (Throwable th6) {
                    th5 = th6;
                    if (0 != 0) {
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
                    objectOutputStream.writeInt(VERSION);
                    objectOutputStream.writeInt(this.subType);
                    String str = this.msgContent;
                    if (str == null) {
                        str = "";
                    }
                    objectOutputStream.writeUTF(str);
                    objectOutputStream.close();
                    this.msgData = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                    byteArrayOutputStream.close();
                } catch (Exception e26) {
                    e16 = e26;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getBytes failure" + e16, e16);
                    }
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception e27) {
                            e27.printStackTrace();
                        }
                    }
                    byteArrayOutputStream.close();
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (0 != 0) {
                    try {
                        objectOutputStream2.close();
                    } catch (Exception e28) {
                        e28.printStackTrace();
                    }
                }
                byteArrayOutputStream.close();
                throw th5;
            }
        } catch (Exception e29) {
            e29.printStackTrace();
        }
    }
}
