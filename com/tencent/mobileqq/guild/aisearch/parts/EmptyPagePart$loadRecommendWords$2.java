package com.tencent.mobileqq.guild.aisearch.parts;

import com.tencent.mobileqq.guild.aisearch.models.AISearchRecommendRepository;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.parts.EmptyPagePart$loadRecommendWords$2", f = "EmptyPagePart.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class EmptyPagePart$loadRecommendWords$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EmptyPagePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyPagePart$loadRecommendWords$2(EmptyPagePart emptyPagePart, Continuation<? super EmptyPagePart$loadRecommendWords$2> continuation) {
        super(2, continuation);
        this.this$0 = emptyPagePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new EmptyPagePart$loadRecommendWords$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        a aVar;
        a aVar2;
        a aVar3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        a aVar4 = null;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                AISearchRecommendRepository aISearchRecommendRepository = AISearchRecommendRepository.f214105d;
                this.label = 1;
                obj = aISearchRecommendRepository.d(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            List<? extends AISearchRecommendRepository.RecommendItem> list = (List) obj;
            RecommendsSnapShot.f214217a.c(list);
            aVar3 = this.this$0.adapter;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar3 = null;
            }
            aVar3.setItems(list);
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "[loadRecommendWords] error: " + e16;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("EmptyPagePart", 1, (String) it.next(), null);
            }
            aVar = this.this$0.adapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar = null;
            }
            if (aVar.getItems().isEmpty()) {
                aVar2 = this.this$0.adapter;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    aVar4 = aVar2;
                }
                aVar4.setItems(AISearchRecommendRepository.a.f214108a.a());
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((EmptyPagePart$loadRecommendWords$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
