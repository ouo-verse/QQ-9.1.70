package com.tencent.hippy.qq.update.qarchive.tools.zip;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class UnparseableExtraFieldData implements CentralDirectoryParsingZipExtraField {
    private static final ZipShort HEADER_ID = new ZipShort(44225);
    private byte[] centralDirectoryData;
    private byte[] localFileData;

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.centralDirectoryData;
        if (bArr == null) {
            return getLocalFileDataData();
        }
        return ZipUtil.copy(bArr);
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        byte[] bArr = this.centralDirectoryData;
        if (bArr == null) {
            return getLocalFileDataLength();
        }
        return new ZipShort(bArr.length);
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localFileData);
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        int length;
        byte[] bArr = this.localFileData;
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        return new ZipShort(length);
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.CentralDirectoryParsingZipExtraField
    public void parseFromCentralDirectoryData(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[i16];
        this.centralDirectoryData = bArr2;
        System.arraycopy(bArr, i3, bArr2, 0, i16);
        if (this.localFileData == null) {
            parseFromLocalFileData(bArr, i3, i16);
        }
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[i16];
        this.localFileData = bArr2;
        System.arraycopy(bArr, i3, bArr2, 0, i16);
    }
}
