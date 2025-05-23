package com.tencent.luggage.wxa.r;

import android.util.Pair;
import com.tencent.luggage.wxa.m.j;
import com.tencent.luggage.wxa.q.l;
import com.tencent.luggage.wxa.r.d;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends d {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f139022e = {5512, 11025, 22050, 44100};

    /* renamed from: b, reason: collision with root package name */
    public boolean f139023b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f139024c;

    /* renamed from: d, reason: collision with root package name */
    public int f139025d;

    public a(l lVar) {
        super(lVar);
    }

    @Override // com.tencent.luggage.wxa.r.d
    public boolean a(com.tencent.luggage.wxa.n0.l lVar) {
        String str;
        int i3;
        if (!this.f139023b) {
            int q16 = lVar.q();
            int i16 = (q16 >> 4) & 15;
            this.f139025d = i16;
            if (i16 == 2) {
                this.f139042a.a(j.a(null, "audio/mpeg", null, -1, -1, 1, f139022e[(q16 >> 2) & 3], null, null, 0, null));
                this.f139024c = true;
            } else if (i16 != 7 && i16 != 8) {
                if (i16 != 10) {
                    throw new d.a("Audio format not supported: " + this.f139025d);
                }
            } else {
                if (i16 == 7) {
                    str = "audio/g711-alaw";
                } else {
                    str = "audio/g711-mlaw";
                }
                String str2 = str;
                if ((q16 & 1) == 1) {
                    i3 = 2;
                } else {
                    i3 = 3;
                }
                this.f139042a.a(j.a((String) null, str2, (String) null, -1, -1, 1, 8000, i3, (List) null, (com.tencent.luggage.wxa.p.a) null, 0, (String) null));
                this.f139024c = true;
            }
            this.f139023b = true;
        } else {
            lVar.f(1);
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.r.d
    public void b(com.tencent.luggage.wxa.n0.l lVar, long j3) {
        if (this.f139025d == 2) {
            int a16 = lVar.a();
            this.f139042a.a(lVar, a16);
            this.f139042a.a(j3, 1, a16, 0, null);
            return;
        }
        int q16 = lVar.q();
        if (q16 == 0 && !this.f139024c) {
            int a17 = lVar.a();
            byte[] bArr = new byte[a17];
            lVar.a(bArr, 0, a17);
            Pair a18 = com.tencent.luggage.wxa.n0.d.a(bArr);
            this.f139042a.a(j.a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) a18.second).intValue(), ((Integer) a18.first).intValue(), Collections.singletonList(bArr), null, 0, null));
            this.f139024c = true;
            return;
        }
        if (this.f139025d != 10 || q16 == 1) {
            int a19 = lVar.a();
            this.f139042a.a(lVar, a19);
            this.f139042a.a(j3, 1, a19, 0, null);
        }
    }
}
