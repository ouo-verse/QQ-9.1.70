package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Zip64ExtendedInformationExtraField implements CentralDirectoryParsingZipExtraField {
    private static final String LFH_MUST_HAVE_BOTH_SIZES_MSG = "Zip64 extended information must contain both size values in the local file header.";
    private ZipEightByteInteger compressedSize;
    private ZipLong diskStart;
    private byte[] rawCentralDirectoryData;
    private ZipEightByteInteger relativeHeaderOffset;
    private ZipEightByteInteger size;
    static final ZipShort HEADER_ID = new ZipShort(1);
    private static final byte[] EMPTY = new byte[0];

    public Zip64ExtendedInformationExtraField() {
    }

    private int addSizes(byte[] bArr) {
        int i3;
        ZipEightByteInteger zipEightByteInteger = this.size;
        if (zipEightByteInteger != null) {
            System.arraycopy(zipEightByteInteger.getBytes(), 0, bArr, 0, 8);
            i3 = 8;
        } else {
            i3 = 0;
        }
        ZipEightByteInteger zipEightByteInteger2 = this.compressedSize;
        if (zipEightByteInteger2 != null) {
            System.arraycopy(zipEightByteInteger2.getBytes(), 0, bArr, i3, 8);
            return i3 + 8;
        }
        return i3;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] bArr = new byte[getCentralDirectoryLength().getValue()];
        int addSizes = addSizes(bArr);
        ZipEightByteInteger zipEightByteInteger = this.relativeHeaderOffset;
        if (zipEightByteInteger != null) {
            System.arraycopy(zipEightByteInteger.getBytes(), 0, bArr, addSizes, 8);
            addSizes += 8;
        }
        ZipLong zipLong = this.diskStart;
        if (zipLong != null) {
            System.arraycopy(zipLong.getBytes(), 0, bArr, addSizes, 4);
        }
        return bArr;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        int i3;
        int i16;
        int i17 = 8;
        int i18 = 0;
        if (this.size != null) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        if (this.compressedSize != null) {
            i16 = 8;
        } else {
            i16 = 0;
        }
        int i19 = i3 + i16;
        if (this.relativeHeaderOffset == null) {
            i17 = 0;
        }
        int i26 = i19 + i17;
        if (this.diskStart != null) {
            i18 = 4;
        }
        return new ZipShort(i26 + i18);
    }

    public ZipEightByteInteger getCompressedSize() {
        return this.compressedSize;
    }

    public ZipLong getDiskStartNumber() {
        return this.diskStart;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        ZipEightByteInteger zipEightByteInteger = this.size;
        if (zipEightByteInteger == null && this.compressedSize == null) {
            return EMPTY;
        }
        if (zipEightByteInteger != null && this.compressedSize != null) {
            byte[] bArr = new byte[16];
            addSizes(bArr);
            return bArr;
        }
        throw new IllegalArgumentException(LFH_MUST_HAVE_BOTH_SIZES_MSG);
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        int i3;
        if (this.size != null) {
            i3 = 16;
        } else {
            i3 = 0;
        }
        return new ZipShort(i3);
    }

    public ZipEightByteInteger getRelativeHeaderOffset() {
        return this.relativeHeaderOffset;
    }

    public ZipEightByteInteger getSize() {
        return this.size;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.CentralDirectoryParsingZipExtraField
    public void parseFromCentralDirectoryData(byte[] bArr, int i3, int i16) throws ZipException {
        byte[] bArr2 = new byte[i16];
        this.rawCentralDirectoryData = bArr2;
        System.arraycopy(bArr, i3, bArr2, 0, i16);
        if (i16 >= 28) {
            parseFromLocalFileData(bArr, i3, i16);
            return;
        }
        if (i16 == 24) {
            this.size = new ZipEightByteInteger(bArr, i3);
            int i17 = i3 + 8;
            this.compressedSize = new ZipEightByteInteger(bArr, i17);
            this.relativeHeaderOffset = new ZipEightByteInteger(bArr, i17 + 8);
            return;
        }
        if (i16 % 8 == 4) {
            this.diskStart = new ZipLong(bArr, (i3 + i16) - 4);
        }
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i3, int i16) throws ZipException {
        if (i16 == 0) {
            return;
        }
        if (i16 >= 16) {
            this.size = new ZipEightByteInteger(bArr, i3);
            int i17 = i3 + 8;
            this.compressedSize = new ZipEightByteInteger(bArr, i17);
            int i18 = i17 + 8;
            int i19 = i16 - 16;
            if (i19 >= 8) {
                this.relativeHeaderOffset = new ZipEightByteInteger(bArr, i18);
                i18 += 8;
                i19 -= 8;
            }
            if (i19 >= 4) {
                this.diskStart = new ZipLong(bArr, i18);
                return;
            }
            return;
        }
        throw new ZipException(LFH_MUST_HAVE_BOTH_SIZES_MSG);
    }

    public void reparseCentralDirectoryData(boolean z16, boolean z17, boolean z18, boolean z19) throws ZipException {
        int i3;
        int i16;
        int i17;
        int i18;
        byte[] bArr = this.rawCentralDirectoryData;
        if (bArr != null) {
            int i19 = 0;
            if (z16) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            if (z17) {
                i16 = 8;
            } else {
                i16 = 0;
            }
            int i26 = i3 + i16;
            if (z18) {
                i17 = 8;
            } else {
                i17 = 0;
            }
            int i27 = i26 + i17;
            if (z19) {
                i18 = 4;
            } else {
                i18 = 0;
            }
            int i28 = i27 + i18;
            if (bArr.length == i28) {
                if (z16) {
                    this.size = new ZipEightByteInteger(this.rawCentralDirectoryData, 0);
                    i19 = 8;
                }
                if (z17) {
                    this.compressedSize = new ZipEightByteInteger(this.rawCentralDirectoryData, i19);
                    i19 += 8;
                }
                if (z18) {
                    this.relativeHeaderOffset = new ZipEightByteInteger(this.rawCentralDirectoryData, i19);
                    i19 += 8;
                }
                if (z19) {
                    this.diskStart = new ZipLong(this.rawCentralDirectoryData, i19);
                    return;
                }
                return;
            }
            throw new ZipException("central directory zip64 extended information extra field's length doesn't match central directory data.  Expected length " + i28 + " but is " + this.rawCentralDirectoryData.length);
        }
    }

    public void setCompressedSize(ZipEightByteInteger zipEightByteInteger) {
        this.compressedSize = zipEightByteInteger;
    }

    public void setDiskStartNumber(ZipLong zipLong) {
        this.diskStart = zipLong;
    }

    public void setRelativeHeaderOffset(ZipEightByteInteger zipEightByteInteger) {
        this.relativeHeaderOffset = zipEightByteInteger;
    }

    public void setSize(ZipEightByteInteger zipEightByteInteger) {
        this.size = zipEightByteInteger;
    }

    public Zip64ExtendedInformationExtraField(ZipEightByteInteger zipEightByteInteger, ZipEightByteInteger zipEightByteInteger2) {
        this(zipEightByteInteger, zipEightByteInteger2, null, null);
    }

    public Zip64ExtendedInformationExtraField(ZipEightByteInteger zipEightByteInteger, ZipEightByteInteger zipEightByteInteger2, ZipEightByteInteger zipEightByteInteger3, ZipLong zipLong) {
        this.size = zipEightByteInteger;
        this.compressedSize = zipEightByteInteger2;
        this.relativeHeaderOffset = zipEightByteInteger3;
        this.diskStart = zipLong;
    }
}
