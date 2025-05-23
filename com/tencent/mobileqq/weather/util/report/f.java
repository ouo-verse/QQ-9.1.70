package com.tencent.mobileqq.weather.util.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0005R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/weather/util/report/f;", "", "", "action", "briefState", "", "b", "source", "e", "", "d", "c", "a", "", "Z", "mHasReportExpo", "", "J", "mOpenRainFallPageStartTime", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f313674a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean mHasReportExpo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long mOpenRainFallPageStartTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43866);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f313674a = new f();
        }
    }

    f() {
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
            mHasReportExpo = false;
            mOpenRainFallPageStartTime = 0L;
        }
    }

    public final void b(@NotNull String action, @NotNull String briefState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) action, (Object) briefState);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(briefState, "briefState");
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", "top_rainsnow");
        hashMap.put("action", action);
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#top_rainsnow#" + action);
        hashMap.put("ext3", briefState);
        hashMap.put("ext9", "1");
        e.f313673a.b(hashMap);
    }

    public final void c(int briefState) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, briefState);
            return;
        }
        mOpenRainFallPageStartTime = System.currentTimeMillis();
        if (briefState != 1) {
            if (briefState != 2) {
                str = "3";
            } else {
                str = "2";
            }
        } else {
            str = "1";
        }
        b("click", str);
        QLog.d("WeatherBriefAttaReporter", 2, "reportItemClick:", str);
    }

    public final void d(int briefState) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, briefState);
            return;
        }
        if (mHasReportExpo) {
            return;
        }
        if (briefState != 1) {
            if (briefState != 2) {
                str = "3";
            } else {
                str = "2";
            }
        } else {
            str = "1";
        }
        b("exp", str);
        mHasReportExpo = true;
        QLog.d("WeatherBriefAttaReporter", 2, "reportItemExpo:", str);
    }

    public final void e(@NotNull String briefState, @NotNull String source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) briefState, (Object) source);
            return;
        }
        Intrinsics.checkNotNullParameter(briefState, "briefState");
        Intrinsics.checkNotNullParameter(source, "source");
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", "top_rainsnow_page");
        hashMap.put("action", "exp");
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#top_rainsnow_page#exp");
        hashMap.put("ext3", briefState);
        hashMap.put("ext5", String.valueOf(System.currentTimeMillis() - mOpenRainFallPageStartTime));
        hashMap.put("ext4", source);
        hashMap.put("ext9", "1");
        e.f313673a.b(hashMap);
    }
}
