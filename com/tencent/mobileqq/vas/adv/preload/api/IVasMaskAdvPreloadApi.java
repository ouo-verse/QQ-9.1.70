package com.tencent.mobileqq.vas.adv.preload.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdDownloadCallBack;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH&J$\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\fH&J\b\u0010\u0016\u001a\u00020\fH&J\b\u0010\u0017\u001a\u00020\fH&J\b\u0010\u0018\u001a\u00020\fH&J\b\u0010\u0019\u001a\u00020\fH&J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\nH&J\b\u0010\u001e\u001a\u00020\nH&J\"\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\"\u001a\u00020\u0003H&\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/preload/api/IVasMaskAdvPreloadApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "cleanMaskAdCache", "", "downloadMaskAdRealTime", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$PosAdInfo;", "callBack", "Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdDownloadCallBack;", "fileExists", "", "filePath", "", "getHealthPosId", "getHealthTianShuPosId", "getMaskAdInfoList", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", "getWeatherFirstPosId", "getWeatherSecondPosId", "getWeatherTianShuPosId", "getWeatherWebUrl", "getWeatherWeekFirstPosId", "isImageMaskAd", "type", "", "isShowMaskAdForHealth", "isShowMaskAdForWeather", "reportEventToBeacon", "eventId", "params", "requestMaskAdAndDownloadFile", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasMaskAdvPreloadApi extends QRouteApi {
    void cleanMaskAdCache();

    void downloadMaskAdRealTime(@NotNull qq_ad_get.QQAdGetRsp.PosAdInfo adInfo, @NotNull MaskAdDownloadCallBack callBack);

    boolean fileExists(@Nullable String filePath);

    @NotNull
    String getHealthPosId();

    @NotNull
    String getHealthTianShuPosId();

    @Nullable
    ArrayList<JSONObject> getMaskAdInfoList(@NotNull MaskAdvName businessName);

    @NotNull
    String getWeatherFirstPosId();

    @NotNull
    String getWeatherSecondPosId();

    @NotNull
    String getWeatherTianShuPosId();

    @NotNull
    String getWeatherWebUrl();

    @NotNull
    String getWeatherWeekFirstPosId();

    boolean isImageMaskAd(int type);

    boolean isShowMaskAdForHealth();

    boolean isShowMaskAdForWeather();

    void reportEventToBeacon(@NotNull MaskAdvName businessName, @NotNull String eventId, @Nullable JSONObject params);

    void requestMaskAdAndDownloadFile();
}
