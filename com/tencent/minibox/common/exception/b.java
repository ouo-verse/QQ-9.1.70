package com.tencent.minibox.common.exception;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.minibox.common.log.LogUtils;
import cooperation.qzone.QZoneHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/minibox/common/exception/b;", "", "", "url", "", "b", "Lcom/tencent/minibox/common/exception/c;", "reportItem", "Lcom/tencent/minibox/common/exception/a;", "attaAppInfo", "a", "c", "<init>", "()V", "MiniBoxCommon_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f151630a = new b();

    b() {
    }

    private final String a(AttaReportItem reportItem, AttaAppInfo attaAppInfo) {
        return new d().a("attaid", "0fe00062006").a("token", "5969283689").a("app_version", attaAppInfo.getAppVersion()).a("device", attaAppInfo.getModel()).a("platform", "1").a("sys_version", attaAppInfo.getOsVersion()).a("thirdparty_appid", reportItem.getAppId()).a("thirdparty_app_version", reportItem.getAppVersion()).a(CGNonAgeReport.EVENT_TYPE, reportItem.getEventType().getValue()).a("uin", attaAppInfo.getUin()).a("imei", "").a("thirdparty_app_type", "1").a(QZoneHelper.Constants.KEY_LAUNCH_TIME, String.valueOf(reportItem.getLaunchTime())).a("event_time", String.valueOf(reportItem.getEventTime())).a("report_time", String.valueOf(System.currentTimeMillis())).a("user_advice", reportItem.getUserAdvice().getAdvice()).a("user_advice_type", reportItem.getUserAdvice().b()).a("minibox_version", l51.a.a()).b();
    }

    private final void b(String url) {
        Response response = null;
        try {
            try {
                response = j51.a.f409276b.a().newCall(new Request.Builder().url(url).build()).execute();
                Intrinsics.checkExpressionValueIsNotNull(response, "response");
                if (!response.isSuccessful()) {
                    LogUtils.e("ExceptionReport", "[doReport] failed, code=" + response.code() + ", msg=" + response.message());
                } else {
                    LogUtils.d("ExceptionReport", "[doReport] success.");
                }
            } catch (Exception e16) {
                LogUtils.e("ExceptionReport", "[doReport] exception.", e16);
            }
        } finally {
            m51.b.a(response);
        }
    }

    public final void c(@NotNull AttaReportItem reportItem, @NotNull AttaAppInfo attaAppInfo) {
        Intrinsics.checkParameterIsNotNull(reportItem, "reportItem");
        Intrinsics.checkParameterIsNotNull(attaAppInfo, "attaAppInfo");
        try {
            b(a(reportItem, attaAppInfo));
        } catch (Exception e16) {
            LogUtils.e("ExceptionReport", "[report] exception.", e16);
        }
    }
}
