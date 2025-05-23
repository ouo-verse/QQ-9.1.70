package com.tencent.luggage.wxa.mc;

import com.tencent.luggage.wxa.tn.w0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class w {

    /* renamed from: b, reason: collision with root package name */
    public static com.tencent.luggage.wxa.rc.q f134404b;

    /* renamed from: a, reason: collision with root package name */
    public static final w f134403a = new w();

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f134405c = new byte[0];

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/luggage/wxa/va/e;", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/luggage/wxa/rc/q;", "a", "(Lcom/tencent/luggage/wxa/va/e;)Lcom/tencent/luggage/wxa/rc/q;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class a<InputType, ResultType> implements com.tencent.luggage.wxa.ka.r {

        /* renamed from: a, reason: collision with root package name */
        public static final a f134406a = new a();

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.rc.q invoke(com.tencent.luggage.wxa.va.e eVar) {
            x xVar = x.f134407a;
            com.tencent.luggage.wxa.rc.q a16 = x.a(xVar, null, null, 999, true, 3, null);
            if (a16 == null) {
                return xVar.a();
            }
            return a16;
        }
    }

    public static final com.tencent.luggage.wxa.rc.q a() {
        com.tencent.luggage.wxa.rc.q qVar;
        synchronized (f134405c) {
            qVar = f134404b;
            if (qVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_reader");
                qVar = null;
            }
        }
        return qVar;
    }

    public final void b() {
        if (f134404b == null) {
            synchronized (f134405c) {
                if (f134404b == null) {
                    com.tencent.luggage.wxa.rc.q INSTANCE = f134403a.c();
                    if (INSTANCE == null) {
                        INSTANCE = c.f134270g;
                        Intrinsics.checkNotNullExpressionValue(INSTANCE, "INSTANCE");
                    }
                    f134404b = INSTANCE;
                    if (INSTANCE == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("_reader");
                        INSTANCE = null;
                    }
                    INSTANCE.init();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final com.tencent.luggage.wxa.rc.q c() {
        com.tencent.luggage.wxa.rc.q qVar;
        long a16 = w0.a();
        try {
            qVar = (com.tencent.luggage.wxa.rc.q) com.tencent.luggage.wxa.ka.o.a(com.tencent.luggage.wxa.tn.z.g(), com.tencent.luggage.wxa.va.e.f143316a, a.f134406a.getClass());
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaCommLibHolder", "ipcGetReader get exception:" + e16);
            qVar = c.f134270g;
        } finally {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaCommLibHolder", "ipcGetReader cost " + (w0.a() - a16) + "ms");
        }
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaCommLibHolder", "ipcGetReader get reader " + qVar);
        return qVar;
    }
}
