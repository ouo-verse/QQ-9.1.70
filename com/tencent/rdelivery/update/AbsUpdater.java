package com.tencent.rdelivery.update;

import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.net.RDeliveryRequest;
import com.tencent.rdelivery.net.g;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0006\u0010\b\u001a\u00020\u0004R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/rdelivery/update/AbsUpdater;", "", "Lcom/tencent/rdelivery/update/AbsUpdater$Event;", "event", "", "c", "Lcom/tencent/rdelivery/net/RDeliveryRequest$RequestSource;", "b", "a", "Lcom/tencent/rdelivery/net/g;", "Lcom/tencent/rdelivery/net/g;", "getRequestManager", "()Lcom/tencent/rdelivery/net/g;", "requestManager", "Lcom/tencent/raft/standard/task/IRTask;", "Lcom/tencent/raft/standard/task/IRTask;", "getTaskInterface", "()Lcom/tencent/raft/standard/task/IRTask;", "taskInterface", "<init>", "(Lcom/tencent/rdelivery/net/g;Lcom/tencent/raft/standard/task/IRTask;)V", "Event", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public abstract class AbsUpdater {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g requestManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final IRTask taskInterface;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rdelivery/update/AbsUpdater$Event;", "", "(Ljava/lang/String;I)V", "SDK_INIT", "NETWORK_RECONNECT", "APP_ENTER_FOREGROUND", "APP_ENTER_BACKGROUND", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes25.dex */
    public enum Event {
        SDK_INIT,
        NETWORK_RECONNECT,
        APP_ENTER_FOREGROUND,
        APP_ENTER_BACKGROUND
    }

    public AbsUpdater(@NotNull g requestManager, @Nullable IRTask iRTask) {
        Intrinsics.checkParameterIsNotNull(requestManager, "requestManager");
        this.requestManager = requestManager;
        this.taskInterface = iRTask;
    }

    public final void a() {
        g.e(this.requestManager, b(), null, null, 6, null);
    }

    @NotNull
    public abstract RDeliveryRequest.RequestSource b();

    public abstract void c(@NotNull Event event);

    public /* synthetic */ AbsUpdater(g gVar, IRTask iRTask, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, (i3 & 2) != 0 ? null : iRTask);
    }
}
