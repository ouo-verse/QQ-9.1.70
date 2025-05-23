package com.tencent.luggage.wxa.hg;

import com.tencent.luggage.wxa.cr.c;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum g {
    CipherMode_C1C3C2_ASN1(0, c.a.SM2CipherMode_C1C3C2_ASN1, com.tencent.luggage.wxa.dr.e.kSM2CipherC1C3C2ASN1Encode),
    CipherMode_C1C3C2(1, c.a.SM2CipherMode_C1C3C2, com.tencent.luggage.wxa.dr.e.kSM2CipherC1C3C2Raw),
    CipherMode_C1C2C3_ASN1(2, c.a.SM2CipherMode_C1C2C3_ASN1, com.tencent.luggage.wxa.dr.e.kSM2CipherC1C2C3ASN1Encode),
    CipherMode_C1C2C3(3, c.a.SM2CipherMode_C1C2C3, com.tencent.luggage.wxa.dr.e.kSM2CipherC1C2C3Raw),
    CipherMode_04C1C3C2(4, c.a.SM2CipherMode_04C1C3C2, com.tencent.luggage.wxa.dr.e.kSM2Cipher04C1C3C2Raw),
    CipherMode_04C1C2C3(5, c.a.SM2CipherMode_04C1C2C3, com.tencent.luggage.wxa.dr.e.kSM2Cipher04C1C2C3Raw);


    /* renamed from: d, reason: collision with root package name */
    public static final a f127109d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f127117a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a f127118b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.dr.e f127119c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a(int i3) {
            boolean z16;
            for (g gVar : g.values()) {
                if (gVar.b() == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return gVar;
                }
            }
            return null;
        }
    }

    g(int i3, c.a aVar, com.tencent.luggage.wxa.dr.e eVar) {
        this.f127117a = i3;
        this.f127118b = aVar;
        this.f127119c = eVar;
    }

    public final int b() {
        return this.f127117a;
    }

    public final com.tencent.luggage.wxa.dr.e c() {
        return this.f127119c;
    }

    public final c.a d() {
        return this.f127118b;
    }
}
