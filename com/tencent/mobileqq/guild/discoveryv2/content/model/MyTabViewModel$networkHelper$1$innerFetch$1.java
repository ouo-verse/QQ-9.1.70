package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.guild.discoveryv2.net.NetTransaction;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.br;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/br;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/c;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.model.MyTabViewModel$networkHelper$1$innerFetch$1", f = "MyTabViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class MyTabViewModel$networkHelper$1$innerFetch$1 extends SuspendLambda implements Function2<NetTransaction<br, ? extends c>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MyTabViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyTabViewModel$networkHelper$1$innerFetch$1(MyTabViewModel myTabViewModel, Continuation<? super MyTabViewModel$networkHelper$1$innerFetch$1> continuation) {
        super(2, continuation);
        this.this$0 = myTabViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MyTabViewModel$networkHelper$1$innerFetch$1 myTabViewModel$networkHelper$1$innerFetch$1 = new MyTabViewModel$networkHelper$1$innerFetch$1(this.this$0, continuation);
        myTabViewModel$networkHelper$1$innerFetch$1.L$0 = obj;
        return myTabViewModel$networkHelper$1$innerFetch$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull NetTransaction<br, ? extends c> netTransaction, @Nullable Continuation<? super Unit> continuation) {
        return ((MyTabViewModel$networkHelper$1$innerFetch$1) create(netTransaction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            NetTransaction netTransaction = (NetTransaction) this.L$0;
            Logger logger = Logger.f235387a;
            logger.d().i(this.this$0.getTag(), 1, netTransaction.toString());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
