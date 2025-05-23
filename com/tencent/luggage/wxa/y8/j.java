package com.tencent.luggage.wxa.y8;

import com.tencent.luggage.wxa.tn.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class j {
    /* JADX WARN: Removed duplicated region for block: B:37:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr) {
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(bArr);
        deflater.finish();
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(bArr.length);
                try {
                    byte[] bArr2 = new byte[1024];
                    while (!deflater.finished()) {
                        byteArrayOutputStream2.write(bArr2, 0, deflater.deflate(bArr2));
                    }
                    bArr = byteArrayOutputStream2.toByteArray();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e16) {
                        w.a("MicroMsg.Zlib", e16, "", new Object[0]);
                    }
                } catch (Exception e17) {
                    e = e17;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        w.a("MicroMsg.Zlib", e, "", new Object[0]);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e18) {
                                w.a("MicroMsg.Zlib", e18, "", new Object[0]);
                            }
                        }
                        deflater.end();
                        return bArr;
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (OutOfMemoryError unused) {
                    throw new OutOfMemoryError("crash upload data length:" + bArr.length);
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
            } catch (OutOfMemoryError unused2) {
            }
            deflater.end();
            return bArr;
        } catch (Throwable th7) {
            th = th7;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e26) {
                    w.a("MicroMsg.Zlib", e26, "", new Object[0]);
                }
            }
            throw th;
        }
    }

    public static byte[] b(byte[] bArr) {
        Exception exc;
        com.tencent.luggage.wxa.aa.g gVar = new com.tencent.luggage.wxa.aa.g();
        gVar.reset();
        gVar.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            try {
                byte[] bArr2 = new byte[1024];
                while (!gVar.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, gVar.inflate(bArr2));
                }
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e16) {
                    w.a("MicroMsg.Zlib", e16, "", new Object[0]);
                }
                exc = null;
            } catch (Throwable th5) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e17) {
                    w.a("MicroMsg.Zlib", e17, "", new Object[0]);
                }
                throw th5;
            }
        } catch (Exception e18) {
            w.a("MicroMsg.Zlib", e18, "exception when loop read byte", new Object[0]);
            try {
                byteArrayOutputStream.close();
            } catch (IOException e19) {
                w.a("MicroMsg.Zlib", e19, "", new Object[0]);
            }
            exc = e18;
        }
        gVar.end();
        if (exc == null) {
            return bArr;
        }
        throw new Exception(exc);
    }
}
