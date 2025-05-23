package com.tencent.mobileqq.qqlive.api.monitor.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerTrafficFlowReporter;
import com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerTrafficFlowReporterNoOp;
import com.tencent.mobileqq.qqlive.api.monitor.IResourceProvider;
import com.tencent.mobileqq.qqlive.api.monitor.ISuperPlayerTrafficFlowReportApi;
import com.tencent.mobileqq.qqlive.api.monitor.ISuperPlayerTrafficFlowReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.superplayer.api.ISuperPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/monitor/impl/SuperPlayerTrafficFlowReportApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/monitor/ISuperPlayerTrafficFlowReportApi;", "()V", "enableTrafficFlowReport", "", "logger", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "getTrafficFlowReporter", "Lcom/tencent/mobileqq/qqlive/api/monitor/ISuperPlayerTrafficFlowReporter;", "scene", "", "superPlayer", "Lcom/tencent/superplayer/api/ISuperPlayer;", "resourceProvider", "Lcom/tencent/mobileqq/qqlive/api/monitor/IResourceProvider;", "Companion", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class SuperPlayerTrafficFlowReportApiImpl implements ISuperPlayerTrafficFlowReportApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final Companion Companion;

    @Deprecated
    @NotNull
    private static final String TAG = "SuperPlayerTrafficFlowReportApiImpl";
    private final boolean enableTrafficFlowReport;

    @NotNull
    private final IAegisLogApi logger;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/monitor/impl/SuperPlayerTrafficFlowReportApiImpl$Companion;", "", "()V", "TAG", "", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    private static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42808);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            Companion = new Companion(null);
        }
    }

    public SuperPlayerTrafficFlowReportApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.enableTrafficFlowReport = true;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.logger = (IAegisLogApi) api;
    }

    @Override // com.tencent.mobileqq.qqlive.api.monitor.ISuperPlayerTrafficFlowReportApi
    @NotNull
    public ISuperPlayerTrafficFlowReporter getTrafficFlowReporter(@NotNull String scene, @Nullable ISuperPlayer superPlayer, @NotNull IResourceProvider resourceProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ISuperPlayerTrafficFlowReporter) iPatchRedirector.redirect((short) 2, this, scene, superPlayer, resourceProvider);
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        this.logger.i(TAG, "get reporter->enable:" + this.enableTrafficFlowReport + ",superPlayer:" + superPlayer);
        if (this.enableTrafficFlowReport && superPlayer != null) {
            return new RoomSuperPlayerTrafficFlowReporter(scene, new WeakReference(superPlayer), resourceProvider);
        }
        return new RoomSuperPlayerTrafficFlowReporterNoOp();
    }
}
