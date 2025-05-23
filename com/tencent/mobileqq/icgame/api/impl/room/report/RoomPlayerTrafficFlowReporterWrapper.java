package com.tencent.mobileqq.icgame.api.impl.room.report;

import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/impl/room/report/RoomPlayerTrafficFlowReporterWrapper;", "Lb32/a;", "", "startTime", "endTime", "", "onFirstFrameCome", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "init", "unInit", "Lcom/tencent/mobileqq/icgame/api/impl/room/report/RoomPlayerTrafficFlowReporter;", "actualReporter", "Lcom/tencent/mobileqq/icgame/api/impl/room/report/RoomPlayerTrafficFlowReporter;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLogger", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "<init>", "(Lcom/tencent/mobileqq/icgame/api/impl/room/report/RoomPlayerTrafficFlowReporter;)V", "Companion", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class RoomPlayerTrafficFlowReporterWrapper extends b32.a {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final String TAG = "RoomPlayerTrafficFlowReporterWrapper";

    @NotNull
    private final RoomPlayerTrafficFlowReporter actualReporter;

    @NotNull
    private final IAegisLogApi aegisLogger;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/impl/room/report/RoomPlayerTrafficFlowReporterWrapper$Companion;", "", "()V", "TAG", "", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    public RoomPlayerTrafficFlowReporterWrapper(@NotNull RoomPlayerTrafficFlowReporter actualReporter) {
        Intrinsics.checkNotNullParameter(actualReporter, "actualReporter");
        this.actualReporter = actualReporter;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
    }

    public final void init() {
        this.actualReporter.init();
    }

    @Override // b32.a
    public void onFirstFrameCome(long startTime, long endTime) {
        this.actualReporter.onFirstFrameCome();
        this.aegisLogger.i(TAG, "onFirstFrameCome");
    }

    @Override // b32.a
    public void onPause() {
        this.actualReporter.onPause();
        this.aegisLogger.i(TAG, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // b32.a
    public void onStop() {
        this.aegisLogger.i(TAG, DKHippyEvent.EVENT_STOP);
    }

    public final void unInit() {
        this.actualReporter.unInit();
    }
}
