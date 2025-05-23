package com.tencent.luggage.wxa.b9;

import com.eclipsesource.mmv8.V8ArrayBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o implements f {

    /* renamed from: c, reason: collision with root package name */
    public static final a f122256c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Map f122257a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f122258b = new AtomicInteger(0);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.b9.f
    public int a(t v85, V8ArrayBuffer v8ArrayBuffer, n nVar) {
        Intrinsics.checkNotNullParameter(v85, "v8");
        Intrinsics.checkNotNullParameter(v8ArrayBuffer, "v8ArrayBuffer");
        int incrementAndGet = this.f122258b.incrementAndGet();
        this.f122257a.put(Integer.valueOf(incrementAndGet), new p(v85, v8ArrayBuffer, nVar));
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.ShareBufferTracerManager", "trace[" + incrementAndGet + ']');
        return incrementAndGet;
    }

    @Override // com.tencent.luggage.wxa.b9.f
    public void b(int i3) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.ShareBufferTracerManager", "untrace[" + i3 + ']');
        this.f122257a.remove(Integer.valueOf(i3));
    }

    @Override // com.tencent.luggage.wxa.b9.f
    public void a() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.ShareBufferTracerManager", "untraceAll");
        this.f122257a.clear();
    }

    @Override // com.tencent.luggage.wxa.b9.f
    public p a(int i3) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.ShareBufferTracerManager", "getBuffer[" + i3 + ']');
        return (p) this.f122257a.get(Integer.valueOf(i3));
    }
}
