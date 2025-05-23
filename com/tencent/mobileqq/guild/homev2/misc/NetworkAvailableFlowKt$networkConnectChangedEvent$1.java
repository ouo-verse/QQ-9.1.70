package com.tencent.mobileqq.guild.homev2.misc;

import com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.misc.NetworkAvailableFlowKt$networkConnectChangedEvent$1", f = "NetworkAvailableFlow.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class NetworkAvailableFlowKt$networkConnectChangedEvent$1 extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NetworkAvailableFlowKt$networkConnectChangedEvent$1(Continuation<? super NetworkAvailableFlowKt$networkConnectChangedEvent$1> continuation) {
        super(2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ProducerScope producerScope, boolean z16) {
        producerScope.mo2003trySendJP2dKIU(Boolean.valueOf(z16));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NetworkAvailableFlowKt$networkConnectChangedEvent$1 networkAvailableFlowKt$networkConnectChangedEvent$1 = new NetworkAvailableFlowKt$networkConnectChangedEvent$1(continuation);
        networkAvailableFlowKt$networkConnectChangedEvent$1.L$0 = obj;
        return networkAvailableFlowKt$networkConnectChangedEvent$1;
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
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final INetworkStateApi.a aVar = new INetworkStateApi.a() { // from class: com.tencent.mobileqq.guild.homev2.misc.f
                @Override // com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi.a
                public final void onNetworkConnect(boolean z16) {
                    NetworkAvailableFlowKt$networkConnectChangedEvent$1.b(ProducerScope.this, z16);
                }
            };
            ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).addConnectStateListener(aVar);
            producerScope.mo2003trySendJP2dKIU(Boxing.boxBoolean(((INetworkStateApi) QRoute.api(INetworkStateApi.class)).isNetworkAvailable()));
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.homev2.misc.NetworkAvailableFlowKt$networkConnectChangedEvent$1.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).removeConnectStateListener(INetworkStateApi.a.this);
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super Boolean> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NetworkAvailableFlowKt$networkConnectChangedEvent$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
