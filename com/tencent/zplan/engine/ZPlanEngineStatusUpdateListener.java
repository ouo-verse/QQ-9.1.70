package com.tencent.zplan.engine;

import androidx.annotation.Keep;
import com.tencent.upload.report.UploadQualityReportBuilder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0017J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0007H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", "engineDestroy", "", "engineFirstFrame", "engineInitFinish", "success", "", "engineInversePurged", "enginePurged", "enginePurging", "engineSuspended", "hotPatchDownloadFailed", "errorCode", "", "errorMessage", "", "serviceConnected", UploadQualityReportBuilder.STATE_CONNECT, "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface ZPlanEngineStatusUpdateListener {
    void engineDestroy();

    @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
    void engineFirstFrame();

    void engineInitFinish(boolean success);

    void engineInversePurged();

    void enginePurged();

    void enginePurging();

    void engineSuspended();

    void hotPatchDownloadFailed(int errorCode, @NotNull String errorMessage);

    void serviceConnected(boolean connect);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {
        public static void h(@NotNull ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener, int i3, @NotNull String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        }

        public static void a(@NotNull ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener) {
        }

        @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
        public static void b(@NotNull ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener) {
        }

        public static void d(@NotNull ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener) {
        }

        public static void e(@NotNull ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener) {
        }

        public static void f(@NotNull ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener) {
        }

        public static void g(@NotNull ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener) {
        }

        public static void c(@NotNull ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener, boolean z16) {
        }

        public static void i(@NotNull ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener, boolean z16) {
        }
    }
}
