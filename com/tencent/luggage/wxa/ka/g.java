package com.tencent.luggage.wxa.ka;

import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00e6\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u00002\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005H\u0096\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\b\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\n\u00f8\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001\u00a8\u0006\u000b\u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/luggage/wxa/ka/g;", AegisLogger.INPUT, "Output", "Lcom/tencent/luggage/wxa/ka/f;", "data", "Lcom/tencent/luggage/wxa/ka/i;", "callback", "", "a", "(Ljava/lang/Object;Lcom/tencent/luggage/wxa/ka/i;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ipcinvoker_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public interface g<Input, Output> extends f {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ka.g$-CC, reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC<Input, Output> {
        public static void a(g gVar, Object obj, i iVar) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new a(iVar, gVar, obj, null), 3, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public Object f131820a;

        /* renamed from: b, reason: collision with root package name */
        public int f131821b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f131822c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f131823d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f131824e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, g gVar, Object obj, Continuation continuation) {
            super(2, continuation);
            this.f131822c = iVar;
            this.f131823d = gVar;
            this.f131824e = obj;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new a(this.f131822c, this.f131823d, this.f131824e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            i iVar;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f131821b;
            if (i3 != 0) {
                if (i3 == 1) {
                    iVar = (i) this.f131820a;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                i iVar2 = this.f131822c;
                if (iVar2 != null) {
                    g gVar = this.f131823d;
                    Object obj2 = this.f131824e;
                    this.f131820a = iVar2;
                    this.f131821b = 1;
                    Object a16 = gVar.a(obj2, this);
                    if (a16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    iVar = iVar2;
                    obj = a16;
                }
                return Unit.INSTANCE;
            }
            iVar.a(obj);
            return Unit.INSTANCE;
        }
    }

    Object a(Object obj, Continuation continuation);

    @Override // com.tencent.luggage.wxa.ka.f
    void a(Object data, i callback);
}
