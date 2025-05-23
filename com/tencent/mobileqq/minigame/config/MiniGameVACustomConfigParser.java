package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.hippy.qq.module.HippyQQHttpModule;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VACustomTextConfig;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\u0005\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameVACustomConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/minigame/config/MiniGameVACustomConfig;", "()V", "defaultConfig", "parse", "content", "", "", DownloadInfo.spKey_Config, "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVACustomConfigParser extends BaseConfigParser<MiniGameVACustomConfig> {
    private static final String TAG = "MiniGameVACustomConfigParser";

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public MiniGameVACustomConfig defaultConfig() {
        return new MiniGameVACustomConfig();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    public MiniGameVACustomConfig parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        MiniGameVACustomConfig miniGameVACustomConfig = new MiniGameVACustomConfig();
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            parse(miniGameVACustomConfig, new String(content, UTF_8));
        } else {
            QLog.i(TAG, 1, "parse empty content");
        }
        return miniGameVACustomConfig;
    }

    private final void parse(MiniGameVACustomConfig miniGameVACustomConfig, String str) {
        ArrayList arrayList;
        try {
            JSONObject jSONObject = new JSONObject(str);
            VACustomTextConfig vACustomTextConfig = new VACustomTextConfig(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 131071, null);
            ArrayList arrayList2 = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("danmakuList");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray.optString(i3);
                    Intrinsics.checkNotNullExpressionValue(optString, "it.optString(i)");
                    arrayList2.add(optString);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("customText");
            if (optJSONObject != null) {
                String optString2 = optJSONObject.optString("retainStopText", vACustomTextConfig.getRetainStopText());
                Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(\"retainStop\u2026extConfig.retainStopText)");
                String optString3 = optJSONObject.optString("retainStopLeftBtnText", vACustomTextConfig.getRetainStopLeftBtnText());
                Intrinsics.checkNotNullExpressionValue(optString3, "it.optString(\"retainStop\u2026ig.retainStopLeftBtnText)");
                String optString4 = optJSONObject.optString("retainStopRightBtnText", vACustomTextConfig.getRetainStopRightBtnText());
                Intrinsics.checkNotNullExpressionValue(optString4, "it.optString(\"retainStop\u2026g.retainStopRightBtnText)");
                String optString5 = optJSONObject.optString("retainCancelText", vACustomTextConfig.getRetainCancelText());
                Intrinsics.checkNotNullExpressionValue(optString5, "it.optString(\"retainCanc\u2026tConfig.retainCancelText)");
                String optString6 = optJSONObject.optString("retainCancelLeftBtnText", vACustomTextConfig.getRetainCancelLeftBtnText());
                Intrinsics.checkNotNullExpressionValue(optString6, "it.optString(\"retainCanc\u2026.retainCancelLeftBtnText)");
                String optString7 = optJSONObject.optString("retainCancelRightBtnText", vACustomTextConfig.getRetainCancelRightBtnText());
                Intrinsics.checkNotNullExpressionValue(optString7, "it.optString(\"retainCanc\u2026retainCancelRightBtnText)");
                String optString8 = optJSONObject.optString("wlanTipsInQueueText", vACustomTextConfig.getWlanTipsInQueueText());
                Intrinsics.checkNotNullExpressionValue(optString8, "it.optString(\"wlanTipsIn\u2026nfig.wlanTipsInQueueText)");
                String optString9 = optJSONObject.optString("wlanTipsInGameText", vACustomTextConfig.getWlanTipsInGameText());
                Intrinsics.checkNotNullExpressionValue(optString9, "it.optString(\"wlanTipsIn\u2026onfig.wlanTipsInGameText)");
                String optString10 = optJSONObject.optString("wifiTipsInQueueText", vACustomTextConfig.getWifiTipsInQueueText());
                Intrinsics.checkNotNullExpressionValue(optString10, "it.optString(\"wifiTipsIn\u2026nfig.wifiTipsInQueueText)");
                String optString11 = optJSONObject.optString("wifiTipsInGameText", vACustomTextConfig.getWifiTipsInGameText());
                Intrinsics.checkNotNullExpressionValue(optString11, "it.optString(\"wifiTipsIn\u2026onfig.wifiTipsInGameText)");
                String optString12 = optJSONObject.optString("tipsBtnText", vACustomTextConfig.getTipsBtnText());
                Intrinsics.checkNotNullExpressionValue(optString12, "it.optString(\"tipsBtnTex\u2026ltTextConfig.tipsBtnText)");
                String optString13 = optJSONObject.optString("foldedTipsText", vACustomTextConfig.getFoldedTipsText());
                Intrinsics.checkNotNullExpressionValue(optString13, "it.optString(\"foldedTips\u2026extConfig.foldedTipsText)");
                arrayList = arrayList2;
                String optString14 = optJSONObject.optString("wlanLoadingInQueueText", vACustomTextConfig.getWlanLoadingInQueueText());
                Intrinsics.checkNotNullExpressionValue(optString14, "it.optString(\"wlanLoadin\u2026g.wlanLoadingInQueueText)");
                String optString15 = optJSONObject.optString("wifiLoadingInQueueText", vACustomTextConfig.getWifiLoadingInQueueText());
                Intrinsics.checkNotNullExpressionValue(optString15, "it.optString(\"wifiLoadin\u2026g.wifiLoadingInQueueText)");
                String optString16 = optJSONObject.optString("wlanLoadingInGameText", vACustomTextConfig.getWlanLoadingInGameText());
                Intrinsics.checkNotNullExpressionValue(optString16, "it.optString(\"wlanLoadin\u2026ig.wlanLoadingInGameText)");
                String optString17 = optJSONObject.optString("wifiLoadingInGameText", vACustomTextConfig.getWifiLoadingInGameText());
                Intrinsics.checkNotNullExpressionValue(optString17, "it.optString(\"wifiLoadin\u2026ig.wifiLoadingInGameText)");
                String optString18 = optJSONObject.optString("loadingLeftBtnText", vACustomTextConfig.getLoadingLeftBtnText());
                Intrinsics.checkNotNullExpressionValue(optString18, "it.optString(\"loadingLef\u2026onfig.loadingLeftBtnText)");
                String optString19 = optJSONObject.optString("loadingRightBtnText", vACustomTextConfig.getLoadingRightBtnText());
                Intrinsics.checkNotNullExpressionValue(optString19, "it.optString(\"loadingRig\u2026nfig.loadingRightBtnText)");
                String optString20 = optJSONObject.optString("wlanStopText", vACustomTextConfig.getWlanStopText());
                Intrinsics.checkNotNullExpressionValue(optString20, "it.optString(\"wlanStopTe\u2026tTextConfig.wlanStopText)");
                String optString21 = optJSONObject.optString("wifiStopText", vACustomTextConfig.getWifiStopText());
                Intrinsics.checkNotNullExpressionValue(optString21, "it.optString(\"wifiStopTe\u2026tTextConfig.wifiStopText)");
                String optString22 = optJSONObject.optString("stopLeftBtnText", vACustomTextConfig.getStopLeftBtnText());
                Intrinsics.checkNotNullExpressionValue(optString22, "it.optString(\"stopLeftBt\u2026xtConfig.stopLeftBtnText)");
                String optString23 = optJSONObject.optString("stopRightBtnText", vACustomTextConfig.getStopRightBtnText());
                Intrinsics.checkNotNullExpressionValue(optString23, "it.optString(\"stopRightB\u2026tConfig.stopRightBtnText)");
                String optString24 = optJSONObject.optString("restartText", vACustomTextConfig.getRestartText());
                Intrinsics.checkNotNullExpressionValue(optString24, "it.optString(\"restartTex\u2026ltTextConfig.restartText)");
                String optString25 = optJSONObject.optString("restartBtnText", vACustomTextConfig.getRestartBtnText());
                Intrinsics.checkNotNullExpressionValue(optString25, "it.optString(\"restartBtn\u2026extConfig.restartBtnText)");
                String optString26 = optJSONObject.optString("autoRestartText", vACustomTextConfig.getAutoRestartText());
                Intrinsics.checkNotNullExpressionValue(optString26, "it.optString(\"autoRestar\u2026xtConfig.autoRestartText)");
                String optString27 = optJSONObject.optString(HippyQQHttpModule.HTPP_ERROR_TEXT, vACustomTextConfig.getErrorText());
                Intrinsics.checkNotNullExpressionValue(optString27, "it.optString(\"errorText\"\u2026aultTextConfig.errorText)");
                String optString28 = optJSONObject.optString("errorBtnText", vACustomTextConfig.getErrorBtnText());
                Intrinsics.checkNotNullExpressionValue(optString28, "it.optString(\"errorBtnTe\u2026tTextConfig.errorBtnText)");
                String optString29 = optJSONObject.optString("authText", vACustomTextConfig.getAuthText());
                Intrinsics.checkNotNullExpressionValue(optString29, "it.optString(\"authText\",\u2026faultTextConfig.authText)");
                String optString30 = optJSONObject.optString("authLeftBtnText", vACustomTextConfig.getAuthLeftBtnText());
                Intrinsics.checkNotNullExpressionValue(optString30, "it.optString(\"authLeftBt\u2026xtConfig.authLeftBtnText)");
                String optString31 = optJSONObject.optString("authRightBtnText", vACustomTextConfig.getAuthRightBtnText());
                Intrinsics.checkNotNullExpressionValue(optString31, "it.optString(\"authRightB\u2026tConfig.authRightBtnText)");
                String optString32 = optJSONObject.optString("yunGameLoadingText", vACustomTextConfig.getYunGameLoadingText());
                Intrinsics.checkNotNullExpressionValue(optString32, "it.optString(\"yunGameLoa\u2026onfig.yunGameLoadingText)");
                String optString33 = optJSONObject.optString("yunGameQueueText", vACustomTextConfig.getYunGameQueueText());
                Intrinsics.checkNotNullExpressionValue(optString33, "it.optString(\"yunGameQue\u2026tConfig.yunGameQueueText)");
                String optString34 = optJSONObject.optString("vaInitText", vACustomTextConfig.getVaInitText());
                Intrinsics.checkNotNullExpressionValue(optString34, "it.optString(\"vaInitText\u2026ultTextConfig.vaInitText)");
                String optString35 = optJSONObject.optString("vaWifiLoadingText", vACustomTextConfig.getVaWifiLoadingText());
                Intrinsics.checkNotNullExpressionValue(optString35, "it.optString(\"vaWifiLoad\u2026Config.vaWifiLoadingText)");
                String optString36 = optJSONObject.optString("vaWlanLoadingText", vACustomTextConfig.getVaWlanLoadingText());
                Intrinsics.checkNotNullExpressionValue(optString36, "it.optString(\"vaWlanLoad\u2026Config.vaWlanLoadingText)");
                String optString37 = optJSONObject.optString("vaWifiStopText", vACustomTextConfig.getVaWifiStopText());
                Intrinsics.checkNotNullExpressionValue(optString37, "it.optString(\"vaWifiStop\u2026extConfig.vaWifiStopText)");
                String optString38 = optJSONObject.optString("vaWlanStopText", vACustomTextConfig.getVaWlanStopText());
                Intrinsics.checkNotNullExpressionValue(optString38, "it.optString(\"vaWlanStop\u2026extConfig.vaWlanStopText)");
                String optString39 = optJSONObject.optString("vaRestartText", vACustomTextConfig.getVaRestartText());
                Intrinsics.checkNotNullExpressionValue(optString39, "it.optString(\"vaRestartT\u2026TextConfig.vaRestartText)");
                String optString40 = optJSONObject.optString("vaRetainStopText", vACustomTextConfig.getVaRetainStopText());
                Intrinsics.checkNotNullExpressionValue(optString40, "it.optString(\"vaRetainSt\u2026tConfig.vaRetainStopText)");
                String optString41 = optJSONObject.optString("vaRetainStopLeftBtnText", vACustomTextConfig.getVaRetainStopLeftBtnText());
                Intrinsics.checkNotNullExpressionValue(optString41, "it.optString(\"vaRetainSt\u2026.vaRetainStopLeftBtnText)");
                String optString42 = optJSONObject.optString("vaRetainStopRightBtnText", vACustomTextConfig.getVaRetainStopRightBtnText());
                Intrinsics.checkNotNullExpressionValue(optString42, "it.optString(\"vaRetainSt\u2026vaRetainStopRightBtnText)");
                String optString43 = optJSONObject.optString("vaRetainCancelText", vACustomTextConfig.getVaRetainCancelText());
                Intrinsics.checkNotNullExpressionValue(optString43, "it.optString(\"vaRetainCa\u2026onfig.vaRetainCancelText)");
                String optString44 = optJSONObject.optString("vaRetainCancelLeftBtnText", vACustomTextConfig.getVaRetainCancelLeftBtnText());
                Intrinsics.checkNotNullExpressionValue(optString44, "it.optString(\"vaRetainCa\u2026aRetainCancelLeftBtnText)");
                String optString45 = optJSONObject.optString("vaRetainCancelRightBtnText", vACustomTextConfig.getVaRetainCancelRightBtnText());
                Intrinsics.checkNotNullExpressionValue(optString45, "it.optString(\"vaRetainCa\u2026RetainCancelRightBtnText)");
                String optString46 = optJSONObject.optString("retainDialogBgUrl", vACustomTextConfig.getRetainDialogBgUrl());
                Intrinsics.checkNotNullExpressionValue(optString46, "it.optString(\"retainDial\u2026Config.retainDialogBgUrl)");
                miniGameVACustomConfig.setCustomTextConfig(new VACustomTextConfig(optString2, optString3, optString4, optString5, optString6, optString7, optString8, optString9, optString10, optString11, optString12, optString13, optString14, optString15, optString16, optString17, optString18, optString19, optString20, optString21, optString22, optString23, optString24, optString25, optString26, optString27, optString28, optString29, optString30, optString31, optString32, optString33, optString34, optString35, optString36, optString37, optString38, optString39, optString40, optString41, optString42, optString43, optString44, optString45, optString46, null, null, null, null, 0, 122880, null));
            } else {
                arrayList = arrayList2;
            }
            miniGameVACustomConfig.getCustomTextConfig().setDefaultDanmakuList(arrayList);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parse error: " + e16.getMessage());
        }
    }
}
