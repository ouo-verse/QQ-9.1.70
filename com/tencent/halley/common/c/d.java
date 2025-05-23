package com.tencent.halley.common.c;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class d {
    public static byte[] a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Deflater deflater = new Deflater();
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[256];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            deflater.finish();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        }
        return bArr;
    }
}
