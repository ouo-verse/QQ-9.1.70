package com.tencent.rdelivery.net;

import android.os.SystemClock;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.data.DataManager;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u0002\u000f\u0006B'\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010#\u001a\u00020\t\u0012\u0006\u0010(\u001a\u00020$\u0012\u0006\u0010.\u001a\u00020)\u00a2\u0006\u0004\b/\u00100J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0017\u0010!\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b\u0016\u0010 R\u0016\u0010#\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\"R\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/rdelivery/net/e;", "", "Lcom/tencent/rdelivery/net/RDeliveryRequest;", Const.BUNDLE_KEY_REQUEST, "", "c", "b", "f", "i", "Lcom/tencent/rdelivery/data/DataManager;", "manager", "e", tl.h.F, "g", "Ljava/util/ArrayDeque;", "a", "Ljava/util/ArrayDeque;", "requestQueue", "", "Z", "hasRunningRequest", "hasLocalDataInitialed", "d", "hasAddRequest", "Liz3/h;", "Liz3/h;", "dataInitListener", "Lcom/tencent/rdelivery/net/e$b;", "Lcom/tencent/rdelivery/net/e$b;", "taskResultListener", "Lcom/tencent/rdelivery/RDeliverySetting;", "Lcom/tencent/rdelivery/RDeliverySetting;", "()Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "Lcom/tencent/rdelivery/data/DataManager;", "dataManager", "Lcom/tencent/raft/standard/net/IRNetwork;", "Lcom/tencent/raft/standard/net/IRNetwork;", "getNetInterface", "()Lcom/tencent/raft/standard/net/IRNetwork;", "netInterface", "Lcom/tencent/raft/standard/task/IRTask;", "j", "Lcom/tencent/raft/standard/task/IRTask;", "getTaskInterface", "()Lcom/tencent/raft/standard/task/IRTask;", "taskInterface", "<init>", "(Lcom/tencent/rdelivery/RDeliverySetting;Lcom/tencent/rdelivery/data/DataManager;Lcom/tencent/raft/standard/net/IRNetwork;Lcom/tencent/raft/standard/task/IRTask;)V", "k", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayDeque<RDeliveryRequest> requestQueue;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean hasRunningRequest;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile boolean hasLocalDataInitialed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasAddRequest;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final iz3.h dataInitListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final b taskResultListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RDeliverySetting setting;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private DataManager dataManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRNetwork netInterface;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRTask taskInterface;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/rdelivery/net/e$b;", "", "", "isSuccess", "Lcom/tencent/rdelivery/net/RDeliveryRequest;", Const.BUNDLE_KEY_REQUEST, "", "resultData", "", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public interface b {
        void a(boolean isSuccess, @NotNull RDeliveryRequest request, @Nullable String resultData);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/rdelivery/net/e$c", "Liz3/h;", "", "onInitFinish", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class c implements iz3.h {
        c() {
        }

        @Override // iz3.h
        public void onInitFinish() {
            com.tencent.rdelivery.util.c logger = e.this.getSetting().getLogger();
            if (logger != null) {
                logger.a(com.tencent.rdelivery.util.d.a("RDelivery_RequestDispatcher", e.this.getSetting().getRdInstanceIdentifier()), "onInitFinish", e.this.getSetting().getEnableDetailLog());
            }
            e.this.hasLocalDataInitialed = true;
            e.this.i();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/rdelivery/net/e$d", "Lcom/tencent/rdelivery/net/e$b;", "", "isSuccess", "Lcom/tencent/rdelivery/net/RDeliveryRequest;", Const.BUNDLE_KEY_REQUEST, "", "resultData", "", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class d implements b {
        d() {
        }

        @Override // com.tencent.rdelivery.net.e.b
        public void a(boolean isSuccess, @NotNull RDeliveryRequest request, @Nullable String resultData) {
            Intrinsics.checkParameterIsNotNull(request, "request");
            e.this.f();
        }
    }

    public e(@NotNull RDeliverySetting setting, @NotNull DataManager dataManager, @NotNull IRNetwork netInterface, @NotNull IRTask taskInterface) {
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        Intrinsics.checkParameterIsNotNull(dataManager, "dataManager");
        Intrinsics.checkParameterIsNotNull(netInterface, "netInterface");
        Intrinsics.checkParameterIsNotNull(taskInterface, "taskInterface");
        this.setting = setting;
        this.dataManager = dataManager;
        this.netInterface = netInterface;
        this.taskInterface = taskInterface;
        this.requestQueue = new ArrayDeque<>();
        c cVar = new c();
        this.dataInitListener = cVar;
        com.tencent.rdelivery.util.c logger = setting.getLogger();
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDelivery_RequestDispatcher", setting.getRdInstanceIdentifier()), "RequestDispatcher init", setting.getEnableDetailLog());
        }
        this.dataManager.e(cVar);
        this.taskResultListener = new d();
    }

    public final void b() {
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDelivery_RequestDispatcher", this.setting.getRdInstanceIdentifier()), "clearRequestQueue", this.setting.getEnableDetailLog());
        }
        synchronized (this.requestQueue) {
            this.requestQueue.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void c(@NotNull RDeliveryRequest request) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(request, "request");
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDelivery_RequestDispatcher", this.setting.getRdInstanceIdentifier()), "enqueueRequest", this.setting.getEnableDetailLog());
        }
        request.l0(SystemClock.elapsedRealtime());
        synchronized (this.requestQueue) {
            if (!this.hasAddRequest) {
                z16 = true;
            } else {
                z16 = false;
            }
            request.Y(Boolean.valueOf(z16));
            com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
            if (logger2 != null) {
                logger2.a(com.tencent.rdelivery.util.d.a("RDelivery_RequestDispatcher", this.setting.getRdInstanceIdentifier()), "enqueueRequest isInitRequest = " + request.getIsInitRequest(), this.setting.getEnableDetailLog());
            }
            if (!this.hasAddRequest) {
                this.hasAddRequest = true;
            }
            this.requestQueue.addLast(request);
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final RDeliverySetting getSetting() {
        return this.setting;
    }

    public final void e(@NotNull DataManager manager) {
        Intrinsics.checkParameterIsNotNull(manager, "manager");
        synchronized (this.requestQueue) {
            this.dataManager.L(this.dataInitListener);
            this.dataManager = manager;
            this.hasLocalDataInitialed = false;
            this.dataManager.e(this.dataInitListener);
            b();
            this.hasAddRequest = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void f() {
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDelivery_RequestDispatcher", this.setting.getRdInstanceIdentifier()), "onRequestFinish", this.setting.getEnableDetailLog());
        }
        this.hasRunningRequest = false;
        i();
    }

    public final void g(@NotNull RDeliveryRequest request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        request.k0(SystemClock.elapsedRealtime());
        this.taskInterface.startTask(IRTask.TaskType.IO_TASK, new SendLocalStorageRequestTask(request, this.dataManager, this.taskResultListener, "requestLocalStorageData", this.setting.getLogger()));
    }

    public final void h(@NotNull RDeliveryRequest request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        request.k0(SystemClock.elapsedRealtime());
        this.taskInterface.startTask(IRTask.TaskType.NETWORK_TASK, new SendNetRequestTask(request, this.dataManager, this.setting, this.netInterface, this.taskResultListener, "requestRemoteData"));
    }

    public final void i() {
        synchronized (this.requestQueue) {
            com.tencent.rdelivery.util.c logger = this.setting.getLogger();
            if (logger != null) {
                logger.a(com.tencent.rdelivery.util.d.a("RDelivery_RequestDispatcher", this.setting.getRdInstanceIdentifier()), "triggerRequestTask requestRunning = " + this.hasRunningRequest + ", dataInitialed = " + this.hasLocalDataInitialed, this.setting.getEnableDetailLog());
            }
            if (!this.hasLocalDataInitialed) {
                return;
            }
            if (this.hasRunningRequest) {
                return;
            }
            RDeliveryRequest pollFirst = this.requestQueue.pollFirst();
            if (pollFirst != null) {
                this.hasRunningRequest = true;
                int i3 = f.f364349a[this.setting.getDataRefreshMode().ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        g(pollFirst);
                    }
                } else {
                    h(pollFirst);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
