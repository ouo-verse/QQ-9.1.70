package com.tencent.mobileqq.guild.media.core.logic.entertips;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0006B#\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/entertips/UserEnterTipsTrigger;", "T", "Lcom/tencent/mobileqq/guild/media/core/logic/entertips/b;", "", "data", "", "a", "release", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/jvm/functions/Function0;", "getCoroutineScope", "()Lkotlin/jvm/functions/Function0;", "coroutineScope", "Lcom/tencent/mobileqq/guild/media/core/logic/entertips/a;", "b", "Lcom/tencent/mobileqq/guild/media/core/logic/entertips/a;", "c", "()Lcom/tencent/mobileqq/guild/media/core/logic/entertips/a;", "trigger", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "cacheList", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "d", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "triggerJob", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/tencent/mobileqq/guild/media/core/logic/entertips/a;)V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class UserEnterTipsTrigger<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<CoroutineScope> coroutineScope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a<T> trigger;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<T> cacheList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b triggerJob;

    /* JADX WARN: Multi-variable type inference failed */
    public UserEnterTipsTrigger(@NotNull Function0<? extends CoroutineScope> coroutineScope, @NotNull a<T> trigger) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        this.coroutineScope = coroutineScope;
        this.trigger = trigger;
        this.cacheList = new CopyOnWriteArrayList<>();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.entertips.b
    public void a(@NotNull List<? extends T> data) {
        Job f16;
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.cacheList.size() > 50) {
            return;
        }
        this.cacheList.addAll(data);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.triggerJob;
        boolean z16 = false;
        if (bVar != null && (f16 = bVar.f()) != null && f16.isActive()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.triggerJob = CorountineFunKt.e(this.coroutineScope.invoke(), "onTriggerEvent", null, null, null, new UserEnterTipsTrigger$addData$1(this, null), 14, null);
    }

    @NotNull
    public final a<T> c() {
        return this.trigger;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.entertips.b
    public void release() {
        Job f16;
        this.cacheList.clear();
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.triggerJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        this.triggerJob = null;
    }
}
