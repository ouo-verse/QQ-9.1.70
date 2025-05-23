package com.tencent.hippy.qq.update.qarchive.tools.zip;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UnrecognizedExtraField implements CentralDirectoryParsingZipExtraField {
    private byte[] centralData;
    private ZipShort headerId;
    private byte[] localData;

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.centralData;
        if (bArr != null) {
            return ZipUtil.copy(bArr);
        }
        return getLocalFileDataData();
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        byte[] bArr = this.centralData;
        if (bArr != null) {
            return new ZipShort(bArr.length);
        }
        return getLocalFileDataLength();
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return this.headerId;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localData);
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.localData.length);
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.CentralDirectoryParsingZipExtraField
    public void parseFromCentralDirectoryData(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[i16];
        System.arraycopy(bArr, i3, bArr2, 0, i16);
        setCentralDirectoryData(bArr2);
        if (this.localData == null) {
            setLocalFileDataData(bArr2);
        }
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[i16];
        System.arraycopy(bArr, i3, bArr2, 0, i16);
        setLocalFileDataData(bArr2);
    }

    public void setCentralDirectoryData(byte[] bArr) {
        this.centralData = ZipUtil.copy(bArr);
    }

    public void setHeaderId(ZipShort zipShort) {
        this.headerId = zipShort;
    }

    public void setLocalFileDataData(byte[] bArr) {
        this.localData = ZipUtil.copy(bArr);
    }
}
