package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.minigame.config.MiniGameCustomLoadingConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\u0005\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameCustomLoadingConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/minigame/config/MiniGameCustomLoadingConfig;", "()V", "defaultConfig", "parse", "content", "", "", DownloadInfo.spKey_Config, "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameCustomLoadingConfigParser extends BaseConfigParser<MiniGameCustomLoadingConfig> {
    private static final String TAG = "MiniGameCustomLoadingConfigParser";

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public MiniGameCustomLoadingConfig defaultConfig() {
        return new MiniGameCustomLoadingConfig();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    public MiniGameCustomLoadingConfig parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        MiniGameCustomLoadingConfig miniGameCustomLoadingConfig = new MiniGameCustomLoadingConfig();
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            parse(miniGameCustomLoadingConfig, new String(content, UTF_8));
        } else {
            QLog.i(TAG, 1, "parse empty content");
        }
        return miniGameCustomLoadingConfig;
    }

    private final void parse(MiniGameCustomLoadingConfig miniGameCustomLoadingConfig, String str) {
        JSONObject optJSONObject;
        try {
            JSONObject optJSONObject2 = new JSONObject(str).optJSONObject("appList");
            Iterator keys = optJSONObject2.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "appListJson.keys()");
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                if ((key.length() > 0) && (optJSONObject = optJSONObject2.optJSONObject(key)) != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(key)");
                    Map<String, MiniGameCustomLoadingConfig.LoadingBgConfig> bgConfigMap = miniGameCustomLoadingConfig.getBgConfigMap();
                    String optString = optJSONObject.optString("loadingBgUrl");
                    Intrinsics.checkNotNullExpressionValue(optString, "configObject.optString(\"loadingBgUrl\")");
                    String optString2 = optJSONObject.optString("landscapeLoadingBgUrl");
                    Intrinsics.checkNotNullExpressionValue(optString2, "configObject.optString(\"landscapeLoadingBgUrl\")");
                    bgConfigMap.put(key, new MiniGameCustomLoadingConfig.LoadingBgConfig(optString, optString2));
                }
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parse error: " + e16.getMessage());
        }
    }
}
