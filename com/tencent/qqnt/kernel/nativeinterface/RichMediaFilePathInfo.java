package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class RichMediaFilePathInfo {
    public int downloadType;
    public int elementSubType;
    public int elementType;
    public String fileName;
    public String fileUuid;
    public byte[] importRichMediaContext;
    public String md5HexStr;
    public boolean needCreate;
    public int thumbSize;

    public RichMediaFilePathInfo() {
        this.md5HexStr = "";
        this.fileName = "";
        this.fileUuid = "";
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public int getElementSubType() {
        return this.elementSubType;
    }

    public int getElementType() {
        return this.elementType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileUuid() {
        return this.fileUuid;
    }

    public byte[] getImportRichMediaContext() {
        return this.importRichMediaContext;
    }

    public String getMd5HexStr() {
        return this.md5HexStr;
    }

    public boolean getNeedCreate() {
        return this.needCreate;
    }

    public int getThumbSize() {
        return this.thumbSize;
    }

    public String toString() {
        return "RichMediaFilePathInfo{elementType=" + this.elementType + ",elementSubType=" + this.elementSubType + ",md5HexStr=" + this.md5HexStr + ",fileName=" + this.fileName + ",downloadType=" + this.downloadType + ",thumbSize=" + this.thumbSize + ",importRichMediaContext=" + this.importRichMediaContext + ",fileUuid=" + this.fileUuid + ",needCreate=" + this.needCreate + ",}";
    }

    public RichMediaFilePathInfo(int i3, int i16, String str, String str2, int i17, int i18, byte[] bArr, String str3, boolean z16) {
        this.elementType = i3;
        this.elementSubType = i16;
        this.md5HexStr = str;
        this.fileName = str2;
        this.downloadType = i17;
        this.thumbSize = i18;
        this.importRichMediaContext = bArr;
        this.fileUuid = str3;
        this.needCreate = z16;
    }
}
