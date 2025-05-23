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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J#\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/slot/IdleQueueSlot;", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/BaseQueueSlot;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;", "task", "", "expectState", "", "i", "", "j", "b", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "Lkotlinx/coroutines/channels/Channel;", h.F, "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class IdleQueueSlot extends BaseQueueSlot {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Channel<BaseTask> channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.slot.IdleQueueSlot$1", f = "IdleQueueSlot.kt", i = {}, l = {26, 27}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.winkpublish.outbox.slot.IdleQueueSlot$1, reason: invalid class name */
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

        /* JADX WARN: Removed duplicated region for block: B:11:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0041 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0062 -> B:7:0x0037). Please report as a decompilation issue!!! */
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
                it = IdleQueueSlot.this.channel.iterator();
            } else if (i3 == 1) {
                ChannelIterator channelIterator = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass12 = this;
                if (!((Boolean) obj).booleanValue()) {
                    BaseTask baseTask = (BaseTask) channelIterator.next();
                    IdleQueueSlot idleQueueSlot = IdleQueueSlot.this;
                    anonymousClass12.L$0 = channelIterator;
                    anonymousClass12.label = 2;
                    if (idleQueueSlot.b(baseTask, 0, anonymousClass12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = channelIterator;
                    anonymousClass1 = anonymousClass12;
                    anonymousClass1.L$0 = it;
                    anonymousClass1.label = 1;
                    hasNext = it.hasNext(anonymousClass1);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    AnonymousClass1 anonymousClass13 = anonymousClass1;
                    channelIterator = it;
                    obj = hasNext;
                    anonymousClass12 = anonymousClass13;
                    if (!((Boolean) obj).booleanValue()) {
                        QLog.e("WinkPublish-upload2-IdleQueueSlot", 1, "[init] end launch");
                        return Unit.INSTANCE;
                    }
                }
            } else if (i3 == 2) {
                ChannelIterator channelIterator2 = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                it = channelIterator2;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            anonymousClass1 = this;
            anonymousClass1.L$0 = it;
            anonymousClass1.label = 1;
            hasNext = it.hasNext(anonymousClass1);
            if (hasNext != coroutine_suspended) {
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public IdleQueueSlot() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(null), 3, null);
    }

    private final void i(BaseTask task, int expectState) {
        boolean z16 = true;
        if (!(task.x() == -1000)) {
            throw new IllegalStateException(("WinkPublish-invalid task state: " + task.x() + ", id: " + task.u()).toString());
        }
        if (expectState != 0 && expectState != 5 && expectState != 3) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        throw new IllegalStateException(("WinkPublish-invalid expectState2: " + expectState).toString());
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.a
    public boolean a(BaseTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.i("WinkPublish-upload2-IdleQueueSlot", 1, "[transferTask] task id=" + task.u() + ", task state=" + task.x());
        throw new RuntimeException("IdleQueueSlot cannot offer");
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.a
    public Object b(BaseTask baseTask, int i3, Continuation<? super Unit> continuation) {
        QLog.i("WinkPublish-upload2-IdleQueueSlot", 1, "[transferTask] task id=" + baseTask.u() + ", task state=" + baseTask.x() + ", expectState=" + i3);
        i(baseTask, i3);
        if (i3 == 0) {
            c.f327281a.a(baseTask.s()).b().a(baseTask);
        } else if (i3 == 3) {
            c.f327281a.a(baseTask.s()).h().a(baseTask);
        } else if (i3 == 5) {
            c.f327281a.a(baseTask.s()).d().a(baseTask);
        }
        return Unit.INSTANCE;
    }

    public List<BaseTask> j() {
        List<BaseTask> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }
}
