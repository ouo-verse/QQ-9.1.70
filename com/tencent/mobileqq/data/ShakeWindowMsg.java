package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ShakeWindowMsg implements Externalizable {
    public static final int OFFLINE_SHAKE = 2;
    public static final int ONLINE_SHAKE = 1;
    private static int VERSION = 1;
    public int mReserve;
    public int mType;
    public int onlineFlag;
    public boolean shake;

    public ShakeWindowMsg() {
        this.shake = true;
        this.onlineFlag = 1;
    }

    public byte[] getBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            writeExternal(objectOutputStream);
            objectOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.SHAKE_MSG, 2, e16.getMessage(), e16);
                return null;
            }
            return null;
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        if (objectInput.readInt() == 1) {
            this.shake = objectInput.readBoolean();
            this.onlineFlag = objectInput.readInt();
            this.mType = objectInput.readInt();
            this.mReserve = objectInput.readInt();
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(VERSION);
        objectOutput.writeBoolean(this.shake);
        objectOutput.writeInt(this.onlineFlag);
        objectOutput.writeInt(this.mType);
        objectOutput.writeInt(this.mReserve);
    }

    public ShakeWindowMsg(ShakeWindowMsg shakeWindowMsg) {
        this.shake = true;
        this.onlineFlag = 1;
        this.shake = shakeWindowMsg.shake;
        this.mType = shakeWindowMsg.mType;
        this.mReserve = shakeWindowMsg.mReserve;
        this.onlineFlag = shakeWindowMsg.onlineFlag;
    }
}
