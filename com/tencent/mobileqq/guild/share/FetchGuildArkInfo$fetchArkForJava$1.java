package com.tencent.mobileqq.guild.share;

import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.share.FetchGuildArkInfo$fetchArkForJava$1", f = "FetchGuildArkInfo.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class FetchGuildArkInfo$fetchArkForJava$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<b, Unit> $cb;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FetchGuildArkInfo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FetchGuildArkInfo$fetchArkForJava$1(FetchGuildArkInfo fetchGuildArkInfo, Function1<? super b, Unit> function1, Continuation<? super FetchGuildArkInfo$fetchArkForJava$1> continuation) {
        super(2, continuation);
        this.this$0 = fetchGuildArkInfo;
        this.$cb = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FetchGuildArkInfo$fetchArkForJava$1 fetchGuildArkInfo$fetchArkForJava$1 = new FetchGuildArkInfo$fetchArkForJava$1(this.this$0, this.$cb, continuation);
        fetchGuildArkInfo$fetchArkForJava$1.L$0 = obj;
        return fetchGuildArkInfo$fetchArkForJava$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object m476constructorimpl;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                FetchGuildArkInfo fetchGuildArkInfo = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                this.label = 1;
                obj = fetchGuildArkInfo.f(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            m476constructorimpl = Result.m476constructorimpl((b) obj);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Function1<b, Unit> function1 = this.$cb;
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "fetchArkForJava, failed " + m479exceptionOrNullimpl;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("FetchGuildArkInfo", 1, (String) it.next(), null);
            }
            function1.invoke(null);
        }
        Function1<b, Unit> function12 = this.$cb;
        if (Result.m483isSuccessimpl(m476constructorimpl)) {
            function12.invoke((b) m476constructorimpl);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FetchGuildArkInfo$fetchArkForJava$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
