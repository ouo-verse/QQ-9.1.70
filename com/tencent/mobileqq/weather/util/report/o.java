package com.tencent.mobileqq.weather.util.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/weather/util/report/o;", "", "", "module", "action", "", "index", "", "a", "bannerWeight", "c", "b", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f313691a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43876);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f313691a = new o();
        }
    }

    o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String module, @NotNull String action, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, module, action, Integer.valueOf(index));
            return;
        }
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(action, "action");
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", module);
        hashMap.put("action", action);
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#" + module + "#" + action);
        hashMap.put("ext5", String.valueOf(index));
        e.f313673a.b(hashMap);
    }

    public final void b(int bannerWeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, bannerWeight);
        } else {
            a("recommend_banner1", "click", bannerWeight);
            QLog.d("WeatherRecommendBannerAttaReporter", 2, "reportBannerClick:", Integer.valueOf(bannerWeight));
        }
    }

    public final void c(int bannerWeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, bannerWeight);
        } else {
            a("recommend_banner1", "exp", bannerWeight);
            QLog.d("WeatherRecommendBannerAttaReporter", 2, "reportBannerExpo:", Integer.valueOf(bannerWeight));
        }
    }
}
