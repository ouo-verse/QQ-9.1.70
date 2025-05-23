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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ>\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J&\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\fJ&\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\fJ.\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\fJ&\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\nR8\u0010\u0018\u001a&\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00020\u0002 \u0015*\u0012\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00160\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/weather/util/report/n;", "", "", "module", "action", "id", "tag", "reference", "like", "cityPage", "", "b", "", "d", "c", "", "isLike", "e", "f", "a", "", "kotlin.jvm.PlatformType", "", "Ljava/util/Set;", "mExpoReportedData", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f313689a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> mExpoReportedData;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43874);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f313689a = new n();
            mExpoReportedData = Collections.synchronizedSet(new HashSet());
        }
    }

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            mExpoReportedData.clear();
        }
    }

    public final void b(@NotNull String module, @NotNull String action, @NotNull String id5, @NotNull String tag, @NotNull String reference, @NotNull String like, @NotNull String cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, module, action, id5, tag, reference, like, cityPage);
            return;
        }
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(reference, "reference");
        Intrinsics.checkNotNullParameter(like, "like");
        Intrinsics.checkNotNullParameter(cityPage, "cityPage");
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", module);
        hashMap.put("action", action);
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#" + module + "#" + action);
        hashMap.put("ext4", id5);
        hashMap.put("ext5", tag);
        hashMap.put("ext6", reference);
        if (!TextUtils.isEmpty(like)) {
            hashMap.put("ext7", like);
        }
        hashMap.put("ext9", cityPage);
        e.f313673a.b(hashMap);
    }

    public final void c(@NotNull String id5, @NotNull String tag, @NotNull String reference, int cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, id5, tag, reference, Integer.valueOf(cityPage));
            return;
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(reference, "reference");
        b("maxim_change", "click", id5, tag, reference, "", String.valueOf(cityPage + 1));
        QLog.d("WeatherQuoteAttaReporter", 2, "reportChangeClick:", id5);
    }

    public final void d(@NotNull String id5, @NotNull String tag, @NotNull String reference, int cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, id5, tag, reference, Integer.valueOf(cityPage));
            return;
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(reference, "reference");
        String valueOf = String.valueOf(cityPage);
        Set<String> set = mExpoReportedData;
        if (set.contains(valueOf)) {
            return;
        }
        if (set.size() > 100) {
            set.clear();
        }
        b("maxim", "exp", id5, tag, reference, "", String.valueOf(cityPage + 1));
        set.add(valueOf);
        QLog.d("WeatherQuoteAttaReporter", 2, "reportItemExpo:", valueOf);
    }

    public final void e(@NotNull String id5, @NotNull String tag, @NotNull String reference, boolean isLike, int cityPage) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, id5, tag, reference, Boolean.valueOf(isLike), Integer.valueOf(cityPage));
            return;
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(reference, "reference");
        String valueOf = String.valueOf(cityPage + 1);
        if (isLike) {
            str = "1";
        } else {
            str = "0";
        }
        b("maxim_like", "click", id5, tag, reference, str, valueOf);
        QLog.d("WeatherQuoteAttaReporter", 2, "reportLikeClick:", id5, "isLike:", Boolean.valueOf(isLike));
    }

    public final void f(@NotNull String id5, @NotNull String tag, @NotNull String reference, int cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, id5, tag, reference, Integer.valueOf(cityPage));
            return;
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(reference, "reference");
        b("maxim_partner", "click", id5, tag, reference, "", String.valueOf(cityPage + 1));
        QLog.d("WeatherQuoteAttaReporter", 2, "reportMoreClick:", id5);
    }
}
