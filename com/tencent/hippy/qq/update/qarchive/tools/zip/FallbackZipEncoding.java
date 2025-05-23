package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
class FallbackZipEncoding implements ZipEncoding {
    private final String charset;

    public FallbackZipEncoding() {
        this.charset = null;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEncoding
    public boolean canEncode(String str) {
        return true;
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEncoding
    public String decode(byte[] bArr) throws IOException {
        String str = this.charset;
        if (str == null) {
            return new String(bArr);
        }
        return new String(bArr, str);
    }

    @Override // com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEncoding
    public ByteBuffer encode(String str) throws IOException {
        String str2 = this.charset;
        if (str2 == null) {
            return ByteBuffer.wrap(str.getBytes());
        }
        return ByteBuffer.wrap(str.getBytes(str2));
    }

    public FallbackZipEncoding(String str) {
        this.charset = str;
    }
}
