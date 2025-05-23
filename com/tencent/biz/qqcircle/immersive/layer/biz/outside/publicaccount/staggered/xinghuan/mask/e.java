package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/xinghuan/mask/e;", "", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", tl.h.F, "", "clickArea", "f", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_TYPE, "d", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f87154a = new e();

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String taskId, int i3) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(taskId, "$taskId");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("task_id", taskId), TuplesKt.to("close_type", Integer.valueOf(i3)));
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FLOATING_CLOSE, null, mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String taskId, int i3) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(taskId, "$taskId");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("task_id", taskId), TuplesKt.to("click_area", Integer.valueOf(i3)));
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FLOATING_CK, null, mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String taskId) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(taskId, "$taskId");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("task_id", taskId));
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FLOATING_EXP, null, mutableMapOf);
    }

    public final void d(@NotNull final String taskId, final int closeType) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.b
            @Override // java.lang.Runnable
            public final void run() {
                e.e(taskId, closeType);
            }
        });
    }

    public final void f(@NotNull final String taskId, final int clickArea) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.c
            @Override // java.lang.Runnable
            public final void run() {
                e.g(taskId, clickArea);
            }
        });
    }

    public final void h(@NotNull final String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.d
            @Override // java.lang.Runnable
            public final void run() {
                e.i(taskId);
            }
        });
    }
}
