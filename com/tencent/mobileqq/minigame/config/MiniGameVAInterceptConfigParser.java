package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\u0005\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfig;", "()V", "defaultConfig", "parse", "content", "", "", DownloadInfo.spKey_Config, "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVAInterceptConfigParser extends BaseConfigParser<MiniGameVAInterceptConfig> {
    private static final String TAG = "MiniGameVAInterceptConfigParser";

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public MiniGameVAInterceptConfig defaultConfig() {
        return new MiniGameVAInterceptConfig();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    public MiniGameVAInterceptConfig parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = new MiniGameVAInterceptConfig();
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            parse(miniGameVAInterceptConfig, new String(content, UTF_8));
        } else {
            QLog.i(TAG, 1, "parse empty content");
        }
        ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).initHardwareConfig(miniGameVAInterceptConfig);
        return miniGameVAInterceptConfig;
    }

    private final void parse(MiniGameVAInterceptConfig miniGameVAInterceptConfig, String str) {
        String str2;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        Iterator keys;
        String str3;
        String str4;
        JSONObject jSONObject2;
        Iterator it;
        JSONObject optJSONObject2;
        String str5 = TAG;
        boolean z16 = true;
        try {
            jSONObject = new JSONObject(str);
            miniGameVAInterceptConfig.setAutoDownload(jSONObject.optInt(VirtualAppProxy.KEY_AUTO_DOWNLOAD, -1));
            miniGameVAInterceptConfig.setDownloadTypeOnWifi(jSONObject.optInt(VirtualAppProxy.KEY_DOWNLOAD_TYPE_ON_WIFI, -1));
            miniGameVAInterceptConfig.setGameAppOpenScheme(jSONObject.optString("gameAppOpenScheme"));
            miniGameVAInterceptConfig.setPreLaunchProcess(jSONObject.optBoolean("preLaunchProcess"));
            miniGameVAInterceptConfig.setCheckVADownloadIgnoreGameEvent(jSONObject.optBoolean("checkVADownloadIgnoreGameEvent", true));
            miniGameVAInterceptConfig.setHotfixTimeout(jSONObject.optLong("hotfixTimeout", 0L));
            optJSONObject = jSONObject.optJSONObject("appList");
            keys = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "appListJson.keys()");
        } catch (JSONException e16) {
            e = e16;
            str2 = str5;
        }
        while (true) {
            str3 = "";
            if (!keys.hasNext()) {
                break;
            }
            String key = (String) keys.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            if (!(key.length() > 0 ? z16 : false) || (optJSONObject2 = optJSONObject.optJSONObject(key)) == null) {
                str4 = str5;
                jSONObject2 = optJSONObject;
                it = keys;
            } else {
                Intrinsics.checkNotNullExpressionValue(optJSONObject2, "optJSONObject(key)");
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = optJSONObject2.optJSONArray("viaWhiteList");
                int length = optJSONArray != null ? optJSONArray.length() : 0;
                if (length > 0) {
                    for (int i3 = 0; i3 < length; i3++) {
                        Object obj = optJSONArray != null ? optJSONArray.get(i3) : null;
                        String str6 = obj instanceof String ? (String) obj : null;
                        if (str6 != null) {
                            arrayList.add(str6);
                        }
                    }
                }
                String joinToString$default = arrayList.isEmpty() ? "" : CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
                Map<String, MiniGameVAInterceptConfig.VAInterceptConfig> interceptConfigMap = miniGameVAInterceptConfig.getInterceptConfigMap();
                String optString = optJSONObject2.optString("gameAppId");
                Intrinsics.checkNotNullExpressionValue(optString, "configObject.optString(\"gameAppId\")");
                String optString2 = optJSONObject2.optString("gameAppPkgName");
                Intrinsics.checkNotNullExpressionValue(optString2, "configObject.optString(\"gameAppPkgName\")");
                int optInt = optJSONObject2.optInt("gameAppMinVersionCode");
                String optString3 = optJSONObject2.optString("configId");
                Intrinsics.checkNotNullExpressionValue(optString3, "configObject.optString(\"configId\")");
                String optString4 = optJSONObject2.optString("loadingImage");
                jSONObject2 = optJSONObject;
                Intrinsics.checkNotNullExpressionValue(optString4, "configObject.optString(\"loadingImage\")");
                it = keys;
                boolean optBoolean = optJSONObject2.optBoolean(MiniChatConstants.MINI_APP_LANDSCAPE, false);
                boolean optBoolean2 = optJSONObject2.optBoolean("gameAppOpenSwitch", false);
                String optString5 = optJSONObject2.optString("gameAppLaunchParams");
                Intrinsics.checkNotNullExpressionValue(optString5, "configObject.optString(\"gameAppLaunchParams\")");
                int optInt2 = optJSONObject2.optInt("gameAppLaunchFlags");
                String optString6 = optJSONObject2.optString("gameAppDefaultDeepLink");
                str4 = str5;
                try {
                    Intrinsics.checkNotNullExpressionValue(optString6, "configObject.optString(\"gameAppDefaultDeepLink\")");
                    interceptConfigMap.put(key, new MiniGameVAInterceptConfig.VAInterceptConfig(optString, optString2, optInt, optString3, optString4, key, optBoolean, optBoolean2, optString5, optInt2, optString6, optJSONObject2.optBoolean("isAllJumpApp"), joinToString$default));
                } catch (JSONException e17) {
                    e = e17;
                    str2 = str4;
                }
            }
            optJSONObject = jSONObject2;
            keys = it;
            str5 = str4;
            z16 = true;
            e = e17;
            str2 = str4;
            QLog.e(str2, 1, "parse error: " + e.getMessage());
            return;
        }
        str4 = str5;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("vaSwitchInfo");
        String jSONObject3 = optJSONObject3 != null ? optJSONObject3.toString() : null;
        if (jSONObject3 != null) {
            str3 = jSONObject3;
        }
        miniGameVAInterceptConfig.setVaSwitchInfo(str3);
        miniGameVAInterceptConfig.setAvailableCheckSwitch(jSONObject.optBoolean("availableCheckSwitch"));
        miniGameVAInterceptConfig.setAvailableCheckDefault(jSONObject.optBoolean("availableCheckDefault"));
        miniGameVAInterceptConfig.setDiffPatchMD5CheckEnable(jSONObject.optBoolean("diffPatchMD5CheckEnable"));
        miniGameVAInterceptConfig.setApkDownloadInnerStorageSwitch(jSONObject.optBoolean("apkDownloadInnerStorageSwitch", true));
        miniGameVAInterceptConfig.setAvailableCheckTimeout(jSONObject.optInt("availableCheckTimeout"));
        JSONObject optJSONObject4 = jSONObject.optJSONObject("vaInstallTips");
        if (optJSONObject4 != null && optJSONObject4.has("loadingViewInstallingTips")) {
            String optString7 = optJSONObject4.optString("loadingViewInstallingTips");
            Intrinsics.checkNotNullExpressionValue(optString7, "vaInstallTipsJson.optStr\u2026adingViewInstallingTips\")");
            miniGameVAInterceptConfig.setLoadingViewInstallingTips(optString7);
        }
        if (optJSONObject4 != null && optJSONObject4.has("loadingViewInstalledTips")) {
            String optString8 = optJSONObject4.optString("loadingViewInstalledTips");
            Intrinsics.checkNotNullExpressionValue(optString8, "vaInstallTipsJson.optStr\u2026oadingViewInstalledTips\")");
            miniGameVAInterceptConfig.setLoadingViewInstalledTips(optString8);
        }
        if (optJSONObject4 != null && optJSONObject4.has("restartConfirmDialogContent")) {
            String optString9 = optJSONObject4.optString("restartConfirmDialogContent");
            Intrinsics.checkNotNullExpressionValue(optString9, "vaInstallTipsJson.optStr\u2026artConfirmDialogContent\")");
            miniGameVAInterceptConfig.setRestartConfirmDialogContent(optString9);
        }
        if (optJSONObject4 != null && optJSONObject4.has("restartConfirmDialogPositiveButton")) {
            String optString10 = optJSONObject4.optString("restartConfirmDialogPositiveButton");
            Intrinsics.checkNotNullExpressionValue(optString10, "vaInstallTipsJson.optStr\u2026irmDialogPositiveButton\")");
            miniGameVAInterceptConfig.setRestartConfirmDialogPositiveButton(optString10);
        }
        if (optJSONObject4 != null && optJSONObject4.has("restartConfirmDialogNegativeButton")) {
            String optString11 = optJSONObject4.optString("restartConfirmDialogNegativeButton");
            Intrinsics.checkNotNullExpressionValue(optString11, "vaInstallTipsJson.optStr\u2026irmDialogNegativeButton\")");
            miniGameVAInterceptConfig.setRestartConfirmDialogNegativeButton(optString11);
        }
        if (jSONObject.has("disableVAOnFenShenApp")) {
            miniGameVAInterceptConfig.setDisableVAOnFenShenApp(jSONObject.optBoolean("disableVAOnFenShenApp"));
        }
        if (jSONObject.has("diffPatchDownloadEnable")) {
            miniGameVAInterceptConfig.setDiffPatchDownloadEnable(jSONObject.optBoolean("diffPatchDownloadEnable"));
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("availableCheckStack");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i16 = 0; i16 < length2; i16++) {
                List<String> availableCheckCrashStacks = miniGameVAInterceptConfig.getAvailableCheckCrashStacks();
                String optString12 = optJSONArray2.optString(i16);
                Intrinsics.checkNotNullExpressionValue(optString12, "availableCheckStack.optString(i)");
                availableCheckCrashStacks.add(optString12);
            }
        }
        miniGameVAInterceptConfig.setFastClickMinInterval(jSONObject.optLong("fastClickMinInterval", 1000L));
        str2 = str4;
        try {
            QLog.i(str2, 1, "parse config:" + miniGameVAInterceptConfig);
        } catch (JSONException e18) {
            e = e18;
        }
    }
}
