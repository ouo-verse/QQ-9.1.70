package com.tencent.mobileqq.winkpublish.outbox.slot;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkpublish.outbox.task.BaseTask;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0016R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/slot/FinishedQueueSlot;", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/BaseQueueSlot;", "", "d", "Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;", "task", "", "a", "", "expectState", "", "b", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "i", "Lkotlinx/coroutines/channels/Channel;", h.F, "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FinishedQueueSlot extends BaseQueueSlot {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Channel<BaseTask> channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.slot.FinishedQueueSlot$1", f = "FinishedQueueSlot.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.winkpublish.outbox.slot.FinishedQueueSlot$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0038 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0039 -> B:5:0x003e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            ChannelIterator it;
            AnonymousClass1 anonymousClass1;
            Object hasNext;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                it = FinishedQueueSlot.this.channel.iterator();
                anonymousClass1 = this;
                anonymousClass1.L$0 = it;
                anonymousClass1.label = 1;
                hasNext = it.hasNext(anonymousClass1);
                if (hasNext != coroutine_suspended) {
                }
            } else if (i3 == 1) {
                ChannelIterator channelIterator = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                ChannelIterator channelIterator2 = channelIterator;
                Object obj2 = coroutine_suspended;
                AnonymousClass1 anonymousClass12 = this;
                if (!((Boolean) obj).booleanValue()) {
                    BaseTask baseTask = (BaseTask) channelIterator2.next();
                    if (!BaseQueueSlot.INSTANCE.a()) {
                        baseTask.L(FinishedQueueSlot.this);
                    }
                    baseTask.r();
                    FinishedQueueSlot.this.e(baseTask);
                    com.tencent.mobileqq.winkpublish.outbox.e.f327257a.a(baseTask.s()).c(baseTask.z());
                    com.tencent.mobileqq.winkpublish.outbox.db.a.c().a(baseTask);
                    c cVar = c.f327281a;
                    cVar.a(baseTask.s()).b().l();
                    cVar.a(baseTask.s()).c(baseTask);
                    anonymousClass1 = anonymousClass12;
                    coroutine_suspended = obj2;
                    it = channelIterator2;
                    anonymousClass1.L$0 = it;
                    anonymousClass1.label = 1;
                    hasNext = it.hasNext(anonymousClass1);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj3 = coroutine_suspended;
                    anonymousClass12 = anonymousClass1;
                    obj = hasNext;
                    channelIterator2 = it;
                    obj2 = obj3;
                    if (!((Boolean) obj).booleanValue()) {
                        QLog.e("WinkPublish-upload2-FinishedQueueSlot", 1, "[init] end launch");
                        return Unit.INSTANCE;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public FinishedQueueSlot() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.a
    public boolean a(BaseTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.i("WinkPublish-upload2-FinishedQueueSlot", 1, "[offer] task id=" + task.u() + ", task state=" + task.x());
        task.N(3);
        if (BaseQueueSlot.INSTANCE.a()) {
            task.L(this);
        }
        task.K(null);
        this.channel.mo2003trySendJP2dKIU(task);
        return true;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.a
    public Object b(BaseTask baseTask, int i3, Continuation<? super Unit> continuation) {
        QLog.i("WinkPublish-upload2-FinishedQueueSlot", 1, "[transferTask] task id=" + baseTask.u() + ", task state=" + baseTask.x() + ", expectState=" + i3);
        if (i3 == baseTask.x()) {
            QLog.i("WinkPublish-upload2-FinishedQueueSlot", 1, "[transferTask] already in finished state");
            return Unit.INSTANCE;
        }
        QLog.e("WinkPublish-upload2-FinishedQueueSlot", 1, "[transferTask] ", new RuntimeException("finish state cannot transfer to any other state, " + baseTask.u() + ", task state=" + baseTask.x() + ", expect=" + i3));
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.BaseQueueSlot
    public String d() {
        return "WinkPublish-upload2-FinishedQueueSlot";
    }

    public List<BaseTask> i() {
        List<BaseTask> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }
}
