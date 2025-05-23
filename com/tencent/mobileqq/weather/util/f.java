package com.tencent.mobileqq.weather.util;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdClickHelper;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdRenderProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\"\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/weather/util/f;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "resPath", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "maskAd", "", "isTianShuAd", "Ltencent/gdt/access$UserActionReportInfo;", "userActionReportInfo", "", "b", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "Lorg/json/JSONObject;", "d", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f313645a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43847);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f313645a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(final Activity activity, final String resPath, final qq_ad_get.QQAdGetRsp.AdInfo maskAd, final boolean isTianShuAd, final access.UserActionReportInfo userActionReportInfo) {
        if (maskAd == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.weather.util.e
            @Override // java.lang.Runnable
            public final void run() {
                f.c(activity, resPath, maskAd, isTianShuAd, userActionReportInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Activity activity, String str, qq_ad_get.QQAdGetRsp.AdInfo adInfo, boolean z16, access.UserActionReportInfo userActionReportInfo) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        MaskAdvName maskAdvName = MaskAdvName.QQ_WEATHER;
        if (str == null) {
            str = "";
        }
        MaskAdRenderProxy maskAdRenderProxy = new MaskAdRenderProxy(activity, maskAdvName, str, adInfo);
        maskAdRenderProxy.setIsTianShuAd(z16);
        if (userActionReportInfo != null) {
            maskAdRenderProxy.setUserActionReportInfo(userActionReportInfo);
        }
        View findViewById = activity.findViewById(R.id.f121047a7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "activity.findViewById(R.id.weather_main_layout)");
        maskAdRenderProxy.startShow((ViewGroup) findViewById);
    }

    @NotNull
    public final JSONObject d(@Nullable Activity activity, @NotNull GdtAd ad5, @Nullable access.UserActionReportInfo userActionReportInfo) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        String str;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo2;
        String str2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, this, activity, ad5, userActionReportInfo);
        }
        Intrinsics.checkNotNullParameter(ad5, "ad");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("weather", 0);
        if (activity == null) {
            QLog.d("WeatherMainMaskWorker", 1, "cancel show maskAd, activity is null");
            return jSONObject;
        }
        long aId = ad5.getAId();
        String posId = ad5.getPosId();
        if (jSONObject.has("weather")) {
            jSONObject.put("weather", 1);
        }
        com.tencent.mobileqq.weather.mvvm.a aVar = com.tencent.mobileqq.weather.mvvm.a.f313393a;
        if (TextUtils.equals(aVar.c(), posId) && MaskAdClickHelper.INSTANCE.isMaskAd(ad5.getInnerShowType())) {
            adInfo = ad5.info;
            str = aVar.b(aId);
        } else {
            adInfo = null;
            str = "";
        }
        if (TextUtils.equals(aVar.d(), posId)) {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo3 = ad5.info;
            str2 = aVar.b(aId);
            adInfo2 = adInfo3;
            z16 = true;
        } else {
            adInfo2 = adInfo;
            str2 = str;
            z16 = false;
        }
        if (adInfo2 != null) {
            b(activity, str2, adInfo2, z16, userActionReportInfo);
        }
        return jSONObject;
    }
}
