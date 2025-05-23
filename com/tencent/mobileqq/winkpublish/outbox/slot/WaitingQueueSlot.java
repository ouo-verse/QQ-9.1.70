package com.tencent.mobileqq.winkpublish.outbox.slot;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.NetworkException;
import com.tencent.mobileqq.winkpublish.outbox.task.BaseTask;
import com.tencent.mobileqq.winkpublish.util.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\rB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J#\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/slot/WaitingQueueSlot;", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/BaseQueueSlot;", "Lcom/tencent/mobileqq/winkpublish/util/d$b;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;", "task", "", "expectState", "", "j", "l", "", "k", "", "a", "b", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connected", "onNetworkConnect", "", h.F, "Ljava/util/Set;", Constants.Raft.TASKS, "Lkotlinx/coroutines/channels/Channel;", "i", "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WaitingQueueSlot extends BaseQueueSlot implements d.b {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Set<BaseTask> tasks = new LinkedHashSet();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Channel<BaseTask> channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.slot.WaitingQueueSlot$1", f = "WaitingQueueSlot.kt", i = {1}, l = {31, 44}, m = "invokeSuspend", n = {"task"}, s = {"L$1"})
    /* renamed from: com.tencent.mobileqq.winkpublish.outbox.slot.WaitingQueueSlot$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
        
            com.tencent.qphone.base.util.QLog.w("WinkPublish-upload2-WaitingQueueSlot", 1, "[init] task is canceled, task id=" + r12.u() + ", state=" + r12.x());
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x00b8  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0091 -> B:6:0x0094). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0098 -> B:7:0x00a1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            ChannelIterator it;
            AnonymousClass1 anonymousClass1;
            AnonymousClass1 anonymousClass12;
            ChannelIterator channelIterator;
            Object hasNext;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                it = WaitingQueueSlot.this.channel.iterator();
                anonymousClass1 = this;
                anonymousClass1.L$0 = it;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 1;
                hasNext = it.hasNext(anonymousClass1);
                if (hasNext == coroutine_suspended) {
                }
            } else if (i3 == 1) {
                channelIterator = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                anonymousClass12 = this;
                if (!((Boolean) obj).booleanValue()) {
                }
            } else if (i3 == 2) {
                BaseTask baseTask = (BaseTask) this.L$1;
                ChannelIterator channelIterator2 = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                ChannelIterator channelIterator3 = channelIterator2;
                anonymousClass12 = this;
                BaseTask baseTask2 = baseTask;
                channelIterator = channelIterator3;
                BaseTask baseTask3 = baseTask2;
                com.tencent.mobileqq.winkpublish.outbox.e.f327257a.a(baseTask3.s()).c(baseTask3.z());
                if (baseTask3.E()) {
                    com.tencent.mobileqq.winkpublish.outbox.db.a.c().e(baseTask3);
                }
                it = channelIterator;
                anonymousClass1 = anonymousClass12;
                anonymousClass1.L$0 = it;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 1;
                hasNext = it.hasNext(anonymousClass1);
                if (hasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                AnonymousClass1 anonymousClass13 = anonymousClass1;
                channelIterator = it;
                obj = hasNext;
                anonymousClass12 = anonymousClass13;
                if (!((Boolean) obj).booleanValue()) {
                    baseTask3 = (BaseTask) channelIterator.next();
                    if (!BaseQueueSlot.INSTANCE.a()) {
                        baseTask3.L(WaitingQueueSlot.this);
                    }
                    if (baseTask3.x() != 5 && baseTask3.x() != 3) {
                        if (baseTask3.getException() == null) {
                            WaitingQueueSlot waitingQueueSlot = WaitingQueueSlot.this;
                            anonymousClass12.L$0 = channelIterator;
                            anonymousClass12.L$1 = baseTask3;
                            anonymousClass12.label = 2;
                            if (waitingQueueSlot.b(baseTask3, 1, anonymousClass12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ChannelIterator channelIterator4 = channelIterator;
                            baseTask = baseTask3;
                            channelIterator3 = channelIterator4;
                            BaseTask baseTask22 = baseTask;
                            channelIterator = channelIterator3;
                            BaseTask baseTask32 = baseTask22;
                            com.tencent.mobileqq.winkpublish.outbox.e.f327257a.a(baseTask32.s()).c(baseTask32.z());
                            if (baseTask32.E()) {
                            }
                            it = channelIterator;
                            anonymousClass1 = anonymousClass12;
                            anonymousClass1.L$0 = it;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 1;
                            hasNext = it.hasNext(anonymousClass1);
                            if (hasNext == coroutine_suspended) {
                            }
                        } else {
                            WaitingQueueSlot.this.tasks.add(baseTask32);
                            com.tencent.mobileqq.winkpublish.outbox.e.f327257a.a(baseTask32.s()).c(baseTask32.z());
                            if (baseTask32.E()) {
                            }
                            it = channelIterator;
                            anonymousClass1 = anonymousClass12;
                            anonymousClass1.L$0 = it;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 1;
                            hasNext = it.hasNext(anonymousClass1);
                            if (hasNext == coroutine_suspended) {
                            }
                        }
                    } else {
                        QLog.w("WinkPublish-upload2-WaitingQueueSlot", 1, "[init] task is canceled, task id=" + baseTask32.u() + ", state=" + baseTask32.x());
                        it = channelIterator;
                        anonymousClass1 = anonymousClass12;
                        anonymousClass1.L$0 = it;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.label = 1;
                        hasNext = it.hasNext(anonymousClass1);
                        if (hasNext == coroutine_suspended) {
                        }
                    }
                } else {
                    QLog.e("WinkPublish-upload2-WaitingQueueSlot", 1, "[init] end launch");
                    return Unit.INSTANCE;
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

    public WaitingQueueSlot() {
        com.tencent.mobileqq.winkpublish.util.d.b(this);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(null), 3, null);
    }

    private final void j(BaseTask task, int expectState) {
        if (task.x() == 0 || task.x() == 6) {
            if (expectState == 1 || expectState == 5 || expectState == 3) {
                return;
            }
            throw new IllegalStateException(("WinkPublish-invalid expectState: " + expectState).toString());
        }
        throw new IllegalStateException(("WinkPublish-invalid task state: " + task.x() + ", id: " + task.u()).toString());
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.a
    public boolean a(BaseTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.i("WinkPublish-upload2-WaitingQueueSlot", 1, "[offer] task id=" + task.u() + ", task state=" + task.x() + ", tasks size=" + this.tasks.size());
        if (task.getException() instanceof NetworkException) {
            task.N(6);
            task.M(System.currentTimeMillis());
        } else {
            task.N(0);
        }
        if (BaseQueueSlot.INSTANCE.a()) {
            task.L(this);
        }
        task.getTaskContext().E(System.currentTimeMillis());
        return ChannelResult.m2018isSuccessimpl(this.channel.mo2003trySendJP2dKIU(task));
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.slot.a
    public Object b(BaseTask baseTask, int i3, Continuation<? super Unit> continuation) {
        QLog.i("WinkPublish-upload2-WaitingQueueSlot", 1, "[transferTask] task id=" + baseTask.u() + ", task state=" + baseTask.x() + ", expectState=" + i3);
        if (i3 == baseTask.x()) {
            QLog.i("WinkPublish-upload2-WaitingQueueSlot", 1, "[transferTask] already in waiting state");
            return Unit.INSTANCE;
        }
        j(baseTask, i3);
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 == 5 && c.f327281a.a(baseTask.s()).d().a(baseTask)) {
                    this.tasks.remove(baseTask);
                }
            } else if (c.f327281a.a(baseTask.s()).h().a(baseTask)) {
                this.tasks.remove(baseTask);
            }
        } else if (c.f327281a.a(baseTask.s()).g().a(baseTask)) {
            this.tasks.remove(baseTask);
        } else {
            QLog.i("WinkPublish-upload2-WaitingQueueSlot", 1, "[transferTask] task id=" + baseTask.u() + " cannot offer to running slot");
            baseTask.N(0);
            baseTask.L(this);
            this.tasks.add(baseTask);
        }
        return Unit.INSTANCE;
    }

    public List<BaseTask> k() {
        List<BaseTask> list;
        list = CollectionsKt___CollectionsKt.toList(this.tasks);
        return list;
    }

    public final void l() {
        Object obj;
        QLog.i("WinkPublish-upload2-WaitingQueueSlot", 1, "[tryRunNext] tasks size=" + this.tasks.size());
        Iterator<T> it = this.tasks.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((BaseTask) obj).E()) {
                    break;
                }
            }
        }
        BaseTask baseTask = (BaseTask) obj;
        if (baseTask != null) {
            a(baseTask);
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.util.d.b
    public void onNetworkConnect(boolean connected) {
        if (QLog.isColorLevel()) {
            QLog.d("WinkPublish-upload2-WaitingQueueSlot", 2, "[onNetworkConnect] connected=" + connected);
        }
        if (!connected) {
            QLog.i("WinkPublish-upload2-WaitingQueueSlot", 1, "no network, task size=" + this.tasks.size());
            return;
        }
        Set<BaseTask> set = this.tasks;
        ArrayList<BaseTask> arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((BaseTask) next).x() == 6) {
                arrayList.add(next);
            }
        }
        for (BaseTask baseTask : arrayList) {
            baseTask.K(null);
            baseTask.N(0);
            if (baseTask.getStartWaitForOfflineMs() > 0) {
                com.tencent.mobileqq.winkpublish.outbox.d.e(baseTask.getTaskContext(), "T_CATCH_IMPORTANT_INFO", baseTask.getTaskContext().r(), null, "scene_wait_for_offline_cost", String.valueOf(System.currentTimeMillis() - baseTask.getStartWaitForOfflineMs()), baseTask.getTaskContext().getDtCameraSessionId(), null, null, null, null, null, null, null, null, 16324, null);
                baseTask.M(-1L);
            }
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new WaitingQueueSlot$onNetworkConnect$2$1(this, baseTask, null), 3, null);
        }
    }
}
