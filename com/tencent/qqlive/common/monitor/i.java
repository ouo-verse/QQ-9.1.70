package com.tencent.qqlive.common.monitor;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqperf.reporter.flow.TrafficFlowReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014J\b\u0010\r\u001a\u00020\u0004H\u0014J\b\u0010\u000e\u001a\u00020\u0004H\u0014J\b\u0010\u000f\u001a\u00020\u0004H\u0014J\b\u0010\u0010\u001a\u00020\u0004H\u0014J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0004J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0004R\u001a\u0010\u001a\u001a\u00020\u00198\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u001e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u00198\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001dR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqlive/common/monitor/i;", "Lcom/tencent/qqlive/common/monitor/m;", "Ljava/lang/Runnable;", "runnable", "", "runOnUiThread", "init", "unInit", "Lcom/tencent/qqlive/common/monitor/j;", "signal", "onNotify", "onNetWifi2Mobile", "onNetNone2Mobile", "onNetMobile2Wifi", "onNetMobile2None", "onProcess2Background", "onProcess2Foreground", "Lcom/tencent/qqperf/reporter/flow/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "report", "", "isMobileNetwork", "", "valueInByte", "byte2KByte", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "logger", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "getLogger", "()Lcom/tencent/qqlive/common/api/IAegisLogApi;", "TAG", "getTAG", "", "signals", "Ljava/util/List;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public class i implements m {
    private static final int BYTE_TO_K_BYTE_FACTOR = 1024;

    @NotNull
    public static final String ENTRANCE_NET_CHANGE_MOBILE_2_NONE = "entrance_net_change_mobile_2_none";

    @NotNull
    public static final String ENTRANCE_NET_CHANGE_MOBILE_2_WIFI = "entrance_net_change_mobile_2_wifi";

    @NotNull
    public static final String ENTRANCE_PROCESS_CHANGE_FOREGROUND_2_BACKGROUND = "entrance_process_change_foreground_2_background";

    @NotNull
    private final String TAG;

    @NotNull
    private final IAegisLogApi logger;

    @NotNull
    private final String scene;

    @NotNull
    private final List<j> signals;

    public i(@NotNull String scene) {
        List<j> listOf;
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.scene = scene;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.logger = (IAegisLogApi) api;
        this.TAG = "QQLiveTrafficFlowReporter@" + hashCode();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new j[]{new d(), new c(), new b(), new a(), new e(), new f()});
        this.signals = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNotify$lambda$2(j signal, i this$0) {
        Intrinsics.checkNotNullParameter(signal, "$signal");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (signal instanceof d) {
            this$0.onNetWifi2Mobile();
            return;
        }
        if (signal instanceof c) {
            this$0.onNetNone2Mobile();
            return;
        }
        if (signal instanceof b) {
            this$0.onNetMobile2Wifi();
            return;
        }
        if (signal instanceof a) {
            this$0.onNetMobile2None();
            return;
        }
        if (signal instanceof e) {
            this$0.onProcess2Background();
        } else if (signal instanceof f) {
            this$0.onProcess2Foreground();
        } else {
            this$0.logger.i(this$0.getTAG(), "unknown signal");
        }
    }

    private final void runOnUiThread(final Runnable runnable) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqlive.common.monitor.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.runOnUiThread$lambda$3(runnable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnUiThread$lambda$3(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long byte2KByte(long valueInByte) {
        return valueInByte / 1024;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final IAegisLogApi getLogger() {
        return this.logger;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String getScene() {
        return this.scene;
    }

    @NotNull
    protected String getTAG() {
        return this.TAG;
    }

    public void init() {
        this.logger.i(getTAG(), "init");
        for (j jVar : this.signals) {
            jVar.a(this);
            jVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isMobileNetwork() {
        return AppNetConnInfo.isMobileConn();
    }

    @Override // com.tencent.qqlive.common.monitor.m
    public void onNotify(@NotNull final j signal) {
        Intrinsics.checkNotNullParameter(signal, "signal");
        this.logger.i(getTAG(), "onNotify->" + signal.getClass().getSimpleName());
        runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.common.monitor.g
            @Override // java.lang.Runnable
            public final void run() {
                i.onNotify$lambda$2(j.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void report(@NotNull com.tencent.qqperf.reporter.flow.b reportParams) {
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        this.logger.i(getTAG(), "report->" + reportParams.b());
        TrafficFlowReporter.r(reportParams);
    }

    public void unInit() {
        this.logger.i(getTAG(), "unInit");
        for (j jVar : this.signals) {
            jVar.c(this);
            jVar.e();
        }
    }

    protected void onNetMobile2None() {
    }

    protected void onNetMobile2Wifi() {
    }

    protected void onNetNone2Mobile() {
    }

    protected void onNetWifi2Mobile() {
    }

    protected void onProcess2Background() {
    }

    protected void onProcess2Foreground() {
    }
}
