package com.tencent.luggage.wxa.x3;

import com.tencent.luggage.wxa.n3.r;
import com.tencent.luggage.wxa.n3.t;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface h {

    /* renamed from: a, reason: collision with root package name */
    public static final b f144573a = b.f144576a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements h {

        /* renamed from: b, reason: collision with root package name */
        public final r f144574b;

        /* renamed from: c, reason: collision with root package name */
        public final String f144575c;

        public a(r session) {
            Intrinsics.checkNotNullParameter(session, "session");
            this.f144574b = session;
            this.f144575c = "SmcKVReportSessionInterface.CloneSessionAdapter";
        }

        @Override // com.tencent.luggage.wxa.x3.h
        public void writeKvData(int i3, byte[] reportContent, boolean z16, int i16, boolean z17, int i17) {
            Intrinsics.checkNotNullParameter(reportContent, "reportContent");
            if (com.tencent.luggage.wxa.tn.e.f141559a) {
                w.e(this.f144575c, "writeKvData logId:" + i3 + " data:" + new String(reportContent, Charsets.UTF_8));
            }
            this.f144574b.writeKvData(i3, reportContent, z16, i16, z17, i17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f144576a = new b();

        public final h a(r session) {
            Intrinsics.checkNotNullParameter(session, "session");
            return new a(session);
        }

        public final h a(t session) {
            Intrinsics.checkNotNullParameter(session, "session");
            return new c(session);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c implements h {

        /* renamed from: b, reason: collision with root package name */
        public final t f144577b;

        /* renamed from: c, reason: collision with root package name */
        public final String f144578c;

        public c(t session) {
            Intrinsics.checkNotNullParameter(session, "session");
            this.f144577b = session;
            this.f144578c = "SmcKVReportSessionInterface.SessionAdapter";
        }

        public final t b() {
            return this.f144577b;
        }

        @Override // com.tencent.luggage.wxa.x3.h
        public void writeKvData(int i3, byte[] reportContent, boolean z16, int i16, boolean z17, int i17) {
            Intrinsics.checkNotNullParameter(reportContent, "reportContent");
            if (com.tencent.luggage.wxa.tn.e.f141559a) {
                w.e(this.f144578c, "writeKvData logId:" + i3 + " data:" + new String(reportContent, Charsets.UTF_8));
            }
            this.f144577b.writeKvData(i3, reportContent, z16, i16, z17, i17);
        }
    }

    void writeKvData(int i3, byte[] bArr, boolean z16, int i16, boolean z17, int i17);
}
