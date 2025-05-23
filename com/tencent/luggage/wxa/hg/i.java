package com.tencent.luggage.wxa.hg;

import com.tencent.luggage.wxa.cr.c;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum i {
    SignMode_RS_ASN1(0, c.b.SM2SignMode_RS_ASN1, com.tencent.luggage.wxa.dr.f.kSM2SignRSASN1Encode),
    SignMode_RS(1, c.b.SM2SignMode_RS, com.tencent.luggage.wxa.dr.f.kSM2SignRSRaw);


    /* renamed from: d, reason: collision with root package name */
    public static final a f127126d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f127130a;

    /* renamed from: b, reason: collision with root package name */
    public final c.b f127131b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.dr.f f127132c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a(int i3) {
            boolean z16;
            for (i iVar : i.values()) {
                if (iVar.b() == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return iVar;
                }
            }
            return null;
        }
    }

    i(int i3, c.b bVar, com.tencent.luggage.wxa.dr.f fVar) {
        this.f127130a = i3;
        this.f127131b = bVar;
        this.f127132c = fVar;
    }

    public final int b() {
        return this.f127130a;
    }

    public final com.tencent.luggage.wxa.dr.f c() {
        return this.f127132c;
    }

    public final c.b d() {
        return this.f127131b;
    }
}
