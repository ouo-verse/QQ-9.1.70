package com.tencent.mobileqq.vas.font.report;

import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.VasNtToggle;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/font/report/VasFontReporter;", "", "()V", "ERROR_DRAW_FILE_EXIST", "", "ERROR_FILE_DOWNLOAD", "ERROR_SO_LOAD", VasFontReporter.FONT_DRAW, "TAG", "isANRReportEnable", "", "()Z", "setANRReportEnable", "(Z)V", "isDrawReportEnable", "setDrawReportEnable", "report", "", "id", "", QCircleWeakNetReporter.KEY_COST, "task", "text", "errorMsg", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasFontReporter {

    @NotNull
    public static final String ERROR_DRAW_FILE_EXIST = "\u5b57\u4f53\u6587\u4ef6\u4e0d\u5b58\u5728,\u7ed8\u5236\u5931\u8d25\u3002id:{id}";

    @NotNull
    public static final String ERROR_FILE_DOWNLOAD = "\u6587\u4ef6\u4e0b\u8f7d\u5931\u8d25\u3002errorCode:{errorCode} ,id:{id}, httpCode:{httpCode}";

    @NotNull
    public static final String ERROR_SO_LOAD = "SO\u52a0\u8f7d\u5931\u8d25\u3002soPath:{soPath}, errorMsg:{errorMsg}";

    @NotNull
    private static final String FONT_DRAW = "FONT_DRAW";

    @NotNull
    private static final String TAG = "VasFontReporter";

    @NotNull
    public static final VasFontReporter INSTANCE = new VasFontReporter();
    private static boolean isDrawReportEnable = VasNtToggle.VAS_FONT_DRAW_REPORT_SWITCH.isEnable(true);
    private static boolean isANRReportEnable = VasNtToggle.VAS_FONT_ANR_REPORT_SWITCH.isEnable(true);

    VasFontReporter() {
    }

    public final boolean isANRReportEnable() {
        return isANRReportEnable;
    }

    public final boolean isDrawReportEnable() {
        return isDrawReportEnable;
    }

    public final void report(@NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        if (isDrawReportEnable) {
            VasNtCommonReporter.getFont().setValue1(FONT_DRAW).setValue2(errorMsg).reportEveryDay(errorMsg);
        }
    }

    public final void setANRReportEnable(boolean z16) {
        isANRReportEnable = z16;
    }

    public final void setDrawReportEnable(boolean z16) {
        isDrawReportEnable = z16;
    }

    public final void report(long id5, long cost, @NotNull String task, @NotNull String text) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(text, "text");
        if (isANRReportEnable) {
            VasNtCommonReporter.getFont().setNum2(id5).setNum3(cost).setValue2(task).setValue3(text).reportEveryDay(task);
        }
    }
}
