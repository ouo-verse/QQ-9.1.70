package com.tencent.mobileqq.ecshop.view.adcard.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/ecshop/view/adcard/model/a;", "", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "adInfo", "", "a", h.F, "g", "c", "d", "f", "b", "", "j", "i", "", "e", "(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)Ljava/lang/Float;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f203961a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29303);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f203961a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(@NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) adInfo);
        }
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        return com.tencent.mobileqq.ecshop.ad.a.a(adInfo);
    }

    @NotNull
    public final String b(@NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) adInfo);
        }
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        return com.tencent.mobileqq.ecshop.ad.a.b(adInfo);
    }

    @NotNull
    public final String c(@NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) adInfo);
        }
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{494, 1662});
        if (listOf.contains(Integer.valueOf(com.tencent.mobileqq.ecshop.ad.a.c(adInfo)))) {
            return com.tencent.mobileqq.ecshop.ad.a.g(adInfo);
        }
        return com.tencent.mobileqq.ecshop.ad.a.e(adInfo);
    }

    @NotNull
    public final String d(@NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) adInfo);
        }
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        return com.tencent.mobileqq.ecshop.ad.a.f(adInfo);
    }

    @Nullable
    public final Float e(@NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Float) iPatchRedirector.redirect((short) 11, (Object) this, (Object) adInfo);
        }
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Float i3 = com.tencent.mobileqq.ecshop.ad.a.i(adInfo);
        if (i3 == null) {
            return com.tencent.mobileqq.ecshop.ad.a.d(adInfo);
        }
        return i3;
    }

    @NotNull
    public final String f(@NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) adInfo);
        }
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        return com.tencent.mobileqq.ecshop.ad.a.h(adInfo);
    }

    @NotNull
    public final String g(@NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) adInfo);
        }
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        return com.tencent.mobileqq.ecshop.ad.a.j(adInfo);
    }

    @NotNull
    public final String h(@NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) adInfo);
        }
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        return com.tencent.mobileqq.ecshop.ad.a.k(adInfo);
    }

    public final boolean i(@NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) adInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{710, Integer.valueOf(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST), 861});
        return listOf.contains(Integer.valueOf(com.tencent.mobileqq.ecshop.ad.a.c(adInfo)));
    }

    public final boolean j(@NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) adInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{185, 433, 1659, Integer.valueOf(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST), 861});
        return listOf.contains(Integer.valueOf(com.tencent.mobileqq.ecshop.ad.a.c(adInfo)));
    }
}
