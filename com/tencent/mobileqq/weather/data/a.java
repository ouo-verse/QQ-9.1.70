package com.tencent.mobileqq.weather.data;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.weather.util.WeatherMainConstant$MainScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010'\u001a\u00020%\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0005R$\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b!\u0010\u0018\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/weather/data/a;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/mobileqq/weather/util/WeatherMainConstant$MainScene;", "c", "bean", "", "d", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAdData", "", "i", "isHideAd", "j", "Lcom/tencent/gdtad/aditem/GdtAd;", "f", "()Lcom/tencent/gdtad/aditem/GdtAd;", "setGdtAd", "(Lcom/tencent/gdtad/aditem/GdtAd;)V", "gdtAd", "", "Ljava/lang/String;", "getAdUniqueKey", "()Ljava/lang/String;", "setAdUniqueKey", "(Ljava/lang/String;)V", "adUniqueKey", "e", "Z", "g", "()Z", tl.h.F, "(Z)V", "hideAd", "setAdPosId", "adPosId", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "reply", "", "pagePos", "adPosIdType", "<init>", "(Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;II)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtAd gdtAd;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String adUniqueKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hideAd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String adPosId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull weather$GetConcernWeatherReply reply, int i3, int i16) {
        super(reply, i3);
        String weatherFirstPosId;
        Intrinsics.checkNotNullParameter(reply, "reply");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, reply, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.adUniqueKey = "";
        if (i16 != 1) {
            if (i16 != 2) {
                weatherFirstPosId = "5062057908149413";
            } else {
                weatherFirstPosId = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherSecondPosId();
            }
        } else {
            weatherFirstPosId = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherFirstPosId();
        }
        this.adPosId = weatherFirstPosId;
    }

    @Override // com.tencent.mobileqq.weather.data.k
    @NotNull
    public WeatherMainConstant$MainScene c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (WeatherMainConstant$MainScene) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return WeatherMainConstant$MainScene.AD;
    }

    @Override // com.tencent.mobileqq.weather.data.k
    public boolean d(@Nullable k bean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) bean)).booleanValue();
        }
        if (!(bean instanceof a) || TextUtils.isEmpty(this.adUniqueKey) || !TextUtils.equals(this.adUniqueKey, ((a) bean).adUniqueKey)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.adPosId;
    }

    @Nullable
    public final GdtAd f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GdtAd) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.gdtAd;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.hideAd;
    }

    public final void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.hideAd = z16;
        }
    }

    public final void i(@Nullable GdtAd gdtAdData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) gdtAdData);
        } else {
            j(gdtAdData, false);
        }
    }

    public final void j(@Nullable GdtAd gdtAdData, boolean isHideAd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, gdtAdData, Boolean.valueOf(isHideAd));
            return;
        }
        this.gdtAd = gdtAdData;
        this.adUniqueKey = com.tencent.mobileqq.ad.cardad.utils.d.f186735a.b(gdtAdData);
        this.hideAd = isHideAd;
    }
}
