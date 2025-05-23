package com.tencent.qqperf.debug.report;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.perf.memory.dump.c;
import com.tencent.pb.performance.ClientPerformance$SsoCrashReportRequest;
import com.tencent.pb.performance.ClientPerformance$SsoMonitorCollectorReportRequest;
import com.tencent.pb.performance.ClientPerformance$SsoMonitorCollectorReportResponse;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import com.tencent.util.DevelopInfoUtils;
import iy3.a;
import java.util.Set;
import jy3.CrashProblem;
import jy3.MainBlockMethodProblem;
import jy3.MemoryLeakProblem;
import jy3.e;
import jy3.f;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\nH\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J&\u0010\u0015\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016H\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqperf/debug/report/PerfProblemBusinessHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "T", "Ljy3/f;", "data", "", Constants.MMCCID, "Ljy3/e;", "Lcom/tencent/pb/performance/ClientPerformance$SsoMonitorCollectorReportRequest;", "F2", "Ljy3/a;", "Lcom/tencent/pb/performance/ClientPerformance$SsoCrashReportRequest;", "E2", "", "", "getCommandList", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "d", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PerfProblemBusinessHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqperf/debug/report/PerfProblemBusinessHandler$a;", "", "T", "Ljy3/f;", "data", "", "a", "", "b", "c", "", "SSO_CMD", "Ljava/lang/String;", "SSO_CRASH_CMD", "SSO_HIGH_POWER_CMD", "TAG", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqperf.debug.report.PerfProblemBusinessHandler$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final <T> void a(f<T> data) {
            String first;
            boolean z16 = data instanceof MainBlockMethodProblem;
            if (!z16 && !(data instanceof MemoryLeakProblem)) {
                first = null;
            } else {
                first = c.f257726a.f().getFirst();
                QLog.d("PerfProblemBusinessHandler", 1, "addLogUrlToData, type: " + data.getClass().getSimpleName() + ", logUrl:" + first);
            }
            if (z16) {
                ((MainBlockMethodProblem) data).b(first);
            } else if (data instanceof MemoryLeakProblem) {
                ((MemoryLeakProblem) data).b(first);
            }
        }

        private final boolean b() {
            if (Intrinsics.areEqual(DevelopInfoUtils.getBranchName(true), DevelopInfoUtils.DEFAULT_BRANCH_NAME)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("PerfProblemBusinessHandler", 4, "not provide branch name, don't report");
                }
                return true;
            }
            if (!AppSetting.isPublicVersion() && !AppSetting.isGrayVersion()) {
                return false;
            }
            QLog.d("PerfProblemBusinessHandler", 4, "not debug version, don't report");
            return true;
        }

        public final <T> void c(@NotNull f<T> data) {
            AppRuntime peekAppRuntime;
            Intrinsics.checkNotNullParameter(data, "data");
            if (b() || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
                return;
            }
            if (!(peekAppRuntime instanceof AppInterface)) {
                QLog.d("PerfProblemBusinessHandler", 4, "is not AppInterface, don't report");
                return;
            }
            a(data);
            BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(PerfProblemBusinessHandler.class.getName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.qqperf.debug.report.PerfProblemBusinessHandler");
            ((PerfProblemBusinessHandler) businessHandler).G2(data);
        }

        Companion() {
        }
    }

    public PerfProblemBusinessHandler(@Nullable AppInterface appInterface) {
        super(appInterface);
    }

    private final ClientPerformance$SsoCrashReportRequest E2(CrashProblem data) {
        ClientPerformance$SsoCrashReportRequest clientPerformance$SsoCrashReportRequest = new ClientPerformance$SsoCrashReportRequest();
        if (clientPerformance$SsoCrashReportRequest.branch_name.get().equals("")) {
            clientPerformance$SsoCrashReportRequest.branch_name.set(DevelopInfoUtils.getBranchName(true));
        }
        data.a(clientPerformance$SsoCrashReportRequest);
        return clientPerformance$SsoCrashReportRequest;
    }

    private final ClientPerformance$SsoMonitorCollectorReportRequest F2(e data) {
        ClientPerformance$SsoMonitorCollectorReportRequest clientPerformance$SsoMonitorCollectorReportRequest = new ClientPerformance$SsoMonitorCollectorReportRequest();
        clientPerformance$SsoMonitorCollectorReportRequest.app.set(1);
        if (clientPerformance$SsoMonitorCollectorReportRequest.branch_name.get().equals("")) {
            clientPerformance$SsoMonitorCollectorReportRequest.branch_name.set(DevelopInfoUtils.getBranchName(true));
        }
        data.a(clientPerformance$SsoMonitorCollectorReportRequest);
        return clientPerformance$SsoMonitorCollectorReportRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void G2(f<T> data) {
        ToServiceMsg toServiceMsg;
        MessageMicro messageMicro;
        if (AppSetting.isDebugVersion()) {
            QLog.d("PerfProblemBusinessHandler", 1, "report " + data);
        }
        if (data instanceof CrashProblem) {
            toServiceMsg = createToServiceMsg("trpc.ep.client_performance.CollectorService.SsoCrashReport");
            messageMicro = E2((CrashProblem) data);
        } else if (data instanceof e) {
            toServiceMsg = createToServiceMsg("trpc.ep.client_performance.CollectorService.SsoMonitorCollectorReport");
            messageMicro = F2((e) data);
        } else {
            toServiceMsg = null;
            messageMicro = null;
        }
        if (toServiceMsg != null) {
            if (messageMicro != null) {
                toServiceMsg.putWupBuffer(messageMicro.toByteArray());
            }
            super.sendPbReq(toServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"trpc.ep.client_performance.CollectorService.SsoMonitorCollectorReport", "trpc.ep.client_performance.CollectorService.SsoCrashReport", "trpc.ep.client_performance.CollectorService.SsoHighPowerConsumptionReport"});
        return of5;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        int i3;
        String str;
        if (req == null) {
            return;
        }
        String serviceCmd = req.getServiceCmd();
        if (!Intrinsics.areEqual("trpc.ep.client_performance.CollectorService.SsoMonitorCollectorReport", serviceCmd) && !Intrinsics.areEqual("trpc.ep.client_performance.CollectorService.SsoCrashReport", serviceCmd) && !Intrinsics.areEqual("trpc.ep.client_performance.CollectorService.SsoHighPowerConsumptionReport", serviceCmd)) {
            QLog.d("PerfProblemBusinessHandler", 1, "fail request serviceCmd: " + serviceCmd);
            return;
        }
        if (data != null && res != null && res.isSuccess()) {
            ClientPerformance$SsoMonitorCollectorReportResponse clientPerformance$SsoMonitorCollectorReportResponse = new ClientPerformance$SsoMonitorCollectorReportResponse();
            try {
                clientPerformance$SsoMonitorCollectorReportResponse.mergeFrom((byte[]) data);
                long j3 = clientPerformance$SsoMonitorCollectorReportResponse.code.get();
                String str2 = clientPerformance$SsoMonitorCollectorReportResponse.f342165msg.get();
                if (j3 != 0) {
                    QLog.e("PerfProblemBusinessHandler", 1, "uploadPerfData code = " + j3 + "  msg: " + str2);
                    return;
                }
                QLog.d("PerfProblemBusinessHandler", 1, "uploadPerfData suc.");
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("PerfProblemBusinessHandler", 1, "func uploadPerfData ends, errInfo:" + e16.getMessage());
                return;
            } catch (OutOfMemoryError unused) {
                QLog.e("PerfProblemBusinessHandler", 1, "uploadPerfData oom");
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("request failed. errCode: ");
        if (res != null) {
            i3 = res.getResultCode();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append(" errMsg: ");
        if (res != null) {
            str = res.getBusinessFailMsg();
        } else {
            str = "";
        }
        sb5.append(str);
        QLog.e("PerfProblemBusinessHandler", 1, sb5.toString());
    }
}
