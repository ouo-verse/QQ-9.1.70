package com.tencent.luggage.wxa.v;

import com.google.android.exoplayer2.extractor.ogg.OggPageHeader;
import com.tencent.luggage.wxa.n0.l;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final e f142867a = new e();

    /* renamed from: b, reason: collision with root package name */
    public final l f142868b = new l(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);

    /* renamed from: c, reason: collision with root package name */
    public int f142869c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f142870d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f142871e;

    public boolean a(com.tencent.luggage.wxa.q.e eVar) {
        int i3;
        com.tencent.luggage.wxa.n0.a.b(eVar != null);
        if (this.f142871e) {
            this.f142871e = false;
            this.f142868b.y();
        }
        while (!this.f142871e) {
            if (this.f142869c < 0) {
                if (!this.f142867a.a(eVar, true)) {
                    return false;
                }
                e eVar2 = this.f142867a;
                int i16 = eVar2.f142880h;
                if ((eVar2.f142874b & 1) == 1 && this.f142868b.d() == 0) {
                    i16 += a(0);
                    i3 = this.f142870d + 0;
                } else {
                    i3 = 0;
                }
                eVar.c(i16);
                this.f142869c = i3;
            }
            int a16 = a(this.f142869c);
            int i17 = this.f142869c + this.f142870d;
            if (a16 > 0) {
                if (this.f142868b.b() < this.f142868b.d() + a16) {
                    l lVar = this.f142868b;
                    lVar.f135088a = Arrays.copyOf(lVar.f135088a, lVar.d() + a16);
                }
                l lVar2 = this.f142868b;
                eVar.a(lVar2.f135088a, lVar2.d(), a16);
                l lVar3 = this.f142868b;
                lVar3.d(lVar3.d() + a16);
                this.f142871e = this.f142867a.f142882j[i17 + (-1)] != 255;
            }
            if (i17 == this.f142867a.f142879g) {
                i17 = -1;
            }
            this.f142869c = i17;
        }
        return true;
    }

    public l b() {
        return this.f142868b;
    }

    public void c() {
        this.f142867a.a();
        this.f142868b.y();
        this.f142869c = -1;
        this.f142871e = false;
    }

    public void d() {
        l lVar = this.f142868b;
        byte[] bArr = lVar.f135088a;
        if (bArr.length == 65025) {
            return;
        }
        lVar.f135088a = Arrays.copyOf(bArr, Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, lVar.d()));
    }

    public e a() {
        return this.f142867a;
    }

    public final int a(int i3) {
        int i16;
        int i17 = 0;
        this.f142870d = 0;
        do {
            int i18 = this.f142870d;
            int i19 = i3 + i18;
            e eVar = this.f142867a;
            if (i19 >= eVar.f142879g) {
                break;
            }
            int[] iArr = eVar.f142882j;
            this.f142870d = i18 + 1;
            i16 = iArr[i19];
            i17 += i16;
        } while (i16 == 255);
        return i17;
    }
}
