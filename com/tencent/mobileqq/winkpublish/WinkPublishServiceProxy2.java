package com.tencent.mobileqq.winkpublish;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.api.IWinkPublishService;
import com.tencent.mobileqq.winkpublish.compact.WinkPublishServiceReporter;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001+B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\"J\u0006\u0010#\u001a\u00020\fJ\u0006\u0010$\u001a\u00020\u0017J\u0006\u0010%\u001a\u00020\fJ\u000e\u0010&\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020'J\u000e\u0010(\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010)\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010*\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "", "businessType", "", "service", "Lcom/tencent/mobileqq/winkpublish/api/IWinkPublishService;", "(ILcom/tencent/mobileqq/winkpublish/api/IWinkPublishService;)V", "getBusinessType", "()I", "getService", "()Lcom/tencent/mobileqq/winkpublish/api/IWinkPublishService;", "addExportTask", "", "winkExportTask", "Lcom/tencent/mobileqq/wink/export/model/WinkExportTask;", "addTask", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "params", "Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "addTaskListener", "listener", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener;", "addTaskListener2", "", "cancelExportTask", "missionId", "", "cancelTaskWithId", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "dc5507Report", "reportData", "Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData;", "getRunningTasks", "", "hasRunningTask", "init", "isBinderAlive", "qualityReport", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "removeTaskListener", "resumeTaskWithId", "updateTaskWithId", "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkPublishServiceProxy2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "WinkPublishServiceProxy2";
    private static boolean initError;
    private final int businessType;

    @NotNull
    private final IWinkPublishService service;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2$Companion;", "", "()V", "TAG", "", "initError", "", "getInitError$annotations", "getInitError", "()Z", "setInitError", "(Z)V", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getInitError() {
            return WinkPublishServiceProxy2.initError;
        }

        public final void setInitError(boolean z16) {
            WinkPublishServiceProxy2.initError = z16;
        }

        Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInitError$annotations() {
        }
    }

    public WinkPublishServiceProxy2(int i3, @NotNull IWinkPublishService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.businessType = i3;
        this.service = service;
    }

    public static final boolean getInitError() {
        return INSTANCE.getInitError();
    }

    public static final void setInitError(boolean z16) {
        INSTANCE.setInitError(z16);
    }

    public final boolean addExportTask(@Nullable WinkExportTask winkExportTask) {
        try {
            this.service.addExportTask(winkExportTask);
            return true;
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[addExportTask] ", e16);
            return false;
        }
    }

    @Nullable
    public final TaskInfo addTask(@NotNull WinkPublishParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            return this.service.addTask(params);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[addTask] ", e16);
            return null;
        }
    }

    @Deprecated(message = "\u975e\u4e3b\u8fdb\u7a0b\u8c03\u7528\u65f6\u6709\u95ee\u9898\uff0c\u8bf7\u4f7f\u7528addListener2\u66ff\u6362", replaceWith = @ReplaceWith(expression = "addTaskListener2", imports = {}))
    public final boolean addTaskListener(@NotNull ITaskListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d(TAG, 1, "[addTaskListener]");
        try {
            this.service.addTaskListener(listener, this.businessType);
            return true;
        } catch (RemoteException e16) {
            QLog.w(TAG, 1, "[addTaskListener]", e16);
            return false;
        } catch (Exception e17) {
            QLog.w(TAG, 1, "[addTaskListener]", e17);
            return false;
        }
    }

    public final void addTaskListener2(@NotNull ITaskListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d(TAG, 1, "[addTaskListener2]");
        try {
            this.service.addTaskListener2(listener, this.businessType);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[addTaskListener2]", e16);
        }
    }

    public final boolean cancelExportTask(@NotNull String missionId) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        try {
            this.service.cancelExportTask(missionId);
            return true;
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[cancelExportTask] ", e16);
            return false;
        }
    }

    public final void cancelTaskWithId(long taskId) {
        try {
            this.service.cancelTaskWithId(taskId, this.businessType);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[cancelTaskWithId] ", e16);
        }
    }

    public final void dc5507Report(@NotNull WinkDc5507ReportData reportData) {
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        try {
            this.service.dc5507Report(reportData, this.businessType);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[dc5507Report] ", e16);
        }
    }

    public final int getBusinessType() {
        return this.businessType;
    }

    @NotNull
    public final List<TaskInfo> getRunningTasks() {
        List<TaskInfo> emptyList;
        try {
            List<TaskInfo> runningTasks = this.service.getRunningTasks(this.businessType);
            Intrinsics.checkNotNullExpressionValue(runningTasks, "service.getRunningTasks(businessType)");
            return runningTasks;
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[getRunningTasks] ", e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    @NotNull
    public final IWinkPublishService getService() {
        return this.service;
    }

    public final boolean hasRunningTask() {
        try {
            return this.service.hasRunningTask(this.businessType);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[hasRunningTask] ", e16);
            return true;
        }
    }

    public final void init() {
        try {
            this.service.init(this.businessType);
            initError = false;
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[init] ", e16);
            if (e16 instanceof DeadObjectException) {
                ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId("T_CATCH_IMPORTANT_INFO").setExt1(WinkPublishServiceReporter.SCENE_WINKPUBLISH_SERVICE).setExt2("8").setExt3(String.valueOf(MobileQQ.sProcessId)).setExt4(String.valueOf(this.businessType)));
                initError = true;
            }
        }
    }

    public final boolean isBinderAlive() {
        try {
            return this.service.asBinder().isBinderAlive();
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[isBinderAlive] ", e16);
            return false;
        }
    }

    public final void qualityReport(@NotNull WinkPublishQualityReportData reportData) {
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        try {
            this.service.qualityReport(reportData, this.businessType);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[qualityReport] ", e16);
        }
    }

    public final void removeTaskListener(@NotNull ITaskListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d(TAG, 1, "[removeTaskListener]");
        try {
            this.service.removeTaskListener(listener, this.businessType);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[removeTaskListener]", e16);
        }
    }

    public final void resumeTaskWithId(long taskId) {
        try {
            this.service.resumeTaskWithId(taskId, this.businessType);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[resumeTaskWithId] ", e16);
        }
    }

    public final boolean updateTaskWithId(long taskId, @NotNull WinkPublishParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            return this.service.updateTaskWithId(taskId, params);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[updateTaskWithId] ", e16);
            return false;
        }
    }
}
