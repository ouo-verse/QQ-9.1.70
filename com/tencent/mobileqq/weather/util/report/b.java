package com.tencent.mobileqq.weather.util.report;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdClickHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006JF\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ&\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0006\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/weather/util/report/b;", "", "", "module", "action", "posId", "", "cityPage", "", "a", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", QQBrowserActivity.APP_PARAM, "b", "i", "j", "k", tl.h.F, "f", "g", "e", "l", Element.ELEMENT_NAME_TIMES, "d", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f313669a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43860);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f313669a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void c(b bVar, String str, String str2, String str3, int i3, GdtAd gdtAd, Map map, int i16, Object obj) {
        if ((i16 & 32) != 0) {
            map = null;
        }
        bVar.b(str, str2, str3, i3, gdtAd, map);
    }

    public final void a(@NotNull String module, @NotNull String action, @NotNull String posId, int cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, module, action, posId, Integer.valueOf(cityPage));
            return;
        }
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(posId, "posId");
        String valueOf = String.valueOf(cityPage + 1);
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", module);
        hashMap.put("action", action);
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#" + module + "#" + action);
        hashMap.put("ext5", posId);
        hashMap.put("ext9", valueOf);
        e.f313673a.b(hashMap);
    }

    public final void b(@NotNull String module, @NotNull String action, @NotNull String posId, int cityPage, @NotNull GdtAd gdtAd, @Nullable Map<String, String> extraParams) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, module, action, posId, Integer.valueOf(cityPage), gdtAd, extraParams);
            return;
        }
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        String valueOf = String.valueOf(cityPage + 1);
        if (MaskAdClickHelper.INSTANCE.isMaskAd(gdtAd.getInnerShowType())) {
            str = "1";
        } else {
            str = "0";
        }
        String valueOf2 = String.valueOf(gdtAd.getInnerShowType());
        HashMap hashMap = new HashMap();
        if (extraParams != null) {
            for (Map.Entry<String, String> entry : extraParams.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", module);
        hashMap.put("action", action);
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#" + module + "#" + action);
        hashMap.put("ext4", str);
        hashMap.put("ext5", posId);
        hashMap.put("ext7", valueOf2);
        hashMap.put("ext9", valueOf);
        hashMap.put("ext10", "1");
        e.f313673a.b(hashMap);
    }

    public final void d(@NotNull String posId, int cityPage, @NotNull GdtAd gdtAd, int times) {
        Map<String, String> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, posId, Integer.valueOf(cityPage), gdtAd, Integer.valueOf(times));
            return;
        }
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ext8", String.valueOf(times)));
        b("ad_carousel", "number", posId, cityPage, gdtAd, mapOf);
        QLog.d("WeatherAdAttaReporter", 1, "reportAdCarousel posId:", posId, ",cityPageValue:", Integer.valueOf(cityPage + 1));
    }

    public final void e(@NotNull String posId, int cityPage, @NotNull GdtAd gdtAd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, posId, Integer.valueOf(cityPage), gdtAd);
            return;
        }
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        c(this, "ad_click", "click", posId, cityPage, gdtAd, null, 32, null);
        QLog.d("WeatherAdAttaReporter", 1, "reportAdClick posId:", posId, ",cityPageValue:", Integer.valueOf(cityPage + 1));
    }

    public final void f(@NotNull String posId, int cityPage, @NotNull GdtAd gdtAd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, posId, Integer.valueOf(cityPage), gdtAd);
            return;
        }
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        c(this, "ad_expose1", "exp", posId, cityPage, gdtAd, null, 32, null);
        QLog.d("WeatherAdAttaReporter", 1, "reportAdExpo1Px posId:", posId, ",cityPageValue:", Integer.valueOf(cityPage + 1));
    }

    public final void g(@NotNull String posId, int cityPage, @NotNull GdtAd gdtAd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, posId, Integer.valueOf(cityPage), gdtAd);
            return;
        }
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        c(this, "ad_expose2", "exp", posId, cityPage, gdtAd, null, 32, null);
        QLog.d("WeatherAdAttaReporter", 1, "reportAdExpo50PercentPx posId:", posId, ",cityPageValue:", Integer.valueOf(cityPage + 1));
    }

    public final void h(@NotNull String posId, int cityPage, @NotNull GdtAd gdtAd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, posId, Integer.valueOf(cityPage), gdtAd);
            return;
        }
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        c(this, "ad_loaded", "load", posId, cityPage, gdtAd, null, 32, null);
        QLog.d("WeatherAdAttaReporter", 1, "reportAdLoad posId:", posId, ",cityPageValue:", Integer.valueOf(cityPage + 1));
    }

    public final void i(@NotNull String posId, int cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) posId, cityPage);
            return;
        }
        Intrinsics.checkNotNullParameter(posId, "posId");
        a("ad_request", Const.BUNDLE_KEY_REQUEST, posId, cityPage);
        QLog.d("WeatherAdAttaReporter", 1, "reportAdRequest posId:", posId, ",cityPageValue:", Integer.valueOf(cityPage + 1));
    }

    public final void j(@NotNull String posId, int cityPage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) posId, cityPage);
            return;
        }
        Intrinsics.checkNotNullParameter(posId, "posId");
        a("ad_requestfail", Const.BUNDLE_KEY_REQUEST, posId, cityPage);
        QLog.d("WeatherAdAttaReporter", 1, "reportAdRequestFail posId:", posId, ",cityPageValue:", Integer.valueOf(cityPage + 1));
    }

    public final void k(@NotNull String posId, int cityPage, @NotNull GdtAd gdtAd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, posId, Integer.valueOf(cityPage), gdtAd);
            return;
        }
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        c(this, "ad_return", "return", posId, cityPage, gdtAd, null, 32, null);
        QLog.d("WeatherAdAttaReporter", 1, "reportAdReturn posId:", posId, ",cityPageValue:", Integer.valueOf(cityPage + 1));
    }

    public final void l(@NotNull String posId, int cityPage, @NotNull GdtAd gdtAd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, posId, Integer.valueOf(cityPage), gdtAd);
            return;
        }
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        c(this, "ad_close", "click", posId, cityPage, gdtAd, null, 32, null);
        QLog.d("WeatherAdAttaReporter", 1, "reportCloseClick posId:", posId, ",cityPageValue:", Integer.valueOf(cityPage + 1));
    }
}
