package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RandSalt {
    public byte[] encryptUin = new byte[0];
    public long salt;

    public byte[] getEncryptUin() {
        return this.encryptUin;
    }

    public long getSalt() {
        return this.salt;
    }

    public String toString() {
        return "RandSalt{encryptUin=" + this.encryptUin + ",salt=" + this.salt + ",}";
    }
}
