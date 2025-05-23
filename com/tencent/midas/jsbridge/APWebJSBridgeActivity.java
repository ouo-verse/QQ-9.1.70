package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;
import com.huawei.hms.framework.common.ContainerUtils;
import com.pay.tool.APMidasCommMethod;
import com.pay.tool.APMidasTools;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.ads.data.AdParam;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.mapsdk.internal.er;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.midas.api.request.APMidasMonthRequest;
import com.tencent.midas.api.request.APMidasSubscribeRequest;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.plugin.APPluginUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vip.api.IVipPayApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class APWebJSBridgeActivity extends Activity {
    private static final String KEY_REQUEST = "key_request";
    private static final String KEY_TYPE = "key_pure_h5_pay";
    private static final String TAG = "APWebJSBridgeActivity";
    private static final String VALUE_PURE_H5 = "value_pure_h5_pay";
    private static final String WEB_URL_POST = "/index.html";
    private static final String WEB_URL_PRE = "https://youxi.vip.qq.com/m/act/";
    private IAPWebPage webPage = null;

    private String constructUrl() {
        String discountUrl;
        if (TextUtils.isEmpty(APPluginDataInterface.singleton().getDiscountUrl())) {
            discountUrl = WEB_URL_PRE + APPluginDataInterface.singleton().getOfferId() + WEB_URL_POST;
            this.webPage.initHead(this, APMidasTools.getUrlParamsValue(discountUrl, APWebProtocol.URL_KEY_HEAD_CONTROL), APMidasTools.getUrlParamsValue(discountUrl, APWebProtocol.URL_KEY_HEAD_TITLE));
            this.webPage.updateWebViewSize(discountUrl);
        } else {
            discountUrl = APPluginDataInterface.singleton().getDiscountUrl();
            this.webPage.initHead(this, APMidasTools.getUrlParamsValue(discountUrl, APWebProtocol.URL_KEY_HEAD_CONTROL), APMidasTools.getUrlParamsValue(discountUrl, APWebProtocol.URL_KEY_HEAD_TITLE));
            this.webPage.updateWebViewSize(APPluginDataInterface.singleton().getDiscountUrl());
        }
        APLog.e("constructUrl", discountUrl);
        HashMap hashMap = new HashMap();
        hashMap.put("offerId", APPluginDataInterface.singleton().getOfferId());
        hashMap.put("openId", APPluginDataInterface.singleton().getOpenId());
        hashMap.put("openKey", APPluginDataInterface.singleton().getOpenKey());
        hashMap.put("sessionId", APPluginDataInterface.singleton().getSessionId());
        hashMap.put(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, APPluginDataInterface.singleton().getSessionType());
        hashMap.put(AdParam.PF, APPluginDataInterface.singleton().getPf());
        hashMap.put("pfKey", APPluginDataInterface.singleton().getPfKey());
        hashMap.put("zoneId", APPluginDataInterface.singleton().getZoneId());
        if (discountUrl.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            if (!discountUrl.endsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                discountUrl = discountUrl + ContainerUtils.FIELD_DELIMITER;
            }
        } else {
            discountUrl = discountUrl + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        String str = discountUrl + APMidasTools.map2UrlParams(hashMap);
        APLog.i("constructUrl", str);
        return str;
    }

    private String getPureH5PayURLParameters(APMidasBaseRequest aPMidasBaseRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "buy");
        hashMap.put(er.f148291t, "v3");
        hashMap.put("appid", aPMidasBaseRequest.offerId);
        hashMap.put(AdParam.PF, aPMidasBaseRequest.f151589pf);
        hashMap.put(DomainData.DOMAIN_NAME, aPMidasBaseRequest.saveValue);
        hashMap.put("sessionid", aPMidasBaseRequest.sessionId);
        hashMap.put("sessiontype", aPMidasBaseRequest.sessionType);
        hashMap.put("openid", aPMidasBaseRequest.openId);
        hashMap.put("openkey", aPMidasBaseRequest.openKey);
        hashMap.put("zoneid", aPMidasBaseRequest.zoneId);
        hashMap.put(AdParam.SDK_TYPE, "android");
        String midasCoreVersionName = APPluginUtils.getMidasCoreVersionName(this);
        APLog.d(TAG, "app_version = " + midasCoreVersionName);
        hashMap.put("appversion", midasCoreVersionName);
        hashMap.put("request_from", NetUtil.STR_UserAgent);
        hashMap.put("is_android_sdk_error_version", "1");
        hashMap.put("android_sdk_reserve", aPMidasBaseRequest.reserv);
        hashMap.put("android_sdk_mpinfo_discountType", aPMidasBaseRequest.mpInfo.discountType);
        hashMap.put("android_sdk_mpinfo_discountUrl", aPMidasBaseRequest.mpInfo.discountUrl);
        hashMap.put("android_sdk_mpinfo_discoutId", aPMidasBaseRequest.mpInfo.discoutId);
        hashMap.put("android_sdk_mpinfo_drmInfo", aPMidasBaseRequest.mpInfo.drmInfo);
        hashMap.put("android_sdk_mpinfo_extras", aPMidasBaseRequest.mpInfo.extras);
        hashMap.put("android_sdk_mpinfo_payChannel", aPMidasBaseRequest.mpInfo.payChannel);
        hashMap.put("android_sdk_extendInfo_unit", aPMidasBaseRequest.extendInfo.unit);
        hashMap.put("android_sdk_extendInfo_isShowListOtherNum", String.valueOf(aPMidasBaseRequest.extendInfo.isShowListOtherNum));
        hashMap.put("android_sdk_extendInfo_isShowNum", String.valueOf(aPMidasBaseRequest.extendInfo.isShowNum));
        if (aPMidasBaseRequest instanceof APMidasGameRequest) {
            if ("hy_gameid".equals(aPMidasBaseRequest.sessionId) && "wc_actoken".equals(aPMidasBaseRequest.sessionType)) {
                hashMap.put("c", "wechat_game");
            } else if ("itopid".equals(aPMidasBaseRequest.sessionId)) {
                hashMap.put("c", "itop_game");
            } else {
                hashMap.put("c", "game");
            }
            if (!TextUtils.isEmpty(aPMidasBaseRequest.saveValue)) {
                hashMap.put("as", "1");
            }
        } else if (aPMidasBaseRequest instanceof APMidasGoodsRequest) {
            APMidasGoodsRequest aPMidasGoodsRequest = (APMidasGoodsRequest) aPMidasBaseRequest;
            hashMap.put("c", "goods");
            if (aPMidasGoodsRequest.tokenType == 1) {
                hashMap.put("params", URLEncoder.encode(aPMidasGoodsRequest.goodsTokenUrl));
            } else {
                hashMap.put("productid", aPMidasGoodsRequest.prodcutId);
            }
        } else if (aPMidasBaseRequest instanceof APMidasSubscribeRequest) {
            APMidasSubscribeRequest aPMidasSubscribeRequest = (APMidasSubscribeRequest) aPMidasBaseRequest;
            if (!"uin".equals(aPMidasBaseRequest.sessionId) && !"openid".equals(aPMidasBaseRequest.sessionId)) {
                hashMap.put("c", "subscribe");
            } else {
                hashMap.put("c", QzoneConfig.MAIN_KEY_QQ_SUBSCRIBE_SETTING);
            }
            if (!TextUtils.isEmpty(aPMidasSubscribeRequest.productId)) {
                hashMap.put("as", "1");
                hashMap.put("productid", aPMidasSubscribeRequest.productId);
            }
            hashMap.put("service", aPMidasSubscribeRequest.serviceCode);
            hashMap.put("aid", aPMidasSubscribeRequest.remark);
            if (aPMidasSubscribeRequest.autoPay) {
                hashMap.put("ap", "1");
            }
        } else if (aPMidasBaseRequest instanceof APMidasMonthRequest) {
            APMidasMonthRequest aPMidasMonthRequest = (APMidasMonthRequest) aPMidasBaseRequest;
            hashMap.put("da", "1");
            hashMap.put("c", aPMidasMonthRequest.serviceCode.toLowerCase());
            hashMap.put("_newservice", "1");
            if (aPMidasMonthRequest.autoPay) {
                hashMap.put("ap", "1");
            }
            if (!TextUtils.isEmpty(aPMidasBaseRequest.saveValue)) {
                hashMap.put("as", "1");
            }
            hashMap.put("aid", aPMidasMonthRequest.remark);
        }
        String str = APMidasPayAPI.env;
        if (APMidasPayAPI.ENV_DEV.equals(str)) {
            hashMap.put("sandbox", "2");
        } else if ("test".equals(str)) {
            hashMap.put("sandbox", "1");
        }
        return map2UrlParams(hashMap);
    }

    private void initUI() {
        this.webPage.initUI(this);
        this.webPage.loadUrl(constructUrl());
    }

    private void initWebPage() {
        APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_INIT, "", "");
        if (APX5.isX5Enabled(this)) {
            this.webPage = new APX5WebPage();
            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_X5, "", "");
        } else {
            this.webPage = new APSystemWebPage();
            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_SYSTEM, "", "");
        }
    }

    public static String map2UrlParams(HashMap<String, String> hashMap) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(entry.getValue());
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            if (!TextUtils.isEmpty(stringBuffer)) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static boolean startPureH5Pay(Context context, String str, String str2) {
        APLog.d(TAG, " Calling into startPureH5Pay caller = " + Thread.currentThread().getStackTrace()[3].toString());
        APPluginReportManager.getInstance().reportImmediatelyOneRecord(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_LAUNCH_PURE_H5_ERROR_REASON, "scene=" + str2 + "&reason=" + str);
        if (context == null) {
            APLog.e(TAG, "Cannot start pure h5 pay with null context!");
            return false;
        }
        APMidasBaseRequest aPMidasBaseRequest = APMidasPayHelper.requestObject;
        if (aPMidasBaseRequest == null) {
            APLog.e(TAG, "Cannot start pure h5 pay with null request object!");
            return false;
        }
        return startPureH5Pay(context, aPMidasBaseRequest);
    }

    private void toPureH5Pay(APMidasBaseRequest aPMidasBaseRequest) {
        this.webPage.toPureH5Pay(this, aPMidasBaseRequest);
        String str = IVipPayApi.BASE_URL + getPureH5PayURLParameters(aPMidasBaseRequest);
        APLog.d(TAG, "To pure h5 pay full url = " + str);
        this.webPage.loadUrl(str);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            APMidasCommMethod.pushActivity(this);
            initWebPage();
            Intent intent = getIntent();
            if (intent != null && VALUE_PURE_H5.equals(intent.getStringExtra(KEY_TYPE))) {
                toPureH5Pay((APMidasBaseRequest) intent.getSerializableExtra("key_request"));
            } else {
                initUI();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            String fullExceptionStacktrace = APPluginUtils.getFullExceptionStacktrace(e16);
            if (!TextUtils.isEmpty(fullExceptionStacktrace) && (fullExceptionStacktrace.contains("webview") || fullExceptionStacktrace.contains(QzoneCoverConst.CoverStringType.COVER_TYPE_WEBVIEW_COVER_PREFIX))) {
                Toast.makeText(this, "\u7cfb\u7edf\u7ec4\u4ef6\u7f3a\u5931\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5", 0).show();
            }
            APPluginUtils.callbackInMidasPluginWithoutCaringAboutNewProcess(this, 100, "\u8fd4\u56de");
            finish();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            APLog.d(TAG, "onKey down = back!");
            APMidasResponse aPMidasResponse = new APMidasResponse();
            aPMidasResponse.resultCode = 100;
            aPMidasResponse.resultMsg = "\u8fd4\u56de";
            APMidasPayHelper.midasCallBack(aPMidasResponse);
            finish();
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    private static boolean startPureH5Pay(Context context, APMidasBaseRequest aPMidasBaseRequest) {
        if (context == null) {
            APLog.e(TAG, "Cannot start pure h5 pay with null context!");
            return false;
        }
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setClass(context, APWebJSBridgeActivity.class);
        intent.putExtra(KEY_TYPE, VALUE_PURE_H5);
        intent.putExtra("key_request", aPMidasBaseRequest);
        context.startActivity(intent);
        return true;
    }
}
