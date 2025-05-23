package com.tencent.luggage.wxa.ol;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j0 implements s0 {

    /* renamed from: d, reason: collision with root package name */
    public static final a f136796d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Integer f136797a;

    /* renamed from: b, reason: collision with root package name */
    public String f136798b;

    /* renamed from: c, reason: collision with root package name */
    public String f136799c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j0(Integer num) {
        this.f136797a = num;
    }

    @Override // com.tencent.luggage.wxa.ol.s0
    public synchronized String a(com.tencent.luggage.wxa.xd.d env, String certPath) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(certPath, "certPath");
        if (Intrinsics.areEqual(certPath, this.f136798b)) {
            String str = this.f136799c;
            if (str != null) {
                return str;
            }
            com.tencent.luggage.wxa.tn.w.b(b(), "readCertPem, cachedCertPem is null");
            throw new l0("certPath is illegal");
        }
        try {
            String a16 = n0.f136895a.a(env, certPath);
            this.f136799c = a16;
            this.f136798b = certPath;
            return a16;
        } catch (o0 e16) {
            throw new l0(e16.getMessage());
        }
    }

    public final String b() {
        int hashCode;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("MicroMsg.AppBrand.BaseInputEncryptExtension#");
        Integer num = this.f136797a;
        if (num != null) {
            hashCode = num.intValue();
        } else {
            hashCode = hashCode();
        }
        sb5.append(hashCode);
        return sb5.toString();
    }

    public /* synthetic */ j0(Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num);
    }
}
