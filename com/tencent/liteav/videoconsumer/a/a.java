package com.tencent.liteav.videoconsumer.a;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.decoder.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f119503a = false;

    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videoconsumer.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC5952a {
        boolean a(int i3, int i16, int i17, int i18);
    }

    public static byte[] a(byte[] bArr) {
        byte b16;
        byte[] bArr2 = new byte[(bArr.length * 3) / 2];
        int i3 = 0;
        int i16 = 0;
        while (i3 < bArr.length) {
            if (i3 < bArr.length - 2 && (b16 = bArr[i3]) == 0) {
                int i17 = i3 + 1;
                if (bArr[i17] == 0) {
                    int i18 = i3 + 2;
                    if (bArr[i18] <= 3) {
                        int i19 = i16 + 1;
                        bArr2[i16] = b16;
                        int i26 = i19 + 1;
                        bArr2[i19] = bArr[i17];
                        bArr2[i26] = 3;
                        i16 = i26 + 1;
                        i3 = i18;
                    }
                }
            }
            bArr2[i16] = bArr[i3];
            i3++;
            i16++;
        }
        if (i16 == bArr.length) {
            return bArr;
        }
        byte[] bArr3 = new byte[i16];
        System.arraycopy(bArr2, 0, bArr3, 0, i16);
        return bArr3;
    }

    public final byte[] a(InputStream inputStream, InterfaceC5952a interfaceC5952a) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b bVar = new b(inputStream, byteArrayOutputStream);
        bVar.b(8);
        int a16 = (int) bVar.a();
        bVar.b(8);
        bVar.a();
        bVar.d();
        boolean z16 = false;
        if (a16 == 100 || a16 == 110 || a16 == 122 || a16 == 144) {
            if (bVar.c() == 3) {
                bVar.b(1);
            }
            bVar.d();
            bVar.d();
            bVar.b(1);
            if (bVar.a(true)) {
                for (int i3 = 0; i3 < 8; i3++) {
                    if (bVar.a(true)) {
                        if (i3 < 6) {
                            bVar.c(16);
                        } else {
                            bVar.c(64);
                        }
                    }
                }
            }
        }
        bVar.d();
        int c16 = bVar.c();
        if (c16 == 0) {
            bVar.d();
        } else if (c16 == 1) {
            bVar.b(1);
            bVar.d();
            bVar.d();
            int c17 = bVar.c();
            for (int i16 = 0; i16 < c17; i16++) {
                bVar.d();
            }
        }
        bVar.c();
        bVar.b(1);
        bVar.d();
        bVar.d();
        if (!bVar.a(true)) {
            bVar.b(1);
        }
        bVar.b(1);
        if (bVar.a(true) && !interfaceC5952a.a(bVar.c(), bVar.c(), bVar.c(), bVar.c())) {
            return null;
        }
        if (bVar.a(false)) {
            bVar.b(true);
            if (bVar.a(true) && ((int) bVar.a()) == 255) {
                bVar.b(16);
                bVar.b(16);
            }
            if (bVar.a(true)) {
                bVar.b(1);
            }
            if (bVar.a(true)) {
                bVar.b(3);
                bVar.b(1);
                if (bVar.a(true)) {
                    bVar.b(8);
                    bVar.b(8);
                    bVar.b(8);
                }
            }
            if (bVar.a(true)) {
                bVar.d();
                bVar.d();
            }
            if (bVar.a(true)) {
                bVar.b(32);
                bVar.b(32);
                bVar.b(1);
            }
            boolean a17 = bVar.a(true);
            if (a17) {
                a(bVar);
            }
            boolean a18 = bVar.a(true);
            if (a18) {
                a(bVar);
            }
            if (a17 || a18) {
                bVar.b(1);
            }
            bVar.b(1);
            if (bVar.a(false)) {
                bVar.b(true);
                bVar.a(true);
                bVar.d();
                bVar.d();
                bVar.d();
                bVar.d();
                bVar.d();
                if (!this.f119503a) {
                    LiteavLog.w("H264SPSModifier", "decode: do not add max_dec_frame_buffering when it is ".concat(String.valueOf(bVar.b())));
                    this.f119503a = true;
                }
            } else {
                bVar.b(true);
                bVar.b(true);
                bVar.d(0);
                bVar.d(0);
                bVar.d(10);
                bVar.d(10);
                bVar.d(0);
                bVar.d(1);
                if (!this.f119503a) {
                    LiteavLog.w("H264SPSModifier", "decode: add max_dec_frame_buffering 1 when it is no exist");
                    this.f119503a = true;
                }
                z16 = true;
            }
            if (!z16) {
                return null;
            }
        } else {
            bVar.b(true);
            bVar.b(false);
            bVar.b(false);
            bVar.b(false);
            bVar.b(false);
            bVar.b(false);
            bVar.b(false);
            bVar.b(false);
            bVar.b(false);
            bVar.b(true);
            bVar.b(true);
            bVar.d(0);
            bVar.d(0);
            bVar.d(10);
            bVar.d(10);
            bVar.d(0);
            bVar.d(1);
            if (!this.f119503a) {
                LiteavLog.w("H264SPSModifier", "decode: add max_dec_frame_buffering 1 when vui is no exist");
                this.f119503a = true;
            }
        }
        bVar.e();
        return byteArrayOutputStream.toByteArray();
    }

    private static void a(b bVar) throws IOException {
        int c16 = bVar.c();
        bVar.a(4);
        bVar.a(4);
        for (int i3 = 0; i3 <= c16; i3++) {
            bVar.d();
            bVar.d();
            bVar.a(1);
        }
        bVar.a(5);
        bVar.a(5);
        bVar.a(5);
        bVar.a(5);
    }
}
