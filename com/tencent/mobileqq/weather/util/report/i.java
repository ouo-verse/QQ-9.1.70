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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u0007R8\u0010\u0012\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00020\u0002 \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00100\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/weather/util/report/i;", "", "", "module", "action", "ext6", "cityPage", "", "b", "", "e", "c", "d", "a", "", "kotlin.jvm.PlatformType", "", "Ljava/util/Set;", "mExpoReportedData", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f313681a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> mExpoReportedData;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43869);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f313681a = new i();
            mExpoReportedData = Collections.synchronizedSet(new HashSet());
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            mExpoReportedData.clear();
        }
    }

    public final void b(@NotNull String module, @NotNull String action, @NotNull String ext6, @NotNull String cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, module, action, ext6, cityPage);
            return;
        }
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(ext6, "ext6");
        Intrinsics.checkNotNullParameter(cityPage, "cityPage");
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", module);
        hashMap.put("action", action);
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#" + module + "#" + action);
        if (!TextUtils.isEmpty(ext6)) {
            hashMap.put("ext6", ext6);
        }
        hashMap.put("ext9", cityPage);
        e.f313673a.b(hashMap);
    }

    public final void c(int cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, cityPage);
        } else {
            b("hourweather_more", "click", "", String.valueOf(cityPage + 1));
            QLog.d("WeatherHourForecastAttaReporter", 2, "reportDaysWeatherMoreClick:", Integer.valueOf(cityPage));
        }
    }

    public final void d(int cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, cityPage);
        } else {
            b("hourweather_slide", "click", "", String.valueOf(cityPage + 1));
            QLog.d("WeatherHourForecastAttaReporter", 2, "reportDaysWeatherSlide:", Integer.valueOf(cityPage));
        }
    }

    public final void e(int cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, cityPage);
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
        b("hourweather", "exp", "", String.valueOf(cityPage + 1));
        set.add(valueOf);
        QLog.d("WeatherHourForecastAttaReporter", 2, "reportItemExpo:", valueOf);
    }
}
