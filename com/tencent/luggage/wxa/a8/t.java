package com.tencent.luggage.wxa.a8;

import com.tencent.luggage.wxa.a8.h;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class t implements h.a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f120945d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f120946e = true;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f120947a;

    /* renamed from: b, reason: collision with root package name */
    public final String f120948b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f120949c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h.a a(u type) {
            boolean z16;
            Intrinsics.checkNotNullParameter(type, "type");
            if (type != u.Video) {
                z16 = t.f120946e;
            } else {
                z16 = false;
            }
            return new t(z16, type.name() + "Thread_");
        }
    }

    public t(boolean z16, String namePrefix) {
        Intrinsics.checkNotNullParameter(namePrefix, "namePrefix");
        this.f120947a = z16;
        this.f120948b = namePrefix;
        this.f120949c = new AtomicInteger(0);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.SameLayerPluginHandlerThreadProvider", "<init>, usePooledImpl: " + z16);
    }

    public static final h.a a(u uVar) {
        return f120945d.a(uVar);
    }

    @Override // com.tencent.luggage.wxa.a8.h.a
    public h create() {
        String str = this.f120948b + this.f120949c.getAndIncrement();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.SameLayerPluginHandlerThreadProvider", "create, name: " + str);
        if (this.f120947a) {
            return new r(str);
        }
        return new s(str);
    }
}
