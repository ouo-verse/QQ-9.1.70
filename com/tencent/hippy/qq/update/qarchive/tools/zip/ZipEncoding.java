package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface ZipEncoding {
    boolean canEncode(String str);

    String decode(byte[] bArr) throws IOException;

    ByteBuffer encode(String str) throws IOException;
}
