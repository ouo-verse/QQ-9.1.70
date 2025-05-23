package com.tencent.luggage.wxa.b9;

import com.eclipsesource.mmv8.InSandboxByteBuffer;
import com.eclipsesource.mmv8.V8ArrayBuffer;
import com.eclipsesource.mmv8.V8Context;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public V8ArrayBuffer f122259a;

    /* renamed from: b, reason: collision with root package name */
    public InSandboxByteBuffer f122260b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f122261c;

    /* renamed from: d, reason: collision with root package name */
    public final n f122262d;

    /* renamed from: e, reason: collision with root package name */
    public final t f122263e;

    public p(t v85, V8ArrayBuffer v8Buffer, n nVar) {
        ByteBuffer backingStore;
        Intrinsics.checkNotNullParameter(v85, "v8");
        Intrinsics.checkNotNullParameter(v8Buffer, "v8Buffer");
        this.f122263e = v85;
        this.f122262d = nVar;
        this.f122259a = v8Buffer;
        if (nVar == n.R && !v8Buffer.getBackingStore().isReadOnly()) {
            ByteBuffer backingStore2 = v8Buffer.getBackingStore();
            if (backingStore2 != null) {
                backingStore = backingStore2.asReadOnlyBuffer();
            } else {
                backingStore = null;
            }
        } else {
            backingStore = v8Buffer.getBackingStore();
        }
        this.f122261c = backingStore;
    }

    public final V8ArrayBuffer a() {
        if (this.f122259a == null) {
            V8Context j3 = this.f122263e.j();
            InSandboxByteBuffer inSandboxByteBuffer = this.f122260b;
            Intrinsics.checkNotNull(inSandboxByteBuffer);
            this.f122259a = j3.newSharedV8ArrayBuffer(inSandboxByteBuffer);
        }
        V8ArrayBuffer v8ArrayBuffer = this.f122259a;
        Intrinsics.checkNotNull(v8ArrayBuffer);
        return v8ArrayBuffer;
    }
}
