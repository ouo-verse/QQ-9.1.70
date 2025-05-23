package com.tencent.luggage.wxa.oc;

import android.util.SparseIntArray;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.hn.h0;
import com.tencent.luggage.wxa.hn.k1;
import com.tencent.luggage.wxa.hn.rh;
import com.tencent.luggage.wxa.hn.s7;
import com.tencent.luggage.wxa.hn.sh;
import com.tencent.luggage.wxa.hn.ta;
import com.tencent.luggage.wxa.ii.j;
import com.tencent.luggage.wxa.ii.k;
import com.tencent.luggage.wxa.j4.k;
import com.tencent.luggage.wxa.mc.g0;
import com.tencent.luggage.wxa.mc.j0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f136284a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f136285b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentSkipListSet f136286c = new ConcurrentSkipListSet(new g());

    /* renamed from: d, reason: collision with root package name */
    public static final f f136287d = new f();

    /* renamed from: e, reason: collision with root package name */
    public static final CoroutineScope f136288e = CoroutineScopeKt.MainScope();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Exception {
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.oc.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6543b {

        /* renamed from: a, reason: collision with root package name */
        public static final C6543b f136289a = new C6543b();

        /* renamed from: b, reason: collision with root package name */
        public static final LinkedBlockingQueue f136290b = new LinkedBlockingQueue();

        /* renamed from: c, reason: collision with root package name */
        public static final AtomicInteger f136291c = new AtomicInteger(0);

        /* renamed from: d, reason: collision with root package name */
        public static final ConcurrentHashMap f136292d = new ConcurrentHashMap();

        /* renamed from: e, reason: collision with root package name */
        public static final ConcurrentHashMap f136293e = new ConcurrentHashMap();

        /* renamed from: f, reason: collision with root package name */
        public static final ConcurrentHashMap f136294f = new ConcurrentHashMap();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.oc.b$b$a */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k.d f136295a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(k.d dVar) {
                super(1);
                this.f136295a = dVar;
            }

            public final void a(k.e it) {
                Intrinsics.checkNotNullParameter(it, "it");
                C6543b.f136289a.a(this.f136295a, it, true);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((k.e) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.oc.b$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6544b extends Lambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k.d f136296a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6544b(k.d dVar) {
                super(2);
                this.f136296a = dVar;
            }

            public final void a(k.a aVar, Throwable th5) {
                Intrinsics.checkNotNullParameter(aVar, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(th5, "<anonymous parameter 1>");
                C6543b.f136289a.a(this.f136296a, (k.e) null, false);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((k.a) obj, (Throwable) obj2);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.oc.b$b$c */
        /* loaded from: classes8.dex */
        public static final class c extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public static final c f136297a = new c();

            public c() {
                super(1);
            }

            public final void a(g0 it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((g0) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.oc.b$b$d */
        /* loaded from: classes8.dex */
        public static final class d extends Lambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CancellableContinuation f136298a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(CancellableContinuation cancellableContinuation) {
                super(2);
                this.f136298a = cancellableContinuation;
            }

            public final void a(boolean z16, k.e eVar) {
                if (this.f136298a.isActive()) {
                    if (z16) {
                        CancellableContinuation cancellableContinuation = this.f136298a;
                        Result.Companion companion = Result.INSTANCE;
                        Intrinsics.checkNotNull(eVar);
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(eVar));
                        return;
                    }
                    CancellableContinuation cancellableContinuation2 = this.f136298a;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new a())));
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a(((Boolean) obj).booleanValue(), (k.e) obj2);
                return Unit.INSTANCE;
            }
        }

        public final int b() {
            return f136290b.size() + f136292d.size();
        }

        public final long[] c() {
            LinkedList linkedList = new LinkedList(f136292d.values());
            int size = linkedList.size() + new LinkedList(f136290b).size();
            long[] jArr = new long[size];
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                jArr[i16] = 0;
            }
            for (Object obj : linkedList) {
                int i17 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                jArr[i3] = ((k) obj).a();
                i3 = i17;
            }
            return jArr;
        }

        public final boolean a(k.d request, Function2 onCompleted) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(onCompleted, "onCompleted");
            f136293e.put(request, onCompleted);
            k.d dVar = request;
            do {
                AtomicInteger atomicInteger = f136291c;
                if (atomicInteger.incrementAndGet() <= 4) {
                    a(request);
                    return true;
                }
                LinkedBlockingQueue linkedBlockingQueue = f136290b;
                linkedBlockingQueue.offer(dVar);
                if (atomicInteger.decrementAndGet() >= 4) {
                    return false;
                }
                dVar = (k.d) linkedBlockingQueue.poll();
            } while (dVar != null);
            return false;
        }

        public final void a(k.d dVar) {
            k a16;
            Function0 function0 = (Function0) f136294f.remove(dVar);
            if (function0 != null) {
                function0.invoke();
            }
            k.b bVar = k.f130516a;
            a aVar = new a(dVar);
            C6544b c6544b = new C6544b(dVar);
            c cVar = c.f136297a;
            k1 k1Var = new k1();
            k1Var.f127976d = 0;
            k1Var.f127977e = false;
            k1Var.f127978f = 1;
            Unit unit = Unit.INSTANCE;
            a16 = bVar.a(dVar, aVar, c6544b, (r20 & 8) != 0 ? k.b.a.f130530a : cVar, (r20 & 16) != 0 ? j.f130505a : null, (r20 & 32) != 0 ? 0 : 10, k1Var, (r20 & 128) != 0 ? null : null);
            f136292d.put(dVar, a16);
        }

        public final void a(k.d dVar, k.e eVar, boolean z16) {
            sh shVar;
            Function2 function2 = (Function2) f136293e.remove(dVar);
            if (function2 != null) {
                function2.invoke(Boolean.valueOf(z16), eVar);
            }
            if (((k) f136292d.remove(dVar)) != null && (shVar = (sh) b.f136285b.remove(dVar)) != null) {
                com.tencent.luggage.wxa.oc.c cVar = new com.tencent.luggage.wxa.oc.c();
                n0 a16 = o0.a().a(dVar.a(), "username");
                cVar.e(a16 != null ? a16.f138465d : null);
                cVar.b(dVar.a());
                k.g g16 = dVar.g();
                cVar.a((g16 instanceof k.g.c ? (k.g.c) g16 : null) != null ? r2.a() : 0);
                cVar.c(0L);
                cVar.e(com.tencent.luggage.wxa.ek.a.a());
                cVar.d(z16 ? 1L : 0L);
                cVar.h(1L);
                cVar.b(shVar.f128692d.f128460e);
                cVar.g(shVar.f128692d.f128461f);
                cVar.f(shVar.f128700l);
                cVar.c(shVar.f128699k);
                cVar.d(dVar.f());
                cVar.c();
            }
            f136291c.decrementAndGet();
            k.d dVar2 = (k.d) f136290b.poll();
            if (dVar2 != null) {
                f136289a.a(dVar2);
            }
        }

        public final Object a(k.d dVar, Function0 function0, Continuation continuation) {
            Continuation intercepted;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            f136294f.put(dVar, function0);
            a(dVar, new d(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final String f136299a;

        /* renamed from: b, reason: collision with root package name */
        public final String f136300b;

        public c(String appId, String str) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            this.f136299a = appId;
            this.f136300b = str;
        }

        public final String a() {
            return this.f136299a;
        }

        public final String b() {
            return this.f136300b;
        }

        public boolean equals(Object obj) {
            Class<?> cls;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                cls = obj.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(c.class, cls)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.predownload.PreDownloadService.PrefetchRequest");
            c cVar = (c) obj;
            if (Intrinsics.areEqual(this.f136299a, cVar.f136299a) && Intrinsics.areEqual(this.f136300b, cVar.f136300b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3;
            int hashCode = this.f136299a.hashCode() * 31;
            String str = this.f136300b;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            return hashCode + i3;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return hashCode() - other.hashCode();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum d {
        Unknown,
        Fail_SvrConnectFail,
        Fail_SvrRetFail,
        Fail_SvrRetListEmpty,
        Fail_PkgDownloadFail,
        Success_AllPkgDownloaded,
        Success_NoNeedGetCode,
        Success_AllPkgDownloadedPrevious
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends com.tencent.luggage.wxa.tk.h {
        @Override // com.tencent.luggage.wxa.tk.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(c cVar, Function1 function1) {
            if (cVar != null && function1 != null) {
                return super.b(cVar, function1);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c o16, c o26) {
            Intrinsics.checkNotNullParameter(o16, "o1");
            Intrinsics.checkNotNullParameter(o26, "o2");
            if (Intrinsics.areEqual(o16, o26)) {
                return 0;
            }
            return o16.hashCode() - o26.hashCode();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public Object f136311a;

        /* renamed from: b, reason: collision with root package name */
        public Object f136312b;

        /* renamed from: c, reason: collision with root package name */
        public Object f136313c;

        /* renamed from: d, reason: collision with root package name */
        public int f136314d;

        /* renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f136315e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f136316f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f136317g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ c f136318h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ long f136319i;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f136320a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ta f136321b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ConcurrentLinkedQueue f136322c;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.oc.b$h$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6545a extends Lambda implements Function0 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ k.d f136323a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ sh f136324b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C6545a(k.d dVar, sh shVar) {
                    super(0);
                    this.f136323a = dVar;
                    this.f136324b = shVar;
                }

                public final void a() {
                    j0 a16 = j0.a();
                    String rVar = this.f136323a.c().toString();
                    sh shVar = this.f136324b;
                    a16.a(rVar, shVar.f128697i, shVar.f128698j);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ta taVar, ConcurrentLinkedQueue concurrentLinkedQueue, Continuation continuation) {
                super(2, continuation);
                this.f136321b = taVar;
                this.f136322c = concurrentLinkedQueue;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f136321b, this.f136322c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                sh shVar;
                Object a16;
                rh rhVar;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f136320a;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                        a16 = obj;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    ta taVar = this.f136321b;
                    if (taVar != null && (rhVar = taVar.f128747e) != null) {
                        shVar = rhVar.f128631e;
                    } else {
                        shVar = null;
                    }
                    if (shVar == null) {
                        return Unit.INSTANCE;
                    }
                    String str = taVar.f128748f;
                    Intrinsics.checkNotNullExpressionValue(str, "singleRespInfo.Appid");
                    k.d dVar = new k.d(str, shVar.f128699k, shVar.f128700l, 0, new k.g.c(shVar.f128697i, 0L, 2, null), true, k.b.f130850a.b());
                    b.f136285b.put(dVar, shVar);
                    C6543b c6543b = C6543b.f136289a;
                    C6545a c6545a = new C6545a(dVar, shVar);
                    this.f136320a = 1;
                    a16 = c6543b.a(dVar, c6545a, this);
                    if (a16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.f136322c.offer((k.e) a16);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, String str2, c cVar, long j3, Continuation continuation) {
            super(2, continuation);
            this.f136316f = str;
            this.f136317g = str2;
            this.f136318h = cVar;
            this.f136319i = j3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            h hVar = new h(this.f136316f, this.f136317g, this.f136318h, this.f136319i, continuation);
            hVar.f136315e = obj;
            return hVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x011e A[Catch: all -> 0x0033, Exception -> 0x0036, Merged into TryCatch #0 {all -> 0x0033, Exception -> 0x0036, blocks: (B:7:0x002e, B:9:0x0118, B:11:0x011e, B:18:0x0136, B:20:0x0176, B:21:0x0182, B:23:0x0188, B:26:0x0196, B:27:0x0199, B:29:0x019d, B:30:0x01a7, B:70:0x01e5, B:72:0x020e, B:73:0x0221, B:76:0x0218, B:41:0x0069, B:43:0x0075, B:45:0x007b, B:49:0x0084, B:50:0x0093, B:53:0x008c, B:55:0x00c8, B:56:0x00da, B:58:0x00e0, B:60:0x010e), top: B:2:0x0018 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0176 A[Catch: all -> 0x0033, Exception -> 0x0036, Merged into TryCatch #0 {all -> 0x0033, Exception -> 0x0036, blocks: (B:7:0x002e, B:9:0x0118, B:11:0x011e, B:18:0x0136, B:20:0x0176, B:21:0x0182, B:23:0x0188, B:26:0x0196, B:27:0x0199, B:29:0x019d, B:30:0x01a7, B:70:0x01e5, B:72:0x020e, B:73:0x0221, B:76:0x0218, B:41:0x0069, B:43:0x0075, B:45:0x007b, B:49:0x0084, B:50:0x0093, B:53:0x008c, B:55:0x00c8, B:56:0x00da, B:58:0x00e0, B:60:0x010e), top: B:2:0x0018 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            CoroutineScope coroutineScope;
            Object a16;
            int collectionSizeOrDefault;
            CoroutineScope coroutineScope2;
            Iterator it;
            ConcurrentLinkedQueue concurrentLinkedQueue;
            LinkedList linkedList;
            Deferred async$default;
            boolean z16;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f136314d;
            int i16 = 1;
            try {
                try {
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                it = (Iterator) this.f136313c;
                                concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f136312b;
                                linkedList = (LinkedList) this.f136311a;
                                coroutineScope2 = (CoroutineScope) this.f136315e;
                                ResultKt.throwOnFailure(obj);
                                while (it.hasNext()) {
                                    Deferred deferred = (Deferred) it.next();
                                    this.f136315e = coroutineScope2;
                                    this.f136311a = linkedList;
                                    this.f136312b = concurrentLinkedQueue;
                                    this.f136313c = it;
                                    this.f136314d = 2;
                                    if (deferred.await(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                w.d("Luggage.WXA.PreDownloadService", "prefetchForAppIdAndPath(appId:" + this.f136316f + ", path:" + this.f136317g + "), await completed, succeed.size:" + concurrentLinkedQueue.size() + ", cmdList.size:" + linkedList.size());
                                if (concurrentLinkedQueue.size() == linkedList.size()) {
                                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                                    booleanRef.element = true;
                                    Iterator it5 = concurrentLinkedQueue.iterator();
                                    while (true) {
                                        if (!it5.hasNext()) {
                                            break;
                                        }
                                        if (((k.e) it5.next()).b() == k.f.REMOTE) {
                                            booleanRef.element = false;
                                            break;
                                        }
                                    }
                                    if (booleanRef.element) {
                                        b.f136284a.a(this.f136318h, d.Success_AllPkgDownloadedPrevious);
                                    } else {
                                        b.f136284a.a(this.f136318h, d.Success_AllPkgDownloaded);
                                    }
                                }
                                w.d("Luggage.WXA.PreDownloadService", "prefetchForAppIdAndPath(appId:" + this.f136316f + ", path:" + this.f136317g + "), cost:" + (w0.a() - this.f136319i));
                                b.f136286c.remove(this.f136318h);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        coroutineScope = (CoroutineScope) this.f136315e;
                        ResultKt.throwOnFailure(obj);
                        a16 = obj;
                    } else {
                        ResultKt.throwOnFailure(obj);
                        coroutineScope = (CoroutineScope) this.f136315e;
                        com.tencent.luggage.wxa.oc.a aVar = new com.tencent.luggage.wxa.oc.a(this.f136316f, this.f136317g, 10);
                        this.f136315e = coroutineScope;
                        this.f136314d = 1;
                        a16 = aVar.a(this);
                        if (a16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    s7 s7Var = (s7) a16;
                    b bVar = b.f136284a;
                    LinkedList a17 = bVar.a(s7Var);
                    if (a17.isEmpty()) {
                        h0 e16 = s7Var.e();
                        if (e16 != null && e16.f127731d == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            bVar.a(this.f136318h, d.Fail_SvrRetFail);
                        } else {
                            bVar.a(this.f136318h, d.Fail_SvrRetListEmpty);
                        }
                        return Unit.INSTANCE;
                    }
                    ConcurrentLinkedQueue concurrentLinkedQueue2 = new ConcurrentLinkedQueue();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a17, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it6 = a17.iterator();
                    while (it6.hasNext()) {
                        ArrayList arrayList2 = arrayList;
                        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, i16, (Object) null)), null, new a((ta) it6.next(), concurrentLinkedQueue2, null), 2, null);
                        arrayList2.add(async$default);
                        arrayList = arrayList2;
                        a17 = a17;
                        i16 = 1;
                    }
                    coroutineScope2 = coroutineScope;
                    it = arrayList.iterator();
                    concurrentLinkedQueue = concurrentLinkedQueue2;
                    linkedList = a17;
                    while (it.hasNext()) {
                    }
                    w.d("Luggage.WXA.PreDownloadService", "prefetchForAppIdAndPath(appId:" + this.f136316f + ", path:" + this.f136317g + "), await completed, succeed.size:" + concurrentLinkedQueue.size() + ", cmdList.size:" + linkedList.size());
                    if (concurrentLinkedQueue.size() == linkedList.size()) {
                    }
                    w.d("Luggage.WXA.PreDownloadService", "prefetchForAppIdAndPath(appId:" + this.f136316f + ", path:" + this.f136317g + "), cost:" + (w0.a() - this.f136319i));
                    b.f136286c.remove(this.f136318h);
                    return Unit.INSTANCE;
                } catch (com.tencent.luggage.wxa.bj.a unused) {
                    b.f136284a.a(this.f136318h, d.Fail_SvrConnectFail);
                    return Unit.INSTANCE;
                }
            } catch (Exception e17) {
                w.b("Luggage.WXA.PreDownloadService", "prefetchForAppIdAndPath(appId:" + this.f136316f + ", path:" + this.f136317g + "), get exception:" + e17);
                if (e17 instanceof a) {
                    b.f136284a.a(this.f136318h, d.Fail_PkgDownloadFail);
                } else {
                    b.f136284a.a(this.f136318h, d.Unknown);
                }
                return Unit.INSTANCE;
            } finally {
                w.d("Luggage.WXA.PreDownloadService", "prefetchForAppIdAndPath(appId:" + this.f136316f + ", path:" + this.f136317g + "), cost:" + (w0.a() - this.f136319i));
                b.f136286c.remove(this.f136318h);
            }
        }
    }

    public final int c() {
        return C6543b.f136289a.b();
    }

    public final long[] d() {
        return C6543b.f136289a.c();
    }

    public final void a(c cVar, d dVar) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("invokeCallback, request(appId:");
        sb5.append(cVar.a());
        sb5.append(", path:");
        String b16 = cVar.b();
        if (b16 == null) {
            b16 = "";
        }
        sb5.append(b16);
        sb5.append("), code:");
        sb5.append(dVar.name());
        w.d("Luggage.WXA.PreDownloadService", sb5.toString());
        Set b17 = f136287d.b(cVar);
        if (b17 != null) {
            Iterator it = b17.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(dVar);
            }
        }
    }

    public final LinkedList a(s7 s7Var) {
        ta taVar;
        LinkedList<ta> linkedList = new LinkedList();
        if (s7Var != null && (taVar = s7Var.f128669e) != null) {
            linkedList.add(taVar);
        }
        List list = s7Var != null ? s7Var.f128670f : null;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        linkedList.addAll(list);
        e.a((List) linkedList, false);
        LinkedList linkedList2 = new LinkedList();
        for (ta taVar2 : linkedList) {
            rh rhVar = taVar2.f128747e;
            if ((rhVar != null ? rhVar.f128631e : null) != null) {
                linkedList2.add(taVar2);
            }
        }
        return linkedList2;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public static final e f136310a = new e();

        /* JADX WARN: Removed duplicated region for block: B:54:0x00a8 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x006f A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void a(List cmdList, boolean z16) {
            sh shVar;
            boolean z17;
            sh shVar2;
            sh shVar3;
            Intrinsics.checkNotNullParameter(cmdList, "cmdList");
            if (z16) {
                Iterator it = cmdList.iterator();
                while (it.hasNext()) {
                    rh rhVar = ((ta) it.next()).f128747e;
                    if (rhVar != null && (shVar3 = rhVar.f128631e) != null && shVar3.f128700l != 6) {
                        rhVar.f128631e = null;
                    }
                }
                return;
            }
            SparseIntArray sparseIntArray = new SparseIntArray();
            Iterator it5 = cmdList.iterator();
            while (it5.hasNext()) {
                ta taVar = (ta) it5.next();
                rh rhVar2 = taVar.f128747e;
                if (rhVar2 != null && (shVar2 = rhVar2.f128631e) != null) {
                    int i3 = shVar2.f128700l;
                    String str = taVar.f128748f;
                    Intrinsics.checkNotNullExpressionValue(str, "info.Appid");
                    rh rhVar3 = taVar.f128747e;
                    Intrinsics.checkNotNull(rhVar3);
                    sh shVar4 = rhVar3.f128631e;
                    Intrinsics.checkNotNull(shVar4);
                    int a16 = a(str, shVar4);
                    sparseIntArray.put(a16, Math.max(i3, sparseIntArray.get(a16, -1)));
                }
            }
            Iterator it6 = cmdList.iterator();
            while (it6.hasNext()) {
                ta taVar2 = (ta) it6.next();
                rh rhVar4 = taVar2.f128747e;
                if (rhVar4 != null && (shVar = rhVar4.f128631e) != null) {
                    int i16 = shVar.f128700l;
                    if (i16 <= 23) {
                        String str2 = taVar2.f128748f;
                        Intrinsics.checkNotNullExpressionValue(str2, "info.Appid");
                        rh rhVar5 = taVar2.f128747e;
                        Intrinsics.checkNotNull(rhVar5);
                        sh shVar5 = rhVar5.f128631e;
                        Intrinsics.checkNotNull(shVar5);
                        if (i16 >= sparseIntArray.get(a(str2, shVar5), -1)) {
                            z17 = false;
                            if (!z17) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("preprocessGetCodeList remove cmd for appId:");
                                sb5.append(taVar2.f128748f);
                                sb5.append(", key:");
                                rh rhVar6 = taVar2.f128747e;
                                Intrinsics.checkNotNull(rhVar6);
                                sh shVar6 = rhVar6.f128631e;
                                Intrinsics.checkNotNull(shVar6);
                                sb5.append(shVar6.f128699k);
                                sb5.append(", type:");
                                sb5.append(i16);
                                w.d("Luggage.WXA.PreDownloadService.Utils", sb5.toString());
                                taVar2.f128747e.f128631e = null;
                            }
                        }
                    }
                    z17 = true;
                    if (!z17) {
                    }
                }
            }
        }

        public static final int a(String str, sh shVar) {
            boolean contains;
            int i3 = shVar.f128700l;
            int[] WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES = com.tencent.luggage.wxa.ip.a.f130735e;
            Intrinsics.checkNotNullExpressionValue(WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES, "WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES");
            contains = ArraysKt___ArraysKt.contains(WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES, i3);
            if (!contains) {
                str = str + '$' + shVar.f128699k;
            }
            return str.hashCode();
        }
    }

    public final void a(String str, String str2, Function1 function1) {
        if (str == null) {
            return;
        }
        c cVar = new c(str, str2);
        try {
            if (f136286c.add(cVar)) {
                f136287d.b(cVar, function1);
                BuildersKt__Builders_commonKt.launch$default(f136288e, Dispatchers.getIO(), null, new h(str, str2, cVar, w0.a(), null), 2, null);
            }
        } finally {
            f136287d.b(cVar, function1);
        }
    }
}
