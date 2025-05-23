package com.tencent.mobileqq.guild.message.notify.api.impl;

import com.tencent.guild.aio.util.GuildAIODispatchers;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/message/notify/api/impl/WeakHandleMsgRevoke;", "Lkotlinx/coroutines/CoroutineScope;", "", "b", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/message/notify/api/impl/GuildNotifyImpl;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "guildNotifyRef", "Lkotlin/coroutines/CoroutineContext;", "e", "Lkotlin/coroutines/CoroutineContext;", "context", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "notifyImpl", "<init>", "(Lcom/tencent/mobileqq/guild/message/notify/api/impl/GuildNotifyImpl;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class WeakHandleMsgRevoke implements CoroutineScope {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<GuildNotifyImpl> guildNotifyRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineContext context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\u008a@"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/qqnt/msg/d;", "Lkotlin/collections/ArrayList;", "msgRecords", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.message.notify.api.impl.WeakHandleMsgRevoke$1", f = "WeakHandleMsgRevoke.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.message.notify.api.impl.WeakHandleMsgRevoke$1, reason: invalid class name */
    /* loaded from: classes14.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ArrayList<com.tencent.qqnt.msg.d>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayList<com.tencent.qqnt.msg.d> arrayList = (ArrayList) this.L$0;
                GuildNotifyImpl guildNotifyImpl = (GuildNotifyImpl) WeakHandleMsgRevoke.this.guildNotifyRef.get();
                if (guildNotifyImpl != null) {
                    guildNotifyImpl.handleMsgRevokeEvent(arrayList);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull ArrayList<com.tencent.qqnt.msg.d> arrayList, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(arrayList, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public WeakHandleMsgRevoke(@NotNull GuildNotifyImpl notifyImpl) {
        Intrinsics.checkNotNullParameter(notifyImpl, "notifyImpl");
        this.guildNotifyRef = new WeakReference<>(notifyImpl);
        this.context = GuildAIODispatchers.f112358a.e().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
        FlowKt.launchIn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerMsgStatusUpdateNotificationFlow(), new AnonymousClass1(null)), this);
    }

    public final void b() {
        JobKt__JobKt.cancelChildren$default(getContext(), (CancellationException) null, 1, (Object) null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    /* renamed from: getCoroutineContext, reason: from getter */
    public CoroutineContext getContext() {
        return this.context;
    }
}
