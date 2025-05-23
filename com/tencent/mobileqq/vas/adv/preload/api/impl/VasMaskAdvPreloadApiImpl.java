package com.tencent.mobileqq.vas.adv.preload.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdDownloadCallBack;
import com.tencent.mobileqq.vas.adv.preload.MaskAdDownloadManager;
import com.tencent.mobileqq.vas.adv.preload.a;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.vas.adv.preload.e;
import fz2.AdConfigBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J$\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\"\u0010 \u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/preload/api/impl/VasMaskAdvPreloadApiImpl;", "Lcom/tencent/mobileqq/vas/adv/preload/api/IVasMaskAdvPreloadApi;", "()V", "cleanMaskAdCache", "", "downloadMaskAdRealTime", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$PosAdInfo;", "callBack", "Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdDownloadCallBack;", "fileExists", "", "filePath", "", "getHealthPosId", "getHealthTianShuPosId", "getMaskAdInfoList", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", "getWeatherFirstPosId", "getWeatherSecondPosId", "getWeatherTianShuPosId", "getWeatherWebUrl", "getWeatherWeekFirstPosId", "isImageMaskAd", "type", "", "isShowMaskAdForHealth", "isShowMaskAdForWeather", "reportEventToBeacon", "eventId", "params", "requestMaskAdAndDownloadFile", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasMaskAdvPreloadApiImpl implements IVasMaskAdvPreloadApi {
    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    public void cleanMaskAdCache() {
        a.f308150a.b();
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    public void downloadMaskAdRealTime(@NotNull qq_ad_get.QQAdGetRsp.PosAdInfo adInfo, @NotNull MaskAdDownloadCallBack callBack) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        MaskAdDownloadManager.f308139a.r(adInfo, callBack);
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    public boolean fileExists(@Nullable String filePath) {
        return a.f308150a.c(filePath);
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    @NotNull
    public String getHealthPosId() {
        String healthPosId;
        AdConfigBean adConfigBean = (AdConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100480");
        if (adConfigBean == null || (healthPosId = adConfigBean.getHealthPosId()) == null) {
            return "1082214467882419";
        }
        return healthPosId;
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    @NotNull
    public String getHealthTianShuPosId() {
        String tianShuHealthPosId;
        AdConfigBean adConfigBean = (AdConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100480");
        if (adConfigBean == null || (tianShuHealthPosId = adConfigBean.getTianShuHealthPosId()) == null) {
            return "mengcheng_tianshu_1012";
        }
        return tianShuHealthPosId;
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    @Nullable
    public ArrayList<JSONObject> getMaskAdInfoList(@NotNull MaskAdvName businessName) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        return MaskAdDownloadManager.f308139a.j(businessName);
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    @NotNull
    public String getWeatherFirstPosId() {
        String weatherFirstPosId;
        AdConfigBean adConfigBean = (AdConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100480");
        if (adConfigBean == null || (weatherFirstPosId = adConfigBean.getWeatherFirstPosId()) == null) {
            return "6011195015998218";
        }
        return weatherFirstPosId;
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    @NotNull
    public String getWeatherSecondPosId() {
        String weatherSecondPosId;
        AdConfigBean adConfigBean = (AdConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100480");
        if (adConfigBean == null || (weatherSecondPosId = adConfigBean.getWeatherSecondPosId()) == null) {
            return "1021798076402236";
        }
        return weatherSecondPosId;
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    @NotNull
    public String getWeatherTianShuPosId() {
        String tianShuWeatherPosId;
        AdConfigBean adConfigBean = (AdConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100480");
        if (adConfigBean == null || (tianShuWeatherPosId = adConfigBean.getTianShuWeatherPosId()) == null) {
            return "mengcheng_tianshu_1013";
        }
        return tianShuWeatherPosId;
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    @NotNull
    public String getWeatherWebUrl() {
        boolean z16;
        AdConfigBean adConfigBean = (AdConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100480");
        if (adConfigBean != null) {
            if (adConfigBean.getWeatherH5Url().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return adConfigBean.getWeatherH5Url();
            }
        }
        return "https://weather.mp.qq.com/page/home?_wv=16777219&_wwv=2&adcode=";
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    @NotNull
    public String getWeatherWeekFirstPosId() {
        String weatherWeekFirstPosId;
        AdConfigBean adConfigBean = (AdConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100480");
        if (adConfigBean == null || (weatherWeekFirstPosId = adConfigBean.getWeatherWeekFirstPosId()) == null) {
            return "4094349949158937";
        }
        return weatherWeekFirstPosId;
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    public boolean isImageMaskAd(int type) {
        return a.f308150a.r(type);
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    public boolean isShowMaskAdForHealth() {
        AdConfigBean adConfigBean = (AdConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100480");
        if (adConfigBean != null) {
            return adConfigBean.getIsShowMaskForHealth();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    public boolean isShowMaskAdForWeather() {
        AdConfigBean adConfigBean = (AdConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100480");
        if (adConfigBean != null) {
            return adConfigBean.getIsShowMaskForWeather();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    public void reportEventToBeacon(@NotNull MaskAdvName businessName, @NotNull String eventId, @Nullable JSONObject params) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        e.f308162a.b(businessName, eventId, params);
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi
    public void requestMaskAdAndDownloadFile() {
        MaskAdDownloadManager.f308139a.o();
    }
}
