package com.tencent.mobileqq.guild.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.summary.api.IGuildSummaryUnreadLimitService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildDelayInitializeServiceImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildDelayInitializeService;", "", "source", "", "runTask", "registerKernelListener", "unRegisterKernelListener", "Lmqq/app/AppRuntime;", "appRuntime", "", "isWrapperSessionReady", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/api/IGuildDelayInitializeService$a;", "task", "scheduleTask", "allowDelayTaskRunning", "checkSessionInitComplete", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "getGuildTabUnreadCountSafely", "Ljava/util/concurrent/atomic/AtomicBoolean;", "allowRunningDelayTask", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "taskQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "needFetchUnreadAfterAllow", "Landroid/content/BroadcastReceiver;", "kernelInitCompleteListener", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildDelayInitializeServiceImpl implements IGuildDelayInitializeService {

    @NotNull
    private static final String TAG = "Guild.perf.GuildDelayInitializeServiceImpl";

    @NotNull
    private final AtomicBoolean allowRunningDelayTask = new AtomicBoolean(false);

    @NotNull
    private final ConcurrentLinkedQueue<IGuildDelayInitializeService.InitializeTask> taskQueue = new ConcurrentLinkedQueue<>();

    @NotNull
    private final AtomicBoolean needFetchUnreadAfterAllow = new AtomicBoolean(false);

    @NotNull
    private final BroadcastReceiver kernelInitCompleteListener = new BroadcastReceiver() { // from class: com.tencent.mobileqq.guild.api.impl.GuildDelayInitializeServiceImpl$kernelInitCompleteListener$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            boolean isWrapperSessionReady;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            AppRuntime Q0 = ch.Q0();
            QLog.i("Guild.perf.GuildDelayInitializeServiceImpl", 1, "receive msg_kernel init complete");
            isWrapperSessionReady = GuildDelayInitializeServiceImpl.this.isWrapperSessionReady(Q0);
            if (isWrapperSessionReady) {
                GuildDelayInitializeServiceImpl.this.allowDelayTaskRunning();
            } else {
                QLog.e("Guild.perf.GuildDelayInitializeServiceImpl", 1, "receive kernel init fail, session is null");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isWrapperSessionReady(AppRuntime appRuntime) {
        IQQNTWrapperSession iQQNTWrapperSession;
        boolean z16;
        IGProSession iGProSession;
        IKernelService iKernelService;
        Boolean bool = null;
        if (appRuntime != null && (iKernelService = (IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            iQQNTWrapperSession = iKernelService.getWrapperSession();
        } else {
            iQQNTWrapperSession = null;
        }
        if (appRuntime != null && (iGProSession = (IGProSession) appRuntime.getRuntimeService(IGProSession.class, "")) != null) {
            bool = Boolean.valueOf(iGProSession.isInit());
        }
        if (appRuntime != null && appRuntime.isLogin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && iQQNTWrapperSession != null && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return true;
        }
        return false;
    }

    private final void registerKernelListener() {
        try {
            IntentFilter intentFilter = new IntentFilter("com.tencent.mobileqq.action.ON_KERNEL_INIT_COMPLETE");
            BaseApplication context = BaseApplication.getContext();
            if (context != null) {
                context.registerReceiver(this.kernelInitCompleteListener, intentFilter);
            }
            QLog.i(TAG, 1, "register KernelInitCompleteListener");
        } catch (Exception e16) {
            QLog.i(TAG, 1, "registerReceiver", e16);
        }
    }

    private final void runTask(final String source) {
        IGuildDelayInitializeService.InitializeTask initializeTask;
        Logger.f235387a.d().i(TAG, 1, "runTask from " + source + ", tasks size: " + this.taskQueue.size());
        if (this.taskQueue.isEmpty()) {
            return;
        }
        ThreadUtils threadUtils = ThreadUtils.f235400a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            while ((!this.taskQueue.isEmpty()) && (initializeTask = (IGuildDelayInitializeService.InitializeTask) this.taskQueue.poll()) != null) {
                Intrinsics.checkNotNullExpressionValue(initializeTask, "taskQueue.poll() ?: return@ensureUiThread");
                Logger.f235387a.d().i(TAG, 1, "runTask #" + initializeTask.getName() + " from " + source + ", ensureUiThread");
                initializeTask.b().invoke();
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.api.impl.GuildDelayInitializeServiceImpl$runTask$$inlined$ensureUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                IGuildDelayInitializeService.InitializeTask initializeTask2;
                while ((!GuildDelayInitializeServiceImpl.this.taskQueue.isEmpty()) && (initializeTask2 = (IGuildDelayInitializeService.InitializeTask) GuildDelayInitializeServiceImpl.this.taskQueue.poll()) != null) {
                    Intrinsics.checkNotNullExpressionValue(initializeTask2, "taskQueue.poll() ?: return@ensureUiThread");
                    Logger.f235387a.d().i("Guild.perf.GuildDelayInitializeServiceImpl", 1, "runTask #" + initializeTask2.getName() + " from " + source + ", ensureUiThread");
                    initializeTask2.b().invoke();
                }
            }
        });
    }

    private final void unRegisterKernelListener() {
        try {
            BaseApplication context = BaseApplication.getContext();
            if (context != null) {
                context.unregisterReceiver(this.kernelInitCompleteListener);
            }
            QLog.i(TAG, 1, "unRegister KernelInitCompleteListener");
        } catch (Exception e16) {
            QLog.i(TAG, 1, "unRegisterKernelListener", e16);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDelayInitializeService
    public void allowDelayTaskRunning() {
        Logger.f235387a.d().i(TAG, 1, "allowDelayTaskRunning");
        if (this.allowRunningDelayTask.compareAndSet(false, true)) {
            runTask("runPendingDelayTask");
            if (this.needFetchUnreadAfterAllow.compareAndSet(true, false)) {
                ((IGuildSummaryUnreadLimitService) ch.R0(IGuildSummaryUnreadLimitService.class)).getGuildTabUnreadCount();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDelayInitializeService
    public void checkSessionInitComplete() {
        Logger.f235387a.d().i(TAG, 1, "checkSessionInitComplete");
        if (isWrapperSessionReady(ch.Q0())) {
            QLog.i(TAG, 1, "receive kernel init complete");
            allowDelayTaskRunning();
        } else {
            QLog.e(TAG, 1, "receive kernel init fail, session is null");
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDelayInitializeService
    @NotNull
    public UnreadInfo.a getGuildTabUnreadCountSafely() {
        if (this.allowRunningDelayTask.get()) {
            if (isWrapperSessionReady(ch.Q0())) {
                if (this.allowRunningDelayTask.get()) {
                    return ((IGuildSummaryUnreadLimitService) ch.R0(IGuildSummaryUnreadLimitService.class)).getGuildTabUnreadCount();
                }
                QLog.e(TAG, 1, "getGuildTabUnreadCountSafely fail, allowRunningDelayTask is false");
                return new UnreadInfo.a(false, 0, 0, 7, null);
            }
            QLog.e(TAG, 1, "getGuildTabUnreadCountSafely fail, session is null");
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent("gpro_quality#event#delay_service_init_error");
            return new UnreadInfo.a(false, 0, 0, 7, null);
        }
        this.needFetchUnreadAfterAllow.compareAndSet(false, true);
        Logger logger = Logger.f235387a;
        RuntimeException runtimeException = new RuntimeException();
        Logger.b bVar = new Logger.b();
        bVar.a().add("getGuildTabUnreadCountSafely too early");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(TAG, 1, (String) it.next(), runtimeException);
        }
        return new UnreadInfo.a(false, 0, 0, 7, null);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        if (isWrapperSessionReady(appRuntime)) {
            QLog.i(TAG, 1, "kernel init complete");
            allowDelayTaskRunning();
        } else {
            QLog.i(TAG, 1, "kernel has not inited");
            registerKernelListener();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        Logger.f235387a.d().i(TAG, 1, "onDestroy, tasks size = " + this.taskQueue.size());
        this.allowRunningDelayTask.set(false);
        unRegisterKernelListener();
        this.taskQueue.clear();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDelayInitializeService
    public void scheduleTask(@NotNull IGuildDelayInitializeService.InitializeTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        Logger logger = Logger.f235387a;
        logger.d().i(TAG, 1, "scheduleTask #" + task.getName());
        if (this.allowRunningDelayTask.get()) {
            logger.d().i(TAG, 1, "scheduleTask direct run task #" + task.getName());
            task.b().invoke();
            return;
        }
        this.taskQueue.offer(task);
        if (this.allowRunningDelayTask.get()) {
            runTask("scheduleTask");
        }
    }
}
