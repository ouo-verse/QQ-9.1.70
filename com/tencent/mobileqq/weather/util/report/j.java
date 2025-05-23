package com.tencent.mobileqq.weather.util.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/weather/util/report/j;", "", "", "c", "", "hasAuth", "", "jumpFrom", "d", "uin", "", "enterTime", "exitTime", "e", "b", "a", "Z", "mHasReportedShowAll", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f313683a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean mHasReportedShowAll;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43870);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f313683a = new j();
        }
    }

    j() {
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
            mHasReportedShowAll = false;
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", "city_slide");
        hashMap.put("action", "click");
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#city_slide#click");
        e.f313673a.b(hashMap);
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", "wholepage_enter");
        hashMap.put("action", "exp");
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#wholepage_enter#exp");
        e.f313673a.b(hashMap);
    }

    public final void d(boolean hasAuth, @NotNull String jumpFrom) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(hasAuth), jumpFrom);
            return;
        }
        Intrinsics.checkNotNullParameter(jumpFrom, "jumpFrom");
        if (mHasReportedShowAll) {
            return;
        }
        mHasReportedShowAll = true;
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", "wholepage_showall");
        hashMap.put("action", "exp");
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#wholepage_showall#exp");
        if (hasAuth) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("ext6", str);
        hashMap.put("ext5", jumpFrom);
        hashMap.put("ext9", "1");
        e.f313673a.b(hashMap);
    }

    public final void e(@NotNull String uin, long enterTime, long exitTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uin, Long.valueOf(enterTime), Long.valueOf(exitTime));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", "wholepage_staytime");
        hashMap.put("action", "exp");
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#wholepage_staytime#exp");
        hashMap.put("ext4", String.valueOf(exitTime - enterTime));
        String valueOf = String.valueOf(enterTime);
        hashMap.put("ext5", uin + "_" + valueOf);
        hashMap.put("ext6", valueOf);
        hashMap.put("ext8", String.valueOf(exitTime));
        e.f313673a.b(hashMap);
    }
}
