package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AsiExtraField implements ZipExtraField, UnixStat, Cloneable {
    private static final ZipShort HEADER_ID = new ZipShort(30062);
    private static final int WORD = 4;
    private int mode = 0;
    private int uid = 0;
    private int gid = 0;
    private String link = "";
    private boolean dirFlag = false;
    private CRC32 crc = new CRC32();

    public Object clone() {
        try {
            AsiExtraField asiExtraField = (AsiExtraField) super.clone();
            asiExtraField.crc = new CRC32();
            return asiExtraField;
        } catch (CloneNotSupportedException e16) {
            throw new RuntimeException(e16);
        }
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return getLocalFileDataData();
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return getLocalFileDataLength();
    }

    public int getGroupId() {
        return this.gid;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public String getLinkedFile() {
        return this.link;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        int value = getLocalFileDataLength().getValue() - 4;
        byte[] bArr = new byte[value];
        System.arraycopy(ZipShort.getBytes(getMode()), 0, bArr, 0, 2);
        byte[] bytes = getLinkedFile().getBytes();
        System.arraycopy(ZipLong.getBytes(bytes.length), 0, bArr, 2, 4);
        System.arraycopy(ZipShort.getBytes(getUserId()), 0, bArr, 6, 2);
        System.arraycopy(ZipShort.getBytes(getGroupId()), 0, bArr, 8, 2);
        System.arraycopy(bytes, 0, bArr, 10, bytes.length);
        this.crc.reset();
        this.crc.update(bArr);
        byte[] bArr2 = new byte[value + 4];
        System.arraycopy(ZipLong.getBytes(this.crc.getValue()), 0, bArr2, 0, 4);
        System.arraycopy(bArr, 0, bArr2, 4, value);
        return bArr2;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(getLinkedFile().getBytes().length + 14);
    }

    public int getMode() {
        return this.mode;
    }

    public int getUserId() {
        return this.uid;
    }

    public boolean isDirectory() {
        if (this.dirFlag && !isLink()) {
            return true;
        }
        return false;
    }

    public boolean isLink() {
        if (getLinkedFile().length() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i3, int i16) throws ZipException {
        long value = ZipLong.getValue(bArr, i3);
        int i17 = i16 - 4;
        byte[] bArr2 = new byte[i17];
        boolean z16 = false;
        System.arraycopy(bArr, i3 + 4, bArr2, 0, i17);
        this.crc.reset();
        this.crc.update(bArr2);
        long value2 = this.crc.getValue();
        if (value == value2) {
            int value3 = ZipShort.getValue(bArr2, 0);
            int value4 = (int) ZipLong.getValue(bArr2, 2);
            byte[] bArr3 = new byte[value4];
            this.uid = ZipShort.getValue(bArr2, 6);
            this.gid = ZipShort.getValue(bArr2, 8);
            if (value4 == 0) {
                this.link = "";
            } else {
                System.arraycopy(bArr2, 10, bArr3, 0, value4);
                this.link = new String(bArr3);
            }
            if ((value3 & 16384) != 0) {
                z16 = true;
            }
            setDirectory(z16);
            setMode(value3);
            return;
        }
        throw new ZipException("bad CRC checksum " + Long.toHexString(value) + " instead of " + Long.toHexString(value2));
    }

    public void setDirectory(boolean z16) {
        this.dirFlag = z16;
        this.mode = getMode(this.mode);
    }

    public void setGroupId(int i3) {
        this.gid = i3;
    }

    public void setLinkedFile(String str) {
        this.link = str;
        this.mode = getMode(this.mode);
    }

    public void setMode(int i3) {
        this.mode = getMode(i3);
    }

    public void setUserId(int i3) {
        this.uid = i3;
    }

    protected int getMode(int i3) {
        int i16;
        if (isLink()) {
            i16 = 40960;
        } else {
            i16 = isDirectory() ? 16384 : 32768;
        }
        return (i3 & 4095) | i16;
    }
}
