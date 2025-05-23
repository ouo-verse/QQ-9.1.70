package com.tencent.luggage.wxa.ib;

import com.tencent.luggage.wxa.tn.a0;
import com.tencent.luggage.wxa.tn.w;
import kotlin.Unit;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f129678a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final a0 f129679b = new a0();

    public final void a(boolean z16) {
        a0 a0Var = f129679b;
        synchronized (a0Var) {
            try {
                if (z16) {
                    a0Var.a();
                } else {
                    a0Var.c();
                }
            } catch (Exception e16) {
                w.a("MicroMsg.PreviewRenderSignal", e16, "markRendering error", new Object[0]);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
