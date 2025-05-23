package com.tencent.luggage.wxa.b9;

import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8ArrayBuffer;
import com.eclipsesource.mmv8.V8Object;

/* compiled from: P */
/* loaded from: classes8.dex */
public class y extends v {

    /* renamed from: b, reason: collision with root package name */
    public final g f122367b;

    /* renamed from: c, reason: collision with root package name */
    public final f f122368c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements JavaCallback {
        public a() {
        }

        @Override // com.eclipsesource.mmv8.JavaCallback
        public Object invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array.length() >= 1 && v8Array.getType(0) == 1) {
                int integer = v8Array.getInteger(0);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.V8DirectApiSharedBuffer", "get, id:%d", Integer.valueOf(integer));
                return y.this.f122367b.get(integer);
            }
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.V8DirectApiSharedBuffer", "get invalid parameters");
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements JavaCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f122370a;

        public b(t tVar) {
            this.f122370a = tVar;
        }

        @Override // com.eclipsesource.mmv8.JavaCallback
        public Object invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array.length() >= 2 && v8Array.getType(0) == 10 && v8Array.getType(1) == 4) {
                int a16 = y.this.f122368c.a(this.f122370a, (V8ArrayBuffer) v8Array.get(0), n.a(v8Array.getString(1)));
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.V8DirectApiSharedBuffer", "trace, traceId:%d", Integer.valueOf(a16));
                return Integer.valueOf(a16);
            }
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.V8DirectApiSharedBuffer", "get invalid parameters");
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements JavaCallback {
        public c() {
        }

        @Override // com.eclipsesource.mmv8.JavaCallback
        public Object invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array.length() >= 1 && v8Array.getType(0) == 1) {
                int integer = v8Array.getInteger(0);
                y.this.f122368c.b(integer);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.V8DirectApiSharedBuffer", "untrace, bufferId:%d", Integer.valueOf(integer));
                return null;
            }
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.V8DirectApiSharedBuffer", "get invalid parameters");
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements JavaCallback {
        public d() {
        }

        @Override // com.eclipsesource.mmv8.JavaCallback
        public Object invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array.length() >= 1 && v8Array.getType(0) == 1) {
                p a16 = y.this.f122368c.a(v8Array.getInteger(0));
                if (a16 == null) {
                    return null;
                }
                return a16.a();
            }
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.V8DirectApiSharedBuffer", "get invalid parameters");
            return null;
        }
    }

    public y(g gVar, f fVar) {
        super("WeixinArrayBuffer");
        this.f122367b = gVar;
        this.f122368c = fVar;
    }

    @Override // com.tencent.luggage.wxa.b9.v
    public void a(t tVar, V8Object v8Object) {
        v8Object.registerJavaMethod(new a(), "get");
        v8Object.registerJavaMethod(new b(tVar), "trace");
        v8Object.registerJavaMethod(new c(), "untrace");
        v8Object.registerJavaMethod(new d(), "getTraceBuffer");
    }

    @Override // com.tencent.luggage.wxa.b9.v
    public void a() {
        this.f122368c.a();
    }
}
