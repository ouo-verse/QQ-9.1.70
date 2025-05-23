package com.tencent.luggage.wxa.q6;

import com.tencent.luggage.wxa.hi.b;
import com.tencent.luggage.wxa.hi.c;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f137864a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final f0 f137865b = f0.e("WxaKeyStepLogger.RUNNING_INSTANCE");

    @Override // com.tencent.luggage.wxa.hi.c
    public void a(String sessionId, b bVar) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        if (f137865b.a(sessionId)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onStepStart id:");
            sb5.append(sessionId);
            sb5.append(", step:");
            sb5.append(bVar != null ? bVar.name() : null);
            w.d("WxaKeyStepLogger", sb5.toString());
        }
    }

    @Override // com.tencent.luggage.wxa.hi.c
    public void b(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        w.d("WxaKeyStepLogger", "onProcessStart id:" + sessionId);
        f137865b.putLong(sessionId, w0.a());
    }

    public final boolean c(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return f137865b.a(sessionId);
    }

    @Override // com.tencent.luggage.wxa.hi.c
    public void a(String sessionId, b bVar, long j3) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        if (f137865b.a(sessionId)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onStepOK id:");
            sb5.append(sessionId);
            sb5.append(" step:");
            sb5.append(bVar != null ? bVar.name() : null);
            sb5.append(" cost:");
            sb5.append(j3);
            w.d("WxaKeyStepLogger", sb5.toString());
        }
    }

    @Override // com.tencent.luggage.wxa.hi.c
    public void a(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        f0 f0Var = f137865b;
        long a16 = f0Var.a(sessionId, Long.MAX_VALUE);
        f0Var.g(sessionId);
        if (a16 < Long.MAX_VALUE) {
            w.d("WxaKeyStepLogger", "onProcessEnd id:" + sessionId + ", cost:" + (w0.a() - a16));
        }
    }
}
