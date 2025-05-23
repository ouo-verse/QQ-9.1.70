package com.tencent.luggage.wxa.w6;

import com.tencent.luggage.wxa.ae.l;
import com.tencent.luggage.wxa.e7.a;
import com.tencent.luggage.wxa.ic.d;
import com.tencent.luggage.wxa.n3.i;
import com.tencent.luggage.wxa.tj.e;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends l {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.w6.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6866a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f144096a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f144097b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f144098c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f144099d;

        public C6866a(d dVar, int i3, CancellableContinuation cancellableContinuation, a aVar) {
            this.f144096a = dVar;
            this.f144097b = i3;
            this.f144098c = cancellableContinuation;
            this.f144099d = aVar;
        }

        @Override // com.tencent.luggage.wxa.e7.a.b
        public void a() {
        }

        @Override // com.tencent.luggage.wxa.e7.a.b
        public void a(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.f144096a.a(this.f144097b, message);
            CancellableContinuation cancellableContinuation = this.f144098c;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }

        @Override // com.tencent.luggage.wxa.e7.a.b
        public void a(Object obj) {
            String str;
            if (obj instanceof Throwable) {
                str = "fail " + ((Throwable) obj).getMessage();
            } else {
                str = "fail " + obj;
            }
            this.f144096a.a(this.f144097b, this.f144099d.makeReturnJson(str));
            CancellableContinuation cancellableContinuation = this.f144098c;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }

        @Override // com.tencent.luggage.wxa.e7.a.b
        public void b() {
        }
    }

    @Override // com.tencent.luggage.wxa.ae.l
    public Object a(d dVar, JSONObject jSONObject, JSONObject jSONObject2, int i3, Object obj, Continuation continuation) {
        Continuation intercepted;
        String str;
        String str2;
        Object coroutine_suspended;
        if (dVar == null) {
            return Boxing.boxBoolean(false);
        }
        if (obj instanceof i) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            com.tencent.luggage.wxa.e7.a aVar = com.tencent.luggage.wxa.e7.a.f124576a;
            String name = getName();
            Intrinsics.checkNotNullExpressionValue(name, "this.name");
            if (jSONObject != null) {
                str = jSONObject.toString();
            } else {
                str = null;
            }
            if (jSONObject2 != null) {
                str2 = jSONObject2.toString();
            } else {
                str2 = null;
            }
            aVar.a(new e(dVar, name, str, str2, i3), new C6866a(dVar, i3, cancellableContinuationImpl, this), obj);
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return Boxing.boxBoolean(false);
    }
}
