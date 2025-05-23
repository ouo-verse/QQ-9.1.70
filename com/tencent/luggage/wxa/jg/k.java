package com.tencent.luggage.wxa.jg;

import com.tencent.luggage.wxa.jg.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k extends j implements com.tencent.luggage.wxa.bj.e {

    /* renamed from: i, reason: collision with root package name */
    public static final a f131108i = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference f131109f = new AtomicReference(null);

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f131110g = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f131111h = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.bj.e
    public void a() {
        this.f131109f.set(null);
    }

    @Override // com.tencent.luggage.wxa.jg.j
    public j.g b(com.tencent.luggage.wxa.xd.d component) {
        com.tencent.luggage.wxa.bj.d dVar;
        Intrinsics.checkNotNullParameter(component, "component");
        if (!this.f131110g.getAndSet(true) && (dVar = (com.tencent.luggage.wxa.bj.d) component.b(com.tencent.luggage.wxa.bj.d.class)) != null) {
            dVar.a(this);
            this.f131111h.set(true);
        }
        if (this.f131111h.get()) {
            j.g gVar = (j.g) this.f131109f.get();
            if (gVar == null) {
                gVar = super.b(component);
                this.f131109f.set(gVar);
            }
            Intrinsics.checkNotNullExpressionValue(gVar, "{\n            mCached.ge\u2026t(fromSystem) }\n        }");
            return gVar;
        }
        j.g b16 = super.b(component);
        Intrinsics.checkNotNullExpressionValue(b16, "{\n            super.getN\u2026Type(component)\n        }");
        return b16;
    }
}
