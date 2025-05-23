package com.tencent.mobileqq.winkpublish.outbox.slot;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkpublish.outbox.task.BaseTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
import kotlinx.coroutines.channels.ChannelResult;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J#\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/slot/CancelledQueueSlot;", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/BaseQueueSlot;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;", "task", "", "expectState", "", "j", "", "d", "", "k", "", "a", "b", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", h.F, "Ljava/util/Set;", Constants.Raft.TASKS, "Lkotlinx/coroutines/channels/Channel;", "i", "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CancelledQueueSlot extends BaseQueueSlot {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Set<BaseTask> tasks = new LinkedHashSet();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Channel<BaseTask> channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.slot.CancelledQueueSlot$1", f = "CancelledQueueSlot.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.winkpublish.outbox.slot.CancelledQueueSlot$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List<BaseTask> savedTasks = com.tencent.mobileqq.winkpublish.outbox.db.a.c().b();
                Set set = CancelledQueueSlot.this.tasks;
                Intrinsics.checkNotNullExpressionValue(savedTasks, "savedTasks");
                set.addAll(savedTasks);
                QLog.i("WinkPublish-upload2-CancelQueueSlot", 1, "[getTasks] savedTasks size=" + savedTasks.size());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.slot.CancelledQueueSlot$2", f = "CancelledQueueSlot.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.winkpublish.outbox.slot.CancelledQueueSlot$2, reason: invalid class name */
    /* loaded from: classes35.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0038 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0039 -> B:5:0x003e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            ChannelIterator it;
            AnonymousClass2 anonymousClass2;
            Object hasNext;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                it = CancelledQueueSlot.this.channel.iterator();
                anonymousClass2 = this;
                anonymousClass2.L$0 = it;
                anonymousClass2.label = 1;
                hasNext = it.hasNext(anonymousClass2);
                if (hasNext != coroutine_suspended) {
                }
            } else if (i3 == 1) {
                ChannelIterator channelIterator = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                ChannelIterator channelIterator2 = channelIterator;
                Object obj2 = coroutine_suspended;
                AnonymousClass2 anonymousClass22 = this;
                if (!((Boolean) obj).booleanValue()) {
                    BaseTask baseTask = (BaseTask) channelIterator2.next();
                    if (!BaseQueueSlot.INSTANCE.a()) {
                        baseTask.L(CancelledQueueSlot.this);
                    }
                    CancelledQueueSlot.this.e(baseTask);
                    baseTask.o();
                    baseTask.H();
                    CancelledQueueSlot.this.tasks.add(baseTask);
                    com.tencent.mobileqq.winkpublish.outbox.e.f327257a.a(baseTask.s()).c(baseTask.z());
                    c.f327281a.a(baseTask.s()).b().l();
                    anonymousClass2 = anonymousClass22;
                    coroutine_suspended = obj2;
                    it = channelIterator2;
                    anonymousClass2.L$0 = it;
                    anonymousClass2.label = 1;
                    hasNext = it.hasNext(anonymousClass2);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj3 = coroutine_suspended;
                    anonymousClass22 = anonymousClass2;
                    obj = hasNext;
                    channelIterator2 = it;
                    obj2 = obj3;
                    if (!((Boolean) obj).booleanValue()) {
                        QLog.e("WinkPublish-upload2-CancelQueueSlot", 1, "[init] end launch");
                        return Unit.INSTANCE;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public CancelledQueueSlot() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass2(null), 3, null);
    }

    private final void j(BaseTask task, int expectState) {
        boolean z16 = true;
        if (!(task.x() == 5)) {
            throw new IllegalStateException(("WinkPublish-invalid task state: " + task.x() + ", id: " + task.u()).toString());
        }
        if (expectState != 0 && expectState != 3) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        throw new IllegalStateException(("WinkPublish-invalid expectState: " + expectState).toString());
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.a
    public boolean a(BaseTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.i("WinkPublish-upload2-CancelQueueSlot", 1, "[offer] task id=" + task.u() + ", task state=" + task.x() + ", tasks size=" + this.tasks.size());
        task.N(5);
        if (BaseQueueSlot.INSTANCE.a()) {
            task.L(this);
        }
        task.K(null);
        return ChannelResult.m2018isSuccessimpl(this.channel.mo2003trySendJP2dKIU(task));
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.a
    public Object b(BaseTask baseTask, int i3, Continuation<? super Unit> continuation) {
        QLog.i("WinkPublish-upload2-CancelQueueSlot", 1, "[transferTask] task id=" + baseTask.u() + ", task state=" + baseTask.x() + ", expectState=" + i3);
        if (i3 == baseTask.x()) {
            QLog.i("WinkPublish-upload2-CancelQueueSlot", 1, "[transferTask] already in cancelled state");
            return Unit.INSTANCE;
        }
        j(baseTask, i3);
        if (i3 != 0) {
            if (i3 == 3) {
                if (c.f327281a.a(baseTask.s()).h().a(baseTask)) {
                    baseTask.K(null);
                    this.tasks.remove(baseTask);
                } else {
                    throw new RuntimeException("cannot transfer to finish slot");
                }
            }
        } else if (c.f327281a.a(baseTask.s()).b().a(baseTask)) {
            this.tasks.remove(baseTask);
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.BaseQueueSlot
    public String d() {
        return "WinkPublish-upload2-CancelQueueSlot";
    }

    public List<BaseTask> k() {
        List<BaseTask> list;
        list = CollectionsKt___CollectionsKt.toList(this.tasks);
        return list;
    }
}
