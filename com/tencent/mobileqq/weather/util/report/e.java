package com.tencent.mobileqq.weather.util.report;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.measure.report.ATTAReporter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/weather/util/report/e;", "", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "b", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f313673a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43864);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f313673a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Map reportParams) {
        String message;
        List list;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        if (QLog.isColorLevel()) {
            list = MapsKt___MapsKt.toList(reportParams);
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null);
            QLog.i("WeatherAttaReporter", 2, "reportParams: " + joinToString$default);
        }
        Uri.Builder buildUpon = Uri.parse("https://h.trace.qq.com/kv").buildUpon();
        buildUpon.appendQueryParameter("token", "6257952621");
        buildUpon.appendQueryParameter("attaid", "0cc00071620");
        String currentUin = VasUtil.getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(currentUin, "VasUtil.getCurrentUin() ?: \"\"");
        }
        buildUpon.appendQueryParameter("uin", currentUin);
        buildUpon.appendQueryParameter("platform", "Android");
        buildUpon.appendQueryParameter("band", Build.BOARD);
        buildUpon.appendQueryParameter("model", DeviceInfoMonitor.getModel());
        buildUpon.appendQueryParameter("app_version", AppSetting.f99551k);
        buildUpon.appendQueryParameter("os_version", Build.VERSION.RELEASE);
        buildUpon.appendQueryParameter("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
        for (Map.Entry entry : reportParams.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        String uri = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uriBuilder.build().toString()");
        Bundle bundle = new Bundle();
        bundle.putString(ATTAReporter.ATTA_TYPE, ATTAReporter.BATCH_REPORT);
        try {
            message = HttpUtil.openUrl(BaseApplication.getContext(), uri, "GET", null, bundle);
        } catch (IOException e16) {
            QLog.e("WeatherAttaReporter", 1, "report atta IOException, url=" + uri, e16);
            message = e16.getMessage();
        } catch (ClassNotFoundException e17) {
            QLog.e("WeatherAttaReporter", 1, "report atta ClassNotFoundException, url=" + uri, e17);
            message = e17.getMessage();
        }
        QLog.i("WeatherAttaReporter", 1, "report atta, result = " + message);
    }

    public final void b(@NotNull final Map<String, ? extends Object> reportParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) reportParams);
        } else {
            Intrinsics.checkNotNullParameter(reportParams, "reportParams");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.weather.util.report.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.c(reportParams);
                }
            }, 128, null, false);
        }
    }
}
