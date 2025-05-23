package com.tencent.guild.api.marketface.impl;

import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.guild.temp.api.IMarketFaceDiffApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
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
@DebugMetadata(c = "com.tencent.guild.api.marketface.impl.MarketFaceApiImpl$bindMagicMarketFaceToView$2", f = "MarketFaceApiImpl.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class MarketFaceApiImpl$bindMagicMarketFaceToView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Contact $contact;
    final /* synthetic */ Ref.ObjectRef<IPicEmoticonInfo> $emoticonInfo;
    final /* synthetic */ Ref.BooleanRef $isLastMsg;
    final /* synthetic */ MarketFaceElement $markFaceMessage;
    final /* synthetic */ long $msgId;
    Object L$0;
    int label;
    final /* synthetic */ MarketFaceApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketFaceApiImpl$bindMagicMarketFaceToView$2(Ref.ObjectRef<IPicEmoticonInfo> objectRef, MarketFaceApiImpl marketFaceApiImpl, MarketFaceElement marketFaceElement, Ref.BooleanRef booleanRef, Contact contact, long j3, Continuation<? super MarketFaceApiImpl$bindMagicMarketFaceToView$2> continuation) {
        super(2, continuation);
        this.$emoticonInfo = objectRef;
        this.this$0 = marketFaceApiImpl;
        this.$markFaceMessage = marketFaceElement;
        this.$isLastMsg = booleanRef;
        this.$contact = contact;
        this.$msgId = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MarketFaceApiImpl$bindMagicMarketFaceToView$2(this.$emoticonInfo, this.this$0, this.$markFaceMessage, this.$isLastMsg, this.$contact, this.$msgId, continuation);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.tencent.mobileqq.emoticonview.IPicEmoticonInfo] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ?? queryEmoticonInfoFromDB;
        Object checkIsLastMsg;
        Ref.BooleanRef booleanRef;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                booleanRef = (Ref.BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            QLog.i(com.tencent.qqnt.emotion.adapter.api.impl.MarketFaceApiImpl.TAG, 4, "withContext==fetchMarketFaceInfoSuspend ThreadName=" + Thread.currentThread().getName());
            Ref.ObjectRef<IPicEmoticonInfo> objectRef = this.$emoticonInfo;
            queryEmoticonInfoFromDB = this.this$0.queryEmoticonInfoFromDB(this.$markFaceMessage);
            objectRef.element = queryEmoticonInfoFromDB;
            ((IMarketFaceDiffApi) QRoute.api(IMarketFaceDiffApi.class)).isSupportMagicFace();
            Ref.BooleanRef booleanRef2 = this.$isLastMsg;
            MarketFaceApiImpl marketFaceApiImpl = this.this$0;
            Contact contact = this.$contact;
            long j3 = this.$msgId;
            this.L$0 = booleanRef2;
            this.label = 1;
            checkIsLastMsg = marketFaceApiImpl.checkIsLastMsg(contact, j3, this);
            if (checkIsLastMsg == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
            obj = checkIsLastMsg;
        }
        booleanRef.element = ((Boolean) obj).booleanValue();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MarketFaceApiImpl$bindMagicMarketFaceToView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
