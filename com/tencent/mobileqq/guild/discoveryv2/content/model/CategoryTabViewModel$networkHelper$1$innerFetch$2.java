package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.guild.discoveryv2.net.NetTransaction;
import com.tencent.mobileqq.qqguildsdk.data.genc.bg;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/bg;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.model.CategoryTabViewModel$networkHelper$1$innerFetch$2", f = "CategoryTabViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class CategoryTabViewModel$networkHelper$1$innerFetch$2 extends SuspendLambda implements Function2<NetTransaction<bg, ? extends a>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CategoryTabViewModel$networkHelper$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryTabViewModel$networkHelper$1$innerFetch$2(CategoryTabViewModel$networkHelper$1 categoryTabViewModel$networkHelper$1, Continuation<? super CategoryTabViewModel$networkHelper$1$innerFetch$2> continuation) {
        super(2, continuation);
        this.this$0 = categoryTabViewModel$networkHelper$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CategoryTabViewModel$networkHelper$1$innerFetch$2 categoryTabViewModel$networkHelper$1$innerFetch$2 = new CategoryTabViewModel$networkHelper$1$innerFetch$2(this.this$0, continuation);
        categoryTabViewModel$networkHelper$1$innerFetch$2.L$0 = obj;
        return categoryTabViewModel$networkHelper$1$innerFetch$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull NetTransaction<bg, ? extends a> netTransaction, @Nullable Continuation<? super Unit> continuation) {
        return ((CategoryTabViewModel$networkHelper$1$innerFetch$2) create(netTransaction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.f((NetTransaction) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
