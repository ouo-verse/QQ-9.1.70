package com.tencent.guild.api.marketface.impl;

import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.api.marketface.impl.MarketFaceApiImpl$fetchMarketFaceInfoSuspend$2", f = "MarketFaceApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class MarketFaceApiImpl$fetchMarketFaceInfoSuspend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<IPicEmoticonInfo> $emoticonInfo;
    final /* synthetic */ MarketFaceElement $markFaceMessage;
    int label;
    final /* synthetic */ MarketFaceApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketFaceApiImpl$fetchMarketFaceInfoSuspend$2(Ref.ObjectRef<IPicEmoticonInfo> objectRef, MarketFaceApiImpl marketFaceApiImpl, MarketFaceElement marketFaceElement, Continuation<? super MarketFaceApiImpl$fetchMarketFaceInfoSuspend$2> continuation) {
        super(2, continuation);
        this.$emoticonInfo = objectRef;
        this.this$0 = marketFaceApiImpl;
        this.$markFaceMessage = marketFaceElement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MarketFaceApiImpl$fetchMarketFaceInfoSuspend$2(this.$emoticonInfo, this.this$0, this.$markFaceMessage, continuation);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.tencent.mobileqq.emoticonview.IPicEmoticonInfo] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ?? queryEmoticonInfoFromDB;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<IPicEmoticonInfo> objectRef = this.$emoticonInfo;
            queryEmoticonInfoFromDB = this.this$0.queryEmoticonInfoFromDB(this.$markFaceMessage);
            objectRef.element = queryEmoticonInfoFromDB;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MarketFaceApiImpl$fetchMarketFaceInfoSuspend$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
