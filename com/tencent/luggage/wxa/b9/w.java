package com.tencent.luggage.wxa.b9;

import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8ArrayBuffer;
import com.eclipsesource.mmv8.V8Object;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w extends v {

    /* renamed from: b, reason: collision with root package name */
    public h f122355b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements JavaCallback {
        public a() {
        }

        @Override // com.eclipsesource.mmv8.JavaCallback
        public Object invoke(V8Object v8Object, V8Array v8Array) {
            Integer valueOf = Integer.valueOf(w.this.f122355b.f());
            com.tencent.luggage.wxa.tn.w.a("V8DirectApiBuffer", "generateId:%d", valueOf);
            return valueOf;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements JavaCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f122357a;

        public b(t tVar) {
            this.f122357a = tVar;
        }

        @Override // com.eclipsesource.mmv8.JavaCallback
        public Object invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array.length() >= 1 && v8Array.getType(0) == 1) {
                com.tencent.luggage.wxa.tn.w.a("V8DirectApiBuffer", "getNativeBuffer, id:%d", Integer.valueOf(v8Array.getInteger(0)));
                ByteBuffer a16 = w.this.f122355b.a(v8Array.getInteger(0), false);
                if (a16 == null) {
                    com.tencent.luggage.wxa.tn.w.f("V8DirectApiBuffer", "getNativeBuffer bb null");
                    return null;
                }
                return this.f122357a.j().newV8ArrayBuffer(a16);
            }
            com.tencent.luggage.wxa.tn.w.f("V8DirectApiBuffer", "getNativeBuffer invalid parameters");
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements JavaVoidCallback {
        public c() {
        }

        @Override // com.eclipsesource.mmv8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array.length() >= 2 && v8Array.getType(0) == 1 && v8Array.getType(1) == 10) {
                com.tencent.luggage.wxa.tn.w.a("V8DirectApiBuffer", "setNativeBuffer, id:%d", Integer.valueOf(v8Array.getInteger(0)));
                V8ArrayBuffer v8ArrayBuffer = (V8ArrayBuffer) v8Array.get(1);
                if (v8ArrayBuffer != null) {
                    w.this.f122355b.a(v8Array.getInteger(0), v8ArrayBuffer.getBackingStore());
                    v8ArrayBuffer.release();
                    return;
                } else {
                    com.tencent.luggage.wxa.tn.w.f("V8DirectApiBuffer", "setNativeBuffer buffer null");
                    return;
                }
            }
            com.tencent.luggage.wxa.tn.w.f("V8DirectApiBuffer", "setNativeBuffer invalid parameters");
        }
    }

    public w(h hVar) {
        this.f122355b = hVar;
    }

    @Override // com.tencent.luggage.wxa.b9.v
    public void a() {
    }

    @Override // com.tencent.luggage.wxa.b9.v
    public void a(t tVar, V8Object v8Object) {
        v8Object.registerJavaMethod(new a(), "getNativeBufferId");
        v8Object.registerJavaMethod(new b(tVar), "getNativeBuffer");
        v8Object.registerJavaMethod(new c(), "setNativeBuffer");
    }
}
