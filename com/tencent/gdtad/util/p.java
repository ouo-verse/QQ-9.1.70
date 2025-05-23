package com.tencent.gdtad.util;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class p {
    private static GdtAd a(JSONObject jSONObject) {
        if (AdJSONUtil.isObjectNull(jSONObject)) {
            AdLog.e("GdtVideoCeilingUtil", "[buildGdtAdForVideoCelling] optionsJsonObject is null");
            return null;
        }
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
        adInfo.display_info.basic_info.img.set(AdJSONUtil.optString(jSONObject, "urlForCover", ""));
        adInfo.display_info.advertiser_info.corporate_logo.set(AdJSONUtil.optString(jSONObject, "adLogoUrl", ""));
        adInfo.display_info.advertiser_info.corporate_image_name.set(AdJSONUtil.optString(jSONObject, "adNameStr", ""));
        adInfo.report_info.landing_page_report_url.set(AdJSONUtil.optString(jSONObject, "landingPageReportUrl", ""));
        adInfo.report_info.trace_info.traceid.set(AdJSONUtil.optString(jSONObject, "traceId", ""));
        adInfo.report_info.trace_info.aid.set(AdJSONUtil.optLong(jSONObject, "aid", WebViewConstants.WV.ENABLE_WEBAIO_SWITCH));
        adInfo.report_info.exposure_url.set(AdJSONUtil.optString(jSONObject, "urlForImpression", ""));
        adInfo.report_info.video_report_url.set(AdJSONUtil.optString(jSONObject, "videoReportUrl", ""));
        adInfo.display_info.video_info.tencent_video_id.set(AdJSONUtil.optString(jSONObject, "vid", ""));
        adInfo.report_info.trace_info.noco_id.set(AdJSONUtil.optLong(jSONObject, "nocoID", 0L));
        adInfo.product_type.set(AdJSONUtil.optInt(jSONObject, "productType", Integer.MIN_VALUE));
        adInfo.app_info.app_package_name.set(AdJSONUtil.optString(jSONObject, "packageName", ""));
        new qq_ad_get.QQAdGetRsp.AdInfo.Ext();
        return new GdtAd(adInfo);
    }

    public static AdVideoCeiling.Params b(JSONObject jSONObject, Activity activity) {
        if (AdJSONUtil.isObjectNull(jSONObject)) {
            AdLog.i("GdtVideoCeilingUtil", "[buildParamsForJs] error params");
            return null;
        }
        AdVideoCeiling.Params params = new AdVideoCeiling.Params();
        params.webUrl = AdJSONUtil.optString(jSONObject, "webUrl", "");
        params.videoUrl = AdJSONUtil.optString(jSONObject, AppConstants.Key.KEY_QZONE_VIDEO_URL, "");
        params.widthHeightRatio = AdJSONUtil.optString(jSONObject, "widthHeightRatio", "");
        params.videoLoop = true;
        Bundle bundle = new Bundle();
        bundle.putString(LaunchParam.KEY_REF_ID, AdJSONUtil.optString(jSONObject, "gdtRefsid", ""));
        bundle.putString("WebReport_POS_ID", AdJSONUtil.optString(jSONObject, "posId", ""));
        params.extrasForIntent = bundle;
        params.f61336ad = a(jSONObject);
        params.vid = AdJSONUtil.optString(jSONObject, "vid", "");
        params.activity = new WeakReference<>(activity);
        return params;
    }
}
