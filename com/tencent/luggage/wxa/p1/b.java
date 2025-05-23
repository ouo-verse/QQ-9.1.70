package com.tencent.luggage.wxa.p1;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.y8.f;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.IOUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final int f137115d = 0;

    /* renamed from: t, reason: collision with root package name */
    public static final int f137131t = 0;

    /* renamed from: a, reason: collision with root package name */
    public static final b f137112a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final int f137113b = 1001;

    /* renamed from: c, reason: collision with root package name */
    public static final int f137114c = 1001;

    /* renamed from: e, reason: collision with root package name */
    public static final int f137116e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f137117f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final int f137118g = 3;

    /* renamed from: h, reason: collision with root package name */
    public static final int f137119h = 4;

    /* renamed from: i, reason: collision with root package name */
    public static final int f137120i = 5;

    /* renamed from: j, reason: collision with root package name */
    public static final int f137121j = 6;

    /* renamed from: k, reason: collision with root package name */
    public static final int f137122k = 7;

    /* renamed from: l, reason: collision with root package name */
    public static final int f137123l = 8;

    /* renamed from: m, reason: collision with root package name */
    public static final int f137124m = 9;

    /* renamed from: n, reason: collision with root package name */
    public static final int f137125n = 10;

    /* renamed from: o, reason: collision with root package name */
    public static final int f137126o = 11;

    /* renamed from: p, reason: collision with root package name */
    public static final int f137127p = 12;

    /* renamed from: q, reason: collision with root package name */
    public static final int f137128q = 13;

    /* renamed from: r, reason: collision with root package name */
    public static final int f137129r = 14;

    /* renamed from: s, reason: collision with root package name */
    public static final int f137130s = 15;

    /* renamed from: u, reason: collision with root package name */
    public static final int f137132u = 1;

    public final int a(com.tencent.luggage.wxa.dn.b bVar, byte[] bArr, byte[] bArr2) {
        if (bVar != null && bArr != null && bArr2 != null) {
            if (bArr.length >= 0 && bArr2.length > 0) {
                int length = 8 - (bArr.length % 8);
                int length2 = bArr.length + length;
                byte[] bArr3 = new byte[length2];
                int length3 = bArr.length;
                for (int i3 = 0; i3 < length3; i3++) {
                    bArr3[i3] = bArr[i3];
                }
                for (int i16 = 0; i16 < length; i16++) {
                    bArr3[bArr.length + i16] = (byte) length;
                }
                byte[] bArr4 = new byte[bArr.length + length + 32];
                bVar.f124396a = bArr4;
                if (f.a(bArr4, bArr3, length2, bArr2.length, bArr2, f137131t) == 0) {
                    return f137126o;
                }
                int length4 = bArr.length + length + 8;
                byte[] bArr5 = new byte[length4];
                for (int i17 = 0; i17 < length4; i17++) {
                    byte[] bArr6 = bVar.f124396a;
                    if (bArr6 != null) {
                        Intrinsics.checkNotNull(bArr6);
                        bArr5[i17] = bArr6[i17];
                    }
                }
                bVar.f124396a = bArr5;
                return f137115d;
            }
            return f137117f;
        }
        return f137117f;
    }

    public final byte[] a(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(data.length);
                try {
                    byte[] bArr = new byte[1024];
                    while (!deflater.finished()) {
                        byteArrayOutputStream2.write(bArr, 0, deflater.deflate(bArr));
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "bos.toByteArray()");
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream2);
                    data = byteArray;
                } catch (Exception e16) {
                    e = e16;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        w.h("Luggage.EncryptUtil", "compress fail", e);
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                        deflater.end();
                        return data;
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                        throw th;
                    }
                } catch (OutOfMemoryError unused) {
                    throw new OutOfMemoryError("crash upload data length:" + data.length);
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
            } catch (OutOfMemoryError unused2) {
            }
            deflater.end();
            return data;
        } catch (Throwable th7) {
            th = th7;
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            throw th;
        }
    }
}
