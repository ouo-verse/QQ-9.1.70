package com.tencent.luggage.wxa.x7;

import android.util.Log;
import com.tencent.luggage.wxa.o3.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class j extends com.tencent.luggage.wxa.p3.f {

    /* renamed from: f, reason: collision with root package name */
    public static final a f144643f = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0003H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/luggage/wxa/va/e;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Lcom/tencent/luggage/wxa/ka/i;", "callback", "", "a", "(Lcom/tencent/luggage/wxa/va/e;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b<InputType, ResultType> implements com.tencent.luggage.wxa.ka.e {

        /* renamed from: a, reason: collision with root package name */
        public static final b f144644a = new b();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(com.tencent.luggage.wxa.va.e eVar, com.tencent.luggage.wxa.ka.i iVar) {
            l.f136139a.b();
            if (iVar != null) {
                iVar.a(com.tencent.luggage.wxa.va.e.f143316a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f144645a = new c();

        public c() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.va.e eVar) {
            w.d("Luggage.RuntimeSDK.TdiClientAccountManager", "main process logout complete");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.va.e) obj);
            return Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.p3.f, com.tencent.luggage.wxa.o3.c, com.tencent.luggage.wxa.o3.e
    public void b() {
        super.b();
        w.d("Luggage.RuntimeSDK.TdiClientAccountManager", "logout stack=" + Log.getStackTraceString(new Throwable()));
        String g16 = z.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
        com.tencent.luggage.wxa.ka.b.a(g16, com.tencent.luggage.wxa.va.e.f143316a, b.f144644a, c.f144645a);
    }
}
