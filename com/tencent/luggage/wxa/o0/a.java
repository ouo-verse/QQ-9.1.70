package com.tencent.luggage.wxa.o0;

import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.j;
import com.tencent.luggage.wxa.n0.l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final List f135959a;

    /* renamed from: b, reason: collision with root package name */
    public final int f135960b;

    /* renamed from: c, reason: collision with root package name */
    public final int f135961c;

    /* renamed from: d, reason: collision with root package name */
    public final int f135962d;

    /* renamed from: e, reason: collision with root package name */
    public final float f135963e;

    public a(List list, int i3, int i16, int i17, float f16) {
        this.f135959a = list;
        this.f135960b = i3;
        this.f135961c = i16;
        this.f135962d = i17;
        this.f135963e = f16;
    }

    public static byte[] a(l lVar) {
        int w3 = lVar.w();
        int c16 = lVar.c();
        lVar.f(w3);
        return com.tencent.luggage.wxa.n0.d.a(lVar.f135088a, c16, w3);
    }

    public static a b(l lVar) {
        int i3;
        int i16;
        float f16;
        try {
            lVar.f(4);
            int q16 = (lVar.q() & 3) + 1;
            if (q16 != 3) {
                ArrayList arrayList = new ArrayList();
                int q17 = lVar.q() & 31;
                for (int i17 = 0; i17 < q17; i17++) {
                    arrayList.add(a(lVar));
                }
                int q18 = lVar.q();
                for (int i18 = 0; i18 < q18; i18++) {
                    arrayList.add(a(lVar));
                }
                if (q17 > 0) {
                    j.b c16 = j.c((byte[]) arrayList.get(0), q16, ((byte[]) arrayList.get(0)).length);
                    int i19 = c16.f135075b;
                    int i26 = c16.f135076c;
                    f16 = c16.f135077d;
                    i3 = i19;
                    i16 = i26;
                } else {
                    i3 = -1;
                    i16 = -1;
                    f16 = 1.0f;
                }
                return new a(arrayList, q16, i3, i16, f16);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e16) {
            throw new o("Error parsing AVC config", e16);
        }
    }
}
