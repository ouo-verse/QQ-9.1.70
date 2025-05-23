package com.tencent.luggage.wxa.e5;

import android.util.ArrayMap;
import com.tencent.luggage.wxa.qc.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h implements c.InterfaceC6640c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayMap f124546a = new ArrayMap();

    @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
    public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
        Function0 function0;
        if ((str == null || str.length() == 0) || bVar == null || (function0 = (Function0) this.f124546a.get(bVar)) == null) {
            return;
        }
        function0.invoke();
    }

    public final void b(Function0 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        a(com.tencent.luggage.wxa.qc.b.DESTROYED, callback);
    }

    public final void c(Function0 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        a(com.tencent.luggage.wxa.qc.b.FOREGROUND, callback);
    }

    public final void d(Function0 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        a(com.tencent.luggage.wxa.qc.b.SUSPEND, callback);
    }

    public final void a(com.tencent.luggage.wxa.qc.b bVar, Function0 function0) {
        this.f124546a.put(bVar, function0);
    }

    public final void a(Function0 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        a(com.tencent.luggage.wxa.qc.b.BACKGROUND, callback);
    }
}
