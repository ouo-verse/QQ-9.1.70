package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class AbstractUnicodeExtraField implements ZipExtraField {
    private byte[] data;
    private long nameCRC32;
    private byte[] unicodeName;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractUnicodeExtraField() {
    }

    private void assembleData() {
        byte[] bArr = this.unicodeName;
        if (bArr == null) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length + 5];
        this.data = bArr2;
        bArr2[0] = 1;
        System.arraycopy(ZipLong.getBytes(this.nameCRC32), 0, this.data, 1, 4);
        byte[] bArr3 = this.unicodeName;
        System.arraycopy(bArr3, 0, this.data, 5, bArr3.length);
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        if (this.data == null) {
            assembleData();
        }
        byte[] bArr = this.data;
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return bArr2;
        }
        return null;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        if (this.data == null) {
            assembleData();
        }
        return new ZipShort(this.data.length);
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return getCentralDirectoryData();
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return getCentralDirectoryLength();
    }

    public long getNameCRC32() {
        return this.nameCRC32;
    }

    public byte[] getUnicodeName() {
        byte[] bArr = this.unicodeName;
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return bArr2;
        }
        return null;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i3, int i16) throws ZipException {
        if (i16 >= 5) {
            byte b16 = bArr[i3];
            if (b16 == 1) {
                this.nameCRC32 = ZipLong.getValue(bArr, i3 + 1);
                int i17 = i16 - 5;
                byte[] bArr2 = new byte[i17];
                this.unicodeName = bArr2;
                System.arraycopy(bArr, i3 + 5, bArr2, 0, i17);
                this.data = null;
                return;
            }
            throw new ZipException("Unsupported version [" + ((int) b16) + "] for UniCode path extra data.");
        }
        throw new ZipException("UniCode path extra data must have at least 5 bytes.");
    }

    public void setNameCRC32(long j3) {
        this.nameCRC32 = j3;
        this.data = null;
    }

    public void setUnicodeName(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.unicodeName = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            this.unicodeName = null;
        }
        this.data = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractUnicodeExtraField(String str, byte[] bArr, int i3, int i16) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i3, i16);
        this.nameCRC32 = crc32.getValue();
        try {
            this.unicodeName = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException("FATAL: UTF-8 encoding not supported.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractUnicodeExtraField(String str, byte[] bArr) {
        this(str, bArr, 0, bArr.length);
    }
}
