package com.tencent.guild.api.marketface.impl;

import android.content.Context;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.api.marketface.impl.MarketFaceApiImpl$handleEmoAdd$2", f = "MarketFaceApiImpl.kt", i = {0}, l = {156, 158}, m = "invokeSuspend", n = {"emoticonInfo"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class MarketFaceApiImpl$handleEmoAdd$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MarketFaceElement $markFaceMessage;
    final /* synthetic */ Ref.ObjectRef<com.tencent.qqnt.msg.api.c<EmoticonPackage>> $result;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MarketFaceApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketFaceApiImpl$handleEmoAdd$2(MarketFaceApiImpl marketFaceApiImpl, MarketFaceElement marketFaceElement, Ref.ObjectRef<com.tencent.qqnt.msg.api.c<EmoticonPackage>> objectRef, Context context, Continuation<? super MarketFaceApiImpl$handleEmoAdd$2> continuation) {
        super(2, continuation);
        this.this$0 = marketFaceApiImpl;
        this.$markFaceMessage = marketFaceElement;
        this.$result = objectRef;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MarketFaceApiImpl$handleEmoAdd$2(this.this$0, this.$markFaceMessage, this.$result, this.$context, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPicEmoticonInfo queryEmoticonInfoFromDB;
        Ref.ObjectRef<com.tencent.qqnt.msg.api.c<EmoticonPackage>> objectRef;
        IPicEmoticonInfo iPicEmoticonInfo;
        T t16;
        Object processEmoAuth;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) this.L$1;
            iPicEmoticonInfo = (IPicEmoticonInfo) this.L$0;
            ResultKt.throwOnFailure(obj);
            t16 = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            queryEmoticonInfoFromDB = this.this$0.queryEmoticonInfoFromDB(this.$markFaceMessage);
            if (queryEmoticonInfoFromDB == null) {
                QLog.i(com.tencent.qqnt.emotion.adapter.api.impl.MarketFaceApiImpl.TAG, 1, "emoticonInfo==null");
                return Unit.INSTANCE;
            }
            objectRef = this.$result;
            FavEmoServerApi favEmoServerApi = FavEmoServerApi.f112580a;
            String epid = queryEmoticonInfoFromDB.getEpid();
            Intrinsics.checkNotNullExpressionValue(epid, "emoticonInfo.epid");
            this.L$0 = queryEmoticonInfoFromDB;
            this.L$1 = objectRef;
            this.label = 1;
            Object c16 = favEmoServerApi.c(epid, this);
            if (c16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            iPicEmoticonInfo = queryEmoticonInfoFromDB;
            t16 = c16;
        }
        objectRef.element = t16;
        MarketFaceApiImpl marketFaceApiImpl = this.this$0;
        Context context = this.$context;
        EmoticonPackage a16 = this.$result.element.a();
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        processEmoAuth = marketFaceApiImpl.processEmoAuth(context, a16, iPicEmoticonInfo, this);
        if (processEmoAuth == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MarketFaceApiImpl$handleEmoAdd$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
