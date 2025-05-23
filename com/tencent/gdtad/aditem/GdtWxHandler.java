package com.tencent.gdtad.aditem;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtWxHandler {
    @Nullable
    public static AdClickUtil.Result a(@NonNull Handler handler, @NonNull GdtAd gdtAd) {
        AdClickUtil.Result result;
        String str;
        IWXAPI createWXAPI;
        int i3;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtAd.info;
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        reportBiz.wx_sdk_method = 3;
        reportBiz.preload_status_code = 0;
        AdReporterForLinkEvent.getInstance().reportAsync(BaseApplication.getContext(), 4006001, gdtAd, reportBiz, null);
        try {
            String str2 = "wxf0a80d0ac2e82aa7";
            if (adInfo.wechat_app_info.app_id.has() && adInfo.wechat_app_info.app_id.get().length() > 0) {
                str2 = adInfo.wechat_app_info.app_id.get();
            }
            str = str2;
            createWXAPI = WXAPIFactory.createWXAPI(BaseApplication.getContext(), str);
        } catch (Exception unused) {
            result = new AdClickUtil.Result(4, 9);
        }
        if (!createWXAPI.isWXAppInstalled()) {
            c(handler, R.string.f170986w14);
            AdReporterForLinkEvent.getInstance().reportAsync(BaseApplication.getContext(), 4006007, gdtAd, reportBiz, null);
        } else if (createWXAPI.getWXAppSupportAPI() < 621086464) {
            c(handler, R.string.f170987w15);
            AdReporterForLinkEvent.getInstance().reportAsync(BaseApplication.getContext(), 4006007, gdtAd, reportBiz, null);
        } else {
            AdReporterForLinkEvent.getInstance().reportAsync(BaseApplication.getContext(), 4006006, gdtAd, reportBiz, null);
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = adInfo.wechat_app_info.app_username.get();
            req.path = adInfo.wechat_app_info.app_path.get();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pathType", 2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_trace_data", adInfo.wechat_app_info.ad_trace_data.get());
                jSONObject2.put("token", adInfo.wechat_app_info.app_token.get());
                jSONObject.put("invokeData", jSONObject2);
                req.extData = jSONObject.toString();
                QLog.i("GdtWechatHandler", 1, "navigateToMiniProgram openMiniGame, make extData json success: name = " + req.userName + ",path=" + req.path + ",extData=" + req.extData + ",appId=" + b(str));
            } catch (Exception e16) {
                QLog.e("GdtWechatHandler", 1, "navigateToMiniProgram  openMiniGame, make extData json failed!", e16);
            }
            req.miniprogramType = 0;
            boolean sendReq = createWXAPI.sendReq(req);
            AdReporterForLinkEvent adReporterForLinkEvent = AdReporterForLinkEvent.getInstance();
            BaseApplication context = BaseApplication.getContext();
            if (sendReq) {
                i3 = 4006008;
            } else {
                i3 = 4006009;
            }
            adReporterForLinkEvent.reportAsync(context, i3, gdtAd, reportBiz, null);
            result = new AdClickUtil.Result(0, 9);
            ReportController.o(null, "dc00898", "", "", "0X800AA79", "0X800AA79", 0, 0, "", "", String.valueOf(adInfo.wechat_app_info.pos_id.get()), "");
            return result;
        }
        result = null;
        ReportController.o(null, "dc00898", "", "", "0X800AA79", "0X800AA79", 0, 0, "", "", String.valueOf(adInfo.wechat_app_info.pos_id.get()), "");
        return result;
    }

    @Nullable
    public static String b(@Nullable String str) {
        if ("wxf0a80d0ac2e82aa7".equals(str)) {
            return "same";
        }
        if (str != null && str.length() > 4) {
            return str.substring(4);
        }
        return str;
    }

    public static void c(@NonNull Handler handler, final int i3) {
        handler.post(new Runnable() { // from class: com.tencent.gdtad.aditem.GdtWxHandler.1
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplication.getContext(), 0, i3, 0).show();
            }
        });
    }
}
