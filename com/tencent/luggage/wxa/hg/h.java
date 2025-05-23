package com.tencent.luggage.wxa.hg;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum h {
    SM2KeyFormatHEX(0, com.tencent.luggage.wxa.dr.g.kTSMStorageSM2KeyFormatHEX),
    SM2KeyFormatPEM(1, com.tencent.luggage.wxa.dr.g.kTSMStorageSM2KeyFormatPEM);


    /* renamed from: c, reason: collision with root package name */
    public static final a f127120c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f127124a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.dr.g f127125b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a(int i3) {
            boolean z16;
            for (h hVar : h.values()) {
                if (hVar.b() == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return hVar;
                }
            }
            return null;
        }
    }

    h(int i3, com.tencent.luggage.wxa.dr.g gVar) {
        this.f127124a = i3;
        this.f127125b = gVar;
    }

    public final int b() {
        return this.f127124a;
    }

    public final com.tencent.luggage.wxa.dr.g c() {
        return this.f127125b;
    }
}
