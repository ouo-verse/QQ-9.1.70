package com.tencent.luggage.wxa.x3;

import android.os.Message;
import com.tencent.luggage.wxa.hn.og;
import com.tencent.luggage.wxa.hn.pg;
import com.tencent.luggage.wxa.hn.s8;
import com.tencent.luggage.wxa.hn.t4;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f144579a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static int f144580b;

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentLinkedQueue f144581c;

    /* renamed from: d, reason: collision with root package name */
    public static final e f144582d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends com.tencent.luggage.wxa.n3.h {

        /* renamed from: e, reason: collision with root package name */
        public final String f144583e;

        /* renamed from: f, reason: collision with root package name */
        public Class f144584f;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.x3.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C6899a implements com.tencent.luggage.wxa.uo.b {

            /* renamed from: b, reason: collision with root package name */
            public static final C6899a f144585b = new C6899a();

            @Override // com.tencent.luggage.wxa.uo.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final pg call(pg pgVar) {
                i.f144579a.a(pgVar.f128458e * 1000);
                w.d("WxaIDKeyReportService", "report cgi: ret:" + pgVar.f128743d.f127731d + " errMsg:" + pgVar.f128743d.f127732e);
                return pgVar;
            }
        }

        public a(LinkedList reportList) {
            Intrinsics.checkNotNullParameter(reportList, "reportList");
            og ogVar = new og();
            ogVar.f128376e.addAll(reportList);
            a(ogVar);
            this.f144583e = "/cgi-bin/mmbiz-bin/wxaruntime/batchreport";
            this.f144584f = pg.class;
        }

        @Override // com.tencent.luggage.wxa.n3.h
        public Class d() {
            return this.f144584f;
        }

        @Override // com.tencent.luggage.wxa.n3.e
        public String a() {
            return this.f144583e;
        }

        @Override // com.tencent.luggage.wxa.n3.e
        public com.tencent.luggage.wxa.xo.d a(String str, og request, Class clazz) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            com.tencent.luggage.wxa.xo.d b16 = super.a(str, (s8) request, clazz).b(C6899a.f144585b);
            Intrinsics.checkNotNullExpressionValue(b16, "super.runPipeline(appId,\u2026next it\n                }");
            return b16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f144586a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f144587b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f144587b = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.f144587b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f144586a;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Function1 function1 = this.f144587b;
                this.f144586a = 1;
                obj = function1.invoke(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f144588a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f144589b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f144589b = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new c(this.f144589b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f144588a;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Function1 function1 = this.f144589b;
                this.f144588a = 1;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d extends SuspendLambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public int f144590a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinkedList f144591b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(LinkedList linkedList, Continuation continuation) {
            super(1, continuation);
            this.f144591b = linkedList;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation continuation) {
            return ((d) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new d(this.f144591b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f144590a;
            try {
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    a aVar = new a(this.f144591b);
                    this.f144590a = 1;
                    obj = aVar.a(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj;
            } catch (Exception e16) {
                w.a("WxaIDKeyReportService", e16, "report fail", new Object[0]);
                return Unit.INSTANCE;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class e extends b0 {
        public e() {
            super("WxaIDKeyReportService");
            a(false);
        }

        @Override // com.tencent.luggage.wxa.tn.b0
        public void d(Message message) {
            int i3;
            if (message != null) {
                i3 = message.what;
            } else {
                i3 = 0;
            }
            if (i3 == 1) {
                i.f144579a.a(false);
            }
        }
    }

    static {
        f0 e16 = f0.e("WxaIDKeyReportService");
        int i3 = 60000;
        if (e16 != null) {
            i3 = e16.a("REPORT_INTERVAL", 60000);
        }
        f144580b = i3;
        f144581c = new ConcurrentLinkedQueue();
        f144582d = new e();
    }

    public final void b() {
        e eVar = f144582d;
        if (!eVar.a(1)) {
            eVar.a(1, f144580b);
        }
    }

    public final void a(int i3) {
        f144580b = i3;
        f0 e16 = f0.e("WxaIDKeyReportService");
        if (e16 != null) {
            e16.b("REPORT_INTERVAL", i3);
        }
        e eVar = f144582d;
        eVar.c(1);
        if (!f144581c.isEmpty()) {
            eVar.a(1, i3);
        }
    }

    public static /* synthetic */ void a(i iVar, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 4) != 0) {
            i17 = 1;
        }
        iVar.a(i3, i16, i17);
    }

    public final void a(int i3, int i16, int i17) {
        if (w.d() <= 1) {
            w.d("WxaIDKeyReportService", "idkeyStat(id:" + i3 + ", key:" + i16 + ", value:" + i17 + ')');
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = f144581c;
        t4 t4Var = new t4();
        t4Var.f128727d = i3;
        t4Var.f128728e = i16;
        t4Var.f128729f = i17;
        concurrentLinkedQueue.add(t4Var);
        b();
    }

    public final void a() {
        f144582d.a((Object) null);
        a(true);
    }

    public final void a(boolean z16) {
        ConcurrentLinkedQueue concurrentLinkedQueue = f144581c;
        LinkedList linkedList = new LinkedList(concurrentLinkedQueue);
        concurrentLinkedQueue.clear();
        d dVar = new d(linkedList, null);
        if (z16) {
            BuildersKt__BuildersKt.runBlocking$default(null, new b(dVar, null), 1, null);
        } else {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new c(dVar, null), 2, null);
        }
    }
}
