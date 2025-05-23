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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0006R8\u0010\u0010\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00020\u0002 \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u000e0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/weather/util/report/s;", "", "", "action", "warningIndex", "cityPage", "", "b", "", "d", "c", "a", "", "kotlin.jvm.PlatformType", "", "Ljava/util/Set;", "mExpoReportedData", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f313696a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> mExpoReportedData;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43883);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f313696a = new s();
            mExpoReportedData = Collections.synchronizedSet(new HashSet());
        }
    }

    s() {
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

    public final void b(@NotNull String action, @NotNull String warningIndex, @NotNull String cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, action, warningIndex, cityPage);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(warningIndex, "warningIndex");
        Intrinsics.checkNotNullParameter(cityPage, "cityPage");
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", "top_warning");
        hashMap.put("action", action);
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#top_warning#" + action);
        if (!TextUtils.isEmpty(warningIndex)) {
            hashMap.put("ext6", warningIndex);
        }
        hashMap.put("ext9", cityPage);
        e.f313673a.b(hashMap);
    }

    public final void c(int warningIndex, int cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(warningIndex), Integer.valueOf(cityPage));
            return;
        }
        String valueOf = String.valueOf(cityPage + 1);
        String valueOf2 = String.valueOf(warningIndex + 1);
        b("click", valueOf2, valueOf);
        QLog.d("WeatherWarningAttaReporter", 2, "reportItemClick:", valueOf2, ",cityPage:", Integer.valueOf(cityPage));
    }

    public final void d(int cityPage) {
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
        b("exp", "", String.valueOf(cityPage + 1));
        set.add(valueOf);
        QLog.d("WeatherWarningAttaReporter", 2, "reportItemExpo:", valueOf);
    }
}
