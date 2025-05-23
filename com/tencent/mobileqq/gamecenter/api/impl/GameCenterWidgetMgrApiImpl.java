package com.tencent.mobileqq.gamecenter.api.impl;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.appwidget.GameCenterAppWidgetProviderV2;
import com.tencent.mobileqq.gamecenter.data.q;
import com.tencent.mobileqq.gamecenter.logic.WidgetConfigLogicHandler;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$BattlepassWidget;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$NewWidget;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameCenterWidgetMgrApiImpl implements IGameCenterWidgetMgrApi {
    public static final String TAG = "GCWidget.GameCenterWidgetMgrApiImpl";
    private final WidgetConfigLogicHandler mWidgetLogicHandler;

    public GameCenterWidgetMgrApiImpl() {
        QLog.i(TAG, 1, "[GameCenterWidgetMgrApiImpl]");
        this.mWidgetLogicHandler = new WidgetConfigLogicHandler();
    }

    private String decodeJumpUrl(Uri uri) {
        try {
            String queryParameter = uri.getQueryParameter("url_prefix");
            if (TextUtils.isEmpty(queryParameter)) {
                return "";
            }
            return new String(PluginBaseInfoHelper.Base64Helper.decode(queryParameter, 0));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "decodeJumpUrl e:", th5);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportIfNeed$0(String str) {
        com.tencent.mobileqq.gamecenter.data.q widgetCacheData;
        String str2;
        String str3;
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("gcwidget_native_report");
            QLog.i(TAG, 2, "[reportIfNeed] jumpTypeKey:" + queryParameter);
            if (getWidgetCacheData(false) == null) {
                widgetCacheData = new com.tencent.mobileqq.gamecenter.data.q();
            } else {
                widgetCacheData = getWidgetCacheData(false);
            }
            q.i promotionAd = widgetCacheData.getPromotionAd();
            if (promotionAd != null) {
                str2 = promotionAd.getId();
                str3 = promotionAd.getAppid();
            } else {
                str2 = "";
                str3 = "";
            }
            if ("-1".equals(queryParameter)) {
                reportEmptyJump(str2, str3);
                return;
            }
            if ("0".equals(queryParameter)) {
                reportResJump(str2, str3, decodeJumpUrl(parse));
                return;
            }
            if ("1".equals(queryParameter)) {
                reportWelfareJump(widgetCacheData, str2);
                return;
            }
            if ("2".equals(queryParameter)) {
                reportGloudGameJump(widgetCacheData, str2);
            } else if ("3".equals(queryParameter)) {
                reportNoticeMsgJump(widgetCacheData, str2, str3);
            } else if ("4".equals(queryParameter)) {
                reportBattleTaskJump();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    private void reportBattleTaskJump() {
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "1091", "9402", "940201", "929234", "", null);
    }

    private void reportEmptyJump(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext15", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_number", com.tencent.mobileqq.statistics.o.b());
        hashMap.put("ext6", str);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str2, "1", "1091", "9402", "940201", "914729", "", hashMap);
    }

    private void reportGloudGameJump(com.tencent.mobileqq.gamecenter.data.q qVar, String str) {
        String str2;
        q.e cloudGame = qVar.getCloudGame();
        if (cloudGame != null) {
            str2 = cloudGame.getAppid();
        } else {
            str2 = "";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext15", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_number", com.tencent.mobileqq.statistics.o.b());
        hashMap.put("ext6", str);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str2, "1", "1091", "9402", "940201", "914645", "", hashMap);
    }

    private void reportNoticeMsgJump(com.tencent.mobileqq.gamecenter.data.q qVar, String str, String str2) {
        String str3;
        q.h messageNotice = qVar.getMessageNotice();
        if (messageNotice != null) {
            str3 = messageNotice.getId();
        } else {
            str3 = "";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext15", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_number", com.tencent.mobileqq.statistics.o.b());
        hashMap.put("ext2", str3);
        hashMap.put("ext6", str);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str2, "1", "1091", "9402", "940201", "914646", "", hashMap);
    }

    private void reportResJump(String str, String str2, String str3) {
        String urlParameter = GameCenterUtil.getUrlParameter(str3, WinkDaTongReportConstant.ElementParamKey.ADID);
        String urlParameter2 = GameCenterUtil.getUrlParameter(str3, Utils.KEY_BUSINESS_ID);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext15", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_number", com.tencent.mobileqq.statistics.o.b());
        hashMap.put("ext6", str);
        hashMap.put("ext8", urlParameter2);
        hashMap.put("ad_id", "1291");
        hashMap.put("ext2", urlParameter);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str2, "1", "1091", "9402", "940201", "914647", "", hashMap);
    }

    private void reportWelfareJump(com.tencent.mobileqq.gamecenter.data.q qVar, String str) {
        int i3;
        String str2;
        q.g gift = qVar.getGift();
        if (gift != null) {
            String appid = gift.getAppid();
            i3 = gift.getUrlType();
            str2 = appid;
        } else {
            i3 = 0;
            str2 = "";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext15", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_number", com.tencent.mobileqq.statistics.o.b());
        hashMap.put("ext2", i3 + "");
        hashMap.put("ext6", str);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str2, "1", "1091", "9402", "940201", "914644", "", hashMap);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public boolean addWidgetV2() {
        boolean isRequestPinAppWidgetSupported;
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        if (Build.VERSION.SDK_INT >= 26) {
            isRequestPinAppWidgetSupported = AppWidgetManager.getInstance(applicationContext).isRequestPinAppWidgetSupported();
            if (isRequestPinAppWidgetSupported && !hasWidgetV2()) {
                AppWidgetManager.getInstance(applicationContext).requestPinAppWidget(new ComponentName(applicationContext, (Class<?>) GameCenterAppWidgetProviderV2.class), null, null);
                QLog.e(TAG, 1, "[addWidget] success,fetchWidgetConfigFromSvr");
                fetchWidgetConfigFromSvrV2();
                return true;
            }
        }
        QLog.e(TAG, 1, "[addWidget] failed");
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public void clearImgCache() {
        this.mWidgetLogicHandler.g();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public void clearWidgetConfigCacheV2() {
        this.mWidgetLogicHandler.h();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public void downloadAndUpdateUi(String str) {
        this.mWidgetLogicHandler.j(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public void fetchEncryptedUinFromSvrV2() {
        this.mWidgetLogicHandler.m();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public void fetchWidgetConfigFromSvrV2() {
        QLog.i(TAG, 1, "[fetchWidgetConfigFromSvrV2]");
        fetchWidgetConfigFromSvrV2(0);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public String getFileDownloadPath(String str) {
        return this.mWidgetLogicHandler.o(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public com.tencent.mobileqq.gamecenter.data.q getWidgetCacheData(boolean z16) {
        return com.tencent.mobileqq.gamecenter.data.r.d(z16);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public boolean hasWidgetV2() {
        return WidgetConfigLogicHandler.r();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public boolean isPullConfigTimeUpV2() {
        return this.mWidgetLogicHandler.s();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public void onWidgetPushMsgReceived(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.mWidgetLogicHandler.q(new JSONObject(str).optLong("next_pull_time", 0L));
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "[handleWidgetPushMsg] error:", e16);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public void reportIfNeed(final String str) {
        if (!TextUtils.isEmpty(str) && str.contains("gcwidget_native_report")) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.z
                @Override // java.lang.Runnable
                public final void run() {
                    GameCenterWidgetMgrApiImpl.this.lambda$reportIfNeed$0(str);
                }
            }, 64, null, false);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public void startTimer() {
        this.mWidgetLogicHandler.x();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public void updateWidgetConfigV3(int i3, QQWidgetSvr$BattlepassWidget qQWidgetSvr$BattlepassWidget, QQWidgetSvr$NewWidget qQWidgetSvr$NewWidget, long j3) {
        this.mWidgetLogicHandler.z(i3, qQWidgetSvr$BattlepassWidget, qQWidgetSvr$NewWidget, j3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi
    public void fetchWidgetConfigFromSvrV2(int i3) {
        QLog.i(TAG, 1, "[fetchWidgetConfigFromSvrV2]");
        this.mWidgetLogicHandler.v(i3);
    }
}
