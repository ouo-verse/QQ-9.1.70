package com.tencent.mobileqq.minigame.report;

import NS_COMM.COMM;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b(\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0003J\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ \u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0002JN\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002JN\u0010.\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002JF\u0010.\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010/\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u00100\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u00101\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u00102\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u001c\u00103\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007J\u001c\u00104\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007JL\u00105\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010;\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u00107\u001a\u00020\u0004H\u0007J\u0012\u0010<\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u001a\u0010=\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u00107\u001a\u00020\u0004H\u0007J\"\u0010>\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0004H\u0007J\u0012\u0010?\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u001a\u0010@\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u00107\u001a\u00020\u0004H\u0007J\"\u0010A\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0004H\u0007J\u0012\u0010B\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010C\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J$\u0010D\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010+\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007J\u001c\u0010E\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007J6\u0010F\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0007J6\u0010G\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010H\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010I\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010J\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010K\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\u00068\u0002X\u0083T\u00a2\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/MiniGameNewRetainDialogReport;", "", "()V", "ACTION_TYPE", "", "NEW_REFER", "", "OLD_REFER", "getOLD_REFER$annotations", "POS_GAMECHANGE", "POS_SUBICON", "POS_SUBPIC", "POS_TOTLEPAGE", "POS_WINDOW_CANCEL", "REFER_FOR_FUNCTION_RETAIN", "RESERVRS_ACTION", "RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_DESKTOP", "RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_DESKTOP_ADD", "RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_DESKTOP_QUIT", "RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_DESKTOP_XCLOSE", "RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_FOLDER", "RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_FOLDER_ADD", "RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_FOLDER_QUIT", "RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_FOLDER_XCLOSE", "RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_MORE_GAME", "RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_TUIJIAN_XCLOSE", "getAppId", "closedAppConfig", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "getRefer", "isNewRetainDialog", "", "handleRetainDialogReportData", "", "entryList", "", "LNS_COMM/COMM$Entry;", "sourceAppid", "report", "refer", "appId", "subAction", com.tencent.luggage.wxa.c8.c.G, "tianshuAdId", "reserves", "reportData", "reportAsync", "reportColorSignDialogAddClick", "reportColorSignDialogCloseClick", "reportColorSignDialogQuitClick", "reportColorSignDialogShow", "reportDialogDismiss", "reportDialogShow", "reportForFunctionRetainDialog", "reservesAction", "reserves3", "reserves4", "reserves5", "reserves6", "reportFunctionRetainCloseClick", "reportFunctionRetainDialogShow", "reportFunctionRetainExitClick", "reportFunctionRetainGuideBannerShow", "reportFunctionRetainMoreBtnClick", "reportFunctionRetainSubscribeClick", "reportFunctionRetainSubscribeResult", "reportNewRetainCloseClick", "reportNewRetainMoreGameClick", "reportPicClick", "reportRecommendGameChange", "reportRecommendGameClick", "reportRecommendGameShow", "reportShotCutDialogAddClick", "reportShotCutDialogCloseClick", "reportShotCutDialogQuitClick", "reportShotCutDialogShow", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameNewRetainDialogReport {
    private static final String ACTION_TYPE = "page_view";
    public static final MiniGameNewRetainDialogReport INSTANCE = new MiniGameNewRetainDialogReport();
    private static final int NEW_REFER = 2120;
    private static final int OLD_REFER = 2113;
    private static final String POS_GAMECHANGE = "_4";
    private static final String POS_SUBICON = "_3";
    private static final String POS_SUBPIC = "_2";
    private static final String POS_TOTLEPAGE = "_1";
    private static final String POS_WINDOW_CANCEL = "_5";
    private static final int REFER_FOR_FUNCTION_RETAIN = 20001;
    private static final String RESERVRS_ACTION = "minigame_newpopwindow";
    private static final String RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_DESKTOP = "minigame_newpopwindow_desktop";
    private static final String RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_DESKTOP_ADD = "minigame_newpopwindow_desktop_add";
    private static final String RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_DESKTOP_QUIT = "minigame_newpopwindow_desktop_quit";
    private static final String RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_DESKTOP_XCLOSE = "minigame_newpopwindow_desktop_xclose";
    private static final String RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_FOLDER = "minigame_newpopwindow_folder";
    private static final String RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_FOLDER_ADD = "minigame_newpopwindow_folder_add";
    private static final String RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_FOLDER_QUIT = "minigame_newpopwindow_folder_quit";
    private static final String RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_FOLDER_XCLOSE = "minigame_newpopwindow_folder_xclose";
    private static final String RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_MORE_GAME = "minigame_newpopwindow_moregame";
    private static final String RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_TUIJIAN_XCLOSE = "minigame_newpopwindow_tuijian_xclose";

    MiniGameNewRetainDialogReport() {
    }

    private final void report(int refer, String appId, String subAction, String pos, int tianshuAdId, String sourceAppid, String reserves, String reportData) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(appId)) {
            COMM.Entry newEntry = MiniProgramReportHelper.newEntry("appid", appId);
            Intrinsics.checkNotNullExpressionValue(newEntry, "newEntry(\"appid\", appId)");
            arrayList.add(newEntry);
        }
        COMM.Entry newEntry2 = MiniProgramReportHelper.newEntry("refer", String.valueOf(refer));
        Intrinsics.checkNotNullExpressionValue(newEntry2, "newEntry(\"refer\", refer.toString())");
        arrayList.add(newEntry2);
        if (tianshuAdId != 0) {
            str = String.valueOf(tianshuAdId);
        } else {
            str = "";
        }
        String str2 = str;
        List<COMM.Entry> newUserInfoEntries = MiniProgramReportHelper.newUserInfoEntries();
        Intrinsics.checkNotNullExpressionValue(newUserInfoEntries, "newUserInfoEntries()");
        arrayList.addAll(newUserInfoEntries);
        List<COMM.Entry> newBaseBusinessEntries = MiniProgramReportHelper.newBaseBusinessEntries("page_view", subAction, reserves, "", "", str2, pos);
        Intrinsics.checkNotNullExpressionValue(newBaseBusinessEntries, "newBaseBusinessEntries(\n\u2026        pos\n            )");
        arrayList.addAll(newBaseBusinessEntries);
        handleRetainDialogReportData(arrayList, sourceAppid);
        if (!(reportData == null || reportData.length() == 0)) {
            List<COMM.Entry> newReportEntries = MiniProgramReportHelper.newReportEntries(reportData);
            Intrinsics.checkNotNullExpressionValue(newReportEntries, "newReportEntries(reportData)");
            arrayList.addAll(newReportEntries);
        }
        List<COMM.Entry> newGenericEntries = MiniProgramReportHelper.newGenericEntries();
        Intrinsics.checkNotNullExpressionValue(newGenericEntries, "newGenericEntries()");
        arrayList.addAll(newGenericEntries);
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    private final void reportAsync(int refer, String appId, String subAction, String pos, int tianshuAdId, String sourceAppid, String reportData) {
        reportAsync(refer, appId, subAction, pos, tianshuAdId, sourceAppid, RESERVRS_ACTION, reportData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportAsync$lambda$0(int i3, String str, String subAction, String pos, int i16, String str2, String reserves, String str3) {
        Intrinsics.checkNotNullParameter(subAction, "$subAction");
        Intrinsics.checkNotNullParameter(pos, "$pos");
        Intrinsics.checkNotNullParameter(reserves, "$reserves");
        INSTANCE.report(i3, str, subAction, pos, i16, str2, reserves, str3);
    }

    @JvmStatic
    public static final void reportColorSignDialogAddClick(MiniAppConfig closedAppConfig) {
        INSTANCE.reportAsync(2120, "", "em_click", "", 0, getAppId(closedAppConfig), RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_FOLDER_ADD);
    }

    @JvmStatic
    public static final void reportColorSignDialogCloseClick(MiniAppConfig closedAppConfig) {
        INSTANCE.reportAsync(2120, "", "em_click", "", 0, getAppId(closedAppConfig), RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_FOLDER_XCLOSE);
    }

    @JvmStatic
    public static final void reportColorSignDialogQuitClick(MiniAppConfig closedAppConfig) {
        INSTANCE.reportAsync(2120, "", "em_click", "", 0, getAppId(closedAppConfig), RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_FOLDER_QUIT);
    }

    @JvmStatic
    public static final void reportColorSignDialogShow(MiniAppConfig closedAppConfig) {
        INSTANCE.reportAsync(2120, "", "em_expo", "", 0, getAppId(closedAppConfig), RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_FOLDER);
    }

    @JvmStatic
    public static final void reportDialogDismiss(MiniAppConfig closedAppConfig, boolean isNewRetainDialog) {
        MiniGameNewRetainDialogReport miniGameNewRetainDialogReport = INSTANCE;
        miniGameNewRetainDialogReport.reportAsync(miniGameNewRetainDialogReport.getRefer(isNewRetainDialog), "", "em_click", miniGameNewRetainDialogReport.getRefer(isNewRetainDialog) + POS_WINDOW_CANCEL, 0, getAppId(closedAppConfig), null);
    }

    @JvmStatic
    public static final void reportDialogShow(MiniAppConfig closedAppConfig, boolean isNewRetainDialog) {
        MiniGameNewRetainDialogReport miniGameNewRetainDialogReport = INSTANCE;
        miniGameNewRetainDialogReport.reportAsync(miniGameNewRetainDialogReport.getRefer(isNewRetainDialog), "", "em_expo", miniGameNewRetainDialogReport.getRefer(isNewRetainDialog) + POS_TOTLEPAGE, 0, getAppId(closedAppConfig), null);
    }

    private final void reportForFunctionRetainDialog(int refer, String appId, String subAction, String reservesAction, String reserves3, String reserves4, String reserves5, String reserves6) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(appId)) {
            COMM.Entry newEntry = MiniProgramReportHelper.newEntry("appid", appId);
            Intrinsics.checkNotNullExpressionValue(newEntry, "newEntry(\"appid\", appId)");
            arrayList.add(newEntry);
        }
        COMM.Entry newEntry2 = MiniProgramReportHelper.newEntry("refer", String.valueOf(refer));
        Intrinsics.checkNotNullExpressionValue(newEntry2, "newEntry(\"refer\", refer.toString())");
        arrayList.add(newEntry2);
        List<COMM.Entry> newUserInfoEntries = MiniProgramReportHelper.newUserInfoEntries();
        Intrinsics.checkNotNullExpressionValue(newUserInfoEntries, "newUserInfoEntries()");
        arrayList.addAll(newUserInfoEntries);
        List<COMM.Entry> newBaseBusinessEntries = MiniProgramReportHelper.newBaseBusinessEntries("page_view", subAction, reservesAction, "", reserves3, reserves4, reserves5);
        Intrinsics.checkNotNullExpressionValue(newBaseBusinessEntries, "newBaseBusinessEntries(\n\u2026  reserves5\n            )");
        arrayList.addAll(newBaseBusinessEntries);
        handleRetainDialogReportData(arrayList, reserves6);
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
        MiniProgramReporter.getInstance().flush();
    }

    @JvmStatic
    public static final void reportFunctionRetainCloseClick(final MiniAppConfig closedAppConfig, final String reserves3) {
        Intrinsics.checkNotNullParameter(reserves3, "reserves3");
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.report.d
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameNewRetainDialogReport.reportFunctionRetainCloseClick$lambda$6(reserves3, closedAppConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportFunctionRetainCloseClick$lambda$6(String reserves3, MiniAppConfig miniAppConfig) {
        Intrinsics.checkNotNullParameter(reserves3, "$reserves3");
        INSTANCE.reportForFunctionRetainDialog(20001, "", "em_click", "minigame_retention_popup_202402_close", reserves3, "", "", getAppId(miniAppConfig));
    }

    @JvmStatic
    public static final void reportFunctionRetainDialogShow(final MiniAppConfig closedAppConfig) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.report.f
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameNewRetainDialogReport.reportFunctionRetainDialogShow$lambda$1(MiniAppConfig.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportFunctionRetainDialogShow$lambda$1(MiniAppConfig miniAppConfig) {
        INSTANCE.reportForFunctionRetainDialog(20001, "", "em_expo", "minigame_retention_popup_202402", "", "", "", getAppId(miniAppConfig));
    }

    @JvmStatic
    public static final void reportFunctionRetainExitClick(final MiniAppConfig closedAppConfig, final String reserves3) {
        Intrinsics.checkNotNullParameter(reserves3, "reserves3");
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.report.i
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameNewRetainDialogReport.reportFunctionRetainExitClick$lambda$7(reserves3, closedAppConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportFunctionRetainExitClick$lambda$7(String reserves3, MiniAppConfig miniAppConfig) {
        Intrinsics.checkNotNullParameter(reserves3, "$reserves3");
        INSTANCE.reportForFunctionRetainDialog(20001, "", "em_click", "minigame_retention_popup_202402_exit", reserves3, "", "", getAppId(miniAppConfig));
    }

    @JvmStatic
    public static final void reportFunctionRetainGuideBannerShow(final MiniAppConfig closedAppConfig, final String reserves4, final String reserves5) {
        Intrinsics.checkNotNullParameter(reserves4, "reserves4");
        Intrinsics.checkNotNullParameter(reserves5, "reserves5");
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.report.c
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameNewRetainDialogReport.reportFunctionRetainGuideBannerShow$lambda$4(reserves4, reserves5, closedAppConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportFunctionRetainGuideBannerShow$lambda$4(String reserves4, String reserves5, MiniAppConfig miniAppConfig) {
        Intrinsics.checkNotNullParameter(reserves4, "$reserves4");
        Intrinsics.checkNotNullParameter(reserves5, "$reserves5");
        INSTANCE.reportForFunctionRetainDialog(20001, "", "em_expo", "minigame_retention_popup_202402_banner", "", reserves4, reserves5, getAppId(miniAppConfig));
    }

    @JvmStatic
    public static final void reportFunctionRetainMoreBtnClick(final MiniAppConfig closedAppConfig) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.report.e
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameNewRetainDialogReport.reportFunctionRetainMoreBtnClick$lambda$2(MiniAppConfig.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportFunctionRetainMoreBtnClick$lambda$2(MiniAppConfig miniAppConfig) {
        INSTANCE.reportForFunctionRetainDialog(20001, "", "em_click", "minigame_retention_popup_202402_more_game", "", "", "", getAppId(miniAppConfig));
    }

    @JvmStatic
    public static final void reportFunctionRetainSubscribeClick(final MiniAppConfig closedAppConfig, final String reserves3) {
        Intrinsics.checkNotNullParameter(reserves3, "reserves3");
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.report.j
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameNewRetainDialogReport.reportFunctionRetainSubscribeClick$lambda$3(reserves3, closedAppConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportFunctionRetainSubscribeClick$lambda$3(String reserves3, MiniAppConfig miniAppConfig) {
        Intrinsics.checkNotNullParameter(reserves3, "$reserves3");
        INSTANCE.reportForFunctionRetainDialog(20001, "", "em_click", "minigame_retention_popup_202402_select_subscribe", reserves3, "", "", getAppId(miniAppConfig));
    }

    @JvmStatic
    public static final void reportFunctionRetainSubscribeResult(final MiniAppConfig closedAppConfig, final String reserves4, final String reserves5) {
        Intrinsics.checkNotNullParameter(reserves4, "reserves4");
        Intrinsics.checkNotNullParameter(reserves5, "reserves5");
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.report.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameNewRetainDialogReport.reportFunctionRetainSubscribeResult$lambda$5(reserves4, reserves5, closedAppConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportFunctionRetainSubscribeResult$lambda$5(String reserves4, String reserves5, MiniAppConfig miniAppConfig) {
        Intrinsics.checkNotNullParameter(reserves4, "$reserves4");
        Intrinsics.checkNotNullParameter(reserves5, "$reserves5");
        INSTANCE.reportForFunctionRetainDialog(20001, "", "em_click", "minigame_retention_popup_202402_subscribe_request", "", reserves4, reserves5, getAppId(miniAppConfig));
    }

    @JvmStatic
    public static final void reportNewRetainCloseClick(MiniAppConfig closedAppConfig) {
        INSTANCE.reportAsync(2120, "", "em_click", "", 0, getAppId(closedAppConfig), RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_TUIJIAN_XCLOSE);
    }

    @JvmStatic
    public static final void reportNewRetainMoreGameClick(MiniAppConfig closedAppConfig) {
        INSTANCE.reportAsync(2120, "", "em_click", "", 0, getAppId(closedAppConfig), RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_MORE_GAME);
    }

    @JvmStatic
    public static final void reportPicClick(MiniAppConfig closedAppConfig, int tianshuAdId, boolean isNewRetainDialog) {
        MiniGameNewRetainDialogReport miniGameNewRetainDialogReport = INSTANCE;
        miniGameNewRetainDialogReport.reportAsync(miniGameNewRetainDialogReport.getRefer(isNewRetainDialog), "", "em_click", miniGameNewRetainDialogReport.getRefer(isNewRetainDialog) + POS_SUBPIC, tianshuAdId, getAppId(closedAppConfig), null);
    }

    @JvmStatic
    public static final void reportRecommendGameChange(MiniAppConfig closedAppConfig, boolean isNewRetainDialog) {
        MiniGameNewRetainDialogReport miniGameNewRetainDialogReport = INSTANCE;
        miniGameNewRetainDialogReport.reportAsync(miniGameNewRetainDialogReport.getRefer(isNewRetainDialog), "", "em_click", miniGameNewRetainDialogReport.getRefer(isNewRetainDialog) + POS_GAMECHANGE, 0, getAppId(closedAppConfig), null);
    }

    @JvmStatic
    public static final void reportRecommendGameClick(MiniAppConfig closedAppConfig, String appId, int tianshuAdId, boolean isNewRetainDialog, String reportData) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        MiniGameNewRetainDialogReport miniGameNewRetainDialogReport = INSTANCE;
        miniGameNewRetainDialogReport.reportAsync(miniGameNewRetainDialogReport.getRefer(isNewRetainDialog), appId, "pg_click", miniGameNewRetainDialogReport.getRefer(isNewRetainDialog) + POS_SUBICON, tianshuAdId, getAppId(closedAppConfig), reportData);
    }

    @JvmStatic
    public static final void reportRecommendGameShow(MiniAppConfig closedAppConfig, String appId, int tianshuAdId, boolean isNewRetainDialog, String reportData) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        MiniGameNewRetainDialogReport miniGameNewRetainDialogReport = INSTANCE;
        miniGameNewRetainDialogReport.reportAsync(miniGameNewRetainDialogReport.getRefer(isNewRetainDialog), appId, "expo", miniGameNewRetainDialogReport.getRefer(isNewRetainDialog) + POS_SUBICON, tianshuAdId, getAppId(closedAppConfig), reportData);
    }

    @JvmStatic
    public static final void reportShotCutDialogAddClick(MiniAppConfig closedAppConfig) {
        INSTANCE.reportAsync(2120, "", "em_click", "", 0, getAppId(closedAppConfig), RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_DESKTOP_ADD);
    }

    @JvmStatic
    public static final void reportShotCutDialogCloseClick(MiniAppConfig closedAppConfig) {
        INSTANCE.reportAsync(2120, "", "em_click", "", 0, getAppId(closedAppConfig), RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_DESKTOP_XCLOSE);
    }

    @JvmStatic
    public static final void reportShotCutDialogQuitClick(MiniAppConfig closedAppConfig) {
        INSTANCE.reportAsync(2120, "", "em_click", "", 0, getAppId(closedAppConfig), RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_DESKTOP_QUIT);
    }

    @JvmStatic
    public static final void reportShotCutDialogShow(MiniAppConfig closedAppConfig) {
        INSTANCE.reportAsync(2120, "", "em_expo", "", 0, getAppId(closedAppConfig), RESERVRS_ACTION_MINIGAME_NEWPOPWINDOW_DESKTOP);
    }

    public final int getRefer(boolean isNewRetainDialog) {
        return 2120;
    }

    private final void reportAsync(final int refer, final String appId, final String subAction, final String pos, final int tianshuAdId, final String sourceAppid, final String reserves, final String reportData) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.report.h
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameNewRetainDialogReport.reportAsync$lambda$0(refer, appId, subAction, pos, tianshuAdId, sourceAppid, reserves, reportData);
            }
        });
    }

    @JvmStatic
    private static final String getAppId(MiniAppConfig closedAppConfig) {
        MiniAppInfo miniAppInfo;
        if (closedAppConfig == null || (miniAppInfo = closedAppConfig.config) == null) {
            return null;
        }
        return miniAppInfo.appId;
    }

    private final void handleRetainDialogReportData(List<COMM.Entry> entryList, String sourceAppid) {
        if (sourceAppid == null) {
            sourceAppid = "";
        }
        COMM.Entry newEntry = MiniProgramReportHelper.newEntry("reserves6", sourceAppid);
        Intrinsics.checkNotNullExpressionValue(newEntry, "newEntry(\"reserves6\", sourceAppid?:\"\")");
        entryList.add(newEntry);
    }

    public static /* synthetic */ void reportDialogDismiss$default(MiniAppConfig miniAppConfig, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        reportDialogDismiss(miniAppConfig, z16);
    }

    public static /* synthetic */ void reportDialogShow$default(MiniAppConfig miniAppConfig, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        reportDialogShow(miniAppConfig, z16);
    }

    public static /* synthetic */ void reportPicClick$default(MiniAppConfig miniAppConfig, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        reportPicClick(miniAppConfig, i3, z16);
    }

    public static /* synthetic */ void reportRecommendGameChange$default(MiniAppConfig miniAppConfig, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        reportRecommendGameChange(miniAppConfig, z16);
    }

    public static /* synthetic */ void reportRecommendGameClick$default(MiniAppConfig miniAppConfig, String str, int i3, boolean z16, String str2, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = true;
        }
        reportRecommendGameClick(miniAppConfig, str, i3, z16, str2);
    }

    public static /* synthetic */ void reportRecommendGameShow$default(MiniAppConfig miniAppConfig, String str, int i3, boolean z16, String str2, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = true;
        }
        reportRecommendGameShow(miniAppConfig, str, i3, z16, str2);
    }

    @Deprecated(message = "8923\u5f00\u59cb\u4ea7\u54c1\u8981\u6c42\u5e9f\u5f03\uff0c\u4e0a\u62a5\u7edf\u4e00\u75282120")
    private static /* synthetic */ void getOLD_REFER$annotations() {
    }
}
