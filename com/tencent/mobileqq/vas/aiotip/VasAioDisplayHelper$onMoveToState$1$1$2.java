package com.tencent.mobileqq.vas.aiotip;

import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.aiotip.api.IVasAioTipService;
import com.tencent.mobileqq.vas.font.magic.IVasMagicFontManager;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.d;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.vas.aiotip.VasAioDisplayHelper$onMoveToState$1$1$2", f = "VasAioDisplayHelper.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
public final class VasAioDisplayHelper$onMoveToState$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VasAioDisplayHelper this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/aiotip/VasAioDisplayHelper$onMoveToState$1$1$2$a", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/qqnt/msg/d;", "value", "", "a", "(Lcom/tencent/qqnt/msg/d;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements FlowCollector<d> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VasAioDisplayHelper f308391d;

        a(VasAioDisplayHelper vasAioDisplayHelper) {
            this.f308391d = vasAioDisplayHelper;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object emit(@NotNull d dVar, @NotNull Continuation<? super Unit> continuation) {
            com.tencent.aio.main.businesshelper.b bVar;
            com.tencent.aio.api.runtime.a a16;
            AIOParam g16;
            bVar = this.f308391d.param;
            if (bVar != null && (a16 = bVar.a()) != null && (g16 = a16.g()) != null) {
                int e16 = g16.r().c().e();
                String peerUid = g16.l().getString("key_peerId", "");
                IVasMagicFontManager iVasMagicFontManager = (IVasMagicFontManager) QRoute.api(IVasMagicFontManager.class);
                Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
                iVasMagicFontManager.checkAndTriggerLocalTips(peerUid, e16);
            }
            ((IVasAioTipService) QRoute.api(IVasAioTipService.class)).tryKeywordsAioTips(dVar, true);
            this.f308391d.triggerRoamMsgTips(dVar);
            this.f308391d.tryNickCoverDetect(dVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasAioDisplayHelper$onMoveToState$1$1$2(VasAioDisplayHelper vasAioDisplayHelper, Continuation<? super VasAioDisplayHelper$onMoveToState$1$1$2> continuation) {
        super(2, continuation);
        this.this$0 = vasAioDisplayHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VasAioDisplayHelper$onMoveToState$1$1$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Flow<d> registerSendMsgNotificationFlow = ((IMsgService) QRoute.api(IMsgService.class)).registerSendMsgNotificationFlow();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (registerSendMsgNotificationFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VasAioDisplayHelper$onMoveToState$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
