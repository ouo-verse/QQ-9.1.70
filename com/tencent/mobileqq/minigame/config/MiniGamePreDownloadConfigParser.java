package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.minigame.config.MiniGamePreDownloadConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\u0005\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGamePreDownloadConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/minigame/config/MiniGamePreDownloadConfig;", "()V", "defaultConfig", "parse", "content", "", "", DownloadInfo.spKey_Config, "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGamePreDownloadConfigParser extends BaseConfigParser<MiniGamePreDownloadConfig> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public MiniGamePreDownloadConfig defaultConfig() {
        return new MiniGamePreDownloadConfig();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    public MiniGamePreDownloadConfig parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        MiniGamePreDownloadConfig miniGamePreDownloadConfig = new MiniGamePreDownloadConfig();
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            parse(miniGamePreDownloadConfig, new String(content, UTF_8));
        } else {
            QLog.i(MiniGamePreDownloadConfig.TAG, 1, "parse empty content");
        }
        return miniGamePreDownloadConfig;
    }

    private final void parse(MiniGamePreDownloadConfig miniGamePreDownloadConfig, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            miniGamePreDownloadConfig.setCheckInterval(jSONObject.optLong("checkInterval"));
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadList");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(i)");
                        Map<String, MiniGamePreDownloadConfig.DownloadConfig> preloadMap = miniGamePreDownloadConfig.getPreloadMap();
                        String optString = optJSONObject.optString("appId");
                        Intrinsics.checkNotNullExpressionValue(optString, "preloadObj.optString(\"appId\")");
                        String optString2 = optJSONObject.optString("appId");
                        Intrinsics.checkNotNullExpressionValue(optString2, "preloadObj.optString(\"appId\")");
                        preloadMap.put(optString, new MiniGamePreDownloadConfig.DownloadConfig(optString2));
                    }
                }
            }
            QLog.i(MiniGamePreDownloadConfig.TAG, 1, "parse config:" + str);
        } catch (JSONException e16) {
            QLog.e(MiniGamePreDownloadConfig.TAG, 1, "parse error: " + e16.getMessage());
        }
    }
}
