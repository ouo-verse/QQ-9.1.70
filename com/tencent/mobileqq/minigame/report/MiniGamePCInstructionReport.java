package com.tencent.mobileqq.minigame.report;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qqmini.proxyimpl.aq;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/MiniGamePCInstructionReport;", "", "()V", "ACTION_TYPE", "", "RESERVRS_ACTION_INSTRUCTION_DIALOG", "RESERVRS_ACTION_INSTRUCTION_DIALOG_CP", "RESERVRS_ACTION_INSTRUCTION_ICON", "RESERVRS_ACTION_INSTRUCTION_SEND_RESULT", "RESERVRS_ACTION_INSTRUCTION_SEND_RESULT_CP", "reportPCDialogEvent", "", "appInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "reservesAction", "fromCP", "", "reserves8", "reportPCDialogSendResult", "reportPCInstructionBtnClick", "reportPCInstructionBtnShow", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGamePCInstructionReport {
    private static final String ACTION_TYPE = "page_view";
    public static final MiniGamePCInstructionReport INSTANCE = new MiniGamePCInstructionReport();
    private static final String RESERVRS_ACTION_INSTRUCTION_DIALOG = "minigame_pc_guide_popup";
    private static final String RESERVRS_ACTION_INSTRUCTION_DIALOG_CP = "minigame_pc_guide_popup_cp";
    private static final String RESERVRS_ACTION_INSTRUCTION_ICON = "minigame_pc_guide_icon";
    private static final String RESERVRS_ACTION_INSTRUCTION_SEND_RESULT = "minigame_pc_guide_result_msg";
    private static final String RESERVRS_ACTION_INSTRUCTION_SEND_RESULT_CP = "minigame_pc_guide_result_msg_cp";

    MiniGamePCInstructionReport() {
    }

    @JvmStatic
    public static final void reportPCDialogEvent(MiniAppInfo appInfo, String reservesAction, boolean fromCP, String reserves8) {
        String str;
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(reservesAction, "reservesAction");
        if (fromCP) {
            str = RESERVRS_ACTION_INSTRUCTION_DIALOG_CP;
        } else {
            str = RESERVRS_ACTION_INSTRUCTION_DIALOG;
        }
        MiniProgramLpReportDC04239.reportAsyncWithIcon(aq.h(appInfo), "page_view", reservesAction, str, null, null, null, null, reserves8);
    }

    @JvmStatic
    public static final void reportPCDialogSendResult(MiniAppInfo appInfo, boolean fromCP, String reserves8) {
        String str;
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(reserves8, "reserves8");
        if (fromCP) {
            str = RESERVRS_ACTION_INSTRUCTION_SEND_RESULT_CP;
        } else {
            str = RESERVRS_ACTION_INSTRUCTION_SEND_RESULT;
        }
        MiniProgramLpReportDC04239.reportAsyncWithIcon(aq.h(appInfo), "page_view", "em_expo", str, null, null, null, null, reserves8);
    }

    @JvmStatic
    public static final void reportPCInstructionBtnClick(MiniAppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        MiniProgramLpReportDC04239.reportAsyncWithIcon(aq.h(appInfo), "page_view", "em_click", RESERVRS_ACTION_INSTRUCTION_ICON, null, null, null, null, null);
    }

    @JvmStatic
    public static final void reportPCInstructionBtnShow(MiniAppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        MiniProgramLpReportDC04239.reportAsyncWithIcon(aq.h(appInfo), "page_view", "em_expo", RESERVRS_ACTION_INSTRUCTION_ICON, null, null, null, null, null);
    }
}
