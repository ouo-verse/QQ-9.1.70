package com.tencent.mobileqq.ark.api.scheme;

import android.os.Looper;
import android.text.TextUtils;
import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.module.h;
import com.tencent.mobileqq.ark.util.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troopgift.GiftPanelControllerWithGiftRepo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.vas.giftdisplay.IVasGiftKuiklyManager;
import com.tencent.mobileqq.vas.kuikly.api.IVasKuiklyLogicApi;
import com.tencent.mobileqq.vaswebviewplugin.GiftJsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopArkApi;
import com.tencent.util.URLUtil;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import s13.KuikLyConfig;
import tr2.g;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQSchemeHandler implements h {
    private void c(String str, String str2) {
        ((IWSManager) QRoute.api(IWSManager.class)).handleArkJump(str, str2);
    }

    private void d(String str, String str2) {
        try {
            QLog.i("QQSchemeHandler", 1, "handleTogether " + str + str2);
            Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str);
            Map<String, Object> b16 = i.b(new JSONObject(str2));
            Object obj = b16.get("type");
            if (obj != null && (obj instanceof String)) {
                String lowerCase = ((String) obj).toLowerCase();
                if ("watch".equals(lowerCase)) {
                    g(b16, argumentsFromURL);
                } else if ("sing".equals(lowerCase)) {
                    f(b16, argumentsFromURL);
                } else if ("listen".equals(lowerCase)) {
                    e(b16, argumentsFromURL);
                } else {
                    QLog.i("QQSchemeHandler", 1, "handleTogether type no support" + lowerCase);
                }
            } else {
                QLog.i("QQSchemeHandler", 1, "handleTogether metaJson error" + str2);
            }
        } catch (Exception e16) {
            QLog.e("QQSchemeHandler", 1, e16, new Object[0]);
        }
    }

    private void e(final Map<String, Object> map, final Map<String, String> map2) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.ark.api.scheme.QQSchemeHandler.3
            @Override // java.lang.Runnable
            public void run() {
                g.k(1, map, map2);
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        } else {
            runnable.run();
        }
    }

    private void f(final Map<String, Object> map, final Map<String, String> map2) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.ark.api.scheme.QQSchemeHandler.2
            @Override // java.lang.Runnable
            public void run() {
                g.k(4, map, map2);
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        } else {
            runnable.run();
        }
    }

    private void g(final Map<String, Object> map, final Map<String, String> map2) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.ark.api.scheme.QQSchemeHandler.1
            @Override // java.lang.Runnable
            public void run() {
                g.k(2, map, map2);
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.mobileqq.ark.module.h
    public boolean a(String str, String str2, JSONObject jSONObject, long j3, String str3, String str4) {
        AIOAnimationControlManager aIOAnimationControlManager;
        if (j3 != 0) {
            return false;
        }
        if (str.equals("pubaccount/pendant")) {
            if (BaseActivity.sTopActivity instanceof BaseActivity) {
                QLog.e("QQSchemeHandler", 1, "pubaccount/pendant NOT IMPLEMENTED");
            }
            return true;
        }
        if (str.equals("map")) {
            h(str2);
            return true;
        }
        if ("cmshow/openGame".equals(str)) {
            return true;
        }
        if ("troop/openManage".equals(str)) {
            ((ITroopArkApi) QRoute.api(ITroopArkApi.class)).openTroopManageForScheme(str2);
        } else if ("troop/report".equals(str)) {
            eu.k(str2);
            if (QLog.isColorLevel()) {
                QLog.d("navigate report", 2, "rags are:" + str2);
            }
        } else if ("gift/predownload".equals(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("VipARPreDownload", 2, "predownload path = " + str2);
            }
            QQAppInterface b16 = b();
            if (b16 != null) {
                ((com.tencent.mobileqq.qzonevip.gift.a) b16.getManager(QQManagerFactory.QZONE_GIFT_MANAGER)).B(str2);
            }
        } else if ("gift/playAnimation".equals(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("VipARPreDownload", 2, "playAnimation path = " + str2);
            }
            QQAppInterface b17 = b();
            if (b17 != null) {
                IVasGiftKuiklyManager iVasGiftKuiklyManager = (IVasGiftKuiklyManager) QRoute.api(IVasGiftKuiklyManager.class);
                if (iVasGiftKuiklyManager.ifUseKuikly()) {
                    iVasGiftKuiklyManager.startPlay(str2);
                } else {
                    com.tencent.mobileqq.qzonevip.gift.a aVar = (com.tencent.mobileqq.qzonevip.gift.a) b17.getManager(QQManagerFactory.QZONE_GIFT_MANAGER);
                    QLog.i("VipARPreDownload", 1, "playAnimation vipARConfig not match ARgift or isEnableOpen3D = false");
                    aVar.L(str2);
                }
            }
        } else if ("qungift/openAioDialog".equals(str)) {
            if (QVipGiftProcessor.getConfig().isEnable()) {
                if (GiftPanelControllerWithGiftRepo.F()) {
                    if (BaseActivity.sTopActivity == null) {
                        QLog.e("QQSchemeHandler", 1, "qungift/openAioDialog activity is null");
                        return true;
                    }
                    QLog.e("QQSchemeHandler", 1, "qungift/openAioDialog ChatFragment is null");
                    return true;
                }
                try {
                    GiftJsPlugin.openGiftBrowser(BaseActivity.sTopActivity, new JSONObject(str2).getString("troopUin"));
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        } else {
            if ("qungift/playAnimation".equals(str)) {
                QQAppInterface b18 = b();
                if (b18 != null && (aIOAnimationControlManager = (AIOAnimationControlManager) b18.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER)) != null) {
                    aIOAnimationControlManager.o(str2);
                }
                return true;
            }
            if (str.startsWith("together?")) {
                d(str, str2);
                return true;
            }
            if (str.startsWith("weishi")) {
                c(str, str2);
                return true;
            }
            if ("luckyBag/openBag".equals(str)) {
                try {
                    w13.a aVar2 = w13.a.f444413a;
                    if (aVar2.f()) {
                        BaseActivity baseActivity = BaseActivity.sTopActivity;
                        String a16 = aVar2.a();
                        if (a16.startsWith("https")) {
                            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(baseActivity, a16);
                        } else {
                            ax c16 = bi.c(b(), baseActivity, a16);
                            if (c16 != null) {
                                c16.b();
                            }
                        }
                    } else {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        HashMap hashMap = new HashMap();
                        hashMap.put(PhotoCacheData.OWNER_UIN, jSONObject2.optString("sender"));
                        hashMap.put("group_id", jSONObject2.optString("group_id"));
                        hashMap.put("scene", jSONObject2.optString(VRReportDefine$ReportParam.SCENE_TYPE));
                        hashMap.put("ark_id", jSONObject2.optString("msg_key"));
                        hashMap.put("luck_bag_type", jSONObject2.optString("luck_bag_type"));
                        ((IVasKuiklyLogicApi) QRoute.api(IVasKuiklyLogicApi.class)).openLucky(new KuikLyConfig("LuckyLogicPage", "vas_lucky_bag", "openLuckyBag", hashMap));
                    }
                } catch (JSONException unused) {
                    QLog.e("QQSchemeHandler", 1, "parse error " + str2);
                }
                return true;
            }
            if ("kuikly/preloadRes".equals(str)) {
                try {
                    String optString = new JSONObject(str2).optString("bundle_name");
                    if (!TextUtils.isEmpty(optString)) {
                        QLog.i("QQSchemeHandler", 1, "start preload ark kuikly res:" + optString);
                        ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).preloadKuiklyResByRule(optString, null);
                    }
                    return true;
                } catch (Exception e17) {
                    QLog.e("QQSchemeHandler", 1, "PreloadKuikly exception", e17);
                }
            }
        }
        return false;
    }

    protected QQAppInterface b() {
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    protected void h(String str) {
        String str2;
        String str3;
        ax c16;
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity instanceof BaseActivity) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str4 = null;
                if (jSONObject.has(QCircleSchemeAttr.Polymerize.LAT)) {
                    str2 = jSONObject.getString(QCircleSchemeAttr.Polymerize.LAT);
                } else {
                    str2 = null;
                }
                if (jSONObject.has("lon")) {
                    str4 = jSONObject.getString("lon");
                }
                String str5 = "";
                if (!jSONObject.has("title")) {
                    str3 = "";
                } else {
                    str3 = jSONObject.getString("title");
                }
                if (jSONObject.has("loc")) {
                    str5 = jSONObject.getString("loc");
                }
                if (str2 != null && str4 != null && (c16 = bi.c(b(), baseActivity, String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=%s&lon=%s&title=%s&loc=%s&dpid=null", str2, str4, str3, str5))) != null) {
                    c16.b();
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("ArkApp", 1, "QQ.showQMapView parameter error: " + e16.getMessage());
                }
            }
        }
    }
}
