package com.tencent.mobileqq.weather.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.weather.util.report.p;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0002R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0016\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/weather/util/h;", "", "", "f", "a", "d", "e", "g", tl.h.F, "", "hitCache", "c", "b", "", "J", "mClickWeatherEntryTime", "mRequestWeatherDataTime", "mRequestFirstScreenAdTime", "mResponseFirstScreenAdTime", "mResponseWeatherDataTime", "Z", "mIsAdCountFinish", "mIsWeatherCountFinish", "i", "mIsWeatherShowReport", "j", "mIsWeatherLoadCompleteReport", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f313657a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long mClickWeatherEntryTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long mRequestWeatherDataTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long mRequestFirstScreenAdTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long mResponseFirstScreenAdTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long mResponseWeatherDataTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean mIsAdCountFinish;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean mIsWeatherCountFinish;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean mIsWeatherShowReport;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean mIsWeatherLoadCompleteReport;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43849);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f313657a = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void f() {
        mIsAdCountFinish = false;
        mIsWeatherCountFinish = false;
        mIsWeatherShowReport = false;
        mIsWeatherLoadCompleteReport = false;
        mClickWeatherEntryTime = 0L;
        mRequestWeatherDataTime = 0L;
        mRequestFirstScreenAdTime = 0L;
        mResponseFirstScreenAdTime = 0L;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            f();
            mClickWeatherEntryTime = System.currentTimeMillis();
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            if (mIsWeatherLoadCompleteReport) {
                return;
            }
            mIsWeatherLoadCompleteReport = true;
            p.f313692a.c(System.currentTimeMillis() - mRequestWeatherDataTime, System.currentTimeMillis() - mClickWeatherEntryTime);
        }
    }

    public final void c(boolean hitCache) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, hitCache);
        } else {
            if (mIsWeatherShowReport) {
                return;
            }
            mIsWeatherShowReport = true;
            p.f313692a.d(mClickWeatherEntryTime, System.currentTimeMillis(), hitCache);
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        mRequestFirstScreenAdTime = currentTimeMillis;
        QLog.d("WeatherTimeCounter", 1, "reqFirstScreenAd from click: ", Long.valueOf(currentTimeMillis - mClickWeatherEntryTime), "ms");
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            mRequestWeatherDataTime = System.currentTimeMillis();
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (mIsAdCountFinish) {
            return;
        }
        mIsAdCountFinish = true;
        long currentTimeMillis = System.currentTimeMillis();
        mResponseFirstScreenAdTime = currentTimeMillis;
        long j3 = currentTimeMillis - mClickWeatherEntryTime;
        long j16 = currentTimeMillis - mRequestFirstScreenAdTime;
        QLog.d("WeatherTimeCounter", 1, "responseFirstScreenAdTime from click: ", Long.valueOf(j3), "ms");
        QLog.d("WeatherTimeCounter", 1, "rspFirstScreenAdTime from req: ", Long.valueOf(j16), "ms");
        p.f313692a.b(j16, j3);
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (mIsWeatherCountFinish) {
            return;
        }
        mIsWeatherCountFinish = true;
        long currentTimeMillis = System.currentTimeMillis();
        mResponseWeatherDataTime = currentTimeMillis;
        long j3 = currentTimeMillis - mClickWeatherEntryTime;
        QLog.d("WeatherTimeCounter", 1, "responseWeatherTime from click: ", Long.valueOf(j3), "ms");
        p.f313692a.e(j3);
    }
}
