package com.tencent.luggage.wxa.i3;

import com.tencent.luggage.wxa.j4.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class s {

    /* renamed from: b, reason: collision with root package name */
    public static final a f129353b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f129354a;

    public s(String wxaLaunchInstanceId) {
        Intrinsics.checkNotNullParameter(wxaLaunchInstanceId, "wxaLaunchInstanceId");
        this.f129354a = wxaLaunchInstanceId;
    }

    public static final String a(com.tencent.luggage.wxa.j4.d dVar) {
        return f129353b.a(dVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof s) && Intrinsics.areEqual(this.f129354a, ((s) obj).f129354a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f129354a.hashCode();
    }

    public String toString() {
        return "WxaLaunchInstanceId(wxaLaunchInstanceId=" + this.f129354a + ')';
    }

    public static final String a(com.tencent.luggage.wxa.ki.a aVar) {
        return f129353b.a(aVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(com.tencent.luggage.wxa.ki.a args) {
            Intrinsics.checkNotNullParameter(args, "args");
            com.tencent.luggage.wxa.j4.k kVar = k.b.f130850a;
            if (kVar == null) {
                kVar = com.tencent.luggage.wxa.j4.k.f130849a;
            }
            String b16 = kVar.b();
            Intrinsics.checkNotNullExpressionValue(b16, "MPInstanceIdFactory.IMPL\u2026FAULT).createInstanceId()");
            String str = args.F;
            if (str == null || str.length() == 0) {
                return b16;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(b16);
            sb5.append("&host_scene=");
            String str2 = args.F;
            Intrinsics.checkNotNull(str2);
            sb5.append(new n(str2, false, 2, (DefaultConstructorMarker) null).a());
            return sb5.toString();
        }

        public final String a(com.tencent.luggage.wxa.j4.d initConfig) {
            Intrinsics.checkNotNullParameter(initConfig, "initConfig");
            com.tencent.luggage.wxa.j4.k kVar = k.b.f130850a;
            if (kVar == null) {
                kVar = com.tencent.luggage.wxa.j4.k.f130849a;
            }
            String b16 = kVar.b();
            Intrinsics.checkNotNullExpressionValue(b16, "MPInstanceIdFactory.IMPL\u2026FAULT).createInstanceId()");
            String str = initConfig.f130793e0;
            if (str == null || str.length() == 0) {
                return b16;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(b16);
            sb5.append("&host_scene=");
            String str2 = initConfig.f130793e0;
            Intrinsics.checkNotNull(str2);
            sb5.append(new n(str2, false, 2, (DefaultConstructorMarker) null).a());
            return sb5.toString();
        }
    }

    public final String a() {
        return this.f129354a;
    }
}
