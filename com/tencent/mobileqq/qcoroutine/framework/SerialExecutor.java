package com.tencent.mobileqq.qcoroutine.framework;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcoroutine.api.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0006R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R-\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00130\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/SerialExecutor;", "", "Lcom/tencent/mobileqq/qcoroutine/api/g;", "r", "", "groupId", "", h.F, "g", "d", "c", "Lkotlinx/coroutines/channels/Channel;", "a", "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "scheduledTasks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Lazy;", "f", "()Ljava/util/concurrent/ConcurrentHashMap;", "waitingQueues", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "sendScope", "Lcom/tencent/mobileqq/qcoroutine/framework/QTaskPool;", "e", "Lcom/tencent/mobileqq/qcoroutine/framework/QTaskPool;", "()Lcom/tencent/mobileqq/qcoroutine/framework/QTaskPool;", "taskPool", "<init>", "(Lcom/tencent/mobileqq/qcoroutine/framework/QTaskPool;)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class SerialExecutor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Channel<Object> channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, g> scheduledTasks;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy waitingQueues;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope sendScope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QTaskPool taskPool;

    public SerialExecutor(@NotNull QTaskPool taskPool) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(taskPool, "taskPool");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) taskPool);
            return;
        }
        this.taskPool = taskPool;
        this.channel = ChannelKt.Channel$default(taskPool.l().a() / 2, null, null, 6, null);
        this.scheduledTasks = new ConcurrentHashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(SerialExecutor$waitingQueues$2.INSTANCE);
        this.waitingQueues = lazy;
        this.sendScope = CoroutineScopeKt.CoroutineScope(com.tencent.mobileqq.qcoroutine.souce.d.a(Dispatchers.getIO(), 1).plus(taskPool.k()).plus(new CoroutineName(taskPool.l() + "_sendScope")));
    }

    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<g>> f() {
        return (ConcurrentHashMap) this.waitingQueues.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String groupId) {
        this.scheduledTasks.remove(groupId);
        ConcurrentLinkedQueue<g> concurrentLinkedQueue = f().get(groupId);
        if (concurrentLinkedQueue != null) {
            g poll = concurrentLinkedQueue.poll();
            if (poll == null) {
                f().remove(groupId);
            } else {
                h(poll, groupId);
            }
        }
    }

    private final void h(g r16, String groupId) {
        this.scheduledTasks.put(groupId, r16);
        BuildersKt__Builders_commonKt.launch$default(this.sendScope, null, null, new SerialExecutor$start$1(this, r16, groupId, null), 3, null);
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            SendChannel.DefaultImpls.close$default(this.channel, null, 1, null);
            CoroutineScopeKt.cancel$default(this.sendScope, null, 1, null);
        }
    }

    public final void d(@NotNull g r16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) r16);
            return;
        }
        Intrinsics.checkNotNullParameter(r16, "r");
        String j3 = r16.j();
        if (j3 != null) {
            if (!this.scheduledTasks.containsKey(j3)) {
                h(r16, j3);
                return;
            }
            ConcurrentLinkedQueue<g> concurrentLinkedQueue = f().get(j3);
            if (concurrentLinkedQueue == null) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                f().put(j3, concurrentLinkedQueue);
            }
            Intrinsics.checkNotNullExpressionValue(concurrentLinkedQueue, "waitingQueues[it] ?: Con\u2026aitingQueues[it] = this }");
            concurrentLinkedQueue.offer(r16);
        }
    }

    @NotNull
    public final QTaskPool e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QTaskPool) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.taskPool;
    }
}
