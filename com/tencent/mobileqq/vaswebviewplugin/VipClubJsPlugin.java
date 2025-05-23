package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.EIPCCallbackWrapper;
import com.tencent.mobileqq.vas.api.f;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.mobileqq.vas.report.VasJsbCommonReport;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.ColorNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.LikeAreaBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.XAResBusiness;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.wallpaper.VipWallpaperService;
import com.tencent.mobileqq.vas.webview.plugin.VasTransformUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.mobilereport.MobileReportManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class VipClubJsPlugin extends VasWebviewJsPluginV2 {
    public static final HashMap<String, QQVasUpdateBusiness> BUSINESS_MAP;
    public static final String BUSINESS_NAME = "vipclub";
    private static final String MESSAGE = "message";
    private static final String RESULT = "result";
    private static final String TAG = "VipClubJsPlugin";
    public static final HashMap<String, QQVasUpdateBusiness> VIP_BUSINESS_MAP;
    private static final boolean enableNewJsb;

    static {
        HashMap<String, QQVasUpdateBusiness> hashMap = new HashMap<>();
        VIP_BUSINESS_MAP = hashMap;
        HashMap<String, QQVasUpdateBusiness> hashMap2 = new HashMap<>();
        BUSINESS_MAP = hashMap2;
        enableNewJsb = VasNormalToggle.VAS_NEW_JSB_COMMON_SWITCH_2.isEnable(true);
        hashMap.put(String.valueOf(327L), ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 327L));
        hashMap.put(String.valueOf(57L), QQVasUpdateBusinessUtil.getBusinessInstance(ColorNameBusiness.class));
        hashMap.put(String.valueOf(54L), QQVasUpdateBusinessUtil.getBusinessInstance(XAResBusiness.class));
        hashMap.put(String.valueOf(333L), ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 333L));
        hashMap2.put(String.valueOf(328L), QQVasUpdateBusinessUtil.getBusinessInstance(LikeAreaBusiness.class));
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "cardSupportVideo")
    public void cardSupportVideo(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            if (VasToggle.getBooleanDataSet(VasToggle.GLDRAWABLE, "video", true)) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            jSONObject.put("result", str2);
            jSONObject.put("msg", "\u4e0d\u652f\u6301\u89c6\u9891");
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "getCustomBgList")
    public void getCustomBgList(final String str) {
        VasUtil.getService().getGxh().getCustomBgList(com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vaswebviewplugin.VipClubJsPlugin.4
            @Override // com.tencent.mobileqq.vas.api.f.b
            public void onCallback(String str2) {
                VipClubJsPlugin.super.callJs(str, str2);
            }
        }));
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "data|callback", method = "getLocalToggleStatus")
    public void getLocalToggleStatus(JSONObject jSONObject, final String str) {
        VasUtil.getService().getGxh().getLocalToggleStatus(jSONObject.toString(), EIPCCallbackWrapper.newInstance(new f.b() { // from class: com.tencent.mobileqq.vaswebviewplugin.f
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str2) {
                VipClubJsPlugin.this.lambda$getLocalToggleStatus$1(str, str2);
            }
        }));
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BUSINESS_NAME;
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "isWeakNet")
    public void isWeakNet(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            VasCommonJsbProxy vasCommonJsbProxy = this.proxy;
            jSONObject.put("weakNet", (vasCommonJsbProxy != null && vasCommonJsbProxy.getIsWeakNet()) ? 1 : 0);
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|business|setKey|data", method = "notify")
    public void notify(String str, String str2, String str3, JSONObject jSONObject) {
        if (enableNewJsb && this.proxy != null) {
            try {
                o13.a.INSTANCE.a(Long.parseLong(str2), this.proxy).a(jSONObject, str3, str);
                QQVasUpdateBusiness.getBusiness(Long.parseLong(str2)).checkFileAvailableAndReport(jSONObject.optInt("itemId"));
                return;
            } catch (Exception unused) {
                QLog.e(TAG, 1, "notify parse error" + jSONObject);
                return;
            }
        }
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        if (TextUtils.isEmpty(currentAccountUin)) {
            return;
        }
        if (this.proxy != null) {
            this.proxy.reportSetEndSetSuccess(str3, String.valueOf(jSONObject.optInt("itemId")));
        }
        if (VIP_BUSINESS_MAP.containsKey(str2)) {
            VasUtil.getService().getVipDataProxy().requestAndUpdateData(currentAccountUin);
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "title|appName|appId|sceneId|sourceId|reportExt|callback", method = "openRechargePanel")
    public void openRechargePanel(String str, String str2, int i3, String str3, String str4, String str5, final String str6) {
        if (((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).isSwitchEnable()) {
            IVasNativePayManager.ReportData reportData = new IVasNativePayManager.ReportData(i3 + "", "0", "0", "0_0_0_0");
            if (!str3.isEmpty()) {
                reportData.mSubBusinessId = str3;
            }
            if (!str4.isEmpty()) {
                reportData.mSource = str4;
            }
            if (!str5.isEmpty()) {
                reportData.mExt = str5;
            }
            QLog.i(TAG, 1, "openRechargePanel : " + reportData.toString());
            ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).initAndShowPayPanel(this.mRuntime.a(), str, str2, reportData, new IVasNativePayManager.PayObserver() { // from class: com.tencent.mobileqq.vaswebviewplugin.VipClubJsPlugin.3
                @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
                public void onOpenPayViewFail() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "0");
                        jSONObject.put("result", "1");
                        jSONObject.put("msg", "\u6253\u5f00\u652f\u4ed8\u9762\u677f\u5931\u8d25");
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    VipClubJsPlugin.this.callJs(str6, jSONObject.toString());
                }

                @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
                public void onOpenPayViewSuccess() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "0");
                        jSONObject.put("result", "0");
                        jSONObject.put("msg", "\u6253\u5f00\u652f\u4ed8\u9762\u677f\u6210\u529f");
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    VipClubJsPlugin.this.callJs(str6, jSONObject.toString());
                }

                @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
                public void onPaySuccess() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "1");
                        jSONObject.put("result", "0");
                        jSONObject.put("msg", "\u652f\u4ed8\u6210\u529f");
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    VipClubJsPlugin.this.callJs(str6, jSONObject.toString());
                }

                @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
                public void onPayViewClose() {
                }

                @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
                public void onPayError(int i16) {
                }
            });
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "type", method = "paySuccess")
    public void paySuccess(Object obj) {
        int intValue;
        if (obj instanceof String) {
            intValue = Integer.parseInt((String) obj);
        } else {
            if (!(obj instanceof Number)) {
                if (obj == null) {
                    QLog.e(TAG, 1, "paySuccess type is null");
                    return;
                }
                QLog.e(TAG, 1, "paySuccess wrong type: " + obj.getClass());
                return;
            }
            intValue = ((Number) obj).intValue();
        }
        QLog.e(TAG, 1, "paySuccess: " + obj);
        Bundle bundle = new Bundle();
        bundle.putInt("type", intValue);
        QIPCClientHelper.getInstance().callServer("VasCommonIPCModule", "paySuccess", bundle, null);
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|status", method = "qidResult")
    public void qidResult(String str, Object obj) {
        int intValue;
        try {
            QLog.d(TAG, 1, "qidResult");
            if (obj instanceof String) {
                intValue = Integer.parseInt((String) obj);
            } else {
                intValue = obj instanceof Number ? ((Number) obj).intValue() : 0;
            }
            VipQidHelper.setQidOpen(this.mRuntime.b(), intValue == 1);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "0");
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|business|itemId|setKey", method = "queryDownloadStatus")
    public void queryDownloadStatus(String str, String str2, int i3, String str3) {
        QQVasUpdateBusiness<?> business = QQVasUpdateBusiness.getBusiness(Long.parseLong(str2));
        VasCommonJsbProxy vasCommonJsbProxy = this.proxy;
        if (vasCommonJsbProxy != null) {
            super.callJs(str, vasCommonJsbProxy.queryInfo(str3, i3, business));
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|business|itemId|setKey", method = GameCenterAPIJavaScript.QUERY_INFO)
    public void queryInfo(String str, String str2, int i3, String str3) {
        QQVasUpdateBusiness<?> business;
        HashMap<String, QQVasUpdateBusiness> hashMap = VIP_BUSINESS_MAP;
        if (hashMap.containsKey(str2)) {
            business = hashMap.get(str2);
        } else {
            HashMap<String, QQVasUpdateBusiness> hashMap2 = BUSINESS_MAP;
            if (hashMap2.containsKey(str2)) {
                business = hashMap2.get(str2);
            } else {
                business = QQVasUpdateBusiness.getBusiness(Long.parseLong(str2));
            }
        }
        QQVasUpdateBusiness<?> qQVasUpdateBusiness = business;
        if (qQVasUpdateBusiness == null) {
            return;
        }
        VasCommonJsbProxy vasCommonJsbProxy = this.proxy;
        if (vasCommonJsbProxy != null) {
            super.callJs(str, VasTransformUtils.INSTANCE.transformVipClubQueryInfo(vasCommonJsbProxy.queryInfo(str3, i3, qQVasUpdateBusiness)));
            return;
        }
        int a16 = com.tencent.mobileqq.webview.js.a.a(i3, qQVasUpdateBusiness, null);
        VasJsbCommonReport.reportPreDownload(str3, qQVasUpdateBusiness, i3, a16, (TextUtils.isEmpty(str3) || VasJsbCommonReport.INSTANCE.getMSetKeyToStartTime().containsKey(str3)) ? false : true, BUSINESS_NAME);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", a16);
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, "parse error " + e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "data|callback", method = "setLocalToggleStatus")
    public void setLocalToggleStatus(JSONObject jSONObject, final String str) {
        VasUtil.getService().getGxh().setLocalToggleStatus(jSONObject.toString(), EIPCCallbackWrapper.newInstance(new f.b() { // from class: com.tencent.mobileqq.vaswebviewplugin.g
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str2) {
                VipClubJsPlugin.this.lambda$setLocalToggleStatus$0(str, str2);
            }
        }));
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "quickSwitchDefaultMode")
    public void switchTheme(final String str) {
        MobileReportManager.getInstance().reportAction("DressVip", "3001150", "21", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "4", 102, 0);
        QIPCClientHelper.getInstance().callServer("VasCommonIPCModule", "switch_to_common_theme", null, new EIPCResultCallback() { // from class: com.tencent.mobileqq.vaswebviewplugin.VipClubJsPlugin.1
            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                String str2;
                if (!eIPCResult.isSuccess()) {
                    VipClubJsPlugin.super.callJsOnError(str, eIPCResult.f396321e.getMessage());
                }
                Bundle bundle = eIPCResult.data;
                if (bundle != null) {
                    str2 = bundle.getString("key_theme_switch_json_result");
                } else {
                    str2 = "";
                }
                VipClubJsPlugin.super.callJs(str, str2);
            }
        });
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "themeSupportVideo")
    public void themeSupportVideo(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            if (ThemeBackground.isSupportVideo()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            jSONObject.put("result", str2);
            jSONObject.put("msg", "\u4e0d\u652f\u6301\u8d85\u7ea7\u4e3b\u9898");
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "updateQQValueCard")
    public void updateQQValueCard(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "0");
            jSONObject.put("msg", "\u6536\u5230\u5237\u65b0\u8bf7\u6c42");
            super.callJs(str, jSONObject.toString());
            QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.S, null, new EIPCResultCallback() { // from class: com.tencent.mobileqq.vaswebviewplugin.VipClubJsPlugin.2
                @Override // eipc.EIPCResultCallback
                public void onCallback(EIPCResult eIPCResult) {
                    if (QLog.isColorLevel()) {
                        QLog.d("GLDrawableDownloadHelper", 2, "requestDownloadDepends success");
                    }
                }
            });
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "wallpaperGetChatBg")
    public void wallpaperGetChatBg(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            VipWallpaperService.c c16 = VipWallpaperService.c(this.mRuntime.a(), true);
            jSONObject.put("result", "0");
            jSONObject.put("id", c16.f311401a);
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|id|changeSystem", method = "wallpaperSetChatBg")
    public void wallpaperSetChatBg(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            if ("0".equals(str2)) {
                VipWallpaperService.f(this.mRuntime.a(), new VipWallpaperService.c(), null);
                jSONObject.put("result", "0");
                jSONObject.put("msg", "\u6062\u590d\u7cfb\u7edf\u58c1\u7eb8");
            } else {
                String shopBgPath = ChatBackgroundUtil.getShopBgPath(str2);
                if (new File(shopBgPath).exists()) {
                    AtomicBoolean atomicBoolean = new AtomicBoolean();
                    VipWallpaperService.f(this.mRuntime.a(), new VipWallpaperService.c(str2, shopBgPath, ""), atomicBoolean);
                    jSONObject.put("result", "0");
                    jSONObject.put("msg", "\u8bbe\u7f6e\u6210\u529f");
                    if (atomicBoolean.get()) {
                        jSONObject.put("isGoOut", true);
                    }
                } else {
                    jSONObject.put("result", "1");
                    jSONObject.put("msg", "\u7d20\u6750\u4e0d\u5b58\u5728");
                }
            }
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "wallpaperSupportList")
    public void wallpaperSupportList(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "staic|apng");
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLocalToggleStatus$1(String str, String str2) {
        super.callJs(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setLocalToggleStatus$0(String str, String str2) {
        super.callJs(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public boolean excuteEvent(String str, long j3, Map<String, Object> map) {
        VasCommonJsbProxy vasCommonJsbProxy;
        if (j3 != 8589934604L || (vasCommonJsbProxy = this.proxy) == null) {
            return false;
        }
        vasCommonJsbProxy.themePostChange();
        return false;
    }
}
