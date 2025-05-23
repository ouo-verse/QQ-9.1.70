package fz2;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b,\b\u0086\b\u0018\u0000 32\u00020\u0001:\u0001)B\u0089\u0001\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0004\u0012\b\b\u0002\u0010.\u001a\u00020\u0004\u0012\b\b\u0002\u00100\u001a\u00020\u0002\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0017\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0012\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u0015\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001aR\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b\u000f\u0010\u001aR\u0017\u0010&\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b\n\u0010\u001aR\u0017\u0010+\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010.\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*R\u0017\u00100\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b/\u0010\u001a\u00a8\u00064"}, d2 = {"Lfz2/a;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "j", "()Z", "isPreloadAd", "e", "l", "isShowMaskForWeather", "f", "k", "isShowMaskForHealth", h.F, "getOnlyDownloadInWifi", "onlyDownloadInWifi", "i", "Ljava/lang/String;", "()Ljava/lang/String;", "weatherFirstPosId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "weatherSecondPosId", BdhLogUtil.LogTag.Tag_Conn, "weatherWeekFirstPosId", "D", "c", "healthPosId", "E", "tianShuWeatherPosId", UserInfo.SEX_FEMALE, "tianShuHealthPosId", "G", "I", "a", "()I", "adEffectiveInterval", "H", "b", "adInfoListMaxSize", "g", "weatherH5Url", "<init>", "(ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "J", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: fz2.a, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class AdConfigBean implements IConfigData {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private final String weatherWeekFirstPosId;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @NotNull
    private final String healthPosId;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @NotNull
    private final String tianShuWeatherPosId;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @NotNull
    private final String tianShuHealthPosId;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    private final int adEffectiveInterval;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    private final int adInfoListMaxSize;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @NotNull
    private final String weatherH5Url;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isPreloadAd;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isShowMaskForWeather;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isShowMaskForHealth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean onlyDownloadInWifi;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String weatherFirstPosId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String weatherSecondPosId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lfz2/a$a;", "", "", "content", "Lfz2/a;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fz2.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AdConfigBean a(@Nullable String content) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            if (content != null && content.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return new AdConfigBean(false, false, false, false, null, null, null, null, null, null, 0, 0, null, InitSkin.DRAWABLE_COUNT, null);
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                if (jSONObject.optInt("openMaskAdPreload", 0) == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (jSONObject.optInt("weatherShowMask", 0) == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (jSONObject.optInt("healthShowMask", 0) == 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (jSONObject.optInt("onlyDownloadInWifi", 0) == 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                String optString = jSONObject.optString("weatherHippyFirstAdPosId", "6011195015998218");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(WEA\u2026ULT_WEATHER_FIRST_POS_ID)");
                String optString2 = jSONObject.optString("weatherHippySecondAdPosId", "1021798076402236");
                Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(WEA\u2026LT_WEATHER_SECOND_POS_ID)");
                String optString3 = jSONObject.optString("healthHippyAdPosId", "1082214467882419");
                Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(HEA\u2026Y, DEFAULT_HEALTH_POS_ID)");
                String optString4 = jSONObject.optString("tianShuWeatherAdPosId", "mengcheng_tianshu_1013");
                Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(TIA\u2026T_TIANSHU_WEATHER_POS_ID)");
                String optString5 = jSONObject.optString("tianShuHealthAdPosId", "mengcheng_tianshu_1012");
                Intrinsics.checkNotNullExpressionValue(optString5, "jsonObject.optString(TIA\u2026LT_TIANSHU_HEALTH_POS_ID)");
                int optInt = jSONObject.optInt("adEffectiveInterval", 7);
                int optInt2 = jSONObject.optInt("adInfoListMaxSize", 20);
                String optString6 = jSONObject.optString("weatherDefaulH5Url", "https://weather.mp.qq.com/page/home?_wv=16777219&_wwv=2&adcode=");
                Intrinsics.checkNotNullExpressionValue(optString6, "jsonObject.optString(WEA\u2026, DEFAULT_WEATHER_H5_URL)");
                return new AdConfigBean(z17, z18, z19, z26, optString, optString2, "4094349949158937", optString3, optString4, optString5, optInt, optInt2, optString6);
            } catch (JSONException e16) {
                QLog.e("AdConfigBean", 1, e16, new Object[0]);
                return new AdConfigBean(false, false, false, false, null, null, null, null, null, null, 0, 0, null, InitSkin.DRAWABLE_COUNT, null);
            }
        }

        Companion() {
        }
    }

    public AdConfigBean() {
        this(false, false, false, false, null, null, null, null, null, null, 0, 0, null, InitSkin.DRAWABLE_COUNT, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getAdEffectiveInterval() {
        return this.adEffectiveInterval;
    }

    /* renamed from: b, reason: from getter */
    public final int getAdInfoListMaxSize() {
        return this.adInfoListMaxSize;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getHealthPosId() {
        return this.healthPosId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTianShuHealthPosId() {
        return this.tianShuHealthPosId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTianShuWeatherPosId() {
        return this.tianShuWeatherPosId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdConfigBean)) {
            return false;
        }
        AdConfigBean adConfigBean = (AdConfigBean) other;
        if (this.isPreloadAd == adConfigBean.isPreloadAd && this.isShowMaskForWeather == adConfigBean.isShowMaskForWeather && this.isShowMaskForHealth == adConfigBean.isShowMaskForHealth && this.onlyDownloadInWifi == adConfigBean.onlyDownloadInWifi && Intrinsics.areEqual(this.weatherFirstPosId, adConfigBean.weatherFirstPosId) && Intrinsics.areEqual(this.weatherSecondPosId, adConfigBean.weatherSecondPosId) && Intrinsics.areEqual(this.weatherWeekFirstPosId, adConfigBean.weatherWeekFirstPosId) && Intrinsics.areEqual(this.healthPosId, adConfigBean.healthPosId) && Intrinsics.areEqual(this.tianShuWeatherPosId, adConfigBean.tianShuWeatherPosId) && Intrinsics.areEqual(this.tianShuHealthPosId, adConfigBean.tianShuHealthPosId) && this.adEffectiveInterval == adConfigBean.adEffectiveInterval && this.adInfoListMaxSize == adConfigBean.adInfoListMaxSize && Intrinsics.areEqual(this.weatherH5Url, adConfigBean.weatherH5Url)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getWeatherFirstPosId() {
        return this.weatherFirstPosId;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getWeatherH5Url() {
        return this.weatherH5Url;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getWeatherSecondPosId() {
        return this.weatherSecondPosId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.isPreloadAd;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.isShowMaskForWeather;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        ?? r27 = this.isShowMaskForHealth;
        int i19 = r27;
        if (r27 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        boolean z17 = this.onlyDownloadInWifi;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((((((((((((((((((i26 + i3) * 31) + this.weatherFirstPosId.hashCode()) * 31) + this.weatherSecondPosId.hashCode()) * 31) + this.weatherWeekFirstPosId.hashCode()) * 31) + this.healthPosId.hashCode()) * 31) + this.tianShuWeatherPosId.hashCode()) * 31) + this.tianShuHealthPosId.hashCode()) * 31) + this.adEffectiveInterval) * 31) + this.adInfoListMaxSize) * 31) + this.weatherH5Url.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getWeatherWeekFirstPosId() {
        return this.weatherWeekFirstPosId;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsPreloadAd() {
        return this.isPreloadAd;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsShowMaskForHealth() {
        return this.isShowMaskForHealth;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsShowMaskForWeather() {
        return this.isShowMaskForWeather;
    }

    @NotNull
    public String toString() {
        return "AdConfigBean(isPreloadAd=" + this.isPreloadAd + ", isShowMaskForWeather=" + this.isShowMaskForWeather + ", isShowMaskForHealth=" + this.isShowMaskForHealth + ", onlyDownloadInWifi=" + this.onlyDownloadInWifi + ", weatherFirstPosId=" + this.weatherFirstPosId + ", weatherSecondPosId=" + this.weatherSecondPosId + ", weatherWeekFirstPosId=" + this.weatherWeekFirstPosId + ", healthPosId=" + this.healthPosId + ", tianShuWeatherPosId=" + this.tianShuWeatherPosId + ", tianShuHealthPosId=" + this.tianShuHealthPosId + ", adEffectiveInterval=" + this.adEffectiveInterval + ", adInfoListMaxSize=" + this.adInfoListMaxSize + ", weatherH5Url=" + this.weatherH5Url + ')';
    }

    public AdConfigBean(boolean z16, boolean z17, boolean z18, boolean z19, @NotNull String weatherFirstPosId, @NotNull String weatherSecondPosId, @NotNull String weatherWeekFirstPosId, @NotNull String healthPosId, @NotNull String tianShuWeatherPosId, @NotNull String tianShuHealthPosId, int i3, int i16, @NotNull String weatherH5Url) {
        Intrinsics.checkNotNullParameter(weatherFirstPosId, "weatherFirstPosId");
        Intrinsics.checkNotNullParameter(weatherSecondPosId, "weatherSecondPosId");
        Intrinsics.checkNotNullParameter(weatherWeekFirstPosId, "weatherWeekFirstPosId");
        Intrinsics.checkNotNullParameter(healthPosId, "healthPosId");
        Intrinsics.checkNotNullParameter(tianShuWeatherPosId, "tianShuWeatherPosId");
        Intrinsics.checkNotNullParameter(tianShuHealthPosId, "tianShuHealthPosId");
        Intrinsics.checkNotNullParameter(weatherH5Url, "weatherH5Url");
        this.isPreloadAd = z16;
        this.isShowMaskForWeather = z17;
        this.isShowMaskForHealth = z18;
        this.onlyDownloadInWifi = z19;
        this.weatherFirstPosId = weatherFirstPosId;
        this.weatherSecondPosId = weatherSecondPosId;
        this.weatherWeekFirstPosId = weatherWeekFirstPosId;
        this.healthPosId = healthPosId;
        this.tianShuWeatherPosId = tianShuWeatherPosId;
        this.tianShuHealthPosId = tianShuHealthPosId;
        this.adEffectiveInterval = i3;
        this.adInfoListMaxSize = i16;
        this.weatherH5Url = weatherH5Url;
    }

    public /* synthetic */ AdConfigBean(boolean z16, boolean z17, boolean z18, boolean z19, String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16, String str7, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? true : z16, (i17 & 2) != 0 ? true : z17, (i17 & 4) != 0 ? true : z18, (i17 & 8) == 0 ? z19 : true, (i17 & 16) != 0 ? "6011195015998218" : str, (i17 & 32) != 0 ? "1021798076402236" : str2, (i17 & 64) != 0 ? "4094349949158937" : str3, (i17 & 128) != 0 ? "1082214467882419" : str4, (i17 & 256) != 0 ? "mengcheng_tianshu_1013" : str5, (i17 & 512) != 0 ? "mengcheng_tianshu_1012" : str6, (i17 & 1024) != 0 ? 7 : i3, (i17 & 2048) != 0 ? 20 : i16, (i17 & 4096) != 0 ? "https://weather.mp.qq.com/page/home?_wv=16777219&_wwv=2&adcode=" : str7);
    }
}
