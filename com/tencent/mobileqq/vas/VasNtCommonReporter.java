package com.tencent.mobileqq.vas;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\bH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007J\b\u0010\u0014\u001a\u00020\bH\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/VasNtCommonReporter;", "", "()V", "isHit", "", "isHit$annotations", "()Z", "getBubble", "Lcom/tencent/mobileqq/vas/VasCommonReportProxy;", "getDynamicDrawable", "getFileAvailableCheck", "getFileAvailableCheck2", "getFileCheck", "getFont", "getFrequency", "getFunCall", "getHistoryFeature", "type", "", "getPrivatePath", "getSafeUnzip", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasNtCommonReporter {

    @NotNull
    public static final VasNtCommonReporter INSTANCE = new VasNtCommonReporter();
    private static final boolean isHit = ReportInfo.INSTANCE.isHit();

    VasNtCommonReporter() {
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getBubble() {
        return new ReportInfo("vas_bubble_report");
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getDynamicDrawable() {
        return new ReportInfo("dynamic_drawable");
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getFileAvailableCheck() {
        return new ReportInfo("file_available_check");
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getFileAvailableCheck2() {
        return new ReportInfo("file_available_check_2");
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getFileCheck() {
        return new ReportInfo("file_check");
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getFont() {
        return new ReportInfo("vas_font_report");
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getFrequency() {
        return new ReportInfo("vas_frequency");
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getFunCall() {
        return new ReportInfo("vas_fun_call_report");
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getHistoryFeature(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new ReportInfo("history_feature").setValue1(type);
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getPrivatePath() {
        return new ReportInfo("transform_private_path");
    }

    @JvmStatic
    @NotNull
    public static final ReportInfo getSafeUnzip() {
        return new ReportInfo("safe_unzip");
    }

    public static final boolean isHit() {
        return isHit;
    }

    @JvmStatic
    public static /* synthetic */ void isHit$annotations() {
    }
}
