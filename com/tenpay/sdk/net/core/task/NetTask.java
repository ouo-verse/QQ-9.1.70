package com.tenpay.sdk.net.core.task;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.core.client.INetClient;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.core.request.NetRequest;
import com.tenpay.sdk.net.core.result.NetResult;
import com.tenpay.sdk.net.core.statistic.StatisticInfo;
import com.tenpay.sdk.net.core.task.base.Priority;
import com.tenpay.sdk.net.core.task.base.PriorityAbility;
import com.tenpay.sdk.net.core.task.base.Task;
import com.tenpay.sdk.net.core.task.base.TaskStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004:\u0001-B%\u0012\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\u0016\u001a\u00020\u00172\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u0015J\r\u0010\u0019\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001dH&J\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dJ\b\u0010 \u001a\u00020!H\u0016J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u001dH\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0015\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010)J\u0015\u0010*\u001a\u00020\u00172\u0006\u0010(\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010)J\b\u0010+\u001a\u00020\u0017H\u0016J\u0006\u0010,\u001a\u00020\u001dR\u001b\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0000\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/tenpay/sdk/net/core/task/NetTask;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tenpay/sdk/net/core/result/NetResult;", "Lcom/tenpay/sdk/net/core/task/base/Task;", "Lcom/tenpay/sdk/net/core/task/base/PriorityAbility;", "client", "Lcom/tenpay/sdk/net/core/client/INetClient;", "netRequest", "Lcom/tenpay/sdk/net/core/request/NetRequest;", "(Lcom/tenpay/sdk/net/core/client/INetClient;Lcom/tenpay/sdk/net/core/request/NetRequest;)V", "getClient", "()Lcom/tenpay/sdk/net/core/client/INetClient;", "requestCallback", "Lcom/tenpay/sdk/net/core/callback/NetCallback;", "statisticInfo", "Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;", "getStatisticInfo", "()Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;", "status", "Lcom/tenpay/sdk/net/core/task/base/TaskStatus;", "taskExecutorObserver", "Lcom/tenpay/sdk/net/core/task/base/Task$onTaskFinishCallback;", "addTaskExecutorObserver", "", "callback", "buildResult", "()Lcom/tenpay/sdk/net/core/result/NetResult;", "cancel", "getCallbackUrl", "", "getCmd", "getHost", "getPriority", "Lcom/tenpay/sdk/net/core/task/base/Priority;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "Lcom/tenpay/sdk/net/core/task/base/TaskStatus$Status;", "id", "isCanceled", "", "onSendRequestFinish", "result", "(Lcom/tenpay/sdk/net/core/result/NetResult;)V", "onTaskFinish", TencentLocation.RUN_MODE, "tag", "ResponseProcessor", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public abstract class NetTask<R extends NetResult> implements Task, PriorityAbility {

    @NotNull
    private final INetClient<?, R> client;

    @NotNull
    private final NetRequest<R> netRequest;

    @Nullable
    private NetCallback<NetResult> requestCallback;

    @NotNull
    private final StatisticInfo statisticInfo;

    @NotNull
    private TaskStatus status;

    @Nullable
    private Task.onTaskFinishCallback<NetTask<?>> taskExecutorObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0007\u001a\u00028\u0002H&\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/sdk/net/core/task/NetTask$ResponseProcessor;", "RSP", "RE", "", "processResponse", "", "response", "result", "(Ljava/lang/Object;Ljava/lang/Object;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface ResponseProcessor<RSP, RE> {
        void processResponse(@Nullable RSP response, RE result);
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskStatus.Status.values().length];
            try {
                iArr[TaskStatus.Status.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskStatus.Status.FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TaskStatus.Status.CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TaskStatus.Status.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NetTask(@NotNull INetClient<?, R> client, @NotNull NetRequest<R> netRequest) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(netRequest, "netRequest");
        this.client = client;
        this.netRequest = netRequest;
        this.status = new TaskStatus();
        this.requestCallback = netRequest.getNetCallback();
        this.statisticInfo = new StatisticInfo();
    }

    public final void addTaskExecutorObserver(@NotNull Task.onTaskFinishCallback<NetTask<?>> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.taskExecutorObserver = callback;
    }

    @NotNull
    public abstract R buildResult();

    @Override // com.tenpay.sdk.net.core.task.base.Task
    public void cancel() {
        TaskStatus.Status status = getStatus();
        this.status.changeStatus(TaskStatus.Status.CANCEL);
        if (status != TaskStatus.Status.RUNNING) {
            R buildResult = buildResult();
            buildResult.setStatisticsInfo(this.statisticInfo);
            onTaskFinish(buildResult);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Comparable
    public int compareTo(@NotNull PriorityAbility priorityAbility) {
        return PriorityAbility.DefaultImpls.compareTo(this, priorityAbility);
    }

    @NotNull
    public abstract String getCallbackUrl();

    @NotNull
    public final INetClient<?, R> getClient() {
        return this.client;
    }

    @NotNull
    public abstract String getCmd();

    @Nullable
    public final String getHost() {
        return null;
    }

    @Override // com.tenpay.sdk.net.core.task.base.PriorityAbility
    @NotNull
    public Priority getPriority() {
        return this.netRequest.getPriority();
    }

    @NotNull
    public final StatisticInfo getStatisticInfo() {
        return this.statisticInfo;
    }

    @NotNull
    public final TaskStatus.Status getStatus() {
        return this.status.getStatus();
    }

    @Override // com.tenpay.sdk.net.core.task.base.Task
    @NotNull
    public String id() {
        return String.valueOf(this.netRequest.getRequestId());
    }

    @Override // com.tenpay.sdk.net.core.task.base.Task
    public boolean isCanceled() {
        if (this.status.getStatus() == TaskStatus.Status.CANCEL) {
            return true;
        }
        return false;
    }

    public void onSendRequestFinish(@NotNull R result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.statisticInfo.setException(result.getThrowable());
        TaskStatus.Status status = getStatus();
        TaskStatus.Status status2 = TaskStatus.Status.CANCEL;
        if (status != status2) {
            if (result.getIsConnectSucceed()) {
                status2 = TaskStatus.Status.SUCCESS;
            } else {
                status2 = TaskStatus.Status.FAIL;
            }
        }
        this.status.changeStatus(status2);
        onTaskFinish(result);
    }

    public void onTaskFinish(@NotNull R result) {
        Intrinsics.checkNotNullParameter(result, "result");
        StatisticInfo statisticInfo = this.statisticInfo;
        statisticInfo.setCanceled(isCanceled());
        statisticInfo.setBizSucceed(result.getIsBizSucceed());
        statisticInfo.setEndTime(System.currentTimeMillis());
        int i3 = WhenMappings.$EnumSwitchMapping$0[getStatus().ordinal()];
        boolean z16 = true;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 && i3 != 4) {
                    ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, tag(), "callback unknown <=== wrong status:" + this.status, null, 4, null);
                    NetCallback<NetResult> netCallback = this.requestCallback;
                    if (netCallback != null) {
                        netCallback.onNetFailed(getCallbackUrl(), result);
                    }
                    this.requestCallback = null;
                } else {
                    ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, tag(), "callback cancel <===[" + result + "]", null, 4, null);
                    NetCallback<NetResult> netCallback2 = this.requestCallback;
                    if (netCallback2 != null) {
                        netCallback2.onNetFailed(getCallbackUrl(), result);
                    }
                    this.requestCallback = null;
                }
            } else {
                ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, tag(), "callback fail <=== " + result.getBizResponse(), null, 4, null);
                NetCallback<NetResult> netCallback3 = this.requestCallback;
                if (netCallback3 != null) {
                    netCallback3.onNetFailed(getCallbackUrl(), result);
                }
                this.requestCallback = null;
            }
        } else {
            ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, tag(), "callback success <=== " + result, null, 4, null);
            NetCallback<NetResult> netCallback4 = this.requestCallback;
            if (netCallback4 != null) {
                netCallback4.onNetSucceed(getCallbackUrl(), result);
            }
            this.requestCallback = null;
        }
        Task.onTaskFinishCallback<NetTask<?>> ontaskfinishcallback = this.taskExecutorObserver;
        if (ontaskfinishcallback != null) {
            if (getStatus() == TaskStatus.Status.PAUSE) {
                z16 = false;
            }
            ontaskfinishcallback.onTaskFinish(this, z16);
        }
        this.taskExecutorObserver = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        StatisticInfo statisticInfo = this.statisticInfo;
        statisticInfo.setFlowId(hashCode());
        statisticInfo.setKey(getCmd());
        statisticInfo.setStartTime(System.currentTimeMillis());
        this.status.changeStatus(TaskStatus.Status.RUNNING);
        this.statisticInfo.setWaitThreadTime(System.currentTimeMillis() - this.statisticInfo.getStartTime());
        this.client.sendRequest(this, new Function1<R, Unit>(this) { // from class: com.tenpay.sdk.net.core.task.NetTask$run$2
            final /* synthetic */ NetTask<R> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((NetResult) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Incorrect types in method signature: (TR;)V */
            public final void invoke(@NotNull NetResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                this.this$0.onSendRequestFinish(result);
            }
        });
    }

    @NotNull
    public final String tag() {
        return "HttpTask(" + Thread.currentThread().getName() + ")[" + id() + "]";
    }
}
