package com.tencent.luggage.wxa.nc;

import com.tencent.luggage.wxa.mc.a0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements com.tencent.luggage.wxa.nc.a {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends a0.a {
        public a(String str, String str2, int i3, int i16) {
            super(str, str2, i3, i16);
        }
    }

    public static int a(byte[] bArr, int i3, int i16) {
        if (bArr == null) {
            return 0;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i3, i16);
        wrap.order(ByteOrder.BIG_ENDIAN);
        if (i16 == 4) {
            return wrap.getInt();
        }
        byte[] bArr2 = new byte[i16];
        wrap.get(bArr2);
        int i17 = 0;
        for (int i18 = 0; i18 < i16; i18++) {
            i17 |= bArr2[i18] << (((i16 - i18) - 1) * 8);
        }
        return i17;
    }
}
