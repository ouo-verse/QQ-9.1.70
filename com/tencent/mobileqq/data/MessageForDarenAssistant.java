package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.LogTag;
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
public class MessageForDarenAssistant extends ChatMessage {
    public static final String TAG = "Q.msg_box.MessageForDarenAssistant";
    public String jumpUrl;

    private void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.f203106msg = objectInput.readUTF();
        this.jumpUrl = objectInput.readUTF();
    }

    private void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.f203106msg);
        objectOutput.writeUTF(this.jumpUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        Throwable th5;
        ObjectInputStream objectInputStream;
        Exception e16;
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
                } catch (Exception e17) {
                    objectInputStream = null;
                    e16 = e17;
                } catch (Throwable th6) {
                    th5 = th6;
                    if (0 != 0) {
                    }
                    throw th5;
                }
                try {
                    readExternal(objectInputStream);
                    objectInputStream.close();
                } catch (Exception e18) {
                    e16 = e18;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "convert byte array to MessageForDarenAssistant failed", e16);
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (0 != 0) {
                    try {
                        objectInputStream2.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                }
                throw th5;
            }
        } catch (Exception e26) {
            e26.printStackTrace();
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

    /* JADX WARN: Removed duplicated region for block: B:48:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                    QLog.d(LogTag.TAG_NEARBY_LIVE_TIP, 2, "convert MessageForDarenAssistant to byte array failed", e18);
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
                        QLog.d(LogTag.TAG_NEARBY_LIVE_TIP, 2, "convert MessageForDarenAssistant to byte array failed", e19);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e26) {
                    e = e26;
                    if (!QLog.isColorLevel()) {
                        return;
                    }
                    QLog.d(LogTag.TAG_NEARBY_LIVE_TIP, 2, "convert MessageForDarenAssistant to byte array failed", e);
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Exception e27) {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.TAG_NEARBY_LIVE_TIP, 2, "convert MessageForDarenAssistant to byte array failed", e27);
                        }
                    }
                }
                byteArrayOutputStream.close();
                throw th5;
            }
        } catch (Exception e28) {
            e16 = e28;
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_NEARBY_LIVE_TIP, 2, "convert MessageForDarenAssistant to byte array failed", e16);
            }
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Exception e29) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_NEARBY_LIVE_TIP, 2, "convert MessageForDarenAssistant to byte array failed", e29);
                    }
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception e36) {
                e = e36;
                if (!QLog.isColorLevel()) {
                    return;
                }
                QLog.d(LogTag.TAG_NEARBY_LIVE_TIP, 2, "convert MessageForDarenAssistant to byte array failed", e);
            }
        }
    }
}
