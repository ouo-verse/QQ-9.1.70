package com.tencent.luggage.wxa.standalone_open_runtime.report;

import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.n3.e0;
import com.tencent.luggage.wxa.q7.s;
import com.tencent.luggage.wxa.r6.a;
import com.tencent.luggage.wxa.v3.c;
import com.tencent.luggage.wxa.v3.d;
import com.tencent.luggage.wxa.v3.e;
import com.tencent.luggage.wxa.z8.b;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.sdk.event.IListener;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;

/* loaded from: classes8.dex */
public final class KVReport_CALL_TRANSFER_API_10054 extends a {

    /* renamed from: i, reason: collision with root package name */
    public static final Companion f140728i = new Companion(null);

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicBoolean f140729j = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public String f140730b;

    /* renamed from: c, reason: collision with root package name */
    public String f140731c;

    /* renamed from: d, reason: collision with root package name */
    public int f140732d;

    /* renamed from: e, reason: collision with root package name */
    public String f140733e;

    /* renamed from: f, reason: collision with root package name */
    public int f140734f;

    /* renamed from: g, reason: collision with root package name */
    public long f140735g;

    /* renamed from: h, reason: collision with root package name */
    public int f140736h;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            if (KVReport_CALL_TRANSFER_API_10054.f140729j.getAndSet(true)) {
                return;
            }
            final b bVar = b.f146383a;
            new IListener<e>(bVar) { // from class: com.tencent.luggage.wxa.standalone_open_runtime.report.KVReport_CALL_TRANSFER_API_10054$Companion$startMonitor$1
                @Override // com.tencent.mm.sdk.event.IListener
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public boolean callback(e event) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    KVReport_CALL_TRANSFER_API_10054.f140728i.a(event);
                    return false;
                }
            }.alive();
        }

        public final void a(e eVar) {
            d d16;
            WXLaunchWxaRedirectingPage.Resp e16;
            com.tencent.luggage.wxa.ic.d a16;
            g runtime;
            if (eVar == null || (d16 = eVar.d()) == null || (e16 = eVar.e()) == null) {
                return;
            }
            KVReport_CALL_TRANSFER_API_10054 kVReport_CALL_TRANSFER_API_10054 = new KVReport_CALL_TRANSFER_API_10054(null, null, 0, null, 0, 0L, 0, 127, null);
            s.d dVar = s.d.f138074a;
            kVReport_CALL_TRANSFER_API_10054.d(dVar.b());
            kVReport_CALL_TRANSFER_API_10054.b(d16.f143055a.getF140742c());
            com.tencent.luggage.wxa.v3.b bVar = d16.f143055a;
            c cVar = bVar instanceof c ? (c) bVar : null;
            kVReport_CALL_TRANSFER_API_10054.a((cVar == null || (a16 = cVar.a()) == null || (runtime = a16.getRuntime()) == null) ? 0 : runtime.l0() + 1);
            kVReport_CALL_TRANSFER_API_10054.c(d16.f143056b);
            kVReport_CALL_TRANSFER_API_10054.b(e16.errCode);
            kVReport_CALL_TRANSFER_API_10054.a(dVar.c());
            kVReport_CALL_TRANSFER_API_10054.c(603979777);
            kVReport_CALL_TRANSFER_API_10054.c();
        }
    }

    public /* synthetic */ KVReport_CALL_TRANSFER_API_10054(String str, String str2, int i3, String str3, int i16, long j3, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? null : str, (i18 & 2) != 0 ? null : str2, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) == 0 ? str3 : null, (i18 & 16) != 0 ? 0 : i16, (i18 & 32) != 0 ? 0L : j3, (i18 & 64) == 0 ? i17 : 0);
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public int a() {
        return 10054;
    }

    public final void b(String str) {
        this.f140731c = str;
    }

    public final void c(String str) {
        this.f140733e = str;
    }

    public final void d(String str) {
        this.f140730b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KVReport_CALL_TRANSFER_API_10054)) {
            return false;
        }
        KVReport_CALL_TRANSFER_API_10054 kVReport_CALL_TRANSFER_API_10054 = (KVReport_CALL_TRANSFER_API_10054) obj;
        if (Intrinsics.areEqual(this.f140730b, kVReport_CALL_TRANSFER_API_10054.f140730b) && Intrinsics.areEqual(this.f140731c, kVReport_CALL_TRANSFER_API_10054.f140731c) && this.f140732d == kVReport_CALL_TRANSFER_API_10054.f140732d && Intrinsics.areEqual(this.f140733e, kVReport_CALL_TRANSFER_API_10054.f140733e) && this.f140734f == kVReport_CALL_TRANSFER_API_10054.f140734f && this.f140735g == kVReport_CALL_TRANSFER_API_10054.f140735g && this.f140736h == kVReport_CALL_TRANSFER_API_10054.f140736h) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        String str = this.f140730b;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.f140731c;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (((i16 + hashCode2) * 31) + this.f140732d) * 31;
        String str3 = this.f140733e;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return ((((((i17 + i3) * 31) + this.f140734f) * 31) + androidx.fragment.app.a.a(this.f140735g)) * 31) + this.f140736h;
    }

    public String toString() {
        return "KVReport_CALL_TRANSFER_API_10054(hostAppId=" + this.f140730b + ", appId=" + this.f140731c + ", appState=" + this.f140732d + ", functionName=" + this.f140733e + ", errorCode=" + this.f140734f + ", iLinkUIN=" + this.f140735g + ", sdkVersion=" + this.f140736h + ')';
    }

    public KVReport_CALL_TRANSFER_API_10054(String str, String str2, int i3, String str3, int i16, long j3, int i17) {
        this.f140730b = str;
        this.f140731c = str2;
        this.f140732d = i3;
        this.f140733e = str3;
        this.f140734f = i16;
        this.f140735g = j3;
        this.f140736h = i17;
    }

    public final void a(int i3) {
        this.f140732d = i3;
    }

    public final void b(int i3) {
        this.f140734f = i3;
    }

    public final void c(int i3) {
        this.f140736h = i3;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public String d() {
        String join = StringUtils.join(new String[]{this.f140730b, this.f140731c, String.valueOf(this.f140732d), this.f140733e, String.valueOf(this.f140734f), e0.f135163b.b(this.f140735g), String.valueOf(this.f140736h)}, ",");
        Intrinsics.checkNotNullExpressionValue(join, "join(arrayOf(\n          \u2026oString()\n        ), \",\")");
        return join;
    }

    public final void a(long j3) {
        this.f140735g = j3;
    }
}
