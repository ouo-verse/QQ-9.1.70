package com.tencent.mobileqq.vas.report;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.ReportInfo;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0006H\u0007J\b\u0010\f\u001a\u00020\u0006H\u0007J\b\u0010\r\u001a\u00020\u0006H\u0007J\b\u0010\u000e\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0011\u001a\u00020\u0006H\u0007J\b\u0010\u0012\u001a\u00020\u0006H\u0007J\b\u0010\u0013\u001a\u00020\u0006H\u0007J\b\u0010\u0014\u001a\u00020\u0006H\u0007J\b\u0010\u0015\u001a\u00020\u0006H\u0007J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0017\u001a\u00020\u0006H\u0007J\b\u0010\u0018\u001a\u00020\u0006H\u0007J\b\u0010\u0019\u001a\u00020\u0006H\u0007J\b\u0010\u001a\u001a\u00020\u0006H\u0007J\b\u0010\u001b\u001a\u00020\u0006H\u0007J\b\u0010\u001c\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\nH\u0007J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0004H\u0003R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/report/VasCommonReporter;", "", "()V", "isHit", "", "getAppIcon", "Lcom/tencent/mobileqq/vas/VasCommonReportProxy;", "getAvif", "getCmdQuality", "type", "", "getDiyCard", "getDownLoader", "getGxhJsbSetDownload", "getHistoryFeature", "getHistoryJsbFeature", "getHotFeature", "getJsSet", "getJsSetPreDownload", "getKuiklyOpen", "getNewPsKey", "getPendant", "getServiceQuality", "getTheme", "getThemeEngine", "getThemeNewScid", "getThemePlate", "getVasPreload", "getWebPerf", "newReport", AdMetricTag.EVENT_NAME, "isNewEventCode", "vas-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasCommonReporter {

    @NotNull
    public static final VasCommonReporter INSTANCE = new VasCommonReporter();

    @JvmField
    public static final boolean isHit;

    static {
        int roundToInt;
        boolean z16;
        roundToInt = MathKt__MathJVMKt.roundToInt(Math.floor(1000 * Math.random()));
        if (roundToInt == 500) {
            z16 = true;
        } else {
            z16 = false;
        }
        isHit = z16;
    }

    VasCommonReporter() {
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getAppIcon() {
        return newReport(MiniConst.WxMiniAppInfoConst.EXTRA_ICON, false);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getAvif() {
        return newReport("avif", false);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getCmdQuality(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return newReport("cmd_quality", true).setValue1(type);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getDiyCard() {
        return newReport("diy_card_report", true);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getDownLoader() {
        return newReport(QDLog.TAG_DOWNLOAD, false);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getGxhJsbSetDownload() {
        return newReport("gxh_jsb_set_download", true);
    }

    @Deprecated(message = "\u8fd9\u4e2a\u63a5\u53e3\u4e0d\u65b9\u4fbf\u7d22\u5f15\uff0c\u4f7f\u7528\u4e0b\u9762\u7684\u63a5\u53e3")
    @JvmStatic
    @NotNull
    public static final ReportInfo getHistoryFeature() {
        return newReport("history_feature", true);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getHistoryJsbFeature(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return newReport("jsb_history_method", true).setValue1(type);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getHotFeature(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return newReport("hot_feature", true).setValue1(type);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getJsSet() {
        return newReport("gxh_common_set", true);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getJsSetPreDownload() {
        return newReport("gxh_common_set_pre_download", true);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getKuiklyOpen() {
        return newReport("kuikly_open", true);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getNewPsKey() {
        return newReport("new_pskey", false);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getPendant() {
        return newReport(IndividuationUrlHelper.UrlId.PENDANT_HOME, false);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getServiceQuality(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return newReport("service_quality", true).setValue1(type);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getTheme() {
        return newReport("theme_switch", false);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getThemeEngine() {
        return newReport("theme_engine", false);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getThemeNewScid() {
        return newReport("theme_new_scid");
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getThemePlate() {
        return newReport("theme_plate", false);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getVasPreload() {
        return newReport("vas_res_preload");
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getWebPerf() {
        return newReport("web_perf", false);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo newReport(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return newReport(eventName, true);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getHistoryFeature(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return newReport("history_feature", true).setValue1(type);
    }

    @JvmStatic
    private static final ReportInfo newReport(String eventName, boolean isNewEventCode) {
        ReportInfo reportInfo = new ReportInfo(eventName);
        reportInfo.setUseNewEventCode(isNewEventCode);
        return reportInfo;
    }
}
