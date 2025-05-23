package com.tencent.hippy.qq.update.qarchive.tools.zip;

/* loaded from: classes7.dex */
public final class GeneralPurposeBit {
    private static final int DATA_DESCRIPTOR_FLAG = 8;
    private static final int ENCRYPTION_FLAG = 1;
    private static final int STRONG_ENCRYPTION_FLAG = 64;
    public static final int UFT8_NAMES_FLAG = 2048;
    private boolean languageEncodingFlag = false;
    private boolean dataDescriptorFlag = false;
    private boolean encryptionFlag = false;
    private boolean strongEncryptionFlag = false;

    public static GeneralPurposeBit parse(byte[] bArr, int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        int value = ZipShort.getValue(bArr, i3);
        GeneralPurposeBit generalPurposeBit = new GeneralPurposeBit();
        boolean z19 = false;
        if ((value & 8) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        generalPurposeBit.useDataDescriptor(z16);
        if ((value & 2048) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        generalPurposeBit.useUTF8ForNames(z17);
        if ((value & 64) != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        generalPurposeBit.useStrongEncryption(z18);
        if ((value & 1) != 0) {
            z19 = true;
        }
        generalPurposeBit.useEncryption(z19);
        return generalPurposeBit;
    }

    public byte[] encode() {
        int i3;
        int i16;
        int i17 = 0;
        if (this.dataDescriptorFlag) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        if (this.languageEncodingFlag) {
            i16 = 2048;
        } else {
            i16 = 0;
        }
        int i18 = i3 | i16 | (this.encryptionFlag ? 1 : 0);
        if (this.strongEncryptionFlag) {
            i17 = 64;
        }
        return ZipShort.getBytes(i18 | i17);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeneralPurposeBit)) {
            return false;
        }
        GeneralPurposeBit generalPurposeBit = (GeneralPurposeBit) obj;
        if (generalPurposeBit.encryptionFlag != this.encryptionFlag || generalPurposeBit.strongEncryptionFlag != this.strongEncryptionFlag || generalPurposeBit.languageEncodingFlag != this.languageEncodingFlag || generalPurposeBit.dataDescriptorFlag != this.dataDescriptorFlag) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((this.encryptionFlag ? 1 : 0) * 17) + (this.strongEncryptionFlag ? 1 : 0)) * 13) + (this.languageEncodingFlag ? 1 : 0)) * 7) + (this.dataDescriptorFlag ? 1 : 0)) * 3;
    }

    public void useDataDescriptor(boolean z16) {
        this.dataDescriptorFlag = z16;
    }

    public void useEncryption(boolean z16) {
        this.encryptionFlag = z16;
    }

    public void useStrongEncryption(boolean z16) {
        this.strongEncryptionFlag = z16;
        if (z16) {
            useEncryption(true);
        }
    }

    public void useUTF8ForNames(boolean z16) {
        this.languageEncodingFlag = z16;
    }

    public boolean usesDataDescriptor() {
        return this.dataDescriptorFlag;
    }

    public boolean usesEncryption() {
        return this.encryptionFlag;
    }

    public boolean usesStrongEncryption() {
        if (this.encryptionFlag && this.strongEncryptionFlag) {
            return true;
        }
        return false;
    }

    public boolean usesUTF8ForNames() {
        return this.languageEncodingFlag;
    }
}
