package com.tencent.mobileqq.weather.util.report;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0007R8\u0010\u0013\u001a&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00020\u0002 \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00110\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/weather/util/report/h;", "", "", "module", "action", "weatherChangeTip", "cityPage", "", "b", "", "", "hasWeatherChangeTip", "d", "c", "a", "", "kotlin.jvm.PlatformType", "", "Ljava/util/Set;", "mExpoReportedData", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f313679a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> mExpoReportedData;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43868);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f313679a = new h();
            mExpoReportedData = Collections.synchronizedSet(new HashSet());
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            mExpoReportedData.clear();
        }
    }

    public final void b(@NotNull String module, @NotNull String action, @NotNull String weatherChangeTip, @NotNull String cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, module, action, weatherChangeTip, cityPage);
            return;
        }
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(weatherChangeTip, "weatherChangeTip");
        Intrinsics.checkNotNullParameter(cityPage, "cityPage");
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", module);
        hashMap.put("action", action);
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#" + module + "#" + action);
        if (!TextUtils.isEmpty(weatherChangeTip)) {
            hashMap.put("ext6", weatherChangeTip);
        }
        hashMap.put("ext9", cityPage);
        e.f313673a.b(hashMap);
    }

    public final void c(int cityPage, boolean hasWeatherChangeTip) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(cityPage), Boolean.valueOf(hasWeatherChangeTip));
            return;
        }
        String valueOf = String.valueOf(cityPage + 1);
        if (hasWeatherChangeTip) {
            str = "1";
        } else {
            str = "0";
        }
        b("daysweather_more", "click", str, valueOf);
        QLog.d("WeatherDaysForecastAttaReporter", 2, "reportDasWeatherMoreClick:", Integer.valueOf(cityPage));
    }

    public final void d(int cityPage, boolean hasWeatherChangeTip) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(cityPage), Boolean.valueOf(hasWeatherChangeTip));
            return;
        }
        String valueOf = String.valueOf(cityPage);
        Set<String> set = mExpoReportedData;
        if (set.contains(valueOf)) {
            return;
        }
        if (set.size() > 100) {
            set.clear();
        }
        String valueOf2 = String.valueOf(cityPage + 1);
        if (hasWeatherChangeTip) {
            str = "1";
        } else {
            str = "0";
        }
        b("daysweather", "exp", str, valueOf2);
        set.add(valueOf);
        QLog.d("WeatherDaysForecastAttaReporter", 2, "reportItemExpo:", valueOf);
    }
}
