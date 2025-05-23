package com.tencent.hippy.qq.update.qarchive.tools.zip;

/* loaded from: classes7.dex */
public class UnicodePathExtraField extends AbstractUnicodeExtraField {
    public static final ZipShort UPATH_ID = new ZipShort(28789);

    public UnicodePathExtraField() {
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return UPATH_ID;
    }

    public UnicodePathExtraField(String str, byte[] bArr, int i3, int i16) {
        super(str, bArr, i3, i16);
    }

    public UnicodePathExtraField(String str, byte[] bArr) {
        super(str, bArr);
    }
}
