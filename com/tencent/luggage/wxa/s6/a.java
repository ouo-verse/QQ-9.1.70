package com.tencent.luggage.wxa.s6;

import com.tencent.luggage.wxa.hn.a3;
import com.tencent.luggage.wxa.hn.b3;
import com.tencent.luggage.wxa.hn.df;
import com.tencent.luggage.wxa.hn.h0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.s6.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6705a extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f140070a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f140071b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6705a(String str, Continuation continuation) {
            super(2, continuation);
            this.f140071b = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C6705a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C6705a(this.f140071b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z16;
            double d16;
            h0 e16;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f140070a == 0) {
                ResultKt.throwOnFailure(obj);
                a3 a3Var = new a3();
                a3Var.f127259e = this.f140071b;
                b3 b3Var = (b3) ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo", null, a3Var, b3.class);
                if (b3Var != null && (e16 = b3Var.e()) != null && e16.f127731d == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return Boxing.boxDouble(-1.0d);
                }
                df dfVar = b3Var.f127323f;
                if (dfVar != null && !Intrinsics.areEqual(Boxing.boxDouble(dfVar.f127514d), -1.0d)) {
                    df dfVar2 = b3Var.f127323f;
                    if (dfVar2 != null) {
                        d16 = dfVar2.f127514d;
                    } else {
                        d16 = 0.0d;
                    }
                    return Boxing.boxDouble(d16);
                }
                return Boxing.boxDouble(-2.0d);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final Object a(String str, Continuation continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C6705a(str, null), continuation);
    }
}
