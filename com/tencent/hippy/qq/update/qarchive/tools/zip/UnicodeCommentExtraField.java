package com.tencent.hippy.qq.update.qarchive.tools.zip;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UnicodeCommentExtraField extends AbstractUnicodeExtraField {
    public static final ZipShort UCOM_ID = new ZipShort(25461);

    public UnicodeCommentExtraField() {
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return UCOM_ID;
    }

    public UnicodeCommentExtraField(String str, byte[] bArr, int i3, int i16) {
        super(str, bArr, i3, i16);
    }

    public UnicodeCommentExtraField(String str, byte[] bArr) {
        super(str, bArr);
    }
}
