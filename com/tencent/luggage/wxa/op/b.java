package com.tencent.luggage.wxa.op;

import android.content.Context;
import android.util.Base64;
import com.tencent.luggage.wxa.np.h;
import com.tencent.luggage.wxa.np.k;
import java.security.Signature;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static int b(byte[] bArr) {
        int i3 = 0;
        for (int i16 = 0; i16 < bArr.length; i16++) {
            i3 += (bArr[i16] & 255) << (i16 * 8);
        }
        return i3;
    }

    public abstract h a();

    public abstract h a(String str);

    public abstract com.tencent.luggage.wxa.pp.c a(String str, String str2);

    public void a(e eVar) {
    }

    public abstract boolean a(Context context);

    public abstract boolean a(String str, boolean z16);

    public abstract byte[] a(long j3);

    public abstract h b(String str, boolean z16);

    public abstract k b();

    public abstract Signature b(String str);

    public abstract k c(String str);

    public abstract boolean c();

    public abstract boolean d();

    public abstract boolean d(String str);

    public abstract boolean e();

    public abstract h f();

    public static k a(byte[] bArr) {
        if (bArr == null) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBase", "soter: raw data is null", new Object[0]);
            return null;
        }
        if (bArr.length < 4) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBase", "soter: raw data length smaller than RAW_LENGTH_PREFIX", new Object[0]);
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        int b16 = b(bArr2);
        com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBase", "soter: parsed raw length: " + b16, new Object[0]);
        if (b16 > 1048576) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBase", "soter: too large json result!", new Object[0]);
            return null;
        }
        byte[] bArr3 = new byte[b16];
        int i3 = b16 + 4;
        if (bArr.length < i3) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBase", "length not correct 2", new Object[0]);
            return null;
        }
        System.arraycopy(bArr, 4, bArr3, 0, b16);
        String str = new String(bArr3);
        com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBase", "soter: to convert json: " + str, new Object[0]);
        k kVar = new k(str, "");
        int length = bArr.length - i3;
        com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBase", "soter: signature length: " + length, new Object[0]);
        if (length != 0) {
            byte[] bArr4 = new byte[length];
            System.arraycopy(bArr, i3, bArr4, 0, length);
            kVar.c(Base64.encodeToString(bArr4, 2));
        }
        return kVar;
    }
}
