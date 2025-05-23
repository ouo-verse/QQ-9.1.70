package com.tencent.mobileqq.weather.util.report;

import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.hippy.qq.utils.AttaReporter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/weather/util/report/a;", "", "", "key", "value", "b", "a", "", "clickTime", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, "", "c", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f313667a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/weather/util/report/a$a", "Lcom/tencent/qqnt/http/api/l;", "Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/m;", "result", "", "onFailed", "onSuccess", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.util.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C8967a implements com.tencent.qqnt.http.api.l {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f313668a;

        C8967a(String str) {
            this.f313668a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onFailed(@NotNull com.tencent.qqnt.http.api.b task, @NotNull com.tencent.qqnt.http.api.m result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.e("VasBusinessAttaReporter", 1, "reportAttaVas error");
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onSuccess(@NotNull com.tencent.qqnt.http.api.b task, @NotNull com.tencent.qqnt.http.api.m result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) task, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("VasBusinessAttaReporter", 2, "reportAttaVas success:", this.f313668a);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43859);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f313667a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a() {
        int networkType = NetworkUtil.getNetworkType(MobileQQ.sMobileQQ);
        if (networkType != 1) {
            if (networkType != 2) {
                if (networkType != 3) {
                    if (networkType != 4) {
                        if (networkType != 6) {
                            return "UNKNOWN";
                        }
                        return "5G";
                    }
                    return "4G";
                }
                return "3G";
            }
            return "2G";
        }
        return "WiFi";
    }

    private final String b(String key, String value) {
        return ContainerUtils.FIELD_DELIMITER + key + ContainerUtils.KEY_VALUE_DELIMITER + value;
    }

    public final void c(long clickTime, long showTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(clickTime), Long.valueOf(showTime));
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("attaid=06f00076856");
        sb5.append(b("token", "4916318627"));
        sb5.append(b("business", "qqbusiness"));
        sb5.append(b("page", "qqweather_native"));
        sb5.append(b("type", "5"));
        sb5.append(b("click_start", String.valueOf(clickTime)));
        sb5.append(b("first_screen_view", String.valueOf(showTime)));
        sb5.append(b("platform", "android"));
        sb5.append(b("network", a()));
        String qua3 = QUA.getQUA3();
        String str = "";
        if (qua3 == null) {
            qua3 = "";
        }
        sb5.append(b("qua", qua3));
        sb5.append(b("load_mode", "0"));
        String currentUin = VasUtil.getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        sb5.append(b("uin", currentUin));
        String str2 = Build.DEVICE;
        if (str2 != null) {
            str = str2;
        }
        sb5.append(b("device", str));
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder()\n        \u2026.DEVICE?: \"\")).toString()");
        AttaReporter.INSTANCE.doReport(sb6, new C8967a(sb6));
    }
}
