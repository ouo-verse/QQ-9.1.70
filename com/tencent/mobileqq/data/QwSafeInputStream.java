package com.tencent.mobileqq.data;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QwSafeInputStream {
    private ByteArrayInputStream mByteArrayInputStream;
    private boolean mHasException;
    private ObjectInputStream mObjectInputStream;

    public QwSafeInputStream(byte[] bArr) throws Exception {
        this.mByteArrayInputStream = new ByteArrayInputStream(bArr);
        this.mObjectInputStream = new ObjectInputStream(this.mByteArrayInputStream);
    }

    public void close() {
        try {
            this.mObjectInputStream.close();
        } catch (Exception unused) {
        }
        try {
            this.mByteArrayInputStream.close();
        } catch (Exception unused2) {
        }
    }

    public boolean readBoolean() {
        return readBoolean(false);
    }

    public int readInt() {
        return readInt(0);
    }

    public Object readObject(Object obj) {
        if (!this.mHasException) {
            try {
                return this.mObjectInputStream.readObject();
            } catch (Exception unused) {
                this.mHasException = true;
            }
        }
        return obj;
    }

    public String readUTF() {
        return readUTF("");
    }

    public boolean readBoolean(boolean z16) {
        if (!this.mHasException) {
            try {
                return this.mObjectInputStream.readBoolean();
            } catch (Exception unused) {
                this.mHasException = true;
            }
        }
        return z16;
    }

    public int readInt(int i3) {
        if (!this.mHasException) {
            try {
                return this.mObjectInputStream.readInt();
            } catch (Exception unused) {
                this.mHasException = true;
            }
        }
        return i3;
    }

    public String readUTF(String str) {
        if (!this.mHasException) {
            try {
                return this.mObjectInputStream.readUTF();
            } catch (Exception unused) {
                this.mHasException = true;
            }
        }
        return str;
    }
}
