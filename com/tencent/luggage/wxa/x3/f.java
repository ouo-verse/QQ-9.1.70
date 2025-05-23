package com.tencent.luggage.wxa.x3;

import android.os.Looper;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.x3.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class f implements com.tencent.luggage.wxa.x3.a {

    /* renamed from: b, reason: collision with root package name */
    public final String f144567b;

    /* renamed from: c, reason: collision with root package name */
    public final int f144568c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedList f144569d;

    /* renamed from: e, reason: collision with root package name */
    public final e0 f144570e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements e0.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public final boolean a() {
            f.this.b();
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/x3/d;", "kotlin.jvm.PlatformType", "toReportList", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "callback", "", "a", "(Lcom/tencent/luggage/wxa/x3/d;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b<InputType, ResultType> implements com.tencent.luggage.wxa.ka.e {

        /* renamed from: a, reason: collision with root package name */
        public static final b f144572a = new b();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(d dVar, com.tencent.luggage.wxa.ka.i iVar) {
            com.tencent.luggage.wxa.x3.a a16 = a.C6898a.f144554a.a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.luggage.reporter.ISmcKVReportServiceEx");
            ((com.tencent.luggage.wxa.x3.b) a16).a(dVar);
            if (iVar != null) {
                iVar.a(com.tencent.luggage.wxa.va.e.f143316a);
            }
        }
    }

    public f(String MASTER_PROCESS_NAME) {
        Intrinsics.checkNotNullParameter(MASTER_PROCESS_NAME, "MASTER_PROCESS_NAME");
        this.f144567b = MASTER_PROCESS_NAME;
        this.f144568c = 1000;
        this.f144569d = new LinkedList();
        e0 e0Var = new e0(Looper.getMainLooper(), (e0.a) new a(), true);
        this.f144570e = e0Var;
        long millis = TimeUnit.SECONDS.toMillis(30L);
        e0Var.a(millis, millis);
    }

    public final void b() {
        d dVar;
        synchronized (this.f144569d) {
            dVar = new d(new ArrayList(this.f144569d));
            this.f144569d.clear();
            Unit unit = Unit.INSTANCE;
        }
        b(dVar);
    }

    @Override // com.tencent.luggage.wxa.x3.h
    public void writeKvData(int i3, byte[] reportContent, boolean z16, int i16, boolean z17, int i17) {
        d dVar;
        Intrinsics.checkNotNullParameter(reportContent, "reportContent");
        synchronized (this.f144569d) {
            this.f144569d.addLast(new c(i3, reportContent, z16, i16, z17, i17));
            if (this.f144569d.size() >= this.f144568c) {
                dVar = new d(new ArrayList(this.f144569d));
                this.f144569d.clear();
            } else {
                dVar = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        b(dVar);
    }

    @Override // com.tencent.luggage.wxa.x3.a
    public void a() {
        b();
    }

    public final void b(d dVar) {
        ArrayList a16;
        if (((dVar == null || (a16 = dVar.a()) == null) ? 0 : a16.size()) > 0) {
            com.tencent.luggage.wxa.ka.b.a(this.f144567b, dVar, b.f144572a, null);
        }
    }
}
