package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QwSafeOutputStream {
    private ByteArrayOutputStream mByteArrayOutputStream = new ByteArrayOutputStream();
    private ObjectOutputStream mObjectOutputStream = new ObjectOutputStream(this.mByteArrayOutputStream);

    public byte[] flushDataAndCloseStream() {
        byte[] bArr;
        try {
            this.mObjectOutputStream.close();
        } catch (Exception unused) {
        }
        try {
            bArr = this.mByteArrayOutputStream.toByteArray();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.QQWALLET_MSG, 2, "flushDataAndCloseStream toByteArray Exception", e16);
            }
            bArr = null;
        }
        try {
            this.mByteArrayOutputStream.close();
        } catch (Exception unused2) {
        }
        return bArr;
    }

    public void writeBoolean(boolean z16) throws Exception {
        this.mObjectOutputStream.writeBoolean(z16);
    }

    public void writeInt(int i3) throws Exception {
        this.mObjectOutputStream.writeInt(i3);
    }

    public void writeObject(Object obj) throws Exception {
        this.mObjectOutputStream.writeObject(obj);
    }

    public void writeUTF(String str) throws Exception {
        writeUTF(str, "");
    }

    public void writeUTF(String str, String str2) throws Exception {
        if (str == null) {
            this.mObjectOutputStream.writeUTF(str2);
        } else {
            this.mObjectOutputStream.writeUTF(str);
        }
    }
}
