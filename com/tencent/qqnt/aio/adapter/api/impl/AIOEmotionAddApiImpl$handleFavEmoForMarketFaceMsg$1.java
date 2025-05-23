package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.guild.api.marketface.IMarketFaceApi;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.qroute.QRoute;
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
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.adapter.api.impl.AIOEmotionAddApiImpl$handleFavEmoForMarketFaceMsg$1", f = "AIOEmotionAddApiImpl.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class AIOEmotionAddApiImpl$handleFavEmoForMarketFaceMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MarketFaceElement $emoInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOEmotionAddApiImpl$handleFavEmoForMarketFaceMsg$1(Context context, MarketFaceElement marketFaceElement, Continuation<? super AIOEmotionAddApiImpl$handleFavEmoForMarketFaceMsg$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$emoInfo = marketFaceElement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AIOEmotionAddApiImpl$handleFavEmoForMarketFaceMsg$1(this.$context, this.$emoInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (QLog.isDevelopLevel()) {
                QLog.i(AIOEmotionAddApiImpl.TAG, 4, "handleFavEmoForMarketFaceMsg");
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((IFavroamingManagerService) peekAppRuntime.getRuntimeService(IFavroamingManagerService.class, "all")).checkFavEmotionInit();
            }
            IMarketFaceApi iMarketFaceApi = (IMarketFaceApi) QRoute.api(IMarketFaceApi.class);
            Context context = this.$context;
            MarketFaceElement marketFaceElement = this.$emoInfo;
            this.label = 1;
            if (iMarketFaceApi.addToFavEmo(context, marketFaceElement, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AIOEmotionAddApiImpl$handleFavEmoForMarketFaceMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
