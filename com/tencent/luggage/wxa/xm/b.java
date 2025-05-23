package com.tencent.luggage.wxa.xm;

import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum b implements com.tencent.luggage.wxa.xm.a {
    INSTANCE;


    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.xm.a f145156a = new C6920b();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xm.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C6920b implements com.tencent.luggage.wxa.xm.a {
        public C6920b() {
        }

        @Override // com.tencent.luggage.wxa.xm.a
        public void a(long j3, long j16, long j17, boolean z16) {
            a();
        }

        @Override // com.tencent.luggage.wxa.xm.a
        public void a(int i3, Object... objArr) {
            a();
        }

        @Override // com.tencent.luggage.wxa.xm.a
        public void a(int i3, String str) {
            a();
        }

        public final void a() {
            w.f("MicroMsg.ReportService", "this is DummyReportService");
        }

        @Override // com.tencent.luggage.wxa.xm.a
        public void a(ArrayList arrayList, boolean z16) {
            a();
        }
    }

    b() {
    }

    @Override // com.tencent.luggage.wxa.xm.a
    public void a(int i3, Object... objArr) {
        this.f145156a.a(i3, objArr);
    }

    @Override // com.tencent.luggage.wxa.xm.a
    public void a(int i3, String str) {
        this.f145156a.a(i3, str);
    }

    public void a(long j3, long j16) {
        a(j3, j16, 1L);
    }

    public void a(long j3, long j16, long j17) {
        a(j3, j16, j17, false);
    }

    public void a(int i3, int i16) {
        a(i3, i16);
    }

    @Override // com.tencent.luggage.wxa.xm.a
    public void a(long j3, long j16, long j17, boolean z16) {
        w.a("MicroMsg.ReportService", "idkeyStat [%d, %d] -> %d", Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        this.f145156a.a(j3, j16, j17, z16);
    }

    @Override // com.tencent.luggage.wxa.xm.a
    public void a(ArrayList arrayList, boolean z16) {
        this.f145156a.a(arrayList, z16);
    }
}
