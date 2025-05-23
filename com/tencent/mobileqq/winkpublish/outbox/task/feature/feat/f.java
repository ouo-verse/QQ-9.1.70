package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.export.model.ExportStartParam;
import com.tencent.mobileqq.wink.export.model.ExportingParam;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010&\u001a\u00020\"\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u000bH\u0016R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010$\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/f;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/j;", "", "L", "Lcom/tencent/mobileqq/wink/export/model/ExportingParam;", "exportingParam", "", "size", "M", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "feat", "", "P", "O", "N", "K", "", HippyTKDListViewAdapter.X, "", "j", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "errCode", "B", "missionID", "Lcom/tencent/mobileqq/wink/export/model/ExportStartParam;", "exportStartParam", "onExportStart", "onExporting", "H", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup;", "G", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup;", "eauGroup", "uweGroup", "<init>", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup;Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup;)V", "I", "a", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f extends j {

    /* renamed from: G, reason: from kotlin metadata */
    private final FeatureGroup eauGroup;

    /* renamed from: H, reason: from kotlin metadata */
    private final FeatureGroup uweGroup;

    public f(FeatureGroup eauGroup, FeatureGroup uweGroup) {
        Intrinsics.checkNotNullParameter(eauGroup, "eauGroup");
        Intrinsics.checkNotNullParameter(uweGroup, "uweGroup");
        this.eauGroup = eauGroup;
        this.uweGroup = uweGroup;
    }

    private final boolean K() {
        int random;
        if (!uq3.c.g3()) {
            return false;
        }
        random = RangesKt___RangesKt.random(new IntRange(0, 9), Random.INSTANCE);
        QLog.i("WinkPublish-upload2-UWETestFeat", 1, "[compareTeamTest] abTest=" + random);
        TaskContext y16 = y();
        com.tencent.mobileqq.winkpublish.outbox.d.d(y16, "T_CATCH_IMPORTANT_INFO", y16.r(), (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : "export_with_upload_compare", (r33 & 16) != 0 ? "" : String.valueOf(random), (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        return random == 0;
    }

    private final boolean L() {
        return com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_OPEN_VIDEO_EXPORT_UPLOAD_CONTROLLER, 0);
    }

    private final boolean O() {
        if (uq3.c.V6(ua3.a.d().f())) {
            return true;
        }
        QLog.i("WinkPublish-upload2-UWETestFeat", 1, "[isWnsOpened] wns config is closed");
        return false;
    }

    private final void P(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b feat) {
        try {
            QLog.d("WinkPublish-upload2-UWETestFeat", 1, "[resumeFor] ", new RuntimeException());
        } catch (Exception e16) {
            QLog.d("WinkPublish-upload2-UWETestFeat", 1, "[resumeFor] ", e16);
        }
        c(feat);
        p();
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j
    public void B(ExportErrorCode errCode) {
        Intrinsics.checkNotNullParameter(errCode, "errCode");
        QLog.w(x(), 1, "[onExportError] errCode=" + errCode);
        P(this.eauGroup);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j
    public void C() {
        QLog.w(x(), 1, "[onExportSuccess]");
        P(this.eauGroup);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public int j() {
        return 0;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void m(TaskContext taskContext) {
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        QLog.i(x(), 1, "[onRun] ");
        if (!O()) {
            P(this.eauGroup);
        } else if (!taskContext.getEnableUWETest()) {
            QLog.i(x(), 1, "[onRun] not enable UWETest");
            P(this.eauGroup);
        } else {
            super.m(taskContext);
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature
    public void n() {
        if (getIsReceivedProgress()) {
            F(false);
        } else {
            QLog.i(x(), 1, "[onTimeoutCheck] timeout");
            B(new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_TIMEOUT_BY_TASK, null, 2, null));
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, x73.a
    public void onExportStart(String missionID, ExportStartParam exportStartParam) {
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        Intrinsics.checkNotNullParameter(exportStartParam, "exportStartParam");
        super.onExportStart(missionID, exportStartParam);
        if (2 == exportStartParam.getExportType() || 3 == exportStartParam.getExportType()) {
            y().H(false);
            P(this.eauGroup);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j, x73.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onExporting(String missionID, ExportingParam exportingParam) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        Intrinsics.checkNotNullParameter(exportingParam, "exportingParam");
        super.onExporting(missionID, exportingParam);
        if (!Intrinsics.areEqual(v(), missionID)) {
            QLog.i(x(), 1, "[onExporting] not the same id, " + v() + ", " + missionID);
            return;
        }
        if (!i()) {
            QLog.w(x(), 1, "[onExporting] continuation is not active");
            return;
        }
        if (exportingParam.f322842e < 0.1d) {
            return;
        }
        String str = exportingParam.f322846m;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    QLog.w("WinkPublish-upload2-UWETestFeat", 1, "[onExporting] invalid filePath");
                    return;
                }
                long length = ((float) new File(exportingParam.f322846m).length()) / exportingParam.f322842e;
                u().z(length);
                QLog.d("WinkPublish-upload2-UWETestFeat", 1, "[onExporting] fake size:" + length + " progress:" + exportingParam.f322842e);
                if (M(exportingParam, length)) {
                    P(this.eauGroup);
                    return;
                }
                if (L()) {
                    QLog.d("WinkPublish-upload2-UWETestFeat", 1, "[onExporting] isDebugOpenUWE");
                    P(this.uweGroup);
                    return;
                } else if (!N(exportingParam)) {
                    P(this.eauGroup);
                    return;
                } else if (K()) {
                    P(this.eauGroup);
                    return;
                } else {
                    P(this.uweGroup);
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j
    public String x() {
        return "WinkPublish-upload2-UWETestFeat";
    }

    private final boolean M(ExportingParam exportingParam, long size) {
        boolean z16 = ((double) exportingParam.f322842e) > 0.4d;
        if (z16) {
            TaskContext y16 = y();
            com.tencent.mobileqq.winkpublish.outbox.d.d(y16, "T_CATCH_IMPORTANT_INFO", y16.r(), (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : "scene_video_export_init_size", (r33 & 16) != 0 ? "" : String.valueOf(exportingParam.f322842e), (r33 & 32) != 0 ? "" : String.valueOf(size), (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        }
        QLog.d("WinkPublish-upload2-UWETestFeat", 1, "[isFastExport] isTooFast=" + z16);
        return z16;
    }

    private final boolean N(ExportingParam exportingParam) {
        QLog.d("WinkPublish-upload2-UWETestFeat", 1, "[isOriginalVideoSizeOverLimitSize] " + exportingParam);
        boolean z16 = exportingParam.C > uq3.c.h3();
        TaskContext y16 = y();
        com.tencent.mobileqq.winkpublish.outbox.d.d(y16, "T_CATCH_IMPORTANT_INFO", y16.r(), (r33 & 4) != 0 ? "" : null, (r33 & 8) != 0 ? "" : "scene_originnal_video_estimate_size", (r33 & 16) != 0 ? "" : String.valueOf(ua3.a.d().f() % 10), (r33 & 32) != 0 ? "" : String.valueOf(exportingParam.C), (r33 & 64) != 0 ? "" : "2", (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
        return z16;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.j
    public void H() {
    }
}
