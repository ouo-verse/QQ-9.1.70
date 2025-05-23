package com.tencent.qqmini.sdk.plugins;

import NS_MINI_SHARE.MiniProgramShare$StGetGroupShareInfoRsp;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.luggage.wxa.xd.c1;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserGroupInfoServlet;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.auth.AuthFilterList;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class DataJsPlugin extends BaseJsPlugin {
    private static final String MINI_APP_STORE_APPID = "1108291530";
    private static final String TAG = "DataJsPlugin";
    private static final int WHAT_GET_SHARE_INFO_TIMEOUT = 1;
    private static final String fakeCheckNavigateRightRsp = "{\"action_code\":1,\"skip_local_check\":1,\"wording\":\"\"}";
    private ChannelProxy mChannelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
    private MiniAppProxy mMiniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);

    private void advertReport(RequestEvent requestEvent) {
        boolean z16;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            int i3 = jSONObject.getJSONObject("data").getJSONObject("data").getInt(TVKDataBinder.KEY_REPORT_TYPE);
            String obj = jSONObject.getJSONObject("data").getJSONObject("data").get("ads_info").toString();
            String obj2 = jSONObject.getJSONObject("data").getJSONObject("data").get(SsoReporter.POS_ID_KEY).toString();
            AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
            if (adProxy != null && i3 == 0) {
                z16 = adProxy.adExposure(this.mMiniAppContext.getAttachActivity(), obj, obj2);
            } else {
                z16 = false;
            }
            if (z16) {
                requestEvent.ok();
            } else {
                requestEvent.fail();
            }
            QMLog.i(TAG, "advertExposure " + obj + ", posId = " + obj2);
        } catch (Exception unused) {
            requestEvent.fail();
            QMLog.e(TAG, "advertExposure, data is wrong " + requestEvent.jsonParams);
        }
    }

    private void advertTap(RequestEvent requestEvent) {
        boolean z16;
        try {
            new JSONObject(requestEvent.jsonParams);
            AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
            if (adProxy != null) {
                z16 = adProxy.adClick(this.mMiniAppContext.getAttachActivity(), requestEvent.jsonParams, "");
            } else {
                z16 = false;
            }
            if (z16) {
                requestEvent.ok();
            } else {
                requestEvent.fail();
            }
        } catch (Exception unused) {
            requestEvent.fail();
            QMLog.e(TAG, "advert_tap, data is wrong " + requestEvent.jsonParams);
        }
    }

    private Typeface getFont(String str, String str2, String str3) {
        if ("normal".equals(str)) {
            if ("normal".equals(str2)) {
                return Typeface.create(str3, 0);
            }
            if ("bold".equals(str2)) {
                return Typeface.create(str3, 1);
            }
        } else if ("italic".equals(str)) {
            if ("normal".equals(str2)) {
                return Typeface.create(str3, 2);
            }
            if ("bold".equals(str2)) {
                return Typeface.create(str3, 3);
            }
        }
        return null;
    }

    private void getUserInfo(final RequestEvent requestEvent, final String str, boolean z16, String str2) {
        String str3 = this.mApkgInfo.appId;
        QMLog.d(TAG, "getUserInfo appID:" + str3);
        this.mChannelProxy.getUserInfo(str3, z16, str2, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.14
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z17, JSONObject jSONObject) {
                String str4 = "";
                if (z17) {
                    if (DebugUtil.isDebugVersion()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("call getUserInfo \uff1a ");
                        if (jSONObject != null) {
                            str4 = jSONObject.toString();
                        }
                        sb5.append(str4);
                        QMLog.d(DataJsPlugin.TAG, sb5.toString());
                    }
                    if (AuthorizeCenter.KEY_API_NAME_GET_USER_INFO_OPEN_DATA.equals(str) && jSONObject != null) {
                        try {
                            jSONObject.remove("signature");
                            jSONObject.remove(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA);
                            jSONObject.remove("iv");
                            jSONObject.remove("cloudID");
                            if (jSONObject.has("data")) {
                                JSONObject jSONObject2 = new JSONObject(jSONObject.get("data").toString());
                                jSONObject2.remove("signature");
                                jSONObject.put("data", jSONObject2);
                            }
                        } catch (Throwable th5) {
                            QMLog.e(DataJsPlugin.TAG, "webapi_getuserinfo_opendata error, ", th5);
                        }
                    }
                    requestEvent.ok(jSONObject);
                    return;
                }
                QMLog.d(DataJsPlugin.TAG, "call getUserInfo failed:" + jSONObject);
                if (jSONObject != null) {
                    requestEvent.fail(jSONObject, jSONObject.optString("errMsg", ""));
                } else {
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"getTextLineHeight"})
    private String handleGetTextLineHeight(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("fontStyle");
            String optString2 = jSONObject.optString("fontWeight");
            String optString3 = jSONObject.optString("fontFamily");
            String optString4 = jSONObject.optString("text");
            int i3 = jSONObject.getInt("fontSize");
            if (!"normal".equals(optString2) && !"bold".equals(optString2)) {
                requestEvent.fail("fontWeight is illegal");
                return "";
            }
            if (!"normal".equals(optString) && !"italic".equals(optString)) {
                requestEvent.fail("fontStyle is illegal");
                return "";
            }
            if (i3 <= 0) {
                requestEvent.fail("jsPluginEngine is illegal");
                return "";
            }
            if (TextUtils.isEmpty(optString4)) {
                requestEvent.fail("text is empty");
                return "";
            }
            Paint paint = new Paint();
            paint.setTextSize(i3);
            if (getFont(optString, optString2, optString3) == null) {
                requestEvent.fail("cannot create this font");
                return "";
            }
            Rect rect = new Rect();
            paint.getTextBounds(optString4, 0, optString4.length(), rect);
            requestEvent.ok();
            return "" + rect.height();
        } catch (JSONException unused) {
            requestEvent.fail("json exception");
            return "";
        }
    }

    private boolean isEntryModelGroupType(String str) {
        LaunchParam launchParam;
        EntryModel entryModel;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && (entryModel = launchParam.entryModel) != null && str != null && str.equals(entryModel.getEntryHash()) && this.mMiniAppInfo.launchParam.entryModel.type == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onRequestAdInfoResult(boolean z16, JSONObject jSONObject, RequestEvent requestEvent, int i3) throws JSONException {
        boolean z17;
        if (z16) {
            int i16 = jSONObject.getInt("retCode");
            String string = jSONObject.getString("errMsg");
            String string2 = jSONObject.getString("response");
            String optString = jSONObject.optString("adClass");
            String optString2 = jSONObject.optString("fromSDK");
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            QMLog.d(TAG, "requestAdInfo. retCode = " + i16);
            if (WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_AD_USE_TRANSCODING, 0) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (i16 != 0 && z17) {
                int retCodeByServerResult = MiniSDKConst.AdConst.getRetCodeByServerResult(i16);
                try {
                    jSONObject3.put("ret", retCodeByServerResult);
                    jSONObject2.put("data", jSONObject3.toString());
                } catch (JSONException e16) {
                    QMLog.e(TAG, "JSONException: " + Log.getStackTraceString(e16));
                }
                if (retCodeByServerResult != -1) {
                    requestEvent.fail(jSONObject2, MiniSDKConst.AdConst.CODE_MSG_MAP.get(Integer.valueOf(retCodeByServerResult)));
                } else {
                    requestEvent.fail(jSONObject2, string);
                }
                return true;
            }
            try {
                jSONObject3.put("data", string2);
                jSONObject3.put("ret", i16);
                jSONObject3.put("adClass", optString);
                if (!TextUtils.isEmpty(optString2)) {
                    jSONObject3.put("fromSDK", optString2);
                }
                jSONObject2.put("data", jSONObject3.toString());
            } catch (JSONException unused) {
                QMLog.i(TAG, "requestAdInfo. retCode = " + i16);
            }
            requestEvent.ok(jSONObject2);
            saveAdCookie(string2, i3);
            return false;
        }
        if (jSONObject != null) {
            int i17 = jSONObject.getInt("retCode");
            String string3 = jSONObject.getString("errMsg");
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("ret", i17);
                jSONObject4.put("errMsg", string3);
                requestEvent.fail(jSONObject4, "");
                return false;
            } catch (JSONException unused2) {
                QMLog.e(TAG, "requestAdInfo. retCode = " + i17);
                return false;
            }
        }
        requestEvent.fail();
        return false;
    }

    private void operateGetShareInfo(String str, int i3, final RequestEvent requestEvent) {
        if (i3 <= 0) {
            i3 = 30000;
        }
        if (TextUtils.isEmpty(str)) {
            requestEvent.fail("shareTicket can not be null");
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("getShareInfoHandlerThread");
        baseHandlerThread.start();
        final Handler handler = new Handler(baseHandlerThread.getLooper(), new Handler.Callback() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.15
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 1) {
                    requestEvent.fail();
                    return false;
                }
                return false;
            }
        });
        handler.sendEmptyMessageDelayed(1, i3);
        this.mChannelProxy.getGroupShareInfo(this.mApkgInfo.appId, str, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.16
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    QMLog.d(DataJsPlugin.TAG, "call getGroupShareInfo  ret:" + jSONObject.toString());
                    try {
                        MiniProgramShare$StGetGroupShareInfoRsp miniProgramShare$StGetGroupShareInfoRsp = (MiniProgramShare$StGetGroupShareInfoRsp) jSONObject.get("response");
                        int i16 = jSONObject.getInt(QzoneIPCModule.RESULT_CODE);
                        String str2 = miniProgramShare$StGetGroupShareInfoRsp.encryptedData.get();
                        String str3 = miniProgramShare$StGetGroupShareInfoRsp.f24969iv.get();
                        QMLog.d(DataJsPlugin.TAG, "getGroupShareInfo receive resultCode= " + i16 + " encryptedData=" + str2 + " iv=" + str3);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, str2);
                        jSONObject2.putOpt("iv", str3);
                        if (!((BaseJsPlugin) DataJsPlugin.this).mIsMiniGame) {
                            JSONObject jSONObject3 = new JSONObject();
                            try {
                                jSONObject3.put("data", jSONObject2);
                            } catch (JSONException e16) {
                                e16.printStackTrace();
                            }
                            QMLog.d(DataJsPlugin.TAG, "call getGroupShareInfo\uff1a " + jSONObject3.toString());
                            requestEvent.ok(jSONObject3);
                        } else {
                            requestEvent.ok(jSONObject2);
                        }
                        Handler handler2 = handler;
                        if (handler2 != null) {
                            handler2.removeMessages(1);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        QMLog.e(DataJsPlugin.TAG, "call getGroupShareInfo failed ");
                        requestEvent.fail();
                        return;
                    }
                }
                QMLog.e(DataJsPlugin.TAG, "call getGroupShareInfo failed ");
                requestEvent.fail();
            }
        });
    }

    @JsEvent({"private_addContact"})
    private void private_addContact(final RequestEvent requestEvent) {
        try {
            if (!((ChannelProxy) ProxyManager.get(ChannelProxy.class)).addPublicAccount(LoginManager.getInstance().getAccount(), new JSONObject(requestEvent.jsonParams).optString("mpid"), new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.3
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    if (!z16) {
                        requestEvent.fail();
                        MiniToast.makeText(((BaseJsPlugin) DataJsPlugin.this).mMiniAppContext.getAttachActivity(), 0, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc", 1).show(((BaseJsPlugin) DataJsPlugin.this).mMiniAppContext.getAttachActivity().getResources().getDimensionPixelSize(R.dimen.mini_sdk_title_bar_height));
                    } else {
                        requestEvent.ok();
                        MiniToast.makeText(((BaseJsPlugin) DataJsPlugin.this).mMiniAppContext.getAttachActivity(), 0, "\u5173\u6ce8\u516c\u4f17\u53f7\u6210\u529f", 1).show(((BaseJsPlugin) DataJsPlugin.this).mMiniAppContext.getAttachActivity().getResources().getDimensionPixelSize(R.dimen.mini_sdk_title_bar_height));
                    }
                }
            })) {
                MiniToast.makeText(this.mMiniAppContext.getAttachActivity(), 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(this.mContext) + "\u4e2d\u5173\u6ce8\u516c\u4f17\u53f7", 1);
                requestEvent.fail();
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void requestAdInfo(final RequestEvent requestEvent, String str, final int i3, int i16, long j3, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        Context context;
        String str7;
        LaunchParam launchParam;
        String spAdGdtCookie = AdUtil.getSpAdGdtCookie(i3);
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo == null || (launchParam = miniAppInfo.launchParam) == null) {
            str3 = "";
            str4 = str3;
            str5 = str4;
        } else {
            String str8 = launchParam.entryPath;
            if (str8 == null) {
                str8 = "";
            }
            String str9 = launchParam.reportData;
            str5 = String.valueOf(launchParam.scene);
            str3 = str8;
            str4 = str9;
        }
        if (miniAppInfo == null || (str7 = miniAppInfo.via) == null) {
            str6 = "";
        } else {
            str6 = str7;
        }
        AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
        if (adProxy != null) {
            try {
                if (this.mMiniAppContext.getAttachActivity() != null) {
                    context = this.mMiniAppContext.getAttachActivity();
                } else {
                    context = MiniAppEnv.g().getContext();
                }
                adProxy.requestAdInfo(context, String.valueOf(j3), str, str2, 53, i3, 0, spAdGdtCookie, str3, str4, str5, str6, i16, new AdProxy.ICmdListener() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.13
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener
                    public void onCmdListener(boolean z16, JSONObject jSONObject) {
                        try {
                            DataJsPlugin.this.onRequestAdInfoResult(z16, jSONObject, requestEvent, i3);
                        } catch (Exception unused) {
                            requestEvent.fail();
                        }
                    }
                });
                return;
            } catch (Throwable th5) {
                requestEvent.fail();
                QMLog.e(TAG, "requestAdInfo. error", th5);
                return;
            }
        }
        requestEvent.fail();
    }

    private void saveAdCookie(String str, int i3) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("gdt_cookie")) {
                String string = jSONObject.getString("gdt_cookie");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                AdUtil.putSpAdGdtCookie(i3, string);
                QMLog.i(TAG, "parseAndSaveCookie save key success, adType = " + i3 + ", value = " + string);
            }
        } catch (Exception e16) {
            QMLog.i(TAG, "parseAndSaveCookie error" + str, e16);
        }
    }

    private void startGroupBrowserActivity(String str, final RequestEvent requestEvent) {
        if (!((ChannelProxy) ProxyManager.get(ChannelProxy.class)).openGroup(this.mMiniAppContext.getAttachActivity(), str, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.17
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    requestEvent.ok();
                } else {
                    requestEvent.fail();
                }
            }
        })) {
            MiniToast.makeText(this.mContext, 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(this.mContext) + "\u4e2d\u6253\u5f00QQ\u7fa4", 1);
            requestEvent.fail("app not implement");
        }
    }

    private void webapiGetWerunStepHistory(final RequestEvent requestEvent) {
        this.mChannelProxy.getUserHealthData(this.mApkgInfo.appId, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.8
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16 && jSONObject != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        if (((BaseJsPlugin) DataJsPlugin.this).mIsMiniGame) {
                            jSONObject2.put("data", jSONObject);
                        } else {
                            jSONObject2.put("data", jSONObject.toString());
                        }
                        requestEvent.ok(jSONObject2);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                requestEvent.fail();
            }
        });
    }

    private void webapiGetnavigateWxaappinfo(final RequestEvent requestEvent, JSONObject jSONObject) {
        String optString = jSONObject.optJSONObject("reqData").optString("target_appid");
        if ("1108291530".equals(this.mApkgInfo.appId)) {
            QMLog.d(TAG, "MINI_APP_STORE skip checkNavigateRight");
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("data", fakeCheckNavigateRightRsp);
                jSONObject2.put("respData", jSONObject3);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            requestEvent.ok(jSONObject2);
            return;
        }
        this.mChannelProxy.checkNavigateRight(this.mApkgInfo.appId, optString, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.10
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject4) {
                if (z16) {
                    if (QMLog.isColorLevel()) {
                        QMLog.d(DataJsPlugin.TAG, "call checkNavigateRight \uff1a " + jSONObject4.toString());
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    JSONObject jSONObject6 = new JSONObject();
                    try {
                        jSONObject6.put("data", jSONObject4.toString());
                        jSONObject5.put("respData", jSONObject6);
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                    QMLog.d(DataJsPlugin.TAG, "call checkNavigateRight real\uff1a " + jSONObject5.toString());
                    requestEvent.ok(jSONObject5);
                    return;
                }
                QMLog.d(DataJsPlugin.TAG, "call checkNavigateRight failed. ");
                requestEvent.fail();
            }
        });
    }

    private void webapiPluginGetUserInfo(final RequestEvent requestEvent, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        String optString = optJSONObject.optString("miniprogram_appid");
        boolean optBoolean = optJSONObject.optBoolean("withCredentials");
        String optString2 = optJSONObject.optString("lang");
        if (!TextUtils.isEmpty(optString)) {
            this.mChannelProxy.getUserInfo(optString, optBoolean, optString2, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.11
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                    QMLog.d(DataJsPlugin.TAG, "webapi_plugin_getuserinfo " + z16 + ", " + jSONObject2);
                    if (z16) {
                        requestEvent.ok(jSONObject2);
                        AuthState.setAllowPluginScopeName(null);
                        return;
                    }
                    QMLog.d(DataJsPlugin.TAG, "call getUserInfo failed:" + jSONObject2);
                    if (jSONObject2 != null) {
                        requestEvent.fail(jSONObject2, jSONObject2.optString("errMsg", ""));
                    } else {
                        requestEvent.fail();
                    }
                    AuthState.setAllowPluginScopeName(null);
                }
            });
        } else {
            requestEvent.fail();
            AuthState.setAllowPluginScopeName(null);
        }
    }

    private void webapiPluginLogin(final RequestEvent requestEvent, JSONObject jSONObject) {
        String optString = jSONObject.optJSONObject("data").optString("miniprogram_appid");
        if (!TextUtils.isEmpty(optString)) {
            this.mChannelProxy.login(optString, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.9
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                    QMLog.d(DataJsPlugin.TAG, "webapi_plugin_login " + z16 + ", " + jSONObject2);
                    if (z16) {
                        requestEvent.ok(jSONObject2);
                    } else {
                        requestEvent.fail();
                    }
                }
            });
        } else {
            requestEvent.fail();
        }
    }

    private void webapiPluginSetAuth(RequestEvent requestEvent, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("miniprogram_appid");
            if (!TextUtils.isEmpty(optString)) {
                String account = LoginManager.getInstance().getAccount();
                String scopePluginSetauthName = BaseJsPluginEngine.getScopePluginSetauthName(optString, jSONObject.optString("plugin_appid"));
                AuthState.setAllowPluginScopeName(scopePluginSetauthName);
                new AuthState(this.mContext, optString, account).grantPermission(scopePluginSetauthName);
                requestEvent.ok();
                return;
            }
            requestEvent.fail();
            return;
        }
        requestEvent.fail();
    }

    @JsEvent({"batchGetContact"})
    public void batchGetContact(final RequestEvent requestEvent) {
        try {
            JSONArray optJSONArray = new JSONObject(requestEvent.jsonParams).optJSONArray("appIds");
            ArrayList<String> arrayList = new ArrayList<>();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    arrayList.add(String.valueOf(optJSONArray.get(i3)));
                }
            }
            this.mChannelProxy.batchGetContact(arrayList, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.6
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    String str;
                    if (z16) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("batchGetContact : ");
                        if (jSONObject != null) {
                            str = jSONObject.toString();
                        } else {
                            str = "";
                        }
                        sb5.append(str);
                        QMLog.e(DataJsPlugin.TAG, sb5.toString());
                        requestEvent.ok(jSONObject);
                        return;
                    }
                    requestEvent.fail("batchGetContact failed.");
                }
            });
        } catch (Throwable unused) {
            requestEvent.fail("batchGetContact failed.");
        }
    }

    @JsEvent({"getCloudTicket"})
    public void getCloudTicket(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String str = this.mApkgInfo.appId;
            String optString = jSONObject.optString("envId");
            if (!TextUtils.isEmpty(optString)) {
                this.mChannelProxy.getTcbTicket(str, optString, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.5
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                        if (z16) {
                            requestEvent.ok(jSONObject2);
                            return;
                        }
                        QMLog.e(DataJsPlugin.TAG, "getTcbTicket fail, retCode: " + jSONObject2.optLong("retCode") + "; errMsg : " + jSONObject2.optString("errMsg"));
                        requestEvent.fail(jSONObject2, null);
                    }
                });
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "API_GET_CLOUD_TICKET error, ", th5);
        }
    }

    @JsEvent({PluginConst.DataJsPluginConst.API_GET_GROUP_INFO})
    public void getGroupInfo(RequestEvent requestEvent) {
        boolean z16;
        LaunchParam launchParam;
        EntryModel entryModel;
        JSONObject jSONObject = new JSONObject();
        try {
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && (entryModel = launchParam.entryModel) != null) {
                z16 = entryModel.isAdmin;
            } else {
                z16 = false;
            }
            jSONObject.put("isGroupManager", z16);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        requestEvent.ok(jSONObject);
    }

    @JsEvent({PluginConst.DataJsPluginConst.API_GET_GROUP_INFO_EXTRA})
    public void getGroupInfoExtra(final RequestEvent requestEvent) {
        boolean z16;
        LaunchParam launchParam;
        EntryModel entryModel;
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("entryDataHash");
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && (entryModel = launchParam.entryModel) != null) {
                z16 = entryModel.isAdmin;
            } else {
                z16 = false;
            }
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("isGroupManager", z16);
            if (isEntryModelGroupType(optString)) {
                String str = this.mApkgInfo.appId;
                MiniAppInfo miniAppInfo2 = this.mMiniAppInfo;
                if (miniAppInfo2 != null) {
                    this.mChannelProxy.getUserGroupInfo(null, str, String.valueOf(miniAppInfo2.launchParam.entryModel.uin), this.mMiniAppInfo.launchParam.entryModel.dwGroupClassExt, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.2
                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                        public void onReceiveResult(boolean z17, JSONObject jSONObject2) {
                            String str2;
                            if (z17) {
                                try {
                                    jSONObject.put("extInfo", jSONObject2.optString(MiniAppGetUserGroupInfoServlet.KEY_EXTRA_JSON_DATA));
                                    requestEvent.ok(jSONObject);
                                    return;
                                } catch (JSONException e16) {
                                    QMLog.e(DataJsPlugin.TAG, "getUserGroupInfo result exception.", e16);
                                    return;
                                }
                            }
                            if (jSONObject2 != null) {
                                str2 = jSONObject2.optString("errMsg");
                            } else {
                                str2 = "getUserGroupInfo failed.";
                            }
                            requestEvent.fail(str2);
                        }
                    });
                    return;
                }
                return;
            }
            QMLog.e(TAG, "entryDataHash or type error.");
            requestEvent.fail("entryDataHash or type error.");
        } catch (JSONException e16) {
            QMLog.e(TAG, "getGroupInfoExtra exception", e16);
            requestEvent.fail("JSONException");
        }
    }

    @JsEvent(isSync = false, value = {PluginConst.DataJsPluginConst.API_GET_NATIVE_USER_INFO})
    public void getNativeUserInfo(RequestEvent requestEvent) {
        if (!MiniAppEnv.g().getAuthSate(this.mMiniAppContext.getMiniAppInfo().appId).isPermissionGranted(AuthorizeCenter.SCOPE_USER_INFO) && !AuthFilterList.isAppInWhiteList(this.mMiniAppContext.getMiniAppInfo().appId) && !AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.getMiniAppInfo())) {
            QMLog.e(TAG, "getUserInfo\u5df2\u5f03\u7528\uff0c\u8bf7\u4f7f\u7528createUserInfoButton");
            requestEvent.evaluateCallbackJs(ApiUtil.wrapCallbackFail("getUserInfo", null, "getUserInfo\u5df2\u5f03\u7528\uff0c\u8bf7\u4f7f\u7528createUserInfoButton").toString());
        } else {
            requestEvent.evaluateCallbackJs(ApiUtil.wrapCallbackOk("getUserInfo", null).toString());
        }
    }

    @JsEvent({PluginConst.DataJsPluginConst.API_GET_NATIVE_WERUN_DATA, "openWeRunSetting"})
    public void getNativeWeRunData(RequestEvent requestEvent) {
        requestEvent.ok();
    }

    @JsEvent({"getPerformance"})
    public void getPerformance(RequestEvent requestEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", MiniReportManager.getLaunchPerformance(this.mMiniAppInfo.appId));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        requestEvent.ok(jSONObject);
    }

    @JsEvent({"getShareInfo"})
    public void getShareInfo(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("shareTicket");
            int optInt = jSONObject.optInt("timeout", 0);
            if (optInt <= 0) {
                optInt = 30000;
            }
            operateGetShareInfo(optString, optInt, requestEvent);
        } catch (JSONException e16) {
            QMLog.e(TAG, e16.getMessage(), e16);
            e16.printStackTrace();
        }
    }

    @JsEvent({PluginConst.DataJsPluginConst.PRIVATE_API_GET_NATIVE_USER_INFO_EXTRA})
    public void getUserInfoExtra(final RequestEvent requestEvent) {
        this.mChannelProxy.getUserInfoExtra(this.mApkgInfo.appId, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.12
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    requestEvent.ok(jSONObject);
                    return;
                }
                QMLog.e(DataJsPlugin.TAG, "call getUserInfoExtra failed:" + jSONObject);
                if (jSONObject != null) {
                    requestEvent.fail(jSONObject, jSONObject.optString("errMsg", ""));
                } else {
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({PluginConst.DataJsPluginConst.API_INVOKE_GROUP_JS})
    public void invokeGroupJSApi(RequestEvent requestEvent) {
        LaunchParam launchParam;
        EntryModel entryModel;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("entryDataHash");
            String optString2 = jSONObject.optString("url");
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && (entryModel = launchParam.entryModel) != null && optString != null && optString.equals(entryModel.getEntryHash()) && this.mMiniAppInfo.launchParam.entryModel.isAdmin && optString2 != null && optString2.contains("{{gid}}")) {
                startGroupBrowserActivity(optString2.replace("{{gid}}", String.valueOf(this.mMiniAppInfo.launchParam.entryModel.uin)), requestEvent);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onResume() {
        super.onResume();
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null) {
            MiniAppInfo miniAppInfo = this.mMiniAppContext.getMiniAppInfo();
            this.mMiniAppInfo = miniAppInfo;
            this.mApkgInfo = (ApkgInfo) miniAppInfo.apkgInfo;
        }
    }

    @JsEvent({"operateAppAdData"})
    public void operateAppAdData(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("api_name");
            if ("getBannerAd".equals(optString)) {
                webapiGetadvert(requestEvent, jSONObject, 2);
            } else if (AuthorizeCenter.KEY_API_NAME_GET_BLOCK_AD.equals(optString)) {
                webapiGetadvert(requestEvent, jSONObject, 12);
            } else if ("getCardAd".equals(optString)) {
                webapiGetadvert(requestEvent, jSONObject, 5);
            } else if ("getFeedsAd".equals(optString)) {
                webapiGetadvert(requestEvent, jSONObject, 6);
            } else if ("getInterstitialAd".equals(optString)) {
                webapiGetadvert(requestEvent, jSONObject, 10);
            } else if (AuthorizeCenter.KEY_API_NAME_CLICK_ADVERT.equals(optString)) {
                advertTap(requestEvent);
            }
        } catch (JSONException e16) {
            requestEvent.fail("json exception");
            QMLog.d(TAG, "operateAppAdData. Exception: " + Log.getStackTraceString(e16));
        }
    }

    @JsEvent({"operateWXData"})
    public void operateWXData(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            String optString = optJSONObject.optString("api_name");
            QMLog.d(TAG, "operateWXData apiName: " + optString);
            if (!AuthorizeCenter.KEY_API_NAME_GET_USER_INFO.equals(optString) && !AuthorizeCenter.KEY_API_NAME_GET_USER_INFO_OPEN_DATA.equals(optString)) {
                if (AuthorizeCenter.KEY_API_NAME_WXA_SUBSCRIBE_BIZ.equals(optString)) {
                    QMLog.e(TAG, "webapi_wxa_subscribe_biz IN DEVELOPMENT");
                    return;
                }
                if (AuthorizeCenter.KEY_API_NAME_PLUGIN_SETAUTH.equals(optString)) {
                    webapiPluginSetAuth(requestEvent, optJSONObject);
                    return;
                }
                if (AuthorizeCenter.KEY_API_NAME_PLUGIN_LOGIN.equals(optString)) {
                    webapiPluginLogin(requestEvent, optJSONObject);
                    return;
                }
                if (AuthorizeCenter.KEY_API_NAME_PLUGIN_GETUSERINFO.equals(optString)) {
                    webapiPluginGetUserInfo(requestEvent, optJSONObject);
                    return;
                }
                if (AuthorizeCenter.KEY_API_NAME_GET_NAVIGATE_WX_APPINFO.equals(optString)) {
                    webapiGetnavigateWxaappinfo(requestEvent, jSONObject);
                    return;
                }
                if (AuthorizeCenter.KEY_API_NAME_GET_ADVERT.equals(optString)) {
                    webapiGetadvert(requestEvent, optJSONObject, 2);
                    return;
                }
                if (AuthorizeCenter.KEY_API_NAME_CLICK_ADVERT.equals(optString)) {
                    advertTap(requestEvent);
                    return;
                }
                if ("advert_report".equals(optString)) {
                    advertReport(requestEvent);
                    return;
                }
                if (AuthorizeCenter.KEY_API_NAME_GET_BLOCK_AD.equals(optString)) {
                    webapiGetadvert(requestEvent, optJSONObject, 12);
                    return;
                } else if ("webapi_getshareinfo".equals(optString)) {
                    operateGetShareInfo(optJSONObject.optJSONObject("data").optString("shareTicket"), optJSONObject.optJSONObject("data").optInt("timeout", 0), requestEvent);
                    return;
                } else {
                    if (AuthorizeCenter.KEY_API_NAME_RUN_STEP_HISTORY.equals(optString)) {
                        webapiGetWerunStepHistory(requestEvent);
                        return;
                    }
                    return;
                }
            }
            boolean optBoolean = optJSONObject.optBoolean("with_credentials");
            String optString2 = optJSONObject.optString("lang", null);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
            if (optJSONObject2 != null) {
                optString2 = optJSONObject2.optString("lang", "en");
            } else if (TextUtils.isEmpty(optString2)) {
                optString2 = "en";
            }
            getUserInfo(requestEvent, optString, optBoolean, optString2);
        } catch (JSONException unused) {
            requestEvent.fail("json exception");
        }
    }

    @JsEvent({"profile"})
    public void profile(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            QMLog.d(TAG, "\u67e5\u770b\u516c\u4f17\u53f7: " + jSONObject);
            if (!((ChannelProxy) ProxyManager.get(ChannelProxy.class)).jump2PublicAccount(this.mMiniAppContext.getAttachActivity(), jSONObject.optString("uin"), jSONObject.optString("pubName"))) {
                MiniToast.makeText(this.mMiniAppContext.getAttachActivity(), 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(this.mContext) + "\u4e2d\u6253\u5f00\u516c\u4f17\u53f7", 1);
            }
        } catch (JSONException e16) {
            QMLog.e(TAG, "profile", e16);
            e16.printStackTrace();
        }
    }

    @JsEvent({"reportSubmitForm"})
    public void reportSubmitForm(final RequestEvent requestEvent) {
        this.mChannelProxy.getFormId(this.mApkgInfo.appId, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.4
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                QMLog.d(DataJsPlugin.TAG, "onCmdListener() called with: isSuc = [" + z16 + "], ret = [" + jSONObject + "]");
                if (z16) {
                    requestEvent.ok(jSONObject);
                } else {
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"scanCode"})
    public void scanCode(final RequestEvent requestEvent) {
        try {
            if (!this.mMiniAppProxy.enterQRCode(this.mMiniAppContext.getAttachActivity(), new JSONObject(requestEvent.jsonParams).optBoolean("onlyFromCamera", false), new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.1
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    if (z16) {
                        requestEvent.ok(jSONObject);
                    } else {
                        requestEvent.fail("can not use camera");
                    }
                }
            })) {
                MiniToast.makeText(this.mMiniAppContext.getAttachActivity(), 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(this.mContext) + "\u4e2d\u626b\u7801\u4e8c\u7ef4\u7801", 1);
                requestEvent.fail();
            }
        } catch (Throwable unused) {
        }
    }

    @JsEvent({c1.NAME})
    public void verifyPlugin(final RequestEvent requestEvent) {
        try {
            ArrayList<PluginInfo> arrayList = new ArrayList<>();
            JSONArray optJSONArray = new JSONObject(requestEvent.jsonParams).optJSONObject("data").optJSONArray("plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject = (JSONObject) optJSONArray.get(i3);
                    PluginInfo pluginInfo = new PluginInfo();
                    pluginInfo.setPluginId(jSONObject.optString("provider"));
                    pluginInfo.setInnerVersion(jSONObject.optString("inner_version"));
                    arrayList.add(pluginInfo);
                }
            }
            this.mChannelProxy.verifyPlugin(this.mApkgInfo.appId, arrayList, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.DataJsPlugin.7
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                    String str;
                    if (z16) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("verifyPlugin : ");
                        if (jSONObject2 != null) {
                            str = jSONObject2.toString();
                        } else {
                            str = "";
                        }
                        sb5.append(str);
                        QMLog.e(DataJsPlugin.TAG, sb5.toString());
                        requestEvent.ok(jSONObject2);
                        return;
                    }
                    requestEvent.fail("verifyPlugin failed.");
                }
            });
        } catch (Throwable unused) {
            requestEvent.fail("verifyPlugin failed.");
        }
    }

    public void webapiGetadvert(RequestEvent requestEvent, JSONObject jSONObject, int i3) {
        int i16;
        int i17;
        try {
            String optString = jSONObject.optJSONObject("data").optString(SsoReporter.POS_ID_KEY);
            if (jSONObject.optJSONObject("data").has(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE)) {
                i16 = jSONObject.optJSONObject("data").optInt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE);
            } else {
                i16 = i3;
            }
            if (jSONObject.optJSONObject("data").has("size")) {
                i17 = jSONObject.optJSONObject("data").optInt("size");
            } else {
                i17 = 1;
            }
            int i18 = i17;
            long longValue = Long.valueOf(LoginManager.getInstance().getAccount()).longValue();
            try {
                String str = this.mMiniAppInfo.appId;
                QMLog.d(TAG, "webapi_getadvert getAppid = " + str);
                if (!TextUtils.isEmpty(str)) {
                    requestAdInfo(requestEvent, optString, i16, i18, longValue, str);
                }
            } catch (Exception e16) {
                e = e16;
                requestEvent.fail();
                QMLog.e(TAG, "webapiGetadvert. error", e);
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
