package com.tencent.luggage.wxa.o0;

import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.j;
import com.tencent.luggage.wxa.n0.l;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final List f135983a;

    /* renamed from: b, reason: collision with root package name */
    public final int f135984b;

    public d(List list, int i3) {
        this.f135983a = list;
        this.f135984b = i3;
    }

    public static d a(l lVar) {
        List singletonList;
        try {
            lVar.f(21);
            int q16 = lVar.q() & 3;
            int q17 = lVar.q();
            int c16 = lVar.c();
            int i3 = 0;
            for (int i16 = 0; i16 < q17; i16++) {
                lVar.f(1);
                int w3 = lVar.w();
                for (int i17 = 0; i17 < w3; i17++) {
                    int w16 = lVar.w();
                    i3 += w16 + 4;
                    lVar.f(w16);
                }
            }
            lVar.e(c16);
            byte[] bArr = new byte[i3];
            int i18 = 0;
            for (int i19 = 0; i19 < q17; i19++) {
                lVar.f(1);
                int w17 = lVar.w();
                for (int i26 = 0; i26 < w17; i26++) {
                    int w18 = lVar.w();
                    byte[] bArr2 = j.f135067a;
                    System.arraycopy(bArr2, 0, bArr, i18, bArr2.length);
                    int length = i18 + bArr2.length;
                    System.arraycopy(lVar.f135088a, lVar.c(), bArr, length, w18);
                    i18 = length + w18;
                    lVar.f(w18);
                }
            }
            if (i3 == 0) {
                singletonList = null;
            } else {
                singletonList = Collections.singletonList(bArr);
            }
            return new d(singletonList, q16 + 1);
        } catch (ArrayIndexOutOfBoundsException e16) {
            throw new o("Error parsing HEVC config", e16);
        }
    }
}
