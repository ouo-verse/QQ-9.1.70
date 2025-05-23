package com.tencent.mobileqq.ark.api.impl;

import com.tencent.ark.Constants;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.ark.config.qqmc.ArkExtendConfParser;
import com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr;
import com.tencent.mobileqq.ark.core.ArkMultiProc;
import com.tencent.mobileqq.ark.core.f;
import com.tencent.mobileqq.ark.util.c;
import com.tencent.mobileqq.ark.util.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ArkAppReportController;
import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.PlatformInfor;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkHelperImpl implements IArkHelper {
    private static final String TAG = "ArkApp.ArkHelper";
    private static boolean isTokenObjectChanged = false;
    public static a91.b mArkCallBack;
    private static JSONObject tokenObject;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements ArkAppMgr.IGetAppPathByNameCallback {
        a() {
        }

        @Override // com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback
        public void onGetAppPathByName(int i3, String str, ArkAppMgr.AppPathInfo appPathInfo) {
            if (QLog.isColorLevel()) {
                QLog.d(ArkHelperImpl.TAG, 2, "preDownloadArkApp download complete,retCode: ", Integer.valueOf(i3), ";msg: ", str);
            }
        }
    }

    public static String getCurrentAppConfig() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (SimpleUIUtil.getSimpleUISwitch()) {
                jSONObject2.put("mode", PlatformInfor.SIMPLE_MODE);
            } else {
                jSONObject2.put("mode", "default");
            }
            jSONObject2.put("themeId", ThemeUtil.getCurrentThemeId());
            jSONObject.put("theme", jSONObject2);
            jSONObject.put("token", getTokenObject());
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "Exception=", e16);
        }
        return jSONObject.toString();
    }

    public static JSONObject getTokenObject() {
        if (isTokenObjectChanged || tokenObject == null) {
            tokenObject = new JSONObject(QUIUtil.getCurrentTokenMap());
            isTokenObjectChanged = false;
        }
        return tokenObject;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public String CopyFileToCache(String str, String str2) {
        return c.a(str, str2);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public String arkPathToSysPath(String str, String str2) {
        return c.c(str, str2);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public void cleanAppCache() {
        d.c();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public void cleanAppStorage() {
        d.b();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public void cleanWebCache() {
        d.d();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public Map<String, String> getArkExtendInfo(String str, String str2) {
        return ArkExtendConfParser.e(str, str2);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public Map<String, String> getArkReplyConfig(JSONObject jSONObject) {
        return ((IArkMsgReplyMgr) QRoute.api(IArkMsgReplyMgr.class)).getArkReplyConfig(jSONObject);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public String getArkReplyIcon(JSONObject jSONObject) {
        try {
            if (!isSupportReply(jSONObject.optString("app"), jSONObject.optString("view"), jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC))) {
                return "";
            }
            return ((IArkMsgReplyMgr) QRoute.api(IArkMsgReplyMgr.class)).getReplyConfigFromMsg(jSONObject).get(IArkMsgReplyMgr.kArkMsgReplyIcon);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "Exception", e16);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public String getCacheResPath(String str, String str2) {
        return c.d(str, str2);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public boolean handleArkQuoteOpenUrl(int i3, JSONObject jSONObject) {
        a91.b bVar = mArkCallBack;
        if (bVar != null) {
            return bVar.a(i3, jSONObject);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public boolean isSupportReply(String str, String str2, String str3) {
        return ((IArkMsgReplyMgr) QRoute.api(IArkMsgReplyMgr.class)).canReply(str, str2, str3);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public void onThemeChange() {
        if (!ArkMultiProc.f199300a) {
            return;
        }
        isTokenObjectChanged = true;
        String currentAppConfig = getCurrentAppConfig();
        QLog.d(TAG, 1, "onThemeChanged.appconfig=", currentAppConfig);
        try {
            ark.arkApplicationSetConfig(null, currentAppConfig);
        } catch (UnsatisfiedLinkError e16) {
            QLog.e(TAG, 1, "onThemeChanged.ark so not load.e=", e16);
        }
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public void preDownloadApp(String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "preDownloadArkApp download start,appName: ", str, ",appView=", str2);
        }
        ArkAppMgr.getInstance().getAppPathByName(str, Constants.DEFAULT_MIN_APP_VERSION, str3, new a());
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public void preloadCommon() {
        ArkAppPreDownloadMgr.o();
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public void registerArkCallBack(a91.b bVar) {
        if (bVar != null) {
            mArkCallBack = bVar;
        }
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public void reportEvent(AppRuntime appRuntime, String str, String str2, String str3, long j3, long j16, long j17, long j18, long j19, String str4, String str5) {
        ArkAppReportController.b(appRuntime, str, str2, str3, j3, j16, j17, j18, j19, str4, str5);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public void stopArkSilkAudio() {
        IArkEnvDelegate iArkEnvDelegate = f.f199347e;
        if (iArkEnvDelegate != null) {
            iArkEnvDelegate.stopArkSilkAudio();
        }
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public void unregisterCallBack() {
        mArkCallBack = null;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkHelper
    public String CopyFileToCache(String str, byte[] bArr) {
        return c.b(str, bArr);
    }
}
