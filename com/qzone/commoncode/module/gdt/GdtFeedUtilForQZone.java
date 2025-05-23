package com.qzone.commoncode.module.gdt;

import NS_MOBILE_FEEDS.s_droplist_option;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.event.EventCenter;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCanvas;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellNegativeFeedback;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdt.tangram.ad.AdArea;
import com.tencent.gdt.tangram.ad.AdListScene;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;
import com.tencent.gdt.tangram.ad.qzone.AnalysisHelperRunnable;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.Common;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.util.QZLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.Foreground;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;
import yl0.i;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GdtFeedUtilForQZone {

    /* renamed from: a, reason: collision with root package name */
    private static final String f46179a = "com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends TypeToken<List<Integer>> {
        a() {
        }
    }

    public static void B(BusinessFeedData businessFeedData, AdArea adArea, boolean z16, String str, boolean z17) {
        b.a(businessFeedData, adArea, z16, str, z17);
    }

    public static void a(BusinessFeedData businessFeedData, int i3, int i16) {
        com.qzone.misc.network.report.f.a(businessFeedData, i3, i16);
    }

    public static String b(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("param");
        HashMap<String, String> z16 = Common.z(queryParameter);
        z16.put("appid", z16.get("id"));
        z16.remove("id");
        if (str.contains(WadlProxyConsts.VIA_AUTO_DOWNLOAD)) {
            z16.put(WadlProxyConsts.VIA_AUTO_DOWNLOAD, "1");
        }
        try {
            return Common.y(z16);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return queryParameter;
        }
    }

    public static boolean c(BusinessFeedData businessFeedData) {
        return MyAppApi.z().n() && businessFeedData != null && businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().yingYongBao;
    }

    public static AdArea d(int i3, int i16) {
        return new AdArea(new AdListScene(i16, i3));
    }

    public static qq_ad_get.QQAdGetRsp.AdInfo f(BusinessFeedData businessFeedData) {
        String str;
        if (businessFeedData == null) {
            return null;
        }
        if (businessFeedData.getAdData().getAdInfo() != null) {
            return businessFeedData.getAdData().getAdInfo();
        }
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo advertiserInfo = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo();
        try {
            advertiserInfo.corporate_image_name.set(businessFeedData.getCellUserInfo().getUser().nickName);
            advertiserInfo.corporate_logo.set(businessFeedData.getCellUserInfo().getUser().logo);
            String advId = QZoneAdFeedDataExtKt.getAdvId(businessFeedData);
            if (!TextUtils.isEmpty(advId)) {
                advertiserInfo.advertiser_id.set(Long.parseLong(advId));
            }
        } catch (NumberFormatException e16) {
            QLog.e(f46179a, 1, "getAdInfo exception", e16);
        }
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo videoInfo = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo();
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basicInfo = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo();
        videoInfo.width.set(QZoneAdFeedDataExtKt.getGdtVideoWidth(businessFeedData));
        videoInfo.height.set(QZoneAdFeedDataExtKt.getGdtVideoHeight(businessFeedData));
        basicInfo.img.set(QZoneAdFeedDataExtKt.getPictureOriginalUrl(businessFeedData));
        if (businessFeedData.getVideoInfo() != null && businessFeedData.getVideoInfo().videoUrl != null) {
            videoInfo.video_url.set(businessFeedData.getVideoInfo().videoUrl.url);
            videoInfo.media_duration.set((int) businessFeedData.getVideoInfo().videoTime);
            if (businessFeedData.getVideoInfo().bigUrl != null) {
                basicInfo.img.set(businessFeedData.getVideoInfo().bigUrl.url);
                basicInfo.pic_width.set(businessFeedData.getVideoInfo().bigUrl.width);
                basicInfo.pic_height.set(businessFeedData.getVideoInfo().bigUrl.height);
            }
        }
        if (businessFeedData.getCellSummaryV2() == null) {
            str = "";
        } else {
            str = businessFeedData.getCellSummaryV2().summary;
        }
        basicInfo.desc.set(str);
        basicInfo.txt.set(businessFeedData.getCellSummary().summary);
        basicInfo.materials.set(QZoneAdFeedDataExtKt.getMDPAInfos(businessFeedData));
        List<Integer> k3 = k(businessFeedData, "ad_extension_type");
        if (k3 != null && !k3.isEmpty()) {
            basicInfo.ad_extension_type.set(k3);
        }
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo videoInfo2 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo();
        if (!TextUtils.isEmpty(QZoneAdFeedDataExtKt.getImaxAdVideoUrl(businessFeedData))) {
            videoInfo2.video_url.set(QZoneAdFeedDataExtKt.getImaxAdVideoUrl(businessFeedData));
        }
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo();
        displayInfo.advertiser_info.set(advertiserInfo);
        displayInfo.video_info.set(videoInfo);
        displayInfo.video_info2.set(videoInfo2);
        if (QZoneAdFeedDataExtKt.isGdt585AdVideo(businessFeedData)) {
            displayInfo.creative_size.set(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST);
        }
        displayInfo.basic_info.set(basicInfo);
        if (!TextUtils.isEmpty(QZoneAdFeedDataExtKt.getGDTMiniProgramType(businessFeedData))) {
            try {
                displayInfo.mini_program_type.set(Integer.parseInt(QZoneAdFeedDataExtKt.getGDTMiniProgramType(businessFeedData)));
            } catch (Exception e17) {
                QLog.e(f46179a, 1, "getAdInfo exception", e17);
            }
        }
        if (businessFeedData.getRecommAction() != null) {
            qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo buttonInfo = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo();
            buttonInfo.txt.set(businessFeedData.getRecommAction().buttonText);
            if (displayInfo.button_info.isEmpty()) {
                displayInfo.button_info.add(buttonInfo);
            }
        }
        displayInfo.outer_layer_download.set(QZoneAdFeedDataExtKt.getAdOuterLayerDownloadValue(businessFeedData));
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo traceInfo = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
        if (businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().cookie != null) {
            String str2 = businessFeedData.getOperationInfoV2().cookie.get(7);
            try {
                if (!TextUtils.isEmpty(str2)) {
                    traceInfo.aid.set(Long.valueOf(str2).longValue());
                }
            } catch (Exception e18) {
                QLog.e(f46179a, 1, "get aid exception", e18);
            }
            traceInfo.traceid.set(businessFeedData.getOperationInfoV2().cookie.get(3));
        }
        if (businessFeedData.getRecommAction() != null && !TextUtils.isEmpty(businessFeedData.getRecommAction().via)) {
            traceInfo.via.set(businessFeedData.getRecommAction().via);
        }
        if (businessFeedData.getRecommAction() != null) {
            traceInfo.product_id.set(String.valueOf(businessFeedData.getRecommAction().productid));
        }
        traceInfo.noco_id.set(businessFeedData.getNocoId());
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls thirdPartyMonitorUrls = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls();
        try {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SApiClickUrl(businessFeedData))) {
                JSONArray jSONArray = new JSONArray(QZoneAdFeedDataExtKt.getC2SApiClickUrl(businessFeedData));
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(jSONArray.getString(i3));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (!TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SApiExposureUrl(businessFeedData))) {
                JSONArray jSONArray2 = new JSONArray(QZoneAdFeedDataExtKt.getC2SApiExposureUrl(businessFeedData));
                for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                    arrayList2.add(jSONArray2.getString(i16));
                }
            }
            thirdPartyMonitorUrls.api_exposure_monitor_url.set(arrayList2);
            thirdPartyMonitorUrls.api_click_monitor_url.set(arrayList);
        } catch (JSONException e19) {
            QLog.e(f46179a, 1, "getAdInfo exception", e19);
        }
        try {
            if (!TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayUrl(businessFeedData))) {
                JSONArray jSONArray3 = new JSONArray(QZoneAdFeedDataExtKt.getC2SVideoPlayUrl(businessFeedData));
                ArrayList arrayList3 = new ArrayList();
                for (int i17 = 0; i17 < jSONArray3.length(); i17++) {
                    arrayList3.add(jSONArray3.getString(i17));
                }
                thirdPartyMonitorUrls.video_play_monitor_url.set(arrayList3);
                try {
                    if (!TextUtils.isEmpty(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(businessFeedData))) {
                        thirdPartyMonitorUrls.video_play_duration.set(Integer.parseInt(QZoneAdFeedDataExtKt.getC2SVideoPlayDuration(businessFeedData)));
                    }
                } catch (NumberFormatException e26) {
                    QLog.e(f46179a, 1, "getAdInfo exception", e26);
                }
            }
        } catch (Exception e27) {
            QLog.e(f46179a, 1, "getAdInfo exception", e27);
        }
        ArrayList arrayList4 = new ArrayList();
        try {
            ArrayList<s_droplist_option> arrayList5 = businessFeedData.getFeedCommInfo().customDroplist;
            if (arrayList5 != null && !arrayList5.isEmpty()) {
                Iterator<s_droplist_option> it = businessFeedData.getFeedCommInfo().customDroplist.iterator();
                while (it.hasNext()) {
                    s_droplist_option next = it.next();
                    qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem negativeFeedbackItem = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem();
                    negativeFeedbackItem.action_type.set(v(next.actiontype));
                    negativeFeedbackItem.report_type.set(next.reporttype);
                    negativeFeedbackItem.icon_url.set(next.iconurl);
                    negativeFeedbackItem.jump_url.set(next.jumpurl);
                    negativeFeedbackItem.text.set(next.optext);
                    arrayList4.add(negativeFeedbackItem);
                }
            }
        } catch (Exception e28) {
            QLog.e(f46179a, 1, "getAdInfo exception", e28);
        }
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
        if (businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().cookie != null) {
            reportInfo.exposure_url.set(businessFeedData.getOperationInfoV2().cookie.get(1));
            reportInfo.video_report_url.set(businessFeedData.getOperationInfoV2().cookie.get(1));
            reportInfo.landing_page_report_url.set(businessFeedData.getOperationInfoV2().cookie.get(15));
        }
        if (businessFeedData.getRecommAction() != null) {
            if (!TextUtils.isEmpty(businessFeedData.getRecommAction().f50232rl)) {
                reportInfo.click_url.set(businessFeedData.getRecommAction().f50232rl);
            }
            if (!TextUtils.isEmpty(businessFeedData.getRecommAction().reportUrl)) {
                reportInfo.negative_feedback_url.set(businessFeedData.getRecommAction().reportUrl);
            }
        }
        reportInfo.effect_url.set(QZoneAdFeedDataExtKt.getGdtEffectCGIUrl(businessFeedData));
        reportInfo.trace_info.set(traceInfo);
        reportInfo.thirdparty_monitor_urls.set(thirdPartyMonitorUrls);
        reportInfo.neg_fb_items.set(arrayList4);
        reportInfo.original_exposure_url.set(businessFeedData.getValueFromCurrencyPassField("original_exposure_url"));
        qq_ad_get.QQAdGetRsp.AdInfo.DestInfo destInfo = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo();
        if (businessFeedData.getRecommAction() != null && !TextUtils.isEmpty(businessFeedData.getRecommAction().dest_url)) {
            destInfo.landing_page.set(businessFeedData.getRecommAction().dest_url);
        }
        CellCanvas cellCanvas = businessFeedData.cellCanvas;
        if (cellCanvas != null) {
            destInfo.canvas_json.set(cellCanvas.canvasData);
        }
        if (businessFeedData.getRecommAction() != null) {
            destInfo.dest_type.set(businessFeedData.getRecommAction().dest_type);
        }
        destInfo.reward_landing_page_url.set(QZoneAdFeedDataExtKt.getRewardLandingPageUrl(businessFeedData));
        qq_ad_get.QQAdGetRsp.AdInfo.AppInfo appInfo = new qq_ad_get.QQAdGetRsp.AdInfo.AppInfo();
        if (businessFeedData.getRecommAction() != null && businessFeedData.getRecommAction().extendInfo != null) {
            try {
                appInfo.app_name.set(businessFeedData.getRecommAction().extendInfo.get(4));
                appInfo.app_package_name.set(businessFeedData.getRecommAction().extendInfo.get(5));
                appInfo.pkg_url.set(businessFeedData.getRecommAction().extendInfo.get(7));
                appInfo.android_app_id.set(businessFeedData.getRecommAction().extendInfo.get(6));
                appInfo.app_logo_url.set(businessFeedData.getRecommAction().extendInfo.get(29));
                String str3 = businessFeedData.getRecommAction().extendInfo.get(30);
                if (!TextUtils.isEmpty(str3)) {
                    appInfo.download_num.set(Long.parseLong(str3));
                }
            } catch (Throwable th5) {
                QLog.e(f46179a, 1, "get appInfo exception", th5);
            }
        }
        if (businessFeedData.getOperationInfoV2() != null && !TextUtils.isEmpty(businessFeedData.getOperationInfoV2().schemaPageUrl)) {
            appInfo.customized_invoke_url.set(businessFeedData.getOperationInfoV2().schemaPageUrl);
        }
        if (businessFeedData.getRecommAction() != null && !TextUtils.isEmpty(businessFeedData.getRecommAction().channel)) {
            appInfo.channel_id.set(businessFeedData.getRecommAction().channel);
        }
        qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo weChatAppInfo = new qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo();
        String j3 = j(businessFeedData, "wechat_app_info");
        if (!TextUtils.isEmpty(j3)) {
            try {
                JSONObject jSONObject = new JSONObject(j3);
                weChatAppInfo.ad_trace_data.set(jSONObject.optString("ad_trace_data"));
                weChatAppInfo.app_id.set(jSONObject.optString("app_id"));
                weChatAppInfo.app_path.set(jSONObject.optString("app_path"));
                weChatAppInfo.app_token.set(jSONObject.optString("app_token"));
                weChatAppInfo.app_username.set(jSONObject.optString("app_username"));
                weChatAppInfo.pos_id.set(jSONObject.optLong(SsoReporter.POS_ID_KEY));
                weChatAppInfo.wechat_appid.set(jSONObject.optString("wechat_appid"));
            } catch (JSONException unused) {
                QZLog.i("GdtFeedUtilForQZone", 2, "wechat iinfo error :" + j3);
            }
        }
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
        if (businessFeedData.getRecommAction() != null) {
            adInfo.product_type.set(businessFeedData.getRecommAction().product_type);
        }
        adInfo.display_info.set(displayInfo);
        adInfo.report_info.set(reportInfo);
        adInfo.dest_info.set(destInfo);
        adInfo.app_info.set(appInfo);
        adInfo.ext_json.set(j(businessFeedData, "sdk_pass_data"));
        adInfo.wechat_app_info.set(weChatAppInfo);
        businessFeedData.getAdData().setAdInfo(adInfo);
        return businessFeedData.getAdData().getAdInfo();
    }

    public static int h(BusinessFeedData businessFeedData) {
        return new com.tencent.gdt.tangram.ad.qzone.b(businessFeedData).i();
    }

    public static String i(BusinessFeedData businessFeedData) {
        return new com.tencent.gdt.tangram.ad.qzone.b(businessFeedData).b();
    }

    public static String j(BusinessFeedData businessFeedData, String str) {
        if (!TextUtils.isEmpty(str) && businessFeedData != null) {
            return businessFeedData.getValueFromCurrencyPassField(str);
        }
        return "";
    }

    private static List<Integer> k(BusinessFeedData businessFeedData, String str) {
        List<Integer> list;
        if (TextUtils.isEmpty(str) || businessFeedData == null) {
            return null;
        }
        String j3 = j(businessFeedData, "ad_extension_type");
        if (TextUtils.isEmpty(j3)) {
            return null;
        }
        try {
            list = (List) new Gson().fromJson(j3, new a().getType());
        } catch (Throwable unused) {
            list = null;
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    public static Context l() {
        return BaseApplication.context;
    }

    public static int m() {
        Activity topActivity = Foreground.getTopActivity();
        View findViewById = topActivity != null ? topActivity.findViewById(R.id.f166672ha0) : null;
        if (findViewById == null) {
            return 0;
        }
        return findViewById.getMeasuredHeight();
    }

    public static boolean o(BusinessFeedData businessFeedData) {
        return !QZoneAdFeedDataExtKt.isGdt585LiveAd(businessFeedData);
    }

    public static boolean q(String str) {
        return com.tencent.gdt.tangram.ad.qzone.embedded.b.j(str);
    }

    private static int v(int i3) {
        if (i3 != 2) {
            if (i3 != 40 && i3 != 56) {
                return 0;
            }
            return 3;
        }
        return 6;
    }

    public static void w(Context context, boolean z16, String str) {
        AppClient.k(context, str, z16);
    }

    public static void x(BusinessFeedData businessFeedData, int i3) {
        QLog.i(f46179a, 2, "[preLoadAdData]sceneId:" + i3 + " isFeedxEnable:true");
        ih.d.a(businessFeedData, i3);
    }

    public static void y(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            com.tencent.gdt.tangram.ad.qzone.a.b().f108410a = new i((int) motionEvent.getX(), (int) motionEvent.getY(), System.currentTimeMillis());
        } else {
            if (action != 1) {
                return;
            }
            com.tencent.gdt.tangram.ad.qzone.a.b().f108411b = new i((int) motionEvent.getX(), (int) motionEvent.getY(), System.currentTimeMillis());
        }
    }

    public static void z(Runnable runnable) {
        if (runnable instanceof AnalysisHelperRunnable) {
            AnalysisHelperRunnable analysisHelperRunnable = (AnalysisHelperRunnable) runnable;
            AdAnalysisHelperForUtil.reportForAPIInvoked(analysisHelperRunnable.f108405d, analysisHelperRunnable.f108407f, analysisHelperRunnable.f108406e, analysisHelperRunnable.f108408h);
        } else {
            ThreadManagerV2.excute(runnable, 128, null, true);
        }
    }

    public static void D(final Context context, ArrayList<CellNegativeFeedback.negativeFbInfo> arrayList, final BusinessFeedData businessFeedData) {
        if (arrayList == null || arrayList.size() == 0 || businessFeedData == null || !businessFeedData.isGDTAdvFeed()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<CellNegativeFeedback.negativeFbInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            CellNegativeFeedback.negativeFbInfo next = it.next();
            if (next != null) {
                jSONArray.put(next.f50231id);
            }
        }
        if (jSONArray.length() == 0) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rea", jSONArray);
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone.1
                @Override // java.lang.Runnable
                public void run() {
                    BusinessFeedData businessFeedData2;
                    try {
                        String encode = URLEncoder.encode(JSONObject.this.toString(), "UTF-8");
                        if (TextUtils.isEmpty(encode) || (businessFeedData2 = businessFeedData) == null || businessFeedData2.getRecommAction() == null || TextUtils.isEmpty(businessFeedData.getRecommAction().reportUrl)) {
                            return;
                        }
                        to.e.d(context, businessFeedData.getRecommAction().reportUrl + "7001&neg=" + encode);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }, null, true);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static String g(BusinessFeedData businessFeedData) {
        CellOperationInfo cellOperationInfo;
        Map<Integer, String> map;
        if (businessFeedData == null || !businessFeedData.isGDTAdvFeed() || (cellOperationInfo = businessFeedData.cellOperationInfo) == null || (map = cellOperationInfo.cookie) == null) {
            return null;
        }
        return map.get(10);
    }

    public static boolean r(Context context) {
        if (context != null && (context instanceof BaseActivity)) {
            return ((BaseActivity) context).getWatchActivityManager().hasJump();
        }
        if (context instanceof QzonePluginProxyActivity) {
            return ((QzonePluginProxyActivity) context).getWatchActivityManager().hasJump();
        }
        return false;
    }

    public static boolean s(BusinessFeedData businessFeedData) {
        CellNegativeFeedback cellNegativeFeedback;
        ArrayList<CellNegativeFeedback.negativeFbInfo> arrayList;
        return (businessFeedData == null || !businessFeedData.isGDTAdvFeed() || (cellNegativeFeedback = businessFeedData.cellNegativeFeedback) == null || (arrayList = cellNegativeFeedback.nagativeFbInfos) == null || arrayList.size() <= 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0087 A[Catch: Exception -> 0x00a0, TRY_ENTER, TryCatch #0 {Exception -> 0x00a0, blocks: (B:12:0x0030, B:14:0x0034, B:15:0x003a, B:19:0x0066, B:20:0x0068, B:24:0x0071, B:26:0x0077, B:27:0x007b, B:30:0x0087, B:31:0x0094, B:35:0x008e, B:39:0x0062), top: B:11:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e A[Catch: Exception -> 0x00a0, TryCatch #0 {Exception -> 0x00a0, blocks: (B:12:0x0030, B:14:0x0034, B:15:0x003a, B:19:0x0066, B:20:0x0068, B:24:0x0071, B:26:0x0077, B:27:0x007b, B:30:0x0087, B:31:0x0094, B:35:0x008e, B:39:0x0062), top: B:11:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void u(Context context, BusinessFeedData businessFeedData, boolean z16, int i3, int i16, Rect rect) {
        if (businessFeedData == null || businessFeedData.getOperationInfoV2() == null || businessFeedData.getOperationInfoV2().cookie == null || businessFeedData.getRecommAction() == null || businessFeedData.getRecommAction().extendInfo == null) {
            return;
        }
        QLog.d("launchToTangram", 4, businessFeedData.getRecommAction().toString(), (Throwable) null);
        try {
            if (context instanceof BasePluginActivity) {
                context = ((BasePluginActivity) context).getOutActivity();
            }
            qq_ad_get.QQAdGetRsp.AdInfo f16 = f(businessFeedData);
            GdtHandler.Params params = new GdtHandler.Params();
            params.activity = new WeakReference<>((Activity) context);
            params.f108486ad = new GdtAd(f16);
            params.reportForClick = z16;
            if ((i3 != 0 || i16 != 8) && i3 != 1 && i3 != 7) {
                params.appAutoDownload = false;
                params.sceneID = i3;
                params.componentID = i16;
                if (i3 == 0 && i16 == 6 && QZoneAdFeedDataExtKt.isGdt585AdVideo(businessFeedData)) {
                    params.videoCeilingSupportedIfNotInstalled = true;
                    params.reportForClick = true;
                }
                Bundle bundle = new Bundle();
                params.extra = bundle;
                if (i3 != 7) {
                    bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_webgames");
                } else {
                    bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_jc_qzone");
                }
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
            }
            params.appAutoDownload = true;
            params.sceneID = i3;
            params.componentID = i16;
            if (i3 == 0) {
                params.videoCeilingSupportedIfNotInstalled = true;
                params.reportForClick = true;
            }
            Bundle bundle2 = new Bundle();
            params.extra = bundle2;
            if (i3 != 7) {
            }
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void A(AdClickData adClickData) {
        BusinessFeedData m3 = adClickData != null ? adClickData.m() : null;
        if (m3 != null && m3.isGDTAdvFeed()) {
            AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "GdtFeedUtilForQzone::reportClickAndCgiJumpInAd" + m3.feedType, "");
        }
        try {
            new cm0.e(adClickData).d();
        } catch (Throwable th5) {
            GdtLog.e(f46179a, "[reportClickAndCgiJumpInAd]", th5);
        }
    }

    public static GdtAd E(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            QZLog.e(f46179a, "toAd error, feedData is null");
            return null;
        }
        if (!businessFeedData.isGDTAdvFeed()) {
            return null;
        }
        qq_ad_get.QQAdGetRsp.AdInfo f16 = f(businessFeedData);
        if (f16 == null) {
            QZLog.e(f46179a, "toAd error, adInfo is null");
            return null;
        }
        return new GdtAd(f16);
    }

    public static boolean p(CellFeedCommInfo cellFeedCommInfo) {
        return cellFeedCommInfo != null && cellFeedCommInfo.getStMapABTest() != null && cellFeedCommInfo.getStMapABTest().containsKey(20) && cellFeedCommInfo.getStMapABTest().get(20).intValue() == 1;
    }

    public static void C(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.cellOperationInfo == null || !businessFeedData.isGDTAdvFeed()) {
            return;
        }
        QZoneWriteOperationService.v0().L(businessFeedData.cellOperationInfo.cookie, 39, 0, 0, 0, 0, true, false, null, null, 0L, false, false, null, false, businessFeedData);
    }

    public static void e(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
            String str = businessFeedData.getFeedCommInfo().feedskey;
            if (businessFeedData.isGDTAdvFeed() && businessFeedData.isSubFeed) {
                str = businessFeedData.parentFeedData.getFeedCommInfo().feedskey;
            }
            EventCenter.getInstance().post("WriteOperation", 38, str);
        }
        if (((businessFeedData == null || businessFeedData.getFeedCommInfo() == null) && !s(businessFeedData)) || businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return;
        }
        EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
    }

    public static BaseVideo n(View view) {
        AbsFeedView b16;
        if (view == null || (b16 = c6.a.b(view)) == null) {
            return null;
        }
        return ((FeedView) b16).getAutoVideoView();
    }

    public static void t(Context context, BusinessFeedData businessFeedData, String str) {
    }
}
