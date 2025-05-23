package com.tencent.luggage.wxa.bj;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f122923a = new h();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f122924a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f122925b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f122926c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bj.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6076a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f122927a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f122928b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6076a(String str, Continuation continuation) {
                super(2, continuation);
                this.f122928b = str;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C6076a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C6076a(this.f122928b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f122927a;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    h hVar = h.f122923a;
                    String str = this.f122928b;
                    this.f122927a = 1;
                    obj = hVar.a(str, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List list, Continuation continuation) {
            super(2, continuation);
            this.f122926c = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            a aVar = new a(this.f122926c, continuation);
            aVar.f122925b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            int collectionSizeOrDefault;
            Iterator it;
            Deferred async$default;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f122924a;
            if (i3 != 0) {
                if (i3 == 1) {
                    it = (Iterator) this.f122925b;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f122925b;
                List list = this.f122926c;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator it5 = list.iterator();
                while (it5.hasNext()) {
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new C6076a((String) it5.next(), null), 2, null);
                    arrayList.add(async$default);
                }
                it = arrayList.iterator();
            }
            while (it.hasNext()) {
                Deferred deferred = (Deferred) it.next();
                this.f122925b = it;
                this.f122924a = 1;
                if (deferred.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final void a(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new a(list, null), 2, null);
    }

    public final Object a(String str, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        boolean z16 = true;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        long a16 = w0.a();
        try {
            w.d("Luggage.WxaPrefetchDNSDomainsUtils", "prefetchForDomain(" + str + "):" + InetAddress.getByName(str) + " cost:" + w0.e(a16));
        } catch (Exception e16) {
            w.d("Luggage.WxaPrefetchDNSDomainsUtils", "prefetchForDomain(" + str + "):failed with exception:" + e16);
            z16 = false;
        }
        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(z16)));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
